package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Smartphone {
    private boolean talkPhone;
    private boolean ecoRating;
    private boolean dualSim;
    private boolean wirelessCharging;
}
