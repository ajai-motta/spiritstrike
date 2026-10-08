package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f1192a = null;

    public static void a(Context context, String str, String str2, com.fyber.inneractive.sdk.flow.x xVar) {
        int i;
        if (context == null || str == null || xVar.b() == null) {
            IAlog.a("Invalid report request parameters!", new Object[0]);
            return;
        }
        b0 b0Var = a0.f1191a;
        if (b0Var.f1192a == null) {
            b0Var.f1192a = context.getSharedPreferences("AutoWebActionPrefs", 0);
        }
        IAlog.e("IAautoWebActionReporter: reporting action: %s", str);
        IAlog.e("IAautoWebActionReporter: url: %s", str2);
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (!iAConfigManager.i.c) {
            IAlog.a("IAautoWebActionReporter: Report of Non user web actions disabled!", new Object[0]);
            return;
        }
        t tVar = t.MRAID_AUTO_ACTION_DETECTED;
        InneractiveAdRequest inneractiveAdRequest = xVar.f1126a;
        com.fyber.inneractive.sdk.response.e eVarB = xVar.b();
        JSONArray jSONArrayB = xVar.c.b();
        w wVar = new w(eVarB);
        wVar.b = tVar;
        wVar.f1220a = inneractiveAdRequest;
        wVar.d = jSONArrayB;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", NativeProtocol.WEB_DIALOG_ACTION, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject.put("url", str2);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "url", str2);
            }
        }
        long j = b0Var.f1192a.getLong("lastReportTS", 0L);
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(timeZone);
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTimeInMillis(j);
        if (j <= 0 || calendar.get(6) != calendar2.get(6)) {
            i = 0;
        } else {
            IAlog.e("IAautoWebActionReporter: encountered same date", new Object[0]);
            i = b0Var.f1192a.getInt("numReportsToday", 0);
        }
        int i2 = iAConfigManager.i.d;
        int i3 = i + 1;
        IAlog.e("IAautoWebActionReporter: day counter: %d max: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        if (i < i2) {
            IAlog.e("IAautoWebActionReporter: adding ad data", new Object[0]);
            wVar.g = true;
        } else {
            IAlog.e("IAautoWebActionReporter: not adding ad data", new Object[0]);
        }
        Integer numValueOf = Integer.valueOf(i3);
        try {
            jSONObject.put("daily_count", numValueOf);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "daily_count", numValueOf);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
        SharedPreferences.Editor editorEdit = b0Var.f1192a.edit();
        editorEdit.putLong("lastReportTS", calendar.getTimeInMillis());
        editorEdit.putInt("numReportsToday", i3);
        editorEdit.apply();
    }
}
