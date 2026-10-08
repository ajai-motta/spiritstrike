package com.applovin.impl;

import androidx.arch.core.util.Function;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f416a;
    private final Object b = new Object();

    public i5(JSONObject jSONObject) {
        this.f416a = jSONObject;
    }

    public JSONObject a() {
        JSONObject jSONObjectDeepCopy;
        synchronized (this.b) {
            jSONObjectDeepCopy = JsonUtils.deepCopy(this.f416a);
        }
        return jSONObjectDeepCopy;
    }

    public List b(String str, List list) {
        List<String> stringList;
        synchronized (this.b) {
            stringList = JsonUtils.getStringList(this.f416a, str, list);
        }
        return stringList;
    }

    public void c(String str) {
        synchronized (this.b) {
            this.f416a.remove(str);
        }
    }

    public String toString() {
        String string;
        synchronized (this.b) {
            string = this.f416a.toString();
        }
        return string;
    }

    public boolean a(String str) {
        boolean zHas;
        synchronized (this.b) {
            zHas = this.f416a.has(str);
        }
        return zHas;
    }

    public Object b(String str) {
        Object objOpt;
        synchronized (this.b) {
            objOpt = this.f416a.opt(str);
        }
        return objOpt;
    }

    public void a(Consumer consumer) {
        synchronized (this.b) {
            consumer.accept(this);
        }
    }

    public void b(String str, int i) {
        synchronized (this.b) {
            JsonUtils.putInt(this.f416a, str, i);
        }
    }

    public Object a(Function function) {
        Object objApply;
        synchronized (this.b) {
            objApply = function.apply(this);
        }
        return objApply;
    }

    public void b(String str, long j) {
        synchronized (this.b) {
            JsonUtils.putLong(this.f416a, str, j);
        }
    }

    public Boolean a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.b) {
            bool2 = JsonUtils.getBoolean(this.f416a, str, bool);
        }
        return bool2;
    }

    public void b(String str, String str2) {
        synchronized (this.b) {
            JsonUtils.putString(this.f416a, str, str2);
        }
    }

    public float a(String str, float f) {
        float f2;
        synchronized (this.b) {
            f2 = JsonUtils.getFloat(this.f416a, str, f);
        }
        return f2;
    }

    public int a(String str, int i) {
        int i2;
        synchronized (this.b) {
            i2 = JsonUtils.getInt(this.f416a, str, i);
        }
        return i2;
    }

    public JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.b) {
            jSONArray2 = JsonUtils.getJSONArray(this.f416a, str, jSONArray);
        }
        return jSONArray2;
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.b) {
            jSONObject2 = JsonUtils.getJSONObject(this.f416a, str, jSONObject);
        }
        return jSONObject2;
    }

    public long a(String str, long j) {
        long j2;
        synchronized (this.b) {
            j2 = JsonUtils.getLong(this.f416a, str, j);
        }
        return j2;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this.b) {
            string = JsonUtils.getString(this.f416a, str, str2);
        }
        return string;
    }

    public List a(String str, List list) {
        List<Integer> integerList;
        synchronized (this.b) {
            integerList = JsonUtils.getIntegerList(this.f416a, str, list);
        }
        return integerList;
    }

    public void a(String str, boolean z) {
        synchronized (this.b) {
            JsonUtils.putBoolean(this.f416a, str, z);
        }
    }

    public void a(String str, Object obj) {
        synchronized (this.b) {
            JsonUtils.putObject(this.f416a, str, obj);
        }
    }
}
