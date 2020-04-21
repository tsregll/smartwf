package com.smartwf.sm.modules.admin.controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartwf.common.pojo.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

/**
 * @Date: 2020-4-21 11:46:56
 * @Description: 文件上传控制器
 */
@RestController
@RequestMapping("file")
@Slf4j
@Api(description = "文件上传控制器")
public class FileUploadController {
	
	@Value("${web.upload-path}")
	private String localFilePath;  //获取上传地址
	
	
	/**
	 * 功能说明：图片上传
	 * @author WCH
	 * @dateTime 2020-4-21 14:09:52
	 * */
	@PostMapping(value = "/upload", consumes = "multipart/*", headers = "content-type=multipart/form-data")
	@ApiOperation(value = "上传图片接口", notes = "上传图片")
	public ResponseEntity<Result<?>> upload(@ApiParam(value = "用户图片", required = true) MultipartFile file) {
	    if (!file.isEmpty()) {
	        if (file.getContentType().contains("image")) {
	        	StringBuffer sb=null;
	            try {
	                String temp = "images" + File.separator ;
	                // 获取图片的文件名
	                String fileName = file.getOriginalFilename();
	                // 获取图片的扩展名
	                String extensionName = fileName.substring(fileName.indexOf("."));
	                // 新的图片文件名 = 获取时间戳+"."图片扩展名
	                String newFileName = String.valueOf(System.currentTimeMillis())  + extensionName;
	                // 数据库保存的目录
	                String datdDirectory = temp.concat(newFileName);
	                // 文件路径
	                String filePath = localFilePath+File.separator+temp;
	                File dest = new File(filePath, newFileName);
	                if (!dest.getParentFile().exists()) {
	                    dest.getParentFile().mkdirs();
	                }
	                // 上传到指定目录
	                file.transferTo(dest);
	                return ResponseEntity.status(HttpStatus.OK).body(Result.msg(datdDirectory));
	            }catch (Exception e){
	            	log.error("文件上传异常！{}", e.getMessage(), e);
	            	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.msg("失败！上传异常"));
	            }
	        }
	    }
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.msg("失败！请检查上传的文件"));
	}
	
	/**
	 * 功能说明：文件上传
	 * @author WCH
	 * @dateTime 2020-4-21 14:09:52
	 * */
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
	    File targetFile = new File(filePath);
	    //PrintUtil.println("filePath="+filePath);
	    if(!targetFile.exists()){
	        targetFile.mkdirs();
	    }
	    FileOutputStream out = new FileOutputStream(filePath+fileName);
	    out.write(file);
	    out.flush();
	    out.close();
	}

	
}