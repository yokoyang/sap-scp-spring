package com.example.demo.web.Utils;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientResponseException;

import javax.security.sasl.AuthenticationException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MyResponseErrorHandler extends DefaultResponseErrorHandler {
    private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        // your error handling here

        String theString = IOUtils.toString(response.getBody(), "UTF-8");
        CustomException exception = new CustomException("login");
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("code", response.getStatusCode().toString());
        properties.put("body", theString);
        properties.put("header", response.getHeaders());
        exception.setProperties(properties);
        try {
            throw exception;
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return errorHandler.hasError(response);

    }
}
