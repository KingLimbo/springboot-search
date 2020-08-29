package com.limbo.search.common;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * describe: 文件上传工具类
 * current user zhumaochao
 * current system 2019/11/8
 */
public class FileUtil {

    /**
     * 上传图片返回图片位置信息
     * @param pathName 文件保存位置文件名
     * @param file 上传的文件信息
     * @param request  请求信息
     * @param response 请求信息
     * @return   图片位置信息
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String uploadImage(String pathName, MultipartFile file,
                                     HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        //重新定义文件保存路径
        realPath = getRenamePath(realPath, request);
        // 文件保存路径
        String fileDir = "/fileData/"+pathName+"/" ;
        //文件重命名
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        suffix = suffix.trim();
        String newFileName = fileName;
        if(null!=suffix){
            newFileName = DateUtil.getStringAllDate()+"."+suffix;
        }
        //查看文件是否存在
        File destFile = new File(realPath + fileDir);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        //创建文件
        File f = new File(destFile.getAbsoluteFile() + "\\" + newFileName);
        System.out.println("##############文件存储位置："+destFile.getAbsoluteFile() + "\\" + newFileName);
        file.transferTo(f);
        f.createNewFile();
        String filePath = fileDir + newFileName;
        return filePath;
    }

    /**
     * 重新定义文件保存路径
     * @param realPath
     * @param request
     * @return
     */
    public static String getRenamePath(String realPath, HttpServletRequest request){
        //获取项目名称
        String projectName= request.getServletContext().getContextPath();
        projectName = projectName.replace("/", "");
        System.err.println("projectName="+projectName);
        System.out.println("request projectName="+request.getContextPath());
        if(StringUtil.isBlank(projectName))
        {
            projectName = "springboot-auth-up";
            realPath = realPath.replace(projectName, "");
        }else
        {
            realPath = realPath.replace(projectName, "");
        }
        return realPath;
    }


    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static void main(String[] args) {

    }

}
