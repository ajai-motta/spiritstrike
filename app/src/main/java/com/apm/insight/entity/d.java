package com.apm.insight.entity;

import android.os.Environment;
import com.apm.insight.e;
import com.apm.insight.l.f;
import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f164a;
    private static JSONObject b;

    public static void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            a();
            JSONObject jSONObject2 = b;
            if (jSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("slardar_filter");
                if (com.apm.insight.a.a(jSONObjectOptJSONObject)) {
                    return;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    try {
                        jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_FILTERS, jSONObjectOptJSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                a.b(jSONObjectOptJSONObject2, jSONObjectOptJSONObject);
            }
        } catch (Throwable unused2) {
        }
    }

    private static void a() {
        if (f164a == null) {
            f164a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + e.g().getPackageName() + "/AutomationTestInfo.json";
        }
        if (b == null) {
            try {
                b = new JSONObject(f.a(f164a, "\n"));
            } catch (IOException unused) {
                b = new JSONObject();
            } catch (JSONException unused2) {
                b = new JSONObject();
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        Object objOpt;
        if (jSONObject == null) {
            return;
        }
        try {
            a();
            JSONObject jSONObject2 = b;
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!"slardar_filter".equals(next) && (objOpt = b.opt(next)) != null) {
                        try {
                            jSONObject.put(next, objOpt);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
