package com.hive.module.interfaces.authv4;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J \u0010\n\u001a\u00020\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH'¨\u0006\u000e"}, d2 = {"Lcom/hive/module/interfaces/authv4/GoogleInAppUpdate;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "launchAppUpdateFlow", "", "appUpdateType", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/module/interfaces/authv4/GoogleInAppUpdate$UpdateFlowListener;", "completeUpdate", "Lkotlin/Function1;", "", "UpdateFlowListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GoogleInAppUpdate extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void completeUpdate$default(GoogleInAppUpdate googleInAppUpdate, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: completeUpdate");
            }
            if ((i & 1) != 0) {
                function1 = null;
            }
            googleInAppUpdate.completeUpdate(function1);
        }

        public static String getHiveModuleName(GoogleInAppUpdate googleInAppUpdate) {
            return HiveModuleName.INSTANCE.getAuthV4_Google_InAppUpdate();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/hive/module/interfaces/authv4/GoogleInAppUpdate$UpdateFlowListener;", "", "onDownloading", "", "onDownloaded", "onDeveloperTriggered", "onNotAvailable", "onCanceled", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface UpdateFlowListener {
        void onCanceled();

        void onDeveloperTriggered();

        void onDownloaded();

        void onDownloading();

        void onNotAvailable();
    }

    void completeUpdate(Function1<? super Boolean, Unit> listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void launchAppUpdateFlow(int appUpdateType, UpdateFlowListener listener);
}
