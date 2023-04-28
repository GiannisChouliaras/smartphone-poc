package com.vodafone.smartphonemigrationpoc.item;

import lombok.NoArgsConstructor;

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
