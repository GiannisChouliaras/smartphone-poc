package com.vodafone.smartphonemigrationpoc.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GuidedSaleDTO {
    private List<GuidedSaleItem> items;
}
