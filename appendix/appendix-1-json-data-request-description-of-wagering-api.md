# Appendix 1: JSON Data Request Description of Wagering API. 附录 1： 关于下注API JSON数据请求的说明.

The Wagering API has 7 action types: `betted`, `accepted`, `settled`, `rollbacked`, `cancelled`, `rejected` and `unsettled`. Each action is composed of 3 elements: action, wager information, and transaction.

Wagering API里面有7个action种类：`betted`, `accepted`, `settled`, `rollbacked`, `cancelled`, `rejected`, `unsettled`。每个action都是由3个元素组成的：action, wager information 和 transaction。

This section will describe the meaning of each object along with sample values. 

这个章节会介绍每个对象的意思以及它们可能的值。

*Root Object 根对象* 
 
| Name 名称 | Description 说明 | Values 值 |
| --- | --- | --- | 
| Timestamp<br/>时间戳 | Action time stamp<br/>动作的时间戳 | 2023-11-24T05:24:08 |
| Signature<br/>签名 | Request signature<br/>请求签名 | fHLuKC27EQUsbK8iXhS2/Wr5+Tw2x/hA5Xl1bGdpU13W0ZYbduwgGcY5ItO1541IrwH6eiD9M4Pnm3ae4Uq34w== |
| Actions<br/>动作 | Action Object<br/>动作对象 |  |

*Action Object (Actions) 动作对象（动作）*
 
| Name 名称 | Description 说明 | Values 值 |
| --- | --- | --- | 
| Id<br/>身份标识 | ID of the action. It is unique in the betting platform.  动作的ID，此ID是独一无二的。| `124434343` |
| Name <br/>名称 | This is the action type. It corresponds to the wager status. Note: In JSON Post data, the value may be uppercase or lowercase. <br/> 这是动作类型。它对应注单状态。 注：在JSON Post 数据中，值可能是大写或小写|`BETTED`<br/>`ACCEPTED`<br/>`SETTLED`<br/>`ROLLBACKED`<br/>`CANCELLED`<br/>`REJECTED`<br/>`UNSETTLED` |
| WagerInfo <br/>注单信息 | This is the wager information that player placed bet. It is a JSON object whose properties depend action type.  此为玩家投注时的注单信息。它是JSON对象, 属性由action的种类而决定。 |  |
| Transaction<br/>交易 | The Operator uses this transaction object to debit/credit the balance of the wallet. 运营商用transaction 对象来增/减钱包里的余额。 |  |
| PlayerInfo<br/>玩家信息 | This is the information of the player that placed the bet.<br/>此为下注玩家的信息 |  |
| ManualWager<br/>手动注单 | Manual wager indicator. Its type is Boolean.<br/>手动注单指针， 它的类型是Boolean| true |

*Wager Information Object (WagerInfo) 注单信息对象（注单信息）*

<table>
 <tr>
  <th rowspan="2">Name 名称</th> 
  <th rowspan="2">Description 说明</th> 
  <th colspan="4">Action Type 投注动作</th>
  <th colspan="3">Wager Type 注单类型</th>
  <th rowspan="2">Values 值</th>
 </tr>
 <tr>
  <th>Bet 投注</th>
  <th>Accept 作实</th>
  <th>Settled 已结算</th>
  <th>rollback cancel reject unsettled 取消/退回结算</th>
  <th>Single 单注</th>
  <th>Parlay 过关</th>
  <th>Teaser 变让分过关</th>
 </tr>
 <tr>
  <td>WagerId 注单ID</td>
  <td>ID of wager in betting platform. Its type is Long.<br/>为下注平台内的注单ID， 类型是Long.</td>
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
  <td>Type 注单种类</td>
  <td>Type of wager.  Its type is String.<br/>注单类型，类型是字符串.</td>
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
  <td>BetType 投注种类</td>
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
  <td>Odds 赔率</td>
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
  <td>OddsFormat 赔率格式</td>
  <td>Format of odds that player betted. Its type is Integer. Refer to 1.7.</td>
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
  <td>ToWin 期望彩金</td>
  <td>Amount of how much the player may win. Its type is Decimal. 如注单为赢，玩家能获得的盈利</td>
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
  <td>ToRisk 下注风险额</td>
  <td>Amount of how much the player may lose. Its type is Decimal. 如注单为输，玩家会输的金额。</td>
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
  <td>EventId 赛事ID</td>
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
  <td>EventName 赛事名称</td>
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
  <td>LeagueId 联赛ID</td>
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
  <td>Sport 运动</td>
  <td>Name of Sport. Its type is String. Refer to 1.4.<br/>Note: The value may be uppercase or lowercase. </td>
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
  <td>Inplay 滚球</td>
  <td>Whether the bet was placed inplay. Its type is Boolean</td>
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
  <td>InPlayScore 滚球比分</td>
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
  <td>Handicap 让分盘</td>
  <td>Handicap amount. Its type is Decimal</td>
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
  <td>SelectionType 投注选项</td>
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
  <td>HomePitcher 棒球主队投球手</td>
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
  <td>AwayPitcher 棒球客队投球手</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data</td>
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
  <td>HomePitcherName 棒球主队投球手名</td>
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
  <td>AwayPitcherName棒球客队投球手名</td>
  <td>Only used for baseball. Its type is String.<br/>Note: If value is NULL, it may not exist in the JSON data</td>
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
  <td>ProfitAndLoss 输赢</td>
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
  <td>Outcome 注单结果</td>
  <td>Outcome is the result of the wager after settlement. Its type is String with 3 values: WIN, LOSE, or DRAW. 注单结算结果，有三个值：赢，输，打和。</td>
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
  <td>WagerMasterId 总注单ID</td>
  <td>Parent Id of the wager when the wager is of type parlay. Its type is Long. 过关注单的parent ID</td>
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
  <td>RoundRobinOptions 轮询过关选择</td>
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
  <td>Legs.SportId 注单运动类型ID</td>
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
  <td>Legs.Sport 注单的运动类型</td>
  <td>Name of the sport in a leg. Its type is String. Refer to 1.4.</td>
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
  <td>Legs.SportGroup 注单的运动所属组</td>
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
  <td>Legs.LeagueId 注单联赛ID</td>
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
  <td>Legs.League 注单联赛名</td>
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
  <td>Legs.BetType 注单投注类型</td>
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
  <td>Type of selection. Its type is Integer</td>
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
  <td>Legs.InplayScore 注单滚球比分</td>
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
  <td>Legs.InPlay 注单滚球</td>
  <td>Whether the event of a leg is inplay or not. Its type is Boolean. 标明该注单是否在滚球时下注。</td>
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
  <td>Legs.Odds 注单赔率</td>
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
  <td>Legs.Handicap 注单让球</td>
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
  <td>Legs.Period 注单投注比赛区间</td>
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
  <td>Legs.TeamType 注单队伍类型</td>
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
  <td>Legs.Point 注单分值</td>
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
  <td>Legs.EventName 注单赛事名</td>
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
  <td>Legs.HomePitcher 注单主队投手</td>
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
  <td>Legs.AwayPitcher 注单客队投手</td>
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
  <td>Legs.HomePitcherName 注单主队投手名</td>
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
  <td>Legs.AwayPitcherName 注单客队投手名</td>
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
  <th rowspan="2">Name 名称</th> 
  <th rowspan="2">Description 说明</th> 
  <th colspan="4">Action Type 投注动作</th>
  <th colspan="3">Wager Type</th>
  <th rowspan="2">Values 值</th>
 </tr>
 <tr>
  <th>Bet 投注</th>
  <th>Accept 作实</th>
  <th>Settled 已结算</th>
  <th>rollback cancel reject unsettled 取消/退回结算</th>
  <th>Single 单注</th>
  <th>Parlay 过关</th>
  <th>Teaser 变让分过关</th>
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
  <td>Transaction amount. Its type is Decimal</td>
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
  <th rowspan="2">Name 名称</th> 
  <th rowspan="2">Description 说明</th> 
  <th colspan="4">Action Type 投注动作</th>
  <th colspan="3">Wager Type 注单类型</th>
  <th rowspan="2">Values 值</th>
 </tr>
 <tr>
  <th>Bet 投注</th>
  <th>Accept 作实</th>
  <th>Settled 已结算</th>
  <th>rollback cancel reject unsettled 取消/退回结算</th>
  <th>Single 单注</th>
  <th>Parlay 过关</th>
  <th>Teaser 变让分过关</th>
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
