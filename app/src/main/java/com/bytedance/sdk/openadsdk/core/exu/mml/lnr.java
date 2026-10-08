package com.bytedance.sdk.openadsdk.core.exu.mml;

import com.bykv.vk.openvk.qdl.qdl.qdl.qdl;
import com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends mml {
    private final qdl mml;
    private final List<ud> qdl = Collections.synchronizedList(new ArrayList());
    private int ud = 1;
    private int lnr = 1;

    public interface ud extends qdl.InterfaceC0177qdl {
        void qdl(int i, int i2);
    }

    static /* synthetic */ int qdl(lnr lnrVar) {
        int i = lnrVar.lnr;
        lnrVar.lnr = i + 1;
        return i;
    }

    public lnr() {
        qdl qdlVar = new qdl();
        this.mml = qdlVar;
        super.qdl(qdlVar);
        qdl(500);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml
    public long jtx() {
        return super.jtx() * ((long) this.ud);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml
    public long yt() {
        long jYt = super.yt();
        return this.ud == 1 ? jYt : jYt + (((long) (this.lnr - 1)) * super.jtx());
    }

    public void lnr(int i) {
        this.ud = Math.max(1, i);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.mml
    public void qdl(qdl.InterfaceC0177qdl interfaceC0177qdl) {
        if (interfaceC0177qdl instanceof ud) {
            if (this.qdl.contains(interfaceC0177qdl)) {
                return;
            }
            this.qdl.add((ud) interfaceC0177qdl);
            return;
        }
        super.qdl(interfaceC0177qdl);
    }

    public int aaj() {
        return this.lnr;
    }

    private class qdl implements qdl.InterfaceC0177qdl {
        private qdl() {
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            lnr.qdl(lnr.this);
            if (lnr.this.lnr <= lnr.this.ud) {
                Iterator it = lnr.this.qdl.iterator();
                while (it.hasNext()) {
                    ((ud) it.next()).qdl(lnr.this.lnr, lnr.this.ud);
                }
                lnr.this.tvp();
                return;
            }
            Iterator it2 = lnr.this.qdl.iterator();
            while (it2.hasNext()) {
                ((ud) it2.next()).qdl(qdlVar);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, long j) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).qdl(qdlVar, j);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void ud(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).ud(qdlVar);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl qdlVar2) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).qdl(qdlVar, qdlVar2);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, boolean z) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).qdl(qdlVar, z);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void lnr(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).lnr(qdlVar);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i, int i2) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).qdl(qdlVar, i, i2);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i, int i2, int i3) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).qdl(qdlVar, i, i2, i3);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).qdl(qdlVar, i);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void ud(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).ud(qdlVar, i);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, long j, long j2) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).qdl(qdlVar, j, j2);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void mml(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).mml(qdlVar);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void mzz(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            Iterator it = lnr.this.qdl.iterator();
            while (it.hasNext()) {
                ((ud) it.next()).mzz(qdlVar);
            }
        }
    }
}
