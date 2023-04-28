package com.vodafone.smartphonemigrationpoc.item.controller;

import com.vodafone.smartphonemigrationpoc.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getItems() throws IOException {

        String response;

        try {
            response = itemService.getItems();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response != null ? response : "Null pointer";
    }
}
