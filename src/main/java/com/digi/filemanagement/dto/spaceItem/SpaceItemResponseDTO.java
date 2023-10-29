package com.digi.filemanagement.dto.spaceItem;

import lombok.Data;

@Data
public class SpaceItemResponseDTO {

    private Long spaceId;
    private Long spacePermissionGroupId;


    public SpaceItemResponseDTO(Long spaceId, Long spacePermissionGroupId) {

        this.spaceId=spaceId;
        this.spacePermissionGroupId=spacePermissionGroupId;
    }
}
