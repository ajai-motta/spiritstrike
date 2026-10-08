package com.facebook.ads.androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.C5C;
import com.facebook.ads.redexgen.core.ID;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class GeobFrame extends Id3Frame {
    public static byte[] A04;
    public static String[] A05 = {"ORThrcUDJ8oSWKnVQcP1uIGpcR", "uxmFmJC1LwPq1ifvsUVY6A58XUxn", "tgzXw0", "3YcwGpAqsC36LlJyS", "bWi6NBg7EuEHzXqjFfskJtL267SBWFe", "P49DRZyRWhn5lVJGsfOn1rO7sNGr7nlu", "aaseJjWnl2zrNSL329JSGdGKj2FyDGUc", "EYKDzopnaqy6"};
    public static final Parcelable.Creator<GeobFrame> CREATOR;
    public final String A00;
    public final String A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[4].length() == 15) {
                throw new RuntimeException();
            }
            A05[1] = "xm9FRjRm82kK4gS3u270gaYNqume";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 80);
            i4++;
        }
    }

    public static void A01() {
        A04 = new byte[]{92, 80, Ascii.DC4, Ascii.NAK, 3, 19, 2, Ascii.EM, 0, 4, Ascii.EM, Ascii.US, Ascii.RS, 77, 117, 121, 63, 48, 53, 60, 55, 56, 52, 60, 100, 78, 84, Ascii.EM, Ascii.GS, Ascii.EM, 17, 32, Ascii.CR, 4, 17, 73, 60, 62, 52, 57};
    }

    static {
        A01();
        CREATOR = new ID();
    }

    public GeobFrame(Parcel parcel) {
        super(A00(36, 4, 43));
        this.A02 = (String) C5C.A0f(parcel.readString());
        this.A01 = (String) C5C.A0f(parcel.readString());
        this.A00 = (String) C5C.A0f(parcel.readString());
        this.A03 = (byte[]) C5C.A0f(parcel.createByteArray());
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(A00(36, 4, 43));
        this.A02 = str;
        this.A01 = str2;
        this.A00 = str3;
        this.A03 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (C5C.A1E(this.A02, geobFrame.A02) && C5C.A1E(this.A01, geobFrame.A01)) {
            String str = this.A00;
            String str2 = geobFrame.A00;
            if (A05[4].length() == 15) {
                throw new RuntimeException();
            }
            A05[1] = "HEIn71RMT8F4EhFByQAG1BwlOeNZ";
            if (C5C.A1E(str, str2) && Arrays.equals(this.A03, geobFrame.A03)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int hashCode() {
        /*
            r6 = this;
            r0 = 17
            int r4 = r0 * 31
            java.lang.String r0 = r6.A02
            r5 = 0
            if (r0 == 0) goto L1e
            java.lang.String r3 = r6.A02
            java.lang.String[] r1 = com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 28
            if (r1 == r0) goto L20
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1e:
            r0 = 0
            goto L2b
        L20:
            java.lang.String[] r2 = com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05
            java.lang.String r1 = "jAIu8v1143XL"
            r0 = 7
            r2[r0] = r1
            int r0 = r3.hashCode()
        L2b:
            int r4 = r4 + r0
            int r1 = r4 * 31
            java.lang.String r0 = r6.A01
            if (r0 == 0) goto L8d
            java.lang.String r0 = r6.A01
            int r0 = r0.hashCode()
        L38:
            int r1 = r1 + r0
            int r4 = r1 * 31
            java.lang.String[] r1 = com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 7
            if (r1 == r0) goto L88
            java.lang.String[] r2 = com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05
            java.lang.String r1 = "5ETNk8FDhPWD3cLm"
            r0 = 3
            r2[r0] = r1
            java.lang.String r0 = r6.A00
            if (r0 == 0) goto L71
        L52:
            java.lang.String r3 = r6.A00
            java.lang.String[] r2 = com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05
            r0 = 2
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L7c
            java.lang.String[] r2 = com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05
            java.lang.String r1 = "kmHBQ6UCcTgjP77v2ijZb3Aa"
            r0 = 3
            r2[r0] = r1
            int r5 = r3.hashCode()
        L71:
            int r4 = r4 + r5
            int r1 = r4 * 31
            byte[] r0 = r6.A03
            int r0 = java.util.Arrays.hashCode(r0)
            int r1 = r1 + r0
            return r1
        L7c:
            java.lang.String[] r2 = com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05
            java.lang.String r1 = "wEfpGayZOaM"
            r0 = 7
            r2[r0] = r1
            int r5 = r3.hashCode()
            goto L71
        L88:
            java.lang.String r0 = r6.A00
            if (r0 == 0) goto L71
            goto L52
        L8d:
            r0 = 0
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.hashCode():int");
    }

    @Override // com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(25, 11, 36) + this.A02 + A00(14, 11, 9) + this.A01 + A00(0, 14, 32) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A02);
        parcel.writeString(this.A01);
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A03);
    }
}
