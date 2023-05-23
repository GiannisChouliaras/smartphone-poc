package com.vodafone.smartphonemigrationpoc.item.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.GuidedSaleDTO;
import com.vodafone.smartphonemigrationpoc.item.itemDTO.ProductItemDTO;
import com.vodafone.smartphonemigrationpoc.item.modelBLF.ProductItem;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemService {

    private static final String DATA = "data/items.json";
    private final EndpointCalls endpointCalls = new EndpointCalls();
    private final ProductItemDTO productsItemDTO;
    private final HashMap<String, List<ProductItem>> map;
    private final ObjectMapper objectMapper;

    public ItemService() throws IOException {
        this.objectMapper = new ObjectMapper();
        this.productsItemDTO = fetchDataFromAtgAndConvertThemToBlf();
        this.map = categorizeProductsOnHashMap(this.productsItemDTO.getProducts());
    }

    public String postRequestsWithoutCategorization() throws IOException {
        createBodiesAndPerformPostRequests(this.endpointCalls, this.productsItemDTO);
        return "Successfully Created and POSTED " + this.productsItemDTO.getProducts().size() + " Products on Broadleaf";
    }

    private void createBodiesAndPerformPostRequests(EndpointCalls calls, ProductItemDTO productsItemDTO) throws JsonProcessingException {
        for (ProductItem item : productsItemDTO.getProducts()) {
            String jsonBody = this.objectMapper.writeValueAsString(item);
            calls.executePostRequestWithoutCategorization(jsonBody);
        }
    }

    private ProductItemDTO fetchDataFromAtgAndConvertThemToBlf() throws IOException {
        GuidedSaleDTO guidedSaleDTO = this.objectMapper.readValue(new File(DATA), GuidedSaleDTO.class);
        ProductItemDTO productItemDTO = new ProductItemDTO();
        productItemDTO.convert(guidedSaleDTO);
        return productItemDTO;
    }

    private HashMap<String, List<ProductItem>> categorizeProductsOnHashMap(List<ProductItem> itemList) {
        HashMap<String, List<ProductItem>> hashMap = new HashMap<>();
        for (ProductItem item : itemList)
            addOrUpdateHashMap(hashMap, item);
        return hashMap;
    }

    private void addOrUpdateHashMap(HashMap<String, List<ProductItem>> map, ProductItem item) {
        if (map.containsKey(item.getName())) {
            map.get(item.getName()).add(item);
            return;
        }
        ArrayList<ProductItem> itemList = new ArrayList<>();
        itemList.add(item);
        map.put(item.getName(), itemList);
    }
}