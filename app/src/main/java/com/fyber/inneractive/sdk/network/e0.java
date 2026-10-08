package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends d0 {
    public static final String e = IAlog.a(e0.class);
    public final com.fyber.inneractive.sdk.player.cache.g d;

    public e0(Context context, com.fyber.inneractive.sdk.cache.a aVar, com.fyber.inneractive.sdk.player.cache.g gVar) {
        super(context, aVar);
        this.d = gVar;
    }

    @Override // com.fyber.inneractive.sdk.network.d0
    public final com.fyber.inneractive.sdk.cache.m a() {
        try {
            if (this.d != null && this.b.d()) {
                com.fyber.inneractive.sdk.player.cache.g gVar = this.d;
                String strC = this.b.c();
                gVar.getClass();
                try {
                } catch (Exception e2) {
                    IAlog.f("%s: failure on filePath: %s", IAlog.a(com.fyber.inneractive.sdk.player.cache.g.class), e2);
                }
                if (gVar.i == null) {
                    throw new IllegalStateException("cache is closed");
                }
                if (!com.fyber.inneractive.sdk.player.cache.g.p.matcher(strC).matches()) {
                    throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + strC + "\"");
                }
                com.fyber.inneractive.sdk.player.cache.e eVar = (com.fyber.inneractive.sdk.player.cache.e) gVar.j.get(strC);
                File fileA = eVar == null ? null : eVar.a(0);
                String absolutePath = (fileA == null || !fileA.exists()) ? null : fileA.getAbsolutePath();
                Uri uri = (Uri) this.b.a(absolutePath);
                if (uri == null) {
                    new c0();
                    return new com.fyber.inneractive.sdk.cache.m();
                }
                IAlog.a("Get cached file: %s", absolutePath);
                if (this.c == null) {
                    this.c = this.f1195a.getSharedPreferences("IAConfigurationPreferences", 0);
                }
                return new com.fyber.inneractive.sdk.cache.m(uri, this.c.getString(this.b.b(), null));
            }
            new c0();
            return new com.fyber.inneractive.sdk.cache.m();
        } catch (Exception unused) {
            b();
            return new com.fyber.inneractive.sdk.cache.m();
        }
    }

    @Override // com.fyber.inneractive.sdk.network.d0
    public final boolean a(String str, String str2) {
        com.fyber.inneractive.sdk.player.cache.g gVar;
        try {
            byte[] bArrDecode = Base64.decode(str2, 0);
            if (bArrDecode != null && (gVar = this.d) != null) {
                com.fyber.inneractive.sdk.player.cache.d dVarA = gVar.a(str);
                if (dVarA == null) {
                    IAlog.f("%s: Error getting editor", e);
                    return false;
                }
                dVarA.a(bArrDecode);
                dVarA.a();
                return true;
            }
            IAlog.f("%s: Invalid content", e);
            return false;
        } catch (IOException | IllegalArgumentException e2) {
            IAlog.f("%s: Error writing cache: ", e, e2);
            return false;
        }
    }
}
