package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import android.util.Log;
import com.adxcorp.ads.mediation.common.Constants;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.dynamicloading.FlashPreferences;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import java.lang.Thread;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class U2 {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03 = {"i0FOsf0o9fpBvAlaEaGgnCYFRbNnwBKJ", "ZsBa2nEfyhltTo", "ZG6g5nWnUhxh", "6zjosiDwJWE47kuMvKAUCDrCWUeR8P3q", "Gh89HIHHDqfPtiuASbXLVil627eRz", "Lsbp3nhJR34oAmuvtJAouWbaxC4Ny9OM", "s0Y", "C"};
    public static final AtomicBoolean A04;
    public static final AtomicBoolean A05;
    public static final AtomicBoolean A06;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-89, -39, -39, -89, -39, -88, -40, -84, -54, -58, -59, -7, -24, -19, -23, -14, -25, -23, -46, -23, -8, -5, -13, -10, -17, -88, -103, -96, 117, -66, -61, -66, -55, -66, -74, -63, -66, -49, -74, -55, -66, -60, -61, 117, -56, -55, -74, -57, -55, -70, -71, -84, -67, -60, 121, -48, -70, -52, 121, -70, -59, -53, -66, -70, -67, -46, 121, -62, -57, -62, -51, -62, -70, -59, -62, -45, -66, -67, 122, 121, -84, -60, -62, -55, -55, -62, -57, -64, -121, -90, -68, -62, 109, -79, -68, -69, 116, -63, 109, -80, -82, -71, -71, 109, -114, -62, -79, -74, -78, -69, -80, -78, -101, -78, -63, -60, -68, -65, -72, -114, -79, -64, 123, -74, -69, -74, -63, -74, -82, -71, -74, -57, -78, 117, 118, 123, 109, -96, -68, -70, -78, 109, -77, -62, -69, -80, -63, -74, -68, -69, -82, -71, -74, -63, -58, 109, -70, -82, -58, 109, -69, -68, -63, 109, -60, -68, -65, -72, 109, -67, -65, -68, -67, -78, -65, -71, -58, 123, -120, -105, -112, -58, -52, -63, -45, -56, 0, 6, -5, Ascii.CR, 2, -7, -3, 9, 8, 0, 3, 1, -42, -44, -35, -44, -31, -40, -46, -3, 2, -3, 8, -3, -11, 0, -3, Ascii.SO, -7, -51, -46, -51, -40, -51, -59, -48, -51, -34, -55, -116, -115, -124, -46, -45, -40, -124, -57, -59, -48, -48, -55, -56, -110, 1, -10, 8, 9, -12, 7, -6, 8, 10, 1, 9};
    }

    static {
        A03();
        A06 = new AtomicBoolean();
        A04 = new AtomicBoolean();
        A05 = new AtomicBoolean();
    }

    public static C2009eB A00() {
        return new C2009eB();
    }

    public static C2008eA A01(C2161ge c2161ge) {
        return new C2008eA(c2161ge);
    }

    public static void A04(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        Y4.A01.execute(new C2010eC(initListener, initResult));
    }

    public static void A06(C2161ge c2161ge) {
        if (AbstractC1617Ur.A0P(c2161ge) && !A05.getAndSet(true)) {
            try {
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = new TT(Thread.getDefaultUncaughtExceptionHandler(), c2161ge, new C1943d6());
                Thread.setDefaultUncaughtExceptionHandler(defaultUncaughtExceptionHandler);
            } catch (Exception e) {
                c2161ge.A08().ABC(A02(198, 7, 78), AbstractC1577Td.A1X, new C1578Te(e));
            }
        }
    }

    public static void A07(C2161ge c2161ge) {
        A0H(c2161ge, null, null, 3);
    }

    public static void A08(C2161ge c2161ge) {
        A0H(c2161ge, null, null, 3);
    }

    public static void A09(C2161ge c2161ge) {
        if (C1615Up.A2O(c2161ge)) {
            A0F(c2161ge, 0);
        }
        if (C1615Up.A2X(c2161ge)) {
            A0B(c2161ge);
        }
    }

    public static void A0A(C2161ge c2161ge) {
        if (C1615Up.A2P(c2161ge)) {
            String[] strArr = A03;
            if (strArr[1].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[1] = "XjvPwbQrSqkAxC";
            strArr2[6] = "skO";
            A0G(c2161ge, null, 3);
        }
    }

    public static void A0B(C2161ge c2161ge) {
        YG.A06.execute(new C2011eD(c2161ge));
    }

    public static void A0C(C2161ge c2161ge) {
        OP.A02(c2161ge);
        TX.A0C(c2161ge, new C1913cc(c2161ge), new C2061f2(), BuildConfigApi.isDebug());
        c2161ge.A0A();
        A0D(c2161ge);
    }

    public static void A0D(C2161ge c2161ge) {
        if (ProcessUtils.isRemoteRenderingProcess()) {
            return;
        }
        SharedPreferences sharedPreferences = FlashPreferences.getSharedPreferences(c2161ge);
        String string = sharedPreferences.getString(A02(186, 12, 121), null);
        String string2 = sharedPreferences.getString(A02(239, 11, 116), null);
        if (string != null && string2 != null) {
            InterfaceC1576Tc interfaceC1576TcA08 = c2161ge.A08();
            C1578Te c1578Te = new C1578Te(string2);
            String flashConfig = A02(181, 5, 63);
            interfaceC1576TcA08.ABz(flashConfig, 3701, c1578Te);
        }
    }

    public static void A0F(C2161ge c2161ge, int i) {
        T7.A01(c2161ge);
        if (A04.getAndSet(true)) {
            return;
        }
        if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isDebuggerOn()) {
            AbstractC1648Vy.A02();
        }
        A06(c2161ge);
        AbstractC1655Wf.A00(C1615Up.A0q(c2161ge), BuildConfigApi.isDebug(), A00(), A01(c2161ge));
        C1556Si.A03(C1615Up.A04(c2161ge));
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            C2134gD.A09(new C1999e1(c2161ge));
        }
        if (i == 3) {
            Log.e(A02(8, 17, 99), A02(89, 89, 44));
            c2161ge.A08().ABz(A02(178, 3, 6), AbstractC1577Td.A0R, new C1578Te(A02(215, 24, 67)));
        }
        ActivityUtils.A04(c2161ge, AudienceNetworkActivity.class);
        YG.A05(c2161ge);
        VL.A05(c2161ge);
        N8.A01(c2161ge);
        if (C1615Up.A16(c2161ge)) {
            RX.A00(c2161ge);
        }
        if (C1615Up.A1z(c2161ge)) {
            ZR.A02().A90(c2161ge);
        }
    }

    public static void A0G(C2161ge c2161ge, AudienceNetworkAds.InitListener initListener, int i) {
        T7.A01(c2161ge);
        boolean z = false;
        synchronized (U2.class) {
            boolean execute = A00;
            if (!execute) {
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        boolean execute2 = A01;
                        if (!execute2) {
                            A01 = true;
                            z = true;
                        }
                    }
                } else {
                    A00 = true;
                    z = true;
                }
            }
        }
        if (z) {
            A0F(c2161ge, i);
            YG.A08.execute(new C2036ed(c2161ge, initListener));
        } else {
            if (i != 1) {
                return;
            }
            String strA02 = A02(51, 38, 56);
            if (initListener != null) {
                A04(initListener, new U1(true, strA02));
            } else {
                Log.w(A02(8, 17, 99), strA02);
            }
        }
    }

    public static void A0H(C2161ge c2161ge, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener, int i) {
        AbstractC1648Vy.A05(A02(Constants.NEXT_STEP, 10, 115), A02(25, 26, 52), A02(0, 8, 82));
        C2134gD.A06();
        A0G(c2161ge, initListener, i);
    }

    public static synchronized boolean A0I() {
        return A00;
    }
}
