package com.zabbix.sisyphus.base.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zabbix.sisyphus.base.common.ImageSize;
import com.zabbix.sisyphus.vo.UploadResult;

/**
 * 作者: zabbix 创建于 16/10/18.
 */
@Controller
@RequestMapping("file")
public class FileUploadController {

    private static final String tempDic = "/attached/";

    @RequestMapping("upload")
    @ResponseBody
    public UploadResult upload(@RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request) throws IOException {
        UploadResult uploadResult = new UploadResult();

//        ImageSize imageSize = imageSize(file.getInputStream());
//        if (imageSize == null) {
//            uploadResult.setError(1);
//            uploadResult.setMessage("上传的文件格式错误!");
//            return  uploadResult;
//        }

//        int w =220;
//        int h = 145;
//        if (imageSize.getWidth()!=w||imageSize.getHeight()!=h){
//            uploadResult.setError(1);
//            uploadResult.setMessage("上传图片宽度或者高度错误!");
//            return  uploadResult;
//        }

        String savePath = request.getServletContext().getRealPath("/") + tempDic;
        //String fileName = String.format("%s.%s", System.currentTimeMillis(), StringUtils.substringAfterLast(file.getOriginalFilename(), "."));
        String fileName = file.getOriginalFilename();
        //创建日期路径
        DateTime now = new DateTime();
        String path = String.format("%d/%d/%d/", now.getYear(), now.getMonthOfYear(), now.getDayOfMonth());
        try {
            FileUtils.writeByteArrayToFile(new File(savePath + path + fileName), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            uploadResult.setError(1);
            return uploadResult;
        }

        uploadResult.setUrl(String.format("%s%s%s", tempDic, path, fileName));
        uploadResult.setError(0);
        return uploadResult;
    }


    public ImageSize imageSize(InputStream inputStream) {
        try {
            BufferedImage bufImg = ImageIO.read(inputStream);
            return new ImageSize(bufImg.getWidth(), bufImg.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
