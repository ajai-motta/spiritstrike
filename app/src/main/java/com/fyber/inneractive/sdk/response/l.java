package com.fyber.inneractive.sdk.response;

import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends b {
    public com.fyber.inneractive.sdk.response.nativead.j e;

    @Override // com.fyber.inneractive.sdk.response.b
    public final void a(String str, r0 r0Var) throws Exception {
        com.fyber.inneractive.sdk.response.nativead.j jVar;
        if (this.f1610a == null || (jVar = this.e) == null) {
            throw new Exception("Missing response ".concat(this.f1610a == null ? "data" : "data native"));
        }
        if (r0Var == null) {
            jVar.i = "ErrorConfigurationMismatch";
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.isNull("native")) {
            this.e.i = "ErrorInvalidJsonResponse";
            throw new com.fyber.inneractive.sdk.response.nativead.a("Missing native ad object", "ErrorInvalidJsonResponse");
        }
        try {
            com.fyber.inneractive.sdk.response.nativead.i iVarA = a(jSONObject.optJSONObject("native"));
            com.fyber.inneractive.sdk.response.nativead.k kVar = this.e.T;
            kVar.N = iVarA;
            if (kVar.d()) {
                a(this.e, r0Var);
            }
        } catch (com.fyber.inneractive.sdk.flow.vast.h e) {
            if (e.getCause() != null) {
                this.e.i = e.getCause().getMessage();
            }
            this.e.j = e.getMessage();
            throw e;
        } catch (com.fyber.inneractive.sdk.response.nativead.a e2) {
            if (e2.getCause() != null) {
                this.e.i = e2.getCause().getMessage();
            }
            this.e.j = e2.getMessage();
            IAlog.f("%s: parsing native ad response: error: %s", "NativeAdResponseParser", e2.getMessage());
            throw e2;
        } catch (Exception e3) {
            this.e.j = e3.getMessage();
            com.fyber.inneractive.sdk.response.nativead.j jVar2 = this.e;
            jVar2.i = "ErrorInvalidNativeOrtbObject";
            jVar2.z = e3;
            IAlog.f("%s: parsing native ad response: error: %s", "NativeAdResponseParser", e3.getMessage());
            if (IAlog.f1642a == 2) {
                e3.printStackTrace();
            }
            throw e3;
        }
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public final boolean b() {
        return false;
    }

    public final void a(com.fyber.inneractive.sdk.response.nativead.j jVar, r0 r0Var) {
        com.fyber.inneractive.sdk.response.nativead.e eVarC = jVar.T.c();
        String str = eVarC != null ? eVarC.f1617a : null;
        if (str != null && !str.isEmpty()) {
            d dVar = new d(false);
            dVar.f1610a = new g();
            dVar.e = this.e;
            dVar.a(str, r0Var);
            return;
        }
        throw new com.fyber.inneractive.sdk.flow.vast.h("Missing vast content", "VastErrorInvalidFile");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.fyber.inneractive.sdk.response.nativead.i a(org.json.JSONObject r15) {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.response.l.a(org.json.JSONObject):com.fyber.inneractive.sdk.response.nativead.i");
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public final e a() {
        com.fyber.inneractive.sdk.response.nativead.j jVar = new com.fyber.inneractive.sdk.response.nativead.j();
        this.f1610a = jVar;
        this.e = jVar;
        return jVar;
    }
}
