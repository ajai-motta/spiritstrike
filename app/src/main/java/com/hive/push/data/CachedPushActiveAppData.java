package com.hive.push.data;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/hive/push/data/CachedPushActiveAppData;", "", "<init>", "()V", "cachedData", "Landroid/os/Bundle;", "save", "", "data", "getString", "", "key", "clear", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CachedPushActiveAppData {
    public static final CachedPushActiveAppData INSTANCE = new CachedPushActiveAppData();
    private static Bundle cachedData;

    private CachedPushActiveAppData() {
    }

    public final void clear() {
        Bundle bundle = cachedData;
        if (bundle != null) {
            bundle.clear();
        }
        cachedData = null;
    }

    public final String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundle = cachedData;
        if (bundle != null) {
            return bundle.getString(key);
        }
        return null;
    }

    public final void save(Bundle data) {
        Intrinsics.checkNotNullParameter(data, "data");
        cachedData = new Bundle(data);
    }
}
