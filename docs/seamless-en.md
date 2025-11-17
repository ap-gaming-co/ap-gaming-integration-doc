# Table Contents

- [Table Contents](#table-contents-%E7%9B%AE%E5%BD%95)
- [1. Seamless Wallet Overview](#1-seamless-wallet-overview)
    - [1.1. Architecture Overview](#11-architecture-overview)
    - [1.2. Data Format](#12-data-format)
        - [1.2.1. Common Data Format](#121-common-data-format)
        - [1.2.2. Common Response Data Format](#122-common-response-data-format)
- [2. Operator Wallet API Methods](#2-operator-wallet-api-methods)
    - [2.1. Ping](#21-ping)
        - [2.1.1. Request Format](#211-request-format)
        - [2.1.2. Response Format](#212-response-format)
        - [2.1.3. Possible Error Code](#213-possible-error-code)
    - [2.2. Seamless Wagering](#22-seamless-wagering)
        - [2.2.1. BETTED Action](#221-betted-action)
        - [2.2.2. ACCEPTED Action](#222-accepted-action)
        - [2.2.3. SETTLED Action](#223-settled-action)
        - [2.2.4. REJECTED Action](#224-rejected-action)
        - [2.2.5. CANCELLED Action](#225-cancelled-action)
        - [2.2.6. ROLLBACKED Actions](#226-rollbacked-actions)
        - [2.2.7. UNSETTLED Action](#227-unsettled-action)
    - [2.3. Appendix](#23-appendix)
        - [2.3.1. JSON Data Request Description of Wagering API](#231-json-data-request-description-of-wagering-api)
        - [2.3.2. JSON Data Response Description of Wagering API](#232-json-data-response-description-of-wagering-api)
        - [2.3.3. Action Types](#233-action-types)
        - [2.3.4. Transaction Status](#234-transaction-status)
        - [2.3.5. Error Response Code](#235-error-response-code)
        - [2.3.6. Action Response Code](#236-action-response-code)
          
# 1. Seamless Wallet Overview

The Sportsbook Platform needs to communicate with the Operator Wallet for the purposes of seamlessly debiting and crediting funds from the Operator Wallet when bets are placed and settled.

## 1.1. Architecture Overview

The SB Seamless Wallet API has been designed using a lightweight REST style web service. All requests/responses use JSON format to transfer. Thus, the header of a request/response must have a parameter `ContentType: application/json`.

## 1.2. Data Format
### 1.2.1. Common Data Format

All requests from the Sportsbook Platform to Operator Wallet API have basic information in POST request data (except [Ping API](#21-ping). Please refer to API definition).

```json
{
    // other property of POST data.
    "Timestamp": "2018-01-15T15:20:14",
    "Signature": "aTFzUoIUD7Tpclf9XQ/+kuyEkNRJCUMK12XgQoVmhKuy6HGle5pj1sdZJJ\
        +FSu23MZhy+ppH02fe3kDnB5CgMw=="
}
```
| Parameter | Type | E.g. Value | Description |
| --- | --- | --- | --- |
| `Timestamp` | `Date` | 2018-01-15T15:20:14 |  |
| `Signature` | `String` |  | The signature was generated from [Authentication](/docs/shared-en.md)

### 1.2.2. Common Response Data Format

Data format for most requests.

```json
{
    "Result": {
         //... Result Object
    },
    "ErrorCode": 0,
    "Timestamp": "2018-01-15T15:20:14"
}
```


# 2. Operator Wallet API Methods

The Operator Wallet API includes the following API methods:

## 2.1. Ping

This method is used to query the Operator Wallet API to determine if the API is available. If no response is received e.g. Timeout, the Operator Wallet API will also be assumed to be unavailable.

### 2.1.1. Request Format

**Endpoint**

The request will be sent to following URI:

```yml
URI: /ping
Method: POST
```

**POST Parameters**

The API method will send post JSON in the following format:

```js
{    
    "Timestamp": "2018-01-15T15:20:14" // (Date)
}
```

### 2.1.2. Response Format

The API will return JSON in the following format:

```js
{
    "Result": {
        "Available": true   // (Boolean) wallet is available. Type: Boolean
    },
    "ErrorCode": 0,     // Refer to Possible Error Code
    "Timestamp": "2018-01-15T15:20:14"
}
```

### 2.1.3. Possible Error Code

| Code | Reason |
| --- | --- |
| 0 | Success |
| -1 | Unknown Error unknown error has occurred during the API call.|
| -6 | API Authentication failed This error will be returned if the Signature is invalid or not found.|
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||


## 2.2. Seamless Wagering

Seamless Wagering methods help to update the balance in the Operator wallet's account in real time. This action occurs when a player places a bet, a bet is accepted, settled, or rejected. These are processes that affect the balance in the Operator wallet.

```yml
URI: /{agentcode}/wagering/usercode/{usercode}/request/{requestid}
Method: POST
```

| Parameter | E.g. Value | Description |
| --- | --- | --- |
| `agentcode` | `AG001` | Agent code is provided by Sportsbook Platform. |
| `usercode` | `PIN00115` | User Code is created in Create Player API. |
| `requestid` | `81347c9e-280d-40d6-8349-29dca7ea6bdc` | Request Id is unique in the betting platform. It is formatted based on UUID (8-4-4-4-12).|
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||

There are 7 Action Types for a wager: `BETTED`, `ACCEPTED`, `REJECTED`, `SETTLED`, `CANCELLED`, `ROLLBACKED` and `UNSETTLED`.

Sequence Interaction

![Sequence Interaction](./../res/figure-1-sequence-interaction-english.png?raw=true)
 
*Figure 1 – The sequence shows the interaction between the Operator and the Sportbook Platform.* <br>
**Bet Placement Process**:

<table>
  <tr style="background-color:#e0dcdc;">
    <th rowspan="2">Actions</th>
    <th colspan="4">Bet Placement Process</th>
    <th colspan="3">Settlement Process</th>
  </tr>
  <tr style="background-color:#e0dcdc;">
    <td>BETTED</td>
    <td>ACCEPTED</td>
    <td>ROLLBACKED</td>
    <td>REJECTED</td>
    <td>SETTLED</td>
    <td>CANCELLED</td>
    <td>UNSETTLED</td>
  </tr>
    <td>Description</td>
    <td>Player is placing a bet</td>
    <td>Bet has been accepted<</td>
    <td>Error occurred when placing</td>
    <td>Live bet has been rejected<</td>
    <td>Bet has been settled</td>
    <td>Bet has been cancelled</td>
    <td>Bet has been unsettled and to be resettled</td>
  <tr>
  </tr>
    <td>Wager Status</td>
    <td>PENDING</td>
    <td>OPEN</td>
    <td>ERROR (wager will be deleted)</td>
    <td>CANCELLED (Rejected)</td>
    <td>SETTLED</td>
    <td>CANCELLED (Void)</td>
    <td>OPEN</td>
  <tr>
  </tr>
    <td>Affect Balance</td>
    <td>- available balance</td>
    <td>+ available balance (see note 1)</td>
    <td>+ available balance</td>
    <td>+ available balance</td>
    <td>+ available balance</td>
    <td>+ available balance</td>
    <td>- available balance</td>
  <tr>
  </tr>
</table>

Note 1: If the bet was accepted with better odds and the player chose Stake as “To Win” amount, the difference must be credited back to the player account. See ACCEPTED Action section.


![Wager State Diagram](../res/wager-state-diagram-english.png?raw=true)

**Unsettled Action** 

A bet may be **Unsettled** when the outcome of the bet needs to be changed.<br/>

A bet can only be Unsettled after it has been **Settled** or **Cancelled**.<br/>

**Handling Settled and Unsettled Actions**

If more than one action applies to a bet, the actions must be processed in order, with the lower action ID first. If this cannot be  done, please follow the instructions below on the action to take, taking into account the current and received properties of the bet.<br/>
 
The action to take will depend on the current status of the bet, the status in the action, and the action ID. Refer to the table below:<br/>
| Status Received<br/> | Current Status<br/> | Received Action ID is Higher<br/>Action ID | Action To Take<br/>|
| --- | --- | --- | --- |
| SETTLED  | ACCEPTED | Yes | Settle the bet |
| SETTLED | UNSETTLED | No  | Ignore action  |
| SETTLED | UNSETTLED | Yes | Settle the bet |
| SETTLED | SETTLED | No | Ignore action |
| SETTLED | SETTLED | Yes | Unsettle the bet, then settle the bet |
| UNSETTLED | SETTLED | No | Ignore action |
| UNSETTLED | SETTLED | Yes | Unsettle the bet |
| UNSETTLED | UNSETTLED | No | Ignore action |
| UNSETTLED | UNSETTLED | Yes | Ignore action |

### 2.2.1. BETTED Action

When a player is placing a bet in the player site, the Sportsbook Platform sends **BETTED** action with wager information to the Operator to deduct funds from the player’s balance and to store the wager. The available Balance response is the balance after performing a transaction.

If the response received from the BETTED action is invalid or incomplete, the Sportsbook Platform will send a ROLLBACKED action as we cannot be certain that the wager information was successfully processed by the Operator.

**Single Wager Type: POST Data for Request**

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

**Parlay & Teaser Wager Type: POST Data for Request**

A Round Robin bet is an easy way to wager multiple parlays with a single bet. They make it easy for bettors to place parlay wagers that consist of 3-8 lines. A parlay without Round Robin can consist of up to 10 lines and 2-6 teams for a teaser. Bettors can cover their bases and wager all possible combinations by using a Round Robin and bet many parlays at once. The downside to these wagers is that gamblers bet too many legs or use too many selections in their parlay combinations. You can find round robin bets at just about every online sportsbook, but they are not often used by most sports gamblers.

Operators receive request BETTED action when the player places a bet. A Round Robin will be presented through RoundRobinOptions. Its value can be `Single`, `Parlay` (not a round robin. It is only normal parlay wager), `TwoLegRoundRobin`, `ThreeLegRoundRobin`, `FourLegRoundRobin`, `FiveLegRoundRobin`, `SixLegRoundRobin`, `SixLegRoundRobin`, `SevenLegRoundRobin`, `EightLegRoundRobin`.

The example table shows a combination of picks (events/legs) and round robin options:

*Table 1 - Combination of picks (events/legs) and round robin options*

| Picks <br/>(events/legs/bets)  | Ways<br/>| Number of Bets |
| --- | --- | --- |
| 3 | 2 - TwoLegRoundRobin| 3 |
| 4 | 2 - TwoLegRoundRobin< | 6 |
| 4 | 3 - ThreeLegRoundRobin | 4 |
| … | … | … |
| … | … | … |
| 8 | 2 - TwoLegRoundRobin | 28 |
| 8 | 3 - ThreeLegRoundRobin | 56 |
| 8 | 4 - FourLegRoundRobin | 70 |
| 8 | 5 - FiveLegRoundRobin | 56 |
| 8 | 6 - SixLegRoundRobin | 28 |

We send to operators 1 `BETTED` action when a player places a bet with a Round Robin Parlay. The wager in this action is *master wager*. Then we send 3 `ACCEPTED` action if player bet in 3 events (games, matches) and `RoundRobinOptions` is `TwoLegRoundRobin` (assuming that the player’s bet was accepted). Other actions are also the same (`ACCEPTED` action). The `WagerMasterId` property will used to group all wagers together.

Events of WagerInfo for Parlay / Teaser Wager will be presented in a list containing event names.

In `BETTED` action, we send the number of bets that will be generated using the `WagerNum` property in JSON request. When the bet is accepted, we will send the number of `ACCEPTED` actions equal to number in the `WagerNum` property. The same will happen for the next action type.

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

**Manual Wager Type: POST Data for Request**

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

### 2.2.2. ACCEPTED Action

The Sportsbook Platform will call to the Operator to notify them that the bet was **ACCEPTED**. The Operator must update the status of wager to **OPEN** and adjust the balance if needed (in the case of better odds accepted).

**POST data for Request**

*No Adjustment for Single Wager: Request data.*

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

**Response Data**

Response data when accepting bet with no balance adjustment.

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

**Response Data**

Response data when accepting a bet with balance adjustment.

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

Response data when accepting bet with no balance adjustment.

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

Response data when accepting a bet with balance adjustment.

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

**Response Data**

Response data when accepting bet.

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

### 2.2.3. SETTLED Action

The Sportsbook Platform will call to the Operator when a bet is **SETTLED**. The Operator wallet must update the player’s wallet balance based on the Amount that the Sportsbook Platform sent in **SETTLED** action.

Note: In SETTLED action, request data may have a Transaction or not. If there is a Transaction in the request wager is **WIN**, **WIN HALF** or **LOSE HALF**.

**Single Wager Type: Request Data**

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
### 2.2.4. REJECTED Action

The Sportsbook Platform will call to the Operator wallet to notify that the wager was **REJECTED**. The Operator wallet needs to update the status of the wager to **REJECTED** and credit the player’s wallet balance based on the Amount in the transaction sent in data request.

**POST data for Request**

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

**Response Data**

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

### 2.2.5. CANCELLED Action

When the bet is cancelled, the Sportsbook Platform will call the Operator with the **CANCELLED** type of transaction to refund the bet amount.

**POST data for Request**

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

**Response Data**

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

### 2.2.6. ROLLBACKED Actions

If a response is not received from the server, a timeout (499), gateway error (502, 504), or an invalid response is received, on sending a BETTED action, a ROLLBACKED action will be sent for the wager. The Operator must rollback the wager using the WagerId and refund the Amount that Sportsbook Platform sent in betted action using the TransactionId. If the Transaction and Wager are not found in Operator side, no adjustment is to be made.

*Note: The rollback action will be sent when there is a problem during the bet placement process. Request includes wager information and transaction type of “rollbacked”. This request has only 1 action and does not include other actions.*

In the Transaction of Rollback action, we send a ReferTransactionId property. This refers to TransactionId of the previous BETTED action. The ROLLBACKED action helps to identify transactions from the BETTED action. Sometimes the Operator will get this action but no previous BETTED action (e.g. there may be a problem sending BETTED actions over the network). Please ignore it and respond as a success with ResponseCode is 0 as data.


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
        },
	"RollbackReason": "Malformed response"
    }]
}
```

**Response Data**

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

### 2.2.7. UNSETTLED Action

When a bet needs to be resettled due to an incorrect result or any other reason that may cause the resettlement in Sportsbook Platform. The Sportsbook Platform will send UNSETTLED action to reverse the previous settle operation. The Operator must refund the lost amount or take back the win amount and change wager status back to OPEN.

*Note: The action following an Unsettled action is either Cancelled or Settled. In this request data, we usually call the Operator in 2 actions: `UNSETTLED` then `CANCELLED`/`SETTLED`.*

**Request Data**

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

**Response Data**

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

## 2.3. Appendix

### 2.3.1. [JSON Data Request Description of Wagering API](./../appendix/appendix-1-json-data-request-description-of-wagering-api-en.md)

### 2.3.2. [JSON Data Response Description of Wagering API](./../appendix/appendix-2-json-data-response-description-of-wagering-api-en.md)

### 2.3.3. Action Types

| No  | Code | Description |
| --- | --- | --- |
| 1 | `BETTED` | Player places bet and the Sportsbook Platform creates a wager. |
| 2 | `ACCEPTED` | A wager was accepted by the Sportsbook Platform.  |
| 3 | `REJECTED` | A wager was not accepted by the Sportsbook Platform.  |
| 4 | `SETTLED` | A wager was settled by the Sportsbook Platform. |
| 5 | `CANCELLED` | A wager was cancelled by the Sportsbook Platform. |
| 6 | `ROLLBACKED` | Rollback is used when an unknown error or timeout occurred. |
| 7 | `UNSETTLED` | Unsettled action happens when a wager needs to be settled or cancelled; however, the wager was previously settled.|
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||

### 2.3.4. Transaction Status

| No | Code | Description |
| --- | :---: | --- |
| 1 | `pending` | The transaction is being processed in the Operator’s wallet.|
| 2 | `completed` | The transaction has been successfully processed in the Operator’s wallet.|
| 3 | `failed` | The transaction failed processing in the Operator's wallet.|

### 2.3.5. Error Response Code

| Code | Message | Description |
| --- | --- | --- |
| 0 | Success | The API call has successfully been completed without any errors.|
| -1 | Unknown Error | An unknown error has occurred during the API call.|
| -3 | Session Not Found | The session token was not found in the Operator Wallet or the session token has expired. |
| -4 | Account Frozen | The account has been suspended/frozen by the Operator Wallet. |
| -5 | Account Not Found | The account was not found in the Operator Wallet.|
| -6 | API Authenticated Failed | This error will be returned if the Signature is invalid or not found.

### 2.3.6. Action Response Code

| Code | Message | Description |
| --- | --- | --- |
| 0 | Success | The API call has successfully been completed without any errors.|
| -1 | Unknown Error | An unknown error has occurred during the execution of the transaction.|
| -2 | Insufficient Fund | The B2B Wallet has insufficient Player funds to complete the debit.|
| -7 | Transaction Not Complete | The debit/credit transaction has not been completed in the Operator Wallet.|
| -8 | Transaction Not Found | The debit/credit transaction cannot be found in the B2B Wallet.|
| -9 | Currency Mismatch | The B2B Wallet Currency Code does not match the Currency Code of Sportsbook Platform Account.<br/><b>Please ignore it. This error code is deprecated from documentation version 1.0.21 (curent version) or later.|
| -10 | Stake Limit | The bet has exceeded the individual stake limit set for the Player of Sportsbook Platform.|
| -11 | Wager Limit | The bet will exceed the wager limit set for the Player of Sportsbook Platform. |
| -12 | Loss Limit | The bet will exceed the loss limit set for the Player of Sportsbook Platform.|
|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;||

