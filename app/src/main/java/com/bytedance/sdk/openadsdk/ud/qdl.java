package com.bytedance.sdk.openadsdk.ud;

import com.bytedance.sdk.component.utils.wd;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qdl {
    protected boolean qdl = false;
    private final ExecutorService ud = Executors.newSingleThreadExecutor();

    protected abstract void qdl(List<File> list);

    protected abstract boolean qdl(long j, int i);

    protected abstract boolean qdl(File file, long j, int i);

    public void qdl(File file) throws IOException {
        this.ud.submit(new CallableC0276qdl(file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(File file) throws IOException {
        if (this.qdl) {
            List<File> listQdl = wd.qdl(file);
            listQdl.toString();
            qdl(listQdl);
        } else {
            try {
                wd.ud(file);
            } catch (Throwable unused) {
            }
            qdl(wd.qdl(file.getParentFile()));
        }
    }

    long ud(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ud.qdl$qdl, reason: collision with other inner class name */
    private class CallableC0276qdl implements Callable<Void> {
        private final File ud;

        private CallableC0276qdl(File file) {
            this.ud = file;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            qdl.this.ud(this.ud);
            return null;
        }
    }
}
