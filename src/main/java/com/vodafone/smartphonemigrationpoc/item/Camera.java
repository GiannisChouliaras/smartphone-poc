package com.vodafone.smartphonemigrationpoc.item;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Camera {

    private String backMpixels;
    private String frontMpixels;
    private String secondBackMpixels;
    private String secondFrontMpixels;
    private boolean backFlash;
    private boolean frontFlash;
}
