package com.vodafone.smartphonemigrationpoc.item;

import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@NoArgsConstructor
public class Battery {
    private boolean removeable;
    private boolean quickcharge;
    private String standbyTime;
    private String talkTime;
    private String capacity;
}
