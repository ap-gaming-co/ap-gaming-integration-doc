
# Table Contents
- [Table Contents 目录](#table-contents)
    - [1. Application Functionality](#1-application-functionality)
        - [1.1.	Get Game Types (Esports Only)](#11-get-game-types)
        - [1.2.	Get Leagues](#12-get-leagues)
        - [1.3.	Get Fixtures](#13-get-fixtures)
        - [1.4.	Get Lines](#14-get-lines)
        - [1.5.	Get Special Lines](#15-get-special-lines)
        - [1.6.	Event Post Message](#16-event-post-message)
        - [1.7.	Bet Selection](#17-bet-selection)
        - [1.8.	Login and Bet Placement Screen](#18-login-and-bet-placement-screen)
        - [1.9.	Error Responses](#19-error-responses)


# 1. Application Functionality <a name="1-application-functionality"></a>

The website has a facility built in that allows logged in users to add bet recommendations.

These recommendations detail specific bets on an individual line on a particular game.

Users must be able to select the game that they want to recommend and then identify the particular line and the side on which to bet.


## 1.1. Get Game Types (Esports Only) <a name="11-get-game-types"></a>

The game types are only required for e-sports. 


**GET Request Get** <br/>
        `/sline/games`

*Parameters*

| Parameter | Data Type | Notes |
| --- | --- | --- |
| `hasOfferings`  | `boolean` | To retrieve ONLY games with odds available |
| `locale` | `String` | Return language for data. |


**Response**

Returns Array of games.

*Game Data*

| Field | Data Type | Notes |
| --- | --- | --- |
| `id`  | `integer<int32>` | Unique Id of the game |
| `name` | `String` | Game name |

*Sample*

```js
{
	“games”: [{
		“id”: 123,
		“name”: “CS:GO”
	   }, {
		“id”: 124,
		“name”: “DOTA2”
   	}]
}
```


## 1.2. Get Leagues <a name="12-get-leagues"></a>

Gets the leagues for the requested sport. 

**GET Request GET** <br/>
        `/sline/leagues`

*Parameters*

| Parameter | Data Type | Notes |
| --- | --- | --- |
| `sportId` <br/>**required**  | `integer<int32>` | Sport id for which the leagues are requested. |
| `gameIds` | Array of integers <int32> | A comma separated list of Game Ids for e-sports games. <br/>If none supplied, all esports games are returned. <br/>Ignored for all other sports. |
| `hasOfferings`  | `boolean` | To retrieve ONLY leagues with odds available |
| `locale`  | `String` | Return language for data. |

**Response**

Returns Array of leagues.

*League Data*

| Field | Data Type | Notes |
| --- | --- | --- |
| `id`  | `integer<int32>` | Unique Id of the league |
| `name` | `String` | League name |
| `hasOfferings` | `boolean` | Whether the league currently has events or specials. |
| `leagueSpecialsCount` | `integer<int32>` | Indicates how many specials are in the given league. |
| `eventSpecialsCount` | `integer<int32>` | Indicates how many game specials are in the given league. |
| `eventCount` | `integer<int32>` | Indicates how many events are in the given league. |

*Sample*

```js
{
	“leagues”: [{
		“id”: 123,
		“name”: “CS:GO – Liga Talents”,
		“homeTeamType”: “Team1”,
		“hasOfferings”: true,
		“leagueSpecialsCount”: 1,
		“eventSpecialsCount”: 4,
		“eventCount”: 4
   }, {
		“id”: 123,
		“name”: “CS:GO – Liga Talents”,
		“homeTeamType”: “Team1”,
		“hasOfferings”: true,
		“leagueSpecialsCount”: 2,
		“eventSpecialsCount”: 0,
		“eventCount”: 6
   }]
}
```

**Esports Leagues**

For eSports, the League name is taken from the **name** field. The name field shows the game type and the league as in the example below:

            CS:GO - ESL Challenger League North America

The format is always {game} – {league}


            CS:GO - ESL Challenger League North America


## 1.3. Get Fixtures <a name="13-get-fixtures"></a>

Gets the fixtures for the requested league. 


**GET Request GET** <br/>
        `/sline/fixtures`

*Parameters*

| Parameter | Data Type | Notes |
| --- | --- | --- |
| `sportId` <br/>**required** | `integer<int32>` | Sport id for which the fixtures are requested. |
| `leagueId` <br/>**required**  | `integer<int32>` | The league id for which the fixtures are requested. |
| `locale`  | `String` | Return language for data.  |

**Response**

Returns a list of unique fixtures.

If a fixture has regular events and specials, the fixture will only return once.


*Fixture Data* 

| Field | Data Type | Notes |
| --- | --- | --- |
| `sportId`  | `integer<int32>` | Requested sport Id. |
| `leagueId`  | `integer<int32>` | Requested league id. |
| `event`  | Array of objects (EventFixture) | Contains a list of events. |

*EventFixture Data* 

| Field | Data Type | Notes |
| --- | --- | --- |
| `eventId`  | `integer<int32>` | Event Id. |
| `starts`  | `String<date-time>` | Game date time. |
| `home`  | `String` | Home team. |
| `away`  | `String` | Away team. |
| `lines`  | `integer<int32>` | Indicates how many lines are in the given event. |

*Sample*

```js
{
	“sportId”: 12,
	“leagueId”: 134567,
	“event”: [{
		“eventId”: 12346781,
		“starts”: “2022-07-01T15:30:00Z”,
		“home”: “Dream Team”,
		“away”: “Burning Code”,
		“lines”: 12,
   }, {
		“eventId”: 12346782,
		“starts”: “2022-07-01T15:30:00Z”,
		“home”: “Detonation FocusMe”,
		“away”: “Crest Act”,
		“lines”: 0,
   }]
}
```


## 1.4. Get Lines <a name="14-get-lines"></a>

Gets the standard lines for the requested event. 


**GET Request GET** <br/>
        `/sline/lines`

*Parameters*

| Parameter | Data Type | Notes |
| --- | --- | --- |
| `sportId` <br/>**required** | `integer<int32>` | Sport id for which the fixtures are requested. |
| `leagueId` <br/>**required** | `integer<int32>` | The league id for which the fixtures are requested. |
| `eventId` <br/>**required** | `integer<int32>` | The event id for which the fixtures are requested. |
| `locale`  | `String` | Return language for data. |

**Response**

Returns a list of unique lines.

Returns standard lines.

*Line Data*

| Field | Data Type | Notes |
| --- | --- | --- |
| `sportId`  | `integer<int32>` | Requested sport Id. |
| `leagueId`  | `integer<int32>` | Requested league id. |
| `eventId`  | `integer<int32>` | Requested event id. |
| `eventDateFm`  | `String<date-time>` | Event date |
| `eventName`  | `String` | Event Name |
| `home`  | `String` | Home team. |
| `away`  | `String` | Away team. |
| `line`  | Array of objects (EventLine) | Contains a list of lines. |


*EventLine Data*

| Field | Data Type | Notes |
| --- | --- | --- |
| `Id`  | `integer<int64>` | Line Id. |
| `altLineId`  | `integer<int64>` | Only populated if this is an alternate line. |
| `periodNumber`  | `integer<int32>` | Period number. |
| `points`  | `number <double>` | Populated for “TOTAL_POINTS”, “HOME_TEAM_TOTAL_POINTS”, “AWAY_TEAM_TOTAL_POINTS” |
| `hdp`  | `number <double>` | Team handicap.<br/>Populated for “SPREAD’ |
| `betType`  | `String` | Enum value<br/>“SPREAD’, “MONEYLINE”, “TOTAL_POINTS”, “HOME_TEAM_TOTAL_POINTS”, “AWAY_TEAM_TOTAL_POINTS” |
| `cutoff`  | `String<date-time>` | Betting cutoff date |

*Sample*

```js
{
	“sportId”: 12,
	“leagueId”: 134567,
	“eventId”: 13456784,
        “eventDateFm”: “2022-07-01T15:30:00Z”,
        “eventName”: "Dream Team vs Burning Code",
        “home”: “Dream Team”,
        “away”: “Burning Code”,
	“line”: [{
		“id”: 12346781,
		“altLineId”: 12346789
		“periodNumber”: 0,
		“points”: null,
		“hdp”: null,
		“betType”: “MONEYLINE”,
		“cutoff”: “2022-07-01T17:30:00Z”
        }, {
		“id”: 12346783,
		“altLineId”: 12346791
		“periodNumber”: 0,
		“points”: null,
		“hdp”: -1,
		“betType”: “SPREAD”,
		“cutoff”: “2022-07-01T17:30:00Z”
   }]
}
```


## 1.5. Get Special Lines <a name="15-get-special-lines"></a>

Gets the special lines for the requested event. 

**GET Request GET** <br/>
        `/sline/special-lines`

*Parameters*

| Parameter | Data Type | Notes |
| --- | --- | --- |
| `sportId` <br/>**required**  | `integer<int32>` | Sport id for which the fixtures are requested. |
| `leagueId` <br/>**required**  | `integer<int32>` | The league id for which the fixtures are requested. |
| `eventId` <br/>**required**  | `integer<int32>` | The event id for which the fixtures are requested. |
| `locale`  | `String` | Return language for data. |

**Response**

Returns a list of unique lines.

Returns special lines.

*Line Data*

| Field | Data Type | Notes |
| --- | --- | --- |
| `sportId`  | `integer<int32>` | Requested sport Id. |
| `leagueId`  | `integer<int32>` | Requested league id. |
| `eventId`  | `integer<int32>` | Requested event id. |
| `eventDateFm`  | `String<date-time>` | Event date |
| `eventName`  | `String` | Event Name |
| `home`  | `String` | Home team. |
| `away`  | `String` | Away team. |
| `specials`  | Array of objects (Specials) | Contains a list of special lines. |


*Specials Data*

| Field | Data Type | Notes |
| --- | --- | --- |
| `Id`  | `integer<int64>` | Special Id. |
| `name`  | `String` | Special name |
| `category`  | `String` | Special category  |
| `periodNumber`  | `integer<int32>` | Period number. |
| `betType`  | `String` | Enum value<br/>“MULTI_WAY_HEAD_TO_HEAD”, “SPREAD”, “OVER_UNDER” |
| `cutoff`  | `String<date-time>` | Betting cutoff date |
| `units`  | `String` | Measurement. Applicable to SPREAD and OVER_UNDER. |
| `contestants`  | Array of objects (Contestants) | Contains a list of contestants. |


*Contestants Data*

| Field | Data Type | Notes |
| --- | --- | --- |
| `Id`  | `integer<int64>` | Contestant Id. |
| `name`  | `String` | Contestant name |
| `contestantLineId`  | `Integer<int64>` | Contestant Line Id |
| `hdp`  | `number <double>` | Team handicap<br/>Populated for “SPREAD” and “OVER_UNDER” |

*Sample*

```js
{
      “sportId”: 12,
      “leagueId”: 134567,
      “eventId”: 13456784,
      “eventDateFm”: “2022-07-01T15:30:00Z”,
      “eventName”: "Dream Team vs Burning Code",
      “home”: “Dream Team”,
      “away”: “Burning Code”,
      “specials”: [{
		“id”: 12346781,
		“name”: “Correct Score”,
		“category”: “Teams”,
		“periodNumber”: 0,
		“betType”: “MULTI_WAY_HEAD_TO_HEAD”,
		“cutoff”: “2022-07-01T17:30:00Z”,
		“units”: “”,
		“contestants”: [{
			“id”: 1456789745,
			“name”: “Dream Team 0 Burning Code 3”
			},{
			“id”: 1456789746,
			“name”: “Dream Team 1 Burning Code 3”
			}]
	}]
}
```


## 1.6. Event Post Message <a name="16-event-post-message"></a>

New post message to allow users who are not logged in to the B2B site, to make their selection(s) and be taken to the correct page and with their selections added to the Bet Slip.

允许未登录到 B2B 网站的用户进行选择，并将其选择添加到投注单中并跳转到正确的页面。

**Process 步骤**

1.	Player makes a selection on a banner, the B2B site needs to store the selection information and open the login popup.<br/>
玩家在登入游戏前进行选择，B2B 网站需要存储选择信息并打开登录弹窗。

2.	In the login process, the B2B client must call loginV2 API with eventId parameter.<br/>
在登录过程中，B2B 客户端必须使用 eventId 参数调用 loginV2 API。

3.	After successful login, B2B site (frontend) sends the selection infoformation (from #1) to Iframe via postMessage, that selection will be available in the Bet Slip.<br/>成功登录后，B2B 网站（前端）通过 postMessage 将选择信息（来自步骤 #1）发送到 iframe，该选择将在投注单中可用。


*PostMessage Payload   postMessage 负载*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `msgCode`  | `String` | Value will be “selectionInfo”<br/>值将为 "selectionInfo"  |
| `msgData`  | Array of Message Data | Message data<br/>讯息数据 |


*Message Data　讯息数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `eventId`  | `integer<int64>` | Event ID 赛事ID  |
| `period`  | `integer<int32>` | Period number.　期间代码 |
| `betType`  | `String` | Enum　值  |
| `team`  | `String` | “HOME” or “AWAY” “主队”或“客队” |
| `altLineId`  | `integer<int64>` | Alternative Line ID　备用盘口ID  |
| `hdp`  | `number <double>` | Home team handicap.　主队让分盘<br/>Only populated for Spread.　仅适用于让分盘 |

*Sample 示例*

```js
{
	“msgCode”: “selectionInfo”,
	“msgData”: [{
		“eventId”: 12346781,
		“period”: 0,
		“betType”: “SPREAD”,
		“team”: “AWAY”,
		“altLineId”: 12346789,
		“hdp”: “0.5”
   	}
      ]
}
```


## 1.7. Bet Selection 投注选项 <a name="17-bet-selection"></a>

We have these type of Bet Selection to send from B2B site to Iframe via postMessage, the msgCode must be "selectionInfo"

**1 – Spread Selection** 1 - 让分盘选项

```js
{
  "msgCode": "selectionInfo",
  "msgData": [{
    "eventId": 1554532082,
    "period": 0,
    "betType": "SPREAD",
    "team": "HOME",
    "altLineId": 0,
    "hdp": 0.25,
  }]
}
```
| Field Name <br/> 字段名称  | Data Type <br/> 数据类型 |
| --- | --- |
| `eventId` | Number |
| `period` | Number |
| `betType` | String (SPREAD) |
| `team` | String (HOME , AWAY)  |
| `altLineId` | Number |
| `hdp` | Number |

**2 – Moneyline Selection** - 输赢盘选项

```js
{
 "msgCode": "selectionInfo",
 "msgData": [{
    "eventId": 1554532082,
    "period": 0,
    "betType": "MONEYLINE",
    "team": "HOME",
    "altLineId": 0,
    "hdp": 0.25,
  }]
}
```
| Field Name <br/> 字段名称  | Data Type <br/> 数据类型 |
| --- | --- |
| `eventId` | Number |
| `period` | Number |
| `betType` | String (MONEYLINE) |
| `team` | String (HOME , AWAY)  |
| `altLineId` | Number |
| `hdp` | Number |

**3 – Total Points Selection** - 总分投注盘选项

```js
{
 "msgCode": "selectionInfo",
 "msgData": [{
    "eventId": 1554532082,
    "period": 0,
    "betType": "TOTAL_POINTS",
    "altLineId": 0,
    "points": 3.0,
    "side": "OVER",
  }]
}
```
| Field Name <br/> 字段名称  | Data Type <br/> 数据类型 |
| --- | --- |
| `eventId` | Number |
| `period` | Number |
| `betType` | String (TOTAL_POINTS) |
| `altLineId` | Number  |
| `points` | Number |
| `side` | String (OVER , UNDER) |

**4 – Team Total Points Selection** - 球队总分盘选项

```js
{
 "msgCode": "selectionInfo",
 "msgData": [{
    "eventId": 1554532082,
    "period": 0,
    "betType": "TEAM_TOTAL_POINTS",
    "altLineId": 0,
    "points": 3.0,
    "team": "HOME",
    "side": "OVER",
  }]
}
```
| Field Name <br/> 字段名称  | Data Type <br/> 数据类型 |
| --- | --- |
| `eventId` | Number |
| `period` | Number |
| `betType` | String (TEAM_TOTAL_POINTS) |
| `altLineId` | Number  |
| `points` | Number |
| `team` | String (HOME , AWAY) |
| `side` | String (OVER , UNDER) |

**5 – Outright selection**

```js
{
 "msgCode": "selectionInfo",
 "msgData": [{
    "eventId": 1554532082,
    "period": 0,
    "betType": "OUTRIGHT",
    "hdp": 3.5,
    "contestantLineId": 1563789224,
    "altLineId": 0,
  }]
}
```
| Field Name <br/> 字段名称  | Data Type <br/> 数据类型 |
| --- | --- |
| `eventId` | Number |
| `period` | Number |
| `betType` | String (OUTRIGHT) |
| `hdp` | Number  |
| `contestantLineId` | Number |
| `altLineId` | Number |


## 1.8. Login and Bet Placement Screen　登录和投注下单页面 <a name="18-login-and-bet-placement-screen"></a>

After selecting the desired recommendations, the user must then submit the selections.

If the user is NOT logged in to the B2B website, they must be asked to log in (as per standard practice).

在选择推荐选项后，用户必须提交该选项。

如果用户没有登录到白牌网站，则必须要求其登录（按照标准流程）。

If the user is logged in to the B2B website, the site must make a call to the Login API (as per standard practice), then the user can be redirected to the bet placement screen.

To show the bet placement screen, the system must get the current odds for the game using the data saved in the bet selection.

如果用户已经登录到白牌网站，则网站必须调用Login API（按照标准流程），然后将用户重定向到投注下单页面。

为显示投注下单页面，系统必须使用保存在投注选项中的数据以获取赛事的当前赔率。


## 1.9. Error Responses　错误响应 <a name="19-error-responses"></a>

A successful response will return a response code of 200 OK. 

成功的响应将返回状态码 200 OK。

Unsuccessful responses are listed below:  

以下是不成功的响应：


**400 Bad Request**

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `code`  | `string` | Identifier representing the type of error that occurred.<br/>错误代码  |
| `message`  | `string` | Description of the error.<br/>描述错误  |


**401 Unauthorized**

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `code`  | `string` | Identifier representing the type of error that occurred.<br/>错误代码  |
| `message`  | `string` | Description of the error.<br/>描述错误  |


**403 Forbidden**

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `code`  | `string` | Identifier representing the type of error that occurred.<br/>错误代码  |
| `message`  | `string` | Description of the error.<br/>描述错误  |


**500 Internal Server Error**

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `ref`  | `string` | Unique reference.<br/>唯一参考值  |
| `code`  | `string` | Identifier representing the type of error that occurred.<br/>错误代码  |
| `message`  | `string` | Description of the error.<br/>描述错误  |

