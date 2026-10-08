package com.hive.analytics.consentmode.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Analytics;
import com.hive.analytics.consentmode.R;
import com.hive.analytics.consentmode.databinding.HiveConsentModeBinding;
import com.hive.analytics.consentmode.ui.ConsentModeFormUi;
import com.hive.analytics.consentmode.ui.model.ConsentFormUiModel;
import com.hive.analytics.consentmode.ui.model.ConsentModeUiModel;
import com.hive.analytics.consentmode.ui.model.OnConsentModeUiListener;
import com.hive.logger.LoggerImpl;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.hive.ui.effect.TouchEffectKt;
import com.hive.ui.view.HiveAnimationButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentModeUi.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0003J\u001a\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeUi;", "Lcom/hive/ui/OnActivityLifecycle;", "parentActivity", "Landroid/app/Activity;", "consentModeUiModel", "Lcom/hive/analytics/consentmode/ui/model/ConsentModeUiModel;", "<init>", "(Landroid/app/Activity;Lcom/hive/analytics/consentmode/ui/model/ConsentModeUiModel;)V", "getConsentModeUiModel$hive_analytics_consent_mode_release", "()Lcom/hive/analytics/consentmode/ui/model/ConsentModeUiModel;", "isShowing", "", "isRequire", "launchActivity", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/analytics/consentmode/ui/model/OnConsentModeUiListener;", "binding", "Lcom/hive/analytics/consentmode/databinding/HiveConsentModeBinding;", "itemAdapter", "Lcom/hive/analytics/consentmode/ui/ConsentModeFormUi;", "show", "", "finish", "onClickAll", "onSubmit", "onClose", "refresh", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConsentModeUi extends OnActivityLifecycle {
    private HiveConsentModeBinding binding;
    private final ConsentModeUiModel consentModeUiModel;
    private boolean isRequire;
    private boolean isShowing;
    private ConsentModeFormUi itemAdapter;
    private Activity launchActivity;
    private OnConsentModeUiListener listener;
    private final Activity parentActivity;

    /* JADX INFO: renamed from: getConsentModeUiModel$hive_analytics_consent_mode_release, reason: from getter */
    public final ConsentModeUiModel getConsentModeUiModel() {
        return this.consentModeUiModel;
    }

    public ConsentModeUi(Activity parentActivity, ConsentModeUiModel consentModeUiModel) {
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(consentModeUiModel, "consentModeUiModel");
        this.parentActivity = parentActivity;
        this.consentModeUiModel = consentModeUiModel;
    }

    public static /* synthetic */ void show$default(ConsentModeUi consentModeUi, boolean z, OnConsentModeUiListener onConsentModeUiListener, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        consentModeUi.show(z, onConsentModeUiListener);
    }

    public final void show(boolean isRequire, OnConsentModeUiListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.isRequire = isRequire;
        if (!this.isShowing) {
            this.listener = listener;
            Intent intent = new Intent();
            intent.putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "ConsentMode");
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
            HiveUiActivity.INSTANCE.launch(this.parentActivity, intent, this);
            return;
        }
        listener.onClose();
    }

    public final void finish() {
        Activity activity = this.launchActivity;
        if (activity != null) {
            activity.finish();
        }
    }

    private final void onClickAll() {
        Object next;
        if (this.consentModeUiModel.isAllChecked()) {
            this.consentModeUiModel.uncheckAll();
            this.consentModeUiModel.disableAll();
            Iterator<T> it = this.consentModeUiModel.getFormList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                String lowerCase = ((ConsentFormUiModel) next).getId().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, Analytics.CONSENT_TYPE_AD_USER_DATA)) {
                    break;
                }
            }
            ConsentFormUiModel consentFormUiModel = (ConsentFormUiModel) next;
            if (consentFormUiModel != null) {
                consentFormUiModel.setEnabled(true);
            }
        } else {
            this.consentModeUiModel.checkAll();
            this.consentModeUiModel.enableAll();
        }
        refresh();
    }

    private final void onSubmit() {
        OnConsentModeUiListener onConsentModeUiListener = this.listener;
        if (onConsentModeUiListener != null) {
            onConsentModeUiListener.onSubmit(this.consentModeUiModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClose() {
        OnConsentModeUiListener onConsentModeUiListener = this.listener;
        if (onConsentModeUiListener != null) {
            onConsentModeUiListener.onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        final Activity activity;
        if (!this.isShowing || (activity = this.launchActivity) == null) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.hive.analytics.consentmode.ui.ConsentModeUi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConsentModeUi.refresh$lambda$5$lambda$4(this.f$0, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$5$lambda$4(ConsentModeUi consentModeUi, Activity activity) {
        ConsentModeFormUi consentModeFormUi = consentModeUi.itemAdapter;
        HiveConsentModeBinding hiveConsentModeBinding = null;
        if (consentModeFormUi != null) {
            if (consentModeFormUi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                consentModeFormUi = null;
            }
            consentModeFormUi.notifyDataSetChanged();
        }
        if (consentModeUi.consentModeUiModel.isAllChecked()) {
            HiveConsentModeBinding hiveConsentModeBinding2 = consentModeUi.binding;
            if (hiveConsentModeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hiveConsentModeBinding2 = null;
            }
            hiveConsentModeBinding2.hiveConsentModeSubButton.setText(Resource.INSTANCE.getString("hive_consent_mode_text_cancel_all"));
            HiveConsentModeBinding hiveConsentModeBinding3 = consentModeUi.binding;
            if (hiveConsentModeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                hiveConsentModeBinding = hiveConsentModeBinding3;
            }
            AppCompatTextView appCompatTextView = hiveConsentModeBinding.hiveConsentModeSubButton;
            Activity activity2 = activity;
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveConsentModeCancelAllTextColor, typedValue, true);
            Unit unit = Unit.INSTANCE;
            appCompatTextView.setTextColor(ContextCompat.getColor(activity2, typedValue.resourceId));
            return;
        }
        HiveConsentModeBinding hiveConsentModeBinding4 = consentModeUi.binding;
        if (hiveConsentModeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeBinding4 = null;
        }
        hiveConsentModeBinding4.hiveConsentModeSubButton.setText(Resource.INSTANCE.getString("hive_consent_mode_text_click_all"));
        HiveConsentModeBinding hiveConsentModeBinding5 = consentModeUi.binding;
        if (hiveConsentModeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            hiveConsentModeBinding = hiveConsentModeBinding5;
        }
        AppCompatTextView appCompatTextView2 = hiveConsentModeBinding.hiveConsentModeSubButton;
        Activity activity3 = activity;
        TypedValue typedValue2 = new TypedValue();
        activity.getTheme().resolveAttribute(com.hive.ui.R.attr.commonWhite, typedValue2, true);
        Unit unit2 = Unit.INSTANCE;
        appCompatTextView2.setTextColor(ContextCompat.getColor(activity3, typedValue2.resourceId));
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.launchActivity = activity;
        this.isShowing = true;
        HiveConsentModeBinding hiveConsentModeBindingInflate = HiveConsentModeBinding.inflate(activity.getLayoutInflater());
        this.binding = hiveConsentModeBindingInflate;
        HiveConsentModeBinding hiveConsentModeBinding = null;
        if (hiveConsentModeBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeBindingInflate = null;
        }
        activity.setContentView(hiveConsentModeBindingInflate.getRoot());
        Util.INSTANCE.hideSystemUI(activity.getWindow());
        HiveConsentModeBinding hiveConsentModeBinding2 = this.binding;
        if (hiveConsentModeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeBinding2 = null;
        }
        hiveConsentModeBinding2.hiveConsentModeTitle.setText(this.consentModeUiModel.getTitle());
        HiveConsentModeBinding hiveConsentModeBinding3 = this.binding;
        if (hiveConsentModeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeBinding3 = null;
        }
        RecyclerView recyclerView = hiveConsentModeBinding3.hiveConsentModeRecyclerView;
        ConsentModeFormUi consentModeFormUi = new ConsentModeFormUi(this, new ConsentModeFormUi.OnItemClickedListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeUi$onCreate$1$1
            @Override // com.hive.analytics.consentmode.ui.ConsentModeFormUi.OnItemClickedListener
            public void onCheck(int position) {
                ConsentFormUiModel consentFormUiModel = this.this$0.getConsentModeUiModel().getFormList().get(position);
                consentFormUiModel.setChecked(!consentFormUiModel.getIsChecked());
                if (consentFormUiModel instanceof ConsentFormUiModel.Group) {
                    ConsentFormUiModel.Group group = (ConsentFormUiModel.Group) consentFormUiModel;
                    boolean isChecked = group.getIsChecked();
                    if (isChecked) {
                        group.checkSubItems();
                        group.enableSubItems();
                    } else {
                        if (isChecked) {
                            throw new NoWhenBranchMatchedException();
                        }
                        group.uncheckSubItems();
                        group.disableSubItems();
                    }
                }
                String lowerCase = consentFormUiModel.getId().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, Analytics.CONSENT_TYPE_AD_USER_DATA)) {
                    handleAdUserDataDependencies(consentFormUiModel);
                }
                this.this$0.refresh();
            }

            @Override // com.hive.analytics.consentmode.ui.ConsentModeFormUi.OnItemClickedListener
            public void onDetail(int position) {
                ConsentFormUiModel consentFormUiModel = this.this$0.getConsentModeUiModel().getFormList().get(position);
                Activity activity2 = this.this$0.launchActivity;
                if (activity2 != null) {
                    new ConsentModeFormDetailUi(activity2, consentFormUiModel.getTitle(), consentFormUiModel.getDescription()).show();
                }
            }

            @Override // com.hive.analytics.consentmode.ui.ConsentModeFormUi.OnItemClickedListener
            public void onCheckSubItem(int parentPosition, int position) {
                ConsentFormUiModel consentFormUiModel = this.this$0.getConsentModeUiModel().getFormList().get(parentPosition);
                if (consentFormUiModel instanceof ConsentFormUiModel.Group) {
                    ((ConsentFormUiModel.Group) consentFormUiModel).getSubItems().get(position).setChecked(!r2.getIsChecked());
                    this.this$0.refresh();
                }
            }

            @Override // com.hive.analytics.consentmode.ui.ConsentModeFormUi.OnItemClickedListener
            public void onDetailSubItem(int parentPosition, int position) {
                ConsentFormUiModel consentFormUiModel = this.this$0.getConsentModeUiModel().getFormList().get(parentPosition);
                if (consentFormUiModel instanceof ConsentFormUiModel.Group) {
                    ConsentFormUiModel.Item item = ((ConsentFormUiModel.Group) consentFormUiModel).getSubItems().get(position);
                    Activity activity2 = this.this$0.launchActivity;
                    if (activity2 != null) {
                        new ConsentModeFormDetailUi(activity2, item.getTitle(), item.getDescription()).show();
                    }
                }
            }

            private final void handleAdUserDataDependencies(ConsentFormUiModel form) {
                String lowerCase = form.getId().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, Analytics.CONSENT_TYPE_AD_USER_DATA)) {
                    Set of = SetsKt.setOf((Object[]) new String[]{Analytics.CONSENT_TYPE_AD_PERSONALIZATION, Analytics.CONSENT_TYPE_ANALYTICS_STORAGE});
                    List<ConsentFormUiModel> formList = this.this$0.getConsentModeUiModel().getFormList();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : formList) {
                        String lowerCase2 = ((ConsentFormUiModel) obj).getId().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (of.contains(lowerCase2)) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList<ConsentFormUiModel> arrayList2 = arrayList;
                    if (!form.getIsChecked()) {
                        for (ConsentFormUiModel consentFormUiModel : arrayList2) {
                            consentFormUiModel.uncheck();
                            consentFormUiModel.disable();
                        }
                        return;
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((ConsentFormUiModel) it.next()).enable();
                    }
                }
            }
        });
        this.itemAdapter = consentModeFormUi;
        recyclerView.setAdapter(consentModeFormUi);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        HiveConsentModeBinding hiveConsentModeBinding4 = this.binding;
        if (hiveConsentModeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeBinding4 = null;
        }
        AppCompatTextView hiveConsentModeSubButton = hiveConsentModeBinding4.hiveConsentModeSubButton;
        Intrinsics.checkNotNullExpressionValue(hiveConsentModeSubButton, "hiveConsentModeSubButton");
        TouchEffectKt.setTouchEffect(hiveConsentModeSubButton, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(117, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.analytics.consentmode.ui.ConsentModeUi$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConsentModeUi.onCreate$lambda$8(this.f$0, (View) obj);
            }
        } : null);
        HiveConsentModeBinding hiveConsentModeBinding5 = this.binding;
        if (hiveConsentModeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeBinding5 = null;
        }
        AppCompatTextView hiveConsentModeMainButton = hiveConsentModeBinding5.hiveConsentModeMainButton;
        Intrinsics.checkNotNullExpressionValue(hiveConsentModeMainButton, "hiveConsentModeMainButton");
        TouchEffectKt.setTouchEffect(hiveConsentModeMainButton, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.analytics.consentmode.ui.ConsentModeUi$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConsentModeUi.onCreate$lambda$9(this.f$0, (View) obj);
            }
        } : null);
        HiveConsentModeBinding hiveConsentModeBinding6 = this.binding;
        if (hiveConsentModeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeBinding6 = null;
        }
        AppCompatTextView hiveConsentModePrivacyPolicy = hiveConsentModeBinding6.hiveConsentModePrivacyPolicy;
        Intrinsics.checkNotNullExpressionValue(hiveConsentModePrivacyPolicy, "hiveConsentModePrivacyPolicy");
        TouchEffectKt.setVisibleEffect(hiveConsentModePrivacyPolicy, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.analytics.consentmode.ui.ConsentModeUi$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConsentModeUi.onCreate$lambda$10(this.f$0, (View) obj);
            }
        } : null);
        if (this.isRequire) {
            HiveConsentModeBinding hiveConsentModeBinding7 = this.binding;
            if (hiveConsentModeBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                hiveConsentModeBinding7 = null;
            }
            hiveConsentModeBinding7.hiveConsentModeButtonClose.setVisibility(8);
            HiveConsentModeBinding hiveConsentModeBinding8 = this.binding;
            if (hiveConsentModeBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                hiveConsentModeBinding = hiveConsentModeBinding8;
            }
            hiveConsentModeBinding.hiveConsentModeButtonClose.setEnabled(false);
        } else {
            HiveConsentModeBinding hiveConsentModeBinding9 = this.binding;
            if (hiveConsentModeBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                hiveConsentModeBinding = hiveConsentModeBinding9;
            }
            hiveConsentModeBinding.hiveConsentModeButtonClose.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeUi.onCreate.5
                @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
                public void onClick() {
                    ConsentModeUi.this.onClose();
                }
            });
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$8(ConsentModeUi consentModeUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LoggerImpl.INSTANCE.d("[ConsentModeUi] Clicks All Button");
        consentModeUi.onClickAll();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9(ConsentModeUi consentModeUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LoggerImpl.INSTANCE.d("[ConsentModeUi] Submit Button");
        consentModeUi.onSubmit();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$10(ConsentModeUi consentModeUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LoggerImpl.INSTANCE.d("[ConsentModeUi] PrivacyPolicy Button");
        OnConsentModeUiListener onConsentModeUiListener = consentModeUi.listener;
        if (onConsentModeUiListener != null) {
            onConsentModeUiListener.onPrivacyPolicy();
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoggerImpl.INSTANCE.d("[ConsentModeUi] onDestroy");
        if (!getIsCalledFinish() && !getIsRecreated()) {
            onClose();
        }
        this.isShowing = false;
        this.launchActivity = null;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        LoggerImpl.INSTANCE.d("[ConsentModeUi] onConfigurationChanged");
        activity.recreate();
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public boolean onBackPressed() {
        if (this.isRequire) {
            return true;
        }
        onClose();
        return true;
    }
}
