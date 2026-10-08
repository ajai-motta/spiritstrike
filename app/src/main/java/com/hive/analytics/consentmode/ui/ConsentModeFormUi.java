package com.hive.analytics.consentmode.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.analytics.consentmode.R;
import com.hive.analytics.consentmode.databinding.HiveConsentModeFormBinding;
import com.hive.analytics.consentmode.databinding.HiveConsentModeFormGroupBinding;
import com.hive.analytics.consentmode.ui.ConsentModeFormUi;
import com.hive.analytics.consentmode.ui.model.ConsentFormUiModel;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentModeFormUi.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0014\u0010\u0014\u001a\u00020\u0011*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "consentModeUi", "Lcom/hive/analytics/consentmode/ui/ConsentModeUi;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi$OnItemClickedListener;", "<init>", "(Lcom/hive/analytics/consentmode/ui/ConsentModeUi;Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi$OnItemClickedListener;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "setDrawable", "Landroidx/appcompat/widget/AppCompatImageView;", "attrResId", "OnItemClickedListener", "ViewType", "ItemHolder", "GroupHolder", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConsentModeFormUi extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ConsentModeUi consentModeUi;
    private final OnItemClickedListener listener;

    /* JADX INFO: compiled from: ConsentModeFormUi.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi$OnItemClickedListener;", "", "onCheck", "", "position", "", "onDetail", "onCheckSubItem", "parentPosition", "onDetailSubItem", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnItemClickedListener {
        void onCheck(int position);

        void onCheckSubItem(int parentPosition, int position);

        void onDetail(int position);

        void onDetailSubItem(int parentPosition, int position);
    }

    public /* synthetic */ ConsentModeFormUi(ConsentModeUi consentModeUi, OnItemClickedListener onItemClickedListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(consentModeUi, (i & 2) != 0 ? null : onItemClickedListener);
    }

    public ConsentModeFormUi(ConsentModeUi consentModeUi, OnItemClickedListener onItemClickedListener) {
        Intrinsics.checkNotNullParameter(consentModeUi, "consentModeUi");
        this.consentModeUi = consentModeUi;
        this.listener = onItemClickedListener;
    }

    /* JADX INFO: compiled from: ConsentModeFormUi.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi$ViewType;", "", "<init>", "()V", "ITEM", "", "GROUP", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewType {
        public static final int GROUP = 1;
        public static final ViewType INSTANCE = new ViewType();
        public static final int ITEM = 0;

        private ViewType() {
        }
    }

    /* JADX INFO: compiled from: ConsentModeFormUi.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/hive/analytics/consentmode/databinding/HiveConsentModeFormBinding;", "<init>", "(Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi;Lcom/hive/analytics/consentmode/databinding/HiveConsentModeFormBinding;)V", "isEnabled", "", "bind", "", "form", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Item;", "position", "", "updateUiState", "isChecked", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ItemHolder extends RecyclerView.ViewHolder {
        private final HiveConsentModeFormBinding binding;
        private boolean isEnabled;
        final /* synthetic */ ConsentModeFormUi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHolder(final ConsentModeFormUi consentModeFormUi, HiveConsentModeFormBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = consentModeFormUi;
            this.binding = binding;
            this.isEnabled = true;
            binding.hiveConsentModeFormDataUsageBtnCheck.setOnClickListener(new View.OnClickListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormUi$ItemHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConsentModeFormUi.ItemHolder._init_$lambda$0(this.f$0, consentModeFormUi, view);
                }
            });
            binding.hiveConsentModeFormDataUsageTitle.setOnClickListener(new View.OnClickListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormUi$ItemHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConsentModeFormUi.ItemHolder._init_$lambda$1(this.f$0, consentModeFormUi, view);
                }
            });
            AppCompatImageView hiveConsentModeFormDataUsageBtnMeatball = binding.hiveConsentModeFormDataUsageBtnMeatball;
            Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormDataUsageBtnMeatball, "hiveConsentModeFormDataUsageBtnMeatball");
            TouchEffectKt.setTouchEffect(hiveConsentModeFormDataUsageBtnMeatball, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(117, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormUi$ItemHolder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConsentModeFormUi.ItemHolder._init_$lambda$2(this.f$0, consentModeFormUi, (View) obj);
                }
            } : null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(ItemHolder itemHolder, ConsentModeFormUi consentModeFormUi, View view) {
            int absoluteAdapterPosition;
            OnItemClickedListener onItemClickedListener;
            if (!itemHolder.isEnabled || (absoluteAdapterPosition = itemHolder.getAbsoluteAdapterPosition()) == -1 || (onItemClickedListener = consentModeFormUi.listener) == null) {
                return;
            }
            onItemClickedListener.onCheck(absoluteAdapterPosition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$1(ItemHolder itemHolder, ConsentModeFormUi consentModeFormUi, View view) {
            int absoluteAdapterPosition;
            OnItemClickedListener onItemClickedListener;
            if (!itemHolder.isEnabled || (absoluteAdapterPosition = itemHolder.getAbsoluteAdapterPosition()) == -1 || (onItemClickedListener = consentModeFormUi.listener) == null) {
                return;
            }
            onItemClickedListener.onCheck(absoluteAdapterPosition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _init_$lambda$2(ItemHolder itemHolder, ConsentModeFormUi consentModeFormUi, View it) {
            OnItemClickedListener onItemClickedListener;
            Intrinsics.checkNotNullParameter(it, "it");
            if (!itemHolder.isEnabled) {
                return Unit.INSTANCE;
            }
            int absoluteAdapterPosition = itemHolder.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition != -1 && (onItemClickedListener = consentModeFormUi.listener) != null) {
                onItemClickedListener.onDetail(absoluteAdapterPosition);
            }
            return Unit.INSTANCE;
        }

        public final void bind(ConsentFormUiModel.Item form, int position) {
            Intrinsics.checkNotNullParameter(form, "form");
            this.binding.hiveConsentModeFormDataUsageTitle.setText(form.getTitle());
            this.isEnabled = form.getIsEnabled();
            updateUiState(form.getIsChecked(), form.getIsEnabled());
        }

        private final void updateUiState(boolean isChecked, boolean isEnabled) {
            HiveConsentModeFormBinding hiveConsentModeFormBinding = this.binding;
            ConsentModeFormUi consentModeFormUi = this.this$0;
            float f = isEnabled ? 1.0f : 0.6f;
            hiveConsentModeFormBinding.hiveConsentModeFormDataUsageBtnCheck.setAlpha(f);
            hiveConsentModeFormBinding.hiveConsentModeFormDataUsageTitle.setAlpha(f);
            hiveConsentModeFormBinding.hiveConsentModeFormDataUsageBtnMeatball.setAlpha(f);
            if (isEnabled) {
                AppCompatImageView hiveConsentModeFormDataUsageBtnMeatball = hiveConsentModeFormBinding.hiveConsentModeFormDataUsageBtnMeatball;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormDataUsageBtnMeatball, "hiveConsentModeFormDataUsageBtnMeatball");
                consentModeFormUi.setDrawable(hiveConsentModeFormDataUsageBtnMeatball, R.attr.hiveConsentModeButtonMeatball);
            } else {
                AppCompatImageView hiveConsentModeFormDataUsageBtnMeatball2 = hiveConsentModeFormBinding.hiveConsentModeFormDataUsageBtnMeatball;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormDataUsageBtnMeatball2, "hiveConsentModeFormDataUsageBtnMeatball");
                consentModeFormUi.setDrawable(hiveConsentModeFormDataUsageBtnMeatball2, R.attr.hiveConsentModeButtonMeatballDisable);
            }
            if (isChecked) {
                AppCompatImageView hiveConsentModeFormDataUsageBtnCheck = hiveConsentModeFormBinding.hiveConsentModeFormDataUsageBtnCheck;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormDataUsageBtnCheck, "hiveConsentModeFormDataUsageBtnCheck");
                consentModeFormUi.setDrawable(hiveConsentModeFormDataUsageBtnCheck, R.attr.hiveConsentModeButtonCheckOn);
            } else {
                AppCompatImageView hiveConsentModeFormDataUsageBtnCheck2 = hiveConsentModeFormBinding.hiveConsentModeFormDataUsageBtnCheck;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormDataUsageBtnCheck2, "hiveConsentModeFormDataUsageBtnCheck");
                consentModeFormUi.setDrawable(hiveConsentModeFormDataUsageBtnCheck2, R.attr.hiveConsentModeButtonCheckOff);
            }
        }
    }

    /* JADX INFO: compiled from: ConsentModeFormUi.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi$GroupHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/hive/analytics/consentmode/databinding/HiveConsentModeFormGroupBinding;", "<init>", "(Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi;Lcom/hive/analytics/consentmode/databinding/HiveConsentModeFormGroupBinding;)V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "subItemsUi", "Lcom/hive/analytics/consentmode/ui/ConsentModeFormGroupSubItemsUi;", "bind", "", "form", "Lcom/hive/analytics/consentmode/ui/model/ConsentFormUiModel$Group;", "position", "", "updateUiState", "isChecked", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class GroupHolder extends RecyclerView.ViewHolder {
        private final HiveConsentModeFormGroupBinding binding;
        private boolean isEnabled;
        private final ConsentModeFormGroupSubItemsUi subItemsUi;
        final /* synthetic */ ConsentModeFormUi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupHolder(final ConsentModeFormUi consentModeFormUi, HiveConsentModeFormGroupBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = consentModeFormUi;
            this.binding = binding;
            this.isEnabled = true;
            ConsentModeFormGroupSubItemsUi consentModeFormGroupSubItemsUi = new ConsentModeFormGroupSubItemsUi(consentModeFormUi.listener);
            this.subItemsUi = consentModeFormGroupSubItemsUi;
            binding.hiveConsentModeFormGroupBtnCheck.setOnClickListener(new View.OnClickListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormUi$GroupHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConsentModeFormUi.GroupHolder._init_$lambda$0(this.f$0, consentModeFormUi, view);
                }
            });
            binding.hiveConsentModeFormGroupTitle.setOnClickListener(new View.OnClickListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormUi$GroupHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConsentModeFormUi.GroupHolder._init_$lambda$1(this.f$0, consentModeFormUi, view);
                }
            });
            AppCompatImageView hiveConsentModeFormGroupBtnMeatball = binding.hiveConsentModeFormGroupBtnMeatball;
            Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupBtnMeatball, "hiveConsentModeFormGroupBtnMeatball");
            TouchEffectKt.setTouchEffect(hiveConsentModeFormGroupBtnMeatball, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormUi$GroupHolder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConsentModeFormUi.GroupHolder._init_$lambda$2(this.f$0, consentModeFormUi, (View) obj);
                }
            } : null);
            binding.hiveConsentModeFormGroupRecyclerview.setAdapter(consentModeFormGroupSubItemsUi);
            binding.hiveConsentModeFormGroupRecyclerview.setHasFixedSize(true);
            binding.hiveConsentModeFormGroupRecyclerview.setLayoutManager(new LinearLayoutManager(binding.hiveConsentModeFormGroupRecyclerview.getContext()));
        }

        /* JADX INFO: renamed from: isEnabled, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        public final void setEnabled(boolean z) {
            this.isEnabled = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(GroupHolder groupHolder, ConsentModeFormUi consentModeFormUi, View view) {
            int absoluteAdapterPosition;
            OnItemClickedListener onItemClickedListener;
            if (!groupHolder.isEnabled || (absoluteAdapterPosition = groupHolder.getAbsoluteAdapterPosition()) == -1 || (onItemClickedListener = consentModeFormUi.listener) == null) {
                return;
            }
            onItemClickedListener.onCheck(absoluteAdapterPosition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$1(GroupHolder groupHolder, ConsentModeFormUi consentModeFormUi, View view) {
            int absoluteAdapterPosition;
            OnItemClickedListener onItemClickedListener;
            if (!groupHolder.isEnabled || (absoluteAdapterPosition = groupHolder.getAbsoluteAdapterPosition()) == -1 || (onItemClickedListener = consentModeFormUi.listener) == null) {
                return;
            }
            onItemClickedListener.onCheck(absoluteAdapterPosition);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit _init_$lambda$2(GroupHolder groupHolder, ConsentModeFormUi consentModeFormUi, View it) {
            OnItemClickedListener onItemClickedListener;
            Intrinsics.checkNotNullParameter(it, "it");
            if (!groupHolder.isEnabled) {
                return Unit.INSTANCE;
            }
            int absoluteAdapterPosition = groupHolder.getAbsoluteAdapterPosition();
            if (absoluteAdapterPosition != -1 && (onItemClickedListener = consentModeFormUi.listener) != null) {
                onItemClickedListener.onDetail(absoluteAdapterPosition);
            }
            return Unit.INSTANCE;
        }

        public final void bind(ConsentFormUiModel.Group form, int position) {
            Intrinsics.checkNotNullParameter(form, "form");
            this.binding.hiveConsentModeFormGroupTitle.setText(form.getTitle());
            this.isEnabled = form.getIsEnabled();
            updateUiState(form.getIsChecked(), form.getIsEnabled());
            this.subItemsUi.updateItems(form.getSubItems(), position, form.getIsChecked());
        }

        private final void updateUiState(boolean isChecked, boolean isEnabled) {
            HiveConsentModeFormGroupBinding hiveConsentModeFormGroupBinding = this.binding;
            ConsentModeFormUi consentModeFormUi = this.this$0;
            float f = isEnabled ? 1.0f : 0.6f;
            hiveConsentModeFormGroupBinding.hiveConsentModeFormGroupBtnCheck.setAlpha(f);
            hiveConsentModeFormGroupBinding.hiveConsentModeFormGroupTitle.setAlpha(f);
            hiveConsentModeFormGroupBinding.hiveConsentModeFormGroupBtnMeatball.setAlpha(f);
            if (isEnabled) {
                AppCompatImageView hiveConsentModeFormGroupBtnMeatball = hiveConsentModeFormGroupBinding.hiveConsentModeFormGroupBtnMeatball;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupBtnMeatball, "hiveConsentModeFormGroupBtnMeatball");
                consentModeFormUi.setDrawable(hiveConsentModeFormGroupBtnMeatball, R.attr.hiveConsentModeButtonMeatball);
            } else {
                AppCompatImageView hiveConsentModeFormGroupBtnMeatball2 = hiveConsentModeFormGroupBinding.hiveConsentModeFormGroupBtnMeatball;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupBtnMeatball2, "hiveConsentModeFormGroupBtnMeatball");
                consentModeFormUi.setDrawable(hiveConsentModeFormGroupBtnMeatball2, R.attr.hiveConsentModeButtonMeatballDisable);
            }
            if (isChecked) {
                AppCompatImageView hiveConsentModeFormGroupBtnCheck = hiveConsentModeFormGroupBinding.hiveConsentModeFormGroupBtnCheck;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupBtnCheck, "hiveConsentModeFormGroupBtnCheck");
                consentModeFormUi.setDrawable(hiveConsentModeFormGroupBtnCheck, R.attr.hiveConsentModeButtonCheckOn);
            } else {
                AppCompatImageView hiveConsentModeFormGroupBtnCheck2 = hiveConsentModeFormGroupBinding.hiveConsentModeFormGroupBtnCheck;
                Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupBtnCheck2, "hiveConsentModeFormGroupBtnCheck");
                consentModeFormUi.setDrawable(hiveConsentModeFormGroupBtnCheck2, R.attr.hiveConsentModeButtonCheckOff);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ConsentFormUiModel consentFormUiModel = this.consentModeUi.getConsentModeUiModel().getFormList().get(position);
        if (consentFormUiModel instanceof ConsentFormUiModel.Item) {
            return 0;
        }
        if (consentFormUiModel instanceof ConsentFormUiModel.Group) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            HiveConsentModeFormBinding hiveConsentModeFormBindingInflate = HiveConsentModeFormBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormBindingInflate, "inflate(...)");
            return new ItemHolder(this, hiveConsentModeFormBindingInflate);
        }
        HiveConsentModeFormGroupBinding hiveConsentModeFormGroupBindingInflate = HiveConsentModeFormGroupBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(hiveConsentModeFormGroupBindingInflate, "inflate(...)");
        return new GroupHolder(this, hiveConsentModeFormGroupBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ItemHolder) {
            ConsentFormUiModel consentFormUiModel = this.consentModeUi.getConsentModeUiModel().getFormList().get(position);
            Intrinsics.checkNotNull(consentFormUiModel, "null cannot be cast to non-null type com.hive.analytics.consentmode.ui.model.ConsentFormUiModel.Item");
            ((ItemHolder) holder).bind((ConsentFormUiModel.Item) consentFormUiModel, position);
        } else if (holder instanceof GroupHolder) {
            ConsentFormUiModel consentFormUiModel2 = this.consentModeUi.getConsentModeUiModel().getFormList().get(position);
            Intrinsics.checkNotNull(consentFormUiModel2, "null cannot be cast to non-null type com.hive.analytics.consentmode.ui.model.ConsentFormUiModel.Group");
            ((GroupHolder) holder).bind((ConsentFormUiModel.Group) consentFormUiModel2, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.consentModeUi.getConsentModeUiModel().getFormList().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDrawable(AppCompatImageView appCompatImageView, int i) {
        TypedValue typedValue = new TypedValue();
        appCompatImageView.getContext().getTheme().resolveAttribute(i, typedValue, true);
        appCompatImageView.setImageDrawable(ContextCompat.getDrawable(appCompatImageView.getContext(), typedValue.resourceId));
    }
}
