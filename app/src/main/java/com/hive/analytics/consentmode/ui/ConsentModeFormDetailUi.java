package com.hive.analytics.consentmode.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import com.hive.analytics.consentmode.databinding.HiveConsentModeFormDetailBinding;
import com.hive.logger.LoggerImpl;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Util;
import com.hive.ui.view.HiveAnimationButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentModeFormDetailUi.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/hive/analytics/consentmode/ui/ConsentModeFormDetailUi;", "Lcom/hive/ui/OnActivityLifecycle;", "parentActivity", "Landroid/app/Activity;", "title", "", "description", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "binding", "Lcom/hive/analytics/consentmode/databinding/HiveConsentModeFormDetailBinding;", "show", "", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConsentModeFormDetailUi extends OnActivityLifecycle {
    private HiveConsentModeFormDetailBinding binding;
    private final String description;
    private final Activity parentActivity;
    private final String title;

    public ConsentModeFormDetailUi(Activity parentActivity, String title, String description) {
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        this.parentActivity = parentActivity;
        this.title = title;
        this.description = description;
    }

    public final void show() {
        Intent intent = new Intent();
        intent.putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "ConsentMode");
        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        HiveUiActivity.INSTANCE.launch(this.parentActivity, intent, this);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(final Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        HiveConsentModeFormDetailBinding hiveConsentModeFormDetailBindingInflate = HiveConsentModeFormDetailBinding.inflate(activity.getLayoutInflater());
        this.binding = hiveConsentModeFormDetailBindingInflate;
        HiveConsentModeFormDetailBinding hiveConsentModeFormDetailBinding = null;
        if (hiveConsentModeFormDetailBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeFormDetailBindingInflate = null;
        }
        activity.setContentView(hiveConsentModeFormDetailBindingInflate.getRoot());
        Util.INSTANCE.hideSystemUI(activity.getWindow());
        HiveConsentModeFormDetailBinding hiveConsentModeFormDetailBinding2 = this.binding;
        if (hiveConsentModeFormDetailBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeFormDetailBinding2 = null;
        }
        hiveConsentModeFormDetailBinding2.hiveConsentModeButtonBack.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.analytics.consentmode.ui.ConsentModeFormDetailUi.onCreate.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                activity.finish();
            }
        });
        HiveConsentModeFormDetailBinding hiveConsentModeFormDetailBinding3 = this.binding;
        if (hiveConsentModeFormDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeFormDetailBinding3 = null;
        }
        hiveConsentModeFormDetailBinding3.hiveConsentModeFormDetailTitle.setText(this.title);
        HiveConsentModeFormDetailBinding hiveConsentModeFormDetailBinding4 = this.binding;
        if (hiveConsentModeFormDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            hiveConsentModeFormDetailBinding4 = null;
        }
        hiveConsentModeFormDetailBinding4.hiveConsentModeFormDetailContents.setMovementMethod(LinkMovementMethod.getInstance());
        HiveConsentModeFormDetailBinding hiveConsentModeFormDetailBinding5 = this.binding;
        if (hiveConsentModeFormDetailBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            hiveConsentModeFormDetailBinding = hiveConsentModeFormDetailBinding5;
        }
        hiveConsentModeFormDetailBinding.hiveConsentModeFormDetailContents.setText(Html.fromHtml(this.description));
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        LoggerImpl.INSTANCE.d("[ConsentModeFormDetailUi] onConfigurationChanged");
        activity.recreate();
    }
}
