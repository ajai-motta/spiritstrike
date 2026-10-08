package com.hive.module;

import com.hive.logger.LoggerImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006J\u001c\u0010\n\u001a\u0004\u0018\u0001H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u0007H\u0086\b¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u0004\u0018\u0001H\f\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\u000fH\u0086\b¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/hive/module/HiveModuleManager;", "", "<init>", "()V", "initialized", "", "", "Lcom/hive/module/HiveModule;", "discover", "hiveModule", "getHiveModule", "hiveModuleName", "T", "()Lcom/hive/module/HiveModule;", "getGoogleSignInModule", "Lcom/hive/module/GoogleSignInModule;", "()Lcom/hive/module/GoogleSignInModule;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleManager {
    public static final HiveModuleManager INSTANCE = new HiveModuleManager();
    private static final Map<String, HiveModule> initialized = new LinkedHashMap();

    private HiveModuleManager() {
    }

    public final String discover(HiveModule hiveModule) {
        Intrinsics.checkNotNullParameter(hiveModule, "hiveModule");
        String hiveModuleName = hiveModule.getHiveModuleName();
        Map<String, HiveModule> map = initialized;
        if (!map.containsKey(hiveModuleName)) {
            map.put(hiveModuleName, hiveModule);
        }
        return hiveModuleName;
    }

    public final HiveModule getHiveModule(String hiveModuleName) {
        Intrinsics.checkNotNullParameter(hiveModuleName, "hiveModuleName");
        HiveModule hiveModule = initialized.get(hiveModuleName);
        if (hiveModule == null) {
            LoggerImpl.INSTANCE.d(hiveModuleName + " Library not set.");
        }
        return hiveModule;
    }

    public final /* synthetic */ <T extends HiveModule> T getHiveModule() {
        Intrinsics.reifiedOperationMarker(4, "T");
        String name = HiveModule.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        T t = (T) getHiveModule(name);
        Intrinsics.reifiedOperationMarker(3, "T");
        if (!(t instanceof HiveModule)) {
            t = null;
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }

    public final /* synthetic */ <T extends GoogleSignInModule> T getGoogleSignInModule() {
        Intrinsics.reifiedOperationMarker(4, "T");
        String name = GoogleSignInModule.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = getHiveModule(name);
        Intrinsics.reifiedOperationMarker(3, "T");
        if (!(hiveModule instanceof GoogleSignInModule)) {
            hiveModule = null;
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) hiveModule;
    }
}
