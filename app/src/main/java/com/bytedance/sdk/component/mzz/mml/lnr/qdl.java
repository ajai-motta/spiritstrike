package com.bytedance.sdk.component.mzz.mml.lnr;

import com.bytedance.sdk.component.mzz.exc;
import com.bytedance.sdk.component.mzz.jtx;
import com.bytedance.sdk.component.mzz.rq;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class qdl<T> {
    private lnr qdl;
    private exc ud;

    public qdl(lnr lnrVar, exc excVar) {
        this.qdl = lnrVar;
        this.ud = excVar;
    }

    public void qdl(rq<T> rqVar) {
        try {
            exc excVar = this.ud;
            if (excVar != null) {
                excVar.qdl("success", this.qdl);
            }
            String strAaj = this.qdl.aaj();
            Map<String, List<lnr>> mapTvp = this.qdl.yt().tvp();
            List<lnr> list = mapTvp.get(strAaj);
            if (list == null) {
                jtx jtxVarJpc = this.qdl.jpc();
                if (jtxVarJpc != null) {
                    Objects.toString(jtxVarJpc);
                    this.qdl.to();
                    jtxVarJpc.qdl(rqVar);
                }
            } else {
                synchronized (list) {
                    list.size();
                    for (lnr lnrVar : list) {
                        jtx jtxVarJpc2 = lnrVar.jpc();
                        if (jtxVarJpc2 != null) {
                            Objects.toString(jtxVarJpc2);
                            lnrVar.to();
                            jtxVarJpc2.qdl(rqVar);
                        }
                    }
                    list.clear();
                    mapTvp.remove(strAaj);
                }
            }
            exc excVar2 = this.ud;
            if (excVar2 != null) {
                excVar2.ud("success", this.qdl);
            }
        } catch (Throwable unused) {
        }
    }

    public void qdl(int i, String str, Throwable th) {
        try {
            exc excVar = this.ud;
            if (excVar != null) {
                excVar.qdl("failed", this.qdl);
            }
            String strAaj = this.qdl.aaj();
            Map<String, List<lnr>> mapTvp = this.qdl.yt().tvp();
            List<lnr> list = mapTvp.get(strAaj);
            if (list == null) {
                jtx jtxVarJpc = this.qdl.jpc();
                if (jtxVarJpc != null) {
                    jtxVarJpc.qdl(i, str, th);
                }
            } else {
                synchronized (list) {
                    Iterator<lnr> it = list.iterator();
                    while (it.hasNext()) {
                        jtx jtxVarJpc2 = it.next().jpc();
                        if (jtxVarJpc2 != null) {
                            Objects.toString(jtxVarJpc2);
                            jtxVarJpc2.qdl(i, str, th);
                        }
                    }
                    list.clear();
                    mapTvp.remove(strAaj);
                }
            }
            exc excVar2 = this.ud;
            if (excVar2 != null) {
                excVar2.ud("failed", this.qdl);
            }
        } catch (Throwable unused) {
        }
    }
}
