package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1825bC {
    public static void A00(View view, boolean z, View.OnClickListener onClickListener) {
        if (!z) {
            view.setOnClickListener(onClickListener);
        } else {
            if (!z) {
                return;
            }
            ViewOnClickListenerC1824bB viewOnClickListenerC1824bB = new ViewOnClickListenerC1824bB(onClickListener);
            view.setOnClickListener(viewOnClickListenerC1824bB);
            view.setOnTouchListener(new ViewOnTouchListenerC1823bA(viewOnClickListenerC1824bB));
        }
    }
}
