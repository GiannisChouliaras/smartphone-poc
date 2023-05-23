package com.vodafone.smartphonemigrationpoc.item.service;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

public class EndpointCalls {

    private final WebClient webClient;
    private static final String CATALOG_API = "https://localhost:8442/products";

    public EndpointCalls() throws SSLException {
        this.webClient = createWebClientWithSSLConfiguration();
    }

    public void executePostRequestWithoutCategorization(String json) {
        this.webClient.post()
                .uri(CATALOG_API)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("X-Context-Request", "{\"catalogId\":\"01GEKZ5989PA5K0B2YYA4E114X\",\"tenantId\":\"5DF1363059675161A85F576D\",\"applicationId\":\"01GEKYXX9CEP821JMDZ9N117J8\"}")
                .body(BodyInserters.fromValue(json))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(responseBody -> System.out.println("Response: " + responseBody), error -> System.err.println("Request failed: " + error.getMessage()));
    }

    private WebClient createWebClientWithSSLConfiguration() throws SSLException {
        SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create()
                        .secure(t -> t.sslContext(sslContext))
                        .resolver(DefaultAddressResolverGroup.INSTANCE)))
                .build();
    }
}
