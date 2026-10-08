package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.t1;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a implements AppLovinBroadcastManager.Receiver {
    private static final long e = TimeUnit.SECONDS.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f616a;
    private final o b;
    private final HashSet c = new HashSet();
    private final Object d = new Object();

    /* JADX INFO: renamed from: com.applovin.impl.sdk.a$a, reason: collision with other inner class name */
    public interface InterfaceC0157a {
        void onAdExpired(t1 t1Var);
    }

    public a(k kVar) {
        this.f616a = kVar;
        this.b = kVar.O();
    }

    private b b(t1 t1Var) {
        synchronized (this.d) {
            if (t1Var == null) {
                return null;
            }
            for (b bVar : this.c) {
                if (t1Var == bVar.b()) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public boolean a(t1 t1Var, InterfaceC0157a interfaceC0157a) {
        synchronized (this.d) {
            if (b(t1Var) != null) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Ad expiration already scheduled for ad: " + t1Var);
                }
                return true;
            }
            if (t1Var.getTimeToLiveMillis() <= e) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Ad has already expired: " + t1Var);
                }
                t1Var.setExpired();
                return false;
            }
            if (o.a()) {
                this.b.a("AdExpirationManager", "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(t1Var.getTimeToLiveMillis()) + " seconds from now for " + t1Var + "...");
            }
            if (this.c.isEmpty()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
            this.c.add(b.a(t1Var, interfaceC0157a, this.f616a));
            return true;
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            a();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            b();
        }
    }

    private void b() {
        HashSet<b> hashSet = new HashSet();
        synchronized (this.d) {
            for (b bVar : this.c) {
                t1 t1VarB = bVar.b();
                if (t1VarB == null) {
                    hashSet.add(bVar);
                } else {
                    long timeToLiveMillis = t1VarB.getTimeToLiveMillis();
                    if (timeToLiveMillis <= 0) {
                        if (o.a()) {
                            this.b.a("AdExpirationManager", "Ad expired while app was paused. Preparing to notify listener for ad: " + t1VarB);
                        }
                        hashSet.add(bVar);
                    } else {
                        if (o.a()) {
                            this.b.a("AdExpirationManager", "Rescheduling expiration with remaining " + TimeUnit.MILLISECONDS.toSeconds(timeToLiveMillis) + " seconds for ad: " + t1VarB);
                        }
                        bVar.a(timeToLiveMillis);
                    }
                }
            }
        }
        for (b bVar2 : hashSet) {
            a(bVar2);
            bVar2.d();
        }
    }

    public void a(t1 t1Var) {
        synchronized (this.d) {
            b bVarB = b(t1Var);
            if (bVarB != null) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Cancelling expiration timer for ad: " + t1Var);
                }
                bVarB.a();
                a(bVarB);
            }
        }
    }

    public void a(b bVar) {
        synchronized (this.d) {
            this.c.remove(bVar);
            if (this.c.isEmpty()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    private void a() {
        synchronized (this.d) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
        }
    }
}
