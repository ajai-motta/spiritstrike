package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ekw implements rc {
    private static final Map<Integer, String> lnr = new HashMap<Integer, String>(12) { // from class: com.bytedance.sdk.openadsdk.core.ekw.1
        {
            put(1, "abtest");
            put(2, "user_data");
            put(3, "gaid");
            put(4, "apk-sign");
            put(5, "screen_scale");
            put(6, "app_set_id_scope");
            put(7, "app_set_id");
            put(8, "installed_source");
            put(9, "app_running_time");
            put(10, "vendor");
            put(11, DeviceRequestsHelper.DEVICE_INFO_MODEL);
            put(12, "user_agent_device");
            put(13, "user_agent_webview");
            put(14, "sys_compiling_time");
            put(15, "sec_did");
            put(16, "url");
            put(17, "X-Argus");
            put(18, "X-Ladon");
            put(19, "X-Khronos");
            put(20, "X-Gorgon");
            put(21, "pangle_m");
            put(22, "screen_height");
            put(23, "screen_width");
            put(24, "rom_version");
            put(25, "carrier_name");
            put(26, "os_version");
            put(27, "conn_type");
            put(28, "boot");
            put(29, "feature_data");
            put(30, "t_ver");
            put(31, "aab");
            put(32, "w_ver");
            put(33, "is_fold");
            put(34, "abi");
            put(35, "is_multi");
        }
    };
    String qdl = "com.union_test.internationad";
    String ud = "8025677";
    private int mml = 0;

    @Override // com.bytedance.sdk.openadsdk.core.rc
    /* JADX INFO: renamed from: mml, reason: merged with bridge method [inline-methods] */
    public ekw qdl(String str) {
        tvp.ud().qdl(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    /* JADX INFO: renamed from: mzz, reason: merged with bridge method [inline-methods] */
    public ekw ud(String str) {
        tvp.ud().lnr(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public rc qdl(int i) {
        tvp.ud().mo(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public rc qdl() {
        com.bytedance.sdk.component.utils.bjy.qdl("PangleSDK-7702");
        com.bykv.vk.openvk.qdl.qdl.qdl.wd.lnr.qdl("PangleSDK-7702");
        com.bytedance.sdk.component.utils.aaj.qdl("PangleSDK-7702");
        com.bytedance.sdk.component.utils.bjy.ud();
        com.bytedance.sdk.component.wd.qdl.qdl();
        com.bykv.vk.openvk.qdl.qdl.qdl.wd.lnr.qdl();
        com.bytedance.sdk.component.utils.aaj.qdl();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public rc ud(int i) {
        tvp.ud().mml(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public int ud() {
        return tvp.ud().to();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public rc mzz(int i) {
        tvp.ud().mzz(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public int mzz() {
        return tvp.ud().rq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public String lnr() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (com.bytedance.sdk.openadsdk.core.yt.mml().koa(r5) == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b A[Catch: all -> 0x02c3, TryCatch #0 {all -> 0x02c3, blocks: (B:3:0x000b, B:5:0x0018, B:7:0x001e, B:9:0x0024, B:11:0x0032, B:18:0x004d, B:20:0x0051, B:22:0x005b, B:24:0x005f, B:27:0x0083, B:28:0x0098, B:30:0x00b3, B:34:0x00d3, B:33:0x00c2, B:35:0x00da, B:37:0x00f2, B:41:0x0109, B:43:0x0126, B:45:0x0133, B:46:0x013c, B:48:0x0210, B:49:0x0220, B:52:0x023c, B:54:0x0247, B:55:0x0259, B:57:0x0266, B:61:0x0274, B:63:0x027a, B:65:0x0287, B:66:0x029d, B:68:0x02a3, B:69:0x02a6, B:71:0x02ac, B:72:0x02b8, B:38:0x00f8, B:40:0x0104, B:14:0x003d, B:16:0x0043), top: B:76:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f A[Catch: all -> 0x02c3, TryCatch #0 {all -> 0x02c3, blocks: (B:3:0x000b, B:5:0x0018, B:7:0x001e, B:9:0x0024, B:11:0x0032, B:18:0x004d, B:20:0x0051, B:22:0x005b, B:24:0x005f, B:27:0x0083, B:28:0x0098, B:30:0x00b3, B:34:0x00d3, B:33:0x00c2, B:35:0x00da, B:37:0x00f2, B:41:0x0109, B:43:0x0126, B:45:0x0133, B:46:0x013c, B:48:0x0210, B:49:0x0220, B:52:0x023c, B:54:0x0247, B:55:0x0259, B:57:0x0266, B:61:0x0274, B:63:0x027a, B:65:0x0287, B:66:0x029d, B:68:0x02a3, B:69:0x02a6, B:71:0x02ac, B:72:0x02b8, B:38:0x00f8, B:40:0x0104, B:14:0x003d, B:16:0x0043), top: B:76:0x000b }] */
    @Override // com.bytedance.sdk.openadsdk.core.rc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String qdl(com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest r19) {
        /*
            Method dump skipped, instruction units count: 711
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ekw.qdl(com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest):java.lang.String");
    }

    private boolean tvp() {
        return "TX".equals(com.bytedance.sdk.openadsdk.core.settings.rq.lnr().gt()) || TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.settings.rq.lnr().gt());
    }

    private JSONObject ud(PAGBiddingRequest pAGBiddingRequest) {
        try {
            PAGBannerSize bannerSize = pAGBiddingRequest.getBannerSize();
            if (bannerSize != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, bannerSize.getWidth());
                if (bannerSize.getType() == 3) {
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, bannerSize.getMaxHeight());
                } else {
                    jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, bannerSize.getHeight());
                }
                jSONObject.put("type", bannerSize.getType());
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private JSONObject qdl(JSONObject jSONObject, boolean z) {
        JSONObject jSONObjectQdl;
        if (z) {
            jSONObjectQdl = PangleEncryptManager.encryptType4(jSONObject, new bch(PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN));
            uw.qdl(jSONObjectQdl);
        } else {
            jSONObjectQdl = com.bytedance.sdk.component.utils.qdl.qdl(jSONObject);
        }
        return jSONObjectQdl != null ? jSONObjectQdl : new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public boolean qdl(String str, int i, String str2, String str3, String str4) {
        if (!this.qdl.equals(yt.qdl().getPackageName()) || !this.ud.equals(tvp.ud().mml()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.component.reward.to.qdl(str, i, str2, str3, str4);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public rc lnr(int i) {
        this.mml = i;
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public int mml() {
        return this.mml;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public rc mml(int i) {
        tvp.ud().lnr(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rc
    public rc lnr(String str) {
        tvp.ud().jpc(str);
        return this;
    }

    public static void mo() {
        try {
            com.bytedance.sdk.openadsdk.yt.lnr.qdl(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ekw.2
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar.ud("bidding_token");
                    return qdlVar;
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAdManagerImpl", th.getMessage());
        }
    }

    public static void wd() {
        try {
            com.bytedance.sdk.openadsdk.yt.lnr.ud(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ekw.3
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar.ud("bidding_token");
                    return qdlVar;
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAdManagerImpl", th.getMessage());
        }
    }

    public static void jpc() {
        try {
            com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.ekw.4
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    qdlVar.ud("bidding_token");
                    return qdlVar;
                }
            });
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("TTAdManagerImpl", th.getMessage());
        }
    }
}
