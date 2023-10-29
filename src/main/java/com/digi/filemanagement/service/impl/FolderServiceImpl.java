package com.digi.filemanagement.service.impl;

import com.digi.filemanagement.dto.folderItem.FolderItemRequestDTO;
import com.digi.filemanagement.dto.folderItem.FolderItemResponseDTO;
import com.digi.filemanagement.entity.ItemEntity;
import com.digi.filemanagement.entity.PermissionEntity;
import com.digi.filemanagement.entity.PermissionGroupEntity;
import com.digi.filemanagement.enumeration.PermissionEnum;
import com.digi.filemanagement.exception.ParentItemNotFoundException;
import com.digi.filemanagement.exception.UserNotAuthorizedException;
import com.digi.filemanagement.repository.ItemRepository;
import com.digi.filemanagement.repository.PermissionGroupRepository;
import com.digi.filemanagement.repository.PermissionRepository;
import com.digi.filemanagement.service.FolderService;
import com.digi.filemanagement.service.UserAuthorityService;
import com.digi.filemanagement.transformer.impl.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    PermissionGroupRepository permissionGroupRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private ItemTransformer itemTransformer;
    @Autowired
    private UserAuthorityService userAuthorityService;

    @Override
    public FolderItemResponseDTO createFolder(FolderItemRequestDTO folderItemRequestDTO) throws Exception {
        if (userAuthorityService.checkIfUserAuthorized(folderItemRequestDTO.getUserEmail(), PermissionEnum.EDIT, folderItemRequestDTO.getPermissionGroupId())) {
            Optional<ItemEntity> parent = itemRepository.findById(folderItemRequestDTO.getParentId());
            if (parent.isEmpty()) {
                throw new ParentItemNotFoundException("The Parent of the Item Not Found!");
            }
            ItemEntity itemEntity = itemTransformer.transformFolderItemDtoToEntity(folderItemRequestDTO);
            PermissionGroupEntity permissionGroupEntity = permissionGroupRepository.findById(folderItemRequestDTO.getPermissionGroupId()).get();
            itemEntity.setPermissionGroupEntity(permissionGroupEntity);
            itemEntity.setParentId(parent.get());
                return new FolderItemResponseDTO(itemEntity.getId(), itemEntity.getPermissionGroupEntity().getId());
        } else {
            throw new UserNotAuthorizedException("User is not authorized!");
        }
    }

}
