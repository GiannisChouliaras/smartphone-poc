package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonIgnoreProperties({"portalReady", "deleted"})
public class ProductItem {
    private ReviewsSummary reviewsSummary;
    private TangibleCharacteristic tangibleCharacteristic;
    private DefaultPrice defaultPrice;
    private SalePrice salePrice;
    private boolean discountable;
    private boolean onOffer;
    private @JsonProperty("isPortalReady") boolean isPortalReady;
    private boolean online;
    private String activeStartDate;
    private String productType;
    private boolean individuallySold;
    private String pricingKey;
    private String inventoryType;
    private boolean eligibleForPickup;
    private boolean availableOnline;
    private String inventoryCheckStrategy;
    private String inventoryReservationStrategy;
    private String name;
    private String uri;
    private String sku;
    private String productSubtype;

    public ProductItem() {
        reviewsSummary = new ReviewsSummary();
        tangibleCharacteristic = new TangibleCharacteristic();
        defaultPrice = new DefaultPrice();
        salePrice = new SalePrice();
        discountable = true;
        onOffer = false;
        isPortalReady = false;
        online = true;
        activeStartDate = "2023-05-04T04:00:00.000Z";
        productType = "VARIANT_BASED";
        individuallySold = true;
        pricingKey = "4dcce69d-b5d8-4fa2-8240-0ece2b4a1095";
        inventoryType = "PHYSICAL";
        eligibleForPickup = false;
        availableOnline = true;
        inventoryCheckStrategy = "NEVER";
        inventoryReservationStrategy = "NEVER";
        name = "dummyTest";
        uri = "/dummmyTest-3";
        sku = "123456";
        productSubtype = "3000";
    }
}