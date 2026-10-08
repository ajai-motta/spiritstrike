package com.fyber.inneractive.sdk.player.controller;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.MediaCodecAudioRenderer;
import com.fyber.inneractive.sdk.player.exoplayer2.video.MediaCodecVideoRenderer;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.exoplayer2.C;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends q {
    public final boolean A;
    public final CopyOnWriteArrayList B;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.u C;
    public boolean D;
    public int E;
    public final int p;
    public final com.fyber.inneractive.sdk.config.global.r q;
    public final int r;
    public com.fyber.inneractive.sdk.player.exoplayer2.g s;
    public int t;
    public int u;
    public boolean v;
    public com.fyber.inneractive.sdk.player.exoplayer2.a[] w;
    public Handler x;
    public b0 y;
    public boolean z;

    public f(Context context, boolean z, com.fyber.inneractive.sdk.config.global.r rVar) {
        Integer numA;
        super(context);
        this.t = 0;
        this.u = 0;
        this.v = false;
        this.z = false;
        this.B = new CopyOnWriteArrayList();
        this.C = null;
        this.E = 0;
        this.A = z;
        this.q = rVar;
        this.r = IAConfigManager.O.u.b.a("extractor_source_retry_count", 6, 3);
        com.fyber.inneractive.sdk.config.global.features.u uVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class) : null;
        this.p = (uVar == null || (numA = uVar.a("max_tries")) == null) ? 0 : numA.intValue();
        IAlog.a("Creating IAExoPlayer2Controller", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a() {
        if (this.s != null) {
            if (!this.z) {
                this.z = true;
                com.fyber.inneractive.sdk.util.r.f1668a.execute(new e(this));
            }
            b0 b0Var = this.y;
            if (b0Var != null) {
                b0Var.f1237a.clear();
            }
            this.y = null;
        }
        Iterator it = this.B.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.B.clear();
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void b(boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar;
        this.n = z;
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr = this.w;
        if (aVarArr == null || (gVar = this.s) == null || this.z || aVarArr.length < 2) {
            return;
        }
        gVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.e(aVarArr[1], 2, Float.valueOf(0.0f)));
        this.v = true;
        c(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int c() {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar == null || this.z) {
            return 0;
        }
        return (int) (gVar.m.c() ? C.TIME_UNSET : com.fyber.inneractive.sdk.player.exoplayer2.b.a(gVar.m.a(gVar.a(), gVar.f).f));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void d(boolean z) {
        this.n = z;
        if (this.s == null || this.z) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.f1251a.getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f = streamVolume / streamMaxVolume;
        IAlog.a(" unmute maxVolume = %d currentVolume = %d targetVolume = %s", Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
        if (streamVolume == 0) {
            IAlog.a("Avoided unmute - Device is muted", new Object[0]);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr = this.w;
        if (aVarArr != null && aVarArr.length >= 2) {
            this.s.a(new com.fyber.inneractive.sdk.player.exoplayer2.e(aVarArr[1], 2, Float.valueOf(f)));
        }
        this.v = false;
        c(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int e() {
        return this.u;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int f() {
        return this.t;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final boolean g() {
        return this.v;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final boolean h() {
        return (this.s == null || this.z || this.e != com.fyber.inneractive.sdk.player.enums.b.Playing) ? false : true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void i() {
        com.fyber.inneractive.sdk.player.enums.b bVar;
        com.fyber.inneractive.sdk.player.enums.b bVar2 = this.e;
        if (bVar2 == com.fyber.inneractive.sdk.player.enums.b.Idle || bVar2 == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar2 == (bVar = com.fyber.inneractive.sdk.player.enums.b.Paused) || bVar2 == com.fyber.inneractive.sdk.player.enums.b.Prepared) {
            IAlog.a("%s paused called when player is in mState: %s ignoring", IAlog.a(this), bVar2);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar != null && !this.z) {
            gVar.a(false);
        }
        k();
        a(bVar);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void j() {
        IAlog.a("%sstart called", IAlog.a(this));
        if (h()) {
            return;
        }
        a(com.fyber.inneractive.sdk.player.enums.b.Start_in_progress);
        this.s.a(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final int b() {
        long jA;
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar == null || this.z) {
            return 0;
        }
        if (!gVar.m.c() && gVar.k <= 0) {
            gVar.m.a(gVar.q.f1391a, gVar.g, false);
            jA = com.fyber.inneractive.sdk.player.exoplayer2.b.a(gVar.q.c) + com.fyber.inneractive.sdk.player.exoplayer2.b.a(gVar.g.e);
        } else {
            jA = gVar.s;
        }
        return (int) jA;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(int i, boolean z) {
        IAlog.a("%sseekTo called with %d playAfterSeek = %s", IAlog.a(this), Integer.valueOf(i), Boolean.valueOf(z));
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar == null || this.z) {
            return;
        }
        gVar.a(z);
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar2 = this.s;
        gVar2.a(gVar2.a(), i);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final String d() {
        return this.A ? "exo_c" : "exo";
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(Surface surface) {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar;
        IAlog.a("%ssetSurface called with %s", IAlog.a(this), surface);
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr = this.w;
        if (aVarArr == null || (gVar = this.s) == null || this.z) {
            return;
        }
        gVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.e(aVarArr[0], 1, surface));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.q
    public final void a(boolean z) {
        if (this.s != null || this.z) {
            return;
        }
        this.D = z;
        IAlog.a("%sMediaPlayerController: creating media player", IAlog.a(this));
        b0 b0Var = this.y;
        if (b0Var != null) {
            b0Var.f1237a.clear();
        }
        this.y = new b0(this);
        this.x = new Handler(Looper.getMainLooper());
        com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.a[z ? 2 : 1];
        this.w = aVarArr;
        aVarArr[0] = new MediaCodecVideoRenderer(this.x, this.y);
        if (z) {
            this.w[1] = new MediaCodecAudioRenderer();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = new com.fyber.inneractive.sdk.player.exoplayer2.g(this.w, new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d(), new com.fyber.inneractive.sdk.player.exoplayer2.c());
        this.s = gVar;
        gVar.e.add(this.y);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5  */
    @Override // com.fyber.inneractive.sdk.player.controller.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r13, int r14) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.f.a(java.lang.String, int):void");
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.s;
        if (gVar == null || uVar == null) {
            return;
        }
        if (!gVar.m.c() || gVar.n != null) {
            gVar.m = com.fyber.inneractive.sdk.player.exoplayer2.x.f1497a;
            gVar.n = null;
            Iterator it = gVar.e.iterator();
            while (it.hasNext()) {
                ((b0) it.next()).getClass();
            }
        }
        if (gVar.h) {
            gVar.h = false;
            int i = com.fyber.inneractive.sdk.player.exoplayer2.source.z.d;
            gVar.o = gVar.b;
            ((com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g) gVar.f1389a).getClass();
            Iterator it2 = gVar.e.iterator();
            while (it2.hasNext()) {
                ((b0) it2.next()).getClass();
            }
        }
        gVar.l++;
        gVar.d.f.obtainMessage(0, 1, 0, uVar).sendToTarget();
        a(com.fyber.inneractive.sdk.player.enums.b.Preparing);
    }
}
