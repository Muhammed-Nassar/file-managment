package com.digi.filemanagement.controller;

import com.digi.filemanagement.dto.common.APIResponse;
import com.digi.filemanagement.dto.fileItem.FileItemRequestDTO;
import com.digi.filemanagement.service.APIResponseService;
import com.digi.filemanagement.service.FileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    APIResponseService apiResponseService;

    @PostMapping("/create")
    public ResponseEntity<?> createFile(@Valid @RequestBody FileItemRequestDTO itemDTO) throws Exception {

        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.OK.toString(),
                "File created Successfully!",
                 fileService.createFile(itemDTO));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/viewMetadata")
    public ResponseEntity<?> viewFileMetadata(@RequestParam Long itemId) {
        return ResponseEntity.ok("File metadata.");
    }
}



