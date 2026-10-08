package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class K3 implements InterfaceC1821b8 {
    public final /* synthetic */ C1328Ji A00;

    public K3(C1328Ji c1328Ji) {
        this.A00 = c1328Ji;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1821b8
    public final void AE7(C1820b7 c1820b7) {
        if (this.A00.A02 != null && c1820b7.A00() != null) {
            this.A00.A02.setImageBitmap(c1820b7.A00());
            this.A00.A02.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.A00.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }
}
