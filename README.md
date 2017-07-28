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

### [正则表态式工具类](/base/RegexUtils.java)

* find(String str, String regex) //判断字符串是否符合正则表达式
* isEmail(String email) //判断输入的字符串是否符合Email格式
* isChinese(String value) //判断输入的字符串是否为纯汉字
* isDouble(String value) //判断是否为浮点数,包括double和float
* isInteger(String value) //判断是否为整数

