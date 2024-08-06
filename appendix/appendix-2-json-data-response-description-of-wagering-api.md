# Appendix 2: JSON Data Response Description of Wagering API. 附录 2： 投注API JSON数据响应说明.

This section will describe the meaning of each object along with sample values.

这个章节会介绍每个对象的意思以及它们可能的值。

*Root Object*
 
| Name 名称 | Description 说明 | Values 值 |
| --- | --- | --- | 
| Result | Result Object |  |
| ErrorCode | Refer to the Error Response Codes | 0 |
| Timestamp | Action time stamp | 2023-11-24T06:32:30 |

*Result Object (Result)*
 
| Name 名称 | Description 说明 | Values 值 |
| --- | --- | --- | 
| Usercode | Usercode of player | PCA0400012 |
| AvailableBalance | Available balance of player after the action | 19662.1135 |
| Actions | Action Object |  |

*Action Object (Actions)*
 
| Name 名称 | Description 说明 | Values 值 |
| --- | --- | --- | 
| Id | ID of the action | 21342537 |
| TransactionId | ID of the transaction | 18489012 |
| WagerId | ID of the wager | 51307096 |
| ErrorCode | Refer to the Error Response Codes | 0 |
| ResponseCode | Refer to the Action Response Codes | 0 |
