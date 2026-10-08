package com.apm.insight.k;

import com.apm.insight.CrashType;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<c> f194a = new ConcurrentLinkedQueue<>();

    static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<c> concurrentLinkedQueue = f194a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        new a(jSONObject, crashType);
        while (!f194a.isEmpty()) {
            f194a.poll();
        }
        f194a = null;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f196a;
        private JSONObject b;
        private CrashType c;

        a(JSONObject jSONObject, CrashType crashType) {
            this.c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.f196a = ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
            } else {
                this.f196a = jSONObject;
            }
            this.b = jSONObject.optJSONObject("header");
        }

        public final String a() {
            return this.f196a.optString("crash_thread_name", null);
        }

        public final long b() {
            return this.f196a.optInt("app_start_time", -1);
        }

        public final String c() {
            int i = AnonymousClass1.f195a[this.c.ordinal()];
            if (i == 1) {
                return this.f196a.optString("data", null);
            }
            if (i == 2) {
                return this.f196a.optString("stack", null);
            }
            if (i != 3) {
                return null;
            }
            return this.f196a.optString("data", null);
        }
    }

    /* JADX INFO: renamed from: com.apm.insight.k.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f195a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f195a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f195a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f195a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
