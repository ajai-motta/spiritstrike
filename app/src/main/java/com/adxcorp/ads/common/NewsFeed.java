package com.adxcorp.ads.common;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class NewsFeed implements Parcelable {
    public static final Parcelable.Creator<NewsFeed> CREATOR = new Parcelable.Creator<NewsFeed>() { // from class: com.adxcorp.ads.common.NewsFeed.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsFeed createFromParcel(Parcel parcel) {
            return new NewsFeed(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NewsFeed[] newArray(int i) {
            return new NewsFeed[i];
        }
    };
    private String link;
    private String title;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NewsFeed() {
    }

    protected NewsFeed(Parcel parcel) {
        this.title = parcel.readString();
        this.link = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.link);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String toString() {
        return "NewsFeed{title='" + this.title + "', link='" + this.link + "'}";
    }
}
