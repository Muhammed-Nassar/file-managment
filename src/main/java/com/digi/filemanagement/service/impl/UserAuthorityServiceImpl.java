package com.digi.filemanagement.service.impl;

import com.digi.filemanagement.entity.PermissionEntity;
import com.digi.filemanagement.enumeration.PermissionEnum;
import com.digi.filemanagement.repository.PermissionRepository;
import com.digi.filemanagement.service.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService {

    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    public boolean checkIfUserAuthorized(String userName, PermissionEnum permissionEnum,Long permissionGroupId) throws Exception {
       Optional<PermissionEntity> permissionEntity=permissionRepository.findByUserEmailAndPermissionLevel(userName,permissionEnum.getValue());
        return permissionEntity.isPresent();
    }
}

