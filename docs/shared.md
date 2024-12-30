
# Table Contents 目录
- [Table Contents 目录](#table-contents)
- [API Integration API 集成](#api-integration)
    - [1. Purpose 目的](#1-purpose)
    - [2. Background 背景](#2-background)
        - [2.1. Authentication & API Requirements 认证和API要求](#21-authentication-api-requirements)
        - [2.2. Data Format 数据格式](#22-data-format)
        - [2.3. Date and Time 日期时间](#23-date-and-time)
        - [2.4. Generate Signature 生成签名](#24-generate-signature)
        - [2.5. Errors and Exceptions 错误和例外](#25-errors-and-exceptions)
        - [2.6. Getting started 如何开始](#26-getting-started)
    - [3. API Functions API功能](#3-api-functions-api)
        - [3.1.	FA001 – Login 登入](#31-fa001-login)
        - [3.2.	FA002 – Logout 登出](#32-fa002-logout)
        - [3.3. FA003 – LoginV2 登陆V2](#33-fa003-loginv2)
        - [3.4.	FP001 – Create User 创建用户](#34-fp001-create-user)
        - [3.5. FP003 – Get Player 获取用户](#35-fp003-get-player)
        - [3.6. FP004 – Get List Player 获取用户列表](#36-fp004-get-list-player)
        - [3.7. FP007 – Change Status Member 更改用户状态](#37-fp007-change-status-member)
        - [3.8. FR001 – Wagers 投注](#38-fr001-wagers)
        - [3.9. FR002 – All Wagers – 所有投注](#39-fr002-all-wagers)
        - [3.10. FR003 – Win Loss Simple - 简易盈亏](#310-fr003-win-loss-simple)
        - [3.11. FR004 – Get My Bet – 获取我的投注](#311-fr004-get-my-bet)
        - [3.12. FR005 – Wager Feed – 投注资料](#312-fr005-wager-feed)
        - [3.13. FR006 – Announcement 公告](#313-fr006-announcement)
        - [3.14. FR009 – Get Hot Event 获取热门赛事](#314-fr009-get-hot-event)
    - [4. Screens and Workflows 截图和工作流程](#4-screens-and-workflows)
    - [5. Appendix 附录](#5-appendix)
        - [5.1. View 界面](#51-view)
        - [5.2. Game Name 游戏名称](#52-gamename)
    - [6. Code Example](#6-code-example)
    - [7. References](#7-references)
  
# API Integration API 集成

## 1. Purpose  目的 <a name="1-purpose"></a>

The I-White-label 3rd Party integration API allows B2B customers to integrate the sportsbook website into B2B customer’s website. B2B customer’s users will be able to access and place bets in the sportsbook system from B2B customer’s website without requiring the user to register in the sportsbook website.

If you are unsure of which integration method to use, please contact us using 24/7 Customer Support in the Skype Channel.

I-外包合作第三方对接API能使B2B客户将体育对接到B2B客户的网站，B2B客户的用户在不需要在体育平台网站注册用户的情况上能够从B2B客户的网站拜访并在体育博彩系统进行投注。

如您不确定使用哪种集成方式，还请在skype群组联系24/7 客服团队。


## 2. Background 背景 <a name="2-background"></a>

### 2.1. Authentication & API Requirements 认证和API要求  <a name="21-authentication-api-requirements"></a>

1.	To be able to call the API, the B2B customer must provide IP addresses to be whitelisted. 为了能够呼唤API, B2B客户需要提供IP供AP Gaming技术团队列入白名单。
2.	All API functional calls must have authentication passed in the HTTP Header: 所有的功能调用API都通过HTTP Header中的认证:
    - token: `<token>`
    - userCode: `<agent code>`
3.	Three important items make up the authentication signature. See  section 2.4 for details on signature generation 认证签名由三个重要项目组成。 有关签名生成的详细信息，请参阅第 2.4 节:
    - Agent code (`agentCode`) 
    - Agent key (`agentKey`) 
    - Secret key (`secretKey`)

### 2.2. Data Format 数据格式 <a name="22-data-format"></a>

The API only supports JSON format. API 只支持JSON格式

#### 2.2.1. Truncated Currencies 截短的货币

**Note: List of truncated currencies (x1000)** <br/>
**注：被截断的货币清单（X1000）**

1. Vietnam Dong (VND) 越南盾 (VND)
2. Indonesian Rupiahs (IDR) 印尼盾 (IDR)
3. Cambodia Riel (KHR) 柬埔寨瑞尔 (KHR)
4. Lao KIP (LAK) 老挝基普 (LAK)
5. Myanmar Krat (MMK) 缅甸克拉特 (MMK)
6. Malagasy ariary (MGA) 马达加斯加阿里亚里 (MGA)
7. Ugandan Shilling (UGX) 乌干达先令 (UGX)
8. Iranian Rial (IRR) 伊朗里亚尔 (IRR)

Example: 100 IDR in system mean 100,000 IDR <br/>
例如：100 IDR在系统中实际价值为 100,000 IDR 

#### 2.2.2. Common Data Types 常见数据类型

| Parameter <br/> 参数 | Description 描述 | E.g. Type Value <br/> 例如：类型值 |
| ---  | ---  | ---   |
| `Boolean`  | Represents a Boolean logic value. 表示Boolean Logic值。 | `true` / `false` |
| `Date`  | All dates and times are GMT-4.  Using for following format: yyyy-MM-ddTHH:mm:ss.  所有的日期和时间都是使用GMT-4市区。格式为yyyy-MM-ddTHH:mm:ss.  | 2018-12-20T04:05:06 |
| `Money`  | All monetary amounts are to 2 decimal places or 0 decimal places.  所有金额都为两位小数点或0位小数点 | 12.05 / 10 |
| `String`  | String value 字符串值 | Message |
| `Long`  | Long value Long 类型值 | 1549009111 |
| `Integer`  | Integer value 整型值 | 113 |
| `Decimal`  | Decimal value. There is a 2-digit decimal number. 小数值，小数点后将有两位数字 | 1.09 |

### 2.3. Date and Time 日期时间 <a name="23-date-and-time"></a>

All dates will be in GMT-4 except `Timestamp`. 除时间戳Timestamp以外，所有日期均为GMT-4.

Date format: yyyy-MM-dd 日期格式：年-月-日

Date Time format: yyyy-MM-dd HH:mm:ss. For example: 2017-04-01 07:00:00

日期时间格式：年-月-日 小时：分钟：秒钟。 例如： 2017-04-01 07:00:00

`Timestamp` (only used for token generation): A UNIX timestamp, also known as Epoch Time or POSIX timestamp, is a representation of a moment defined as the time that has elapsed since a reference known as the UNIX epoch: 1970-01-01 00:00:00 UTC. Using Java as an example, `System.currentTimeMillis()` returns just that, a UNIX timestamp in milliseconds.

时间戳（仅用于产生令牌）：UNIX时间戳，也称为“Epoch Time”或POSIX时间戳，定义为UNIX epoch是一个时间的表示已经过去的时间：1970-01-01 00:00:00 UTC（什么是UTC）。以Java为例，System.currentTimeMillis()返回一个UNIX时间戳（毫秒）。

Please use this code to get a timestamp in java: `long timestamp = System.currentTimeMillis();`

请用这个令牌在java获取时间戳: `long timestamp = System.currentTimeMillis();`

For example: `1493366020081` 例如：`1493366020081`

### 2.4. Generate Signature 生成签名 <a name="24-generate-signature"></a>

A token is generated from 3 properties: `agent_code`, `agent_key`, `timestamp`, `secret_key`

一个代码会从三个属性里产生，即`agent_code`, `agent_key`, `timestamp`, `secret_key`

```java
hashToken = DigestUtils.md5Hex(agent_code + timestamp + agent_key); 
tokenPayload = agent_code + "|" + timestamp + "|" + hashToken
signature = encryptAES(tokenPayload, secret_key)
```

The signature is built based on agent_code, agent_key and secrect_key. They are provided when we receive a request to switch from transfer to seamless wallet type.

签名是基于agent_code, agent_key以及 secret_key建立。它们会在我们收到从转账钱包转至单一钱包的申请的时候提供。

We use an **AES** algorithm to encrypt and decrypt string values from the signature based on the `secret_key`. The operator must decrypt it to verify when they call the B2B Seamless wallet.

我们使用AES的算法从基于`secret_key` 的签名里加密和解密字串值。当我们调取B2B单一钱包时，运营商需要解密字符串以核实。

#### 2.4.1. Java Code Example/ Java代码示例

We use Java programming language to create example code in generating a signature. A signature token is used as authentication between the Betting Platform and the Operator.

我们使用Java编程语言创建一个示例代码来生成签名。一个签名代码在投注平台和运营商之间被用作为一个签名认证。

```java
private static final String ALGORITHM = "AES";
private static final String INIT_VECTOR = "RandomInitVector";

/**
 * Encode to generate signature that be used when send a request.
 * 
 * @param timestamp - current timestamp send request
 * @param agentCode - agentCode will be provided
 * @param agentKey - agentKey will be provided
 * @return String encoded to use for request
 */
public String encode(String timestamp, String agentCode, String agentKey, String aesKey) {
    String hashToken = DigestUtils.md5Hex(agentCode + timestamp + agentKey);
    String tokenPayload = String.format("%s|%s|%s", agentCode, timestamp, hashToken);
    return encryptAES(tokenPayload, aesKey);
}

/**
 * Decode string to verify signature in request.
 *
 * @param token - string value of singature.
 * @param aesKey - it is `secret_key` that will provided from platform.
 * @return Signature
 */
public static Signature decode(String token, String aesKey) {
    String tokenPayload = decryptAES(token, aesKey);
    String[] tmp = tokenPayload.split("\\|");
    Signature signature = new Signature(tmp[0], tmp[2], aesKey);
    signature.setTimestamp(tmp[1]);
    return signature;
}


/**
 * Use secrect_key to encrypt `tokenPayload` by AES algorithms.
 * 
 * @param tokenPayload - it is String that generate follow format in document.
 * @param aesKey - secrect_key be provide by platform.
 * @return String | NULL. 
 */
public String encryptAES(String tokenPayload, String aesKey) {
    try {
        SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey.getBytes(), ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
        byte[] encrypted = cipher.doFinal(tokenPayload.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException |
            InvalidKeyException | NoSuchAlgorithmException | BadPaddingException |
            IllegalBlockSizeException | NoSuchPaddingException ex) {
        LOGGER.log(Level.SEVERE, ex, () -> String.format("An exceptionn occurred "
                + "when encript key: %s, plain text: %s, exception %s", aesKey,              tokenPayload, ex));
    }
    return null;
}

/**
 * Descrypt String by secret_key base on ASE algorithm.
 *
 * @param encryptedText - String is return from {#link encryptAES()}
 * @param aesKey - secrect_key be provide by platform.
 * @return String | NULL.
 */
public static String decryptAES(String encryptedText, String aesKey) {
    try {
        SecretKeySpec secretKeySpec = new SecretKeySpec(aesKey.getBytes(), ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(original);
    } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException |
                NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
        LOGGER.log(Level.INFO,
                "An exceptionn occurred when decrypt key: {0}, encryptedText: "
                + "{1}, exception {2}", new Object[]{aesKey, encryptedText, ex.toString()});

    }
    return null;
}
```

### 2.5. Errors and Exceptions 错误和例外 <a name="25-errors-and-exceptions"></a>

Error response with known error. 已知错误的错误响应

```js
{  
    code: '108',  
    message: 'Agent invalid. Please contact partner to get agent code.'  
} 
```

Please see details in the Error Table. 请在错误表格中参看详细信息

Unexpected exception error format includes a “trace”. The customer can send the trace_code to the IT Support Team for assistance. 意外的异常错误格式只会包含 “追踪 trace”代码. 客户可以发送追踪代码trace_code给技术服务团队申请协助。

```js
{  
    trace: 'CO1AP1|VDyxg0Jj0KuYZpnrG7kEjYaVZDfieeDTa4Fhb+v1ZHjWoKY4a2t2PJNOX/A88\
        +vLLl2fD0ep1hK6cwmj0z0fEA==|28642330553954',  
} 
```

### 2.6. Getting started 如何开始 <a name="26-getting-started"></a>

**Step 1 – Sign up** 步骤1 – 注册

To get started you need to create an account and get agent code via Partner Service BO Site. 开始前，您需要创建一个帐户，并通过后台获取agent code。

**Step 2 – Receive agent key** 步骤2 – 获得agentKey

You need to send the agentCode (created in step 1) to our 24/7 Customer Support in the Skype Channel to get an agentKey and secretKey. 您需要将agentCode（步骤1创建）发给我24/7 Skype上的技術客服来获取agentKey 和secretKey

Please note that for your request to access the API, the IP address must in our whitelist. 请注意：IP 需要先列入白名单，您才能够申请访问

**Step 3 – Generate signature (refer to 2.4)** 步骤 3 – 生成签名（参见 2.4）

**Step 4 – Call API service** 步骤4 – 呼唤API服务

For each service call, you must pass token verification and the appropriate parameters. 对每个服务呼唤，您需要通过令牌验证以及的合适的参数

## 3. API Functions API功能 <a name="3-api-functions-api"></a>

### 3.1. FA001 – Login 登入 <a name="31-fa001-login"></a>

This service is used to generate a URL without the player needing to login. 这个服务是让用户无需登录也能产生URL

Endpoint 端点

| Name <br/>名称 | Value 设置值 | Description 描述 |
| --- | --- | --- |
| URL  | `/player/login`  |   |
| Method  | `GET`/`POST`  | For POST method, it is recommended to send parameters as an JSON object in the request body 对于 POST 方法，建议在请求正文中以 JSON 对象的形式发送参数。 |

| Name <br/>名称 | Value 设置值 | Validation 验证 | Description 描述 |
| --- | --- | --- | --- |
| `userCode`  | String <br/>(required 必需项) | | This is the agent code obtained in step 2. E.g: CO1AP1 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | String<br/>(required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 | |

**Parameters 参数**

| Name <br/>名称 | Value <br/>设置值 | Validation 验证 | Description 描述 |
| --- | --- | --- | --- |
| `userCode` | String<br/>(required 必需项) | | This is the user code / loginID of the player. E.g: *PA10000000* 此为玩家登录名/用户名，例如*PA10000000* |
| `locale` | String <br/>(optional 非必需项) | Supported locales based on brand’s available languages. 支持的语言是基于品牌可用的语言 | See Locale (Language) in the Data-format. 详见数据格式中的区域代码（语言）。|
| `oddsFormat` | String <br/>(optional 非必需项) | A list of supported oddsFormats is available in the Data-format. 支持的数据格式列表请参阅 oddsFormats数据格式。 | See Odds Format in the Data-format. 详见数据格式中的赔率格式。|
| `desktopView` | Boolean <br/>(optional 非必需项) | `true`/`false` *(Default: false)*  Only applicable to Asian view  仅限用于亚洲界面 | If true then desktop view be used when their players use mobile device Otherwise, the appropriate view will be displayed based on the device (desktop or mobile). 当设置值为true，　用户将会在移动端使用电脑版界面，否则界面会根据使用的设备（电脑端或者移动端）决定 |
| `view` | String <br/>(optional 非必需项) | Default: COMPACT 默认：COMPACT（新亚洲界面） | Once the parameter is set, this view would be the default view in the iFrame. 该参数可设置并更改默认界面 |

*Format URL login URL登录格式*

```
<host>/member/<locale>/sports?oddsFormat=HK&token=<token>
```

Example 例如：
http://whitelabelapidomain.com/member/en/sports?oddsFormat=HK&token=TkIxS3pJc2RwdituRmNXam1NVGk0ZlhsZ0lrV285Y2JncFAvVXN2V2dsNVAvNHdXejFadHQ1UTZoeFB6c201cXQ4dXc5NC8vL0pvNHhDQUN4bng0T2c9PQ==

*Note: This token is generated by the AP Gaming system to allow users to log in to our system. This is not a token generated by a third party. 注意 : 这个 令牌 是由 AP Gaming 系统产生让 用 户 登入我 们的系统。这个不是第三方产生的 令牌*

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
private static void getTokenLogin() throws IOException {  
    Map params = new HashMap(); 
    params.put("userCode", "PA10000000"); 
    params.put("locale", "zh-cn"); 
    params.put("oddsFormat", "HK");
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth/jbR/qgUcpi2wHc62Tw==");  
      
    String url = "http://apidomain.com/b2b/player/login";  
    String result = HttpUtils.post(url, "", params, headers);  
    System.out.println(result);  
}  
```

*Sample code (C#)  示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace Login  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("userCode", "QAT0101.05");  
            parameters.Add("locale", "zh-cn");  
            parameters.Add("oddsFormat", "HK");  
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","QAT0101");  
            headers.Add("token","LrSnxY89VuOx05LD6goEQ5fcnWzKT36mwhdJ73A86WJO66wzGmJN9YGDgR8Ac9qLWCTmpaOtZUgv2\
                r714TiZGQ==");  
  
            Console.WriteLine(HttpUtils.PostRequest("https://api.apgaming.co/b2b/player/login",\
                 parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  

    class HttpUtils  {  
        public async static Task<string> PostRequest(String url, Dictionary<string, string> 
            parameters, Dictionary<string, string> headers)  {  
            HttpClient client = new HttpClient();  
            foreach(var item in headers) {   
                client.DefaultRequestHeaders.Add(item.Key, item.Value);  
            }  
              
            var content = new FormUrlEncodedContent(parameters);  
            var response = await client.PostAsync(url + "?" + content.ReadAsStringAsync().Result, null);  
            return await response.Content.R     eadAsStringAsync();  
        }  

        public async static Task<string> GetRequest(String url, Dictionary<string, string> 
            parameters, Dictionary<string, string> headers)    {    
            HttpClient client = new HttpClient();    
            foreach(var item in headers){ client.DefaultRequestHeaders.Add(item.Key, item.Value);}    
              
            var content = new FormUrlEncodedContent(parameters);    
            var response = await client.GetAsync(url + "?" + content.ReadAsStringAsync().Result);    
            return await response.Content.ReadAsStringAsync();    
        }  
    }  
}  
```

*Response 反应*

The result is a URL to the login System. We use this URL to open a new popup in the browser. This URL will auto login to the system. 结果是登录系统的URL。然后我们使用这个URL在浏览器中打开新的弹出窗口。这个网址会自动登录系统。

```js
{   
    loginUrl: 'http://whitelabelapidomain.com/member/en?oddsFormat=HK&token=xyz',   
    userCode: 'PA10000000', 
    loginId: 'PA1000',                 
    token: 'thisislogintokengeneratetologin',        
    updatedDate: 1459312108353                   
}
```

*Extension扩充*

In Mobile version we support the “Back” icon ![Workflow](./../res/back-icon.png) to redirect to a [custom URL]. The [custom URL] is the URL that you provide in the “externalUrl” parameter to the Login link response. 在移动版，我们有“返回”的图标 重定向[定制 URL]. 这里的[定制 URL]是你多加的“externalURL”参数给登陆链接回应。

For example: 
http://whitelabelapidomain.com/en/sports?token=eGRDMFRQZDZQYlhIelBFdXZ2UVN5Nm9MNHlkNThVc0JiRm5SN2hMcVE3dEhHZm00ZnFDbmVMYzB5OTVFYW1NV0NZN0F2c0tqZXFjSU9EdjJhN0tiWXc9PQ==&externalUrl=http://google.com

When the player clicks on the “Back” icon ![Workflow](./../res/back-icon.png), the app will redirect to google.com. 当你点击“返回”图标，应用程序将发送重定向到google.com页面

*Note: This feature is only available on the Mobile version 注意：此功能只有在移动版本上有*

### 3.2. FA002 – Logout 登出 <a name="32-fa002-logout"></a>

If you need to logout from system by userCode. You must call this function. 如果你需要通过userCode登出系统。你需要调用这个函数。

**Endpoint 端点**

| Name 名称 | Value 设置值 | Description 描述 |
| --- | --- | --- |
| URL | `/player/logout` | |
| Method | `GET`/`POST` | For POST method, it is recommended to send parameters as a JSON object in the request body. |

**Parameters 参数**

| Name <br/>名称 | Type <br/>类型 | Value 设置值 | Validation 验证 | Description 描述 |
| --- | --- | --- | --- | --- |
| `userCode` | Header | String <br/>(required 必需项) | | This is the agent code obtained in step 2. E.g: CO1AP1. 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String <br/>(optional 非必需项) | Token is available for 15 minutes after creation.  令牌在创建之后的15分钟内有效 | |
| `userCode` | Query | String <br/>(required 必需项) | | This is the user code / loginID of the player. E.g: `PA10000000` 此为玩家登录名/用户名，例如`PA10000000` |

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*	

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
private static void doLogout() throws IOException {  
    Map params = new HashMap();  
    params.put("userCode", "PA10000000");  
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth/\
        jbR/qgUcpi2wHc62Tw==");
    String url = "http://apidomain.com/b2b/player/logout";  
    String result = HttpUtils.post(url, "", params, headers);  
    System.out.println(result);  
}
```

*Sample code (C#)  示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace Logout  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("userCode", "PA10000000");  
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0+efzoMCb3i\
                +PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.PostRequest("http://apidomain.com/b2b/player/logout", 
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
} 
```

*Response反应*

```js
{  
    "status": "successful"  
}  
```

### 3.3. FA003 – LoginV2 登陆V2 <a name="33-fa003-loginv2"></a>

This service is used to create a new user and generate a URL that will allow the player to access the website without needing to login. This service is different from FA001 in that if the player does not exist in the system, a new user will be created.

这项服务是用以创建新用户并通过产生一个URL允许用户无需登录也能访问网站。 这个服务跟FA001不同的是如果用户在系统里不存在，将会创建新用户

**Endpoint 端点**

| Name <br/>名称 | Value 设置值 | Description 描述 |
| --- | --- | --- |
| URL | `/player/loginV2 ` | |
| Method | `GET`/`POST` | For POST method, it is recommended to send parameters as a JSON object in the request body. 对于 POST 方法，建议在请求正文中以 JSON 对象的形式发送参数。|

**Parameters 参数**

| Name <br/>名称 | Type <br/>类型 | Value <br/>设置值 | Validation 验证 | Description 描述 |
| --- | --- | --- | --- | --- |
| `userCode` | Header | String <br/>(required 必需项) | | This is the agent code obtained in step 2. E.g: CO1AP1. 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String<br/> (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 | |
| `loginId`  | Query | String <br/>(required 必需项)  | If loginId does not exist in the system, it will validate and create a new player based on this loginId.<br/>如果系统中不存在此loginId，则会根据该loginId进行验证并创建新的用户。<br/>Validation Rule for loginId: Must be between 6 and 50 alphanumeric characters.<br/>LoginId 的验证规则：必须介于 6 到 50 个字母数字字符之间。| This is the user code / loginID of the player. 此为玩家登录名/用户名，例如 |
| `locale` | Query | String <br/>(optional 非必需项) | Supported locales based on brand’s available languages. 支持的语言是基于品牌可用的语言。| See Locale (Language) in the Data-format. 详见数据格式中的区域代码（语言）。|
| `sport` | Query | String <br/>(optional 非必需项) | A list of supported sports is available in the Data-format.<br/>**Notes:**<br/>If you only want to show only e-sports in the iFrame, you must contact us to enable the setting and the sport parameter must be "e-sports".<br/>若您想在iframe中只显示电子竞技，需与我们联系以启用设置，并且需将sport参数设置为”e-sports” | See Sport in the Data-format. 详见数据格式中的体育项目。|
| `oddsFormat` | Query | String<br/>(optional 非必需项) | A list of supported odds formats is available in the Data-format. | See Odds Format in the Data-format. 详见数据格式中的赔率格式。|
| `desktopView` | Query | Boolean<br/>(optional 非必需项) | `true`/`false` *(Default: false) 默认：false*   Only applicable to Asian view  仅限用于亚洲界面 | If true, then desktop view will be used when the players use a mobile device. Otherwise, the appropriate view will be displayed based on the device (desktop or mobile). |
| `view` | Query | String<br/>(optional 非必需项) | Default: COMPACT 默认：COMPACT | See View in the Data-format. <br/>Once the parameter is set, the view will be the default view in the iFrame. 该参数可设置并更改默认界面 |
| `eventId` | Query | Number<br/>(optional 非必需项) | Event ID can be obtained by the Get Hot Event API. event Id 可以通过热门赛事 API获取。 | Players will be redirected to the corresponding event page. 玩家将被定向到相对应的赛事页面。 |
| `parentUrl` | Query | String <br/>(optional 非必需项) | Client's domain which will be used for live streaming in all views. 客户的域名将在所有介面中用于直播 | This parameter is supported in all views. 该参数支持所有界面。 |
| `gameName` | Query | String <br/>(optional 非必需项) | | See Game Name in the Data-format.<br/>This parameter is only supported for Esports-Hub 该参数仅支持在Esports-Hub |
| `leagueId` | Query | Number<br/>(optional 非必需项) | League ID can be obtained by the Get Hot Event API. league Id 可以通过热门赛事 API获取。 | Players will be redirected to the corresponding League page. 玩家将被定向到相对应的联赛页面。 |
| `mode` | Query | String <br/>(optional 非必需项) | `LIGHT`/`DARK` *(Default: LIGHT)* The mode to be displayed by default. 默认显示的模式。 | Only applicable to new visitors. Existing user preferences will supersede this setting. 仅适用于新用户。 现有用户的偏好选项将取代此设置。|

*Workflow工作流程*
To be added 以后添加

*Format URL login URL登陆格式*

```
<host>/member-service/v1/login-token?locale=<en>&sport=<sport>&oddsFormat=<oddsFormat>&token=<token>
```

Example 例如: http://whitelabelapidomain.com/member-service/v1/login-token?locale=en&sport=soccer&oddsFormat=HK&token=YkZXSFl5S0VsUElrQzRlRS9ZRERsbDN3dktnb2dnSE1tcTZ1VTEvVnFldTJkVTcyWklJeVVRSk1xY3dpM2VWVXFYY3IxMzRpWGNBWllsakV2Wk1JZ0E9PQ==

*Note: This token is generated by the AP Gaming system to allow users to log in to our system. This is not a token generated by a third party.*

*注意 : 这个 令牌 是由 AP Gaming 系统产生让 用 户 登入我 们的系统。这个不是第三方产生的 令牌。*

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
private static void getTokenLogin() throws IOException {  
    Map params = new HashMap();  
    params.put("loginId", "PA1002"); 
    params.put("locale", "zh-cn"); 
    params.put("sport", "tennis"); 
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepa\
        XQivCIVpsDlth/jbR/qgUcpi2wHc62Tw==");  
    String url = "http://apidomain.com/b2b/player/loginV2";  
    String result = HttpUtils.post(url, "", params, headers);  
    System.out.println(result);  
}  
```

*Sample code (C#)  示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace LoginV2  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("loginId", "PA1002");   
            parameters.Add("locale", "zh-cn");   
            parameters.Add("sport", "tennis");   
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0+efzoMCb3i\
                +PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.PostRequest("http://apidomain.com/b2b/player/loginV2", 
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

*Response 反应*

The result is a URL to login to the System. We use this URL to open a new popup in the browser. This URL will auto login to the AP Gaming system.

然后我们用这个URL在浏览器中打开新的弹出视窗。

```js
{   
  loginUrl: 'http://whitelabelapidomain.com/member-service/v1/login-token\
        ?locale=zh-cn&sport=tennis&token=YkZXSFl5S0VsUElrQzRlRS9ZRERsbDN3dktnb2dnSE1tcTZ1VTEvVnFldTJkV\
        TcyWklJeVVRSk1xY3dpM2VWVXFYY3IxMzRpWGNBWllsakV2Wk1JZ0E9PQ==,   
  userCode: 'PA10000001', 
  loginId: 'PA1002',                 
  token: 'YkZXSFl5S0VsUElrQzRlRS9ZRERsbDN3dktnb2dnSE1tcTZ1VTEvVnFldTJkVTcyWklJeVVRSk1xY3d\
    pM2VWVXFYY3IxMzRpWGNBWllsakV2Wk1JZ0E9PQ==',        
  updatedDate: '2017-05-26 05:37:16'                   
}   
```
_Usage Limits 使用限制_

Usage is limited to a maximum of 20 requests per 5 seconds.

最大使用限制为每 5 秒20 个请求。

*Extension 扩充*

In Mobile version we support the “Back” icon ![Workflow](./../res/back-icon.png) to redirect to a [custom URL]. The [custom URL] is the URL that you provide in the “externalUrl” parameter to the Login link response. <br/>在移动版，我们有“返回”的图标 重定向[定制 URL]. 这里的[定制 URL]是你多加的“externalURL”参数给登陆链接回应。

For example 例如:

http://whitelabelapidomain.com/member-service/v1/login-token?locale=en&token=eGRDMFRQZDZQYlhIelBFdXZ2UVN5NmZNWXE4RFlnUm1vS1pFeVFnVFV4MEpWYkZ5SlczM0ZmZTlFNUhlTytRYTdXeUNmUTN2ak5iVXpQbTNLVWpCUkE9PQ==&externalUrl=http://google.com

When the player clicks on the “Back” icon ![Workflow](./../res/back-icon.png), the app will redirect to google.com.

当你点击“返回”图标，应用程序将发送重定向到google.com页面

*Note: This feature is only available on the Mobile version 注意：此功能只有在移动版本上有*

### 3.4. FP001 – Create User 创建用户 <a name="34-fp001-create-user"></a>

This service is used to sign up a player.

这个服务是用来注册用户

**Endpoint 端点**

| Name 名称 | Value 设置值 | Description  描述 |
| --- | --- | --- |
| URL | `/player/create` | |
| Method | `GET`/`POST` | For POST method, it is recommended to send parameters as a JSON object in the request body. <br/>对于 POST 方法，建议在请求正文中以 JSON 对象的形式发送参数。|

**Parameters 参数**

| Name <br/>名称 | Type <br/>类型 | Value <br/>设置值 | Validation 验证 | Description 描述 |
| --- | --- | --- | --- | --- |
| `userCode` | Header | String<br/> (required 必需项)  |  | This is the agent code obtained in step 2. E.g: `CO1AP1`. 此为在第二步骤获取的代理编号，例如，`CO1AP1` |
| `token` | Header | String (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `agentCode` | Query | String<br/>  (optional 非必需项) |  | The downline agent code that the newly-created player will belong to. If no agent code is provided, the player will be created direct under agent code calling the API. E.g: `CO1AP100` 新建玩家账户所属的代理编号。如果没有提供代理编号，那么玩家用户会直接创建在调用此API的代理账户之下，例如：`CO1AP100` |
| `loginId` | Query | String<br/> (optional 非必需项) | If entered, the system will validate the loginId and respond with an error if it already exists in the system. <br/>输入用户名后，系统会创建用户，若用户名已存在则返回错误 | Validation Rule for loginId: Must be between 6 and 50 alphanumeric characters. <br/>LoginId 的验证规则：必须介于 6 到 50 个字母数字字符之间。|

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（HttpU– 请参阅附录里的 HttpUtils class*

```java
private static void createNewUser() throws IOException {  
    Map params = new HashMap();  
//      params.put("agentCode", "CO1AP100");   //optional parameter  
//      params.put("loginId", "PA10000001");   //optional parameter  
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXH\
        qK9FCFO1n6oepaXQivCIVpsDlth/jbR/qgUcpi2wHc62Tw==");  
      
    String url = "http://apidomain.com/b2b/player/create";  
    String result = HttpUtils.post(url, "", params, headers);  
    System.out.println(result);  
}  
```

*Sample code (C#)  示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace CreateUser  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
             
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQOb\
                ZEn0+efzoMCb3i+PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.PostRequest("http://apidomain.com/b2b/player/create", 
                    parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

*Response 反应*

```js
{   
  userCode: 'PA10000000',    // String userCode  
  loginId: 'PA1000',    
}   
```
_Usage Limits 使用限制_

Usage is limited to a maximum of 10 requests per 5 seconds.

最大使用限制为每 5 秒10 个请求。

### 3.5. FP003 – Get Player 获取用户 <a name="35-fp003-get-player"></a>

This service returns player information.

获取用户资料

| Name 名称 | Value 设置值 | Description 描述 |
| --- | --- | --- |
| URL | `/player/info` | |
| Method | `GET` | |

**Parameters 参数**

| Name  <br/>名称 | Type <br/>类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String  (required 必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `userCode` | Query | String (required 必需项)  |  | This is the user code / loginID of the player. E.g: PA10000000 此为玩家登录名/用户名，例如PA10000000 |
|  |

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void getPlayer() throws IOException {  
    Map params = new HashMap();  
    params.put("userCode", "PA10000000");  
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth/jbR\
        /qgUcpi2wHc62Tw==");  
        
    String url = "http://apidomain.com/b2b/player/info";  
    String result = HttpUtils.get(url, "", params, headers);  
    System.out.println(result);  
}
```

*Sample code (C#)  示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace GetPlayer  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("userCode", " PA10000000");   
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode"," CO1AP1");  
            headers.Add("token","UFizq11OTAHxGdaCkzxd1rymMxvIxc8tr3I5oLo3Z5jyh77EpddNrcwHO\
                +omwBnyl1uNrR+xF2+Hyqbw+8eOFA==");  
  
            Console.WriteLine(HttpUtils.GetRequest("http://apidomain.com/b2b /player/info",
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
} 
```

*Response 反应*

```js
{  
  "userCode": "PA10000000",  
  "loginId": "PA1000",  
  "firstName": "",  
  "lastName": "",  
  "status": "ACTIVE", // (User Status)       
  "availableBalance": 0,  
  "outstanding": 0,  
  "createdDate": 2017-04-23 22:24:07,  
  "createdBy": "B2B"  
}  
```

### 3.6. FP004 – Get List Player 获取用户列表 <a name="36-fp004-get-list-player"></a>

This service returns a list of player information.

获取用户列表信息

**Endpoint 端点**

| Name 名称 | Value 设置值 | Description 描述 |
| --- | --- | ---  |
| URL | `/list-player/info` | |
| Method | `GET` | |


**Parameters 参数**

| Name <br/> 名称 | Type <br/> 类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required 必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
private static void getPlayer() throws IOException {  
    Map params = new HashMap();  
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth\
            /jbR/qgUcpi2wHc62Tw==");  
          
    String url = "http://apidomain.com/b2b/list-player/info";  
    String result = HttpUtils.get(url, "", params, headers);  
    System.out.println(result);  
}  
```

*Sample code (C#)  示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace GetListPlayer  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0+efzoMCb3i\
                    +PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.GetRequest("http://apidomain.com/b2b/list-player/info", 
                    parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}
```

*Response 反应*

```js
[{  
  "userCode": "PA10000000",
  "loginId": "PA1000",  
  "firstName": "",  
  "lastName": "",  
  "status": "ACTIVE", // (User Status)       
  "availableBalance": 0,  
  "outstanding": 0,  
  "createdDate": 2017-04-23 22:24:07,  
  "createdBy": "B2B"  
}]  
```

### 3.7. FP007 – Change Status Member 更改用户状态 <a name="37-fp007-change-status-member"></a>

This service updates the status for a player.

更新用户状态

**Endpoint 端点**

| Name 名称 | Value 设置值 | Description  描述 |
| ---  | ---  | ---   |
| URL  | `/player/update-status`  |   |
| Method  | `GET`/`POST` | For POST method, it is recommended to send parameters as a JSON object in the request body. <br/>对于 POST 方法，建议在请求正文中以 JSON 对象的形式发送参数。|


**Parameters 参数**

| Name <br/>名称 | Type <br/>类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String  (required 必需项)  |  | This is agent code that you get at step 2. E.g: CO1AP1 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `userCode` | Query | String (required 必需项)  |  | This is the user code / loginID of the player. E.g: PA10000000.<br/>此为玩家登录名/用户名，例如PA10000000 |
| `status` | Query | String (required 必需项)  | `ACTIVE`, `INACTIVE`, `SUSPENDED` | See User Status in the Data-format. 详见数据格式中的用户状态。|

**Note 注:**
-	`INACTIVE` player CANNOT login on Member site
-	`SUSPENDED` player CAN login on Member site, but CANNOT place bet

**注意：**
-	`INACTIVE` 玩家不可登陆 
-	`SUSPENDED` 玩家可以登陆，但不能投注

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void updateStatusMember() throws IOException {  
    Map params = new HashMap();  
    params.put("userCode", "PA10000000");  
    params.put("status", "ACTIVE");  

    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth\
            /jbR/qgUcpi2wHc62Tw==");  
      
    String url = "http://apidomain.com/b2b/player/update-status";  
    String result = HttpUtils.post(url, "", params, headers);  
    System.out.println(result);  
}  
```

*Sample code (C#)  示例代码（C#）)*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace ChangeStatusMember  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("userCode", "PA10000000");   
            parameters.Add("status", "ACTIVE");   
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0+efzoMCb3i\
                    +PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.PostRequest("http://apidomain.com/b2b/player/update-status", 
                    parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
} 
```

**Response 回应**

```js
{  
    "status": "successful"  
}
```

### 3.8. FR001 – Wagers 投注 <a name="38-fr001-wagers"></a>

This service returns all wagers for a player.

获取你所有用户的投注

We also provide a wager feed to Push wager changes to B2B customer servers (see FR004).

我们也提供投注信息来推动更改的投注到B2B客户的服务器（参考FR004）

请参考 Wager 字段返回的翻译: [链接](translation.md)

**Endpoint 端点**

| Name 名称 | Value 设置值 | Description 描述  |
| ---  | ---  | ---   |
| URL  | `/report/wagers`  |   |
| Method  | `GET`  |   |

**Parameters 参数**

| Name <br/>名称 | Type <br/>类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required 必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String(required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `dateFrom` | Query | Date (required 必需项)  | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 创建日期格式 yyyy-MM-dd HH:mm:ss 时区为GMT-4 | Example 例如: 2016-10-15 23:59:59 |
| `dateTo`  | Query | Date(required 必需项)  | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 创建日期格式 yyyy-MM-dd HH:mm:ss 时区为GMT-4 | Example: 2016-10-16 23:59:59 Rule: dateTo – dateFrom <= 24 hours 例如：2016-10-16 23:59:59 规则： dateTo - dateFrom <= 24 hours 结束日期-开始日期小于等于24小时 |
| `product` | Query | String (required 必需项) | SB | Product Sport Book 产品: 体育 |
| `userCode` | Query | String (required 必需项) |  | This is the user code / loginID of the player. E.g: PA10000000 此为玩家登录名/用户名，例如PA10000000 |
| `settle` | Query | Boolean(optional 非必需项) | true/false(Default 默认: false) | If true, wagers of status included: SETTLED, CANCELLED Else also included: OPEN, PENDING  如TRUE, 那么注单状态包括： 已结算，已取消 其他还包括：等待中，注单未结算 |
| `filterBy` | Query | String (optional 非必需项) | event_date/wager_date (Default 默认: event_date) | If settle (above) equals FALSE date range is based on filterBy‘s value otherwise it is based on settlement date 如果settle返回FAlSE, 日期会按照filterBy的数值，否则按照注单结算日期 |
| `locale` | Query | String(optional 非必需项) | Supported locales based on brand’s available languages. 支持的语言是基于品牌可用的语言 |  See Locale (Language) in the Data-format. 详见数据格式中的区域代码（语言）。|

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void getListWager() throws IOException {  
    Map params = new HashMap();  
    params.put("userCode", "PA10000000");  
    params.put("dateFrom", "2017-04-13 00:00:00");  
    params.put("dateTo", "2017-04-14 00:00:00");  
    params.put("settle", "true");  
    params.put("product", "SB");  
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth\
            /jbR/qgUcpi2wHc62Tw==");  
      
    String url = "http://apidomain.com/b2b/report/wagers";  
    String result = HttpUtils.get(url, "", params, headers);  
    System.out.println(result);  
}    
```

*Sample code (C#)  示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace Wagers  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("userCode", "PA10000000");    
            parameters.Add("dateFrom", "2017-04-13 00:00:00");    
            parameters.Add("dateTo", "2017-04-14 00:00:00");    
            parameters.Add("settle", "true");    
            parameters.Add("product", "SB");    
   
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0+efzoMCb3i\
                +PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.GetRequest("http://apidomain.com/b2b/report/wagers", 
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
} 
```

**Response OK (SB - without Parlay) 反应OK (体育-没有过关)**

```js
[  
  {  
    "wagerId": 6719824,
    "eventId": 704431488,
    "eventName": "Brisbane Olympic United SSC-vs-Moreton Bay United FC",  
    "parentEventName": null,
    "headToHead": null,  
    "wagerDateFm": "2017-04-13 05:13:04",  
    "eventDateFm": "2017-04-13 09:30:00",  
    "settleDateFm": "2017-04-13 08:12:05",
    "resettleDateFm": "2017-04-13 09:12:05",
    "status": "SETTLED",  
    "homeTeam": "Brisbane Olympic United SSC",  
    "awayTeam": "Moreton Bay United FC",  
    "selection": "Moreton Bay United FC",  
    "handicap": 0.75,  
    "odds": 1.99,  
    "oddsFormat": 1,
    "wagerType: "single",
    "betType": 2,  
    "leagueId": 545,
    "league": "Australia NPL - Queensland",  
    "stake": 7.00,
    "sportId": 29,  
    "sport": "Soccer",  
    "currencyCode": "CNY",  
    "inplayScore": "0-1",  //the live event's current score
    "inPlay": true,  //indicate that the wager is placed on In Play event
    "homePitcher": null,  
    "awayPitcher": null,  
    "homePitcherName": null,  
    "awayPitcherName": null,  
    "period": 0,  
    "cancellationStatus": null,  
    "parlaySelections": [],  
    "category": null,
    "toWin": 6.93,  //is the amount that player will win if he wins the bet
    "toRisk": 7.00,  //is the amount that player will lose if he loses the bet
    "product": "SB",
    "isResettle": false,
    "parlayMixOdds": 1.99,
    "parlayFinalOdds": 1.99,
    "competitors": [],  
    "userCode": "Q23100000D",  
    "loginId": "Q23100D",  
    "winLoss": -3.50,  
    "turnover": 3.50,  
    "scores": [  
      {  
        "period": 1,  
        "score": "0-1"  
      },  
      {  
        "period": 0,  
        "score": "2-2"  
      }  
    ],  
    "result": "LOSE",
    "volume": 6.93,
    "view" : 'D-Compact' //D: Desktop M: Mobile
  }  
]  
```

**Response OK (SB - with Parlay) 反应 OK (体育 – 有过关)**

```js
[  
  {  
    "wagerId": 6719844,  
    "eventName": null,
    "parentEventName": null,
    "headToHead": null,  
    "wagerDateFm": "2017-04-13 05:19:37",  
    "eventDateFm": "2017-04-13 09:30:00",  
    "settleDateFm": "2017-04-13 06:22:14",
    "resettleDateFm": "2017-04-13 07:22:14",
    "status": "SETTLED",  
    "homeTeam": null,  
    "awayTeam": null,  
    "selection": "",  
    "handicap": 0,  
    "odds": 5.597,  
    "oddsFormat": 1,  
    "wagerType: "parlay",
    "betType": 6,  
    "leagueId": 0,
    "league": null,  
    "stake": 7.00,  
    "sportId": 0,
    "sport": null,  
    "currencyCode": "CNY",  
    "inplayScore": "0",  //the live event's current score
    "inPlay": false,  //indicate that the wager is placed on In Play event
    "homePitcher": null,  
    "awayPitcher": null,  
    "homePitcherName": null,  
    "awayPitcherName": null,  
    "period": 0,  
    "cancellationStatus": null,  
    "category": null,
    "masterWagerId": 6719844,  
    "wagerNum": 1,
    "parlaySelections": [  
      {  
        "selection": "Banyule City",  
        "eventDateFm": "2017-04-13 09:30:00",  
        "scores": [  
          {  
            "period": 1,  
            "score": "1-1"  
          },  
          {  
            "period": 0,  
            "score": "1-1"  
          }  
        ],  
        "sportId": 29,
        "sport": "Soccer",  
        "leagueId": 545,
        "league": "Australia - FFA Cup Qualifiers",
        "eventId": 704431423,
        "eventName": "Banyule City –vs- Melbourne Knights",  
        "homeTeam": "Banyule City",  
        "awayTeam": "Melbourne Knights",  
        "betType": 2,  
        "wagerId": 6719844,  
        "inplayScore": null,  //the live event's current score
        "inPlay": false,  //indicate that the wager is placed on In Play event
        "odds": 1.952,  
        "handicap": 2.25,  
        "homePitcher": null,  
        "awayPitcher": null,  
        "homePitcherName": null,  
        "awayPitcherName": null,  
        "period": 0,  
        "legStatus": "WON"  
      },  
      {  
        "selection": "Brisbane Wolves",  
        "eventDateFm": "2017-04-13 09:30:00",  
        "scores": [  
          {  
            "period": 1,  
            "score": "0-1"  
          },  
          {  
            "period": 0,  
            "score": "0-4"  
          }  
        ],  
        "sportId": 29,
        "sport": "Soccer",  
        "leagueId": 545,
        "league": "Australia - FFA Cup Qualifiers",
        "eventId": 704431424,
        "eventName": "Brisbane Wolves –vs- Peninsula Power",  
        "homeTeam": "Brisbane Wolves",  
        "awayTeam": "Peninsula Power",  
        "betType": 2,  
        "wagerId": 6719844,  
        "inplayScore": null,  //the live event's current score
        "inPlay": false,  //indicate that the wager is placed on In Play event
        "odds": 1.769,  
        "handicap": 1.25,  
        "homePitcher": null,  
        "awayPitcher": null,  
        "homePitcherName": null,  
        "awayPitcherName": null,  
        "period": 0,  
        "legStatus": "LOSE"  
      },  
      {  
        "selection": "AZS UJ Krakow (women)",  
        "eventDateFm": "2017-04-13 09:30:00",  
        "scores": [  
          {  
            "period": 0,  
            "score": "4-1"  
          }  
        ],  
        "sportId": 29,
        "sport": "Soccer", 
        "leagueId": 5412, 
        "league": "Poland - Ekstraliga Women",
        "eventId": 704431322,
        "eventName": "Gks Gornik Leczna (W) –vs- AZS UJ Krakow (women)",  
        "homeTeam": "Gks Gornik Leczna (W)",  
        "awayTeam": "AZS UJ Krakow (women)",  
        "betType": 2,  
        "wagerId": 6719844,  
        "inplayScore": null,  //the live event's current score
        "inPlay": false,  //indicate that the wager is placed on In Play event
        "odds": 1.621,  
        "handicap": 4.5,  
        "homePitcher": null,  
        "awayPitcher": null,  
        "homePitcherName": null,  
        "awayPitcherName": null,  
        "period": 0,  
        "legStatus": "WON"  
      }  
    ],  
    "toWin": 32.179,  //is the amount that player will win if he wins the bet
    "toRisk": 7.00, //is the amount that player will lose if he loses the bet  
    "product": "SB",
    "isResettle": false,
    "parlayMixOdds": 5.597,
    "parlayFinalOdds": 5.597,
    "competitors": [],  
    "userCode": "Q23100000D",  
    "loginId": "Q23100D",  
    "winLoss": -7.00,  
    "scores": [],  
    "turnover": 7.00,  
    "result": "LOSE",
    "volume": 7.00,
    "view" : 'D-Euro' //D: Desktop M: Mobile
  }  
] 
```

**Response OK (SB - with Outright)反应 OK (体育 – 有优胜冠军)**

```js
[  
  {  
    "wagerId": 6862959,
    "eventId": 380533298,
    "eventName": "Both Teams To Score 1st Half",  
    "parentEventName": "Middlesbrough-vs-Arsenal",  
    "headToHead": null,  
    "wagerDateFm": "2017-04-17 07:15:42",  
    "eventDateFm": "2017-04-17 09:30:00",  
    "settleDateFm": "2017-04-17 08:50:00",
    "resettleDateFm": "2017-04-17 09:22:14",
    "status": "SETTLED",  
    "homeTeam": "No",  
    "awayTeam": "Both Teams To Score 1st Half",  
    "selection": "No",  
    "handicap": 0,  
    "odds": 1.199,  
    "oddsFormat": 1,  
    "wagerType: "single",
    "betType": 99, 
    "leagueId": 5452, 
    "league": "England - Premier League",  
    "stake": 10.00,  
    "sportId": 29,
    "sport": "Soccer",  
    "currencyCode": "CNY",  
    "inplayScore": "",  //the live event's current score
    "inPlay": false,  //indicate that the wager is placed on In Play event
    "homePitcher": null,  
    "awayPitcher": null,  
    "homePitcherName": null,  
    "awayPitcherName": null,  
    "period": 0,  
    "cancellationStatus": null,  
    "parlaySelections": [],  
    "category": "Both Teams To Score ",  
    "toWin": 1.99,  //is the amount that player will win if he wins the bet
    "toRisk": 10.00,  //is the amount that player will lose if he loses the bet
    "product": "SB",
    "isResettle": false,
    "parlayMixOdds": 1.199,
    "parlayFinalOdds": 1.199,
    "competitors": [],  
    "userCode": "Q23100000D",  
    "loginId": "Q23100D",  
    "winLoss": 1.99,  
    "scores": [],  
    "turnover": 10.00,  
    "result": "WIN",
    "volume": 1.99,
    "view" : 'M-Asian' //D: Desktop M: Mobile
  }  
]  
```

**Response OK (SB - with Teaser) 反应OK (体育-含变让分过关盘)**

```js
[  
  {  
    "wagerId": 702256132,  
    "eventName": null,  
    "parentEventName": null,  
    "headToHead": null,  
    "wagerDateFm": "2018-05-02 04:15:25",  
    "eventDateFm": "2018-05-02 09:30:00",  
    "settleDateFm": null,
    "resettleDateFm": null,
    "status": "OPEN",  
    "homeTeam": null,  
    "awayTeam": null,  
    "selection": null,  
    "handicap": 0,  
    "odds": 0.5,  
    "oddsFormat": 2,  
    "wagerType: "teaser",
    "betType": 7,  
    "leagueId": 0,
    "league": null,  
    "stake": 11.00,  
    "sportId": 4,
    "sport": "Basketball",
    "currencyCode": "CNY",  
    "inplayScore": "0",  
    "inPlay": false,  
    "homePitcher": null,  
    "awayPitcher": null,  
    "homePitcherName": null,  
    "awayPitcherName": null,  
    "period": 0,  
    "cancellationStatus": null,  
    "parlaySelections": [  
      {  
        "selection": "Toronto Raptors",  
        "eventDateFm": "2018-05-04 09:30:00",  
        "scores": [],  
        "sportId": 4,
        "sport": "Basketball",  
        "leagueId": 1231,
        "league": "NBA",  
        "homeTeam": "Toronto Raptors",  
        "awayTeam": "Cleveland Cavaliers",  
        "betType": 2,  
        "wagerId": 702256132,  
        "selectionType": 0,  
        "inplayScore": null,  
        "inPlay": false,  
        "odds": 0,  
        "handicap": 0.5,  
        "homePitcher": null,  
        "awayPitcher": null,  
        "homePitcherName": null,  
        "awayPitcherName": null,  
        "period": 0,  
        "legStatus": "ACCEPTED",
        "eventId": 10458146,
        "eventName": "Toronto Raptors-vs-Cleveland Cavaliers",  
        "point": 7,  
        "type": "NBA 2 - 6 Team",  
        "teaserHDPPoint": "-6.5 + 7 pts"  
      },  
      {  
        "selection": "Utah Jazz",  
        "eventDateFm": "2018-05-03 09:30:00",  
        "scores": [],  
        "sportId": 4,
        "sport": "Basketball",  
        "leagueId": 1231,
        "league": "NBA",  
        "homeTeam": "Houston Rockets",  
        "awayTeam": "Utah Jazz",  
        "betType": 2,  
        "wagerId": 702256132,  
        "selectionType": 1,  
        "inplayScore": null,  
        "inPlay": false,  
        "odds": 0,  
        "handicap": 18,  
        "homePitcher": null,  
        "awayPitcher": null,  
        "homePitcherName": null,  
        "awayPitcherName": null,  
        "period": 0,  
        "legStatus": "WON",
        "eventId": 10534278,
        "eventName": "Houston Rockets-vs-Utah Jazz",  
        "point": 7,  
        "type": "NBA 2 - 6 Team",  
        "teaserHDPPoint": "11 + 7 pts"  
      }  
    ],  
    "category": null,  
    "toWin": 5.50,  
    "toRisk": 11.00,  
    "product": "SB",  
    "parlayMixOdds": 0.5,
    "parlayFinalOdds": 0.5,
    "competitors": [],  
    "userCode": "Q231000000",  
    "loginId": "Q231000000",  
    "winLoss": 0.00,  
    "turnover": 0.00,  
    "scores": [],  
    "result": null,
    "volume": 5.50,
    "view" : 'M-Euro' //D: Desktop M: Mobile
  }  
]  
```

### 3.9. FR002 – All Wagers – 所有投注 <a name="39-fr002-all-wagers"></a>

This service returns all wagers for a player (this function works as FR001 and will replace it in the future).

获取你用户所有的投注 （此功能和FR001一样，并在将来取代它）

请参考 Wager 字段返回的翻译: [链接](translation.md)

**Endpoint 端点:**

| Name 名称 | Value 设置值  | Description 描述  |
| ---  | ---  | ---   |
| URL  | `/report/all-wagers`  |   |
| Method  | `GET`  |   |

**Parameters 参数:**

| Name 名称 | Type <br/>类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | ---  | --- | ---  | ---  |
| `userCode`  | Header | String (required必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String(required必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `dateFrom` | Query | Date (optional非必需项)  | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 创建日期格式 yyyy-MM-dd HH:mm:ss 时区为GMT-4 | Example 例如: 2016-10-15 23:59:59  |
| `dateTo (1)` | Query | Date (optional非必需项)  | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 创建日期格式 yyyy-MM-dd HH:mm:ss 时区为GMT-4 | Example: 2016-10-16 23:59:59 Rule: dateTo – dateFrom <= 24 hours <br/>例如：2016-10-16 23:59:59 规则： dateTo - dateFrom <= 24 hours 结束日期-开始日期小于等于24小时 |
| `userCode` | Query | String (optional 非必需项) |  | This is the user code / loginID of the player. E.g: PA10000000. 玩家用户名/登录名 |
| `settle` | Query | Int (optional 非必需项) | 1: settled 已结算 <br/>0: unsettled 未结算 <br/>-1: all (both settled and unsettled) 所有（包含已结算和未结算） (Default: -1) | 1 = wager status: SETTLED or CANCELLED 注单状态：已结算或已取消<br/>0 = wager status includes: OPEN or PENDING 注单状态包括：等待中 或者 注单未结算<br/>-1 All wager status values 所有注单状态值。|
| `filterBy (2)` | Query | String(optional非必需项) | event_date wager_date settle_date update_date (Default 默认: wager_date) |
| `locale` | Query | String (optional 非必需项) | Supported locales based on brand’s available languages. 在基于现有品牌的语言下，列出所支持区域 |  See Locale (Language) in the Data-format. 详见数据格式中的区域代码（语言）。|
| `wagerIds` | Query | String(optional 非必需项) | A comma-separated list of wagerIDs to be returned. 用逗号分隔的注单ID列表将会被返回 |  Example 例如: `6862955`,`6862947` |

**Note:**
(1):
1. WITHOUT date range:
	a. System shall return all wagers from last 24 hours. 
2. Specific date range:
	a. If `userCode` = null, valid date range will be up to 24 hours.
	b. If `userCode` != null, valid date range will be up to 168 hours (7 days).

**注意：**

1. 如未输入日期范围, 则系统应返回过去24小时内的全部注单。
2. 如果输入了日期范围:
	a. 如果 `userCode` = null, 有效日期范围最高为24小时。
	b. 如果 `userCode` != null, 有效日期范围最高为168小时(7 天).

(2):	
When filterBy is settle_date, the system will only query data by date (not time) but dateFrom and dateTo must still use yyyy-MM-dd HH:00:00 format.

URL example: http://apidomain.com/b2b/report/all-wagers?wagerIds=6862955,6862947

在filterBy是settle_date的情况下，系统只按日期格式查询数据，但dateFrom和dateTo仍然使用yyyy-MM-dd HH:00:00的格式。

URL 示例: http://apidomain.com/b2b/report/all-wagers?wagerIds=6862955,6862947

**Response OK 返回OK**

The response result is the same as with FR001 except that the result may contain data for more than one “userCode”.

这个反应是跟FR001一样，但会为每张注单结果添加“userCode”

请参考 Wager 字段返回的翻译: [链接](translation.md)

```js
[  
  {  
    "wagerId": 6862955,
    "eventId": 688720403,
    "eventName": "Winner of 2018 Super Bowl?",  
    "parentEventName": null,  
    "headToHead": null,  
    "wagerDateFm": "2017-04-17 07:15:29",  
    "eventDateFm": "2017-09-01 09:30:00",  
    "settleDateFm": null,  // in case status=”SETTLED” is value like "2017-09-01 22:02:15”
    "resettleDateFm": null,
    "status": "OPEN",  
    "homeTeam": "New England Patriots",  
    "awayTeam": "Winner of 2018 Super Bowl?",  
    "selection": "New England Patriots",  
    "handicap": 0,  
    "odds": 5.39,  
    "oddsFormat": 1,  
    "betType": 99,  
    "wagerType: "single",
    "leagueId": 5121,
    "league": "NFL",  
    "stake": 10.00,  
    "sportId": 15,
    "sport": "Football",  
    "currencyCode": "CNY",  
    "inplayScore": "",  //the live event's current score
    "inPlay": false,  //indicate that the wager is placed on In Play event
    "homePitcher": null,  
    "awayPitcher": null,  
    "homePitcherName": null,  
    "awayPitcherName": null,  
    "period": 0,  
    "cancellationStatus": null,  
    "parlaySelections": [],  
    "category": "Futures",  
    "toWin": 43.90,  //is the amount that player will win if he wins the bet
    "toRisk": 10.00,  //is the amount that player will lose if he loses the bet
    "product": "SB",
    "isResettle": null, // in case status=”SETTLED” value is true or false
    "parlayMixOdds": 5.39,
    "parlayFinalOdds": 5.39,
    "competitors": [],  
    "userCode": "Q23100000D",  
    "loginId": "Q23100D",  
    "winLoss": 0.00,  
    "scores": [],  
    "result": null,
    "volume": 10.00,
    "view" : 'D-Compact' //D: Desktop M: Mobile
  },  
  {  
    "wagerId": 6862947,
    "eventId": 688976540,
    "eventName": "Player to Win ATP French Open ? (All In)",  
    "parentEventName": null,  
    "headToHead": null,  
    "wagerDateFm": "2017-04-17 07:11:17",  
    "eventDateFm": "2017-05-22 09:30:00",  
    "settleDateFm": null,
    "resettleDateFm": null,
    "status": "OPEN",  
    "homeTeam": "Andy Murray",  
    "awayTeam": "Player to Win ATP French Open ? (All In)",  
    "selection": "Andy Murray",  
    "handicap": 0,  
    "odds": 5.36,  
    "oddsFormat": 1,  
    "betType": 99,  
    "wagerType: "single",
    "leagueId": 9281,
    "league": "ATP French Open",  
    "stake": 10.00,  
    "sportId": 33,
    "sport": "Tennis",  
    "currencyCode": "CNY",  
    "inplayScore": "",  //the live event's current score
    "inPlay": false,  //indicate that the wager is placed on In Play event
    "homePitcher": null,  
    "awayPitcher": null,  
    "homePitcherName": null,  
    "awayPitcherName": null,  
    "period": 0,  
    "cancellationStatus": null,  
    "parlaySelections": [],  
    "category": "To Win",  
    "toWin": 43.60, //is the amount that player will win if he wins the bet 
    "toRisk": 10.00,  //is the amount that player will lose if he loses the bet
    "product": "SB",
    "isResettle": null, // in case status=”SETTLED” value is true or false
    "parlayMixOdds": 5.36,
    "parlayFinalOdds": 5.36,
    "competitors": [],  
    "userCode": "Q23100000D",  
    "loginId": "Q23100D",  
    "winLoss": 0.00,  
    "scores": [],  
    "turnover": 0.00,  
    "result": null,
    "volume": 10.00,
    "view" : 'M-Asian' //D: Desktop M: Mobile
  }  
]  
```

### 3.10. FR003 – Win Loss Simple - 简易盈亏 <a name="310-fr003-win-loss-simple"></a>

This service returns a simple win loss report for agent or player.

获取代理和用户的简易盈亏

**Endpoint 端点:**

| Name 名称 | Value 设置值 | Description 描述  |
| ---  | ---  | ---   |
| URL  | `/report/winloss-simple` |   |
| Method  | `GET`  |  

**Parameters 参数:**

| Name <br/>名称 | Type <br/>类型 | Value 设置值  | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required 必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `dateFrom` | Query | Date (optional 非必需项)  | Created Date format yyyy-MM-dd GMT-4  创建日期格式 yyyy-MM-dd 时区为GMT-4 | Date format Example 日期格式例子: 2016-10-15 |
| `dateTo`  | Query | Date (optional 非必需项)  | Created Date format yyyy-MM-dd GMT-4  创建日期格式 yyyy-MM-dd 时区为GMT-4 | Date format Example: 2016-10-16 Rule: dateTo – dateFrom <= 90 days 日期格式例子：2016-10-16 规则：结束日期-开始日期小于等于90天 |
| `userCode` | Query | String (optional 非必需项) |  | This is the user code / loginID  of `AGENT` or `PLAYER` 此处指的是代理或者玩家的用户名/登录ID |

**Note:**
```
Date range = null: 
	Returns report data for TODAY.
userCode  = null
	Returns data for all users under the userCode calling the API 
userCode  != null (specific user code or login id)
	a. If userCode is agent (level != PL), returns data for all users under userCode.
	b. If userCode is player (level = PL), returns data for the player.
```

**For example 例如:** <br/>
**userCode** = `CO1AP100` - This is user code of **Agent** 这是代理号 <br/>
**userCode** = `PA10000000` - This is user code of **Player** 这是用户名

**注意:**
```
Date range = null: 
	系统会获取当日报表。
userCode  = null
	获取userCode 下面所有调用API的用户报表。 
userCode  != null (特定用户名或登录名)
	a. 如果 userCode 为代理(level != PL ), 获取userCode下所有用户的报表。
	b. 如果 userCode 为玩家(level = PL ), 获取玩家报表。
```
**For example 例如:**

```
userCode = CO1AP100 - 此为代理用户名。
userCode = PA10000000 – 此为玩家用户名。
```

*Sample code (Java)*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void getWinLossSimple() throws IOException {  
    Map params = new HashMap();  
    params.put("userCode", "PA10000000");  // params.put("userCode", "CO1AP100");  
    params.put("dateFrom", "2017-05-01");  
    params.put("dateTo", "2017-06-05");  
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth/jbR/qgUcpi2wHc62Tw==");  
      
    String url = "http://apidomain.com/b2b/report/winloss-simple";  
    String result = HttpUtils.get(url, "", params, headers);  
    System.out.println(result);  
}  
```

*Sample code (C#) 示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace WinLostSimple  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("userCode", "PA10000000");    
            parameters.Add("dateFrom", "2017-05-01");    
            parameters.Add("dateTo", "2017-06-05");    
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0\
                +efzoMCb3i+PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.GetRequest("http://apidomain.com/b2b/report/winloss-simple", 
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

**Response OK 返回OK**

```js
{  
  "report": [  
    {  
      "userId": 1000002738,  
      "userCode": "PA10000000",  
      "firstName": "",  
      "currency": "USD",  
      "levelName": "PL",  
      "loginId": "PA1000",  
      "turnover": 19,  
      "payout": -3.02,  
      "winLoss": 0,  
    },  
    {  
      "userId": 1000002796,  
      "userCode": "PA10000001",  
      "firstName": "",  
      "currency": "USD",  
      "levelName": "PL",  
      "loginId": " PA1001",  
      "turnover": 1,  
      "payout": -1,  
      "winLoss": 0.05,  
    }  
  ],  
  "total": {  
    "turnover": 20,  
    "payout": -4.02,  
    "winLoss": 0.05,  
  }  
} 
```

### 3.11. FR004 – Get My Bet – 获取我的投注 <a name="311-fr004-get-my-bet"></a>

This service is used to generate a URL to allow the user to redirect to the My Bet page without needing to log in.

此服务透过传送登陆产生URL令用户无需登录也能访问‘我的投注’页面。

**Endpoint 端点**

| Name <br/>名称 | Value 设置值 | Description 描述 |
| ---  | ---  | ---  |
| URL  | /player/account/my-bets-full  |   |
| Method  | GET/POST  | For POST method, it is recommended to send parameters as a JSON object in the request body. |

Parameters 参数

| Name <br/>名称 | Type <br/>类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required 必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` | Header | String(required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `loginId`  | Query | String  (required 必需项)  |  | This is the user code / loginID of the player. E.g: PA10000000 or PA10.02 此为玩家登录名/用户名，例如PA10000000或PA10.abc123 |
| `locale`  | Query | String (optional 非必需项) | Supported locales based on brand’s available languages. 支持的语言是基于品牌可用的语言 |  See Locale (Language) in the Data-format. 详见数据格式中的区域代码（语言）。|


Format of URL for the My Bet page: 前往"我的投注" 的URL格式

```
<host>/member-service/v1/account/my-bets-full?locale=<en>&token=<token>
```

Example 例如: http://whitelabelapidomain.com/member-service/v1/account/my-bets-full?locale=en&token=YkZXSFl5S0VsUElrQzRlRS9ZRERsbDN3dktnb2dnSE1tcTZ1VTEvVnFldTJkVTcyWklJeVVRSk1xY3dpM2VWVXFYY3IxMzRpWGNBWllsakV2Wk1JZ0E9PQ==

*Note: This token is generated by the AP Gaming system to allow users to log in to our system. This is not a token generated by a third party.*

注意 : 这个 令牌 是由 AP Gaming 系统产生让 用 户 登入我 们的系统。这个不是第三方产生的 令牌。

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
private static void getTokenLogin() throws IOException {  
    Map params = new HashMap();  
    params.put("loginId", "PA1002"); 
    params.put("locale", "zh-cn"); 
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth\
        /jbR/qgUcpi2wHc62Tw==");  
    String url = "http://apidomain.com/b2b/player/account/my-bets-full";  
    String result = HttpUtils.post(url, "", params, headers);  
    System.out.println(result);  
}   
```

*Sample code (C#) 示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace GetMyBet  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("loginId", "PA1002");    
            parameters.Add("locale", "zh-cn");    
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0+efzoMCb3i+PWr1ZFuj\
                0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.PostRequest("http://apidomain.com/b2b/player/account/my-bets-full", 
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

**Response 反应**

The result is a URL to log in to the System. This URL will open a new popup in the browser. This URL will auto-login to the AP Gaming system and redirect the user to the My Bet page.

反应结果是透过URL登入系统。然后我们使用这个URL在浏览器中打开新的弹出窗口。这个URL将自动登入AP Gaming系统并重新引导至"我的投注"页面。

```js
{  
  "userCode": "PA10000001",  
  "loginId": "PA1002",  
  "token": "UGd0eFhVaUlpTXpRelhZN001NG8wSVR0eW5xMkVWcGpNUXlJYVdrUTJid2p1YW9Bdz\
    BIMGh0NmRZRG9KL3B4TXlyMjk1SjBGMnU2NzRwcVdmYXpYakE9PQ==",  
  "loginUrl": "http://whitelabelapidomain.com/member-service/v1/account/my-bets-full?locale=zh-cn&\
        token=UGd0eFhVaUlpTXpRelhZN001NG8wSVR0eW5xMkVWcGpNUXlJYVdrUTJid2p1YW9BdzB\
        IMGh0NmRZRG9KL3B4TXlyMjk1SjBGMnU2NzRwcVdmYXpYakE9PQ==",  
  "updateDate": "2017-09-06 22:46:34"  
} 
```

### 3.12. FR005 – Wager Feed 投注资料 <a name="312-fr005-wager-feed"></a>

This service will push wager changes to the B2B customer servers via HTTP.

这项服务通过HTTP推动投注更改信息到B2B客户的服务器。

To use this function, the B2B customer server must make a public Restful service available to receive JSON data from us. After B2B customer configuration success, the public URL must be sent back to us.

为了能使用这个功能，B2B客户服务器需要公开一个Restful服务来接收来自我们的JSON数据。在B2B客户配置成功后，您需要将您的公开网址发回给我们

Request URL: url_any Request Method: POST Request Payload: (see defined message model for detail) Message model:<br/>
Request 方法：POST 请求有效负载：（详细信息请参阅以下已定义的消息模型） 消息模型：

```js
{  
    "messageId":123456789,  
    "messageData":[  
        {feed_wager_data1}, 
        {feed_wager_data2}  
    ]  
}
```

Feed_wager_data model: (this model is the same as the model in FR002 except with the addition of an id field.

此数据模型与FR002内的模型一样，除了id项添加了更多)

请参考 Wager 字段返回的翻译: [链接](translation.md)

```js
{  
  "id": 750,  
  "wagerId": 7838345,  
  "sport": null,  
  "league": null,  
  "eventName": null,  
  "parentEventName": null,  
  "headToHead": null,  
  "scores": [],  
  "homeTeam": null,  
  "awayTeam": null,  
  "selection": null, 
  "masterWagerId": 7838345,  
  "wagerNum": 1,
  "parlaySelections": [  
    {  
      "wagerId": 7838345,  
      "selection": "Over",  
      "eventDateFm": "2017-07-26 09:30:00",  
      "scores": [  
        {  
          "period": 1,  
          "score": "0-2"  
        },  
        {  
          "period": 0,  
          "score": "0-3"  
        }  
      ],  
      "sportId": 29,
      "sport": "Soccer",
      "leagueId": 5412,  
      "league": "UEFA - EURO Women",  
      "homeTeam": "Iceland (W)",  
      "awayTeam": "Austria (W)",  
      "odds": 1.84,  
      "handicap": 0.75,  
      "legStatus": "WON",  
      "homePitcher": null,  
      "awayPitcher": null,  
      "homePitcherName": null,  
      "awayPitcherName": null,  
      "betType": 3,  
      "inplayScore": null,  
      "inPlay": false,  
      "period": 1,  
      "selectionType": 3, 
      "eventname": "Iceland (W)-vs-Austria (W)"  

    },  
    {  
      "wagerId": 7838345,  
      "selection": "Over",  
      "eventDateFm": "2017-07-26 09:30:00",  
      "scores": [  
        {  
          "period": 1,  
          "score": "2-0"  
        },  
        {  
          "period": 0,  
          "score": "3-1"  
        }  
      ],  
      "sportId": 29,
      "sport": "Soccer",  
      "leagueId": 54513,
      "league": "UEFA - Champions League Qualifiers",  
      "homeTeam": "FC Astana",  
      "awayTeam": "Legia Warszawa",  
      "odds": 2,  
      "handicap": 2.25,  
      "legStatus": "WON",  
      "homePitcher": null,  
      "awayPitcher": null,  
      "homePitcherName": null,  
      "awayPitcherName": null,  
      "betType": 3,  
      "inplayScore": null,  
      "inPlay": false,  
      "period": 0,  
      "selectionType": 3  
      "eventname": " FC Astana-vs-Legia Warszawa"  
    },  
    {  
      "wagerId": 7838345,  
      "selection": "Red Bull Salzburg",  
      "eventDateFm": "2017-07-26 09:30:00",  
      "scores": [  
        {  
          "period": 1,  
          "score": "0-1"  
        },  
        {  
          "period": 0,  
          "score": "1-1"  
        }  
      ],  
      "sportId": 29,
      "sport": "Soccer",  
      "leagueId": 54513,
      "league": "UEFA - Champions League Qualifiers",  
      "homeTeam": "Red Bull Salzburg",  
      "awayTeam": "HNK Rijeka",  
      "odds": 1.636,  
      "handicap": 0,  
      "legStatus": "LOSE",  
      "homePitcher": null,  
      "awayPitcher": null,  
      "homePitcherName": null,  
      "awayPitcherName": null,  
      "betType": 1,  
      "inplayScore": null,  
      "inPlay": false,  
      "period": 0,  
      "selectionType": 0  
    },  
    {  
      "wagerId": 7838345,  
      "selection": "Under",  
      "eventDateFm": "2017-07-26 09:30:00",  
      "scores": [  
        {  
          "period": 1,  
          "score": "0-0"  
        },  
        {  
          "period": 0,  
          "score": "1-0"  
        }  
      ],  
      "sportId": 29,
      "sport": "Soccer",  
      "leagueId": 54513,
      "league": "UEFA - Champions League Qualifiers",  
      "homeTeam": "Viitorul Constanta",  
      "awayTeam": "APOEL Nicosia",  
      "odds": 1.657,  
      "handicap": 2.25,  
      "legStatus": "WON",  
      "homePitcher": null,  
      "awayPitcher": null,  
      "homePitcherName": null,  
      "awayPitcherName": null,  
      "betType": 3,  
      "inplayScore": null,  
      "inPlay": false,  
      "period": 0,  
      "selectionType": 4  
      "eventname": "Viitorul Constanta-vs-APOEL Nicosia"  
    }  
  ],  
  "odds": 9.976,  
  "handicap": 0,  
  "parlayMixOdds": 9.976,
  "parlayFinalOdds": 9.976,
  "homePitcher": null,  
  "awayPitcher": null,  
  "homePitcherName": null,  
  "awayPitcherName": null,  
  "betType": 6,  
  "inplayScore": "0",  
  "cancellationStatus": null,  
  "category": null,  
  "inPlay": false,  
  "eventDateFm": "2017-07-26 09:30:00",  
  "oddsFormat": 1,
  "wagerType: "parlay",
  "result": "DRAW",  
  "status": "SETTLED",  
  "toWin": 89.76,  
  "toRisk": 10.00,
  "stake": 10.00,
  "period": 0,
  "product": "SB",
  "winLoss": 0.00,  
  "currencyCode": "CNY",  
  "userCode": "KR00000000",  
  "loginId": "KR0000", 
  "wagerDateFm": "2017-07-26 02:13:31"
  "turnover": 0.00,
  "settleDateFm":  "2017-07-26 04:11:22",
  "resettleDateFm": "2017-07-26 05:11:22"
} 
```

Example, Coding: 例如，代码：

*Setup endpoint 设置端点:*

```java
@RequestMapping(value = "/feed/wager", method = RequestMethod.POST)  
public Object receiveData1(@RequestBody Message message) {  
    System.out.println("======IntegrationController /feed/wager ========" + message.getMessageData().toString());  
    String result = message.getMessageId();  
    fService.onMessage(message.getMessageData());  
    return result;  
}  
```

*Define message model 界定信息模型:*

```java
public class Message {  
  
    String messageId;  
    List<WagerFeed> messageData;  
  
    public String getMessageId() {  
        return messageId;  
    }  
  
    public List<WagerFeed> getMessageData() {  
        return messageData;  
    }  
  
    public void setMessageData(List<WagerFeed> messageData) {  
        this.messageData = messageData;  
    }  
}  
public class WagerFeed {  
  
    long id;  
    long wagerId;  
    String status;  
    BigDecimal toWin;  
    BigDecimal toRisk;  
    BigDecimal winLoss;  
    String currency;  
    String userCode;  
    String wagerDateFm;  
    String sport;  
    String league;  
    String eventName;  
    String parentEventName;  
    String headToHead;  
    List<EventScore> scores = new ArrayList<>();  
    String homeTeam;  
    String awayTeam;  
    String selection;  
    List<WagerFeedSelection> parlaySelections = new ArrayList<>();  
    BigDecimal odds;  
    BigDecimal handicap;  
    BigDecimal parlayMixOdds;
    BigDecimal parlayFinalOdds;
    String homePitcher;  
    String awayPitcher;  
    String homePitcherName;  
    String awayPitcherName;  
    int betType;  
    String inplayScore;  
    String cancellationStatus;  
    String category;  
    boolean inPlay;  
    String eventDateFm;  
    int oddsFormat;  
    String wagerType;
    String result;  
    // GETTER SETTER HERE  
}  
public class EventScore {  
    int period;  
    String score;  
    // GETTER SETTER HERE  
}  
public class WagerFeedSelection {  
    long wagerId;  
    String selection;  
    String eventDateFm;  
    List<EventScore> scores = new ArrayList<>();  
    String sport;  
    String league;  
    String homeTeam;  
    String awayTeam;  
    BigDecimal odds;  
    BigDecimal handicap;  
    private LegStatus legStatus;  
    String homePitcher;  
    String awayPitcher;  
    String homePitcherName;  
    String awayPitcherName;   
    int betType;  
    String inplayScore;  
    boolean inPlay;  
    int period;  
    int selectionType;  
    String eventName;  

    // GETTER SETTER HERE  
}  
```

### 3.13. FR006 – Announcement 公告 <a name="313-fr006-announcement"></a>

This service will get match announcements.

这项服务用于获取比赛公告

**Endpoint 端点:**

| Name 名称 | Value 设置值 | Description  描述 |
| ---  | ---  | ---   |
| URL  | `/player/account/announcements` |   |
| Method  | `GET` | |
 
**Parameters 参数:**

| Name <br/>名称 | Type <br/>类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required 必需项) |  | This is the agent code obtained in step 2. E.g: CO1AP1. 这里指的是步骤2中获得的代理号，例如：CO1AP1 |
| `token` | Header | String (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `dateFrom` | Query | Date (optional 非必需项) | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 创建日期格式 yyyy-MM-dd HH:mm:ss 时区为GMT-4 | Example 例如: 2016-10-15 23:59:59  |
| `dateTo`  | Query | Date (optional 非必需项) | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 创建日期格式 yyyy-MM-dd HH:mm:ss 时区为GMT-4 | Example: 2016-10-16 23:59:59 Rule: dateTo – dateFrom <= 168 hours (7 days) 例如：2016-10-16 23:59:59 规则： dateTo - dateFrom <= 168 hours (7 days) 结束日期-开始日期小于等于168小时（7天） |
| `locale` | Query | String(optional 非必需项) | Supported locales based on brand’s available languages. 支持的语言是基于品牌可用的语言 |  See Locale (Language) in the Data-format. 详见数据格式中的区域代码（语言）。|
| `sport` | Query | String(optional 非必需项) | The sport name 体育名称 |  See Sport in the Data-format. 详见数据格式中的体育项目。|

**Note:**

No date range specified: System will return all announcements from the last 24 hours (1 day).

注意： a. 如果未输入日期，系统将返回过去24小时内的所有公告

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void getAnnouncements() throws IOException {  
    Map params = new HashMap();  
    params.put("dateFrom", "2017-04-13 00:00:00");  
    params.put("dateTo", "2017-04-14 00:00:00");  
    params.put("locale", "en");
    params.put("sport", "soccer");
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth/jbR/qgUcpi2wHc62Tw==");  
      
    String url = "http://apidomain.com/b2b/player/account/announcements";  
    String result = HttpUtils.get(url, "", params, headers);  
    System.out.println(result);  
}  
```

*Sample code (C#) 示例代码（C#）*

```csharp
using System;  
using System.Net.Http;  
using System.Collections.Generic;  
using System.Threading.Tasks;  
  
namespace Announcement  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("dateFrom", "2017-04-13 00:00:00");    
            parameters.Add("dateTo", "2017-04-14 00:00:00");    
            parameters.Add("locale", "en");    
   
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0\
                +efzoMCb3i+PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.GetRequest("http://apidomain.com/b2b/player/account/announcements", 
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

**Response OK返回OK**

```js
[  
  {  
    "text": "Wagers for the following market have been refunded due to event \
        cancellation. [2017-08-02 11:30 PM][Di Wu Game 10 of Set 1-vs-Xin Gao Game 10 of Set 1][Match]",  
    "createdDate": "2017-08-02 23:59:52"
  },  
  {  
    "text": "Wagers for the following market have been refunded due to event \
        cancellation. [2017-08-02 11:30 PM][Di Wu Game 11 of Set 1-vs-Xin Gao Game 11\ of Set 1][Match]",  
    "createdDate": "2017-08-02 23:59:49"
  },  
  {  
    "text": "Due to a change in scores, wagers for the following market have been\
         resettled, [2017-06-20 02:30 PM][Los Andes-vs-Gimnasia Jujuy][1st Half]",  
    "createdDate": "2017-06-20 15:20:01"
  },  
  {  
    "text": "Wagers for the following market have been refunded due to event \
        cancellation. [2017-06-15 11:00 AM][Bayern Munchen II (n)-vs-Wacker Innsbruck][Match]",  
    "createdDate": "2017-06-15 10:39:28"
  },  
  {  
    "text": "The following wagers have been voided: Wager ID: 7540873, \
        Cancellation Reason: nullDetails:  not verification \n",  
    "createdDate": "2017-06-14 10:12:50"
  },  
  {  
    "text": "Due to a change in scores, wagers for the following market have been \
        resettled, [2017-06-09 06:45 AM][Player to Win ATP French Open ? (All In)][Match]",  
    "createdDate": "2017-06-11 20:43:32"
  }  
]  
```

### 3.14. FR009 – Get Hot Event 获取热门赛事 <a name="314-fr009-get-hot-event"></a>

This service will return hot events configured by B2B Agent.

这项服务将获得B2B Agent设置的热门赛事

Call the API along with the Sport name to get events. Each Sport has its own logic for getting hot events:

使用体育名称调用API以获取赛事，并且每种体育项目都有其自己的逻辑来获取热门赛事：

- If the requested Sports are in configurations as B2B Hot Events on the Partner Service BO Site, the system will return the Hot Events for that Sport. 若请求的体育项目在配置B2B热门赛事–后台中，则系统将以config形式返回该项目的热门赛事API。
- If the requested Sport is Soccer: The Hot Events will be based on the following information to return 50 Hot Events. 若请求的体育项目是足球：系统将基于以下信息进行计算以获取50个热门赛事
	- Hot Soccer Team and Hot Leagues (return Hot Events starting in the next 15 days). 热门足球队和热门联赛（返还接下来15天开始的炙热事件）。
	- Highest max bet of Money Line. 最高赔率投注。
- If requested Sport is E-Sports: The Hot Events will be based on the following information to return 50 Hot Events for each Game. 若请求的体育项目是电子竞技：系统将基于以下信息进行计算，以获取每种游戏的50个热门赛事。
	- Hot E-Sports team and Hot Leagues (return Hot Events starting in the next 15 days). 热门电子竞技团队和热门联赛（返还接下来15天开始的炙热事件）。
	- Highest max bet of Money Line 最高赔率投注。
- For all other Sports: The Hot Events will be based on the following information to return 50 Hot Events for each Sport. 若请求的体育项目是其他：系统将基于以下信息进行计算，以获取每种体育项目的50个热门事件。
	- Hot Leagues (return Hot Events starting in the next 15 days). 热门联赛（返还接下来15天开始的炙热事件）。
	- Highest max bets of Money line. 最高赔率投注。

The Event IDs parameter obtained by the Get Hot Event API can be passed into the LoginV2 API in order to redirect players to the corresponding event page. 热门赛事里获取到的eventId用于LoginV2 API的参数，以定向玩家到对应的赛事页面。

**Endpoint 端点:**

| Name 名称 | Value 设置值 | Description 描述  |
| ---  | ---  | ---   |
| URL  | `/v1/hot-events` |   |
| Method  | `GET` | |
 
**Parameters 参数**

| Name 名称 | Type <br/> 类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | ---  | ---  | ---  | ---  |
| `userCode`  | Header | String (required必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 这是在 Step 2里获取的agent code,例如：CO1AP1 |
| `locale` 区域设置 | Query | String (optional非必需项) | Supported locales based on brand’s available languages. 在基于现有品牌的语言下，列出所支持区域 |  See Locale (Language) in the Data-format. 详见数据格式中的区域代码（语言）。|
| `oddsFormat` 赔率格式 | Query | String (optional 非必需项) | List supported oddsFormat: AM, EU, HK, ID, MY 列出所支持赔率格式 | See Odds Format in the Data-format. 详见数据格式中的赔率格式。 |
| `sports` | Query | String(required必需项) | A comma-separated list of sport names. 用逗号分隔的体育名称列表 |  See Sport in the Data-format. 详见数据格式中的体育项目。|


*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;    
import java.util.HashMap;    
import java.util.Map;    
    
private static void getHotEvents() throws IOException {
    Map params = new HashMap();
    params.put("sports", "soccer");
    params.put("locale", "en");
    params.put("oddsFormat", "EU");
    Map headers = new HashMap();    
    headers.put("userCode", " Q231");    
      
    String url = "http://apidomain.com/b2b/v1/hot-events";    
    String result = HttpUtils.get(url, "", params, headers);    
    System.out.println(result);    
}
```

*Sample code (C#) 示例代码（C#）*

```csharp
using System;    
using System.Net.Http;    
using System.Collections.Generic;    
using System.Threading.Tasks;    
    
namespace ChangeStatusForDepositWithdraw    
{    
    class Program    
    {    
        static void Main(string[] args)    
        {    
         Dictionary<string, string> parameters = new Dictionary<string, string>();
         parameters.Add("sports", "soccer");     
         parameters.Add("locale", "en");
         parameters.Add("oddsFormat", "EU");     
         Dictionary<string, string> headers = new Dictionary<string, string>();    
         headers.Add("userCode","Q231");    
         Console.WriteLine(HttpUtils.GetRequest("http://apidomain.com/b2b/v1/hot-events",
             parameters, headers).Result);    
         Console.ReadKey();    
        }    
    }    
}
```

**Response OK 回应OK**

```js
[{  
    "id": 29,  
    "name": "Soccer",  
    "leagues": [{  
            "id": 1728,  
            "name": "Sweden - Allsvenskan",  
            "events": [{  
                    "id": 1000605833,  
                    "home": "Djurgardens IF",  
                    "away": "Malmo FF",  
                    "starts": "2019-07-14T15:30:00Z",  
                    "spreads": [{  
                            "hdp": 0,  
                            "home": -116,  
                            "away": -102  
                        }, {  
                            "hdp": 0.5,  
                            "home": -222,  
                            "away": 177  
                        }  
                    ],  
                    "moneyline": {  
                        "home": 165,  
                        "away": 181,  
                        "draw": 231  
                    },  
                    "totals": [{  
                            "points": 2.25,  
                            "over": -114,  
                            "under": -105  
                        }, {  
                            "points": 1.75,  
                            "over": -230,  
                            "under": 179  
                        }  
                    ]  
                }  
            ]  
        }  
    ]  
}]
```

## 4. Screens and Workflows 截图和工作流程 <a name="4-screens-and-workflows"></a>

This section shows basic workflows for each of the API functions.

请参阅每个API函数的基本工作流程。

![Workflow](./../res/workflow.jpg)

## 5. Appendix 附录 <a name="5-appendix"></a>

### 5.1. View 界面 <a name="51-view"></a>
| View Code 界面代码 | Description 描述 |
| --- | ---  |
| ASIA | Asia View 亚洲界面 |
| EURO | Europe View 欧洲界面 |
| ESPORTS-HUB | Esports View AP 电竞 |
| COMPACT | New Asian View 新亚洲界面 |

### 5.2. Game Name 游戏名称 <a name="52-gamename"></a>
| Game Name 游戏名称|
| --- |
| csgo |
| cs2 |
| dota-2 |
| league-of-legends |
| age-of-empires |
| king-of-glory |
| mobile-legends |
| pubg |
| rainbow-six |
| starcraft-2 |
| valorant |
| wild-rift |
| world-of-warcraft |
| street-fighter |
| pubg-mobile |
| rocket-league |
| arena-of-valor |
| warcraft-3 |
| league-of-legends-wild-rift |
| crossfire |
| overwatch |
| hearthstone |
| team-fortress-2 |
| brawl-stars |
| call-of-duty |
| call-of-duty-mobile |
| free-fire |
| fifa |
| paladins |
| lcs-classic-showmatch |
| vainglory |
| tekken |
| flowfireleague-global-finals |
| rennsport |
| starcraft-brood-war |
| halo |
| super-smash-bros |
| moon-studio-carnival-cup-sea-qualifier |
| madden |
| quake |
| clash-royale |
| long-description-csgo |
| ragnarok |
| enascar |
| magic |
| mel-premiership-last-chance-qualifier |
| nba2k |
| bga |
| honor-of-kings |
| pokemon-unite |
| apex-legends |
| naraka-bladepoint |
| pubg-global-invitationals |
| peacekeeper-elite |
| formula-1 |
| heroes-of-the-storm |
| d2-gamwiba |
| magic-arena |
| stayhome-challenge |
| dragon-ball-fighterz |
| teamfight-tactics |
| fortnite |
| dcl-the-game |
| brawhalla |
| moon-studio-carnival-cup |
| shadowverse |
| cs-val |
| iracing |
| smite |
| artifact |
| osu |
| eboxing |
| overwatch-2 |
| cs-cbc20rsoq |
| esoccer-la-liga-santander-challenge-18-min |
| moon-studio-carnival-cup-cn-qualifier |
| esports-beta |
| esl-challenger-katowice-eu-qualifier |
| pro-evolution-soccer |
| ecricket |

## 6. Code Example 不同代码示例 <a name="6-code-example"></a>

1. [Java Code for HttpUtils 用于HttpUtils的Java代码](./../codes/HttpUtils.java)

2. [Java Code to verify Signature 用于验证签名的Java代码](./../codes/SignatureVerification.java)

3. [C# Code to verify Signature 用于验证签名的C#代码](./../codes/SignatureVerification.cs)

4. [PHP Code to verify Signature 用于验证签名的PHP代码](./../codes/SignatureVerification.php)

## 7. References 参考资料<a name="7-references"></a>

1. [Data Format 数据格式](./data-format.md)

