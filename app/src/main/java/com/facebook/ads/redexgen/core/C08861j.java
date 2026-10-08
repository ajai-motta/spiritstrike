package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C08861j extends AQ {
    public static byte[] A04;
    public static String[] A05 = {"EpUFNdKyF", "ElnVCWkanZ28CNZmVbXI8Cgdfk8l0", "X39VUuGfeiZ7XA2vCr", "EABpQNGHZAa4ZPAJBF04BZM7WLurFTC9", "chwMXTauvlPIh4ZEXg6aw7fxDLbtX6Fs", "XZGBORnRKKQlpHrvvOBFjnqbRPoZpqW4", "uC2aRCtD", "rZqfEylCjzpizgmEVXgae15ipmvYBT3W"};
    public long A00;
    public Uri A01;
    public RandomAccessFile A02;
    public boolean A03;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 66);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {99, 108, 105, 96, 86, 119, 102, 87, 96, 100, 97, 74, 117, 96, 107, 111, 96, 101, 108, 90, 123, 106, 91, 108, 104, 109, 91, 72, 79, 47, 36, 35, 56, 113, 57, 48, 34, 113, 32, 36, 52, 35, 40, 113, 48, 63, 53, 126, 62, 35, 113, 55, 35, 48, 54, 60, 52, 63, 37, 125, 113, 38, 57, 56, 50, 57, 113, 48, 35, 52, 113, 63, 62, 37, 113, 34, 36, 33, 33, 62, 35, 37, 52, 53, 127, 113, Ascii.NAK, 56, 53, 113, 40, 62, 36, 113, 50, 48, Base64.padSymbol, Base64.padSymbol, 113, 4, 35, 56, 127, 33, 48, 35, 34, 52, 121, 120, 113, 62, 63, 113, 48, 113, 34, 37, 35, 56, 63, 54, 113, 50, 62, 63, 37, 48, 56, 63, 56, 63, 54, 113, 118, 110, 118, 113, 62, 35, 113, 118, 114, 118, 110, 113, 4, 34, 52, 113, 4, 35, 56, 127, 55, 35, 62, 60, Ascii.ETB, 56, Base64.padSymbol, 52, 121, 63, 52, 38, 113, Ascii.ETB, 56, Base64.padSymbol, 52, 121, 33, 48, 37, 57, 120, 120, 113, 37, 62, 113, 48, 39, 62, 56, 53, 113, 37, 57, 56, 34, 127, 113, 33, 48, 37, 57, 108, 116, 34, 125, 32, 36, 52, 35, 40, 108, 116, 34, 125, 55, 35, 48, 54, 60, 52, 63, 37, 108, 116, 34};
        String[] strArr = A05;
        if (strArr[0].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[3] = "X0VoZl0WlZuonvRnqv5GR18rztIlLTBl";
        strArr2[7] = "XOIDFuTAWw0P55lYRHi5z3HfEt22MTH0";
        A04 = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    @MetaExoPlayerCustomization("FB tracing added in D4783963 for calls to TraceUtil.beginSection and TraceUtil.endSection")
    public final long AGi(C09855i c09855i) throws C2656pA {
        AnonymousClass54.A02(A01(0, 15, 71));
        Uri uri = c09855i.A06;
        this.A01 = uri;
        A0G(c09855i);
        this.A02 = A00(uri);
        try {
            try {
                this.A02.seek(c09855i.A04);
                this.A00 = c09855i.A03 == -1 ? this.A02.length() - c09855i.A04 : c09855i.A03;
                AnonymousClass54.A00();
                if (this.A00 < 0) {
                    throw new C2656pA(null, null, 2008);
                }
                this.A03 = true;
                A0H(c09855i);
                long j = this.A00;
                if (A05[1].length() == 32) {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[0] = "xa7zJISj9";
                strArr[2] = "YSvWE2PgVF009LXgrm";
                return j;
            } catch (IOException e) {
                throw new C2656pA(e, 2000);
            }
        } catch (Throwable th) {
            AnonymousClass54.A00();
            throw th;
        }
    }

    static {
        A02();
    }

    public C08861j() {
        super(false);
    }

    public static RandomAccessFile A00(Uri uri) throws C2656pA {
        try {
            return new RandomAccessFile((String) AbstractC09493y.A01(uri.getPath()), A01(29, 1, 31));
        } catch (FileNotFoundException e) {
            boolean zIsEmpty = TextUtils.isEmpty(uri.getQuery());
            String[] strArr = A05;
            if (strArr[3].charAt(29) != strArr[7].charAt(29)) {
                throw new RuntimeException();
            }
            A05[1] = "uF4";
            if (zIsEmpty && TextUtils.isEmpty(uri.getFragment())) {
                throw new C2656pA(e, (C5C.A02 < 21 || !C09875k.A00(e.getCause())) ? PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND : 2006);
            }
            throw new C2656pA(String.format(A01(30, PsExtractor.AUDIO_STREAM, 19), uri.getPath(), uri.getQuery(), uri.getFragment()), e, 1004);
        } catch (SecurityException e2) {
            throw new C2656pA(e2, 2006);
        } catch (RuntimeException e3) {
            throw new C2656pA(e3, 2000);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final Uri A9P() {
        return this.A01;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws com.facebook.ads.redexgen.core.C2656pA {
        /*
            r6 = this;
            r4 = 0
            r6.A01 = r4
            r3 = 0
            java.io.RandomAccessFile r0 = r6.A02     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L46
            if (r0 == 0) goto Ld
            java.io.RandomAccessFile r0 = r6.A02     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L46
            r0.close()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L46
        Ld:
            r6.A02 = r4
            boolean r4 = r6.A03
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08861j.A05
            r0 = 0
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L37
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08861j.A05
            java.lang.String r1 = "OaGc5WGUg2QUkWgGCbKJpnMVI4k73TqR"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "7y85lWdOal5lz5BxO7mJ0PPL1NIIxTrt"
            r0 = 7
            r2[r0] = r1
            if (r4 == 0) goto L36
            r6.A03 = r3
            r6.A0E()
        L36:
            return
        L37:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3d:
            r2 = move-exception
            r1 = 2000(0x7d0, float:2.803E-42)
            com.facebook.ads.redexgen.X.pA r0 = new com.facebook.ads.redexgen.X.pA     // Catch: java.lang.Throwable -> L46
            r0.<init>(r2, r1)     // Catch: java.lang.Throwable -> L46
            throw r0     // Catch: java.lang.Throwable -> L46
        L46:
            r5 = move-exception
            r6.A02 = r4
            boolean r4 = r6.A03
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08861j.A05
            r0 = 3
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 29
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L73
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08861j.A05
            java.lang.String r1 = "Vm3YcALUN"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "c4edS4Kr4EVyTdnKAl"
            r0 = 2
            r2[r0] = r1
            if (r4 == 0) goto L72
        L6d:
            r6.A03 = r3
            r6.A0E()
        L72:
            throw r5
        L73:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C08861j.A05
            java.lang.String r1 = "xGGiO6aoc87d3bdrOM0514KxVU6xxq2z"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "rL55lenIs2jXGgYduJCww9Rx5eQkWv1P"
            r0 = 4
            r2[r0] = r1
            if (r4 == 0) goto L72
            goto L6d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C08861j.close():void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09052c
    @MetaExoPlayerCustomization("FB tracing added in D4783963 for calls to TraceUtil.beginSection and TraceUtil.endSection")
    public final int read(byte[] bArr, int i, int i2) throws C2656pA {
        if (i2 == 0) {
            return 0;
        }
        try {
            if (this.A00 == 0) {
                return -1;
            }
            try {
                AnonymousClass54.A02(A01(15, 14, 75));
                int i3 = ((RandomAccessFile) C5C.A0f(this.A02)).read(bArr, i, (int) Math.min(this.A00, i2));
                if (i3 > 0) {
                    this.A00 -= (long) i3;
                    A0F(i3);
                }
                return i3;
            } catch (IOException e) {
                throw new C2656pA(e, 2000);
            }
        } finally {
            AnonymousClass54.A00();
        }
    }
}
