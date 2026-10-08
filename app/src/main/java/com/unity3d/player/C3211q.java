package com.unity3d.player;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* JADX INFO: renamed from: com.unity3d.player.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3211q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3329a;
    private final AudioManager b;
    private C3207o c;

    public C3211q(Context context) {
        this.f3329a = context;
        this.b = (AudioManager) context.getSystemService("audio");
    }

    public final void a() {
        if (this.c != null) {
            this.f3329a.getContentResolver().unregisterContentObserver(this.c);
            this.c = null;
        }
    }

    public final void a(InterfaceC3209p interfaceC3209p) {
        this.c = new C3207o(new Handler(Looper.getMainLooper()), this.b, interfaceC3209p);
        this.f3329a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.c);
    }
}
