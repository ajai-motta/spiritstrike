package com.hive.analytics.provider.attributes;

import android.util.Log;
import com.hive.Const;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001J\u0006\u0010\u0015\u001a\u00020\u0003R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/hive/analytics/provider/attributes/AnalyticsAttributes;", "", "moduleSpecificAttributes", "Lorg/json/JSONObject;", "customAttributes", "<init>", "(Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getModuleSpecificAttributes", "()Lorg/json/JSONObject;", "setModuleSpecificAttributes", "(Lorg/json/JSONObject;)V", "getCustomAttributes", "setCustomAttributes", "addModuleSpecificAttribute", "", "analyticsSpecific", "Lcom/hive/analytics/provider/attributes/IAnalyticsSpecific;", "addCustomAttribute", "name", "", "value", "toJson", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsAttributes {
    private JSONObject customAttributes;
    private JSONObject moduleSpecificAttributes;

    public AnalyticsAttributes() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final void addCustomAttribute(String name, Object value) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.customAttributes == null) {
            this.customAttributes = new JSONObject();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = this.customAttributes;
            objM7415constructorimpl = Result.m7415constructorimpl(jSONObject != null ? jSONObject.put(name, value) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.w(Const.TAG, "[AnalyticsAttributesLegacy] addCustomAttribute() exception : " + thM7418exceptionOrNullimpl);
        }
    }

    public final void addModuleSpecificAttribute(IAnalyticsSpecific analyticsSpecific) {
        Object objM7415constructorimpl;
        JSONObject jSONObjectPut;
        Intrinsics.checkNotNullParameter(analyticsSpecific, "analyticsSpecific");
        if (this.moduleSpecificAttributes == null) {
            this.moduleSpecificAttributes = new JSONObject();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = this.moduleSpecificAttributes;
            if (jSONObject != null) {
                String lowerCase = analyticsSpecific.getTrackerName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                jSONObjectPut = jSONObject.put(lowerCase, analyticsSpecific.toJson());
            } else {
                jSONObjectPut = null;
            }
            objM7415constructorimpl = Result.m7415constructorimpl(jSONObjectPut);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.w(Const.TAG, "[AnalyticsAttributesLegacy] addModuleSpecificAttribute() exception : " + thM7418exceptionOrNullimpl);
        }
    }

    public final JSONObject getCustomAttributes() {
        return this.customAttributes;
    }

    public final JSONObject getModuleSpecificAttributes() {
        return this.moduleSpecificAttributes;
    }

    public final void setCustomAttributes(JSONObject jSONObject) {
        this.customAttributes = jSONObject;
    }

    public final void setModuleSpecificAttributes(JSONObject jSONObject) {
        this.moduleSpecificAttributes = jSONObject;
    }

    public final JSONObject toJson() {
        Object objM7415constructorimpl;
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.INSTANCE;
            jSONObject.put("moduleSpecificAttributes", this.moduleSpecificAttributes);
            objM7415constructorimpl = Result.m7415constructorimpl(jSONObject.put("customAttributes", this.customAttributes));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.w(Const.TAG, "[AnalyticsAttributes] toJson() exception : " + thM7418exceptionOrNullimpl);
        }
        return jSONObject;
    }

    public AnalyticsAttributes(JSONObject jSONObject, JSONObject jSONObject2) {
        this.moduleSpecificAttributes = jSONObject;
        this.customAttributes = jSONObject2;
    }

    public /* synthetic */ AnalyticsAttributes(JSONObject jSONObject, JSONObject jSONObject2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject, (i & 2) != 0 ? null : jSONObject2);
    }
}
