package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.a5;
import com.applovin.impl.d2;
import com.applovin.impl.e6;
import com.applovin.impl.f2;
import com.applovin.impl.j6;
import com.applovin.impl.k3;
import com.applovin.impl.l1;
import com.applovin.impl.l5;
import com.applovin.impl.r3;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t4;
import com.applovin.mediation.adapter.MaxAdapter;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f511a;
    private final o b;
    private final AtomicBoolean c = new AtomicBoolean();
    private final Set d = new HashSet();
    private final Object e = new Object();
    private final JSONArray f = new JSONArray();
    private final LinkedHashMap g = new LinkedHashMap();
    private final Object h = new Object();
    private final Map i = new HashMap();
    private final Map j = new HashMap();
    private final Object k = new Object();
    private List l;

    public f(k kVar) {
        this.f511a = kVar;
        this.b = kVar.O();
    }

    public void a(Activity activity) {
        if (this.c.compareAndSet(false, true)) {
            String str = (String) this.f511a.a(a5.G);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<k3> listA = a(JsonUtils.getJSONArray(jSONObject, this.f511a.t0().c() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.l = listA;
                    for (k3 k3Var : listA) {
                        this.i.put(k3Var.b(), k3Var);
                    }
                    long j = StringUtils.parseLong(this.f511a.o0().getExtraParameters().get("adapter_initialization_delay_ms"), -1L);
                    l5 l5Var = new l5(listA, activity, this.f511a);
                    if (j > 0) {
                        this.f511a.r0().a(l5Var, e6.b.MEDIATION, j);
                    } else {
                        this.f511a.r0().a(l5Var);
                    }
                } catch (JSONException e) {
                    if (o.a()) {
                        this.b.a("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e);
                    }
                    l1.a((Throwable) e);
                }
            }
        }
    }

    public JSONArray b() {
        JSONArray jSONArrayShallowCopy;
        synchronized (this.h) {
            jSONArrayShallowCopy = JsonUtils.shallowCopy(this.f);
        }
        return jSONArrayShallowCopy;
    }

    public boolean c() {
        return this.c.get();
    }

    private void c(k3 k3Var) {
        String strB = k3Var.b();
        synchronized (this.e) {
            if (this.d.contains(strB)) {
                return;
            }
            this.d.add(strB);
            this.f511a.P().d(d2.b0, f2.a(k3Var));
        }
    }

    boolean b(k3 k3Var) {
        boolean zContainsKey;
        synchronized (this.h) {
            zContainsKey = this.g.containsKey(k3Var.b());
        }
        return zContainsKey;
    }

    public t4 a(k3 k3Var, Activity activity) {
        k3 k3VarA = a(k3Var);
        if (k3VarA == null) {
            return t4.a("AdapterInitialization:" + k3Var.c(), MaxAdapter.InitializationStatus.DOES_NOT_APPLY);
        }
        String strB = k3Var.b();
        synchronized (this.k) {
            t4 t4Var = (t4) this.j.get(strB);
            if (t4Var != null && (!t4Var.d() || !k3VarA.q())) {
                return t4Var;
            }
            final t4 t4Var2 = new t4("AdapterInitialization:" + k3Var.c());
            this.j.put(strB, t4Var2);
            h hVarA = this.f511a.T().a(k3VarA);
            if (hVarA == null) {
                t4Var2.a("Adapter implementation not found");
                return t4Var2;
            }
            if (o.a()) {
                this.b.d("MediationAdapterInitializationManager", "Initializing adapter " + k3VarA);
            }
            c(k3VarA);
            hVarA.a(MaxAdapterParametersImpl.a(k3VarA), activity, new MaxAdapter.OnCompletionListener() { // from class: com.applovin.impl.mediation.f$$ExternalSyntheticLambda0
                @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
                public final void onCompletion(MaxAdapter.InitializationStatus initializationStatus, String str) {
                    f.a(t4Var2, initializationStatus, str);
                }
            });
            j6.a(k3VarA.m(), t4Var2, "The adapter (" + k3Var.c() + ") timed out initializing", "MediationAdapterInitializationManager", this.f511a);
            return t4Var2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(t4 t4Var, MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            if (initializationStatus == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE) {
                t4Var.a(str);
                return;
            } else {
                t4Var.b(initializationStatus);
                return;
            }
        }
        l1.a("Adapters should never report a null or INITIALIZING status.", new Object[0]);
        t4Var.a("Adapter reported INITIALIZING");
    }

    private k3 a(k3 k3Var) {
        List<k3> list;
        if (((Boolean) this.f511a.a(r3.A8)).booleanValue()) {
            k3 k3Var2 = (k3) this.i.get(k3Var.b());
            return k3Var2 != null ? k3Var2 : k3Var;
        }
        if (!this.f511a.t0().c() || (list = this.l) == null) {
            return k3Var;
        }
        for (k3 k3Var3 : list) {
            if (k3Var3.b().equals(k3Var.b())) {
                return k3Var3;
            }
        }
        return null;
    }

    public Integer a(String str) {
        Integer num;
        synchronized (this.h) {
            num = (Integer) this.g.get(str);
        }
        return num;
    }

    public Set a() {
        HashSet hashSet;
        synchronized (this.h) {
            hashSet = new HashSet(this.g.keySet());
        }
        return hashSet;
    }

    void a(k3 k3Var, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus == null || initializationStatus == MaxAdapter.InitializationStatus.INITIALIZING) {
            return;
        }
        synchronized (this.h) {
            z = !b(k3Var);
            if (z) {
                this.g.put(k3Var.b(), Integer.valueOf(initializationStatus.getCode()));
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putString(jSONObject, "class", k3Var.b());
                JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                JsonUtils.putLong(jSONObject, "init_time_ms", j);
                JsonUtils.putString(jSONObject, AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, JSONObject.quote(str));
                this.f.put(jSONObject);
            }
        }
        if (z) {
            this.f511a.a(k3Var);
            this.f511a.X().processAdapterInitializationPostback(k3Var, j, initializationStatus, str);
            this.f511a.t().a(initializationStatus, k3Var.b());
        }
    }

    private List a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new k3(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, this.f511a));
        }
        return arrayList;
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        synchronized (this.h) {
            this.g.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", Integer.valueOf(initializationStatus.getCode()));
        }
        this.f511a.t().a(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }
}
