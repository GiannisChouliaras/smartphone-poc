package com.vodafone.smartphonemigrationpoc.item.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.GuidedSaleDTO;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.ProductItemDTO;
import com.vodafone.smartphonemigrationpoc.item.modelBLF.ProductItem;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import io.netty.resolver.DefaultAddressResolverGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {

    private static final String DATA = "/home/theofanis/Documents/smartphone-poc/data/items.json";
    private static final String CATALOG_API = "https://localhost:8442/products";

    public String getItems() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        GuidedSaleDTO guidedSaleDTO = objectMapper.readValue(new File(DATA), GuidedSaleDTO.class);
        ProductItemDTO productsItemDTO = convert(guidedSaleDTO);
        HashMap<String, ArrayList<ProductItem>> productsMap = categorizeProducts(productsItemDTO);
//        WebClient webClient = createWebClientWithSSLConfiguration();
//        for (ProductItem item : productsItemDTO.getProducts()) {
//            String jsonBody = objectMapper.writeValueAsString(item);
//            createAndExecutePostRequest(jsonBody,webClient);
//        }
        return "Successfully Created and POSTED " + productsItemDTO.getProducts().size() + " Products on Broadleaf";
    }

    private void createAndExecutePostRequest(String json,WebClient webClient) throws SSLException {
        executePostRequest(json, webClient);
    }

    private void executePostRequest(String json, WebClient webClient) {
        webClient.post()
                .uri(CATALOG_API)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header("X-Context-Request", "{\"catalogId\":\"01GEKZ5989PA5K0B2YYA4E114X\",\"tenantId\":\"5DF1363059675161A85F576D\",\"applicationId\":\"01GEKYXX9CEP821JMDZ9N117J8\"}")
                .body(BodyInserters.fromValue(json))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(responseBody -> {
                    System.out.println("Response: " + responseBody);
                }, error -> {
                    System.err.println("Request failed: " + error.getMessage());
                });
    }

    private WebClient createWebClientWithSSLConfiguration() throws SSLException {
        SslContext sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create()
                        .secure(t -> t.sslContext(sslContext))
                        .resolver(DefaultAddressResolverGroup.INSTANCE)))
                .build();
    }

    private ProductItemDTO convert(GuidedSaleDTO guidedSaleDTO) {
        ProductItemDTO productItemDTO = new ProductItemDTO();
        productItemDTO.convert(guidedSaleDTO);
        return productItemDTO;
    }

    private HashMap<String, ArrayList<ProductItem>> categorizeProducts(ProductItemDTO productsItemDTO){
        HashMap<String,ArrayList<ProductItem>> hashMap = new HashMap<>();
        for(ProductItem item: productsItemDTO.getProducts()){
            if(hashMap.containsKey(item.getName())){
                hashMap.get(item.getName()).add(item);
            }
            else{
                hashMap.put(item.getName(),new ArrayList<ProductItem>());
                hashMap.get(item.getName()).add(item);
            }
        }
        return hashMap;
    }
}