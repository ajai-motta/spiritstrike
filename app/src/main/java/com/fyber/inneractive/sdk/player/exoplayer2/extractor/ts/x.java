package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1382a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.r[] b;

    public x(List list) {
        this.f1382a = list;
        this.b = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.r[list.size()];
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        for (int i = 0; i < this.b.length; i++) {
            e0Var.a();
            e0Var.b();
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(e0Var.d, 3);
            com.fyber.inneractive.sdk.player.exoplayer2.o oVar = (com.fyber.inneractive.sdk.player.exoplayer2.o) this.f1382a.get(i);
            String str = oVar.f;
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            String str2 = oVar.f1404a;
            if (str2 == null) {
                e0Var.b();
                str2 = e0Var.e;
            }
            gVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(str2, str, oVar.x, oVar.y, oVar.z, null, Long.MAX_VALUE, Collections.emptyList()));
            this.b[i] = gVarA;
        }
    }
}
