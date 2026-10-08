package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.data.CountryNumber;
import com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnVerifyIdentityListener;
import com.hive.core.Configuration;
import com.hive.core.Logger;
import com.hive.ui.effect.TouchEffectKt;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: compiled from: A3_VerifyIdentityUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0017J\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010!J\b\u0010\"\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\u001a\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\fJ\u001a\u0010(\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\fJ\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u001a\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/A3_VerifyIdentityUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "isInputNumberActive", "", "isSendActive", "isInputAuthCodeActive", "isSendError", "sendErrorMessage", "", "isVerifyError", "verifyErrorMessage", "isInputNotEmpty", "timeTick", "spinner", "Landroid/widget/Spinner;", "inputNewPhoneNumber", "Landroid/widget/EditText;", "errorMessage1", "Landroid/widget/TextView;", "send", "timeLimit", "authCodeInput", "errorMessage2", "countDownTimer", "Landroid/os/CountDownTimer;", "show", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "Lcom/hive/authv4/devicemanagement/ui/model/OnVerifyIdentityListener;", "refresh", "setTimerReset", "setTimerCancel", "setSendError", "isError", "message", "setVerifyError", "onSend", "finish", "onActive", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A3_VerifyIdentityUi extends A0_BaseDeviceManagementUi {
    private EditText authCodeInput;
    private CountDownTimer countDownTimer;
    private TextView errorMessage1;
    private TextView errorMessage2;
    private EditText inputNewPhoneNumber;
    private boolean isInputAuthCodeActive;
    private boolean isInputNotEmpty;
    private boolean isInputNumberActive;
    private boolean isSendActive;
    private boolean isSendError;
    private boolean isVerifyError;
    private TextView send;
    private String sendErrorMessage;
    private Spinner spinner;
    private TextView timeLimit;
    private String timeTick;
    private String verifyErrorMessage;

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    @Deprecated(message = "Override function", replaceWith = @ReplaceWith(expression = "show(listener: OnVerifyIdentityListener?)", imports = {}))
    public void show(OnBaseButtonListener listener) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A3_VerifyIdentityUi(Activity parentActivity) {
        super(parentActivity, R.layout.hive_device_management_a3_verify_identity);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        this.isInputNumberActive = true;
        this.timeTick = "";
    }

    public final void show(OnVerifyIdentityListener listener) {
        super.show((OnBaseButtonListener) listener);
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void refresh() {
        if (getIsShowing()) {
            final Activity launchActivity = getLaunchActivity();
            if (launchActivity != null) {
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        A3_VerifyIdentityUi.refresh$lambda$10$lambda$9(this.f$0, launchActivity);
                    }
                });
                return;
            }
            return;
        }
        Logger.INSTANCE.d("[" + getTag() + "] refresh, is not showing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$10$lambda$9(A3_VerifyIdentityUi a3_VerifyIdentityUi, Activity activity) {
        String string;
        boolean z = a3_VerifyIdentityUi.isInputNumberActive;
        Spinner spinner = a3_VerifyIdentityUi.spinner;
        if (spinner != null) {
            spinner.setEnabled(z);
        }
        EditText editText = a3_VerifyIdentityUi.inputNewPhoneNumber;
        if (editText != null) {
            editText.setEnabled(z);
        }
        if (a3_VerifyIdentityUi.isSendActive) {
            TextView textView = a3_VerifyIdentityUi.send;
            if (textView != null) {
                textView.setEnabled(true);
            }
            Activity activity2 = activity;
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonActive, typedValue, true);
            Drawable drawable = ContextCompat.getDrawable(activity2, typedValue.resourceId);
            TextView textView2 = a3_VerifyIdentityUi.send;
            if (textView2 != null) {
                textView2.setBackground(drawable);
            }
            TypedValue typedValue2 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementFontColorActive, typedValue2, true);
            int iIntValue = Integer.valueOf(ContextCompat.getColor(activity2, typedValue2.resourceId)).intValue();
            TextView textView3 = a3_VerifyIdentityUi.send;
            if (textView3 != null) {
                textView3.setTextColor(iIntValue);
            }
        } else {
            Activity activity3 = activity;
            TypedValue typedValue3 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonInActive, typedValue3, true);
            Drawable drawable2 = ContextCompat.getDrawable(activity3, typedValue3.resourceId);
            TextView textView4 = a3_VerifyIdentityUi.send;
            if (textView4 != null) {
                textView4.setBackground(drawable2);
            }
            TypedValue typedValue4 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementFontColorInActive, typedValue4, true);
            int color = ContextCompat.getColor(activity3, typedValue4.resourceId);
            TextView textView5 = a3_VerifyIdentityUi.send;
            if (textView5 != null) {
                textView5.setTextColor(color);
            }
            TextView textView6 = a3_VerifyIdentityUi.send;
            if (textView6 != null) {
                textView6.setEnabled(false);
            }
        }
        if (a3_VerifyIdentityUi.isSendError) {
            TextView textView7 = a3_VerifyIdentityUi.errorMessage1;
            if (textView7 != null) {
                String string2 = a3_VerifyIdentityUi.sendErrorMessage;
                if (string2 == null) {
                    Activity launchActivity = a3_VerifyIdentityUi.getLaunchActivity();
                    string2 = launchActivity != null ? launchActivity.getString(R.string.hive_device_management_144) : null;
                }
                textView7.setText(string2);
            }
            TextView textView8 = a3_VerifyIdentityUi.errorMessage1;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
        } else {
            TextView textView9 = a3_VerifyIdentityUi.errorMessage1;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        TextView textView10 = a3_VerifyIdentityUi.timeLimit;
        if (textView10 != null) {
            textView10.setText(a3_VerifyIdentityUi.timeTick);
        }
        if (StringsKt.isBlank(a3_VerifyIdentityUi.timeTick)) {
            TextView textView11 = a3_VerifyIdentityUi.timeLimit;
            if (textView11 != null) {
                textView11.setVisibility(8);
            }
        } else {
            TextView textView12 = a3_VerifyIdentityUi.timeLimit;
            if (textView12 != null) {
                textView12.setVisibility(0);
            }
        }
        EditText editText2 = a3_VerifyIdentityUi.authCodeInput;
        if (editText2 != null) {
            editText2.setEnabled(a3_VerifyIdentityUi.isInputAuthCodeActive);
        }
        if (a3_VerifyIdentityUi.isVerifyError) {
            TextView textView13 = a3_VerifyIdentityUi.errorMessage2;
            if (textView13 != null) {
                String str = a3_VerifyIdentityUi.verifyErrorMessage;
                if (str != null) {
                    string = str;
                } else {
                    Activity launchActivity2 = a3_VerifyIdentityUi.getLaunchActivity();
                    string = launchActivity2 != null ? launchActivity2.getString(R.string.hive_device_management_144) : null;
                }
                textView13.setText(string);
            }
            TextView textView14 = a3_VerifyIdentityUi.errorMessage2;
            if (textView14 != null) {
                textView14.setVisibility(0);
            }
        } else {
            TextView textView15 = a3_VerifyIdentityUi.errorMessage2;
            if (textView15 != null) {
                textView15.setVisibility(8);
            }
        }
        a3_VerifyIdentityUi.setActive(a3_VerifyIdentityUi.isInputNotEmpty);
        super.refresh();
    }

    private final void setTimerReset() {
        Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    A3_VerifyIdentityUi.setTimerReset$lambda$11(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimerReset$lambda$11(A3_VerifyIdentityUi a3_VerifyIdentityUi) {
        CountDownTimer countDownTimer = a3_VerifyIdentityUi.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = a3_VerifyIdentityUi.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
        TextView textView = a3_VerifyIdentityUi.timeLimit;
        if (textView != null) {
            textView.setVisibility(0);
        }
        EditText editText = a3_VerifyIdentityUi.authCodeInput;
        if (editText != null) {
            editText.setText("");
        }
        a3_VerifyIdentityUi.isVerifyError = false;
        a3_VerifyIdentityUi.refresh();
    }

    private final void setTimerCancel() {
        Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    A3_VerifyIdentityUi.setTimerCancel$lambda$12(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimerCancel$lambda$12(A3_VerifyIdentityUi a3_VerifyIdentityUi) {
        CountDownTimer countDownTimer = a3_VerifyIdentityUi.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        a3_VerifyIdentityUi.timeTick = "";
        TextView textView = a3_VerifyIdentityUi.timeLimit;
        if (textView != null) {
            textView.setVisibility(8);
        }
        a3_VerifyIdentityUi.refresh();
    }

    public static /* synthetic */ void setSendError$default(A3_VerifyIdentityUi a3_VerifyIdentityUi, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        a3_VerifyIdentityUi.setSendError(z, str);
    }

    public final void setSendError(boolean isError, String message) {
        if (isError) {
            this.isInputNumberActive = true;
            this.isSendActive = true;
        } else {
            setTimerReset();
            this.isInputNumberActive = false;
            this.isSendActive = false;
            this.isInputAuthCodeActive = true;
        }
        this.isSendError = isError;
        this.sendErrorMessage = message;
        refresh();
    }

    public static /* synthetic */ void setVerifyError$default(A3_VerifyIdentityUi a3_VerifyIdentityUi, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        a3_VerifyIdentityUi.setVerifyError(z, str);
    }

    public final void setVerifyError(boolean isError, String message) {
        this.isVerifyError = isError;
        this.verifyErrorMessage = message;
        refresh();
    }

    private final void onSend() {
        Spinner spinner = this.spinner;
        String strValueOf = String.valueOf(spinner != null ? spinner.getSelectedItem() : null);
        EditText editText = this.inputNewPhoneNumber;
        String strValueOf2 = String.valueOf(editText != null ? editText.getText() : null);
        final Bundle bundle = new Bundle();
        bundle.putString("phoneCode", strValueOf);
        bundle.putString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, strValueOf2);
        this.isInputNumberActive = false;
        this.isSendActive = false;
        this.isSendError = false;
        refresh();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A3_VerifyIdentityUi.onSend$lambda$14(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSend$lambda$14(A3_VerifyIdentityUi a3_VerifyIdentityUi, Bundle bundle) {
        OnBaseButtonListener listener = a3_VerifyIdentityUi.getListener();
        OnVerifyIdentityListener onVerifyIdentityListener = listener instanceof OnVerifyIdentityListener ? (OnVerifyIdentityListener) listener : null;
        if (onVerifyIdentityListener != null) {
            onVerifyIdentityListener.onSend(bundle);
        }
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
        EditText editText = this.authCodeInput;
        String strValueOf = String.valueOf(editText != null ? editText.getText() : null);
        final Bundle bundle = new Bundle();
        bundle.putString("code", strValueOf);
        this.isVerifyError = false;
        refresh();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                A3_VerifyIdentityUi.onActive$lambda$16(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$16(A3_VerifyIdentityUi a3_VerifyIdentityUi, Bundle bundle) {
        OnBaseButtonListener listener = a3_VerifyIdentityUi.getListener();
        if (listener != null) {
            listener.onActive(bundle);
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_phone_code_spinner);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.Spinner");
        Spinner spinner = (Spinner) viewFindViewById;
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, R.layout.hive_device_management_a3_spinner_item);
        Iterator<T> it = CountryNumber.INSTANCE.getUniqueCountryNumber().iterator();
        while (it.hasNext()) {
            arrayAdapter.add(Marker.ANY_NON_NULL_MARKER + ((Number) it.next()).intValue());
        }
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(CountryNumber.INSTANCE.findCountryNumberIndexFromCountryCode(Configuration.INSTANCE.getHiveCountry()));
        this.spinner = spinner;
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_button_input_1);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) viewFindViewById2;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$onCreate$2$1
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
                A3_VerifyIdentityUi a3_VerifyIdentityUi = this.this$0;
                if (!a3_VerifyIdentityUi.isInputNumberActive || a3_VerifyIdentityUi.isSendActive == z) {
                    return;
                }
                a3_VerifyIdentityUi.isSendActive = z;
                a3_VerifyIdentityUi.refresh();
            }
        });
        this.inputNewPhoneNumber = editText;
        View viewFindViewById3 = activity.findViewById(R.id.hive_device_management_error_message_1);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById3;
        textView.setVisibility(8);
        this.errorMessage1 = textView;
        View viewFindViewById4 = activity.findViewById(R.id.hive_device_management_send_verification_code_button);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView2 = (TextView) viewFindViewById4;
        TouchEffectKt.setTouchEffect(textView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A3_VerifyIdentityUi.onCreate$lambda$23$lambda$22(textView2, this, (View) obj);
            }
        } : null);
        this.send = textView2;
        View viewFindViewById5 = activity.findViewById(R.id.hive_device_management_time_limit);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) viewFindViewById5;
        textView3.setText(this.timeTick);
        this.timeLimit = textView3;
        View viewFindViewById6 = activity.findViewById(R.id.hive_device_management_button_input_2);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText2 = (EditText) viewFindViewById6;
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$onCreate$6$1
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
                A3_VerifyIdentityUi a3_VerifyIdentityUi = this.this$0;
                if (a3_VerifyIdentityUi.isInputNotEmpty != z) {
                    a3_VerifyIdentityUi.isInputNotEmpty = z;
                    a3_VerifyIdentityUi.refresh();
                }
            }
        });
        this.authCodeInput = editText2;
        View viewFindViewById7 = activity.findViewById(R.id.hive_device_management_error_message_2);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) viewFindViewById7;
        textView4.setVisibility(8);
        this.errorMessage2 = textView4;
        if (this.countDownTimer == null) {
            this.countDownTimer = new AnonymousClass8();
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$23$lambda$22(TextView textView, A3_VerifyIdentityUi a3_VerifyIdentityUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - sendButton()");
        a3_VerifyIdentityUi.onSend();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$onCreate$8, reason: invalid class name */
    /* JADX INFO: compiled from: A3_VerifyIdentityUi.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/hive/authv4/devicemanagement/ui/A3_VerifyIdentityUi$onCreate$8", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass8 extends CountDownTimer {
        AnonymousClass8() {
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
            A3_VerifyIdentityUi a3_VerifyIdentityUi = A3_VerifyIdentityUi.this;
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
            a3_VerifyIdentityUi.timeTick = sb.toString();
            Activity launchActivity = A3_VerifyIdentityUi.this.getLaunchActivity();
            if (launchActivity != null) {
                final A3_VerifyIdentityUi a3_VerifyIdentityUi2 = A3_VerifyIdentityUi.this;
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$onCreate$8$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        A3_VerifyIdentityUi.AnonymousClass8.onTick$lambda$0(a3_VerifyIdentityUi2);
                    }
                });
            }
            if (j < 150) {
                A3_VerifyIdentityUi.this.isInputNumberActive = true;
                A3_VerifyIdentityUi.this.isSendActive = true;
            }
            A3_VerifyIdentityUi.this.refresh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onTick$lambda$0(A3_VerifyIdentityUi a3_VerifyIdentityUi) {
            TextView textView = a3_VerifyIdentityUi.timeLimit;
            if (textView != null) {
                textView.setText(a3_VerifyIdentityUi.timeTick);
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            final Activity launchActivity = A3_VerifyIdentityUi.this.getLaunchActivity();
            if (launchActivity != null) {
                final A3_VerifyIdentityUi a3_VerifyIdentityUi = A3_VerifyIdentityUi.this;
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi$onCreate$8$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        A3_VerifyIdentityUi.AnonymousClass8.onFinish$lambda$2$lambda$1(a3_VerifyIdentityUi, launchActivity);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onFinish$lambda$2$lambda$1(A3_VerifyIdentityUi a3_VerifyIdentityUi, Activity activity) {
            a3_VerifyIdentityUi.timeTick = activity.getText(R.string.hive_device_management_122).toString();
            TextView textView = a3_VerifyIdentityUi.timeLimit;
            if (textView != null) {
                textView.setText(a3_VerifyIdentityUi.timeTick);
            }
            EditText editText = a3_VerifyIdentityUi.authCodeInput;
            if (editText != null) {
                editText.setText("");
            }
            a3_VerifyIdentityUi.isInputAuthCodeActive = false;
            a3_VerifyIdentityUi.setVerifyError(true, activity.getText(R.string.hive_device_management_147).toString());
        }
    }
}
