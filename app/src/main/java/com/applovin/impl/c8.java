package com.applovin.impl;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c8 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f344a;
    private List b;
    private int c;
    private Uri d;
    private final Set e;
    private v7 f;
    private final Map g;

    private c8() {
        this.f344a = Collections.emptyList();
        this.b = Collections.emptyList();
        this.e = new HashSet();
        this.g = new HashMap();
    }

    public static c8 a(q8 q8Var, c8 c8Var, t7 t7Var, com.applovin.impl.sdk.k kVar) {
        q8 q8VarC;
        v7 v7VarA;
        List listA;
        q8 q8VarC2;
        List listA2;
        q8 q8VarC3;
        int iA;
        if (q8Var == null) {
            throw new IllegalArgumentException("No node specified.");
        }
        if (t7Var == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        if (c8Var == null) {
            try {
                c8Var = new c8(t7Var);
            } catch (Throwable th) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("VastVideoCreative", "Error occurred while initializing", th);
                }
                kVar.D().a("VastVideoCreative", th);
                return null;
            }
        }
        if (c8Var.c == 0 && (q8VarC3 = q8Var.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.s)) != null && (iA = a(q8VarC3.d(), kVar)) > 0) {
            c8Var.c = iA;
        }
        q8 q8VarC4 = q8Var.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.t);
        if (q8VarC4 != null && (listA2 = a(q8VarC4, kVar)) != null && listA2.size() > 0) {
            List list = c8Var.f344a;
            if (list != null) {
                listA2.addAll(list);
            }
            c8Var.f344a = listA2;
        }
        q8 q8VarC5 = q8Var.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.x);
        if (q8VarC5 != null) {
            if (c8Var.d == null && (q8VarC2 = q8VarC5.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.y)) != null) {
                String strD = q8VarC2.d();
                if (StringUtils.isValidString(strD)) {
                    c8Var.d = Uri.parse(strD);
                }
            }
            b8.a(q8VarC5.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.z), c8Var.e, t7Var, kVar);
        }
        q8 q8VarC6 = q8Var.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.B);
        if (q8VarC6 != null && (v7VarA = v7.a((q8VarC = q8VarC6.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.C)), kVar)) != null) {
            q8 q8VarC7 = q8VarC.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.G);
            if (q8VarC7 != null && (listA = q8VarC7.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.I)) != null) {
                b8.a(listA, v7VarA.f699a, t7Var, kVar);
            }
            List listA3 = q8VarC.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.J);
            if (listA3 != null) {
                b8.a(listA3, v7VarA.b, t7Var, kVar);
            }
            c8Var.f = v7VarA;
        }
        b8.a(q8Var, c8Var.g, t7Var, kVar);
        return c8Var;
    }

    public Set b() {
        return this.e;
    }

    public Uri c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public Map e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c8)) {
            return false;
        }
        c8 c8Var = (c8) obj;
        if (this.c != c8Var.c) {
            return false;
        }
        List list = this.f344a;
        if (list == null ? c8Var.f344a != null : !list.equals(c8Var.f344a)) {
            return false;
        }
        Uri uri = this.d;
        if (uri == null ? c8Var.d != null : !uri.equals(c8Var.d)) {
            return false;
        }
        Set set = this.e;
        if (set == null ? c8Var.e != null : !set.equals(c8Var.e)) {
            return false;
        }
        Map map = this.g;
        Map map2 = c8Var.g;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public v7 f() {
        return this.f;
    }

    public List g() {
        return this.f344a;
    }

    public int hashCode() {
        List list = this.f344a;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.c) * 31;
        Uri uri = this.d;
        int iHashCode2 = (iHashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set set = this.e;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map map = this.g;
        return iHashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f344a + ", durationSeconds=" + this.c + ", destinationUri=" + this.d + ", clickTrackers=" + this.e + ", eventTrackers=" + this.g + ", industryIcon=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    private c8(t7 t7Var) {
        this.f344a = Collections.emptyList();
        this.b = Collections.emptyList();
        this.e = new HashSet();
        this.g = new HashMap();
        this.b = t7Var.f();
    }

    private static int a(String str, com.applovin.impl.sdk.k kVar) {
        try {
            List<String> listExplode = CollectionUtils.explode(str, ":");
            if (listExplode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds(StringUtils.parseInt(listExplode.get(0))) + TimeUnit.MINUTES.toSeconds(StringUtils.parseInt(listExplode.get(1))) + ((long) StringUtils.parseInt(listExplode.get(2))));
            }
        } catch (Throwable unused) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
            }
        }
        return 0;
    }

    private static List a(q8 q8Var, com.applovin.impl.sdk.k kVar) {
        List listA = q8Var.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.u);
        ArrayList arrayList = new ArrayList(listA.size());
        List<String> listExplode = CollectionUtils.explode((String) kVar.a(y4.T4));
        List<String> listExplode2 = CollectionUtils.explode((String) kVar.a(y4.S4));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            d8 d8VarA = d8.a((q8) it.next(), kVar);
            if (d8VarA != null) {
                try {
                    String strC = d8VarA.c();
                    if (StringUtils.isValidString(strC) && !listExplode.contains(strC)) {
                        arrayList.add(d8VarA);
                    } else {
                        if (((Boolean) kVar.a(y4.U4)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(d8VarA.e().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !listExplode2.contains(fileExtensionFromUrl)) {
                                arrayList.add(d8VarA);
                            }
                        }
                        kVar.O();
                        if (com.applovin.impl.sdk.o.a()) {
                            kVar.O().k("VastVideoCreative", "Video file not supported: " + d8VarA);
                        }
                    }
                } catch (Throwable th) {
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().a("VastVideoCreative", "Failed to validate video file: " + d8VarA, th);
                    }
                }
            }
        }
        return arrayList;
    }

    public d8 a(long j) {
        List list = this.f344a;
        d8 d8Var = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        List<d8> arrayList = new ArrayList(3);
        for (String str : this.b) {
            for (d8 d8Var2 : this.f344a) {
                String strC = d8Var2.c();
                if (StringUtils.isValidString(strC) && str.equalsIgnoreCase(strC)) {
                    arrayList.add(d8Var2);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f344a;
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.applovin.impl.c8$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c8.a((d8) obj, (d8) obj2);
            }
        });
        for (d8 d8Var3 : arrayList) {
            if (d8Var3.b() > j) {
                break;
            }
            d8Var = d8Var3;
        }
        return d8Var != null ? d8Var : (d8) arrayList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(d8 d8Var, d8 d8Var2) {
        return Long.compare(d8Var.b(), d8Var2.b());
    }

    public static c8 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject == null) {
            return null;
        }
        c8 c8Var = new c8();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "video_files", new JSONArray());
        c8Var.f344a = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            d8 d8VarA = d8.a(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), kVar);
            if (d8VarA != null) {
                c8Var.f344a.add(d8VarA);
            }
        }
        c8Var.b = JsonUtils.getStringList(jSONObject, "preferred_video_file_types", Collections.emptyList());
        c8Var.c = JsonUtils.getInt(jSONObject, "duration_seconds", 0);
        String string = JsonUtils.getString(jSONObject, "destination_uri", null);
        c8Var.d = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "click_trackers", new JSONArray());
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            z7 z7VarA = z7.a(JsonUtils.getJSONObject(jSONArray2, i2, (JSONObject) null), kVar);
            if (z7VarA != null) {
                c8Var.e.add(z7VarA);
            }
        }
        c8Var.f = v7.a(JsonUtils.getJSONObject(jSONObject, "industry_icon", (JSONObject) null), kVar);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "event_trackers", new JSONObject());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            HashSet hashSet = new HashSet();
            String next = itKeys.next();
            JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject2, next, new JSONArray());
            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                z7 z7VarA2 = z7.a(JsonUtils.getJSONObject(jSONArray3, i3, (JSONObject) null), kVar);
                if (z7VarA2 != null) {
                    hashSet.add(z7VarA2);
                }
            }
            c8Var.g.put(next, hashSet);
        }
        return c8Var;
    }

    @Override // com.applovin.impl.q4
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List list = this.f344a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(((d8) it.next()).a());
            }
        }
        JsonUtils.putJsonArray(jSONObject, "video_files", jSONArray);
        JsonUtils.putJsonArray(jSONObject, "preferred_video_file_types", new JSONArray((Collection) this.b));
        JsonUtils.putInt(jSONObject, "duration_seconds", this.c);
        Uri uri = this.d;
        JsonUtils.putString(jSONObject, "destination_uri", uri == null ? null : uri.toString());
        JSONArray jSONArray2 = new JSONArray();
        Iterator it2 = this.e.iterator();
        while (it2.hasNext()) {
            jSONArray2.put(((z7) it2.next()).a());
        }
        JsonUtils.putJsonArray(jSONObject, "click_trackers", jSONArray2);
        v7 v7Var = this.f;
        if (v7Var != null) {
            JsonUtils.putJSONObject(jSONObject, "industry_icon", v7Var.a());
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.g.keySet()) {
            Set set = (Set) this.g.get(str);
            if (set != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator it3 = set.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(((z7) it3.next()).a());
                }
                JsonUtils.putJsonArray(jSONObject2, str, jSONArray3);
            }
        }
        JsonUtils.putJSONObject(jSONObject, "event_trackers", jSONObject2);
        return jSONObject;
    }
}
