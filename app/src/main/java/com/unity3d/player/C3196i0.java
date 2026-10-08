package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: renamed from: com.unity3d.player.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3196i0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3189f f3314a;
    private UnityPlayer b;
    private K c;

    public C3196i0(Context context, UnityPlayer unityPlayer) {
        int i;
        super(context);
        this.c = new K(context);
        this.b = unityPlayer;
        C3189f c3189f = new C3189f(context, unityPlayer);
        this.f3314a = c3189f;
        c3189f.setId(context.getResources().getIdentifier("unitySurfaceView", "id", context.getPackageName()));
        if (a()) {
            this.f3314a.getHolder().setFormat(-3);
            this.f3314a.setZOrderOnTop(true);
            i = 0;
        } else {
            this.f3314a.getHolder().setFormat(-1);
            i = -16777216;
        }
        setBackgroundColor(i);
        this.f3314a.getHolder().addCallback(new SurfaceHolderCallbackC3194h0(this));
        this.f3314a.setFocusable(true);
        this.f3314a.setFocusableInTouchMode(true);
        this.f3314a.setContentDescription(a(context));
        addView(this.f3314a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private static String a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", TypedValues.Custom.S_STRING, context.getPackageName()));
    }

    private static boolean a() {
        Activity activity = UnityPlayer.currentActivity;
        if (activity == null) {
            return false;
        }
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    final void a(float f) {
        this.f3314a.a(f);
    }

    public final void b() {
        K k = this.c;
        UnityPlayer unityPlayer = this.b;
        J j = k.b;
        if (j != null && j.getParent() != null) {
            unityPlayer.removeView(k.b);
        }
        this.c.b = null;
    }

    public final boolean c() {
        C3189f c3189f = this.f3314a;
        return c3189f != null && c3189f.a();
    }
}
