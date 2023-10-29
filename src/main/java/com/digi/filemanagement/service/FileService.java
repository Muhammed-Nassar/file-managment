package com.digi.filemanagement.service;

import com.digi.filemanagement.dto.common.ItemDTO;
import com.digi.filemanagement.dto.fileItem.FileItemRequestDTO;
import com.digi.filemanagement.dto.fileItem.FileItemResponseDTO;

public interface FileService {
    public FileItemResponseDTO createFile(FileItemRequestDTO itemDTO) throws Exception;

    public ItemDTO getItemById(Long itemId)throws Exception ;
}


