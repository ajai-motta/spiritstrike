package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class UJ {
    public static String A00;
    public static byte[] A01;
    public static String[] A02 = {"qZcb6NmBns1n3v1", "rTLETUx3xNnjwSb02Sx6jVZM5Fuzg7Of", "ujF8Yx1ooHYTWOANWsLoHgp9GHsWq5OG", "emoc9RIZRY17k1iV3jHEmbNdIKvpuqWe", "9dj0hHqqeHaqkXambHAPXjsskYxWzSoy", "H6Wp9lsP8ocDK9Bk7hE2Cfl7XjXVKK5i", "baRwZ59Bd0PN8tFBdjuxnLHZSOlJTNRT", "2xLvEFwTfIQTf34sGOrn6donSx3FaGAc"};
    public static final AtomicReference<String> A03;
    public static final AtomicBoolean A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A01 = new byte[]{-56, 3, -18, -22, -23, -10, -41, -23, Ascii.GS, Ascii.FF, 17, Ascii.CR, Ascii.SYN, Ascii.VT, Ascii.CR, -10, Ascii.CR, Ascii.FS, Ascii.US, Ascii.ETB, Ascii.SUB, 19, -18, Ascii.ETB, Ascii.SUB, -23, Ascii.SYN, Ascii.FF, Ascii.SUB, Ascii.ETB, 17, Ascii.FF, -29, -18, -22, -5, -10, -41, 6, -18, -7, -11, -12, 9, -30, -18, -7, -11, -11, 9, -30, -71, -60, -64, -54, -63, -83, -53, -42, -46, -29, -26, -65, -63, -67, -68, -67, -86, -55, -59, -39, -42, -78, SignedBytes.MAX_POWER_OF_TWO, 57, 79, 62, 69, 60, 60, 54, 79, 76, 79, 80, 88, 79, -9, 57, 69, 67, 4, 60, 55, 57, 59, 56, 69, 69, 65, 4, 55, 58, 73, 4, 63, 68, 74, 59, 72, 68, 55, 66, 4, 75, 55, 52, 50, 59, 50, 63, 54, 48, Ascii.EM, 37, 37, 33, -33, Ascii.DC2, Ascii.CAN, Ascii.SYN, Ascii.US, 37, Ascii.US, Ascii.GS, Ascii.SI, Ascii.FS, 9, Ascii.VT, 17, Ascii.SI, Ascii.CAN, Ascii.RS, -20, -22, -36, -23, -42, -40, -34, -36, -27, -21, -42, -29, -40, -22, -21, -42, -23, -36, -35, -23, -36, -22, -33, 59, 41, 38, 35, 58, 45, 41, 59};
    }

    static {
        A07();
        A00 = A00(80, 7, 107);
        A04 = new AtomicBoolean();
        A03 = new AtomicReference<>();
    }

    public static String A01(T8 t8) {
        return WebSettings.getDefaultUserAgent(t8);
    }

    public static String A02(T8 t8) {
        FutureTask futureTask = new FutureTask(new UI(t8));
        for (int i = 0; i < 3; i++) {
            Y4.A00(futureTask);
            try {
                return (String) futureTask.get();
            } catch (Throwable th) {
                A08(t8, th);
                SystemClock.sleep(500L);
            }
        }
        return null;
    }

    public static String A03(T8 t8, C1588To c1588To) {
        String strA07 = c1588To.A07();
        if (TextUtils.isEmpty(strA07) && !A04.getAndSet(true)) {
            InterfaceC1576Tc interfaceC1576TcA08 = t8.A08();
            int i = AbstractC1577Td.A1Z;
            String bundle = A00(73, 7, 122);
            C1578Te c1578Te = new C1578Te(bundle);
            String bundle2 = A00(116, 7, 87);
            interfaceC1576TcA08.ABC(bundle2, i, c1578Te);
        }
        return strA07;
    }

    public static String A04(T8 t8, boolean z) {
        if (t8 == null) {
            return A00;
        }
        if (z) {
            return System.getProperty(A00(123, 10, 59));
        }
        String str = A03.get();
        if (str != null) {
            return str;
        }
        long spUserAgentRefresh = AbstractC1614Uo.A01(t8);
        String strA00 = A00(143, 23, 1);
        String strA002 = A00(133, 10, 52);
        String strA003 = A00(88, 28, 96);
        if (spUserAgentRefresh > 0) {
            SharedPreferences sharedPreferences = t8.getSharedPreferences(ProcessUtils.getProcessSpecificName(strA003, t8), 0);
            String string = sharedPreferences.getString(strA002, null);
            long j = sharedPreferences.getLong(strA00, 0L);
            if (!TextUtils.isEmpty(string) && System.currentTimeMillis() - j < spUserAgentRefresh) {
                A03.set(string);
                String[] strArr = A02;
                String str2 = strArr[6];
                String browserUserAgent = strArr[3];
                if (str2.charAt(17) != browserUserAgent.charAt(17)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[6] = "raDju45r7vWAWvtCMjs7ezmbeHuUzRMZ";
                strArr2[3] = "IEXEfOXuBGyf1jRfSjx88B0PyUJh9Pa6";
                return string;
            }
        }
        String strA02 = null;
        try {
            strA02 = A01(t8);
            A03.set(strA02);
        } catch (Throwable t) {
            A08(t8, t);
        }
        if (strA02 == null) {
            strA02 = A02(t8);
        }
        if (strA02 == null) {
            return A00;
        }
        if (spUserAgentRefresh > 0) {
            SharedPreferences sharedPreferences2 = t8.getSharedPreferences(ProcessUtils.getProcessSpecificName(strA003, t8), 0);
            sharedPreferences2.edit().putString(strA002, A03.get()).apply();
            sharedPreferences2.edit().putLong(strA00, System.currentTimeMillis()).apply();
        }
        return strA02;
    }

    public static String A05(C1588To c1588To, T8 t8) {
        if (AbstractC1614Uo.A04(t8)) {
            return A00(63, 5, 5) + A03(t8, c1588To) + A00(39, 6, 61) + c1588To.A06() + A00(45, 6, 61) + c1588To.A04() + A00(38, 1, 85);
        }
        return A00(0, 0, 76);
    }

    public static String A06(C1588To c1588To, T8 t8, boolean z) {
        return A04(t8, z) + A00(0, 38, 50) + t8.A05().A9S() + A00(57, 6, 26) + C1588To.A04 + A00(38, 1, 85) + A05(c1588To, t8) + A00(68, 5, 13) + t8.A05().A9T() + A00(51, 6, 8) + Locale.getDefault().toString() + A00(87, 1, 36);
    }

    public static void A08(T8 t8, Throwable th) {
        t8.A08().ABC(A00(166, 8, 78), AbstractC1577Td.A2i, new C1578Te(th));
    }
}
