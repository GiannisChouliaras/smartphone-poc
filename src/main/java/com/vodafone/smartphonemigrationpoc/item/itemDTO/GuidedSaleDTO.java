package com.vodafone.smartphonemigrationpoc.item.itemDTO;

import com.vodafone.smartphonemigrationpoc.item.model.GuidedSaleItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GuidedSaleDTO {
    private List<GuidedSaleItem> items;
}
