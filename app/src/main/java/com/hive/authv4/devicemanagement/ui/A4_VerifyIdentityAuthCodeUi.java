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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnVerifyIdentityAuthCodeListener;
import com.hive.core.Logger;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: A4_VerifyIdentityAuthCodeUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0019J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0006\u0010\u001f\u001a\u00020\u0019J\u001a\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\b\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u0006\u0010%\u001a\u00020\u0019J\u001a\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/A4_VerifyIdentityAuthCodeUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "phoneNumberText", "", "hideCustomerSupport", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Z)V", "isError", "message", "isInputAuthCodeActive", "timeTick", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "Landroid/widget/TextView;", "timeLimit", "inputText", "Landroid/widget/EditText;", "resend", "errorMessage", "customerSupport", "countDownTimer", "Landroid/os/CountDownTimer;", "show", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "Lcom/hive/authv4/devicemanagement/ui/model/OnVerifyIdentityAuthCodeListener;", "onContactCustomerSupport", "refresh", "setTimerReset", "setError", TypedValues.Custom.S_BOOLEAN, "setVerifyError", "finish", "onActive", "onResend", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "resendActive", "b", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A4_VerifyIdentityAuthCodeUi extends A0_BaseDeviceManagementUi {
    private CountDownTimer countDownTimer;
    private TextView customerSupport;
    private TextView errorMessage;
    private final boolean hideCustomerSupport;
    private EditText inputText;
    private boolean isError;
    private boolean isInputAuthCodeActive;
    private String message;
    private TextView phoneNumber;
    private final String phoneNumberText;
    private TextView resend;
    private TextView timeLimit;
    private String timeTick;

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    @Deprecated(message = "Override function", replaceWith = @ReplaceWith(expression = "show(listener: OnVerifyIdentityListener?)", imports = {}))
    public void show(OnBaseButtonListener listener) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A4_VerifyIdentityAuthCodeUi(Activity parentActivity, String phoneNumberText, boolean z) {
        super(parentActivity, R.layout.hive_device_management_a4_verify_identity_auth_code);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(phoneNumberText, "phoneNumberText");
        this.phoneNumberText = phoneNumberText;
        this.hideCustomerSupport = z;
        this.isInputAuthCodeActive = true;
        this.timeTick = "";
    }

    public final void show(OnVerifyIdentityAuthCodeListener listener) {
        super.show((OnBaseButtonListener) listener);
    }

    public final void onContactCustomerSupport() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                A4_VerifyIdentityAuthCodeUi.onContactCustomerSupport$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onContactCustomerSupport$lambda$0(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi) {
        OnBaseButtonListener listener = a4_VerifyIdentityAuthCodeUi.getListener();
        OnVerifyIdentityAuthCodeListener onVerifyIdentityAuthCodeListener = listener instanceof OnVerifyIdentityAuthCodeListener ? (OnVerifyIdentityAuthCodeListener) listener : null;
        if (onVerifyIdentityAuthCodeListener != null) {
            onVerifyIdentityAuthCodeListener.onContactCustomerSupport();
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void refresh() {
        super.refresh();
        if (getIsShowing()) {
            Activity launchActivity = getLaunchActivity();
            if (launchActivity != null) {
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        A4_VerifyIdentityAuthCodeUi.refresh$lambda$2$lambda$1(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        Logger.INSTANCE.d("[" + getTag() + "] refresh, is not showing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$2$lambda$1(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi) {
        TextView textView = a4_VerifyIdentityAuthCodeUi.errorMessage;
        if (textView != null) {
            String string = a4_VerifyIdentityAuthCodeUi.message;
            if (string == null) {
                Activity launchActivity = a4_VerifyIdentityAuthCodeUi.getLaunchActivity();
                string = launchActivity != null ? launchActivity.getString(R.string.hive_device_management_120) : null;
            }
            textView.setText(string);
        }
        if (a4_VerifyIdentityAuthCodeUi.isError) {
            TextView textView2 = a4_VerifyIdentityAuthCodeUi.errorMessage;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        } else {
            TextView textView3 = a4_VerifyIdentityAuthCodeUi.errorMessage;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        EditText editText = a4_VerifyIdentityAuthCodeUi.inputText;
        if (editText != null) {
            editText.setEnabled(a4_VerifyIdentityAuthCodeUi.isInputAuthCodeActive);
        }
    }

    public final void setTimerReset() {
        Logger.INSTANCE.d("[" + getTag() + "] setTimerReset");
        Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    A4_VerifyIdentityAuthCodeUi.setTimerReset$lambda$3(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimerReset$lambda$3(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi) {
        CountDownTimer countDownTimer = a4_VerifyIdentityAuthCodeUi.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = a4_VerifyIdentityAuthCodeUi.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
        a4_VerifyIdentityAuthCodeUi.isInputAuthCodeActive = true;
        EditText editText = a4_VerifyIdentityAuthCodeUi.inputText;
        if (editText != null) {
            editText.setText("");
        }
        a4_VerifyIdentityAuthCodeUi.isError = false;
        a4_VerifyIdentityAuthCodeUi.refresh();
    }

    public static /* synthetic */ void setError$default(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        a4_VerifyIdentityAuthCodeUi.setError(z, str);
    }

    public final void setError(boolean z, String message) {
        Logger.INSTANCE.w("[" + getTag() + "] setError(" + z + ", " + message + ')');
        if (z) {
            resendActive(true);
        }
        this.isError = z;
        this.message = message;
        refresh();
    }

    public static /* synthetic */ void setVerifyError$default(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        a4_VerifyIdentityAuthCodeUi.setVerifyError(z, str);
    }

    public final void setVerifyError(boolean z, String message) {
        Logger.INSTANCE.w("[" + getTag() + "] setVerifyError(" + z + ", " + message + ')');
        this.isError = z;
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                A4_VerifyIdentityAuthCodeUi.onActive$lambda$5(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$5(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi, Bundle bundle) {
        OnBaseButtonListener listener = a4_VerifyIdentityAuthCodeUi.getListener();
        if (listener != null) {
            listener.onActive(bundle);
        }
    }

    public final void onResend() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                A4_VerifyIdentityAuthCodeUi.onResend$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResend$lambda$6(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi) {
        OnBaseButtonListener listener = a4_VerifyIdentityAuthCodeUi.getListener();
        OnVerifyIdentityAuthCodeListener onVerifyIdentityAuthCodeListener = listener instanceof OnVerifyIdentityAuthCodeListener ? (OnVerifyIdentityAuthCodeListener) listener : null;
        if (onVerifyIdentityAuthCodeListener != null) {
            onVerifyIdentityAuthCodeListener.onResend();
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_phone_number);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        textView.setText(this.phoneNumberText);
        this.phoneNumber = textView;
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_time_limit);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewFindViewById2;
        textView2.setText(this.timeTick);
        this.timeLimit = textView2;
        View viewFindViewById3 = activity.findViewById(R.id.hive_device_management_button_input);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) viewFindViewById3;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$onCreate$3$1
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
                A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi = this.this$0;
                if (a4_VerifyIdentityAuthCodeUi.getIsActive() != z) {
                    a4_VerifyIdentityAuthCodeUi.setActive(z);
                    a4_VerifyIdentityAuthCodeUi.refresh();
                }
            }
        });
        this.inputText = editText;
        View viewFindViewById4 = activity.findViewById(R.id.hive_device_management_btn_resend);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView3 = (TextView) viewFindViewById4;
        TouchEffectKt.setVisibleEffect(textView3, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A4_VerifyIdentityAuthCodeUi.onCreate$lambda$11$lambda$10(textView3, this, (View) obj);
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
        TouchEffectKt.setVisibleEffect(textView5, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A4_VerifyIdentityAuthCodeUi.onCreate$lambda$14$lambda$13(textView5, this, (View) obj);
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
    public static final Unit onCreate$lambda$11$lambda$10(TextView textView, A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - resend()");
        a4_VerifyIdentityAuthCodeUi.resendActive(false);
        a4_VerifyIdentityAuthCodeUi.onResend();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14$lambda$13(TextView textView, A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - customerSupport()");
        a4_VerifyIdentityAuthCodeUi.onContactCustomerSupport();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$onCreate$7, reason: invalid class name */
    /* JADX INFO: compiled from: A4_VerifyIdentityAuthCodeUi.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/hive/authv4/devicemanagement/ui/A4_VerifyIdentityAuthCodeUi$onCreate$7", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
            A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi = A4_VerifyIdentityAuthCodeUi.this;
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
            a4_VerifyIdentityAuthCodeUi.timeTick = sb.toString();
            Logger.INSTANCE.d("[" + A4_VerifyIdentityAuthCodeUi.this.getTag() + "] countDownTimer onTick() - " + A4_VerifyIdentityAuthCodeUi.this.timeTick);
            Activity launchActivity = A4_VerifyIdentityAuthCodeUi.this.getLaunchActivity();
            if (launchActivity != null) {
                final A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi2 = A4_VerifyIdentityAuthCodeUi.this;
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$onCreate$7$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        A4_VerifyIdentityAuthCodeUi.AnonymousClass7.onTick$lambda$0(a4_VerifyIdentityAuthCodeUi2);
                    }
                });
            }
            A4_VerifyIdentityAuthCodeUi.this.resendActive(j < 150);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onTick$lambda$0(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi) {
            TextView textView = a4_VerifyIdentityAuthCodeUi.timeLimit;
            if (textView != null) {
                textView.setText(a4_VerifyIdentityAuthCodeUi.timeTick);
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.INSTANCE.d("[" + A4_VerifyIdentityAuthCodeUi.this.getTag() + "] countDownTimer onFinish()");
            final Activity launchActivity = A4_VerifyIdentityAuthCodeUi.this.getLaunchActivity();
            if (launchActivity != null) {
                final A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi = A4_VerifyIdentityAuthCodeUi.this;
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$onCreate$7$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        A4_VerifyIdentityAuthCodeUi.AnonymousClass7.onFinish$lambda$2$lambda$1(a4_VerifyIdentityAuthCodeUi, launchActivity);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onFinish$lambda$2$lambda$1(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi, Activity activity) {
            a4_VerifyIdentityAuthCodeUi.timeTick = activity.getText(R.string.hive_device_management_122).toString();
            TextView textView = a4_VerifyIdentityAuthCodeUi.timeLimit;
            if (textView != null) {
                textView.setText(a4_VerifyIdentityAuthCodeUi.timeTick);
            }
            EditText editText = a4_VerifyIdentityAuthCodeUi.inputText;
            if (editText != null) {
                editText.setText("");
            }
            a4_VerifyIdentityAuthCodeUi.isInputAuthCodeActive = false;
            a4_VerifyIdentityAuthCodeUi.resendActive(true);
            a4_VerifyIdentityAuthCodeUi.setError(true, activity.getText(R.string.hive_device_management_147).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resendActive(final boolean b) {
        final Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    A4_VerifyIdentityAuthCodeUi.resendActive$lambda$19$lambda$18(this.f$0, b, launchActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resendActive$lambda$19$lambda$18(A4_VerifyIdentityAuthCodeUi a4_VerifyIdentityAuthCodeUi, boolean z, Activity activity) {
        TextView textView = a4_VerifyIdentityAuthCodeUi.resend;
        if (textView != null) {
            textView.setEnabled(z);
        }
        Activity activity2 = activity;
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(z ? R.attr.hiveDeviceManagementActiveResendFontColor : R.attr.hiveDeviceManagementInActiveResendFontColor, typedValue, true);
        int color = ContextCompat.getColor(activity2, typedValue.resourceId);
        TextView textView2 = a4_VerifyIdentityAuthCodeUi.resend;
        if (textView2 != null) {
            textView2.setTextColor(color);
        }
    }
}
