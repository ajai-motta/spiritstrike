package com.gomfactory.adpie.sdk.videoads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class EndCardData implements Parcelable {
    public static final Parcelable.Creator<EndCardData> CREATOR = new Parcelable.Creator<EndCardData>() { // from class: com.gomfactory.adpie.sdk.videoads.EndCardData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EndCardData createFromParcel(Parcel parcel) {
            return new EndCardData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EndCardData[] newArray(int i) {
            return new EndCardData[i];
        }
    };
    private String clickThrough;
    private ArrayList<String> clickTracking;
    private ArrayList<String> creativeView;
    private int height;
    private String resource;
    private int resourceType;
    private int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public EndCardData() {
    }

    protected EndCardData(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.resourceType = parcel.readInt();
        this.resource = parcel.readString();
        this.clickThrough = parcel.readString();
        this.creativeView = parcel.createStringArrayList();
        this.clickTracking = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.resourceType);
        parcel.writeString(this.resource);
        parcel.writeString(this.clickThrough);
        parcel.writeStringList(this.creativeView);
        parcel.writeStringList(this.clickTracking);
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(int i) {
        this.resourceType = i;
    }

    public String getResource() {
        return this.resource;
    }

    public void setResource(String str) {
        this.resource = str;
    }

    public String getClickThrough() {
        return this.clickThrough;
    }

    public void setClickThrough(String str) {
        this.clickThrough = str;
    }

    public ArrayList<String> getCreativeView() {
        return this.creativeView;
    }

    public void setCreativeView(ArrayList<String> arrayList) {
        this.creativeView = arrayList;
    }

    public ArrayList<String> getClickTracking() {
        return this.clickTracking;
    }

    public void setClickTracking(ArrayList<String> arrayList) {
        this.clickTracking = arrayList;
    }
}
