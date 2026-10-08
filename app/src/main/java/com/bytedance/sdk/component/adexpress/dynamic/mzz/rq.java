package com.bytedance.sdk.component.adexpress.dynamic.mzz;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.mzz.ud;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class rq {
    private static final Set<String> qdl = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", "close", "close-fill", "webview-close")));
    private static String ud;

    /* JADX WARN: Removed duplicated region for block: B:224:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x045f A[Catch: Exception -> 0x0470, JSONException -> 0x0474, TryCatch #0 {Exception -> 0x0470, blocks: (B:225:0x0455, B:227:0x045f, B:232:0x0469), top: B:276:0x0455 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.mzz.ud.lnr qdl(java.lang.String r20, java.lang.String r21, java.lang.String r22, boolean r23, boolean r24, int r25, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc r26, double r27, int r29, double r30, java.lang.String r32, com.bytedance.sdk.component.adexpress.ud.exu r33) {
        /*
            Method dump skipped, instruction units count: 1305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.qdl(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.ud.exu):com.bytedance.sdk.component.adexpress.dynamic.mzz.ud$lnr");
    }

    public static String qdl(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static ud.lnr qdl(ud.lnr lnrVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            lnrVar.qdl = 0.0f;
            lnrVar.ud = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = qdl(str);
            }
            if (TextUtils.isEmpty(str3)) {
                lnrVar.qdl = 0.0f;
                lnrVar.ud = 0.0f;
            } else {
                return qdl(str3, str2);
            }
        }
        return lnrVar;
    }

    public static ud.lnr qdl(String str, String str2) {
        return qdl(str, str2, false);
    }

    public static ud.lnr qdl(String str, String str2, boolean z) {
        ud.lnr lnrVar = new ud.lnr();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrQdl = qdl(str, (float) ud(str2), z);
            lnrVar.qdl = iArrQdl[0];
            lnrVar.ud = iArrQdl[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                lnrVar.ud = 0.0f;
            }
        } catch (Exception unused) {
        }
        return lnrVar;
    }

    public static double ud(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString(TtmlNode.ATTR_TTS_FONT_SIZE));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] qdl(String str, float f, boolean z) {
        int[] iArrUd = ud(str, f, z);
        return new int[]{com.bytedance.sdk.component.adexpress.mml.wd.ud(com.bytedance.sdk.component.adexpress.mml.qdl(), iArrUd[0]), com.bytedance.sdk.component.adexpress.mml.wd.ud(com.bytedance.sdk.component.adexpress.mml.qdl(), iArrUd[1])};
    }

    public static int[] ud(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.mml.qdl());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String qdl() {
        return ud;
    }

    public static boolean ud() {
        return !TextUtils.isEmpty(ud);
    }
}
