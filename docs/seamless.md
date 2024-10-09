# Table Contents 目录

- [Table Contents 目录](#table-contents-%E7%9B%AE%E5%BD%95)
- [1. Seamless Wallet Overview 单一钱包概要](#1-seamless-wallet-overview-%E5%8D%95%E4%B8%80%E9%92%B1%E5%8C%85%E6%A6%82%E8%A6%81)
    - [1.1. Architecture Overview 架构概述](#11-architecture-overview-%E6%9E%B6%E6%9E%84%E6%A6%82%E8%BF%B0)
    - [1.2. Data Format 数据格式](#12-data-format-%E6%95%B0%E6%8D%AE%E6%A0%BC%E5%BC%8F)
        - [1.2.1. Common Data Format 通用数据格式](#121-common-data-format-%E9%80%9A%E7%94%A8%E6%95%B0%E6%8D%AE%E6%A0%BC%E5%BC%8F)
        - [1.2.2. Common Response Data Format 通用响应数据格式](#122-common-response-data-format-%E9%80%9A%E7%94%A8%E5%93%8D%E5%BA%94%E6%95%B0%E6%8D%AE%E6%A0%BC%E5%BC%8F)
- [2. Operator Wallet API Methods 运营商钱包的API方法](#2-operator-wallet-api-methods-%E8%BF%90%E8%90%A5%E5%95%86%E9%92%B1%E5%8C%85%E7%9A%84api%E6%96%B9%E6%B3%95)
    - [2.1. Ping 命令](#21-ping-%E5%91%BD%E4%BB%A4)
        - [2.1.1. Request Format 请求格式](#211-request-format-%E8%AF%B7%E6%B1%82%E6%A0%BC%E5%BC%8F)
        - [2.1.2. Response Format 响应格式](#212-response-format-%E5%93%8D%E5%BA%94%E6%A0%BC%E5%BC%8F)
        - [2.1.3. Possible Error Code 可能出现的错误代码](#213-possible-error-code-%E5%8F%AF%E8%83%BD%E5%87%BA%E7%8E%B0%E7%9A%84%E9%94%99%E8%AF%AF%E4%BB%A3%E7%A0%81)
    - [2.2. Seamless Wagering 无缝下注](#22-seamless-wagering-%E6%97%A0%E7%BC%9D%E4%B8%8B%E6%B3%A8)
        - [2.2.1. BETTED Action 已下注](#221-betted-action-%E5%B7%B2%E4%B8%8B%E6%B3%A8)
        - [2.2.2. ACCEPTED Action 已接受](#222-accepted-action-%E5%B7%B2%E6%8E%A5%E5%8F%97)
        - [2.2.3. SETTLED Action 已结算](#223-settled-action-%E5%B7%B2%E7%BB%93%E7%AE%97)
        - [2.2.4. REJECTED Action 已被拒](#224-rejected-action-%E5%B7%B2%E8%A2%AB%E6%8B%92)
        - [2.2.5. CANCELLED Action 已取消](#225-cancelled-action-%E5%B7%B2%E5%8F%96%E6%B6%88)
        - [2.2.6. ROLLBACKED Actions 已返回](#226-rollbacked-actions-%E5%B7%B2%E8%BF%94%E5%9B%9E)
        - [2.2.7. UNSETTLED Action 取消结算](#227-unsettled-action-%E5%8F%96%E6%B6%88%E7%BB%93%E7%AE%97)
    - [2.3. Appendix 附录](#23-appendix-%E9%99%84%E5%BD%95)
        - [2.3.1. JSON Data Request Description of Wagering API 投注API的JSON数据请求描述](#231-json-data-request-description-of-wagering-api-%E6%8A%95%E6%B3%A8API%E7%9A%84JSON%E6%95%B0%E6%8D%AE%E8%AF%B7%E6%B1%82%E6%8F%8F%E8%BF%B0)
        - [2.3.2. JSON Data Response Description of Wagering API 投注API的JSON数据回应描述](#232-json-data-response-description-of-wagering-api-%E6%8A%95%E6%B3%A8API%E7%9A%84JSON%E6%95%B0%E6%8D%AE%E5%9B%9E%E5%BA%94%E6%8F%8F%E8%BF%B0)
        - [2.3.3. Action Types 操作类型](#233-action-types-%E6%93%8D%E4%BD%9C%E7%B1%BB%E5%9E%8B)
        - [2.3.4. Transaction Status 交易状态](#234-transaction-status-%E4%BA%A4%E6%98%93%E7%8A%B6%E6%80%81)
        - [2.3.5. Error Response Code 响应错误代码](#235-error-response-code-%E5%93%8D%E5%BA%94%E9%94%99%E8%AF%AF%E4%BB%A3%E7%A0%81)
        - [2.3.6. Action Response Code 操作响应代码](#236-action-response-code-%E6%93%8D%E4%BD%9C%E5%93%8D%E5%BA%94%E4%BB%A3%E7%A0%81)
          
# 1. Seamless Wallet Overview 单一钱包概要

The Sportsbook Platform needs to communicate with the Operator Wallet for the purposes of seamlessly debiting and crediting funds from the Operator Wallet when bets are placed and settled.

当注单生成和结算时，体育平台需要与运营商的钱包通讯以达到从运营商钱包里无缝存取相关款项的目的。

## 1.1. Architecture Overview 架构概述

The SB Seamless Wallet API has been designed using a lightweight REST style web service. All requests/responses use JSON format to transfer. Thus, the header of a request/response must have a parameter `ContentType: application/json`.

单一钱包API的设计使用了轻量REST的架构风格来提供网络服务。所有请求和响应都以JSON的格式传输，因此每一项请求和响应的的报头都会有一个`ContentType: application/json`. 的参数 。

## 1.2. Data Format 数据格式
### 1.2.1. Common Data Format 通用数据格式

All requests from the Sportsbook Platform to Operator Wallet API have basic information in POST request data (except [Ping API](#21-ping-%E5%91%BD%E4%BB%A4). Please refer to API definition).

从体育平台到运营商钱包API的所有请求在POST请求数据里都有基本信息(除了Ping API, 请参照API定义)。

```json
{
    // other property of POST data.
    "Timestamp": "2018-01-15T15:20:14",
    "Signature": "aTFzUoIUD7Tpclf9XQ/+kuyEkNRJCUMK12XgQoVmhKuy6HGle5pj1sdZJJ\
        +FSu23MZhy+ppH02fe3kDnB5CgMw=="
}
```
| Parameter 参数 | Type 类型 | E.g. Value 设置值 | Description 描述 |
| --- | --- | --- | --- |
| `Timestamp` | `Date` | 2018-01-15T15:20:14 |  |
| `Signature` | `String` |  | The signature was generated from [Authentication](/docs/shared.md#21-authentication-api-requirements) <br>此签名由认证生成|

### 1.2.2. Common Response Data Format 通用响应数据格式

Data format for most requests. 大多数请求的数据格式

```json
{
    "Result": {
         //... Result Object
    },
    "ErrorCode": 0,
    "Timestamp": "2018-01-15T15:20:14"
}
```


# 2. Operator Wallet API Methods 运营商钱包的API方法

The Operator Wallet API includes the following API methods:

运营商钱包的API包括以下API方法：

## 2.1. Ping 命令

This method is used to query the Operator Wallet API to determine if the API is available. If no response is received e.g. Timeout, the Operator Wallet API will also be assumed to be unavailable.

此方法被用来查询运营商钱包的API是否可被调取。如果没有响应，例如超时，运营商钱包的API将会被假定为无法调取。

### 2.1.1. Request Format 请求格式

**Endpoint 端点**

The request will be sent to following URI:

请求将被传至以下URI

```yml
URI: /ping
Method: POST
```

**POST Parameters POST参数**

The API method will send post JSON in the following format:

API方法将按以下格式传送 post JSON

```js
{    
    "Timestamp": "2018-01-15T15:20:14" // (Date)
}
```

### 2.1.2. Response Format 响应格式

The API will return JSON in the following format:

API将按以下格式返回JSON

```js
{
    "Result": {
        "Available": true   // (Boolean) wallet is available. Type: Boolean
    },
    "ErrorCode": 0,     // Refer to Possible Error Code
    "Timestamp": "2018-01-15T15:20:14"
}
```

### 2.1.3. Possible Error Code 可能出现的错误代码

| Code 代码 | Reason 原因 |
| --- | --- |
| 0 | Success 成功 |
| -1 | Unknown Error 未知错误An unknown error has occurred during the API call.在调取API过程中出现未知错误 |
| -6 | API Authentication failed API认证失败This error will be returned if the Signature is invalid or not found.如果签名失效或不存在，此错误将会被返回 |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||


## 2.2. Seamless Wagering 无缝下注

Seamless Wagering methods help to update the balance in the Operator wallet's account in real time. This action occurs when a player places a bet, a bet is accepted, settled, or rejected. These are processes that affect the balance in the Operator wallet.

无缝下注的方法将有助于实时更新运营商钱包里的账户余额。这项操作将在玩家下注、注单被接受、被结算，被取消等时候发生，这些都是会影响运营商钱包余额的步骤。

```yml
URI: /{agentcode}/wagering/usercode/{usercode}/request/{requestid}
Method: POST
```

| Parameter 参数 | E.g. Value 设置值 | Description 描述 |
| --- | --- | --- |
| `agentcode` | `AG001` | Agent code is provided by Sportsbook Platform. 体育平台提供的代理号 |
| `usercode` | `PIN00115` | User Code is created in Create Player API. 呼叫创建用户API生成的用户名 |
| `requestid` | `81347c9e-280d-40d6-8349-29dca7ea6bdc` | Request Id is unique in the betting platform. It is formatted based on UUID (8-4-4-4-12).Request ID在投注系统里是独一无二的。其格式是按照UUID (8-4-4-4-12) |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||

There are 7 Action Types for a wager: `BETTED`, `ACCEPTED`, `REJECTED`, `SETTLED`, `CANCELLED`, `ROLLBACKED` and `UNSETTLED`.

我们的每个注单会有7种操作类型，即：已下注、已接受、已被拒、已结算、已取消、已返回以及取消结算。

Sequence Interaction 序列交互

![Sequence Interaction](./../res/figure-1-sequence-interaction-english-chinese.png?raw=true)
 
*Figure 1 – The sequence shows the interaction between the Operator and the Sportbook Platform.* <br>
*图 1 – 该序列显示了运营商和体育平台之间的交互。*

**Bet Placement Process 下注处理步骤**:

<table>
  <tr style="background-color:#e0dcdc;">
    <th rowspan="2">Actions 动作</th>
    <th colspan="4">Bet Placement Process 下注过程</th>
    <th colspan="3">Settlement Process 结算过程</th>
  </tr>
  <tr style="background-color:#e0dcdc;">
    <td>BETTED 已下注</td>
    <td>ACCEPTED 已接受</td>
    <td>ROLLBACKED 已返回</td>
    <td>REJECTED 已被拒</td>
    <td>SETTLED 已结算</td>
    <td>CANCELLED 已取消</td>
    <td>UNSETTLED 未结算</td>
  </tr>
    <td>Description 描述</td>
    <td>Player is placing a bet<br/>玩家正在下注</td>
    <td>Bet has been accepted<br/>注单已被接受</td>
    <td>Error occurred when placing bet<br/>下注时出现错误</td>
    <td>Live bet has been rejected<br/>即时注单被拒绝</td>
    <td>Bet has been settled<br/>注单已结算</td>
    <td>Bet has been cancelled<br/>注单已被取消</td>
    <td>Bet has been unsettled and to be resettled<br/>注单未结算，将被重新结算</td>
  <tr>
  </tr>
    <td>Wager Status 注单状态</td>
    <td>PENDING 待确认</td>
    <td>OPEN 开放</td>
    <td>ERROR (wager will be deleted)<br/>报错（注单将被删除）</td>
    <td>CANCELLED (Rejected)<br/>注单取消（被拒绝）</td>
    <td>SETTLED 已结算</td>
    <td>CANCELLED (Void)<br/>已取消（注单无效）</td>
    <td>OPEN 开放</td>
  <tr>
  </tr>
    <td>Affect Balance 影响余额</td>
    <td>- available balance<br/>余额减少</td>
    <td>+ available balance (see note 1)<br/>余额增加</td>
    <td>+ available balance<br/>余额增加</td>
    <td>+ available balance<br/>余额增加</td>
    <td>+/- available balance<br/>余额增减取决于注单结果</td>
    <td>+ available balance<br/>余额增加</td>
    <td>+/- available balance<br/>余额增减 取决于注单结果</td>
  <tr>
  </tr>
</table>

Note 1: If the bet was accepted with better odds and the player chose Stake as “To Win” amount, the difference must be credited back to the player account. See ACCEPTED Action section.

注1：如果投注以更好的赔率被接受，并且玩家选择本金为"获胜"金额，则差额必须退回玩家帐户。 请参阅"已接受"部分。

![Wager State Diagram](../res/wager-state-diagram-english-chinese.png?raw=true)

**Unsettled Action 取消结算** 

A bet may be **Unsettled** when the outcome of the bet needs to be changed.<br/>
当注单结果需要改变时，投注可能处于取消结算状态。 

A bet can only be Unsettled after it has been **Settled** or **Cancelled**.<br/>
注单仅有在已结算或已取消后才能回到'取消结算'状态 。 

**Handling Settled and Unsettled Actions 根据已结算和取消结算的处理**
 
The action to take will depend on the current status of the bet, the status in the action, and the action ID. Refer to the table below:<br/>
要采取的步骤将取决于注单的当前状态、操作的状态以及操作ID。参考下表：

| Status Received<br/>已收到状态 | Current Status<br/>当前状态 | Received Action ID is Higher<br/>收到的Action ID较大 | Action To Take<br/>采取的行动 |
| --- | --- | --- | --- |
| SETTLED 已结算 | ACCEPTED 已接受 | Yes 是 | Settle the bet 结算注单 |
| SETTLED 已结算 | UNSETTLED 未结算 | No 否 | Ignore action 可忽略 |
| SETTLED 已结算 | UNSETTLED 未结算 | Yes 是 | Settle the bet 结算注单 |
| SETTLED 已结算 | SETTLED 已结算 | No 否 | Ignore action 可忽略 |
| SETTLED 已结算 | SETTLED 已结算 | Yes 是 | Unsettle the bet, then settle the bet 取消结算後结算注单 |
| UNSETTLED 未结算 | SETTLED 已结算 | No 否 | Ignore action 可忽略 |
| UNSETTLED 未结算 | SETTLED 已结算 | Yes 是 | Unsettle the bet 取消结算 |
| UNSETTLED 未结算 | UNSETTLED 未结算 | No 否 | Ignore action 可忽略 |
| UNSETTLED 未结算 | UNSETTLED 未结算 | Yes 是 | Unsettle the bet, then settle the bet 取消结算後结算注单 |

### 2.2.1. BETTED Action 已下注

When a player is placing a bet in the player site, the Sportsbook Platform sends **BETTED** action with wager information to the Operator to deduct funds from the player’s balance and to store the wager. The available Balance response is the balance after performing a transaction.

当玩家在网站下注，体育平台将执行已下注的操作并将注单信息一起发送给运营商以扣除玩家的相应金额并保存注单。响应的可用余额为交易完成之后的余额。

**Single Wager Type: POST Data for Request 单一注单：请求的POST数据**

```js
{
    "Timestamp": "2022-06-14T07:32:16",
    "Signature": "XKEa2UKfrWfVcDaIp/MDt62ujb8QkAx2Ja1AdkeIjcbeN65a5yzWojP4RBKxVLV9HOnEKiLYSbT0ssdc5KDVXQ==",
    "Actions": [
        {
            "Id": 1923899,
            "Name": "BETTED",
            "PlayerInfo": {
		"LoginId": "MPvZSDqM1685576929",
		"UserCode": "PXM130000D"
            },
            "Transaction": {
                "TransactionId": 1177217,
                "TransactionType": "DEBIT",
                "TransactionDate": "2022-06-14T07:32:16",
                "Amount": 100
            },
            "WagerInfo": {
                "WagerId": 46739150,
                "Type": "SINGLE",
                "BetType": 99,
                "Odds": 0.043,
                "OddsFormat": 2,
                "ToWin": 4.3,
                "ToRisk": 100,
                "Stake": 100,
                "Period": 0,
                "Selection": "Kanga 1, Gravitas 0",
                "EventId": 1554522772,
                "EventName": "Correct Score",
                "EventDateFm": "2022-06-14 07:15:00",
                "LeagueId": 212168,
                "SportId": 12,
                "Sport": "E Sports",
                "Inplay": true,
                "InPlayScore": "",
                "Handicap": 0.0,
                "SelectionType": "10",
                "LeagueName": "League of Legends - LCO",
                "ParentEventName": "Kanga-vs-Gravitas",
		"PlayerIPAddress": "10.10.12.8"
            }
        }
    ]
}
```

**Parlay & Teaser Wager Type: POST Data for Request 混合过关&变让分过关：请求的POST数据**

A Round Robin bet is an easy way to wager multiple parlays with a single bet. They make it easy for bettors to place parlay wagers that consist of 3-8 lines. A parlay without Round Robin can consist of up to 10 lines and 2-6 teams for a teaser. Bettors can cover their bases and wager all possible combinations by using a Round Robin and bet many parlays at once. The downside to these wagers is that gamblers bet too many legs or use too many selections in their parlay combinations. You can find round robin bets at just about every online sportsbook, but they are not often used by most sports gamblers.

轮询过关投注(Round Robin投注)是一种简单快捷地在同一次投注里投注多个过关注单的玩法。玩家可以同时选择多个过关组合选项，并在同一时间下注在3-8个赔率的排列组合上。过关（Parlay）投注：玩家可以选择2-10个赔率进行过关投注，而变让分过关盘（Teaser投注）可以在2-6支队伍上的排列组合中进行投注。玩家可以使用轮询过关投注一次性投注多张过关注单来覆盖以他们选择的赔率为基础的所有可能的组合，这些注单的缺点是玩家在过关组合中会产生过多的选项。您几乎可以在所有线上体育博彩中看到轮询投注，但是大多数玩家不会经常使用该功能。

Operators receive request BETTED action when the player places a bet. A Round Robin will be presented through RoundRobinOptions. Its value can be `Single`, `Parlay` (not a round robin. It is only normal parlay wager), `TwoLegRoundRobin`, `ThreeLegRoundRobin`, `FourLegRoundRobin`, `FiveLegRoundRobin`, `SixLegRoundRobin`, `SixLegRoundRobin`, `SevenLegRoundRobin`, `EightLegRoundRobin`.

当玩家投注轮询过关(Round Robin bet)时，运营商会收到BETTED 的请求。轮询过关会通过RoundRobinOptions来展示。它的值可以是`Single`, `Parlay` (此种属于普通过关注单，非轮询过关), `TwoLegRoundRobin`, `ThreeLegRoundRobin`, `FourLegRoundRobin`, `FiveLegRoundRobin`, `SixLegRoundRobin`, `SixLegRoundRobin`, `SevenLegRoundRobin`, `EightLegRoundRobin`.

The example table shows a combination of picks (events/legs) and round robin options:

我们将投注选项（赛事/投注项）以及轮询投注的选择列表示例如下：

*Table 1 - Combination of picks (events/legs) and round robin options*

| Picks <br/>(events/legs/bets)<br/>投注选择 <br/>（赛事/投注项） | Ways<br/>投注方法 | Number of Bets <br/>投注单数 |
| --- | --- | --- |
| 3 | 2 - TwoLegRoundRobin<br>2-两个选项的轮询过关投注 | 3 |
| 4 | 2 - TwoLegRoundRobin<br>2-两个选项的轮询过关投注 | 6 |
| 4 | 3 - ThreeLegRoundRobin<br>3-三个选项的轮询过关投注 | 4 |
| … | … | … |
| … | … | … |
| 8 | 2 - TwoLegRoundRobin<br>2-两个选项的轮询过关投注 | 28 |
| 8 | 3 - ThreeLegRoundRobin<br>3-三个选项的轮询过关投注 | 56 |
| 8 | 4 - FourLegRoundRobin<br>4-四个选项的轮询过关投注 | 70 |
| 8 | 5 - FiveLegRoundRobin<br>5-五个选项的轮询过关投注 | 56 |
| 8 | 6 - SixLegRoundRobin<br>6-六个选项的轮询过关投注 | 28 |

We send to operators 1 `BETTED` action when a player places a bet with a Round Robin Parlay. The wager in this action is *master wager*. Then we send 3 `ACCEPTED` action if player bet in 3 events (games, matches) and `RoundRobinOptions` is `TwoLegRoundRobin` (assuming that the player’s bet was accepted). Other actions are also the same (`ACCEPTED` action). The `WagerMasterId` property will used to group all wagers together.

当运营商1的玩家投注在轮询过关时，我们会发送 `BETTED` 讯息。该讯息中的注单为这个轮询过关投注里的总注单 *master wager*. 随后，如果玩家在这次投注中是投注在了三场赛事上，我们会发送3个 `ACCEPTED` 讯息以及`RoundRobinOptions` is `TwoLegRoundRobin` (前提是玩家的投注被接受了). 其他的投注也同样会发送 `ACCEPTED` 讯息. `WagerMasterId` 属性用于将此轮询过关里的所有注单组在一。.

Events of WagerInfo for Parlay / Teaser Wager will be presented in a list containing event names.

混合过关和变让分过关的注单赛事信息Events of WagerInfo将会以包含赛事名称的列表形式呈现。 

In `BETTED` action, we send the number of bets that will be generated using the `WagerNum` property in JSON request. When the bet is accepted, we will send the number of `ACCEPTED` actions equal to number in the `WagerNum` property. The same will happen for the next action type.

在已下注中，我们将发送於 JSON 请求中 `WagerNum` 生成的投注数量。 当投注被接受时，我们将发送等于 `WagerNum` 中数字的 `ACCEPTED` 数量。 下一个操作类型也以此類推。

```js
{
    "Timestamp": "2022-07-15T09:50:14",
    "Signature": "NsSP2DR6VC+IM6GYDs5qXHYZFiDixcap+WwKiVVQpWYHbDzdFT2o2AVk56Naiv6W5ohoupX0WAiG9mIUOtO3Nw==",
    "Actions": [
        {
            "Id": 1929876,
            "Name": "BETTED",
            "PlayerInfo": {
		"LoginId": "MPvZSDqM1685576929",
		"UserCode": "PXM130000D"
            },
            "Transaction": {
                "TransactionId": 1180518,
                "TransactionType": "DEBIT",
                "TransactionDate": "2022-07-15T09:50:14",
                "Amount": 33
            },
            "WagerInfo": {
                "WagerId": 47076606,
                "Type": "PARLAY",
                "BetType": 6,
                "Odds": -0.143,
                "OddsFormat": 4,
                "ToWin": "230.770",
                "ToRisk": "33.000",
                "Stake": "33.000",
		"PlayerIPAddress": "10.10.12.8",
                "Legs": [
                    {
			"LegId": "68bf2b8a-81a9-d9de-32f5-8c13dcc47ddc",
                        "SportId": 29,
                        "Sport": "Soccer",
                        "SportGroup": 0,
                        "League": "Canada - Premier League",
                        "BetType": 1,
                        "LeagueId": 205098,
                        "EventId": 1555400711,
                        "EventDateFm": "2022-07-15 19:30:00",
                        "SelectionType": 2,
                        "InplayScore": null,
                        "InPlay": false,
                        "Odds": 2.910,
                        "Handicap": 0.0,
                        "Period": 0,
                        "TeamType": 0,
                        "EventName": "York United FC-vs-Pacific FC",
                        "Selection": "Draw"
                    },
                    {
			"LegId": "a76c7bad-1ceb-9b9c-fbd4-235d8ab4f99f",
                        "SportId": 29,
                        "Sport": "Soccer",
                        "SportGroup": 0,
                        "League": "Club Friendlies",
                        "BetType": 2,
                        "LeagueId": 1863,
                        "EventId": 1555686630,
                        "EventDateFm": "2022-07-15 11:00:00",
                        "SelectionType": 1,
                        "InplayScore": null,
                        "InPlay": false,
                        "Odds": 0.666,
                        "Handicap": 0.25,
                        "Period": 0,
                        "TeamType": 0,
                        "EventName": "Istanbul Basaksehir FK-vs-Konyaspor Club",
                        "Selection": "Konyaspor Club"
                    },
                    {
			"LegId": "b0bbbc91-a8f8-4b37-b439-149060fcaa16",
                        "SportId": 29,
                        "Sport": "Soccer",
                        "SportGroup": 0,
                        "League": "Brazil - Serie B",
                        "BetType": 3,
                        "LeagueId": 1835,
                        "EventId": 1555400748,
                        "EventDateFm": "2022-07-15 18:00:00",
                        "SelectionType": 3,
                        "InplayScore": null,
                        "InPlay": false,
                        "Odds": 0.649,
                        "Handicap": 1.75,
                        "Period": 0,
                        "TeamType": 0,
                        "EventName": "Criciuma EC SC-vs-AA Ponte Preta SP",
                        "Selection": "Over"
                    }
                ],
                "WagerMasterId": 47076606,
                "WagerNum": 1,
                "RoundRobinOptions": [
                    "Parlay"
                ]
            }
        }
    ]
}
```

**Manual Wager Type: POST Data for Request 手动投注类型：发布请求数据**

```js
{
  "Timestamp": "2021-07-02T15:22:07",
  "Signature": "ADGNbaOMwu/lNxQTnpAZFlzsMK76mvl1JehKtC9lprVvpKkDGasdez1e2P2mSr8F0czOLf4Y2fedcbaw5YO7Iw==",
  "Actions": [
    {
      "Id": 15560892634072091,
      "Name": "BETTED",
      "ManualWager": true,
      "PlayerInfo": {
         "LoginId": "MPvZSDqM1685576929",
         "UserCode": "PXM130000D"
      },
      "Transaction": {
        "TransactionId": 15560892277229,
        "TransactionType": "DEBIT",
        "TransactionDate": "2021-06-30T02:04:26",
        "Amount": 642586
      },
      "WagerInfo": {
        "WagerId": 725462707,
        "Type": "single",
        "BetType": 8,
        "Odds": 9.084,
        "OddsFormat": 1,
        "ToWin": "5195307.000",
        "ToRisk": "642586.000",
	"Stake": "642586.000",
        "Period": 0,
        "Description": "Baseball - MLB\nMinnesota Twins vs Chicago White Sox - Over 8.5 @ -128 for Game\nArizona Diamondbacks vs St. Louis Cardinals - Over 8.5 @ -123 for Game\n\nBaseball - Korea Professional Baseball\nDoosan Bears vs Hanwha Eagles - Doosan Bears @ -162 for Game\nG2 Samsung Lions vs G2 SSG Landers - Over 8.5 @ -135 for Game\n\nOld ticket : Ref No: 00000000 / 11111111\nMember id : ABCXYZ",
	"PlayerIPAddress": "10.10.12.8",
	"OriginalWagerId": 725462706
      }
    }
  ]
}
```
**Response Data for Single, Parlay and Teaser, Manual cases.**

**单人、过关和预告、手动案例的响应数据**

```js
{
    "Result": {
        "UserCode": "S013000002",
        "AvailableBalance": 156.09999999999985,
        "Actions": [{
            "Id": 15560892634072091,
            "TransactionId": 15560892277229,
            "WagerId": 725462707,
            "ResponseCode": 0 // Refer to Action Response Code
        }]
    },
    "ErrorCode": 0,
    "Timestamp": "2019-05-14T19:32:57"
}
```

### 2.2.2. ACCEPTED Action 已接受

The Sportsbook Platform will call to the Operator to notify them that the bet was **ACCEPTED**. The Operator must update the status of wager to **OPEN** and adjust the balance if needed (in the case of better odds accepted).

体育平台将会通知运营商注单已接受。运营商需要更新注单状态至开放OPEN，并在有需要的时候调整余额（以防接受了更佳的赔率）。

**POST data for Request**

**请求的POST 数据**

*No Adjustment for Single Wager: Request data.*

*无需调整余额的单一注单：请求数据*

```js
{
  "Timestamp": "2024-03-22T04:41:14",
  "Signature": "6rC+ptbJmJQJ6Cn/X5p95dvnq/yOR7pWvalM7acs/hlCRryXBW7uy/tDcqbuVJFMEe4Qt8XkKQ7syvPPHpNcqA==",
  "Actions": [
    {
      "Id": 15560892635790863,
      "Name": "ACCEPTED",
      "PlayerInfo": {
        "LoginId": "Test.ABCD.1000475355",
        "UserCode": "P1L0000001"
      },
      "WagerInfo": {
        "WagerId": 2200510331,
        "Type": "single",
        "BetType": 1,
        "Sport": "Soccer",
        "Odds": 210.000,
        "OddsFormat": 0,
        "ToWin": 44.100,
        "ToRisk": 21.000,
        "Stake": 21.000,
        "Period": 0,
        "EventId": 1587781217,
        "EventName": "Everton-vs-Liverpool",
        "EventDateFm": "2024-03-24 09:00:00",
        "LeagueId": 8713,
        "LeagueName": "England - Women Super League",
        "SportId": 29,
        "Inplay": false,
        "InPlayScore": "",
        "Handicap": 0.00,
        "SelectionType": "HOME",
        "Selection": "Everton",
        "ParentEventName": null
      }
    }
  ]
}
```

**Response Data 响应数据**

Response data when accepting bet with no balance adjustment.

在无需调整余额的情况下，接受注单时的响应数据

```js
{
  "Result": {
    "UserCode": "P1L0000001",
    "AvailableBalance": 13471.05,
    "Actions": [
      {
        "Id": 15560892635790863,
        "TransactionId": null,
        "WagerId": 2200510331,
        "ResponseCode": 0
      }
    ]
  },
  "ErrorCode": 0,
  "Timestamp": "2024-03-22T00:41:14"
}
```

*Has Adjustment for Single Wager: Request data in case of better odds accepted and player chose to WIN option to place bet.*

*需要调整余额的单一注单：在接受更佳赔率以及玩家在下注时选择了独赢选项时的请求数据*

```js
{
{
    "Timestamp": "2019-05-03T04:18:27",
    "Signature": "w2QdXVixBhwuogVDouo08WaKrx5EzE6pNerQkaRMhHZ2ljQZ1u5gZzE\
        +/9H2FMiRJlvZz/QB0F4QlsXd4StmRA==",
    "Actions": [{
        "Id": 15560892634070383,
        "Name": "ACCEPTED",
    	"PlayerInfo": {
            "LoginId": "MPvZSDqM1685576929",
            "UserCode": "PXM130000D"
    	},
        "Transaction": {
            "TransactionId": 15560892276043,
            "TransactionType": "CREDIT",
            "TransactionDate": "2019-05-03T08:18:26",
            "Amount": 2     // Amount need adjust
        },
        "WagerInfo": {
            "WagerId": 725417673,
            "Type": "single",
            "BetType": 3,
            "Sport": "Soccer",
            "Odds": 1.909,
            "OddsFormat": 1,
            "ToWin": 20.000,
            "ToRisk": 22.000,
            "Period": 0,
            "EventId": 984812269,
            "EventName": "Oeste Itapolis-vs-Cuiaba",
            "LeagueId": 1835,
            "LeagueName": "Brazil - Serie B",
 	    "ParentEventName": null,
            "Inplay": false,
            "InPlayScore": "",
            "Handicap": 2.00,
            "SelectionType": "UNDER",
            "Selection": "Cuiaba"
        }
    }]
}
```

**Response Data 响应数据**

Response data when accepting a bet with balance adjustment.

当接受需要调整余额的注单时的响应数据

```js
{
    "Result": {
        "UserCode": "SU1070000H",
        "AvailableBalance": 172.71500000000003,
        "Actions": [{
            "Id": 15560892634070383,
        "TransactionId": 15560892276043,
            "WagerId": 724816652,
            "ResponseCode": 0 // Refer to Action Response Code
        }]
    },
    "ErrorCode": 0,
    "Timestamp": "2019-05-03T00:18:27"
}
```

*No Adjustment for Parlay/ Teaser Wager: Request data.*

*无需调整余额的混合过关/变让分过关注单的请求数据*

```js
{
    "Timestamp": "2019-05-14T06:42:37",
    "Signature": "pybnPupUEeQs3JpavwTUfsbMl7ux82vwlhigjbsT0ICBw77bYE9ULDWK7cw3bQSRx0qE\
        +VLGegK6UvO/fkUNlA==",
    "Actions": [{
        "Id": 15560892634071858,
        "Name": "ACCEPTED",
    	"PlayerInfo": {
            "LoginId": "MPvZSDqM1685576929",
            "UserCode": "PXM130000D"
    	},
        "WagerInfo": {
            "WagerId": 725428677,
            "Type": "parlay",
            "BetType": 6,
            "Odds": 3.324,
            "OddsFormat": 2,
            "ToWin": 39.890,
            "ToRisk": 12.000,
            "Legs": [{
                    "LegId": "68bf2b8a-81a9-d9de-32f5-8c13dcc47ddc",
                    "SportId": 29,
                    "Sport": "Soccer",
                    "SportGroup": 0,
                    "LeagueId": 154545454,
                    "League": "Brazil - Serie B",
                    "BetType": 1,
                    "SelectionType": 2,
                    "Selection": "DRAW",
                    "InplayScore": null,
                    "InPlay": false,
                    "Odds": 2.920,
                    "Handicap": 0.00,
                    "Period": 0,
                    "LegStatus": "ACCEPTED",
                    "TeamType": 0,
                    "EventName": "Oeste Itapolis-vs-Cuiaba"
                },
                {
		    "LegId": "a76c7bad-1ceb-9b9c-fbd4-235d8ab4f99f",
                    "SportId": 29,
                    "Sport": "Soccer",
                    "SportGroup": 0,
                    "LeagueId": 154545455,
                    "League": "Brazil - Serie B",
                    "BetType": 3,
                    "SelectionType": 3,
                    "Selection": "Brasil de Pelotas",
                    "InplayScore": null,
                    "InPlay": false,
                    "Odds": 0.480,
                    "Handicap": 1.50,
                    "Period": 0,
                    "LegStatus": "ACCEPTED",
                    "TeamType": 0,
                    "EventName": "Figueirense-vs-Brasil de Pelotas"
                }
            ],
            "WagerMasterId": 725428677
        }
    }]
}
```

**Response Data**

**响应数据**

Response data when accepting bet with no balance adjustment.

当接受无需调整余额的注单时的响应数据

```js
{
    "Result": {
        "UserCode": "S013000000",
        "AvailableBalance": 92693.40000000004,
        "Actions": [{
            "Id": 15560892634071858,
            "WagerId": 725428677,
            "ResponseCode": 0 // Refer to Action Response Code
        }]
    },
    "ErrorCode": 0,
    "Timestamp": "2019-05-14T02:42:37"
}
```

*Has Adjustment for Parlay/ Teaser Wager: Request data in case of better odds accepted and player chose to Win option to place bet.*

*需要调整余额的混合过关/变让分过关注单：在接受更佳赔率以及玩家在下注时选择了独赢选项时的请求数据*

```js
{
    "Timestamp": "2019-05-14T06:42:37",
    "Signature": "pybnPupUEeQs3JpavwTUfsbMl7ux82vwlhigjbsT0ICBw77bYE9ULDWK7cw3bQSRx0qE\
        +VLGegK6UvO/fkUNlA==",
    "Actions": [{
        "Id": 15560892634071858,
        "Name": "ACCEPTED",
    	"PlayerInfo": {
            "LoginId": "MPvZSDqM1685576929",
            "UserCode": "PXM130000D"
    	},
        "Transaction": {
            "TransactionId": 15560892276043,
            "TransactionType": "CREDIT",
            "TransactionDate": "2019-05-03T08:18:26",
            "Amount": 2.00 // Amount need adjust
        },
        "WagerInfo": {
            "WagerId": 725428677,
            "Type": "parlay",
            "BetType": 6,
            "Odds": 3.324,
            "OddsFormat": 2,
            "ToWin": 39.890,
            "ToRisk": 12.000,
            "Legs": [{
		    "LegId": "68bf2b8a-81a9-d9de-32f5-8c13dcc47ddc",
                    "SportId": 29,
                    "Sport": "Soccer",
                    "SportGroup": 0,
                    "LeagueId": 154545454,
                    "League": "Brazil - Serie B",
                    "BetType": 1,
                    "SelectionType": 2,
                    "Selection": "Cuiaba",
                    "InplayScore": null,
                    "InPlay": false,
                    "Odds": 2.920,
                    "Handicap": 0.00,
                    "Period": 0,
                    "LegStatus": "ACCEPTED",
                    "TeamType": 0,
                    "EventName": "Oeste Itapolis-vs-Cuiaba"
                },
                {
		    "LegId": "a76c7bad-1ceb-9b9c-fbd4-235d8ab4f99f",
                    "SportId": 29,
                    "Sport": "Soccer",
                    "SportGroup": 0,
                    "LeagueId": 154545455,
                    "League": "Brazil - Serie B",
                    "BetType": 3,
                    "SelectionType": 3,
                    "Selection": "Figueirense",
                    "InplayScore": null,
                    "InPlay": false,
                    "Odds": 0.480,
                    "Handicap": 1.50,
                    "Period": 0,
                    "LegStatus": "ACCEPTED",
                    "TeamType": 0,
                    "EventName": "Figueirense-vs-Brasil de Pelotas"
                }
            ],
            "WagerMasterId": 725428677
        }
    }]
}
```

**Response Data**

**响应数据**

Response data when accepting a bet with balance adjustment.

当接受需要调整余额的注单时的响应数据

```js
{
    "Result": {
        "UserCode": "S013000000",
        "AvailableBalance": 92693.40000000004,
        "Actions": [{
            "Id": 15560892634071858,
            "TransactionId": 15560892276043,
            "WagerId": 725428677,
            "ResponseCode": 0 // Refer to Action Response Code
        }]
    },
    "ErrorCode": 0,
    "Timestamp": "2019-05-14T02:42:37"
}
```

*Manual Wager Type: Request data.*

*手动投注类型：请求数据。*

```js
{
  "Timestamp": "2021-07-02T12:51:31",
  "Signature": "pybnPupUEeQs3JpavwTUfsbMl7ux82vwlhigjbsT0ICBw77bYE9ULDWK7cw3bQSRx0qE\
        +VLGegK6UvO/fkUNlA==",
  "Actions": [
    {
      "Id": 15560892634071824,
      "Name": "ACCEPTED",
       "PlayerInfo": {
           "LoginId": "MPvZSDqM1685576929",
           "UserCode": "PXM130000D"
      },
      "WagerInfo": {
        "WagerId": 725428677,
	"Type": "single",
        "BetType": 8,
        "Odds": 9.084,
        "OddsFormat": 1,
        "ToWin": "5195307.000",
        "ToRisk": "642586.000",
	"Stake": "642586.000",
        "Period": 0,
        "Description": "Baseball - MLB\nMinnesota Twins vs Chicago White Sox - Over 8.5 @ -128 for Game\nArizona Diamondbacks vs St. Louis Cardinals - Over 8.5 @ -123 for Game\n\nBaseball - Korea Professional Baseball\nDoosan Bears vs Hanwha Eagles - Doosan Bears @ -162 for Game\nG2 Samsung Lions vs G2 SSG Landers - Over 8.5 @ -135 for Game\n\nOld ticket : Ref No: 00000000 / 00000000\nMember id : ABC XYZ",
	"OriginalWagerId": 725428676
      }
    }
  ]
}
```

**Response Data 响应数据**

Response data when accepting bet.

接受投注时的响应数据。

```js
{
  "Result": {
    "UserCode": "XZ10700",
    "AvailableBalance": "172.71500000000003",
    "Actions": [
      {
        "Id": 19532026,
        "WagerId": 1751348096,
        "ResponseCode": 0 // Refer to Action Response Code
      }
    ]
  },
  "ErrorCode": 0,
  "Timestamp": "2021-07-02T16:51:32"
}
```

### 2.2.3. SETTLED Action 已结算

The Sportsbook Platform will call to the Operator when a bet is **SETTLED**. The Operator wallet must update the player’s wallet balance based on the Amount that the Sportsbook Platform sent in **SETTLED** action.

体育平台将会通知运营商注单已结算。运营商钱包需要根据体育平台在执行已结算的步骤时向其提供的Amount金额来更新玩家的钱包余额。

Note: In SETTLED action, request data may have a Transaction or not. If there is a Transaction in the request wager is **WIN**, **WIN HALF** or **LOSE HALF**.

注：在已结算的步骤中，请求数据不一定有Transaction （交易）。如果请求中有Transaction （交易）信息，注单结果为赢，半赢或者半输。

**Single Wager Type: Request Data**

**单一注单：请求数据**

```js
{
    "Timestamp": "2019-05-14T04:19:40",
    "Signature": "HolXboM6LNFzni/Bh8FRJw4AqpdwmtcqrGagPDECNlxx3RuFisBLc2M8cySyJmnChSwwEPMko\
        87sUaEkcfjn4Q==",
    "Actions": [{
        "Id": 15560892634071798,
        "Name": "SETTLED",
    	"PlayerInfo": {
            "LoginId": "MPvZSDqM1685576929",
            "UserCode": "PXM130000D"
    	},
        "Transaction": {
            "TransactionId": 15560892277038,
            "TransactionType": "CREDIT",
            "TransactionDate": "2019-05-14T04:00:00",
            "Amount": 14.840
        },
        "WagerInfo": {
            "WagerId": 725361010,
            "Type": "single",
            "BetType": 1,
            "Sport": "Baseball",
            "Odds": 2.120,
            "OddsFormat": 1,
            "ToWin": 7.840,
            "ToRisk": 7.000,
            "Period": 0,
            "SettlementTime": "2019-05-14 06:00:00",
            "ResettlementTime": "2019-05-14 07:00:00",
            "PartialStatus": 1,
            "EventId": 985845048,
            "EventName": "Yokohama Bay Stars-vs-Chunichi Dragons",
            "LeagueId": 187703,
            "LeagueName": "Nippon Professional Baseball",
	    "ParentEventName": null,
            "Inplay": false,
            "InPlayScore": "",
            "Handicap": 0.00,
            "SelectionType": "HOME",
            "Selection": "Yokohama Bay Stars",
            "HomePitcher": "Y. Ono",
            "AwayPitcher": "K. Azuma",
            "HomePitcherName": "Y. Ono",
            "AwayPitcherName": "K. Azuma",
            "ProfitAndLoss": 7.840,
            "Outcome": "WIN"    
        }
    }]
}
```

**Response Data**

**响应数据**

```js
{
    "Result": {
        "UserCode": "PIN00115", // (String)
        // (Money) Balance after perform transaction
        "AvailableBalance": 1.02,
        "Actions": [{
            "Id": 15560892634071798,
            "WagerId": 725361010, // (Long)
            "TransactionId": 15560892277038, // (Long)    
            "ResponseCode": 0 // Refer to Action Response Code
        }]
    },
    "ErrorCode": 0, // Refer to Request Error Code
    "Timestamp": "2018-01-15T15:20:14" // (Date)
}
```

**Parlay/ Teaser Type: Request Data**

**混合过关/变让分过关：请求数据**

```js
{
    "Timestamp": "2019-05-21T11:59:57",
    "Signature": "9qOierMPv8iqy0fFsNO84sXxp4WJtDkGQYw13gLJzj1LSwvG6zmM6yhRb3h88ZTHVyK6cRADh1K\
        NuxeNh4CxqQ==",
    "Actions": [{
        "Id": 15560892634075535,
        "Name": "SETTLED",
    	"PlayerInfo": {
            "LoginId": "MPvZSDqM1685576929",
            "UserCode": "PXM130000D"
    	},
        "Transaction": {
            "TransactionId": 15560892277038,
            "TransactionType": "CREDIT",
            "TransactionDate": "2019-05-14T04:00:00",
            "Amount": 50.000
        },
        "WagerInfo": {
            "WagerId": 725755355,
            "Type": "parlay",
            "BetType": 6,
            "Odds": 209.000,
            "OddsFormat": 0,
            "ToWin": 209.000,
            "ToRisk": 100.000,
            "ProfitAndLoss": -50.000,
            "Outcome": "LOSE",
            "SettlementTime": "2019-05-14 06:00:00",
            "ResettlementTime": "2019-05-14 07:00:00",
            "PartialStatus": 1,
            "Legs": [{
		    "LegId": "68bf2b8a-81a9-d9de-32f5-8c13dcc47ddc",
                    "SportId": 29,
                    "Sport": "Soccer",
                    "SportGroup": 0,
                    "League": "Ukraine - Premier League",
                    "BetType": 3,
                    "LeagueId": 2650,
                    "SelectionType": 4,
                    "Selection": "Karpaty Lviv",
                    "InplayScore": null,
                    "InPlay": false,
                    "Odds": -138.000,
                    "Handicap": 1.00,
                    "Period": 1,
                    "LegStatus": "PUSH",
                    "TeamType": 0,
                    "EventName": "Chornomorets Odessa-vs-Karpaty Lviv"
                },
                {
		    "LegId": "a76c7bad-1ceb-9b9c-fbd4-235d8ab4f99f",
                    "SportId": 29,
                    "Sport": "Soccer",
                    "SportGroup": 0,
                    "League": "Ukraine - Premier League",
                    "BetType": 2,
                    "LeagueId": 2650,
                    "SelectionType": 0,
                    "Selection": "Desna",
                    "InplayScore": null,
                    "InPlay": false,
                    "Odds": -126.000,
                    "Handicap": 0.00,
                    "Period": 0,
                    "LegStatus": "LOSE",
                    "TeamType": 0,
                    "EventName": "Desna-vs-Vorskla Poltava"
                }
            ],
            "WagerMasterId": 725755322
        }
    }]
}
```

**Response Data**

**响应数据**

```js
{
    "Result": {
        "UserCode": "PIN00115", // (String)
        // (Money) Balance after perform transaction
        "AvailableBalance": 1.02,
        "Actions": [{
            "Id": 15560892634075535,
            "WagerId": 725755355, // (Long)
            "TransactionId": 15560892277038, // (Long)    
            "ResponseCode": 0 // Refer to Action Response Code
        }]
    },
    "ErrorCode": 0, // Refer to Request Error Code
    "Timestamp": "2018-01-15T15:20:14" // (Date)
}
```
**Manual Wager Type: Request Data**

**手动投注类型：请求数据**

```js
{
  "Timestamp": "2021-07-02T12:52:07",
  "Signature": "pybnPupUEeQs3JpavwTUfsbMl7ux82vwlhigjbsT0ICBw77bYE9ULDWK7cw3bQSRx0qE\
        +VLGegK6UvO/fkUNlA==",
  "Actions": [
    {
      "Id": 15560892634075535,
      "Name": "SETTLED",
      "PlayerInfo": {
     	"LoginId": "MPvZSDqM1685576929",
        "UserCode": "PXM130000D"
      },
      "Transaction": {
        "TransactionId": 15560892277038,
        "TransactionType": "CREDIT",
        "TransactionDate": "2021-07-02T12:51:54",
        "Amount": 5837893
      },
      "WagerInfo": {
        "WagerId": 725755355,
	"Type": "single",
        "BetType": 8,
        "Odds": 9.084,
        "OddsFormat": 1,
        "ToWin": "5195307.000",
        "ToRisk": "642586.000",
	"Stake": "642586.000",
        "ProfitAndLoss": "5195307.000",
        "Outcome": "WIN",
        "Period": 0,
        "SettlementTime": "2021-07-02 12:51:54",
        "ResettlementTime": "2021-07-02 13:51:54",
        "PartialStatus": 1,
        "Description": "Baseball - MLB\nMinnesota Twins vs Chicago White Sox - Over 8.5 @ -128 for Game\nArizona Diamondbacks vs St. Louis Cardinals - Over 8.5 @ -123 for Game\n\nBaseball - Korea Professional Baseball\nDoosan Bears vs Hanwha Eagles - Doosan Bears @ -162 for Game\nG2 Samsung Lions vs G2 SSG Landers - Over 8.5 @ -135 for Game\n\nOld ticket : Ref No: 0000000 / 00000000\nMember id : ABCXYZ",
	"OriginalWagerId": 725755354
      }
    }
  ]
}
```

**Response Data**

**响应数据**

```js
{
  "Result": {
    "UserCode": "PIN00115",
    "AvailableBalance": "2542586.95",
    "Actions": [
      {
        "Id": 15560892634075535,
        "TransactionId": 11707259,
        "WagerId": 725755355,
        "ResponseCode": 0 // Refer to Action Response Code
      }
    ]
  },
  "ErrorCode": 0,
  "Timestamp": "2021-07-02T16:52:08"
}
```
### 2.2.4. REJECTED Action 已被拒

The Sportsbook Platform will call to the Operator wallet to notify that the wager was **REJECTED**. The Operator wallet needs to update the status of the wager to **REJECTED** and credit the player’s wallet balance based on the Amount in the transaction sent in data request.

体育平台将会通知运营商钱包注单已被拒。运营商钱包需要更新注单状态至REJECTED（已被拒）并根据数据请求里的交易金额返还至玩家的钱包。

**POST data for Request 发出数据请求**

```js
{
    "Timestamp": "2018-01-15T15:20:14", // (Date)
    "Signature": "w2QdXVixBhwuogVDouo08WaKrx5EzE6pNerQkaRMhHZ2ljQZ1u5gZzE\
        +/9H2FMiRJlvZz/QB0F4QlsXd4StmRA==",
    "Actions": [{
        "Id": 2445645645,
        "Name": "REJECTED",
    	"PlayerInfo": {
            "LoginId": "MPvZSDqM1685576929",
	    "UserCode": "PXM130000D"
    	},
        "WagerInfo": {
            "WagerId": 1545454 // (Long)
        },
        "Transaction": {
            "TransactionId": 123456789, // (Long)
            "TransactionType": "CREDIT", // Transaction Type
            "TransactionDate": "2019-01-18T15:20:15", // (Date)        
            "Amount": 15.55 // (Money)
        }
    }]
}
```

**Response Data 响应数据**

```js
{
    "Result": {
        "UserCode": "PIN00115",
        "AvailableBalance": 18.02,
        "Actions": [{
            "Id": 2445645645,
            "TransactionId": 123456789,
            "WagerId": 1545454,
            "ResponseCode": 0 // Refer to Action Response Code
        }]
    },
    "ErrorCode": 0,
    "Timestamp": "2019-05-03T00:18:27"
}
```

### 2.2.5. CANCELLED Action 已取消

When the bet is cancelled, the Sportsbook Platform will call the Operator with the **CANCELLED** type of transaction to refund the bet amount.

当注单被取消，体育平台会通知运营商：cancelled交易已取消以返还投注金额。

**POST data for Request 发出数据请求**

```js
{
    "Timestamp": "2018-01-15T15:20:14", // (Date)
    "Signature": "w2QdXVixBhwuogVDouo08WaKrx5EzE6pNerQkaRMhHZ2ljQZ1u5gZzE\
        +/9H2FMiRJlvZz/QB0F4QlsXd4StmRA==",
    "Actions": [{
        "Id": 124457,
        "Name": "CANCELLED",
    	"PlayerInfo": {
            "LoginId": "MPvZSDqM1685576929",
	    "UserCode": "PXM130000D"
    	},
        "WagerInfo": {
            "WagerId": 1545454 // (Long)
        },
        "Transaction": {
            "TransactionId": 123456789, // (Long)
            "TransactionType": "CREDIT", // Transaction Type
            "TransactionDate": "2019-01-18T15:20:15", // (Date)        
            "Amount": 15.55 // (Money)
        }
    }]
}
```

**Response Data 响应数据**

```js
{
    "Result": {
        "UserCode": "PIN00115", // (String)
        // (Money) Balance after perform transaction
        "AvailableBalance": 18.02,
        "Actions": [{
            "Id": 124457, // (Long)
            "WagerId": 1545454, // (Long)
            "TransactionId": 123456789, // (Long)
            "ResponseCode": 0 // Refer to Action Response Code
        }]
    },
    "ErrorCode": 0, // Refer to Request Error Code
    "Timestamp": "2018-01-15T15:20:14" // (Date)
}
```

### 2.2.6. ROLLBACKED Actions 已返回

If a response is not received from the server, or a timeout (499) or gateway error (502, 504) is received, on sending a BETTED action, a ROLLBACKED action will be sent for the wager. The Operator must rollback the wager using the WagerId and refund the Amount that Sportsbook Platform sent in betted action using the TransactionId. If the Transaction and Wager are not found in Operator side, no adjustment is to be made.

如果未从服务器收到响应，或者收到超时 (499) 或网关错误 (502、504)，则在发送投注操作时，将发送投注的返回操作。 运营商必须使用 WagerId 返回投注，并退还体育博彩平台使用 TransactionId 在投注操作中发送的金额。 如果运营商端没有找到交易和投注，则无需进行调整。

*Note: The rollback action will be sent when there is a problem during the bet placement process. Request includes wager information and transaction type of “rollbacked”. This request has only 1 action and does not include other actions.*

*注：在下注过程中出现问题时，将发送"已返回"请求"。该请求包含下注信息和"已返回"的交易类型。 该请求只有1个动作，不会和其他交易类型一起发送。*

In the Transaction of Rollback action, we send a ReferTransactionId property. This refers to TransactionId of the previous BETTED action. The ROLLBACKED action helps to identify transactions from the BETTED action. Sometimes the Operator will get this action but no previous BETTED action (e.g. there may be a problem sending BETTED actions over the network). Please ignore it and respond as a success with ResponseCode is 0 as data.

在"已返回”请求的交易中，我们发送的 ReferTransactionId指向的是之前 “已下注” 请求的 TransactionId。 "已返回”请求操作有助于识别来自 “已下注”请求中的交易。 有时运营商会收到此 "已返回”请求，但没有与之对应的的 “已下注”请求（比如，发送 “已下注”请求可能存在网络问题）。 请忽略并发送ResponseCode 为 0 的数据作为成功响应。

```js
{
    "Timestamp": "2019-05-03T23:32:47",
    "Signature": "fhpsVEdPsn+BbdFw+NxTzhV6+r4TM06LCgRplAnuYfgERdrcsWljQPXR\
        /IAs9h54qXy6hXlDpXpMW/m1J37Syg==",
    "Actions": [{
        "Id": 15560892634070450,
        "Name": "ROLLBACKED",
    	"PlayerInfo": {
            "LoginId": "MPvZSDqM1685576929",
            "UserCode": "PXM130000D"
    	},
        "Transaction": {
            "TransactionId": 15560892276088,
      "ReferTransactionId": 15560892276087,
            "TransactionType": "CREDIT",
            "TransactionDate": "2019-05-04T03:32:47",
            "Amount": 10
        },
        "WagerInfo": {
            "WagerId": 724839645
        }
    }]
}
```

**Response Data 响应数据**

```js
{
    "Result": {
        "UserCode": "SU1070000H",
        "AvailableBalance": 191.71500000000003,
        "Actions": [{
            "Id": 15560892634070450,
            "TransactionId": 15560892276088,
            "WagerId": 724839645,
        "ResponseCode": 0
        }]
    },
    "ErrorCode": 0,
    "Timestamp": "2019-05-03T19:32:47"
}
```

### 2.2.7. UNSETTLED Action 取消结算

When a bet needs to be resettled due to an incorrect result or any other reason that may cause the resettlement in Sportsbook Platform. The Sportsbook Platform will send UNSETTLED action to reverse the previous settle operation. The Operator must refund the lost amount or take back the win amount and change wager status back to OPEN.

当注单因错误结果或者其他原因需要在体育平台重新结算，体育平台会执行取消结算的步骤以返回之前的结算。运营商需要返还或扣除玩家可能的输赢金额并将注单状态改为OPEN。

*Note: The action following an Unsettled action is either Cancelled or Settled. In this request data, we usually call the Operator in 2 actions: `UNSETTLED` then `CANCELLED`/`SETTLED`.*

*注：未结算之后的步骤为已取消或者已结算。在这项请求数据中，我们通常调取运营商钱包2个步骤：取消结算以及已取消/已结算。*

**Request Data 请求数据**

```js
{
    "Timestamp": "2019-05-07T22:19:26",
    "Signature": "bgDLFBQBcU1UqOq+HUMUKTSeOAKRwnm1bu7igURAKI2ZD9updNLL\
        +pNRoJQ2CvC9EYr1DtBAYYNpPPVpnCUHKw==",
    "Actions": [{
            "Id": 15560892634071356,
            "Name": "UNSETTLED",
            "PlayerInfo": {
		"LoginId": "MPvZSDqM1685576929",
		"UserCode": "PXM130000D"
            },
            "Transaction": {
                "TransactionId": 15560892276754,
                "TransactionType": "DEBIT",
                "TransactionDate": "2019-05-07T04:00:00",
                "Amount": 197
            },
            "WagerInfo": {
                "WagerId": 725057660
            }
        },
        {
            "Id": 15560892634071356,
            "Name": "CANCELLED",
            "PlayerInfo": {
		"LoginId": "MPvZSDqM1685576929",
		"UserCode": "PXM130000D"
            },
            "Transaction": {
                "TransactionId": 15560892276755,
                "TransactionType": "CREDIT",
                "TransactionDate": "2019-05-07T04:00:00",
                "Amount": 100
            },
            "WagerInfo": {
                "WagerId": 725057660
            }
        }
    ]
}
```

**Response Data 响应数据**

```js
{
    "Result": {
        "UserCode": "S013000005",
        "AvailableBalance": 9900,
        "Actions": [{
                "Id": 15560892634071356,
                "TransactionId": 15560892276754,
                "WagerId": 725057660,
            "ResponseCode": 0
            },
            {
                "Id": 15560892634071356,
                "TransactionId": 15560892276755,
                "WagerId": 725057660,
            "ResponseCode": 0
            }
        ]
    },
    "ErrorCode": 0,
    "Timestamp": "2019-05-07T18:19:26"
}
```

## 2.3. Appendix 附录

### 2.3.1. [JSON Data Request Description of Wagering API 投注API的JSON数据请求描述](./../appendix/appendix-1-json-data-request-description-of-wagering-api.md)

### 2.3.2. [JSON Data Response Description of Wagering API 投注API的JSON数据回应描述](./../appendix/appendix-2-json-data-response-description-of-wagering-api.md)

### 2.3.3. Action Types 操作类型

| No 编号 | Code 代码 | Description 描述 |
| --- | --- | --- |
| 1 | `BETTED` | Player places bet and the Sportsbook Platform creates a wager. <br/>玩家下注且在体育平台创建了相应注单 |
| 2 | `ACCEPTED` | A wager was accepted by the Sportsbook Platform. <br/>注单被体育平台接受 |
| 3 | `REJECTED` | A wager was not accepted by the Sportsbook Platform. <br/>注单没有被体育平台接受 |
| 4 | `SETTLED` | A wager was settled by the Sportsbook Platform. <br/>注单在体育平台已结算 |
| 5 | `CANCELLED` | A wager was cancelled by the Sportsbook Platform. <br/>注单被体育平台取消 |
| 6 | `ROLLBACKED` | Rollback is used when an unknown error or timeout occurred. <br/>注单因未知错误或超时而被返回 |
| 7 | `UNSETTLED` | Unsettled action happens when a wager needs to be settled or cancelled; however, the wager was previously settled. <br/>取消结算状态：注单需要结算或取消但注单曾被结算过 |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||

### 2.3.4. Transaction Status 交易状态

| No 编号 | Code 代码 | Description 描述 |
| --- | :---: | --- |
| 1 | `pending` | The transaction is being processed in the Operator’s wallet. <br/>交易正在运营商钱包里进行 |
| 2 | `completed` | The transaction has been successfully processed in the Operator’s wallet. <br/>交易已在运营商钱包里成功受理 |
| 3 | `failed` | The transaction failed processing in the Operator's wallet. <br/>交易在运营商钱包里未受理成功 |

### 2.3.5. Error Response Code 响应错误代码

| Code 代码 | Message 信息 | Description 描述 |
| --- | --- | --- |
| 0 | Success | The API call has successfully been completed without any errors.<br/>成功调取API,未出现任何错误 |
| -1 | Unknown Error | An unknown error has occurred during the API call.<br/>在调取API时出现未知错误 |
| -3 | Session Not Found | The session token was not found in the Operator Wallet or the session token has expired. <br/>会话令牌未在运营商钱包或者会话令牌已过期失效 |
| -4 | Account Frozen | The account has been suspended/frozen by the Operator Wallet.<br/>账户被运营商钱包中止或冻结 |
| -5 | Account Not Found | The account was not found in the Operator Wallet.<br/>账户在运营商钱包里不存在 |
| -6 | API Authenticated Failed | This error will be returned if the Signature is invalid or not found.<br/>无效或不存在的签名 |

### 2.3.6. Action Response Code 操作响应代码

| Code 代码 | Message 信息 | Description 描述 |
| --- | --- | --- |
| 0 | Success | The API call has successfully been completed without any errors.<br/>成功调取API,未出现任何错误 |
| -1 | Unknown Error | An unknown error has occurred during the execution of the transaction.<br/>在执行交易过程中出现未知错误 |
| -2 | Insufficient Fund | The B2B Wallet has insufficient Player funds to complete the debit.<br/>在B2B钱包里，玩家资金不足以支付账款 |
| -7 | Transaction Not Complete | The debit/credit transaction has not been completed in the Operator Wallet.<br/>添加或扣除款项交易未在运营商钱包里完成 |
| -8 | Transaction Not Found | The debit/credit transaction cannot be found in the B2B Wallet.<br/>添加或扣除款项交易在B2B钱包里不存在 |
| -9 | Currency Mismatch | The B2B Wallet Currency Code does not match the Currency Code of Sportsbook Platform Account.<br/><b>Please ignore it. This error code is deprecated from documentation version 1.0.21 (curent version) or later.</b><br/>B2B钱包币种代码与体育平台账户币种代码不一致 |
| -10 | Stake Limit | The bet has exceeded the individual stake limit set for the Player of Sportsbook Platform.<br/>注单金额超过玩家在体育平台的单个玩家下注限额 |
| -11 | Wager Limit | The bet will exceed the wager limit set for the Player of Sportsbook Platform.<br/>注单金额将超过玩家在体育平台的下注限额 |
| -12 | Loss Limit | The bet will exceed the loss limit set for the Player of Sportsbook Platform.<br/>注单金额将超过玩家在体育平台的损失限额 |
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||

