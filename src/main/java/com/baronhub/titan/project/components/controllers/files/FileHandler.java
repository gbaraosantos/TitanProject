package com.baronhub.titan.project.components.controllers.files;

import com.baronhub.titan.project.components.services.operation.file.system.gce.GceFileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller that handles file operations
 */

@Controller
public class FileHandler {

    @Autowired
    private GceFileSystemService fileSystemService;

    @RequestMapping(value = "/getSource" , method = RequestMethod.GET)
    String upload(HttpServletResponse response) throws IOException {
        String a  = fileSystemService.getObject("titan-bucket" , "2000px-Tomcat-logo.svg.png");
        System.out.println(a);
        return a;
    }


    /**
     *
     */
    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    void upload(@RequestParam("testFile")MultipartFile file) throws IOException {
        fileSystemService.addObject("titan-bucket" , "teste.png",file);
    }
}
