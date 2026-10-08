package com.gomfactory.adpie.sdk.dialog;

import com.gomfactory.adpie.sdk.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class DialogStyleV1 {
    public static final int DIALOG_SIZE_250x250 = 0;
    public static final int DIALOG_SIZE_300x250 = 1;
    private final int adSize;
    private final int backgroundColor;
    private final int buttonCount;
    private final int buttonTextSize;
    private final String defaultImageClickUrl;
    private final int defaultImageResId;
    private final int firstButtonColor;
    private final String firstButtonText;
    private final int firstButtonTextColor;
    private final String messageText;
    private final int messageTextColor;
    private final int messageTextSize;
    private final int radius;
    private final int secondButtonColor;
    private final String secondButtonText;
    private final int secondButtonTextColor;
    private final int thirdButtonColor;
    private final String thirdButtonText;
    private final int thirdButtonTextColor;

    private DialogStyleV1(Builder builder) {
        this.adSize = builder.adSize;
        this.defaultImageResId = builder.defaultImageResId;
        this.defaultImageClickUrl = builder.defaultImageClickUrl;
        this.backgroundColor = builder.backgroundColor;
        this.messageText = builder.messageText;
        this.messageTextColor = builder.messageTextColor;
        this.messageTextSize = builder.messageTextSize;
        this.buttonCount = builder.buttonCount;
        this.buttonTextSize = builder.buttonTextSize;
        this.firstButtonText = builder.firstButtonText;
        this.firstButtonColor = builder.firstButtonColor;
        this.firstButtonTextColor = builder.firstButtonTextColor;
        this.secondButtonText = builder.secondButtonText;
        this.secondButtonColor = builder.secondButtonColor;
        this.secondButtonTextColor = builder.secondButtonTextColor;
        this.thirdButtonText = builder.thirdButtonText;
        this.thirdButtonColor = builder.thirdButtonColor;
        this.thirdButtonTextColor = builder.thirdButtonTextColor;
        this.radius = builder.radius;
    }

    public int getAdSize() {
        return this.adSize;
    }

    public int getDefaultImageResId() {
        return this.defaultImageResId;
    }

    public String getDefaultImageClickUrl() {
        return this.defaultImageClickUrl;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public int getMessageTextColor() {
        return this.messageTextColor;
    }

    public int getMessageTextSize() {
        return this.messageTextSize;
    }

    public int getButtonCount() {
        return this.buttonCount;
    }

    public int getButtonTextSize() {
        return this.buttonTextSize;
    }

    public String getFirstButtonText() {
        return this.firstButtonText;
    }

    public int getFirstButtonColor() {
        return this.firstButtonColor;
    }

    public int getFirstButtonTextColor() {
        return this.firstButtonTextColor;
    }

    public String getSecondButtonText() {
        return this.secondButtonText;
    }

    public int getSecondButtonColor() {
        return this.secondButtonColor;
    }

    public int getSecondButtonTextColor() {
        return this.secondButtonTextColor;
    }

    public String getThirdButtonText() {
        return this.thirdButtonText;
    }

    public int getThirdButtonColor() {
        return this.thirdButtonColor;
    }

    public int getThirdButtonTextColor() {
        return this.thirdButtonTextColor;
    }

    public int getRadius() {
        return this.radius;
    }

    public String toString() {
        return "[" + super.toString() + "] adSize : " + this.adSize + ", defaultImageResId : " + this.defaultImageResId + ", defaultImageClickUrl : " + this.defaultImageClickUrl + ", backgroundColor : " + this.backgroundColor + ", messageText : " + this.messageText + ", messageTextColor : " + this.messageTextColor + ", messageTextSize : " + this.messageTextSize + ", buttonCount : " + this.buttonCount + ", buttonTextSize : " + this.buttonTextSize + ", firstButtonText : " + this.firstButtonText + ", firstButtonColor : " + this.firstButtonColor + ", firstButtonTextColor : " + this.firstButtonTextColor + ", secondButtonText : " + this.secondButtonText + ", secondButtonColor : " + this.secondButtonColor + ", secondButtonTextColor : " + this.secondButtonTextColor + ", thirdButtonText : " + this.thirdButtonText + ", thirdButtonColor : " + this.thirdButtonColor + ", thirdButtonTextColor : " + this.thirdButtonTextColor + ", radius : " + this.radius;
    }

    public static class Builder {
        private int adSize;
        private String defaultImageClickUrl;
        private int defaultImageResId;
        private int buttonCount = 2;
        private int buttonTextSize = 15;
        private int backgroundColor = -1;
        private String messageText = Constants.DEFAULT_DIALOG_MESSAGE_TEXT;
        private int messageTextColor = -16777216;
        private int messageTextSize = 15;
        private String firstButtonText = Constants.DEFAULT_DIALOG_FIRST_BUTTON_TEXT;
        private int firstButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        private int firstButtonTextColor = -1;
        private String secondButtonText = Constants.DEFAULT_DIALOG_SECOND_BUTTON_TEXT;
        private int secondButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        private int secondButtonTextColor = -1;
        private String thirdButtonText = Constants.DEFAULT_DIALOG_THIRD_BUTTON_TEXT;
        private int thirdButtonColor = Constants.DEFAULT_DIALOG_BUTTON_COLOR;
        private int thirdButtonTextColor = -1;
        private int radius = 10;

        public Builder setAdSize(int i) {
            this.adSize = i;
            return this;
        }

        public Builder setDefaultImageResId(int i) {
            this.defaultImageResId = i;
            return this;
        }

        public Builder setDefaultImageClickUrl(String str) {
            this.defaultImageClickUrl = str;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder setMessageText(String str) {
            this.messageText = str;
            return this;
        }

        public Builder setMessageTextColor(int i) {
            this.messageTextColor = i;
            return this;
        }

        public Builder setMessageTextSize(int i) {
            this.messageTextSize = i;
            return this;
        }

        public Builder setButtonCount(int i) {
            this.buttonCount = i;
            return this;
        }

        public Builder setButtonTextSize(int i) {
            this.buttonTextSize = i;
            return this;
        }

        public Builder setFirstButtonText(String str) {
            this.firstButtonText = str;
            return this;
        }

        public Builder setFirstButtonColor(int i) {
            this.firstButtonColor = i;
            return this;
        }

        public Builder setFirstButtonTextColor(int i) {
            this.firstButtonTextColor = i;
            return this;
        }

        public Builder setSecondButtonText(String str) {
            this.secondButtonText = str;
            return this;
        }

        public Builder setSecondButtonColor(int i) {
            this.secondButtonColor = i;
            return this;
        }

        public Builder setSecondButtonTextColor(int i) {
            this.secondButtonTextColor = i;
            return this;
        }

        public Builder setThirdButtonText(String str) {
            this.thirdButtonText = str;
            return this;
        }

        public Builder setThirdButtonColor(int i) {
            this.thirdButtonColor = i;
            return this;
        }

        public Builder setThirdButtonTextColor(int i) {
            this.thirdButtonTextColor = i;
            return this;
        }

        public Builder setRadius(int i) {
            this.radius = i;
            return this;
        }

        public DialogStyleV1 build() {
            return new DialogStyleV1(this);
        }
    }
}
