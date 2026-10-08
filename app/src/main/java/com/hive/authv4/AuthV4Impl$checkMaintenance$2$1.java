package com.hive.authv4;

import android.content.DialogInterface;
import android.os.Handler;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.auth.MaintenanceDialog;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/hive/authv4/AuthV4Impl$checkMaintenance$2$1", "Lcom/hive/auth/MaintenanceDialog$OnDismissListener;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "onDismissWithButtonAction", "buttonAction", "Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Impl$checkMaintenance$2$1 implements MaintenanceDialog.OnDismissListener {
    final /* synthetic */ String $fApiName;
    final /* synthetic */ AuthV4.AuthV4MaintenanceListener $listener;
    final /* synthetic */ ArrayList<AuthV4.AuthV4MaintenanceInfo> $maintenanceInfoList;
    final /* synthetic */ ResultAPI $resultApi;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MaintenanceDialog.MaintenanceActionType.values().length];
            try {
                iArr[MaintenanceDialog.MaintenanceActionType.TIMEOVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MaintenanceDialog.MaintenanceActionType.OPEN_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MaintenanceDialog.MaintenanceActionType.EXIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MaintenanceDialog.MaintenanceActionType.DONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AuthV4Impl$checkMaintenance$2$1(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList) {
        this.$fApiName = str;
        this.$resultApi = resultAPI;
        this.$listener = authV4MaintenanceListener;
        this.$maintenanceInfoList = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDismiss$lambda$0(String str, ResultAPI resultAPI, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, ArrayList arrayList) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDismissWithButtonAction$lambda$1(MaintenanceDialog.MaintenanceActionType maintenanceActionType, String str, AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener, ArrayList arrayList) {
        int i = WhenMappings.$EnumSwitchMapping$0[maintenanceActionType.ordinal()];
        ResultAPI resultAPI = i != 1 ? i != 2 ? i != 3 ? i != 4 ? new ResultAPI(-17, ResultAPI.Code.AuthV4MaintenanceActionDefault_DoExit, "") : new ResultAPI(0, ResultAPI.Code.AuthV4MaintenanceActionDone, "") : new ResultAPI(-17, ResultAPI.Code.AuthV4MaintenanceActionExit_DoExit, "") : new ResultAPI(-17, ResultAPI.Code.AuthV4MaintenanceActionOpenURL_DoExit, "") : new ResultAPI(-17, ResultAPI.Code.AuthV4MaintenanceTimeover_DoExit, "");
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4MaintenanceListener.onAuthV4Maintenance(resultAPI, arrayList);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Handler handler = AuthV4Impl.mainLooperHandler;
        final String str = this.$fApiName;
        final ResultAPI resultAPI = this.$resultApi;
        final AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener = this.$listener;
        final ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = this.$maintenanceInfoList;
        handler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$checkMaintenance$2$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl$checkMaintenance$2$1.onDismiss$lambda$0(str, resultAPI, authV4MaintenanceListener, arrayList);
            }
        });
    }

    @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
    public void onDismissWithButtonAction(DialogInterface dialog, final MaintenanceDialog.MaintenanceActionType buttonAction) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
        Handler handler = AuthV4Impl.mainLooperHandler;
        final String str = this.$fApiName;
        final AuthV4.AuthV4MaintenanceListener authV4MaintenanceListener = this.$listener;
        final ArrayList<AuthV4.AuthV4MaintenanceInfo> arrayList = this.$maintenanceInfoList;
        handler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$checkMaintenance$2$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl$checkMaintenance$2$1.onDismissWithButtonAction$lambda$1(buttonAction, str, authV4MaintenanceListener, arrayList);
            }
        });
    }
}
