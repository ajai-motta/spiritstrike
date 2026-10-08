package com.bytedance.sdk.component;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private static volatile Handler ud;
    private static final Object qdl = new Object();
    private static final LinkedList<Runnable> lnr = new LinkedList<>();
    private static Object mml = new Object();

    public static void qdl(Runnable runnable, boolean z) {
        try {
            Handler handlerUd = ud();
            synchronized (qdl) {
                lnr.add(runnable);
                if (z) {
                    handlerUd.sendEmptyMessageDelayed(1, 100L);
                } else {
                    handlerUd.sendEmptyMessage(1);
                }
            }
        } catch (OutOfMemoryError unused) {
        }
    }

    private static Handler ud() {
        Handler handler;
        if (ud == null) {
            synchronized (qdl) {
                if (ud == null) {
                    HandlerThread safeHandlerThread = com.bytedance.sdk.component.qdl.qdl != null ? com.bytedance.sdk.component.qdl.qdl.getSafeHandlerThread("queued-work-looper", -2) : null;
                    if (safeHandlerThread == null) {
                        safeHandlerThread = new HandlerThread("queued-work-looper", -2);
                        safeHandlerThread.start();
                    }
                    ud = new qdl(safeHandlerThread.getLooper());
                }
                handler = ud;
            }
            return handler;
        }
        return ud;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lnr() {
        LinkedList linkedList;
        synchronized (mml) {
            synchronized (qdl) {
                LinkedList<Runnable> linkedList2 = lnr;
                linkedList = (LinkedList) linkedList2.clone();
                linkedList2.clear();
                ud().removeMessages(1);
            }
            if (linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }

    private static class qdl extends Handler {
        qdl(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    ud.lnr();
                } catch (OutOfMemoryError unused) {
                }
            }
        }
    }
}
