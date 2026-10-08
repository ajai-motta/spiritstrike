package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.view.View;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public interface e extends k {
    boolean C();

    View M();

    Object a(Continuation<? super Unit> continuation);

    void a(String str);

    void b(boolean z);

    StateFlow<l> f();

    StateFlow<a> isPlaying();

    String m();

    StateFlow<i> o();

    void pause();

    void play();

    void seekTo(long j);
}
