package com.bykv.vk.openvk.qdl.qdl.ud.qdl.ud;

import android.content.Context;
import com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class lnr {
    public static final ConcurrentHashMap<String, ud> qdl = new ConcurrentHashMap<>();

    public static synchronized void qdl(Context context, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, qdl.InterfaceC0176qdl interfaceC0176qdl) {
        if (lnrVar == null) {
            return;
        }
        ConcurrentHashMap<String, ud> concurrentHashMap = qdl;
        ud udVar = concurrentHashMap.get(lnrVar.yt());
        if (udVar == null) {
            udVar = new ud(context, lnrVar);
            concurrentHashMap.put(lnrVar.yt(), udVar);
            Integer.valueOf(lnrVar.mo());
            lnrVar.yt();
        }
        udVar.qdl(interfaceC0176qdl);
        Integer.valueOf(lnrVar.mo());
        lnrVar.yt();
    }

    public static synchronized void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        ud udVarRemove = qdl.remove(lnrVar.yt());
        if (udVarRemove != null) {
            udVarRemove.qdl(true);
        }
        Integer.valueOf(lnrVar.mo());
        lnrVar.yt();
    }
}
