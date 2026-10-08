package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdClosedListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class UK implements Ad, NativeAdBaseApi, Repairable, InterfaceC1634Vi {
    public static C1571Sx A0o;
    public static byte[] A0p;
    public static String[] A0q = {"0QrYY16WpsBKaBkyPEA33iBIoR05UhVT", "YnnsFrkLVth43aFbA8XanJ7Af1ELV", "Oxqa2FUUnPLQ7GUfsty3Y0efzjvyqNtk", "SIKP4BEcnF1kam64buW5uj4ZKlEjFxDR", "vEVPI6RQ4lovzpZyrpWOxFDddvUHwWNp", "NGWOmnzpb", "djSS0JJWnZq1rlBsvyeXY9GnDKzed", "NhvbMWoFDj5W6o0bWnGe4dztWB8buZER"};
    public static final String A0r;
    public static final WeakHashMap<View, WeakReference<UK>> A0s;
    public long A00;
    public Drawable A01;
    public View.OnTouchListener A02;
    public View A03;
    public View A04;
    public View A05;
    public View A06;
    public AdClosedListener A07;
    public NativeAdLayout A08;
    public NE A09;
    public C2336jj A0A;
    public C10357g A0B;
    public C2294iu A0C;
    public T3 A0D;
    public C1597Tx A0E;
    public VI A0F;
    public VW A0G;
    public ViewOnClickListenerC1603Ud A0H;
    public InterfaceC1595Tv A0I;
    public C1629Vd A0J;
    public EnumC1630Ve A0K;
    public EnumC1640Vq A0L;
    public ZT A0M;
    public InterfaceC1727Zc A0N;
    public C1819b6 A0O;
    public C1949dC A0P;
    public C2013eF A0Q;
    public AbstractC2109fo A0R;
    public AbstractC2109fo A0S;
    public C2110fp A0T;
    public C2110fp A0U;
    public String A0V;
    public String A0W;
    public WeakReference<C2212hT> A0X;
    public WeakReference<AbstractC2109fo> A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public C2347ju A0e;
    public final C1571Sx A0f;
    public final C2165gi A0g;
    public final InterfaceC1626Va A0h;
    public final C1636Vk A0i;
    public final Y2 A0j;
    public final String A0k;
    public final String A0l;
    public final List<View> A0m;
    public volatile boolean A0n;

    public static String A0W(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0p, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0e() {
        A0p = new byte[]{-32, Ascii.SUB, 38, Ascii.US, Ascii.RS, -19, -14, -13, -16, Ascii.RS, -18, -15, -16, -24, -27, Ascii.SYN, -24, -26, -19, Ascii.ETB, -27, -74, -74, -71, -76, -70, -72, -29, -29, 38, 73, 5, 83, 84, 89, 5, 81, 84, 70, 73, 74, 73, -25, 10, -6, Ascii.VT, 19, Ascii.SYN, Ascii.DC2, 7, Ascii.SUB, Ascii.VT, -58, -51, -53, Ascii.EM, -51, -58, Ascii.SI, Ascii.EM, -58, Ascii.DC4, Ascii.NAK, Ascii.SUB, -58, 7, -58, Ascii.DC4, 7, Ascii.SUB, Ascii.SI, Ascii.FS, Ascii.VT, -58, 7, 10, -33, -37, -38, Ascii.SO, -3, 2, -2, 7, -4, -2, -25, -2, Ascii.CR, Ascii.DLE, 8, Ascii.VT, 4, -27, 0, 8, Ascii.VT, 4, 3, -65, 19, Ascii.SO, -65, Ascii.VT, Ascii.SO, 0, 3, -65, -20, 4, 3, 8, 0, -51, -16, Ascii.VT, 19, Ascii.SYN, Ascii.SI, Ascii.SO, -54, Ascii.RS, Ascii.EM, -54, Ascii.EM, Ascii.FF, Ascii.RS, Ascii.VT, 19, Ascii.CAN, -54, Ascii.RS, Ascii.SI, Ascii.ETB, Ascii.SUB, Ascii.SYN, Ascii.VT, Ascii.RS, Ascii.SI, -54, -13, -18, -54, Ascii.DLE, Ascii.FS, Ascii.EM, Ascii.ETB, -54, Ascii.FF, 19, Ascii.SO, -54, Ascii.SUB, Ascii.VT, 35, Ascii.SYN, Ascii.EM, Ascii.VT, Ascii.SO, -54, -47, -49, Ascii.GS, -47, -23, Ascii.SO, Ascii.DC4, 5, Ascii.DC2, Ascii.SO, 1, Ascii.FF, -64, 5, Ascii.DC2, Ascii.DC2, Ascii.SI, Ascii.DC2, -50, -86, Ascii.RS, 67, 75, 54, 65, 62, 57, -11, 72, 58, 73, -11, 68, 59, -11, 56, 65, 62, 56, SignedBytes.MAX_POWER_OF_TWO, 54, 55, 65, 58, -11, 75, 62, 58, 76, 72, 0, Ascii.CAN, Ascii.ETB, Ascii.FS, Ascii.DC4, 9, Ascii.FS, Ascii.CAN, 42, -45, Ascii.EM, 34, 37, -45, Ascii.FS, Ascii.SYN, 34, 33, -45, Ascii.FS, 38, -45, Ascii.FS, 38, -45, 32, Ascii.FS, 38, 38, Ascii.FS, 33, Ascii.SUB, -31, Ascii.GS, 53, 52, 57, 49, 38, 57, 53, 71, -16, 57, 67, -16, Base64.padSymbol, 57, 67, 67, 57, 62, 55, -2, 51, 91, 89, 90, 6, 86, 88, 85, 92, 79, 74, 75, 6, 71, 6, 60, 79, 75, 93, 35, 54, 73, 62, 75, 58, -11, Ascii.SYN, 57, -11, 76, 54, 72, -11, 54, 65, 71, 58, 54, 57, 78, -11, 71, 58, 60, 62, 72, 73, 58, 71, 58, 57, -11, 76, 62, 73, Base64.padSymbol, -11, 54, -11, 43, 62, 58, 76, 3, -11, Ascii.SYN, 74, 73, 68, -11, 74, 67, 71, 58, 60, 62, 72, 73, 58, 71, 62, 67, 60, -11, 54, 67, 57, -11, 69, 71, 68, 56, 58, 58, 57, 62, 67, 60, 3, -55, -36, -17, -28, -15, -32, -101, -36, -33, -101, -33, -32, -18, -17, -19, -22, -12, -32, -33, -39, -20, -1, -12, 1, -16, -85, -20, -17, -85, -9, -6, -20, -17, -85, -3, -16, -4, 0, -16, -2, -1, -16, -17, -22, -3, -7, Ascii.VT, -76, -11, 0, 6, -7, -11, -8, Ascii.CR, -76, 6, -7, -5, -3, 7, 8, -7, 6, -7, -8, -76, Ascii.VT, -3, 8, -4, -76, -11, -76, -30, -11, 8, -3, 10, -7, -43, -8, -62, -76, -43, 9, 8, 3, -76, 9, 2, 6, -7, -5, -3, 7, 8, -7, 6, -3, 2, -5, -76, -11, 2, -8, -76, 4, 6, 3, -9, -7, -7, -8, -3, 2, -5, -62, -1, Ascii.DC2, Ascii.SO, 32, -55, Ascii.ETB, Ascii.CAN, Ascii.GS, -55, Ascii.ESC, Ascii.SO, Ascii.DLE, Ascii.DC2, Ascii.FS, Ascii.GS, Ascii.SO, Ascii.ESC, Ascii.SO, Ascii.CR, -55, 32, Ascii.DC2, Ascii.GS, 17, -55, Ascii.GS, 17, Ascii.DC2, Ascii.FS, -55, -9, 10, Ascii.GS, Ascii.DC2, Ascii.US, Ascii.SO, -22, Ascii.CR, 46, 49, -19, 58, 50, 49, 54, 46, -19, 65, 70, Base64.padSymbol, 50, -19, 54, SignedBytes.MAX_POWER_OF_TWO, -19, 59, 60, 65, -19, SignedBytes.MAX_POWER_OF_TWO, 66, Base64.padSymbol, Base64.padSymbol, 60, 63, 65, 50, 49, -5, 54, 69, 62, 51, 52, 66, 67, 65, 62, 72, 81, 84, 70, 73, 38, 73, 69, 72, 58, Base64.padSymbol, Ascii.SUB, Base64.padSymbol, 1, 2, -7, 60, 58, 69, 69, 62, Base64.padSymbol, -7, 70, 72, 75, 62, -7, 77, 65, 58, 71, -7, 72, 71, 60, 62, -27, -40, -21, -32, -19, -36};
        String[] strArr = A0q;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0q[3] = "WbNUBB1XQVUYjPuN5kyqwH0pcEyoS9gz";
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0335 A[LOOP:0: B:109:0x032f->B:111:0x0335, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0261  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0g(android.view.View r13, android.view.View r14, java.util.List<android.view.View> r15, boolean r16) {
        /*
            Method dump skipped, instruction units count: 1211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.UK.A0g(android.view.View, android.view.View, java.util.List, boolean):void");
    }

    static {
        A0e();
        A0r = UK.class.getSimpleName();
        A0s = new WeakHashMap<>();
    }

    public UK(Context context, String str, InterfaceC1626Va interfaceC1626Va, boolean z) {
        this.A0l = UUID.randomUUID().toString();
        this.A0L = EnumC1640Vq.A06;
        this.A0G = VW.A04;
        this.A09 = NE.A03;
        this.A0X = new WeakReference<>(null);
        this.A0m = new ArrayList();
        this.A0j = new Y2();
        this.A0d = false;
        this.A0c = false;
        this.A00 = -1L;
        this.A0Z = false;
        if (context instanceof C2165gi) {
            this.A0g = (C2165gi) context;
        } else if (!z) {
            this.A0g = C1538Rp.A04(context);
        } else {
            this.A0g = C1538Rp.A03(context);
        }
        this.A0g.A0O(this);
        this.A0k = str;
        this.A0h = interfaceC1626Va;
        if (A0o != null) {
            this.A0f = A0o;
        } else {
            this.A0f = new C1571Sx(this.A0g);
        }
        this.A05 = new View(context);
        this.A0i = new C1636Vk(this.A0g, this);
    }

    public UK(UK uk) {
        this((Context) uk.A0g, (String) null, uk.A0h, true);
        this.A0E = uk.A0E;
        this.A0e = uk.A0e;
        this.A0C = uk.A0C;
        this.A0n = true;
        this.A05 = new View(this.A0g);
    }

    public UK(C2165gi c2165gi, C2347ju c2347ju, C1597Tx c1597Tx, InterfaceC1626Va interfaceC1626Va) {
        this((Context) c2165gi, (String) null, interfaceC1626Va, true);
        this.A0e = c2347ju;
        this.A0E = c1597Tx;
        this.A0n = true;
        this.A05 = new View(c2165gi);
    }

    public UK(C2165gi c2165gi, C2347ju c2347ju, C1597Tx c1597Tx, InterfaceC1626Va interfaceC1626Va, C2294iu c2294iu) {
        this(c2165gi, c2347ju, c1597Tx, interfaceC1626Va);
        this.A0C = c2294iu;
    }

    private int A00() {
        if (this.A0E != null) {
            return this.A0E.A04();
        }
        if (this.A0B == null || this.A0B.A0J() == null) {
            return 1;
        }
        C1597Tx c1597TxA0J = this.A0B.A0J();
        String[] strArr = A0q;
        String str = strArr[6];
        String str2 = strArr[1];
        int length = str.length();
        int viewabilityThreshold = str2.length();
        if (length != viewabilityThreshold) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0q;
        strArr2[2] = "P5kYLn6xwAUrjDfDuw88TuaVt88D3vtD";
        strArr2[7] = "ZJzVQNISDO4cH7XUZ38T2d7bCdM1k8uN";
        return c1597TxA0J.A04();
    }

    private int A01() {
        if (this.A0E != null) {
            return this.A0E.A07();
        }
        if (this.A0e != null) {
            return this.A0e.A0C();
        }
        if (this.A0B != null && this.A0B.A0J() != null) {
            return this.A0B.A0J().A07();
        }
        return 0;
    }

    private int A02() {
        if (this.A0E != null) {
            return this.A0E.A08();
        }
        if (this.A0e != null) {
            return this.A0e.A0D();
        }
        if (this.A0B != null && this.A0B.A0J() != null) {
            return this.A0B.A0J().A08();
        }
        return 1000;
    }

    private int A03() {
        if (this.A0E != null) {
            return this.A0E.A09();
        }
        C10357g c10357g = this.A0B;
        if (A0q[3].charAt(5) != 'B') {
            throw new RuntimeException();
        }
        A0q[5] = "Xt";
        if (c10357g == null || this.A0B.A0J() == null) {
            return 0;
        }
        return this.A0B.A0J().A09();
    }

    public static Drawable A05(C2165gi c2165gi, Bitmap bitmap, boolean z, String str) {
        BitmapDrawable bitmapDrawableA00;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(c2165gi.getResources(), bitmap);
        if (z && (bitmapDrawableA00 = AbstractC2012eE.A00(c2165gi, str)) != null) {
            Drawable iconViewDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawableA00});
            return iconViewDrawable;
        }
        return bitmapDrawable;
    }

    public static NativeAdBase A0A(Context context, String str, String str2) throws C1638Vn {
        EnumC1640Vq enumC1640VqA00 = C1644Vu.A00(str2);
        if (enumC1640VqA00 != null) {
            EnumC1640Vq template = EnumC1640Vq.A05;
            if (enumC1640VqA00 == template) {
                return new NativeBannerAd(context, str);
            }
            EnumC1640Vq template2 = EnumC1640Vq.A06;
            if (enumC1640VqA00 == template2) {
                return new NativeAd(context, str);
            }
            throw new C1638Vn(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(42, 34, 54), enumC1640VqA00));
        }
        throw new C1638Vn(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(114, 50, 58), str2));
    }

    private final C2347ju A0C() {
        C2347ju c2347ju = this.A0e;
        if (c2347ju != null && c2347ju.A0R()) {
            return c2347ju;
        }
        return null;
    }

    private C2335ji A0F() {
        return A0G(false);
    }

    private C2335ji A0G(boolean z) {
        if (this.A0e != null) {
            C2347ju c2347ju = this.A0e;
            if (A0q[3].charAt(5) == 'B') {
                String[] strArr = A0q;
                strArr[0] = "rkQiEYXoMEhriwkmxTS9YqbekXjRctvV";
                strArr[4] = "aQIgqL6bCxVEsMgFZvYj1f08oAvgjHgO";
                if (c2347ju.A0R()) {
                    if (z) {
                        C2347ju c2347ju2 = this.A0e;
                        if (A0q[3].charAt(5) == 'B') {
                            A0q[3] = "EWl26Bqfon8mX0lHHC6z05409Pwx5AXq";
                            c2347ju2.A0I();
                        }
                    }
                    return this.A0e.A0E();
                }
            }
            throw new RuntimeException();
        }
        return new C2335ji();
    }

    public static C1610Uk A0K() {
        return new C1610Uk();
    }

    public static UK A0L(NativeAdBaseApi nativeAdBaseApi) {
        if (nativeAdBaseApi instanceof Proxy) {
            return (UK) ((RZ) Proxy.getInvocationHandler(nativeAdBaseApi)).A04();
        }
        return (UK) nativeAdBaseApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A0M, reason: merged with bridge method [inline-methods] */
    public final C1627Vb getAdChoicesIcon() {
        return A0F().A0G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A0O, reason: merged with bridge method [inline-methods] */
    public final C1628Vc getAdStarRating() {
        return A0F().A0J();
    }

    private AdPlacementType A0R() {
        if (this.A0L == EnumC1640Vq.A06) {
            return AdPlacementType.NATIVE;
        }
        return AdPlacementType.NATIVE_BANNER;
    }

    private void A0a() {
        for (View view : this.A0m) {
            view.setOnClickListener(null);
            if (A0q[3].charAt(5) != 'B') {
                throw new RuntimeException();
            }
            A0q[3] = "reBfvBMaH6BqwlxZ2WqAQZq3knZpIvyz";
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
        }
        this.A0m.clear();
    }

    private void A0b() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            X6.A0O(new X6(), this.A0g, XB.A00(getAdChoicesLinkUrl()), A1H());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0c() {
        this.A0j.A05();
        this.A0i.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0d() {
        if (this.A0T != null) {
            this.A0T.A0V();
            this.A0g.A0F().ACZ();
            this.A0T = null;
        }
    }

    public static void A0f(Drawable drawable, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (A0q[3].charAt(5) != 'B') {
            throw new RuntimeException();
        }
        String[] strArr = A0q;
        strArr[6] = "LXDT52DRzEPuIKBbeK5QN38hLQjcy";
        strArr[1] = "Z1aNossC2MxjaxQyIIrn4vHalGw3J";
        imageView.setBackground(null);
    }

    private void A0h(FrameLayout frameLayout, String str) {
        if (this.A0Q != null) {
            frameLayout.removeView(this.A0Q);
        }
        this.A0Q = AbstractC2012eE.A01(C1538Rp.A03(this.A0g), str);
        if (this.A0Q != null) {
            frameLayout.addView(this.A0Q, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(this.A0Q);
        }
    }

    private void A0i(C2347ju c2347ju, boolean z) {
        Iterator<UK> it;
        if (c2347ju == null) {
            return;
        }
        boolean zEquals = this.A0G.equals(VW.A04);
        String strA0W = A0W(596, 6, 7);
        if (zEquals) {
            C2335ji c2335jiA0E = c2347ju.A0E();
            AbstractC2330jd abstractC2330jdA0F = c2335jiA0E.A0F();
            if (abstractC2330jdA0F != null) {
                O0.A00(abstractC2330jdA0F, this.A0f, strA0W);
            }
            String strA7O = c2347ju.A7O();
            if (A0q[3].charAt(5) != 'B') {
                throw new RuntimeException();
            }
            String[] strArr = A0q;
            strArr[6] = "lK6BgrMvSH2F6L4J2jXYHYWLLMocG";
            strArr[1] = "r7RKa3WPMM0ePgLxUrWU6ktCTFHYt";
            if (!TextUtils.isEmpty(strA7O)) {
                this.A0F = new VI(strA7O, this.A0g.A0A());
                this.A0f.A0e(this.A0F);
            }
            if (c2335jiA0E.A0I() != null) {
                C1569Sv c1569Sv = new C1569Sv(c2335jiA0E.A0I().getUrl(), c2335jiA0E.A0I().getHeight(), c2335jiA0E.A0I().getWidth(), c2347ju.A0G(), A0W(596, 6, 7));
                c1569Sv.A01 = this.A0D;
                this.A0f.A0W();
                this.A0f.A0c(c1569Sv);
            }
            if (!this.A0L.equals(EnumC1640Vq.A05)) {
                if (c2335jiA0E.A0H() != null) {
                    this.A0f.A0c(new C1569Sv(c2335jiA0E.A0H().getUrl(), c2335jiA0E.A0H().getHeight(), c2335jiA0E.A0H().getWidth(), c2347ju.A0G(), A0W(596, 6, 7)));
                }
                if (c2347ju.A0H() != null) {
                    List<UK> listA0H = c2347ju.A0H();
                    String[] strArr2 = A0q;
                    String clientToken = strArr2[2];
                    if (clientToken.charAt(3) != strArr2[7].charAt(3)) {
                        String[] strArr3 = A0q;
                        strArr3[6] = "77gx94UEEewpboaJzdp5NkxYfy9yz";
                        strArr3[1] = "VW3IQGZLEm7XJQdY3dbeWOHCgy17v";
                        it = listA0H.iterator();
                    } else {
                        String[] strArr4 = A0q;
                        strArr4[0] = "SnanODICAbTvQWDZLrONkEMoieoDOxdU";
                        strArr4[4] = "rm0yXzoJreTTXaU8PcTY1VhnZxiHPX84";
                        it = listA0H.iterator();
                    }
                    while (it.hasNext()) {
                        UK next = it.next();
                        if (next.getAdCoverImage() != null) {
                            this.A0f.A0c(new C1569Sv(next.getAdCoverImage().getUrl(), next.getAdCoverImage().getHeight(), next.getAdCoverImage().getWidth(), c2347ju.A0G(), A0W(596, 6, 7)));
                        }
                    }
                }
                String strA0e = c2335jiA0E.A0e();
                if (!TextUtils.isEmpty(strA0e)) {
                    this.A0f.A0b(new C1567St(strA0e, c2347ju.A0G(), A0W(596, 6, 7), c2335jiA0E.A0D()));
                }
            }
            if (abstractC2330jdA0F != null && abstractC2330jdA0F.A1g()) {
                C1567St cacheFileData = new C1567St(abstractC2330jdA0F.A0x(), abstractC2330jdA0F.A1D(), strA0W);
                cacheFileData.A04 = true;
                cacheFileData.A03 = A0W(0, 5, 66);
                this.A0f.A0Y(cacheFileData);
            }
        }
        this.A0f.A0X(new VZ(this, c2347ju, z), new C1564Sq(c2347ju.A0G(), strA0W));
    }

    private void A0j(NG ng) {
        if (this.A0e == null) {
            return;
        }
        this.A0e.A0K(ng);
    }

    public static void A0k(NativeAdImageApi nativeAdImageApi, ImageView imageView, C2165gi c2165gi) {
        if (nativeAdImageApi != null && imageView != null) {
            new LM(imageView, c2165gi).A05(nativeAdImageApi.getHeight(), nativeAdImageApi.getWidth()).A07(nativeAdImageApi.getUrl());
        }
    }

    private final void A0n(InterfaceC1595Tv interfaceC1595Tv) {
        this.A0I = interfaceC1595Tv;
    }

    private final void A0o(String str) {
        this.A0V = str;
    }

    private void A0p(List<View> list, View view) {
        if (this.A0h != null && this.A0h.AJx(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                A0p(list, viewGroup.getChildAt(i));
            }
            return;
        }
        list.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0q() {
        return A1D() == EnumC1631Vf.A05 || A1D() == EnumC1631Vf.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0r() {
        return A0F().A0j();
    }

    public final int A0y() {
        return A0F().A06();
    }

    public final int A0z() {
        return A0F().A07();
    }

    public final int A10() {
        if (this.A0e != null && !TextUtils.isEmpty(this.A0e.A0E().A0e())) {
            return this.A0e.A0E().A0A();
        }
        return -1;
    }

    public final long A11() {
        return this.A00;
    }

    public final C2347ju A12() {
        return this.A0e;
    }

    public final AbstractC2330jd A13() {
        return A0F().A0F();
    }

    public final C1571Sx A14() {
        return this.A0f;
    }

    public final C2165gi A15() {
        return this.A0g;
    }

    public final C2165gi A16() {
        return this.A0g;
    }

    public final ViewOnClickListenerC1603Ud A17() {
        return this.A0H;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A18, reason: merged with bridge method [inline-methods] */
    public final C1627Vb getAdCoverImage() {
        return A0F().A0H();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* JADX INFO: renamed from: A19, reason: merged with bridge method [inline-methods] */
    public final C1627Vb getAdIcon() {
        return A0F().A0I();
    }

    public final InterfaceC1595Tv A1A() {
        return this.A0I;
    }

    public final C1629Vd A1B() {
        return this.A0J;
    }

    public final EnumC1630Ve A1C() {
        return this.A0K;
    }

    public final EnumC1631Vf A1D() {
        return A0F().A0K();
    }

    public final Y2 A1E() {
        return this.A0j;
    }

    public final C1756a5 A1F() {
        if (A13() == null || !A13().A2U()) {
            return null;
        }
        C1756a5 c1756a5 = new C1756a5(this.A0g, EnumC1773aM.A05);
        c1756a5.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.VY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.A00.A1R(view);
            }
        });
        return c1756a5;
    }

    public final C2110fp A1G() {
        return this.A0U;
    }

    public final String A1H() {
        if (this.A0e == null || !isAdLoaded()) {
            return null;
        }
        return this.A0e.A7O();
    }

    public final String A1I() {
        return this.A0W;
    }

    public final String A1J() {
        return A0G(true).A0Q();
    }

    public final String A1K() {
        return A0G(true).A0R();
    }

    public final String A1L() {
        return A0F().A0d();
    }

    public final String A1M() {
        if (this.A0e == null || TextUtils.isEmpty(this.A0e.A0E().A0e())) {
            return null;
        }
        return this.A0f.A0T(this.A0e.A0E().A0e());
    }

    public final List<UK> A1N() {
        if (this.A0e == null || !isAdLoaded()) {
            return null;
        }
        return this.A0e.A0H();
    }

    public final void A1O() {
        if (!AbstractC1456Oh.A00(this.A0g.A02()).A0O(this.A0g, false)) {
            A0b();
            if (A0q[5].length() == 3) {
                throw new RuntimeException();
            }
            A0q[3] = "yREZ0BSYt8CSunaR9f1myx0zIAs3a5bO";
            return;
        }
        AbstractC1728Zd abstractC1728ZdA01 = AbstractC1729Ze.A01(this.A0g, this.A0g.A0A(), A1H(), this.A08);
        if (abstractC1728ZdA01 == null) {
            A0b();
            return;
        }
        ((C2194hB) this.A08.getNativeAdLayoutApi()).A05(abstractC1728ZdA01);
        if (!C1615Up.A22(this.A0g)) {
            C2165gi c2165giA15 = A15();
            String[] strArr = A0q;
            if (strArr[6].length() != strArr[1].length()) {
                c2165giA15.A0F().ABW();
                abstractC1728ZdA01.setOnAdClosedListener(this.A07);
            } else {
                A0q[5] = "wIzlh5hd";
                c2165giA15.A0F().ABW();
                abstractC1728ZdA01.setOnAdClosedListener(this.A07);
            }
        }
        abstractC1728ZdA01.setAdReportingCallbackListener(this.A0N);
        abstractC1728ZdA01.A0N();
    }

    public final void A1P(Drawable drawable) {
        this.A01 = drawable;
        A1o(drawable != null, true);
    }

    public final void A1Q(View view) {
        this.A0m.add(view);
        view.setOnClickListener(this.A0H);
        view.setOnTouchListener(this.A0H);
        if (C1615Up.A1C(view.getContext())) {
            view.setOnLongClickListener(this.A0H);
        }
    }

    public final /* synthetic */ void A1R(View view) {
        this.A0g.A0F().AAy(EnumC1773aM.A05.name().toLowerCase(Locale.US));
        A1O();
    }

    public final void A1S(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0p(arrayList, view);
        A0g(view, imageView, arrayList, true);
    }

    public final void A1T(View view, ImageView imageView, List<View> clickableViews) {
        A0g(view, imageView, clickableViews, true);
    }

    public final void A1U(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0p(arrayList, view);
        A0g(view, adNativeComponentView, arrayList, false);
    }

    public final void A1V(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews) {
        A0g(view, adNativeComponentView, clickableViews, false);
    }

    public final void A1W(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews, boolean z) {
        A0g(view, adNativeComponentView, clickableViews, z);
    }

    public final void A1X(View view, AdNativeComponentView adNativeComponentView, boolean z) {
        List<View> clickableViews = new ArrayList<>();
        A0p(clickableViews, view);
        A0g(view, adNativeComponentView, clickableViews, z);
    }

    public final void A1Y(AdClosedListener adClosedListener) {
        A15().A0F().ABX();
        this.A07 = adClosedListener;
    }

    public final void A1Z(MediaView mediaView) {
        if (mediaView != null) {
            this.A0c = true;
        }
    }

    public final void A1a(MediaView mediaView) {
        if (mediaView != null) {
            this.A0d = true;
        }
    }

    public final void A1b(NativeAdBase nativeAdBase, NativeAdListener nativeAdListener) {
        if (nativeAdListener == null) {
            return;
        }
        A0n(new C10276y(nativeAdListener, nativeAdBase));
    }

    public final void A1c(NativeAdLayout nativeAdLayout) {
        this.A08 = nativeAdLayout;
    }

    public final void A1d(C2347ju c2347ju) {
        A0i(c2347ju, true);
        if (this.A0I != null && c2347ju.A0H() != null) {
            C1645Vv c1645Vv = new C1645Vv(this);
            for (UK uk : c2347ju.A0H()) {
                if (A0q[3].charAt(5) != 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A0q;
                strArr[0] = "7JUEXy8BV6wMe69mvRG8Hisl1h58kfsH";
                strArr[4] = "Ag7M0cktqfZPxcWhbEyn8XCMGlxm5ALn";
                uk.A0j(c1645Vv);
            }
        }
    }

    public final void A1e(C2212hT c2212hT) {
        this.A0X = new WeakReference<>(c2212hT);
    }

    public final void A1f(VW vw, String str, T3 t3) {
        if (str == null) {
            this.A0g.A0F().A3Q();
        } else {
            this.A0g.A0F().A3P();
        }
        this.A00 = System.currentTimeMillis();
        boolean z = this.A0n;
        String[] strArr = A0q;
        if (strArr[0].charAt(21) != strArr[4].charAt(21)) {
            String[] strArr2 = A0q;
            strArr2[0] = "knecuAJjZigTf7VsFCGhTGCW7dxKplKn";
            strArr2[4] = "uRrNlLGUJL1gxvEKewtOLFu1Ztix0dl1";
            if (z) {
                AdSettings.IntegrationErrorMode integrationErrorModeA00 = OA.A00(this.A0g);
                String strA0W = A0W(566, 30, 105);
                AdSettings.IntegrationErrorMode integrationErrorMode = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;
                if (!integrationErrorMode.equals(integrationErrorModeA00)) {
                    C1637Vm c1637Vm = new C1637Vm(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0W(566, 30, 105));
                    A16().A0F().A3N(Y1.A01(this.A00), c1637Vm.A03().getErrorCode(), c1637Vm.A04());
                    if (this.A0I != null) {
                        this.A0I.ADp(c1637Vm);
                    } else {
                        Log.e(A0W(76, 17, 41), strA0W);
                    }
                    C1578Te c1578Te = new C1578Te(strA0W);
                    A16().A08().ABC(A0W(550, 3, 101), AbstractC1577Td.A0c, c1578Te);
                } else {
                    throw new OF(strA0W);
                }
            }
            this.A0n = true;
            this.A0G = vw;
            if (vw.equals(VW.A05)) {
                NE ne = NE.A05;
                if (A0q[3].charAt(5) == 'B') {
                    A0q[3] = "N11XMBa1eBkGGouoRChlRsXEwEtHvHDZ";
                    this.A09 = ne;
                }
            }
            this.A0D = t3;
            O7 o7 = new O7(this.A0k, this.A0L, A0R(), null, 1, new C2284ij());
            o7.A05(vw);
            o7.A06(this.A0V);
            o7.A07(this.A0W);
            this.A0B = new C10357g(this.A0g, o7);
            this.A0B.A0S(new C1646Vw(this));
            this.A0B.A0W(str);
            return;
        }
        throw new RuntimeException();
    }

    public final void A1g(C1629Vd c1629Vd) {
        this.A0J = c1629Vd;
    }

    public final void A1h(EnumC1630Ve enumC1630Ve) {
        this.A0K = enumC1630Ve;
    }

    public final void A1i(EnumC1640Vq enumC1640Vq) {
        if (!A0r()) {
            if (EnumC1640Vq.A05.equals(enumC1640Vq)) {
                this.A0g.A0F().A3T(AdPlacementType.NATIVE_BANNER.toString(), this.A0k);
            } else {
                this.A0g.A0F().A3T(AdPlacementType.NATIVE.toString(), this.A0k);
            }
        }
        this.A0L = enumC1640Vq;
    }

    public final void A1j(InterfaceC1727Zc interfaceC1727Zc) {
        this.A0N = interfaceC1727Zc;
    }

    public final void A1k(AbstractC2109fo abstractC2109fo) {
        this.A0Y = new WeakReference<>(abstractC2109fo);
    }

    public final void A1l(boolean z) {
        this.A0a = z;
    }

    public final void A1m(boolean z) {
        this.A0Z = z;
    }

    public final void A1n(boolean z) {
        this.A0b = z;
    }

    public final void A1o(boolean z, boolean z2) {
        String strA0W;
        if (z) {
            if (this.A0G.equals(VW.A05)) {
                boolean zA0r = A0r();
                if (A0q[3].charAt(5) != 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A0q;
                strArr[6] = "maLBxQjysuwmJ75m3YPaJDHU5JlBu";
                strArr[1] = "hXXEi4DazsshJWFEyRiAh7tUxgC1d";
                if (!zA0r && this.A0I != null) {
                    this.A0I.AEq();
                }
            }
            if (this.A0U != null) {
                this.A0U.A0U();
                this.A0i.A09();
                return;
            }
            return;
        }
        if (this.A0U != null) {
            C2347ju adapter = A12();
            if (adapter != null) {
                strA0W = adapter.A0G();
            } else if (A0q[5].length() != 3) {
                String[] strArr2 = A0q;
                strArr2[2] = "2ETmOz1YodPf8MKRGGB9YcIoy7FDTpAq";
                strArr2[7] = "k5VZ8yDbY0Zqj8FxkeEerY08JJe7M6tR";
                strA0W = A0W(0, 0, 121);
            } else {
                String[] strArr3 = A0q;
                strArr3[0] = "JjUCnZOckAfeDcKZajvIf0dyi7sruRRg";
                strArr3[4] = "GlO3j5qd4HFQ8L5mPWBpkp3onxgG8Q98";
                strA0W = A0W(0, 0, 121);
            }
            this.A0i.A0C(this.A0g, strA0W);
            this.A0U.A0V();
        }
        if (this.A0I != null && z2) {
            C1637Vm c1637VmA01 = C1637Vm.A01(AdErrorType.BROKEN_MEDIA_ERROR, A0W(93, 21, 47));
            A16().A0F().A3N(Y1.A01(this.A00), c1637VmA01.A03().getErrorCode(), c1637VmA01.A04());
            this.A0I.ADp(c1637VmA01);
        }
    }

    public final boolean A1p() {
        return this.A0Z;
    }

    public final boolean A1q() {
        return A0F().A0h();
    }

    public final boolean A1r() {
        return A0F().A0g();
    }

    public final boolean A1s() {
        return this.A0L == EnumC1640Vq.A05;
    }

    public final boolean A1t() {
        return this.A08 == null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1634Vi
    public final int A7d() {
        View view = this.A06;
        if (view instanceof AdNativeComponentView) {
            View videoView = ((AdNativeComponentView) view).getAdContentsView();
            if (videoView instanceof C2049eq) {
                return ((C2049eq) videoView).getCurrentPosition();
            }
            return -1;
        }
        return -1;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new C1632Vg(this, nativeAdBase);
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        AbstractC1648Vy.A05(A0W(553, 7, 95), A0W(363, 19, 11), A0W(21, 8, 17));
        if (C1615Up.A1z(this.A0g)) {
            A16().A0B().AKU(this.A03);
        }
        if (!A0r()) {
            this.A0g.A0F().A3U();
        }
        if (this.A0B != null) {
            this.A0B.A0Y(true);
            this.A0B.A0K();
            this.A0B = null;
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void downloadMedia() {
        if (this.A0G.equals(VW.A05)) {
            this.A09 = NE.A04;
        }
        this.A0G = VW.A04;
        A0i(this.A0e, false);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdBodyText() {
        return A0G(true).A0L();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdCallToAction() {
        return A0G(true).A0Z();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesImageUrl() {
        if (getAdChoicesIcon() == null) {
            return null;
        }
        return getAdChoicesIcon().getUrl();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesLinkUrl() {
        return A0F().A0M();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesText() {
        return A0F().A0N();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdHeadline() {
        return A0G(true).A0O();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdLinkDescription() {
        return A0G(true).A0P();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdSocialContext() {
        return A0G(true).A0T();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdTranslation() {
        return A0G(true).A0W();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdUntrimmedBodyText() {
        return A0G(true).A0X();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdvertiserName() {
        return A0G(true).A0Y();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final float getAspectRatio() {
        C1627Vb nativeAdImage;
        if (this.A0e == null || (nativeAdImage = this.A0e.A0E().A0H()) == null) {
            return 0.0f;
        }
        int width = nativeAdImage.getWidth();
        int height = nativeAdImage.getHeight();
        if (height <= 0) {
            return 0.0f;
        }
        float f = width;
        float f2 = height;
        String[] strArr = A0q;
        if (strArr[0].charAt(21) == strArr[4].charAt(21)) {
            throw new RuntimeException();
        }
        A0q[3] = "OUTl4BjdLTzCi4kmpI6eA9pKBM08eKMp";
        return f / f2;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0l;
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A0k;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final Drawable getPreloadedIconViewDrawable() {
        C1627Vb c1627VbA0I;
        Bitmap bitmapA0N;
        C2347ju adapter = this.A0e;
        if (adapter != null && (c1627VbA0I = A0F().A0I()) != null && (bitmapA0N = this.A0f.A0N(c1627VbA0I.getUrl())) != null) {
            return A05(A16(), bitmapA0N, A1t(), A1I());
        }
        return null;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getPromotedTranslation() {
        return A0G(true).A0S();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getSponsoredTranslation() {
        return A0G(true).A0U();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean hasCallToAction() {
        return this.A0e != null && this.A0e.A0Q();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean zA0A = true;
        if (this.A0B != null) {
            C10357g c10357g = this.A0B;
            String[] strArr = A0q;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0q;
            strArr2[2] = "gqyuy6F7WThaJUOfAsIyr4sziGGBhw0f";
            strArr2[7] = "L6lbko7Rv34huPFym8TvMBezY1vQkdWf";
            zA0A = c10357g.A0Z();
        } else if (this.A0C != null) {
            zA0A = this.A0C.A0A();
        }
        this.A0g.A0F().A5f(zA0A);
        return zA0A;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean isAdLoaded() {
        return this.A0e != null && this.A0e.A0R();
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        AbstractC1648Vy.A05(A0W(560, 6, 117), A0W(382, 24, 27), A0W(13, 8, 68));
        A1f(VW.A00(NativeAdBase.MediaCacheFlag.ALL), null, new T3(false, -1, -1));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        AbstractC1648Vy.A05(A0W(560, 6, 117), A0W(382, 24, 27), A0W(5, 8, 76));
        ((C1632Vg) nativeLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void onCtaBroadcast() {
        if (this.A05 != null) {
            this.A05.performClick();
        }
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        if (this.A04 != null) {
            this.A04.post(new C1647Vx(this));
        }
        String str = A0W(164, 16, 48) + AbstractC1692Xt.A03(this.A0g, th);
        A16().A0F().A3N(Y1.A01(this.A00), 2001, str);
        if (this.A0I != null) {
            this.A0I.ADp(new C1637Vm(2001, str));
        }
    }

    @Override // com.facebook.ads.Ad
    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints == null) {
            return;
        }
        A0o(extraHints.getHints());
        this.A0W = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void unregisterView() {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.UK.unregisterView():void");
    }
}
