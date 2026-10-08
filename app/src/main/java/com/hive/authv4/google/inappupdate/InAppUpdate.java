package com.hive.authv4.google.inappupdate;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.hive.HiveActivity;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.Logger;
import com.hive.module.interfaces.authv4.GoogleInAppUpdate;
import com.hive.ui.OnActivityLifecycle;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: InAppUpdate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0007J\u001c\u0010\u0015\u001a\u00020\u00122\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/hive/authv4/google/inappupdate/InAppUpdate;", "Lcom/hive/ui/OnActivityLifecycle;", "<init>", "()V", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "updateFlowListener", "Lcom/hive/module/interfaces/authv4/GoogleInAppUpdate$UpdateFlowListener;", "currentAppUpdateType", "", "installStatusListener", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "appUpdateRequestCode", "getAppUpdateManager", "getAppUpdateInfo", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchAppUpdateFlow", "", "appUpdateType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "completeUpdate", "Lkotlin/Function1;", "", "onResume", "activity", "Landroid/app/Activity;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "hive-authv4-google-inappupdate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InAppUpdate extends OnActivityLifecycle {
    private AppUpdateManager appUpdateManager;
    private GoogleInAppUpdate.UpdateFlowListener updateFlowListener;
    private int currentAppUpdateType = 1;
    private final InstallStateUpdatedListener installStatusListener = new InstallStateUpdatedListener() { // from class: com.hive.authv4.google.inappupdate.InAppUpdate$$ExternalSyntheticLambda1
        @Override // com.google.android.play.core.listener.StateUpdatedListener
        public final void onStateUpdate(InstallState installState) {
            InAppUpdate.installStatusListener$lambda$0(this.f$0, installState);
        }
    };
    private final int appUpdateRequestCode = 23718;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installStatusListener$lambda$0(InAppUpdate inAppUpdate, InstallState it) {
        GoogleInAppUpdate.UpdateFlowListener updateFlowListener;
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.v("GoogleAppUpdate, InstallStatus: " + it);
        if (it.installStatus() != 11 || (updateFlowListener = inAppUpdate.updateFlowListener) == null) {
            return;
        }
        updateFlowListener.onDownloaded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppUpdateManager getAppUpdateManager() {
        AppUpdateManager appUpdateManager = this.appUpdateManager;
        if (appUpdateManager != null) {
            return appUpdateManager;
        }
        AppUpdateManager appUpdateManagerCreate = AppUpdateManagerFactory.create(HiveCoreInitializer.INSTANCE.getInitContext());
        Intrinsics.checkNotNullExpressionValue(appUpdateManagerCreate, "create(...)");
        appUpdateManagerCreate.registerListener(this.installStatusListener);
        return appUpdateManagerCreate;
    }

    public final void launchAppUpdateFlow(int appUpdateType, GoogleInAppUpdate.UpdateFlowListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Logger.INSTANCE.v("GoogleAppUpdate, startUpdateFlow(" + appUpdateType + ')');
        this.updateFlowListener = listener;
        this.currentAppUpdateType = appUpdateType;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(listener, appUpdateType, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.authv4.google.inappupdate.InAppUpdate$launchAppUpdateFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppUpdate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.google.inappupdate.InAppUpdate$launchAppUpdateFlow$1", f = "InAppUpdate.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $appUpdateType;
        final /* synthetic */ GoogleInAppUpdate.UpdateFlowListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GoogleInAppUpdate.UpdateFlowListener updateFlowListener, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listener = updateFlowListener;
            this.$appUpdateType = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InAppUpdate.this.new AnonymousClass1(this.$listener, this.$appUpdateType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7415constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = InAppUpdate.this.getAppUpdateInfo(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
            if (appUpdateInfo != null) {
                int i2 = this.$appUpdateType;
                InAppUpdate inAppUpdate = InAppUpdate.this;
                GoogleInAppUpdate.UpdateFlowListener updateFlowListener = this.$listener;
                Logger.INSTANCE.v("GoogleAppUpdate, appUpdateInfo: \n    updateAvailability: " + appUpdateInfo.updateAvailability() + "\n    installStatus: " + appUpdateInfo.installStatus() + '\n');
                if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(i2)) {
                    HiveActivity.registerHiveActivityLifecycleListeners(inAppUpdate);
                    Logger.INSTANCE.v("GoogleAppUpdate, UPDATE_AVAILABLE, startUpdateFlowForResult.");
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(Boxing.boxBoolean(inAppUpdate.getAppUpdateManager().startUpdateFlowForResult(appUpdateInfo, i2, HiveActivity.INSTANCE.getRecentActivity(), inAppUpdate.appUpdateRequestCode)));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                    if (thM7418exceptionOrNullimpl != null) {
                        Logger.INSTANCE.w("GoogleAppUpdate, startUpdateFlowForResult - failed: " + thM7418exceptionOrNullimpl + AbstractJsonLexerKt.END_OBJ);
                        updateFlowListener.onNotAvailable();
                    }
                    Result.m7414boximpl(objM7415constructorimpl);
                } else if (appUpdateInfo.updateAvailability() == 3 && appUpdateInfo.installStatus() == 2) {
                    Logger.INSTANCE.v("GoogleAppUpdate, startUpdateFlow DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS, DOWNLOADING.");
                    updateFlowListener.onDownloading();
                } else if (appUpdateInfo.updateAvailability() == 3 && appUpdateInfo.installStatus() == 11) {
                    Logger.INSTANCE.v("GoogleAppUpdate, startUpdateFlow DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS.");
                    updateFlowListener.onDeveloperTriggered();
                } else {
                    Logger.INSTANCE.v("GoogleAppUpdate, startUpdateFlow - not available.");
                    updateFlowListener.onNotAvailable();
                }
            } else {
                this.$listener.onNotAvailable();
                Unit unit = Unit.INSTANCE;
                Logger.INSTANCE.w("GoogleAppUpdate, startUpdateFlow - getAppUpdateInfo error.");
            }
            return Unit.INSTANCE;
        }
    }

    public final void completeUpdate(final Function1<? super Boolean, Unit> listener) {
        Logger.INSTANCE.v("GoogleAppUpdate, completeUpdate");
        getAppUpdateManager().completeUpdate().addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.authv4.google.inappupdate.InAppUpdate$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                InAppUpdate.completeUpdate$lambda$5(listener, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void completeUpdate$lambda$5(Function1 function1, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.v("GoogleAppUpdate, completeUpdate - " + it.isSuccessful() + ": (" + it.getException() + ')');
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(it.isSuccessful()));
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.currentAppUpdateType == 1) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C28501(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.google.inappupdate.InAppUpdate$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppUpdate.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.authv4.google.inappupdate.InAppUpdate$onResume$1", f = "InAppUpdate.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
    static final class C28501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C28501(Continuation<? super C28501> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InAppUpdate.this.new C28501(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM7415constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = InAppUpdate.this.getAppUpdateInfo(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
            if (appUpdateInfo != null) {
                InAppUpdate inAppUpdate = InAppUpdate.this;
                Logger.INSTANCE.v("GoogleAppUpdate, appUpdateInfo in onResume(): \n    updateAvailability: " + appUpdateInfo.updateAvailability() + "\n    installStatus: " + appUpdateInfo.installStatus() + '\n');
                if (appUpdateInfo.updateAvailability() == 2 || appUpdateInfo.updateAvailability() == 3) {
                    Logger.INSTANCE.v("GoogleAppUpdate, IMMEDIATE Update, restart startUpdateFlowForResult in onResume().");
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(Boxing.boxBoolean(inAppUpdate.getAppUpdateManager().startUpdateFlowForResult(appUpdateInfo, inAppUpdate.currentAppUpdateType, HiveActivity.INSTANCE.getRecentActivity(), inAppUpdate.appUpdateRequestCode)));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                    if (thM7418exceptionOrNullimpl != null) {
                        Logger.INSTANCE.w("GoogleAppUpdate, startUpdateFlowForResult in onResume - failed: " + thM7418exceptionOrNullimpl + AbstractJsonLexerKt.END_OBJ);
                        GoogleInAppUpdate.UpdateFlowListener updateFlowListener = inAppUpdate.updateFlowListener;
                        if (updateFlowListener != null) {
                            updateFlowListener.onNotAvailable();
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.v("GoogleAppUpdate, onActivityResult requestCode: " + requestCode + ", resultCode: " + resultCode);
        if (requestCode == this.appUpdateRequestCode && this.currentAppUpdateType == 0) {
            if (resultCode == -1) {
                Logger.INSTANCE.v("GoogleAppUpdate, Update Start.");
                GoogleInAppUpdate.UpdateFlowListener updateFlowListener = this.updateFlowListener;
                if (updateFlowListener != null) {
                    updateFlowListener.onDownloading();
                    return;
                }
                return;
            }
            Logger.INSTANCE.v("GoogleAppUpdate, Update Canceled.");
            GoogleInAppUpdate.UpdateFlowListener updateFlowListener2 = this.updateFlowListener;
            if (updateFlowListener2 != null) {
                updateFlowListener2.onCanceled();
            }
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.v("GoogleAppUpdate, onDestroy");
        HiveActivity.unregisterHiveActivityLifecycleListeners(this);
        getAppUpdateManager().unregisterListener(this.installStatusListener);
        this.appUpdateManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAppUpdateInfo(Continuation<? super AppUpdateInfo> continuation) {
        Object objM7415constructorimpl;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(getAppUpdateManager().getAppUpdateInfo().addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.authv4.google.inappupdate.InAppUpdate$getAppUpdateInfo$2$1$1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task<AppUpdateInfo> task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    if (task.isSuccessful() && task.getResult() != null) {
                        if (cancellableContinuationImpl2.isActive()) {
                            CancellableContinuation<AppUpdateInfo> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m7415constructorimpl(task.getResult()));
                            return;
                        }
                        return;
                    }
                    Logger.INSTANCE.w("GoogleAppUpdate, getAppUpdateInfo - task failed.: " + task.getException());
                    if (cancellableContinuationImpl2.isActive()) {
                        CancellableContinuation<AppUpdateInfo> cancellableContinuation2 = cancellableContinuationImpl2;
                        Result.Companion companion3 = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m7415constructorimpl(null));
                    }
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.w("GoogleAppUpdate, getAppUpdateInfo - failed.: " + thM7418exceptionOrNullimpl);
            if (cancellableContinuationImpl2.isActive()) {
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m7415constructorimpl(null));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
