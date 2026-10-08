package com.gomfactory.adpie.sdk.common;

/* JADX INFO: loaded from: classes3.dex */
public class Configuration {
    private boolean adpieSdkLog;
    private boolean adpieServerLog;
    private String adpieConfigUrl = "https://adp.adpies.com/adp/config";
    private String adpieSspUrl = "https://ssp.adpies.com/ssp/request";

    public boolean isAdpieSdkLog() {
        return this.adpieSdkLog;
    }

    public void setAdpieSdkLog(boolean z) {
        this.adpieSdkLog = z;
    }

    public boolean isAdpieServerLog() {
        return this.adpieServerLog;
    }

    public void setAdpieServerLog(boolean z) {
        this.adpieServerLog = z;
    }

    public String getAdpieConfigUrl() {
        return this.adpieConfigUrl;
    }

    public void setAdpieConfigUrl(String str) {
        this.adpieConfigUrl = str;
    }

    public String getAdpieSspUrl() {
        return this.adpieSspUrl;
    }

    public void setAdpieSspUrl(String str) {
        this.adpieSspUrl = str;
    }
}
