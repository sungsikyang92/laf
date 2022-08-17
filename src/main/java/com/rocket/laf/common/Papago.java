package com.rocket.laf.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class Papago {
    public String papagoTrans(String param){

        StringBuffer response = new StringBuffer();
        String clientId = "9uju5qlink";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "cBAe0e2BwwY6xC5QGxDmOqtzSm3zLRGvacQSCrOK";//애플리케이션 클라이언트 시크릿값";
        
        //깡통 어레이를 만든다. 텍스트만 추가하기위해
        
        //제이슨 어레이의 크기만큼 포문을 실행한다.
        
        try {
            String text = URLEncoder.encode(param, "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // post request
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
            }
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    return response.toString();
    }
}
