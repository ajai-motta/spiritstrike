package com.applovin.impl.mediation;

import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.a3;
import com.applovin.impl.e6;
import com.applovin.impl.i;
import com.applovin.impl.j5;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.o7;
import com.applovin.impl.q5;
import com.applovin.impl.r3;
import com.applovin.impl.s3;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t2;
import com.applovin.impl.t3;
import com.applovin.impl.u3;
import com.applovin.impl.w5;
import com.applovin.impl.y2;
import com.applovin.impl.y4;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f507a;
    private final Map b = new HashMap(4);
    private final Object c = new Object();
    private final Map d = new HashMap(4);
    private final Object e = new Object();
    private final Map f = Collections.synchronizedMap(new HashMap(4));
    private final Map g = new HashMap();
    private final Object h = new Object();

    class a implements q5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f508a;
        final /* synthetic */ Map b;
        final /* synthetic */ String c;
        final /* synthetic */ a3 d;
        final /* synthetic */ Context e;
        final /* synthetic */ a.InterfaceC0152a f;

        a(long j, Map map, String str, a3 a3Var, Context context, a.InterfaceC0152a interfaceC0152a) {
            this.f508a = j;
            this.b = map;
            this.c = str;
            this.d = a3Var;
            this.e = context;
            this.f = interfaceC0152a;
        }

        @Override // com.applovin.impl.q5.b
        public void a(JSONArray jSONArray) {
            this.b.put("sct_ms", Long.valueOf(SystemClock.elapsedRealtime() - this.f508a));
            this.b.put("calfc", Integer.valueOf(e.this.b(this.c)));
            w5 w5Var = new w5(this.d, jSONArray, this.e, e.this.f507a, this.f);
            if (((Boolean) e.this.f507a.a(r3.t8)).booleanValue()) {
                e.this.f507a.r0().a((j5) w5Var, e6.b.MEDIATION);
            } else {
                e.this.f507a.r0().a(w5Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements a.InterfaceC0152a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f509a;
        private final WeakReference b;
        private final e c;
        private final c d;
        private final MaxAdFormat e;
        private final Map f;
        private final Map g;
        private final Map h;
        private final int i;
        private long j;
        private long k;

        /* synthetic */ b(Map map, Map map2, Map map3, c cVar, MaxAdFormat maxAdFormat, long j, long j2, e eVar, k kVar, Context context, a aVar) {
            this(map, map2, map3, cVar, maxAdFormat, j, j2, eVar, kVar, context);
        }

        private void a(MaxAd maxAd) {
            Context contextO = (Context) this.b.get();
            if (contextO == null) {
                contextO = k.o();
            }
            this.j = SystemClock.elapsedRealtime();
            this.k = System.currentTimeMillis();
            this.h.put("art", i.SEQUENTIAL_OR_PRECACHE.b());
            this.c.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f, this.g, this.h, contextO, this);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, MaxError maxError) {
            this.c.d(str);
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.j;
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) maxError.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f509a.X().processWaterfallInfoPostback(maxAdWaterfallInfoImpl, maxError, this.k, jElapsedRealtime);
            }
            boolean z = maxError.getCode() == -5603 && o7.c(this.f509a) && ((Boolean) this.f509a.a(y4.B6)).booleanValue();
            if (this.f509a.a(r3.n8, this.e) && this.d.c < this.i && !z) {
                c.e(this.d);
                final int iPow = (int) Math.pow(2.0d, this.d.c);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.e$b$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(iPow, str);
                    }
                }, TimeUnit.SECONDS.toMillis(iPow));
                return;
            }
            this.d.c = 0;
            this.d.b.set(false);
            if (this.d.d != null) {
                MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxError;
                maxErrorImpl.setLoadTag(this.d.f510a);
                maxErrorImpl.setRequestLatencyMillis(jElapsedRealtime);
                t2.a(this.d.d, str, maxError);
                this.d.d = null;
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            int sizeSafely;
            y2 y2Var = (y2) maxAd;
            y2Var.i(this.d.f510a);
            y2Var.a(SystemClock.elapsedRealtime() - this.j);
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) y2Var.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f509a.X().processWaterfallInfoPostback(maxAdWaterfallInfoImpl, null, this.k, y2Var.getRequestLatencyMillis());
            }
            this.c.a(maxAd.getAdUnitId());
            this.d.c = 0;
            if (this.d.d == null) {
                this.c.a(y2Var);
                this.d.b.set(false);
                int iJ = y2Var.J();
                synchronized (this.c.e) {
                    sizeSafely = CollectionUtils.getSizeSafely((Queue) this.c.d.get(maxAd.getAdUnitId()));
                }
                if (sizeSafely < iJ) {
                    int i = sizeSafely + 1;
                    this.f509a.O();
                    if (o.a()) {
                        this.f509a.O().a("MediationAdLoadManagerV2", "Preloading waterfall " + i + " of " + iJ);
                    }
                    a(maxAd);
                    return;
                }
                return;
            }
            y2Var.A().c().a(this.d.d);
            this.d.d.onAdLoaded(y2Var);
            this.c.f.put(maxAd.getAdUnitId(), y2Var);
            if (y2Var.M().endsWith("load")) {
                this.d.d.onAdRevenuePaid(y2Var);
            }
            this.d.d = null;
            if ((!this.f509a.c(r3.i8).contains(maxAd.getAdUnitId()) && !this.f509a.a(r3.h8, maxAd.getFormat())) || this.f509a.t0().c() || this.f509a.t0().d()) {
                this.d.b.set(false);
                return;
            }
            int iJ2 = y2Var.J();
            this.f509a.O();
            if (o.a()) {
                this.f509a.O().a("MediationAdLoadManagerV2", "Preloading waterfall 1 of " + iJ2);
            }
            a(maxAd);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        private b(Map map, Map map2, Map map3, c cVar, MaxAdFormat maxAdFormat, long j, long j2, e eVar, k kVar, Context context) {
            this.f509a = kVar;
            this.b = new WeakReference(context);
            this.c = eVar;
            this.d = cVar;
            this.e = maxAdFormat;
            this.g = map2;
            this.f = map;
            this.h = map3;
            this.j = j;
            this.k = j2;
            if (CollectionUtils.getBoolean(map2, "disable_auto_retries")) {
                this.i = -1;
            } else if (maxAdFormat.isAdViewAd() && CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) {
                this.i = Math.min(2, ((Integer) kVar.a(r3.m8)).intValue());
            } else {
                this.i = ((Integer) kVar.a(r3.m8)).intValue();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, String str) {
            this.g.put("retry_delay_sec", Integer.valueOf(i));
            this.g.put("retry_attempt", Integer.valueOf(this.d.c));
            Context contextO = (Context) this.b.get();
            if (contextO == null) {
                contextO = k.o();
            }
            this.h.put("art", i.EXPONENTIAL_RETRY.b());
            this.h.put("era", Integer.valueOf(this.d.c));
            this.k = System.currentTimeMillis();
            this.c.a(str, this.e, this.f, this.g, this.h, contextO, this);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f510a;
        private final AtomicBoolean b;
        private int c;
        private volatile a.InterfaceC0152a d;

        /* synthetic */ c(String str, a aVar) {
            this(str);
        }

        static /* synthetic */ int e(c cVar) {
            int i = cVar.c;
            cVar.c = i + 1;
            return i;
        }

        private c(String str) {
            this.b = new AtomicBoolean();
            this.f510a = str;
        }
    }

    public e(k kVar) {
        this.f507a = kVar;
    }

    private y2 f(String str) {
        synchronized (this.e) {
            Queue queue = (Queue) this.d.get(str);
            if (CollectionUtils.isEmpty(queue)) {
                return null;
            }
            return (y2) queue.poll();
        }
    }

    public boolean e(String str) {
        boolean z;
        synchronized (this.e) {
            z = !CollectionUtils.isEmpty((Queue) this.d.get(str));
        }
        return z;
    }

    private String b(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            str3 = "-" + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        return sb.toString();
    }

    public Queue c(String str) {
        ArrayDeque arrayDeque = new ArrayDeque();
        y2 y2Var = (y2) this.f.get(str);
        if (y2Var != null) {
            arrayDeque.add(y2Var);
        }
        synchronized (this.c) {
            Queue queue = (Queue) this.d.get(str);
            if (queue != null) {
                arrayDeque.addAll(queue);
            }
        }
        return arrayDeque;
    }

    public void d(String str) {
        synchronized (this.h) {
            this.f507a.O();
            if (o.a()) {
                this.f507a.O().a("MediationAdLoadManagerV2", "Incrementing ad load failures count for ad unit ID: " + str);
            }
            Integer num = (Integer) this.g.get(str);
            if (num == null) {
                num = 0;
            }
            this.g.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public int b(String str) {
        int iIntValue;
        synchronized (this.h) {
            Integer num = (Integer) this.g.get(str);
            iIntValue = num != null ? num.intValue() : 0;
        }
        return iIntValue;
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, i iVar, Map map, Map map2, Context context, a.InterfaceC0152a interfaceC0152a) {
        y2 y2VarF = (this.f507a.t0().d() || o7.h(k.o())) ? null : f(str);
        if (y2VarF != null) {
            y2VarF.i(str2);
            y2VarF.A().c().a(interfaceC0152a);
            interfaceC0152a.onAdLoaded(y2VarF);
            this.f.put(str, y2VarF);
            if (y2VarF.M().endsWith("load")) {
                interfaceC0152a.onAdRevenuePaid(y2VarF);
            }
        }
        c cVarA = a(str, str2);
        if (!cVarA.b.compareAndSet(false, true)) {
            if (cVarA.d != null && cVarA.d != interfaceC0152a) {
                o.j("MediationAdLoadManagerV2", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
            }
            cVarA.d = interfaceC0152a;
            return;
        }
        if (y2VarF == null) {
            cVarA.d = interfaceC0152a;
        }
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        mapSynchronizedMap.put("art", iVar.b());
        if (StringUtils.isValidString(str2)) {
            mapSynchronizedMap.put("alt", str2);
        }
        a(str, maxAdFormat, map, map2, mapSynchronizedMap, context, new b(map, map2, mapSynchronizedMap, cVarA, maxAdFormat, SystemClock.elapsedRealtime(), System.currentTimeMillis(), this, this.f507a, context, null));
    }

    public void c(String str, String str2) {
        synchronized (this.c) {
            this.b.remove(b(str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, Context context, a.InterfaceC0152a interfaceC0152a) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a3 a3Var = new a3(str, maxAdFormat, map, map2, map3, a(str, maxAdFormat));
        this.f507a.r0().a((j5) new q5(a3Var, context, this.f507a, new a(jElapsedRealtime, map3, str, a3Var, context, interfaceC0152a)), e6.b.MEDIATION);
    }

    private com.applovin.impl.h a(String str, MaxAdFormat maxAdFormat) {
        if (((Boolean) this.f507a.a(y4.N4)).booleanValue()) {
            u3 u3VarY = this.f507a.Y();
            s3 s3Var = s3.e;
            Map mapA = u3VarY.a(s3Var, t3.a(str));
            s3.a aVar = s3.a.SESSION;
            int iA = a(mapA, aVar);
            s3.a aVar2 = s3.a.INSTALL;
            int iA2 = a(mapA, aVar2);
            Map mapA2 = this.f507a.Y().a(s3Var, t3.a(maxAdFormat));
            return new com.applovin.impl.h(iA, iA2, a(mapA2, aVar), a(mapA2, aVar2));
        }
        return new com.applovin.impl.h(-1, -1, -1, -1);
    }

    private int a(Map map, s3.a aVar) {
        Long l;
        if (map == null || (l = (Long) map.get(aVar.b())) == null) {
            return -1;
        }
        return l.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y2 y2Var) {
        synchronized (this.e) {
            Queue arrayDeque = (Queue) this.d.get(y2Var.getAdUnitId());
            if (arrayDeque == null) {
                arrayDeque = new ArrayDeque();
                this.d.put(y2Var.getAdUnitId(), arrayDeque);
            }
            arrayDeque.add(y2Var);
        }
    }

    private c a(String str, String str2) {
        c cVar;
        synchronized (this.c) {
            String strB = b(str, str2);
            cVar = (c) this.b.get(strB);
            if (cVar == null) {
                cVar = new c(str2, null);
                this.b.put(strB, cVar);
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.h) {
            this.f507a.O();
            if (o.a()) {
                this.f507a.O().a("MediationAdLoadManagerV2", "Clearing ad load failures count for ad unit ID: " + str);
            }
            this.g.remove(str);
        }
    }
}
