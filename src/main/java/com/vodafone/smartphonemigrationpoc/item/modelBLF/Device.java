package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    private Smartphone smartphone;
    private boolean fastCharging;
    private boolean removableBattery;
    private boolean frontFlash;
    private boolean backFlash;
    private boolean agps;
    private boolean bluetooth;
    private boolean dlna;
    private boolean gps;
    private boolean gpsNavigation;
    private boolean nfc;
    private boolean wifiHotspot;
    private boolean pcConnectionCableIncluded;
    private boolean batteryIncluded;
    private boolean chargerIncluded;
    private boolean handsfreeIncluded;
    private boolean manualIncluded;
    private boolean fmRadio;
    private boolean email;
    private boolean hdVoice;
    private boolean mp3;
}