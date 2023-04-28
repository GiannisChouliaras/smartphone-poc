package com.vodafone.smartphonemigrationpoc.item.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Camera {

    private String backMpixels;
    private String secondFrontMpixels;
    private boolean frontFlash;
    private String secondBackMpixels;
    private String frontMpixels;
    private boolean backFlash;
}
