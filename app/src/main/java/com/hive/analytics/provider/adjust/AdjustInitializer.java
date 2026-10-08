package com.hive.analytics.provider.adjust;

import android.content.Context;
import androidx.startup.Initializer;
import com.adjust.sdk.Util;
import com.hive.analytics.AnalyticsModule;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.base.HiveInitializer;
import com.hive.core.HiveCoreInitializer;
import com.hive.module.HiveModuleManager;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.analytics.ProviderAdjust;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdjustInitializer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/hive/analytics/provider/adjust/AdjustInitializer;", "Landroidx/startup/Initializer;", "Lcom/hive/module/interfaces/analytics/ProviderAdjust;", "Lcom/hive/analytics/AnalyticsModule;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "getProviderModuleInstance", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter;", "getVersionInfo", "", "", "hive-analytics-provider-adjust_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdjustInitializer implements Initializer<AdjustInitializer>, ProviderAdjust, AnalyticsModule {
    @Override // com.hive.module.interfaces.analytics.ProviderAdjust, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return ProviderAdjust.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public AdjustInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HiveModuleManager.INSTANCE.discover(this);
        AnalyticsProviderAdjust analyticsProviderAdjust = AnalyticsProviderAdjust.INSTANCE;
        return this;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.listOf((Object[]) new Class[]{HiveCoreInitializer.class, HiveInitializer.class});
    }

    @Override // com.hive.analytics.AnalyticsModule
    public AnalyticsProviderAdapter getProviderModuleInstance() {
        return AnalyticsProviderAdjust.INSTANCE;
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Analytics_Adjust(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            map.put(ModuleCheckName.INSTANCE.getAdjust_Sdk(), Util.getSdkVersion());
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }
}
