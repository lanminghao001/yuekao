package com.example.lanminghao201812212.image;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class Image2 {
    public static DisplayImageOptions image(){
        DisplayImageOptions options = new DisplayImageOptions.Builder().displayer(new RoundedBitmapDisplayer(50)).build();
        return options;
    }
}
