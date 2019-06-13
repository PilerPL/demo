package com.example.controller;


import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class TestUtil {

    public static final String URL_STR = "http://papyrix.cnki.net/api/subject/export.action?token=53FBC7C59F0B847771D821D2A5DB1953&file=bd1e7884-834c-11e9-82f9-005056aa14d2";

    public static void main(String[] args){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String filename = "D://temp/test.json";
        download(URL_STR, filename);
        stopWatch.stop();
        long time = stopWatch.getTime();

        System.err.println(time);
    }

    public static final int cache = 10 * 1024;

    public static String download(String url, String filepath) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = client.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            File file = new File(filepath);
            file.getParentFile().mkdirs();
            FileOutputStream fileout = new FileOutputStream(file);
            byte[] buffer=new byte[cache];
            int ch = 0;
            while ((ch = is.read(buffer)) != -1) {
                fileout.write(buffer,0,ch);
            }
            is.close();
            fileout.flush();
            fileout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}