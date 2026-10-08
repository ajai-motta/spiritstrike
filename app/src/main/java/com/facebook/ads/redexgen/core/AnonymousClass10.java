package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.ads.androidx.media3.exoplayer.video.DummySurface;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations;
import com.google.android.exoplayer2.C;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.10, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass10 extends AbstractC08831g {
    public static boolean A0z;
    public static boolean A10;
    public static byte[] A11;
    public static String[] A12 = {"1NrdYD1", "e5CK9xPn181JbTmOtknpsRCTtEnfDjR7", "JOO2xDl09pGw2ctw4YX5NjUR9G0o3YSd", "78GGNN1Oy", "9AKZq2G4NCUeKdGegrXYJ0IAO08zLsd4", "iWBlsDv", "UMYjsOFgfK8VKq5PmkWlrwAU0Drwgr0y", "VHiTYYEOZZ1JgajrOOPlCJmFeSyZZTnO"};
    public static final int[] A13;
    public C2528n5 A00;
    public float A01;
    public float A02;
    public float A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public int A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public long A0N;
    public long A0O;
    public long A0P;
    public long A0Q;
    public long A0R;
    public MediaFormat A0S;
    public Surface A0T;
    public Surface A0U;
    public C2678pW A0V;
    public C1229Fm A0W;
    public G2 A0X;
    public Object A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public boolean A0e;
    public boolean A0f;
    public boolean A0g;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D69547806: Only become ready once we have a surface")
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public final int A0l;
    public final int A0m;
    public final int A0n;
    public final int A0o;
    public final long A0p;
    public final Context A0q;
    public final C1231Fo A0r;
    public final G7 A0s;
    public final GA A0t;
    public final GP A0u;
    public final boolean A0v;
    public final boolean A0w;
    public final long[] A0x;
    public final long[] A0y;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Point A07(B3 b3, C2725qI c2725qI) throws BX {
        boolean z = c2725qI.A0A > c2725qI.A0L;
        int i = z ? c2725qI.A0A : c2725qI.A0L;
        int i2 = z ? c2725qI.A0L : c2725qI.A0A;
        float f = i2 / i;
        for (int i3 : A13) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                return null;
            }
            if (C5C.A02 >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point pointA0N = b3.A0N(i5, i3);
                if (b3.A0R(pointA0N.x, pointA0N.y, c2725qI.A01)) {
                    return pointA0N;
                }
            } else {
                int iA05 = C5C.A05(i3, 16) * 16;
                int iA052 = C5C.A05(i4, 16) * 16;
                if (iA05 * iA052 <= C1117Ba.A00()) {
                    int i6 = z ? iA052 : iA05;
                    if (!z) {
                        iA05 = iA052;
                    }
                    return new Point(i6, iA05);
                }
            }
        }
        return null;
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A11, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0P() {
        A11 = new byte[]{96, 101, 95, 96, 96, 102, 96, 98, 92, 98, 92, 95, -64, -80, -81, -84, -74, -81, -59, -74, -90, -91, -94, -84, -91, -63, -106, -122, -117, -123, -122, 79, SignedBytes.MAX_POWER_OF_TWO, 62, 63, 68, 111, 66, 62, 88, 78, 71, 71, 71, 68, 120, -113, -123, 126, 126, 126, -66, -70, -61, -63, -122, 124, 117, 118, 117, -90, 121, 125, 105, 95, 88, 90, 88, -119, 92, 96, -77, -72, -58, -77, 93, 98, 112, 106, -123, -105, -103, -105, -93, -100, 116, 116, -123, -120, 99, 117, 119, 117, -127, 122, 82, 82, 99, 102, 99, 95, 113, 115, 113, 125, 118, 78, 78, 95, 98, 97, 78, 96, 98, 96, 108, 101, Base64.padSymbol, Base64.padSymbol, 78, 81, 108, 63, -121, -76, -86, -72, -75, -77, -89, -66, 102, -121, 120, 124, -119, 122, -114, 78, 126, -126, 110, 93, 124, -124, 114, 127, 90, -71, -21, -19, -21, -41, -46, -70, -83, -88, -88, -61, -60, -76, -24, -27, -44, -46, -63, -30, -25, -40, -46, -91, -65, -55, -66, -64, -56, -86, -82, -43, -67, -51, -68, -47, -60, -68, -101, -81, -58, -101, -83, -85, -84, -80, 127, -113, 126, -109, -122, 126, -100, 126, -111, -109, 111, -108, -92, -109, -88, -101, -109, -79, -109, -90, -88, -123, -79, -122, -99, -89, -107, -123, -110, 122, 120, 121, 120, -95, -117, 114, 116, 118, -125, 123, 100, 105, 99, 108, 106, 119, -128, 95, 90, -122, 112, 87, 87, 85, -127, 118, 119, 117, 50, 127, 115, -118, 50, -124, 119, -123, -127, 126, -121, -122, 123, -127, -128, 50, 115, 118, 124, -121, -123, -122, 119, 118, 50, -122, -127, 76, 50, -71, -27, -29, -33, -27, -55, -89, -126, 114, 115, 113, 112, -103, -96, -87, -101, -107, -77, -107, -121, -77, -92, -58, -61, -59, -52, -43, -57, -63, -33, -50, -17, -12, -27, -54, -47, -38, -52, -58, -28, -43, -9, -18, -14, 77, 84, 93, 79, 73, 103, 90, 105, -127, 103, 96, -93, -44, -61, -48, -79, -46, -65, -48, -67, -79, -62, -81, -83, -83, -83, -76, -95, -97, -97, -95, 111, 92, 90, 90, 95, 90, 71, 70, 69, 69, 78, 59, 58, 57, 59, -106, -125, -126, -127, -123, 84, 65, 65, 63, 63, -107, -80, -69, -62, -76, -110, -73, -76, -78, -70, 111, -86, -69, -76, -74, -80, -78, -56, -107, -63, -80, -68, -76, -94, -72, -55, -76, 123, 111, 94, 96, 102, 101, 92, 92, 118, 94, 89, 99, 78, 74, 77, 71, -98, -96, -90, -91, -100, -100, -74, -86, -82, -82, -120, -115, -121, -112, -91, -89, -83, -84, -93, -93, -67, -79, -75, -75, -113, -108, -112, -107, 101, 103, 109, 108, 99, 99, 125, 113, 117, 117, 79, 84, 81, 79, -113, -111, -105, -106, -115, -115, -89, -97, -118, -108, 125, 127, 120, -128, 102, 104, 110, 109, 100, 100, 126, 118, 97, 107, 86, 82, 85, 84, -118, -116, -110, -111, -120, -120, -94, -102, -123, -113, 122, 120, 116, 124, -105, -71, -97, -98, -107, -107, -81, -109, -110, -100, -121, -123, -127, -125, -104, -70, -96, -97, -106, -106, -80, -104, -109, -99, -120, -124, -126, -118, 99, 112, 92, 114, 96, 100, 59, 105, 115, 111, 72, 103, 77, 84, 114, -127, 108, 118, 120, 87, 114, -125, -110, 126, 124, -120, 104, -125, 81, 96, 78, 86, 85, -97, -82, -83, -91, -86, -124, -97, -109, -94, -94, -116, -98, 120, -109, -89, -52, -60, -57, -52, -57, -42, -117, -74, -109, -107, -112, 93, 90, 109, -81, -72, -77, -110, -79, -105, -106, -70, -92, -97, -48, -93, -97, 103, 98, 72, 102, 79, 78, 75, 122, 117, 91, 123, 96, 99, 94, 99, 106, 68, 76, 71, 72, 78, -69, -44, -35, -34, -27, -34, -113, -80, -95, -97, -96, -91, -47, -94, -97, 125, -106, -97, -96, -89, -96, 81, 124, 98, 97, -110, 101, 97, -56, -31, -22, -21, -14, -21, -100, -57, -76, 117, 93, -117, 118, 110, 114, -125, 126, -120, 118, 94, 103, 114, 80, 84, 108, 107, 112, 104, 74, 118, 107, 108, 106, 93, 112, 107, 108, 118, 89, 108, 117, 107, 108, 121, 108, 121, -90, -56, -51, -56, -98, -117, -127, -115, -96, -122, -91, -83, -98, -126, 125, -97, -92, -97, 119, 99, -83, -75, -88, -93, -88, -96, 85, 95, 60, 59, 56, 81, -99, -89, -124, -122, -126, -103, -109, -111, -100, 114, -85, -77, -77, -85, -80, -87, -85, -54, -63, -84, -56, -47, -49, -111, -80, -51, -77, -75, -82, 126, 102, 99, 91, 77, Base64.padSymbol, 56, 65, 66, 59, 88, 118, 109, 116, 91, 88, 94, -88, -97, -90, -114, -119, -120, -125, 122, -127, 105, 100, 100, -76, -80, -87, 121, 123, 120, 96, 124, -71, -47, -54, -41, -35, -40, -42, -97, -107, -82, -67, -86, -79, 101, -91, -66, -51, -66, -119, -126, -116, -76, -120, -100, -81, -56, -41, -56, -108, -116, -112, -113, -66, -109, -90, 123, 93, 95, 90, -69, -98, -100, -96, -102, -103, 124, 122, 127, 107, 78, 77, 75, 74, -126, 102, 124, 120, 92, 97, -125, 112, -118, -128, -123, -116, 101, -50, -31, -32, -23, -27, -100, -80, -44, -79, -60, -61, -52, -56, 127, -83, -50, -45, -60, 127, -111, 113, -124, -125, -116, -120, 63, 109, -114, -109, -124, 63, 82, -105, -86, -77, -87, -86, -73, 101, -76, -70, -71, -75, -70, -71, 101, -85, -90, -82, -79, -86, -87, -78, -59, -45, -49, -52, -43, -44, -55, -49, -50, -45, -128, -43, -50, -53, -50, -49, -41, -50, -114, -128, -93, -49, -60, -59, -61, -128, -51, -63, -40, -128, -46, -59, -45, -49, -52, -43, -44, -55, -49, -50, -102, -128, -119, -125, 99, 125, 111, 105, 107, 102, -90, -96, -128, -99, -123, -125, -125, -102, -88, -83, -89, -121, -92, -116, -118, -118, -89, -118, -124, 100, -123, 112, 104, 103, -119, 107, 126, -128, 
        114, 108, 125, 75, 126, 100, -62, -59, -65, -100, -77, -61, -59, -96, -92, 118, -113, -124, -105, -120, -126, 115, -107, -110, -42, -14, -15, -4, -93, -41, -28, -27, -17, -24, -9, -93, -42, 126, 108, 93, 87, 97, 93, 90, 112, 126, 108, 93, 87, 97, 93, 90, -126, -72, -90, -105, -111, -100, -103, -108, -86, -116, 122, 107, 101, 112, 109, 104, -123, -77, -50, -50, 127, -52, -64, -51, -40, 127, -46, -45, -47, -60, -64, -52, 127, -62, -57, -64, -51, -58, -60, -46, -117, 127, -46, -50, 127, -61, -47, -50, -49, -49, -56, -51, -58, 127, -50, -59, -59, -46, -60, -45, -103, 127, -89, -126, 107, 71, 72, 92, 87, 112, 79, 117, 114, 87, 87, 79, -73, -110, -66, -89, -86, 97, 78, 59, 97, -38, -42, -77, -72, -72, -75, -82, -123, -122, -77, -92, -90, -93, -90, -124, 124, -92, -83, 112, -85, -101, -81, -98, -93, -87, 103, -83, -97, -83, -83, -93, -87, -88, 103, -93, -98, 120, -116, -117, -122, 68, 125, -119, 122, -92, 115, 111, -94, -81, -91, -77, -80, -86, -91, 111, -94, -73, 114, 110, -91, -94, -73, 114, -91, 111, -91, -90, -92, -80, -91, -90, -77, -24, -9, -12, -11, -78, -25, -12, -7, -7, -12, -14, 108, 123, 120, 121, 54, 117, 110, 111, 125, -48, -33, -36, -35, -102, -33, -42, -44, -43, -31, -95, -80, -83, -82, 107, -78, -83, -82, -28, -9, -78, 110, -127, 62, -51, -54, -41, -48, -54, -43, -52, -51, -54, -23, -9, -12, -11, -37, -18, -23, -22, -12, -57, -6, -21, -21, -22, -9, 114, 120, 123, -60, -51, -47, -46, -61, -48, -38, -26, -43, -31, -39, -95, -26, -43, -24, -39, -53, -38, -52, -38, -55, -44, -53, -56, -56, -53, -48, -72, -75, -71, -73, -72, -60, -65, -53, -70, -74, -68, -116, -115, -60, -61, -74, -69, -53, -52, -61, -81, -66, -120, -109, -116, 116, -113, -94, 114, 105, 108, 106, 115, 108, 107, 118, 118, 66, 65, Base64.padSymbol, 63, 105, 67, 66, 58, SignedBytes.MAX_POWER_OF_TWO, -46, -37, -46, -36, -97, -103, -52, -41, -56, -49, -62, -74, -105, -108, -104, 96, -90, -102, -94, -109, -105, -100, -95, -95, -105, -86, -101, -101, 100, 99, 101, 95, 120, 113, 107, -124, 66, -65, -62, -54, -128, -65, -76, -57, -72, -63, -74, -52, -56, -115, 123, -55, -54, -49, -64, 125, 113, 126, 126, 121, 126, 119, -17, -29, -12, -21, -16, -15, -31, -24, -115, -127, -104, 77, -120, -123, -119, -121, -120, -108, -27, -39, -16, -91, -31, -26, -24, -19, -20, -91, -21, -31, -14, -35, 117, 105, -128, 53, 127, 113, 108, 124, 112, 124, 119, -75, -79, -84, -73, -57, -61, -57, -65, -102, -115, -103, -115, -96, -108, -110, -115, -121, -113, -112, -123, -103, -105, -125, -118, -89, 105, 104, 105, -113, -128, -115, -124, -117, -117, 126, -125, -74, -89, -76, -85, -78, -78, -91, -86, -78, -18, -33, -20, -29, -22, -22, -35, -30, -15, -91, -106, -93, -102, -95, -95, -108, -103, -87, -24, -22, -31, -25, -22, -31, -20, -15, -84, -97, -90, -97, -101, -83, -97, -119, -81, -82, -86, -81, -82, 124, -81, -96, -96, -97, -84, -128, 125, -126, 111, -126, 119, 125, 124, 59, 114, 115, 117, -128, 115, 115, -127, -107, 91, 82, 87, -102, 82, 83, 90, -58, -76, -63, -57, -62, -63, -68, -105, -113, -115, -108, 122, -115, -120, -119, -109, 102, -103, -118, -118, -119, -106, -14, -33, -25, -30, -19, -35, -16, -19, -11, -119, 120, -127, 116, 122, -118, -84, -83, -90, -90, -99, -92, -99, -100, 101, -88, -92, -103, -79, -102, -103, -101, -93, -90, -107, -94, -98, -107, -107, -113, 125, 101, -54, -67, -72, -71, -61, -125, -121, -69, -60, -60, -86, -99, -104, -103, -93, 99, -107, -86, 100, 101, -40, -53, -58, -57, -47, -111, -61, -40, -59, -124, 119, 114, 115, 125, Base64.padSymbol, 114, 125, 122, 112, -121, 59, -124, 119, -127, 119, 125, 124, -37, -50, -55, -54, -44, -108, -51, -54, -37, -56, -109, -122, -127, -126, -116, 76, -118, -115, 81, -109, 74, -126, -112, -33, -46, -51, -50, -40, -104, -31, -106, -33, -41, -51, -105, -40, -41, -101, -105, -33, -39, -95, -22, -35, -40, -39, -29, -93, -20, -95, -22, -30, -40, -94, -29, -30, -90, -94, -22, -28, -83, -76, -98, -79, -80, -84, -85, -42, -57, -40, -47, -60, -61, -51, -65, -70, -54, -66, -88, -96, -96, -107, -92, -112, -105, -89, -97, -97, -108, -93, -113, -106, -98, -45};
    }

    static {
        A0P();
        A13 = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D69547806: Only become ready once we have a surface")
    public AnonymousClass10(Context context, C2321jQ c2321jQ, MediaCodecRendererMetaParameters mediaCodecRendererMetaParameters, BT bt, long j, A6 a6, boolean z, boolean z2, Handler handler, GQ gq, int i, int i2, int i3, int i4, int i5) {
        super(2, c2321jQ, mediaCodecRendererMetaParameters, bt, a6, z, z2, i3, i4);
        this.A0e = true;
        this.A0Z = true;
        boolean z3 = false;
        this.A0f = false;
        this.A0K = C.TIME_UNSET;
        this.A0c = false;
        this.A0h = false;
        this.A0w = MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A1v);
        this.A0h = MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A0w);
        this.A0p = j;
        this.A0l = i;
        this.A0m = i2;
        this.A0q = context.getApplicationContext();
        this.A0n = i5;
        this.A0t = new GA(context);
        this.A0s = new G7(this.A0q);
        this.A0u = new GP(handler, gq);
        this.A0r = new C1231Fo(this.A0s, this, this.A0w);
        this.A0v = A0i();
        if (C5C.A02 == 29 && C5C.A06.startsWith(A0B(811, 6, 62))) {
            z3 = true;
        }
        this.A0a = z3;
        this.A0x = new long[10];
        this.A0y = new long[10];
        this.A0R = C.TIME_UNSET;
        this.A0O = C.TIME_UNSET;
        this.A0M = C.TIME_UNSET;
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0H = 1;
        A0F();
    }

    private int A00(C2725qI c2725qI) {
        if (c2725qI.A0B != -1) {
            int i = 0;
            int i2 = c2725qI.A0X.size();
            for (int initializationDataCount = 0; initializationDataCount < i2; initializationDataCount++) {
                int totalInitializationDataSize = c2725qI.A0X.get(initializationDataCount).length;
                i += totalInitializationDataSize;
            }
            int totalInitializationDataSize2 = c2725qI.A0B;
            return totalInitializationDataSize2 + i;
        }
        int i3 = c2725qI.A0L;
        String str = c2725qI.A0W;
        int width = c2725qI.A0A;
        return A02(str, i3, width);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A01(com.facebook.ads.redexgen.core.BT r8, com.facebook.ads.redexgen.core.C2725qI r9, boolean r10) throws com.facebook.ads.redexgen.core.BX {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A01(com.facebook.ads.redexgen.X.BT, com.facebook.ads.redexgen.X.qI, boolean):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0011 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A02(java.lang.String r7, int r8, int r9) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A02(java.lang.String, int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03(long j, long j2, long j3, long j4, boolean z) {
        double playbackSpeed = A1f();
        long j5 = (long) ((j4 - j) / playbackSpeed);
        if (z) {
            return j5 - (j3 - j2);
        }
        return j5;
    }

    @MetaExoPlayerCustomization("D64704257: Adding a new param to control AI FRC")
    private final MediaFormat A08(C2725qI c2725qI, C1229Fm c1229Fm, boolean z, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A0B(1462, 4, 83), c2725qI.A0W);
        mediaFormat.setInteger(A0B(1755, 5, 79), c2725qI.A0L);
        mediaFormat.setInteger(A0B(1307, 6, 73), c2725qI.A0A);
        AbstractC09594i.A06(mediaFormat, c2725qI.A0X);
        AbstractC09594i.A03(mediaFormat, A0B(1286, 10, 109), c2725qI.A01);
        AbstractC09594i.A04(mediaFormat, A0B(1548, 16, 7), c2725qI.A0F);
        AbstractC09594i.A02(mediaFormat, c2725qI.A0N);
        mediaFormat.setInteger(A0B(1447, 9, 1), c1229Fm.A02);
        mediaFormat.setInteger(A0B(1423, 10, 25), c1229Fm.A00);
        AbstractC09594i.A04(mediaFormat, A0B(1433, 14, 113), c1229Fm.A01);
        if (C5C.A02 >= 23) {
            String strA0B = A0B(1521, 8, 113);
            String[] strArr = A12;
            if (strArr[4].charAt(23) == strArr[7].charAt(23)) {
                throw new RuntimeException();
            }
            A12[2] = "2RIBJj1oBKSBZdAo5SnKQdQzGU6CRjTj";
            mediaFormat.setInteger(strA0B, 0);
        }
        if (z) {
            mediaFormat.setInteger(A0B(1173, 8, 16), 0);
        }
        AbstractC2292is.A03(this.A0z, mediaFormat);
        if (i != 0) {
            A0T(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.core.C1229Fm A0A(com.facebook.ads.redexgen.core.B3 r12, com.facebook.ads.redexgen.core.C2725qI r13, com.facebook.ads.redexgen.core.C2725qI[] r14) throws com.facebook.ads.redexgen.core.BX {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A0A(com.facebook.ads.redexgen.X.B3, com.facebook.ads.redexgen.X.qI, com.facebook.ads.redexgen.X.qI[]):com.facebook.ads.redexgen.X.Fm");
    }

    public static List<B3> A0C(BT bt, C2725qI c2725qI) throws BX {
        ArrayList arrayList = new ArrayList();
        String alternativeMimeType = C1117Ba.A0P(c2725qI);
        if (alternativeMimeType != null) {
            List<B3> listA7o = bt.A7o(alternativeMimeType, false, false);
            if (C5C.A02 >= 26) {
                if (A0B(1664, 18, 7).equals(c2725qI.A0W) && !listA7o.isEmpty()) {
                    return listA7o;
                }
                return arrayList;
            }
            return arrayList;
        }
        return arrayList;
    }

    public static List<B3> A0D(BT bt, C2725qI c2725qI, boolean z) throws BX {
        String str = c2725qI.A0W;
        if (str == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(bt.A7o(str, z, false));
    }

    private void A0E() {
        B0 b0A1j;
        this.A0i = false;
        if (C5C.A02 >= 23 && this.A0k && (b0A1j = A1j()) != null) {
            this.A00 = new C2528n5(this, b0A1j);
        }
    }

    private void A0F() {
        this.A0G = -1;
        this.A0E = -1;
        this.A03 = -1.0f;
        this.A0F = -1;
    }

    @MetaExoPlayerCustomization("need for SR to release EGL context")
    private void A0G() {
        if (this.A0r.A0G() && MetaExoPlayerUpgradeConfig.A03(EnumC2325jX.A1t)) {
            this.A0r.A0A();
            throw null;
        }
    }

    private void A0H() {
        if (this.A0m > 0 && this.A05 > 0 && this.A05 >= this.A0m) {
            this.A0u.A00(this.A05, SystemClock.elapsedRealtime() - this.A0I);
        }
        this.A05 = 0;
        this.A0I = SystemClock.elapsedRealtime();
    }

    private void A0I() {
        B0 b0A1j = A1j();
        if (b0A1j != null && !this.A0c && b0A1j.A9K() > 30) {
            A0V(super.A0g);
            this.A0c = true;
        }
    }

    private void A0J() {
        if (this.A09 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long now = this.A0J;
            long elapsedMs = jElapsedRealtime - now;
            this.A0u.A01(this.A09, elapsedMs);
            this.A09 = 0;
            this.A0J = jElapsedRealtime;
        }
    }

    private void A0K() {
        if (this.A08 == -1 && this.A06 == -1) {
            return;
        }
        if (this.A0G != this.A08 || this.A0E != this.A06 || this.A0F != this.A07 || this.A03 != this.A01) {
            this.A0u.A07(new C2678pW(this.A08, this.A06, this.A07, this.A01));
            this.A0G = this.A08;
            this.A0E = this.A06;
            this.A0F = this.A07;
            this.A03 = this.A01;
        }
    }

    private void A0L() {
        if (this.A0i) {
            this.A0u.A0D(this.A0U);
        }
    }

    private void A0M() {
        if (this.A0G != -1 || this.A0E != -1) {
            this.A0u.A07(new C2678pW(this.A0G, this.A0E, this.A0F, this.A03));
        }
    }

    private void A0N() {
        long jElapsedRealtime;
        if (this.A0p > 0) {
            jElapsedRealtime = SystemClock.elapsedRealtime() + this.A0p;
        } else {
            jElapsedRealtime = C.TIME_UNSET;
        }
        this.A0M = jElapsedRealtime;
    }

    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    private void A0O() {
        super.A0h.A03(super.A0f);
    }

    private final void A0Q(int i) {
        super.A0h.A04 += i;
        this.A09 += i;
        this.A05 += i;
        super.A0h.A07 = Math.max(this.A05, super.A0h.A07);
        if (this.A09 >= this.A0l) {
            A0J();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0R(long r10, long r12, float r14) {
        /*
            r9 = this;
            long r0 = com.facebook.ads.redexgen.core.C2Y.A01(r10)
            int r6 = (int) r0
            long r0 = com.facebook.ads.redexgen.core.C2Y.A01(r12)
            int r5 = (int) r0
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r5 <= r3) goto L44
            r0 = 10000(0x2710, float:1.4013E-41)
            if (r5 >= r0) goto L44
            int r2 = r6 + r5
            int r1 = r9.A0A
            int r0 = r9.A0B
            int r1 = r1 + r0
            int r1 = r1 + r3
            if (r2 <= r1) goto L44
            int r0 = r9.A0A
            r7 = 4652007308841189376(0x408f400000000000, double:1000.0)
            if (r6 <= r0) goto L45
            int r1 = r9.A0A
            int r0 = r9.A0B
            int r1 = r1 + r0
            if (r6 >= r1) goto L45
            com.facebook.ads.redexgen.X.6I r4 = r9.A0h
            int r3 = r4.A0E
            int r2 = r6 + r5
            int r1 = r9.A0A
            int r0 = r9.A0B
            int r1 = r1 + r0
            int r2 = r2 - r1
            float r0 = (float) r2
            float r0 = r0 * r14
            double r1 = (double) r0
            double r1 = r1 / r7
            int r0 = (int) r1
            int r3 = r3 + r0
            r4.A0E = r3
        L40:
            r9.A0A = r6
            r9.A0B = r5
        L44:
            return
        L45:
            int r1 = r9.A0A
            int r0 = r9.A0B
            int r1 = r1 + r0
            if (r6 <= r1) goto L40
            com.facebook.ads.redexgen.X.6I r4 = r9.A0h
            int r3 = r4.A0E
            float r0 = (float) r5
            float r0 = r0 * r14
            double r1 = (double) r0
            double r1 = r1 / r7
            int r0 = (int) r1
            int r3 = r3 + r0
            r4.A0E = r3
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A0R(long, long, float):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0S(long j, long j2, C2725qI c2725qI, MediaFormat mediaFormat) {
        if (this.A0X != null) {
            this.A0X.AGS(j, j2, c2725qI, mediaFormat);
        }
    }

    public static void A0T(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled(A0B(1609, 17, 49), true);
        mediaFormat.setInteger(A0B(1157, 16, 51), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0U(android.view.Surface r9) throws com.facebook.ads.redexgen.core.AD {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A0U(android.view.Surface):void");
    }

    private void A0V(C2725qI c2725qI) {
        B0 codec = A1j();
        if (codec != null && c2725qI != null) {
            Pair<Long, Integer> pairA8j = codec.A8j();
            if (((Long) pairA8j.first).longValue() > 0) {
                super.A0h.A04(pairA8j);
                GP gp = this.A0u;
                if (A12[2].charAt(6) == 'n') {
                    throw new RuntimeException();
                }
                A12[3] = "UGSzGWhN7NgjOmIm99IkQUILfPM9Cd";
                gp.A04(super.A0h.A00, c2725qI);
            }
        }
    }

    private final void A0W(B0 b0, int i, long j) {
        AnonymousClass54.A02(A0B(1262, 15, 126));
        b0.AHi(i, false);
        AnonymousClass54.A00();
        A0Q(1);
    }

    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    private final void A0X(B0 b0, int i, long j) {
        if (this.A0w) {
            A0Y(b0, i, j);
            return;
        }
        A0K();
        try {
            AnonymousClass54.A02(A0B(1529, 19, 51));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            b0.AHi(i, true);
            long j2 = super.A0f;
            long startRenderTime = SystemClock.elapsedRealtime();
            super.A0f = j2 + (startRenderTime - jElapsedRealtime);
            this.A0P = SystemClock.elapsedRealtime() * 1000;
            super.A0h.A09++;
            A0H();
            A27();
            A0O();
        } finally {
            AnonymousClass54.A00();
        }
    }

    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    private final void A0Y(B0 b0, int i, long j) {
        AnonymousClass54.A02(A0B(1529, 19, 51));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        b0.AHi(i, true);
        long j2 = super.A0f;
        long startRenderTime = SystemClock.elapsedRealtime();
        super.A0f = j2 + (startRenderTime - jElapsedRealtime);
        AnonymousClass54.A00();
        super.A0h.A09++;
        A0H();
        if (!this.A0r.A0G()) {
            this.A0P = SystemClock.elapsedRealtime() * 1000;
            A0K();
            A27();
        }
    }

    private final void A0Z(B0 b0, int i, long j) {
        AnonymousClass54.A02(A0B(1579, 15, 29));
        b0.AHi(i, false);
        AnonymousClass54.A00();
        super.A0h.A0B++;
    }

    @MetaExoPlayerCustomization("D36797879: Adding implementation for calculating avg render time")
    private final void A0a(B0 b0, int i, long j, long j2) {
        if (this.A0w) {
            A0c(b0, i, j, j2, true);
            return;
        }
        A0K();
        A0S(j, j2, super.A0g, this.A0S);
        try {
            AnonymousClass54.A02(A0B(1529, 19, 51));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            b0.AHh(i, j2);
            long j3 = super.A0f;
            long startRenderTime = SystemClock.elapsedRealtime();
            super.A0f = j3 + (startRenderTime - jElapsedRealtime);
            this.A0P = SystemClock.elapsedRealtime() * 1000;
            super.A0h.A09++;
            A0H();
            A27();
            A0O();
        } finally {
            AnonymousClass54.A00();
        }
    }

    private final void A0b(@MetaExoPlayerCustomization B0 b0, int i, long j, long j2, boolean z) {
        if (this.A0w) {
            A0c(b0, i, j, j2, z);
            return;
        }
        A0K();
        A0S(j, j2, super.A0g, this.A0S);
        try {
            AnonymousClass54.A02(A0B(1529, 19, 51));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            b0.AHh(i, j2);
            long j3 = super.A0f;
            long startRenderTime = SystemClock.elapsedRealtime();
            super.A0f = j3 + (startRenderTime - jElapsedRealtime);
            this.A0P = SystemClock.elapsedRealtime() * 1000;
            super.A0h.A09++;
            A0H();
            A27();
            A0O();
        } finally {
            AnonymousClass54.A00();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004b  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("notifyFrameMetadataListener be removed once we take the Exo renderOutputBufferNow Function refactor")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0c(com.facebook.ads.redexgen.core.B0 r11, int r12, long r13, long r15, boolean r17) {
        /*
            r10 = this;
            r6 = r15
            if (r17 == 0) goto L20
            com.facebook.ads.redexgen.X.qI r8 = r10.A0g
            android.media.MediaFormat r9 = r10.A0S
            r3 = r10
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AnonymousClass10.A12
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 21
            if (r1 == r0) goto L80
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AnonymousClass10.A12
            java.lang.String r1 = "fwcrFdVwexqT3olBri8BzspmWxCtZa94"
            r0 = 6
            r2[r0] = r1
            r4 = r13
            r3.A0S(r4, r6, r8, r9)
        L20:
            r2 = 1529(0x5f9, float:2.143E-42)
            r1 = 19
            r0 = 51
            java.lang.String r0 = A0B(r2, r1, r0)
            com.facebook.ads.redexgen.core.AnonymousClass54.A02(r0)
            long r4 = android.os.SystemClock.elapsedRealtime()
            r11.AHh(r12, r6)
            long r2 = r10.A0f
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r0 = r0 - r4
            long r2 = r2 + r0
            r10.A0f = r2
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AnonymousClass10.A12
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 21
            if (r1 == r0) goto L80
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AnonymousClass10.A12
            java.lang.String r1 = "NtBdNhJ"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "S1Pe4Cz"
            r0 = 0
            r2[r0] = r1
            com.facebook.ads.redexgen.core.AnonymousClass54.A00()
            com.facebook.ads.redexgen.X.6I r1 = r10.A0h
            int r0 = r1.A09
            int r0 = r0 + 1
            r1.A09 = r0
            r10.A0H()
            com.facebook.ads.redexgen.X.Fo r0 = r10.A0r
            boolean r0 = r0.A0G()
            if (r0 != 0) goto L7f
            long r2 = android.os.SystemClock.elapsedRealtime()
            r0 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r0
            r10.A0P = r2
            r10.A0K()
            r10.A27()
            r10.A0O()
        L7f:
            return
        L80:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A0c(com.facebook.ads.redexgen.X.B0, int, long, long, boolean):void");
    }

    public static void A0d(B0 b0, Surface surface) {
        b0.AJb(surface);
    }

    @MetaExoPlayerCustomization
    private void A0f(Object obj) {
        this.A0d = ((Boolean) obj).booleanValue();
        A1j();
    }

    private boolean A0g() {
        if (this.A0n <= 0) {
            return false;
        }
        boolean z = this.A0K == C.TIME_UNSET || System.currentTimeMillis() - this.A0K <= ((long) this.A0n);
        if (this.A0K == C.TIME_UNSET) {
            AbstractC09574g.A07(A0B(682, 23, 0), A0B(TypedValues.Custom.TYPE_FLOAT, 20, 62));
            this.A0K = System.currentTimeMillis();
        }
        return z;
    }

    public static boolean A0h() {
        return C5C.A02 >= 21;
    }

    public static boolean A0i() {
        return C5C.A02 <= 22 && A0B(1280, 6, 87).equals(C5C.A03) && A0B(725, 6, 88).equals(C5C.A05);
    }

    public static boolean A0k(long j) {
        return j < -30000;
    }

    public static boolean A0l(long j) {
        return j < -500000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A0m(long r11, long r13) {
        /*
            r10 = this;
            int r1 = r10.A9A()
            r0 = 2
            r9 = 1
            if (r1 != r0) goto L48
            r8 = 1
        L9:
            boolean r0 = r10.A0j
            if (r0 != 0) goto L40
            if (r8 != 0) goto L13
            boolean r0 = r10.A0g
            if (r0 == 0) goto L3e
        L13:
            r7 = 1
        L14:
            long r1 = android.os.SystemClock.elapsedRealtime()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            long r3 = r10.A0P
            long r1 = r1 - r3
            long r3 = r10.A0M
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L3c
            long r3 = r10.A1i()
            int r0 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r0 < 0) goto L3c
            if (r7 != 0) goto L3b
            if (r8 == 0) goto L3c
            boolean r0 = r10.A0p(r13, r1)
            if (r0 == 0) goto L3c
        L3b:
            return r9
        L3c:
            r9 = 0
            goto L3b
        L3e:
            r7 = 0
            goto L14
        L40:
            boolean r0 = r10.A0i
            if (r0 != 0) goto L46
            r7 = 1
            goto L14
        L46:
            r7 = 0
            goto L14
        L48:
            r8 = 0
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A0m(long, long):boolean");
    }

    private final boolean A0n(long j, long j2) {
        return A0l(j);
    }

    private final boolean A0o(long j, long j2) {
        return A0k(j);
    }

    private final boolean A0p(long j, long j2) {
        return A0k(j) && j2 > 100000;
    }

    private final boolean A0q(B0 b0, int i, long j, long j2) throws AD {
        int iA1Q = A1Q(j2);
        if (iA1Q == 0) {
            return false;
        }
        C6I c6i = super.A0h;
        int droppedSourceBufferCount = c6i.A06;
        c6i.A06 = droppedSourceBufferCount + 1;
        int droppedSourceBufferCount2 = this.A04;
        A0Q(droppedSourceBufferCount2 + iA1Q);
        A1m();
        if (!this.A0r.A0G()) {
            return true;
        }
        this.A0r.A09();
        throw null;
    }

    private boolean A0r(B3 b3) {
        return C5C.A02 >= 23 && this.A0e && !this.A0k && !A0u(b3.A03) && (!b3.A06 || DummySurface.A05(this.A0q));
    }

    /* JADX WARN: Removed duplicated region for block: B:404:0x09c9  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0be0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0u(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 3994
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A0u(java.lang.String):boolean");
    }

    public static boolean A0v(boolean z, C2725qI c2725qI, C2725qI c2725qI2) {
        return c2725qI.A0W.equals(c2725qI2.A0W) && c2725qI.A0F == c2725qI2.A0F && (z || (c2725qI.A0L == c2725qI2.A0L && c2725qI.A0A == c2725qI2.A0A)) && C5C.A1E(c2725qI.A0N, c2725qI2.A0N);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.AE
    public final void A1X() {
        super.A1X();
        this.A09 = 0;
        this.A0A = 0;
        this.A0B = 0;
        this.A0J = SystemClock.elapsedRealtime();
        this.A0P = SystemClock.elapsedRealtime() * 1000;
        if (this.A0w) {
            this.A0s.A0D();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.AE
    public final void A1Y() {
        this.A0M = C.TIME_UNSET;
        A0J();
        A0H();
        if (this.A0w) {
            this.A0s.A0E();
        }
        super.A1Y();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.AE
    public final void A1Z() {
        this.A08 = -1;
        this.A06 = -1;
        this.A01 = -1.0f;
        this.A02 = -1.0f;
        this.A0R = C.TIME_UNSET;
        this.A0O = C.TIME_UNSET;
        this.A0C = 0;
        A0F();
        A0E();
        this.A0t.A08();
        this.A00 = null;
        this.A0k = false;
        this.A0A = 0;
        this.A0B = 0;
        A0G();
        try {
            super.A1Z();
        } finally {
            super.A0h.A02();
            this.A0u.A09(super.A0h);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.AE
    public final void A1a(long j, boolean z) throws AD {
        super.A1a(j, z);
        if (this.A0r.A0G()) {
            this.A0r.A09();
            throw null;
        }
        A0E();
        if (this.A0w) {
            this.A0s.A0C();
        }
        this.A0N = C.TIME_UNSET;
        this.A0L = C.TIME_UNSET;
        this.A0O = C.TIME_UNSET;
        this.A0A = 0;
        this.A0B = 0;
        if (this.A0C != 0) {
            this.A0R = this.A0x[this.A0C - 1];
            this.A0C = 0;
        }
        if (z) {
            A0N();
        } else {
            this.A0M = C.TIME_UNSET;
        }
        A0H();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.AE
    public final void A1b(boolean z, boolean z2) throws AD {
        super.A1b(z, z2);
        this.A0k = A1V().A00;
        this.A0u.A0A(super.A0h);
        this.A0t.A09();
        this.A0g = z2;
        this.A0j = false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.AE
    public final void A1c(C2725qI[] c2725qIArr, long j, long j2) throws AD {
        if (this.A0R == C.TIME_UNSET) {
            this.A0R = j2;
        } else {
            if (this.A0C == this.A0x.length) {
                AbstractC09574g.A07(A0B(682, 23, 0), A0B(1069, 45, 88) + this.A0x[this.A0C - 1]);
            } else {
                this.A0C++;
            }
            long[] jArr = this.A0x;
            int i = this.A0C - 1;
            if (A12[1].charAt(20) != 's') {
                throw new RuntimeException();
            }
            A12[2] = "SAUgnWkYDj4XEzprgfj9YLgtcmW5pkCR";
            jArr[i] = j2;
            this.A0y[this.A0C - 1] = this.A0O;
        }
        super.A1c(c2725qIArr, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final int A1g(B0 b0, B3 b3, C2725qI c2725qI, C2725qI c2725qI2) {
        if (AbstractC2292is.A04(this.A0z, c2725qI.A0L, c2725qI.A0A, c2725qI2.A0L, c2725qI2.A0A)) {
            return 0;
        }
        if (A21() && c2725qI.A0W.equals(c2725qI2.A0W) && c2725qI.A0F == c2725qI2.A0F) {
            return 1;
        }
        if (!A0v(b3.A04, c2725qI, c2725qI2) || c2725qI2.A0L > this.A0W.A02 || c2725qI2.A0A > this.A0W.A00 || A00(c2725qI2) > this.A0W.A01) {
            return 0;
        }
        boolean zA0A = c2725qI.A0A(c2725qI2);
        if (A12[2].charAt(6) == 'n') {
            throw new RuntimeException();
        }
        A12[2] = "4hDLfGBXu2jWhDFi4VyshDOfpKmyRTIF";
        return zA0A ? 1 : 3;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final int A1h(BT bt, A6 a6, C2725qI c2725qI) throws BX {
        if (A24(c2725qI)) {
            return 20;
        }
        return A01(bt, c2725qI, super.A0j);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final List<B3> A1l(BT bt, C2725qI c2725qI, boolean z) throws BX {
        return A0D(bt, c2725qI, z);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final void A1m() throws AD {
        super.A1m();
        this.A04 = 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final void A1n() {
        try {
            super.A1n();
            this.A04 = 0;
            if (this.A0T != null) {
                if (this.A0U == this.A0T) {
                    this.A0U = null;
                }
                this.A0T.release();
                if (A12[3].length() == 21) {
                    throw new RuntimeException();
                }
                String[] strArr = A12;
                strArr[4] = "7lrYh0KktVrYvVNtOiQ9Yi2M4ixXH9PV";
                strArr[7] = "rg1WGkW3vr4OYC0nZllkbznbWLz7shBk";
                this.A0T = null;
            }
        } catch (Throwable th) {
            this.A04 = 0;
            if (this.A0T != null) {
                if (this.A0U == this.A0T) {
                    this.A0U = null;
                }
                this.A0T.release();
                this.A0T = null;
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final void A1q(long j) {
        super.A1q(j);
        this.A04--;
        while (this.A0C != 0 && j >= this.A0y[0]) {
            this.A0R = this.A0x[0];
            this.A0C--;
            System.arraycopy(this.A0x, 1, this.A0x, 0, this.A0C);
            System.arraycopy(this.A0y, 1, this.A0y, 0, this.A0C);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("for SR video effects support of MCM")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1r(com.facebook.ads.redexgen.core.C2725qI r6) {
        /*
            r5 = this;
            boolean r0 = r5.A24(r6)
            r3 = 0
            if (r0 == 0) goto L59
            com.facebook.ads.redexgen.X.qI r0 = r5.A0g
            if (r0 == 0) goto L31
            com.facebook.ads.redexgen.X.qI r0 = r5.A0g
            java.lang.String r4 = r0.A0W
            r2 = 1645(0x66d, float:2.305E-42)
            r1 = 10
            r0 = 45
            java.lang.String r0 = A0B(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L31
            r0 = 1
        L20:
            if (r0 == 0) goto L33
            com.facebook.ads.redexgen.X.Fo r0 = r5.A0r
            boolean r0 = r0.A0G()
            if (r0 == 0) goto L33
            com.facebook.ads.redexgen.X.Fo r0 = r5.A0r
            r0.A0A()
            r0 = 0
            throw r0
        L31:
            r0 = 0
            goto L20
        L33:
            com.facebook.ads.redexgen.X.Fo r0 = r5.A0r
            com.facebook.ads.redexgen.core.C1231Fo.A05(r0, r3)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AnonymousClass10.A12
            r0 = 2
            r1 = r1[r0]
            r0 = 6
            char r1 = r1.charAt(r0)
            r0 = 110(0x6e, float:1.54E-43)
            if (r1 == r0) goto L53
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AnonymousClass10.A12
            java.lang.String r1 = "sIGbpbi"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "eroBYPH"
            r0 = 0
            r2[r0] = r1
            return
        L53:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L59:
            com.facebook.ads.redexgen.X.jY r0 = com.facebook.ads.redexgen.core.EnumC2326jY.A09
            int r1 = com.facebook.ads.redexgen.core.MetaExoPlayerUpgradeConfig.A00(r0)
            if (r1 <= 0) goto L6c
            if (r6 == 0) goto L6c
            int r0 = r6.A0L
            if (r0 <= r1) goto L6c
            com.facebook.ads.redexgen.X.Fo r0 = r5.A0r
            com.facebook.ads.redexgen.core.C1231Fo.A05(r0, r3)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A1r(com.facebook.ads.redexgen.X.qI):void");
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final void A1s(C2725qI c2725qI) throws AD {
        super.A1s(c2725qI);
        this.A0u.A05(c2725qI, null);
        this.A02 = c2725qI.A02;
        this.A0D = c2725qI.A0F;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final void A1t(C2725qI c2725qI) throws AD {
        if (!this.A0r.A0G()) {
            this.A0r.A0J(c2725qI, A1i());
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final void A1u(C2646p0 c2646p0) {
        this.A04++;
        this.A0O = Math.max(c2646p0.A01, this.A0O);
        if (C5C.A02 < 23 && this.A0k) {
            A27();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final void A1v(B0 b0, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        this.A0S = mediaFormat;
        String strA0B = A0B(1229, 10, 102);
        boolean zContainsKey = mediaFormat.containsKey(strA0B);
        String strA0B2 = A0B(1239, 8, 55);
        String strA0B3 = A0B(1209, 11, 126);
        String strA0B4 = A0B(1220, 9, 2);
        boolean z = zContainsKey && mediaFormat.containsKey(strA0B4) && mediaFormat.containsKey(strA0B3) && mediaFormat.containsKey(strA0B2);
        if (z) {
            int integer3 = mediaFormat.getInteger(strA0B);
            int unappliedRotationDegrees = mediaFormat.getInteger(strA0B4);
            integer = (integer3 - unappliedRotationDegrees) + 1;
        } else {
            integer = mediaFormat.getInteger(A0B(1755, 5, 79));
        }
        this.A08 = integer;
        if (z) {
            int integer4 = mediaFormat.getInteger(strA0B3);
            int unappliedRotationDegrees2 = mediaFormat.getInteger(strA0B2);
            integer2 = (integer4 - unappliedRotationDegrees2) + 1;
        } else {
            integer2 = mediaFormat.getInteger(A0B(1307, 6, 73));
        }
        this.A06 = integer2;
        this.A01 = this.A02;
        if (C5C.A02 >= 21) {
            if (this.A0D == 90 || this.A0D == 270) {
                int rotatedHeight = this.A08;
                int unappliedRotationDegrees3 = this.A06;
                this.A08 = unappliedRotationDegrees3;
                this.A06 = rotatedHeight;
                this.A01 = 1.0f / this.A01;
            }
        } else if (!this.A0r.A0G()) {
            int unappliedRotationDegrees4 = this.A0D;
            this.A07 = unappliedRotationDegrees4;
        }
        int unappliedRotationDegrees5 = this.A0H;
        b0.AJs(unappliedRotationDegrees5);
        this.A0V = new C2678pW(this.A08, this.A06, this.A07, this.A01);
        this.A0s.A0F(super.A0g.A01);
        if (this.A0r.A0G()) {
            C1231Fo c1231Fo = this.A0r;
            C09162p c09162pA07 = super.A0g.A07();
            int unappliedRotationDegrees6 = this.A08;
            C09162p c09162pA0r = c09162pA07.A0r(unappliedRotationDegrees6);
            int unappliedRotationDegrees7 = this.A06;
            C09162p c09162pA0f = c09162pA0r.A0f(unappliedRotationDegrees7);
            int unappliedRotationDegrees8 = this.A07;
            c1231Fo.A0D(c09162pA0f.A0l(unappliedRotationDegrees8).A0Y(this.A01).A14());
            throw null;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    @MetaExoPlayerCustomizations({@MetaExoPlayerCustomization("D40834768: [FBLite][Video] Enable low latency decoding for older Android versions"), @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Google Platform Dav1d Testing with Low Latency Decoding D62649046")})
    public final void A1w(B3 b3, B0 b0, C2725qI c2725qI, MediaCrypto mediaCrypto) throws BX {
        this.A0W = A0A(b3, c2725qI, A1e());
        MediaFormat mediaFormatA08 = A08(c2725qI, this.A0W, this.A0v, this.A0o);
        if (this.A0U == null) {
            AbstractC09493y.A08(A0r(b3));
            if (this.A0T == null) {
                Context context = this.A0q;
                boolean z = b3.A06;
                if (A12[3].length() != 21) {
                    A12[6] = "yiNR3QranPnEQfiPRrhMyH37rGbgy01y";
                    this.A0T = DummySurface.A01(context, z);
                }
                throw new RuntimeException();
            }
            Surface surface = this.A0T;
            if (A12[2].charAt(6) != 'n') {
                String[] strArr = A12;
                strArr[5] = "LRboFGG";
                strArr[0] = "hwnKdFV";
                this.A0U = surface;
            }
            throw new RuntimeException();
        }
        boolean z2 = this.A0z.A0I;
        boolean z3 = false;
        String strA0B = A0B(1390, 11, 76);
        boolean z4 = z2 && b3.A00 != null && b3.A00.isFeatureSupported(strA0B);
        if (b3.A03.equals(A0B(1181, 28, 58)) && this.A0z.A0B) {
            z3 = true;
        }
        if ((C5C.A02 >= 30 || this.A0z.A0J) && z4 && !z3) {
            mediaFormatA08.setFeatureEnabled(strA0B, true);
            String[] strArr2 = A12;
            if (strArr2[5].length() != strArr2[0].length()) {
                String[] strArr3 = A12;
                strArr3[5] = "hfJ3VMX";
                strArr3[0] = "92OmzWl";
                mediaFormatA08.setInteger(strA0B, 1);
            } else {
                A12[3] = "U57WE1Icqa5Z";
                mediaFormatA08.setInteger(strA0B, 1);
            }
        }
        if (this.A0r.A0G()) {
            mediaFormatA08 = this.A0r.A06(mediaFormatA08);
        }
        if (this.A0r.A0G()) {
            C1231Fo c1231Fo = this.A0r;
            String[] strArr4 = A12;
            if (strArr4[4].charAt(23) == strArr4[7].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr5 = A12;
            strArr5[4] = "vjf6uovaHCWDHHkpYfphkXQkMzg9bbjD";
            strArr5[7] = "sOVWNDiAOc7Hvgm0kOVhLN9DKu4y3eSs";
            c1231Fo.A07();
            throw null;
        }
        b0.A58(mediaFormatA08, this.A0U, mediaCrypto, 0, this.A0Y);
        int i = C5C.A02;
        if (A12[6].charAt(29) != 'x') {
            A12[1] = "mXryJuZr86dScF3AeNkyss5tnbfSKjka";
            if (i < 23) {
                return;
            }
        } else {
            A12[6] = "iNbmoOXFYL62OfUeH4JwG1appoAFSKUM";
            if (i < 21) {
                return;
            }
        }
        if (this.A0k) {
            this.A00 = new C2528n5(this, b0);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    @MetaExoPlayerCustomization("D45988204: [FBLite][Video] Add Codec Hooks for Logging")
    public final void A1x(String str) {
        this.A0u.A0F(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final void A1y(String str, long j, long j2) {
        this.A0u.A0G(str, j, j2);
        this.A0b = A0u(str);
        if (this.A0w) {
            C1231Fo c1231Fo = this.A0r;
            if (A12[1].charAt(20) != 's') {
                throw new RuntimeException();
            }
            String[] strArr = A12;
            strArr[4] = "TMyTJm2xfuZjG3FrE9xxFPlKyVDcqwcD";
            strArr[7] = "gYDTbLVVgSlIu0qIAiA5ri17AONkCNH7";
            c1231Fo.A0E(str);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "D60404164: Merge init calls in the renderer")
    public final void A1z(String str, C2725qI c2725qI) throws AD {
        this.A0u.A0F(str);
        if (!this.A0r.A0G()) {
            this.A0r.A0J(c2725qI, A1i());
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final boolean A20() {
        return this.A0a && SystemClock.elapsedRealtime() - this.A0Q < 500;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final boolean A22() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0261, code lost:
    
        if (r6 < com.unity3d.services.core.di.ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0266, code lost:
    
        if (r6 < com.unity3d.services.core.di.ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0269, code lost:
    
        A0a(r42, r44, r0, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0272, code lost:
    
        r37.A0K = com.google.android.exoplayer2.C.TIME_UNSET;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x027a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x027b, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0280, code lost:
    
        if (A0g() != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0282, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0283, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c5, code lost:
    
        if (A0q(r42, r44, r0, r38) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c7, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01dd, code lost:
    
        if (A0q(r42, r44, r0, r38) != false) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A23(long r38, long r40, com.facebook.ads.redexgen.core.B0 r42, java.nio.ByteBuffer r43, int r44, int r45, long r46, boolean r48, boolean r49) throws com.facebook.ads.redexgen.core.AD {
        /*
            Method dump skipped, instruction units count: 754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.A23(long, long, com.facebook.ads.redexgen.X.B0, java.nio.ByteBuffer, int, int, long, boolean, boolean):boolean");
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g
    public final boolean A25(B3 b3) {
        return (this.A0U != null && (this.A0Z || this.A0U.isValid())) || A0r(b3);
    }

    public final Pair<ColorInfo, ColorInfo> A26(ColorInfo colorInfo) {
        if (!ColorInfo.A09(colorInfo)) {
            return Pair.create(ColorInfo.A09, ColorInfo.A09);
        }
        if (colorInfo.A03 == 7) {
            return Pair.create(colorInfo, colorInfo.A0A().A02(6).A03());
        }
        return Pair.create(colorInfo, colorInfo);
    }

    public final void A27() {
        this.A0j = true;
        if (!this.A0i) {
            this.A0i = true;
            this.A0u.A0D(this.A0U);
        }
    }

    @MetaExoPlayerCustomization("Required for VideoProcessorManager migration")
    public final boolean A28(long j, long j2, boolean z) {
        return A0k(j) && !z;
    }

    @Override // com.facebook.ads.redexgen.core.AE, com.facebook.ads.redexgen.core.InterfaceC10317c
    public final void A9i(int i, Object obj) throws AD {
        if (i == 1) {
            A0U((Surface) obj);
            return;
        }
        if (i == 4) {
            this.A0H = ((Integer) obj).intValue();
            B0 b0A1j = A1j();
            if (b0A1j == null) {
                return;
            }
            b0A1j.AJs(this.A0H);
            return;
        }
        if (i == 7) {
            this.A0X = (G2) obj;
            return;
        }
        if (i == 10001) {
            A0f(obj);
            return;
        }
        if (i == 13) {
            this.A0r.A0F((List) AbstractC09493y.A01(obj));
            return;
        }
        if (A12[3].length() != 21) {
            A12[1] = "MccsEzjpf2F4QgbfkxLUs5z2ugRdHbCL";
            if (i == 14) {
                C09764z c09764z = (C09764z) AbstractC09493y.A01(obj);
                if (c09764z.A03() == 0 || c09764z.A02() == 0) {
                    return;
                }
                Surface surface = this.A0U;
                String[] strArr = A12;
                if (strArr[5].length() == strArr[0].length()) {
                    A12[1] = "OmulH2jEP4hpWDROHXWwsVVsUaMV65qL";
                    if (surface == null) {
                        return;
                    }
                    this.A0r.A0C(this.A0U, c09764z);
                    return;
                }
            } else {
                super.A9i(i, obj);
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final boolean AAP() {
        boolean zAAP = super.AAP();
        boolean isEnded = this.A0r.A0G();
        if (isEnded) {
            boolean isEnded2 = this.A0r.A0I();
            return zAAP & isEnded2;
        }
        return zAAP;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.InterfaceC2634oo
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations({@com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("D18870411: Adding start stall debug reason"), @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D69547806: Only become ready once we have a surface")})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean AAe() {
        /*
            r9 = this;
            boolean r0 = super.AAe()
            if (r0 == 0) goto L22
            boolean r0 = r9.A0i
            if (r0 != 0) goto L22
            android.view.Surface r0 = r9.A0T
            if (r0 == 0) goto L14
            android.view.Surface r1 = r9.A0U
            android.view.Surface r0 = r9.A0T
            if (r1 == r0) goto L22
        L14:
            com.facebook.ads.redexgen.X.B0 r0 = r9.A1j()
            if (r0 == 0) goto L22
            boolean r0 = r9.A0k
            if (r0 != 0) goto L22
            com.facebook.ads.redexgen.X.ir r0 = com.facebook.ads.redexgen.core.EnumC2291ir.A08
            r9.A0B = r0
        L22:
            boolean r0 = super.AAe()
            r8 = 1
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L82
            com.facebook.ads.redexgen.X.Fo r0 = r9.A0r
            boolean r0 = r0.A0G()
            if (r0 == 0) goto L3e
            com.facebook.ads.redexgen.X.Fo r0 = r9.A0r
            boolean r0 = r0.A0H()
            if (r0 == 0) goto L82
        L3e:
            boolean r0 = r9.A0h
            if (r0 == 0) goto L67
            android.view.Surface r5 = r9.A0U
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AnonymousClass10.A12
            r0 = 1
            r1 = r1[r0]
            r0 = 20
            char r1 = r1.charAt(r0)
            r0 = 115(0x73, float:1.61E-43)
            if (r1 == r0) goto L59
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L59:
            java.lang.String[] r4 = com.facebook.ads.redexgen.core.AnonymousClass10.A12
            java.lang.String r1 = "iOSBWWk"
            r0 = 5
            r4[r0] = r1
            java.lang.String r1 = "3hctIGW"
            r0 = 0
            r4[r0] = r1
            if (r5 == 0) goto L82
        L67:
            boolean r0 = r9.A0i
            if (r0 != 0) goto L7f
            android.view.Surface r0 = r9.A0T
            if (r0 == 0) goto L75
            android.view.Surface r1 = r9.A0U
            android.view.Surface r0 = r9.A0T
            if (r1 == r0) goto L7f
        L75:
            com.facebook.ads.redexgen.X.B0 r0 = r9.A1j()
            if (r0 == 0) goto L7f
            boolean r0 = r9.A0k
            if (r0 == 0) goto L82
        L7f:
            r9.A0M = r2
            return r8
        L82:
            long r4 = r9.A0M
            r1 = 0
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 != 0) goto L8a
            return r1
        L8a:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r4 = r9.A0M
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L95
            return r8
        L95:
            r9.A0M = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AnonymousClass10.AAe():boolean");
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC08831g, com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final void AIX(long j, long j2) throws AD {
        super.AIX(j, j2);
        if (this.A0r.A0G()) {
            this.A0r.A0B(j, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo, com.facebook.ads.redexgen.core.InterfaceC10447p
    public final String getName() {
        return A0B(682, 23, 0);
    }
}
