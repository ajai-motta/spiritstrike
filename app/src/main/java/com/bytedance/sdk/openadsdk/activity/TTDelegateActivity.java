package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.bjy;
import com.bytedance.sdk.openadsdk.core.koa;
import com.bytedance.sdk.openadsdk.core.mml.wd;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.core.vu;
import com.bytedance.sdk.openadsdk.core.yt;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TTDelegateActivity extends TTBaseActivity {
    private static final Map<String, wd.qdl> mml = Collections.synchronizedMap(new HashMap());
    private vu lnr;
    ljh qdl = null;
    private Intent ud;

    public static void qdl(ljh ljhVar, String str, wd.qdl qdlVar) {
        if (ljhVar == null) {
            return;
        }
        Intent intent = new Intent(yt.qdl(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 6);
        intent.putExtra("closed_listener_key", str);
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            intent.putExtra("ext_info", ljhVar.ir());
            intent.putExtra("filter_words", com.bytedance.sdk.openadsdk.tool.qdl.qdl(ljhVar.fc()));
            intent.putExtra("creative_info", ljhVar.rdz().toString());
        } else {
            intent.putExtra("meta_index", koa.qdl().qdl(ljhVar));
        }
        if (qdlVar != null) {
            if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                com.bytedance.sdk.openadsdk.core.tvp.ud().qdl(str, qdlVar);
            } else {
                mml.put(str, qdlVar);
            }
        }
        com.bytedance.sdk.component.utils.ud.qdl(yt.qdl(), intent, null);
    }

    public static void qdl(ljh ljhVar, String str) {
        qdl(ljhVar, str, null);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!rdp.mzz()) {
            finish();
            return;
        }
        mml();
        this.ud = getIntent();
        if (yt.qdl() == null) {
            yt.ud(this);
        }
    }

    private void mml() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (yt.qdl() == null) {
            yt.ud(this);
        }
        setIntent(intent);
        this.ud = intent;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        vu vuVar = this.lnr;
        if ((vuVar == null || ((com.bytedance.sdk.openadsdk.lnr.lnr) vuVar).qdl == null || !((com.bytedance.sdk.openadsdk.lnr.lnr) this.lnr).qdl.isShowing()) && this.ud != null) {
            mzz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        vu vuVar = this.lnr;
        if (vuVar != null) {
            vuVar.ud();
        }
    }

    private void mzz() {
        String strIr;
        String strQdl;
        String stringExtra;
        int intExtra = this.ud.getIntExtra("type", 0);
        if (intExtra != 1) {
            if (intExtra == 6) {
                if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                    strIr = this.ud.getStringExtra("ext_info");
                    strQdl = this.ud.getStringExtra("filter_words");
                    stringExtra = this.ud.getStringExtra("creative_info");
                } else {
                    if (this.qdl == null) {
                        this.qdl = koa.qdl().qdl(koa.qdl(this.ud));
                    }
                    ljh ljhVar = this.qdl;
                    if (ljhVar == null) {
                        finish();
                        return;
                    } else {
                        strIr = ljhVar.ir();
                        strQdl = com.bytedance.sdk.openadsdk.tool.qdl.qdl(this.qdl.fc());
                        stringExtra = "";
                    }
                }
                qdl(strIr, strQdl, this.ud.getStringExtra("closed_listener_key"), stringExtra, this.qdl);
                return;
            }
            finish();
        }
    }

    private void qdl(String str, String str2, final String str3, String str4, ljh ljhVar) {
        if (str2 != null && str != null && this.lnr == null) {
            com.bytedance.sdk.openadsdk.lnr.lnr lnrVar = new com.bytedance.sdk.openadsdk.lnr.lnr(this, str, com.bytedance.sdk.openadsdk.tool.qdl.qdl(str2), str4, ljhVar);
            this.lnr = lnrVar;
            lnrVar.qdl(str3);
            this.lnr.qdl(new vu.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.vu.qdl
                public void qdl(int i, String str5) {
                    wd.qdl qdlVarMzz;
                    if (TTDelegateActivity.mml != null && TTDelegateActivity.mml.size() > 0 && !TextUtils.isEmpty(str3) && !com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                        wd.qdl qdlVar = (wd.qdl) TTDelegateActivity.mml.get(str3);
                        if (qdlVar != null) {
                            qdlVar.qdl();
                        }
                    } else if (!TextUtils.isEmpty(str3) && (qdlVarMzz = com.bytedance.sdk.openadsdk.core.tvp.ud().mzz(str3)) != null) {
                        qdlVarMzz.qdl();
                        com.bytedance.sdk.openadsdk.core.tvp.ud().mo(str3);
                    }
                    TTDelegateActivity.this.qdl(str3);
                    TTDelegateActivity.this.finish();
                }

                @Override // com.bytedance.sdk.openadsdk.core.vu.qdl
                public void qdl() {
                    if (!((com.bytedance.sdk.openadsdk.lnr.lnr) TTDelegateActivity.this.lnr).lnr()) {
                        TTDelegateActivity.this.qdl(str3);
                        TTDelegateActivity.this.finish();
                    }
                    ((com.bytedance.sdk.openadsdk.lnr.lnr) TTDelegateActivity.this.lnr).qdl(false);
                }
            });
        }
        vu vuVar = this.lnr;
        if (vuVar != null) {
            vuVar.qdl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(String str) {
        Map<String, wd.qdl> map = mml;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.remove(str);
        if (bjy.mml()) {
            map.size();
        }
    }
}
