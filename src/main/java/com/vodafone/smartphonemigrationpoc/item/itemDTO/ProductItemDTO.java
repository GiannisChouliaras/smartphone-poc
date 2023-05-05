package com.vodafone.smartphonemigrationpoc.item.itemDTO;

import com.vodafone.smartphonemigrationpoc.item.modelBLF.ProductItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductItemDTO {
   private List<ProductItem> products;

    public void convert(GuidedSaleDTO guidedSaleDTO) {
        // TODO: 1: implementation of convert method (mapping).
    }
}
