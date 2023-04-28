package com.vodafone.smartphonemigrationpoc.item;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Basic {

    private String deviceName;
    private String deviceModel;
    private String brand;
    private String sku;
    private String price;
    private String currency;
    private String url;
    private String imageUrl;
    private String releaseYear;
    private boolean available ;
}
