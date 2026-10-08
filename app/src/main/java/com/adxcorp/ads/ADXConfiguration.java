package com.adxcorp.ads;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ADXConfiguration {
    private String appId;
    private GdprType gdprType;
    private List<String> testDeviceIds;

    public enum GdprType {
        POPUP_LOCATION,
        POPUP_DEBUG,
        DIRECT_UNKNOWN,
        DIRECT_NOT_REQUIRED,
        DIRECT_DENIED,
        DIRECT_CONFIRM
    }

    public String getAppId() {
        return this.appId;
    }

    public GdprType getGdprType() {
        return this.gdprType;
    }

    public List<String> getTestDeviceIds() {
        return this.testDeviceIds;
    }

    public static class Builder {
        String appId;
        GdprType gdprType;
        List<String> testDeviceIds;

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setGdprType(GdprType gdprType) {
            this.gdprType = gdprType;
            return this;
        }

        public Builder setTestDeviceIds(List<String> list) {
            this.testDeviceIds = list;
            return this;
        }

        public ADXConfiguration build() {
            ADXConfiguration aDXConfiguration = new ADXConfiguration();
            aDXConfiguration.appId = this.appId;
            aDXConfiguration.gdprType = this.gdprType;
            aDXConfiguration.testDeviceIds = this.testDeviceIds;
            return aDXConfiguration;
        }
    }
}
