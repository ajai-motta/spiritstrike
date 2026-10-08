package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2666pK implements C4W {
    public Message A00;
    public C2665pJ A01;

    public C2666pK() {
    }

    private void A00() {
        this.A00 = null;
        this.A01 = null;
        C2665pJ.A01(this);
    }

    public final C2666pK A01(Message message, C2665pJ c2665pJ) {
        this.A00 = message;
        this.A01 = c2665pJ;
        return this;
    }

    public final void A02() {
        ((Message) AbstractC09493y.A01(this.A00)).sendToTarget();
        A00();
    }

    public final boolean A03(Handler handler) {
        boolean success = handler.sendMessageAtFrontOfQueue((Message) AbstractC09493y.A01(this.A00));
        A00();
        return success;
    }
}
