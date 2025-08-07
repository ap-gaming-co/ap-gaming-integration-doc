
# Table Contents
- [Table Contents](#table-contents)
- [Transfer Wallet](#transfer-wallet)
    - [1. API Functions API](#1-api-functions)
        - [1.1. FP005 – Deposit](#11-fp005-deposit)
        - [1.2.	FP006 – Withdraw](#12-fp006-withdraw)
        - [1.3. FR007 – Transactions](#13-fr007-transactions)
        - [1.4. FR008 – Check Status for Deposit/Withdraw](#14-fr008-check-status-for-deposit-withdraw)
  
# Transfer Wallet<a name="transfer-wallet"></a>

## 1. API Functions API<a name="1-api-functions"></a>

### 1.1. FP005 – Deposit<a name="11-fp005-deposit"></a>

Deposit for player.

**Endpoint:**

| Name | Value | Description |
| ---  | ---  | ---  |
| URL  | `/player/deposit`  |   |
| Method  | `GET`/`POST` | For POST method, it is recommended to send parameters as a  JSON object in the request body. |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| | |

**Parameters:**

| Name | Type | Value | Validation | Description |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. |
| `token` |   Header   | String (required) | Token is available for 15 minutes after creation. |
| `userCode`  |   Query   | String (required)   | This is the user code / loginID of the player. E.g: `PA10000000`|
| `amount`  |   Query   | Decimal (10, 2) (required)  | Value  > 0 |
| `transactionId` |   Query   | String (50) (optional) | Value > 0 | The transactionId can be used to check a transaction’s status. It is a unique ID. |
||&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||||

Sample code (java) - See HttpUtils class at Appendix

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

*Sample code (C#)*

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

**Response:**

Successful response will return JSON format. <br>

```js
{   
  'userCode': 'PA10000000',     // string   
  'loginId': 'PA1000',     // string   
  'availableBalance': 1010.00,   // decimal(after deposit)   
  'amount': 10.00      // decimal   
}
```

### 1.2. FP006 – Withdraw <a name="12-fp006-withdraw"></a>

Withdraw for player.<br>

**Endpoint:**

| Name | Value | Description |
| ---  | ---  | ---   |
| URL  | `/player/withdraw`  |   |
| Method  | `GET`/`POST` | For POST method, it is recommended to send parameters as a JSON object in the request body.|
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;| | |


**Parameters:**

| Name | Value | Validation | Description |
| ---  | ---  | ---  | ---  |
| userCode  | String (required)  | This is the agent code obtained in step 2. E.g: CO1AP1. |
| token | String (required) | Token is available for 15 minutes after creation. |
| userCode  | String (required) | This is the user code / loginID of the player. E.g: PA10000000 |
| amount  | Decimal (10, 2) (required) | Value > 0 |
| transactionId | String (50) (optional) | Value > 0 | The transactionId can be used to check a transaction’s status. It is a unique ID. |

*Sample code (java) - See HttpUtils class at Appendix*

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

*Sample code (C#)*

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

**Response:**

Successful response will return JSON format.<br>

```js 
{   
  'userCode': 'PA10000000',     // string   
  'loginId': 'PA1000',     // string   
  'availableBalance': 1010.00,   // decimal(after withdrawal)   
  'amount': 10.00      // decimal   
}        
```

### 1.3. FR007 – Transactions <a name="13-fr007-transactions"></a>

This service will return Deposit/Withdrawal transactions made by players.<br>

**Endpoint:**

| Name | Value | Description |
| --- | ---  | ---   |
| URL  | `/report/transactions` |   |
| Method  | `GET` | |
 
**Parameters:**

| Name | Type | Value | Validation | Description |
| ---  | --- | ---  | ---  | ---  |
| `userCode`  | Header | String (required) | This is the agent code obtained in step 2. E.g: CO1AP1. |
| `token` | Header | String (required) | Token is available for 15 minutes after creation. |
| `dateFrom` | Query | Date (optional) | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 | Example: 2016-10-15 23:59:59   |
| `dateTo`  | Query | Date (optional)  | Created Date Time format yyyy-MM-dd HH:mm:ss GMT-4 | Example: 2016-10-16 23:59:59   |
| `transferType` | Query | String (optional) | ALL DEPOSIT WITHDRAWAL (default: ALL) | Indicates the transfer type to return. |
| `userCode` | Query | String (optional) | This is the user code / loginID of the player. E.g: PA10000000.|
||&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||||

**Note:**

No date range specified: System will return all transactions to the present time.

*Sample code (java) - See HttpUtils class at Appendix*

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

*Sample code (C#)*

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

**Response OK:**

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

### 1.4. FR008 – Check Status for Deposit/Withdraw <a name="14-fr008-check-status-for-deposit-withdraw"></a>

This service will return the status of a Deposit/Withdrawal transaction made by players.<br>

**Endpoint:**

| Name | Value | Description |
| ---  | ---  | ---   |
| URL  | `/player/depositwithdraw/status` |   |
| Method  | `GET`, `POST` | For POST method, it is recommended to send parameters as a JSON object in the request body. |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|||

**Parameters:**

| Name | Type | Value | Validation | Description |
| ---  | ---  | ---  | ---  | ---  |
| `userCode`  | Header  | String<br/> (required)  |  | This is the agent code obtained in step 2. E.g: CO1AP1. |
| `token` | Header  | String <br/> (required) | Token is available for 15 minutes after creation. |
| `transactionId` | Query  | String(50)<br/>(required)  | Value > 0 | Deposit/withdrawal transactionId Example: 12345678 |
||&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|||

*Sample code (java) - See HttpUtils class at Appendix*

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

*Sample code (C#)*

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

**Response OK:**

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
