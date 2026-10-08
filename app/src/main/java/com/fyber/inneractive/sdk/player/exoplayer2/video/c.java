package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1483a;
    public final int b;
    public final int c;
    public final byte[] d;
    public int e;

    public c(int i, int i2, int i3, byte[] bArr) {
        this.f1483a = i;
        this.b = i2;
        this.c = i3;
        this.d = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (this.f1483a == cVar.f1483a && this.b == cVar.b && this.c == cVar.c && Arrays.equals(this.d, cVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.e == 0) {
            this.e = Arrays.hashCode(this.d) + ((((((this.f1483a + 527) * 31) + this.b) * 31) + this.c) * 31);
        }
        return this.e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(this.f1483a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d != null);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1483a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d != null ? 1 : 0);
        byte[] bArr = this.d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    public c(Parcel parcel) {
        this.f1483a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}
