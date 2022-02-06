package com.fatihhernn.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients //tek bir yerden kullanılmasın söyledik ve aktif hale getirdik
public class FeignConfig {
}
