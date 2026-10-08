package com.unity3d.ads.core.configuration;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.core.misc.JsonStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: MediationTraitsMetadataReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/configuration/MediationTraitsMetadataReader;", "Lcom/unity3d/ads/core/configuration/MetadataReader;", "Lorg/json/JSONObject;", "jsonStorage", "Lcom/unity3d/services/core/misc/JsonStorage;", "(Lcom/unity3d/services/core/misc/JsonStorage;)V", "getBooleanTrait", "", "key", "", "(Ljava/lang/String;)Ljava/lang/Boolean;", k.M, "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MediationTraitsMetadataReader extends MetadataReader<JSONObject> {
    public static final String BOLD_SDK_ENABLED = "boldSdkEnabled";
    public static final String MEDIATION_TRAITS = "mediation.traits.value";
    public static final String USE_REFACTORED_HTTP_CLIENT = "useRefactoredHttpClient";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediationTraitsMetadataReader(JsonStorage jsonStorage) {
        super(jsonStorage, MEDIATION_TRAITS);
        Intrinsics.checkNotNullParameter(jsonStorage, "jsonStorage");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean getBooleanTrait(java.lang.String r4) throws org.json.JSONException {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = r3
            com.unity3d.ads.core.configuration.MetadataReader r0 = (com.unity3d.ads.core.configuration.MetadataReader) r0
            com.unity3d.services.core.misc.JsonStorage r1 = r0.getJsonStorage()
            java.lang.String r0 = r0.getKey()
            java.lang.Object r0 = r1.get(r0)
            r1 = 0
            if (r0 == 0) goto L24
            java.lang.String r2 = "get(key)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r2 = r0 instanceof org.json.JSONObject
            if (r2 == 0) goto L21
            goto L22
        L21:
            r0 = r1
        L22:
            if (r0 != 0) goto L25
        L24:
            r0 = r1
        L25:
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            if (r0 == 0) goto L3b
            boolean r2 = r0.has(r4)
            if (r2 == 0) goto L30
            goto L31
        L30:
            r0 = r1
        L31:
            if (r0 == 0) goto L3b
            boolean r4 = r0.optBoolean(r4)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.configuration.MediationTraitsMetadataReader.getBooleanTrait(java.lang.String):java.lang.Boolean");
    }
}
