package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Smartphone {
    private boolean talkPhone;
    private boolean ecoRating;
    private boolean dualSim;
    private boolean wirelessCharging;

    public Smartphone() {
        this.talkPhone = false;
        this.ecoRating = false;
        this.dualSim = false;
        this.wirelessCharging = false;
    }
}
