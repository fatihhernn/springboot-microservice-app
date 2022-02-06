package com.fatihhernn.client;

import com.fatihhernn.client.contract.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("account-service")
public interface AccountServiceClient {

    //account-serviceden account dto yu kaldırıp buraya aldık. account ve ticket service buradaki paket dependecysini onların pom larına ekledik
    @RequestMapping("/account/{id}")
    ResponseEntity<AccountDto> get(@PathVariable("id") String id);
}
