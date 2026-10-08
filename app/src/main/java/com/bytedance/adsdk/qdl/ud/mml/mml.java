package com.bytedance.adsdk.qdl.ud.mml;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public enum mml implements mzz {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, mml> mo;
    private final String wd;

    static {
        HashMap map = new HashMap(128);
        mo = map;
        for (mml mmlVar : map.values()) {
            mo.put(mmlVar.qdl(), mmlVar);
        }
    }

    mml(String str) {
        this.wd = str;
    }

    public static boolean qdl(mzz mzzVar) {
        return mzzVar instanceof mml;
    }

    public String qdl() {
        return this.wd;
    }
}
