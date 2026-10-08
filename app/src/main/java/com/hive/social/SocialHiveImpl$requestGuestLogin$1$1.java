package com.hive.social;

import android.app.Activity;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.auth.AuthImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.iapv4.Repayment;
import com.hive.protocol.socialapi.GuestLogin;
import com.hive.social.SocialHiveImpl$requestGuestLogin$1$1;
import com.hive.standalone.HiveLifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.social.SocialHiveImpl$requestGuestLogin$1$1", f = "SocialHiveImpl.kt", i = {}, l = {1861, 1873}, m = "invokeSuspend", n = {}, s = {})
public final class SocialHiveImpl$requestGuestLogin$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GuestLogin $guestLogin;
    final /* synthetic */ SocialHive.GuestLoginParam $guestLoginParam;
    final /* synthetic */ SocialHive.AsyncRequestListener $listener;
    final /* synthetic */ ResultAPI $resultApi;
    final /* synthetic */ String $verifier;
    int label;

    /* JADX INFO: renamed from: com.hive.social.SocialHiveImpl$requestGuestLogin$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.social.SocialHiveImpl$requestGuestLogin$1$1$2", f = "SocialHiveImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HiveLifecycle.HiveAccount $account;
        final /* synthetic */ SocialHive.GuestLoginParam $guestLoginParam;
        final /* synthetic */ SocialHive.AsyncRequestListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HiveLifecycle.HiveAccount hiveAccount, SocialHive.GuestLoginParam guestLoginParam, SocialHive.AsyncRequestListener asyncRequestListener, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$account = hiveAccount;
            this.$guestLoginParam = guestLoginParam;
            this.$listener = asyncRequestListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(SocialHive.GuestLoginParam guestLoginParam, SocialHive.AsyncRequestListener asyncRequestListener) {
            SocialHiveImpl.INSTANCE.requestGuestAuth(new SocialHive.GuestAuthParam(guestLoginParam.getGuestUid()), asyncRequestListener);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$account, this.$guestLoginParam, this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = Repayment.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof Repayment)) {
                hiveModule = null;
            }
            if (!(hiveModule instanceof Repayment)) {
                hiveModule = null;
            }
            Repayment repayment = (Repayment) hiveModule;
            if (repayment != null) {
                Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
                HiveLifecycle.HiveAccount hiveAccount = this.$account;
                final SocialHive.GuestLoginParam guestLoginParam = this.$guestLoginParam;
                final SocialHive.AsyncRequestListener asyncRequestListener = this.$listener;
                repayment.showRepayment(recentActivity, hiveAccount, new Function0() { // from class: com.hive.social.SocialHiveImpl$requestGuestLogin$1$1$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SocialHiveImpl$requestGuestLogin$1$1.AnonymousClass2.invokeSuspend$lambda$0(guestLoginParam, asyncRequestListener);
                    }
                });
            } else {
                this.$listener.onComplete(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveIapV4:Repayment"), null);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.social.SocialHiveImpl$requestGuestLogin$1$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.social.SocialHiveImpl$requestGuestLogin$1$1$3", f = "SocialHiveImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GuestLogin $guestLogin;
        final /* synthetic */ SocialHive.AsyncRequestListener $listener;
        final /* synthetic */ ResultAPI $resultApi;
        final /* synthetic */ String $uid;
        final /* synthetic */ String $uidSession;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, String str2, SocialHive.AsyncRequestListener asyncRequestListener, ResultAPI resultAPI, GuestLogin guestLogin, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$uid = str;
            this.$uidSession = str2;
            this.$listener = asyncRequestListener;
            this.$resultApi = resultAPI;
            this.$guestLogin = guestLogin;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$uid, this.$uidSession, this.$listener, this.$resultApi, this.$guestLogin, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AuthImpl.INSTANCE.onC2SModuleLogin(this.$uid, this.$uidSession, true);
            this.$listener.onComplete(this.$resultApi, this.$guestLogin.getResponse().getJsonResponseData());
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialHiveImpl$requestGuestLogin$1$1(GuestLogin guestLogin, ResultAPI resultAPI, String str, SocialHive.GuestLoginParam guestLoginParam, SocialHive.AsyncRequestListener asyncRequestListener, Continuation<? super SocialHiveImpl$requestGuestLogin$1$1> continuation) {
        super(2, continuation);
        this.$guestLogin = guestLogin;
        this.$resultApi = resultAPI;
        this.$verifier = str;
        this.$guestLoginParam = guestLoginParam;
        this.$listener = asyncRequestListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SocialHiveImpl$requestGuestLogin$1$1(this.$guestLogin, this.$resultApi, this.$verifier, this.$guestLoginParam, this.$listener, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x01ba, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r13, r4, r12) == r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01d4, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r13, r1, r12) == r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01d6, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.social.SocialHiveImpl$requestGuestLogin$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SocialHiveImpl$requestGuestLogin$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
