package com.bykv.vk.openvk.preload.geckox.f;

import com.bykv.vk.openvk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Lock> f815a = new HashMap();
    private FileLock b;
    private String c;

    private a(String str, FileLock fileLock) {
        this.c = str;
        this.b = fileLock;
    }

    public static a a(String str) throws Exception {
        Map<String, Lock> map = f815a;
        synchronized (map) {
            Lock reentrantLock = map.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                map.put(str, reentrantLock);
            }
            if (!reentrantLock.tryLock()) {
                return null;
            }
            try {
                FileLock fileLockC = FileLock.c(str);
                if (fileLockC == null) {
                    reentrantLock.unlock();
                    return null;
                }
                return new a(str, fileLockC);
            } catch (Exception e) {
                reentrantLock.lock();
                com.bykv.vk.openvk.preload.geckox.utils.a.a(new RuntimeException(e));
                return null;
            }
        }
    }

    public final void a() {
        Map<String, Lock> map = f815a;
        synchronized (map) {
            try {
                this.b.a();
                this.b.b();
                map.get(this.c).unlock();
            } catch (Throwable th) {
                f815a.get(this.c).unlock();
                throw th;
            }
        }
    }
}
