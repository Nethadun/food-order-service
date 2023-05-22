package com.microservice.foodorderservice.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url="http://localhost:8080", name = "userServiceClient")
@Headers({"Content-Type: application/json"})
public interface UserServiceClient {
//    @PostMapping("/api/user/token/ad")
//    public UserDetails generateToken(@RequestParam String userName);
}