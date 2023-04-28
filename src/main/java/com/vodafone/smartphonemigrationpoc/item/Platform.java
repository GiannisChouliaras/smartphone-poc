package com.vodafone.smartphonemigrationpoc.item;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Platform {
    private String cpuClockRate;
    private String cpuModel;
    private String operatingSystem;
    private String cpuCores;
}