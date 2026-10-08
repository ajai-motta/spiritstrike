package com.adxcorp.gdpr;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.library.base.R;

/* JADX INFO: loaded from: classes2.dex */
public class ADXGDPRDialog extends Dialog {
    private Button mBtnCancel;
    private Button mBtnCloseWindowForConfirm;
    private Button mBtnCloseWindowForDeny;
    private Button mBtnOk;
    private View.OnClickListener mClickListener;
    private View mConfirmLayout;
    private View mDenyLayout;
    private View mMainLayout;
    private TextView mTextViewDescription;

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public ADXGDPRDialog(Context context) {
        super(context, R.style.AdxGDPRDialogTheme);
        this.mClickListener = new View.OnClickListener() { // from class: com.adxcorp.gdpr.ADXGDPRDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == ADXGDPRDialog.this.mBtnOk) {
                    ADXGDPRDialog.this.mMainLayout.setVisibility(8);
                    ADXGDPRDialog.this.mConfirmLayout.setVisibility(0);
                    ADXGdprManager.saveResultGDPR(ADXGDPRDialog.this.getContext(), ADXGDPR.ADXConsentState.ADXConsentStateConfirm);
                } else if (view == ADXGDPRDialog.this.mBtnCancel) {
                    ADXGDPRDialog.this.mMainLayout.setVisibility(8);
                    ADXGDPRDialog.this.mDenyLayout.setVisibility(0);
                    ADXGdprManager.saveResultGDPR(ADXGDPRDialog.this.getContext(), ADXGDPR.ADXConsentState.ADXConsentStateDenied);
                } else if (view == ADXGDPRDialog.this.mBtnCloseWindowForConfirm || view == ADXGDPRDialog.this.mBtnCloseWindowForDeny) {
                    ADXGDPRDialog.this.dismiss();
                }
            }
        };
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.adx_dialog_gdpr);
        this.mMainLayout = findViewById(R.id.mainLayout);
        this.mConfirmLayout = findViewById(R.id.confirmLayout);
        this.mDenyLayout = findViewById(R.id.denyLayout);
        this.mTextViewDescription = (TextView) findViewById(R.id.adx_textview_description);
        Button button = (Button) findViewById(R.id.adx_btn_ok);
        this.mBtnOk = button;
        button.setOnClickListener(this.mClickListener);
        Button button2 = (Button) findViewById(R.id.adx_btn_cancel);
        this.mBtnCancel = button2;
        button2.setOnClickListener(this.mClickListener);
        Button button3 = (Button) findViewById(R.id.adx_btn_close_window_confirm);
        this.mBtnCloseWindowForConfirm = button3;
        button3.setOnClickListener(this.mClickListener);
        Button button4 = (Button) findViewById(R.id.adx_btn_close_window_deny);
        this.mBtnCloseWindowForDeny = button4;
        button4.setOnClickListener(this.mClickListener);
        setLearnMoreSpan();
    }

    private void setLearnMoreSpan() {
        String string = this.mTextViewDescription.getText().toString();
        int iIndexOf = string.indexOf("Learn more.");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new URLSpan(ADXGdprManager.getPrivacyURL()), iIndexOf, iIndexOf + 11, 33);
        this.mTextViewDescription.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTextViewDescription.setText(spannableString);
    }
}
