# Appendix 1: JSON Data Request Description of Wagering API.

The Wagering API has 7 action types: `betted`, `accepted`, `settled`, `rollbacked`, `cancelled`, `rejected` and `unsettled`. Each action is composed of 3 elements: action, wager information, and transaction.

This section will describe the meaning of each object along with sample values. 

*Root Object*
 
| Name | Description | Values |
| --- | --- | --- | 
| Timestamp | Action time stamp | 2023-11-24T05:24:08 |
| Signature | Request signature | fHLuKC27EQUsbK8iXhS2/Wr5+Tw2x/hA5Xl1bGdpU13W0ZYbduwgGcY5ItO1541IrwH6eiD9M4Pnm3ae4Uq34w== |
| Actions   | Action Object  |  |

*Action Object (Actions)*
 
| Name | Description | Values |
| --- | --- | --- | 
| Id ID | ID of the action. It is unique in the betting platform. | `124434343` |
| Name | This is the action type. It corresponds to the wager status. Note: In JSON Post data, the value may be uppercase or lowercase.  
|`BETTED`<br/>`ACCEPTED`<br/>`SETTLED`<br/>`ROLLBACKED`<br/>`CANCELLED`<br/>`REJECTED`<br/>`UNSETTLED` |
| WagerInfo | This is the wager information that player placed bet. It is a JSON object whose properties depend action type. |  |
| Transaction | The Operator uses this transaction object to debit/credit the balance of the wallet. |  |
| PlayerInfo | This is the information of the player that placed the bet. |  |
| ManualWager | Manual wager indicator. Its type is Boolean. | true |

*Wager Information Object (WagerInfo)*

<table>
 <tr>
  <th rowspan="2">Name</th> 
  <th rowspan="2">Description</th> 
  <th colspan="4">Action Type</th>
  <th colspan="3">Wager Type</th>
  <th rowspan="2">Values</th>
 </tr>
 <tr>
  <th>Bet</th>
  <th>Accept</th>
  <th>Settled</th>
  <th>rollback cancel reject unsettled</th>
  <th>Single</th>
  <th>Parlay</th>
  <th>Teaser</th>
 </tr>
 <tr>
  <td>WagerId</td>
  <td>ID of wager in betting platform. Its type is Long. </td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>725462707</td>
 </tr>
 <tr>
  <td>Type</td>
  <td>Type of wager.  Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>SINGLE</br>PARLAY</br>TEASER</td>
 </tr>
 <tr>
  <td>BetType</td>
  <td>Type of bet. It relates to wager type. Its type is Integer.<br/>Bet type: <br/>6 – parlay<br/>7 – teaser<br/>other - single.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>6</td>
 </tr>
 <tr>
  <td>Odds</td>
  <td>Value of odds that player betted. Its type is Decimal.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>12.666</td>
 </tr>
 <tr>
  <td>OddsFormat</td>
  <td>Format of odds that player betted. Its type is Integer. Refer to Data format- 4.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>1</td>
 </tr>
 <tr>
  <td>ToWin</td>
  <td>Amount of how much the player may win. Its type is Decimal. </td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>128.330</td>
 </tr>
 <tr>
  <td>ToRisk</td>
  <td>Amount of how much the player may lose. Its type is Decimal.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>11.000</td>
 </tr>
 <tr>
  <td>Stake</td>
  <td>Stake amount. Its type is Decimal.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>12.000</td>
 </tr>
 <tr>
  <td>EventId</td>
  <td>ID of event in wager that player bet. Its type is Long.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>988939488</td>
 </tr>
 <tr>
  <td>EventName</td>
  <td>Name of event in wager that player bet. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>CA Independiente de La Chorrera-vs-CD Universitario Chorrillo</td>
 </tr>
 <tr>
  <td>EventDateFm</td>
  <td>Event date. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>2023-11-22 21:30:00</td>
 </tr>
 <tr>
  <td>LeagueId</td>
  <td>League ID of event. Its type is Long.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>10573</td>
 </tr>
 <tr>
  <td>LeagueName</td>
  <td>Name of the league. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>ATP Challenger Yokohama - R16</td>
 </tr>
 <tr>
  <td>SportId</td>
  <td>ID of the sport. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>29</td>
 </tr>
 <tr>
  <td>Sport</td>
  <td>Name of Sport. Its type is String. Refer to Data format - 1.<br/>Note: The value may be uppercase or lowercase.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>SOCCER</td>
 </tr>
 <tr>
  <td>Inplay</td>
  <td>Whether the bet was placed inplay. Its type is Boolean. </td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>true</td>
 </tr>
 <tr>
  <td>InPlayScore</td>
  <td>For inplay bets, the score at the time of placing the bet. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>2-0</td>
 </tr>
 <tr>
  <td>Handicap</td>
  <td>Handicap amount. Its type is Decimal.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>-0.25</td>
 </tr>
 <tr>
  <td>SelectionType</td>
  <td>Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>AWAY</br>HOME</br>DRAW</br>...</td>
 </tr>
 <tr>
  <td>HomePitcher</td>
  <td>Only used for baseball. Its type is String. <br/>Note: If value is NULL, it may not exist in the JSON data.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>R. Messenger</td>
 </tr>
 <tr>
  <td>AwayPitcher</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>D. Yamai</td>
 </tr>
 <tr>
  <td>HomePitcherName</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>R. Messenger</td>
 </tr>
 <tr>
  <td>AwayPitcherName</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>D. Yamai</td>
 </tr>
 <tr>
  <td>Selection</td>
  <td>Chosen team. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>Michael Mmoh</td>
 </tr>
 <tr>
  <td>ParentEventName</td>
  <td>Name of event in wager that player bet. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>Kanga-vs-Gravitas</td>
 </tr>
 <tr>
  <td>PlayerIPAddress</td>
  <td>IP address of the bettor. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>175.176.58.233</td>
 </tr>
 <tr>
  <td>Scores.Period</td>
  <td>Match period. Its type is Integer.</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>0</td>
 </tr>
 <tr>
  <td>Scores.Score</td>
  <td>Score at time of wager placement. Its type is String.</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>1-0</td>
 </tr>
 <tr>
  <td>ProfitAndLoss</td>
  <td>Profit and Loss of wager after settlement. Its type is Decimal.</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-6.250</td>
 </tr>
 <tr>
  <td>Outcome</td>
  <td>Outcome is the result of the wager after settlement. Its type is String with 3 values: WIN, LOSE, or DRAW.</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>WIN</br>LOSE</br>DRAW</td>
 </tr>
 <tr>
  <td>Period</td>
  <td>Match period. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>0</td>
 </tr>
 <tr>
  <td>SettlementTime</td>
  <td>Date and time of wager settlement. Its type is String.</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>2019-05-14 06:00:00</td>
 </tr>
 <tr>
  <td>ResettlementTime</td>
  <td>Date and time of wager resettlement. Its type is String.</td>
  <td>-</td>
  <td>-</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>2019-05-14 07:00:00</td>
 </tr>
 <tr>
  <td>WagerMasterId</td>
  <td>Parent Id of the wager when the wager is of type parlay. Its type is Long.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>725462707</td>
 </tr>
 <tr>
  <td>WagerNum</td>
  <td>Number of bets generated. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>1</td>
 </tr>
 <tr>
  <td>RoundRobinOptions</td>
  <td>Round Robin Type of parlay wager.<br/>Note: value is string array.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>["Parlay", ...]</td>
 </tr>
 <tr>
  <td>Description</td>
  <td>Manual wager description. Its type is String.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>-</td>
  <td>-</td>
  <td>Baseball - MLB<br/>Minnesota Twins vs Chicago White Sox - Over 8.5 @ -128 for Game</td>
 </tr>
 <tr>
  <td>Legs.LegId</td>
  <td>ID of the leg. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>dd501a83-d913-95f5-2cd7-15d3151d2672</td>
 </tr>
 <tr>
  <td>Legs.SportId</td>
  <td>ID of the sport in a leg. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>29</td>
 </tr>
 <tr>
  <td>Legs.Sport</td>
  <td>Name of the sport in a leg. Its type is String. Refer to Data format - 1. Sports</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>Soccer</td>
 </tr>
 <tr>
  <td>Legs.SportGroup</td>
  <td>ID of the sport group in a leg. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>0</td>
 </tr>
 <tr>
  <td>Legs.LeagueId</td>
  <td>ID of the league in a leg. Its type is Long.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>1544875</td>
 </tr>
 <tr>
  <td>Legs.League</td>
  <td>Name of the league in a leg. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>Finland - Ykkonen</td>
 </tr>
 <tr>
  <td>Legs.BetType</td>
  <td>Type of bet in a leg. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>1</td>
 </tr>
 <tr>
  <td>Legs.EventId</td>
  <td>ID of event in leg that player bet. Its type is Long.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>1582132612</td>
 </tr>
 <tr>
  <td>Legs.EventDateFm</td>
  <td>Event date. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>2023-11-22 06:15:29</td>
 </tr>
 <tr>
  <td>Legs.SelectionType</td>
  <td>Type of selection. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>1</td>
 </tr>
 <tr>
  <td>Legs.InplayScore</td>
  <td>Score of the event in a leg when it is inplay. Its type is String.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>2-0</td>
 </tr>
 <tr>
  <td>Legs.InPlay</td>
  <td>Whether the event of a leg is inplay or not. Its type is Boolean.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>true</td>
 </tr>
 <tr>
  <td>Legs.Odds</td>
  <td>Odds value of a leg. Its type is Decimal.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>7.660</td>
 </tr>
 <tr>
  <td>Legs.Handicap 选项让球</td>
  <td>Handicap of event in a leg. Its type is Decimal.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>0.00</td>
 </tr>
 <tr>
  <td>Legs.Period</td>
  <td>Period of event in a leg. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>0</td>
 </tr>
 <tr>
  <td>Legs.LegStatus</td>
  <td>Status of the leg. Its type is String.</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>WON</td>
 </tr>
 <tr>
  <td>Legs.TeamType</td>
  <td>Team Type of event in a leg. Its type is Integer.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>0</td>
 </tr>
 <tr>
  <td>Legs.Point</td>
  <td>Points on a bet. Its type is Decimal.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>1.004</td>
 </tr>
 <tr>
  <td>Legs.EventName</td>
  <td>Name of Event in a leg. It type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>TPS Turku-vs-Ac Kajaani</td>
 </tr>
 <tr>
  <td>Legs.HomePitcher</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>R. Messenger</td>
 </tr>
 <tr>
  <td>Legs.AwayPitcher</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>D. Yamai</td>
 </tr>
 <tr>
  <td>Legs.HomePitcherName</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>R. Messenger</td>
 </tr>
 <tr>
  <td>Legs.AwayPitcherName</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data.</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>D. Yamai</td>
 </tr>
 <tr>
  <td>Legs.Type</td>
  <td>Wager type of the leg. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>College 2 - 6 Team</td>
 </tr>
 <tr>
  <td>Legs.Selection</td>
  <td>Chosen team. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>Brasil de Pelotas</td>
 </tr>
 <tr>
  <td>Legs.Scores.Period</td>
  <td>Match period. Its type is Integer.</td>
  <td>-</td>
  <td>-</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>0</td>
 </tr>
 <tr>
  <td>Legs.Scores.Score</td>
  <td>Score for the period. Its type is String.</td>
  <td>-</td>
  <td>-</td>
  <td>:white_check_mark:</td>
  <td>-</td>
  <td>-</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>1-0</td>
 </tr>
</table>

*Transaction Object (Transaction)*

<table>
 <tr>
  <th rowspan="2">Name</th> 
  <th rowspan="2">Description</th> 
  <th colspan="4">Action Type</th>
  <th colspan="3">Wager Type</th>
  <th rowspan="2">Values</th>
 </tr>
 <tr>
  <th>Bet</th>
  <th>Accept</th>
  <th>Settled</th>
  <th>rollback cancel reject unsettled</th>
  <th>Single</th>
  <th>Parlay</th>
  <th>Teaser</th>
 </tr>
 <tr>
  <td>TransactionId</td>
  <td>ID of transaction in betting platform. Its type is Long.</td>
  <td>:heavy_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>18488162</td>
 </tr>
 <tr>
  <td>ReferTransactionId</td>
  <td>TransactionId of the previous BETTED action. Its type is Long.</td>
  <td>-</td>
  <td>-</td>
  <td>-</td>
  <td>:white_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>18586167</td>
 </tr>
 <tr>
  <td>TransactionType</td>
  <td>Type of transaction. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>CREDIT</td>
 </tr>
 <tr>
  <td>TransactionDate</td>
  <td>Transaction date. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>2019-05-04T03:32:47</td>
 </tr>
  <tr>
  <td>Amount</td>
  <td>Transaction amount. Its type is Decimal.</td>
  <td>:heavy_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:white_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>10</td>
 </tr>
 <tr>
</table>


*Player Information Object (PlayerInfo)*

<table>
 <tr>
  <th rowspan="2">Name</th> 
  <th rowspan="2">Description</th> 
  <th colspan="4">Action Type</th>
  <th colspan="3">Wager Type</th>
  <th rowspan="2">Values</th>
 </tr>
 <tr>
  <th>Bet</th>
  <th>Accept</th>
  <th>Settled</th>
  <th>rollback cancel reject unsettled</th>
  <th>Single</th>
  <th>Parlay</th>
  <th>Teaser</th>
 </tr>
 <tr>
  <td>LoginId</td>
  <td>Login ID of the player. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>MPvZSDqM1685576929</td>
 </tr>
 <tr>
  <td>UserCode</td>
  <td>Usercode of the player. Its type is String.</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>:heavy_check_mark:</td>
  <td>PXM130000D</td>
 </tr>
<tr>
</table>


:heavy_check_mark: 	: The property is always present in JSON data.</br>
:white_check_mark: 	: The property is present in JSON data only if its value is not NULL.</br>
\-	: The property is not applicable in the corresponding context.
