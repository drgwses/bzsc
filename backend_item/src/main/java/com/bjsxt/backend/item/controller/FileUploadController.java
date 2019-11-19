package com.bjsxt.backend.item.controller;

import com.bjsxt.backend.item.service.FileUploadService;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;
    @RequestMapping("/upload")
    public Result fileUpload(MultipartFile file){
         try {
             Result result = fileUploadService.fileUpload(file);
             if (result!=null){
                 return  result;
             }
         }catch (Exception e){
              e.printStackTrace();
         }
        return Result.error("error");
    }
}
