package com.vodafone.smartphonemigrationpoc.item.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Basic {

    private boolean available ;
    private String deviceName;
    private String url;
    private String price;
    private String imageUrl;
    private String currency;
    private String deviceModel;
    private String sku;
    private String brand;
    private String releaseYear;
}
