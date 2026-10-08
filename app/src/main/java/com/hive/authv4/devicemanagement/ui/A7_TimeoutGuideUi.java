package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener;
import com.hive.core.Logger;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: A7_TimeoutGuideUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0012\u001a\u00020\u000eJ\u001a\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/A7_TimeoutGuideUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "errorCodeText", "", "hideCustomerSupport", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Z)V", "errorCode", "Landroid/widget/TextView;", "customerSupport", "show", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "Lcom/hive/authv4/devicemanagement/ui/model/OnErrorGuideListener;", "onContactCustomerSupport", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A7_TimeoutGuideUi extends A0_BaseDeviceManagementUi {
    private TextView customerSupport;
    private TextView errorCode;
    private final String errorCodeText;
    private final boolean hideCustomerSupport;

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    @Deprecated(message = "Override function", replaceWith = @ReplaceWith(expression = "show(listener: OnErrorGuideListener?)", imports = {}))
    public void show(OnBaseButtonListener listener) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A7_TimeoutGuideUi(Activity parentActivity, String errorCodeText, boolean z) {
        super(parentActivity, R.layout.hive_device_management_a7_timeout_guide);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(errorCodeText, "errorCodeText");
        this.errorCodeText = errorCodeText;
        this.hideCustomerSupport = z;
    }

    public final void show(OnErrorGuideListener listener) {
        super.show((OnBaseButtonListener) listener);
    }

    public final void onContactCustomerSupport() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A7_TimeoutGuideUi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A7_TimeoutGuideUi.onContactCustomerSupport$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onContactCustomerSupport$lambda$0(A7_TimeoutGuideUi a7_TimeoutGuideUi) {
        OnBaseButtonListener listener = a7_TimeoutGuideUi.getListener();
        OnErrorGuideListener onErrorGuideListener = listener instanceof OnErrorGuideListener ? (OnErrorGuideListener) listener : null;
        if (onErrorGuideListener != null) {
            onErrorGuideListener.onContactCustomerSupport();
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_error_code);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        textView.setText("[" + this.errorCodeText + AbstractJsonLexerKt.END_LIST);
        this.errorCode = textView;
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_contact_customer_support);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView2 = (TextView) viewFindViewById2;
        TouchEffectKt.setVisibleEffect(textView2, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A7_TimeoutGuideUi$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A7_TimeoutGuideUi.onCreate$lambda$4$lambda$3(textView2, this, (View) obj);
            }
        } : null);
        textView2.setVisibility(this.hideCustomerSupport ? 8 : 0);
        this.customerSupport = textView2;
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$4$lambda$3(TextView textView, A7_TimeoutGuideUi a7_TimeoutGuideUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - customerSupport()");
        a7_TimeoutGuideUi.onContactCustomerSupport();
        return Unit.INSTANCE;
    }
}
