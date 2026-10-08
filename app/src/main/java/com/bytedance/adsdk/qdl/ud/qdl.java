package com.bytedance.adsdk.qdl.ud;

import com.bytedance.adsdk.qdl.ud.lnr.qdl.jpc;
import com.bytedance.adsdk.qdl.ud.lnr.qdl.lnr;
import com.bytedance.adsdk.qdl.ud.lnr.qdl.mml;
import com.bytedance.adsdk.qdl.ud.lnr.qdl.mo;
import com.bytedance.adsdk.qdl.ud.lnr.qdl.mzz;
import com.bytedance.adsdk.qdl.ud.lnr.qdl.to;
import com.bytedance.adsdk.qdl.ud.lnr.qdl.tvp;
import com.bytedance.adsdk.qdl.ud.lnr.qdl.ud;
import com.bytedance.adsdk.qdl.ud.lnr.qdl.wd;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class qdl {
    private static final com.bytedance.adsdk.qdl.ud.lnr.qdl qdl;
    private com.bytedance.adsdk.qdl.ud.ud.qdl lnr;
    private Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> mml = new LinkedList();
    private String mzz;
    private final com.bytedance.adsdk.qdl.ud.lnr.qdl ud;

    static {
        int i = 8;
        mo[] moVarArr = {new to(), new mml(), new tvp(), new ud(), new mzz(), new com.bytedance.adsdk.qdl.ud.lnr.qdl.qdl(), new wd(), new lnr(), new jpc()};
        final com.bytedance.adsdk.qdl.ud.lnr.qdl qdlVar = new com.bytedance.adsdk.qdl.ud.lnr.qdl() { // from class: com.bytedance.adsdk.qdl.ud.qdl.1
            @Override // com.bytedance.adsdk.qdl.ud.lnr.qdl
            public int qdl(String str, int i2, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final mo moVar = moVarArr[i];
            i--;
            qdlVar = new com.bytedance.adsdk.qdl.ud.lnr.qdl() { // from class: com.bytedance.adsdk.qdl.ud.qdl.2
                @Override // com.bytedance.adsdk.qdl.ud.lnr.qdl
                public int qdl(String str, int i2, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque) {
                    return moVar.qdl(str, i2, deque, qdlVar);
                }
            };
        }
        qdl = qdlVar;
    }

    private qdl(String str, com.bytedance.adsdk.qdl.ud.lnr.qdl qdlVar) {
        this.ud = qdlVar;
        this.mzz = str;
        try {
            qdl();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.qdl.qdl.ud(str, e);
        }
    }

    public static qdl qdl(String str) {
        return new qdl(str, qdl);
    }

    private void qdl() {
        int length = this.mzz.length();
        int i = 0;
        while (i < length) {
            int iQdl = this.ud.qdl(this.mzz, i, this.mml);
            if (iQdl == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.mzz.substring(0, i));
            }
            i = iQdl;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.qdl.ud.ud.qdl qdlVarPollFirst = this.mml.pollFirst();
            if (qdlVarPollFirst != null) {
                arrayList.add(0, qdlVarPollFirst);
            } else {
                this.lnr = com.bytedance.adsdk.qdl.ud.mzz.ud.qdl(arrayList, this.mzz, i);
                this.mml = null;
                return;
            }
        }
    }

    public <T> T qdl(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) qdl(map);
    }

    public <T> T qdl(Map<String, JSONObject> map) {
        return (T) this.lnr.qdl(map);
    }
}
