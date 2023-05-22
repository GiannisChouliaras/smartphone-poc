package com.vodafone.smartphonemigrationpoc.item.modelBLF;

import com.vodafone.smartphonemigrationpoc.item.modelATG.GuidedSaleItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
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

    /*
     {
      "platformInfo": {
        "cpuClockRate": null,
        "cpuModel": "A14 Bionic",
        "operatingSystem": "iOS",
        "cpuCores": null
      },
      "memoryInfo": {
        "storageCapacity": "64GB",
        "ram": null
      },
      "bodyInfo": {
        "weight": "135gr",
        "ipRating": "IP68 (maximum depth of 6 meters up to 30 minutes)",
        "simType": "4FFF",
        "width": "64.2mm",
        "height": "131.5mm"
      },
      "basicInfo": {
        "available": false,
        "deviceName": "Apple iPhone 12 mini",
        "url": null,
        "price": "0.00",
        "imageUrl": null,
        "currency": "EUR",
        "deviceModel": "Apple iPhone 12 mini",
        "sku": "000001141112101001",
        "brand": "Apple",
        "releaseYear": "2020"
      },
      "batteryInfo": {
        "talkTime": null,
        "capacity": null,
        "removable": false,
        "standbyTime": "15hrs",
        "quickcharge": true
      },
      "connectivityInfo": {
        "wifi": true,
        "mobileNetworks": [
          "5G"
        ],
        "nfc": true,
        "gps": true,
        "wifiHotspot": true,
        "bluetooth": true,
        "dlna": false
      },
      "displayInfo": {
        "technology": "Super Retina XDR/OLED Display",
        "resolution": "2340x1080-pixel resolution at 476 ppi",
        "size": "5.4inches"
      },
      "colorInfo": {
        "colorName": "Μαύρο",
        "colorHex": "#000000"
      },
      "cameraInfo": {
        "backMpixels": "12.0MP",
        "secondFrontMpixels": null,
        "frontFlash": true,
        "secondBackMpixels": "12.0MP",
        "frontMpixels": "12.0MP",
        "backFlash": true
      }
    },
     */

    public Device(GuidedSaleItem item) {
        this.smartphone = new Smartphone(false, false, false, false);
        this.fastCharging = item.getBatteryInfo().isQuickcharge();
        this.removableBattery = item.getBatteryInfo().isRemovable();
        this.frontFlash = item.getCameraInfo().isFrontFlash();
        this.backFlash = item.getCameraInfo().isBackFlash();
        this.agps = false;
        this.bluetooth = item.getConnectivityInfo().isBluetooth();
        this.dlna = item.getConnectivityInfo().isDlna();
        this.gps = item.getConnectivityInfo().isGps();
        this.gpsNavigation = false;
        this.nfc = item.getConnectivityInfo().isNfc();
        this.wifiHotspot = item.getConnectivityInfo().isWifiHotspot();
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