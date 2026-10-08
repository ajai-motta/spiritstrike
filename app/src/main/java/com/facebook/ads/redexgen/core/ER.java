package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"NEW_CLASS"}, value = "Encapsulate error info from subtitle decoder")
public class ER {

    @Nullable
    public final C2725qI A00;
    public final Throwable A01;

    public ER(@Nullable C2725qI c2725qI, Throwable th) {
        this.A00 = c2725qI;
        this.A01 = th;
    }
}
