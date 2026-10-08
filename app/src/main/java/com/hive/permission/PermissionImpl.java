package com.hive.permission;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.HiveActivity;
import com.hive.Permission;
import com.hive.ResultAPI;
import com.hive.auth.AuthKeys;
import com.hive.base.Property;
import com.hive.core.configuration.HiveLanguage;
import com.hive.logger.LoggerImpl;
import com.hive.permission.CheckPermissionLayoutV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "4.16.2, GCPSDK4-906")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/hive/permission/PermissionImpl;", "", "<init>", "()V", "hasCalledRequestPermissionViewData", "", "isInProgressRequestPermissionViewData", "TAG", "", "requestPermissionViewData", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Permission$PermissionViewDataListener;", "getPermissionViewData", "Lcom/hive/Permission$PermissionViewData;", "language", "Lcom/hive/core/configuration/HiveLanguage;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionImpl {
    public static final PermissionImpl INSTANCE = new PermissionImpl();
    private static final String TAG = "Permission";
    private static boolean hasCalledRequestPermissionViewData;
    private static boolean isInProgressRequestPermissionViewData;

    private PermissionImpl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionViewData$lambda$0(String str, Permission.PermissionViewDataListener permissionViewDataListener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        Permission permission = Permission.INSTANCE;
        loggerImpl.e(permission.getTAG(), "requestPermissionViewData is already in progress!");
        ResultAPI resultAPI = new ResultAPI(-3, ResultAPI.Code.AuthV4InProgress, "requestPermissionViewData is already in progress!");
        loggerImpl.apiCallbackLog(permission.getTAG(), str, resultAPI.toString());
        if (permissionViewDataListener != null) {
            permissionViewDataListener.onPermissionViewData(resultAPI, null);
        }
    }

    public final boolean hasCalledRequestPermissionViewData() {
        if (!TextUtils.isEmpty(Property.INSTANCE.getINSTANCE().getValue(AuthKeys.INSTANCE.getPERMISSION_VIEW_DATA_SHOWN()))) {
            hasCalledRequestPermissionViewData = true;
        }
        return hasCalledRequestPermissionViewData;
    }

    public final void requestPermissionViewData(final Permission.PermissionViewDataListener listener) {
        int i = 2;
        final String callMethodName = LoggerImpl.getCallMethodName(2);
        if (isInProgressRequestPermissionViewData) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.permission.PermissionImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PermissionImpl.requestPermissionViewData$lambda$0(callMethodName, listener);
                }
            });
            return;
        }
        isInProgressRequestPermissionViewData = true;
        hasCalledRequestPermissionViewData = true;
        CheckPermission checkPermission = CheckPermission.INSTANCE;
        CheckPermissionLayoutV2.OnFinishedListener onFinishedListener = null;
        byte b = 0;
        if (checkPermission.isChecked()) {
            LoggerImpl.INSTANCE.i(TAG, "requestPermissionViewData : ");
            isInProgressRequestPermissionViewData = false;
            if (listener != null) {
                listener.onPermissionViewData(new ResultAPI(0, ResultAPI.Code.AuthV4SkipPermissionView), null);
                return;
            }
            return;
        }
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.i(TAG, "requestPermissionViewData : ");
        if (checkPermission.getShouldShowRationalePermissions().size() <= 0) {
            loggerImpl.i(TAG, "requestPermissionViewData : ");
            isInProgressRequestPermissionViewData = false;
            if (listener != null) {
                listener.onPermissionViewData(new ResultAPI(0, ResultAPI.Code.AuthV4SkipPermissionView), null);
                return;
            }
            return;
        }
        CheckPermissionLayoutV2 checkPermissionLayoutV2 = new CheckPermissionLayoutV2(HiveActivity.INSTANCE.getRecentActivity(), onFinishedListener, i, b == true ? 1 : 0);
        ArrayList<String> permissionList = checkPermissionLayoutV2.getPermissionList();
        if (permissionList.isEmpty()) {
            loggerImpl.i(TAG, "requestPermissionViewData : ");
            isInProgressRequestPermissionViewData = false;
            if (listener != null) {
                listener.onPermissionViewData(new ResultAPI(0, ResultAPI.Code.AuthV4SkipPermissionView), null);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = permissionList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            String next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            String str = next;
            arrayList.add(new Permission.PermissionViewUnitData(checkPermissionLayoutV2.getContentsStr(str, 0), checkPermissionLayoutV2.getContentsStr(str, 1), str, checkPermissionLayoutV2.getPermissionViewCategory(str)));
        }
        ArrayList<String> commonList = checkPermissionLayoutV2.getCommonList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = commonList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            String next2 = it2.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            String str2 = next2;
            arrayList2.add(new Permission.PermissionViewUnitData(checkPermissionLayoutV2.getCommonContentsStr(str2, 0), checkPermissionLayoutV2.getCommonContentsStr(str2, 1), str2, checkPermissionLayoutV2.getPermissionViewCategory(str2)));
        }
        Permission.PermissionViewData permissionViewData = new Permission.PermissionViewData(checkPermissionLayoutV2.getTitleStr(), arrayList, arrayList2);
        isInProgressRequestPermissionViewData = false;
        if (listener != null) {
            listener.onPermissionViewData(new ResultAPI(0, ResultAPI.Code.Success), permissionViewData);
        }
    }

    public final Permission.PermissionViewData getPermissionViewData(HiveLanguage language) {
        Intrinsics.checkNotNullParameter(language, "language");
        Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
        Configuration configuration = recentActivity.getResources().getConfiguration();
        if (Intrinsics.areEqual(language.getValue(), "zh-hans")) {
            configuration.setLocale(Locale.SIMPLIFIED_CHINESE);
        } else if (Intrinsics.areEqual(language.getValue(), "zh-hant")) {
            configuration.setLocale(Locale.TRADITIONAL_CHINESE);
        } else {
            configuration.setLocale(new Locale(language.getValue()));
        }
        Resources resources = recentActivity.createConfigurationContext(configuration).getResources();
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission-group.PHONE");
        arrayList.add("android.permission-group.STORAGE");
        arrayList.add("android.permission-group.CONTACTS");
        arrayList.add("android.permission-group.MICROPHONE");
        arrayList.add("android.permission-group.LOCATION");
        arrayList.add("android.permission-group.CAMERA");
        arrayList.add("android.permission-group.SMS");
        arrayList.add("android.permission-group.CALENDAR");
        arrayList.add("android.permission-group.SENSORS");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("Common");
        CheckPermissionLayoutV2 checkPermissionLayoutV2 = new CheckPermissionLayoutV2(recentActivity, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNull(resources);
        String titleStr = checkPermissionLayoutV2.getTitleStr(resources);
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            String str = (String) next;
            Intrinsics.checkNotNull(resources);
            String contentsStr = checkPermissionLayoutV2.getContentsStr(resources, str, 0);
            Intrinsics.checkNotNull(resources);
            String contentsStr2 = checkPermissionLayoutV2.getContentsStr(resources, str, 1);
            Permission.PermissionCategory permissionViewCategory = checkPermissionLayoutV2.getPermissionViewCategory(str);
            if (contentsStr.length() != 0 && contentsStr2.length() != 0) {
                arrayList3.add(new Permission.PermissionViewUnitData(contentsStr, contentsStr2, str, permissionViewCategory));
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.size() > 0) {
            Iterator it2 = arrayList2.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                String str2 = (String) next2;
                Intrinsics.checkNotNull(resources);
                String commonContentsStr = checkPermissionLayoutV2.getCommonContentsStr(resources, str2, 0);
                Intrinsics.checkNotNull(resources);
                String commonContentsStr2 = checkPermissionLayoutV2.getCommonContentsStr(resources, str2, 1);
                Permission.PermissionCategory permissionViewCategory2 = checkPermissionLayoutV2.getPermissionViewCategory(str2);
                if (commonContentsStr2.length() != 0) {
                    arrayList4.add(new Permission.PermissionViewUnitData(commonContentsStr, commonContentsStr2, str2, permissionViewCategory2));
                }
            }
            return new Permission.PermissionViewData(titleStr, arrayList3, arrayList4);
        }
        return new Permission.PermissionViewData("", new ArrayList(), new ArrayList());
    }
}
