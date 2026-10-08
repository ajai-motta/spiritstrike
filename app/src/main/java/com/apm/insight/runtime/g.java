package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.ICommonParams;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f251a = null;
    private int b = -1;

    public static com.apm.insight.nativecrash.b a(Context context) {
        return new com.apm.insight.nativecrash.b(context, new ICommonParams() { // from class: com.apm.insight.runtime.g.1
            @Override // com.apm.insight.ICommonParams
            public final String getDeviceId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final List<String> getPatchInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Integer> getPluginInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final String getSessionId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final long getUserId() {
                return 0L;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Object> getCommonParams() {
                return new HashMap();
            }
        });
    }

    public final void a(String str) {
        this.f251a = str;
        o.a().a(str);
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.f251a) && !AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.f251a)) {
            return this.f251a;
        }
        String strD = com.apm.insight.e.a().d();
        this.f251a = strD;
        if (TextUtils.isEmpty(strD) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.f251a)) {
            String strB = o.a().b();
            this.f251a = strB;
            return strB;
        }
        return this.f251a;
    }

    public final boolean b() {
        return this.f251a != null;
    }
}
