package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ju, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2347ju implements InterfaceC1420Mw, N1 {
    public static byte[] A0C;
    public static String[] A0D = {"axrzCdv0FVVdCRJ2G5bzsKW6gzdnjkd", "bTiRlDodVRVUvI5asAv5OrmPjdR2kQoL", "0F0kzsbgf", "9OhtkIX5JTQzZAf31yyS0L6RFdCICf7G", "a5UohLNEI7iVSyxaj4LiJgBVL6R7sy1L", "7foeJoxu0TAivWs2uWCvQbVxkZa0ERHH", "EHJaWrfXkxbvFmDXjSXoaOL8kiGJisUm", "EwwWMCMqNj"};
    public static final String A0E;
    public int A00;
    public C2335ji A01;
    public NG A02;
    public NH A03;
    public InterfaceC1626Va A04;
    public List<UK> A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final C2165gi A0A;
    public final String A0B;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 27);
            if (A0D[0].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "ypXQoKhxcHRWJrqojmqi5sMtZ7xfThaX";
            strArr[6] = "2LOy6kLjroQDrfbojOuFHdbjLd88ORkx";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{55, Ascii.DC2, Ascii.ETB, 6, 2, 19, 4, 86, Ascii.ETB, Ascii.SUB, 4, 19, Ascii.ETB, Ascii.DC2, Ascii.SI, 86, Ascii.SUB, Ascii.EM, Ascii.ETB, Ascii.DC2, 19, Ascii.DC2, 86, Ascii.DC2, Ascii.ETB, 2, Ascii.ETB, 2, 45, 40, 34, 42, 97, 41, 32, 49, 49, 36, 47, 36, 37, 97, 46, 47, 97, 45, 46, 34, 42, 50, 34, 51, 36, 36, 47, 97, 32, 37, 87, 120, 125, 119, 127, 52, 120, 123, 115, 115, 113, 112, 119, 117, 120, 120, 113, 102, SignedBytes.MAX_POWER_OF_TWO, 109, 100, 113, 46, 44, 63, 41, 46, 35, 57, 85, 87, 68, 82, 95, 88, 82, 114, 101, 58, 53, 32, Base64.padSymbol, 34, 49, Ascii.FF, 17, Ascii.RS, Ascii.SI, Ascii.FF, Ascii.ETB, Ascii.DLE, Ascii.VT, 100, 127, 120, 96, 100, 116, 88, 117, 33, 62, 50, 32};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A06(Map<String, String> map, Map<String, String> map2) {
        try {
            new Handler().postDelayed(new C2348jv(this, map2, A03(map)), this.A01.A09() * 1000);
        } catch (Exception unused) {
        }
    }

    static {
        A04();
        A0E = C2347ju.class.getSimpleName();
    }

    public C2347ju(C2165gi c2165gi) {
        this(c2165gi, new C2335ji());
    }

    public C2347ju(C2165gi c2165gi, C2335ji c2335ji) {
        this.A0B = UUID.randomUUID().toString();
        this.A00 = 200;
        this.A01 = c2335ji;
        this.A0A = c2165gi;
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap map2 = new HashMap();
        String strA02 = A02(118, 4, 76);
        if (map.containsKey(strA02)) {
            map2.put(strA02, map.get(strA02));
        }
        String strA022 = A02(102, 8, 100);
        if (map.containsKey(strA022)) {
            map2.put(strA022, map.get(strA022));
        }
        return map2;
    }

    private void A05(C2335ji c2335ji) {
        if (!this.A06) {
            this.A01 = c2335ji;
            List<C2335ji> listA0f = this.A01.A0f();
            if (listA0f != null && listA0f.size() > 0) {
                int size = listA0f.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    C2347ju adapter = new C2347ju(this.A0A);
                    adapter.A05(listA0f.get(i));
                    arrayList.add(new UK(this.A0A, adapter, (C1597Tx) null, this.A04));
                }
                this.A05 = arrayList;
            }
            this.A06 = true;
            this.A07 = A07();
            return;
        }
        throw new IllegalStateException(A02(0, 27, 109));
    }

    private boolean A07() {
        return (!(this.A01.A0j() || TextUtils.isEmpty(this.A01.A0Y())) || (!TextUtils.isEmpty(this.A01.A0V()) && this.A01.A0j())) && (this.A01.A0I() != null || this.A01.A0j()) && (this.A01.A0H() != null || A8k() == AdPlacementType.NATIVE_BANNER);
    }

    public final int A08() {
        return this.A01.A02();
    }

    public final int A09() {
        return this.A01.A05();
    }

    public final int A0A() {
        int iA08 = this.A01.A08();
        if (iA08 < 0 || iA08 > 100) {
            return 0;
        }
        return iA08;
    }

    public final int A0B() {
        return this.A00;
    }

    public final int A0C() {
        return this.A01.A0B();
    }

    public final int A0D() {
        return this.A01.A0C();
    }

    public final C2335ji A0E() {
        return this.A01;
    }

    public final NG A0F() {
        return this.A02;
    }

    public final String A0G() {
        return this.A01.A0b();
    }

    public final List<UK> A0H() {
        if (!A0R()) {
            return null;
        }
        return this.A05;
    }

    public final void A0I() {
        if (!this.A09) {
            String strA0c = A0E().A0c();
            if (strA0c != null) {
                VA vaA0A = this.A0A.A0A();
                String[] strArr = A0D;
                if (strArr[1].charAt(25) != strArr[3].charAt(25)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[4] = "MHNGbcOaMZIG61BxjY7eI95TuiNlx0Gr";
                strArr2[6] = "kvjKrlZQ6RBIZv1Jj5ESJw4vFB55PB3z";
                vaA0A.AGz(strA0c);
            }
            this.A09 = true;
        }
    }

    public final void A0J() {
        if (this.A05 != null && !this.A05.isEmpty()) {
            Iterator<UK> it = this.A05.iterator();
            while (it.hasNext()) {
                it.next().unregisterView();
            }
        }
    }

    public final void A0K(NG ng) {
        this.A02 = ng;
    }

    public final void A0L(C2165gi c2165gi, NG ng, VA va, O8 o8, InterfaceC1626Va interfaceC1626Va) {
        int iA06;
        this.A02 = ng;
        this.A04 = interfaceC1626Va;
        JSONObject jSONObjectA03 = o8.A03();
        C1597Tx c1597TxA01 = o8.A01();
        if (c1597TxA01 != null) {
            iA06 = c1597TxA01.A06();
        } else {
            iA06 = 200;
        }
        this.A00 = iA06;
        A05(NI.A00(c2165gi, jSONObjectA03, AbstractC1676Xd.A02(jSONObjectA03, A02(94, 2, 10))));
        if (AbstractC1421Mx.A06(c2165gi, this, va)) {
            c2165gi.A0F().A52();
            ng.AEz(this, C1637Vm.A00(AdErrorType.NO_FILL));
        } else {
            if (ng != null) {
                ng.AEw(this);
            }
            this.A03 = new NH(c2165gi, this.A0B, this, ng);
            this.A03.A02();
        }
    }

    public final void A0M(Map<String, String> extraData) {
        C1429Ng c1429NgA2A;
        if (!A0R()) {
            return;
        }
        boolean shouldBlockLockscreenClicks = C1615Up.A26(this.A0A);
        if (shouldBlockLockscreenClicks) {
            boolean shouldBlockLockscreenClicks2 = YC.A03(extraData);
            if (shouldBlockLockscreenClicks2) {
                Log.e(A0E, A02(27, 31, 90));
                return;
            }
        }
        HashMap map = new HashMap();
        if (extraData != null) {
            map.putAll(extraData);
        }
        boolean shouldBlockLockscreenClicks3 = this.A01.A0j();
        if (shouldBlockLockscreenClicks3) {
            map.put(A02(87, 7, 45), String.valueOf(A0E().A04()));
            map.put(A02(80, 7, 86), String.valueOf(A0E().A03()));
        }
        map.put(A02(70, 10, 15), AdPlacementType.NATIVE.name());
        map.put(A02(110, 8, 10), this.A0B);
        C2165gi c2165gi = this.A0A;
        VA vaA0A = this.A0A.A0A();
        String strA7O = this.A01.A7O();
        Uri uriA0E = this.A01.A0E();
        if (this.A01.A0F() != null) {
            c1429NgA2A = this.A01.A0F().A2A();
        } else {
            c1429NgA2A = null;
        }
        AbstractC1417Mt abstractC1417MtA00 = C1418Mu.A00(c2165gi, vaA0A, strA7O, uriA0E, map, c1429NgA2A);
        EnumC1414Mq enumC1414MqA0G = EnumC1414Mq.A09;
        if (abstractC1417MtA00 != null) {
            enumC1414MqA0G = abstractC1417MtA00.A0G(null);
        }
        if (enumC1414MqA0G != EnumC1414Mq.A06) {
            XI.A04(this.A0A, A02(58, 12, 15));
            if (this.A02 != null) {
                this.A02.AEv(this);
            }
        }
    }

    public final void A0N(Map<String, String> extraData) {
        this.A0A.A0A().AB6(this.A01.A7O(), extraData);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0O(java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2347ju.A0O(java.util.Map):void");
    }

    public final boolean A0P() {
        return true;
    }

    public final boolean A0Q() {
        return A0R() && this.A01.A0E() != null;
    }

    public final boolean A0R() {
        return this.A06 && this.A07;
    }

    public final boolean A0S() {
        return this.A01.A0i();
    }

    public final boolean A0T() {
        return C1615Up.A1b(this.A0A) && A0R() && this.A01.A0k();
    }

    public final boolean A0U() {
        return C1615Up.A1b(this.A0A) && A0R() && this.A01.A0l();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1420Mw
    public final String A7O() {
        return this.A01.A7O();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1420Mw
    public final Collection<String> A7p() {
        return A0E().A7p();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1420Mw
    public final EnumC1419Mv A8K() {
        return A0E().A8K();
    }

    public AdPlacementType A8k() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.facebook.ads.redexgen.core.N1
    public final boolean AKL() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.N1
    public final void onDestroy() {
        if (this.A03 != null) {
            NH nh = this.A03;
            String[] strArr = A0D;
            if (strArr[4].charAt(16) != strArr[6].charAt(16)) {
                throw new RuntimeException();
            }
            A0D[7] = "xLZjaQWgus";
            nh.A03();
        }
    }
}
