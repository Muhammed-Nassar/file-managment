package com.digi.filemanagement.dto.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class APIResponse {
    private LocalDateTime dateTime;
    private String statusCode;
    private String statusMessage;
    private Object responseData;

    public APIResponse(String statusCode, String statusMessage,Object responseData) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.responseData=responseData;
        this.dateTime=LocalDateTime.now();
    }
}
