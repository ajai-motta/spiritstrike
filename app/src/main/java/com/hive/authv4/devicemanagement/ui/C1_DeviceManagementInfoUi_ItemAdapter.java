package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi_ItemAdapter;
import com.hive.authv4.devicemanagement.ui.model.DeviceInfo;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: C1_DeviceManagementInfoUi_ItemAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi_ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi_ItemAdapter$DeviceManagementInfoItemViewHolder;", "activity", "Landroid/app/Activity;", "mgtInfo", "Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi;", "<init>", "(Landroid/app/Activity;Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "DeviceManagementInfoItemViewHolder", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C1_DeviceManagementInfoUi_ItemAdapter extends RecyclerView.Adapter<DeviceManagementInfoItemViewHolder> {
    private final Activity activity;
    private final C1_DeviceManagementInfoUi mgtInfo;

    public C1_DeviceManagementInfoUi_ItemAdapter(Activity activity, C1_DeviceManagementInfoUi mgtInfo) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mgtInfo, "mgtInfo");
        this.activity = activity;
        this.mgtInfo = mgtInfo;
    }

    /* JADX INFO: compiled from: C1_DeviceManagementInfoUi_ItemAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi_ItemAdapter$DeviceManagementInfoItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi_ItemAdapter;Landroid/view/View;)V", "connectionIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getConnectionIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "addDate", "getAddDate", "editButton", "getEditButton", "deleteButton", "getDeleteButton", "deviceInfo", "Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "getDeviceInfo", "()Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "setDeviceInfo", "(Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;)V", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DeviceManagementInfoItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView addDate;
        private final AppCompatImageView connectionIcon;
        private final AppCompatImageView deleteButton;
        private DeviceInfo deviceInfo;
        private final AppCompatImageView editButton;
        final /* synthetic */ C1_DeviceManagementInfoUi_ItemAdapter this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceManagementInfoItemViewHolder(final C1_DeviceManagementInfoUi_ItemAdapter c1_DeviceManagementInfoUi_ItemAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = c1_DeviceManagementInfoUi_ItemAdapter;
            View viewFindViewById = itemView.findViewById(R.id.hive_device_management_device_management_info_item_icon_connection);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            this.connectionIcon = (AppCompatImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.hive_device_management_device_management_info_item_title);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.title = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.hive_device_management_device_management_info_item_date);
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.addDate = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.hive_device_management_device_management_info_item_edit);
            Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            AppCompatImageView appCompatImageView = (AppCompatImageView) viewFindViewById4;
            TouchEffectKt.setTouchEffect(appCompatImageView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi_ItemAdapter$DeviceManagementInfoItemViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C1_DeviceManagementInfoUi_ItemAdapter.DeviceManagementInfoItemViewHolder.editButton$lambda$2$lambda$1(this.f$0, c1_DeviceManagementInfoUi_ItemAdapter, (View) obj);
                }
            } : null);
            this.editButton = appCompatImageView;
            View viewFindViewById5 = itemView.findViewById(R.id.hive_device_management_device_management_info_item_delete);
            Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewFindViewById5;
            TouchEffectKt.setTouchEffect(appCompatImageView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi_ItemAdapter$DeviceManagementInfoItemViewHolder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C1_DeviceManagementInfoUi_ItemAdapter.DeviceManagementInfoItemViewHolder.deleteButton$lambda$5$lambda$4(this.f$0, c1_DeviceManagementInfoUi_ItemAdapter, (View) obj);
                }
            } : null);
            this.deleteButton = appCompatImageView2;
        }

        public final AppCompatImageView getConnectionIcon() {
            return this.connectionIcon;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final TextView getAddDate() {
            return this.addDate;
        }

        public final AppCompatImageView getEditButton() {
            return this.editButton;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit editButton$lambda$2$lambda$1(DeviceManagementInfoItemViewHolder deviceManagementInfoItemViewHolder, C1_DeviceManagementInfoUi_ItemAdapter c1_DeviceManagementInfoUi_ItemAdapter, View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            DeviceInfo deviceInfo = deviceManagementInfoItemViewHolder.deviceInfo;
            if (deviceInfo != null) {
                c1_DeviceManagementInfoUi_ItemAdapter.mgtInfo.onEdit(deviceInfo);
            }
            return Unit.INSTANCE;
        }

        public final AppCompatImageView getDeleteButton() {
            return this.deleteButton;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit deleteButton$lambda$5$lambda$4(DeviceManagementInfoItemViewHolder deviceManagementInfoItemViewHolder, C1_DeviceManagementInfoUi_ItemAdapter c1_DeviceManagementInfoUi_ItemAdapter, View it) {
            Intrinsics.checkNotNullParameter(it, "it");
            DeviceInfo deviceInfo = deviceManagementInfoItemViewHolder.deviceInfo;
            if (deviceInfo != null) {
                c1_DeviceManagementInfoUi_ItemAdapter.mgtInfo.onDelete(deviceInfo);
            }
            return Unit.INSTANCE;
        }

        public final DeviceInfo getDeviceInfo() {
            return this.deviceInfo;
        }

        public final void setDeviceInfo(DeviceInfo deviceInfo) {
            this.deviceInfo = deviceInfo;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DeviceManagementInfoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hive_device_management_c1_device_management_info_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new DeviceManagementInfoItemViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DeviceManagementInfoItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (Intrinsics.areEqual(this.mgtInfo.getDeviceInfoList$hive_authv4_device_management_release().get(position).getSeq(), this.mgtInfo.getSeq())) {
            holder.getConnectionIcon().setVisibility(0);
            holder.getDeleteButton().setEnabled(false);
            Activity activity = this.activity;
            TypedValue typedValue = new TypedValue();
            this.activity.getTheme().resolveAttribute(R.attr.hiveIconDeleteInActive, typedValue, true);
            holder.getDeleteButton().setImageDrawable(ContextCompat.getDrawable(activity, typedValue.resourceId));
        } else {
            holder.getConnectionIcon().setVisibility(8);
        }
        holder.getTitle().setText(this.mgtInfo.getDeviceInfoList$hive_authv4_device_management_release().get(position).getDeviceName());
        holder.getAddDate().setText(this.mgtInfo.getDeviceInfoList$hive_authv4_device_management_release().get(position).getAddDate());
        holder.setDeviceInfo(this.mgtInfo.getDeviceInfoList$hive_authv4_device_management_release().get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mgtInfo.getDeviceInfoList$hive_authv4_device_management_release().size();
    }
}
