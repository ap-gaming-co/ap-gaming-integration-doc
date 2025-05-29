
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

