package com.vodafone.smartphonemigrationpoc.item.modelATG;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuidedSaleItem {

    private Platform platformInfo;
    private Memory memoryInfo;
    private Body bodyInfo;
    private Basic basicInfo;
    private Battery batteryInfo;
    private Connectivity connectivityInfo;
    private Display displayInfo;
    private Color colorInfo;
    private Camera cameraInfo;
}
