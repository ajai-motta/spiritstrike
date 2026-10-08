package com.bytedance.sdk.component.jpc.lnr;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends ThreadPoolExecutor {
    private int lnr;
    private int mml;
    private boolean mzz;
    private final String qdl;
    private int ud;

    private mo(qdl qdlVar) {
        super(qdlVar.ud, Integer.MAX_VALUE, qdlVar.mzz, qdlVar.wd, (BlockingQueue<Runnable>) qdlVar.tvp, qdlVar.to);
        this.mzz = false;
        String unused = qdlVar.qdl;
        Integer.valueOf(qdlVar.ud);
        Integer.valueOf(qdlVar.lnr);
        Long.valueOf(qdlVar.mzz);
        Integer.valueOf(qdlVar.mml);
        Boolean.valueOf(qdlVar.jpc);
        BlockingQueue unused2 = qdlVar.tvp;
        this.qdl = qdlVar.qdl;
        this.ud = qdlVar.ud;
        this.lnr = qdlVar.lnr;
        this.mml = qdlVar.mml;
        allowCoreThreadTimeOut(qdlVar.mo);
        this.mzz = qdlVar.jpc;
    }

    public void qdl(qdl qdlVar) {
        try {
            if (qdlVar.ud >= 0 && this.ud != qdlVar.ud) {
                int i = qdlVar.ud;
                this.ud = i;
                setCorePoolSize(i);
            }
            this.lnr = qdlVar.lnr;
            this.mml = qdlVar.mml;
            allowCoreThreadTimeOut(qdlVar.mo);
            this.mzz = qdlVar.jpc;
        } catch (Throwable th) {
            th.getMessage();
        }
        String unused = qdlVar.qdl;
        Integer.valueOf(qdlVar.ud);
        Integer.valueOf(qdlVar.lnr);
        Long.valueOf(qdlVar.mzz);
        Integer.valueOf(qdlVar.mml);
        Boolean.valueOf(qdlVar.jpc);
        BlockingQueue unused2 = qdlVar.tvp;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof ud) {
            ((ud) runnable).ud(SystemClock.elapsedRealtime());
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        boolean z = runnable instanceof ud;
        if (z) {
            ((ud) runnable).lnr(SystemClock.elapsedRealtime());
        }
        super.afterExecute(runnable, th);
        if (z) {
            ud udVar = (ud) runnable;
            udVar.ud();
            Integer.valueOf(udVar.qdl());
            Long.valueOf(udVar.lnr());
            Long.valueOf(udVar.mml());
            Long.valueOf(udVar.mzz());
        }
        lnr();
    }

    private void ud() {
        int corePoolSize;
        try {
            if (this.ud != 0 && (corePoolSize = getCorePoolSize()) < this.lnr) {
                int size = getQueue().size();
                if (getActiveCount() < this.ud || size < this.mml) {
                    return;
                }
                setCorePoolSize(this.lnr);
                Integer.valueOf(size);
                Integer.valueOf(corePoolSize);
                Integer.valueOf(this.lnr);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void lnr() {
        int corePoolSize;
        int size;
        try {
            if (this.ud != 0 && (corePoolSize = getCorePoolSize()) > this.ud && (size = getQueue().size()) == 0) {
                setCorePoolSize(this.ud);
                Integer.valueOf(size);
                Integer.valueOf(corePoolSize);
                Integer.valueOf(this.ud);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        int iQdl;
        String strUd;
        runnable.getClass();
        final RunnableFuture runnableFutureNewTaskFor = newTaskFor(runnable, null);
        if (!(runnable instanceof ud)) {
            iQdl = 6;
            strUd = "";
        } else {
            ud udVar = (ud) runnable;
            iQdl = udVar.qdl();
            strUd = udVar.ud();
        }
        if (iQdl == 0 || TextUtils.isEmpty(strUd)) {
            new RuntimeException();
        }
        execute(new ud(iQdl, strUd) { // from class: com.bytedance.sdk.component.jpc.lnr.mo.1
            @Override // java.lang.Runnable
            public void run() {
                runnableFutureNewTaskFor.run();
            }
        });
        return runnableFutureNewTaskFor;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bytedance.sdk.component.jpc.lnr.qdl qdlVarQdl;
        if (!(runnable instanceof ud)) {
            runnable = new ud("unknown", runnable) { // from class: com.bytedance.sdk.component.jpc.lnr.mo.2
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnableMo = mo();
                    if (runnableMo != null) {
                        runnableMo.run();
                    }
                }
            };
        }
        if (!"cache".equals(this.qdl)) {
            String name = Thread.currentThread().getName();
            if (!TextUtils.isEmpty(name) && name.startsWith(mml.qdl(this.qdl)) && (qdlVarQdl = lnr.qdl()) != null) {
                qdlVarQdl.qdl(this, (ud) runnable);
            }
        }
        ((ud) runnable).qdl(SystemClock.elapsedRealtime());
        try {
            super.execute(runnable);
            ud();
        } catch (Throwable th) {
            qdl(runnable, th);
        }
    }

    private void qdl(Runnable runnable, Throwable th) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Handler handlerUd = lnr.ud();
                if (handlerUd != null) {
                    handlerUd.post(runnable);
                    return;
                }
                return;
            }
            runnable.run();
        } catch (Throwable unused) {
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if ("aidl".equals(this.qdl)) {
            return Collections.emptyList();
        }
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("aidl".equals(this.qdl)) {
            return;
        }
        super.shutdown();
    }

    public boolean qdl() {
        return this.mzz;
    }

    public static class qdl {
        private String qdl = "cache";
        private int ud = 4;
        private int lnr = 100;
        private int mml = 0;
        private long mzz = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        private boolean mo = false;
        private TimeUnit wd = TimeUnit.MILLISECONDS;
        private boolean jpc = false;
        private BlockingQueue<Runnable> tvp = new PriorityBlockingQueue();
        private ThreadFactory to = null;

        public qdl mml(int i) {
            return this;
        }

        public qdl mzz(int i) {
            return this;
        }

        public qdl qdl(String str) {
            this.qdl = str;
            return this;
        }

        public qdl qdl(int i) {
            this.ud = i;
            return this;
        }

        public qdl ud(int i) {
            this.lnr = i;
            return this;
        }

        public qdl lnr(int i) {
            this.mml = i;
            return this;
        }

        public qdl qdl(long j) {
            this.mzz = j;
            return this;
        }

        public qdl qdl(boolean z) {
            this.mo = z;
            return this;
        }

        public qdl ud(boolean z) {
            this.jpc = z;
            return this;
        }

        public mo qdl() {
            if (this.to == null) {
                this.to = new mml(this.qdl);
            }
            if (this.ud < 0) {
                this.ud = 8;
            }
            if (this.ud == 0) {
                this.tvp = new SynchronousQueue();
            }
            if (this.tvp == null) {
                this.tvp = new LinkedBlockingQueue();
            }
            if (this.lnr > 100) {
                this.lnr = 100;
            }
            int i = this.lnr;
            int i2 = this.ud;
            if (i < i2) {
                this.lnr = i2;
            }
            return new mo(this);
        }
    }
}
