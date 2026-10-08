package com.fyber.inneractive.sdk.player.controller;

import android.media.AudioManager;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends z implements com.fyber.inneractive.sdk.flow.storepromo.loader.b {
    public boolean A;
    public final boolean B;
    public final boolean z;

    public g(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.s sVar, s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, boolean z2, String str) {
        com.fyber.inneractive.sdk.flow.storepromo.b bVar;
        super(fVar, sVar, s0Var, rVar, z, str);
        this.z = false;
        this.A = false;
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1259a;
        if (fVar2 != null && (bVar = ((com.fyber.inneractive.sdk.player.n) fVar2).v) != null) {
            bVar.e = this;
        }
        this.z = false;
        this.B = z2;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final boolean A() {
        return !this.z;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void E() {
        q qVar;
        super.E();
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || (qVar = fVar.f1498a) == null || qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed || !this.z) {
            return;
        }
        this.d.m();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a() {
        if (!this.h) {
            f();
            return;
        }
        if (this.d.b()) {
            return;
        }
        this.d.a(false);
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        E();
        D();
        this.k = false;
        this.h = true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.b
    public final void b(boolean z) {
        super.b(z);
        if (this.z) {
            this.d.m();
            this.d.g(false);
            this.f = 0;
        }
        C();
        this.d.e(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void f() {
        int ringerMode;
        int streamVolume;
        super.f();
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null && fVar.f1498a != null && !this.A) {
            try {
                AudioManager audioManager = (AudioManager) this.d.getContext().getSystemService("audio");
                ringerMode = audioManager.getRingerMode();
                try {
                    streamVolume = audioManager.getStreamVolume(2);
                } catch (Throwable unused) {
                    streamVolume = 0;
                }
            } catch (Throwable unused2) {
                ringerMode = 0;
            }
            if ((!this.z && ((r0) this.b).f.d.booleanValue()) || this.B || p()) {
                f(false);
            } else if (streamVolume > 0 && ringerMode == 2) {
                IAlog.a("%s setting default volume. unmuting player", IAlog.a(this));
                i(false);
            }
            this.d.setMuteButtonState(p());
            this.A = true;
        }
        h(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int i() {
        return IAConfigManager.O.u.b.a("VideoFullscreenBufferingTimeout", 12, 1) * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    @Override // com.fyber.inneractive.sdk.player.controller.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int o() {
        /*
            r10 = this;
            com.fyber.inneractive.sdk.config.global.r r0 = r10.c
            if (r0 == 0) goto L2b
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.c> r1 = com.fyber.inneractive.sdk.config.global.features.c.class
            com.fyber.inneractive.sdk.config.global.features.h r0 = r0.a(r1)
            com.fyber.inneractive.sdk.config.global.features.c r0 = (com.fyber.inneractive.sdk.config.global.features.c) r0
            r0.getClass()
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.HashMap r0 = r0.c
            java.util.Collection r0 = r0.values()
            r1.<init>(r0)
            int r0 = r1.size()
            if (r0 <= 0) goto L2b
            com.fyber.inneractive.sdk.config.global.r r0 = r10.c
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.c> r1 = com.fyber.inneractive.sdk.config.global.features.c.class
            com.fyber.inneractive.sdk.config.global.features.h r0 = r0.a(r1)
            com.fyber.inneractive.sdk.config.global.features.c r0 = (com.fyber.inneractive.sdk.config.global.features.c) r0
            goto L2c
        L2b:
            r0 = 0
        L2c:
            r1 = 8
            r2 = 5
            r3 = -1
            if (r0 == 0) goto L47
            java.lang.String r4 = "skip_time_sec"
            java.lang.Integer r0 = r0.a(r4)
            if (r0 == 0) goto L3f
            int r0 = r0.intValue()
            goto L40
        L3f:
            r0 = r2
        L40:
            if (r0 < 0) goto L45
            if (r0 > r1) goto L45
            goto L48
        L45:
            r0 = r2
            goto L48
        L47:
            r0 = r3
        L48:
            com.fyber.inneractive.sdk.config.IAConfigManager r4 = com.fyber.inneractive.sdk.config.IAConfigManager.O
            com.fyber.inneractive.sdk.config.s r4 = r4.u
            com.fyber.inneractive.sdk.config.o r4 = r4.b
            com.fyber.inneractive.sdk.config.s0 r5 = r10.b
            com.fyber.inneractive.sdk.config.enums.Skip r6 = r10.x
            boolean r7 = com.fyber.inneractive.sdk.external.InneractiveAdManager.isCurrentUserAChild()
            java.lang.String r8 = "vast_configuration"
            com.fyber.inneractive.sdk.config.l r4 = r4.a(r8)
            java.lang.String r8 = "skip_d"
            r4.getClass()
            java.util.HashMap r9 = r4.f961a     // Catch: java.lang.Exception -> L77
            boolean r9 = r9.containsKey(r8)     // Catch: java.lang.Exception -> L77
            if (r9 == 0) goto L77
            java.util.HashMap r4 = r4.f961a     // Catch: java.lang.Exception -> L77
            java.lang.Object r4 = r4.get(r8)     // Catch: java.lang.Exception -> L77
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L77
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> L77
            goto L78
        L77:
            r4 = r3
        L78:
            int r4 = java.lang.Math.max(r4, r3)
            if (r6 != 0) goto L88
            if (r5 == 0) goto L88
            com.fyber.inneractive.sdk.config.r0 r5 = (com.fyber.inneractive.sdk.config.r0) r5
            com.fyber.inneractive.sdk.config.t0 r5 = r5.f
            if (r5 == 0) goto L88
            com.fyber.inneractive.sdk.config.enums.Skip r6 = r5.h
        L88:
            if (r7 == 0) goto Laa
            if (r0 <= r3) goto L90
            if (r0 > r1) goto L90
            r2 = r0
            goto Lc0
        L90:
            if (r4 <= r3) goto L95
            if (r4 > r1) goto L95
            goto Lae
        L95:
            java.lang.Integer r0 = r6.value()
            int r0 = r0.intValue()
            if (r0 <= r3) goto Lc0
            if (r0 > r1) goto Lc0
            java.lang.Integer r0 = r6.value()
            int r2 = r0.intValue()
            goto Lc0
        Laa:
            if (r4 <= r3) goto Lb0
            if (r4 > r2) goto Lb0
        Lae:
            r2 = r4
            goto Lc0
        Lb0:
            com.fyber.inneractive.sdk.config.enums.Skip r0 = com.fyber.inneractive.sdk.config.enums.Skip.DEFAULT
            if (r6 != r0) goto Lb8
            r2 = 99999(0x1869f, float:1.40128E-40)
            goto Lc0
        Lb8:
            java.lang.Integer r0 = r6.value()
            int r2 = r0.intValue()
        Lc0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.g.o():int");
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void r() {
        this.r = true;
        IAlog.a("%s onBufferingTimeout reached. Skipping to end card", IAlog.a(this));
        if (B()) {
            g(false);
        } else {
            d(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void t() {
        g0 g0Var = this.g;
        if (g0Var != null) {
            g0Var.j();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void v() {
        this.d.g(true);
        C();
        h();
        f();
        h(true);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void x() {
        super.x();
        if (this.z) {
            this.d.m();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a(boolean z) {
        e(z);
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void b(g1 g1Var) {
        com.fyber.inneractive.sdk.player.ui.s sVar;
        TapAction tapAction = ((r0) this.b).f.i;
        if (tapAction == TapAction.CTR) {
            a(false, VideoClickOrigin.VIDEO, g1Var);
            return;
        }
        if (tapAction != TapAction.FULLSCREEN && tapAction != TapAction.DO_NOTHING) {
            IAlog.a("% sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a(this), tapAction);
            return;
        }
        if (((com.fyber.inneractive.sdk.config.global.features.u) this.c.a(com.fyber.inneractive.sdk.config.global.features.u.class)).c().equals(com.fyber.inneractive.sdk.config.global.features.t.OPEN) || ((this.t != com.fyber.inneractive.sdk.ignite.m.NONE && IAConfigManager.O.E.n()) || ((sVar = this.d) != null && sVar.a()))) {
            a(false, VideoClickOrigin.VIDEO, g1Var);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.loader.b
    public final void a(g1 g1Var) {
        a(11, g1Var);
    }
}
