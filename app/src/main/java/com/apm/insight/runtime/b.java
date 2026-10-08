package com.apm.insight.runtime;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.work.WorkRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f244a = -30000;
    private static File b;

    public static void a(long j) throws Throwable {
        if (j - f244a < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            return;
        }
        f244a = j;
        try {
            if (b == null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                b = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/TrackInfo/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % 86400000)) / 86400000) + DomExceptionUtils.SEPARATOR + com.apm.insight.e.f());
            }
            com.apm.insight.l.f.a(b, String.valueOf(System.currentTimeMillis()), false);
        } catch (IOException unused) {
        }
    }

    public static String a(long j, String str) {
        try {
            return com.apm.insight.l.f.a(new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/TrackInfo/" + ((j - (j % 86400000)) / 86400000) + DomExceptionUtils.SEPARATOR + str), "\n");
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static void a() {
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/TrackInfo/");
        String[] list = file.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            for (int i = 0; i < list.length - 5; i++) {
                com.apm.insight.l.f.a(new File(file, list[i]));
            }
        }
    }
}
