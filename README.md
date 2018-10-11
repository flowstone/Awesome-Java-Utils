# Java工具类

## 介绍

   为了工作上能够高效快速开发,利用空闲时间,收集Java常用的工具类,如有错误请提交Issues,提交新的代码,请到Pull requests,谢谢合作.

> 工具类列表如下:   
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

### [身份证合法性](/base/IdcardValidator.java)(最严谨的方式)

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

### [AES加解密](/encrypt/AESUtils.java)

* decrypt(String encryptValue, String key) //AES解密
* encrypt(String value, String key) //AES加密

### [BASE64加解密工具类](/encrypt/Base64Utils.java) 

* encrypt(byte[] data) //BASE64加密
* decrypt(String str) //BASE64解密

### [DES加解密工具类](/encrypt/DESUtils.java)

* encrypt(String data, String key) //DES加密
* decrypt(String cryptData,String key) //DES解密

### [加解密工具类](/encrypt/EncryptAndDecryptUtils.java)

* md5Encrypt(String value) //MD5加密
* shaEncrypt(String value) //SHA加密
* base64Encrypt(String value) //Base64加密
* base64Decrypt(String value) //Base64解密
* desEncrypt(String value,String key) //DES加密
* desDecrypt(String value,String key) //DES解密
* aesEncrypt(String value,String key) //AES加密
* aesDecrypt(String value,String key) //AES解密

### [MD5加密](/encrypt/MD5Utils.java)

* encrypt(String value,String key) //MD5加密 

* Convert-->转换工具类
* Date-->时间工具类
* Response-->常用统一响应类
## 致谢

* 感谢提供工具类的大神们,@chenssy,@xuan

排名不分先后

## 说明
 
 * 此工具类长期更新

 ## 更新说明 

 * 2017-07-28　　项目初立
 * 2017-07-31   更新加密工具类
 * 2017-07-31   重构工具类
 * 2018-10-09   添加转换工具，时间工类
