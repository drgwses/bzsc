package com.bjsxt.backend.item.service.impl;

import com.bjsxt.backend.item.service.FileUploadService;
import com.bjsxt.utils.FtpUtil;
import com.bjsxt.utils.IDUtils;
import com.bjsxt.utils.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Value("${FTP_HOST}")
    private String FTP_HOST="192.168.163.130";
    @Value("${FTP_PORT}")
    private int FTP_PORT=21;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME="ftpuser";
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD="ftpuser";
    @Value("${FTP_BASEPATH}")
    private String FTP_BASEPATH="/home/ftpuser" ;
    @Override
    public Result fileUpload(MultipartFile file){
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("/yyyy/MM/dd");
            String path = fmt.format(new Date());
            String newName = IDUtils.genImageName() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            FtpUtil.uploadFile(this.FTP_HOST,FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, path, newName, file.getInputStream());
            String imgUrl="http://"+FTP_HOST+path+newName;
            return Result.ok(imgUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
