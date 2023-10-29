package com.digi.filemanagement.service;

import com.digi.filemanagement.dto.folderItem.FolderItemRequestDTO;
import com.digi.filemanagement.dto.folderItem.FolderItemResponseDTO;

public interface FolderService {



    public FolderItemResponseDTO createFolder(FolderItemRequestDTO itemDTO) throws Exception;

}


