package com.fyber.inneractive.sdk.player.cache;

import coil.disk.DiskLruCache;
import com.fyber.inneractive.sdk.util.IAlog;
import io.ktor.sse.ServerSentEventKt;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Closeable {
    public static final Pattern p = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final b q = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f1230a;
    public final File b;
    public final File c;
    public final File d;
    public final long f;
    public BufferedWriter i;
    public int k;
    public f l;
    public long h = 0;
    public final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    public long m = 0;
    public final ThreadPoolExecutor n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final a o = new a(this);
    public final int e = 0;
    public final int g = 1;

    public g(File file, long j) {
        this.f1230a = file;
        this.b = new File(file, DiskLruCache.JOURNAL_FILE);
        this.c = new File(file, DiskLruCache.JOURNAL_FILE_TMP);
        this.d = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.f = j;
    }

    public static void a(g gVar, d dVar, boolean z) {
        int i;
        synchronized (gVar) {
            e eVar = dVar.f1228a;
            if (eVar.d != dVar) {
                throw new IllegalStateException();
            }
            if (z && !eVar.c) {
                for (int i2 = 0; i2 < gVar.g; i2++) {
                    if (!dVar.b[i2]) {
                        a(dVar.d, dVar, false);
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                    }
                    if (!eVar.b(i2).exists()) {
                        a(dVar.d, dVar, false);
                        return;
                    }
                }
            }
            for (int i3 = 0; i3 < gVar.g; i3++) {
                File fileB = eVar.b(i3);
                if (!z) {
                    a(fileB);
                } else if (fileB.exists()) {
                    File fileA = eVar.a(i3);
                    fileB.renameTo(fileA);
                    long j = eVar.b[i3];
                    long length = fileA.length();
                    eVar.b[i3] = length;
                    gVar.h = (gVar.h - j) + length;
                }
            }
            gVar.k++;
            eVar.d = null;
            if (eVar.c || z) {
                eVar.c = true;
                BufferedWriter bufferedWriter = gVar.i;
                StringBuilder sb = new StringBuilder("CLEAN ");
                sb.append(eVar.f1229a);
                StringBuilder sb2 = new StringBuilder();
                for (long j2 : eVar.b) {
                    sb2.append(' ');
                    sb2.append(j2);
                }
                sb.append(sb2.toString());
                sb.append('\n');
                bufferedWriter.write(sb.toString());
                if (z) {
                    gVar.m++;
                }
            } else {
                gVar.j.remove(eVar.f1229a);
                gVar.i.write("REMOVE " + eVar.f1229a + '\n');
            }
            gVar.i.flush();
            if (gVar.h > gVar.f || ((i = gVar.k) >= 2000 && i >= gVar.j.size())) {
                gVar.n.submit(gVar.o);
            }
        }
    }

    public final void b() {
        FileInputStream fileInputStream = new FileInputStream(this.b);
        Charset charset = l.f1234a;
        k kVar = new k(fileInputStream);
        try {
            String strA = kVar.a();
            String strA2 = kVar.a();
            String strA3 = kVar.a();
            String strA4 = kVar.a();
            String strA5 = kVar.a();
            if (!DiskLruCache.MAGIC.equals(strA) || !"1".equals(strA2) || !Integer.toString(this.e).equals(strA3) || !Integer.toString(this.g).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    b(kVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (kVar.e == -1) {
                        c();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), l.f1234a));
                    }
                    try {
                        kVar.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                kVar.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final synchronized void c() {
        BufferedWriter bufferedWriter = this.i;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), l.f1234a));
        try {
            bufferedWriter2.write(DiskLruCache.MAGIC);
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.e));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.g));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (e eVar : this.j.values()) {
                if (eVar.d != null) {
                    bufferedWriter2.write("DIRTY " + eVar.f1229a + '\n');
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("CLEAN ");
                    sb.append(eVar.f1229a);
                    StringBuilder sb2 = new StringBuilder();
                    for (long j : eVar.b) {
                        sb2.append(' ');
                        sb2.append(j);
                    }
                    sb.append(sb2.toString());
                    sb.append('\n');
                    bufferedWriter2.write(sb.toString());
                }
            }
            bufferedWriter2.close();
            if (this.b.exists()) {
                File file = this.b;
                File file2 = this.d;
                a(file2);
                if (!file.renameTo(file2)) {
                    throw new IOException();
                }
            }
            if (!this.c.renameTo(this.b)) {
                throw new IOException();
            }
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), l.f1234a));
        } catch (Throwable th) {
            bufferedWriter2.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.i == null) {
            return;
        }
        Iterator it = new ArrayList(this.j.values()).iterator();
        while (it.hasNext()) {
            d dVar = ((e) it.next()).d;
            if (dVar != null) {
                a(dVar.d, dVar, false);
            }
        }
        d();
        this.i.close();
        this.i = null;
    }

    public final void d() {
        while (this.h > this.f) {
            String str = (String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey();
            f fVar = this.l;
            if (fVar == null) {
                c(str);
            } else if (fVar.a(str)) {
                c(str);
            } else {
                boolean zC = false;
                for (String str2 : this.j.keySet()) {
                    if (this.l.a(str2)) {
                        zC |= c(str2);
                    }
                }
                if (!zC) {
                    return;
                }
            }
        }
    }

    public final void b(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf != -1) {
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(32, i);
            if (iIndexOf2 == -1) {
                strSubstring = str.substring(i);
                if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                    this.j.remove(strSubstring);
                    return;
                }
            } else {
                strSubstring = str.substring(i, iIndexOf2);
            }
            e eVar = (e) this.j.get(strSubstring);
            if (eVar == null) {
                eVar = new e(this, strSubstring);
                this.j.put(strSubstring, eVar);
            }
            if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
                String[] strArrSplit = str.substring(iIndexOf2 + 1).split(ServerSentEventKt.SPACE);
                eVar.c = true;
                eVar.d = null;
                if (strArrSplit.length == eVar.e.g) {
                    for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                        try {
                            eVar.b[i2] = Long.parseLong(strArrSplit[i2]);
                        } catch (NumberFormatException unused) {
                            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
                        }
                    }
                    return;
                }
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                eVar.d = new d(this, eVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    public final synchronized boolean c(String str) {
        IAlog.e("DiskLruCache remove %s", str);
        if (this.i != null) {
            if (p.matcher(str).matches()) {
                e eVar = (e) this.j.get(str);
                if (eVar != null && eVar.d == null) {
                    for (int i = 0; i < this.g; i++) {
                        File fileA = eVar.a(i);
                        if (fileA.exists() && !fileA.delete()) {
                            throw new IOException("failed to delete " + fileA);
                        }
                        long j = this.h;
                        long[] jArr = eVar.b;
                        this.h = j - jArr[i];
                        jArr[i] = 0;
                    }
                    this.k++;
                    this.i.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.j.remove(str);
                    int i2 = this.k;
                    if (i2 >= 2000 && i2 >= this.j.size()) {
                        this.n.submit(this.o);
                    }
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
        throw new IllegalStateException("cache is closed");
    }

    public static g a(File file, long j) throws IOException {
        if (j > 0) {
            File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else if (!file2.renameTo(file3)) {
                    throw new IOException();
                }
            }
            g gVar = new g(file, j);
            if (gVar.b.exists()) {
                try {
                    gVar.b();
                    gVar.a();
                    return gVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    IAlog.e("DiskLruCache delete cache", new Object[0]);
                    gVar.close();
                    l.a(gVar.f1230a);
                }
            }
            file.mkdirs();
            g gVar2 = new g(file, j);
            gVar2.c();
            return gVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final void a() throws IOException {
        a(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            int i = 0;
            if (eVar.d == null) {
                while (i < this.g) {
                    this.h += eVar.b[i];
                    i++;
                }
            } else {
                eVar.d = null;
                while (i < this.g) {
                    a(eVar.a(i));
                    a(eVar.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    public static void a(File file) throws IOException {
        IAlog.e("DiskLruCache deleteIfExists - %s", file);
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final d a(String str) {
        synchronized (this) {
            if (this.i != null) {
                if (p.matcher(str).matches()) {
                    e eVar = (e) this.j.get(str);
                    if (eVar == null) {
                        eVar = new e(this, str);
                        this.j.put(str, eVar);
                    } else if (eVar.d != null) {
                        return null;
                    }
                    d dVar = new d(this, eVar);
                    eVar.d = dVar;
                    this.i.write("DIRTY " + str + '\n');
                    this.i.flush();
                    return dVar;
                }
                throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
            }
            throw new IllegalStateException("cache is closed");
        }
    }
}
