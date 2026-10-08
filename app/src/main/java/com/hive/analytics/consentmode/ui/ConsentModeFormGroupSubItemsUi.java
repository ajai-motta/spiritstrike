package com.hive.analytics.consentmode.ui;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.analytics.consentmode.R;
import com.hive.analytics.consentmode.databinding.HiveConsentModeFormGroupItemBinding;
import com.hive.analytics.consentmode.ui.ConsentModeFormGroupSubItemsUi;
import com.hive.analytics.consentmode.ui.ConsentModeFormUi;
import com.hive.analytics.consentmode.ui.model.ConsentFormUiModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentModeFormGroupSubItemsUi.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J&\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeFormGroupSubItemsUi;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/hive/analytics/consentmode/ui/ConsentModeFormGroupSubItemsUi$ItemHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi$OnItemClickedListener;", "<init>", "(Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi$OnItemClickedListener;)V", FirebaseAnalytics.Param.ITEMS, "", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Item;", "parentPosition", "", "isEnabled", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "updateItems", "newItems", "ItemHolder", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConsentModeFormGroupSubItemsUi extends RecyclerView.Adapter<ItemHolder> {
    private boolean isEnabled;
    private List<ConsentFormUiModel.Item> items;
    private final ConsentModeFormUi.OnItemClickedListener listener;
    private int parentPosition;

    public ConsentModeFormGroupSubItemsUi() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ConsentModeFormGroupSubItemsUi(ConsentModeFormUi.OnItemClickedListener onItemClickedListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : onItemClickedListener);
    }

    public ConsentModeFormGroupSubItemsUi(ConsentModeFormUi.OnItemClickedListener onItemClickedListener) {
        this.listener = onItemClickedListener;
        this.items = new ArrayList();
    }

    /* JADX INFO: compiled from: ConsentModeFormGroupSubItemsUi.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeFormGroupSubItemsUi$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/hive/analytics/consentmode/databinding/HiveConsentModeFormGroupItemBinding;", "<init>", "(Lcom/hive/analytics/consentmode/ui/ConsentModeFormGroupSubItemsUi;Lcom/hive/analytics/consentmode/databinding/HiveConsentModeFormGroupItemBinding;)V", "bind", "", "item", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Item;", "updateUiState", "isChecked", "", "isEnabled", "setDrawable", "view", "Landroidx/appcompat/widget/AppCompatImageView;", "attrResId", "", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ItemHolder extends RecyclerView.ViewHolder {
        private final HiveConsentModeFormGroupItemBinding binding;
        final /* synthetic */ ConsentModeFormGroupSubItemsUi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHolder(final ConsentModeFormGroupSubItemsUi consentModeFormGroupSubItemsUi, HiveConsentModeFormGroupItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = consentModeFormGroupSubItemsUi;
            this.binding = binding;
            binding.hiveConsentModeFormGroupItemBtnCheck.setOnClickListener(new View.OnClickListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormGroupSubItemsUi$ItemHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConsentModeFormGroupSubItemsUi.ItemHolder._init_$lambda$0(consentModeFormGroupSubItemsUi, this, view);
                }
            });
            binding.hiveConsentModeFormGroupItemTitle.setOnClickListener(new View.OnClickListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormGroupSubItemsUi$ItemHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConsentModeFormGroupSubItemsUi.ItemHolder._init_$lambda$1(consentModeFormGroupSubItemsUi, this, view);
                }
            });
            binding.hiveConsentModeFormGroupItemBtnMeatball.setOnClickListener(new View.OnClickListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormGroupSubItemsUi$ItemHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConsentModeFormGroupSubItemsUi.ItemHolder._init_$lambda$2(consentModeFormGroupSubItemsUi, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(ConsentModeFormGroupSubItemsUi consentModeFormGroupSubItemsUi, ItemHolder itemHolder, View view) {
            int absoluteAdapterPosition;
            ConsentModeFormUi.OnItemClickedListener onItemClickedListener;
            if (!consentModeFormGroupSubItemsUi.isEnabled || (absoluteAdapterPosition = itemHolder.getAbsoluteAdapterPosition()) == -1 || (onItemClickedListener = consentModeFormGroupSubItemsUi.listener) == null) {
                return;
            }
            onItemClickedListener.onCheckSubItem(consentModeFormGroupSubItemsUi.parentPosition, absoluteAdapterPosition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$1(ConsentModeFormGroupSubItemsUi consentModeFormGroupSubItemsUi, ItemHolder itemHolder, View view) {
            int absoluteAdapterPosition;
            ConsentModeFormUi.OnItemClickedListener onItemClickedListener;
            if (!consentModeFormGroupSubItemsUi.isEnabled || (absoluteAdapterPosition = itemHolder.getAbsoluteAdapterPosition()) == -1 || (onItemClickedListener = consentModeFormGroupSubItemsUi.listener) == null) {
                return;
            }
            onItemClickedListener.onCheckSubItem(consentModeFormGroupSubItemsUi.parentPosition, absoluteAdapterPosition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$2(ConsentModeFormGroupSubItemsUi consentModeFormGroupSubItemsUi, ItemHolder itemHolder, View view) {
            int absoluteAdapterPosition;
            ConsentModeFormUi.OnItemClickedListener onItemClickedListener;
            if (!consentModeFormGroupSubItemsUi.isEnabled || (absoluteAdapterPosition = itemHolder.getAbsoluteAdapterPosition()) == -1 || (onItemClickedListener = consentModeFormGroupSubItemsUi.listener) == null) {
                return;
            }
            onItemClickedListener.onDetailSubItem(consentModeFormGroupSubItemsUi.parentPosition, absoluteAdapterPosition);
        }

        public final void bind(ConsentFormUiModel.Item item) {
            Intrinsics.checkNotNullParameter(item, "item");
            HiveConsentModeFormGroupItemBinding hiveConsentModeFormGroupItemBinding = this.binding;
            ConsentModeFormGroupSubItemsUi consentModeFormGroupSubItemsUi = this.this$0;
            hiveConsentModeFormGroupItemBinding.hiveConsentModeFormGroupItemTitle.setText(item.getTitle());
            updateUiState(item.getIsChecked(), consentModeFormGroupSubItemsUi.isEnabled);
        }

        private final void updateUiState(boolean isChecked, boolean isEnabled) {
            HiveConsentModeFormGroupItemBinding hiveConsentModeFormGroupItemBinding = this.binding;
            float f = isEnabled ? 1.0f : 0.6f;
            hiveConsentModeFormGroupItemBinding.hiveConsentModeFormGroupItemBtnCheck.setAlpha(f);
            hiveConsentModeFormGroupItemBinding.hiveConsentModeFormGroupItemTitle.setAlpha(f);
            hiveConsentModeFormGroupItemBinding.hiveConsentModeFormGroupItemBtnMeatball.setAlpha(f);
            if (isEnabled) {
                AppCompatImageView hiveConsentModeFormGroupItemBtnMeatball = hiveConsentModeFormGroupItemBinding.hiveConsentModeFormGroupItemBtnMeatball;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupItemBtnMeatball, "hiveConsentModeFormGroupItemBtnMeatball");
                setDrawable(hiveConsentModeFormGroupItemBtnMeatball, R.attr.hiveConsentModeButtonMeatball);
            } else {
                AppCompatImageView hiveConsentModeFormGroupItemBtnMeatball2 = hiveConsentModeFormGroupItemBinding.hiveConsentModeFormGroupItemBtnMeatball;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupItemBtnMeatball2, "hiveConsentModeFormGroupItemBtnMeatball");
                setDrawable(hiveConsentModeFormGroupItemBtnMeatball2, R.attr.hiveConsentModeButtonMeatballDisable);
            }
            if (isChecked) {
                AppCompatImageView hiveConsentModeFormGroupItemBtnCheck = hiveConsentModeFormGroupItemBinding.hiveConsentModeFormGroupItemBtnCheck;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupItemBtnCheck, "hiveConsentModeFormGroupItemBtnCheck");
                setDrawable(hiveConsentModeFormGroupItemBtnCheck, R.attr.hiveConsentModeButtonCheckOn);
            } else {
                AppCompatImageView hiveConsentModeFormGroupItemBtnCheck2 = hiveConsentModeFormGroupItemBinding.hiveConsentModeFormGroupItemBtnCheck;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupItemBtnCheck2, "hiveConsentModeFormGroupItemBtnCheck");
                setDrawable(hiveConsentModeFormGroupItemBtnCheck2, R.attr.hiveConsentModeButtonCheckOff);
            }
        }

        private final void setDrawable(AppCompatImageView view, int attrResId) {
            Context context = view.getContext();
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(attrResId, typedValue, true);
            view.setImageDrawable(ContextCompat.getDrawable(context, typedValue.resourceId));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        HiveConsentModeFormGroupItemBinding hiveConsentModeFormGroupItemBindingInflate = HiveConsentModeFormGroupItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupItemBindingInflate, "inflate(...)");
        return new ItemHolder(this, hiveConsentModeFormGroupItemBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ItemHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void updateItems(List<ConsentFormUiModel.Item> newItems, int parentPosition, boolean isEnabled) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        this.parentPosition = parentPosition;
        this.isEnabled = isEnabled;
        notifyDataSetChanged();
    }
}
