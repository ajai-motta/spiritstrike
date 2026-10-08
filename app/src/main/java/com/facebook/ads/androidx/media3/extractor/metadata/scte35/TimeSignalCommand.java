package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.AnonymousClass53;
import com.facebook.ads.redexgen.core.C09724v;
import com.facebook.ads.redexgen.core.C1297Ic;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static String[] A02 = {"fBCCr7VwDgvhDxdGkzRiY2TvWvmZmARS", "lBD0fDkRFVdGPYWDbMcaGx4cyXv4WEJh", "6y4HJXgmtxqVkaNMzYZBmSXA6CGxm4DJ", "vpsLDrGqE5zherZQZMMLL6G3cLRsG8Dm", "qp0fDGr3Nzl8ahCuvet6k2311zos", "c5cBfT4Hj52dvZvyRqGaKhWxL68ft04u", "OtVyWYxYdMxR9geYu5t1Sc80NPuk", "8DkmlbSWSEaEI0nee1I51BPAFd"};
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new C1297Ic();
    public final long A00;
    public final long A01;

    public TimeSignalCommand(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
    }

    public /* synthetic */ TimeSignalCommand(long j, long j2, C1297Ic c1297Ic) {
        this(j, j2);
    }

    public static long A00(C09724v c09724v, long j) {
        long jA0I = c09724v.A0I();
        if ((128 & jA0I) == 0) {
            return C.TIME_UNSET;
        }
        long firstByte = c09724v.A0Q();
        long j2 = (((1 & jA0I) << 32) | firstByte) + j;
        if (A02[7].length() == 21) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[5] = "5vtaLYhnTEc2lUg08l0YEv2QqnnKhzp8";
        strArr[0] = "gGhCeZV4kOFdoFbuN1d60dh6MMvStMtQ";
        return j2 & 8589934591L;
    }

    public static TimeSignalCommand A01(C09724v c09724v, long j, AnonymousClass53 anonymousClass53) {
        long jA00 = A00(c09724v, j);
        return new TimeSignalCommand(jA00, anonymousClass53.A06(jA00));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
    }
}
