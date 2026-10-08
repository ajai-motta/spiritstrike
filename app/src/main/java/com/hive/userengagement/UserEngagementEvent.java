package com.hive.userengagement;

import android.net.Uri;
import com.adjust.sdk.Constants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.base.Android;
import com.hive.module.interfaces.HiveUserEngagement;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010$\u001a\u0004\u0018\u00010\u0016J\b\u0010%\u001a\u0004\u0018\u00010\u0016J\b\u0010&\u001a\u0004\u0018\u00010\u0003J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020(H\u0002J\n\u0010+\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR1\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030 j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006."}, d2 = {"Lcom/hive/userengagement/UserEngagementEvent;", "", "arg", "", "<init>", "(Ljava/lang/String;)V", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "value", "scheme", "getScheme", "()Ljava/lang/String;", "host", "getHost", "path", "getPath", "query", "getQuery", "queryParameterNames", "", "queryData", "ueJsonData", "Lorg/json/JSONObject;", "getUeJsonData", "()Lorg/json/JSONObject;", "setUeJsonData", "(Lorg/json/JSONObject;)V", "Lcom/hive/userengagement/UserEngagementEvent$ValidationResult;", "validationResult", "getValidationResult", "()Lcom/hive/userengagement/UserEngagementEvent$ValidationResult;", "hashMapQuery", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getHashMapQuery", "()Ljava/util/HashMap;", "toJson", "toJsonWithQueryData", "toEventsString", "validateScheme", "", "validateHost", "validatePath", "toJsonQuery", k.M, "ValidationResult", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserEngagementEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static HashMap<String, String> queryParameters = new HashMap<>();
    private String host;
    private String path;
    private String query;
    private String queryData;
    private Set<String> queryParameterNames;
    private String scheme;
    private JSONObject ueJsonData;
    private Uri uri;
    private ValidationResult validationResult;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ.\u0010\n\u001a\u00020\t2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007J&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR.\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/hive/userengagement/UserEngagementEvent$Companion;", "", "<init>", "()V", "queryParameters", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "clearQueryParameters", "", "setQueryParameters", "parameters", "getQueryParametersThenClear", "appendQueryParameters", "Lorg/json/JSONObject;", "jsonObject", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JSONObject appendQueryParameters(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            HashMap<String, String> queryParametersThenClear = getQueryParametersThenClear();
            Set<String> setKeySet = queryParametersThenClear.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            for (String str : setKeySet) {
                Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                String str2 = str;
                if (!jsonObject.has(str2)) {
                    try {
                        jsonObject.put(str2, queryParametersThenClear.get(str2));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            return jsonObject;
        }

        public final void clearQueryParameters() {
            UserEngagementEvent.queryParameters.clear();
        }

        public final HashMap<String, String> getQueryParametersThenClear() {
            HashMap<String, String> map = new HashMap<>(UserEngagementEvent.queryParameters);
            clearQueryParameters();
            return map;
        }

        public final void setQueryParameters(HashMap<String, String> parameters) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            UserEngagementEvent.queryParameters = parameters;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/hive/userengagement/UserEngagementEvent$ValidationResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OK", "FAIL", "INVALIDURI", "INVALIDSCHEME", "INVALIDHOST", "INVALIDJSONFORMAT", "INVALIDPATH", "UNKNOWNERROR", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ValidationResult {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ValidationResult[] $VALUES;
        private final int value;
        public static final ValidationResult OK = new ValidationResult("OK", 0, 0);
        public static final ValidationResult FAIL = new ValidationResult("FAIL", 1, -1000);
        public static final ValidationResult INVALIDURI = new ValidationResult("INVALIDURI", 2, -1001);
        public static final ValidationResult INVALIDSCHEME = new ValidationResult("INVALIDSCHEME", 3, -1002);
        public static final ValidationResult INVALIDHOST = new ValidationResult("INVALIDHOST", 4, -1003);
        public static final ValidationResult INVALIDJSONFORMAT = new ValidationResult("INVALIDJSONFORMAT", 5, -1004);
        public static final ValidationResult INVALIDPATH = new ValidationResult("INVALIDPATH", 6, -1005);
        public static final ValidationResult UNKNOWNERROR = new ValidationResult("UNKNOWNERROR", 7, -2000);

        private static final /* synthetic */ ValidationResult[] $values() {
            return new ValidationResult[]{OK, FAIL, INVALIDURI, INVALIDSCHEME, INVALIDHOST, INVALIDJSONFORMAT, INVALIDPATH, UNKNOWNERROR};
        }

        static {
            ValidationResult[] validationResultArr$values = $values();
            $VALUES = validationResultArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(validationResultArr$values);
        }

        private ValidationResult(String str, int i, int i2) {
            this.value = i2;
        }

        public static EnumEntries<ValidationResult> getEntries() {
            return $ENTRIES;
        }

        public static ValidationResult valueOf(String str) {
            return (ValidationResult) Enum.valueOf(ValidationResult.class, str);
        }

        public static ValidationResult[] values() {
            return (ValidationResult[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    public UserEngagementEvent(String arg) throws Exception {
        Intrinsics.checkNotNullParameter(arg, "arg");
        this.ueJsonData = new JSONObject();
        this.validationResult = ValidationResult.OK;
        try {
            Uri uri = Uri.parse(arg);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
            this.uri = uri;
            this.scheme = uri.getScheme();
            validateScheme();
            this.host = this.uri.getHost();
            validateHost();
            this.path = this.uri.getPath();
            validatePath();
            this.query = this.uri.getQuery();
            Set<String> queryParameterNames = this.uri.getQueryParameterNames();
            Intrinsics.checkNotNullExpressionValue(queryParameterNames, "getQueryParameterNames(...)");
            this.queryParameterNames = queryParameterNames;
            this.queryData = this.uri.getQueryParameter("?");
            this.ueJsonData = toJsonWithQueryData();
        } catch (Exception e) {
            e.printStackTrace();
            this.validationResult = ValidationResult.INVALIDURI;
            throw e;
        }
    }

    private final JSONObject toJsonQuery() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.queryParameterNames) {
                jSONObject.put(str, this.uri.getQueryParameter(str));
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            this.validationResult = ValidationResult.INVALIDJSONFORMAT;
            return null;
        }
    }

    private final boolean validateHost() {
        String str = this.host;
        if (Intrinsics.areEqual(str, "hive") || Intrinsics.areEqual(str, "game")) {
            return true;
        }
        this.validationResult = ValidationResult.INVALIDHOST;
        return false;
    }

    private final boolean validatePath() {
        String str;
        boolean z = (Intrinsics.areEqual(this.host, "hive") && ((str = this.path) == null || HiveUserEngagement.InterworkApi.INSTANCE.getInterworkApi(str) == null)) ? false : true;
        if (!z) {
            this.validationResult = ValidationResult.INVALIDPATH;
        }
        return z;
    }

    private final boolean validateScheme() {
        String str = this.scheme;
        if (Intrinsics.areEqual(str, Constants.PUSH) || Intrinsics.areEqual(str, "interwork") || Intrinsics.areEqual(str, "intent") || Intrinsics.areEqual(str, Android.INSTANCE.getPackageName())) {
            return true;
        }
        this.validationResult = ValidationResult.INVALIDSCHEME;
        return false;
    }

    public final HashMap<String, String> getHashMapQuery() {
        HashMap<String, String> map = new HashMap<>();
        for (String str : this.queryParameterNames) {
            map.put(str, this.uri.getQueryParameter(str));
        }
        return map;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final JSONObject getUeJsonData() {
        return this.ueJsonData;
    }

    public final ValidationResult getValidationResult() {
        return this.validationResult;
    }

    public final void setUeJsonData(JSONObject jSONObject) {
        this.ueJsonData = jSONObject;
    }

    public final String toEventsString() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FirebaseAnalytics.Param.INDEX, 0);
            jSONObject.put("event", this.ueJsonData);
            jSONArray.put(0, jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("events", jSONArray);
            return jSONObject2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scheme", this.scheme);
            jSONObject.put("host", this.host);
            jSONObject.put("path", this.path);
            jSONObject.put("query", toJsonQuery());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            this.validationResult = ValidationResult.INVALIDJSONFORMAT;
            return null;
        }
    }

    public final JSONObject toJsonWithQueryData() {
        new JSONObject();
        try {
            JSONObject json = toJson();
            if (json != null) {
                json.put("queryData", this.queryData);
                return json;
            }
            this.validationResult = ValidationResult.INVALIDJSONFORMAT;
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            this.validationResult = ValidationResult.INVALIDJSONFORMAT;
            return null;
        }
    }
}
