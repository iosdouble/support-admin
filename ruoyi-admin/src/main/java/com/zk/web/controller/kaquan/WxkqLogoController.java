package com.zk.web.controller.kaquan;

import com.zk.common.constant.WXUrlConstants;
import com.zk.common.core.domain.AjaxResult;
import com.zk.common.core.page.TableDataInfo;
import com.zk.common.utils.json.JsonUtil;
import com.zk.system.domain.weixin.accesstoken.AccessToken;
import com.zk.system.domain.weixin.accesstoken.WeixinGetToken;
import com.zk.system.domain.weixin.domain.resp.LogoUrlSuccessResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Classname WxkqLogoController
 * @Description TODO 微信卡券Logo上传接口
 * @Date 2020/8/18 10:25 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqLogoController @see ruoyi
 */
@RestController
@RequestMapping("/logo")
public class WxkqLogoController {

    private Logger logger = LoggerFactory.getLogger(WxkqLogoController.class);


    @Autowired
    private WeixinGetToken weixinGetToken;

    @PostMapping(value = "/upload")
    public AjaxResult upload(@RequestParam(value = "file") MultipartFile file) {

        AccessToken accessToken = weixinGetToken.getToken();

        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();

        //获取到文件名并且存库
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        String newFileName = fileName;
        String path = "/Users/nihui/Documents/IDEAProject/Git/RuoYi/log/";
        File newFile = new File(path+newFileName);

        try {
            file.transferTo(newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //图片路径
        String filepath = newFile.getAbsolutePath();
        System.out.println("这里没有执行");
        System.out.println(filepath);
        //把自己的access_token放在等号后面
        String urlStr = WXUrlConstants.UPLOAD_IMAGE+"?access_token="+accessToken.getAccess_token();

        Map<String, String> textMap = new HashMap<String, String>();
        textMap.put("name", "testname");
        Map<String, String> fileMap = new HashMap<String, String>();
        fileMap.put("userfile", filepath);
        String ret = formUpload(urlStr, textMap, fileMap);
        System.out.println(ret);
        LogoUrlSuccessResp logoUrlSuccessResp = JsonUtil.toObject(ret,LogoUrlSuccessResp.class);

        return AjaxResult.success("OK");
    }


    @GetMapping("/list")
    public TableDataInfo findLogoUrlList(){
        return null;
    }



    /**
     * 上传图片
     */
    private  String formUpload(String urlStr, Map<String, String> textMap, Map<String, String> fileMap) {
        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }
            // file
            if (fileMap != null) {
                Iterator iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();
                    String contentType = new MimetypesFileTypeMap().getContentType(file);
                    if (filename.endsWith(".png")) {
                        contentType = "image/png";
                    }
                    if (contentType == null || contentType.equals("")) {
                        contentType = "application/octet-stream";
                    }
                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename
                            + "\"\r\n");
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
                    out.write(strBuf.toString().getBytes());
                    DataInputStream in = new DataInputStream(new FileInputStream(file));
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
            }
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();
            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }
}
