# Java工具类

## 基本工具类
### [转换工具类](/base/ConvertUtils.java)

* strToInt(String str, int value) //String转换为int
* strToLong(String str, long value) //String转换为long
* strToFloat(String str, float value) //String转换为float
* strToDouble(String str, double value) //String转换为double
* strToDate(String str, Date date) //String转换为日期
* strToDate(String str, String format, Date date) //String转换为指定格式的日期
* dateToStr(Date date, String str) //日期转换为字符串
* dateToStr(Date date, String format, String str) //日期转换为指定格式的字符串
* strToStr(String str, String defalut) //如果字符串为空则使用默认字符串
* dateToSqlDate(Date date) //date 转换为 sqldate
* sqlDateToDate(Date date) //sqldate 转换为 date
* dateToSqlTimestamp(Date date) //date 转换为 timestamp
* qlTimestampToDate(Timestamp date) // timestamp 转换为 date

### [身份证合法性](/base/IdcardValidator.java)

### [金钱处理工具类](/base/MoneyUtils.java)

* number2CNMontry(String numberOfMoney) //人民币转换为大写
* accountantMoney(BigDecimal money) //将人民币转换为会计格式金额(xxxx,xxxx,xxxx.xx),保留两位小数
* getFormatMoney(BigDecimal money,int scale,double divisor) //格式化金额，显示为xxx万元，xxx百万,xxx亿

### [正则表达式工具类](/base/RegexUtils.java)

* find(String str, String regex) //判断字符串是否符合正则表达式
* isEmail(String email) //判断输入的字符串是否符合Email格式
* isChinese(String value) //判断输入的字符串是否为纯汉字
* isDouble(String value) //判断是否为浮点数,包括double和float
* isInteger(String value) //判断是否为整数

### [字符串工具类](/base/StringUtils.java)

* changeToFull(String str) //将半角的符号转换成全角符号
* unicodeEscaped(char ch) //将字符转换为编码为Unicode
* toString(Oject object,String nullStrl) //进行toString操作,若为空,返回默认值
* repeatString(String value,int count) //将字符串重复N次
* repeatChar(char ch, int count) //将某个字符重复N次
* isAllLowerCase(String value) //判断字符串是否全部都为小写
* isAllUpperCase(String value) //判断字符串是否全部大写
* reverse(String value) //反转字符串
* subString(String resourceString,int length) //截取字符串,支持中英文混乱,其中中文当做两位处理
* subHTMLString(String htmlString, int length) //截取HTML字符串,支持过滤html标签
* delHTMLTag(String htmlStr) //过滤html标签,包括script、style、html、空格、回车标签

### [验证帮助工具类](/base/ValidateHelper.java)

* isEmptyArray(T[] array) //判断数组是否为空
* isNotEmptyArray(T[] array) //判断数组是否不为空
* isEmptyString(String string) //判断字符串是否为空
* isNotEmptyString(String string) //判断字符串是否不为空
* isEmptyCollection(Collection collection) //判断集合是否为空
* isNotEmptyCollection(Collection collection) //判断集合是不为空
* isNotEmptyMap(Map map) //判断map集合是否不为空
* isEmptyMap(Map map) //判断map集合是否为空
* isEmpty(Object object) //检验对象是否为空,String中只有空格在对象中也算空

### [Bean与Map转换工具类](/beanConvert/BeanMapConvert.java)

* bean2MapObject(Object object) //Bean转换为Map
* map2Bean(Map map,Object object) //Map转换为Java Bean
