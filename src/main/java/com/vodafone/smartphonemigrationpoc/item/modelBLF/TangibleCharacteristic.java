package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TangibleCharacteristic {
    private boolean wifi;
    private Device device;

    public TangibleCharacteristic() {
        wifi = false;
        device = new Device();
    }
}
