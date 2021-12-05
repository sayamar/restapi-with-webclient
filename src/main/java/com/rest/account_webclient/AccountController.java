package com.rest.account_webclient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@Slf4j
public class AccountController {

    private final WebClient webClient;

    @GetMapping("/api/accounts")
    public Flux<Account> getAccounts() {
        log.info("Inside getAccounts() ");
        return webClient
                .get()
                .uri("/accounts")
                .retrieve()
                .bodyToFlux(Account.class);
    }

}
