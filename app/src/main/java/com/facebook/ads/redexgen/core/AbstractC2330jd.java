package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.adapters.datamodels.AdInfo;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2330jd extends NQ implements Serializable {
    public static JSONObject A0R = null;
    public static byte[] A0S = null;
    public static String[] A0T = {"MTFiGS2hyLPfirnVlCyKu8FL5ydCU71a", "6CtUdYtPnHS0iwt", "3FBcQYGRSJhXKbj7ODsddhFyR1abGnGF", "UQ7LtGE24TX4QkAlsGDlXXS4Vcev", "JcPJu", "s3C", "M3uL5ar3Pz1QrNsTamNzt8iOeyqnSnZC", "bpoJK"};
    public static final LinkedHashMap<String, String> A0U;
    public static final long serialVersionUID = -5352540727250859603L;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public NN A06;
    public C1429Ng A07;
    public C1432Nj A08;
    public C1435Nm A09;
    public C1441Ns A0A;
    public String A0B;
    public String A0C;
    public boolean A0E;
    public final List<NR> A0P;
    public boolean A0D = false;
    public boolean A0F = false;
    public boolean A0L = false;
    public boolean A0K = false;
    public boolean A0H = false;
    public boolean A0I = false;
    public boolean A0G = false;
    public boolean A0J = false;
    public final Map<String, String> A0Q = new HashMap();
    public int A05 = 5000;
    public boolean A0O = false;
    public boolean A0N = false;
    public boolean A0M = false;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0S, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0S = new byte[]{81, 84, 111, 83, 88, 95, 89, 83, 85, 67, 111, 92, 89, 94, 91, 111, 69, 66, 92, 122, 117, 68, 119, 116, 124, 116, 68, 111, 98, 107, 126, Ascii.GS, Ascii.DC2, Ascii.NAK, 17, Ascii.GS, 8, Ascii.EM, 35, Ascii.US, Ascii.SO, Ascii.EM, Ascii.CAN, Ascii.NAK, 8, 35, Ascii.DLE, Ascii.NAK, Ascii.DC2, Ascii.EM, 53, 58, Base64.padSymbol, 57, 53, 32, 49, Ascii.VT, 55, 38, 49, 48, Base64.padSymbol, 32, Ascii.VT, 56, Base64.padSymbol, 58, 49, Ascii.VT, 53, 33, 32, 59, Ascii.VT, 55, 56, 59, 39, 49, Ascii.VT, 57, Base64.padSymbol, 56, 56, Base64.padSymbol, 76, 88, 89, 66, 78, 65, 68, 78, 70, 114, 78, 66, 88, 67, 89, 73, 66, 90, 67, 114, 89, 68, SignedBytes.MAX_POWER_OF_TWO, 72, 87, 67, 66, 89, 85, 90, 95, 85, 93, 105, 85, 66, 87, 105, 66, 95, 91, 83, 47, 59, 58, 33, 45, 34, 39, 45, 37, 17, 40, 34, 47, 56, 33, 60, 59, 57, 59, 48, Base64.padSymbol, 7, 57, 43, 43, Base64.padSymbol, 44, 43, Ascii.SI, Ascii.CR, Ascii.RS, 3, Ascii.EM, Ascii.US, 9, 0, 6, Ascii.CR, 4, Ascii.FF, Ascii.VT, 58, 4, 1, Ascii.SYN, 58, 3, Ascii.ETB, 0, Ascii.DC4, Ascii.DLE, 0, Ascii.VT, 6, Ascii.FS, 92, 80, 82, 17, 89, 94, 92, 90, 93, 80, 80, 84, 17, 94, 91, 76, 17, 86, 81, 75, 90, 77, 76, 75, 86, 75, 86, 94, 83, 17, 89, 86, 81, 86, 76, 87, 96, 94, 92, 75, 86, 73, 86, 75, 70, 33, 48, 39, 38, 43, 54, Ascii.GS, 46, 43, 44, 39, Ascii.GS, 43, 44, 36, 45, Ascii.GS, 54, 39, 58, 54, 111, 120, 89, 78, 81, 98, 92, 77, 77, 98, 95, 82, 72, 83, 89, 98, 72, 79, 81, 78, 119, 115, 37, 112, 78, 118, 97, 78, 126, 103, 116, 99, 125, 112, 104, 78, 98, 116, 114, 100, 99, 116, 78, 101, 126, 122, 116, 127, 70, 76, SignedBytes.MAX_POWER_OF_TWO, 65, 83, 84, 73, 78, 91, 86, 86, 101, 72, 95, 92, 95, 72, 72, 95, 72, 75, 76, 86, 71, 80, 81, 86, 75, 86, 75, 67, 78, 6, 8, 8, Ascii.GS, 50, 3, 8, Ascii.NAK, Ascii.EM, 50, Ascii.EM, 2, 50, 9, 8, Ascii.RS, Ascii.EM, 4, 3, Ascii.FF, Ascii.EM, 4, 2, 3, 50, 2, 3, Ascii.SO, 1, 4, Ascii.SO, 6, 91, 86, 89, 83, 68, 84, 86, 71, 82, 102, 107, 115, 101, 127, 126, 8, Ascii.ETB, 10, Ascii.FF, 10, Ascii.EM, 17, Ascii.FF, 43, 60, 46, 56, 43, Base64.padSymbol, 60, Base64.padSymbol, 6, 47, 48, Base64.padSymbol, 60, 54, 58, 33, 38, 60, 37, 45, Ascii.SYN, 37, 38, 46, Ascii.SYN, 40, 39, 48, Ascii.SYN, 32, 40, 43, Ascii.SYN, 42, 37, 32, 42, 34, Ascii.SYN, 38, 39, 42, 44, 45, 54, 49, 41, 1, 63, 58, 1, Base64.padSymbol, 54, 49, 55, Base64.padSymbol, 59, 1, 40, 108, 44, 55, 48, 40, 0, 60, 45, 58, 59, 54, 43, 0, 51, 54, 49, 58, 56, 35, 36, 60, Ascii.DC4, 40, 57, 46, 47, 34, 63, Ascii.DC4, 39, 34, 37, 46, Ascii.DC4, 36, 37, Ascii.DC4, 57, 40, Ascii.DC4, 56, 62, 40, 40, 46, 56, 56, Ascii.DC4, 56, 40, 57, 46, 46, 37, 122, 97, 102, 126, 86, 106, 123, 108, 109, 96, 125, 86, 101, 96, 103, 108, 86, 127, 59, 86, 104, 103, 96, 100, 104, 125, 96, 102, 103, 44, 55, 48, 40, 0, 60, 45, 58, 59, 54, 43, 0, 51, 54, 49, 58, 0, 41, 109, 0, 44, 43, 62, 43, 54, 60, 100, 127, 120, 96, 72, 123, 120, 118, 115, 114, 101, 72, 121, 99, 115, SignedBytes.MAX_POWER_OF_TWO, 91, 92, 68, 108, 93, 86, 75, 71, 108, 80, 71, 82, 108, 92, 93, 108, 86, 93, 87, 80, 82, 65, 87, 73, 84, 73, 81, 88, Ascii.GS, 6, 6, 5, Ascii.VT, 8, Ascii.ESC, 54, 8, 10, Ascii.GS, 54, 8, Ascii.SUB, 54, 10, Ascii.GS, 8, 104, 111, 113};
    }

    static {
        A09();
        A0U = new LinkedHashMap<>(10, 0.75f, false);
    }

    public AbstractC2330jd(List<NR> list) {
        this.A0P = list;
    }

    public static String A06(String str) {
        return A0U.get(str);
    }

    private HashMap<String, String> A07(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A05(251, 18, 77));
        HashMap<String, String> map = new HashMap<>();
        if (jSONObjectOptJSONObject == null) {
            return map;
        }
        Iterator<String> nameItr = jSONObjectOptJSONObject.keys();
        while (nameItr.hasNext()) {
            try {
                String next = nameItr.next();
                map.put(next, jSONObjectOptJSONObject.getString(next));
            } catch (JSONException unused) {
            }
        }
        return map;
    }

    public static List<NR> A08(JSONObject jSONObject, C2165gi c2165gi, InterfaceC1427Ne interfaceC1427Ne) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A05(156, 8, 28));
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            return NZ.A01(jSONArrayOptJSONArray, jSONObject, c2165gi, interfaceC1427Ne);
        }
        List<AdInfo> adInfoList = new ArrayList<>();
        NR nrA00 = NR.A00(jSONObject);
        interfaceC1427Ne.A3y(nrA00, jSONObject);
        adInfoList.add(nrA00);
        return adInfoList;
    }

    private void A0A(int i) {
        this.A00 = i;
    }

    private final void A0B(int i) {
        this.A04 = i;
    }

    private void A0C(NN nn) {
        this.A06 = nn;
    }

    private final void A0D(C1429Ng c1429Ng) {
        this.A07 = c1429Ng;
    }

    private void A0E(C1432Nj c1432Nj) {
        this.A08 = c1432Nj;
    }

    private final void A0F(C1435Nm c1435Nm) {
        this.A09 = c1435Nm;
    }

    private void A0G(C1441Ns c1441Ns) {
        this.A0A = c1441Ns;
    }

    private void A0H(String str) {
        this.A0B = str;
    }

    public final int A22() {
        return this.A00;
    }

    public final int A23() {
        return this.A01;
    }

    public final int A24() {
        return this.A02;
    }

    public final int A25() {
        return this.A03;
    }

    public final int A26() {
        return this.A04;
    }

    public final int A27() {
        return this.A05;
    }

    public final NN A28() {
        return this.A06;
    }

    public final NR A29() {
        return this.A0P.get(0);
    }

    public final C1429Ng A2A() {
        return this.A07;
    }

    public final C1432Nj A2B() {
        return this.A08;
    }

    public final C1435Nm A2C() {
        return this.A09;
    }

    public final C1441Ns A2D() {
        return this.A0A;
    }

    public final String A2E() {
        return this.A0B;
    }

    public final String A2F(String str) {
        return this.A0Q.get(str);
    }

    public final List<NR> A2G() {
        return Collections.unmodifiableList(this.A0P);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A2H(com.facebook.ads.redexgen.core.InterfaceC1706Yh r5) {
        /*
            r4 = this;
            java.lang.String r3 = r4.A10()
            int r0 = r3.hashCode()
            switch(r0) {
                case -1364000502: goto L39;
                case 604727084: goto L27;
                default: goto Lb;
            }
        Lb:
            r0 = -1
        Lc:
            switch(r0) {
                case 0: goto L10;
                case 1: goto L1d;
                default: goto Lf;
            }
        Lf:
            return
        L10:
            r2 = 183(0xb7, float:2.56E-43)
            r1 = 45
            r0 = 79
            java.lang.String r0 = A05(r2, r1, r0)
            r5.A4j(r0)
        L1d:
            com.facebook.ads.redexgen.X.ez r0 = com.facebook.ads.redexgen.core.EnumC2058ez.A08
            java.lang.String r0 = r0.A03()
            r5.A4j(r0)
            goto Lf
        L27:
            r2 = 317(0x13d, float:4.44E-43)
            r1 = 12
            r0 = 82
            java.lang.String r0 = A05(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 0
            goto Lc
        L39:
            r2 = 384(0x180, float:5.38E-43)
            r1 = 14
            r0 = 41
            java.lang.String r0 = A05(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 1
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2330jd.A2H(com.facebook.ads.redexgen.X.Yh):void");
    }

    public final void A2I(JSONObject jSONObject) {
        String strA05;
        A0D(C1429Ng.A00(jSONObject.optJSONObject(A05(301, 16, 74))));
        A0R = jSONObject.optJSONObject(A05(144, 12, 40));
        C1434Nl c1434NlA06 = new C1434Nl().A06(jSONObject.optString(A05(591, 5, 77)));
        String strA052 = A05(297, 4, 95);
        if (jSONObject.optJSONObject(strA052) != null) {
            strA05 = jSONObject.optJSONObject(strA052).optString(A05(614, 3, 109));
        } else {
            strA05 = A05(0, 0, 15);
        }
        A0F(c1434NlA06.A05(strA05).A04(jSONObject.optString(A05(0, 19, 64))).A07(AbstractC1436Nn.A03(jSONObject)).A08());
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A05(370, 6, 122));
        JSONObject layoutObject = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(A05(376, 8, 8)) : null;
        C1423Na c1423NaA01 = C1423Na.A01(layoutObject);
        String[] strArr = A0T;
        if (strArr[1].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0T;
        strArr2[2] = "MaJS3iOjDVpkOvzQIu4XnTvkYtI43ENf";
        strArr2[6] = "dcadpZfpRdAwhtf1LK3imqQWfZ9Fu8JJ";
        A0C(new NN(c1423NaA01, C1423Na.A01(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(A05(361, 9, 71)) : null)));
        A0G(AbstractC1436Nn.A01(jSONObject));
        A0E(AbstractC1436Nn.A00(jSONObject));
        A0A(jSONObject.optInt(A05(19, 12, 107), 0));
        A0B(jSONObject.optInt(A05(164, 19, 21), -1));
        this.A0Q.putAll(A07(jSONObject));
        this.A03 = jSONObject.optInt(A05(110, 18, 70), 0);
        this.A01 = jSONObject.optInt(A05(128, 16, 62), 1);
        this.A0L = jSONObject.optBoolean(A05(596, 18, 25), false);
        this.A0K = jSONObject.optBoolean(A05(552, 15, 103), false);
        this.A0H = jSONObject.optBoolean(A05(567, 24, 67), false);
        this.A0I = jSONObject.optBoolean(A05(444, 16, 47), false);
        this.A0G = jSONObject.optBoolean(A05(31, 19, 12), false);
        this.A05 = jSONObject.optInt(A05(50, 36, 36), 5000);
        this.A0C = jSONObject.optString(A05(228, 21, 50));
        this.A0J = jSONObject.optBoolean(A05(460, 37, 59), false);
        this.A0F = jSONObject.optBoolean(A05(398, 29, 57), false);
        this.A0E = jSONObject.optBoolean(A05(329, 32, 29), false);
        this.A02 = jSONObject.optInt(A05(86, 24, 93), this.A03);
        String strOptString = jSONObject.optString(A05(249, 2, 124));
        A0H(strOptString);
        A0U.put(strOptString, jSONObject.optString(A05(269, 28, 97)));
        this.A0O = jSONObject.optBoolean(A05(526, 26, 47), false);
        this.A0N = jSONObject.optBoolean(A05(497, 29, 121), false);
        this.A0M = jSONObject.optBoolean(A05(427, 17, 46), false);
        A1P(jSONObject);
    }

    public final void A2J(boolean z) {
        this.A0D = z;
    }

    public final void A2K(boolean z) {
        this.A0H = z;
    }

    public final boolean A2L() {
        return this.A0D;
    }

    public final boolean A2M() {
        return A2Q() || A2U();
    }

    public final boolean A2N() {
        return this.A0E;
    }

    public final boolean A2O() {
        return this.A0F;
    }

    public final boolean A2P() {
        return this.A0H;
    }

    public final boolean A2Q() {
        return this.A0I;
    }

    public final boolean A2R() {
        return this.A0J;
    }

    public final boolean A2S() {
        return this.A0K;
    }

    public final boolean A2T() {
        return this.A0L;
    }

    public final boolean A2U() {
        return this.A0M;
    }

    public final boolean A2V() {
        return this.A0N;
    }

    public final boolean A2W() {
        return this.A0O;
    }
}
