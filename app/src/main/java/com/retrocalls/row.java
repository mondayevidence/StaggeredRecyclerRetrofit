package com.retrocalls;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class row {

    private int img;

    public row(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
