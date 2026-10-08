package com.unity3d.ads.core.configuration;

import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.services.core.configuration.ConfigurationReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: AlternativeFlowReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u000bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "", "configurationReader", "Lcom/unity3d/services/core/configuration/ConfigurationReader;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "mediationMetadataReader", "Lcom/unity3d/ads/core/configuration/MediationTraitsMetadataReader;", "(Lcom/unity3d/services/core/configuration/ConfigurationReader;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/configuration/MediationTraitsMetadataReader;)V", "isAlternativeFlowEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isAlternativeFlowRead", "invoke", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AlternativeFlowReader {
    private final ConfigurationReader configurationReader;
    private final MutableStateFlow<Boolean> isAlternativeFlowEnabled;
    private final MutableStateFlow<Boolean> isAlternativeFlowRead;
    private final MediationTraitsMetadataReader mediationMetadataReader;
    private final SessionRepository sessionRepository;

    public AlternativeFlowReader(ConfigurationReader configurationReader, SessionRepository sessionRepository, MediationTraitsMetadataReader mediationMetadataReader) {
        Intrinsics.checkNotNullParameter(configurationReader, "configurationReader");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(mediationMetadataReader, "mediationMetadataReader");
        this.configurationReader = configurationReader;
        this.sessionRepository = sessionRepository;
        this.mediationMetadataReader = mediationMetadataReader;
        this.isAlternativeFlowRead = StateFlowKt.MutableStateFlow(false);
        this.isAlternativeFlowEnabled = StateFlowKt.MutableStateFlow(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean invoke() throws org.json.JSONException {
        /*
            r5 = this;
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r0 = r5.isAlternativeFlowRead
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L1b
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r0 = r5.isAlternativeFlowEnabled
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L1b:
            com.unity3d.ads.core.configuration.MediationTraitsMetadataReader r0 = r5.mediationMetadataReader
            com.unity3d.ads.core.configuration.MetadataReader r0 = (com.unity3d.ads.core.configuration.MetadataReader) r0
            com.unity3d.services.core.misc.JsonStorage r1 = r0.getJsonStorage()
            java.lang.String r0 = r0.getKey()
            java.lang.Object r0 = r1.get(r0)
            r1 = 0
            if (r0 == 0) goto L3b
            java.lang.String r2 = "get(key)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r2 = r0 instanceof org.json.JSONObject
            if (r2 == 0) goto L38
            goto L39
        L38:
            r0 = r1
        L39:
            if (r0 != 0) goto L3c
        L3b:
            r0 = r1
        L3c:
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            r2 = 1
            if (r0 == 0) goto L62
            java.lang.String r3 = "boldSdkEnabled"
            boolean r4 = r0.has(r3)
            if (r4 == 0) goto L4a
            r1 = r0
        L4a:
            if (r1 == 0) goto L62
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r0 = r5.isAlternativeFlowEnabled
            boolean r1 = r1.optBoolean(r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.setValue(r1)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r0 = r5.isAlternativeFlowRead
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r0.setValue(r1)
        L62:
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r0 = r5.isAlternativeFlowRead
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto La6
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r0 = r5.isAlternativeFlowEnabled
            com.unity3d.services.core.configuration.ConfigurationReader r1 = r5.configurationReader
            com.unity3d.services.core.configuration.Configuration r1 = r1.getCurrentConfiguration()
            com.unity3d.services.core.configuration.IExperiments r1 = r1.getExperiments()
            boolean r1 = r1.isBoldSdkNextSessionEnabled()
            if (r1 != 0) goto L95
            com.unity3d.ads.core.data.repository.SessionRepository r1 = r5.sessionRepository
            gatewayprotocol.v1.NativeConfigurationOuterClass$NativeConfiguration r1 = r1.getNativeConfiguration()
            gatewayprotocol.v1.NativeConfigurationOuterClass$FeatureFlags r1 = r1.getFeatureFlags()
            boolean r1 = r1.getBoldSdkNextSessionEnabled()
            if (r1 == 0) goto L93
            goto L95
        L93:
            r1 = 0
            goto L96
        L95:
            r1 = r2
        L96:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.setValue(r1)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r0 = r5.isAlternativeFlowRead
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r0.setValue(r1)
        La6:
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r0 = r5.isAlternativeFlowEnabled
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.configuration.AlternativeFlowReader.invoke():boolean");
    }
}
