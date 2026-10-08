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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.data.CountryNumber;
import com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnChangeMobilePhoneNo3Listener;
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

/* JADX INFO: compiled from: C12_ChangeMobilePhoneNo3Ui.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\u0010\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010*J\b\u0010+\u001a\u00020'H\u0016J\b\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020'H\u0002J\u001a\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005J\u001a\u00101\u001a\u00020'2\u0006\u0010/\u001a\u00020\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0005J\b\u00102\u001a\u00020'H\u0002J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020'H\u0016J\b\u00105\u001a\u00020'H\u0016J\u001a\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u000109H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C12_ChangeMobilePhoneNo3Ui;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "hiddenPhoneNumberText", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "isInputNumberActive", "", "isSendActive", "isInputAuthCodeActive", "isSendError", "sendErrorMessage", "isChangeError", "changeErrorMessage", "isInputNotEmpty", "isChecked", "timeTick", "hiddenPhoneNumber", "Landroid/widget/TextView;", "spinner", "Landroid/widget/Spinner;", "inputNewPhoneNumber", "Landroid/widget/EditText;", "errorMessage1", "send", "timeLimit", "authCodeInput", "errorMessage2", "checkLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "checkButton", "Landroidx/appcompat/widget/AppCompatImageView;", "checkText", "moreButton", "countDownTimer", "Landroid/os/CountDownTimer;", "show", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "Lcom/hive/authv4/devicemanagement/ui/model/OnChangeMobilePhoneNo3Listener;", "refresh", "setTimerReset", "setTimerCancel", "setSendError", "isError", "message", "setChangeError", "onSend", "onMore", "finish", "onActive", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C12_ChangeMobilePhoneNo3Ui extends A0_BaseDeviceManagementUi {
    private EditText authCodeInput;
    private String changeErrorMessage;
    private AppCompatImageView checkButton;
    private ConstraintLayout checkLayout;
    private TextView checkText;
    private CountDownTimer countDownTimer;
    private TextView errorMessage1;
    private TextView errorMessage2;
    private TextView hiddenPhoneNumber;
    private final String hiddenPhoneNumberText;
    private EditText inputNewPhoneNumber;
    private boolean isChangeError;
    private boolean isChecked;
    private boolean isInputAuthCodeActive;
    private boolean isInputNotEmpty;
    private boolean isInputNumberActive;
    private boolean isSendActive;
    private boolean isSendError;
    private AppCompatImageView moreButton;
    private TextView send;
    private String sendErrorMessage;
    private Spinner spinner;
    private TextView timeLimit;
    private String timeTick;

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    @Deprecated(message = "Override function", replaceWith = @ReplaceWith(expression = "show(listener: OnChangeMobilePhoneNo3Listener?)", imports = {}))
    public void show(OnBaseButtonListener listener) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12_ChangeMobilePhoneNo3Ui(Activity parentActivity, String hiddenPhoneNumberText) {
        super(parentActivity, R.layout.hive_device_management_c12_change_mobile_phone_no_3);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(hiddenPhoneNumberText, "hiddenPhoneNumberText");
        this.hiddenPhoneNumberText = hiddenPhoneNumberText;
        this.isInputNumberActive = true;
        this.timeTick = "";
    }

    public final void show(OnChangeMobilePhoneNo3Listener listener) {
        super.show((OnBaseButtonListener) listener);
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void refresh() {
        if (getIsShowing()) {
            final Activity launchActivity = getLaunchActivity();
            if (launchActivity != null) {
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12_ChangeMobilePhoneNo3Ui.refresh$lambda$14$lambda$13(this.f$0, launchActivity);
                    }
                });
                return;
            }
            return;
        }
        Logger.INSTANCE.d("[" + getTag() + "] refresh, is not showing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$14$lambda$13(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, Activity activity) {
        String string;
        boolean z = c12_ChangeMobilePhoneNo3Ui.isInputNumberActive;
        Spinner spinner = c12_ChangeMobilePhoneNo3Ui.spinner;
        if (spinner != null) {
            spinner.setEnabled(z);
        }
        EditText editText = c12_ChangeMobilePhoneNo3Ui.inputNewPhoneNumber;
        if (editText != null) {
            editText.setEnabled(z);
        }
        boolean z2 = false;
        if (c12_ChangeMobilePhoneNo3Ui.isSendActive) {
            TextView textView = c12_ChangeMobilePhoneNo3Ui.send;
            if (textView != null) {
                textView.setEnabled(true);
            }
            Activity activity2 = activity;
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonActive, typedValue, true);
            Drawable drawable = ContextCompat.getDrawable(activity2, typedValue.resourceId);
            TextView textView2 = c12_ChangeMobilePhoneNo3Ui.send;
            if (textView2 != null) {
                textView2.setBackground(drawable);
            }
            TypedValue typedValue2 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementFontColorActive, typedValue2, true);
            int iIntValue = Integer.valueOf(ContextCompat.getColor(activity2, typedValue2.resourceId)).intValue();
            TextView textView3 = c12_ChangeMobilePhoneNo3Ui.send;
            if (textView3 != null) {
                textView3.setTextColor(iIntValue);
            }
        } else {
            Activity activity3 = activity;
            TypedValue typedValue3 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonInActive, typedValue3, true);
            Drawable drawable2 = ContextCompat.getDrawable(activity3, typedValue3.resourceId);
            TextView textView4 = c12_ChangeMobilePhoneNo3Ui.send;
            if (textView4 != null) {
                textView4.setBackground(drawable2);
            }
            TypedValue typedValue4 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementFontColorInActive, typedValue4, true);
            int color = ContextCompat.getColor(activity3, typedValue4.resourceId);
            TextView textView5 = c12_ChangeMobilePhoneNo3Ui.send;
            if (textView5 != null) {
                textView5.setTextColor(color);
            }
            TextView textView6 = c12_ChangeMobilePhoneNo3Ui.send;
            if (textView6 != null) {
                textView6.setEnabled(false);
            }
        }
        if (c12_ChangeMobilePhoneNo3Ui.isSendError) {
            TextView textView7 = c12_ChangeMobilePhoneNo3Ui.errorMessage1;
            if (textView7 != null) {
                String string2 = c12_ChangeMobilePhoneNo3Ui.sendErrorMessage;
                if (string2 == null) {
                    Activity launchActivity = c12_ChangeMobilePhoneNo3Ui.getLaunchActivity();
                    string2 = launchActivity != null ? launchActivity.getString(R.string.hive_device_management_144) : null;
                }
                textView7.setText(string2);
            }
            TextView textView8 = c12_ChangeMobilePhoneNo3Ui.errorMessage1;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
        } else {
            TextView textView9 = c12_ChangeMobilePhoneNo3Ui.errorMessage1;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
        }
        TextView textView10 = c12_ChangeMobilePhoneNo3Ui.timeLimit;
        if (textView10 != null) {
            textView10.setText(c12_ChangeMobilePhoneNo3Ui.timeTick);
        }
        if (StringsKt.isBlank(c12_ChangeMobilePhoneNo3Ui.timeTick)) {
            TextView textView11 = c12_ChangeMobilePhoneNo3Ui.timeLimit;
            if (textView11 != null) {
                textView11.setVisibility(8);
            }
        } else {
            TextView textView12 = c12_ChangeMobilePhoneNo3Ui.timeLimit;
            if (textView12 != null) {
                textView12.setVisibility(0);
            }
        }
        EditText editText2 = c12_ChangeMobilePhoneNo3Ui.authCodeInput;
        if (editText2 != null) {
            editText2.setEnabled(c12_ChangeMobilePhoneNo3Ui.isInputAuthCodeActive);
        }
        if (c12_ChangeMobilePhoneNo3Ui.isChangeError) {
            TextView textView13 = c12_ChangeMobilePhoneNo3Ui.errorMessage2;
            if (textView13 != null) {
                String str = c12_ChangeMobilePhoneNo3Ui.changeErrorMessage;
                if (str != null) {
                    string = str;
                } else {
                    Activity launchActivity2 = c12_ChangeMobilePhoneNo3Ui.getLaunchActivity();
                    string = launchActivity2 != null ? launchActivity2.getString(R.string.hive_device_management_144) : null;
                }
                textView13.setText(string);
            }
            TextView textView14 = c12_ChangeMobilePhoneNo3Ui.errorMessage2;
            if (textView14 != null) {
                textView14.setVisibility(0);
            }
        } else {
            TextView textView15 = c12_ChangeMobilePhoneNo3Ui.errorMessage2;
            if (textView15 != null) {
                textView15.setVisibility(8);
            }
        }
        if (c12_ChangeMobilePhoneNo3Ui.isChecked) {
            TypedValue typedValue5 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonCheckOn, typedValue5, true);
            Drawable drawable3 = ContextCompat.getDrawable(activity, typedValue5.resourceId);
            AppCompatImageView appCompatImageView = c12_ChangeMobilePhoneNo3Ui.checkButton;
            if (appCompatImageView != null) {
                appCompatImageView.setImageDrawable(drawable3);
            }
        } else {
            TypedValue typedValue6 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonCheckOff, typedValue6, true);
            Drawable drawable4 = ContextCompat.getDrawable(activity, typedValue6.resourceId);
            AppCompatImageView appCompatImageView2 = c12_ChangeMobilePhoneNo3Ui.checkButton;
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageDrawable(drawable4);
            }
        }
        if (c12_ChangeMobilePhoneNo3Ui.isInputNotEmpty && c12_ChangeMobilePhoneNo3Ui.isChecked) {
            z2 = true;
        }
        c12_ChangeMobilePhoneNo3Ui.setActive(z2);
        super.refresh();
    }

    private final void setTimerReset() {
        Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    C12_ChangeMobilePhoneNo3Ui.setTimerReset$lambda$15(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimerReset$lambda$15(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui) {
        CountDownTimer countDownTimer = c12_ChangeMobilePhoneNo3Ui.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = c12_ChangeMobilePhoneNo3Ui.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
        TextView textView = c12_ChangeMobilePhoneNo3Ui.timeLimit;
        if (textView != null) {
            textView.setVisibility(0);
        }
        EditText editText = c12_ChangeMobilePhoneNo3Ui.authCodeInput;
        if (editText != null) {
            editText.setText("");
        }
        c12_ChangeMobilePhoneNo3Ui.isChangeError = false;
        c12_ChangeMobilePhoneNo3Ui.refresh();
    }

    private final void setTimerCancel() {
        Activity launchActivity = getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C12_ChangeMobilePhoneNo3Ui.setTimerCancel$lambda$16(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimerCancel$lambda$16(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui) {
        CountDownTimer countDownTimer = c12_ChangeMobilePhoneNo3Ui.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        c12_ChangeMobilePhoneNo3Ui.timeTick = "";
        TextView textView = c12_ChangeMobilePhoneNo3Ui.timeLimit;
        if (textView != null) {
            textView.setVisibility(8);
        }
        c12_ChangeMobilePhoneNo3Ui.refresh();
    }

    public static /* synthetic */ void setSendError$default(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        c12_ChangeMobilePhoneNo3Ui.setSendError(z, str);
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

    public static /* synthetic */ void setChangeError$default(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        c12_ChangeMobilePhoneNo3Ui.setChangeError(z, str);
    }

    public final void setChangeError(boolean isError, String message) {
        this.isChangeError = isError;
        this.changeErrorMessage = message;
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C12_ChangeMobilePhoneNo3Ui.onSend$lambda$18(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSend$lambda$18(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, Bundle bundle) {
        OnBaseButtonListener listener = c12_ChangeMobilePhoneNo3Ui.getListener();
        OnChangeMobilePhoneNo3Listener onChangeMobilePhoneNo3Listener = listener instanceof OnChangeMobilePhoneNo3Listener ? (OnChangeMobilePhoneNo3Listener) listener : null;
        if (onChangeMobilePhoneNo3Listener != null) {
            onChangeMobilePhoneNo3Listener.onSend(bundle);
        }
    }

    private final void onMore() {
        OnBaseButtonListener listener = getListener();
        OnChangeMobilePhoneNo3Listener onChangeMobilePhoneNo3Listener = listener instanceof OnChangeMobilePhoneNo3Listener ? (OnChangeMobilePhoneNo3Listener) listener : null;
        if (onChangeMobilePhoneNo3Listener != null) {
            onChangeMobilePhoneNo3Listener.onMore();
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
        this.isChangeError = false;
        refresh();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C12_ChangeMobilePhoneNo3Ui.onActive$lambda$20(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$20(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, Bundle bundle) {
        OnBaseButtonListener listener = c12_ChangeMobilePhoneNo3Ui.getListener();
        if (listener != null) {
            listener.onActive(bundle);
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_non_editable);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        textView.setText(this.hiddenPhoneNumberText);
        this.hiddenPhoneNumber = textView;
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_phone_code_spinner);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.Spinner");
        Spinner spinner = (Spinner) viewFindViewById2;
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, R.layout.hive_device_management_a3_spinner_item);
        Iterator<T> it = CountryNumber.INSTANCE.getUniqueCountryNumber().iterator();
        while (it.hasNext()) {
            arrayAdapter.add(Marker.ANY_NON_NULL_MARKER + ((Number) it.next()).intValue());
        }
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(CountryNumber.INSTANCE.findCountryNumberIndexFromCountryCode(Configuration.INSTANCE.getHiveCountry()));
        this.spinner = spinner;
        View viewFindViewById3 = activity.findViewById(R.id.hive_device_management_button_input_1);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) viewFindViewById3;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$onCreate$3$1
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
                C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui = this.this$0;
                if (!c12_ChangeMobilePhoneNo3Ui.isInputNumberActive || c12_ChangeMobilePhoneNo3Ui.isSendActive == z) {
                    return;
                }
                c12_ChangeMobilePhoneNo3Ui.isSendActive = z;
                c12_ChangeMobilePhoneNo3Ui.refresh();
            }
        });
        this.inputNewPhoneNumber = editText;
        View viewFindViewById4 = activity.findViewById(R.id.hive_device_management_error_message_1);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewFindViewById4;
        textView2.setVisibility(8);
        this.errorMessage1 = textView2;
        View viewFindViewById5 = activity.findViewById(R.id.hive_device_management_send_verification_code_button);
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView3 = (TextView) viewFindViewById5;
        TouchEffectKt.setTouchEffect(textView3, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C12_ChangeMobilePhoneNo3Ui.onCreate$lambda$28$lambda$27(textView3, this, (View) obj);
            }
        } : null);
        this.send = textView3;
        View viewFindViewById6 = activity.findViewById(R.id.hive_device_management_time_limit);
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) viewFindViewById6;
        textView4.setText(this.timeTick);
        this.timeLimit = textView4;
        View viewFindViewById7 = activity.findViewById(R.id.hive_device_management_button_input_2);
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText2 = (EditText) viewFindViewById7;
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$onCreate$7$1
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
                C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui = this.this$0;
                if (c12_ChangeMobilePhoneNo3Ui.isInputNotEmpty != z) {
                    c12_ChangeMobilePhoneNo3Ui.isInputNotEmpty = z;
                    c12_ChangeMobilePhoneNo3Ui.refresh();
                }
            }
        });
        this.authCodeInput = editText2;
        View viewFindViewById8 = activity.findViewById(R.id.hive_device_management_error_message_2);
        Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView5 = (TextView) viewFindViewById8;
        textView5.setVisibility(8);
        this.errorMessage2 = textView5;
        View viewFindViewById9 = activity.findViewById(R.id.hive_device_management_check_layout);
        Intrinsics.checkNotNull(viewFindViewById9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById9;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12_ChangeMobilePhoneNo3Ui.onCreate$lambda$33$lambda$32(constraintLayout, this, view);
            }
        });
        this.checkLayout = constraintLayout;
        View viewFindViewById10 = activity.findViewById(R.id.hive_device_management_btn_check);
        Intrinsics.checkNotNull(viewFindViewById10, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        final AppCompatImageView appCompatImageView = (AppCompatImageView) viewFindViewById10;
        TouchEffectKt.setTouchEffect(appCompatImageView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C12_ChangeMobilePhoneNo3Ui.onCreate$lambda$35$lambda$34(appCompatImageView, this, (View) obj);
            }
        } : null);
        this.checkButton = appCompatImageView;
        View viewFindViewById11 = activity.findViewById(R.id.hive_device_management_sub_title);
        Intrinsics.checkNotNull(viewFindViewById11, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView6 = (TextView) viewFindViewById11;
        TouchEffectKt.setVisibleEffect(textView6, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C12_ChangeMobilePhoneNo3Ui.onCreate$lambda$37$lambda$36(textView6, this, (View) obj);
            }
        } : null);
        this.checkText = textView6;
        View viewFindViewById12 = activity.findViewById(R.id.hive_device_management_btn_more);
        Intrinsics.checkNotNull(viewFindViewById12, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        final AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewFindViewById12;
        TouchEffectKt.setTouchEffect(appCompatImageView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C12_ChangeMobilePhoneNo3Ui.onCreate$lambda$39$lambda$38(appCompatImageView2, this, (View) obj);
            }
        } : null);
        this.moreButton = appCompatImageView2;
        if (this.countDownTimer == null) {
            this.countDownTimer = new AnonymousClass13();
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$28$lambda$27(TextView textView, C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - sendButton()");
        c12_ChangeMobilePhoneNo3Ui.onSend();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$33$lambda$32(ConstraintLayout constraintLayout, C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, View view) {
        Logger.INSTANCE.d("[DeviceManagement] " + constraintLayout.getTag() + " - checkButton()");
        c12_ChangeMobilePhoneNo3Ui.isChecked = c12_ChangeMobilePhoneNo3Ui.isChecked ^ true;
        c12_ChangeMobilePhoneNo3Ui.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$35$lambda$34(AppCompatImageView appCompatImageView, C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + appCompatImageView.getTag() + " - checkButton()");
        c12_ChangeMobilePhoneNo3Ui.isChecked = c12_ChangeMobilePhoneNo3Ui.isChecked ^ true;
        c12_ChangeMobilePhoneNo3Ui.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$37$lambda$36(TextView textView, C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - checkText()");
        c12_ChangeMobilePhoneNo3Ui.isChecked = c12_ChangeMobilePhoneNo3Ui.isChecked ^ true;
        c12_ChangeMobilePhoneNo3Ui.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$39$lambda$38(AppCompatImageView appCompatImageView, C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + appCompatImageView.getTag() + " - moreButton()");
        c12_ChangeMobilePhoneNo3Ui.onMore();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$onCreate$13, reason: invalid class name */
    /* JADX INFO: compiled from: C12_ChangeMobilePhoneNo3Ui.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/hive/authv4/devicemanagement/ui/C12_ChangeMobilePhoneNo3Ui$onCreate$13", "Landroid/os/CountDownTimer;", "onTick", "", "millisUntilFinished", "", "onFinish", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass13 extends CountDownTimer {
        AnonymousClass13() {
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
            C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui = C12_ChangeMobilePhoneNo3Ui.this;
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
            c12_ChangeMobilePhoneNo3Ui.timeTick = sb.toString();
            Activity launchActivity = C12_ChangeMobilePhoneNo3Ui.this.getLaunchActivity();
            if (launchActivity != null) {
                final C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui2 = C12_ChangeMobilePhoneNo3Ui.this;
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$onCreate$13$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12_ChangeMobilePhoneNo3Ui.AnonymousClass13.onTick$lambda$0(c12_ChangeMobilePhoneNo3Ui2);
                    }
                });
            }
            if (j < 150) {
                C12_ChangeMobilePhoneNo3Ui.this.isInputNumberActive = true;
                C12_ChangeMobilePhoneNo3Ui.this.isSendActive = true;
            }
            C12_ChangeMobilePhoneNo3Ui.this.refresh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onTick$lambda$0(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui) {
            TextView textView = c12_ChangeMobilePhoneNo3Ui.timeLimit;
            if (textView != null) {
                textView.setText(c12_ChangeMobilePhoneNo3Ui.timeTick);
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            final Activity launchActivity = C12_ChangeMobilePhoneNo3Ui.this.getLaunchActivity();
            if (launchActivity != null) {
                final C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui = C12_ChangeMobilePhoneNo3Ui.this;
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui$onCreate$13$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12_ChangeMobilePhoneNo3Ui.AnonymousClass13.onFinish$lambda$2$lambda$1(c12_ChangeMobilePhoneNo3Ui, launchActivity);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onFinish$lambda$2$lambda$1(C12_ChangeMobilePhoneNo3Ui c12_ChangeMobilePhoneNo3Ui, Activity activity) {
            c12_ChangeMobilePhoneNo3Ui.timeTick = activity.getText(R.string.hive_device_management_122).toString();
            TextView textView = c12_ChangeMobilePhoneNo3Ui.timeLimit;
            if (textView != null) {
                textView.setText(c12_ChangeMobilePhoneNo3Ui.timeTick);
            }
            EditText editText = c12_ChangeMobilePhoneNo3Ui.authCodeInput;
            if (editText != null) {
                editText.setText("");
            }
            c12_ChangeMobilePhoneNo3Ui.isInputAuthCodeActive = false;
            c12_ChangeMobilePhoneNo3Ui.setChangeError(true, activity.getText(R.string.hive_device_management_147).toString());
        }
    }
}
