package com.bytedance.adsdk.ud.lnr;

import android.util.Pair;
import io.ktor.sse.ServerSentEventKt;

/* JADX INFO: loaded from: classes.dex */
public class wd<T> {
    T qdl;
    T ud;

    public void qdl(T t, T t2) {
        this.qdl = t;
        this.ud = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ud(pair.first, this.qdl) && ud(pair.second, this.ud);
    }

    private static boolean ud(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.qdl;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.ud;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.qdl + ServerSentEventKt.SPACE + this.ud + "}";
    }
}
