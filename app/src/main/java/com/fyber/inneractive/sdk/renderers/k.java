package com.fyber.inneractive.sdk.renderers;

import androidx.compose.animation.core.AnimationConstants;

/* JADX INFO: loaded from: classes3.dex */
public enum k {
    BANNER_WIDTH(320),
    BANNER_HEIGHT(50),
    BANNER_TABLET_HEIGHT(90),
    BANNER_TABLET_WIDTH(728),
    RECTANGLE_HEIGHT(250),
    RECTANGLE_WIDTH(AnimationConstants.DefaultDurationMillis);

    final int value;

    k(int i) {
        this.value = i;
    }
}
