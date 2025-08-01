# Affiliates Odds

## Description

This service will return odds data for affiliate use.
- Clients must provide a valid sport name as a parameter to retrieve all available events and their corresponding odds.
- Only affiliates with allowed access are permitted to retrieve odds data from this endpoint.
Call the API along with the Sport name to get events.

Each Sport has its own logic for getting hot events:

- If the requested Sport is Soccer: The Hot Events will be based on the following information to return all Hot Events.
	- Hot Soccer Team and Hot Leagues (return Hot Events starting in the next 15 days).
	- Highest max bet of Money Line.
- If requested Sport is E-Sports: The Hot Events will be based on the following information to return all Hot Events for each Game.
	- Hot E-Sports team and Hot Leagues (return Hot Events starting in the next 15 days).
	- Highest max bet of Money Line
- For all other Sports: The Hot Events will be based on the following information to return all Hot Events for each Sport.
	- Hot Leagues (return Hot Events starting in the next 15 days).
	- Highest max bets of Money line.

## Endpoint

| Name | Value | Description  |
| ---  | ---  | ---   |
| URL  | `/affiliate/v1/odds` |   |
| Method  | `GET` | |
 
## Parameters

| Name | Type | Value  | Validation  | Description  |
| ---  | ---  | ---  | ---  | ---  |
| `userCode`  | Header | String (required)  |  | This is the affiliate code |
| `locale` | Query | String (optional) | Supported locales. Default: `en`| Supported language [here](#languages)
| `oddsFormat` | Query | String (optional ) | List supported oddsFormat: `AM`, `EU`, `HK`, `ID`, `MY` | See Odds Format [here](#odds-format)  |
| `sport` | Query | String(required) | Sport code.|  See Sport [here](#sports) |

## Response OK

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
## Sports

| Id | Name | Code
| --- | --- | ---
| 1 | Badminton  | badminton
| 2 | Bandy | bandy
| 3 | Baseball | baseball
| 4 | Basketball | basketball
| 5 | Beach Volleyball | beach-volleyball
| 6 | Boxing | boxing
| 8 | Cricket | cricket
| 9 | Curling | curling
| 10 | Darts  | darts
| 11 | Darts (Legs) | darts-legs
| 12 | E-Sports  | e-sports
| 13 | Field Hockey  |field-hockey
| 14 | Floorball  | floorball
| 15 | Football  | football
| 16 | Futsal  | futsal
| 17 | Golf  | golf
| 18 | Handball  | handball
| 19 | Hockey  | hockey
| 22 | Mixed Martial Arts  |mixed-martial-arts
| 24 | Politics  | politics
| 26 | Rugby League  | rugby-league
| 27 | Rugby Union  | rugby-union
| 28 | Snooker  |snooker
| 29 | Soccer  |soccer
| 30 | Softball  |softball
| 31 | Squash  |squash
| 32 | Table Tennis  | table-tennis
| 33 | Tennis  |tennis
| 34 | Volleyball  |volleyball
| 35 | Volleyball (Points) | volleyball-points
| 36 | Water Polo  |water-polo
| 39 | Aussie Rules  |aussie-rules
| 40 | Alpine Skiing  |alpine-skiing
| 41 | Biathlon  |biathlon
| 42 | Ski Jumping  |ski-jumping
| 43 | Cross Country  |cross-country
| 44 | Formula 1  |formula-1
| 45 | Cycling  |cycling
| 46 | Bobsleigh  |bobsleigh
| 47 | Figure Skating  |figure-skating
| 48 | Freestyle Skiing  |freestyle-skiing
| 49 | Luge  |luge
| 50 | Nordic Combined  |nordic-combined
| 51 | Short Track  |short-track
| 52 | Skeleton  |skeleton
| 53 | Snow Boarding  |snow-boarding
| 54 | Speed Skating  |speed-skating
| 55 | Olympics  |olympics
| 56 | Athletics  |athletics
| 57 | CrossFit  |crossfit
| 58 | Entertainment  |entertainment
| 59 | Archery  |archery
| 60 | Drone Racing  |drone-racing
| 62 | Poker  |poker

## Odds Format

| Code  | Name   | Description  |
| --- | ---  | ---   |
| 0 | `AM`  | American odds format  |
| 1 | `EU`  | Euro odds format |
| 2 | `HK`  | Hong Kong odds format  |
| 3 | `ID`  | Indo odds format  |
| 4 | `MY`  | Malay odds format  |

## Languages 

| Locale code  | Description   |
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
