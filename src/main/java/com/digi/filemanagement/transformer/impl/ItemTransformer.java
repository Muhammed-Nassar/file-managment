package com.digi.filemanagement.transformer.impl;

import com.digi.filemanagement.dto.common.ItemDTO;
import com.digi.filemanagement.dto.fileItem.FileItemRequestDTO;
import com.digi.filemanagement.dto.folderItem.FolderItemRequestDTO;
import com.digi.filemanagement.dto.spaceItem.SpaceItemRequestDTO;
import com.digi.filemanagement.entity.ItemEntity;
import com.digi.filemanagement.entity.PermissionEntity;
import com.digi.filemanagement.entity.PermissionGroupEntity;
import com.digi.filemanagement.enumeration.ItemTypeEnum;
import com.digi.filemanagement.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemTransformer implements Transformer<ItemEntity, ItemDTO> {

    @Autowired
    private PermissionGroupTransformer permissionGroupTransformer;

    @Override
    public ItemEntity transformDtoToEntity(ItemDTO itemDTO) {
        return ItemEntity.builder()
                .name(itemDTO.getType())
                .type(ItemTypeEnum.fromId(itemDTO.getType()))
                .build();
    }

    @Override
    public ItemDTO transformEntityToDto(ItemEntity entity) {
        return null;
    }


    public ItemEntity transformSpaceItemDtoToEntityWithPermissions(SpaceItemRequestDTO spaceItemRequestDTO) {
//
        return ItemEntity.builder()
                .name(spaceItemRequestDTO.getName())
                .type(ItemTypeEnum.SPACE).
                permissionGroupEntity(permissionGroupTransformer.transformDtoToEntity(spaceItemRequestDTO.getPermissionGroup()))
                .build();

    }

    public ItemEntity transformFolderItemDtoToEntity(FolderItemRequestDTO itemDTO) {
        return ItemEntity.builder()
                .name(itemDTO.getName())
                .type(ItemTypeEnum.FOLDER)
                .build();
    }

    public ItemEntity transformFileItemDtoToEntity(FileItemRequestDTO fileItemRequestDTO) {
        return ItemEntity.builder()
                .name(fileItemRequestDTO.getType())
                .type(ItemTypeEnum.FILE)
//                .parentId(fileItemRequestDTO.getParentId())
                .build();
    }
}
