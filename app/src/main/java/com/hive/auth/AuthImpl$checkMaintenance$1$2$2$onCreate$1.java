package com.hive.auth;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.hive.ResultAPI;
import com.hive.auth.AuthDataInterface;
import com.hive.auth.MaintenanceDialog;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.activeuser.GetNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/hive/auth/AuthImpl$checkMaintenance$1$2$2$onCreate$1", "Lcom/hive/auth/MaintenanceDialog$OnDismissListener;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "onDismissWithButtonAction", "buttonAction", "Lcom/hive/auth/MaintenanceDialog$MaintenanceActionType;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthImpl$checkMaintenance$1$2$2$onCreate$1 implements MaintenanceDialog.OnDismissListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ AuthDataInterface.AuthMaintenanceInfo $authMaintenanceInfo;
    final /* synthetic */ AuthDataInterface.AuthMaintenanceListener $authMaintenanceListener;
    final /* synthetic */ String $fApiName;
    final /* synthetic */ GetNotice $it;

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

    public AuthImpl$checkMaintenance$1$2$2$onCreate$1(Activity activity, GetNotice getNotice, String str, AuthDataInterface.AuthMaintenanceListener authMaintenanceListener, AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo) {
        this.$activity = activity;
        this.$it = getNotice;
        this.$fApiName = str;
        this.$authMaintenanceListener = authMaintenanceListener;
        this.$authMaintenanceInfo = authMaintenanceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDismiss$lambda$0(GetNotice getNotice, String str, AuthDataInterface.AuthMaintenanceListener authMaintenanceListener, AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo) {
        ResultAPI resultAPI = new ResultAPI(0, ResultAPI.Code.Success, "checkMaintenance success : " + getNotice);
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        authMaintenanceListener.onAuthMaintenance(resultAPI, authMaintenanceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDismissWithButtonAction$lambda$1(MaintenanceDialog.MaintenanceActionType maintenanceActionType, String str, AuthDataInterface.AuthMaintenanceListener authMaintenanceListener, AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo) {
        int i = WhenMappings.$EnumSwitchMapping$0[maintenanceActionType.ordinal()];
        ResultAPI resultAPI = i != 1 ? i != 2 ? i != 3 ? i != 4 ? new ResultAPI(-17, ResultAPI.Code.AuthMaintenanceActionDefault_DoExit, "") : new ResultAPI(0, ResultAPI.Code.AuthMaintenanceActionDone, "") : new ResultAPI(-17, ResultAPI.Code.AuthMaintenanceActionExit_DoExit, "") : new ResultAPI(-17, ResultAPI.Code.AuthMaintenanceActionOpenURL_DoExit, "") : new ResultAPI(-17, ResultAPI.Code.AuthMaintenanceTimeover_DoExit, "");
        LoggerImpl.INSTANCE.apiCallbackLog(AuthDataInterface.getTAG(), str, resultAPI.toString());
        authMaintenanceListener.onAuthMaintenance(resultAPI, authMaintenanceInfo);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.$activity.finish();
        Handler handler = new Handler(Looper.getMainLooper());
        final GetNotice getNotice = this.$it;
        final String str = this.$fApiName;
        final AuthDataInterface.AuthMaintenanceListener authMaintenanceListener = this.$authMaintenanceListener;
        final AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo = this.$authMaintenanceInfo;
        handler.post(new Runnable() { // from class: com.hive.auth.AuthImpl$checkMaintenance$1$2$2$onCreate$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AuthImpl$checkMaintenance$1$2$2$onCreate$1.onDismiss$lambda$0(getNotice, str, authMaintenanceListener, authMaintenanceInfo);
            }
        });
    }

    @Override // com.hive.auth.MaintenanceDialog.OnDismissListener
    public void onDismissWithButtonAction(DialogInterface dialog, final MaintenanceDialog.MaintenanceActionType buttonAction) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
        this.$activity.finish();
        Handler handler = new Handler(Looper.getMainLooper());
        final String str = this.$fApiName;
        final AuthDataInterface.AuthMaintenanceListener authMaintenanceListener = this.$authMaintenanceListener;
        final AuthDataInterface.AuthMaintenanceInfo authMaintenanceInfo = this.$authMaintenanceInfo;
        handler.post(new Runnable() { // from class: com.hive.auth.AuthImpl$checkMaintenance$1$2$2$onCreate$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthImpl$checkMaintenance$1$2$2$onCreate$1.onDismissWithButtonAction$lambda$1(buttonAction, str, authMaintenanceListener, authMaintenanceInfo);
            }
        });
    }
}
