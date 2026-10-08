package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.core.Logger;
import com.hive.ui.devicemanagement.model.OnChangeMobilePhoneNo2Listener;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: C11_ChangeMobilePhoneNo2Ui.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0006\u0010\u001e\u001a\u00020\u0019J\u001a\u0010\u001f\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010 \u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\u0006\u0010#\u001a\u00020\u0019J\u0006\u0010$\u001a\u00020\u0019J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C11_ChangeMobilePhoneNo2Ui;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "hiddenPhoneNumberText", "", "hideCustomerSupport", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Z)V", "isError", "message", "isInputAuthCodeActive", "timeTick", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "Landroid/widget/TextView;", "timeLimit", "inputText", "Landroid/widget/EditText;", "resend", "errorMessage", "customerSupport", "countDownTimer", "Landroid/os/CountDownTimer;", "show", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "Lcom/hive/ui/devicemanagement/model/OnChangeMobilePhoneNo2Listener;", "refresh", "setTimerReset", "setError", "setVerifyError", "finish", "onActive", "onResend", "onContactCustomerSupport", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "resendActive", "b", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C11_ChangeMobilePhoneNo2Ui extends A0_BaseDeviceManagementUi {
    private CountDownTimer countDownTimer;
    private TextView customerSupport;
    private TextView errorMessage;
    private final String hiddenPhoneNumberText;
    private final boolean hideCustomerSupport;
    private EditText inputText;
    private boolean isError;
    private boolean isInputAuthCodeActive;
    private String message;
    private TextView phoneNumber;
    private TextView resend;
    private TextView timeLimit;
    private String timeTick;

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    @Deprecated(message = "Override function", replaceWith = @ReplaceWith(expression = "show(listener: OnChangeMobilePhoneNo2Listener?)", imports = {}))
    public void show(OnBaseButtonListener listener) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11_ChangeMobilePhoneNo2Ui(Activity parentActivity, String hiddenPhoneNumberText, boolean z) {
        super(parentActivity, R.layout.hive_device_management_c11_change_mobile_phone_no_2);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(hiddenPhoneNumberText, "hiddenPhoneNumberText");
        this.hiddenPhoneNumberText = hiddenPhoneNumberText;
        this.hideCustomerSupport = z;
        this.isInputAuthCodeActive = true;
        this.timeTick = "";
    }

    public final void show(OnChangeMobilePhoneNo2Listener listener) {
        super.show((OnBaseButtonListener) listener);
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void refresh() {
        super.refresh();
        if (getIsShowing()) {
            Activity launchActivity = getLaunchActivity();
            if (launchActivity != null) {
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C11_ChangeMobilePhoneNo2Ui.refresh$lambda$1$lambda$0(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        Logger.INSTANCE.d("[" + getTag() + "] refresh, is not showing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$1$lambda$0(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui) {
        TextView textView = c11_ChangeMobilePhoneNo2Ui.errorMessage;
        if (textView != null) {
            String string = c11_ChangeMobilePhoneNo2Ui.message;
            if (string == null) {
                Activity launchActivity = c11_ChangeMobilePhoneNo2Ui.getLaunchActivity();
                string = launchActivity != null ? launchActivity.getString(R.string.hive_device_management_120) : null;
            }
            textView.setText(string);
        }
        if (c11_ChangeMobilePhoneNo2Ui.isError) {
            TextView textView2 = c11_ChangeMobilePhoneNo2Ui.errorMessage;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        } else {
            TextView textView3 = c11_ChangeMobilePhoneNo2Ui.errorMessage;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        EditText editText = c11_ChangeMobilePhoneNo2Ui.inputText;
        if (editText != null) {
            editText.setEnabled(c11_ChangeMobilePhoneNo2Ui.isInputAuthCodeActive);
        }
    }

    public final void setTimerReset() {
        Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    C11_ChangeMobilePhoneNo2Ui.setTimerReset$lambda$2(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimerReset$lambda$2(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui) {
        CountDownTimer countDownTimer = c11_ChangeMobilePhoneNo2Ui.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = c11_ChangeMobilePhoneNo2Ui.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
        c11_ChangeMobilePhoneNo2Ui.isInputAuthCodeActive = true;
        EditText editText = c11_ChangeMobilePhoneNo2Ui.inputText;
        if (editText != null) {
            editText.setText("");
        }
        c11_ChangeMobilePhoneNo2Ui.isError = false;
        c11_ChangeMobilePhoneNo2Ui.refresh();
    }

    public static /* synthetic */ void setError$default(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        c11_ChangeMobilePhoneNo2Ui.setError(z, str);
    }

    public final void setError(boolean isError, String message) {
        if (isError) {
            resendActive(true);
        }
        this.isError = isError;
        this.message = message;
        refresh();
    }

    public static /* synthetic */ void setVerifyError$default(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        c11_ChangeMobilePhoneNo2Ui.setVerifyError(z, str);
    }

    public final void setVerifyError(boolean isError, String message) {
        this.isError = isError;
        this.message = message;
        refresh();
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void finish() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.finish();
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void onActive() {
        EditText editText = this.inputText;
        String strValueOf = String.valueOf(editText != null ? editText.getText() : null);
        final Bundle bundle = new Bundle();
        bundle.putString("code", strValueOf);
        this.isError = false;
        refresh();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                C11_ChangeMobilePhoneNo2Ui.onActive$lambda$4(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$4(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui, Bundle bundle) {
        OnBaseButtonListener listener = c11_ChangeMobilePhoneNo2Ui.getListener();
        if (listener != null) {
            listener.onActive(bundle);
        }
    }

    public final void onResend() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C11_ChangeMobilePhoneNo2Ui.onResend$lambda$5(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResend$lambda$5(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui) {
        OnBaseButtonListener listener = c11_ChangeMobilePhoneNo2Ui.getListener();
        OnChangeMobilePhoneNo2Listener onChangeMobilePhoneNo2Listener = listener instanceof OnChangeMobilePhoneNo2Listener ? (OnChangeMobilePhoneNo2Listener) listener : null;
        if (onChangeMobilePhoneNo2Listener != null) {
            onChangeMobilePhoneNo2Listener.onResend();
        }
    }

    public final void onContactCustomerSupport() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C11_ChangeMobilePhoneNo2Ui.onContactCustomerSupport$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onContactCustomerSupport$lambda$6(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui) {
        OnBaseButtonListener listener = c11_ChangeMobilePhoneNo2Ui.getListener();
        OnChangeMobilePhoneNo2Listener onChangeMobilePhoneNo2Listener = listener instanceof OnChangeMobilePhoneNo2Listener ? (OnChangeMobilePhoneNo2Listener) listener : null;
        if (onChangeMobilePhoneNo2Listener != null) {
            onChangeMobilePhoneNo2Listener.onContactCustomerSupport();
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_phone_number);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        textView.setText(this.hiddenPhoneNumberText);
        this.phoneNumber = textView;
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_time_limit);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewFindViewById2;
        textView2.setText(this.timeTick);
        this.timeLimit = textView2;
        View viewFindViewById3 = activity.findViewById(R.id.hive_device_management_button_input);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) viewFindViewById3;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$onCreate$3$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                boolean z = false;
                if (s != null && (!StringsKt.isBlank(s))) {
                    z = true;
                }
                C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui = this.this$0;
                if (c11_ChangeMobilePhoneNo2Ui.getIsActive() != z) {
                    c11_ChangeMobilePhoneNo2Ui.setActive(z);
                    c11_ChangeMobilePhoneNo2Ui.refresh();
                }
            }
        });
        this.inputText = editText;
        View viewFindViewById4 = activity.findViewById(R.id.hive_device_management_btn_resend);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView3 = (TextView) viewFindViewById4;
        TouchEffectKt.setVisibleEffect(textView3, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C11_ChangeMobilePhoneNo2Ui.onCreate$lambda$11$lambda$10(textView3, this, (View) obj);
            }
        } : null);
        this.resend = textView3;
        View viewFindViewById5 = activity.findViewById(R.id.hive_device_management_error_message);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) viewFindViewById5;
        textView4.setVisibility(8);
        this.errorMessage = textView4;
        View viewFindViewById6 = activity.findViewById(R.id.hive_device_management_contact_customer_support);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView5 = (TextView) viewFindViewById6;
        TouchEffectKt.setVisibleEffect(textView5, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C11_ChangeMobilePhoneNo2Ui.onCreate$lambda$14$lambda$13(textView5, this, (View) obj);
            }
        } : null);
        textView5.setVisibility(this.hideCustomerSupport ? 8 : 0);
        this.customerSupport = textView5;
        if (this.countDownTimer == null) {
            AnonymousClass7 anonymousClass7 = new AnonymousClass7();
            anonymousClass7.start();
            this.countDownTimer = anonymousClass7;
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$11$lambda$10(TextView textView, C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - resend()");
        c11_ChangeMobilePhoneNo2Ui.resendActive(false);
        c11_ChangeMobilePhoneNo2Ui.onResend();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14$lambda$13(TextView textView, C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - customerSupport");
        c11_ChangeMobilePhoneNo2Ui.onContactCustomerSupport();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$onCreate$7, reason: invalid class name */
    /* JADX INFO: compiled from: C11_ChangeMobilePhoneNo2Ui.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/hive/authv4/devicemanagement/ui/C11_ChangeMobilePhoneNo2Ui$onCreate$7", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass7 extends CountDownTimer {
        AnonymousClass7() {
            super(180000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            Object objValueOf;
            Object objValueOf2;
            long j = millisUntilFinished / ((long) 1000);
            long j2 = 60;
            long j3 = j / j2;
            long j4 = j % j2;
            C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui = C11_ChangeMobilePhoneNo2Ui.this;
            StringBuilder sb = new StringBuilder();
            if (j3 > 9) {
                objValueOf = Long.valueOf(j3);
            } else {
                objValueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO + j3;
            }
            sb.append(objValueOf);
            sb.append(AbstractJsonLexerKt.COLON);
            if (j4 > 9) {
                objValueOf2 = Long.valueOf(j4);
            } else {
                objValueOf2 = AppEventsConstants.EVENT_PARAM_VALUE_NO + j4;
            }
            sb.append(objValueOf2);
            c11_ChangeMobilePhoneNo2Ui.timeTick = sb.toString();
            Activity launchActivity = C11_ChangeMobilePhoneNo2Ui.this.getLaunchActivity();
            if (launchActivity != null) {
                final C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui2 = C11_ChangeMobilePhoneNo2Ui.this;
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$onCreate$7$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C11_ChangeMobilePhoneNo2Ui.AnonymousClass7.onTick$lambda$0(c11_ChangeMobilePhoneNo2Ui2);
                    }
                });
            }
            C11_ChangeMobilePhoneNo2Ui.this.resendActive(j < 150);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onTick$lambda$0(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui) {
            TextView textView = c11_ChangeMobilePhoneNo2Ui.timeLimit;
            if (textView != null) {
                textView.setText(c11_ChangeMobilePhoneNo2Ui.timeTick);
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            final Activity launchActivity = C11_ChangeMobilePhoneNo2Ui.this.getLaunchActivity();
            if (launchActivity != null) {
                final C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui = C11_ChangeMobilePhoneNo2Ui.this;
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$onCreate$7$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C11_ChangeMobilePhoneNo2Ui.AnonymousClass7.onFinish$lambda$2$lambda$1(c11_ChangeMobilePhoneNo2Ui, launchActivity);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onFinish$lambda$2$lambda$1(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui, Activity activity) {
            c11_ChangeMobilePhoneNo2Ui.timeTick = activity.getText(R.string.hive_device_management_122).toString();
            TextView textView = c11_ChangeMobilePhoneNo2Ui.timeLimit;
            if (textView != null) {
                textView.setText(c11_ChangeMobilePhoneNo2Ui.timeTick);
            }
            EditText editText = c11_ChangeMobilePhoneNo2Ui.inputText;
            if (editText != null) {
                editText.setText("");
            }
            c11_ChangeMobilePhoneNo2Ui.isInputAuthCodeActive = false;
            c11_ChangeMobilePhoneNo2Ui.resendActive(true);
            c11_ChangeMobilePhoneNo2Ui.setError(true, activity.getText(R.string.hive_device_management_147).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resendActive(final boolean b) {
        final Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    C11_ChangeMobilePhoneNo2Ui.resendActive$lambda$19$lambda$18(this.f$0, b, launchActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resendActive$lambda$19$lambda$18(C11_ChangeMobilePhoneNo2Ui c11_ChangeMobilePhoneNo2Ui, boolean z, Activity activity) {
        TextView textView = c11_ChangeMobilePhoneNo2Ui.resend;
        if (textView != null) {
            textView.setEnabled(z);
        }
        Activity activity2 = activity;
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(z ? R.attr.hiveDeviceManagementActiveResendFontColor : R.attr.hiveDeviceManagementInActiveResendFontColor, typedValue, true);
        int color = ContextCompat.getColor(activity2, typedValue.resourceId);
        TextView textView2 = c11_ChangeMobilePhoneNo2Ui.resend;
        if (textView2 != null) {
            textView2.setTextColor(color);
        }
    }
}
