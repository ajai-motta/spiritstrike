package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.l.c;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f250a;
    private HashMap<String, Long> b;
    private int c;
    private int d;

    public f(Context context) {
        this.b = null;
        this.c = 50;
        this.d = 100;
        this.f250a = context;
        this.b = b();
        this.c = a.a(this.c, "custom_event_settings", "npth_simple_setting", "crash_limit_issue");
        this.d = a.a(this.d, "custom_event_settings", "npth_simple_setting", "crash_limit_all");
    }

    private HashMap<String, Long> b() {
        JSONArray jSONArrayA;
        File fileH = com.apm.insight.l.j.h(this.f250a);
        HashMap<String, Long> map = new HashMap<>();
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        try {
            jSONArrayA = com.apm.insight.l.f.a(fileH.getAbsolutePath());
        } catch (IOException unused) {
        } catch (Throwable th) {
            com.apm.insight.c.a();
            j.a(th, "NPTH_CATCH");
        }
        if (com.apm.insight.a.a(jSONArrayA)) {
            return map;
        }
        Long lDecode = Long.decode(jSONArrayA.optString(0, null));
        if (System.currentTimeMillis() - lDecode.longValue() <= 86400000) {
            map.put("time", lDecode);
            for (int i = 1; i < jSONArrayA.length(); i++) {
                String[] strArrSplit = jSONArrayA.optString(i, "").split(ServerSentEventKt.SPACE);
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], Long.decode(strArrSplit[1]));
                }
            }
            return map;
        }
        File fileG = com.apm.insight.l.j.g(this.f250a);
        fileH.renameTo(new File(fileG, String.valueOf(System.currentTimeMillis())));
        String[] list = fileG.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            new File(fileG, list[0]).delete();
        }
        return map;
    }

    public final void a() throws Throwable {
        HashMap<String, Long> map = this.b;
        Long lRemove = map.remove("time");
        if (lRemove == null) {
            com.apm.insight.c.a();
            j.a(new RuntimeException("err times, no time"), "NPTH_CATCH");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lRemove);
        sb.append('\n');
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(' ');
            sb.append(entry.getValue());
            sb.append('\n');
        }
        try {
            com.apm.insight.l.f.a(com.apm.insight.l.j.h(this.f250a), sb.toString(), false);
        } catch (IOException unused) {
        }
    }

    public final boolean a(String str) {
        if (str == null) {
            str = "default";
        }
        return c.AnonymousClass1.a(this.b, str, 1L).longValue() < ((long) this.c) && c.AnonymousClass1.a(this.b, TtmlNode.COMBINE_ALL, 1L).longValue() < ((long) this.d);
    }
}
