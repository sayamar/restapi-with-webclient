package com.rest.account_webclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
@ConfigurationProperties("account")
public class WebClientConfig {

    private String host;
    private int port;
    private Long globalTimeout;
    private Long requestTimeout;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://localhost:9001")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

//    @Bean
//    public WebClient webClient() {
//
//        ClientHttpConnector connector = new ReactorClientHttpConnector(
//                HttpClient
//                        .create()
//                        .responseTimeout(Duration.ofMillis(globalTimeout))
//                        .doOnRequest((req, conn) -> {
//                            log.debug("webClient - {}", req);
//                            req.responseTimeout(Duration.ofMillis(requestTimeout));
//                        })
//        );
//        return WebClient.builder()
//                .baseUrl("http://" + host + ":" + port)
//                .clientConnector(connector)
//                .build();
//
//    }


}
