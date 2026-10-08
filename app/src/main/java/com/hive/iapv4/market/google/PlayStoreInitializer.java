package com.hive.iapv4.market.google;

import android.content.Context;
import androidx.startup.Initializer;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.HiveActivity;
import com.hive.base.HiveInitializer;
import com.hive.core.HiveCoreInitializer;
import com.hive.iapv4.BaseMarketAPI;
import com.hive.iapv4.IapV4Initializer;
import com.hive.iapv4.IapV4Module;
import com.hive.module.HiveModuleManager;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.iapv4.market.MarketGoogle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayStoreInitializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/hive/iapv4/market/google/PlayStoreInitializer;", "Landroidx/startup/Initializer;", "Lcom/hive/module/interfaces/iapv4/market/MarketGoogle;", "Lcom/hive/iapv4/IapV4Module;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "getMarketModuleInstance", "Lcom/hive/iapv4/BaseMarketAPI;", "getGoogleBillingVersion", "", "getVersionInfo", "", "hive-iapv4-market-google_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlayStoreInitializer implements Initializer<PlayStoreInitializer>, MarketGoogle, IapV4Module {
    @Override // com.hive.module.interfaces.iapv4.market.MarketGoogle, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return MarketGoogle.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public PlayStoreInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HiveModuleManager.INSTANCE.discover(this);
        return this;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.listOf((Object[]) new Class[]{HiveCoreInitializer.class, HiveInitializer.class, IapV4Initializer.class});
    }

    @Override // com.hive.iapv4.IapV4Module
    public BaseMarketAPI getMarketModuleInstance() {
        return PlayStore.INSTANCE;
    }

    @Override // com.hive.module.interfaces.iapv4.market.MarketGoogle
    public String getGoogleBillingVersion(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            Properties properties = new Properties();
            properties.load(context.getClassLoader().getResourceAsStream("billing.properties"));
            String property = properties.getProperty("version");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
            return property;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
            try {
                Result.Companion companion3 = Result.INSTANCE;
                Class.forName(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT);
                return "imported";
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th2));
                return "not imported";
            }
        }
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Iapv4_Google(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            Properties properties = new Properties();
            properties.load(HiveActivity.INSTANCE.getRecentActivity().getClassLoader().getResourceAsStream("billing.properties"));
            map.put(ModuleCheckName.INSTANCE.getBilling_Client(), properties.getProperty("version"));
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }
}
