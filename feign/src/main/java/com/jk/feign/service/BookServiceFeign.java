package com.jk.feign.service;

import com.jk.service.BookService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "springcloud-provider",fallback = BookServiceFallBack.class)
public interface BookServiceFeign extends BookService {

}
