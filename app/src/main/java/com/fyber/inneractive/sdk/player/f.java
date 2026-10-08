package com.fyber.inneractive.sdk.player;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.model.vast.x;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f implements com.fyber.inneractive.sdk.player.controller.p, com.fyber.inneractive.sdk.player.controller.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.controller.q f1498a;
    public t0 b;
    public InneractiveAdRequest c;
    public com.fyber.inneractive.sdk.measurement.e d;
    public com.fyber.inneractive.sdk.measurement.f e;
    public q l;
    public int m;
    public com.fyber.inneractive.sdk.model.vast.r n;
    public p f = null;
    public boolean g = true;
    public boolean h = false;
    public volatile boolean i = false;
    public boolean j = false;
    public int k = 0;
    public final c o = new c(this);

    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public f(android.content.Context r5, com.fyber.inneractive.sdk.config.global.r r6) {
        /*
            r4 = this;
            r4.<init>()
            r0 = 0
            r4.f = r0
            r1 = 1
            r4.g = r1
            r1 = 0
            r4.h = r1
            r4.i = r1
            r4.j = r1
            r4.k = r1
            com.fyber.inneractive.sdk.player.c r2 = new com.fyber.inneractive.sdk.player.c
            r2.<init>(r4)
            r4.o = r2
            if (r6 == 0) goto L33
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.u> r2 = com.fyber.inneractive.sdk.config.global.features.u.class
            com.fyber.inneractive.sdk.config.global.features.h r2 = r6.a(r2)     // Catch: java.lang.Throwable -> L31
            com.fyber.inneractive.sdk.config.global.features.u r2 = (com.fyber.inneractive.sdk.config.global.features.u) r2     // Catch: java.lang.Throwable -> L31
            java.lang.String r3 = "use_fmp_cache_mechanism"
            java.lang.Boolean r2 = r2.c(r3)     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto L33
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L31
            goto L34
        L31:
            r6 = move-exception
            goto L3b
        L33:
            r2 = r1
        L34:
            com.fyber.inneractive.sdk.player.controller.f r3 = new com.fyber.inneractive.sdk.player.controller.f     // Catch: java.lang.Throwable -> L31
            r3.<init>(r5, r2, r6)     // Catch: java.lang.Throwable -> L31
            r0 = r3
            goto L4a
        L3b:
            int r2 = com.fyber.inneractive.sdk.util.IAlog.f1642a
            r3 = 3
            if (r2 > r3) goto L4a
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Failed creating exo player"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
            r6.printStackTrace()
        L4a:
            if (r0 != 0) goto L51
            com.fyber.inneractive.sdk.player.controller.a r0 = new com.fyber.inneractive.sdk.player.controller.a
            r0.<init>(r5)
        L51:
            r4.f1498a = r0
            java.util.concurrent.CopyOnWriteArrayList r5 = r0.b
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto L60
            java.util.concurrent.CopyOnWriteArrayList r5 = r0.b
            r5.add(r4)
        L60:
            com.fyber.inneractive.sdk.player.controller.q r5 = r4.f1498a
            java.util.concurrent.CopyOnWriteArrayList r6 = r5.c
            boolean r6 = r6.contains(r4)
            if (r6 != 0) goto L6f
            java.util.concurrent.CopyOnWriteArrayList r5 = r5.c
            r5.add(r4)
        L6f:
            com.fyber.inneractive.sdk.player.controller.q r5 = r4.f1498a
            com.fyber.inneractive.sdk.player.c r6 = r4.o
            r5.f = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.f.<init>(android.content.Context, com.fyber.inneractive.sdk.config.global.r):void");
    }

    public abstract void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject);

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
        IAlog.a("IMediaPlayerFlowManager: onPlayerError called with: %s", oVar.getMessage());
        a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, oVar), new JSONObject());
        if (this.h) {
            IAlog.a("IMediaPlayerFlowManager: onPlayerError video was prepared. This is a critical error. Aborting!", new Object[0]);
            a(new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, oVar), new JSONObject());
        }
    }

    public abstract void a(com.fyber.inneractive.sdk.response.i iVar, VideoClickOrigin videoClickOrigin, x... xVarArr);

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void c(boolean z) {
        try {
            t0 t0Var = this.b;
            com.fyber.inneractive.sdk.response.g gVar = t0Var != null ? (com.fyber.inneractive.sdk.response.g) t0Var.b : null;
            u uVar = u.VAST_MEDIA_LOAD_RETRY_ATTEMPTED;
            InneractiveAdRequest inneractiveAdRequest = this.c;
            t0 t0Var2 = this.b;
            JSONArray jSONArrayB = t0Var2 == null ? null : t0Var2.c.b();
            w wVar = new w(gVar);
            wVar.c = uVar;
            wVar.f1220a = inneractiveAdRequest;
            wVar.d = jSONArrayB;
            if (this.n != null && gVar != null) {
                wVar.f.put(new com.fyber.inneractive.sdk.network.x().a(String.valueOf(z), "waudio").a(this.n.g, "url").a(this.n.e, "bitrate").a(TextUtils.isEmpty(this.n.d) ? "na" : this.n.d, "mime").a(this.n.f1171a, "delivery").a(Integer.valueOf(this.k), "media_file_index").a(this.f1498a.d(), "player").f1221a);
            }
            wVar.a((String) null);
        } catch (Exception unused) {
        }
    }

    public static boolean a(int i, int i2, s0 s0Var) {
        if (i2 == 1 || InneractiveAdManager.isCurrentUserAChild()) {
            return true;
        }
        if (i <= 15999) {
            return false;
        }
        com.fyber.inneractive.sdk.config.t0 t0Var = s0Var != null ? ((r0) s0Var).f : null;
        return (t0Var == null || t0Var.h == Skip.DEFAULT || t0Var.j == UnitDisplayType.REWARDED) ? false : true;
    }

    public static int a(f fVar) {
        com.fyber.inneractive.sdk.response.e eVar;
        t0 t0Var = fVar.b;
        if (t0Var == null || (eVar = t0Var.b) == null) {
            return -1;
        }
        return ((com.fyber.inneractive.sdk.response.g) eVar).y;
    }

    public final void a() {
        com.fyber.inneractive.sdk.measurement.f fVar = this.e;
        if (fVar != null) {
            if (fVar.f1147a != null) {
                IAlog.a("%s destroy", "OMVideo");
                try {
                    fVar.f1147a.finish();
                } catch (Throwable th) {
                    fVar.a(th);
                }
            }
            fVar.b = null;
            fVar.f1147a = null;
            fVar.c = null;
        }
    }

    public static boolean a(com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.ignite.m mVar) {
        Boolean boolC;
        mVar.getClass();
        return mVar == com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP && IAConfigManager.O.E.n() && rVar != null && rVar.a(com.fyber.inneractive.sdk.config.global.features.n.class) != null && ((boolC = ((com.fyber.inneractive.sdk.config.global.features.n) rVar.a(com.fyber.inneractive.sdk.config.global.features.n.class)).c("enable_app_info_button")) == null || boolC.booleanValue());
    }
}
