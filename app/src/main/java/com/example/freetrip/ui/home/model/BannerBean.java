package com.example.freetrip.ui.home.model;

import android.net.Uri;


import com.example.freetrip.R;

import java.util.ArrayList;
import java.util.List;

public class BannerBean {
    private int imageRes;
    private Uri imageUri;
    private String imageTitle;

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }


    public static List<BannerBean> getDefaultBanners() {
        List<BannerBean> banners = new ArrayList<>();
        BannerBean banner1 = new BannerBean();
        banner1.setImageRes(R.drawable.banner1);
        BannerBean banner2 = new BannerBean();
        banner2.setImageRes(R.drawable.banner2);
        BannerBean banner3 = new BannerBean();
        banner3.setImageRes(R.drawable.banner3);
        BannerBean banner4 = new BannerBean();
        banner4.setImageRes(R.drawable.banner4);
        banners.add(banner1);
        banners.add(banner2);
        banners.add(banner3);
        banners.add(banner4);
        return banners;
    }
}
