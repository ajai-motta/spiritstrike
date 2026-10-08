package com.fyber.inneractive.sdk.video;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.cache.n;
import com.fyber.inneractive.sdk.util.s;
import com.fyber.inneractive.sdk.util.w;
import com.fyber.inneractive.sdk.util.x;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements w {
    @Override // com.fyber.inneractive.sdk.util.w
    public final boolean a() {
        return TextUtils.equals("vid_cache", "vid_cache") && n.f.c && s.a();
    }

    @Override // com.fyber.inneractive.sdk.util.w
    public final x getType() {
        return x.Video;
    }
}
