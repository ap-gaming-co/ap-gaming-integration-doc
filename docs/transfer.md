
# Table Contents 目录
- [Table Contents 目录](#table-contents)
- [Transfer Wallet 转账钱包](#transfer-wallet)
    - [1. API Functions API 功能](#1-api-functions)
        - [1.1. FP005 – Deposit 存款](#11-fp005-deposit)
        - [1.2.	FP006 – Withdraw 提款](#12-fp006-withdraw)
        - [1.3. FR007 – Transactions 交易](#13-fr007-transactions)
        - [1.4. FR008 – Check Status for Deposit/Withdraw 查询存取款状态](#14-fr008-check-status-for-deposit-withdraw)
  
# Transfer Wallet 转账钱包 <a name="transfer-wallet"></a>

## 1. API Functions API 功能 <a name="1-api-functions"></a>

### 1.1. FP005 – Deposit 存款 <a name="11-fp005-deposit"></a>

Deposit for player. 用户存款

**Endpoint 端点:**

| Name 名称 | Value 设置值 | Description 描述 |
| ---  | ---  | ---  |
| URL  | `/player/deposit`  |   |
| Method  | `GET`/`POST` | For POST method, it is recommended to send parameters as a  JSON object in the request body.<br> 对于 POST 方法，建议在请求正文中以 JSON 对象的形式发送参数。  |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| | |

**Parameters 参数:**

| Name 名称 | Type 类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required 必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| `token` |   Header   | String (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| `userCode`  |   Query   | String (required 必需项)   |   | This is the user code / loginID of the player. E.g: `PA10000000` 此为玩家登录名/用户名，例如`PA10000000` |
| `amount`  |   Query   | Decimal(10, 2) (required 必需项)  | Value  > 0 <br> 设置值>0 |   |
| `transactionId` |   Query   | String(50) (optional 非必需项) | Value > 0 <br> 设置值>0 | The transactionId can be used to check a transaction’s status. It is a unique ID. 用于检查交易状态的交易ID |
||&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||||

Sample code (java) - See HttpUtils class at Appendix
示例代码（java）– 请参阅附录里的 HttpUtils class

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void deposit() throws IOException {  
    Map params = new HashMap();  
    params.put("userCode", "PA10000000");  
    params.put("amount", 10);  
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth/\
            jbR/qgUcpi2wHc62Tw==");  
          
    String url = "http://apidomain.com/b2b/player/deposit";  
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
  
namespace Deposit  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("userCode", "PA10000000");   
            parameters.Add("amount", "10");   
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0+efzoMCb3i\
                    +PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.PostRequest("http://apidomain.com/b2b/player/deposit", 
                    parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

**Response 反应:**

Successful response will return JSON format. <br>
成功响应数据将返回JSON格式

```js
{   
  'userCode': 'PA10000000',     // string   
  'loginId': 'PA1000',     // string   
  'availableBalance': 1010.00,   // decimal(after deposit)   
  'amount': 10.00      // decimal   
}
```

### 1.2. FP006 – Withdraw 提款 <a name="12-fp006-withdraw"></a>

Withdraw for player.<br>
用户提款

**Endpoint 端点:**

| Name 名称 | Value 设置值 | Description 描述 |
| ---  | ---  | ---   |
| URL  | `/player/withdraw`  |   |
| Method  | `GET`/`POST` | For POST method, it is recommended to send parameters as a JSON object in the request body. <br> 对于 POST 方法，建议在请求正文中以 JSON 对象的形式发送参数。 |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| | |


**Parameters 参数:**

| Name 名称 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | ---  | ---  | ---  |
| userCode  | String (required 必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 此为在第二步骤获取的代理编号，例如，CO1AP1 |
| token | String (required 必需项) | Token is available for 15 minutes after creation. 令牌在创建之后的15分钟内有效 |  |
| userCode  | String (required必需项) |  | This is the user code / loginID of the player. E.g: PA10000000 此为玩家登录名/用户名，例如PA10000000 |
| amount  | Decimal(10, 2) (required必需项)  | Value > 0 <br> 设置值>0 |   |
| transactionId | String(50) (optional非必需项) | Value > 0<br> 设置值>0 | The transactionId can be used to check a transaction’s status. It is a unique ID. 用于检查交易状态的交易ID |

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void withdraw() throws IOException {  
    Map params = new HashMap();  
    params.put("userCode", "PA10000000");  
    params.put("amount", 10);  
    Map headers = new HashMap();  
    headers.put("userCode", "CO1AP1");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepa\
            XQivCIVpsDlth/jbR/qgUcpi2wHc62Tw==");  
          
    String url = "http://apidomain.com/b2b/player/withdraw";  
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
  
namespace Withdraw  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("loginId", "PA10000000");   
            parameters.Add("amount", "10");   
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","CO1AP1");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0\
                    +efzoMCb3i+PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.PostRequest("http://apidomain.com/b2b/player/withdraw", 
                    parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

**Response 反应:**

Successful response will return JSON format.<br>
成功响应数据将返回JSON格式

```js 
{   
  'userCode': 'PA10000000',     // string   
  'loginId': 'PA1000',     // string   
  'availableBalance': 1010.00,   // decimal(after withdrawal)   
  'amount': 10.00      // decimal   
}        
```

### 1.3. FR007 – Transactions 交易 <a name="13-fr007-transactions"></a>

This service will return Deposit/Withdrawal transactions made by players.<br>
这项服务将获得玩家在B2B Agent里做出的存取款交易

**Endpoint 端点:**

| Name 名称 | Value 设置值 | Description 描述 |
| --- | ---  | ---   |
| URL  | `/report/transactions` |   |
| Method  | `GET` | |
 
**Parameters 参数:**

| Name 名称 | Type 类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required 必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 这是在 Step 2里获取的agent code,例如：CO1AP1 |
| `token` | Header | String (required必需项) | Token is available for 15 minutes after creation. Token令牌在创建之后的15分钟内有效 |  |
| `dateFrom` | Query | Date (optional 非必需项)  | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 创建时间格式年-月-日-时-分-秒 GMT-4 | Example例如: 2016-10-15 23:59:59   |
| `dateTo`  | Query | Date (optional 非必需项)  | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4创建时间格式年-月-日-时-分-秒 GMT-4 | Example例如: 2016-10-16 23:59:59   |
| `transferType` | Query | String(optional 非必需项) | ALL DEPOSIT WITHDRAWAL 所有存取款 (default默认: ALL) | Indicates the transfer type to return. 注明转账类型来获取 |
| `userCode` | Query | String (optional 非必需项)  |  | This is the user code / loginID of the player. E.g: PA10000000. 这是玩家的用户名/登录名 |
||&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||||

**Note 注意:**

No date range specified如没有设定时间范围: System will return all transactions to the present time. 系统将回应直至当前的所有交易

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void getAnnouncements() throws IOException {  
    Map params = new HashMap();  
    params.put("dateFrom", "2017-04-24 02:10:12");    
    Map headers = new HashMap();  
    headers.put("userCode", " Q231");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth/jbR\
        /qgUcpi2wHc62Tw==");  
      
    String url = "http://apidomain.com/b2b/report/transactions";  
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
  
namespace Transactions  
{  
    class Program  
    {  
        static void Main(string[] args)  
        {  
            Dictionary<string, string> parameters = new Dictionary<string, string>();  
            parameters.Add("dateFrom", "2017-04-24 02:10:12");  
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","Q231");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0\
                +efzoMCb3i+PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.GetRequest("http://apidomain.com/b2b/report/transactions", 
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

**Response OK 返回OK:**

```js
[  
  {  
    "agentCode": "Q231",  
    "transferType": "DEPOSIT",  
    "amount": 1,  
    "userCode": "Q23100000A",  
    "loginId": "Q23100000A",  
    "remarks": "Deposit to Q23100000A",  
    "transferDate": "2017-04-24 02:10:12"  
  },  
  {  
    "agentCode": "Q231",  
    "transferType": "WITHDRAWAL",  
    "amount": 1,  
    "userCode": "Q23100000A",  
    "loginId": "Q23100000A",  
    "remarks": "Withdrawal from Q23100000A",  
    "transferDate": "2017-04-24 02:13:26"  
  },  
  {  
    "agentCode": "Q231",  
    "transferType": "DEPOSIT",  
    "amount": 1000,  
    "userCode": "Q231000000",  
    "loginId": "Q231000000",  
    "remarks": "Deposit to Q231000000",  
    "transferDate": "2017-05-03 00:38:39"  
  }    
] 
```

### 1.4. FR008 – Check Status for Deposit/Withdraw 查询存取款状态 <a name="14-fr008-check-status-for-deposit-withdraw"></a>

This service will return the status of a Deposit/Withdrawal transaction made by players.<br>
这项服务将获得玩家在B2B Agent里的存取款交易状态

**Endpoint 端点:**

| Name 名称 | Value 设置值 | Description 描述 |
| ---  | ---  | ---   |
| URL  | `/player/depositwithdraw/status` |   |
| Method  | `GET`, `POST` | For POST method, it is recommended to send parameters as a JSON object in the request body. <br> 对于 POST 方法，建议在请求正文中以 JSON 对象的形式发送参数。 |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|||

**Parameters 参数:**

| Name 名称 | Type 类型 | Value 设置值 | Validation 验证 | Description 描述 |
| ---  | ---  | ---  | ---  | ---  |
| `userCode`  | Header  | String<br/> (required必需项)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. 这是在 Step 2里获取的agent code,例如：CO1AP1 |
| `token` | Header  | String <br/> (required必需项) | Token is available for 15 minutes after creation. Token令牌在创建之后的15分钟内有效 |  |
| `transactionId` | Query  | String(50)<br/>(required必需项)  | Value > 0 <br> 设置值>0| Deposit/withdrawal transactionId您在调取存取款数据时发送的交易ID Example例如: 12345678 |
||&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|||

*Sample code (java) - See HttpUtils class at Appendix*
*示例代码（java）– 请参阅附录里的 HttpUtils class*

```java
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
  
private static void getStatus() throws IOException {  
    Map params = new HashMap();  
    params.put("transactionId", "12345678");    
    Map headers = new HashMap();  
    headers.put("userCode", " Q231");  
    headers.put("token", "gvbLZb70DhMNXMLw3egvktPT3sfDWnDC5QI97MXHqK9FCFO1n6oepaXQivCIVpsDlth/\
        jbR/qgUcpi2wHc62Tw==");  
      
    String url = "http://apidomain.com/b2b/player/depositwithdraw/status";  
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
            parameters.Add("transactionId", "12345678");  
  
            Dictionary<string, string> headers = new Dictionary<string, string>();  
            headers.Add("userCode","Q231");  
            headers.Add("token","DIwYQJZIYiosWrbXQe+TFdyMk6POZvbcM1KjxxQObZEn0\
                +efzoMCb3i+PWr1ZFuj0UciR8w+qqo1M2hJ965Y9w==");  
  
            Console.WriteLine(HttpUtils.GetRequest("http://apidomain.com/b2b/player/depositwithdraw/status", 
                parameters, headers).Result);  
            Console.ReadKey();  
        }  
    }  
}  
```

**Response OK 回应OK:**

```js
{  
    "status": "SUCCESS",  
    "transferDate": "2018-11-15 23:18:34",  
    "transferType": "DEPOSIT",  
    "amount": 0.2,  
    "userCode": "Q231000000"  
}
```

```js
{  
    "status": "FAILED",  
    "transferDate": "2018-11-14 20:15:20",  
    "transferType": "WITHDRAW",  
    "amount": 5,  
    "userCode": "Q231000000"  
}  
```

```js
{  
    "status": "NOT_EXISTS"  
}
```
