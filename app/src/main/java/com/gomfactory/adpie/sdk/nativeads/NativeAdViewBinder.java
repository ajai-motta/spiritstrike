package com.gomfactory.adpie.sdk.nativeads;

/* JADX INFO: loaded from: classes3.dex */
public class NativeAdViewBinder {
    private int callToActionId;
    private int descriptionId;
    private int iconImageId;
    private int layoutId;
    private int mainId;
    private int optOutId;
    private int ratingbarId;
    private int titleId;

    public NativeAdViewBinder(Builder builder) {
        this.layoutId = builder.layoutId;
        this.titleId = builder.titleId;
        this.descriptionId = builder.descriptionId;
        this.mainId = builder.mainId;
        this.iconImageId = builder.iconImageId;
        this.callToActionId = builder.callToActionId;
        this.ratingbarId = builder.ratingbarId;
        this.optOutId = builder.optOutId;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public int getTitleId() {
        return this.titleId;
    }

    public int getDescriptionId() {
        return this.descriptionId;
    }

    public int getMainId() {
        return this.mainId;
    }

    public int getIconImageId() {
        return this.iconImageId;
    }

    public int getCallToActionId() {
        return this.callToActionId;
    }

    public int getRatingbarId() {
        return this.ratingbarId;
    }

    public int getOptOutId() {
        return this.optOutId;
    }

    public static class Builder {
        private int callToActionId;
        private int descriptionId;
        private int iconImageId;
        private int layoutId;
        private int mainId;
        private int optOutId;
        private int ratingbarId;
        private int titleId;

        public Builder(int i) {
            this.layoutId = i;
        }

        public Builder setTitleId(int i) {
            this.titleId = i;
            return this;
        }

        public Builder setDescriptionId(int i) {
            this.descriptionId = i;
            return this;
        }

        public Builder setMainId(int i) {
            this.mainId = i;
            return this;
        }

        public Builder setIconImageId(int i) {
            this.iconImageId = i;
            return this;
        }

        public Builder setRatingbarId(int i) {
            this.ratingbarId = i;
            return this;
        }

        public Builder setCallToActionId(int i) {
            this.callToActionId = i;
            return this;
        }

        public Builder setOptOutId(int i) {
            this.optOutId = i;
            return this;
        }

        public NativeAdViewBinder build() {
            return new NativeAdViewBinder(this);
        }
    }
}
