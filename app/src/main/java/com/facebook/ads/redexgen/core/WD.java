package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class WD {
    public static byte[] A08;
    public static String[] A09 = {"gkSyaXwR", "2VU3Nz3voiV1lmdRee4U2QJOpqB0EmXx", "l2PJ1mhNLKomP6h8XAPCJTvwOfm7DNfm", "U14uMoZpedA5MoqMp8wF", "ZGFJtzG5houIZuhA5wVIi53yZAjLLlX2", "TKuU0S0TRmpOZ7a0gUh222TH0KiJMCsX", "Ntgwe7QRVjptK5Vt0gMbvLxTukJluaCr", "4nIPbhAhAn1Dg8Q4wgXTfE5Yoh5xfpBP"};
    public static final YE A0A;
    public static final Executor A0B;
    public static final AtomicReference<WH> A0C;
    public long A00;
    public long A01;
    public WC A02;
    public Map<String, String> A03;
    public final C1455Og A04;
    public final C2165gi A05;
    public final WE A06;
    public final String A07;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A08 = new byte[]{113, 107, -97, 108, 106, 111, -96, 112, -32, -15, -17, -21, -19, -25, -16, -19, -23, -14, -8, 3, -10, -23, -11, -7, -23, -9, -8, 3, -19, -24, -126, -84, 89, -117, -121, 115, 89, -62, -61, -108, -70, -67, -64, -64, -108, -26, -39, -41, -39, -35, -22, -39, -40, -39, -6, -85, -47, -12, -9, -9, -85, -16, -3, -3, -6, -3, -85, -18, -6, -17, -16, -85, -26, -80, -2, -24, -85, -80, -2, -33, -35, -26, -35, -22, -31, -37, -57, -66, -51, -48, -56, -53, -60, 10, Ascii.VT, -30, 5, 8, 8, -28, Ascii.VT, Ascii.VT, 7, -35, -33, -36, -29, -42, -47, -46};
    }

    static {
        A0B();
        A0A = new YE();
        A0B = Executors.newCachedThreadPool(A0A);
        A0C = new AtomicReference<>();
    }

    public WD(C2165gi c2165gi) {
        this(c2165gi, AbstractC1456Oh.A00(c2165gi.A02()));
    }

    public WD(C2165gi c2165gi, C1455Og c1455Og) {
        this.A01 = -1L;
        this.A00 = -1L;
        this.A05 = c2165gi;
        this.A06 = WE.A00();
        this.A07 = WI.A01(c2165gi);
        this.A04 = c1455Og;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1559Sl A03(long j, WA wa) {
        return new C1559Sl(this, wa, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        if (this.A05 == null || !C2134gD.A0A(this.A05)) {
            return;
        }
        C1578Te c1578Te = new C1578Te(A06(8, 5, 102));
        c1578Te.A05(1);
        this.A05.A08().ABC(A06(86, 7, 32), AbstractC1577Td.A1x, c1578Te);
    }

    private void A0C(int i, String str) {
        String strA06 = A06(37, 16, 59);
        String strA062 = A06(0, 8, 1);
        String strA063 = A06(93, 10, 99);
        AbstractC1648Vy.A05(strA063, strA06, strA062);
        AbstractC1648Vy.A04(strA063, String.format(Locale.US, A06(53, 26, 82), Integer.valueOf(i), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(C1637Vm c1637Vm) {
        if (this.A02 != null) {
            this.A02.ADp(c1637Vm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(C1637Vm c1637Vm) {
        Y4.A00(new RO(this, c1637Vm));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L(RG rg) {
        if (this.A02 != null) {
            this.A02.AG7(rg);
        } else {
            if (rg.A00() == null || rg.A00().A06() == null) {
                return;
            }
            C1661Wl.A00(this.A05).A0D(rg.A00().A06().toString(), rg.A00().A0B());
        }
    }

    private void A0M(RG rg) {
        TE syncModule;
        Y4.A00(new SO(this, rg));
        if (C1615Up.A2e(this.A05) && (syncModule = this.A05.A06()) != null) {
            syncModule.A6d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0N(String str, long j, WA wa) {
        String clientChallenge;
        try {
            try {
                WG wgA07 = this.A06.A07(this.A05, str, j);
                C1596Tw c1596TwA00 = wgA07.A00();
                if (c1596TwA00 != null) {
                    C1615Up.A0V(this.A05).A36(c1596TwA00.A0A());
                    if (C1615Up.A0x(this.A05) && c1596TwA00.A08() != null) {
                        U6.A04(this.A05.A02(), c1596TwA00.A08());
                    }
                    if (C1615Up.A0y(this.A05) && c1596TwA00.A0D() != null) {
                        U6.A05(this.A05.A02(), c1596TwA00.A0D());
                    }
                    this.A05.A08().ACP();
                    this.A04.A0N(c1596TwA00.A07());
                    W9.A05(c1596TwA00.A05().A0B(), wa);
                    YS.A01(this.A05, A0B, c1596TwA00);
                    C1578Te c1578Te = new C1578Te(A06(30, 7, 0) + XY.A02());
                    c1578Te.A06(1);
                    c1578Te.A0A(false);
                    this.A05.A08().ACA(A06(79, 7, 63), AbstractC1577Td.A1W, c1578Te);
                }
                switch (wgA07.A01()) {
                    case A02:
                        RG rg = (RG) wgA07;
                        if (c1596TwA00 != null) {
                            if (c1596TwA00.A05().A0E()) {
                                W9.A07(str, wa);
                            }
                            if (this.A03 != null) {
                                clientChallenge = this.A03.get(A06(13, 17, 107));
                            } else {
                                clientChallenge = null;
                            }
                            if (!TextUtils.isEmpty(wgA07.A02()) && !TextUtils.isEmpty(clientChallenge)) {
                                this.A05.A03().AIi(this.A05, clientChallenge, wgA07.A02());
                            }
                        }
                        this.A05.A0F().A3X(Y1.A01(this.A01), Y1.A02(this.A01, this.A00));
                        A0M(rg);
                        return;
                    case A03:
                        R4 r4 = (R4) wgA07;
                        String strA04 = r4.A04();
                        AdErrorType adErrorTypeAdErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(r4.A03(), AdErrorType.ERROR_MESSAGE);
                        A0C(r4.A03(), strA04);
                        if (strA04 == null) {
                            strA04 = str;
                        }
                        this.A05.A0F().A3W(Y1.A01(this.A01), adErrorTypeAdErrorTypeFromCode.getErrorCode(), strA04, adErrorTypeAdErrorTypeFromCode.isPublicError());
                        A0E(C1637Vm.A01(adErrorTypeAdErrorTypeFromCode, strA04));
                        return;
                    default:
                        AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                        this.A05.A0F().A3W(Y1.A01(this.A01), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                        A0E(C1637Vm.A01(adErrorType, str));
                        return;
                }
            } catch (Exception e) {
                e = e;
                String message = e.getMessage();
                AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
                C2165gi c2165gi = this.A05;
                if (A09[0].length() == 29) {
                    throw new RuntimeException();
                }
                A09[0] = "STn1t4NLUPoQ";
                c2165gi.A0F().A3W(Y1.A01(this.A01), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
                A0E(C1637Vm.A01(adErrorType2, message));
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(String str, long j, WA wa) {
        A0B.execute(new C1565Sr(this, str, j, wa));
    }

    private boolean A0P(WA wa) {
        String string = wa.A06().toString();
        if (C1661Wl.A00(this.A05).A0F(string)) {
            return false;
        }
        int iA0A = C1661Wl.A00(this.A05).A0A(string);
        int storedAdsCount = C1615Up.A0J(this.A05);
        int iA09 = C1661Wl.A00(this.A05).A09(string);
        if (iA0A >= storedAdsCount || iA0A > iA09) {
            C1661Wl c1661WlA00 = C1661Wl.A00(this.A05);
            String type = wa.A06().toString();
            Pair<String, String> pairA0B = c1661WlA00.A0B(type);
            if (pairA0B != null) {
                Object obj = pairA0B.second;
                String[] strArr = A09;
                String str = strArr[1];
                String str2 = strArr[4];
                int storedAdsCount2 = str.charAt(27);
                if (storedAdsCount2 == str2.charAt(27)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A09;
                strArr2[5] = "wxWvHA1chxzz72CPhzVDSI5kTKVxH7gh";
                strArr2[2] = "qa9WwGn6xu1bvFfukLGFlV7cMdAOaohF";
                if (obj != null && pairA0B.first != null) {
                    A0O(pairA0B.second.toString(), 0L, wa);
                    return true;
                }
            }
        }
        return false;
    }

    public final void A0Q(WA wa) {
        this.A01 = System.currentTimeMillis();
        C1587Tn.A0B(this.A05);
        A0C.get();
        if (0 != 0) {
            throw new NullPointerException(A06(103, 7, 52));
        }
        if (C1615Up.A02(this.A05) > 0 && A0P(wa)) {
            return;
        }
        if (W9.A08(wa)) {
            YG.A06.execute(new C1580Tg(this));
            String strA02 = W9.A02(wa);
            if (strA02 != null) {
                this.A05.A0F().AKg();
                A0O(strA02, 0L, wa);
                return;
            } else {
                AdErrorType error = AdErrorType.LOAD_TOO_FREQUENTLY;
                this.A05.A0F().A3W(Y1.A01(this.A01), error.getErrorCode(), error.getDefaultErrorMessage(), error.isPublicError());
                A0E(C1637Vm.A01(error, null));
                return;
            }
        }
        A0B.execute(new TZ(this, wa));
    }

    public final void A0R(WC wc) {
        this.A02 = wc;
    }
}
