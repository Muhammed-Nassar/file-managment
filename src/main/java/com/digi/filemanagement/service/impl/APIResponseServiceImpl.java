package com.digi.filemanagement.service.impl;

import com.digi.filemanagement.dto.common.APIResponse;
import com.digi.filemanagement.service.APIResponseService;
import org.springframework.stereotype.Service;

@Service
public class APIResponseServiceImpl implements APIResponseService {


    @Override
    public APIResponse generateServiceResponse(String statusCode, String statusMessage, Object responseData) {
        return new APIResponse(statusCode,statusMessage,responseData);
    }
}
