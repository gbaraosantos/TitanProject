package com.baronhub.titan.project.components.controllers.homepage;

import com.baronhub.titan.project.components.services.file.system.GceFileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Homepage Controller
 */

@Controller
public class Homepage {
    @Autowired private GceFileSystemService fileSystemService;

    /**
     * Handles a fileUpload
     * @param file Gets file from Upload
     */
    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    void upload(@RequestParam("testFile") MultipartFile file){

    }

}
