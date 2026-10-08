package com.bytedance.sdk.component.adexpress.dynamic.ud;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.mml.wd;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    public static int qdl(wd wdVar) {
        if (wdVar == null) {
            return 0;
        }
        String strMrf = wdVar.mrf();
        String strBch = wdVar.bch();
        if (TextUtils.isEmpty(strBch) || TextUtils.isEmpty(strMrf) || !strBch.equals("creative")) {
            return 0;
        }
        if (strMrf.equals("shake")) {
            return 2;
        }
        if (strMrf.equals("twist")) {
            return 3;
        }
        return strMrf.equals("slide") ? 1 : 0;
    }
}
