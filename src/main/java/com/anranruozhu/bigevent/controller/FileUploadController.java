package com.anranruozhu.bigevent.controller;

import com.anranruozhu.bigevent.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author anranruozhu
 * @ClassName FileUploadController
 *
 * @Description 文件上传的控制器
 * @create 2024/5/15 下午4:17
 **/
@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @PostMapping
    public Result<String> upload(MultipartFile file) throws IOException {
        //把文件内容存储到本地磁盘上
        String orginalFilename = file.getOriginalFilename();
        //保证文件的名字时唯一的
            String filename= UUID.randomUUID().toString()+"_"+orginalFilename.substring(orginalFilename.lastIndexOf("."));
        file.transferTo(new File("D:\\file\\"+filename));
        return Result.success("url访问地址...");
    }
}
