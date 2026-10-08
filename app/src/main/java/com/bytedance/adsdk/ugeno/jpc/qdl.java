package com.bytedance.adsdk.ugeno.jpc;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class qdl implements Parcelable {
    private final Parcelable ud;
    public static final qdl qdl = new qdl() { // from class: com.bytedance.adsdk.ugeno.jpc.qdl.1
    };
    public static final Parcelable.Creator<qdl> CREATOR = new Parcelable.ClassLoaderCreator<qdl>() { // from class: com.bytedance.adsdk.ugeno.jpc.qdl.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public qdl createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public qdl createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) != null) {
                throw new IllegalStateException("superState must be null");
            }
            return qdl.qdl;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public qdl[] newArray(int i) {
            return new qdl[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private qdl() {
        this.ud = null;
    }

    protected qdl(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.ud = parcelable == qdl ? null : parcelable;
    }

    protected qdl(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.ud = parcelable == null ? qdl : parcelable;
    }

    public final Parcelable qdl() {
        return this.ud;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.ud, i);
    }
}
