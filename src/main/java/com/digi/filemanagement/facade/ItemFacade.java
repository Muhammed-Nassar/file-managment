package com.digi.filemanagement.facade;

import com.digi.filemanagement.service.FileService;
import com.digi.filemanagement.service.FolderService;
import com.digi.filemanagement.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemFacade {
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private FolderService folderService;
    @Autowired
    private FileService fileService;

   //Delegate Methods

}
