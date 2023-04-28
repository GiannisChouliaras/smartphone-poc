package com.vodafone.smartphonemigrationpoc.item;

import lombok.NoArgsConstructor;
import lombok.Data;
@Data
@NoArgsConstructor
public class Connectivity {
    private boolean bluetooth;
    private boolean dlna;
    private boolean gps;
    private boolean nfc;
    private boolean wifi;
    private boolean wifiHotspot;
    private boolean mobileNetworks;
}
