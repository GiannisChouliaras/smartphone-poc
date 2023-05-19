package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}