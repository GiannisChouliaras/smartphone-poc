package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class DefaultPrice {
    private int amount;

    public DefaultPrice() {
        amount = 1;
    }
}
