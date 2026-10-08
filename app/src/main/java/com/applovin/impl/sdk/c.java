package com.applovin.impl.sdk;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.applovin.impl.d2;
import com.applovin.impl.e6;
import com.applovin.impl.f2;
import com.applovin.impl.j5;
import com.applovin.impl.p7;
import com.applovin.impl.q4;
import com.applovin.impl.s6;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.y4;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.internal.AnalyticsEvents;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static final File b = new File(k.o().getFilesDir(), "al/persisted-ads");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f623a;

    public static class a implements q4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f624a;
        private final AppLovinAdType b;
        private final boolean c;
        private final long d;
        private final long e;

        public a(String str, AppLovinAdType appLovinAdType, boolean z, long j, long j2) {
            this.f624a = str;
            this.b = appLovinAdType;
            this.c = z;
            this.d = j;
            this.e = j2;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public long b() {
            return this.e;
        }

        public long c() {
            return this.d;
        }

        public String d() {
            return this.f624a + "_" + this.b;
        }

        public String e() {
            return this.f624a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String strE = e();
            String strE2 = aVar.e();
            if (strE != null ? !strE.equals(strE2) : strE2 != null) {
                return false;
            }
            AppLovinAdType appLovinAdTypeF = f();
            AppLovinAdType appLovinAdTypeF2 = aVar.f();
            return appLovinAdTypeF != null ? appLovinAdTypeF.equals(appLovinAdTypeF2) : appLovinAdTypeF2 == null;
        }

        public AppLovinAdType f() {
            return this.b;
        }

        public boolean g() {
            return this.c;
        }

        public int hashCode() {
            String strE = e();
            int iHashCode = strE == null ? 43 : strE.hashCode();
            AppLovinAdType appLovinAdTypeF = f();
            return ((iHashCode + 59) * 59) + (appLovinAdTypeF != null ? appLovinAdTypeF.hashCode() : 43);
        }

        public String toString() {
            return "AdPersistenceFileService.PersistedAdFilePath(id=" + e() + ", type=" + f() + ", isAdServerAd=" + g() + ", expiryTimeMillis=" + c() + ", appLaunchTimestamp=" + b() + ")";
        }

        public static a a(com.applovin.impl.sdk.ad.b bVar) {
            return a(bVar, 0L, 0L);
        }

        public static a a(com.applovin.impl.sdk.ad.b bVar, long j, long j2) {
            if (bVar == null) {
                return null;
            }
            return new a(StringUtils.isValidString(bVar.getMediationServeId()) ? bVar.getMediationServeId() : UUID.randomUUID().toString(), bVar.getType(), bVar instanceof com.applovin.impl.sdk.ad.a, SystemClock.elapsedRealtime() + j, j2);
        }

        public static a a(JSONObject jSONObject, k kVar) {
            String string = JsonUtils.getString(jSONObject, "id", "");
            String string2 = JsonUtils.getString(jSONObject, "type", "");
            Boolean bool = JsonUtils.getBoolean(jSONObject, "is_ad_server_ad", null);
            long j = JsonUtils.getLong(jSONObject, "expiry_time_millis", 0L);
            long j2 = JsonUtils.getLong(jSONObject, "app_launch_timestamp", 0L);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || bool == null) {
                return null;
            }
            return new a(string, AppLovinAdType.fromString(string2), bool.booleanValue(), j, j2);
        }

        @Override // com.applovin.impl.q4
        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putString(jSONObject, "id", this.f624a);
            JsonUtils.putString(jSONObject, "type", this.b.toString());
            JsonUtils.putBoolean(jSONObject, "is_ad_server_ad", this.c);
            JsonUtils.putLong(jSONObject, "expiry_time_millis", this.d);
            JsonUtils.putLong(jSONObject, "app_launch_timestamp", this.e);
            return jSONObject;
        }
    }

    public interface b {
        void a(a aVar);
    }

    /* JADX INFO: renamed from: com.applovin.impl.sdk.c$c, reason: collision with other inner class name */
    public interface InterfaceC0159c {
        void a(com.applovin.impl.sdk.ad.b bVar, String str);
    }

    public c(k kVar) {
        this.f623a = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        a aVarA = a.a(bVar, ((Long) this.f623a.a(y4.e1)).longValue(), k.n());
        File fileA = a(aVarA);
        if (fileA == null) {
            a("Could not persist incompatible ad", bVar, bVar2);
            return;
        }
        try {
            JSONObject jSONObjectA = bVar.a();
            if (jSONObjectA == null) {
                a("Could not serialize ad for persistence", bVar, bVar2);
                return;
            }
            if (this.f623a.G().a((InputStream) new ByteArrayInputStream(jSONObjectA.toString().getBytes("UTF-8")), fileA, true)) {
                a(aVarA, bVar, bVar2);
            } else {
                a("Failed to write persisted ad to disk", bVar, bVar2);
            }
        } catch (Throwable th) {
            a("Ad could not be persisted", bVar, bVar2);
            this.f623a.D().a("AdPersistenceFileService", th, CollectionUtils.map(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, "Ad could not be persisted"));
        }
    }

    public void b(final com.applovin.impl.sdk.ad.b bVar, final b bVar2) {
        if (b()) {
            this.f623a.r0().a((j5) new s6(this.f623a, "persistAd", new Runnable() { // from class: com.applovin.impl.sdk.c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(bVar, bVar2);
                }
            }), e6.b.CACHING);
        } else {
            a("Ad Persistence directory could not be created", bVar, bVar2);
        }
    }

    private boolean b() {
        File file = b;
        if (file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    public void b(a aVar) {
        File fileA = a(aVar);
        if (fileA != null) {
            fileA.delete();
        }
    }

    public void a(final a aVar, final InterfaceC0159c interfaceC0159c) {
        final File fileA = a(aVar);
        if (fileA != null && fileA.exists()) {
            this.f623a.r0().a((j5) new s6(this.f623a, "retrievePersistedAd", new Runnable() { // from class: com.applovin.impl.sdk.c$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.a(fileA, interfaceC0159c, aVar);
                }
            }), e6.b.OTHER);
        } else {
            interfaceC0159c.a(null, "Persisted ad could not be retrieved: Retrieval failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(File file, InterfaceC0159c interfaceC0159c, a aVar) throws Throwable {
        com.applovin.impl.sdk.ad.b bVarA;
        String strF = this.f623a.G().f(file);
        if (strF == null) {
            interfaceC0159c.a(null, "Persisted ad could not be retrieved: Read failed");
            return;
        }
        try {
            JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(strF, new JSONObject());
            JsonUtils.putBoolean(JsonUtils.getJSONObject(jSONObjectJsonObjectFromJsonString, "full_response", new JSONObject()), "is_persisted_ad", true);
            if (aVar.g()) {
                bVarA = com.applovin.impl.sdk.ad.a.a(jSONObjectJsonObjectFromJsonString, this.f623a);
            } else {
                bVarA = p7.a(jSONObjectJsonObjectFromJsonString, this.f623a);
            }
            if (bVarA == null) {
                interfaceC0159c.a(null, "Persisted ad could not be retrieved: Deserialization failed");
            } else {
                interfaceC0159c.a(bVarA, null);
            }
        } catch (Throwable th) {
            interfaceC0159c.a(null, "Persisted ad could not be retrieved: Deserialization failed");
            this.f623a.D().a("AdPersistenceFileService", th, CollectionUtils.map(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, "Persisted ad could not be retrieved: Deserialization failed"));
        }
    }

    private File a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new File(b.getAbsolutePath() + DomExceptionUtils.SEPARATOR + aVar.d());
    }

    private void a(a aVar, com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        if (bVar2 == null) {
            return;
        }
        this.f623a.O();
        if (o.a()) {
            this.f623a.O().a("AdPersistenceFileService", "Ad was persisted successfully");
        }
        bVar2.a(aVar);
        this.f623a.g().a(d2.T, bVar);
    }

    private void a(String str, com.applovin.impl.sdk.ad.b bVar, b bVar2) {
        if (bVar2 == null) {
            return;
        }
        this.f623a.O();
        if (o.a()) {
            this.f623a.O().a("AdPersistenceFileService", str);
        }
        bVar2.a(null);
        Map mapA = f2.a((AppLovinAdImpl) bVar);
        CollectionUtils.putStringIfValid(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, mapA);
        this.f623a.g().d(d2.U, mapA);
    }

    public void a(List list) {
        File[] fileArrListFiles = b.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        boolean z = false;
        for (File file : fileArrListFiles) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((a) it.next()).d().equals(file.getName())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                file.delete();
            }
        }
    }

    public void a() {
        File[] fileArrListFiles;
        File file = b;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
    }
}
