package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static r0 a(String str) {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        HashMap map = iAConfigManager.b;
        if (map != null && map.containsKey(str)) {
            return (r0) iAConfigManager.b.get(str);
        }
        IAlog.c("Requested unit config doesn't exists - %s", str);
        return null;
    }
}
