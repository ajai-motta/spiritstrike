package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedCallback;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.utils.ljh;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class TTBaseActivity extends Activity {
    protected boolean jpc = false;
    private OnBackInvokedCallback qdl;
    protected String tvp;

    protected boolean qdl() {
        return false;
    }

    private static class qdl implements OnBackInvokedCallback {
        private final WeakReference<TTBaseActivity> qdl;

        qdl(TTBaseActivity tTBaseActivity) {
            this.qdl = new WeakReference<>(tTBaseActivity);
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            TTBaseActivity tTBaseActivity = this.qdl.get();
            if (tTBaseActivity != null) {
                tTBaseActivity.ud();
            }
        }
    }

    protected void ud() {
        onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (qdl() && ljh.qdl()) {
            this.qdl = new qdl(this);
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.qdl);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (Build.VERSION.SDK_INT <= 28 && Build.VERSION.SDK_INT >= 24) {
            try {
                super.onResume();
                return;
            } catch (IllegalArgumentException e) {
                aaj.qdl("TTBaseActivity", "super.onResume() run fail", e);
                try {
                    Field declaredField = Activity.class.getDeclaredField("mCalled");
                    declaredField.setAccessible(true);
                    declaredField.set(this, Boolean.TRUE);
                    return;
                } catch (Exception e2) {
                    aaj.qdl("TTBaseActivity", "onResume set mCalled fail", e2);
                    return;
                }
            }
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                try {
                    super.onPause();
                    return;
                } catch (IllegalArgumentException unused) {
                    Field declaredField = Activity.class.getDeclaredField("mCalled");
                    declaredField.setAccessible(true);
                    declaredField.set(this, Boolean.TRUE);
                    return;
                }
            } catch (Exception unused2) {
                return;
            }
        }
        super.onPause();
    }

    public void lnr(boolean z) {
        this.jpc = z;
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (!ljh.qdl() || this.qdl == null) {
            return;
        }
        getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.qdl);
        this.qdl = null;
    }
}
