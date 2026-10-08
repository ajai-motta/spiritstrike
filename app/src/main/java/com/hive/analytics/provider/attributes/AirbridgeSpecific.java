package com.hive.analytics.provider.attributes;

import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.messaging.Constants;
import com.hive.Const;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/hive/analytics/provider/attributes/AirbridgeSpecific;", "Lcom/hive/analytics/provider/attributes/IAnalyticsSpecific;", "<init>", "()V", "semanticAttributes", "Lorg/json/JSONObject;", "setSemanticAction", "name", "", "setSemanticLabel", "setSemanticValue", "value", "", "addSemanticAttribute", "", "toJson", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AirbridgeSpecific extends IAnalyticsSpecific {
    private final JSONObject semanticAttributes;

    public AirbridgeSpecific() {
        super(AnalyticsProviderAdapter.AnalyticsProviderType.AIRBRIDGE.getValue());
        this.semanticAttributes = new JSONObject();
    }

    public final IAnalyticsSpecific addSemanticAttribute(String name, Object value) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(this.semanticAttributes.put(name, value));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.w(Const.TAG, "[AirbridgeSpecific] addSemanticAttribute() exception : " + thM7418exceptionOrNullimpl);
        }
        return this;
    }

    public final IAnalyticsSpecific setSemanticAction(String name) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(this.semanticAttributes.put(NativeProtocol.WEB_DIALOG_ACTION, name));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.w(Const.TAG, "[AirbridgeSpecific] setAction() exception : " + thM7418exceptionOrNullimpl);
        }
        return this;
    }

    public final IAnalyticsSpecific setSemanticLabel(String name) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(this.semanticAttributes.put(Constants.ScionAnalytics.PARAM_LABEL, name));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.w(Const.TAG, "[AirbridgeSpecific] setLabel() exception : " + thM7418exceptionOrNullimpl);
        }
        return this;
    }

    public final IAnalyticsSpecific setSemanticValue(double value) {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(this.semanticAttributes.put("value", value));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Log.w(Const.TAG, "[AirbridgeSpecific] setValue() exception : " + thM7418exceptionOrNullimpl);
        }
        return this;
    }

    @Override // com.hive.analytics.provider.attributes.IAnalyticsSpecific
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("semanticAttributes", this.semanticAttributes);
        return jSONObject;
    }
}
