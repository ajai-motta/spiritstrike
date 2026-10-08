package com.hive.permission;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.Permission;
import com.hive.logger.LoggerImpl;
import com.hive.ui.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "4.16.2, GCPSDK4-906")
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u00012B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0017H\u0003J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-J\u001e\u0010*\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-J\u0016\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-J\u001e\u0010.\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-J\u0006\u00100\u001a\u00020\u001aJ\u0006\u00101\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R>\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R>\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\t0\rj\b\u0012\u0004\u0012\u00020\t`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/hive/permission/CheckPermissionLayoutV2;", "Landroid/widget/RelativeLayout;", "activity", "Landroid/app/Activity;", "finishedListener", "Lcom/hive/permission/CheckPermissionLayoutV2$OnFinishedListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/permission/CheckPermissionLayoutV2$OnFinishedListener;)V", "permissionLayoutContentView", "Landroid/widget/LinearLayout;", "permissionLayoutButtonOK", "Landroid/widget/TextView;", "value", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "permissionList", "getPermissionList", "()Ljava/util/ArrayList;", "commonList", "getCommonList", "textViewArr", "mContext", "Landroid/content/Context;", "rootView", "finish", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "resetUI", "getPermissionViewCategory", "Lcom/hive/Permission$PermissionCategory;", "permissionName", "getOldPermissionGroup", TtmlNode.TAG_P, "checkPermissionGroupAndroidQ", "context", "checkPermissionGroup", "getTitleStr", "res", "Landroid/content/res/Resources;", "getContentsStr", "groupName", FirebaseAnalytics.Param.INDEX, "", "getCommonContentsStr", "commonName", "release", "onBackKeyDown", "OnFinishedListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPermissionLayoutV2 extends RelativeLayout {
    private final Activity activity;
    private ArrayList<String> commonList;
    private final OnFinishedListener finishedListener;
    private final Context mContext;
    private TextView permissionLayoutButtonOK;
    private LinearLayout permissionLayoutContentView;
    private ArrayList<String> permissionList;
    private RelativeLayout rootView;
    private ArrayList<LinearLayout> textViewArr;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/hive/permission/CheckPermissionLayoutV2$OnFinishedListener;", "", "onFinished", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnFinishedListener {
        void onFinished();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckPermissionLayoutV2(Activity activity) {
        this(activity, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[Catch: Exception -> 0x00aa, TryCatch #1 {Exception -> 0x00aa, blocks: (B:7:0x0027, B:9:0x0034, B:11:0x0038, B:13:0x0044, B:15:0x0048, B:16:0x004c, B:18:0x0050, B:45:0x00a1, B:21:0x0059, B:24:0x0062, B:27:0x006b, B:30:0x0074, B:33:0x007d, B:36:0x0086, B:39:0x008f, B:42:0x0098, B:46:0x00a6), top: B:59:0x0027, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void checkPermissionGroup(android.content.Context r6) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.permission.CheckPermissionLayoutV2.checkPermissionGroup(android.content.Context):void");
    }

    private final void checkPermissionGroupAndroidQ(Context context) {
        this.permissionList = new ArrayList<>();
        try {
            Iterator<String> it = CheckPermission.INSTANCE.getShouldShowRationalePermissions().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                String next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                String oldPermissionGroup = getOldPermissionGroup(next);
                if (!StringsKt.isBlank(oldPermissionGroup)) {
                    this.permissionList.add(oldPermissionGroup);
                }
            }
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w("checkPermissionGroupAndroidQ exception: " + e.getMessage());
        }
        HashSet hashSet = new HashSet(this.permissionList);
        this.permissionList.clear();
        this.permissionList.addAll(hashSet);
        if (this.permissionList.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.commonList = arrayList;
            arrayList.add("Common");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final String getOldPermissionGroup(String p) {
        switch (p.hashCode()) {
            case -2062386608:
                return !p.equals("android.permission.READ_SMS") ? "" : "android.permission-group.SMS";
            case -1928411001:
                return !p.equals("android.permission.READ_CALENDAR") ? "" : "android.permission-group.CALENDAR";
            case -1888586689:
                return !p.equals("android.permission.ACCESS_FINE_LOCATION") ? "" : "android.permission-group.LOCATION";
            case -1748812559:
                return !p.equals("android.permission.ACCESS_UCE_OPTIONS_SERVICE") ? "" : "android.permission-group.PHONE";
            case -1674700861:
                return !p.equals("android.permission.ANSWER_PHONE_CALLS") ? "" : "android.permission-group.PHONE";
            case -1479758289:
                return !p.equals("android.permission.RECEIVE_WAP_PUSH") ? "" : "android.permission-group.SMS";
            case -1238066820:
                return !p.equals("android.permission.BODY_SENSORS") ? "" : "android.permission-group.SENSORS";
            case -1164582768:
                return !p.equals("android.permission.READ_PHONE_NUMBERS") ? "" : "android.permission-group.PHONE";
            case -895679497:
                return !p.equals("android.permission.RECEIVE_MMS") ? "" : "android.permission-group.SMS";
            case -895673731:
                return !p.equals("android.permission.RECEIVE_SMS") ? "" : "android.permission-group.SMS";
            case -406040016:
                return !p.equals("android.permission.READ_EXTERNAL_STORAGE") ? "" : "android.permission-group.STORAGE";
            case -63024214:
                return !p.equals("android.permission.ACCESS_COARSE_LOCATION") ? "" : "android.permission-group.LOCATION";
            case -5573545:
                return !p.equals("android.permission.READ_PHONE_STATE") ? "" : "android.permission-group.PHONE";
            case 52602690:
                return !p.equals("android.permission.SEND_SMS") ? "" : "android.permission-group.SMS";
            case 112197485:
                return !p.equals("android.permission.CALL_PHONE") ? "" : "android.permission-group.PHONE";
            case 214526995:
                return !p.equals("android.permission.WRITE_CONTACTS") ? "" : "android.permission-group.CONTACTS";
            case 391491540:
                return !p.equals("android.permission.ACCESS_UCE_PRESENCE_SERVICE") ? "" : "android.permission-group.PHONE";
            case 441496538:
                return !p.equals("android.permission.ACCEPT_HANDOVER") ? "" : "android.permission-group.PHONE";
            case 463403621:
                return !p.equals("android.permission.CAMERA") ? "" : "android.permission-group.CAMERA";
            case 603653886:
                return !p.equals("android.permission.WRITE_CALENDAR") ? "" : "android.permission-group.CALENDAR";
            case 754296492:
                return !p.equals("android.permission.USE_FINGERPRINT") ? "" : "android.permission-group.SENSORS";
            case 784519842:
                return !p.equals("android.permission.USE_SIP") ? "" : "android.permission-group.PHONE";
            case 958655846:
                return !p.equals("android.permission.READ_CELL_BROADCASTS") ? "" : "android.permission-group.SMS";
            case 1271781903:
                return !p.equals("android.permission.GET_ACCOUNTS") ? "" : "android.permission-group.CONTACTS";
            case 1365911975:
                return !p.equals("android.permission.WRITE_EXTERNAL_STORAGE") ? "" : "android.permission-group.STORAGE";
            case 1702240384:
                return !p.equals("android.permission.USE_BIOMETRIC") ? "" : "android.permission-group.SENSORS";
            case 1831139720:
                return !p.equals("android.permission.RECORD_AUDIO") ? "" : "android.permission-group.MICROPHONE";
            case 1977429404:
                return !p.equals("android.permission.READ_CONTACTS") ? "" : "android.permission-group.CONTACTS";
            default:
                return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void resetUI() {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.permission.CheckPermissionLayoutV2.resetUI():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetUI$lambda$0(CheckPermissionLayoutV2 checkPermissionLayoutV2, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        checkPermissionLayoutV2.finish();
        return Unit.INSTANCE;
    }

    public final void finish() {
        OnFinishedListener onFinishedListener = this.finishedListener;
        if (onFinishedListener != null) {
            onFinishedListener.onFinished();
        }
    }

    public final String getCommonContentsStr(String commonName, int index) {
        String string;
        Intrinsics.checkNotNullParameter(commonName, "commonName");
        ArrayList arrayList = new ArrayList();
        String str = "";
        if (Intrinsics.areEqual(commonName, "Common")) {
            Resource resource = Resource.INSTANCE;
            string = resource.getString("hive_permission_common_title");
            if (string == null) {
                string = "";
            }
            String string2 = resource.getString("hive_permission_common_desc");
            if (string2 != null) {
                str = string2;
            }
        } else {
            string = "";
        }
        arrayList.add(string);
        arrayList.add(str);
        Object obj = arrayList.get(index);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (String) obj;
    }

    public final ArrayList<String> getCommonList() {
        return this.commonList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0106 A[PHI: r1 r5
  0x0106: PHI (r1v45 java.lang.String) = 
  (r1v6 java.lang.String)
  (r1v12 java.lang.String)
  (r1v18 java.lang.String)
  (r1v24 java.lang.String)
  (r1v30 java.lang.String)
  (r1v36 java.lang.String)
  (r1v42 java.lang.String)
  (r1v50 java.lang.String)
 binds: [B:75:0x0103, B:66:0x00e6, B:57:0x00c9, B:48:0x00ac, B:39:0x008d, B:30:0x006e, B:21:0x004f, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]
  0x0106: PHI (r5v24 java.lang.String) = 
  (r5v3 java.lang.String)
  (r5v6 java.lang.String)
  (r5v9 java.lang.String)
  (r5v12 java.lang.String)
  (r5v15 java.lang.String)
  (r5v18 java.lang.String)
  (r5v21 java.lang.String)
  (r5v27 java.lang.String)
 binds: [B:75:0x0103, B:66:0x00e6, B:57:0x00c9, B:48:0x00ac, B:39:0x008d, B:30:0x006e, B:21:0x004f, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getContentsStr(java.lang.String r5, int r6) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.permission.CheckPermissionLayoutV2.getContentsStr(java.lang.String, int):java.lang.String");
    }

    public final ArrayList<String> getPermissionList() {
        return this.permissionList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Permission.PermissionCategory getPermissionViewCategory(String permissionName) {
        if (permissionName == null) {
            return Permission.PermissionCategory.Other;
        }
        switch (permissionName.hashCode()) {
            case -1639857183:
                if (permissionName.equals("android.permission-group.CONTACTS")) {
                    return Permission.PermissionCategory.Contacts;
                }
                break;
            case -1410061184:
                if (permissionName.equals("android.permission-group.PHONE")) {
                    return Permission.PermissionCategory.Phone;
                }
                break;
            case -1140935117:
                if (permissionName.equals("android.permission-group.CAMERA")) {
                    return Permission.PermissionCategory.Camera;
                }
                break;
            case 828638019:
                if (permissionName.equals("android.permission-group.LOCATION")) {
                    return Permission.PermissionCategory.Location;
                }
                break;
            case 852078861:
                if (permissionName.equals("android.permission-group.STORAGE")) {
                    return Permission.PermissionCategory.Storage;
                }
                break;
            case 1581272376:
                if (permissionName.equals("android.permission-group.MICROPHONE")) {
                    return Permission.PermissionCategory.Microphone;
                }
                break;
            case 2024019467:
                if (permissionName.equals("Common")) {
                    return Permission.PermissionCategory.Common;
                }
                break;
        }
        return Permission.PermissionCategory.Other;
    }

    public final String getTitleStr() {
        String string = Resource.INSTANCE.getString("hive_permission_ui_title");
        return string == null ? "" : string;
    }

    public final void onBackKeyDown() {
        finish();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        View viewInflate = View.inflate(this.activity, getContext().getResources().getIdentifier("hive_permission_popup", TtmlNode.TAG_LAYOUT, getContext().getPackageName()), this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate;
        this.rootView = relativeLayout2;
        this.activity.setContentView(relativeLayout2);
        resetUI();
    }

    public final void release() {
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckPermissionLayoutV2(Activity activity, OnFinishedListener onFinishedListener) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.finishedListener = onFinishedListener;
        this.permissionList = new ArrayList<>();
        this.commonList = new ArrayList<>();
        this.textViewArr = new ArrayList<>();
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.mContext = applicationContext;
        if (onFinishedListener != null) {
            View viewInflate = View.inflate(activity, getContext().getResources().getIdentifier("hive_permission_popup", TtmlNode.TAG_LAYOUT, getContext().getPackageName()), this);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
            this.rootView = relativeLayout;
            activity.setContentView(relativeLayout);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            checkPermissionGroupAndroidQ(activity);
        } else {
            checkPermissionGroup(activity);
        }
        if (onFinishedListener != null) {
            this.textViewArr = new ArrayList<>();
            resetUI();
        }
    }

    public final String getTitleStr(Resources res) {
        Intrinsics.checkNotNullParameter(res, "res");
        String string = res.getString(this.mContext.getResources().getIdentifier("hive_permission_ui_title", TypedValues.Custom.S_STRING, this.mContext.getPackageName()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String getCommonContentsStr(Resources res, String commonName, int index) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(commonName, "commonName");
        ArrayList arrayList = new ArrayList();
        if (!Intrinsics.areEqual(commonName, "Common")) {
            string = "";
            string2 = "";
        } else {
            string = res.getString(getContext().getResources().getIdentifier("hive_permission_common_title", TypedValues.Custom.S_STRING, getContext().getPackageName()));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            string2 = res.getString(getContext().getResources().getIdentifier("hive_permission_common_desc", TypedValues.Custom.S_STRING, getContext().getPackageName()));
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        }
        arrayList.add(string);
        arrayList.add(string2);
        Object obj = arrayList.get(index);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (String) obj;
    }

    public /* synthetic */ CheckPermissionLayoutV2(Activity activity, OnFinishedListener onFinishedListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i & 2) != 0 ? null : onFinishedListener);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getContentsStr(android.content.res.Resources r7, java.lang.String r8, int r9) {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.permission.CheckPermissionLayoutV2.getContentsStr(android.content.res.Resources, java.lang.String, int):java.lang.String");
    }
}
