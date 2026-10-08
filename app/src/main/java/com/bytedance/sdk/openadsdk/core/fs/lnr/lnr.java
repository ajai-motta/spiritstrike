package com.bytedance.sdk.openadsdk.core.fs.lnr;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.facebook.appevents.AppEventsConstants;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private static boolean mml;
    private static SimpleDateFormat qdl;
    private final Map<ud, String> lnr;
    private final List<String> ud;

    public lnr(List<String> list, ljh ljhVar) {
        int iVz;
        this.ud = list;
        HashMap map = new HashMap();
        this.lnr = map;
        map.put(ud.CACHEBUSTING, lnr());
        map.put(ud.TIMESTAMP, ud());
        map.put(ud.APPBUNDLE, yt.qdl().getPackageName());
        map.put(ud.PLAYERSTATE, "");
        if (ljhVar != null && ((iVz = ljhVar.vz()) == 3 || iVz == 7 || iVz == 8)) {
            map.put(ud.PLAYERSTATE, "fullscreen");
        }
        map.put(ud.SERVERSIDE, AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    private String ud() {
        if (qdl == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                qdl = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.getDefault());
            } else {
                qdl = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
                mml = true;
            }
        }
        String str = qdl.format(new Date());
        if (!mml) {
            return str;
        }
        int iUw = gy.uw();
        if (iUw < 0) {
            if (iUw <= -10) {
                return str + iUw;
            }
            return str + "-0" + (-iUw);
        }
        if (iUw < 10) {
            return str + "+0" + iUw;
        }
        return str + Marker.ANY_NON_NULL_MARKER + iUw;
    }

    public List<String> qdl() {
        ArrayList arrayList = new ArrayList();
        for (String strReplaceAll : this.ud) {
            if (!TextUtils.isEmpty(strReplaceAll)) {
                for (ud udVar : ud.values()) {
                    String str = this.lnr.get(udVar);
                    if (str == null) {
                        str = "";
                    }
                    strReplaceAll = udVar == ud.__MRC_IMPRESSION_ID__ ? strReplaceAll.replaceAll(udVar.name(), str) : strReplaceAll.replaceAll("\\[" + udVar.name() + "\\]", str);
                }
                arrayList.add(strReplaceAll);
            }
        }
        return arrayList;
    }

    public lnr qdl(com.bytedance.sdk.openadsdk.core.fs.qdl.qdl qdlVar) {
        if (qdlVar != null) {
            this.lnr.put(ud.ERRORCODE, qdlVar.qdl());
        }
        return this;
    }

    public lnr qdl(long j) {
        if (j >= 0) {
            String strUd = ud(j);
            if (!TextUtils.isEmpty(strUd)) {
                this.lnr.put(ud.CONTENTPLAYHEAD, strUd);
            }
        }
        return this;
    }

    public lnr qdl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lnr.put(ud.__MRC_IMPRESSION_ID__, str);
        }
        return this;
    }

    public lnr ud(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (Throwable unused) {
            }
            this.lnr.put(ud.ASSETURI, str);
        }
        return this;
    }

    private String lnr() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    private String ud(long j) {
        return String.format(Locale.getDefault(), "%02d:%02d:%02d.%03d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % 1000));
    }
}
