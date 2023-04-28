package com.vodafone.smartphonemigrationpoc.item.model;

import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@NoArgsConstructor
public class Battery {
    private String talkTime;
    private String capacity;
    private boolean removable;
    private String standbyTime;
    private boolean quickcharge;
}
