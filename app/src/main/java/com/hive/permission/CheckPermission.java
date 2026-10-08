package com.hive.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Configuration;
import com.hive.HiveActivity;
import com.hive.PlatformHelper;
import com.hive.ResultAPI;
import com.hive.auth.AuthKeys;
import com.hive.auth.UserAgreeDialog;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import com.hive.platformhelper.PlatformHelperImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "4.16.2, GCPSDK4-906")
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\"\u001a\u0004\u0018\u00010\u001aJ+\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050$2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bH\u0002¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010*\u001a\u00020 2\u0006\u0010(\u001a\u00020)J\u0010\u0010+\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0002J\u0006\u0010,\u001a\u00020\u000eJ\u0006\u0010-\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b8BX\u0082\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR#\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b8F¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR#\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00020\u0005`\b8F¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/hive/permission/CheckPermission;", "", "<init>", "()V", "TAG", "", "HIVE_PERMISSIONS", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "HIVE_RATIONALE_PERMISSIONS", "PERMISSIONS_THAT_NEED_CHECK", "getPERMISSIONS_THAT_NEED_CHECK", "()Ljava/util/ArrayList;", "isPermissionAlreadyGranted", "", "()Z", "shouldShowRationalePermissions", "getShouldShowRationalePermissions", "shouldRequestPermissions", "getShouldRequestPermissions", "CHECK_PERMISSION_ACTION", "CHECK_PERMISSION_REQUEST_CODE", "", "SETTING_ACTION_REQUEST_CODE", "isEnableRequestStoragePermission", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/permission/CheckPermission$OnAuthCheckPermissionListener;", "getListener$hive_service_release", "()Lcom/hive/permission/CheckPermission$OnAuthCheckPermissionListener;", "setListener$hive_service_release", "(Lcom/hive/permission/CheckPermission$OnAuthCheckPermissionListener;)V", "setEnableRequestStoragePermission", "", InAppPurchaseConstants.METHOD_SET_LISTENER, "getListener", "getDeniedPermissions", "", "permissions", "(Ljava/util/ArrayList;)[Ljava/lang/String;", "launchFlow", "context", "Landroid/content/Context;", "requestPermission", "requestPermissionWithoutPermissionDescription", "isChecked", "checked", "OnAuthCheckPermissionListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPermission {
    public static final String CHECK_PERMISSION_ACTION = "com.hive.auth.CHECK_PERMISSION";
    public static final int CHECK_PERMISSION_REQUEST_CODE = 29512;
    public static final int SETTING_ACTION_REQUEST_CODE = 31112;
    public static final String TAG = "CheckPermission";
    private static boolean isEnableRequestStoragePermission;
    private static OnAuthCheckPermissionListener listener;
    public static final CheckPermission INSTANCE = new CheckPermission();
    private static final ArrayList<String> HIVE_PERMISSIONS = new ArrayList<>();
    private static final ArrayList<String> HIVE_RATIONALE_PERMISSIONS = CollectionsKt.arrayListOf("android.permission.WRITE_CONTACTS", "android.permission.READ_CONTACTS", "android.permission.GET_ACCOUNTS", "android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.ACCEPT_HANDOVER", "android.permission.USE_SIP", "android.permission.ACCESS_UCE_OPTIONS_SERVICE", "android.permission.ANSWER_PHONE_CALLS", "android.permission.READ_PHONE_NUMBERS", "android.permission.ACCESS_UCE_PRESENCE_SERVICE", "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR", "android.permission.CAMERA", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS", "android.permission.RECEIVE_SMS", "android.permission.SEND_SMS", "android.permission.READ_CELL_BROADCASTS", "android.permission.BODY_SENSORS", "android.permission.USE_FINGERPRINT", "android.permission.USE_BIOMETRIC");
    private static final ArrayList<String> PERMISSIONS_THAT_NEED_CHECK = new ArrayList<>();
    private static final ArrayList<String> shouldShowRationalePermissions = new ArrayList<>();
    private static final ArrayList<String> shouldRequestPermissions = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/hive/permission/CheckPermission$OnAuthCheckPermissionListener;", "", "onAuthCheckPermissionListener", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnAuthCheckPermissionListener {
        void onAuthCheckPermissionListener();
    }

    static {
        LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] create");
    }

    private CheckPermission() {
    }

    private final String[] getDeniedPermissions(ArrayList<String> permissions) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(TAG, "[CheckPermission] getDeniedPermissions");
        Context context = Configuration.getContext();
        ArrayList arrayList = new ArrayList();
        if (permissions.isEmpty()) {
            loggerImpl.d(TAG, "[CheckPermission] getDeniedPermissions() parameter is empty");
            return (String[]) arrayList.toArray(new String[0]);
        }
        for (String str : permissions) {
            if (context.checkSelfPermission(str) == -1) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private final ArrayList<String> getPERMISSIONS_THAT_NEED_CHECK() {
        PERMISSIONS_THAT_NEED_CHECK.clear();
        Context context = Configuration.getContext();
        String[] strArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        if (strArr != null) {
            for (String str : strArr) {
                if (HIVE_RATIONALE_PERMISSIONS.contains(str)) {
                    PERMISSIONS_THAT_NEED_CHECK.add(str);
                }
            }
        }
        return PERMISSIONS_THAT_NEED_CHECK;
    }

    private final boolean isPermissionAlreadyGranted() {
        Context context = Configuration.getContext();
        Iterator<T> it = getPERMISSIONS_THAT_NEED_CHECK().iterator();
        while (it.hasNext()) {
            if (context.checkSelfPermission((String) it.next()) == -1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$6(Context context) {
        Intent intent = new Intent(context, (Class<?>) UserAgreeDialog.class);
        intent.setAction(CHECK_PERMISSION_ACTION);
        ExtentionsKt.startActivityCatching$default(context, intent, null, 2, null);
    }

    private final void requestPermissionWithoutPermissionDescription(Context context) {
        LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] requestPermissionWithoutPermissionDescription.");
        PlatformHelperImpl.INSTANCE.requestUserPermissions(CollectionsKt.toList(getShouldRequestPermissions()), new PlatformHelper.RequestUserPermissionsListener() { // from class: com.hive.permission.CheckPermission.requestPermissionWithoutPermissionDescription.1
            @Override // com.hive.PlatformHelper.RequestUserPermissionsListener
            public void onRequestUserPermissions(ResultAPI result, List<String> granted, List<String> denied) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(granted, "granted");
                Intrinsics.checkNotNullParameter(denied, "denied");
                OnAuthCheckPermissionListener listener2 = CheckPermission.INSTANCE.getListener();
                if (listener2 != null) {
                    listener2.onAuthCheckPermissionListener();
                }
            }
        });
    }

    public final void checked() {
        LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] checked");
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), AuthKeys.INSTANCE.getIS_CHECKED_PERMISSION(), "true", null, 4, null);
        companion.getINSTANCE().writeProperties();
    }

    public final OnAuthCheckPermissionListener getListener() {
        return listener;
    }

    public final OnAuthCheckPermissionListener getListener$hive_service_release() {
        return listener;
    }

    public final ArrayList<String> getShouldRequestPermissions() {
        ArrayList<String> arrayList = shouldRequestPermissions;
        arrayList.clear();
        CollectionsKt.addAll(arrayList, INSTANCE.getDeniedPermissions(HIVE_PERMISSIONS));
        return arrayList;
    }

    public final ArrayList<String> getShouldShowRationalePermissions() {
        ArrayList<String> arrayList = shouldShowRationalePermissions;
        arrayList.clear();
        if (TextUtils.equals("true", Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getIS_CHECKED_PERMISSION()))) {
            for (String str : getPERMISSIONS_THAT_NEED_CHECK()) {
                try {
                    boolean zShouldShowRequestPermissionRationale = HiveActivity.INSTANCE.getRecentActivity().shouldShowRequestPermissionRationale(str);
                    LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] isChecked: Show a rationale? " + zShouldShowRequestPermissionRationale + " (" + str + ')');
                    if (zShouldShowRequestPermissionRationale) {
                        shouldShowRationalePermissions.add(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            CollectionsKt.addAll(arrayList, getDeniedPermissions(getPERMISSIONS_THAT_NEED_CHECK()));
        }
        return shouldShowRationalePermissions;
    }

    public final boolean isChecked() {
        ArrayList<String> shouldShowRationalePermissions2 = getShouldShowRationalePermissions();
        return shouldShowRationalePermissions2 == null || shouldShowRationalePermissions2.isEmpty();
    }

    public final void launchFlow(Context context, OnAuthCheckPermissionListener listener2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener2, "listener");
        listener = listener2;
        if (isPermissionAlreadyGranted()) {
            LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] launchFlow() isPermissionAlreadyGranted");
            listener2.onAuthCheckPermissionListener();
            return;
        }
        if (getShouldShowRationalePermissions().isEmpty()) {
            if (getShouldShowRationalePermissions().isEmpty()) {
                LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] launchFlow() shouldShowRationalePermissions.isEmpty()");
                requestPermissionWithoutPermissionDescription(context);
                return;
            }
            return;
        }
        boolean z = PermissionImpl.INSTANCE.hasCalledRequestPermissionViewData() || !ConfigurationImpl.INSTANCE.getHivePermissionViewOn();
        LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] launchFlow() shouldShowRationalePermissions.isNotEmpty() didCustomRationale: " + z);
        if (z) {
            requestPermissionWithoutPermissionDescription(context);
        } else {
            requestPermission(context);
        }
    }

    public final void requestPermission(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] requestPermission.");
        new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.hive.permission.CheckPermission$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CheckPermission.requestPermission$lambda$6(context);
            }
        });
    }

    public final void setEnableRequestStoragePermission() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(TAG, "[CheckPermission] setEnableRequestStoragePermission");
        if (!isEnableRequestStoragePermission) {
            if (Build.VERSION.SDK_INT >= 29) {
                HIVE_PERMISSIONS.add("android.permission.READ_EXTERNAL_STORAGE");
            } else {
                HIVE_PERMISSIONS.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            loggerImpl.d(TAG, "[CheckPermission] storage and Permission List : " + HIVE_PERMISSIONS);
        }
        isEnableRequestStoragePermission = true;
    }

    public final void setListener(OnAuthCheckPermissionListener listener2) {
        Intrinsics.checkNotNullParameter(listener2, "listener");
        LoggerImpl.INSTANCE.d(TAG, "[CheckPermission] setParam");
        listener = listener2;
    }

    public final void setListener$hive_service_release(OnAuthCheckPermissionListener onAuthCheckPermissionListener) {
        listener = onAuthCheckPermissionListener;
    }
}
