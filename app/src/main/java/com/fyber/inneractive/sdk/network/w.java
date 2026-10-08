package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdRequest f1220a;
    public t b;
    public u c;
    public JSONArray d;
    public final com.fyber.inneractive.sdk.response.e e;
    public final JSONArray f;
    public boolean g;

    public w(t tVar) {
        this((com.fyber.inneractive.sdk.response.e) null);
        this.b = tVar;
        this.f1220a = null;
        this.d = null;
    }

    public final w a(Object... objArr) {
        if (objArr.length > 0) {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < objArr.length - 1; i += 2) {
                String string = objArr[i].toString();
                Object obj = objArr[i + 1];
                try {
                    jSONObject.put(string, obj);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", string, obj);
                }
            }
            this.f.put(jSONObject);
        }
        return this;
    }

    public w(t tVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        this(eVar);
        this.b = tVar;
        this.f1220a = inneractiveAdRequest;
        this.d = null;
    }

    public w(u uVar) {
        this((com.fyber.inneractive.sdk.response.e) null);
        this.c = uVar;
        this.f1220a = null;
        this.d = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r20) {
        /*
            Method dump skipped, instruction units count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.w.a(java.lang.String):void");
    }

    public w(u uVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar) {
        this(eVar);
        this.c = uVar;
        this.f1220a = inneractiveAdRequest;
        this.d = null;
    }

    public w(com.fyber.inneractive.sdk.response.e eVar) {
        this.g = false;
        this.e = eVar;
        this.f = new JSONArray();
    }
}
