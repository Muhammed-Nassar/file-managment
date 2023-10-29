package com.digi.filemanagement.service;

import com.digi.filemanagement.dto.spaceItem.SpaceItemRequestDTO;
import com.digi.filemanagement.dto.spaceItem.SpaceItemResponseDTO;

public interface SpaceService {

    public SpaceItemResponseDTO createSpace(SpaceItemRequestDTO itemDTO) throws Exception ;

}


