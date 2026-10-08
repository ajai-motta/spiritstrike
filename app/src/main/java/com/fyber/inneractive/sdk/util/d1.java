package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1649a;

    public d1(Looper looper, com.fyber.inneractive.sdk.network.f fVar) {
        super(looper);
        this.f1649a = new WeakReference(fVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String str;
        String string;
        super.handleMessage(message);
        e1 e1Var = (e1) v.a(this.f1649a);
        if (e1Var != null) {
            com.fyber.inneractive.sdk.network.f fVar = (com.fyber.inneractive.sdk.network.f) e1Var;
            int i = message.what;
            if (i == 12312329 || i == 20150330) {
                if (fVar.f && fVar.f1198a.size() > 0) {
                    while (true) {
                        JSONObject jSONObject = null;
                        string = null;
                        if (fVar.f1198a.size() <= 0) {
                            break;
                        }
                        try {
                            jSONObject = (JSONObject) fVar.f1198a.poll();
                        } catch (Throwable unused) {
                        }
                        if (jSONObject != null) {
                            fVar.b.put(jSONObject);
                        }
                    }
                    if (fVar.b.length() > 0) {
                        JSONArray jSONArray = fVar.b;
                        int i2 = com.fyber.inneractive.sdk.config.k.f959a;
                        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
                        if (TextUtils.isEmpty(property)) {
                            str = "https://" + IAConfigManager.O.i.f;
                        } else if (Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches()) {
                            str = "https://" + property + "/simpleM2M/Event";
                        } else {
                            str = "https://" + property + ".inner-active.mobi/simpleM2M/Event";
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        try {
                            string = jSONArray.toString();
                        } catch (Throwable unused2) {
                        }
                        if (string != null) {
                            IAConfigManager.O.s.a(new com.fyber.inneractive.sdk.network.x0(new com.fyber.inneractive.sdk.network.e(str, jSONArray, jCurrentTimeMillis), str, string));
                        }
                        fVar.b = new JSONArray();
                    }
                }
                d1 d1Var = fVar.d;
                if (d1Var != null) {
                    d1Var.removeMessages(12312329);
                    long j = fVar.e * 1000;
                    d1 d1Var2 = fVar.d;
                    if (d1Var2 != null) {
                        d1Var2.post(new com.fyber.inneractive.sdk.network.c(fVar, 12312329, j));
                    }
                }
            }
        }
    }
}
