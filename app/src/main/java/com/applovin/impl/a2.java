package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.b1;
import com.applovin.impl.e6;
import com.applovin.impl.n8;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.ExoPlayer;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a2 extends w1 implements AppLovinCommunicatorSubscriber {
    private final b2 M;
    private MediaPlayer N;
    private final View O;
    protected final AppLovinVideoView P;
    protected final com.applovin.impl.a Q;
    protected final com.applovin.impl.adview.g R;
    protected i0 S;
    protected final ImageView T;
    protected com.applovin.impl.adview.l U;
    protected final ProgressBar V;
    protected ProgressBar W;
    protected ImageView X;
    private final e Y;
    private final d Z;
    private final Handler a0;
    private final Handler b0;
    protected final b1 c0;
    protected final b1 d0;
    private final boolean e0;
    protected boolean f0;
    protected long g0;
    private int h0;
    private int i0;
    protected boolean j0;
    private boolean k0;
    private final AtomicBoolean l0;
    private final AtomicBoolean m0;
    private long n0;
    private long o0;

    class a implements b1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f281a;

        a(int i) {
            this.f281a = i;
        }

        @Override // com.applovin.impl.b1.b
        public void a() {
            if (a2.this.S != null) {
                long seconds = ((long) this.f281a) - TimeUnit.MILLISECONDS.toSeconds(r0.P.getCurrentPosition());
                if (seconds <= 0) {
                    a2.this.v = true;
                } else if (a2.this.Q()) {
                    a2.this.S.setProgress((int) seconds);
                }
            }
        }

        @Override // com.applovin.impl.b1.b
        public boolean b() {
            return a2.this.Q();
        }
    }

    class b implements b1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f282a;

        b(Integer num) {
            this.f282a = num;
        }

        @Override // com.applovin.impl.b1.b
        public void a() {
            a2 a2Var = a2.this;
            if (a2Var.j0) {
                a2Var.V.setVisibility(8);
            } else {
                a2.this.V.setProgress((int) ((a2Var.P.getCurrentPosition() / a2.this.g0) * this.f282a.intValue()));
            }
        }

        @Override // com.applovin.impl.b1.b
        public boolean b() {
            return !a2.this.j0;
        }
    }

    class c implements b1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f283a;
        final /* synthetic */ Integer b;
        final /* synthetic */ Long c;

        c(long j, Integer num, Long l) {
            this.f283a = j;
            this.b = num;
            this.c = l;
        }

        @Override // com.applovin.impl.b1.b
        public void a() {
            a2.this.W.setProgress((int) ((a2.this.r / this.f283a) * this.b.intValue()));
            a2.this.r += this.c.longValue();
        }

        @Override // com.applovin.impl.b1.b
        public boolean b() {
            return a2.this.r < this.f283a;
        }
    }

    private class d implements n8.a {
        private d() {
        }

        @Override // com.applovin.impl.n8.a
        public void a(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            a2.this.a("video_button");
        }

        @Override // com.applovin.impl.n8.a
        public void b(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            a2.this.a(lVar.getAndClearLastClickEvent());
        }

        @Override // com.applovin.impl.n8.a
        public void c(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "Fully Watched from video button...");
            }
            a2.this.J = true;
        }

        @Override // com.applovin.impl.n8.a
        public void d(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            a2.this.T();
        }

        /* synthetic */ d(a2 a2Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.n8.a
        public void a(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            l7.a(uri, a2.this.b().getController(), a2.this.b);
        }

        @Override // com.applovin.impl.n8.a
        public void b(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            l7.c(uri, a2.this.b().getController().g(), a2.this.b);
        }
    }

    private class e implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnCompletionListener, AppLovinTouchToClickListener.OnClickListener {
        private e() {
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            a2.this.a(motionEvent);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "Video completed");
            }
            a2.this.k0 = true;
            a2 a2Var = a2.this;
            if (!a2Var.t) {
                a2Var.S();
            } else if (a2Var.h()) {
                a2.this.A();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a2.this.g("Video view error (" + i + "," + i2 + ")");
            a2.this.P.start();
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i + ", " + i2 + ")");
            }
            if (i == 701) {
                a2.this.R();
                return false;
            }
            if (i != 3) {
                if (i != 702) {
                    return false;
                }
                a2.this.E();
                return false;
            }
            a2.this.c0.b();
            a2 a2Var = a2.this;
            if (a2Var.R != null) {
                a2Var.P();
            }
            a2.this.E();
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a2.this.N = mediaPlayer;
            mediaPlayer.setOnInfoListener(a2.this.Y);
            mediaPlayer.setOnErrorListener(a2.this.Y);
            float f = !a2.this.f0 ? 1 : 0;
            mediaPlayer.setVolume(f, f);
            a2.this.u = (int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration());
            a2.this.d(mediaPlayer.getDuration());
            a2.this.O();
            com.applovin.impl.sdk.o oVar = a2.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.a("AppLovinFullscreenActivity", "MediaPlayer prepared: " + a2.this.N);
            }
        }

        /* synthetic */ e(a2 a2Var, a aVar) {
            this();
        }
    }

    private class f implements View.OnClickListener {
        private f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a2 a2Var = a2.this;
            if (view == a2Var.R) {
                a2Var.T();
                return;
            }
            if (view == a2Var.T) {
                a2Var.U();
                return;
            }
            com.applovin.impl.sdk.o oVar = a2Var.c;
            if (com.applovin.impl.sdk.o.a()) {
                a2.this.c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }

        /* synthetic */ f(a2 a2Var, a aVar) {
            this();
        }
    }

    public a2(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.M = new b2(this.f701a, this.d, this.b);
        a aVar = null;
        this.X = null;
        e eVar = new e(this, aVar);
        this.Y = eVar;
        d dVar = new d(this, aVar);
        this.Z = dVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.a0 = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.b0 = handler2;
        b1 b1Var = new b1(handler, this.b);
        this.c0 = b1Var;
        this.d0 = new b1(handler2, this.b);
        boolean zC0 = this.f701a.C0();
        this.e0 = zC0;
        this.f0 = o7.e(this.b);
        this.i0 = -1;
        this.l0 = new AtomicBoolean();
        this.m0 = new AtomicBoolean();
        this.n0 = -2L;
        this.o0 = 0L;
        if (!bVar.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
        this.P = appLovinVideoView;
        appLovinVideoView.setOnPreparedListener(eVar);
        appLovinVideoView.setOnCompletionListener(eVar);
        appLovinVideoView.setOnErrorListener(eVar);
        bVar.h().putString("video_view_address", f8.a(appLovinVideoView));
        View view = new View(activity);
        this.O = view;
        boolean z = false;
        view.setBackgroundColor(Color.argb(254, 0, 0, 0));
        if (((Boolean) kVar.a(y4.r1)).booleanValue()) {
            view.setOnTouchListener(new AppLovinTouchToClickListener(kVar, y4.j0, activity, eVar));
        } else {
            appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(kVar, y4.j0, activity, eVar));
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda6
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return a2.a(view2, motionEvent);
                }
            });
        }
        f fVar = new f(this, aVar);
        if (bVar.d0() >= 0) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.U(), activity);
            this.R = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(fVar);
        } else {
            this.R = null;
        }
        if (a(this.f0, kVar)) {
            ImageView imageView = new ImageView(activity);
            this.T = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(fVar);
            e(this.f0);
        } else {
            this.T = null;
        }
        String strA0 = bVar.a0();
        if (StringUtils.isValidString(strA0)) {
            n8 n8Var = new n8(kVar);
            n8Var.a(new WeakReference(dVar));
            com.applovin.impl.adview.l lVar = new com.applovin.impl.adview.l(bVar.Z(), bVar, n8Var, activity);
            this.U = lVar;
            lVar.a(strA0);
        } else {
            this.U = null;
        }
        if (zC0) {
            com.applovin.impl.a aVar2 = new com.applovin.impl.a(activity, ((Integer) kVar.a(y4.p2)).intValue(), R.attr.progressBarStyleLarge);
            this.Q = aVar2;
            aVar2.setColor(Color.parseColor("#75FFFFFF"));
            aVar2.setBackgroundColor(Color.parseColor("#00000000"));
            aVar2.setVisibility(8);
            AppLovinCommunicator.getInstance(activity).subscribe(this, "video_caching_failed");
        } else {
            this.Q = null;
        }
        int iC = c();
        if (((Boolean) kVar.a(y4.Z1)).booleanValue() && iC > 0) {
            z = true;
        }
        if (this.S == null && z) {
            this.S = new i0(activity);
            int iS = bVar.s();
            this.S.setTextColor(iS);
            this.S.setTextSize(((Integer) kVar.a(y4.Y1)).intValue());
            this.S.setFinishedStrokeColor(iS);
            this.S.setFinishedStrokeWidth(((Integer) kVar.a(y4.X1)).intValue());
            this.S.setMax(iC);
            this.S.setProgress(iC);
            b1Var.a("COUNTDOWN_CLOCK", TimeUnit.SECONDS.toMillis(1L), new a(iC));
        }
        if (!bVar.k0()) {
            this.V = null;
            return;
        }
        Long l = (Long) kVar.a(y4.m2);
        Integer num = (Integer) kVar.a(y4.n2);
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
        this.V = progressBar;
        a(progressBar, bVar.j0(), num.intValue());
        b1Var.a("PROGRESS_BAR", l.longValue(), new b(num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        com.applovin.impl.a aVar = this.Q;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        com.applovin.impl.a aVar = this.Q;
        if (aVar != null) {
            aVar.a();
            final com.applovin.impl.a aVar2 = this.Q;
            Objects.requireNonNull(aVar2);
            a(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    aVar2.b();
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        this.n0 = -1L;
        this.o0 = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        com.applovin.impl.a aVar = this.Q;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L() {
        this.q = SystemClock.elapsedRealtime();
    }

    private void M() {
        com.applovin.impl.adview.l lVar;
        e8 e8VarB0 = this.f701a.b0();
        if (e8VarB0 == null || !e8VarB0.j() || this.j0 || (lVar = this.U) == null) {
            return;
        }
        final boolean z = lVar.getVisibility() == 4;
        final long jH = e8VarB0.h();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(z, jH);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.j0) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
                return;
            }
            return;
        }
        if (this.b.n0().isApplicationPaused()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k("AppLovinFullscreenActivity", "Skip video resume - app paused");
                return;
            }
            return;
        }
        if (this.i0 < 0) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Invalid last video position");
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Resuming video at position " + this.i0 + "ms for MediaPlayer: " + this.N);
        }
        this.P.seekTo(this.i0);
        this.P.start();
        this.c0.b();
        this.i0 = -1;
        a(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.I();
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.m0.compareAndSet(false, true)) {
            a(this.R, this.f701a.d0(), new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.J();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    private void e(boolean z) {
        if (o0.e()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.d.getDrawable(z ? com.applovin.sdk.R.drawable.applovin_ic_unmute_to_mute : com.applovin.sdk.R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.T.setScaleType(ImageView.ScaleType.FIT_XY);
                this.T.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        ImageViewUtils.setImageUri(this.T, z ? this.f701a.G() : this.f701a.Y(), this.b);
    }

    private void f(boolean z) {
        this.h0 = C();
        if (z) {
            this.P.pause();
        } else {
            this.P.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(String str) {
        p8.a(this.U, str, "AppLovinFullscreenActivity", this.b);
    }

    @Override // com.applovin.impl.w1
    protected void A() {
        this.M.a(this.l);
        this.q = SystemClock.elapsedRealtime();
    }

    protected int C() {
        long currentPosition = this.P.getCurrentPosition();
        if (this.k0) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((currentPosition / this.g0) * 100.0f) : this.h0;
    }

    public void D() {
        this.y++;
        if (this.f701a.u()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            a("video_skip");
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Skipping video...");
            }
            S();
        }
    }

    protected void E() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.H();
            }
        });
    }

    protected boolean F() {
        if (this.J && this.f701a.a1()) {
            return true;
        }
        return G();
    }

    protected boolean G() {
        return C() >= this.f701a.f0();
    }

    protected void O() {
        long jP;
        long millis;
        if (this.f701a.O() >= 0 || this.f701a.P() >= 0) {
            if (this.f701a.O() >= 0) {
                jP = this.f701a.O();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f701a;
                long j = this.g0;
                long j2 = j > 0 ? j : 0L;
                if (aVar.W0()) {
                    int iH1 = (int) ((com.applovin.impl.sdk.ad.a) this.f701a).h1();
                    if (iH1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iH1);
                    } else {
                        int iR = (int) aVar.r();
                        if (iR > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iR);
                        }
                    }
                    j2 += millis;
                }
                jP = (long) (j2 * (((double) this.f701a.P()) / 100.0d));
            }
            c(jP);
        }
    }

    protected boolean Q() {
        return (this.v || this.j0 || !this.P.isPlaying()) ? false : true;
    }

    protected void R() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.K();
            }
        });
    }

    public void S() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Showing postitial...");
        }
        f(this.f701a.d1());
        long jM = this.f701a.M();
        if (jM > 0) {
            this.r = 0L;
            Long l = (Long) this.b.a(y4.u2);
            Integer num = (Integer) this.b.a(y4.x2);
            ProgressBar progressBar = new ProgressBar(this.d, null, R.attr.progressBarStyleHorizontal);
            this.W = progressBar;
            a(progressBar, this.f701a.L(), num.intValue());
            this.d0.a("POSTITIAL_PROGRESS_BAR", l.longValue(), new c(jM, num, l));
            this.d0.b();
        }
        this.M.a(this.k, this.j, b(), this.W);
        a("javascript:al_onPoststitialShow(" + this.y + "," + this.z + ");", this.f701a.x());
        if (this.k != null) {
            if (this.f701a.r() >= 0) {
                a(this.k, this.f701a.r(), new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.L();
                    }
                });
            } else {
                this.k.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.k;
        if (gVar != null) {
            arrayList.add(new h4(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.j;
            arrayList.add(new h4(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        ProgressBar progressBar2 = this.W;
        if (progressBar2 != null) {
            arrayList.add(new h4(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        this.f701a.getAdEventTracker().b(b(), arrayList);
        p();
        this.j0 = true;
    }

    public void T() {
        this.n0 = SystemClock.elapsedRealtime() - this.o0;
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.n0 + "ms");
        }
        D();
    }

    protected void U() {
        MediaPlayer mediaPlayer = this.N;
        if (mediaPlayer == null) {
            return;
        }
        try {
            float f2 = this.f0 ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f2, f2);
            boolean z = !this.f0;
            this.f0 = z;
            e(z);
            a(this.f0, 0L);
        } catch (Throwable unused) {
        }
    }

    protected void d(long j) {
        this.g0 = j;
    }

    protected void g(String str) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f701a);
        }
        if (this.l0.compareAndSet(false, true)) {
            if (((Boolean) this.b.a(y4.T0)).booleanValue()) {
                this.b.G().d(this.f701a, com.applovin.impl.sdk.k.o());
            }
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.F;
            if (appLovinAdDisplayListener instanceof l2) {
                ((l2) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            String str2 = this.f701a instanceof p7 ? "handleVastVideoError" : "handleVideoError";
            this.b.D().a(str2, str, this.f701a);
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", str2);
            CollectionUtils.putStringIfValid(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, mapHashMap);
            this.b.g().a(d2.E, this.f701a, mapHashMap);
            a("media_error");
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    @Override // com.applovin.impl.w1
    protected void m() {
        super.a(C(), this.e0, F(), this.n0);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.f701a.getAdIdNumber() && this.e0) {
                int i = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && !r0.a(i)) || this.k0 || this.P.isPlaying()) {
                    return;
                }
                g("Video cache error during stream. ResponseCode=" + i + ", exception=" + string);
            }
        }
    }

    @Override // com.applovin.impl.w1
    public void r() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (((Boolean) this.b.a(y4.w6)).booleanValue()) {
                p8.b(this.U);
                this.U = null;
            }
            if (this.e0) {
                AppLovinCommunicator.getInstance(this.d).unsubscribe(this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.P;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.P.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.N;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.r();
    }

    @Override // com.applovin.impl.w1
    public void v() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Pausing video");
        }
        this.i0 = this.P.getCurrentPosition();
        this.P.pause();
        this.c0.c();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Paused video at position " + this.i0 + "ms");
        }
    }

    @Override // com.applovin.impl.w1
    public void w() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.w1
    public void b(boolean z) {
        super.b(z);
        if (z) {
            b(0L);
            if (this.j0) {
                this.d0.b();
                return;
            }
            return;
        }
        if (this.j0) {
            this.d0.c();
        } else {
            v();
        }
    }

    @Override // com.applovin.impl.w1
    public void a(ViewGroup viewGroup) {
        String str;
        this.M.a(this.T, this.R, this.U, this.Q, this.V, this.S, this.P, this.O, b(), this.j, this.X, viewGroup);
        if (o0.h() && (str = this.b.o0().getExtraParameters().get("audio_focus_request")) != null) {
            this.P.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (((Boolean) this.b.a(y4.Y5)).booleanValue() || !a(!this.e0)) {
            this.P.setVideoURI(this.f701a.l0());
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            com.applovin.impl.adview.k kVar = this.j;
            if (kVar != null) {
                kVar.b();
            }
            this.P.start();
            if (this.e0) {
                R();
            }
            b().renderAd(this.f701a);
            if (this.R != null) {
                this.b.r0().a(new s6(this.b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.P();
                    }
                }), e6.b.TIMEOUT, this.f701a.e0(), true);
            }
            super.c(this.f0);
        }
    }

    @Override // com.applovin.impl.w1
    public void f() {
        super.f();
        this.M.a(this.U);
        this.M.a((View) this.R);
        if (!h() || this.j0) {
            A();
        }
    }

    @Override // com.applovin.impl.w1
    public void e() {
        super.e();
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z, long j) {
        if (z) {
            f8.a(this.U, j, (Runnable) null);
        } else {
            f8.b(this.U, j, null);
        }
    }

    @Override // com.applovin.impl.w1
    public void b(long j) {
        a(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.N();
            }
        }, j);
    }

    @Override // com.applovin.impl.w1
    protected void a(final String str, long j) {
        super.a(str, j);
        if (this.U == null || j < 0 || !StringUtils.isValidString(str)) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.h(str);
            }
        }, j);
    }

    private void a(ProgressBar progressBar, int i, int i2) {
        progressBar.setMax(i2);
        progressBar.setPadding(0, 0, 0, 0);
        if (o0.e()) {
            progressBar.setProgressTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // com.applovin.impl.w1
    public void a(String str) {
        this.c0.a();
        this.d0.a();
        this.a0.removeCallbacksAndMessages(null);
        this.b0.removeCallbacksAndMessages(null);
        if (!((Boolean) this.b.a(y4.Q6)).booleanValue()) {
            com.applovin.impl.sdk.ad.b bVar = this.f701a;
            if (bVar != null) {
                bVar.a(str);
            }
            m();
        }
        super.a(str);
    }

    protected void a(MotionEvent motionEvent) {
        Context context;
        if (this.f701a.B0()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri uriC0 = this.f701a.c0();
            if (uriC0 != null) {
                if (!((Boolean) this.b.a(y4.x)).booleanValue() || (context = this.d) == null) {
                    context = b() != null ? b().getContext() : com.applovin.impl.sdk.k.o();
                }
                this.b.k().trackAndLaunchVideoClick(this.f701a, uriC0, motionEvent, this, context);
                t2.a(this.E, this.f701a);
                this.z++;
                return;
            }
            return;
        }
        M();
    }

    private static boolean a(boolean z, com.applovin.impl.sdk.k kVar) {
        if (!((Boolean) kVar.a(y4.e2)).booleanValue()) {
            return false;
        }
        if (!((Boolean) kVar.a(y4.f2)).booleanValue() || z) {
            return true;
        }
        return ((Boolean) kVar.a(y4.h2)).booleanValue();
    }
}
