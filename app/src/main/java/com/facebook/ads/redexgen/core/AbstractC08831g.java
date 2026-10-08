package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC08831g extends AE {
    public static byte[] A11;
    public static String[] A12 = {"nx3Y", "ySV9u0UlUifM8l7YXQ9XliwCignJM927", "I56UD3cYRclrpAgGGb6MtOKCjcs9cL2j", "Sm2NURaNWtDVUJWNcAo7ERDS0hDt7", "bHPfo4AgOQoRvyPk4FB0ks", "XoiyS7TBeS4mt", "Z3oSrtXzlmftA", "iDWmG7Cddc7JoXPcHC9pChUfA3XnAJjW"};
    public static final byte[] A13;
    public float A00;
    public float A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public MediaFormat A0C;
    public InterfaceC10919s A0D;
    public InterfaceC10919s A0E;
    public B0 A0F;
    public B3 A0G;
    public BA A0H;
    public BC A0I;
    public String A0J;
    public ByteBuffer A0K;
    public ArrayDeque<B3> A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public boolean A0e;

    @MetaExoPlayerCustomization("Potentially can be removed. Added in D36797879")
    public long A0f;
    public C2725qI A0g;
    public C6I A0h;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D57514060: Do not added Dav1dMediaCodecInfo to the list of MediaCodecInfos if it's already added, can be cleaned up after launch")
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public final int A0l;
    public final int A0m;
    public final MediaCodec.BufferInfo A0n;
    public final C2646p0 A0o;
    public final C2646p0 A0p;
    public final C10286z A0q;
    public final A6 A0r;
    public final BT A0s;
    public final ArrayDeque<BC> A0t;
    public final List<Long> A0u;
    public final boolean A0v;
    public final boolean A0w;
    public final boolean A0x;
    public final MediaCodecRendererMetaParameters A0y;
    public final C2321jQ A0z;

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "D60404164: Merge init calls in the renderer")
    public final boolean A10;

    public static String A0x(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A11, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A15() {
        A11 = new byte[]{-74, -86, -20, -1, -2, -86, -8, -7, -86, -3, -17, -19, -1, -4, -17, -86, -18, -17, -19, -7, -18, -17, -4, -86, -21, 0, -21, -13, -10, -21, -20, -10, -17, -72, -86, -34, -4, 3, -13, -8, -15, -86, -2, -7, -86, -6, -4, -7, -19, -17, -17, -18, -86, 1, -13, -2, -14, -86, -110, -120, -87, -89, -77, -88, -87, -74, 100, -83, -78, -83, -72, -83, -91, -80, -83, -66, -91, -72, -83, -77, -78, 100, -86, -91, -83, -80, -87, -88, 112, 100, -74, -87, -72, -74, -67, -25, 8, Ascii.DC4, Ascii.CAN, 8, Ascii.CAN, 8, -61, 9, 4, Ascii.FF, Ascii.SI, 8, 7, -49, -61, Ascii.NAK, 8, Ascii.ETB, Ascii.NAK, Ascii.FS, -22, Ascii.CAN, 19, -58, Ascii.EM, Ascii.VT, Ascii.EM, Ascii.EM, Ascii.SI, Ascii.NAK, Ascii.DC4, -58, Ascii.CAN, Ascii.VT, Ascii.ETB, Ascii.ESC, Ascii.SI, Ascii.CAN, Ascii.VT, Ascii.EM, -58, Ascii.EM, Ascii.VT, 9, Ascii.ESC, Ascii.CAN, Ascii.VT, -58, 10, Ascii.VT, 9, Ascii.NAK, 10, Ascii.VT, Ascii.CAN, -58, Ascii.FF, Ascii.NAK, Ascii.CAN, -58, -103, -76, -68, -65, -72, -73, 115, -57, -62, 115, -68, -63, -68, -57, -68, -76, -65, -68, -51, -72, 115, -73, -72, -74, -62, -73, -72, -59, -115, 115, -113, -89, -90, -85, -93, 98, -76, -89, -77, -73, -85, -76, -89, -75, 98, -93, 98, -122, -76, -81, -107, -89, -75, -75, -85, -79, -80, -113, -93, -80, -93, -87, -89, -76, -47, -23, -24, -19, -27, -57, -13, -24, -23, -25, -42, -23, -14, -24, -23, -10, -23, -10, -78, -80, -69, -111, -88, -37, -36, -47, -46, -42, -111, -60, -39, -58, -111, -57, -56, -58, -23, -25, -14, -56, -33, Ascii.DC2, 19, 8, 9, Ascii.CR, -56, -5, Ascii.DLE, -3, -56, -2, -1, -3, -56, Ascii.CR, -1, -3, Ascii.SI, Ascii.FF, -1, -79, -81, -70, -112, -81, -74, -83, -112, -93, -73, -90, -85, -79, -112, -90, -89, -91, -79, -90, -89, -76, -112, -81, -78, -107, -90, -92, -81, -123, -92, -85, -94, -123, -83, -96, -101, -100, -90, -123, -101, -100, -102, -90, -101, -100, -87, -123, -104, -83, -102, -83, -85, -74, -116, -84, -44, -57, -62, -57, -65, -116, -58, -112, -108, -110, -116, -62, -61, -63, -51, -62, -61, -103, -105, -94, 120, -104, -64, -77, -82, -77, -85, 120, -78, 124, -128, 126, 120, -82, -81, -83, -71, -82, -81, 120, -67, -81, -83, -65, -68, -81, -44, -46, -35, -77, -40, -54, -56, -77, -26, -5, -24, -77, -23, -22, -24, -35, -37, -26, -68, -31, -45, -47, -68, -17, 4, -15, -68, -14, -13, -15, -68, 1, -13, -15, 3, 0, -13, -56, -58, -47, -89, -38, -27, -27, -16, -30, -25, -25, -34, -21, -89, -17, -30, -35, -34, -24, -89, -35, -34, -36, -24, -35, -34, -21, -89, -38, -17, -36, -53, -55, -44, -86, -35, -23, -24, -21, -29, -27, -33, -86, -35, -14, -33, -86, -32, -31, -33, -21, -32, -31, -18, -86, -35, -13, -31, -17, -21, -23, -31, Ascii.CR, Ascii.VT, Ascii.SYN, -20, Ascii.US, 43, 42, 45, 37, 39, 33, -20, Ascii.US, 52, 33, -20, 34, 35, 33, 45, 34, 35, 48, -20, Ascii.US, 53, 35, 49, 45, 43, 35, -20, 49, 35, 33, 51, 48, 35, -71, -73, -62, -104, -47, -39, -39, -47, -42, -49, -104, -53, -53, -51, -104, -50, -49, -51, -39, -50, -49, -36, 4, 2, Ascii.CR, -29, Ascii.FS, 36, 36, Ascii.FS, 33, Ascii.SUB, -29, 43, 36, 39, Ascii.ETB, Ascii.RS, 40, -29, Ascii.EM, Ascii.SUB, Ascii.CAN, 36, Ascii.EM, Ascii.SUB, 39, Ascii.SI, Ascii.CR, Ascii.CAN, -18, 50, 43, -18, 54, 41, 36, 37, 47, Ascii.US, 36, 37, 35, 47, 36, 37, 50, -18, 33, 54, 35, -73, -39, -52, -51, -52, -39, -39, -52, -53, -121, -53, -52, -54, -42, -53, -52, -39, -121, -48, -43, -38, -37, -56, -43, -37, -48, -56, -37, -48, -42, -43, -121, -51, -56, -48, -45, -52, -53, -107, -121, -70, -45, -52, -52, -41, -48, -43, -50, -121, -37, -49, -52, -43, -121, -39, -52, -37, -39, -32, -48, -43, -50, -107, 7, 1, -31, -11, -23, -27, -28, Ascii.SI, 9, -23, -3, -15, -18, -20, Ascii.DLE, 10, -22, 4, -11, -19, -19, -104, -110, 114, -113, 124, 117, 117, 0, -6, -38, 1, -30, -27, -30, -79, -74, -81, -68, -68, -77, -70, 123, -79, -67, -61, -68, -62, -76, -64, -65, -73, -70, -72, -58, -61, -74, -108, -64, -75, -74, -76, -44, -29, -42, -46, -27, -42, -76, -32, -43, -42, -44, -85, -75, -61, -78, -70, -65, -110, -65, -75, -105, -74, -74, -75, -82, -76, -73, -67, -74, -84, -83, -70, -13, -7, -4, 2, -5, -15, -14, -1, -20, -7, 1, -14, -49, -51, -36, -65, -38, -55, -40, -40, -51, -52, -75, -51, -52, -47, -55, -85, -38, -31, -40, -36, -41, -49, -38, -41, -35, -40, -51, -38, Ascii.SI, 9, -39, -41, -41, -41, -16, -19, -15, -17, -16, -4, -63, -71, -56, -75, -126, -72, -75, -54, -123, -72, -126, -75, -54, -123, -126, -72, -71, -73, -61, -72, -71, -58, 38, 39, Ascii.DC4, 37, 39, -10, 34, Ascii.ETB, Ascii.CAN, Ascii.SYN, -42, -53, -50, -61, -46, -53, -61, Ascii.DLE, 3, -2, -1, 9, -55, -5, Ascii.DLE, -54, -53, Ascii.GS, Ascii.DLE, Ascii.VT, Ascii.FF, Ascii.SYN, -42, Ascii.VT, Ascii.SYN, 19, 9, 32, -44, Ascii.GS, Ascii.DLE, Ascii.SUB, Ascii.DLE, Ascii.SYN, Ascii.NAK, 9, -5, -10, 6, -6};
    }

    public abstract int A1g(B0 b0, B3 b3, C2725qI c2725qI, C2725qI c2725qI2);

    public abstract int A1h(BT bt, A6 a6, C2725qI c2725qI) throws BX;

    public abstract List<B3> A1l(BT bt, C2725qI c2725qI, boolean z) throws BX;

    public abstract void A1u(C2646p0 c2646p0);

    public abstract void A1v(@MetaExoPlayerCustomization B0 b0, MediaFormat mediaFormat) throws AD;

    public abstract void A1w(B3 b3, B0 b0, C2725qI c2725qI, MediaCrypto mediaCrypto) throws BX;

    @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging")
    public abstract void A1x(String str);

    public abstract void A1y(String str, long j, long j2);

    public abstract boolean A22();

    public abstract boolean A23(long j, long j2, B0 b0, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z, boolean z2) throws AD;

    static {
        A15();
        A13 = new byte[]{0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    }

    public AbstractC08831g(int i, C2321jQ c2321jQ, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, BT bt, A6 a6, boolean z, boolean z2, int i2, int i3) {
        super(i);
        this.A09 = C.TIME_UNSET;
        this.A08 = C.TIME_UNSET;
        this.A0k = false;
        this.A0i = false;
        AbstractC09493y.A08(C5C.A02 >= 16);
        this.A0z = (C2321jQ) AbstractC09493y.A01(c2321jQ);
        this.A0y = (MediaCodecRendererMetaParameters) AbstractC09493y.A01(mediaCodecRendererMetaParameters);
        this.A0s = (BT) AbstractC09493y.A01(bt);
        this.A0r = a6;
        this.A0x = z;
        this.A0v = z2;
        this.A0m = i2;
        this.A0l = i3;
        this.A0o = new C2646p0(0);
        this.A0p = C2646p0.A02();
        this.A0q = new C10286z();
        this.A0u = new ArrayList();
        this.A0n = new MediaCodec.BufferInfo();
        this.A00 = 1.0f;
        this.A01 = 1.0f;
        this.A0t = new ArrayDeque<>();
        A18(BC.A04);
        this.A03 = 0;
        this.A04 = 0;
        this.A0A = C.TIME_UNSET;
        this.A0B = C.TIME_UNSET;
        this.A0w = MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A1v);
        this.A10 = MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A1g);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0124 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A0w(java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC08831g.A0w(java.lang.String):int");
    }

    private ByteBuffer A0y(int i) {
        return this.A0F.A8J(i);
    }

    private ByteBuffer A0z(int i) {
        return this.A0F.A8e(i);
    }

    private List<B3> A10(boolean z) throws BX {
        String alternativeMimeType;
        List<B3> listA1l = A1l(this.A0s, this.A0g, z);
        if (listA1l.isEmpty() && z) {
            listA1l = A1l(this.A0s, this.A0g, false);
            if (!listA1l.isEmpty()) {
                AbstractC09574g.A07(A0x(220, 18, 67), A0x(116, 40, 101) + this.A0g.A0W + A0x(0, 58, 73) + listA1l + A0x(58, 1, 35));
            }
        }
        if (listA1l.isEmpty() && this.A0j && (alternativeMimeType = C1117Ba.A0P(this.A0g)) != null) {
            List<B3> listA7o = this.A0s.A7o(alternativeMimeType, false, false);
            if (C5C.A02 >= 26) {
                if (A0x(848, 18, 102).equals(this.A0g.A0W) && !listA7o.isEmpty()) {
                    return listA7o;
                }
                return listA1l;
            }
            return listA1l;
        }
        return listA1l;
    }

    private void A11() throws AD {
        if (this.A04 == 2) {
            A1n();
            A1p();
        } else {
            if (A12[0].length() != 4) {
                throw new RuntimeException();
            }
            String[] strArr = A12;
            strArr[4] = "s3YfZmdbCJrJCYfdnx93Y1";
            strArr[3] = "Or76pnfNSBivOkp3C019O1267DCns";
            this.A0a = true;
            A1o();
        }
    }

    private void A12() throws AD {
        MediaFormat mediaFormatA8f = this.A0F.A8f();
        if (this.A02 != 0 && mediaFormatA8f.getInteger(A0x(866, 5, 81)) == 32 && mediaFormatA8f.getInteger(A0x(793, 6, 71)) == 32) {
            this.A0b = true;
            return;
        }
        if (this.A0S) {
            mediaFormatA8f.setInteger(A0x(688, 13, 13), 1);
        }
        this.A0C = mediaFormatA8f;
        this.A0T = true;
        A1v(this.A0F, mediaFormatA8f);
    }

    private void A13() {
        this.A05 = -1;
        this.A0o.A02 = null;
    }

    private void A14() {
        this.A06 = -1;
        this.A0K = null;
    }

    @MetaExoPlayerCustomizations({@MetaExoPlayerCustomization("Call to 'forceDisableAsynchronous'"), @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging"), @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "D60404164: Merge init calls in the renderer")})
    private void A16(B3 b3, MediaCrypto mediaCrypto) throws Exception {
        B0 b0A0K = null;
        String str = b3.A03;
        try {
            if (this.A10) {
                A1z(str, this.A0g);
            } else {
                A1t(this.A0g);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (!this.A10) {
                A1x(str);
            }
            AnonymousClass54.A02(A0x(715, 12, 48) + str);
            new C2596oC().A00();
            b0A0K = B7.A02().A0K(A22(), this.A0z, this.A0y.getA00(), EnumC2318jL.A05, str);
            try {
                this.A0J = str;
                AnonymousClass54.A00();
                AnonymousClass54.A02(A0x(TypedValues.TransitionType.TYPE_FROM, 14, 16));
            } catch (Exception e) {
                e = e;
            }
            try {
                A1w(b3, b0A0K, this.A0g, mediaCrypto);
                AnonymousClass54.A00();
                AnonymousClass54.A02(A0x(821, 10, 114));
                b0A0K.start();
                AnonymousClass54.A00();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                this.A0F = b0A0K;
                this.A0G = b3;
                A1y(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            } catch (Exception e2) {
                e = e2;
                if (b0A0K != null) {
                    b0A0K.AHb();
                }
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D53064452: Add decoder init time failure thread sleep")
    private void A17(B3 b3, B3 b32, MediaCrypto mediaCrypto) throws Exception {
        int iA00 = MetaExoPlayerUpgradeConfig.A00(EnumC2326jY.A06);
        if (iA00 >= 0) {
            try {
                A16(b32, mediaCrypto);
                return;
            } catch (Exception e) {
                if (b32 == b3) {
                    AbstractC09574g.A07(A0x(220, 18, 67), A0x(590, 63, 38));
                    Thread.sleep(iA00);
                    A16(b32, mediaCrypto);
                    return;
                }
                throw e;
            }
        }
        A16(b32, mediaCrypto);
    }

    private void A18(BC bc) {
        this.A0I = bc;
        if (bc.A02 != C.TIME_UNSET) {
            this.A0Z = true;
        }
    }

    private boolean A19() {
        if (this.A0l <= 0) {
            return false;
        }
        boolean z = this.A08 == C.TIME_UNSET || System.currentTimeMillis() - this.A08 <= ((long) this.A0l);
        if (this.A08 == C.TIME_UNSET) {
            AbstractC09574g.A07(A0x(220, 18, 67), A0x(95, 21, 98));
            try {
                this.A0L = null;
                A1n();
            } catch (IllegalStateException unused) {
            }
            this.A08 = System.currentTimeMillis();
        }
        return z;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D70661541: Skip the sample if sample is too large")
    private boolean A1A() throws AD {
        int result;
        if (this.A0F == null || this.A04 == 2 || this.A0X) {
            return false;
        }
        if (this.A05 < 0) {
            this.A05 = this.A0F.A5s();
            if (this.A05 < 0) {
                return false;
            }
            this.A0o.A02 = A0y(this.A05);
            this.A0o.A0A();
        }
        if (this.A04 == 1) {
            if (!this.A0Q) {
                this.A0V = true;
                this.A0F.AHI(this.A05, 0, 0, 0L, 4);
                A13();
            }
            this.A04 = 2;
            return false;
        }
        if (this.A0M) {
            this.A0M = false;
            this.A0o.A02.put(A13);
            this.A0F.AHI(this.A05, 0, A13.length, 0L, 0);
            A13();
            this.A0U = true;
            String[] strArr = A12;
            if (strArr[4].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A12;
            strArr2[7] = "TQo31YhCROQVY4YgWOUT3bWhQ8E3XWwr";
            strArr2[1] = "W5PRMN9OPETbxvbbJic4GeLECMZHBr0G";
            return true;
        }
        int iPosition = 0;
        if (this.A0e) {
            result = -4;
        } else {
            if (this.A03 == 1) {
                for (int i = 0; i < this.A0g.A0X.size(); i++) {
                    this.A0o.A02.put(this.A0g.A0X.get(i));
                }
                this.A03 = 2;
            }
            iPosition = this.A0o.A02.position();
            boolean zA03 = MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A0z);
            if (A12[2].charAt(29) == 'f') {
                throw new RuntimeException();
            }
            String[] strArr3 = A12;
            strArr3[6] = "tFzAjqlOyn071";
            strArr3[5] = "66mU3uAl0xlMl";
            if (zA03) {
                try {
                    result = A1R(this.A0q, this.A0o, 0);
                } catch (AnonymousClass63 unused) {
                    A1C(0);
                    A1m();
                    return true;
                }
            } else {
                result = A1R(this.A0q, this.A0o, 0);
            }
        }
        if (A9p() || this.A0o.A08()) {
            this.A0B = this.A0A;
        }
        if (result == -3) {
            return false;
        }
        if (result == -5) {
            if (this.A03 == 2) {
                this.A0o.A0A();
                this.A03 = 1;
            }
            A1s(this.A0q.A00);
            return true;
        }
        if (this.A0o.A05()) {
            if (this.A03 == 2) {
                this.A0o.A0A();
                this.A03 = 1;
            }
            this.A0X = true;
            if (!this.A0U) {
                A11();
                return false;
            }
            try {
                if (!this.A0Q) {
                    this.A0V = true;
                    this.A0F.AHI(this.A05, 0, 0, 0L, 4);
                    A13();
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                C2725qI c2725qI = this.A0g;
                int adaptiveReconfigurationBytes = e.getErrorCode();
                throw A1S(e, c2725qI, C5C.A02(adaptiveReconfigurationBytes));
            }
        }
        if (this.A0d && !this.A0o.A07()) {
            this.A0o.A0A();
            if (this.A03 == 2) {
                this.A03 = 1;
            }
            return true;
        }
        this.A0d = false;
        boolean skipIfSampleTooLarge = this.A0o.A0E();
        boolean bufferEncrypted = this.A0y.getA01();
        if (bufferEncrypted && skipIfSampleTooLarge) {
            this.A0o.A05.A01(iPosition);
        }
        boolean bufferEncrypted2 = A1N(skipIfSampleTooLarge);
        this.A0e = bufferEncrypted2;
        boolean bufferEncrypted3 = this.A0e;
        if (bufferEncrypted3) {
            return false;
        }
        boolean bufferEncrypted4 = this.A0N;
        if (bufferEncrypted4 && !skipIfSampleTooLarge) {
            HS.A0G(this.A0o.A02);
            if (this.A0o.A02.position() == 0) {
                return true;
            }
            this.A0N = false;
        }
        try {
            long j = this.A0o.A01;
            boolean bufferEncrypted5 = this.A0o.A04();
            if (bufferEncrypted5) {
                this.A0u.add(Long.valueOf(j));
            }
            this.A0A = Math.max(this.A0A, j);
            this.A0o.A0B();
            A1u(this.A0o);
            if (skipIfSampleTooLarge) {
                this.A0F.AHK(this.A05, 0, this.A0o.A05, j, 0);
            } else {
                this.A0F.AHI(this.A05, 0, this.A0o.A02.limit(), j, 0);
            }
            A13();
            this.A0U = true;
            this.A03 = 0;
            this.A0h.A08++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            C2725qI c2725qI2 = this.A0g;
            int adaptiveReconfigurationBytes2 = e2.getErrorCode();
            throw A1S(e2, c2725qI2, C5C.A02(adaptiveReconfigurationBytes2));
        }
    }

    private boolean A1B() {
        return this.A06 >= 0;
    }

    private boolean A1C(int i) throws AD {
        C10286z c10286zA1U = A1U();
        this.A0p.A0A();
        int iA1R = A1R(c10286zA1U, this.A0p, i | 4);
        if (iA1R == -5) {
            A1s(c10286zA1U.A00);
            return true;
        }
        if (iA1R == -4 && this.A0p.A05()) {
            this.A0X = true;
            A11();
        }
        int result = A12[2].charAt(29);
        if (result == 102) {
            throw new RuntimeException();
        }
        String[] strArr = A12;
        strArr[4] = "I6wAGrX36WnyTLz4kIu2A0";
        strArr[3] = "sKJkcvNhIyFX1pRFROyyBnawIxNqa";
        return false;
    }

    private boolean A1D(long j) {
        int size = this.A0u.size();
        for (int i = 0; i < size; i++) {
            if (this.A0u.get(i).longValue() == j) {
                this.A0u.remove(i);
                return true;
            }
        }
        String[] strArr = A12;
        String str = strArr[4];
        String str2 = strArr[3];
        int length = str.length();
        int size2 = str2.length();
        if (length == size2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A12;
        strArr2[4] = "k0VQHwP22phbTrXBZc8FuM";
        strArr2[3] = "DsxaarEsX3gZUO5CYPDgS2koeov7n";
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A1E(long r21, long r23) throws com.facebook.ads.redexgen.core.AD {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC08831g.A1E(long, long):boolean");
    }

    private boolean A1F(MediaCrypto mediaCrypto, boolean z) throws BA {
        if (this.A0L == null) {
            try {
                List<B3> listA10 = A10(z);
                if (this.A0v) {
                    this.A0L = new ArrayDeque<>(listA10);
                } else {
                    this.A0L = new ArrayDeque<>(Collections.singletonList(listA10.get(0)));
                }
                this.A0H = null;
            } catch (BX e) {
                throw new BA(this.A0g, e, z, -49998);
            }
        }
        if (!this.A0i && A21()) {
            this.A0L.addFirst(B3.A02(A0x(799, 22, 19), this.A0g.A0W, this.A0g.A0W, null, false, true, false, false, false));
        }
        if (!this.A0L.isEmpty()) {
            B3 b3PeekFirst = this.A0L.peekFirst();
            do {
                B3 b3PeekFirst2 = this.A0L.peekFirst();
                if (!A25(b3PeekFirst2)) {
                    return false;
                }
                try {
                    A17(b3PeekFirst, b3PeekFirst2, mediaCrypto);
                    return true;
                } catch (Exception e2) {
                    AbstractC09574g.A0A(A0x(220, 18, 67), A0x(156, 30, 18) + b3PeekFirst2, e2);
                    this.A0L.removeFirst();
                    BA ba = new BA(this.A0g, e2, z, b3PeekFirst2);
                    if (this.A0H == null) {
                        this.A0H = ba;
                    } else {
                        this.A0H = this.A0H.A00(ba);
                    }
                }
            } while (!this.A0L.isEmpty());
            throw this.A0H;
        }
        throw new BA(this.A0g, (Throwable) null, z, -49999);
    }

    public static boolean A1G(C2725qI c2725qI) {
        return c2725qI.A07 == 0 || c2725qI.A07 == 2;
    }

    public static boolean A1H(B3 b3) {
        String str = b3.A03;
        if (C5C.A02 <= 17) {
            String name = A0x(566, 24, 127);
            if (!name.equals(str)) {
                String name2 = A0x(419, 31, 56);
                if (name2.equals(str)) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A1I(java.lang.String r6) {
        /*
            int r1 = com.facebook.ads.redexgen.core.C5C.A02
            r0 = 23
            if (r1 > r0) goto L34
            r3 = 541(0x21d, float:7.58E-43)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC08831g.A12
            r0 = 4
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L98
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC08831g.A12
            java.lang.String r1 = "BtOe3nAvRfSweps9KMSbQL"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "8BFXWDNhFQQqbiuKKB32KUMMZhTUo"
            r0 = 3
            r2[r0] = r1
            r1 = 25
            r0 = 116(0x74, float:1.63E-43)
            java.lang.String r0 = A0x(r3, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L7d
        L34:
            int r1 = com.facebook.ads.redexgen.core.C5C.A02
            r0 = 19
            if (r1 > r0) goto L96
            java.lang.String r3 = com.facebook.ads.redexgen.core.C5C.A03
            r2 = 787(0x313, float:1.103E-42)
            r1 = 6
            r0 = 102(0x66, float:1.43E-43)
            java.lang.String r0 = A0x(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L96
            r5 = 450(0x1c2, float:6.3E-43)
            r4 = 31
            r3 = 59
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC08831g.A12
            r0 = 6
            r1 = r2[r0]
            r0 = 5
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L7f
            java.lang.String r0 = A0x(r5, r4, r3)
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L7d
        L6d:
            r2 = 481(0x1e1, float:6.74E-43)
            r1 = 38
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r0 = A0x(r2, r1, r0)
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L96
        L7d:
            r0 = 1
        L7e:
            return r0
        L7f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC08831g.A12
            java.lang.String r1 = "lQUGM0gwxiouwODu2Sf00uvqO0zTfr3c"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "xcBcqPxRh43dKrs9lyzAmVul0JtIaCtf"
            r0 = 1
            r2[r0] = r1
            java.lang.String r0 = A0x(r5, r4, r3)
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L7d
            goto L6d
        L96:
            r0 = 0
            goto L7e
        L98:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC08831g.A1I(java.lang.String):boolean");
    }

    public static boolean A1J(String str) {
        return C5C.A02 == 21 && A0x(519, 22, 41).equals(str);
    }

    public static boolean A1K(String str) {
        if (C5C.A02 >= 18 && (C5C.A02 != 18 || (!A0x(382, 15, 68).equals(str) && !A0x(397, 22, 77).equals(str)))) {
            if (C5C.A02 == 19 && C5C.A06.startsWith(A0x(667, 7, 124))) {
                if (!A0x(238, 18, 34).equals(str)) {
                    if (A12[0].length() != 4) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A12;
                    strArr[6] = "NlNH7MPHVQXxq";
                    strArr[5] = "FDVIIX4T9j7Ji";
                    if (A0x(256, 25, 89).equals(str)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A1L(String str, C2725qI c2725qI) {
        return C5C.A02 < 21 && c2725qI.A0X.isEmpty() && A0x(306, 25, 22).equals(str);
    }

    public static boolean A1M(String str, C2725qI c2725qI) {
        return C5C.A02 <= 18 && c2725qI.A06 == 1 && A0x(281, 25, 33).equals(str);
    }

    private boolean A1N(boolean z) throws AD {
        if (this.A0D == null || (!z && this.A0x)) {
            return false;
        }
        int iA9A = this.A0D.A9A();
        if (iA9A != 1) {
            return iA9A != 4;
        }
        C10899q c10899q = (C10899q) AbstractC09493y.A01(this.A0D.A80());
        C10899q c10899qA80 = this.A0D.A80();
        C2725qI c2725qI = this.A0g;
        int drmSessionState = c10899q.A00;
        throw A1S(c10899qA80, c2725qI, drmSessionState);
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public void A1X() {
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public void A1Y() {
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public void A1Z() {
        this.A0g = null;
        A18(BC.A04);
        this.A0t.clear();
        this.A0L = null;
        try {
            A1n();
            try {
                if (this.A0D != null) {
                    this.A0D.AHc(null);
                }
                try {
                    if (this.A0E != null && this.A0E != this.A0D) {
                        this.A0E.AHc(null);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.A0E != null && this.A0E != this.A0D) {
                        this.A0E.AHc(null);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.A0D != null) {
                    this.A0D.AHc(null);
                }
                try {
                    if (this.A0E != null && this.A0E != this.A0D) {
                        this.A0E.AHc(null);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.A0E != null && this.A0E != this.A0D) {
                        this.A0E.AHc(null);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public void A1a(long j, boolean z) throws AD {
        this.A0X = false;
        this.A0a = false;
        if (this.A0F != null) {
            A1m();
        }
        this.A0I.A03.A01();
        this.A0t.clear();
    }

    @Override // com.facebook.ads.redexgen.core.AE
    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    public void A1b(boolean z, boolean z2) throws AD {
        this.A0h = new C6I();
        this.A0f = 0L;
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public void A1c(C2725qI[] c2725qIArr, long j, long j2) throws AD {
    }

    public final float A1f() {
        return this.A00;
    }

    public final long A1i() {
        return this.A0I.A02;
    }

    public final B0 A1j() {
        return this.A0F;
    }

    public final B3 A1k() {
        return this.A0G;
    }

    public void A1m() throws AD {
        this.A07 = C.TIME_UNSET;
        A13();
        A14();
        this.A0d = true;
        this.A0e = false;
        this.A0c = false;
        this.A0u.clear();
        this.A0M = false;
        this.A0b = false;
        this.A0Y = false;
        this.A0B = C.TIME_UNSET;
        if (this.A0R) {
            A1n();
            A1p();
        } else {
            boolean z = this.A0O;
            String[] strArr = A12;
            if (strArr[6].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A12[0] = "8Nzt";
            if ((z && this.A0V) || A20() || this.A04 != 0) {
                A1n();
                A1p();
            } else {
                this.A0F.flush();
                this.A0U = false;
            }
        }
        if (this.A0W && this.A0g != null) {
            this.A03 = 1;
        }
    }

    public void A1n() {
        this.A07 = C.TIME_UNSET;
        this.A09 = C.TIME_UNSET;
        this.A08 = C.TIME_UNSET;
        A13();
        A14();
        this.A0C = null;
        this.A0T = false;
        this.A0e = false;
        this.A0c = false;
        this.A0u.clear();
        this.A0G = null;
        this.A0W = false;
        this.A0U = false;
        this.A0N = false;
        this.A0R = false;
        this.A02 = 0;
        this.A0Q = false;
        this.A0O = false;
        this.A0S = false;
        this.A0M = false;
        this.A0b = false;
        this.A0V = false;
        this.A03 = 0;
        this.A04 = 0;
        if (this.A0F != null) {
            this.A0h.A03++;
            try {
                B7.A02().A0L(A22(), this.A0z, this.A0y.getA00(), EnumC2318jL.A05, this.A0J, this.A0F);
                this.A0F = null;
                InterfaceC10919s interfaceC10919s = this.A0D;
                String[] strArr = A12;
                if (strArr[6].length() == strArr[5].length()) {
                    String[] strArr2 = A12;
                    strArr2[7] = "JSCNcek9dAkyOPO1KkbpJsRj9JD6rmzz";
                    strArr2[1] = "RONQ7IAwO8Bcbv1Krrdz5fvlVLwlovmm";
                    if (interfaceC10919s != null && this.A0E != this.A0D) {
                        try {
                            this.A0D.AHc(null);
                            return;
                        } finally {
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                this.A0F = null;
                String[] strArr3 = A12;
                if (strArr3[7].charAt(2) != strArr3[1].charAt(2)) {
                    A12[2] = "iwo0woIVvHFpnZaxaWQfv32BCS9fYlqT";
                    if (this.A0D != null && this.A0E != this.A0D) {
                        try {
                            this.A0D.AHc(null);
                        } finally {
                        }
                    }
                    throw th;
                }
            }
            throw new RuntimeException();
        }
    }

    public void A1o() throws AD {
    }

    public final void A1p() throws AD {
        long jElapsedRealtime;
        if (this.A0F != null || this.A0g == null) {
            return;
        }
        this.A0D = this.A0E;
        if (this.A0D != null) {
            this.A0D.A7V();
            if (0 == 0) {
                if (this.A0D.A80() == null) {
                    return;
                }
            } else {
                throw new NullPointerException(A0x(759, 21, 39));
            }
        }
        try {
            if (!A1F(null, false)) {
                return;
            }
            String str = this.A0G.A03;
            this.A02 = A0w(str);
            this.A0N = A1L(str, this.A0g);
            this.A0R = A1K(str);
            this.A0Q = A1H(this.A0G);
            this.A0O = A1I(str);
            this.A0P = A1J(str);
            this.A0S = A1M(str, this.A0g);
            if (A9A() == 2) {
                jElapsedRealtime = SystemClock.elapsedRealtime() + 1000;
            } else {
                jElapsedRealtime = -9223372036854775807L;
            }
            this.A07 = jElapsedRealtime;
            A13();
            A14();
            this.A09 = C.TIME_UNSET;
            this.A0d = true;
            this.A0h.A02++;
        } catch (BA e) {
            String mimeType = A12[0];
            if (mimeType.length() != 4) {
                throw new RuntimeException();
            }
            String[] strArr = A12;
            strArr[4] = "htoDBH0u2SWwWLv1LDVpoG";
            strArr[3] = "VZtqtU1mGbN1CVtxZAbUMauSXb3bc";
            if (this.A0m > 0 && (this.A09 == C.TIME_UNSET || System.currentTimeMillis() - this.A09 <= this.A0m)) {
                if (this.A09 == C.TIME_UNSET) {
                    String strA0x = A0x(220, 18, 67);
                    String mimeType2 = A0x(59, 36, 3);
                    AbstractC09574g.A07(strA0x, mimeType2);
                    this.A09 = System.currentTimeMillis();
                }
                if (this.A0L != null && this.A0L.isEmpty()) {
                    this.A0L = null;
                    return;
                }
                return;
            }
            throw A1S(e, this.A0g, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
        }
    }

    public void A1q(long j) {
    }

    @MetaExoPlayerCustomization("Needed for sr video effects")
    public void A1r(C2725qI c2725qI) {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A1s(com.facebook.ads.redexgen.core.C2725qI r9) throws com.facebook.ads.redexgen.core.AD {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC08831g.A1s(com.facebook.ads.redexgen.X.qI):void");
    }

    public void A1t(C2725qI c2725qI) throws AD {
    }

    public void A1z(String str, C2725qI c2725qI) throws AD {
        A1t(c2725qI);
    }

    public boolean A20() {
        return false;
    }

    public final boolean A21() {
        return A24(this.A0g);
    }

    public final boolean A24(C2725qI c2725qI) {
        if (c2725qI == null || !this.A0k || !A0x(838, 10, 89).equalsIgnoreCase(c2725qI.A0W)) {
            return false;
        }
        return true;
    }

    public boolean A25(B3 b3) {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public boolean AAP() {
        return this.A0a;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public boolean AAe() {
        if (this.A0g == null) {
            super.A0B = EnumC2291ir.A07;
        } else if (this.A0e) {
            super.A0B = EnumC2291ir.A0A;
        } else if (!A1d() && !A1B()) {
            super.A0B = EnumC2291ir.A06;
        }
        if (this.A0g != null) {
            boolean z = this.A0e;
            if (A12[2].charAt(29) == 'f') {
                throw new RuntimeException();
            }
            String[] strArr = A12;
            strArr[7] = "joohYCoWTVCMZ7ZK6VknoEQ3356Yke9R";
            strArr[1] = "gcfLSJm2tOx4UzvBIoCvVtFxExIT9beD";
            if (!z && (A1d() || A1B() || (this.A07 != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.A07))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public void AIX(long j, long j2) throws AD {
        if (this.A0a) {
            A1o();
            return;
        }
        if (this.A0g == null && !A1C(2)) {
            return;
        }
        A1p();
        if (this.A0F != null) {
            try {
                try {
                    AnonymousClass54.A02(A0x(727, 12, 16));
                    while (A1E(j, j2)) {
                    }
                    while (A1A()) {
                    }
                    this.A08 = C.TIME_UNSET;
                } catch (IllegalStateException e) {
                    if (!A19()) {
                        throw A1S(e, this.A0g, PlaybackException.ERROR_CODE_DECODING_FAILED);
                    }
                }
            } finally {
                AnonymousClass54.A00();
            }
        } else {
            this.A0h.A0A += A1Q(j);
            A1C(1);
        }
        this.A0h.A02();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10447p
    public final int AKM(C2725qI c2725qI) throws AD {
        try {
            return A1h(this.A0s, this.A0r, c2725qI);
        } catch (BX e) {
            throw A1S(e, c2725qI, PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AE, com.facebook.ads.redexgen.core.InterfaceC10447p
    public final int AKO() {
        return 8;
    }
}
