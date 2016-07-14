package com.edkornev.berserkcounter.utils;

import com.edkornev.berserkcounter.R;

/**
 * Created by Eduard on 14.07.2016.
 */
public enum RaceEnum {
    FIELDS(R.drawable.fields), ROCKS(R.drawable.rocks), FORESTS(R.drawable.forests),
    SWAMPS(R.drawable.swamps), DARK(R.drawable.dark);

    RaceEnum(int image) {
        this.image = image;
    }

    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
