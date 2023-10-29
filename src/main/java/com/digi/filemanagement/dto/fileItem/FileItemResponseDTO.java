package com.digi.filemanagement.dto.fileItem;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileItemResponseDTO {
    private String fileId;

    public FileItemResponseDTO(String fileId) {
        this.fileId = fileId;
    }
}
