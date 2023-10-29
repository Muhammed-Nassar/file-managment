package com.digi.filemanagement.service.impl;

import com.digi.filemanagement.dto.common.ItemDTO;
import com.digi.filemanagement.dto.fileItem.FileItemRequestDTO;
import com.digi.filemanagement.dto.fileItem.FileItemResponseDTO;
import com.digi.filemanagement.entity.ItemEntity;
import com.digi.filemanagement.entity.PermissionEntity;
import com.digi.filemanagement.enumeration.PermissionEnum;
import com.digi.filemanagement.exception.UserNotAuthorizedException;
import com.digi.filemanagement.repository.FileRepository;
import com.digi.filemanagement.repository.ItemRepository;
import com.digi.filemanagement.repository.PermissionRepository;
import com.digi.filemanagement.service.FileService;
import com.digi.filemanagement.transformer.impl.ItemTransformer;
import com.digi.filemanagement.util.DataParser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    @Autowired

    private ItemRepository itemRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private ItemTransformer itemTransformer;
    @Autowired
    private EntityManager entityManager;
    @Override
    public FileItemResponseDTO createFile(FileItemRequestDTO fileItemRequestDTO) {
        Optional<PermissionEntity> permissionEntity = permissionRepository.findByUserEmailAndPermissionLevel(fileItemRequestDTO.getUserEmail(), PermissionEnum.EDIT.getValue());
        if (permissionEntity.isPresent()) {
            ItemEntity itemEntity = itemTransformer.transformFileItemDtoToEntity(fileItemRequestDTO);
            ItemEntity save = itemRepository.save(itemEntity);
            fileRepository.saveFile(DataParser.convertBase64ToBytes(fileItemRequestDTO.getFileContent()), save.getId());
            return new FileItemResponseDTO("File ID !!!!");

        } else {
            throw new UserNotAuthorizedException("User is not authorized!");
        }
    }

    @Override
    public ItemDTO getItemById(Long itemId) {
        return null;
    }


//
private void saveFileNative(byte[] fileData, Long itemId) {
    try {
        String sql = "INSERT INTO file (content, item_id) VALUES (?, ?)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, fileData);
        query.setParameter(2, itemId);
        query.executeUpdate();
    } catch (Exception e) {
        // Handle exceptions
    }}
 }
