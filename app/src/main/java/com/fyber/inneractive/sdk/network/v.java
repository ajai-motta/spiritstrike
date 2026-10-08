package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f1219a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ String g;
    public final /* synthetic */ w h;

    public v(w wVar, y yVar, String str, String str2, String str3, String str4, Integer num, String str5) {
        this.h = wVar;
        this.f1219a = yVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = num;
        this.g = str5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strA;
        HashMap map;
        com.fyber.inneractive.sdk.response.e eVar;
        w wVar = this.h;
        t tVar = wVar.b;
        if (tVar != null) {
            this.f1219a.a(Integer.valueOf(tVar.val), NotificationCompat.CATEGORY_ERROR);
            this.h.b.getClass();
            strA = r1.ERROR_TABLE.a();
            IAlog.a("Event dispatcher - dispatching error: %s", this.h.b);
            IAlog.d("%s %s", "DISPATCHED_SDK_ERROR", Integer.valueOf(this.h.b.val));
        } else {
            u uVar = wVar.c;
            if (uVar != null) {
                this.f1219a.a(Integer.valueOf(uVar.val), "event");
                this.h.c.getClass();
                strA = r1.EVENT_TABLE.a();
                IAlog.a("Event dispatcher - dispatching event: %s", this.h.c);
                IAlog.d("%s %s", "DISPATCHED_SDK_EVENT", Integer.valueOf(this.h.c.val));
            } else {
                strA = null;
            }
        }
        y yVar = this.f1219a;
        StringBuilder sb = new StringBuilder();
        sb.append(strA);
        w wVar2 = this.h;
        t tVar2 = wVar2.b;
        sb.append(tVar2 != null ? String.valueOf(tVar2.val) : String.valueOf(wVar2.c.val));
        yVar.a(sb.toString(), "table");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        this.f1219a.a(Long.valueOf(calendar.getTimeInMillis()), "date_created");
        if (!IAConfigManager.d()) {
            this.f1219a.a(this.b, "contentid");
            this.f1219a.a(this.c, "fairbidv");
            if (!TextUtils.isEmpty(this.d)) {
                this.f1219a.a(this.d, "placement_type");
            }
            if (!TextUtils.isEmpty(this.e)) {
                this.f1219a.a(this.e, "spot_id");
            }
            if (!InneractiveAdManager.isCurrentUserAChild()) {
                String strI = com.fyber.inneractive.sdk.util.k.i();
                if (!TextUtils.isEmpty(strI)) {
                    this.f1219a.a(strI, "ciso");
                }
            }
            this.f1219a.a(this.f, AppEventsConstants.EVENT_PARAM_AD_TYPE);
            if (this.h.g && !TextUtils.isEmpty(this.g)) {
                this.f1219a.c = this.g;
            }
            this.f1219a.a(com.fyber.inneractive.sdk.util.z0.a().b(), "n");
            try {
                this.f1219a.a(w.h.format(calendar.getTime()), "day");
            } catch (Throwable unused) {
            }
            this.f1219a.a(Integer.valueOf(calendar.get(11)), "hour");
            JSONArray jSONArray = this.h.d;
            if (jSONArray != null && jSONArray.length() > 0) {
                this.f1219a.a(this.h.d, "experiments");
            }
            com.fyber.inneractive.sdk.response.e eVar2 = this.h.e;
            if (eVar2 != null && eVar2.D) {
                this.f1219a.a("1", "sdk_bidding");
            }
            if (InneractiveAdManager.isCurrentUserAChild()) {
                this.f1219a.a("1", "child_mode");
            }
            IAConfigManager iAConfigManager = IAConfigManager.O;
            this.f1219a.a(iAConfigManager.E.n() && (eVar = this.h.e) != null && eVar.H != com.fyber.inneractive.sdk.ignite.m.NONE ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, "ignite");
            y yVar2 = this.f1219a;
            com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
            yVar2.a(lVar != null ? lVar.f840a.d() : null, "ignitep");
            y yVar3 = this.f1219a;
            com.fyber.inneractive.sdk.ignite.l lVar2 = iAConfigManager.E.p;
            yVar3.a(lVar2 != null ? lVar2.f840a.i() : null, "ignitev");
            JSONArray jSONArrayB = iAConfigManager.M.b();
            if (jSONArrayB != null && jSONArrayB.length() > 0) {
                this.f1219a.a(jSONArrayB, "s_experiments");
            }
            JSONArray jSONArray2 = this.h.f;
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                int i = 0;
                while (true) {
                    if (i >= jSONArray2.length()) {
                        break;
                    }
                    if (jSONArray2.optJSONObject(i).length() >= 1) {
                        this.f1219a.a(this.h.f, "extra");
                        break;
                    }
                    i++;
                }
            }
            com.fyber.inneractive.sdk.response.e eVar3 = this.h.e;
            if (eVar3 != null && eVar3.L) {
                this.f1219a.a("1", "dynamic_controls");
            }
        }
        y yVar4 = this.f1219a;
        if (TextUtils.isEmpty(yVar4.f1222a) || (map = yVar4.b) == null || map.size() == 0) {
            return;
        }
        f fVar = IAConfigManager.O.I;
        fVar.getClass();
        JSONObject jSONObject = new JSONObject();
        HashMap map2 = yVar4.b;
        for (String str : map2.keySet()) {
            Object obj = map2.get(str);
            if (obj != null) {
                try {
                    jSONObject.put(str, obj);
                } catch (JSONException unused2) {
                }
            }
        }
        String strSubstring = yVar4.c;
        if (strSubstring != null) {
            int length = strSubstring.length();
            if (length > 51200) {
                int iIndexOf = strSubstring.indexOf("iawrapper");
                if (iIndexOf == -1) {
                    iIndexOf = 0;
                }
                strSubstring = strSubstring.substring(iIndexOf, 51199);
                IAlog.a("Sdk event dispatcher: message size %d is too long! trimming message to %d Characters", Integer.valueOf(length), 51200);
            }
            try {
                jSONObject.put("ad", strSubstring);
            } catch (JSONException e) {
                IAlog.a("Failed inserting ad body to json", e, new Object[0]);
            }
        }
        if (IAlog.f1642a == 1) {
            try {
                IAlog.d("%s, Event: %s", "SDK_EVENT", jSONObject.toString());
            } catch (Throwable unused3) {
            }
        }
        fVar.f1198a.offer(jSONObject);
        if (fVar.f1198a.size() > 30) {
            com.fyber.inneractive.sdk.util.d1 d1Var = fVar.d;
            if (d1Var != null && d1Var.hasMessages(12312329)) {
                fVar.d.removeMessages(12312329);
            }
            com.fyber.inneractive.sdk.util.d1 d1Var2 = fVar.d;
            if (d1Var2 != null) {
                d1Var2.post(new c(fVar, 12312329, 0L));
            }
        }
    }
}
