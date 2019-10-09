package com.elevenst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Created by smhong on 2019-10-06.
 */
@Service
public class ProductRemoteServiceImpl implements ProductRemoteService{

    public static final String URL = "http://localhost:8082/products/";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getProductInfoFallback")
    public String getProductInfo(String productId) {
        return restTemplate.getForObject(URL + productId, String.class);
    }

    public String getProductInfoFallback(String productId, Throwable t) {
        System.out.println("t = " + t);
        return "This Product is sold out";
    }
}
