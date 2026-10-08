package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {
    public static FilterInputStream a(InputStream inputStream, boolean z) {
        FilterInputStream bufferedInputStream;
        try {
            if (z) {
                IAlog.a("HttpExecutorBase: getInputStream found gzip encoding", new Object[0]);
                bufferedInputStream = new GZIPInputStream(inputStream);
            } else {
                IAlog.a("HttpExecutorBase: getInputStream no gzip encoding", new Object[0]);
                bufferedInputStream = new BufferedInputStream(inputStream);
            }
            return bufferedInputStream;
        } catch (Exception unused) {
            return null;
        }
    }

    public static l a(FilterInputStream filterInputStream, int i, String str, Map map, String str2) throws b, q1 {
        try {
            l lVar = new l(filterInputStream, i, str, map, str2);
            if (lVar.f1205a / 100 != 5) {
                return lVar;
            }
            throw new b(String.format("server returned error %d", Integer.valueOf(lVar.f1205a)));
        } catch (b e) {
            IAlog.a("failed executing network request", e, new Object[0]);
            throw new b(e);
        } catch (Exception e2) {
            IAlog.a("failed reading network response", e2, new Object[0]);
            throw new q1(e2);
        }
    }
}
