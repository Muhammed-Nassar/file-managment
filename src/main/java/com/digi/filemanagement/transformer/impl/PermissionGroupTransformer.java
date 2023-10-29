package com.digi.filemanagement.transformer.impl;

import com.digi.filemanagement.dto.common.PermissionDTO;
import com.digi.filemanagement.dto.common.PermissionGroupDTO;
import com.digi.filemanagement.entity.PermissionEntity;
import com.digi.filemanagement.entity.PermissionGroupEntity;
import com.digi.filemanagement.transformer.Transformer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionGroupTransformer implements Transformer<PermissionGroupEntity, PermissionGroupDTO> {

    @Override
    public PermissionGroupEntity transformDtoToEntity(PermissionGroupDTO groupDTO) {
       List<PermissionEntity> permissions= groupDTO.
                getPermissions().stream().map(PermissionEntity::new).toList();
        return PermissionGroupEntity.builder()
                .groupName(groupDTO.getGroupName())
                .permissions(permissions)
                .build();
    }

    @Override
    public PermissionGroupDTO transformEntityToDto(PermissionGroupEntity entity) {
        return null;
    }

}
