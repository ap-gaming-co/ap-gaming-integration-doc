# Appendix 2: JSON Data Response Description of Wagering API. 附录 2： 投注API JSON数据响应说明.

This section will describe the meaning of each object along with sample values.

这个章节会介绍每个对象的意思以及它们可能的值。

*Root Object 根对象*
 
| Name 名称 | Description 说明 | Values 值 |
| --- | --- | --- | 
| Result 结果 | Result Object 结果对象 |  |
| ErrorCode 错误代码 | Refer to the Error Response Codes 参考错误响应代码 | 0 |
| Timestamp 时间戳 | Action time stamp 动作时间戳 | 2023-11-24T06:32:30 |

*Result Object (Result) 结果对象（结果）*
 
| Name 名称 | Description 说明 | Values 值 |
| --- | --- | --- | 
| Usercode 用户代码 | Usercode of player 玩家的用户代码 | PCA0400012 |
| AvailableBalance 剩余可用余额 | Available balance of player after the action 动作后玩家的可用余额 | 19662.1135 |
| Actions 动作 | Action Object 动作对象 |  |

*Action Object (Actions) 动作对象（动作）*
 
| Name 名称 | Description 说明 | Values 值 |
| --- | --- | --- | 
| Id  ID| ID of the action 动作ID | 21342537 |
| TransactionId 交易ID | ID of the transaction 交易ID | 18489012 |
| WagerId 注单ID | ID of the wager 注单ID | 51307096 |
| ErrorCode 错误代码 | Refer to the Error Response Codes 参考错误响应代码 | 0 |
| ResponseCode 响应代码 | Refer to the Action Response Codes 参考动作响应代码 | 0 |
