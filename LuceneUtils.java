package me.xueyao.lucene.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 工具类，获取Lucene操作对象
 * @author XueYao
 * @date 2017-11-18
 */
public class LuceneUtils {
    //索引文件存入目录
    private static final String INDEX_DIR = "indexDir";
    //索引文件存放目录对象
    private static Directory directory;
    //分词器对象
    private static Analyzer analyzer;
    //索引写对象，单例
    private static IndexWriter indexWriter;
    //索引读对象
    private static IndexReader indexReader;

    static {
        try {
            //初始化索引文件存放目录对象
            directory = FSDirectory.open(new File(INDEX_DIR));
            //初始化IK分词器
            analyzer = new IKAnalyzer();
            //初始化索引的写配置对象
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST,analyzer);
            //初始化索引的写对象
            indexWriter = new IndexWriter(directory,indexWriterConfig);
            //虚拟机退出时关闭
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    super.run();
                    System.out.println("关闭IndexWriter中...");
                    try {
                        //关闭写对象
                        indexWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("关闭IndexWriter成功...");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取IndexWriter
     * @return IndexWriter对象
     */
    public static IndexWriter getIndexWriter() {
        return indexWriter;
    }

    /**
     * 获取IndexReader，重用一些旧的IndexReader
     * @return IndexReader 对象
     * @throws Exception IOException
     */
    private static IndexReader getIndexReader() throws Exception {
        if (indexReader == null) {
            indexReader = DirectoryReader.open(directory);
        } else {
            /*
            * 如果IndexReader不为空，就使用DirectoryReader打开一个索引更过的IndexReader类
            * 如果改变会返回一个新的reader，没有改变返回null*/
            IndexReader tr = DirectoryReader.openIfChanged((DirectoryReader)indexReader);
            if (null != tr) {
                //此时要记得把旧的索引Reader对象关闭
                indexReader.close();
                indexReader = tr;
            }
        }
        return indexReader;
    }


    /**
     * 获取IndexSearcher
     * @return IndexSearcher对象
     * @throws Exception  异常
     */
    private static IndexSearcher getIndexSearcher() throws Exception {
        return new IndexSearcher(getIndexReader());
    }

    /**
     * 根据查询条件，在控制台打印符合条件的n个结果
     * @param query 查询条件对象
     * @param n 最大显示的结果的条数
     * @throws Exception 异常
     */
    public static void printTopDocsByQuery(Query query, int n) throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();

        TopDocs topDocs = indexSearcher.search(query, n);
        //打印命中的总条数
        System.out.println("本次搜索共：" + topDocs.totalHits + "条数据，最高分：" + topDocs.getMaxScore());
        //获取得分文档对象(ScoreDoc)数组.ScoreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        for (ScoreDoc scoreDoc : scoreDocs) {
            //取出文档编号
            int docId = scoreDoc.doc;
            System.out.println("文档的编号是：" + docId);
            System.out.println("当前文档得分:" + scoreDoc.score);
            //根据编号去找文档
            Document document = indexSearcher.doc(docId);
            //获取文档的所有字段对象
            List<IndexableField> fieldsList = document.getFields();
            for (IndexableField field : fieldsList) {
                System.out.println(field.name() + ":" + field.stringValue());
            }
        }
    }

    /**
     * 根据查询条件，在控制台打印符合条件的n个结果并高亮显示
     * @param query  查询条件对象
     * @param n 最大显示的结果的条数
     * @throws Exception  异常
     */
    public static void printTopDocsByQueryForHighlighter(Query query,int n) throws Exception{
        //=======高亮相关
        Formatter formatter=new SimpleHTMLFormatter("<em>","</em>");
        //得分对象
        Scorer scorer=new QueryScorer(query);
        //准备高亮工具
        Highlighter highlighter=new Highlighter(formatter, scorer);
        //=======搜索相关
        IndexSearcher indexSearcher = getIndexSearcher();
        // 搜索数据,两个参数：查询条件对象要查询的最大结果条数
        // 返回的结果是 按照匹配度排名得分前N名的文档信息（包含查询到的总条数信息、所有符合条件的文档的编号信息）
        TopDocs topDocs = indexSearcher.search(query, n);
        // 打印命中的总条数
        System.out.println("本次搜索共" + topDocs.totalHits + "条数据,最高分："+topDocs.getMaxScore());

        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        //循环
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            System.out.println("=========文档的编号是："+docID);
            // 取出文档得分
            System.out.println("当前文档得分： " + scoreDoc.score);
            // 根据编号去找文档
            //Document document = indexReader.document(docID);//方法1
            Document document = indexSearcher.doc(docID);//方法2
            //获取文档的所有字段对象
            List<IndexableField> fieldList= document.getFields();
            //遍历列表
            for (IndexableField field : fieldList) {
                String highlighterValue = highlighter.getBestFragment(analyzer, field.name(), field.stringValue());

                //打印出所有的字段的名字和值（必须存储了的）
                System.out.println(field.name()+":"+highlighterValue);
            }

        }
    }

    /**
     * 打印搜索结果文档
     * @param topDocs  topDocs对象
     * @param indexSearcher indexSearcher对象
     * @throws Exception 异常
     */
    public static void printTopDocs(TopDocs topDocs,IndexSearcher indexSearcher) throws Exception{
        // 打印命中的总条数
        System.out.println("本次搜索共" + topDocs.totalHits + "条数据,最高分："+topDocs.getMaxScore());

        // 获取得分文档对象（ScoreDoc）数组.SocreDoc中包含：文档的编号、文档的得分
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        //循环
        for (ScoreDoc scoreDoc : scoreDocs) {
            // 取出文档编号
            int docID = scoreDoc.doc;
            System.out.println("=========文档的编号是："+docID);
            // 取出文档得分
            System.out.println("当前文档得分： " + scoreDoc.score);

            // 根据编号去找文档
            //Document document = indexReader.document(docID);//方法1
            Document document = indexSearcher.doc(docID);//方法2
            //获取文档的所有字段对象
            List<IndexableField> fieldList= document.getFields();
            //遍历列表
            for (IndexableField field : fieldList) {
                //打印出所有的字段的名字和值（必须存储了的）
                System.out.println(field.name()+":"+field.stringValue());
            }

        }
    }
}
