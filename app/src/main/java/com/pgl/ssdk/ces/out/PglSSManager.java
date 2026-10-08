package com.pgl.ssdk.ces.out;

import android.content.Context;
import android.view.MotionEvent;
import com.pgl.ssdk.ces.b;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class PglSSManager {
    public static final int INIT_STATUS_FAIL_CONTEXT_NULL = 4;
    public static final int INIT_STATUS_FAIL_SO_LOADFAIL = 3;
    public static final int INIT_STATUS_FAIL_SO_MISSING = 2;
    public static final int INIT_STATUS_OK = 0;
    public static final int INIT_STATUS_UNINITIALIZE = 1;
    public static final String REPORT_SCENE_ADSHOW = "AdShow";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile PglSSManager f3080a;
    private final b b;
    private volatile int c = 0;
    private volatile PglSSCallBack d;

    private PglSSManager(Context context, PglSSConfig pglSSConfig) {
        this.b = b.a(context, pglSSConfig.getAppId(), pglSSConfig.getOVRegionType(), pglSSConfig.getCollectMode(), pglSSConfig.getAdSdkVersion());
    }

    public static int getInitStatus() {
        return b.d();
    }

    public static PglSSManager getInstance() {
        return f3080a;
    }

    public static String getLoadError() {
        if (b.f() != null) {
            return b.f().b;
        }
        return null;
    }

    @DungeonFlag
    public static PglSSManager init(Context context, PglSSConfig pglSSConfig, String str, String str2, String str3, String str4) {
        if (context == null && pglSSConfig == null) {
            return null;
        }
        if (f3080a == null) {
            synchronized (PglSSManager.class) {
                if (f3080a == null) {
                    f3080a = new PglSSManager(context, pglSSConfig);
                    if (b.d() == 0) {
                        f3080a.d = pglSSConfig.getCallBack();
                        f3080a.b.a(pglSSConfig.getCustomInfo());
                        f3080a.b.a(str, str3, str2, str4);
                    }
                }
            }
        }
        return f3080a;
    }

    public void checkEventVirtual(MotionEvent motionEvent) {
        if (b.d() == 0) {
            this.b.a(motionEvent);
        }
    }

    public long getECForBidding() {
        return 0L;
    }

    public Map<String, String> getFeatureHash(String str, byte[] bArr) {
        if (b.d() == 0) {
            return this.b.a(str, bArr);
        }
        return null;
    }

    public PglSSCallBack getPglCallBack() {
        return this.d;
    }

    public String getSofChara() {
        return null;
    }

    public String getToken() {
        if (b.d() == 0) {
            return this.b.g();
        }
        return null;
    }

    public void reportNow(String str, Map<String, Object> map) {
        if (b.d() == 0) {
            this.b.a(str);
            int i = this.c;
            b bVar = this.b;
            if (i % bVar.p == 0) {
                bVar.a(str, map);
            }
            this.c++;
        }
    }

    public void setCustomInfo(Map<String, Object> map) {
        if (b.d() == 0) {
            this.b.a(map);
        }
    }

    public void setDeviceId(String str) {
        if (b.d() == 0) {
            this.b.c(str);
        }
    }

    public void setGaid(String str) {
        if (b.d() == 0) {
            this.b.d(str);
        }
    }
}
