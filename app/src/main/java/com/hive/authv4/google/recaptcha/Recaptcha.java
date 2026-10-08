package com.hive.authv4.google.recaptcha;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.recaptcha.RecaptchaClient;
import com.google.android.recaptcha.RecaptchaException;
import com.hive.Configuration;
import com.hive.Logger;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Recaptcha.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010\u0007J\"\u0010\t\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\n0\fJ\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0015\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/hive/authv4/google/recaptcha/Recaptcha;", "", "<init>", "()V", "recaptchaClient", "Lcom/google/android/recaptcha/RecaptchaClient;", "getClient", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeRecaptchaClient", "execute", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "", "handleFailure", "callFrom", "t", "", "isRecaptchaEnable", "", "getRecaptchaSiteKey", "recaptchaInfoList", "Lorg/json/JSONObject;", "hive-authv4-google-recaptcha_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Recaptcha {
    public static final Recaptcha INSTANCE = new Recaptcha();
    private static RecaptchaClient recaptchaClient;

    /* JADX INFO: renamed from: com.hive.authv4.google.recaptcha.Recaptcha$getRecaptchaSiteKey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recaptcha.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.google.recaptcha.Recaptcha", f = "Recaptcha.kt", i = {}, l = {115}, m = "getRecaptchaSiteKey", n = {}, s = {})
    static final class C28511 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28511(Continuation<? super C28511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recaptcha.this.getRecaptchaSiteKey(this);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.google.recaptcha.Recaptcha$initializeRecaptchaClient$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recaptcha.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.google.recaptcha.Recaptcha", f = "Recaptcha.kt", i = {1, 2, 2}, l = {26, 27, 143}, m = "initializeRecaptchaClient", n = {"isEnable", "siteKey", "isEnable"}, s = {"Z$0", "L$0", "Z$0"})
    static final class C28521 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C28521(Continuation<? super C28521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recaptcha.this.initializeRecaptchaClient(this);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.google.recaptcha.Recaptcha$isRecaptchaEnable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Recaptcha.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.google.recaptcha.Recaptcha", f = "Recaptcha.kt", i = {}, l = {103}, m = "isRecaptchaEnable", n = {}, s = {})
    static final class C28531 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C28531(Continuation<? super C28531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recaptcha.this.isRecaptchaEnable(this);
        }
    }

    private Recaptcha() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getClient(Continuation<? super RecaptchaClient> continuation) {
        RecaptchaClient recaptchaClient2 = recaptchaClient;
        return recaptchaClient2 == null ? initializeRecaptchaClient(continuation) : recaptchaClient2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object initializeRecaptchaClient(kotlin.coroutines.Continuation<? super com.google.android.recaptcha.RecaptchaClient> r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.hive.authv4.google.recaptcha.Recaptcha.C28521
            if (r0 == 0) goto L14
            r0 = r13
            com.hive.authv4.google.recaptcha.Recaptcha$initializeRecaptchaClient$1 r0 = (com.hive.authv4.google.recaptcha.Recaptcha.C28521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.hive.authv4.google.recaptcha.Recaptcha$initializeRecaptchaClient$1 r0 = new com.hive.authv4.google.recaptcha.Recaptcha$initializeRecaptchaClient$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L45
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            boolean r1 = r0.Z$0
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto Lc7
        L37:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L3f:
            boolean r2 = r0.Z$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L66
        L45:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L55
        L49:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.label = r5
            java.lang.Object r13 = r12.isRecaptchaEnable(r0)
            if (r13 != r1) goto L55
            return r1
        L55:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r2 = r13.booleanValue()
            r0.Z$0 = r2
            r0.label = r4
            java.lang.Object r13 = r12.getRecaptchaSiteKey(r0)
            if (r13 != r1) goto L66
            return r1
        L66:
            java.lang.String r13 = (java.lang.String) r13
            r0.L$0 = r13
            r0.Z$0 = r2
            r0.label = r3
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlinx.coroutines.CancellableContinuationImpl r3 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r3.<init>(r4, r5)
            r3.initCancellability()
            r4 = r3
            kotlinx.coroutines.CancellableContinuation r4 = (kotlinx.coroutines.CancellableContinuation) r4
            r5 = 0
            if (r2 == 0) goto La6
            r2 = r13
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L8c
            goto La6
        L8c:
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            kotlinx.coroutines.CoroutineScope r6 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r2)
            com.hive.authv4.google.recaptcha.Recaptcha$initializeRecaptchaClient$2$1 r2 = new com.hive.authv4.google.recaptcha.Recaptcha$initializeRecaptchaClient$2$1
            r2.<init>(r13, r4, r5)
            r9 = r2
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r6, r7, r8, r9, r10, r11)
            goto Lb7
        La6:
            boolean r13 = r4.isActive()
            if (r13 == 0) goto Lb7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            kotlin.Result$Companion r13 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.Result.m7415constructorimpl(r5)
            r4.resumeWith(r13)
        Lb7:
            java.lang.Object r13 = r3.getResult()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r13 != r2) goto Lc4
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        Lc4:
            if (r13 != r1) goto Lc7
            return r1
        Lc7:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.google.recaptcha.Recaptcha.initializeRecaptchaClient(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.hive.authv4.google.recaptcha.Recaptcha$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: Recaptcha.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.google.recaptcha.Recaptcha$execute$1", f = "Recaptcha.kt", i = {}, l = {54, 56}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Integer, String, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super Integer, ? super String, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = Recaptcha.INSTANCE.getClient(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Result.m7414boximpl(((Result) obj).getValue());
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            RecaptchaClient recaptchaClient = (RecaptchaClient) obj;
            if (recaptchaClient != null) {
                Function2<Integer, String, Unit> function2 = this.$listener;
                MainCoroutineDispatcher main = Dispatchers.getMain();
                Recaptcha$execute$1$1$1 recaptcha$execute$1$1$1 = new Recaptcha$execute$1$1$1(recaptchaClient, function2, null);
                this.label = 2;
                obj = BuildersKt.withContext(main, recaptcha$execute$1$1$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Result.m7414boximpl(((Result) obj).getValue());
                return Unit.INSTANCE;
            }
            this.$listener.invoke(Boxing.boxInt(-3), null);
            return Unit.INSTANCE;
        }
    }

    public final void execute(Function2<? super Integer, ? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(listener, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int handleFailure(String callFrom, Throwable t) {
        if (t instanceof ApiException) {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            StringBuilder sb = new StringBuilder("[Recaptcha] ");
            sb.append(callFrom);
            sb.append(" failed(");
            ApiException apiException = (ApiException) t;
            sb.append(apiException.getStatusCode());
            sb.append("): \n  ApiException(");
            sb.append(apiException.getStatus());
            sb.append(')');
            loggerImpl.w(sb.toString());
            return apiException.getStatusCode();
        }
        if (t instanceof RecaptchaException) {
            LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
            StringBuilder sb2 = new StringBuilder("[Recaptcha] ");
            sb2.append(callFrom);
            sb2.append(" failed(");
            RecaptchaException recaptchaException = (RecaptchaException) t;
            sb2.append(recaptchaException.getErrorCode());
            sb2.append("): \n  RecaptchaException(");
            sb2.append(recaptchaException.getErrorMessage());
            sb2.append(')');
            loggerImpl2.w(sb2.toString());
            if (recaptchaException.getErrorCode().ordinal() == 0) {
                return -1;
            }
            return recaptchaException.getErrorCode().ordinal();
        }
        LoggerImpl.INSTANCE.w("[Recaptcha] " + callFrom + " failed(-2): \n  Other failures(" + t + ')');
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object isRecaptchaEnable(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.hive.authv4.google.recaptcha.Recaptcha.C28531
            if (r0 == 0) goto L14
            r0 = r5
            com.hive.authv4.google.recaptcha.Recaptcha$isRecaptchaEnable$1 r0 = (com.hive.authv4.google.recaptcha.Recaptcha.C28531) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.hive.authv4.google.recaptcha.Recaptcha$isRecaptchaEnable$1 r0 = new com.hive.authv4.google.recaptcha.Recaptcha$isRecaptchaEnable$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.recaptchaInfoList(r0)
            if (r5 != r1) goto L3e
            return r1
        L3e:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            if (r5 == 0) goto L4a
            java.lang.String r0 = "is_recaptcha"
            java.lang.String r5 = r5.optString(r0)
            if (r5 != 0) goto L4c
        L4a:
            java.lang.String r5 = ""
        L4c:
            int r0 = r5.hashCode()
            switch(r0) {
                case 48: goto L78;
                case 49: goto L6f;
                case 2583950: goto L66;
                case 3569038: goto L5d;
                case 66658563: goto L5a;
                case 97196323: goto L54;
                default: goto L53;
            }
        L53:
            goto L7b
        L54:
            java.lang.String r0 = "false"
        L56:
            r5.equals(r0)
            goto L7b
        L5a:
            java.lang.String r0 = "FALSE"
            goto L56
        L5d:
            java.lang.String r0 = "true"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L7c
            goto L7b
        L66:
            java.lang.String r0 = "TRUE"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L7c
            goto L7b
        L6f:
            java.lang.String r0 = "1"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L7c
            goto L7b
        L78:
            java.lang.String r0 = "0"
            goto L56
        L7b:
            r3 = 0
        L7c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "[Recaptcha] isRecaptchaEnable: "
            r5.<init>(r0)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.hive.Logger.d(r5)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.google.recaptcha.Recaptcha.isRecaptchaEnable(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getRecaptchaSiteKey(kotlin.coroutines.Continuation<? super java.lang.String> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.hive.authv4.google.recaptcha.Recaptcha.C28511
            if (r0 == 0) goto L14
            r0 = r5
            com.hive.authv4.google.recaptcha.Recaptcha$getRecaptchaSiteKey$1 r0 = (com.hive.authv4.google.recaptcha.Recaptcha.C28511) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.hive.authv4.google.recaptcha.Recaptcha$getRecaptchaSiteKey$1 r0 = new com.hive.authv4.google.recaptcha.Recaptcha$getRecaptchaSiteKey$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.recaptchaInfoList(r0)
            if (r5 != r1) goto L3e
            return r1
        L3e:
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            if (r5 == 0) goto L4a
            java.lang.String r0 = "site_key"
            java.lang.String r5 = r5.optString(r0)
            if (r5 != 0) goto L4c
        L4a:
            java.lang.String r5 = ""
        L4c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "[Recaptcha] recaptchaSiteKey: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.hive.Logger.d(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.google.recaptcha.Recaptcha.getRecaptchaSiteKey(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recaptchaInfoList(Continuation<? super JSONObject> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Configuration.getMetaData("recaptcha_info_list", false, new Configuration.GetMetaDataListener() { // from class: com.hive.authv4.google.recaptcha.Recaptcha$recaptchaInfoList$2$1
            @Override // com.hive.Configuration.GetMetaDataListener
            public void onGetMetaData(ResultAPI result, String data) {
                Object objM7415constructorimpl;
                JSONObject jSONObjectOptJSONObject;
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(data, "data");
                Logger.d("[Recaptcha] recaptchaInfoList: " + data);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONArray jSONArray = new JSONArray(data);
                    int length = jSONArray.length();
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null && Intrinsics.areEqual(jSONObjectOptJSONObject.optString("recaptcha_type"), "v3_app")) {
                                break;
                            } else {
                                i++;
                            }
                        } else {
                            jSONObjectOptJSONObject = null;
                            break;
                        }
                    }
                    objM7415constructorimpl = Result.m7415constructorimpl(jSONObjectOptJSONObject);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                JSONObject jSONObject = (JSONObject) (Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<JSONObject> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion3 = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(jSONObject));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
