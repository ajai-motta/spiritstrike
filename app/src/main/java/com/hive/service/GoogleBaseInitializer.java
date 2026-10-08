package com.hive.service;

import android.content.Context;
import androidx.startup.Initializer;
import com.hive.base.HiveInitializer;
import com.hive.core.HiveCoreInitializer;
import com.hive.module.HiveModuleManager;
import com.hive.module.googlebase.HiveModuleGoogleBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GoogleBaseInitializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\t0\bH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/service/GoogleBaseInitializer;", "Landroidx/startup/Initializer;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "hive-service-google-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GoogleBaseInitializer implements Initializer<GoogleBaseInitializer> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public GoogleBaseInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        HiveModuleGoogleBase hiveModuleGoogleBase = new HiveModuleGoogleBase();
        hiveModuleGoogleBase.installProvider(context);
        hiveModuleManager.discover(hiveModuleGoogleBase);
        return this;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.listOf((Object[]) new Class[]{HiveCoreInitializer.class, HiveInitializer.class});
    }
}
