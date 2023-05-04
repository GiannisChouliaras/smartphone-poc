package com.vodafone.smartphonemigrationpoc.item.modelATG;

import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@NoArgsConstructor
public class Connectivity {
    private boolean wifi;
    private List<String> mobileNetworks;
    private boolean nfc;
    private boolean gps;
    private boolean wifiHotspot;
    private boolean bluetooth;
    private boolean dlna;
}
