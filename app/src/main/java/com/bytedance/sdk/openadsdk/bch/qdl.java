package com.bytedance.sdk.openadsdk.bch;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.core.fs;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.facebook.appevents.AppEventsConstants;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private static int qdl(int i) {
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    i2 = 5;
                    if (i != 5 && i != 15) {
                        return -1;
                    }
                }
            }
        }
        return i2;
    }

    public static List<String> qdl(List<String> list, boolean z) {
        String strQdl = fs.qdl(yt.qdl());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strQdl)) {
                next = next.replace("{UID}", strQdl).replace("__UID__", strQdl);
            }
            if (z) {
                next = qdl(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static String qdl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new SecureRandom().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            aaj.lnr("TrackAdUrlUtils", e.getMessage());
            return str;
        }
    }

    public static List<String> qdl(List<String> list, boolean z, ljh ljhVar) {
        String strQdl = fs.qdl(yt.qdl());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strQdl)) {
                next = next.replace("{UID}", strQdl).replace("__UID__", strQdl);
            }
            if (next.contains("__CID__") && ljhVar != null && !TextUtils.isEmpty(ljhVar.yre())) {
                next = next.replace("__CID__", ljhVar.yre());
            }
            if (next.contains("__CTYPE__") && ljhVar != null) {
                next = next.replace("__CTYPE__", String.valueOf(qdl(ljhVar.vxg())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().ud());
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(gy.mml()));
            }
            if (z) {
                next = qdl(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
