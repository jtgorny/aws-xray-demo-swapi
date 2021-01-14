package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DemoController {

    private final WebClient webClient;

@GetMapping("/demo")
    public Mono<String> demo () {
        log.info("Inside demo method");
        return webClient.get().uri("https://swapi.dev/api/starships/9/").retrieve().bodyToMono(String.class);
    }
}
