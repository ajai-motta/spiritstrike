package com.bytedance.adsdk.qdl.ud.ud.qdl;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class wd implements com.bytedance.adsdk.qdl.ud.ud.qdl {
    private final Object qdl;

    public wd(String str) {
        if (str.equalsIgnoreCase("true")) {
            this.qdl = Boolean.TRUE;
        } else if (str.equalsIgnoreCase("false")) {
            this.qdl = Boolean.FALSE;
        } else {
            if (str.equalsIgnoreCase(AbstractJsonLexerKt.NULL)) {
                this.qdl = null;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public Object qdl(Map<String, JSONObject> map) {
        return this.qdl;
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public com.bytedance.adsdk.qdl.ud.mml.mzz qdl() {
        return com.bytedance.adsdk.qdl.ud.mml.mo.CONSTANT;
    }

    public String toString() {
        return "KeywordNode [keywordValue=" + this.qdl + "]";
    }

    @Override // com.bytedance.adsdk.qdl.ud.ud.qdl
    public String ud() {
        Object obj = this.qdl;
        if (obj != null) {
            return obj.toString();
        }
        return "NULL";
    }
}
