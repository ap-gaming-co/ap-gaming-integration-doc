
# Data Format

- [Data Format](#data-format)
    - [1. Sports](#1-sports)
    - [2. Wager Type](#2-wager-type)
    - [3. Bet Type](#3-bet-type)
    - [4. Odds Format](#4-odds-format)
    - [5. Date Time](#5-date-time)
    - [6. Errors Table](#6-errors-table)
    - [7. Event Status](#7-event-status)
    - [8. Languages](#8-languages)
    - [9. Selection Type](#9-selection-type)
    - [10. Wager Result](#10-wager-result)
    - [11. Wager Status](#11-wager-status)
    - [12. Period Status](#12-period-status)
    - [13. User Status](#13-user-status)
    - [14. Leg Status Result](#14-leg-status-result)
    - [15. Non-login currency display](#15-non-login-currency-display)
    - [16. Bet Status Partial Result](#16-bet-status-partial-result)


## 1. Sports

| Id | Code |
| --- | --- |
| 1 | Badminton |
| 2 | Bandy
| 3 | Baseball
| 4 | Basketball
| 5 | Beach Volleyball
| 6 | Boxing
| 7 | Chess
| 8 | Cricket
| 9 | Curling
| 10 | Darts |
| 11 | Darts (Legs) |
| 12 | E-Sports |
| 13 | Field Hockey |
| 14 | Floorball |
| 15 | Football |
| 16 | Futsal |
| 17 | Golf |
| 18 | Handball |
| 19 | Hockey | 
| 20 | Horse Racing Specials |
| 21 | Lacrosse | 
| 22 | Mixed Martial Arts |
| 23 | Other Sports |
| 24 | Politics |
| 26 | Rugby League |
| 27 | Rugby Union |
| 28 | Snooker |
| 29 | Soccer |
| 30 | Softball |
| 31 | Squash |
| 32 | Table Tennis |
| 33 | Tennis |
| 34 | Volleyball |
| 35 | Volleyball (Points) |
| 36 | Water Polo |
| 37 | Padel Tennis |
| 39 | Aussie Rules |
| 40 | Alpine Skiing |
| 41 | Biathlon |
| 42 | Ski Jumping |
| 43 | Cross Country |
| 44 | Formula 1 |
| 45 | Cycling |
| 46 | Bobsleigh |
| 47 | Figure Skating |
| 48 | Freestyle Skiing |
| 49 | Luge |
| 50 | Nordic Combined |
| 51 | Short Track |
| 52 | Skeleton |
| 53 | Snow Boarding |
| 54 | Speed Skating |
| 55 | Olympics |
| 56 | Athletics |
| 57 | CrossFit |
| 58 | Entertainment |
| 59 | Archery |
| 60 | Drone Racing |
| 61 | MLB Series Prices |
| 62 | Poker |
| 63 | Motorsport |
| 64 | Simulated Games |
| 65 | Sumo |
| 66 | Slap Fighting |

## 2. Wager Type

| Id | Code | Description |
| --- | --- | --- |
| 1 | `single` | Wager type is Single |
| 2 | `parlay` | Wager type is Parlay |
| 3 | `teaser` | Wager type is Teaser |

## 3. Bet Type

| Code  | Name | Description | 
| ---  | ---  | ---  |
| 1 | `ML_1X2` |  1x2| 
| 2 | `HDP` |  Handicap| 
| 3 | `OU` |  Over Under| 
| 4 | `HOME_TOTALS` | | 
| 5 | `AWAY_TOTALS` | | 
| 6 | `MIX_PARLAY` | | 
| 7 | ``TEASER`` | | 
| 8 | `MANUAL_PLAY` | | 
| 97 | `OE` | Odd Even| 
| 99 | `SPECIAL`/`OUTRIGHT` | | 

## 4. Odds Format

| Code | Name  | Description |
| --- | ---  | ---   |
| 0 | `AM` | American odds format |
| 1 | `EU` | Euro odds format |
| 2 | `HK` | Hong Kong odds format |
| 3 | `ID` | Indo odds format |
| 4 | `MY` | Malay odds format |

## 5. Date Time 

All dates will be in **GMT-4** except Timestamp. 
Date Time format: `yyyy-MM-ddTHH:mm:ss`
E.g. `2018-12-20T04:05:06`

## 6. Errors Table

| Code | Message |  Description  |
| --- | ---  |  ---   |
| 103 | Your player's account has been < status >. |  |
| 104 | Member not exist in system. |  |
| 105 | The user creation failed. |  |
| 106 | User locked by multiplelogin failures. |  |
| 107 | Agent doesn’t have key stored in the system. |  |
| 108 | Agent code is invalid. Please contact partner to get agent code. |  |
| 109 | You are not allowed to create player under agent code who is not directly downline. |  |
| 110 | Agent does not exist in system. |  |
| 111 | Login ID already exists in system. |  |
| 112 | Login ID is not valid. |  |
| 113 | User's brand does not support login. |  |
| 114 | Cannot change status when user is Closed or Suspended by Company. |  |
| 115 | User account hasn't exist in system. |  |
| 116 | You could not create more downline because you reached the maximum limitation. |  |
| 305 | Player has no permission create key store. |  |
| 306 | Invalid parameters. You will have information in message of error. |  |
| 307 | Account Balance do not exist in system. |  |
| 308 | Your amount should be a positive number |  |
| 309 | Your balance is not enough. |  |
| 310 | Your balance exceeded credit limit. |  |
| 311 | Amount value should be two decimal places. |  |
| 401 | The token is invalid. It’s possible the token is wrong or that it has expired. |  |
| 403 | The code for this token has not yet been generatedThe token for this brand is still not generated. |  |
| 405 | Your wallet does not exist in system. |  |
| 406 | Your wallet is inactive. |  |
| 407 | Invalid product. |  |
| 423 | Your account is . Please contact your upline for help. | When the agentCodes are INACTIVE/SUSPENDED and CLOSED, it will display the errorCode 423.  |

## 7. Event Status

| No | Code | Description |
| --- | --- | --- |
| 1 | `OPEN` | Event is open for bet placement. |
| 2 | `CLOSE` | Event is closed. Players cannot place a bet. |
| 3 | `SETTLED` | Event is done. Wagers is going to be settled. |

## 8. Languages 语言

| Locale code 区域代码 | Description 描述   |
| --- | --- |
| en | English |
| zh-cn | Simplified Chinese (简体中文) |
| zh-tw | Traditional Chinese (繁體中文) |
| id | Indonesian |
| vi | Vietnamese (Tiếng Việt) |
| ja | Japanese (日本語) |
| ko | Korean (한국어) | 
| th | Thai (ภาษา ไทย) | 
| fr | French (Français) |
| de | German (Deutsch) |
| es | Spanish (Español) |
| pt | Brazilian Portuguese | 
| ru | Russian (Русский ) |
| tr | Turkish |
| hi | Hindi | 
| hy | Armenian |
| ka | Georgian |
| uk | Ukrainian |
| he | Hebrew |
| km | Khmer |
| sv | Swedish |
| fi | Finnish |
| no | Norwegian |
| it | Italian |
| tl | Filipino|

## 9. Selection Type 选择类型

| Code 代码 | Name 名称 | Description  描述 | 
| ---  | ---  | ---   | 
| 0 | `HOME` 主队 | Home team is selected 选定"主队" |
| 1 | `AWAY` 客队 | Away team is selected 选定"客队" |
| 2 | `DRAW` 和局 | Draw is selected 选定"和局" |
| 3 | `OVER` 大 | Over is selected 选定"大" |
| 4 | `UNDER` 小 | Under is selected 选定"小" |
| 5 | `HOME_OVER` 主队大 | Home over is selected 选定"主队大" |
| 6 | `HOME_UNDER` 主队小 | Home under is selected 选定"主队小" |
| 7 | `AWAY_OVER` 客队大 | Away over is selected 选定"客队大" |
| 8 | `AWAY_UNDER` 客队小 | Away under is selected 选定"客队小" |
| 9 | `ODD` 单数 | Odd type is selected 选定"单数" |
| 10 | `EVEN` 双数 | Even type is selected 选定"双数" |
| 11 | `TEAM` 队伍 | Team type is selected 选定"队伍" |

## 10. Wager Result 注单结果 

| Code  代码 | Name 名称 | Description  描述 |
| ---  | ---  | ---   |
| `WIN` | Wager has been settled as win<br/>注单已结算为赢。 |  |
| `LOSE` | Wager has been settled as lose<br/>注单已结算为输。 |  |
| `DRAW` | Wager has been settled as draw<br/>注单已结算为平局。 |  |
| `HALF_WON_HALF_PUSHED` | Wager has been settled as half win<br/>注单已结算为赢一半。 |  |
| `HALF_LOST_HALF_PUSHED` | Wager has been settled as half lose<br/>注单已结算为输一半。 |  |

## 11. Wager Status 注单状态

| Code 代码 | Name 名称 | Description  描述 |
| ---  | ---  | ---   |
| `PENDING`  | Wager is pending<br/>注单未结算 |  |
| `OPEN`  | Wager is opening<br/>等待中 |  |
| `SETTLED`  | Wager was settled<br/>注单已结算 |  |
| `CANCELLED`  | Wager was cancelled <br/>注单被取消 |  |

## 12. Period Status 期间状态

| Code 代码 | Name 名称 | Description 描述 |
| --- | --- | --- |
| 0 | Badminton 羽毛球 | Match 赛事 | 
| 1 | Badminton 羽毛球 | 1st Game_Badminton 第一场比赛_羽毛球 | 
| 2 | Badminton 羽毛球 | 2nd Game_Badminton 第二场比赛_羽毛球 | 
| 3 | Badminton 羽毛球 | 3rd Game_Badminton 第三场比赛_羽毛球 | 
| 0 | Bandy 班迪球 | Match 赛事 | 
| 1 | Bandy 班迪球 | 1st Half 上半场 | 
| 2 | Bandy 班迪球 | 2nd Half 下半场 | 
| 0 | Baseball 棒球 | Game 赛事 | 
| 1 | Baseball 棒球 | 1st Half 上半场 | 
| 2 | Baseball 棒球 | 2nd Half 下半场 | 
| 3 | Baseball 棒球 | 1st Inning 第一局 | 
| 4 | Baseball 棒球 | 2nd Inning 第二局 | 
| 5 | Baseball 棒球 | 3nd Inning 第三局 | 
| 6 | Baseball 棒球 | 4nd Inning 第四局 | 
| 7 | Baseball 棒球 | 5th Inning 第五局 | 
| 8 | Baseball 棒球 | 6th Inning 第六局 | 
| 9 | Baseball 棒球 | 7th Inning 第七局 | 
| 10 | Baseball 棒球 | 8th Inning 第八局 | 
| 11 | Baseball 棒球 | 9th Inning 第九局 | 
| 12 | Baseball 棒球 | 1-7 Innings 第一局至第七局 | 
| 0 | Basketball 篮球 | Game 赛事 | 
| 1 | Basketball 篮球 | 1st Half 上半场 | 
| 2 | Basketball 篮球 | 2nd Half 下半场 | 
| 3 | Basketball 篮球 | 1st Quarter 第一节 | 
| 4 | Basketball 篮球 | 2nd Quarter 第二节 | 
| 5 | Basketball 篮球 | 3rd Quarter 第三节 | 
| 6 | Basketball 篮球 | 4th Quarter 第四节 | 
| 0 | Beach Volleyball 沙滩排球 | Match 赛事 | 
| 1 | Beach Volleyball 沙滩排球 | 1st Set 首盘 | 
| 2 | Beach Volleyball 沙滩排球 | 2nd Set 第二盘 | 
| 3 | Beach Volleyball 沙滩排球 | 3rd Set 第三盘 | 
| 0 | Boxing 拳击 | Fight 拳击 | 
| 0 | Chess 西洋棋 | Match 赛事 | 
| 0 | Cricket 板球、木球 | Match 赛事 | 
| 1 | Cricket 板球、木球 | 1st Inning 第一局 | 
| 2 | Cricket 板球、木球 | 2nd Inning 第二局 | 
| 0 | Curling 冰壶 | Game 赛事 | 
| 1 | Curling 冰壶 | 1st End 第一场结束 | 
| 0 | Darts 飞镖 | Match 赛事 | 
| 1 | Darts 飞镖 | 1st Set 首盘 | 
| 2 | Darts 飞镖 | 2nd Set 第二盘 | 
| 3 | Darts 飞镖 | 3rd Set 第三盘 | 
| 4 | Darts 飞镖 | 4th Set 第四盘 | 
| 5 | Darts 飞镖 | 5th Set 第五盘 | 
| 0 | Darts (Legs) 飞镖 （局) | Match赛事 | 
| 1 | Darts (Legs) 飞镖 （局) | 1st Leg第一局 | 
| 2 | Darts (Legs) 飞镖 （局) | 2nd Leg第二局 | 
| 3 | Darts (Legs) 飞镖 （局) | 3rd Leg第三局 | 
| 4 | Darts (Legs) 飞镖 （局) | 4th Leg第四局 | 
| 5 | Darts (Legs) 飞镖 （局) | 5th Leg第五局 | 
| 6 | Darts (Legs) 飞镖 （局) | 6th Leg第六局 | 
| 0 | E Sports电子竞技 | Match赛事 | 
| 1 | E Sports电子竞技 | Map 1地图一 | 
| 2 | E Sports电子竞技 | Map 2地图二 | 
| 3 | E Sports电子竞技 | Map 3地图三 | 
| 4 | E Sports电子竞技 | Map 4地图四 | 
| 5 | E Sports电子竞技 | Map 5地图五 | 
| 6 | E Sports电子竞技 | Map 6地图六 | 
| 7 | E Sports电子竞技 | Map 7地图七 | 
| 8 | E Sports电子竞技 | Map 8 | 
| 9 | E Sports电子竞技 | Map 9 | 
| 10 | E Sports电子竞技 | Map 10 | 
| 11 | E Sports电子竞技 | Map 1 1st Half | 
| 12 | E Sports电子竞技 | Map 2 1st Half | 
| 13 | E Sports电子竞技 | Map 3 1st Half | 
| 14 | E Sports电子竞技 | Map 4 1st Half | 
| 15 | E Sports电子竞技 | Map 5 1st Half | 
| 16 | E Sports电子竞技 | Map 6 1st Half | 
| 17 | E Sports电子竞技 | Map 7 1st Half | 
| 18 | E Sports电子竞技 | Map 1 Round 1 | 
| 19 | E Sports电子竞技 | Map 1 Round 2 | 
| 20 | E Sports电子竞技 | Map 1 Round 3 | 
| 21 | E Sports电子竞技 | Map 1 Round 4 | 
| 22 | E Sports电子竞技 | Map 1 Round 5 | 
| 23 | E Sports电子竞技 | Map 1 Round 6 | 
| 24 | E Sports电子竞技 | Map 1 Round 7 | 
| 25 | E Sports电子竞技 | Map 1 Round 8 | 
| 26 | E Sports电子竞技 | Map 1 Round 9 | 
| 27 | E Sports电子竞技 | Map 1 Round 10 | 
| 28 | E Sports电子竞技 | Map 1 Round 11 | 
| 29 | E Sports电子竞技 | Map 1 Round 12 | 
| 30 | E Sports电子竞技 | Map 1 Round 13 | 
| 31 | E Sports电子竞技 | Map 1 Round 14 | 
| 32 | E Sports电子竞技 | Map 1 Round 15 | 
| 33 | E Sports电子竞技 | Map 1 Round 16 | 
| 34 | E Sports电子竞技 | Map 1 Round 17 | 
| 35 | E Sports电子竞技 | Map 1 Round 18 | 
| 36 | E Sports电子竞技 | Map 1 Round 19 | 
| 37 | E Sports电子竞技 | Map 1 Round 20 | 
| 38 | E Sports电子竞技 | Map 1 Round 21 | 
| 39 | E Sports电子竞技 | Map 1 Round 22 | 
| 40 | E Sports电子竞技 | Map 1 Round 23 | 
| 41 | E Sports电子竞技 | Map 1 Round 24 | 
| 42 | E Sports电子竞技 | Map 1 Round 25 | 
| 43 | E Sports电子竞技 | Map 1 Round 26 | 
| 44 | E Sports电子竞技 | Map 1 Round 27 | 
| 45 | E Sports电子竞技 | Map 1 Round 28 | 
| 46 | E Sports电子竞技 | Map 1 Round 29 | 
| 47 | E Sports电子竞技 | Map 1 Round 30 | 
| 48 | E Sports电子竞技 | Map 1 Round 31 | 
| 49 | E Sports电子竞技 | Map 1 Round 32 | 
| 50 | E Sports电子竞技 | Map 1 Round 33 | 
| 51 | E Sports电子竞技 | Map 1 Round 34 | 
| 52 | E Sports电子竞技 | Map 1 Round 35 | 
| 53 | E Sports电子竞技 | Map 1 Round 36 | 
| 54 | E Sports电子竞技 | Map 2 Round 1 | 
| 55 | E Sports电子竞技 | Map 2 Round 2 | 
| 56 | E Sports电子竞技 | Map 2 Round 3 | 
| 57 | E Sports电子竞技 | Map 2 Round 4 | 
| 58 | E Sports电子竞技 | Map 2 Round 5 | 
| 59 | E Sports电子竞技 | Map 2 Round 6 | 
| 60 | E Sports电子竞技 | Map 2 Round 7 | 
| 61 | E Sports电子竞技 | Map 2 Round 8 | 
| 62 | E Sports电子竞技 | Map 2 Round 9 | 
| 63 | E Sports电子竞技 | Map 2 Round 10 | 
| 64 | E Sports电子竞技 | Map 2 Round 11 | 
| 65 | E Sports电子竞技 | Map 2 Round 12 | 
| 66 | E Sports电子竞技 | Map 2 Round 13 | 
| 67 | E Sports电子竞技 | Map 2 Round 14 | 
| 68 | E Sports电子竞技 | Map 2 Round 15 | 
| 69 | E Sports电子竞技 | Map 2 Round 16 | 
| 70 | E Sports电子竞技 | Map 2 Round 17 | 
| 71 | E Sports电子竞技 | Map 2 Round 18 | 
| 72 | E Sports电子竞技 | Map 2 Round 19 | 
| 73 | E Sports电子竞技 | Map 2 Round 20 | 
| 74 | E Sports电子竞技 | Map 2 Round 21 | 
| 75 | E Sports电子竞技 | Map 2 Round 22 | 
| 76 | E Sports电子竞技 | Map 2 Round 23 | 
| 77 | E Sports电子竞技 | Map 2 Round 24 | 
| 78 | E Sports电子竞技 | Map 2 Round 25 | 
| 79 | E Sports电子竞技 | Map 2 Round 26 | 
| 80 | E Sports电子竞技 | Map 2 Round 27 | 
| 81 | E Sports电子竞技 | Map 2 Round 28 | 
| 82 | E Sports电子竞技 | Map 2 Round 29 | 
| 83 | E Sports电子竞技 | Map 2 Round 30 | 
| 84 | E Sports电子竞技 | Map 2 Round 31 | 
| 85 | E Sports电子竞技 | Map 2 Round 32 | 
| 86 | E Sports电子竞技 | Map 2 Round 33 | 
| 87 | E Sports电子竞技 | Map 2 Round 34 | 
| 88 | E Sports电子竞技 | Map 2 Round 35 | 
| 89 | E Sports电子竞技 | Map 2 Round 36 | 
| 90 | E Sports电子竞技 | Map 3 Round 1 | 
| 91 | E Sports电子竞技 | Map 3 Round 2 | 
| 92 | E Sports电子竞技 | Map 3 Round 3 | 
| 93 | E Sports电子竞技 | Map 3 Round 4 | 
| 94 | E Sports电子竞技 | Map 3 Round 5 | 
| 95 | E Sports电子竞技 | Map 3 Round 6 | 
| 96 | E Sports电子竞技 | Map 3 Round 7 | 
| 97 | E Sports电子竞技 | Map 3 Round 8 | 
| 98 | E Sports电子竞技 | Map 3 Round 9 | 
| 99 | E Sports电子竞技 | Map 3 Round 10 | 
| 100 | E Sports电子竞技 | Map 3 Round 11 | 
| 101 | E Sports电子竞技 | Map 3 Round 12 | 
| 102 | E Sports电子竞技 | Map 3 Round 13 | 
| 103 | E Sports电子竞技 | Map 3 Round 14 | 
| 104 | E Sports电子竞技 | Map 3 Round 15 | 
| 105 | E Sports电子竞技 | Map 3 Round 16 | 
| 106 | E Sports电子竞技 | Map 3 Round 17 | 
| 107 | E Sports电子竞技 | Map 3 Round 18 | 
| 108 | E Sports电子竞技 | Map 3 Round 19 | 
| 109 | E Sports电子竞技 | Map 3 Round 20 | 
| 110 | E Sports电子竞技 | Map 3 Round 21 | 
| 111 | E Sports电子竞技 | Map 3 Round 22 | 
| 112 | E Sports电子竞技 | Map 3 Round 23 | 
| 113 | E Sports电子竞技 | Map 3 Round 24 | 
| 114 | E Sports电子竞技 | Map 3 Round 25 | 
| 115 | E Sports电子竞技 | Map 3 Round 26 | 
| 116 | E Sports电子竞技 | Map 3 Round 27 | 
| 117 | E Sports电子竞技 | Map 3 Round 28 | 
| 118 | E Sports电子竞技 | Map 3 Round 29 | 
| 119 | E Sports电子竞技 | Map 3 Round 30 | 
| 120 | E Sports电子竞技 | Map 3 Round 31 | 
| 121 | E Sports电子竞技 | Map 3 Round 32 | 
| 122 | E Sports电子竞技 | Map 3 Round 33 | 
| 123 | E Sports电子竞技 | Map 3 Round 34 | 
| 124 | E Sports电子竞技 | Map 3 Round 35 | 
| 125 | E Sports电子竞技 | Map 3 Round 36 | 
| 126 | E Sports电子竞技 | Map 4 Round 1 | 
| 127 | E Sports电子竞技 | Map 4 Round 2 | 
| 128 | E Sports电子竞技 | Map 4 Round 3 | 
| 129 | E Sports电子竞技 | Map 4 Round 4 | 
| 130 | E Sports电子竞技 | Map 4 Round 5 | 
| 131 | E Sports电子竞技 | Map 4 Round 6 | 
| 132 | E Sports电子竞技 | Map 4 Round 7 | 
| 133 | E Sports电子竞技 | Map 4 Round 8 | 
| 134 | E Sports电子竞技 | Map 4 Round 9 | 
| 135 | E Sports电子竞技 | Map 4 Round 10 | 
| 136 | E Sports电子竞技 | Map 4 Round 11 | 
| 137 | E Sports电子竞技 | Map 4 Round 12 | 
| 138 | E Sports电子竞技 | Map 4 Round 13 | 
| 139 | E Sports电子竞技 | Map 4 Round 14 | 
| 140 | E Sports电子竞技 | Map 4 Round 15 | 
| 141 | E Sports电子竞技 | Map 4 Round 16 | 
| 142 | E Sports电子竞技 | Map 4 Round 17 | 
| 143 | E Sports电子竞技 | Map 4 Round 18 | 
| 144 | E Sports电子竞技 | Map 4 Round 19 | 
| 145 | E Sports电子竞技 | Map 4 Round 20 | 
| 146 | E Sports电子竞技 | Map 4 Round 21 | 
| 147 | E Sports电子竞技 | Map 4 Round 22 | 
| 148 | E Sports电子竞技 | Map 4 Round 23 | 
| 149 | E Sports电子竞技 | Map 4 Round 24 | 
| 150 | E Sports电子竞技 | Map 4 Round 25 | 
| 151 | E Sports电子竞技 | Map 4 Round 26 | 
| 152 | E Sports电子竞技 | Map 4 Round 27 | 
| 153 | E Sports电子竞技 | Map 4 Round 28 | 
| 154 | E Sports电子竞技 | Map 4 Round 29 | 
| 155 | E Sports电子竞技 | Map 4 Round 30 | 
| 156 | E Sports电子竞技 | Map 4 Round 31 | 
| 157 | E Sports电子竞技 | Map 4 Round 32 | 
| 158 | E Sports电子竞技 | Map 4 Round 33 | 
| 159 | E Sports电子竞技 | Map 4 Round 34 | 
| 160 | E Sports电子竞技 | Map 4 Round 35 | 
| 161 | E Sports电子竞技 | Map 4 Round 36 | 
| 162 | E Sports电子竞技 | Map 5 Round 1 | 
| 163 | E Sports电子竞技 | Map 5 Round 2 | 
| 164 | E Sports电子竞技 | Map 5 Round 3 | 
| 165 | E Sports电子竞技 | Map 5 Round 4 | 
| 166 | E Sports电子竞技 | Map 5 Round 5 | 
| 167 | E Sports电子竞技 | Map 5 Round 6 | 
| 168 | E Sports电子竞技 | Map 5 Round 7 | 
| 169 | E Sports电子竞技 | Map 5 Round 8 | 
| 170 | E Sports电子竞技 | Map 5 Round 9 | 
| 171 | E Sports电子竞技 | Map 5 Round 10 | 
| 172 | E Sports电子竞技 | Map 5 Round 11 | 
| 173 | E Sports电子竞技 | Map 5 Round 12 | 
| 174 | E Sports电子竞技 | Map 5 Round 13 | 
| 175 | E Sports电子竞技 | Map 5 Round 14 | 
| 176 | E Sports电子竞技 | Map 5 Round 15 | 
| 177 | E Sports电子竞技 | Map 5 Round 16 | 
| 178 | E Sports电子竞技 | Map 5 Round 17 | 
| 179 | E Sports电子竞技 | Map 5 Round 18 | 
| 180 | E Sports电子竞技 | Map 5 Round 19 | 
| 181 | E Sports电子竞技 | Map 5 Round 20 | 
| 182 | E Sports电子竞技 | Map 5 Round 21 | 
| 183 | E Sports电子竞技 | Map 5 Round 22 | 
| 184 | E Sports电子竞技 | Map 5 Round 23 | 
| 185 | E Sports电子竞技 | Map 5 Round 24 | 
| 186 | E Sports电子竞技 | Map 5 Round 25 | 
| 187 | E Sports电子竞技 | Map 5 Round 26 | 
| 188 | E Sports电子竞技 | Map 5 Round 27 | 
| 189 | E Sports电子竞技 | Map 5 Round 28 | 
| 190 | E Sports电子竞技 | Map 5 Round 29 | 
| 191 | E Sports电子竞技 | Map 5 Round 30 | 
| 192 | E Sports电子竞技 | Map 5 Round 31 | 
| 193 | E Sports电子竞技 | Map 5 Round 32 | 
| 194 | E Sports电子竞技 | Map 5 Round 33 | 
| 195 | E Sports电子竞技 | Map 5 Round 34 | 
| 196 | E Sports电子竞技 | Map 5 Round 35 | 
| 197 | E Sports电子竞技 | Map 5 Round 36 | 
| 198 | E Sports电子竞技 | Map 6 Round 1 | 
| 199 | E Sports电子竞技 | Map 6 Round 2 | 
| 200 | E Sports电子竞技 | Map 6 Round 3 | 
| 201 | E Sports电子竞技 | Map 6 Round 4 | 
| 202 | E Sports电子竞技 | Map 6 Round 5 | 
| 203 | E Sports电子竞技 | Map 6 Round 6 | 
| 204 | E Sports电子竞技 | Map 6 Round 7 | 
| 205 | E Sports电子竞技 | Map 6 Round 8 | 
| 206 | E Sports电子竞技 | Map 6 Round 9 | 
| 207 | E Sports电子竞技 | Map 6 Round 10 | 
| 208 | E Sports电子竞技 | Map 6 Round 11 | 
| 209 | E Sports电子竞技 | Map 6 Round 12 | 
| 210 | E Sports电子竞技 | Map 6 Round 13 | 
| 211 | E Sports电子竞技 | Map 6 Round 14 | 
| 212 | E Sports电子竞技 | Map 6 Round 15 | 
| 213 | E Sports电子竞技 | Map 6 Round 16 | 
| 214 | E Sports电子竞技 | Map 6 Round 17 | 
| 215 | E Sports电子竞技 | Map 6 Round 18 | 
| 216 | E Sports电子竞技 | Map 6 Round 19 | 
| 217 | E Sports电子竞技 | Map 6 Round 20 | 
| 218 | E Sports电子竞技 | Map 6 Round 21 | 
| 219 | E Sports电子竞技 | Map 6 Round 22 | 
| 220 | E Sports电子竞技 | Map 6 Round 23 | 
| 221 | E Sports电子竞技 | Map 6 Round 24 | 
| 222 | E Sports电子竞技 | Map 6 Round 25 | 
| 223 | E Sports电子竞技 | Map 6 Round 26 | 
| 224 | E Sports电子竞技 | Map 6 Round 27 | 
| 225 | E Sports电子竞技 | Map 6 Round 28 | 
| 226 | E Sports电子竞技 | Map 6 Round 29 | 
| 227 | E Sports电子竞技 | Map 6 Round 30 | 
| 228 | E Sports电子竞技 | Map 6 Round 31 | 
| 229 | E Sports电子竞技 | Map 6 Round 32 | 
| 230 | E Sports电子竞技 | Map 6 Round 33 | 
| 231 | E Sports电子竞技 | Map 6 Round 34 | 
| 232 | E Sports电子竞技 | Map 6 Round 35 | 
| 233 | E Sports电子竞技 | Map 6 Round 36 | 
| 234 | E Sports电子竞技 | Map 7 Round 1 | 
| 235 | E Sports电子竞技 | Map 7 Round 2 | 
| 236 | E Sports电子竞技 | Map 7 Round 3 | 
| 237 | E Sports电子竞技 | Map 7 Round 4 | 
| 238 | E Sports电子竞技 | Map 7 Round 5 | 
| 239 | E Sports电子竞技 | Map 7 Round 6 | 
| 240 | E Sports电子竞技 | Map 7 Round 7 | 
| 241 | E Sports电子竞技 | Map 7 Round 8 | 
| 242 | E Sports电子竞技 | Map 7 Round 9 | 
| 243 | E Sports电子竞技 | Map 7 Round 10 | 
| 244 | E Sports电子竞技 | Map 7 Round 11 | 
| 245 | E Sports电子竞技 | Map 7 Round 12 | 
| 246 | E Sports电子竞技 | Map 7 Round 13 | 
| 247 | E Sports电子竞技 | Map 7 Round 14 | 
| 248 | E Sports电子竞技 | Map 7 Round 15 | 
| 249 | E Sports电子竞技 | Map 7 Round 16 | 
| 250 | E Sports电子竞技 | Map 7 Round 17 | 
| 251 | E Sports电子竞技 | Map 7 Round 18 | 
| 252 | E Sports电子竞技 | Map 7 Round 19 | 
| 253 | E Sports电子竞技 | Map 7 Round 20 | 
| 254 | E Sports电子竞技 | Map 7 Round 21 | 
| 255 | E Sports电子竞技 | Map 7 Round 22 | 
| 256 | E Sports电子竞技 | Map 7 Round 23 | 
| 257 | E Sports电子竞技 | Map 7 Round 24 | 
| 258 | E Sports电子竞技 | Map 7 Round 25 | 
| 259 | E Sports电子竞技 | Map 7 Round 26 | 
| 260 | E Sports电子竞技 | Map 7 Round 27 | 
| 261 | E Sports电子竞技 | Map 7 Round 28 | 
| 262 | E Sports电子竞技 | Map 7 Round 29 | 
| 263 | E Sports电子竞技 | Map 7 Round 30 | 
| 264 | E Sports电子竞技 | Map 7 Round 31 | 
| 265 | E Sports电子竞技 | Map 7 Round 32 | 
| 266 | E Sports电子竞技 | Map 7 Round 33 | 
| 267 | E Sports电子竞技 | Map 7 Round 34 | 
| 268 | E Sports电子竞技 | Map 7 Round 35 | 
| 269 | E Sports电子竞技 | Map 7 Round 36 |
| 0 | Field Hockey曲棍球 | Match赛事 | 
| 1 | Field Hockey曲棍球 | 1st Half上半场 | 
| 2 | Field Hockey曲棍球 | 2nd Half下半场 | 
| 0 | Floorball福樂球、地板球 | Match赛事 | 
| 1 | Floorball福樂球、地板球 | 1st Period第一节 | 
| 2 | Floorball福樂球、地板球 | 2nd Period第二节 | 
| 3 | Floorball福樂球、地板球 | 3rd Period第三节 | 
| 0 | Football橄榄球 | Game赛事 | 
| 1 | Football橄榄球 | 1st Half上半场 | 
| 2 | Football橄榄球 | 2nd Half下半场 | 
| 3 | Football橄榄球 | 1st Quarter第一节 | 
| 4 | Football橄榄球 | 2nd Quarter第二节 | 
| 5 | Football橄榄球 | 3rd Quarter第三节 | 
| 6 | Football橄榄球 | 4th Quarter第四节 | 
| 0 | Futsal室内足球 | Match赛事 | 
| 1 | Futsal室内足球 | 1st Half上半场 | 
| 2 | Futsal室内足球 | 2nd Half下半场 | 
| 0 | Golf高尔夫球 | Matchups对决 | 
| 0 | Handball手球 | Match赛事 | 
| 1 | Handball手球 | 1st Half上半场 | 
| 2 | Handball手球 | 2nd Half下半场 | 
| 0 | Hockey冰上曲棍球 | Game赛事 | 
| 1 | Hockey冰上曲棍球 | 1st Period第一节 | 
| 2 | Hockey冰上曲棍球 | 2nd Period第二节 | 
| 3 | Hockey冰上曲棍球 | 3rd Period第三节 | 
| 4 | Hockey冰上曲棍球 | Overtime加时赛 | 
| 5 | Hockey冰上曲棍球 | Shootout点球大战 | 
| 6 | Hockey冰上曲棍球 | Regulation Time常规时间 | 
| 0 | Horse Racing赛马 | Race赛事 | 
| 0 | Lacrosse袋棍球 | Match全场 | 
| 1 | Lacrosse袋棍球 | 1st Half上半场 | 
| 2 | Lacrosse袋棍球 | 2st Half下半场 | 
| 3 | Lacrosse袋棍球 | 1st Quarter第一节 | 
| 4 | Lacrosse袋棍球 | 2nd Quarter第二节 | 
| 5 | Lacrosse袋棍球 | 3rd Quarter第三节 | 
| 6 | Lacrosse袋棍球 | 4th Quarter第四节 | 
| 0 | Mixed Martial Arts综合格斗 | Fight赛事 | 
| 1 | Mixed Martial Arts综合格斗 | Round 1第一局 | 
| 2 | Mixed Martial Arts综合格斗 | Round 2第二局 | 
| 3 | Mixed Martial Arts综合格斗 | Round 3第三局 | 
| 4 | Mixed Martial Arts综合格斗 | Round 4第四局 | 
| 5 | Mixed Martial Arts综合格斗 | Round 5第五局 | 
| 0 | Other Sports其它 | Game赛事 | 
| 0 | Politics政治 | Election选举 | 
| 0 | Rugby League联盟式橄榄球 | Match赛事 | 
| 1 | Rugby League联盟式橄榄球 | 1st Half上半场 | 
| 2 | Rugby League联盟式橄榄球 | 2nd Half下半场 | 
| 0 | Rugby Union联合式橄榄球 | Match赛事 | 
| 1 | Rugby Union联合式橄榄球 | 1st Half上半场 | 
| 2 | Rugby Union联合式橄榄球 | 2nd Half下半场 | 
| 0 | Snooker桌球、撞球 | Match赛事 | 
| 1 | Snooker桌球、撞球 | 1st Frame第一回合 | 
| 0 | Soccer足球 | Match赛事 | 
| 1 | Soccer足球 | 1st Half上半场 | 
| 2 | Soccer足球 | 2nd Half下半场 | 
| 3 | Soccer足球 | Extra Time加时赛 | 
| 4 | Soccer足球 | Extra Time 1st Half加时赛上半场 | 
| 5 | Soccer足球 | Extra Time 2nd Half加时赛下半场 | 
| 6 | Soccer足球 | Penalty Shootout点球决胜 | 
| 7 | Soccer足球 | 1st Ten Shootout Pen前10个点球 | 
| 8 | Soccer足球 | To Qualify晋级 |
| 0 | Softball垒球 | Game赛事 | 
| 1 | Softball垒球 | 1st Half上半场 | 
| 2 | Softball垒球 | 2st Half下半场 | 
| 0 | Squash壁球 | Match赛事 | 
| 1 | Squash壁球 | 1st Game第一场比赛 | 
| 2 | Squash壁球 | 2nd Game第二场比赛 | 
| 3 | Squash壁球 | 3rd Game第三场比赛 | 
| 4 | Squash壁球 | 4th Game第四场比赛 | 
| 5 | Squash壁球 | 5th Game第五场比赛 | 
| 0 | Table Tennis乒乓球 | Match赛事 | 
| 1 | Table Tennis乒乓球 | 1st Game第一场比赛 | 
| 2 | Table Tennis乒乓球 | 2nd Game第二场比赛 | 
| 3 | Table Tennis乒乓球 | 3rd Game第三场比赛 | 
| 4 | Table Tennis乒乓球 | 4th Game第四场比赛 | 
| 5 | Table Tennis乒乓球 | 5th Game第五场比赛 | 
| 6 | Table Tennis乒乓球 | 6th Game第六场比赛 | 
| 0 | Tennis网球 | Match 比赛 | 
| 1 | Tennis网球 | 1st Set 第1盘 | 
| 2 | Tennis网球 | 2nd Set 第2盘 | 
| 3 | Tennis网球 | 3rd Set 第3盘 | 
| 4 | Tennis网球 | 4th Set 第4盘 | 
| 5 | Tennis网球 | 5th Set 第5盘 | 
| 6 | Tennis网球 | Set 1 Game 1 第1盘第1局 | 
| 7 | Tennis网球 | Set 1 Game 2 第1盘第2局 | 
| 8 | Tennis网球 | Set 1 Game 3 第1盘第3局 | 
| 9 | Tennis网球 | Set 1 Game 4 第1盘第4局 | 
| 10 | Tennis网球 | Set 1 Game 5 第1盘第5局 | 
| 11 | Tennis网球 | Set 1 Game 6 第1盘第6局 | 
| 12 | Tennis网球 | Set 1 Game 7 第1盘第7局 | 
| 13 | Tennis网球 | Set 1 Game 8 第1盘第8局 | 
| 14 | Tennis网球 | Set 1 Game 9 第1盘第9局 | 
| 15 | Tennis网球 | Set 1 Game 10 第1盘第10局 | 
| 16 | Tennis网球 | Set 1 Game 11 第1盘第11局 | 
| 17 | Tennis网球 | Set 1 Game 12 第1盘第12局 | 
| 18 | Tennis网球 | Set 1 Game 13 第1盘第13局 | 
| 19 | Tennis网球 | Set 2 Game 1 第2盘第1局 | 
| 20 | Tennis网球 | Set 2 Game 2 第2盘第2局 | 
| 21 | Tennis网球 | Set 2 Game 3 第2盘第3局 | 
| 22 | Tennis网球 | Set 2 Game 4 第2盘第4局 | 
| 23 | Tennis网球 | Set 2 Game 5 第2盘第5局 | 
| 24 | Tennis网球 | Set 2 Game 6 第2盘第6局 | 
| 25 | Tennis网球 | Set 2 Game 7 第2盘第7局 | 
| 26 | Tennis网球 | Set 2 Game 8 第2盘第8局 | 
| 27 | Tennis网球 | Set 2 Game 9 第2盘第9局 | 
| 28 | Tennis网球 | Set 2 Game 10 第2盘第10局 | 
| 29 | Tennis网球 | Set 2 Game 11 第2盘第11局 | 
| 30 | Tennis网球 | Set 2 Game 12 第2盘第12局 | 
| 31 | Tennis网球 | Set 2 Game 13 第2盘第13局 | 
| 32 | Tennis网球 | Set 3 Game 1 第3盘第1局 | 
| 33 | Tennis网球 | Set 3 Game 2 第3盘第2局 | 
| 34 | Tennis网球 | Set 3 Game 3 第3盘第3局 | 
| 35 | Tennis网球 | Set 3 Game 4 第3盘第4局 | 
| 36 | Tennis网球 | Set 3 Game 5 第3盘第5局 | 
| 37 | Tennis网球 | Set 3 Game 6 第3盘第6局 | 
| 38 | Tennis网球 | Set 3 Game 7 第3盘第7局 | 
| 39 | Tennis网球 | Set 3 Game 8 第3盘第8局 | 
| 40 | Tennis网球 | Set 3 Game 9 第3盘第9局 | 
| 41 | Tennis网球 | Set 3 Game 10 第3盘第10局 | 
| 42 | Tennis网球 | Set 3 Game 11 第3盘第11局 | 
| 43 | Tennis网球 | Set 3 Game 12 第3盘第12局 | 
| 44 | Tennis网球 | Set 3 Game 13 第3盘第13局 | 
| 45 | Tennis网球 | Set 3 Game 14 第3盘第14局 | 
| 46 | Tennis网球 | Set 3 Game 15 第3盘第15局 | 
| 47 | Tennis网球 | Set 3 Game 16 第3盘第16局 | 
| 48 | Tennis网球 | Set 3 Game 17 第3盘第17局 | 
| 49 | Tennis网球 | Set 3 Game 18 第3盘第18局 | 
| 50 | Tennis网球 | Set 3 Game 19 第3盘第19局 | 
| 51 | Tennis网球 | Set 3 Game 20 第3盘第20局 | 
| 52 | Tennis网球 | Set 3 Game 21 第3盘第21局 | 
| 53 | Tennis网球 | Set 3 Game 22 第3盘第22局 | 
| 54 | Tennis网球 | Set 3 Game 23 第3盘第23局 | 
| 55 | Tennis网球 | Set 3 Game 24 第3盘第24局 | 
| 56 | Tennis网球 | Set 3 Game 25 第3盘第25局 | 
| 57 | Tennis网球 | Set 3 Game 26 第3盘第26局 | 
| 58 | Tennis网球 | Set 3 Game 27 第3盘第27局 | 
| 59 | Tennis网球 | Set 3 Game 28 第3盘第28局 | 
| 60 | Tennis网球 | Set 3 Game 29 第3盘第29局 | 
| 61 | Tennis网球 | Set 3 Game 30 第3盘第30局 | 
| 62 | Tennis网球 | Set 3 Game 31 第3盘第31局 | 
| 63 | Tennis网球 | Set 3 Game 32 第3盘第32局 | 
| 64 | Tennis网球 | Set 3 Game 33 第3盘第33局 | 
| 65 | Tennis网球 | Set 3 Game 34 第3盘第34局 | 
| 66 | Tennis网球 | Set 3 Game 35 第3盘第35局 | 
| 67 | Tennis网球 | Set 3 Game 36 第3盘第36局 | 
| 68 | Tennis网球 | Set 3 Game 37 第3盘第37局 | 
| 69 | Tennis网球 | Set 3 Game 38 第3盘第38局 | 
| 70 | Tennis网球 | Set 3 Game 39 第3盘第39局 | 
| 71 | Tennis网球 | Set 3 Game 40 第3盘第40局 | 
| 72 | Tennis网球 | Set 3 Game 41 第3盘第41局 | 
| 73 | Tennis网球 | Set 3 Game 42 第3盘第42局 | 
| 74 | Tennis网球 | Set 3 Game 43 第3盘第43局 | 
| 75 | Tennis网球 | Set 3 Game 44 第3盘第44局 | 
| 76 | Tennis网球 | Set 3 Game 45 第3盘第45局 | 
| 77 | Tennis网球 | Set 3 Game 46 第3盘第46局 | 
| 78 | Tennis网球 | Set 3 Game 47 第3盘第47局 | 
| 79 | Tennis网球 | Set 3 Game 48 第3盘第48局 | 
| 80 | Tennis网球 | Set 3 Game 49 第3盘第49局 | 
| 81 | Tennis网球 | Set 3 Game 50 第3盘第50局 | 
| 82 | Tennis网球 | Set 3 Game 51 第3盘第51局 | 
| 83 | Tennis网球 | Set 3 Game 52 第3盘第52局 | 
| 84 | Tennis网球 | Set 3 Game 53 第3盘第53局 | 
| 85 | Tennis网球 | Set 3 Game 54 第3盘第54局 | 
| 86 | Tennis网球 | Set 3 Game 55 第3盘第55局 | 
| 87 | Tennis网球 | Set 3 Game 56 第3盘第56局 | 
| 88 | Tennis网球 | Set 3 Game 57 第3盘第57局 | 
| 89 | Tennis网球 | Set 3 Game 58 第3盘第58局 | 
| 90 | Tennis网球 | Set 3 Game 59 第3盘第59局 | 
| 91 | Tennis网球 | Set 3 Game 60 第3盘第60局 | 
| 92 | Tennis网球 | Set 3 Game 61 第3盘第61局 | 
| 93 | Tennis网球 | Set 3 Game 62 第3盘第62局 | 
| 94 | Tennis网球 | Set 3 Game 63 第3盘第63局 | 
| 95 | Tennis网球 | Set 3 Game 64 第3盘第64局 | 
| 96 | Tennis网球 | Set 3 Game 65 第3盘第65局 | 
| 97 | Tennis网球 | Set 3 Game 66 第3盘第66局 | 
| 98 | Tennis网球 | Set 3 Game 67 第3盘第67局 | 
| 99 | Tennis网球 | Set 3 Game 68 第3盘第68局 | 
| 100 | Tennis网球 | Set 3 Game 69 第3盘第69局 | 
| 101 | Tennis网球 | Set 3 Game 70 第3盘第70局 | 
| 102 | Tennis网球 | Set 3 Game 71 第3盘第71局 | 
| 103 | Tennis网球 | Set 3 Game 72 第3盘第72局 | 
| 104 | Tennis网球 | Set 3 Game 73 第3盘第73局 | 
| 105 | Tennis网球 | Set 3 Game 74 第3盘第74局 | 
| 106 | Tennis网球 | Set 3 Game 75 第3盘第75局 | 
| 107 | Tennis网球 | Set 3 Game 76 第3盘第76局 | 
| 108 | Tennis网球 | Set 3 Game 77 第3盘第77局 | 
| 109 | Tennis网球 | Set 3 Game 78 第3盘第78局 | 
| 110 | Tennis网球 | Set 3 Game 79 第3盘第79局 | 
| 111 | Tennis网球 | Set 3 Game 80 第3盘第80局 | 
| 112 | Tennis网球 | Set 3 Game 81 第3盘第81局 | 
| 113 | Tennis网球 | Set 3 Game 82 第3盘第82局 | 
| 114 | Tennis网球 | Set 3 Game 83 第3盘第83局 | 
| 115 | Tennis网球 | Set 3 Game 84 第3盘第84局 | 
| 116 | Tennis网球 | Set 3 Game 85 第3盘第85局 | 
| 117 | Tennis网球 | Set 3 Game 86 第3盘第86局 | 
| 118 | Tennis网球 | Set 3 Game 87 第3盘第87局 | 
| 119 | Tennis网球 | Set 3 Game 88 第3盘第88局 | 
| 120 | Tennis网球 | Set 3 Game 89 第3盘第89局 | 
| 121 | Tennis网球 | Set 3 Game 90 第3盘第90局 | 
| 122 | Tennis网球 | Set 3 Game 91 第3盘第91局 | 
| 123 | Tennis网球 | Set 3 Game 92 第3盘第92局 | 
| 124 | Tennis网球 | Set 3 Game 93 第3盘第93局 | 
| 125 | Tennis网球 | Set 3 Game 94 第3盘第94局 | 
| 126 | Tennis网球 | Set 3 Game 95 第3盘第95局 | 
| 127 | Tennis网球 | Set 3 Game 96 第3盘第96局 | 
| 128 | Tennis网球 | Set 3 Game 97 第3盘第97局 | 
| 129 | Tennis网球 | Set 3 Game 98 第3盘第98局 | 
| 130 | Tennis网球 | Set 3 Game 99 第3盘第99局 | 
| 131 | Tennis网球 | Set 3 Game 100 第3盘第100局 | 
| 132 | Tennis网球 | Set 4 Game 1 第4盘第1局 | 
| 133 | Tennis网球 | Set 4 Game 2 第4盘第2局 | 
| 134 | Tennis网球 | Set 4 Game 3 第4盘第3局 | 
| 135 | Tennis网球 | Set 4 Game 4 第4盘第4局 | 
| 136 | Tennis网球 | Set 4 Game 5 第4盘第5局 | 
| 137 | Tennis网球 | Set 4 Game 6 第4盘第6局 | 
| 138 | Tennis网球 | Set 4 Game 7 第4盘第7局 | 
| 139 | Tennis网球 | Set 4 Game 8 第4盘第8局 | 
| 140 | Tennis网球 | Set 4 Game 9 第4盘第9局 | 
| 141 | Tennis网球 | Set 4 Game 10 第4盘第10局 | 
| 142 | Tennis网球 | Set 4 Game 11 第4盘第11局 | 
| 143 | Tennis网球 | Set 4 Game 12 第4盘第12局 | 
| 144 | Tennis网球 | Set 4 Game 13 第4盘第13局 | 
| 145 | Tennis网球 | Set 5 Game 1 第5盘第1局 | 
| 146 | Tennis网球 | Set 5 Game 2 第5盘第2局 | 
| 147 | Tennis网球 | Set 5 Game 3 第5盘第3局 | 
| 148 | Tennis网球 | Set 5 Game 4 第5盘第4局 | 
| 149 | Tennis网球 | Set 5 Game 5 第5盘第5局 | 
| 150 | Tennis网球 | Set 5 Game 6 第5盘第6局 | 
| 151 | Tennis网球 | Set 5 Game 7 第5盘第7局 | 
| 152 | Tennis网球 | Set 5 Game 8 第5盘第8局 | 
| 153 | Tennis网球 | Set 5 Game 9 第5盘第9局 | 
| 154 | Tennis网球 | Set 5 Game 10 第5盘第10局 | 
| 155 | Tennis网球 | Set 5 Game 11 第5盘第11局 | 
| 156 | Tennis网球 | Set 5 Game 12 第5盘第12局 | 
| 157 | Tennis网球 | Set 5 Game 13 第5盘第13局 | 
| 158 | Tennis网球 | Set 5 Game 14 第5盘第14局 | 
| 159 | Tennis网球 | Set 5 Game 15 第5盘第15局 | 
| 160 | Tennis网球 | Set 5 Game 16 第5盘第16局 | 
| 161 | Tennis网球 | Set 5 Game 17 第5盘第17局 | 
| 162 | Tennis网球 | Set 5 Game 18 第5盘第18局 | 
| 163 | Tennis网球 | Set 5 Game 19 第5盘第19局 | 
| 164 | Tennis网球 | Set 5 Game 20 第5盘第20局 | 
| 165 | Tennis网球 | Set 5 Game 21 第5盘第21局 | 
| 166 | Tennis网球 | Set 5 Game 22 第5盘第22局 | 
| 167 | Tennis网球 | Set 5 Game 23 第5盘第23局 | 
| 168 | Tennis网球 | Set 5 Game 24 第5盘第24局 | 
| 169 | Tennis网球 | Set 5 Game 25 第5盘第25局 | 
| 170 | Tennis网球 | Set 5 Game 26 第5盘第26局 | 
| 171 | Tennis网球 | Set 5 Game 27 第5盘第27局 | 
| 172 | Tennis网球 | Set 5 Game 28 第5盘第28局 | 
| 173 | Tennis网球 | Set 5 Game 29 第5盘第29局 | 
| 174 | Tennis网球 | Set 5 Game 30 第5盘第30局 | 
| 175 | Tennis网球 | Set 5 Game 31 第5盘第31局 | 
| 176 | Tennis网球 | Set 5 Game 32 第5盘第32局 | 
| 177 | Tennis网球 | Set 5 Game 33 第5盘第33局 | 
| 178 | Tennis网球 | Set 5 Game 34 第5盘第34局 | 
| 179 | Tennis网球 | Set 5 Game 35 第5盘第35局 | 
| 180 | Tennis网球 | Set 5 Game 36 第5盘第36局 | 
| 181 | Tennis网球 | Set 5 Game 37 第5盘第37局 | 
| 182 | Tennis网球 | Set 5 Game 38 第5盘第38局 | 
| 183 | Tennis网球 | Set 5 Game 39 第5盘第39局 | 
| 184 | Tennis网球 | Set 5 Game 40 第5盘第40局 | 
| 185 | Tennis网球 | Set 5 Game 41 第5盘第41局 | 
| 186 | Tennis网球 | Set 5 Game 42 第5盘第42局 | 
| 187 | Tennis网球 | Set 5 Game 43 第5盘第43局 | 
| 188 | Tennis网球 | Set 5 Game 44 第5盘第44局 | 
| 189 | Tennis网球 | Set 5 Game 45 第5盘第45局 | 
| 190 | Tennis网球 | Set 5 Game 46 第5盘第46局 | 
| 191 | Tennis网球 | Set 5 Game 47 第5盘第47局 | 
| 192 | Tennis网球 | Set 5 Game 48 第5盘第48局 | 
| 193 | Tennis网球 | Set 5 Game 49 第5盘第49局 | 
| 194 | Tennis网球 | Set 5 Game 50 第5盘第50局 | 
| 195 | Tennis网球 | Set 5 Game 51 第5盘第51局 | 
| 196 | Tennis网球 | Set 5 Game 52 第5盘第52局 | 
| 197 | Tennis网球 | Set 5 Game 53 第5盘第53局 | 
| 198 | Tennis网球 | Set 5 Game 54 第5盘第54局 | 
| 199 | Tennis网球 | Set 5 Game 55 第5盘第55局 | 
| 200 | Tennis网球 | Set 5 Game 56 第5盘第56局 | 
| 201 | Tennis网球 | Set 5 Game 57 第5盘第57局 | 
| 202 | Tennis网球 | Set 5 Game 58 第5盘第58局 | 
| 203 | Tennis网球 | Set 5 Game 59 第5盘第59局 | 
| 204 | Tennis网球 | Set 5 Game 60 第5盘第60局 | 
| 205 | Tennis网球 | Set 5 Game 61 第5盘第61局 | 
| 206 | Tennis网球 | Set 5 Game 62 第5盘第62局 | 
| 207 | Tennis网球 | Set 5 Game 63 第5盘第63局 | 
| 208 | Tennis网球 | Set 5 Game 64 第5盘第64局 | 
| 209 | Tennis网球 | Set 5 Game 65 第5盘第65局 | 
| 210 | Tennis网球 | Set 5 Game 66 第5盘第66局 | 
| 211 | Tennis网球 | Set 5 Game 67 第5盘第67局 | 
| 212 | Tennis网球 | Set 5 Game 68 第5盘第68局 | 
| 213 | Tennis网球 | Set 5 Game 69 第5盘第69局 | 
| 214 | Tennis网球 | Set 5 Game 70 第5盘第70局 | 
| 215 | Tennis网球 | Set 5 Game 71 第5盘第71局 | 
| 216 | Tennis网球 | Set 5 Game 72 第5盘第72局 | 
| 217 | Tennis网球 | Set 5 Game 73 第5盘第73局 | 
| 218 | Tennis网球 | Set 5 Game 74 第5盘第74局 | 
| 219 | Tennis网球 | Set 5 Game 75 第5盘第75局 | 
| 220 | Tennis网球 | Set 5 Game 76 第5盘第76局 | 
| 221 | Tennis网球 | Set 5 Game 77 第5盘第77局 | 
| 222 | Tennis网球 | Set 5 Game 78 第5盘第78局 | 
| 223 | Tennis网球 | Set 5 Game 79 第5盘第79局 | 
| 224 | Tennis网球 | Set 5 Game 80 第5盘第80局 | 
| 225 | Tennis网球 | Set 5 Game 81 第5盘第81局 | 
| 226 | Tennis网球 | Set 5 Game 82 第5盘第82局 | 
| 227 | Tennis网球 | Set 5 Game 83 第5盘第83局 | 
| 228 | Tennis网球 | Set 5 Game 84 第5盘第84局 | 
| 229 | Tennis网球 | Set 5 Game 85 第5盘第85局 | 
| 230 | Tennis网球 | Set 5 Game 86 第5盘第86局 | 
| 231 | Tennis网球 | Set 5 Game 87 第5盘第87局 | 
| 232 | Tennis网球 | Set 5 Game 88 第5盘第88局 | 
| 233 | Tennis网球 | Set 5 Game 89 第5盘第89局 | 
| 234 | Tennis网球 | Set 5 Game 90 第5盘第90局 | 
| 235 | Tennis网球 | Set 5 Game 91 第5盘第91局 | 
| 236 | Tennis网球 | Set 5 Game 92 第5盘第92局 | 
| 237 | Tennis网球 | Set 5 Game 93 第5盘第93局 | 
| 238 | Tennis网球 | Set 5 Game 94 第5盘第94局 | 
| 239 | Tennis网球 | Set 5 Game 95 第5盘第95局 | 
| 240 | Tennis网球 | Set 5 Game 96 第5盘第96局 | 
| 241 | Tennis网球 | Set 5 Game 97 第5盘第97局 | 
| 242 | Tennis网球 | Set 5 Game 98 第5盘第98局 | 
| 243 | Tennis网球 | Set 5 Game 99 第5盘第99局 | 
| 244 | Tennis网球 | Set 5 Game 100 第5盘第100局 | 
| 0 | Volleyball排球 | Match赛事 | 
| 1 | Volleyball排球 | 1st Set首盘 | 
| 2 | Volleyball排球 | 2nd Set第二盘 | 
| 3 | Volleyball排球 | 3rd Set第三盘 | 
| 4 | Volleyball排球 | 4th Set第四盘 | 
| 5 | Volleyball排球 | 5th Set第五盘 | 
| 0 | Volleyball (Points) 排球（得分) | Game赛事 | 
| 1 | Volleyball (Points) 排球（得分) | 1st Set首盘 | 
| 2 | Volleyball (Points) 排球（得分) | 2nd Set第二盘 | 
| 3 | Volleyball (Points) 排球（得分) | 3rd Set第三盘 | 
| 4 | Volleyball (Points) 排球（得分) | 4th Set第四盘 | 
| 5 | Volleyball (Points) 排球（得分) | 5th Set第五盘 | 
| 0 | Water Polo水球 | Match赛事 | 
| 1 | Water Polo水球 | 1st Period第一节 | 
| 2 | Water Polo水球 | 2nd Period第二节 | 
| 3 | Water Polo水球 | 3rd Period第三节 | 
| 4 | Water Polo水球 | 4th Period第四节 | 
| 0 | Padel Tennis板网球 | Match赛事 | 
| 1 | Padel Tennis板网球 | 1st Set Winner首盘优胜者 | 
| 2 | Padel Tennis板网球 | 2nd Set Winner第二盘优胜者 | 
| 3 | Padel Tennis板网球 | 3rd Set Winner第三盘优胜者 | 
| 0 | Aussie Rules澳洲足球 | Game赛事 | 
| 1 | Aussie Rules澳洲足球 | 1st Half上半场 | 
| 2 | Aussie Rules澳洲足球 | 2nd Half下半场 | 
| 3 | Aussie Rules澳洲足球 | 1st Quarter第一节 | 
| 4 | Aussie Rules澳洲足球 | 2nd Quarter第二节 | 
| 5 | Aussie Rules澳洲足球 | 3rd Quarter第三节 | 
| 6 | Aussie Rules澳洲足球 | 4th Quarter第四节 | 
| 0 | Alpine Skiing高山滑雪 | Matchups对决 | 
| 0 | Biathlon冬季两项 | Matchups对决 | 
| 0 | Ski Jumping跳台滑雪 | Matchups对决 | 
| 0 | Cross Country越野滑雪 | Matchups对决 | 
| 0 | Formula 1一级方程式赛车 | Matchups对决 | 
| 0 | Cycling自行车 | Matchups对决 | 
| 0 | Bobsleigh有舵雪橇 | Matchups对决 | 
| 0 | Figure Skating花样滑冰 | Matchups对决 | 
| 0 | Freestyle Skiing自由式滑雪 | Matchups对决 | 
| 0 | Luge无舵雪橇 | Matchups对决 | 
| 0 | Nordic Combined北欧两项 | Matchups对决 | 
| 0 | Short Track短道速滑 | Matchups对决 | 
| 0 | Skeleton俯式冰橇 | Matchups对决 | 
| 0 | Snow Boarding单板滑雪 | Matchups对决 | 
| 0 | Speed Skating速度滑冰 | Matchups对决 | 
| 0 | Olympics 奥林匹克 | Match赛事 | 
| 0 | Athletics 田径 | Matchups对决 | 
| 0 | Crossfit 混合健身 | Matchups对决 | 
| 0 | Entertainment 娱乐 | Matchups对决 | 
| 0 | Archery 射箭 | Match赛事 | 
| 0 | Drone Racing 无人机竞速 | Matchups对决 | 
| 0 | Poker 扑克 | Matchup对决 | 
| 0 | Motorsport 赛车运动 | Matchups对决 | 
| 0 | Simulated Games 模拟比赛 | Game赛事 | 
| 1 | Simulated Games 模拟比赛 | 1st Half上半场 | 
| 2 | Simulated Games 模拟比赛 | 2nd Half下半场 | 
| 0 | Sumo 相扑 | Match赛事 | 

## 13. User Status 用户状态

| Code 代码 | Name 名称 | Description 描述 |
| --- | --- | --- |
| `ACTIVE` | User is active <br/>用户账号已激活 | ‘ACTIVE’ player CAN log in and place bet on Member site. <br/>"激活"状态的玩家可以在会员网站上登录和下注。 | 
| `INACTIVE` | User is inactive <br/>用户账号未激活 | ‘INACTIVE’ player CANNOT log in on Member site. <br/>"未激活"状态的玩家不可以在会员网站上登录。 | 
| `SUSPENDED` | User is suspended by direct agent. <br/>用户被上线代理暂停 | ‘SUSPENDED’ player CAN log in on Member site, but CANNOT place bet. <br/>"暂停"状态的玩家可以在会员网站上登录，但不可以下注。 | 
| `SUSPENDED_BY_COMPANY` | User is suspended by ‘Company’ agent. <br/>用户被公司级代理暂停使用 | ‘SUSPENDED_BY_COMPANY’ player CAN log in on Member site, but CANNOT place bet. <br/>"用户被公司暂停使用"状态的玩家可以在会员网站上登录，但不可以下注。 | 
| `CLOSED` | User is closed by administrator <br/>用户账号被管理员关闭 | ‘CLOSED’ player CANNOT log in on Member site. <br/>"关闭"状态的玩家不可以在会员网站上登录。 | 
| `INACTIVE_BY_COMPANY` | User is inactive by company <br/>用户被公司级代理注销 | ‘INACTIVE_BY_COMPANY’ player CANNOT log in on Member site. <br/> 已被公司级代理注销的用户不可以在会员网站上登录。| 


## 14. Leg Status Result 选项结果

| No | Code 代码 | Description 描述 |
| --- | --- | --- |
| 1 | `ACCEPTED` | The leg is accepted<br/>选项被接受 | 
| 2 | `CANCELLED` | The leg is cancelled - the stake on this leg will be transferred to the next one. In this case the leg will be ignored when calculating the win/loss. <br/>选项被取消，在此选项的注金将会被转移到下一个。在此情况下，计算输赢时将会忽略该选项 | 
| 3 | `LOSE` | The leg is a loss - the whole parlay wager will settled as lose. <br/>选项为输，整个过关注单将被结算为输。 | 
| 4 | `PUSH` | The leg is a push - the stake on this leg will be transferred to the next one. In this case the leg will be ignored when calculating the win/loss. <br/>选项为和局，在此选项的注金将会被转移到下一个。在此情况下，计算输赢时将会忽略该选项 | 
| 5 | `REFUNDED` | The leg is refunded - the stake on this leg will be transferred to the next one. In this case the leg will be ignored when calculating the win/loss. <br/>选项为退还，在此选项的注金将会被转移到下一个。在此情况下，计算输赢时将会忽略该选项 | 
| 6 | `WON` | The leg is a win - this leg will be settled as a win. <br/>选项为赢，此选项将会被结算为赢。| 
| 7 | `HALF_WON_HALF_PUSHED` | The leg has been settled as half win. <br/>选项已结算为赢一半。| 
| 8 | `HALF_LOST_HALF_PUSHED` | The leg has been settled as half lose. <br/>选项已结算为输一半。 | 

## 15. Non-login currency display 未登录币种显示

For non-login currency display, please add parameter /?currency=value<br/>
对于未登录币种显示，请加参数 /?currency=value<br/>
E.g.  <br/>
Non-login domain → https://whitelabelapidomain.com/en <br/>
If you would like to display MYR when non-login → https://whitelabelapidomain.com/en/?currency=MYR <br/>
例： <br/>
域名 → https://whitelabelapidomain.com/en 若欲在未登录时显示 MYR 币种 → https://whitelabelapidomain.com/en/?currency=MYR <br/>
Note: Without this parameter, the default non-login currency would be CNY. <br/>
请注意：如果没有此参数，默认的未登录币种显示为 CNY

## 16. Bet Status Partial Result 投注半\/全数结算状态

| Code 代码 | Description 描述 |
| --- | --- |
| 0 | Half 半数结算 | 
| 1 | Full 全数结算 | 

