
# Table Contents 目录
- [Table Contents 目录](#table-contents)
    - [1. Project Summary 项目概要](#1-project-summary)
        - [1.1. Objectives 目标](#11-objectives)
        - [1.2. Project Scope 项目框架](#12-project-scope)
        - [1.3. Prerequisites 前提条件](#13-prerequisites)
    - [2. Application Functionality 应用功能](#2-application-functionality)
        - [2.1.	Get Game Types (Esports Only)  获取游戏类型（仅适用于电竞）](#21-get-game-types)
        - [2.2.	Get Leagues 获取联赛](#22-get-leagues)
        - [2.3.	Get Fixtures 获取赛事](#23-get-fixtures)
        - [2.4.	Get Lines 获取盘口](#24-get-lines)
        - [2.5.	Get Special Lines 获取特殊盘口](#25-get-special-lines)
        - [2.6.	Event Post Message 赛事发布消息](#26-event-post-message)
        - [2.7.	Bet Selection　投注选项](#27-bet-selection)
        - [2.8.	Login and Bet Placement Screen　登录和投注下单页面](#28-login-and-bet-placement-screen)
        - [2.9.	Error Responses　错误响应](#29-error-responses)

# 1. Project Summary 项目概要 <a name="1-project-summary"></a>

## 1.1. Objectives 目标 <a name="11-objectives"></a>

To provide the necessary interfaces to enable sharing bets functionality.

Currently, this functionality is not available for White Label integration with our APIs. This means that WL users are not able to recommend our lines and odds.

旨在提供必要的接口以实现共享投注功能。

目前，该功能不适用于对接我方API的白牌用户。这意味着白牌用户将无法推荐我们的盘口和赔率。

## 1.2. Project Scope 项目框架 <a name="12-project-scope"></a>

This project will define the necessary interfaces to ensure that all required functionality is available to allow users to recommend and place bets.

The user interface for this functionality is outside the scope of this project.

该项目将定义必要的接口，以确保所有所需功能可用来允许用户推荐和投注。

此功能的用户界面不在此项目的范围之内。

## 1.3. Prerequisites 前提条件 <a name="13-prerequisites"></a>

The client must have the ability to access eSports enabled. This is disabled by default.

Without this facility enabled, the system will not be able to access any of the endpoints listed in this document.

客户端必须能够访问已启用的电竞界面。默认是关闭的。

如果未启用此功能，系统将无法访问本文档中列出的任何端点。

# 2. Application Functionality 应用功能 <a name="2-application-functionality"></a>

The website has a facility built in that allows logged in users to add bet recommendations.

These recommendations detail specific bets on an individual line on a particular game.

Users must be able to select the game that they want to recommend and then identify the particular line and the side on which to bet.

网站内置了允许已登录用户添加投注推荐的功能。

这些推荐详细说明了特定游戏中个别盘口的具体投注。

用户必须能够选择他们想要推荐的游戏，然后确定特定盘口和投注选择。

## 2.1. Get Game Types (Esports Only)  获取游戏类型（仅适用于电竞）<a name="21-get-game-types"></a>

The game types are only required for e-sports. 

仅适用于电竞的游戏类型

**GET Request Get 请求** <br/>
        `/sline/games`

*Parameters 参数*

| Parameter <br/>参数 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `hasOfferings`  | boolean | To retrieve ONLY games with odds available <br/>仅获取具有可用赔率的游戏 |
| `locale` | String | Return language for data. <br/>返回数据的语言设置 |


**Response 响应**

Returns Array of games. 返回游戏数组

*Game Data  游戏数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `id`  | integer<int32> | Unique Id of the game游戏ID |
| `name` | String | Game name游戏名称 |

*Sample 示例*

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

## 2.2. Get Leagues 获取联赛 <a name="22-get-leagues"></a>

Gets the leagues for the requested sport. 

获取所请求体育项目的联赛。

**GET Request GET请求** <br/>
        `/sline/leagues`

*Parameters 参数*

| Parameter <br/>参数 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `sportId` <br/>**required** <br/>**必需**  | integer<int32> | Sport id for which the leagues are requested. <br/>请求特定联赛中的体育项目ID |
| `gameIds` | Array of integers <int32> | A comma separated list of Game Ids for e-sports games. <br/>If none supplied, all esports games are returned. <br/>Ignored for all other sports. <br/>电竞游戏的游戏ID列表，以逗号分隔 <br/>如果未提供逗号，则返回所有电竞游戏 <br/>对于其他体育项目，此参数将被忽略 |
| `hasOfferings`  | boolean | To retrieve ONLY leagues with odds available <br/>仅获取具有可用赔率的联赛 |
| `locale`  | String | Return language for data. <br/>返回数据的语言设置 |

**Response 响应**

Returns Array of leagues. 返回联赛的数组

*League Data 联赛数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `id`  | integer<int32> | Unique Id of the league联赛ID |
| `name` | String | League name联赛名称 |
| `hasOfferings` | boolean | Whether the league currently has events or specials. <br/>获取有提供赛事盘口或者特别盘口的联赛 |
| `leagueSpecialsCount` | integer<int32> | Indicates how many specials are in the given league. <br/>列明联赛里有多少个特别盘口 |
| `eventSpecialsCount` | integer<int32> | Indicates how many game specials are in the given league. <br/>列明联赛里有多少个特别赛事盘口 |
| `eventCount` | integer<int32> | Indicates how many events are in the given league. <br/>列明联赛里有多少个赛事 |

*Sample 示例*

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

**Esports Leagues 电竞联赛**

For eSports, the League name is taken from the **name** field. The name field shows the game type and the league as in the example below:

            CS:GO - ESL Challenger League North America

The format is always {game} – {league}

在我司的电竞，联赛名称是从 **name** 字段里获取。 name 字段将会以以下方式呈现：

            CS:GO - ESL Challenger League North America

格式始终为 {游戏} - {联赛}。

## 2.3. Get Fixtures 获取赛事 <a name="23-get-fixtures"></a>

Gets the fixtures for the requested league. 

获取游戏开盘日期、时间，以及主队与客队讯息

**GET Request GET请求** <br/>
        `/sline/fixtures`

*Parameters 参数*

| Parameter <br/>参数 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `sportId` <br/>**required** <br/>**必需**  | integer<int32> | Sport id for which the fixtures are requested. <br/>所请求赛事的体育项目ID |
| `leagueId` <br/>**required** <br/>**必需**  | integer<int32> | The league id for which the fixtures are requested. <br/>所请求赛事的联赛ID |
| `locale`  | String | Return language for data. <br/>返回数据的语言设置 |

**Response 响应**

Returns a list of unique fixtures.

If a fixture has regular events and specials, the fixture will only return once.

返回唯一赛事的列表

如果一个赛事具有常规盘口和特殊盘口，该赛事只会返回一次

*Fixture Data  赛事数据* 

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `sportId`  | integer<int32> | Requested sport Id.<br/>体育ID |
| `leagueId`  | integer<int32> | Requested league id.<br/>联赛ID |
| `event`  | Array of objects (EventFixture) | Contains a list of events.<br/>赛事ID |

*EventFixture Data  赛事数据* 

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `eventId`  | integer<int32> | Event Id. 赛事ID |
| `starts`  | String<date-time> | Game date time. 比赛日期时间 |
| `home`  | String | Home team. 主队名称 |
| `away`  | String | Away team. 客队名称 |
| `lines`  | integer<int32> | Indicates how many lines are in the given event.<br/>列明给定赛事的盘口数 |

*Sample 示例*

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

## 2.4. Get Lines 获取盘口 <a name="24-get-lines"></a>

Gets the standard lines for the requested event. 

获取所请求赛事的一般盘口

**GET Request GET请求** <br/>
        `/sline/lines`

*Parameters 参数*

| Parameter <br/>参数 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `sportId` <br/>**required** <br/>**必需**  | integer<int32> | Sport id for which the fixtures are requested. <br/>体育ID |
| `leagueId` <br/>**required** <br/>**必需**  | integer<int32> | The league id for which the fixtures are requested. <br/>联赛ID |
| `eventId` <br/>**required** <br/>**必需**  | integer<int32> | The event id for which the fixtures are requested. <br/>赛事ID |
| `locale`  | String | Return language for data. <br/>返回数据的语言设置 |

**Response 响应**

Returns a list of unique lines. 返回唯一盘口的列表。

Returns standard lines. 返回一般盘口。

*Line Data 盘口数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `sportId`  | integer<int32> | Requested sport Id. 体育ID |
| `leagueId`  | integer<int32> | Requested league id. 联赛ID |
| `eventId`  | integer<int32> | Requested event id. 赛事ID |
| `eventDateFm`  | String<date-time> | Event date赛事日期 |
| `eventName`  | String | Event Name赛事名称 |
| `home`  | String | Home team. 主队名称 |
| `homeLogo`  | String(URL) | Home team logo. 主队标识<br/>Only for Esports. 仅适用于电竞 |
| `away`  | String | Away team. 客队名称 |
| `awayLogo`  | String(URL) | Away team logo. 客队标识<br/>Only for Esports. 仅适用于电竞 |
| `line`  | Array of objects (EventLine) | Contains a list of lines. 赛事讯息 |


*EventLine Data 盘口数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `Id`  | integer<int64> | Line Id. 盘口ID |
| `altLineId`  | integer<int64> | Only populated if this is an alternate line. <br/>让分盘里的替代盘口 |
| `periodNumber`  | integer<int32> | Period number. 期间代码 |
| `points`  | number <double> | Populated for “TOTAL_POINTS”, “HOME_TEAM_TOTAL_POINTS”, “AWAY_TEAM_TOTAL_POINTS”<br/>适用于 “TOTAL_POINTS”、“HOME_TEAM_TOTAL_POINTS”，“AWAY_TEAM_TOTAL_POINTS” |
| `hdp`  | number <double> | Team handicap. 队伍让分盘<br/>Populated for “SPREAD’  适用于“让分盘’ |
| `betType`  | String | Enum value 值<br/>“SPREAD’, “MONEYLINE”, “TOTAL_POINTS”, “HOME_TEAM_TOTAL_POINTS”, “AWAY_TEAM_TOTAL_POINTS” |
| `cutoff`  | String<date-time> | Betting cutoff date 投注截止日期 |

*Sample 示例*

```js
{
	“sportId”: 12,
	“leagueId”: 134567,
	“eventId”: 13456784,
“eventDateFm”: “2022-07-01T15:30:00Z”,
      “eventName”: "Dream Team vs Burning Code",
      “home”: “Dream Team”,
      "homeLogo": null,
      “away”: “Burning Code”,
      "awayLogo": null,
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

## 2.5. Get Special Lines 获取特殊盘口 <a name="25-get-special-lines"></a>

Gets the special lines for the requested event. 

获取指定赛事的特殊盘口

**GET Request GET请求** <br/>
        `/sline/special-lines`

*Parameters 参数*

| Parameter <br/>参数 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `sportId` <br/>**required** <br/>**必需**  | integer<int32> | Sport id for which the fixtures are requested. <br/>体育ID |
| `leagueId` <br/>**required** <br/>**必需**  | integer<int32> | The league id for which the fixtures are requested. <br/>联赛ID |
| `eventId` <br/>**required** <br/>**必需**  | integer<int32> | The event id for which the fixtures are requested. <br/>赛事ID |
| `locale`  | String | Return language for data. <br/>返回数据的语言设置 |

**Response　响应**

Returns a list of unique lines.　 返回唯一盘口的列表。

Returns special lines.　 返回特殊盘口。

*Line Data　盘口数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `sportId`  | integer<int32> | Requested sport Id.　体育ID |
| `leagueId`  | integer<int32> | Requested league id. 联赛ID |
| `eventId`  | integer<int32> | Requested event id.　赛事ID |
| `eventDateFm`  | String<date-time> | Event date　赛事日期 |
| `eventName`  | String | Event Name　赛事名称 |
| `home`  | String | Home team. 主队名称 |
| `homeLogo`  | String(URL) | Home team logo. 主队标识<br/>Only for Esports. 仅适用于电竞 |
| `away`  | String | Away team. 客队名称 |
| `awayLogo`  | String(URL) | Away team logo. 客队标识<br/>Only for Esports. 仅适用于电竞 |
| `specials`  | Array of objects (Specials) | Contains a list of special lines.　特殊盘口讯息 |


*Specials Data　特殊盘口数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `Id`  | integer<int64> | Special Id.　特殊盘口ID |
| `name`  | String | Special name  特殊盘口名称 |
| `category`  | String | Special category  特殊盘口类别 |
| `periodNumber`  | integer<int32> | Period number.  期间代码 |
| `betType`  | String | Enum value 值<br/>“MULTI_WAY_HEAD_TO_HEAD”, “SPREAD”, “OVER_UNDER” |
| `cutoff`  | String<date-time> | Betting cutoff date 投注截止日期 |
| `units`  | String | Measurement. Applicable to SPREAD and OVER_UNDER. <br/>单位。适用于让分和大小盘。 |
| `contestants`  | Array of objects (Contestants) | Contains a list of contestants. <br/>参赛者讯息 |


*Contestants Data  参赛者数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `Id`  | integer<int64> | Contestant Id. 参赛者ID |
| `name`  | String | Contestant name 参赛者名称 |
| `contestantLineId`  | Integer<int64> | Contestant Line Id 参赛者盘口ID |
| `hdp`  | number <double> | Team handicap队伍让分盘<br/>Populated for “SPREAD” and “OVER_UNDER” 适用于让分和大小盘 |

*Sample 示例*

```js
{
      “sportId”: 12,
      “leagueId”: 134567,
      “eventId”: 13456784,
      “eventDateFm”: “2022-07-01T15:30:00Z”,
      “eventName”: "Dream Team vs Burning Code",
      “home”: “Dream Team”,
      "homeLogo": null,
      “away”: “Burning Code”,
      "awayLogo": null,
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

## 2.6. Event Post Message 赛事发布消息 <a name="26-event-post-message"></a>

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
| `msgCode`  | String | Value will be “selectionInfo”<br/>值将为 "selectionInfo"  |
| `msgData`  | Array of Message Data | Message data<br/>讯息数据 |


*Message Data　讯息数据*

| Field <br/>字段 | Data Type <br/>数据类型 | Notes <br/>说明 |
| --- | --- | --- |
| `eventId`  | integer<int64> | Event ID 赛事ID  |
| `period`  | integer<int32> | Period number.　期间代码 |
| `betType`  | String | Enum　值  |
| `team`  | String | “HOME” or “AWAY” “主队”或“客队” |
| `altLineId`  | integer<int64> | Alternative Line ID　备用盘口ID  |
| `hdp`  | number <double> | Home team handicap.　主队让分盘<br/>Only populated for Spread.　仅适用于让分盘 |

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

## 2.7. Bet Selection　投注选项 <a name="27-bet-selection"></a>

On selection of the bet, the system must save the details of the bet as part of the recommendation.

在选择投注时，作为推荐的一部分，系统必须将投注的详细信息保存。

**Straight Bets　直接投注**

Fields that must be stored for all standard bets:　 对于所有一般投注，必须存储以下字段：

•	SportId　（体育ID）
•	EventId　（赛事ID）
•	PeriodNumber （期间代码）
•	BetType （投注类型）
•	LineId （盘口ID）
•	AltLineId （备用盘口ID）

Other fields are required depending on the bet type.　 其他字段取决于投注类型而有所不同。

*Spread　让分盘*

Fields that are required for Spread bet type:　 对于让分投注类型，需要以下字段：

•	Team (Whether TEAM1 OR TEAM2 was selected)　（选择TEAM1还是TEAM2）
•	Handicap (Amount of handicap)　（让分）

*Moneyline　输赢盘*

•	Team (Whether TEAM1, TEAM2, DRAW was selected)　（选择TEAM1、TEAM2还是“和”）
Totals　总分盘
•	Side (Whether Over or Under was selected)　 （选择Over还是Under）
•	Handicap (Amount of handicap)　 （让分）

*Team Total　球队总分盘*

•	Choice (Whether Home or Away was selected)　 （选择主队还是客队）
•	Choice (Whether Over or Under was selected)　 （选择Over还是Under）
•	Handicap (Amount of handicap)　 （让分）

**Special Bets　特殊投注**

Fields that must be stored for all special bets:　 对于所有特殊投注，必须存储以下字段：

•	LineId　盘口ID
•	SpecialId 特殊盘口ID
•	contestantId  参赛者ID
 
