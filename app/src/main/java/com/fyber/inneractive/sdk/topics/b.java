package com.fyber.inneractive.sdk.topics;

import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.util.Base64;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;
import com.fyber.inneractive.sdk.util.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1625a;
    public boolean b;
    public a g;
    public GetTopicsRequest h;
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public ArrayList e = new ArrayList();
    public ArrayList f = new ArrayList();
    public final AtomicBoolean i = new AtomicBoolean(false);

    public final void a(boolean z, boolean z2) {
        if (this.i.compareAndSet(false, true)) {
            this.f1625a = z;
            this.b = z2;
            GetTopicsRequest.Builder builder = new GetTopicsRequest.Builder();
            builder.setAdsSdkName("com.fyber.inneractive.sdk");
            this.h = builder.build();
            this.g = new a(this);
        }
    }

    public final JSONArray b() {
        JSONObject jSONObject;
        if (this.f.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Topic topic : this.f) {
            if (this.d.containsKey(topic)) {
                jSONObject = (JSONObject) this.d.get(topic);
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", topic.getTopicId());
                    jSONObject2.put("mv", topic.getModelVersion());
                    jSONObject2.put("tv", topic.getTaxonomyVersion());
                    this.d.put(topic, jSONObject2);
                    jSONObject = jSONObject2;
                } catch (Exception e) {
                    IAlog.a("%sException when convertTopicToJSON called", e, IAlog.a(this));
                    jSONObject = null;
                }
            }
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }

    public final void c() {
        TopicsManager topicsManager;
        Context baseContext = o.f1662a.getBaseContext();
        if (baseContext == null || (topicsManager = (TopicsManager) baseContext.getSystemService(TopicsManager.class)) == null) {
            return;
        }
        topicsManager.getTopics(this.h, r.f1668a, this.g);
    }

    public final JSONArray a() {
        JSONObject jSONObject;
        if (this.e.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (EncryptedTopic encryptedTopic : this.e) {
            if (!IAConfigManager.c()) {
                jSONObject = null;
            } else if (this.c.containsKey(encryptedTopic)) {
                jSONObject = (JSONObject) this.c.get(encryptedTopic);
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    byte[] encryptedTopic2 = encryptedTopic.getEncryptedTopic();
                    jSONObject2.put("et", encryptedTopic2 == null ? null : Base64.encodeToString(encryptedTopic2, 10));
                    jSONObject2.put("ki", encryptedTopic.getKeyIdentifier());
                    byte[] encapsulatedKey = encryptedTopic.getEncapsulatedKey();
                    jSONObject2.put("ek", encapsulatedKey == null ? null : Base64.encodeToString(encapsulatedKey, 10));
                    this.c.put(encryptedTopic, jSONObject2);
                    jSONObject = jSONObject2;
                } catch (Exception e) {
                    IAlog.a("%sException when convertEncryptedTopicToJSON called", e, IAlog.a(this));
                    jSONObject = null;
                }
            }
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }
}
