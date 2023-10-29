package com.digi.filemanagement.dto.folderItem;

import lombok.Data;

@Data
public class FolderItemResponseDTO {

    private Long folderId;
    private Long folderPermissionGroupId;


    public FolderItemResponseDTO(Long folderId, Long folderPermissionGroupId) {

        this.folderId=folderId;
        this.folderPermissionGroupId=folderPermissionGroupId;
    }
}
