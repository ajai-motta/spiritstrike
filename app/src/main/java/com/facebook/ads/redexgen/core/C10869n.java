package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C10869n extends AbstractC2580nv implements DI {
    public long A00;
    public InterfaceC09965t A01;
    public InterfaceC2406ku<InterfaceExecutorC1219Fb> A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final int A06;
    public final AnonymousClass32 A07;
    public final C2714q7 A08;
    public final C5Y A09;
    public final A6 A0A;
    public final DC A0B;
    public final FF A0C;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ku != com.google.common.base.Supplier<com.facebook.ads.androidx.media3.exoplayer.util.ReleasableExecutor> */
    @MetaExoPlayerCustomization("Allow for passing a new drmSessionManager")
    public C10869n(C2714q7 c2714q7, C5Y c5y, DC dc, A6 a6, FF ff, int i, InterfaceC2406ku<InterfaceExecutorC1219Fb> interfaceC2406ku) {
        this.A07 = (AnonymousClass32) AbstractC09493y.A01(c2714q7.A03);
        this.A08 = c2714q7;
        this.A09 = c5y;
        this.A0B = dc;
        this.A0A = a6 == null ? A6.A00 : a6;
        this.A0C = ff;
        this.A06 = i;
        this.A04 = true;
        this.A00 = C.TIME_UNSET;
        this.A02 = interfaceC2406ku;
    }

    private void A00() {
        final Timeline c10859m = new C10859m(this.A00, this.A05, false, this.A03, null, this.A08);
        if (this.A04) {
            Timeline timeline = new C9t(c10859m) { // from class: com.facebook.ads.redexgen.X.1e
                @Override // com.facebook.ads.redexgen.core.C9t, com.facebook.ads.androidx.media3.common.Timeline
                public final C2692pl A0I(int i, C2692pl c2692pl, boolean z) {
                    super.A0I(i, c2692pl, z);
                    c2692pl.A05 = true;
                    return c2692pl;
                }

                @Override // com.facebook.ads.redexgen.core.C9t, com.facebook.ads.androidx.media3.common.Timeline
                public final C2690pj A0L(int i, C2690pj c2690pj, long j) {
                    super.A0L(i, c2690pj, j);
                    c2690pj.A0F = true;
                    return c2690pj;
                }
            };
            c10859m = timeline;
        }
        A05(c10859m);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2580nv
    public final void A09() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2580nv
    public final void A0A(InterfaceC09965t interfaceC09965t) {
        this.A01 = interfaceC09965t;
        this.A0A.AH4();
        this.A0A.AJe((Looper) AbstractC09493y.A01(Looper.myLooper()), A00());
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1163Cx
    @MetaExoPlayerCustomization("PlayerId needs to be set")
    public final InterfaceC2574np A5W(C2573no c2573no, F0 f0, long j) {
        InterfaceExecutorC1219Fb interfaceExecutorC1219Fb;
        InterfaceC2661pF interfaceC2661pFA5I = this.A09.A5I();
        if (this.A01 != null) {
            interfaceC2661pFA5I.A43(this.A01);
        }
        Uri uri = this.A07.A00;
        DD ddA5X = this.A0B.A5X(C8O.A03);
        A6 a6 = this.A0A;
        A1 a1A01 = A01(c2573no);
        FF ff = this.A0C;
        D8 d8A02 = A02(c2573no);
        String str = this.A07.A04;
        int i = this.A06;
        if (this.A02 != null) {
            interfaceExecutorC1219Fb = this.A02.get();
        } else {
            interfaceExecutorC1219Fb = null;
        }
        return new C10889p(uri, interfaceC2661pFA5I, ddA5X, a6, a1A01, ff, d8A02, this, f0, str, i, interfaceExecutorC1219Fb);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1163Cx
    public final void ACT() {
    }

    @Override // com.facebook.ads.redexgen.core.DI
    public final void AG0(long j, boolean z, boolean z2) {
        if (j == C.TIME_UNSET) {
            j = this.A00;
        }
        if (!this.A04 && this.A00 == j && this.A05 == z && this.A03 == z2) {
            return;
        }
        this.A00 = j;
        this.A05 = z;
        this.A03 = z2;
        this.A04 = false;
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1163Cx
    public final void AHk(InterfaceC2574np interfaceC2574np) {
        ((C10889p) interfaceC2574np).A0a();
    }
}
