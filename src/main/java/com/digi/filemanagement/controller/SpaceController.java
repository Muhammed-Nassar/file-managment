package com.digi.filemanagement.controller;

import com.digi.filemanagement.dto.common.APIResponse;
import com.digi.filemanagement.dto.spaceItem.SpaceItemRequestDTO;
import com.digi.filemanagement.service.APIResponseService;
import com.digi.filemanagement.service.SpaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items/space")
public class SpaceController {
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private APIResponseService apiResponseService;

    @PostMapping("/create")
    public ResponseEntity<?> createSpace(@Valid @RequestBody SpaceItemRequestDTO itemDTO) throws Exception {

        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.OK.toString(),
                "Space created Successfully!", spaceService.createSpace(itemDTO));
        return ResponseEntity.ok(apiResponse);

    }

}
