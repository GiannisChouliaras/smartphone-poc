package com.vodafone.smartphonemigrationpoc.item.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.GuidedSaleDTO;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.ProductItemDTO;
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
        // TODO: * make the call to the endpoint (we use mocked data for now)

        ObjectMapper objectMapper = new ObjectMapper();
        GuidedSaleDTO guidedSaleDTO = objectMapper.readValue(new File(DATA), GuidedSaleDTO.class);
        ProductItemDTO productsItemDTO = convert(guidedSaleDTO);
        // TODO: 2: after the mapping --> convert dto to json (will be used as body on blf endpoint)
        // TODO: 3: after the conversion of dto to json, build the endpoint for broadleaf.
        return guidedSaleDTO.toString();
    }

    private ProductItemDTO convert(GuidedSaleDTO guidedSaleDTO) {
        ProductItemDTO productItemDTO = new ProductItemDTO();
        productItemDTO.convert(guidedSaleDTO);
        return productItemDTO;
    }
}