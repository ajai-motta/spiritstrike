package com.hive.iapv4.repayment.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.iapv4.repayment.R;
import com.hive.iapv4.repayment.ui.RepaymentItemViewAdapter;
import com.hive.iapv4.repayment.ui.model.RepaymentItem;
import com.hive.iapv4.repayment.ui.model.RepaymentListener;
import com.hive.iapv4.repayment.ui.model.RepaymentState;
import com.hive.iapv4.repayment.ui.source.RepaymentSource;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepaymentItemViewAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/hive/iapv4/repayment/ui/RepaymentItemViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/hive/iapv4/repayment/ui/RepaymentItemViewAdapter$RepaymentItemViewHolder;", "activity", "Landroid/app/Activity;", "dataSource", "Lcom/hive/iapv4/repayment/ui/source/RepaymentSource;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/iapv4/repayment/ui/model/RepaymentListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/iapv4/repayment/ui/source/RepaymentSource;Lcom/hive/iapv4/repayment/ui/model/RepaymentListener;)V", "getListener", "()Lcom/hive/iapv4/repayment/ui/model/RepaymentListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "RepaymentItemViewHolder", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RepaymentItemViewAdapter extends RecyclerView.Adapter<RepaymentItemViewHolder> {
    private final Activity activity;
    private final RepaymentSource dataSource;
    private final RepaymentListener listener;

    /* JADX INFO: compiled from: RepaymentItemViewAdapter.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RepaymentState.values().length];
            try {
                iArr[RepaymentState.Require.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RepaymentState.Complete.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RepaymentState.Impossible.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final RepaymentListener getListener() {
        return this.listener;
    }

    public RepaymentItemViewAdapter(Activity activity, RepaymentSource dataSource, RepaymentListener repaymentListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.activity = activity;
        this.dataSource = dataSource;
        this.listener = repaymentListener;
    }

    /* JADX INFO: compiled from: RepaymentItemViewAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/hive/iapv4/repayment/ui/RepaymentItemViewAdapter$RepaymentItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/hive/iapv4/repayment/ui/RepaymentItemViewAdapter;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "refundTime", "getRefundTime", "button", "getButton", "item", "Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;", "getItem", "()Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;", "setItem", "(Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;)V", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RepaymentItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView button;
        private RepaymentItem item;
        private final TextView refundTime;
        final /* synthetic */ RepaymentItemViewAdapter this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RepaymentItemViewHolder(final RepaymentItemViewAdapter repaymentItemViewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = repaymentItemViewAdapter;
            View viewFindViewById = itemView.findViewById(R.id.hive_repayment_rectangle_2_item_title);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.hive_repayment_rectangle_2_item_refund_time);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.refundTime = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.hive_repayment_rectangle_2_item_button);
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewFindViewById3;
            TouchEffectKt.setTouchEffect(textView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.iapv4.repayment.ui.RepaymentItemViewAdapter$RepaymentItemViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RepaymentItemViewAdapter.RepaymentItemViewHolder.button$lambda$2$lambda$1(this.f$0, repaymentItemViewAdapter, (View) obj);
                }
            } : null);
            this.button = textView;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final TextView getRefundTime() {
            return this.refundTime;
        }

        public final TextView getButton() {
            return this.button;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit button$lambda$2$lambda$1(RepaymentItemViewHolder repaymentItemViewHolder, RepaymentItemViewAdapter repaymentItemViewAdapter, View it) {
            RepaymentListener listener;
            Intrinsics.checkNotNullParameter(it, "it");
            RepaymentItem repaymentItem = repaymentItemViewHolder.item;
            if (repaymentItem != null && (listener = repaymentItemViewAdapter.getListener()) != null) {
                listener.onRepayment(repaymentItem);
            }
            return Unit.INSTANCE;
        }

        public final RepaymentItem getItem() {
            return this.item;
        }

        public final void setItem(RepaymentItem repaymentItem) {
            this.item = repaymentItem;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RepaymentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hive_repayment_rectangle_2_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new RepaymentItemViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RepaymentItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.dataSource.getSortedList().get(position).getMarketId() == this.dataSource.getSelectedMarketId()) {
            String title = this.dataSource.getSortedList().get(position).getTitle();
            String refundTime = this.dataSource.getSortedList().get(position).getRefundTime();
            holder.getTitle().setVisibility(0);
            holder.getTitle().setText(title);
            holder.getRefundTime().setVisibility(0);
            holder.getRefundTime().setText(refundTime);
            int i = WhenMappings.$EnumSwitchMapping$0[this.dataSource.getSortedList().get(position).getState().ordinal()];
            if (i == 1) {
                holder.getButton().setEnabled(true);
                Activity activity = this.activity;
                TypedValue typedValue = new TypedValue();
                this.activity.getTheme().resolveAttribute(com.hive.ui.R.attr.hiveDefaultPopupMainButton, typedValue, true);
                holder.getButton().setBackground(ContextCompat.getDrawable(activity, typedValue.resourceId));
                Activity activity2 = this.activity;
                TypedValue typedValue2 = new TypedValue();
                this.activity.getTheme().resolveAttribute(com.hive.ui.R.attr.commonWhite, typedValue2, true);
                holder.getButton().setTextColor(ContextCompat.getColor(activity2, typedValue2.resourceId));
                holder.getButton().setText(this.dataSource.getSortedList().get(position).getDisplayPrice() + '\n' + this.activity.getString(R.string.hive_repayment_repayment));
            } else if (i == 2) {
                holder.getButton().setEnabled(false);
                Activity activity3 = this.activity;
                TypedValue typedValue3 = new TypedValue();
                this.activity.getTheme().resolveAttribute(com.hive.ui.R.attr.hiveDefaultPopupSubDisableButton, typedValue3, true);
                holder.getButton().setBackground(ContextCompat.getDrawable(activity3, typedValue3.resourceId));
                Activity activity4 = this.activity;
                TypedValue typedValue4 = new TypedValue();
                this.activity.getTheme().resolveAttribute(com.hive.ui.R.attr.fontPopupSub, typedValue4, true);
                holder.getButton().setTextColor(ContextCompat.getColor(activity4, typedValue4.resourceId));
                String string = this.activity.getString(R.string.hive_repayment_repayment_complete);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                holder.getButton().setText(string);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                holder.getButton().setEnabled(false);
                Activity activity5 = this.activity;
                TypedValue typedValue5 = new TypedValue();
                this.activity.getTheme().resolveAttribute(com.hive.ui.R.attr.hiveDefaultPopupSubDisableButton, typedValue5, true);
                holder.getButton().setBackground(ContextCompat.getDrawable(activity5, typedValue5.resourceId));
                Activity activity6 = this.activity;
                TypedValue typedValue6 = new TypedValue();
                this.activity.getTheme().resolveAttribute(R.attr.com_hive_repayment_item_non_payable_product_font, typedValue6, true);
                holder.getButton().setTextColor(ContextCompat.getColor(activity6, typedValue6.resourceId));
                String string2 = this.activity.getString(R.string.hive_repayment_non_payable_product);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                holder.getButton().setText(string2);
            }
        } else {
            holder.getTitle().setVisibility(8);
            holder.getRefundTime().setVisibility(8);
            holder.getButton().setEnabled(false);
            Activity activity7 = this.activity;
            TypedValue typedValue7 = new TypedValue();
            this.activity.getTheme().resolveAttribute(com.hive.ui.R.attr.hiveDefaultPopupSubDisableButton, typedValue7, true);
            holder.getButton().setBackground(ContextCompat.getDrawable(activity7, typedValue7.resourceId));
            Activity activity8 = this.activity;
            TypedValue typedValue8 = new TypedValue();
            this.activity.getTheme().resolveAttribute(com.hive.ui.R.attr.fontPopupMain, typedValue8, true);
            holder.getButton().setTextColor(ContextCompat.getColor(activity8, typedValue8.resourceId));
            StringBuilder sb = new StringBuilder();
            sb.append(this.dataSource.getSortedList().get(position).getMarketName());
            sb.append(" (");
            RepaymentSource repaymentSource = this.dataSource;
            sb.append(repaymentSource.getRemainCount(repaymentSource.getSortedList().get(position).getMarketId()));
            sb.append(' ');
            sb.append(this.activity.getString(R.string.hive_repayment_cases));
            sb.append(')');
            holder.getButton().setText(sb.toString());
        }
        holder.setItem(this.dataSource.getSortedList().get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataSource.getSortedList().size();
    }
}
