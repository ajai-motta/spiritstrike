package com.adxcorp.ads.common;

import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class MediationData implements Parcelable {
    public static final Parcelable.Creator<MediationData> CREATOR = new Parcelable.Creator<MediationData>() { // from class: com.adxcorp.ads.common.MediationData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediationData createFromParcel(Parcel parcel) {
            return new MediationData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediationData[] newArray(int i) {
            return new MediationData[i];
        }
    };
    private String adNetworkName;
    private String bidResponse;
    private String customEventName;
    private String customEventParams;
    private double ecpm;
    private String mediationId;
    private MediationSettings mediationSettings;
    private String metricEndpointFormat;
    private NewsFeed newsFeed;
    private String requestId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediationData() {
    }

    protected MediationData(Parcel parcel) {
        this.requestId = parcel.readString();
        this.metricEndpointFormat = parcel.readString();
        this.mediationId = parcel.readString();
        this.adNetworkName = parcel.readString();
        this.customEventName = parcel.readString();
        this.customEventParams = parcel.readString();
        this.bidResponse = parcel.readString();
        this.ecpm = parcel.readDouble();
        this.mediationSettings = (MediationSettings) parcel.readParcelable(MediationSettings.class.getClassLoader());
        this.newsFeed = (NewsFeed) parcel.readParcelable(NewsFeed.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.requestId);
        parcel.writeString(this.metricEndpointFormat);
        parcel.writeString(this.mediationId);
        parcel.writeString(this.adNetworkName);
        parcel.writeString(this.customEventName);
        parcel.writeString(this.customEventParams);
        parcel.writeString(this.bidResponse);
        parcel.writeDouble(this.ecpm);
        parcel.writeParcelable(this.mediationSettings, i);
        parcel.writeParcelable(this.newsFeed, i);
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getMetricEndpointFormat() {
        return this.metricEndpointFormat;
    }

    public void setMetricEndpointFormat(String str) {
        this.metricEndpointFormat = str;
    }

    public String getMediationId() {
        return this.mediationId;
    }

    public void setMediationId(String str) {
        this.mediationId = str;
    }

    public String getAdNetworkName() {
        return this.adNetworkName;
    }

    public void setAdNetworkName(String str) {
        this.adNetworkName = str;
    }

    public String getCustomEventName() {
        return this.customEventName;
    }

    public void setCustomEventName(String str) {
        this.customEventName = str;
    }

    public String getCustomEventParams() {
        return this.customEventParams;
    }

    public void setCustomEventParams(String str) {
        this.customEventParams = str;
    }

    public String getBidResponse() {
        return this.bidResponse;
    }

    public void setBidResponse(String str) {
        this.bidResponse = str;
    }

    public double getEcpm() {
        return this.ecpm;
    }

    public void setEcpm(double d) {
        this.ecpm = d;
    }

    public MediationSettings getMediationSettings() {
        return this.mediationSettings;
    }

    public void setMediationSettings(MediationSettings mediationSettings) {
        this.mediationSettings = mediationSettings;
    }

    public NewsFeed getNewsFeed() {
        return this.newsFeed;
    }

    public void setNewsFeed(NewsFeed newsFeed) {
        this.newsFeed = newsFeed;
    }

    public String toString() {
        return "MediationData{requestId='" + this.requestId + "', metricEndpointFormat='" + this.metricEndpointFormat + "', mediationId='" + this.mediationId + "', adNetworkName='" + this.adNetworkName + "', customEventName='" + this.customEventName + "', customEventParams='" + this.customEventParams + "', bidResponse='" + this.bidResponse + "', ecpm=" + this.ecpm + ", mediationSettings=" + this.mediationSettings + ", newsFeed=" + this.newsFeed + AbstractJsonLexerKt.END_OBJ;
    }
}
