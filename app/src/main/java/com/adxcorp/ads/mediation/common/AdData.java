package com.adxcorp.ads.mediation.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AdData implements Parcelable {
    public static final Parcelable.Creator<AdData> CREATOR = new Parcelable.Creator<AdData>() { // from class: com.adxcorp.ads.mediation.common.AdData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdData createFromParcel(Parcel parcel) {
            return new AdData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdData[] newArray(int i) {
            return new AdData[i];
        }
    };
    private String adm;
    private String admImageTag;
    private int animationType;
    private int backButtonEnabled;
    private String bgColor;
    private long closeButtonDelay;
    private int closeButtonPosition;
    private int height;
    private int icType;
    private int monitoring;
    private int orientation;
    private int position;
    private ArrayList<String> trackingClkUrls;
    private ArrayList<String> trackingCloseUrls;
    private ArrayList<String> trackingImpUrls;
    private int webviewLanding;
    private int webviewLoadingSkip;
    private int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AdData() {
    }

    protected AdData(Parcel parcel) {
        this.icType = parcel.readInt();
        this.adm = parcel.readString();
        this.admImageTag = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.bgColor = parcel.readString();
        this.closeButtonPosition = parcel.readInt();
        this.closeButtonDelay = parcel.readLong();
        this.monitoring = parcel.readInt();
        this.webviewLoadingSkip = parcel.readInt();
        this.trackingImpUrls = parcel.createStringArrayList();
        this.trackingClkUrls = parcel.createStringArrayList();
        this.webviewLanding = parcel.readInt();
        this.trackingCloseUrls = parcel.createStringArrayList();
        this.orientation = parcel.readInt();
        this.backButtonEnabled = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.icType);
        parcel.writeString(this.adm);
        parcel.writeString(this.admImageTag);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.bgColor);
        parcel.writeInt(this.closeButtonPosition);
        parcel.writeLong(this.closeButtonDelay);
        parcel.writeInt(this.monitoring);
        parcel.writeInt(this.webviewLoadingSkip);
        parcel.writeStringList(this.trackingImpUrls);
        parcel.writeStringList(this.trackingClkUrls);
        parcel.writeInt(this.webviewLanding);
        parcel.writeStringList(this.trackingCloseUrls);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.backButtonEnabled);
    }

    public int getIcType() {
        return this.icType;
    }

    public void setIcType(int i) {
        this.icType = i;
    }

    public String getAdm() {
        return this.adm;
    }

    public void setAdm(String str) {
        this.adm = str;
    }

    public String getAdmImageTag() {
        return this.admImageTag;
    }

    public void setAdmImageTag(String str) {
        this.admImageTag = str;
    }

    public int getContentWidth() {
        return this.width;
    }

    public void setContentWidth(int i) {
        this.width = i;
    }

    public int getContentHeight() {
        return this.height;
    }

    public void setContentHeight(int i) {
        this.height = i;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getAnimationType() {
        return this.animationType;
    }

    public void setAnimationType(int i) {
        this.animationType = i;
    }

    public int getCloseButtonPosition() {
        return this.closeButtonPosition;
    }

    public void setCloseButtonPosition(int i) {
        this.closeButtonPosition = i;
    }

    public long getCloseButtonDelay() {
        return this.closeButtonDelay;
    }

    public void setCloseButtonDelay(long j) {
        this.closeButtonDelay = j;
    }

    public int getMonitoring() {
        return this.monitoring;
    }

    public void setMonitoring(int i) {
        this.monitoring = i;
    }

    public int getWebviewLoadingSkip() {
        return this.webviewLoadingSkip;
    }

    public void setWebviewLoadingSkip(int i) {
        this.webviewLoadingSkip = i;
    }

    public int getWebviewLanding() {
        return this.webviewLanding;
    }

    public void setWebviewLanding(int i) {
        this.webviewLanding = i;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public int getBackButtonEnabled() {
        return this.backButtonEnabled;
    }

    public void setBackButtonEnabled(int i) {
        this.backButtonEnabled = i;
    }

    public ArrayList<String> getTrackingImpUrls() {
        return this.trackingImpUrls;
    }

    public void setTrackingImpUrls(ArrayList<String> arrayList) {
        this.trackingImpUrls = arrayList;
    }

    public ArrayList<String> getTrackingClkUrls() {
        return this.trackingClkUrls;
    }

    public void setTrackingClkUrls(ArrayList<String> arrayList) {
        this.trackingClkUrls = arrayList;
    }

    public ArrayList<String> getTrackingCloseUrls() {
        return this.trackingCloseUrls;
    }

    public void setTrackingCloseUrls(ArrayList<String> arrayList) {
        this.trackingCloseUrls = arrayList;
    }
}
