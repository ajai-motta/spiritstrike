package com.fyber.inneractive.sdk.network;

import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class o1 extends l {
    public final Response g;

    public o1(l lVar, Response response) {
        this.g = response;
        this.d = lVar.d;
        this.c = lVar.c;
        this.e = lVar.e;
        this.f1205a = lVar.f1205a;
    }

    @Override // com.fyber.inneractive.sdk.network.l
    public final void a() {
        super.a();
        Response response = this.g;
        if (response != null) {
            response.close();
        }
    }
}
