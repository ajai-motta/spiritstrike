package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.os.Build;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements k {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f3000a;
    public final LifecycleEventObserver b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3001a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f3001a = iArr;
        }
    }

    public d(Lifecycle lifecycle, final Function0<Unit> onExoResume, final Function0<Unit> onExoPause) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(onExoResume, "onExoResume");
        Intrinsics.checkNotNullParameter(onExoPause, "onExoPause");
        this.f3000a = lifecycle;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer.d$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                d.a(onExoResume, onExoPause, lifecycleOwner, event);
            }
        };
        this.b = lifecycleEventObserver;
        lifecycle.addObserver(lifecycleEventObserver);
    }

    public static final void a(Function0 function0, Function0 function02, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = a.f3001a[event.ordinal()];
        if (i == 1) {
            if (Build.VERSION.SDK_INT > 23) {
                function0.invoke();
            }
        } else if (i == 2) {
            if (Build.VERSION.SDK_INT <= 23) {
                function0.invoke();
            }
        } else if (i == 3) {
            if (Build.VERSION.SDK_INT <= 23) {
                function02.invoke();
            }
        } else if (i == 4 && Build.VERSION.SDK_INT > 23) {
            function02.invoke();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        this.f3000a.removeObserver(this.b);
    }
}
