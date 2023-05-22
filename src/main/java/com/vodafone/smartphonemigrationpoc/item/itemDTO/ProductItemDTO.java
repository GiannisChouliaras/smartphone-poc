package com.vodafone.smartphonemigrationpoc.item.itemDTO;

import com.vodafone.smartphonemigrationpoc.item.modelATG.GuidedSaleItem;
import com.vodafone.smartphonemigrationpoc.item.modelBLF.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductItemDTO {
    private List<ProductItem> products;

    public ProductItemDTO() {
        products = new ArrayList<>();
    }

    /**
     * For all items in GuidedSaleDTO, create a new ProductItem and assign the data at the proper variables
     *
     * @param guidedSaleDTO
     */
    public void convert(GuidedSaleDTO guidedSaleDTO) {
        for (GuidedSaleItem item : guidedSaleDTO.getItems()) {
            ProductItem productItem = assignDataFromGuidedToProduct(item);
            products.add(productItem);
        }
    }

    private ProductItem assignDataFromGuidedToProduct(GuidedSaleItem item) {
        ProductItem productItem = new ProductItem();
        productItem.setReviewsSummary(createReviewsSummary());
        productItem.setTangibleCharacteristic(createTangibleChar(item));
        productItem.setDefaultPrice(createDefaultPrice(item));
        productItem.setSalePrice(createSalePrice(item));
        productItem.setDiscountable(false);
        productItem.setOnOffer(false);
        productItem.setPortalReady(false);
        productItem.setOnline(true);
        productItem.setActiveStartDate("2023-05-04T04:00:00.000Z");
        productItem.setProductType("VARIANT_BASED");
        productItem.setIndividuallySold(true);
        productItem.setPricingKey("pricingKey");
        productItem.setInventoryType("PHYSICAL");
        productItem.setEligibleForPickup(false);
        productItem.setAvailableOnline(true);
        productItem.setInventoryCheckStrategy("NEVER");
        productItem.setInventoryReservationStrategy("NEVER");
        productItem.setName(item.getBasicInfo().getDeviceName());
        productItem.setUri(createUriBasedOnName(item.getBasicInfo().getDeviceName()));
        productItem.setSku(item.getBasicInfo().getSku());
        productItem.setProductSubtype("3000");

        return productItem;
    }

    private String createUriBasedOnName(String deviceName) {
        String nameWithoutSpaces = deviceName.replaceAll("\\s", "");
        return "/" + nameWithoutSpaces.trim();
    }

    private SalePrice createSalePrice(GuidedSaleItem item) {
        return new SalePrice(Integer.parseInt(item.getBasicInfo().getPrice()));
    }

    private DefaultPrice createDefaultPrice(GuidedSaleItem item) {
        return new DefaultPrice(Integer.parseInt(item.getBasicInfo().getPrice()));
    }

    private TangibleCharacteristic createTangibleChar(GuidedSaleItem item) {
        Device device = new Device(item);
        return new TangibleCharacteristic(item.getConnectivityInfo().isWifi(), device);
    }

    private ReviewsSummary createReviewsSummary() {
        return new ReviewsSummary(0);
    }
}
