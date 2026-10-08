package com.google.android.exoplayer2.util;

import android.view.SurfaceView;
import com.google.android.exoplayer2.util.DebugViewProvider;

/* JADX INFO: loaded from: classes8.dex */
public interface DebugViewProvider {
    public static final DebugViewProvider NONE = new DebugViewProvider() { // from class: com.google.android.exoplayer2.util.DebugViewProvider$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.util.DebugViewProvider
        public final SurfaceView getDebugPreviewSurfaceView(int i, int i2) {
            return DebugViewProvider.CC.lambda$static$0(i, i2);
        }
    };

    /* JADX INFO: renamed from: com.google.android.exoplayer2.util.DebugViewProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            DebugViewProvider debugViewProvider = DebugViewProvider.NONE;
        }

        public static /* synthetic */ SurfaceView lambda$static$0(int i, int i2) {
            return null;
        }
    }

    SurfaceView getDebugPreviewSurfaceView(int i, int i2);
}
