package com.facebook.ads.redexgen.core;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6J, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C6J extends AbstractC1346Ka {
    public static byte[] A02;
    public static String[] A03 = {"ccLmdgMtf", "50lpHgsnQSuWf1CWCacJGyiAwAWsDUud", "Nq2vo108Bdlpu7LWCjcAC5dDG31maruF", "TAe0PaklKNA7XHBVlxrhZCtyBfgeydAO", "ouUdcivF6", "IAXVD4SBpgtyrGYWX4yc8p2wBrUpSeUf", "nA5GNdAWyE31pAGlKcdnPdOQEY7Q2fwD", "a5Dyr8HKQP9cZfy0xnx35qJg31dQk6"};
    public static final int A04;
    public final View A00;
    public final boolean A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[7].length() != 30) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "FT3046kmt";
            strArr[4] = "J6Q3a22Lt";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 71);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{37, 33, 45, 43, 41};
    }

    static {
        A01();
        A04 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public C6J(C1882c7 c1882c7, boolean z) {
        super(c1882c7, true);
        this.A01 = z;
        this.A00 = c1882c7.A02();
        if (this.A00 == null) {
            return;
        }
        A1S();
        if (this.A01) {
            addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        } else {
            FrameLayout frameLayout = new FrameLayout(c1882c7.A06());
            RelativeLayout.LayoutParams insideContainerParams = new RelativeLayout.LayoutParams(-1, -1);
            insideContainerParams.addRule(2, getAdDetailsView().getId());
            frameLayout.setLayoutParams(insideContainerParams);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            layoutParams.setMargins(AbstractC1878c3.A08, 0, AbstractC1878c3.A08, 0);
            frameLayout.addView(this.A00, layoutParams);
            addView(frameLayout);
        }
        XR xrA02 = this.A08.A02(getAdDataBundle());
        c1882c7.A06().A0H().A00(xrA02.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A08);
        if (this.A00 != null) {
            if (xrA02.A00) {
                this.A00.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.c8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.A00.A1X(view);
                    }
                });
            } else if (C1615Up.A1J(getAdContextWrapper())) {
                AbstractC1825bC.A00(this.A00, C1615Up.A1K(getAdContextWrapper()), new ViewOnClickListenerC1884c9(this));
            }
        }
        getAdDetailsView().bringToFront();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1878c3
    public final boolean A0A() {
        return this.A01 && super.A0B();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1878c3
    public final boolean A0B() {
        return this.A01 && super.A0B();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1346Ka, com.facebook.ads.redexgen.core.AbstractC1878c3
    public final void A1H(NR nr, String str, double d, Bundle bundle) {
        super.A1H(nr, str, d, bundle);
        if (!this.A01 && d > 0.0d && this.A00 != null) {
            int mediaHeight = (int) (((double) (A04 - (AbstractC1878c3.A08 * 2))) / d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, mediaHeight);
            layoutParams.gravity = 17;
            int i = AbstractC1878c3.A08;
            int mediaHeight2 = AbstractC1878c3.A08;
            layoutParams.setMargins(i, 0, mediaHeight2, 0);
            this.A00.setLayoutParams(layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1878c3
    public final boolean A1O() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1346Ka
    public final AbstractC1828bF A1R(C1882c7 c1882c7, NR nr, String str) {
        return new C1349Kd(c1882c7.A06(), getCtaButton(), AbstractC1346Ka.A0F, nr.A0I().A00() == NW.A05, getColors(), nr.A0J().A06(), str, c1882c7.A07(), c1882c7.A0C(), c1882c7.A0F(), c1882c7.A0A(), c1882c7.A05());
    }

    public final /* synthetic */ void A1X(View view) {
        getCtaButton().A0E(A00(0, 5, 11));
    }
}
