package com.adxcorp.ads.common;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class MediationSettings implements Parcelable {
    public static final Parcelable.Creator<MediationSettings> CREATOR = new Parcelable.Creator<MediationSettings>() { // from class: com.adxcorp.ads.common.MediationSettings.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediationSettings createFromParcel(Parcel parcel) {
            return new MediationSettings(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediationSettings[] newArray(int i) {
            return new MediationSettings[i];
        }
    };
    private long bannerRefreshInterval;
    private String biddingKitAdUnitId;
    private double biddingKitEcpm;
    private String biddingKitMediationId;
    private String biddingKitMetricEndpointFormat;
    private String biddingKitRequestId;
    private String biddingPlatform;
    private long biddingRequestTimeout;
    private boolean enableBiddingKit;
    private long mediationRequestTimeout;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediationSettings() {
    }

    protected MediationSettings(Parcel parcel) {
        this.mediationRequestTimeout = parcel.readLong();
        this.biddingRequestTimeout = parcel.readLong();
        this.bannerRefreshInterval = parcel.readLong();
        this.biddingKitRequestId = parcel.readString();
        this.biddingKitMetricEndpointFormat = parcel.readString();
        this.biddingKitMediationId = parcel.readString();
        this.biddingKitAdUnitId = parcel.readString();
        this.biddingKitEcpm = parcel.readDouble();
        this.enableBiddingKit = parcel.readByte() != 0;
        this.biddingPlatform = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mediationRequestTimeout);
        parcel.writeLong(this.biddingRequestTimeout);
        parcel.writeLong(this.bannerRefreshInterval);
        parcel.writeString(this.biddingKitRequestId);
        parcel.writeString(this.biddingKitMetricEndpointFormat);
        parcel.writeString(this.biddingKitMediationId);
        parcel.writeString(this.biddingKitAdUnitId);
        parcel.writeDouble(this.biddingKitEcpm);
        parcel.writeByte(this.enableBiddingKit ? (byte) 1 : (byte) 0);
        parcel.writeString(this.biddingPlatform);
    }

    public long getMediationRequestTimeout() {
        return this.mediationRequestTimeout;
    }

    public void setMediationRequestTimeout(long j) {
        this.mediationRequestTimeout = j;
    }

    public long getBiddingRequestTimeout() {
        return this.biddingRequestTimeout;
    }

    public void setBiddingRequestTimeout(long j) {
        this.biddingRequestTimeout = j;
    }

    public long getBannerRefreshInterval() {
        return this.bannerRefreshInterval;
    }

    public void setBannerRefreshInterval(long j) {
        this.bannerRefreshInterval = j;
    }

    public String getBiddingKitRequestId() {
        return this.biddingKitRequestId;
    }

    public void setBiddingKitRequestId(String str) {
        this.biddingKitRequestId = str;
    }

    public String getBiddingKitMetricEndpointFormat() {
        return this.biddingKitMetricEndpointFormat;
    }

    public void setBiddingKitMetricEndpointFormat(String str) {
        this.biddingKitMetricEndpointFormat = str;
    }

    public String getBiddingKitMediationId() {
        return this.biddingKitMediationId;
    }

    public void setBiddingKitMediationId(String str) {
        this.biddingKitMediationId = str;
    }

    public String getBiddingKitAdUnitId() {
        return this.biddingKitAdUnitId;
    }

    public void setBiddingKitAdUnitId(String str) {
        this.biddingKitAdUnitId = str;
    }

    public double getBiddingKitEcpm() {
        return this.biddingKitEcpm;
    }

    public void setBiddingKitEcpm(double d) {
        this.biddingKitEcpm = d;
    }

    public boolean isEnableBiddingKit() {
        return this.enableBiddingKit;
    }

    public void setEnableBiddingKit(boolean z) {
        this.enableBiddingKit = z;
    }

    public String getBiddingPlatform() {
        return this.biddingPlatform;
    }

    public void setBiddingPlatform(String str) {
        this.biddingPlatform = str;
    }

    public String toString() {
        return "MediationSettings{mediationRequestTimeout=" + this.mediationRequestTimeout + ", biddingRequestTimeout=" + this.biddingRequestTimeout + ", bannerRefreshInterval=" + this.bannerRefreshInterval + ", biddingKitRequestId='" + this.biddingKitRequestId + "', biddingKitMetricEndpointFormat='" + this.biddingKitMetricEndpointFormat + "', biddingKitMediationId='" + this.biddingKitMediationId + "', biddingKitAdUnitId='" + this.biddingKitAdUnitId + "', biddingKitEcpm=" + this.biddingKitEcpm + ", enableBiddingKit=" + this.enableBiddingKit + ", biddingPlatform='" + this.biddingPlatform + "'}";
    }
}
