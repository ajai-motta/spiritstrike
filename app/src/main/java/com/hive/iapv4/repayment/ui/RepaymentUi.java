package com.hive.iapv4.repayment.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Logger;
import com.hive.iapv4.repayment.R;
import com.hive.iapv4.repayment.ui.model.RepaymentListener;
import com.hive.iapv4.repayment.ui.source.RepaymentSource;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: compiled from: RepaymentUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017J\u0006\u0010&\u001a\u00020$J\u001a\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0016J\u001a\u0010-\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J$\u00100\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010*2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0016J\u0018\u00104\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u00105\u001a\u00020*H\u0016J\u0010\u00106\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0016J\u0010\u00107\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0016J\u0010\u00108\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0016J\u0018\u00109\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u000eH\u0016J\u0018\u0010;\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=H\u0016J \u0010>\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020=H\u0016J3\u0010@\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020GH\u0016¢\u0006\u0002\u0010HJ*\u0010I\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010A\u001a\u00020B2\u0006\u0010J\u001a\u00020B2\b\u0010K\u001a\u0004\u0018\u00010/H\u0016J\b\u0010L\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/hive/iapv4/repayment/ui/RepaymentUi;", "Lcom/hive/ui/OnActivityLifecycle;", "parentActivity", "Landroid/app/Activity;", "dataSource", "Lcom/hive/iapv4/repayment/ui/source/RepaymentSource;", "activityLifecycle", "<init>", "(Landroid/app/Activity;Lcom/hive/iapv4/repayment/ui/source/RepaymentSource;Lcom/hive/ui/OnActivityLifecycle;)V", "getActivityLifecycle", "()Lcom/hive/ui/OnActivityLifecycle;", "setActivityLifecycle", "(Lcom/hive/ui/OnActivityLifecycle;)V", "value", "", "isShowing", "()Z", "lunchActivity", "getLunchActivity", "()Landroid/app/Activity;", "setLunchActivity", "(Landroid/app/Activity;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/iapv4/repayment/ui/model/RepaymentListener;", "rectangle1Title", "Landroid/widget/TextView;", "rectangle1Content", "rectangle2Title", "rectangle2Refresh", "Landroidx/appcompat/widget/AppCompatImageView;", "rectangle2RecyclerViewAdapter", "Lcom/hive/iapv4/repayment/ui/RepaymentItemViewAdapter;", "rectangle2CsCode", "rectangle2InquireButton", "rectangle2StartGameButton", "show", "", "repaymentListener", "refresh", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onRestart", "onStart", "onNewIntent", "intent", "Landroid/content/Intent;", "onRestoreInstanceState", "persistentState", "Landroid/os/PersistableBundle;", "onResume", "onSaveInstanceState", "outState", "onPause", "onStop", "onDestroy", "onWindowFocusChanged", "hasFocus", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "onActivityResult", "resultCode", "data", "onBackPressed", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RepaymentUi extends OnActivityLifecycle {
    private OnActivityLifecycle activityLifecycle;
    private final RepaymentSource dataSource;
    private boolean isShowing;
    private RepaymentListener listener;
    private Activity lunchActivity;
    private final Activity parentActivity;
    private TextView rectangle1Content;
    private TextView rectangle1Title;
    private TextView rectangle2CsCode;
    private TextView rectangle2InquireButton;
    private RepaymentItemViewAdapter rectangle2RecyclerViewAdapter;
    private AppCompatImageView rectangle2Refresh;
    private TextView rectangle2StartGameButton;
    private TextView rectangle2Title;

    @Override // com.hive.ui.OnActivityLifecycle
    public boolean onBackPressed() {
        return true;
    }

    public /* synthetic */ RepaymentUi(Activity activity, RepaymentSource repaymentSource, OnActivityLifecycle onActivityLifecycle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, repaymentSource, (i & 4) != 0 ? null : onActivityLifecycle);
    }

    public final OnActivityLifecycle getActivityLifecycle() {
        return this.activityLifecycle;
    }

    public final void setActivityLifecycle(OnActivityLifecycle onActivityLifecycle) {
        this.activityLifecycle = onActivityLifecycle;
    }

    public RepaymentUi(Activity parentActivity, RepaymentSource dataSource, OnActivityLifecycle onActivityLifecycle) {
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.parentActivity = parentActivity;
        this.dataSource = dataSource;
        this.activityLifecycle = onActivityLifecycle;
    }

    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    public final Activity getLunchActivity() {
        return this.lunchActivity;
    }

    public final void setLunchActivity(Activity activity) {
        this.lunchActivity = activity;
    }

    public final void show(RepaymentListener repaymentListener) {
        Intrinsics.checkNotNullParameter(repaymentListener, "repaymentListener");
        Logger.INSTANCE.d("[RepaymentUi] show");
        if (this.isShowing) {
            return;
        }
        this.listener = repaymentListener;
        Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "Repayment");
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        HiveUiActivity.INSTANCE.launch(this.parentActivity, intentPutExtra, this);
    }

    public final void refresh() {
        Logger.INSTANCE.d("[RepaymentUi] refresh");
        if (this.isShowing) {
            final Activity activity = this.lunchActivity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.hive.iapv4.repayment.ui.RepaymentUi$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        RepaymentUi.refresh$lambda$7$lambda$6(this.f$0, activity);
                    }
                });
                return;
            }
            return;
        }
        Logger.INSTANCE.d("[RepaymentUi] is not showing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$7$lambda$6(RepaymentUi repaymentUi, Activity activity) {
        TextView textView = repaymentUi.rectangle1Title;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rectangle1Title");
            textView = null;
        }
        textView.setText(repaymentUi.dataSource.getGuideTitle());
        TextView textView3 = repaymentUi.rectangle1Content;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rectangle1Content");
            textView3 = null;
        }
        textView3.setText(repaymentUi.dataSource.getGuideContent());
        TextView textView4 = repaymentUi.rectangle2Title;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rectangle2Title");
            textView4 = null;
        }
        String string = activity.getResources().getString(R.string.hive_repayment_repayment_item);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = activity.getResources().getString(R.string.hive_repayment_cases);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        textView4.setText(string + " (" + repaymentUi.dataSource.getCompleteCount() + FileSystemKt.UnixPathSeparator + repaymentUi.dataSource.getFullCount() + ' ' + string2 + ')');
        RepaymentItemViewAdapter repaymentItemViewAdapter = repaymentUi.rectangle2RecyclerViewAdapter;
        if (repaymentItemViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rectangle2RecyclerViewAdapter");
            repaymentItemViewAdapter = null;
        }
        repaymentItemViewAdapter.notifyDataSetChanged();
        TextView textView5 = repaymentUi.rectangle2CsCode;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rectangle2CsCode");
            textView5 = null;
        }
        textView5.setText("CS Code : " + repaymentUi.dataSource.getCsCode());
        TextView textView6 = repaymentUi.rectangle2InquireButton;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rectangle2InquireButton");
            textView6 = null;
        }
        textView6.setText(activity.getResources().getString(R.string.hive_repayment_customer_support));
        TextView textView7 = repaymentUi.rectangle2StartGameButton;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rectangle2StartGameButton");
        } else {
            textView2 = textView7;
        }
        textView2.setText(activity.getResources().getString(R.string.hive_repayment_start_game));
        if (repaymentUi.dataSource.isFullComplete()) {
            textView2.setEnabled(true);
            Activity activity2 = activity;
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(com.hive.ui.R.attr.hiveDefaultPopupMainButton, typedValue, true);
            textView2.setBackground(ContextCompat.getDrawable(activity2, typedValue.resourceId));
            TypedValue typedValue2 = new TypedValue();
            activity.getTheme().resolveAttribute(com.hive.ui.R.attr.commonWhite, typedValue2, true);
            textView2.setTextColor(ContextCompat.getColor(activity2, typedValue2.resourceId));
            return;
        }
        textView2.setEnabled(false);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(final Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.lunchActivity = activity;
        this.isShowing = true;
        activity.setContentView(R.layout.hive_repayment);
        View viewFindViewById = activity.findViewById(R.id.hive_repayment_rectangle_1_title);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.rectangle1Title = (TextView) viewFindViewById;
        View viewFindViewById2 = activity.findViewById(R.id.hive_repayment_rectangle_1_content);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.rectangle1Content = (TextView) viewFindViewById2;
        View viewFindViewById3 = activity.findViewById(R.id.hive_repayment_rectangle_2_title);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.rectangle2Title = (TextView) viewFindViewById3;
        View viewFindViewById4 = activity.findViewById(R.id.hive_repayment_rectangle_2_refresh);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewFindViewById4;
        TouchEffectKt.setTouchEffect(appCompatImageView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.iapv4.repayment.ui.RepaymentUi$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RepaymentUi.onCreate$lambda$9$lambda$8(this.f$0, (View) obj);
            }
        } : null);
        this.rectangle2Refresh = appCompatImageView;
        View viewFindViewById5 = activity.findViewById(R.id.hive_repayment_rectangle_2_recycler_view);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById5;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        RepaymentItemViewAdapter repaymentItemViewAdapter = new RepaymentItemViewAdapter(activity, this.dataSource, this.listener);
        this.rectangle2RecyclerViewAdapter = repaymentItemViewAdapter;
        recyclerView.setAdapter(repaymentItemViewAdapter);
        View viewFindViewById6 = activity.findViewById(R.id.hive_repayment_rectangle_2_cs_code);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.rectangle2CsCode = (TextView) viewFindViewById6;
        View viewFindViewById7 = activity.findViewById(R.id.hive_repayment_rectangle_2_inquire_button);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById7;
        TouchEffectKt.setTouchEffect(textView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.iapv4.repayment.ui.RepaymentUi$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RepaymentUi.onCreate$lambda$12$lambda$11(this.f$0, (View) obj);
            }
        } : null);
        this.rectangle2InquireButton = textView;
        View viewFindViewById8 = activity.findViewById(R.id.hive_repayment_rectangle_2_start_game_button);
        Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewFindViewById8;
        TouchEffectKt.setTouchEffect(textView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.iapv4.repayment.ui.RepaymentUi$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RepaymentUi.onCreate$lambda$14$lambda$13(this.f$0, activity, (View) obj);
            }
        } : null);
        this.rectangle2StartGameButton = textView2;
        refresh();
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onCreate(activity, savedInstanceState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$9$lambda$8(RepaymentUi repaymentUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RepaymentListener repaymentListener = repaymentUi.listener;
        if (repaymentListener != null) {
            repaymentListener.onRefresh();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$12$lambda$11(RepaymentUi repaymentUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RepaymentListener repaymentListener = repaymentUi.listener;
        if (repaymentListener != null) {
            repaymentListener.onInquiry(repaymentUi.dataSource.getInquiryUrl());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14$lambda$13(RepaymentUi repaymentUi, Activity activity, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (repaymentUi.dataSource.isFullComplete()) {
            RepaymentListener repaymentListener = repaymentUi.listener;
            if (repaymentListener != null) {
                repaymentListener.onStartGame();
            }
            activity.finish();
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onRestart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onRestart(activity);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onStart(activity);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onNewIntent(activity, intent);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onRestoreInstanceState(activity, savedInstanceState, persistentState);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onResume(activity);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onSaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onSaveInstanceState(activity, outState);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onPause(activity);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onStart(activity);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        RepaymentListener repaymentListener;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!getIsCalledFinish() && !getIsRecreated() && (repaymentListener = this.listener) != null) {
            repaymentListener.onDestroy();
        }
        this.isShowing = false;
        this.lunchActivity = null;
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onDestroy(activity);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onWindowFocusChanged(Activity activity, boolean hasFocus) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onWindowFocusChanged(activity, hasFocus);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        activity.recreate();
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onConfigurationChanged(activity, newConfig);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onMultiWindowModeChanged(Activity activity, boolean isInMultiWindowMode, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onMultiWindowModeChanged(activity, isInMultiWindowMode, newConfig);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.d("[RepaymentUi] onActivityResult");
        OnActivityLifecycle onActivityLifecycle = this.activityLifecycle;
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onActivityResult(activity, requestCode, resultCode, data);
        }
    }
}
