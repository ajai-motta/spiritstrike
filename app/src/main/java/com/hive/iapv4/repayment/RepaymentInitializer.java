package com.hive.iapv4.repayment;

import android.app.Activity;
import android.content.Context;
import androidx.startup.Initializer;
import com.hive.base.HiveInitializer;
import com.hive.core.HiveCoreInitializer;
import com.hive.iapv4.IapV4Initializer;
import com.hive.module.HiveModuleManager;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.iapv4.Repayment;
import com.hive.standalone.HiveLifecycle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepaymentInitializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lcom/hive/iapv4/repayment/RepaymentInitializer;", "Landroidx/startup/Initializer;", "Lcom/hive/module/interfaces/iapv4/Repayment;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "showRepayment", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "startGameListener", "Lkotlin/Function0;", "getVersionInfo", "", "", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RepaymentInitializer implements Initializer<RepaymentInitializer>, com.hive.module.interfaces.iapv4.Repayment {
    @Override // com.hive.module.interfaces.iapv4.Repayment, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return Repayment.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public RepaymentInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HiveModuleManager.INSTANCE.discover(this);
        return this;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.listOf((Object[]) new Class[]{HiveCoreInitializer.class, HiveInitializer.class, IapV4Initializer.class});
    }

    @Override // com.hive.module.interfaces.iapv4.Repayment
    public void showRepayment(Activity activity, HiveLifecycle.HiveAccount account, Function0<Unit> startGameListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(startGameListener, "startGameListener");
        new Repayment(activity, account).show(startGameListener);
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Iapv4_Repayment(), "26.2.0");
        return map;
    }
}
