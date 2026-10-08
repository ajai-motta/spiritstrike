package com.hive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.player.UnityPlayerActivity;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes3.dex */
public class HiveUnityPlayerActivity extends UnityPlayerActivity {
    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (((X509Certificate) CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509).generateCertificate(new ByteArrayInputStream(getPackageManager().getPackageInfo(getPackageName(), 64).signatures[0].toByteArray()))).getSubjectX500Principal().equals(new X500Principal("CN=Android Debug,O=Android,C=US"))) {
                Toast.makeText(this, "This signing is debug signing.", 1).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        HiveActivity.onCreate(this, bundle);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        HiveActivity.onStart(this);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onStop() {
        HiveActivity.onStop(this);
        super.onStop();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onDestroy() {
        HiveActivity.onDestroy(this);
        super.onDestroy();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onPause() {
        HiveActivity.onPause(this);
        super.onPause();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        HiveActivity.onResume(this);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        HiveActivity.onConfigurationChanged(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        HiveActivity.onWindowFocusChanged(this, z);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        HiveActivity.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        HiveActivity.onRequestPermissionsResult(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        HiveActivity.onActivityResult(this, i, i2, intent);
    }

    public void onSaveInstanceState(Activity activity, Bundle bundle) {
        super.onSaveInstanceState(bundle);
        HiveActivity.onSaveInstanceState(activity, bundle);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, android.content.res.Configuration configuration) {
        super.onMultiWindowModeChanged(z, configuration);
        HiveActivity.onMultiWindowModeChanged(this, z, configuration);
    }
}
