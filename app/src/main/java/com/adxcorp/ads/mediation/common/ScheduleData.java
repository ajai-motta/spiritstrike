package com.adxcorp.ads.mediation.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ScheduleData implements Parcelable {
    public static final Parcelable.Creator<ScheduleData> CREATOR = new Parcelable.Creator<ScheduleData>() { // from class: com.adxcorp.ads.mediation.common.ScheduleData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScheduleData createFromParcel(Parcel parcel) {
            return new ScheduleData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScheduleData[] newArray(int i) {
            return new ScheduleData[i];
        }
    };
    private String classData;
    private String className;
    private ArrayList<String> trackingClkUrls;
    private ArrayList<String> trackingImpUrls;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ScheduleData() {
    }

    protected ScheduleData(Parcel parcel) {
        this.className = parcel.readString();
        this.classData = parcel.readString();
        this.trackingImpUrls = parcel.createStringArrayList();
        this.trackingClkUrls = parcel.createStringArrayList();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.className);
        parcel.writeString(this.classData);
        parcel.writeStringList(this.trackingImpUrls);
        parcel.writeStringList(this.trackingClkUrls);
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public String getClassData() {
        return this.classData;
    }

    public void setClassData(String str) {
        this.classData = str;
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
}
