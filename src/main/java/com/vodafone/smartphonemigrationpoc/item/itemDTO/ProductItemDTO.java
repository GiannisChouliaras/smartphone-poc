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
        productItem.setReviewsSummary(createReviewsSummary(item));
        productItem.setTangibleCharacteristic(createTangibleChar(item));
        productItem.setDefaultPrice(createDefaultPrice(item));
        productItem.setSalePrice(createSalePrice(item));
        // TODO: populate boolean and string values from item
        productItem.setDiscountable(false);
        productItem.setOnOffer(false);
        productItem.setPortalReady(false);
        productItem.setOnline(false);
        productItem.setActiveStartDate("date");
        productItem.setProductType("productType");
        productItem.setIndividuallySold(false);
        productItem.setPricingKey("pricingKey");
        productItem.setInventoryType("inventoryType");
        productItem.setEligibleForPickup(false);
        productItem.setAvailableOnline(false);
        productItem.setInventoryCheckStrategy("inventoryCheckStrategy");
        productItem.setInventoryReservationStrategy("inventoryReservationStrategy");
        productItem.setName("name");
        productItem.setUri("uri");
        productItem.setSku("sku");
        productItem.setProductSubtype("productSubtype");

        return productItem;
    }

    private SalePrice createSalePrice(GuidedSaleItem item) {
        return new SalePrice(); // TODO: populate SalePrice
    }

    private DefaultPrice createDefaultPrice(GuidedSaleItem item) {
        return new DefaultPrice(); // TODO: populate DefaultPrice
    }

    private TangibleCharacteristic createTangibleChar(GuidedSaleItem item) {
        return new TangibleCharacteristic(); // TODO: populate TangibleCharacteristics
    }

    private ReviewsSummary createReviewsSummary(GuidedSaleItem item) {
        return new ReviewsSummary(); // TODO: populate ReviewsSummary
    }
}
