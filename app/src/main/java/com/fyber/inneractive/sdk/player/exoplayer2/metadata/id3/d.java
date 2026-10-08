package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends o {
    public static final Parcelable.Creator<d> CREATOR = new c();
    public final byte[] b;

    public d(String str, byte[] bArr) {
        super(str);
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f1403a.equals(dVar.f1403a) && Arrays.equals(this.b, dVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) + ((this.f1403a.hashCode() + 527) * 31);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1403a);
        parcel.writeByteArray(this.b);
    }

    public d(Parcel parcel) {
        super(parcel.readString());
        this.b = parcel.createByteArray();
    }
}
