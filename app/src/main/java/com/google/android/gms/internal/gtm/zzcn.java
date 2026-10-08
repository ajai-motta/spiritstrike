package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcn implements Parcelable.Creator {
    zzcn() {
    }

    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzco(parcel);
    }

    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzco[i];
    }
}
