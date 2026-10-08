package com.unity3d.ads.core.domain.om;

import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidOmStartSession.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/domain/om/AndroidOmStartSession;", "Lcom/unity3d/ads/core/domain/om/AndroidOmInteraction;", "openMeasurementRepository", "Lcom/unity3d/ads/core/data/repository/OpenMeasurementRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/data/repository/OpenMeasurementRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "options", "Lorg/json/JSONObject;", "(Lcom/unity3d/ads/core/data/model/AdObject;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidOmStartSession extends AndroidOmInteraction {
    private final OpenMeasurementRepository openMeasurementRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidOmStartSession.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.core.domain.om.AndroidOmStartSession", f = "AndroidOmStartSession.kt", i = {0, 0}, l = {18}, m = "invoke", n = {"this", "adObject"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidOmStartSession.this.invoke(null, null, this);
        }
    }

    public AndroidOmStartSession(OpenMeasurementRepository openMeasurementRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(openMeasurementRepository, "openMeasurementRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.openMeasurementRepository = openMeasurementRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.unity3d.ads.core.domain.om.OmInteraction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(com.unity3d.ads.core.data.model.AdObject r12, org.json.JSONObject r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.unity3d.ads.core.domain.om.AndroidOmStartSession.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r14
            com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1 r0 = (com.unity3d.ads.core.domain.om.AndroidOmStartSession.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1 r0 = new com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r12 = r0.L$1
            com.unity3d.ads.core.data.model.AdObject r12 = (com.unity3d.ads.core.data.model.AdObject) r12
            java.lang.Object r13 = r0.L$0
            com.unity3d.ads.core.domain.om.AndroidOmStartSession r13 = (com.unity3d.ads.core.domain.om.AndroidOmStartSession) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L59
        L32:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3a:
            kotlin.ResultKt.throwOnFailure(r14)
            com.unity3d.ads.core.data.repository.OpenMeasurementRepository r14 = r11.openMeasurementRepository
            com.google.protobuf.ByteString r2 = r12.getOpportunityId()
            android.webkit.WebView r4 = r11.getWebview(r12)
            com.unity3d.ads.core.data.model.OmidOptions r13 = r11.getOMidOptions(r13)
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r14 = r14.startSession(r2, r4, r13, r0)
            if (r14 != r1) goto L58
            return r1
        L58:
            r13 = r11
        L59:
            r7 = r12
            com.unity3d.ads.core.data.model.OMResult r14 = (com.unity3d.ads.core.data.model.OMResult) r14
            boolean r12 = r14 instanceof com.unity3d.ads.core.data.model.OMResult.Success
            if (r12 == 0) goto L6f
            com.unity3d.ads.core.domain.SendDiagnosticEvent r2 = r13.sendDiagnosticEvent
            r9 = 46
            r10 = 0
            java.lang.String r3 = "om_session_start_success"
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto La4
        L6f:
            boolean r12 = r14 instanceof com.unity3d.ads.core.data.model.OMResult.Failure
            if (r12 == 0) goto La4
            com.unity3d.ads.core.domain.SendDiagnosticEvent r2 = r13.sendDiagnosticEvent
            java.util.Map r12 = kotlin.collections.MapsKt.createMapBuilder()
            com.unity3d.ads.core.data.model.OMResult$Failure r14 = (com.unity3d.ads.core.data.model.OMResult.Failure) r14
            java.lang.String r13 = r14.getReason()
            java.lang.String r0 = "reason"
            r12.put(r0, r13)
            java.lang.String r13 = r14.getReasonDebug()
            if (r13 == 0) goto L93
            java.lang.String r13 = "reason_debug"
            java.lang.String r14 = r14.getReasonDebug()
            r12.put(r13, r14)
        L93:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            java.util.Map r5 = kotlin.collections.MapsKt.build(r12)
            r9 = 42
            r10 = 0
            java.lang.String r3 = "om_session_start_failure"
            r4 = 0
            r6 = 0
            r8 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        La4:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.om.AndroidOmStartSession.invoke(com.unity3d.ads.core.data.model.AdObject, org.json.JSONObject, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
