package com.baizhi.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 用来测试文件上传下载
 */
@Controller
@RequestMapping("file")
public class FileController {




    //用来处理文件下载 请求对应响应输出流
    @RequestMapping("download")
    public void download(String openStyle,String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {

        openStyle = openStyle==null?"inline":"attachment";

        System.out.println("下载文件的名称: "+fileName);
        //1.根据下载相对目录获取下载目录在服务器部署之后绝对目录
        String realPath = request.getSession().getServletContext().getRealPath("/down");
        //2.通过文件输入流读取文件
        FileInputStream is = new FileInputStream(new File(realPath, fileName));
        //3.获取响应输出流
        response.setContentType("text/plain;charset=UTF-8");
        //4.附件下载attachment 附件  inline 在线打开
        response.setHeader("content-disposition",openStyle+";fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        ServletOutputStream os = response.getOutputStream();


        //5.处理下载流复制 //操作io流用IOUtils  操作file 用 FileUtils
        IOUtils.copy(is,os);
        IOUtils.closeQuietly(is);//优雅关闭 安静关流
        IOUtils.closeQuietly(os);//优雅关闭 安静关流

        //传统写法
        //aa.txt 1033-1024 = 9
//        int len;
//        byte[] b = new byte[1024];
//        while(true){
//            len = is.read(b);
//            if(len==-1)break;
//            os.write(b,0,len);
//        }
//        //释放资源
//        is.close();
//        os.close();
    }


    //用来处理文件上传
    @RequestMapping("upload")
    public String upload(MultipartFile img, HttpServletRequest request) throws IOException {
        System.out.println("文件名: "+img.getOriginalFilename());
        System.out.println("文件大小: "+img.getSize());
        System.out.println("文件类型: "+img.getContentType());
        //文件上传
        //1.根据upload相对路径获取部署到服务之后绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        //2.修改文件原始名称
        String extension = FilenameUtils.getExtension(img.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString().replace("-","")+"."+extension;

        //3.生成当天日期目录
        LocalDate now = LocalDate.now();
        File dateDir = new File(realPath, now.toString());
        if(!dateDir.exists()) dateDir.mkdirs();

        //4.将文件上传到upload对应日期的目录中
        img.transferTo(new File(dateDir,newFileName));
        return "index";
    }
}
