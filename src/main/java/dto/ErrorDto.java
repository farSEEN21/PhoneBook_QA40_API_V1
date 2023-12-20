package dto;

import lombok.Value;

@Value
public class ErrorDto {

//     "timestamp": "2023-12-18T17:15:01.548Z",
//             "status": 0,
//             "error": "string",
//             "message": {},
//            "path": "string"

    String path;
    Object message;
    String erroe;
    int status;
    String timestamp;


}
