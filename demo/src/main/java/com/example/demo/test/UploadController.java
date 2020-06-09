package com.example.demo.test;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;



/**
 * @author zw
 */
@Controller
public class UploadController {

	@RequestMapping("/tt")
	@ResponseBody
	public String tt(HttpServletRequest request) {
		return "11111111111";
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletRequest request) {
		try {
			String bmsah = "ArteryBase5.0.0安装指南";
			String url = "http://127.0.0.1:8080/demo/revFile";
			String pdfPath = "D:\\work_document\\ArteryBase5.0.0安装指南.pdf";
			sendPdf(url, pdfPath, bmsah);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "33333333333333";
	}


	public  void sendPdf(String uri,String filePath,String fileName){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(uri);
            File file = new File(filePath);
            FileBody bin = new FileBody(file);
            //String base = pdfToBase64(file);
            //StringBody fileNameBody = new StringBody(URLEncoder.encode(fileName+".pdf", "UTF-8"), ContentType.APPLICATION_JSON);
			//StringBody uploadFileName =new StringBody(
			//		fileName+".pdf", ContentType.create(
			//				"text/plain", "UTF-8"));
			//BROWSER_COMPATIBLE自定义charset，RFC6532=utf-8，STRICT=iso-8859-1
			//此处一定要用RFC6532，网上普遍用的BROWSER_COMPATIBLE依然会出现中文名乱码 HttpMultipartMode.RFC6532
			//multipartEntityBuilder.setCharset(Charset.forName("UTF-8")); //此处踩坑，转发出去的filename依然为乱码
			//ContentType contentType = ContentType.create("multipart/form-data",Charset.forName("UTF-8"));
			// 此处也是坑，转发出去的filename依然为乱码

					HttpEntity reqEntity = MultipartEntityBuilder.create()
					.setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
            		.setCharset(Charset.forName("UTF-8"))
            		.addPart("file", bin)
					//.addPart("fileName", uploadFileName)
                    //.addTextBody("fileName", fileName+".pdf",ContentType.APPLICATION_JSON)
                    .build();
             
            httppost.setEntity(reqEntity);
            //httppost.addHeader("Content-type","application/json; charset=utf-8");
            
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
            try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }


	@RequestMapping("/revFile")
	@ResponseBody
	public Map<String, Object> scanningUpload(MultipartHttpServletRequest request){
	    Map<String, Object> result = new HashMap<String, Object>();
        Date date = new Date();
        String fileName = null;
        String content = null;
	    request.getSession().setMaxInactiveInterval(60);
	    Iterator<String> iter = request.getFileNames();
	    String caseNumber = null;
	    try {
	        while (iter.hasNext()) {
	            MultipartFile multipartFile = request.getFile(iter.next());
	            fileName = multipartFile.getOriginalFilename();
				System.out.println("--------fileName--------->>"+fileName);
			}
	        
	    }catch (Exception e) {
            result.put("code", 400);
            result.put("msg", "未知错误！");
            return result;
        }
	    result.put("code", 200);
        result.put("msg", "OK");
        return result;
	}
	
}
