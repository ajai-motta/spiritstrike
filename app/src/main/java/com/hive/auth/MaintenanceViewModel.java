package com.hive.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.bolts.AppLinks;
import com.hive.auth.MaintenanceDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/hive/auth/MaintenanceViewModel;", "Landroidx/lifecycle/ViewModel;", "maintenanceModel", "Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;", "<init>", "(Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;)V", "getMaintenanceModel", "()Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;", "_remainingTime", "Landroidx/lifecycle/MutableLiveData;", "", "remainingTime", "Landroidx/lifecycle/LiveData;", "getRemainingTime", "()Landroidx/lifecycle/LiveData;", "updateRemainingTime", "", "Factory", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MaintenanceViewModel extends ViewModel {
    private final MutableLiveData<Integer> _remainingTime;
    private final MaintenanceDialog.MaintenanceModel maintenanceModel;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u0006\u001a\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/hive/auth/MaintenanceViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initMaintenanceModel", "Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;", "<init>", "(Lcom/hive/auth/MaintenanceDialog$MaintenanceModel;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", AppLinks.KEY_NAME_EXTRAS, "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Factory implements ViewModelProvider.Factory {
        private final MaintenanceDialog.MaintenanceModel initMaintenanceModel;

        public Factory(MaintenanceDialog.MaintenanceModel initMaintenanceModel) {
            Intrinsics.checkNotNullParameter(initMaintenanceModel, "initMaintenanceModel");
            this.initMaintenanceModel = initMaintenanceModel;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (modelClass.isAssignableFrom(MaintenanceViewModel.class)) {
                return new MaintenanceViewModel(this.initMaintenanceModel);
            }
            throw new IllegalArgumentException("Unknown class " + modelClass);
        }
    }

    /* JADX INFO: renamed from: com.hive.auth.MaintenanceViewModel$updateRemainingTime$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.MaintenanceViewModel$updateRemainingTime$1", f = "MaintenanceViewModel.kt", i = {0}, l = {28}, m = "invokeSuspend", n = {"endTime"}, s = {"J$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        long J$0;
        Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MaintenanceViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[Catch: all -> 0x0091, TryCatch #0 {all -> 0x0091, blocks: (B:6:0x0015, B:22:0x0061, B:15:0x0042, B:17:0x004c, B:19:0x0054, B:23:0x007e, B:24:0x0085, B:25:0x008a, B:11:0x0026, B:13:0x0036, B:26:0x008b, B:27:0x0090), top: B:35:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0085 A[Catch: all -> 0x0091, TryCatch #0 {all -> 0x0091, blocks: (B:6:0x0015, B:22:0x0061, B:15:0x0042, B:17:0x004c, B:19:0x0054, B:23:0x007e, B:24:0x0085, B:25:0x008a, B:11:0x0026, B:13:0x0036, B:26:0x008b, B:27:0x0090), top: B:35:0x000b }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005e -> B:22:0x0061). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 1000(0x3e8, double:4.94E-321)
                java.lang.String r4 = "Required value was null."
                r5 = 1
                if (r1 == 0) goto L21
                if (r1 != r5) goto L19
                long r6 = r12.J$0
                java.lang.Object r1 = r12.L$0
                com.hive.auth.MaintenanceViewModel r1 = (com.hive.auth.MaintenanceViewModel) r1
                kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Throwable -> L91
                goto L61
            L19:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L21:
                kotlin.ResultKt.throwOnFailure(r13)
                com.hive.auth.MaintenanceViewModel r13 = com.hive.auth.MaintenanceViewModel.this
                kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L91
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L91
                androidx.lifecycle.MutableLiveData r1 = com.hive.auth.MaintenanceViewModel.access$get_remainingTime$p(r13)     // Catch: java.lang.Throwable -> L91
                java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L91
                if (r1 == 0) goto L8b
                java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.lang.Throwable -> L91
                long r8 = r1.longValue()     // Catch: java.lang.Throwable -> L91
                java.lang.Long.signum(r8)
                long r8 = r8 * r2
                long r6 = r6 + r8
                r1 = r13
            L42:
                androidx.lifecycle.MutableLiveData r13 = com.hive.auth.MaintenanceViewModel.access$get_remainingTime$p(r1)     // Catch: java.lang.Throwable -> L91
                java.lang.Object r13 = r13.getValue()     // Catch: java.lang.Throwable -> L91
                if (r13 == 0) goto L85
                java.lang.Number r13 = (java.lang.Number) r13     // Catch: java.lang.Throwable -> L91
                int r13 = r13.intValue()     // Catch: java.lang.Throwable -> L91
                if (r13 < 0) goto L7e
                r12.L$0 = r1     // Catch: java.lang.Throwable -> L91
                r12.J$0 = r6     // Catch: java.lang.Throwable -> L91
                r12.label = r5     // Catch: java.lang.Throwable -> L91
                java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r2, r12)     // Catch: java.lang.Throwable -> L91
                if (r13 != r0) goto L61
                return r0
            L61:
                androidx.lifecycle.MutableLiveData r13 = com.hive.auth.MaintenanceViewModel.access$get_remainingTime$p(r1)     // Catch: java.lang.Throwable -> L91
                long r8 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L91
                long r8 = r6 - r8
                double r8 = (double) r8     // Catch: java.lang.Throwable -> L91
                r10 = 4652007308841189376(0x408f400000000000, double:1000.0)
                double r8 = r8 / r10
                int r8 = kotlin.math.MathKt.roundToInt(r8)     // Catch: java.lang.Throwable -> L91
                java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)     // Catch: java.lang.Throwable -> L91
                r13.setValue(r8)     // Catch: java.lang.Throwable -> L91
                goto L42
            L7e:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L91
                java.lang.Object r13 = kotlin.Result.m7415constructorimpl(r13)     // Catch: java.lang.Throwable -> L91
                goto L9c
            L85:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L91
                r13.<init>(r4)     // Catch: java.lang.Throwable -> L91
                throw r13     // Catch: java.lang.Throwable -> L91
            L8b:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L91
                r13.<init>(r4)     // Catch: java.lang.Throwable -> L91
                throw r13     // Catch: java.lang.Throwable -> L91
            L91:
                r13 = move-exception
                kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
                java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
                java.lang.Object r13 = kotlin.Result.m7415constructorimpl(r13)
            L9c:
                java.lang.Throwable r13 = kotlin.Result.m7418exceptionOrNullimpl(r13)
                if (r13 == 0) goto Lb9
                com.hive.logger.LoggerImpl r0 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "[MaintenanceViewModel] updateRemainingTime() exception: "
                r1.<init>(r2)
                java.lang.String r13 = r13.getMessage()
                r1.append(r13)
                java.lang.String r13 = r1.toString()
                r0.w(r13)
            Lb9:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.MaintenanceViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public MaintenanceViewModel(MaintenanceDialog.MaintenanceModel maintenanceModel) {
        Intrinsics.checkNotNullParameter(maintenanceModel, "maintenanceModel");
        this.maintenanceModel = maintenanceModel;
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._remainingTime = mutableLiveData;
        mutableLiveData.setValue(Integer.valueOf(maintenanceModel.getRemainingTime()));
    }

    public final MaintenanceDialog.MaintenanceModel getMaintenanceModel() {
        return this.maintenanceModel;
    }

    public final LiveData<Integer> getRemainingTime() {
        return this._remainingTime;
    }

    public final void updateRemainingTime() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
