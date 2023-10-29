package com.digi.filemanagement.service.impl;

import com.digi.filemanagement.dto.spaceItem.SpaceItemRequestDTO;
import com.digi.filemanagement.dto.spaceItem.SpaceItemResponseDTO;
import com.digi.filemanagement.entity.ItemEntity;
import com.digi.filemanagement.repository.ItemRepository;
import com.digi.filemanagement.service.SpaceService;
import com.digi.filemanagement.transformer.impl.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemTransformer itemTransformer;


    @Override
    public SpaceItemResponseDTO createSpace(SpaceItemRequestDTO spaceItemRequestDTO) {
        ItemEntity spaceEntity = itemRepository.save(itemTransformer.transformSpaceItemDtoToEntityWithPermissions(spaceItemRequestDTO));
        return new SpaceItemResponseDTO(spaceEntity.getId(), spaceEntity.getPermissionGroupEntity().getId());
    }


}

