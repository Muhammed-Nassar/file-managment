package com.digi.filemanagement.dto.folderItem;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class FolderItemRequestDTO {

    @NotBlank(message = "The item name is required.")
    private String name;
    @Email
    @NotBlank(message = "[User]  email is required.")
    private String userEmail;
    @NotNull(message = "Parent id is required.")
    private Long parentId;
    @NotNull(message = "Permission Group  id is required.")
    private Long permissionGroupId;
}
//username
//fileId