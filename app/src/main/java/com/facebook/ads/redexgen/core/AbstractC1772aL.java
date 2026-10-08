package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1772aL {
    public static String[] A00 = {"JDSePW2HSG4YeS6gtlV", "82T2GFaLeV3aTbLMJos0KxEKOb8V", "eQCDfbwHDs1I63LCwtRfVvk7aOq68Yi1", "mKAtiPzaErPw2g5AsekgNJUywNJKgzbn", "W6CrCk7jl5WmpSSnHELA9a4ylCy3ZwGN", "yC8I8b2mmbmFe3RpkHIpYdmwx30s8PcH", "t7vLS6XVWI7z", "7V80TKFhnzYK6cwmq9Eavbn4uXT7"};

    public static EnumC1776aP A00(AbstractC2330jd abstractC2330jd) {
        if (abstractC2330jd.A2U()) {
            EnumC1776aP enumC1776aP = EnumC1776aP.A02;
            if (A00[3].charAt(31) != 'n') {
                throw new RuntimeException();
            }
            A00[0] = "myUXVCGo2IYKrTscb4wiG";
            return enumC1776aP;
        }
        return EnumC1776aP.A03;
    }

    public static void A01(C2165gi c2165gi, EnumC1773aM enumC1773aM) {
        c2165gi.A0F().AAz(enumC1773aM.name().toLowerCase(Locale.US));
    }

    public static void A02(C2165gi c2165gi, EnumC1773aM enumC1773aM) {
        c2165gi.A0F().AB9(enumC1773aM.name().toLowerCase(Locale.US));
    }

    public static void A03(C2165gi c2165gi, EnumC1773aM enumC1773aM) {
        c2165gi.A0F().AC7(enumC1773aM.name().toLowerCase(Locale.US));
    }

    public static void A04(C2165gi c2165gi, EnumC1773aM enumC1773aM) {
        A01(c2165gi, enumC1773aM);
    }

    public static void A05(C2165gi c2165gi, EnumC1773aM enumC1773aM) {
        A02(c2165gi, enumC1773aM);
    }

    public static void A06(C2165gi c2165gi, EnumC1773aM enumC1773aM) {
        A03(c2165gi, enumC1773aM);
    }

    public static void A07(VI vi, C2165gi c2165gi, InterfaceC1706Yh interfaceC1706Yh, AbstractC2330jd abstractC2330jd, EnumC1773aM enumC1773aM) {
        if (vi != null) {
            vi.A04(VH.A0A, null);
        }
        if (abstractC2330jd.A2Q()) {
            c2165gi.A0F().AB8(enumC1773aM.name().toLowerCase(Locale.US));
        }
        if (abstractC2330jd.A2U()) {
            c2165gi.A0F().AAy(enumC1773aM.name().toLowerCase(Locale.US));
        }
        C1455Og c1455OgA00 = AbstractC1456Oh.A00(c2165gi.A02());
        C2161ge c2161geA02 = c2165gi.A02();
        if (A00[6].length() != 12) {
            throw new RuntimeException();
        }
        A00[0] = "Fh7";
        if (c1455OgA00.A0O(c2161geA02, true)) {
            if (interfaceC1706Yh != null) {
                interfaceC1706Yh.AAo(abstractC2330jd.A2E(), abstractC2330jd.A2C());
            }
        } else {
            if (TextUtils.isEmpty(abstractC2330jd.A2C().A00())) {
                return;
            }
            X6.A0O(new X6(), c2165gi, XB.A00(abstractC2330jd.A2C().A00()), abstractC2330jd.A2E());
        }
    }
}
