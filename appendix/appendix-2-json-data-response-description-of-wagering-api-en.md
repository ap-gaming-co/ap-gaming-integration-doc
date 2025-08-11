# Appendix 2: JSON Data Response Description of Wagering API. 

This section will describe the meaning of each object along with sample values.

*Root Object*
 
| Name | Description  | Values |
| --- | --- | --- | 
| Result | Result Object |  |
| ErrorCode | Refer to the Error Response Codes | 0 |
| Timestamp | Action time stamp | 2023-11-24T06:32:30 |

*Result Object (Result)*
 
| Name | Description | Values |
| --- | --- | --- | 
| Usercode | Usercode of player | PCA0400012 |
| AvailableBalance | Available balance of player after the action | 19662.1135 |
| Actions | Action Object |  |

*Action Object (Actions)*
 
| Name  | Description  | Values  |
| --- | --- | --- | 
| Id  ID| ID of the action | 21342537 |
| TransactionId | ID of the transaction | 18489012 |
| WagerId | ID of the wager | 51307096 |
| ErrorCode | Refer to the Error Response Codes | 0 |
| ResponseCode | Refer to the Action Response Codes | 0 |
