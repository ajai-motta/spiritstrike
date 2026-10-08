package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.applovin.impl.a5;
import com.applovin.impl.d2;
import com.applovin.impl.e6;
import com.applovin.impl.j5;
import com.applovin.impl.l1;
import com.applovin.impl.s6;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u;
import com.applovin.impl.y4;
import com.applovin.sdk.AppLovinAdType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f625a;
    private final c b;
    private final List c = Collections.synchronizedList(new ArrayList());

    public interface a {
        void a(com.applovin.impl.sdk.ad.b bVar);
    }

    public d(k kVar) {
        this.f625a = kVar;
        this.b = new c(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(c.a aVar) {
        if (aVar == null) {
            this.f625a.O();
            if (o.a()) {
                this.f625a.O().a("AdPersistenceManager", "Ad failed to persist");
                return;
            }
            return;
        }
        this.c.add(aVar);
        if (((Boolean) this.f625a.a(y4.d1)).booleanValue()) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f625a.q0().b(a5.E);
        this.b.a();
    }

    private void e() {
        String str = (String) this.f625a.q0().a(a5.E);
        if (str == null) {
            return;
        }
        JSONArray jsonArray = JsonUtils.toJsonArray(str, new JSONArray());
        for (int length = jsonArray.length() - 1; length >= 0; length--) {
            try {
                c.a aVarA = c.a.a(JsonUtils.getJSONObject(jsonArray, length, new JSONObject()), this.f625a);
                if (aVarA != null) {
                    if (a(aVarA)) {
                        long jC = aVarA.c() - SystemClock.elapsedRealtime();
                        this.f625a.g().d(d2.Y, CollectionUtils.map("details", "ttl = " + jC + "ms"));
                    } else {
                        this.c.add(0, aVarA);
                    }
                }
            } catch (Throwable th) {
                this.f625a.O();
                if (o.a()) {
                    this.f625a.O().a("AdPersistenceManager", "Failed to deserialize persisted ad file path", th);
                }
                this.f625a.D().a("AdPersistenceManager", "deserializePersistedAdFilePath", th);
            }
        }
    }

    private void f() {
        this.f625a.r0().a((j5) new s6(this.f625a, "loadPersistedAdFilesQueueAndCleanupAsync", new Runnable() { // from class: com.applovin.impl.sdk.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        }), e6.b.OTHER);
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.c) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(((c.a) it.next()).a());
                } catch (Throwable th) {
                    this.f625a.O();
                    if (o.a()) {
                        this.f625a.O().a("AdPersistenceManager", "Failed to serialize persisted ad file path", th);
                    }
                    this.f625a.D().a("AdPersistenceManager", "serializePersistedAdFilePath", th);
                }
            }
        }
        this.f625a.q0().b(a5.E, new JSONArray((Collection) arrayList).toString());
    }

    public void a(final u uVar, final a aVar) {
        if (aVar == null) {
            this.f625a.O();
            if (o.a()) {
                this.f625a.O().b("AdPersistenceManager", "Persisted ad could not be retrieved: listener is null");
            }
            l1.a("Persisted ad could not be retrieved: listener is null", new Object[0]);
            return;
        }
        if (uVar == null) {
            a(aVar, null, null, "Persisted ad could not be retrieved: adZone is null");
            return;
        }
        this.f625a.g().a(d2.V, uVar, (AppLovinError) null);
        final c.a aVarA = a(uVar.g());
        this.b.a(aVarA, new c.InterfaceC0159c() { // from class: com.applovin.impl.sdk.d$$ExternalSyntheticLambda0
            @Override // com.applovin.impl.sdk.c.InterfaceC0159c
            public final void a(com.applovin.impl.sdk.ad.b bVar, String str) {
                this.f$0.a(aVar, aVarA, uVar, bVar, str);
            }
        });
    }

    public void b() {
        f();
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
    }

    public void g() {
        this.f625a.r0().a((j5) new s6(this.f625a, "resetManagerState", new Runnable() { // from class: com.applovin.impl.sdk.d$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        }), e6.b.OTHER);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        h();
    }

    private void d(c.a aVar) {
        if (aVar != null && this.c.remove(aVar)) {
            this.b.b(aVar);
        }
    }

    public void b(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f625a.g().a(d2.S, bVar);
        this.b.b(bVar, new c.b() { // from class: com.applovin.impl.sdk.d$$ExternalSyntheticLambda3
            @Override // com.applovin.impl.sdk.c.b
            public final void a(c.a aVar) {
                this.f$0.c(aVar);
            }
        });
    }

    private boolean b(c.a aVar) {
        long jB = aVar.b();
        return (jB == 0 || jB == k.n()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        e();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, c.a aVar2, u uVar, com.applovin.impl.sdk.ad.b bVar, String str) {
        if (bVar != null && !StringUtils.isValidString(str)) {
            a(aVar, bVar, aVar2);
        } else {
            a(aVar, aVar2, uVar, str);
        }
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            return;
        }
        d(c.a.a(bVar));
    }

    private c.a a(AppLovinAdType appLovinAdType) {
        c.a aVar;
        synchronized (this.c) {
            Iterator it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = (c.a) it.next();
                if (aVar.f().equals(appLovinAdType) && !a(aVar) && b(aVar)) {
                    break;
                }
            }
            this.c.remove(aVar);
        }
        return aVar;
    }

    private void a(a aVar, c.a aVar2, u uVar, String str) {
        if (aVar == null) {
            return;
        }
        this.f625a.O();
        if (o.a()) {
            this.f625a.O().a("AdPersistenceManager", str);
        }
        aVar.a(null);
        this.b.b(aVar2);
        this.f625a.g().a(d2.X, uVar, new AppLovinError(-1, str));
    }

    private void a(a aVar, com.applovin.impl.sdk.ad.b bVar, c.a aVar2) {
        if (aVar == null) {
            return;
        }
        this.f625a.O();
        if (o.a()) {
            this.f625a.O().a("AdPersistenceManager", "Loading persisted ad");
        }
        aVar.a(bVar);
        this.b.b(aVar2);
        this.f625a.g().a(d2.W, bVar);
    }

    private boolean a(c.a aVar) {
        return SystemClock.elapsedRealtime() + ((Long) this.f625a.a(y4.f1)).longValue() >= aVar.c();
    }

    private void a() {
        synchronized (this.c) {
            this.b.a(new ArrayList(this.c));
        }
    }
}
