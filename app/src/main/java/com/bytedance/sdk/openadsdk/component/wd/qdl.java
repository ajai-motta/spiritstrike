package com.bytedance.sdk.openadsdk.component.wd;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.wd;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.component.mo;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.multipro.ud;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    public static AtomicInteger qdl = new AtomicInteger(1);

    public static File qdl(String str) {
        return new File(CacheDirFactory.getICacheDir(0).ud() + File.separator + str);
    }

    public static File ud(String str) {
        return qdl(yt.qdl(), mo.qdl(yt.qdl()).ud(), str);
    }

    public static File qdl(Context context, String str, String str2) {
        return wd.qdl(context, ud.lnr(), str, str2);
    }

    public static void qdl(File file) {
        if (file == null) {
            return;
        }
        try {
            wd.ud(file);
        } catch (Throwable unused) {
        }
    }

    public static void qdl(Context context) {
        try {
            mo.qdl(context).qdl();
        } catch (Throwable unused) {
        }
    }

    public static String qdl() {
        return wd.qdl(yt.qdl(), ud.lnr(), mo.qdl(yt.qdl()).ud()).getAbsolutePath();
    }

    public static void qdl(JSONObject jSONObject, int i, boolean z) {
        try {
            String strJpc = tvp.ud().jpc();
            int iTvp = tvp.ud().tvp();
            JSONObject jSONObject2 = jSONObject.getJSONObject("creative");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, strJpc);
            if (!z) {
                jSONObject3.put("app_icon_id", "@".concat(String.valueOf(iTvp)));
            } else if (tvp.ud().tvp() != 0) {
                jSONObject3.put("app_icon_id", "local://pag_open_icon_id");
            }
            jSONObject2.put("open_app_info", jSONObject3);
            if (jSONObject2.optJSONObject("video") == null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("video_duration", yt.mml().ljh(String.valueOf(i)));
                jSONObject2.put("video", jSONObject4);
            }
        } catch (Exception e) {
            aaj.lnr("TTAppOpenUtils", e.getMessage());
        }
    }

    public static int qdl(ljh ljhVar, int i) {
        return i - ljhVar.fh();
    }

    public static long ud() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime();
        }
        return Process.getElapsedCpuTime();
    }

    public static int lnr() {
        return qdl.getAndIncrement();
    }
}
