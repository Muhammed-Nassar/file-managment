package com.digi.filemanagement.dto.spaceItem;

import com.digi.filemanagement.dto.common.PermissionGroupDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class SpaceItemRequestDTO {

    @NotBlank(message = "The item name is required.")
    private String name;
    @NotNull(message = "The permission group is required.")
    private PermissionGroupDTO permissionGroup;
}
