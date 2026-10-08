package com.hive.authv4;

import android.util.Log;
import com.hive.AuthV4;
import com.hive.Const;
import com.hive.ResultAPI;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Impl$setup$1$1$parseXml$1", f = "AuthV4Impl.kt", i = {0}, l = {395}, m = "invokeSuspend", n = {"isSuccess"}, s = {"Z$0"})
public final class AuthV4Impl$setup$1$1$parseXml$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ AuthV4.AuthV4SetupListener $setupListener;
    boolean Z$0;
    int label;

    /* JADX INFO: renamed from: com.hive.authv4.AuthV4Impl$setup$1$1$parseXml$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.AuthV4Impl$setup$1$1$parseXml$1$1", f = "AuthV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AuthV4.AuthV4SetupListener $setupListener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AuthV4.AuthV4SetupListener authV4SetupListener, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$setupListener = authV4SetupListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$setupListener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Log.e(Const.TAG, "parse error - check configuration xml file");
            AuthV4Impl.isInProgressSetup = false;
            AuthV4.AuthV4SetupListener authV4SetupListener = this.$setupListener;
            if (authV4SetupListener == null) {
                return null;
            }
            authV4SetupListener.onAuthV4Setup(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidConfigurationXml, "parse error - check configuration xml file"), false, null, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV4Impl$setup$1$1$parseXml$1(AuthV4.AuthV4SetupListener authV4SetupListener, Continuation<? super AuthV4Impl$setup$1$1$parseXml$1> continuation) {
        super(2, continuation);
        this.$setupListener = authV4SetupListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Impl$setup$1$1$parseXml$1(this.$setupListener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean xmlConfigurationFile;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
            xmlConfigurationFile = configurationImpl.parseXmlConfigurationFile();
            if (xmlConfigurationFile) {
                boolean ageGateU13 = Configuration.INSTANCE.getAgeGateU13();
                if (ageGateU13) {
                    try {
                        LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "Saved AgeGateU13 : " + ageGateU13);
                        configurationImpl.setAgeGateU13(ageGateU13);
                    } catch (Exception unused) {
                    }
                }
                return Boxing.boxBoolean(xmlConfigurationFile);
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$setupListener, null);
            this.Z$0 = xmlConfigurationFile;
            this.label = 1;
            obj = BuildersKt.withContext(main, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            z = xmlConfigurationFile;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = this.Z$0;
            ResultKt.throwOnFailure(obj);
        }
        xmlConfigurationFile = z;
        return Boxing.boxBoolean(xmlConfigurationFile);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((AuthV4Impl$setup$1$1$parseXml$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
