package com.hive.push.google.fcm;

import android.content.Context;
import androidx.startup.Initializer;
import com.hive.base.HiveInitializer;
import com.hive.core.HiveCoreInitializer;
import com.hive.module.HiveModuleManager;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.push.GoogleFcm;
import com.hive.push.PushImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GoogleFcmInitializer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/hive/push/google/fcm/GoogleFcmInitializer;", "Landroidx/startup/Initializer;", "Lcom/hive/module/interfaces/push/GoogleFcm;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", "", "Ljava/lang/Class;", "getVersionInfo", "", "", "hive-push-google-fcm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GoogleFcmInitializer implements Initializer<GoogleFcmInitializer>, GoogleFcm {
    @Override // com.hive.module.interfaces.push.GoogleFcm, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return GoogleFcm.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public GoogleFcmInitializer create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HiveModuleManager.INSTANCE.discover(this);
        PushImpl pushImpl = PushImpl.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        pushImpl.addRemotePushInstance(new Fcm(applicationContext, PushImpl.RemotePushType.FCM));
        return this;
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return CollectionsKt.listOf((Object[]) new Class[]{HiveCoreInitializer.class, HiveInitializer.class});
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Push_Google_Fcm(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            map.put(ModuleCheckName.INSTANCE.getFirebase_Messaging(), com.google.firebase.messaging.BuildConfig.VERSION_NAME);
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }
}
