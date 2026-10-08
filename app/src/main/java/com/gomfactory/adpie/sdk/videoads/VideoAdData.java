package com.gomfactory.adpie.sdk.videoads;

import android.os.Parcel;
import android.os.Parcelable;
import com.gomfactory.adpie.sdk.common.AdData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class VideoAdData extends AdData {
    public static final Parcelable.Creator<VideoAdData> CREATOR = new Parcelable.Creator<VideoAdData>() { // from class: com.gomfactory.adpie.sdk.videoads.VideoAdData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoAdData createFromParcel(Parcel parcel) {
            return new VideoAdData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoAdData[] newArray(int i) {
            return new VideoAdData[i];
        }
    };
    private boolean autoPlay;
    private int backButtonEnabled;
    private int contentHeight;
    private int contentWidth;
    private int delivery;
    private String description;
    private int duration;
    private ArrayList<EndCardData> endCardData;
    private int icType;
    private String link;
    private String linkText;
    private String optoutImageUrl;
    private String optoutLink;
    private int orientation;
    private int skipOffset;
    private String ssvUrl;
    private String title;
    private ArrayList<String> trackingClkUrls;
    private ArrayList<String> trackingCompleteUrls;
    private ArrayList<String> trackingFirstQuartileUrls;
    private ArrayList<String> trackingImpUrls;
    private ArrayList<String> trackingMidpointUrls;
    private ArrayList<String> trackingStartUrls;
    private ArrayList<String> trackingThirdQuartileUrls;
    private String videoContent;
    private String videoContentType;

    @Override // com.gomfactory.adpie.sdk.common.AdData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VideoAdData() {
    }

    protected VideoAdData(Parcel parcel) {
        this.icType = parcel.readInt();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.skipOffset = parcel.readInt();
        this.duration = parcel.readInt();
        this.link = parcel.readString();
        this.linkText = parcel.readString();
        this.videoContent = parcel.readString();
        this.videoContentType = parcel.readString();
        this.delivery = parcel.readInt();
        this.contentWidth = parcel.readInt();
        this.contentHeight = parcel.readInt();
        this.autoPlay = parcel.readInt() != 0;
        this.trackingStartUrls = parcel.createStringArrayList();
        this.trackingFirstQuartileUrls = parcel.createStringArrayList();
        this.trackingMidpointUrls = parcel.createStringArrayList();
        this.trackingThirdQuartileUrls = parcel.createStringArrayList();
        this.trackingCompleteUrls = parcel.createStringArrayList();
        this.trackingImpUrls = parcel.createStringArrayList();
        this.trackingClkUrls = parcel.createStringArrayList();
        this.ssvUrl = parcel.readString();
        this.optoutImageUrl = parcel.readString();
        this.optoutLink = parcel.readString();
        this.orientation = parcel.readInt();
        this.backButtonEnabled = parcel.readInt();
        this.endCardData = parcel.createTypedArrayList(EndCardData.CREATOR);
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.icType);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeInt(this.skipOffset);
        parcel.writeInt(this.duration);
        parcel.writeString(this.link);
        parcel.writeString(this.linkText);
        parcel.writeString(this.videoContent);
        parcel.writeString(this.videoContentType);
        parcel.writeInt(this.delivery);
        parcel.writeInt(this.contentWidth);
        parcel.writeInt(this.contentHeight);
        parcel.writeInt(this.autoPlay ? 1 : 0);
        parcel.writeStringList(this.trackingStartUrls);
        parcel.writeStringList(this.trackingFirstQuartileUrls);
        parcel.writeStringList(this.trackingMidpointUrls);
        parcel.writeStringList(this.trackingThirdQuartileUrls);
        parcel.writeStringList(this.trackingCompleteUrls);
        parcel.writeStringList(this.trackingImpUrls);
        parcel.writeStringList(this.trackingClkUrls);
        parcel.writeString(this.ssvUrl);
        parcel.writeString(this.optoutImageUrl);
        parcel.writeString(this.optoutLink);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.backButtonEnabled);
        parcel.writeTypedList(this.endCardData);
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public int getIcType() {
        return this.icType;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public void setIcType(int i) {
        this.icType = i;
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

    public int getSkipOffset() {
        return this.skipOffset;
    }

    public void setSkipOffset(int i) {
        this.skipOffset = i;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getLinkText() {
        return this.linkText;
    }

    public void setLinkText(String str) {
        this.linkText = str;
    }

    public String getVideoContent() {
        return this.videoContent;
    }

    public void setVideoContent(String str) {
        this.videoContent = str;
    }

    public String getVideoContentType() {
        return this.videoContentType;
    }

    public void setVideoContentType(String str) {
        this.videoContentType = str;
    }

    public int getDelivery() {
        return this.delivery;
    }

    public void setDelivery(int i) {
        this.delivery = i;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public int getContentWidth() {
        return this.contentWidth;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public void setContentWidth(int i) {
        this.contentWidth = i;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public int getContentHeight() {
        return this.contentHeight;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public void setContentHeight(int i) {
        this.contentHeight = i;
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public ArrayList<String> getTrackingStartUrls() {
        return this.trackingStartUrls;
    }

    public void setTrackingStartUrls(ArrayList<String> arrayList) {
        this.trackingStartUrls = arrayList;
    }

    public ArrayList<String> getTrackingFirstQuartileUrls() {
        return this.trackingFirstQuartileUrls;
    }

    public void setTrackingFirstQuartileUrls(ArrayList<String> arrayList) {
        this.trackingFirstQuartileUrls = arrayList;
    }

    public ArrayList<String> getTrackingMidpointUrls() {
        return this.trackingMidpointUrls;
    }

    public void setTrackingMidpointUrls(ArrayList<String> arrayList) {
        this.trackingMidpointUrls = arrayList;
    }

    public ArrayList<String> getTrackingThirdQuartileUrls() {
        return this.trackingThirdQuartileUrls;
    }

    public void setTrackingThirdQuartileUrls(ArrayList<String> arrayList) {
        this.trackingThirdQuartileUrls = arrayList;
    }

    public ArrayList<String> getTrackingCompleteUrls() {
        return this.trackingCompleteUrls;
    }

    public void setTrackingCompleteUrls(ArrayList<String> arrayList) {
        this.trackingCompleteUrls = arrayList;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public ArrayList<String> getTrackingImpUrls() {
        return this.trackingImpUrls;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public void setTrackingImpUrls(ArrayList<String> arrayList) {
        this.trackingImpUrls = arrayList;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public ArrayList<String> getTrackingClkUrls() {
        return this.trackingClkUrls;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public void setTrackingClkUrls(ArrayList<String> arrayList) {
        this.trackingClkUrls = arrayList;
    }

    public String getSsvUrl() {
        return this.ssvUrl;
    }

    public void setSsvUrl(String str) {
        this.ssvUrl = str;
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

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public int getOrientation() {
        return this.orientation;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public void setOrientation(int i) {
        this.orientation = i;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public int getBackButtonEnabled() {
        return this.backButtonEnabled;
    }

    @Override // com.gomfactory.adpie.sdk.common.AdData
    public void setBackButtonEnabled(int i) {
        this.backButtonEnabled = i;
    }

    public ArrayList<EndCardData> getEndCardData() {
        return this.endCardData;
    }

    public void setEndCardData(ArrayList<EndCardData> arrayList) {
        this.endCardData = arrayList;
    }
}
