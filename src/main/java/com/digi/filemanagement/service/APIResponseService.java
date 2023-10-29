package com.digi.filemanagement.service;

import com.digi.filemanagement.dto.common.APIResponse;

public interface APIResponseService {

    public APIResponse generateServiceResponse(String statusCode, String statusMessage,Object responseData)  ;

}


