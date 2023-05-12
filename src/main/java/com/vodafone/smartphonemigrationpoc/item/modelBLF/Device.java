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

    public Device() {
        this.smartphone = new Smartphone();
        this.fastCharging = false;
        this.removableBattery = false;
        this.frontFlash = false;
        this.backFlash = false;
        this.agps = false;
        this.bluetooth = false;
        this.dlna = false;
        this.gps = false;
        this.gpsNavigation = false;
        this.nfc = false;
        this.wifiHotspot = false;
        this.pcConnectionCableIncluded = false;
        this.batteryIncluded = false;
        this.chargerIncluded = false;
        this.handsfreeIncluded = false;
        this.manualIncluded = false;
        this.fmRadio = false;
        this.email = false;
        this.hdVoice = false;
        this.mp3 = false;
    }
}