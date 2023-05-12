package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewsSummary {
    private int numberOfReviews;

    public ReviewsSummary() {
        numberOfReviews = 0;
    }
}
