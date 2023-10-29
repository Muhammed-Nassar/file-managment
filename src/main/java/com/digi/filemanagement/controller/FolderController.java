package com.digi.filemanagement.controller;

import com.digi.filemanagement.dto.common.APIResponse;
import com.digi.filemanagement.dto.folderItem.FolderItemRequestDTO;
import com.digi.filemanagement.service.APIResponseService;
import com.digi.filemanagement.service.FolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items/folder")
public class FolderController {
    @Autowired
    private FolderService folderService;
    @Autowired
    private APIResponseService apiResponseService;

    @PostMapping("/create")
    public ResponseEntity<?> createFolder(@Valid @RequestBody FolderItemRequestDTO folderItemRequestDTO) throws Exception {
        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.OK.toString(),
                "Folder created Successfully!",
                folderService.createFolder(folderItemRequestDTO));
        return ResponseEntity.ok(apiResponse);
    }

}
