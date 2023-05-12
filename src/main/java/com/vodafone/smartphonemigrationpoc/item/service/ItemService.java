package com.vodafone.smartphonemigrationpoc.item.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.GuidedSaleDTO;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.ProductItemDTO;
import com.vodafone.smartphonemigrationpoc.item.modelBLF.ProductItem;
import com.vodafone.smartphonemigrationpoc.item.modelBLF.ReviewsSummary;
import com.vodafone.smartphonemigrationpoc.item.modelBLF.TangibleCharacteristic;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final WebClient.Builder webClientBuilder;
    private static final String DATA = "/Users/unlock/IdeaProjects/smartphone-poc/data/items.json";

    public String getItems() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
//        GuidedSaleDTO guidedSaleDTO = objectMapper.readValue(new File(DATA), GuidedSaleDTO.class);
//        ProductItemDTO productsItemDTO = convert(guidedSaleDTO);
        ProductItemDTO productsItemDTO = createDummyProductDTO();
        String json = objectMapper.writeValueAsString(productsItemDTO.getProducts().get(0));
        performPostRequest(json);

        // TODO: 2: after the mapping --> convert dto to json (will be used as body on blf endpoint)
        // TODO: 3: after the conversion of dto to json, build the endpoint for broadleaf.
        return "Did it really work?";
    }

    private ProductItemDTO convert(GuidedSaleDTO guidedSaleDTO) {
        ProductItemDTO productItemDTO = new ProductItemDTO();
        productItemDTO.convert(guidedSaleDTO);
        return productItemDTO;
    }

    private ProductItemDTO createDummyProductDTO() {
        ProductItemDTO productsDTO = new ProductItemDTO();
        ProductItem product = new ProductItem();
        productsDTO.getProducts().add(product);
        return productsDTO;
    }

    private void performPostRequest(String json) {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://localhost:8446/api/catalog/products"))
                .header("Content-Type", "application/json")
                .header("X-Context-Request", "{\"catalogId\":\"01GEKZ5989PA5K0B2YYA4E114X\",\"sandboxId\":\"01GZ3QTA913K9V03SQC4MJ1BNY\",\"tenantId\":\"5DF1363059675161A85F576D\",\"applicationId\":\"01GEKYXX9CEP821JMDZ9N117J8\",\"customerContextId\":\"01GEKYXX9CEP821JMDZ9N117J8\",\"changeContainer\":{\"name\":\"PRODUCT\"}}")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            String responseBody = httpResponse.body();

            System.out.println("Status code: " + statusCode);
            System.out.println("Response body: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}