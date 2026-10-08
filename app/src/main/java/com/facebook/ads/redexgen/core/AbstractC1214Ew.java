package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ew, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1214Ew {
    public InterfaceC1213Ev A00;
    public F6 A01;

    public abstract boolean A0Y();

    public abstract C1215Ex A0b(InterfaceC10447p[] interfaceC10447pArr, C2555nW c2555nW, C2573no c2573no, Timeline timeline) throws AD;

    public abstract void A0c(Object obj);

    public final F6 A00() {
        return (F6) AbstractC09493y.A02(this.A01);
    }

    public final void A01() {
        if (this.A00 != null) {
            this.A00.AGD();
        }
    }

    public final void A02(InterfaceC1213Ev interfaceC1213Ev, F6 f6) {
        this.A00 = interfaceC1213Ev;
        this.A01 = f6;
    }
}
