package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.k3;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.y2;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final k b;
    private final o c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f512a = Collections.synchronizedMap(new HashMap(16));
    private final Object d = new Object();
    private final Map e = new HashMap();
    private final Set f = new HashSet();
    private final Object g = new Object();
    private final Set h = new HashSet();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f513a;
        private final String b;
        private final MaxAdFormat c;
        private final JSONObject d;

        a(String str, String str2, y2 y2Var, k kVar) {
            this.f513a = str;
            this.b = str2;
            JSONObject jSONObject = new JSONObject();
            this.d = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (y2Var == null) {
                this.c = null;
            } else {
                this.c = y2Var.getFormat();
                JsonUtils.putString(jSONObject, "format", y2Var.getFormat().getLabel());
            }
        }

        JSONObject a() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f513a.equals(aVar.f513a) || !this.b.equals(aVar.b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.c;
            MaxAdFormat maxAdFormat2 = aVar.c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int iHashCode = ((this.f513a.hashCode() * 31) + this.b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.c;
            return iHashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.f513a + "', operationTag='" + this.b + "', format=" + this.c + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public g(k kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.b = kVar;
        this.c = kVar.O();
    }

    public Collection a() {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList(this.h.size());
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                arrayList.add(((a) it.next()).a());
            }
        }
        return arrayList;
    }

    public Collection b() {
        Set setUnmodifiableSet;
        synchronized (this.d) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f);
        }
        return setUnmodifiableSet;
    }

    public Collection c() {
        Set setUnmodifiableSet;
        synchronized (this.d) {
            HashSet hashSet = new HashSet(this.e.size());
            Iterator it = this.e.values().iterator();
            while (it.hasNext()) {
                hashSet.add(((Class) it.next()).getName());
            }
            setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return setUnmodifiableSet;
    }

    h a(k3 k3Var) {
        return a(k3Var, false);
    }

    h a(k3 k3Var, boolean z) {
        Class cls;
        h hVar;
        if (k3Var != null) {
            String strC = k3Var.c();
            String strB = k3Var.b();
            if (TextUtils.isEmpty(strC)) {
                if (o.a()) {
                    this.c.b("MediationAdapterManager", "No adapter name provided for " + strB + ", not loading the adapter ");
                }
                return null;
            }
            if (TextUtils.isEmpty(strB)) {
                if (o.a()) {
                    this.c.b("MediationAdapterManager", "Unable to find default className for '" + strC + "'");
                }
                return null;
            }
            if (z && (hVar = (h) this.f512a.get(strB)) != null) {
                return hVar;
            }
            synchronized (this.d) {
                if (!this.f.contains(strB)) {
                    if (this.e.containsKey(strB)) {
                        cls = (Class) this.e.get(strB);
                    } else {
                        Class clsA = a(strB);
                        if (clsA == null) {
                            if (o.a()) {
                                this.c.k("MediationAdapterManager", "Adapter " + strC + " could not be loaded, class " + strB + " not found");
                            }
                            this.f.add(strB);
                            return null;
                        }
                        cls = clsA;
                    }
                    h hVarA = a(k3Var, cls, z);
                    if (hVarA != null) {
                        if (o.a()) {
                            this.c.a("MediationAdapterManager", "Loaded " + strC);
                        }
                        this.e.put(strB, cls);
                        if (z) {
                            this.f512a.put(k3Var.b(), hVarA);
                        }
                        return hVarA;
                    }
                    if (o.a()) {
                        this.c.b("MediationAdapterManager", "Failed to load " + strC);
                    }
                    this.f.add(strB);
                    return null;
                }
                if (o.a()) {
                    this.c.a("MediationAdapterManager", "Not attempting to load " + strC + " due to prior errors");
                }
                return null;
            }
        }
        throw new IllegalArgumentException("No adapter spec specified");
    }

    public void a(String str, String str2, y2 y2Var) {
        synchronized (this.g) {
            this.b.O();
            if (o.a()) {
                this.b.O().b("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            }
            this.h.add(new a(str, str2, y2Var, this.b));
        }
    }

    private h a(k3 k3Var, Class cls, boolean z) {
        try {
            return new h(k3Var, (MediationAdapterBase) cls.getConstructor(AppLovinSdk.class).newInstance(this.b.z0()), z, this.b);
        } catch (Throwable th) {
            o.c("MediationAdapterManager", "Failed to load adapter: " + k3Var, th);
            return null;
        }
    }

    private Class a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            o.h("MediationAdapterManager", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
