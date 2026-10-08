package com.hive.hercules;

import android.content.Context;
import androidx.startup.Initializer;
import com.hive.base.Android;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.Logger;
import com.hive.module.HiveModuleManager;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.HiveHercules;
import com.hive.standalone.HiveLifecycle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HerculesInitializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/hive/hercules/HerculesInitializer;", "Landroidx/startup/Initializer;", "Lcom/hive/module/interfaces/HiveHercules;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "processInitHercules", "", "getVersionInfo", "", "", "hive-hercules_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HerculesInitializer implements Initializer<HerculesInitializer>, HiveHercules {
    @Override // com.hive.module.interfaces.HiveHercules, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveHercules.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public HerculesInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HiveModuleManager.INSTANCE.discover(this);
        HiveLifecycle.registerHiveLifecycleListeners(new HiveLifecycle.HiveLifecycleListener() { // from class: com.hive.hercules.HerculesInitializer.create.1
            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onAgreement() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onAgreement(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onNetworkAvailable(boolean z) {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onNetworkAvailable(this, z);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onProcessUri(String str) {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onProcessUri(this, str);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onReset() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onReset(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSignOut() {
                HiveLifecycle.HiveLifecycleListener.DefaultImpls.onSignOut(this);
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSetupFinished() {
                HerculesInitializer.this.processInitHercules();
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onInitializeFinished() {
                HerculesInitializer.this.processInitHercules();
            }

            @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
            public void onSignIn(HiveLifecycle.HiveAccount hiveAccount) {
                Intrinsics.checkNotNullParameter(hiveAccount, "hiveAccount");
                String vid = hiveAccount.getVid();
                ProviderHercules.INSTANCE.setPlayerId((vid == null || vid.length() == 0) ? hiveAccount.getUid() : hiveAccount.getVid());
            }
        });
        return this;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.listOf(HiveCoreInitializer.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processInitHercules() {
        Object objM7415constructorimpl;
        if (Configuration.INSTANCE.getUseHercules()) {
            Logger.INSTANCE.w("[Hercules] Hercules is enabled.");
            try {
                Result.Companion companion = Result.INSTANCE;
                System.loadLibrary("Hercules");
                ProviderHercules.INSTANCE.initialize();
                ProviderHercules.INSTANCE.setDeviceId(HiveLifecycle.INSTANCE.getAccount().getDid());
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                Logger.INSTANCE.e("[Hercules] Hercules native library(so) does not found. " + thM7418exceptionOrNullimpl);
                Android.INSTANCE.finish();
            }
            Result.m7414boximpl(objM7415constructorimpl);
            return;
        }
        Logger.INSTANCE.w("[Hercules] Hercules is disabled.");
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Hercules(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            map.put(ModuleCheckName.INSTANCE.getHercules_Security(), "20250219");
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }
}
