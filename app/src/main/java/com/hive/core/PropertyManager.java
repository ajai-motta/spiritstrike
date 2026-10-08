package com.hive.core;

import android.content.Context;
import com.hive.core.Logger;
import com.unity3d.services.core.fid.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropertyManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/hive/core/PropertyManager;", "", "<init>", "()V", "propertyMap", "", "", "Lcom/hive/core/Property;", "cachePropertyMap", "Lcom/hive/core/CacheProperty;", Constants.GET_INSTANCE, "fileName", "context", "Landroid/content/Context;", "getCacheInstance", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PropertyManager {
    public static final PropertyManager INSTANCE = new PropertyManager();
    private static final Map<String, Property> propertyMap = new LinkedHashMap();
    private static final Map<String, CacheProperty> cachePropertyMap = new LinkedHashMap();

    private PropertyManager() {
    }

    public final Property getInstance(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Map<String, Property> map = propertyMap;
        Property property = map.get(fileName);
        if (property == null) {
            if (Configuration.INSTANCE.isRunningInFacebookCloud()) {
                Logger.INSTANCE.coreLog$hive_core_release("PropertyManager.getInstance() isRunningInFacebookCloud true.", Logger.LogType.Debug);
                property = new Property(fileName, null, true, 2, null);
            } else {
                property = new Property(fileName, null, false, 6, null);
            }
            map.put(fileName, property);
        }
        return property;
    }

    public final Property getInstance(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        HiveCoreInitializer.INSTANCE.setInitContext(context.getApplicationContext());
        return getInstance(fileName);
    }

    public final CacheProperty getCacheInstance(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Map<String, CacheProperty> map = cachePropertyMap;
        CacheProperty cacheProperty = map.get(fileName);
        if (cacheProperty == null) {
            if (Configuration.INSTANCE.isRunningInFacebookCloud()) {
                Logger.INSTANCE.coreLog$hive_core_release("PropertyManager.getInstance() isRunningInFacebookCloud true.", Logger.LogType.Debug);
                cacheProperty = new CacheProperty(fileName, true);
            } else {
                cacheProperty = new CacheProperty(fileName, false, 2, null);
            }
            map.put(fileName, cacheProperty);
        }
        return cacheProperty;
    }
}
