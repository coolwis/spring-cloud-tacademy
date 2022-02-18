package com.elevenst.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product", fallbackFactory = FeignProductRemoteServiceFallbackFactory.class) //name=product -> eureka에 등록된 서버 이름
//@FeignClient(name = "product", url="http://localhost:8082/")  //url 지정시 eureka를 사용하지 않고 호출됨.
public interface FeignProductRemoteService {
    @RequestMapping(path = "/products/{productId}")
    String getProductInfo(@PathVariable("productId") String productId);
}