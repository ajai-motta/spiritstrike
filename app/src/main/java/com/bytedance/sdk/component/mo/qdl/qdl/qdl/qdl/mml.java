package com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl;

import android.content.Context;
import com.bytedance.sdk.component.mo.qdl.jpc;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends qdl {
    @Override // com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.qdl
    public byte lnr() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.qdl
    public byte mml() {
        return (byte) 0;
    }

    public mml(Context context, com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
        super(context, qdlVar);
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.qdl, com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.lnr
    public String ud() {
        com.bytedance.sdk.component.mo.qdl.qdl.mzz mzzVarMml = jpc.wd().mml();
        if (mzzVarMml != null) {
            return mzzVarMml.qdl();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.qdl.qdl.lnr
    protected long mo() {
        return com.bytedance.sdk.component.mo.qdl.wd.qdl.ud();
    }

    public static String lnr(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }
}
