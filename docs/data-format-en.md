
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

## 8. Languages

| Locale code | Description   |
| --- | --- |
| en | English |
| zh-cn | Simplified Chinese |
| zh-tw | Traditional Chinese |
| id | Indonesian |
| vi | Vietnamese (Tiếng Việt) |
| ja | Japanese |
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

## 9. Selection Type 

| Code | Name | Description  | 
| ---  | ---  | ---   | 
| 0 | `HOME` | Home team is selected |
| 1 | `AWAY` | Away team is selected |
| 2 | `DRAW` | Draw is selected |
| 3 | `OVER` | Over is selected |
| 4 | `UNDER` | Under is selected |
| 5 | `HOME_OVER` | Home over is selected |
| 6 | `HOME_UNDER` | Home under is selected |
| 7 | `AWAY_OVER` | Away over is selected |
| 8 | `AWAY_UNDER` | Away under is selected |
| 9 | `ODD` | Odd type is selected |
| 10 | `EVEN` | Even type is selected |
| 11 | `TEAM` | Team type is selected |

## 10. Wager Result 

| Code  | Name | Description  |
| ---  | ---  | ---   |
| `WIN` | Wager has been settled as win |  |
| `LOSE` | Wager has been settled as lose |  |
| `DRAW` | Wager has been settled as draw |  |
| `HALF_WON_HALF_PUSHED` | Wager has been settled as half win |  |
| `HALF_LOST_HALF_PUSHED` | Wager has been settled as half lose |  |

## 11. Wager Status

| Code | Name | Description  |
| ---  | ---  | ---   |
| `PENDING`  | Wager is pending |  |
| `OPEN`  | Wager is opening |  |
| `SETTLED`  | Wager was settled |  |
| `CANCELLED`  | Wager was cancelled |  |

## 12. Period Status

| Code | Name | Description |
| --- | --- | --- |
| 0 | Badminton | Match | 
| 1 | Badminton | 1st Game_Badminton | 
| 2 | Badminton | 2nd Game_Badminton | 
| 3 | Badminton | 3rd Game_Badminton | 
| 0 | Bandy | Match | 
| 1 | Bandy | 1st Half | 
| 2 | Bandy | 2nd Half | 
| 0 | Baseball | Game | 
| 1 | Baseball| 1st Half | 
| 2 | Baseball | 2nd Half | 
| 3 | Baseball | 1st Inning | 
| 4 | Baseball | 2nd Inning | 
| 5 | Baseball | 3nd Inning | 
| 6 | Baseball | 4nd Inning | 
| 7 | Baseball | 5th Inning | 
| 8 | Baseball | 6th Inning | 
| 9 | Baseball | 7th Inning | 
| 10 | Baseball | 8th Inning | 
| 11 | Baseball | 9th Inning | 
| 12 | Baseball | 1-7 Innings | 
| 0 | Basketball | Game | 
| 1 | Basketball | 1st Half | 
| 2 | Basketball | 2nd Half | 
| 3 | Basketball | 1st Quarter | 
| 4 | Basketball | 2nd Quarter | 
| 5 | Basketball | 3rd Quarter | 
| 6 | Basketball | 4th Quarter  | 
| 0 | Beach Volleyball | Match | 
| 1 | Beach Volleyball | 1st Set | 
| 2 | Beach Volleyball | 2nd Set | 
| 3 | Beach Volleyball | 3rd Set | 
| 0 | Boxing | Fight | 
| 0 | Chess | Match | 
| 0 | Cricket | Match | 
| 1 | Cricket | 1st Inning | 
| 2 | Cricket | 2nd Inning | 
| 0 | Curling | Game | 
| 1 | Curling | 1st End | 
| 0 | Darts | Match | 
| 1 | Darts | 1st Set | 
| 2 | Darts | 2nd Set | 
| 3 | Darts | 3rd Set | 
| 4 | Darts | 4th Set | 
| 5 | Darts | 5th Set | 
| 0 | Darts (Legs) | Match | 
| 1 | Darts (Legs) | 1st Leg | 
| 2 | Darts (Legs) | 2nd Leg | 
| 3 | Darts (Legs) | 3rd Leg | 
| 4 | Darts (Legs) | 4th Leg | 
| 5 | Darts (Legs) | 5th Leg | 
| 6 | Darts (Legs) | 6th Leg | 
| 0 | E Sports | Match | 
| 1 | E Sports | Map 1 | 
| 2 | E Sports | Map 2 | 
| 3 | E Sports | Map 3 | 
| 4 | E Sports | Map 4 | 
| 5 | E Sports | Map 5 | 
| 6 | E Sports | Map 6 | 
| 7 | E Sports | Map 7 | 
| 8 | E Sports | Map 8 | 
| 9 | E Sports | Map 9 | 
| 10 | E Sports | Map 10 | 
| 11 | E Sports | Map 1 1st Half | 
| 12 | E Sports | Map 2 1st Half | 
| 13 | E Sports | Map 3 1st Half | 
| 14 | E Sports | Map 4 1st Half | 
| 15 | E Sports | Map 5 1st Half | 
| 16 | E Sports | Map 6 1st Half | 
| 17 | E Sports | Map 7 1st Half | 
| 18 | E Sports | Map 1 Round 1 | 
| 19 | E Sports | Map 1 Round 2 | 
| 20 | E Sports | Map 1 Round 3 | 
| 21 | E Sports | Map 1 Round 4 | 
| 22 | E Sports | Map 1 Round 5 | 
| 23 | E Sports | Map 1 Round 6 | 
| 24 | E Sports | Map 1 Round 7 | 
| 25 | E Sports | Map 1 Round 8 | 
| 26 | E Sports | Map 1 Round 9 | 
| 27 | E Sports | Map 1 Round 10 | 
| 28 | E Sports | Map 1 Round 11 | 
| 29 | E Sports | Map 1 Round 12 | 
| 30 | E Sports | Map 1 Round 13 | 
| 31 | E Sports | Map 1 Round 14 | 
| 32 | E Sports | Map 1 Round 15 | 
| 33 | E Sports | Map 1 Round 16 | 
| 34 | E Sports | Map 1 Round 17 | 
| 35 | E Sports | Map 1 Round 18 | 
| 36 | E Sports | Map 1 Round 19 | 
| 37 | E Sports | Map 1 Round 20 | 
| 38 | E Sports | Map 1 Round 21 | 
| 39 | E Sports | Map 1 Round 22 | 
| 40 | E Sports | Map 1 Round 23 | 
| 41 | E Sports | Map 1 Round 24 | 
| 42 | E Sports | Map 1 Round 25 | 
| 43 | E Sports | Map 1 Round 26 | 
| 44 | E Sports | Map 1 Round 27 | 
| 45 | E Sports | Map 1 Round 28 | 
| 46 | E Sports | Map 1 Round 29 | 
| 47 | E Sports | Map 1 Round 30 | 
| 48 | E Sports | Map 1 Round 31 | 
| 49 | E Sports | Map 1 Round 32 | 
| 50 | E Sports | Map 1 Round 33 | 
| 51 | E Sports | Map 1 Round 34 | 
| 52 | E Sports | Map 1 Round 35 | 
| 53 | E Sports | Map 1 Round 36 | 
| 54 | E Sports | Map 2 Round 1 | 
| 55 | E Sports | Map 2 Round 2 | 
| 56 | E Sports | Map 2 Round 3 | 
| 57 | E Sports | Map 2 Round 4 | 
| 58 | E Sports | Map 2 Round 5 | 
| 59 | E Sports | Map 2 Round 6 | 
| 60 | E Sports | Map 2 Round 7 | 
| 61 | E Sports | Map 2 Round 8 | 
| 62 | E Sports | Map 2 Round 9 | 
| 63 | E Sports | Map 2 Round 10 | 
| 64 | E Sports | Map 2 Round 11 | 
| 65 | E Sports | Map 2 Round 12 | 
| 66 | E Sports | Map 2 Round 13 | 
| 67 | E Sports | Map 2 Round 14 | 
| 68 | E Sports | Map 2 Round 15 | 
| 69 | E Sports | Map 2 Round 16 | 
| 70 | E Sports | Map 2 Round 17 | 
| 71 | E Sports | Map 2 Round 18 | 
| 72 | E Sports | Map 2 Round 19 | 
| 73 | E Sports | Map 2 Round 20 | 
| 74 | E Sports | Map 2 Round 21 | 
| 75 | E Sports | Map 2 Round 22 | 
| 76 | E Sports | Map 2 Round 23 | 
| 77 | E Sports | Map 2 Round 24 | 
| 78 | E Sports | Map 2 Round 25 | 
| 79 | E Sports | Map 2 Round 26 | 
| 80 | E Sports | Map 2 Round 27 | 
| 81 | E Sports | Map 2 Round 28 | 
| 82 | E Sports | Map 2 Round 29 | 
| 83 | E Sports | Map 2 Round 30 | 
| 84 | E Sports | Map 2 Round 31 | 
| 85 | E Sports | Map 2 Round 32 | 
| 86 | E Sports | Map 2 Round 33 | 
| 87 | E Sports | Map 2 Round 34 | 
| 88 | E Sports | Map 2 Round 35 | 
| 89 | E Sports | Map 2 Round 36 | 
| 90 | E Sports | Map 3 Round 1 | 
| 91 | E Sports | Map 3 Round 2 | 
| 92 | E Sports | Map 3 Round 3 | 
| 93 | E Sports | Map 3 Round 4 | 
| 94 | E Sports | Map 3 Round 5 | 
| 95 | E Sports | Map 3 Round 6 | 
| 96 | E Sports | Map 3 Round 7 | 
| 97 | E Sports | Map 3 Round 8 | 
| 98 | E Sports | Map 3 Round 9 | 
| 99 | E Sports | Map 3 Round 10 | 
| 100 | E Sports | Map 3 Round 11 | 
| 101 | E Sports | Map 3 Round 12 | 
| 102 | E Sports | Map 3 Round 13 | 
| 103 | E Sports | Map 3 Round 14 | 
| 104 | E Sports | Map 3 Round 15 | 
| 105 | E Sports | Map 3 Round 16 | 
| 106 | E Sports | Map 3 Round 17 | 
| 107 | E Sports | Map 3 Round 18 | 
| 108 | E Sports | Map 3 Round 19 | 
| 109 | E Sports | Map 3 Round 20 | 
| 110 | E Sports | Map 3 Round 21 | 
| 111 | E Sports | Map 3 Round 22 | 
| 112 | E Sports | Map 3 Round 23 | 
| 113 | E Sports | Map 3 Round 24 | 
| 114 | E Sports | Map 3 Round 25 | 
| 115 | E Sports | Map 3 Round 26 | 
| 116 | E Sports | Map 3 Round 27 | 
| 117 | E Sports | Map 3 Round 28 | 
| 118 | E Sports | Map 3 Round 29 | 
| 119 | E Sports | Map 3 Round 30 | 
| 120 | E Sports | Map 3 Round 31 | 
| 121 | E Sports | Map 3 Round 32 | 
| 122 | E Sports | Map 3 Round 33 | 
| 123 | E Sports | Map 3 Round 34 | 
| 124 | E Sports | Map 3 Round 35 | 
| 125 | E Sports | Map 3 Round 36 | 
| 126 | E Sports | Map 4 Round 1 | 
| 127 | E Sports | Map 4 Round 2 | 
| 128 | E Sports | Map 4 Round 3 | 
| 129 | E Sports | Map 4 Round 4 | 
| 130 | E Sports | Map 4 Round 5 | 
| 131 | E Sports | Map 4 Round 6 | 
| 132 | E Sports | Map 4 Round 7 | 
| 133 | E Sports | Map 4 Round 8 | 
| 134 | E Sports | Map 4 Round 9 | 
| 135 | E Sports | Map 4 Round 10 | 
| 136 | E Sports | Map 4 Round 11 | 
| 137 | E Sports | Map 4 Round 12 | 
| 138 | E Sports | Map 4 Round 13 | 
| 139 | E Sports | Map 4 Round 14 | 
| 140 | E Sports | Map 4 Round 15 | 
| 141 | E Sports | Map 4 Round 16 | 
| 142 | E Sports | Map 4 Round 17 | 
| 143 | E Sports | Map 4 Round 18 | 
| 144 | E Sports | Map 4 Round 19 | 
| 145 | E Sports | Map 4 Round 20 | 
| 146 | E Sports | Map 4 Round 21 | 
| 147 | E Sports | Map 4 Round 22 | 
| 148 | E Sports | Map 4 Round 23 | 
| 149 | E Sports | Map 4 Round 24 | 
| 150 | E Sports | Map 4 Round 25 | 
| 151 | E Sports | Map 4 Round 26 | 
| 152 | E Sports | Map 4 Round 27 | 
| 153 | E Sports | Map 4 Round 28 | 
| 154 | E Sports | Map 4 Round 29 | 
| 155 | E Sports | Map 4 Round 30 | 
| 156 | E Sports | Map 4 Round 31 | 
| 157 | E Sports | Map 4 Round 32 | 
| 158 | E Sports | Map 4 Round 33 | 
| 159 | E Sports | Map 4 Round 34 | 
| 160 | E Sports | Map 4 Round 35 | 
| 161 | E Sports | Map 4 Round 36 | 
| 162 | E Sports | Map 5 Round 1 | 
| 163 | E Sports | Map 5 Round 2 | 
| 164 | E Sports | Map 5 Round 3 | 
| 165 | E Sports | Map 5 Round 4 | 
| 166 | E Sports | Map 5 Round 5 | 
| 167 | E Sports | Map 5 Round 6 | 
| 168 | E Sports | Map 5 Round 7 | 
| 169 | E Sports | Map 5 Round 8 | 
| 170 | E Sports | Map 5 Round 9 | 
| 171 | E Sports | Map 5 Round 10 | 
| 172 | E Sports | Map 5 Round 11 | 
| 173 | E Sports | Map 5 Round 12 | 
| 174 | E Sports | Map 5 Round 13 | 
| 175 | E Sports | Map 5 Round 14 | 
| 176 | E Sports | Map 5 Round 15 | 
| 177 | E Sports | Map 5 Round 16 | 
| 178 | E Sports | Map 5 Round 17 | 
| 179 | E Sports | Map 5 Round 18 | 
| 180 | E Sports | Map 5 Round 19 | 
| 181 | E Sports | Map 5 Round 20 | 
| 182 | E Sports | Map 5 Round 21 | 
| 183 | E Sports | Map 5 Round 22 | 
| 184 | E Sports | Map 5 Round 23 | 
| 185 | E Sports | Map 5 Round 24 | 
| 186 | E Sports | Map 5 Round 25 | 
| 187 | E Sports | Map 5 Round 26 | 
| 188 | E Sports | Map 5 Round 27 | 
| 189 | E Sports | Map 5 Round 28 | 
| 190 | E Sports | Map 5 Round 29 | 
| 191 | E Sports | Map 5 Round 30 | 
| 192 | E Sports | Map 5 Round 31 | 
| 193 | E Sports | Map 5 Round 32 | 
| 194 | E Sports | Map 5 Round 33 | 
| 195 | E Sports | Map 5 Round 34 | 
| 196 | E Sports | Map 5 Round 35 | 
| 197 | E Sports | Map 5 Round 36 | 
| 198 | E Sports | Map 6 Round 1 | 
| 199 | E Sports | Map 6 Round 2 | 
| 200 | E Sports | Map 6 Round 3 | 
| 201 | E Sports | Map 6 Round 4 | 
| 202 | E Sports | Map 6 Round 5 | 
| 203 | E Sports | Map 6 Round 6 | 
| 204 | E Sports | Map 6 Round 7 | 
| 205 | E Sports | Map 6 Round 8 | 
| 206 | E Sports | Map 6 Round 9 | 
| 207 | E Sports | Map 6 Round 10 | 
| 208 | E Sports | Map 6 Round 11 | 
| 209 | E Sports | Map 6 Round 12 | 
| 210 | E Sports | Map 6 Round 13 | 
| 211 | E Sports | Map 6 Round 14 | 
| 212 | E Sports | Map 6 Round 15 | 
| 213 | E Sports | Map 6 Round 16 | 
| 214 | E Sports | Map 6 Round 17 | 
| 215 | E Sports | Map 6 Round 18 | 
| 216 | E Sports | Map 6 Round 19 | 
| 217 | E Sports | Map 6 Round 20 | 
| 218 | E Sports | Map 6 Round 21 | 
| 219 | E Sports | Map 6 Round 22 | 
| 220 | E Sports | Map 6 Round 23 | 
| 221 | E Sports | Map 6 Round 24 | 
| 222 | E Sports | Map 6 Round 25 | 
| 223 | E Sports | Map 6 Round 26 | 
| 224 | E Sports | Map 6 Round 27 | 
| 225 | E Sports | Map 6 Round 28 | 
| 226 | E Sports | Map 6 Round 29 | 
| 227 | E Sports | Map 6 Round 30 | 
| 228 | E Sports | Map 6 Round 31 | 
| 229 | E Sports | Map 6 Round 32 | 
| 230 | E Sports | Map 6 Round 33 | 
| 231 | E Sports | Map 6 Round 34 | 
| 232 | E Sports | Map 6 Round 35 | 
| 233 | E Sports | Map 6 Round 36 | 
| 234 | E Sports | Map 7 Round 1 | 
| 235 | E Sports | Map 7 Round 2 | 
| 236 | E Sports | Map 7 Round 3 | 
| 237 | E Sports | Map 7 Round 4 | 
| 238 | E Sports | Map 7 Round 5 | 
| 239 | E Sports | Map 7 Round 6 | 
| 240 | E Sports | Map 7 Round 7 | 
| 241 | E Sports | Map 7 Round 8 | 
| 242 | E Sports | Map 7 Round 9 | 
| 243 | E Sports | Map 7 Round 10 | 
| 244 | E Sports | Map 7 Round 11 | 
| 245 | E Sports | Map 7 Round 12 | 
| 246 | E Sports | Map 7 Round 13 | 
| 247 | E Sports | Map 7 Round 14 | 
| 248 | E Sports | Map 7 Round 15 | 
| 249 | E Sports | Map 7 Round 16 | 
| 250 | E Sports | Map 7 Round 17 | 
| 251 | E Sports | Map 7 Round 18 | 
| 252 | E Sports | Map 7 Round 19 | 
| 253 | E Sports | Map 7 Round 20 | 
| 254 | E Sports | Map 7 Round 21 | 
| 255 | E Sports | Map 7 Round 22 | 
| 256 | E Sports | Map 7 Round 23 | 
| 257 | E Sports | Map 7 Round 24 | 
| 258 | E Sports | Map 7 Round 25 | 
| 259 | E Sports | Map 7 Round 26 | 
| 260 | E Sports | Map 7 Round 27 | 
| 261 | E Sports | Map 7 Round 28 | 
| 262 | E Sports | Map 7 Round 29 | 
| 263 | E Sports | Map 7 Round 30 | 
| 264 | E Sports | Map 7 Round 31 | 
| 265 | E Sports | Map 7 Round 32 | 
| 266 | E Sports | Map 7 Round 33 | 
| 267 | E Sports | Map 7 Round 34 | 
| 268 | E Sports | Map 7 Round 35 | 
| 269 | E Sports | Map 7 Round 36 |
| 0 | Field Hockey | Match | 
| 1 | Field Hockey | 1st Half | 
| 2 | Field Hockey | 2nd Half | 
| 0 | Floorball | Match | 
| 1 | Floorball | 1st Period | 
| 2 | Floorball | 2nd Period | 
| 3 | Floorball | 3rd Period | 
| 0 | Football | Game | 
| 1 | Football | 1st Half | 
| 2 | Football | 2nd Half | 
| 3 | Football | 1st Quarter | 
| 4 | Football | 2nd Quarter | 
| 5 | Football | 3rd Quarter | 
| 6 | Football | 4th Quarter | 
| 0 | Futsal | Match | 
| 1 | Futsal | 1st Half | 
| 2 | Futsal | 2nd Half | 
| 0 | Golf | Matchups | 
| 0 | Handball | Match | 
| 1 | Handball | 1st Half | 
| 2 | Handball | 2nd Half | 
| 0 | Hockey | Game | 
| 1 | Hockey | 1st Period | 
| 2 | Hockey | 2nd Period | 
| 3 | Hockey | 3rd Period | 
| 4 | Hockey | Overtime | 
| 5 | Hockey | Shootout | 
| 6 | Hockey | Regulation Time | 
| 0 | Horse Racing | Race | 
| 0 | Lacrosse | Match | 
| 1 | Lacrosse | 1st Half | 
| 2 | Lacrosse | 2st Half | 
| 3 | Lacrosse | 1st Quarter | 
| 4 | Lacrosse | 2nd Quarter | 
| 5 | Lacrosse | 3rd Quarter | 
| 6 | Lacrosse | 4th Quarter | 
| 0 | Mixed Martial Arts | Fight | 
| 1 | Mixed Martial Arts | Round 1 | 
| 2 | Mixed Martial Arts | Round 2 | 
| 3 | Mixed Martial Arts | Round 3 | 
| 4 | Mixed Martial Arts | Round 4 | 
| 5 | Mixed Martial Arts | Round 5 | 
| 0 | Other Sports | Game | 
| 0 | Politics | Election | 
| 0 | Rugby League | Match | 
| 1 | Rugby League | 1st Half | 
| 2 | Rugby League | 2nd Half | 
| 0 | Rugby Union | Match | 
| 1 | Rugby Union | 1st Half | 
| 2 | Rugby Union | 2nd Half | 
| 0 | Snooker | Match | 
| 1 | Snooker | 1st Frame | 
| 0 | Soccer | Match | 
| 1 | Soccer | 1st Half | 
| 2 | Soccer | 2nd Half | 
| 3 | Soccer | Extra Time | 
| 4 | Soccer | Extra Time 1st Half | 
| 5 | Soccer | Extra Time 2nd Half | 
| 6 | Soccer | Penalty Shootout | 
| 7 | Soccer | 1st Ten Shootout Pen | 
| 8 | Soccer | To Qualify |
| 0 | Softball | Game | 
| 1 | Softball | 1st Half | 
| 2 | Softball | 2st Half | 
| 0 | Squash | Match | 
| 1 | Squash | 1st Game | 
| 2 | Squash | 2nd Game | 
| 3 | Squash | 3rd Game | 
| 4 | Squash | 4th Game | 
| 5 | Squash | 5th Game | 
| 0 | Table Tennis | Match | 
| 1 | Table Tennis | 1st Game | 
| 2 | Table Tennis | 2nd Game | 
| 3 | Table Tennis | 3rd Game | 
| 4 | Table Tennis | 4th Game | 
| 5 | Table Tennis | 5th Game | 
| 6 | Table Tennis | 6th Game | 
| 0 | Tennis | Match | 
| 1 | Tennis | 1st Set | 
| 2 | Tennis | 2nd Set | 
| 3 | Tennis | 3rd Set | 
| 4 | Tennis | 4th Set | 
| 5 | Tennis | 5th Set | 
| 6 | Tennis | Set 1 Game 1 | 
| 7 | Tennis | Set 1 Game 2 | 
| 8 | Tennis | Set 1 Game 3 | 
| 9 | Tennis | Set 1 Game 4 第1盘第4局 | 
| 10 | Tennis | Set 1 Game 5 第1盘第5局 | 
| 11 | Tennis | Set 1 Game 6 第1盘第6局 | 
| 12 | Tennis | Set 1 Game 7 第1盘第7局 | 
| 13 | Tennis | Set 1 Game 8 第1盘第8局 | 
| 14 | Tennis | Set 1 Game 9 第1盘第9局 | 
| 15 | Tennis | Set 1 Game 10 第1盘第10局 | 
| 16 | Tennis | Set 1 Game 11 第1盘第11局 | 
| 17 | Tennis | Set 1 Game 12 第1盘第12局 | 
| 18 | Tennis | Set 1 Game 13 第1盘第13局 | 
| 19 | Tennis | Set 2 Game 1 第2盘第1局 | 
| 20 | Tennis | Set 2 Game 2 第2盘第2局 | 
| 21 | Tennis | Set 2 Game 3 第2盘第3局 | 
| 22 | Tennis | Set 2 Game 4 第2盘第4局 | 
| 23 | Tennis | Set 2 Game 5 第2盘第5局 | 
| 24 | Tennis | Set 2 Game 6 第2盘第6局 | 
| 25 | Tennis | Set 2 Game 7 第2盘第7局 | 
| 26 | Tennis | Set 2 Game 8 第2盘第8局 | 
| 27 | Tennis | Set 2 Game 9 第2盘第9局 | 
| 28 | Tennis | Set 2 Game 10 第2盘第10局 | 
| 29 | Tennis | Set 2 Game 11 第2盘第11局 | 
| 30 | Tennis | Set 2 Game 12 第2盘第12局 | 
| 31 | Tennis | Set 2 Game 13 第2盘第13局 | 
| 32 | Tennis | Set 3 Game 1 第3盘第1局 | 
| 33 | Tennis | Set 3 Game 2 第3盘第2局 | 
| 34 | Tennis | Set 3 Game 3 第3盘第3局 | 
| 35 | Tennis | Set 3 Game 4 第3盘第4局 | 
| 36 | Tennis | Set 3 Game 5 第3盘第5局 | 
| 37 | Tennis | Set 3 Game 6 第3盘第6局 | 
| 38 | Tennis | Set 3 Game 7 第3盘第7局 | 
| 39 | Tennis | Set 3 Game 8 第3盘第8局 | 
| 40 | Tennis | Set 3 Game 9 第3盘第9局 | 
| 41 | Tennis | Set 3 Game 10 第3盘第10局 | 
| 42 | Tennis | Set 3 Game 11 第3盘第11局 | 
| 43 | Tennis | Set 3 Game 12 第3盘第12局 | 
| 44 | Tennis | Set 3 Game 13 第3盘第13局 | 
| 45 | Tennis | Set 3 Game 14 第3盘第14局 | 
| 46 | Tennis | Set 3 Game 15 第3盘第15局 | 
| 47 | Tennis | Set 3 Game 16 第3盘第16局 | 
| 48 | Tennis | Set 3 Game 17 第3盘第17局 | 
| 49 | Tennis | Set 3 Game 18 第3盘第18局 | 
| 50 | Tennis | Set 3 Game 19 第3盘第19局 | 
| 51 | Tennis | Set 3 Game 20 第3盘第20局 | 
| 52 | Tennis | Set 3 Game 21 第3盘第21局 | 
| 53 | Tennis | Set 3 Game 22 第3盘第22局 | 
| 54 | Tennis | Set 3 Game 23 第3盘第23局 | 
| 55 | Tennis | Set 3 Game 24 第3盘第24局 | 
| 56 | Tennis | Set 3 Game 25 第3盘第25局 | 
| 57 | Tennis | Set 3 Game 26 第3盘第26局 | 
| 58 | Tennis | Set 3 Game 27 第3盘第27局 | 
| 59 | Tennis | Set 3 Game 28 第3盘第28局 | 
| 60 | Tennis | Set 3 Game 29 第3盘第29局 | 
| 61 | Tennis | Set 3 Game 30 第3盘第30局 | 
| 62 | Tennis | Set 3 Game 31 第3盘第31局 | 
| 63 | Tennis | Set 3 Game 32 第3盘第32局 | 
| 64 | Tennis | Set 3 Game 33 第3盘第33局 | 
| 65 | Tennis | Set 3 Game 34 第3盘第34局 | 
| 66 | Tennis | Set 3 Game 35 第3盘第35局 | 
| 67 | Tennis | Set 3 Game 36 第3盘第36局 | 
| 68 | Tennis | Set 3 Game 37 第3盘第37局 | 
| 69 | Tennis | Set 3 Game 38 第3盘第38局 | 
| 70 | Tennis | Set 3 Game 39 第3盘第39局 | 
| 71 | Tennis | Set 3 Game 40 第3盘第40局 | 
| 72 | Tennis | Set 3 Game 41 第3盘第41局 | 
| 73 | Tennis | Set 3 Game 42 第3盘第42局 | 
| 74 | Tennis | Set 3 Game 43 第3盘第43局 | 
| 75 | Tennis | Set 3 Game 44 第3盘第44局 | 
| 76 | Tennis | Set 3 Game 45 第3盘第45局 | 
| 77 | Tennis | Set 3 Game 46 第3盘第46局 | 
| 78 | Tennis | Set 3 Game 47 第3盘第47局 | 
| 79 | Tennis | Set 3 Game 48 第3盘第48局 | 
| 80 | Tennis | Set 3 Game 49 第3盘第49局 | 
| 81 | Tennis | Set 3 Game 50 第3盘第50局 | 
| 82 | Tennis | Set 3 Game 51 第3盘第51局 | 
| 83 | Tennis | Set 3 Game 52 第3盘第52局 | 
| 84 | Tennis | Set 3 Game 53 第3盘第53局 | 
| 85 | Tennis | Set 3 Game 54 第3盘第54局 | 
| 86 | Tennis | Set 3 Game 55 第3盘第55局 | 
| 87 | Tennis | Set 3 Game 56 第3盘第56局 | 
| 88 | Tennis | Set 3 Game 57 第3盘第57局 | 
| 89 | Tennis | Set 3 Game 58 第3盘第58局 | 
| 90 | Tennis | Set 3 Game 59 第3盘第59局 | 
| 91 | Tennis | Set 3 Game 60 第3盘第60局 | 
| 92 | Tennis | Set 3 Game 61 第3盘第61局 | 
| 93 | Tennis | Set 3 Game 62 第3盘第62局 | 
| 94 | Tennis | Set 3 Game 63 第3盘第63局 | 
| 95 | Tennis | Set 3 Game 64 第3盘第64局 | 
| 96 | Tennis | Set 3 Game 65 第3盘第65局 | 
| 97 | Tennis | Set 3 Game 66 第3盘第66局 | 
| 98 | Tennis | Set 3 Game 67 第3盘第67局 | 
| 99 | Tennis | Set 3 Game 68 第3盘第68局 | 
| 100 | Tennis | Set 3 Game 69 第3盘第69局 | 
| 101 | Tennis | Set 3 Game 70 第3盘第70局 | 
| 102 | Tennis | Set 3 Game 71 第3盘第71局 | 
| 103 | Tennis | Set 3 Game 72 第3盘第72局 | 
| 104 | Tennis | Set 3 Game 73 第3盘第73局 | 
| 105 | Tennis | Set 3 Game 74 第3盘第74局 | 
| 106 | Tennis | Set 3 Game 75 第3盘第75局 | 
| 107 | Tennis | Set 3 Game 76 第3盘第76局 | 
| 108 | Tennis | Set 3 Game 77 第3盘第77局 | 
| 109 | Tennis | Set 3 Game 78 第3盘第78局 | 
| 110 | Tennis | Set 3 Game 79 第3盘第79局 | 
| 111 | Tennis | Set 3 Game 80 第3盘第80局 | 
| 112 | Tennis | Set 3 Game 81 第3盘第81局 | 
| 113 | Tennis | Set 3 Game 82 第3盘第82局 | 
| 114 | Tennis | Set 3 Game 83 第3盘第83局 | 
| 115 | Tennis | Set 3 Game 84 第3盘第84局 | 
| 116 | Tennis | Set 3 Game 85 第3盘第85局 | 
| 117 | Tennis | Set 3 Game 86 第3盘第86局 | 
| 118 | Tennis | Set 3 Game 87 第3盘第87局 | 
| 119 | Tennis | Set 3 Game 88 第3盘第88局 | 
| 120 | Tennis | Set 3 Game 89 第3盘第89局 | 
| 121 | Tennis | Set 3 Game 90 第3盘第90局 | 
| 122 | Tennis | Set 3 Game 91 第3盘第91局 | 
| 123 | Tennis | Set 3 Game 92 第3盘第92局 | 
| 124 | Tennis | Set 3 Game 93 第3盘第93局 | 
| 125 | Tennis | Set 3 Game 94 第3盘第94局 | 
| 126 | Tennis | Set 3 Game 95 第3盘第95局 | 
| 127 | Tennis | Set 3 Game 96 第3盘第96局 | 
| 128 | Tennis | Set 3 Game 97 第3盘第97局 | 
| 129 | Tennis | Set 3 Game 98 第3盘第98局 | 
| 130 | Tennis | Set 3 Game 99 第3盘第99局 | 
| 131 | Tennis | Set 3 Game 100 第3盘第100局 | 
| 132 | Tennis | Set 4 Game 1 第4盘第1局 | 
| 133 | Tennis | Set 4 Game 2 第4盘第2局 | 
| 134 | Tennis | Set 4 Game 3 第4盘第3局 | 
| 135 | Tennis | Set 4 Game 4 第4盘第4局 | 
| 136 | Tennis | Set 4 Game 5 第4盘第5局 | 
| 137 | Tennis | Set 4 Game 6 第4盘第6局 | 
| 138 | Tennis | Set 4 Game 7 第4盘第7局 | 
| 139 | Tennis | Set 4 Game 8 第4盘第8局 | 
| 140 | Tennis | Set 4 Game 9 第4盘第9局 | 
| 141 | Tennis | Set 4 Game 10 第4盘第10局 | 
| 142 | Tennis | Set 4 Game 11 第4盘第11局 | 
| 143 | Tennis | Set 4 Game 12 第4盘第12局 | 
| 144 | Tennis | Set 4 Game 13 第4盘第13局 | 
| 145 | Tennis | Set 5 Game 1 第5盘第1局 | 
| 146 | Tennis | Set 5 Game 2 第5盘第2局 | 
| 147 | Tennis | Set 5 Game 3 第5盘第3局 | 
| 148 | Tennis | Set 5 Game 4 第5盘第4局 | 
| 149 | Tennis | Set 5 Game 5 第5盘第5局 | 
| 150 | Tennis | Set 5 Game 6 第5盘第6局 | 
| 151 | Tennis | Set 5 Game 7 第5盘第7局 | 
| 152 | Tennis | Set 5 Game 8 第5盘第8局 | 
| 153 | Tennis | Set 5 Game 9 第5盘第9局 | 
| 154 | Tennis | Set 5 Game 10 第5盘第10局 | 
| 155 | Tennis | Set 5 Game 11 第5盘第11局 | 
| 156 | Tennis | Set 5 Game 12 第5盘第12局 | 
| 157 | Tennis | Set 5 Game 13 第5盘第13局 | 
| 158 | Tennis | Set 5 Game 14 第5盘第14局 | 
| 159 | Tennis | Set 5 Game 15 第5盘第15局 | 
| 160 | Tennis | Set 5 Game 16 第5盘第16局 | 
| 161 | Tennis | Set 5 Game 17 第5盘第17局 | 
| 162 | Tennis | Set 5 Game 18 第5盘第18局 | 
| 163 | Tennis | Set 5 Game 19 第5盘第19局 | 
| 164 | Tennis | Set 5 Game 20 第5盘第20局 | 
| 165 | Tennis | Set 5 Game 21 第5盘第21局 | 
| 166 | Tennis | Set 5 Game 22 第5盘第22局 | 
| 167 | Tennis | Set 5 Game 23 第5盘第23局 | 
| 168 | Tennis | Set 5 Game 24 第5盘第24局 | 
| 169 | Tennis | Set 5 Game 25 第5盘第25局 | 
| 170 | Tennis | Set 5 Game 26 第5盘第26局 | 
| 171 | Tennis | Set 5 Game 27 第5盘第27局 | 
| 172 | Tennis | Set 5 Game 28 第5盘第28局 | 
| 173 | Tennis | Set 5 Game 29 第5盘第29局 | 
| 174 | Tennis | Set 5 Game 30 第5盘第30局 | 
| 175 | Tennis | Set 5 Game 31 第5盘第31局 | 
| 176 | Tennis | Set 5 Game 32 第5盘第32局 | 
| 177 | Tennis | Set 5 Game 33 第5盘第33局 | 
| 178 | Tennis | Set 5 Game 34 第5盘第34局 | 
| 179 | Tennis | Set 5 Game 35 第5盘第35局 | 
| 180 | Tennis | Set 5 Game 36 第5盘第36局 | 
| 181 | Tennis | Set 5 Game 37 第5盘第37局 | 
| 182 | Tennis | Set 5 Game 38 第5盘第38局 | 
| 183 | Tennis | Set 5 Game 39 第5盘第39局 | 
| 184 | Tennis | Set 5 Game 40 第5盘第40局 | 
| 185 | Tennis | Set 5 Game 41 第5盘第41局 | 
| 186 | Tennis | Set 5 Game 42 第5盘第42局 | 
| 187 | Tennis | Set 5 Game 43 第5盘第43局 | 
| 188 | Tennis | Set 5 Game 44 第5盘第44局 | 
| 189 | Tennis | Set 5 Game 45 第5盘第45局 | 
| 190 | Tennis | Set 5 Game 46 第5盘第46局 | 
| 191 | Tennis | Set 5 Game 47 第5盘第47局 | 
| 192 | Tennis | Set 5 Game 48 第5盘第48局 | 
| 193 | Tennis | Set 5 Game 49 第5盘第49局 | 
| 194 | Tennis | Set 5 Game 50 第5盘第50局 | 
| 195 | Tennis | Set 5 Game 51 第5盘第51局 | 
| 196 | Tennis | Set 5 Game 52 第5盘第52局 | 
| 197 | Tennis | Set 5 Game 53 第5盘第53局 | 
| 198 | Tennis | Set 5 Game 54 第5盘第54局 | 
| 199 | Tennis | Set 5 Game 55 第5盘第55局 | 
| 200 | Tennis | Set 5 Game 56 第5盘第56局 | 
| 201 | Tennis | Set 5 Game 57 第5盘第57局 | 
| 202 | Tennis | Set 5 Game 58 第5盘第58局 | 
| 203 | Tennis | Set 5 Game 59 第5盘第59局 | 
| 204 | Tennis | Set 5 Game 60 第5盘第60局 | 
| 205 | Tennis | Set 5 Game 61 第5盘第61局 | 
| 206 | Tennis | Set 5 Game 62 第5盘第62局 | 
| 207 | Tennis | Set 5 Game 63 第5盘第63局 | 
| 208 | Tennis | Set 5 Game 64 第5盘第64局 | 
| 209 | Tennis | Set 5 Game 65 第5盘第65局 | 
| 210 | Tennis | Set 5 Game 66 第5盘第66局 | 
| 211 | Tennis | Set 5 Game 67 第5盘第67局 | 
| 212 | Tennis | Set 5 Game 68 第5盘第68局 | 
| 213 | Tennis | Set 5 Game 69 第5盘第69局 | 
| 214 | Tennis | Set 5 Game 70 第5盘第70局 | 
| 215 | Tennis | Set 5 Game 71 第5盘第71局 | 
| 216 | Tennis | Set 5 Game 72 第5盘第72局 | 
| 217 | Tennis | Set 5 Game 73 第5盘第73局 | 
| 218 | Tennis | Set 5 Game 74 第5盘第74局 | 
| 219 | Tennis | Set 5 Game 75 第5盘第75局 | 
| 220 | Tennis | Set 5 Game 76 第5盘第76局 | 
| 221 | Tennis | Set 5 Game 77 第5盘第77局 | 
| 222 | Tennis | Set 5 Game 78 第5盘第78局 | 
| 223 | Tennis | Set 5 Game 79 第5盘第79局 | 
| 224 | Tennis | Set 5 Game 80 第5盘第80局 | 
| 225 | Tennis | Set 5 Game 81 第5盘第81局 | 
| 226 | Tennis | Set 5 Game 82 第5盘第82局 | 
| 227 | Tennis | Set 5 Game 83 第5盘第83局 | 
| 228 | Tennis | Set 5 Game 84 第5盘第84局 | 
| 229 | Tennis | Set 5 Game 85 第5盘第85局 | 
| 230 | Tennis | Set 5 Game 86 第5盘第86局 | 
| 231 | Tennis | Set 5 Game 87 第5盘第87局 | 
| 232 | Tennis | Set 5 Game 88 第5盘第88局 | 
| 233 | Tennis | Set 5 Game 89 第5盘第89局 | 
| 234 | Tennis | Set 5 Game 90 第5盘第90局 | 
| 235 | Tennis | Set 5 Game 91 第5盘第91局 | 
| 236 | Tennis | Set 5 Game 92 | 
| 237 | Tennis | Set 5 Game 93 | 
| 238 | Tennis | Set 5 Game 94 | 
| 239 | Tennis | Set 5 Game 95 | 
| 240 | Tennis | Set 5 Game 96 | 
| 241 | Tennis | Set 5 Game 97 | 
| 242 | Tennis | Set 5 Game 98 | 
| 243 | Tennis | Set 5 Game 99 | 
| 244 | Tennis | Set 5 Game 100 | 
| 0 | Volleyball | Match | 
| 1 | Volleyball | 1st Set | 
| 2 | Volleyball | 2nd Set | 
| 3 | Volleyball | 3rd Set | 
| 4 | Volleyball | 4th Set | 
| 5 | Volleyball | 5th Set | 
| 0 | Volleyball (Points) | Game | 
| 1 | Volleyball (Points) | 1st Set | 
| 2 | Volleyball (Points) | 2nd Set | 
| 3 | Volleyball (Points) | 3rd Set | 
| 4 | Volleyball (Points) | 4th Set | 
| 5 | Volleyball (Points) | 5th Set | 
| 0 | Water Polo | Match | 
| 1 | Water Polo | 1st Period | 
| 2 | Water Polo | 2nd Period | 
| 3 | Water Polo | 3rd Period | 
| 4 | Water Polo | 4th Period | 
| 0 | Padel Tennis | Match | 
| 1 | Padel Tennis | 1st Set Winner | 
| 2 | Padel Tennis | 2nd Set Winner | 
| 3 | Padel Tennis | 3rd Set Winner | 
| 0 | Aussie Rules | Game | 
| 1 | Aussie Rules | 1st Half | 
| 2 | Aussie Rules | 2nd Half | 
| 3 | Aussie Rules | 1st Quarter | 
| 4 | Aussie Rules | 2nd Quarter | 
| 5 | Aussie Rules | 3rd Quarter | 
| 6 | Aussie Rules | 4th Quarter | 
| 0 | Alpine Skiing | Matchups | 
| 0 | Biathlon | Matchups | 
| 0 | Ski Jumping | Matchups | 
| 0 | Cross Country | Matchups | 
| 0 | Formula 1 | Matchups | 
| 0 | Cycling | Matchups | 
| 0 | Bobsleigh | Matchups | 
| 0 | Figure Skating | Matchups | 
| 0 | Freestyle Skiing | Matchups | 
| 0 | Luge | Matchups | 
| 0 | Nordic Combined | Matchups | 
| 0 | Short Track | Matchups | 
| 0 | Skeleton | Matchups | 
| 0 | Snow Boarding | Matchups | 
| 0 | Speed Skating | Matchups | 
| 0 | Olympics | Match | 
| 0 | Athletics | Matchups | 
| 0 | Crossfit | Matchups | 
| 0 | Entertainment | Matchups | 
| 0 | Archery | Match | 
| 0 | Drone Racing | Matchups | 
| 0 | Poker | Matchup | 
| 0 | Motorsport | Matchups | 
| 0 | Simulated Games | Game | 
| 1 | Simulated Games | 1st Half | 
| 2 | Simulated Games | 2nd Half | 
| 0 | Sumo | Match | 

## 13. User Status

| Code | Name | Description |
| --- | --- | --- |
| `ACTIVE` | User is active | ‘ACTIVE’ player CAN log in and place bet on Member site. | 
| `INACTIVE` | User is inactive | ‘INACTIVE’ player CANNOT log in on Member site. | 
| `SUSPENDED` | User is suspended by direct agent. | ‘SUSPENDED’ player CAN log in on Member site, but CANNOT place bet. | 
| `SUSPENDED_BY_COMPANY` | User is suspended by ‘Company’ agent. | ‘SUSPENDED_BY_COMPANY’ player CAN log in on Member site, but CANNOT place bet. | 
| `CLOSED` | User is closed by administrator | ‘CLOSED’ player CANNOT log in on Member site. | 
| `INACTIVE_BY_COMPANY` | User is inactive by company | ‘INACTIVE_BY_COMPANY’ player CANNOT log in on Member site. | 


## 14. Leg Status Result

| No | Code | Description |
| --- | --- | --- |
| 1 | `ACCEPTED` | The leg is accepted | 
| 2 | `CANCELLED` | The leg is cancelled - the stake on this leg will be transferred to the next one. In this case the leg will be ignored when calculating the win/loss. | 
| 3 | `LOSE` | The leg is a loss - the whole parlay wager will settled as lose. | 
| 4 | `PUSH` | The leg is a push - the stake on this leg will be transferred to the next one. In this case the leg will be ignored when calculating the win/loss. | 
| 5 | `REFUNDED` | The leg is refunded - the stake on this leg will be transferred to the next one. In this case the leg will be ignored when calculating the win/loss. | 
| 6 | `WON` | The leg is a win - this leg will be settled as a win. | 
| 7 | `HALF_WON_HALF_PUSHED` | The leg has been settled as half win. | 
| 8 | `HALF_LOST_HALF_PUSHED` | The leg has been settled as half lose. | 

## 15. Non-login currency display

For non-login currency display, please add parameter /?currency=value<br/>
E.g.  <br/>
Non-login domain → https://whitelabelapidomain.com/en <br/>
If you would like to display MYR when non-login → https://whitelabelapidomain.com/en/?currency=MYR <br/>
Note: Without this parameter, the default non-login currency would be CNY. <br/>

## 16. Bet Status Partial Result

| Code | Description |
| --- | --- |
| 0 | Half | 
| 1 | Full | 

