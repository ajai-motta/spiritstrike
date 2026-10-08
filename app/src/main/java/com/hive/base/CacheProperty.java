package com.hive.base;

import android.content.Context;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.PropertyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\n"}, d2 = {"Lcom/hive/base/CacheProperty;", "Lcom/hive/base/Property;", "propertiesFileName", "", "<init>", "(Ljava/lang/String;)V", "loadProperties", "Lcom/hive/core/Property;", "context", "Landroid/content/Context;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CacheProperty extends Property {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheProperty(String propertiesFileName) {
        super(propertiesFileName);
        Intrinsics.checkNotNullParameter(propertiesFileName, "propertiesFileName");
    }

    @Override // com.hive.base.Property
    public com.hive.core.Property loadProperties(Context context) {
        String propertiesFileName;
        if (getIsPrefixFileName()) {
            propertiesFileName = Configuration.INSTANCE.getZone().getValue() + '_' + getPropertiesFileName();
        } else {
            propertiesFileName = getPropertiesFileName();
        }
        if (context != null) {
            HiveCoreInitializer.INSTANCE.setInitContext(context.getApplicationContext());
        }
        return PropertyManager.INSTANCE.getCacheInstance(propertiesFileName);
    }
}
