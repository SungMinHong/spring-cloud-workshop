package com.elevenst.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by smhong on 2019-10-10.
 */
//@FeignClient(name = "product", url = "http://localhost:8082/")
@FeignClient(name = "product")  //url이 없으면 feign 클라이언트는 내부적으로 리본을 사용하고 유레카를 통해 url을 찾게된다. 유레카에 등록된 이름이 product인 서비스를 찾는다.
public interface FeignProductRemoteService {
    @RequestMapping("/products/{productId}")
    String getProductInfo(@PathVariable("productId") String productId);
}
