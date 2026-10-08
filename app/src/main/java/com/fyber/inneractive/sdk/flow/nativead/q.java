package com.fyber.inneractive.sdk.flow.nativead;

import androidx.webkit.ProxyConfig;
import com.fyber.inneractive.sdk.config.IAConfigManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1084a;
    public static final String b;

    static {
        String strB = com.fyber.inneractive.sdk.util.o.b("ia_js_load_monitor.txt");
        f1084a = "<html><head>" + strB + "<script src='%s'></script></head><body></body></html>";
        b = "<html><head>" + strB + "%s</head><body></body></html>";
    }

    public static boolean a(String str) {
        return (str == null || str.trim().isEmpty()) ? false : true;
    }

    public static String b(String str) {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (str.startsWith(iAConfigManager.q ? "https" : ProxyConfig.MATCH_HTTP)) {
            return String.format(f1084a, str);
        }
        if (iAConfigManager.q && !str.startsWith("https")) {
            return null;
        }
        if (!str.startsWith("<script")) {
            str = "<script type='text/javascript'>".concat(str);
        }
        if (!str.endsWith("</script>")) {
            str = str.concat("</script>");
        }
        return String.format(b, str);
    }
}
