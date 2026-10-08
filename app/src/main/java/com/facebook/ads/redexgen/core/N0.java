package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.facebook.ads.internal.action.UserReturnTracker$UserReturnListener;
import com.facebook.ads.redexgen.core.N0;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Ascii;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class N0 {
    public static byte[] A09;
    public static String[] A0A = {"jjDsG8QlYrxY", "", "TMhFK0S9G1", "6qW7u5SP6R0wlmhQUiBuXDFp8yf", "n7Dasyj9dq5sG0xOL43e0c5rVQV9l70l", "dOqhBdKnx9bW", "a7CXWDqETze4gqUmjqRBhcRjVGu0d2y8", "nE3PHSl6bqsIePbBJ"};
    public static final String A0B;
    public Application A02;
    public InterfaceC1416Ms A04;
    public UserReturnTracker$UserReturnListener A05;
    public final VA A08;
    public long A01 = 0;
    public long A00 = 0;
    public String A06 = null;
    public EnumC1414Mq A03 = null;
    public boolean A07 = false;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A09 = new byte[]{104, 83, 92, 95, 81, 88, Ascii.GS, 73, 82, Ascii.GS, 113, 82, 90, Ascii.GS, 104, 78, 88, 79, Ascii.GS, 111, 88, 73, 72, 79, 83, Ascii.GS, 74, 85, 88, 83, Ascii.GS, 73, 82, 86, 88, 83, Ascii.GS, 84, 78, Ascii.GS, 83, 72, 81, 81, 19, 2, 1, 3, Ascii.VT, 63, Ascii.DC4, 9, Ascii.CR, 5, Ascii.DC2, Ascii.ESC, Ascii.US, 8, Ascii.ESC, 33, 10, Ascii.ETB, 19, Ascii.ESC, 60, 38, 39, 48, 60, 62, 54, 118, 97, 116, 107, 118, 112, 109, 106, 99};
    }

    static {
        A03();
        A0B = N0.class.getSimpleName();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.facebook.ads.internal.action.UserReturnTracker$UserReturnListener] */
    public N0(VA va, final Activity activity, int i) {
        this.A08 = va;
        this.A02 = activity.getApplication();
        this.A05 = new Application.ActivityLifecycleCallbacks(activity, this) { // from class: com.facebook.ads.internal.action.UserReturnTracker$UserReturnListener
            public N0 A00;
            public final WeakReference<Activity> A01;

            {
                this.A01 = new WeakReference<>(activity);
                this.A00 = this;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity2) {
                if (this.A00 == null) {
                    return;
                }
                Activity trackedActivity = this.A01.get();
                if (trackedActivity == null || (trackedActivity != null && activity2.equals(trackedActivity))) {
                    this.A00.A05();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStopped(Activity activity2) {
            }
        };
    }

    public static N0 A00(VA va, Activity activity) {
        return A01(va, activity, Build.VERSION.SDK_INT);
    }

    public static N0 A01(VA va, Activity activity, int i) {
        if (activity != null && i >= 14) {
            return new N0(va, activity, i);
        }
        return null;
    }

    private void A04(String str, long j, long j2, EnumC1414Mq enumC1414Mq) {
        HashMap map = new HashMap();
        map.put(A02(54, 10, 111), Long.toString(j));
        map.put(A02(45, 9, 113), Long.toString(j2));
        if (enumC1414Mq != null) {
            map.put(A02(64, 7, 66), enumC1414Mq.name());
        }
        this.A08.AC9(str, map);
    }

    public final void A05() {
        this.A00 = System.currentTimeMillis();
        if (this.A00 - this.A01 < ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS && this.A04 != null) {
            InterfaceC1416Ms interfaceC1416Ms = this.A04;
            if (A0A[2].length() != 10) {
                throw new RuntimeException();
            }
            A0A[1] = "";
            interfaceC1416Ms.AFa();
        }
        if (this.A06 != null) {
            A04(this.A06, this.A01, this.A00, this.A03);
        } else {
            Application application = this.A02;
            String strA02 = A02(0, 45, 44);
            if (application != null && (this.A02.getBaseContext() instanceof C2165gi)) {
                ((C2165gi) this.A02.getBaseContext()).A08().ABC(A02(71, 9, 21), AbstractC1577Td.A22, new C1578Te(strA02));
            }
            Log.w(A0B, strA02);
        }
        if (this.A02 != null && this.A05 != null) {
            this.A02.unregisterActivityLifecycleCallbacks(this.A05);
            this.A07 = false;
        }
    }

    public final void A06(EnumC1414Mq enumC1414Mq) {
        this.A03 = enumC1414Mq;
    }

    public final void A07(InterfaceC1416Ms interfaceC1416Ms) {
        this.A04 = interfaceC1416Ms;
    }

    public final void A08(String str) {
        this.A06 = str;
        this.A01 = System.currentTimeMillis();
        if (this.A05 == null || this.A02 == null || this.A07) {
            A04(str, -1L, -1L, EnumC1414Mq.A05);
        } else {
            this.A07 = true;
            this.A02.registerActivityLifecycleCallbacks(this.A05);
        }
    }
}
