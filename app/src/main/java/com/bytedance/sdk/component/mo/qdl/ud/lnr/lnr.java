package com.bytedance.sdk.component.mo.qdl.ud.lnr;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.component.mo.qdl.jpc;
import com.bytedance.sdk.component.mo.qdl.mzz;
import com.bytedance.sdk.component.mo.qdl.qdl.mml;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends HandlerThread implements Handler.Callback {
    private static int exc = 200;
    private static int yt = 10;
    private final int aaj;
    private final AtomicInteger bjy;
    private volatile Handler exu;
    private final AtomicInteger fs;
    private long jl;
    private volatile long jpc;
    private final AtomicInteger jtx;
    private final int jyq;
    private final Object lnr;
    private com.bytedance.sdk.component.mo.qdl.ud.lnr mml;
    private volatile int mo;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.mo.qdl.mml.qdl> mzz;
    private final int oth;
    protected mml qdl;
    private final List<com.bytedance.sdk.component.mo.qdl.mml.qdl> rdp;
    private final long rq;
    private final long to;
    private final AtomicInteger tvp;
    private volatile boolean ud;
    private volatile long wd;

    public static void qdl(int i) {
        yt = i;
    }

    public static void ud(int i) {
        exc = i;
    }

    public lnr(PriorityBlockingQueue<com.bytedance.sdk.component.mo.qdl.mml.qdl> priorityBlockingQueue) {
        super("csj_log");
        this.ud = true;
        this.lnr = new Object();
        this.wd = 0L;
        this.jpc = 0L;
        this.tvp = new AtomicInteger(0);
        this.to = 5000L;
        this.rq = 5000000000L;
        this.fs = new AtomicInteger(0);
        this.rdp = new ArrayList();
        this.bjy = new AtomicInteger(0);
        this.jtx = new AtomicInteger(0);
        this.jl = 60000L;
        this.aaj = 1;
        this.jyq = 2;
        this.oth = 3;
        this.mzz = priorityBlockingQueue;
        this.qdl = new com.bytedance.sdk.component.mo.qdl.qdl.ud();
        if (com.bytedance.sdk.component.mo.qdl.ud.ud()) {
            return;
        }
        long jRdp = jpc.wd().jtx().rdp();
        if (jRdp > 0) {
            this.jl = jRdp;
        }
    }

    public void qdl(boolean z) {
        this.ud = z;
    }

    public boolean qdl() {
        return this.ud;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
        } catch (Throwable th) {
            th.getMessage();
        }
        if (i == 1) {
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.tvp(), 1);
            ud();
            qdl(true);
            mzz();
        } else {
            if (i != 2 && i != 3) {
                if (i == 11) {
                    ArrayList arrayList = new ArrayList(this.rdp);
                    this.rdp.clear();
                    qdl((List<com.bytedance.sdk.component.mo.qdl.mml.qdl>) arrayList, false, "timeout_dispatch");
                    to();
                }
                return true;
            }
            lnr();
        }
        return true;
    }

    private void ud() {
        long jYt = jpc.wd().yt();
        if (jYt <= 0) {
            return;
        }
        this.qdl.qdl(Integer.MAX_VALUE, jYt);
    }

    private void lnr() {
        mml();
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.fco(), 1);
        lnr(1);
    }

    private void mml() {
        if (!isAlive()) {
            com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.mml();
        } else {
            if (qdl()) {
                return;
            }
            lnr(6);
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.exu = new Handler(getLooper(), this);
        com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.qdl(this.exu);
        this.exu.sendEmptyMessage(1);
    }

    public boolean qdl(int i, boolean z) {
        mzz mzzVarJtx = jpc.wd().jtx();
        if (mzzVarJtx == null || !mzzVarJtx.qdl(jpc.wd().mo())) {
            return false;
        }
        return this.qdl.qdl(i, z);
    }

    public void qdl(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar, boolean z) {
        if (qdlVar == null) {
            return;
        }
        qdlVar.mml();
        if (z) {
            if (this.exu != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(qdlVar);
                qdl((List<com.bytedance.sdk.component.mo.qdl.mml.qdl>) arrayList, true, "ignore_result_dispatch");
                return;
            }
            return;
        }
        this.mzz.add(qdlVar);
        mzz(2);
    }

    public void lnr(int i) {
        try {
            boolean zQdl = qdl(i, com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud);
            if (i == 6 || zQdl) {
                com.bytedance.sdk.component.mo.qdl.mml.ud udVar = new com.bytedance.sdk.component.mo.qdl.mml.ud();
                udVar.ud(i);
                this.mzz.add(udVar);
                mzz(3);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void qdl(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar, int i) {
        this.tvp.set(0);
        if (i == 0) {
            this.mo = ((com.bytedance.sdk.component.mo.qdl.mml.ud) qdlVar).rq();
            if (this.mo != 6) {
                com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.wc(), 1);
                ud(qdlVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.mo.qdl.mml.ud udVar = (com.bytedance.sdk.component.mo.qdl.mml.ud) qdlVar;
        if (udVar.rq() == 1) {
            this.mo = 1;
            ud(qdlVar);
        } else if (udVar.rq() == 2) {
            wd();
            this.mo = 2;
            ud(qdlVar);
        }
    }

    private void mzz() {
        while (qdl()) {
            try {
                com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.jpc(), 1);
                com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVarPoll = this.mzz.poll(this.jl, TimeUnit.MILLISECONDS);
                int size = this.mzz.size();
                if (qdlVarPoll instanceof com.bytedance.sdk.component.mo.qdl.mml.ud) {
                    qdl(qdlVarPoll, size);
                } else if (qdlVarPoll == null) {
                    int iIncrementAndGet = this.tvp.incrementAndGet();
                    com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.om(), 1);
                    if (mml(iIncrementAndGet)) {
                        mo();
                        return;
                    } else if (iIncrementAndGet < 4) {
                        this.mo = 1;
                        ud((com.bytedance.sdk.component.mo.qdl.mml.qdl) null);
                    }
                } else {
                    qdl(qdlVarPoll);
                    ud(qdlVarPoll);
                }
            } catch (Throwable th) {
                th.getMessage();
                com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.gy(), 1);
            }
        }
    }

    private boolean mml(int i) {
        return i >= 4 && this.fs.get() == 0 && !com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud && !com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.lnr;
    }

    private void mo() {
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.oth(), 1);
        qdl(false);
        com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.lnr();
    }

    private void wd() {
        if (this.mzz.size() >= 100) {
            for (int i = 0; i < 100; i++) {
                com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVarPoll = this.mzz.poll();
                if (!(qdlVarPoll instanceof com.bytedance.sdk.component.mo.qdl.mml.ud) && qdlVarPoll != null) {
                    qdl(qdlVarPoll);
                }
            }
        }
    }

    private void qdl(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar) {
        this.tvp.set(0);
        if (com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud) {
            this.mo = 5;
        } else if (com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.lnr) {
            this.mo = 7;
        } else {
            this.mo = 4;
        }
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.xi(), 1);
        this.qdl.qdl(qdlVar, this.mo);
        com.bytedance.sdk.component.mo.qdl.lnr.qdl.wd(qdlVar);
    }

    private boolean jpc() {
        if (com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud) {
            return this.mo == 4 || this.mo == 7 || this.mo == 6 || this.mo == 5 || this.mo == 2;
        }
        return false;
    }

    private void ud(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar) {
        List<com.bytedance.sdk.component.mo.qdl.mml.qdl> listQdl;
        if (com.bytedance.sdk.component.mo.qdl.lnr.qdl.ud() && jpc.wd().qdl()) {
            return;
        }
        int i = 0;
        if (jpc()) {
            com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl(this.mo);
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.fs(), 1);
            if (this.mzz.size() != 0) {
                return;
            }
            if (!this.exu.hasMessages(2)) {
                com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud = false;
                this.jpc = 0L;
                this.wd = 0L;
                this.bjy.set(0);
                this.jtx.set(0);
            } else {
                qdl(false);
                return;
            }
        }
        do {
            boolean zQdl = qdl(this.mo, com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud);
            com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl(zQdl, this.mo, qdlVar);
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.exu(), 1);
            if (zQdl && (listQdl = this.qdl.qdl(this.mo, -1, null)) != null) {
                listQdl.size();
                qdl(listQdl);
            } else {
                tvp();
            }
            i++;
            if (!zQdl) {
                return;
            }
        } while (i <= 6);
    }

    private void tvp() {
        try {
            if (this.mzz.size() == 0 && this.exu.hasMessages(11) && qdl()) {
                qdl(false);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void qdl(List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list, String str) {
        qdl(str);
        qdl(list, false, str);
        to();
    }

    private void qdl(List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list) {
        if (list.size() != 0) {
            com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl(list, this.mzz.size());
            if (list.size() > 1 || com.bytedance.sdk.component.mo.qdl.lnr.qdl.lnr()) {
                qdl(list, "batchRead");
                return;
            }
            com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar = list.get(0);
            if (qdlVar != null) {
                if (qdlVar.mzz() == 1) {
                    qdl(list, "highPriority");
                    return;
                }
                if (qdlVar.mml() == 0 && qdlVar.mzz() == 2) {
                    if (qdlVar.ud() == 3) {
                        qdl(list, "version_v3");
                        return;
                    } else {
                        ud(list);
                        return;
                    }
                }
                if (qdlVar.mml() == 1) {
                    qdl(list, "stats");
                    return;
                } else if (qdlVar.mml() == 3) {
                    qdl(list, "adType_v3");
                    return;
                } else {
                    if (qdlVar.mml() == 2) {
                        qdl(list, "other");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        tvp();
    }

    private void ud(List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list) {
        this.rdp.addAll(list);
        this.rdp.size();
        mzz mzzVarJtx = jpc.wd().jtx();
        if (mzzVarJtx != null && mzzVarJtx.fs() != null) {
            yt = mzzVarJtx.fs().ud();
        }
        if (this.rdp.size() >= yt) {
            if (this.exu.hasMessages(11)) {
                this.exu.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.rdp);
            this.rdp.clear();
            qdl((List<com.bytedance.sdk.component.mo.qdl.mml.qdl>) arrayList, false, "max_size_dispatch");
            to();
            return;
        }
        if (this.mzz.size() == 0) {
            qdl(false);
            if (this.exu.hasMessages(11)) {
                this.exu.removeMessages(11);
            }
            if (this.exu.hasMessages(1)) {
                this.exu.removeMessages(1);
            }
            long jQdl = exc;
            if (mzzVarJtx != null && mzzVarJtx.fs() != null) {
                jQdl = mzzVarJtx.fs().qdl();
            }
            this.exu.sendEmptyMessageDelayed(11, jQdl);
            return;
        }
        this.rdp.size();
    }

    private void qdl(String str) {
        if (this.exu.hasMessages(11)) {
            this.exu.removeMessages(11);
        }
        if (this.rdp.size() != 0) {
            ArrayList arrayList = new ArrayList(this.rdp);
            this.rdp.clear();
            qdl((List<com.bytedance.sdk.component.mo.qdl.mml.qdl>) arrayList, false, "before_".concat(String.valueOf(str)));
            to();
            arrayList.size();
        }
    }

    private void qdl(List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list, boolean z, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl(list, this.mo, str);
        com.bytedance.sdk.component.mo.qdl.ud.lnr lnrVarJpc = jpc.wd().jpc();
        this.mml = lnrVarJpc;
        if (lnrVarJpc != null) {
            ud(list, z, jCurrentTimeMillis);
        } else {
            qdl(list, z, jCurrentTimeMillis);
        }
    }

    private void qdl(final List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list, final boolean z, final long j) {
        mzz mzzVarJtx = jpc.wd().jtx();
        if (mzzVarJtx != null) {
            Executor executorMzz = mzzVarJtx.mzz();
            if (list.get(0).mzz() == 1) {
                executorMzz = mzzVarJtx.mml();
            }
            if (executorMzz == null) {
                return;
            }
            this.fs.incrementAndGet();
            executorMzz.execute(new com.bytedance.sdk.component.mo.qdl.mzz.mzz("csj_log_upload") { // from class: com.bytedance.sdk.component.mo.qdl.ud.lnr.lnr.1
                @Override // java.lang.Runnable
                public void run() {
                    lnr lnrVar = lnr.this;
                    lnrVar.qdl((List<com.bytedance.sdk.component.mo.qdl.mml.qdl>) list, z, j, lnrVar.mo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list, boolean z, long j, int i) {
        ud udVarQdl;
        try {
            com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar = list.get(0);
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.dk(), 1);
            if (qdlVar.mml() == 0) {
                udVarQdl = jpc.mzz().qdl(list);
                qdl(udVarQdl, list);
                if (udVarQdl != null) {
                    com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl(list, udVarQdl.mml);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.mo.qdl.mml.qdl> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().wd());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    e.getMessage();
                }
                udVarQdl = jpc.mzz().qdl(jSONObject);
            }
            ud udVar = udVarQdl;
            this.fs.decrementAndGet();
            qdl(z, udVar, list, j);
        } catch (Throwable th) {
            th.getMessage();
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.gy(), 1);
            this.fs.decrementAndGet();
        }
    }

    private void ud(List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list, final boolean z, final long j) {
        this.fs.incrementAndGet();
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.dk(), 1);
        try {
            HashMap map = new HashMap();
            Iterator<com.bytedance.sdk.component.mo.qdl.mml.qdl> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.mo.qdl.mml.qdl next = it.next();
                int i = next == null ? 0 : next.to();
                if (map.get(Integer.valueOf(i)) == null) {
                    map.put(Integer.valueOf(i), new ArrayList());
                }
                ((List) map.get(Integer.valueOf(i))).add(next);
            }
            for (Integer num : map.keySet()) {
                if (num.intValue() == 0 || jpc.wd().lnr() == null || jpc.wd().lnr().get(num) == null) {
                    this.mml.qdl(list, new com.bytedance.sdk.component.mo.qdl.ud.ud() { // from class: com.bytedance.sdk.component.mo.qdl.ud.lnr.lnr.2
                        @Override // com.bytedance.sdk.component.mo.qdl.ud.ud
                        public void qdl(List<qdl> list2) {
                            try {
                                lnr.this.fs.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    qdl qdlVar = list2.get(i2);
                                    if (qdlVar != null) {
                                        lnr.this.qdl(z, qdlVar.qdl(), qdlVar.ud(), j);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                } else {
                    jpc.wd().lnr().get(num).qdl(list, new com.bytedance.sdk.component.mo.qdl.ud.ud() { // from class: com.bytedance.sdk.component.mo.qdl.ud.lnr.lnr.3
                        @Override // com.bytedance.sdk.component.mo.qdl.ud.ud
                        public void qdl(List<qdl> list2) {
                            try {
                                lnr.this.fs.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    qdl qdlVar = list2.get(i2);
                                    if (qdlVar != null) {
                                        lnr.this.qdl(z, qdlVar.qdl(), qdlVar.ud(), j);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            e.getMessage();
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.gy(), 1);
            this.fs.decrementAndGet();
        }
    }

    private void mzz(int i) {
        if (!qdl()) {
            if (this.exu == null) {
                return;
            }
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.lnr(), 1);
            if (this.exu.hasMessages(1)) {
                return;
            }
            if (i == 1) {
                com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.mo(), 1);
            } else if (i == 2) {
                com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.mml(), 1);
            } else if (i == 3) {
                com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.mzz(), 1);
            }
            this.exu.sendEmptyMessage(1);
            return;
        }
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.qdl(), 1);
    }

    private void qdl(ud udVar, List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list) {
        if (udVar == null || !udVar.qdl) {
            return;
        }
        List<Object> listQdl = com.bytedance.sdk.component.mo.qdl.ud.qdl();
        if (list == null || listQdl == null || listQdl.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar : list) {
            if (qdlVar.mzz() == 1) {
                com.bytedance.sdk.component.mo.qdl.lnr.qdl.qdl(qdlVar);
                com.bytedance.sdk.component.mo.qdl.lnr.qdl.mzz(qdlVar);
                Iterator<Object> it = listQdl.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    private void to() {
        long jNanoTime;
        if (this.exu.hasMessages(11)) {
            tvp();
        } else {
            mzz(1);
        }
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.ud(), 1);
        if (this.mo == 2) {
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.wd(), 1);
            synchronized (this.lnr) {
                try {
                    try {
                        long jNanoTime2 = System.nanoTime();
                        this.lnr.wait(5000L);
                        jNanoTime = System.nanoTime() - jNanoTime2;
                        if (!com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud) {
                            boolean z = com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.lnr;
                        }
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    if (jNanoTime < 5000000000L && 5000000000L - jNanoTime >= 50000000) {
                        if (!com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud && !com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.lnr) {
                            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.mrf(), 1);
                            lnr(2);
                            return;
                        }
                        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.rq(), 1);
                        return;
                    }
                    com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.to(), 1);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(boolean z, ud udVar, List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list, long j) {
        if (z || udVar == null) {
            return;
        }
        int i = udVar.ud;
        int i2 = -2;
        if (udVar.mzz) {
            i = -1;
        } else if (i < 0) {
            i = -2;
        }
        if (i == 510 || i == 511) {
            i = -2;
        }
        if (udVar.qdl || ((i < 500 || i >= 509) && i <= 513)) {
            i2 = i;
        }
        if (list != null) {
            list.size();
            this.fs.get();
        }
        qdl(i2, list, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4 A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:53:0x00eb, B:55:0x00ef, B:56:0x00f4, B:18:0x0030, B:20:0x0040, B:22:0x0042, B:24:0x004f, B:26:0x0051, B:28:0x005f, B:29:0x0064, B:30:0x0069, B:32:0x006f, B:34:0x0075, B:36:0x0085, B:37:0x008a, B:39:0x0092, B:40:0x0097, B:41:0x00b4, B:43:0x00c4, B:45:0x00c6, B:47:0x00d3, B:49:0x00d5, B:51:0x00e3, B:52:0x00e8, B:59:0x00fb), top: B:64:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(int r6, java.util.List<com.bytedance.sdk.component.mo.qdl.mml.qdl> r7, long r8) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.mo.qdl.ud.lnr.lnr.qdl(int, java.util.List, long):void");
    }

    public void qdl(int i, long j) {
        if (this.exu == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        if (i == 2) {
            this.exu.sendMessageDelayed(messageObtain, ((long) (((this.bjy.incrementAndGet() - 1) % 4) + 1)) * j);
        } else if (i == 3) {
            this.exu.sendMessageDelayed(messageObtain, ((long) (((this.jtx.incrementAndGet() - 1) % 4) + 1)) * j);
        }
    }
}
