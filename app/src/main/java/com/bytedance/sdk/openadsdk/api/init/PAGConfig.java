package com.bytedance.sdk.openadsdk.api.init;

import android.text.TextUtils;
import com.bykv.vk.openvk.qdl.qdl.qdl.lnr;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.bjy;
import com.bytedance.sdk.component.wd.lnr.lnr;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.core.kdv;
import com.bytedance.sdk.openadsdk.utils.gy;

/* JADX INFO: loaded from: classes3.dex */
public final class PAGConfig implements InitConfig {
    private static String to;
    private String jpc;
    private int lnr;
    private String qdl;
    private String rq;
    private String tvp;
    private boolean ud;
    private boolean wd;
    private int mml = -1;
    private int mzz = -1;
    private int mo = 0;

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isUseTextureView() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getData() {
        return this.tvp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(String str) {
        this.tvp = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAppId() {
        return this.qdl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(String str) {
        this.qdl = str;
    }

    public boolean getDebugLog() {
        return this.ud;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(boolean z) {
        this.ud = z;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getAppIconId() {
        return this.lnr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(int i) {
        this.lnr = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i) {
        if (i < -1 || i > 1) {
            i = -1;
        }
        this.mml = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getGdpr() {
        return this.mml;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lnr(int i) {
        this.mzz = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getPA() {
        return this.mzz;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public int getTitleBarTheme() {
        return this.mo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml(int i) {
        this.mo = i;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public boolean isSupportMultiProcess() {
        return this.wd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(boolean z) {
        this.wd = z;
        lnr.qdl(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lnr(String str) {
        this.jpc = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getPackageName() {
        if (TextUtils.isEmpty(this.jpc)) {
            return to;
        }
        return this.jpc;
    }

    public static void setGDPRConsent(int i) {
        gy.tvp("setGdpr");
        if (i < -1 || i > 1) {
            i = -1;
        }
        kdv.qdl().ud(i);
    }

    public static int getGDPRConsent() {
        if (!gy.tvp("getGdpr")) {
            return -1;
        }
        int iUd = kdv.qdl().ud();
        if (iUd == 1) {
            return 0;
        }
        if (iUd == 0) {
            return 1;
        }
        return iUd;
    }

    public static void setPAConsent(int i) {
        if (gy.tvp("setPAConsent")) {
            if (i == 1 || i == 0) {
                kdv.qdl().mzz(i);
            } else {
                kdv.qdl().mzz(-2);
            }
        }
    }

    public static int getPAConsent() {
        if (gy.tvp("getPAConsent")) {
            return kdv.qdl().mzz();
        }
        return -1;
    }

    public static void debugLog(boolean z) {
        if (kdv.qdl() != null) {
            if (z) {
                kdv.qdl().lnr(1);
                kdv.qdl().qdl();
                return;
            }
            kdv.qdl().lnr(0);
            com.bytedance.sdk.component.wd.lnr.lnr.qdl(lnr.qdl.OFF);
            bjy.lnr();
            com.bykv.vk.openvk.qdl.qdl.qdl.wd.lnr.ud();
            aaj.ud();
        }
    }

    public static void setAppIconId(int i) {
        if (kdv.qdl() != null) {
            kdv.qdl().mml(i);
        }
    }

    public static void setUserData(String str) {
        if (kdv.qdl() != null) {
            kdv.qdl().ud(str);
        }
    }

    public static void setPackageName(String str) {
        to = str;
    }

    @Override // com.bytedance.sdk.openadsdk.InitConfig
    public String getAdxId() {
        return this.rq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml(String str) {
        this.rq = str;
    }

    public static class Builder {
        private String[] jpc;
        private int lnr;
        private String qdl;
        private String to;
        private String tvp;
        private boolean ud;
        private int mml = -1;
        private int mzz = -1;
        private int mo = 0;
        private boolean wd = false;
        private String rq = "";

        public Builder useTextureView(boolean z) {
            return this;
        }

        public Builder setUserData(String str) {
            this.to = str;
            return this;
        }

        public Builder appId(String str) {
            this.qdl = str;
            return this;
        }

        public Builder debugLog(boolean z) {
            this.ud = z;
            return this;
        }

        public Builder appIcon(int i) {
            this.lnr = i;
            return this;
        }

        public Builder setGDPRConsent(int i) {
            this.mml = i;
            return this;
        }

        public Builder setPAConsent(int i) {
            if (i == 0 || i == 1) {
                this.mzz = i;
            } else {
                this.mzz = -2;
            }
            return this;
        }

        public Builder setAdxId(String str) {
            this.rq = str;
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.mo = i;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.wd = z;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.jpc = strArr;
            return this;
        }

        public Builder setPackageName(String str) {
            this.tvp = str;
            return this;
        }

        public PAGConfig build() {
            PAGConfig pAGConfig = new PAGConfig();
            pAGConfig.ud(this.qdl);
            pAGConfig.qdl(this.lnr);
            pAGConfig.mml(this.mo);
            pAGConfig.ud(this.wd);
            pAGConfig.ud(this.mml);
            pAGConfig.lnr(this.mzz);
            pAGConfig.qdl(this.ud);
            pAGConfig.lnr(this.tvp);
            pAGConfig.qdl(this.to);
            pAGConfig.mml(this.rq);
            return pAGConfig;
        }
    }
}
