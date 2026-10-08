package com.hive.authv4.google.inappupdate;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.GoogleInAppUpdate;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveModuleInAppUpdate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u001e\u0010\u0010\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H\u0017J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/hive/authv4/google/inappupdate/HiveModuleInAppUpdate;", "Lcom/hive/module/interfaces/authv4/GoogleInAppUpdate;", "<init>", "()V", "googleInAppUpdate", "Lcom/hive/authv4/google/inappupdate/InAppUpdate;", "getGoogleInAppUpdate", "()Lcom/hive/authv4/google/inappupdate/InAppUpdate;", "googleInAppUpdate$delegate", "Lkotlin/Lazy;", "launchAppUpdateFlow", "", "appUpdateType", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/module/interfaces/authv4/GoogleInAppUpdate$UpdateFlowListener;", "completeUpdate", "Lkotlin/Function1;", "", "getVersionInfo", "", "", "hive-authv4-google-inappupdate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleInAppUpdate implements GoogleInAppUpdate {

    /* JADX INFO: renamed from: googleInAppUpdate$delegate, reason: from kotlin metadata */
    private final Lazy googleInAppUpdate = LazyKt.lazy(new Function0() { // from class: com.hive.authv4.google.inappupdate.HiveModuleInAppUpdate$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HiveModuleInAppUpdate.googleInAppUpdate_delegate$lambda$0();
        }
    });

    @Override // com.hive.module.interfaces.authv4.GoogleInAppUpdate, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return GoogleInAppUpdate.DefaultImpls.getHiveModuleName(this);
    }

    private final InAppUpdate getGoogleInAppUpdate() {
        return (InAppUpdate) this.googleInAppUpdate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InAppUpdate googleInAppUpdate_delegate$lambda$0() {
        return new InAppUpdate();
    }

    @Override // com.hive.module.interfaces.authv4.GoogleInAppUpdate
    public void launchAppUpdateFlow(int appUpdateType, GoogleInAppUpdate.UpdateFlowListener listener) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            Result.Companion companion = Result.INSTANCE;
            Class.forName("com.google.android.play.core.appupdate.AppUpdateManager");
            getGoogleInAppUpdate().launchAppUpdateFlow(appUpdateType, listener);
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7418exceptionOrNullimpl(objM7415constructorimpl) != null) {
            listener.onNotAvailable();
        }
    }

    @Override // com.hive.module.interfaces.authv4.GoogleInAppUpdate
    public void completeUpdate(Function1<? super Boolean, Unit> listener) {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Class.forName("com.google.android.play.core.appupdate.AppUpdateManager");
            getGoogleInAppUpdate().completeUpdate(listener);
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7418exceptionOrNullimpl(objM7415constructorimpl) == null || listener == null) {
            return;
        }
        listener.invoke(false);
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Google_Inappupdate(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            Properties properties = new Properties();
            properties.load(HiveActivity.INSTANCE.getRecentActivity().getClassLoader().getResourceAsStream("app-update.properties"));
            map.put(ModuleCheckName.INSTANCE.getGoogle_Play_Appupdate(), properties.getProperty("version"));
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }
}
