package com.adxcorp.ads;

/* JADX INFO: loaded from: classes2.dex */
public class NewsViewBinder {
    private int bannerId;
    private int layoutId;
    private int newsIconId;
    private int newsTitleId;

    public NewsViewBinder(Builder builder) {
        this.layoutId = builder.layoutId;
        this.bannerId = builder.bannerId;
        this.newsTitleId = builder.newsTitleId;
        this.newsIconId = builder.newsIconId;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public int getBannerId() {
        return this.bannerId;
    }

    public int getNewsTitleId() {
        return this.newsTitleId;
    }

    public int getNewsIconId() {
        return this.newsIconId;
    }

    public static class Builder {
        private int bannerId;
        private int layoutId;
        private int newsIconId;
        private int newsTitleId;

        public Builder(int i) {
            this.layoutId = i;
        }

        public Builder setBannerId(int i) {
            this.bannerId = i;
            return this;
        }

        public Builder setNewsTitleId(int i) {
            this.newsTitleId = i;
            return this;
        }

        public Builder setNewsIconId(int i) {
            this.newsIconId = i;
            return this;
        }

        public NewsViewBinder build() {
            return new NewsViewBinder(this);
        }
    }
}
