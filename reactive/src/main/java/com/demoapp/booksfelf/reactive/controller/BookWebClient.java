package com.demoapp.booksfelf.reactive.controller;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class BookWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");
    private Mono<ClientResponse> result = client.get()
            .uri("/books")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();

    public String getResult() {
        return ">> result = " + result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
