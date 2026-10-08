package com.hive.authv4;

import android.os.Handler;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/hive/authv4/AuthV4Impl$checkBlacklist$3$2", "Lcom/hive/AuthV4$AuthV4MaintenanceListener;", "onAuthV4Maintenance", "", "result", "Lcom/hive/ResultAPI;", "maintenanceInfo", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$AuthV4MaintenanceInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Impl$checkBlacklist$3$2 implements AuthV4.AuthV4MaintenanceListener {
    final /* synthetic */ String $fApiName;
    final /* synthetic */ ArrayList<AuthV4.AuthV4MaintenanceInfo> $infoList;
    final /* synthetic */ AuthV4.AuthV4MaintenanceListener $listener;

    public AuthV4Impl$checkBlacklist$3$2(String str, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList) {
        this.$fApiName = str;
        this.$listener = authV4MaintenanceListener;
        this.$infoList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAuthV4Maintenance$lambda$0(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, ArrayList arrayList) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, arrayList);
    }

    @Override // com.hive.AuthV4.AuthV4MaintenanceListener
    public void onAuthV4Maintenance(final ResultAPI result, ArrayList<AuthV4.AuthV4MaintenanceInfo> maintenanceInfo) {
        Intrinsics.checkNotNullParameter(result, "result");
        Handler handler = AuthV4Impl.mainLooperHandler;
        final String str = this.$fApiName;
        final AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener = this.$listener;
        final ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = this.$infoList;
        handler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$checkBlacklist$3$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl$checkBlacklist$3$2.onAuthV4Maintenance$lambda$0(str, result, authV4MaintenanceListener, arrayList);
            }
        });
    }
}
