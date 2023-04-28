package com.vodafone.smartphonemigrationpoc.item;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuidedSaleItem {

    private Basic basicInfo;
    private Battery batteryInfo;
    private Body bodyInfo;
    private Camera cameraInfo;
    private Color colorInfo;
    private Connectivity connectivityInfo;
    private Display displayInfo;
    private Memory memoryInfo;
    private Platform platformInfo;
}
