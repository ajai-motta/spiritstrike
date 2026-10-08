package com.facebook.ads.redexgen.core;

import android.os.Looper;
import android.util.SparseArray;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class A8 implements InterfaceC2629oj {
    public static String[] A09 = {"4o0rkz4sfHeK33SO99B05QXsoRhyQzGZ", "K0gAeF3eD9ckm8sSKGrLnlGwgDvg6cGZ", "7dDhReETm", "uWDgAo3QhNS2SDAVWxvGGUxEzkeXCi8E", "iTLUe92lN", "exEbYNMUNVYj7aZkfWzuIWQ7Xih8easj", "xOp2qsvLijFTZdD02NXuZsLwHYitQrqs", "G4m8GVqXoTOlF678hGe6mWsbCNLG0"};
    public InterfaceC09283b A00;
    public C4X A01;
    public C09544d<AnonymousClass88> A02;
    public boolean A03;
    public final AnonymousClass45 A07;
    public final C2692pl A05 = new C2692pl();
    public final C2690pj A06 = new C2690pj();
    public final C8A A08 = new C8A(this.A05);
    public final SparseArray<AnonymousClass86> A04 = new SparseArray<>();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.facebook.ads.redexgen.X.86] */
    @RequiresNonNull({"player"})
    private final AnonymousClass86 A03(final Timeline timeline, final int i, C2573no c2573no) {
        final C2573no c2573no2 = c2573no;
        if (timeline.A0N()) {
            c2573no2 = null;
        }
        final long jA6J = this.A07.A6J();
        boolean z = timeline.equals(this.A00.A7g()) && i == this.A00.A7b();
        if (c2573no2 != null && c2573no2.A00()) {
            if (z && this.A00.A7Y() == c2573no2.A00 && this.A00.A7Z() == c2573no2.A01) {
                jA04 = this.A00.A7e();
            }
        } else if (z) {
            jA04 = this.A00.A7T();
            String[] strArr = A09;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A09[6] = "ZwCTxmE9kC93SnFyqUzyIs0NB6ZXsqqf";
        } else {
            jA04 = timeline.A0N() ? 0L : timeline.A0K(i, this.A06).A04();
            String[] strArr2 = A09;
            if (strArr2[3].length() == strArr2[1].length()) {
                A09[6] = "IrjjFtfbEX9d6APA3g1gQ2wngpNkMZh7";
            }
        }
        final C2573no c2573noA06 = this.A08.A06();
        final Timeline timelineA7g = this.A00.A7g();
        final int iA7b = this.A00.A7b();
        final long jA7e = this.A00.A7e();
        final long jA9J = this.A00.A9J();
        return new Object(jA6J, timeline, i, c2573no2, jA04, timelineA7g, iA7b, c2573noA06, jA7e, jA9J) { // from class: com.facebook.ads.redexgen.X.86
            public final int A00;
            public final int A01;
            public final long A02;
            public final long A03;
            public final long A04;
            public final long A05;
            public final Timeline A06;
            public final Timeline A07;
            public final C2573no A08;
            public final C2573no A09;

            {
                this.A04 = jA6J;
                this.A07 = timeline;
                this.A01 = i;
                this.A09 = c2573no2;
                this.A03 = jA04;
                this.A06 = timelineA7g;
                this.A00 = iA7b;
                this.A08 = c2573noA06;
                this.A02 = jA7e;
                this.A05 = jA9J;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                AnonymousClass86 anonymousClass86 = (AnonymousClass86) obj;
                if (this.A04 == anonymousClass86.A04 && this.A01 == anonymousClass86.A01 && this.A03 == anonymousClass86.A03 && this.A00 == anonymousClass86.A00 && this.A02 == anonymousClass86.A02 && this.A05 == anonymousClass86.A05 && CB.A01(this.A07, anonymousClass86.A07) && CB.A01(this.A09, anonymousClass86.A09) && CB.A01(this.A06, anonymousClass86.A06) && CB.A01(this.A08, anonymousClass86.A08)) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return CB.A00(Long.valueOf(this.A04), this.A07, Integer.valueOf(this.A01), this.A09, Long.valueOf(this.A03), this.A06, Integer.valueOf(this.A00), this.A08, Long.valueOf(this.A02), Long.valueOf(this.A05));
            }
        };
    }

    public A8(AnonymousClass45 anonymousClass45) {
        this.A07 = (AnonymousClass45) AbstractC09493y.A01(anonymousClass45);
        this.A02 = new C09544d<>(C5C.A0d(), anonymousClass45, new InterfaceC09524b() { // from class: com.facebook.ads.redexgen.X.og
        });
    }

    private final AnonymousClass86 A00() {
        return A04(this.A08.A06());
    }

    private AnonymousClass86 A01(int i, C2573no c2573no) {
        AbstractC09493y.A01(this.A00);
        boolean z = true;
        if (c2573no != null) {
            if (this.A08.A05(c2573no) == null) {
                z = false;
            }
            if (z) {
                return A04(c2573no);
            }
            return A03(Timeline.A02, i, c2573no);
        }
        Timeline timelineA7g = this.A00.A7g();
        if (i >= timelineA7g.A07()) {
            z = false;
        }
        if (!z) {
            timelineA7g = Timeline.A02;
        }
        return A03(timelineA7g, i, null);
    }

    private AnonymousClass86 A02(C2706pz c2706pz) {
        if (c2706pz instanceof AD) {
            AD ad = (AD) c2706pz;
            if (ad.A05 != null) {
                return A04(new C2573no(ad.A05));
            }
        }
        return A00();
    }

    private AnonymousClass86 A04(C2573no c2573no) {
        Timeline timelineA05;
        AbstractC09493y.A01(this.A00);
        if (c2573no == null) {
            timelineA05 = null;
        } else {
            timelineA05 = this.A08.A05(c2573no);
        }
        if (c2573no == null || timelineA05 == null) {
            int windowIndex = this.A00.A7b();
            Timeline knownTimeline = this.A00.A7g();
            if (!(windowIndex < knownTimeline.A07())) {
                knownTimeline = Timeline.A02;
            }
            return A03(knownTimeline, windowIndex, null);
        }
        return A03(timelineA05, timelineA05.A0J(c2573no.A04, this.A05).A00, c2573no);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4a != com.facebook.ads.androidx.media3.common.util.ListenerSet$Event<com.facebook.ads.androidx.media3.exoplayer.analytics.AnalyticsListener> */
    private final void A05(AnonymousClass86 anonymousClass86, int i, InterfaceC09514a<AnonymousClass88> interfaceC09514a) {
        this.A04.put(i, anonymousClass86);
        this.A02.A0A(i, interfaceC09514a);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2629oj
    public final void ACe() {
        if (!this.A03) {
            final AnonymousClass86 anonymousClass86A00 = A00();
            this.A03 = true;
            A05(anonymousClass86A00, -1, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oe
            });
        }
    }

    @Override // com.facebook.ads.redexgen.core.C3U
    public final void ADZ(final C2673pR c2673pR) {
        final AnonymousClass86 anonymousClass86A00 = A00();
        A05(anonymousClass86A00, 27, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oc
        });
    }

    @Override // com.facebook.ads.redexgen.core.C3U
    public final void ADa(final List<C2675pT> list) {
        final AnonymousClass86 anonymousClass86A00 = A00();
        A05(anonymousClass86A00, 27, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oR
        });
    }

    @Override // com.facebook.ads.redexgen.core.D9
    public final void ADk(int i, C2573no c2573no, final C1158Cs c1158Cs) {
        final AnonymousClass86 anonymousClass86A01 = A01(i, c2573no);
        A05(anonymousClass86A01, 1004, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oh
        });
    }

    @Override // com.facebook.ads.redexgen.core.D9
    public final void AEb(int i, C2573no c2573no, final Cq cq, final C1158Cs c1158Cs) {
        final AnonymousClass86 anonymousClass86A01 = A01(i, c2573no);
        A05(anonymousClass86A01, 1002, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.od
        });
    }

    @Override // com.facebook.ads.redexgen.core.D9
    public final void AEd(@MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) int i, @MetaExoPlayerCustomization(type = {"NEW_METHOD_ARGS"}) C2573no c2573no, final Cq cq, final C1158Cs c1158Cs, Object obj, Object obj2) {
        final AnonymousClass86 anonymousClass86A01 = A01(i, c2573no);
        A05(anonymousClass86A01, 1001, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oT
        });
    }

    @Override // com.facebook.ads.redexgen.core.D9
    public final void AEg(int i, C2573no c2573no, final Cq cq, final C1158Cs c1158Cs, final IOException iOException, final boolean z) {
        final AnonymousClass86 anonymousClass86A01 = A01(i, c2573no);
        A05(anonymousClass86A01, 1003, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oi
        });
    }

    @Override // com.facebook.ads.redexgen.core.C3U
    public final void AFI(final C2704px c2704px) {
        final AnonymousClass86 anonymousClass86A00 = A00();
        A05(anonymousClass86A00, 12, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.ob
        });
    }

    @Override // com.facebook.ads.redexgen.core.C3U
    public final void AFK(final C2706pz c2706pz) {
        final AnonymousClass86 anonymousClass86A02 = A02(c2706pz);
        A05(anonymousClass86A02, 10, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.of
        });
    }

    @Override // com.facebook.ads.redexgen.core.C3U
    public final void AFM(final boolean z, final int i) {
        final AnonymousClass86 anonymousClass86A00 = A00();
        A05(anonymousClass86A00, -1, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oa
        });
    }

    @Override // com.facebook.ads.redexgen.core.C3U
    public final void AFt() {
        final AnonymousClass86 anonymousClass86A00 = A00();
        A05(anonymousClass86A00, -1, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oS
        });
    }

    @Override // com.facebook.ads.redexgen.core.C3U
    public final void AGA(Timeline timeline, final int i) {
        this.A08.A07((InterfaceC09283b) AbstractC09493y.A01(this.A00));
        final AnonymousClass86 anonymousClass86A00 = A00();
        A05(anonymousClass86A00, 0, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oY
        });
    }

    @Override // com.facebook.ads.redexgen.core.C3U
    public final void AGE(final C2680pY c2680pY) {
        final AnonymousClass86 anonymousClass86A00 = A00();
        A05(anonymousClass86A00, 2, new InterfaceC09514a() { // from class: com.facebook.ads.redexgen.X.oW
        });
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2629oj
    public final void AJf(final InterfaceC09283b interfaceC09283b, Looper looper) {
        AbstractC09493y.A08(this.A00 == null || this.A08.A03.isEmpty());
        this.A00 = (InterfaceC09283b) AbstractC09493y.A01(interfaceC09283b);
        this.A01 = this.A07.A5P(looper, null);
        this.A02 = this.A02.A07(looper, new InterfaceC09524b() { // from class: com.facebook.ads.redexgen.X.oZ
        });
    }
}
