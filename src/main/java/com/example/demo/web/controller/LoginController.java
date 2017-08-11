package com.example.demo.web.controller;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.example.demo.web.Utils.SSLUtil;
import com.example.demo.web.model.LoginInputViewModel;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@RestController
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public String login(@RequestBody LoginInputViewModel loginInput) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {

        final String url = "https://10.58.106.72:50000/b1s/v1/Login";
        SSLUtil.turnOffSslChecking();
        RestTemplate restTemplate = new RestTemplate();
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        MultiValueMap<String, String> requestHeaders = new LinkedMultiValueMap<String, String>();
        requestHeaders.add("Content-Type", "application/json");

        HttpEntity<LoginInputViewModel> request = new HttpEntity<LoginInputViewModel>(loginInput, requestHeaders);
        return restTemplate.postForObject(url, request, String.class);

    }
}
