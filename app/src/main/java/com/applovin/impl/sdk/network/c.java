package com.applovin.impl.sdk.network;

import android.text.TextUtils;
import com.applovin.impl.j5;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.o;
import com.applovin.impl.y4;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends j5 {
    private final b g;
    private final o h;
    private AtomicBoolean i;
    private boolean j;

    c(b bVar, k kVar) {
        super("PersistentPostbackQueueSaveTask", kVar);
        this.i = new AtomicBoolean();
        this.j = false;
        this.g = bVar;
        this.h = kVar.O();
    }

    public List a(int i) throws Throwable {
        ArrayList arrayList = new ArrayList();
        m mVarG = this.f428a.G();
        if (!mVarG.b("persistent_postback_cache.json", k.o())) {
            o.h("PersistentPostbackQueueSaveTask", "Postbacks queue file does not exist.");
            return arrayList;
        }
        File fileA = mVarG.a("persistent_postback_cache.json", k.o());
        String strF = mVarG.f(fileA);
        if (TextUtils.isEmpty(strF)) {
            o.h("PersistentPostbackQueueSaveTask", "Postbacks queue file has no content.");
            return arrayList;
        }
        boolean z = false;
        try {
            JSONArray jSONArray = new JSONObject(strF).getJSONArray("pb");
            if (o.a()) {
                this.h.a("PersistentPostbackQueueSaveTask", "Deserializing " + jSONArray.length() + " postback(s)...");
            }
            arrayList.ensureCapacity(Math.max(1, jSONArray.length()));
            Integer num = (Integer) this.f428a.a(y4.N2);
            for (int i2 = 0; i2 < jSONArray.length() && arrayList.size() < i; i2++) {
                try {
                    d dVar = new d(jSONArray.getJSONObject(i2), this.f428a);
                    if (dVar.c() < num.intValue()) {
                        arrayList.add(dVar);
                    } else {
                        o.h("PersistentPostbackQueueSaveTask", "Skipping deserialization because maximum attempt count exceeded for postback: " + dVar);
                    }
                } catch (Throwable th) {
                    o.c("PersistentPostbackQueueSaveTask", "Unable to deserialize postback from json", th);
                    this.f428a.D().a("PersistentPostbackQueueSaveTask", "deserializePostback", th);
                }
            }
            if (o.a()) {
                this.h.a("PersistentPostbackQueueSaveTask", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            }
        } catch (Throwable th2) {
            try {
                o.c("PersistentPostbackQueueSaveTask", "Failed to load postback queue", th2);
                try {
                    this.f428a.D().a("PersistentPostbackQueueSaveTask", "deserializePostbackQueue", th2);
                    if (((Boolean) this.f428a.a(y4.S0)).booleanValue()) {
                        mVarG.a(fileA, "removeAfterDeserializationFail");
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z = true;
                    if (z && ((Boolean) this.f428a.a(y4.S0)).booleanValue()) {
                        mVarG.a(fileA, "removeAfterDeserializationFail");
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        this.j = arrayList.isEmpty();
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        a(this.g.d());
    }

    private void a(List list) {
        if (!(this.j && list.isEmpty()) && this.i.compareAndSet(false, true)) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                try {
                    jSONArray.put(dVar.q());
                } catch (Throwable th) {
                    o.c("PersistentPostbackQueueSaveTask", "Unable to serialize postback to JSON: " + dVar, th);
                    this.f428a.D().a("PersistentPostbackQueueSaveTask", "serializePostback", th);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pb", jSONArray);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes("UTF-8"));
                m mVarG = this.f428a.G();
                if (mVarG.a((InputStream) byteArrayInputStream, mVarG.a("persistent_postback_cache.json", k.o()), true)) {
                    if (o.a()) {
                        this.h.a("PersistentPostbackQueueSaveTask", "Exported postback queue to disk.");
                    }
                } else if (o.a()) {
                    this.h.b("PersistentPostbackQueueSaveTask", "Unable to export postback queue to disk.");
                }
            } catch (Throwable th2) {
                o.c("PersistentPostbackQueueSaveTask", "Unable to export postbacks to disk: " + jSONArray, th2);
                this.f428a.D().a("PersistentPostbackQueueSaveTask", "serializePostbackQueue", th2);
            }
            this.i.set(false);
        }
    }
}
