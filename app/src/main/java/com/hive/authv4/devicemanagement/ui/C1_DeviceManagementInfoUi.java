package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.model.DeviceInfo;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnManagementInfoListener;
import com.hive.core.HiveContext;
import com.hive.core.Logger;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: C1_DeviceManagementInfoUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001*B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0018J\b\u0010\u0019\u001a\u00020\u0015H\u0017J\u0014\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\bJ\u001a\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "hiddenPhoneNumberText", "", "deviceInfoList", "", "Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "seq", "maxDeviceCount", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getDeviceInfoList$hive_authv4_device_management_release", "()Ljava/util/List;", "getSeq$hive_authv4_device_management_release", "()Ljava/lang/String;", "itemAdapter", "Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi_ItemAdapter;", "show", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "Lcom/hive/authv4/devicemanagement/ui/model/OnManagementInfoListener;", "refresh", "setDeviceInfoList", "newList", "setChanged", "deviceInfo", "errorCode", "setDelete", "onActive", "onCancel", "onEdit", "onDelete", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "", "LayoutManager", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C1_DeviceManagementInfoUi extends A0_BaseDeviceManagementUi {
    private final List<DeviceInfo> deviceInfoList;
    private final String hiddenPhoneNumberText;
    private C1_DeviceManagementInfoUi_ItemAdapter itemAdapter;
    private final int maxDeviceCount;
    private final String seq;

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    @Deprecated(message = "Override function", replaceWith = @ReplaceWith(expression = "show(listener: OnManagementInfoListener?)", imports = {}))
    public void show(OnBaseButtonListener listener) {
    }

    public final List<DeviceInfo> getDeviceInfoList$hive_authv4_device_management_release() {
        return this.deviceInfoList;
    }

    /* JADX INFO: renamed from: getSeq$hive_authv4_device_management_release, reason: from getter */
    public final String getSeq() {
        return this.seq;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1_DeviceManagementInfoUi(Activity parentActivity, String hiddenPhoneNumberText, List<DeviceInfo> deviceInfoList, String str, int i) {
        super(parentActivity, R.layout.hive_device_management_c1_device_management_info);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(hiddenPhoneNumberText, "hiddenPhoneNumberText");
        Intrinsics.checkNotNullParameter(deviceInfoList, "deviceInfoList");
        this.hiddenPhoneNumberText = hiddenPhoneNumberText;
        this.deviceInfoList = deviceInfoList;
        this.seq = str;
        this.maxDeviceCount = i;
    }

    public final void show(OnManagementInfoListener listener) {
        super.show((OnBaseButtonListener) listener);
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void refresh() {
        Activity launchActivity;
        super.refresh();
        if (!getIsShowing() || (launchActivity = getLaunchActivity()) == null) {
            return;
        }
        launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C1_DeviceManagementInfoUi.refresh$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$0(C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi) {
        C1_DeviceManagementInfoUi_ItemAdapter c1_DeviceManagementInfoUi_ItemAdapter = c1_DeviceManagementInfoUi.itemAdapter;
        if (c1_DeviceManagementInfoUi_ItemAdapter != null) {
            if (c1_DeviceManagementInfoUi_ItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                c1_DeviceManagementInfoUi_ItemAdapter = null;
            }
            c1_DeviceManagementInfoUi_ItemAdapter.notifyDataSetChanged();
        }
    }

    public final void setDeviceInfoList(List<DeviceInfo> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.deviceInfoList.clear();
        this.deviceInfoList.addAll(newList);
        refresh();
    }

    public static /* synthetic */ void setChanged$default(C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi, DeviceInfo deviceInfo, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        c1_DeviceManagementInfoUi.setChanged(deviceInfo, str);
    }

    public final void setChanged(DeviceInfo deviceInfo, String errorCode) {
        Activity launchActivity;
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        String str = errorCode;
        if (str == null || StringsKt.isBlank(str)) {
            final int iIndexOf = this.deviceInfoList.indexOf(deviceInfo);
            if (iIndexOf != -1) {
                this.deviceInfoList.set(iIndexOf, deviceInfo);
                if (!getIsShowing() || (launchActivity = getLaunchActivity()) == null) {
                    return;
                }
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C1_DeviceManagementInfoUi.setChanged$lambda$1(this.f$0, iIndexOf);
                    }
                });
                return;
            }
            Logger.INSTANCE.w("[" + getTag() + "] setChanged, is not work");
            return;
        }
        Activity launchActivity2 = getLaunchActivity();
        if (launchActivity2 != null) {
            A0_BaseDeviceManagementUi.show$default(new C6_ChangeNameErrorGuideUi(launchActivity2, errorCode), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setChanged$lambda$1(C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi, int i) {
        C1_DeviceManagementInfoUi_ItemAdapter c1_DeviceManagementInfoUi_ItemAdapter = c1_DeviceManagementInfoUi.itemAdapter;
        if (c1_DeviceManagementInfoUi_ItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
            c1_DeviceManagementInfoUi_ItemAdapter = null;
        }
        c1_DeviceManagementInfoUi_ItemAdapter.notifyItemChanged(i);
    }

    public static /* synthetic */ void setDelete$default(C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi, DeviceInfo deviceInfo, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        c1_DeviceManagementInfoUi.setDelete(deviceInfo, str);
    }

    public final void setDelete(DeviceInfo deviceInfo, String errorCode) {
        Activity launchActivity;
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        String str = errorCode;
        if (str == null || StringsKt.isBlank(str)) {
            final int iIndexOf = this.deviceInfoList.indexOf(deviceInfo);
            if (iIndexOf != -1) {
                this.deviceInfoList.remove(iIndexOf);
                if (!getIsShowing() || (launchActivity = getLaunchActivity()) == null) {
                    return;
                }
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C1_DeviceManagementInfoUi.setDelete$lambda$3(this.f$0, iIndexOf);
                    }
                });
                return;
            }
            Logger.INSTANCE.w("[" + getTag() + "] setDelete, is not work");
            return;
        }
        Activity launchActivity2 = getLaunchActivity();
        if (launchActivity2 != null) {
            A0_BaseDeviceManagementUi.show$default(new C4_DeleteErrorGuideUi(launchActivity2, errorCode), null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDelete$lambda$3(C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi, int i) {
        C1_DeviceManagementInfoUi_ItemAdapter c1_DeviceManagementInfoUi_ItemAdapter = c1_DeviceManagementInfoUi.itemAdapter;
        if (c1_DeviceManagementInfoUi_ItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
            c1_DeviceManagementInfoUi_ItemAdapter = null;
        }
        c1_DeviceManagementInfoUi_ItemAdapter.notifyItemRemoved(i);
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void onActive() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                C1_DeviceManagementInfoUi.onActive$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$6(C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi) {
        OnBaseButtonListener listener = c1_DeviceManagementInfoUi.getListener();
        if (listener != null) {
            OnBaseButtonListener.DefaultImpls.onActive$default(listener, null, 1, null);
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void onCancel() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C1_DeviceManagementInfoUi.onCancel$lambda$7(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCancel$lambda$7(C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi) {
        OnBaseButtonListener listener = c1_DeviceManagementInfoUi.getListener();
        if (listener != null) {
            listener.onCancel();
        }
    }

    public final void onEdit(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            C5_ChangeNameUi c5_ChangeNameUi = new C5_ChangeNameUi(launchActivity, deviceInfo.getDeviceName());
            c5_ChangeNameUi.show(new C1_DeviceManagementInfoUi$onEdit$1$1$1(deviceInfo, c5_ChangeNameUi, this));
        }
    }

    public final void onDelete(DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            if (this.deviceInfoList.size() <= 1) {
                A0_BaseDeviceManagementUi.show$default(new C15_LastDeleteGuideUi(launchActivity), null, 1, null);
            } else {
                C2_DeleteGuideUi c2_DeleteGuideUi = new C2_DeleteGuideUi(launchActivity);
                c2_DeleteGuideUi.show(new C1_DeviceManagementInfoUi$onDelete$1$1$1(c2_DeleteGuideUi, this, deviceInfo));
            }
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_device_management_info_recycler_view);
        RecyclerView recyclerView = viewFindViewById instanceof RecyclerView ? (RecyclerView) viewFindViewById : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LayoutManager(activity));
            C1_DeviceManagementInfoUi_ItemAdapter c1_DeviceManagementInfoUi_ItemAdapter = new C1_DeviceManagementInfoUi_ItemAdapter(activity, this);
            this.itemAdapter = c1_DeviceManagementInfoUi_ItemAdapter;
            recyclerView.setAdapter(c1_DeviceManagementInfoUi_ItemAdapter);
        }
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_text_1);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById2).setText(HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_95, Integer.valueOf(this.maxDeviceCount)));
        View viewFindViewById3 = activity.findViewById(R.id.hive_device_management_text_2);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById3).setText(HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_96, Integer.valueOf(this.maxDeviceCount)));
        refresh();
    }

    /* JADX INFO: compiled from: C1_DeviceManagementInfoUi.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi$LayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "canScrollVertically", "", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutManager extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutManager(Activity activity) {
            super(activity);
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public boolean onBackPressed() {
        Logger.INSTANCE.d("[DeviceManagement] " + getTag() + " - onBackPressed()");
        onClose();
        return true;
    }
}
