package com.hive.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CacheProperty.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/core/CacheProperty;", "Lcom/hive/core/Property;", "fileName", "", "fixedKey", "", "<init>", "(Ljava/lang/String;Z)V", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CacheProperty extends Property {
    public /* synthetic */ CacheProperty(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CacheProperty(String fileName, boolean z) {
        super(fileName, HiveCoreInitializer.INSTANCE.getInitContext().getCacheDir().getPath() + "/hive", z);
        Intrinsics.checkNotNullParameter(fileName, "fileName");
    }
}
