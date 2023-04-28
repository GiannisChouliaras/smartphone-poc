package com.vodafone.smartphonemigrationpoc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.GuidedSaleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final WebClient.Builder webClientBuilder;
    private static final String DATA = "/home/ioannisch/Documents/smartphone-migration-poc/data/items.json";

    public String getItems() throws IOException {
        // TODO: make the call to the endpoint

        ObjectMapper objectMapper = new ObjectMapper();
        GuidedSaleDTO guidedSaleDTO = objectMapper.readValue(new File(DATA), GuidedSaleDTO.class);
        return guidedSaleDTO.toString();
    }
}
