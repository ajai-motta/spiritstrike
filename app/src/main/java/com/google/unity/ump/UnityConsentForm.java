package com.google.unity.ump;

import android.app.Activity;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class UnityConsentForm {
    private final Activity activity;
    private final UnityConsentFormCallback callback;
    private final ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener = new AnonymousClass1(this);

    /* JADX INFO: renamed from: com.google.unity.ump.UnityConsentForm$1, reason: invalid class name */
    class AnonymousClass1 implements ConsentForm.OnConsentFormDismissedListener {
        final /* synthetic */ UnityConsentForm this$0;

        AnonymousClass1(final UnityConsentForm this$0) {
            Objects.requireNonNull(this$0);
            this.this$0 = this$0;
        }

        @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
        public void onConsentFormDismissed(final FormError error) {
            new Thread(new Runnable() { // from class: com.google.unity.ump.UnityConsentForm$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5356x3b14d05a(error);
                }
            }).start();
        }

        /* JADX INFO: renamed from: lambda$onConsentFormDismissed$0$com-google-unity-ump-UnityConsentForm$1, reason: not valid java name */
        /* synthetic */ void m5356x3b14d05a(FormError formError) {
            if (this.this$0.callback != null) {
                this.this$0.callback.onConsentFormDismissed(formError);
            }
        }
    }

    public UnityConsentForm(Activity activity, UnityConsentFormCallback callback) {
        this.activity = activity;
        this.callback = callback;
    }

    public void loadAndShowConsentFormIfRequired() {
        UserMessagingPlatform.loadAndShowConsentFormIfRequired(this.activity, this.onConsentFormDismissedListener);
    }

    public void show(ConsentForm consentForm) {
        consentForm.show(this.activity, this.onConsentFormDismissedListener);
    }

    public void showPrivacyOptionsForm() {
        UserMessagingPlatform.showPrivacyOptionsForm(this.activity, this.onConsentFormDismissedListener);
    }
}
