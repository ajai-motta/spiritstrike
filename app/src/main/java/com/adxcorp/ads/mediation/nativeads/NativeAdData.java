package com.adxcorp.ads.mediation.nativeads;

import android.os.Parcel;
import android.os.Parcelable;
import com.adxcorp.ads.mediation.common.AdData;
import com.adxcorp.ads.mediation.videoads.VideoAdData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdData extends AdData {
    public static final Parcelable.Creator<NativeAdData> CREATOR = new Parcelable.Creator<NativeAdData>() { // from class: com.adxcorp.ads.mediation.nativeads.NativeAdData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeAdData createFromParcel(Parcel parcel) {
            return new NativeAdData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NativeAdData[] newArray(int i) {
            return new NativeAdData[i];
        }
    };
    private int[] assetTypes;
    private String callToAction;
    private String description;
    private int icType;
    private int iconHeight;
    private String iconImageUrl;
    private int iconWidth;
    private String link;
    private int mainHeight;
    private String mainImageUrl;
    private int mainWidth;
    private int onlyClickCTA;
    private String optoutImageUrl;
    private String optoutLink;
    private double rating;
    private String title;
    private ArrayList<String> trackingClkUrls;
    private ArrayList<String> trackingImpUrls;
    private VideoAdData videoAdData;

    @Override // com.adxcorp.ads.mediation.common.AdData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NativeAdData() {
    }

    protected NativeAdData(Parcel parcel) {
        this.icType = parcel.readInt();
        this.assetTypes = parcel.createIntArray();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.iconImageUrl = parcel.readString();
        this.mainImageUrl = parcel.readString();
        this.callToAction = parcel.readString();
        this.rating = parcel.readDouble();
        this.iconWidth = parcel.readInt();
        this.iconHeight = parcel.readInt();
        this.mainWidth = parcel.readInt();
        this.mainHeight = parcel.readInt();
        this.link = parcel.readString();
        this.trackingImpUrls = parcel.createStringArrayList();
        this.trackingClkUrls = parcel.createStringArrayList();
        this.optoutImageUrl = parcel.readString();
        this.optoutLink = parcel.readString();
        this.videoAdData = (VideoAdData) parcel.readParcelable(VideoAdData.class.getClassLoader());
        this.onlyClickCTA = parcel.readInt();
    }

    @Override // com.adxcorp.ads.mediation.common.AdData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.icType);
        parcel.writeIntArray(this.assetTypes);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.iconImageUrl);
        parcel.writeString(this.mainImageUrl);
        parcel.writeString(this.callToAction);
        parcel.writeDouble(this.rating);
        parcel.writeInt(this.iconWidth);
        parcel.writeInt(this.iconHeight);
        parcel.writeInt(this.mainWidth);
        parcel.writeInt(this.mainHeight);
        parcel.writeString(this.link);
        parcel.writeStringList(this.trackingImpUrls);
        parcel.writeStringList(this.trackingClkUrls);
        parcel.writeString(this.optoutImageUrl);
        parcel.writeString(this.optoutLink);
        parcel.writeParcelable(this.videoAdData, i);
        parcel.writeInt(this.onlyClickCTA);
    }

    @Override // com.adxcorp.ads.mediation.common.AdData
    public int getIcType() {
        return this.icType;
    }

    @Override // com.adxcorp.ads.mediation.common.AdData
    public void setIcType(int i) {
        this.icType = i;
    }

    public int[] getAssetTypes() {
        return this.assetTypes;
    }

    public void setAssetTypes(int[] iArr) {
        this.assetTypes = iArr;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getIconImageUrl() {
        return this.iconImageUrl;
    }

    public void setIconImageUrl(String str) {
        this.iconImageUrl = str;
    }

    public String getMainImageUrl() {
        return this.mainImageUrl;
    }

    public void setMainImageUrl(String str) {
        this.mainImageUrl = str;
    }

    public String getCallToAction() {
        return this.callToAction;
    }

    public void setCallToAction(String str) {
        this.callToAction = str;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double d) {
        this.rating = d;
    }

    public int getIconWidth() {
        return this.iconWidth;
    }

    public void setIconWidth(int i) {
        this.iconWidth = i;
    }

    public int getIconHeight() {
        return this.iconHeight;
    }

    public void setIconHeight(int i) {
        this.iconHeight = i;
    }

    public int getMainWidth() {
        return this.mainWidth;
    }

    public void setMainWidth(int i) {
        this.mainWidth = i;
    }

    public int getMainHeight() {
        return this.mainHeight;
    }

    public void setMainHeight(int i) {
        this.mainHeight = i;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    @Override // com.adxcorp.ads.mediation.common.AdData
    public ArrayList<String> getTrackingImpUrls() {
        return this.trackingImpUrls;
    }

    @Override // com.adxcorp.ads.mediation.common.AdData
    public void setTrackingImpUrls(ArrayList<String> arrayList) {
        this.trackingImpUrls = arrayList;
    }

    @Override // com.adxcorp.ads.mediation.common.AdData
    public ArrayList<String> getTrackingClkUrls() {
        return this.trackingClkUrls;
    }

    @Override // com.adxcorp.ads.mediation.common.AdData
    public void setTrackingClkUrls(ArrayList<String> arrayList) {
        this.trackingClkUrls = arrayList;
    }

    public String getOptoutImageUrl() {
        return this.optoutImageUrl;
    }

    public void setOptoutImageUrl(String str) {
        this.optoutImageUrl = str;
    }

    public String getOptoutLink() {
        return this.optoutLink;
    }

    public void setOptoutLink(String str) {
        this.optoutLink = str;
    }

    public VideoAdData getVideoAdData() {
        return this.videoAdData;
    }

    public void setVideoAdData(VideoAdData videoAdData) {
        this.videoAdData = videoAdData;
    }

    public int getOnlyClickCTA() {
        return this.onlyClickCTA;
    }

    public void setOnlyClickCTA(int i) {
        this.onlyClickCTA = i;
    }
}
