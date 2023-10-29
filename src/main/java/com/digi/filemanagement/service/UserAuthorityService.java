package com.digi.filemanagement.service;

import com.digi.filemanagement.enumeration.PermissionEnum;

public interface UserAuthorityService {



    public boolean checkIfUserAuthorized(String userName, PermissionEnum permissionEnum, Long permissionGroupId) throws Exception;

}


