package com.adxcorp.ads.mediation.common;

/* JADX INFO: loaded from: classes2.dex */
public class AdResponse {
    private AdData adData;
    private int count;
    private long interval;
    private String message;
    private int result;

    public int getResult() {
        return this.result;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public long getInterval() {
        return this.interval;
    }

    public void setInterval(long j) {
        this.interval = j;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public AdData getAdData() {
        return this.adData;
    }

    public void setAdData(AdData adData) {
        this.adData = adData;
    }
}
