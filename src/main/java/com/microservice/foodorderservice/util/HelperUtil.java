package com.microservice.foodorderservice.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
@Slf4j
@Component
public class HelperUtil {
//    public UserDetails apiRequestGET(String url) {
//
//        RestTemplate restTemplate = new RestTemplate();
//
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            try {
//                HttpEntity<String> entity = new HttpEntity<>(headers);
//                ResponseEntity<UserDetails> exchange = restTemplate.exchange("http://localhost:8080/api/user/token/ad/"+url, HttpMethod.GET, entity, UserDetails.class);
//                UserDetails body = exchange.getBody();
//                return body;
//            } catch(Exception e) {
//                log.info("API_CALL_UNSUCCESSFUL");
//            }
//
//        return null;
//    }
}
