package com.fyber.inneractive.sdk.player.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o[] f1400a;

    public b(ArrayList arrayList) {
        o[] oVarArr = new o[arrayList.size()];
        this.f1400a = oVarArr;
        arrayList.toArray(oVarArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f1400a, ((b) obj).f1400a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1400a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1400a.length);
        for (o oVar : this.f1400a) {
            parcel.writeParcelable(oVar, 0);
        }
    }

    public b(Parcel parcel) {
        this.f1400a = new o[parcel.readInt()];
        int i = 0;
        while (true) {
            o[] oVarArr = this.f1400a;
            if (i >= oVarArr.length) {
                return;
            }
            oVarArr[i] = (o) parcel.readParcelable(o.class.getClassLoader());
            i++;
        }
    }
}
