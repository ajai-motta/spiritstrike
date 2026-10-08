package com.hive.iapv4.repayment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.hive.HiveActivity;
import com.hive.IAPV4;
import com.hive.ResultAPI;
import com.hive.core.ExtentionsKt;
import com.hive.iapv4.IapV4Impl;
import com.hive.iapv4.repayment.Repayment;
import com.hive.iapv4.repayment.ui.RepaymentUi;
import com.hive.iapv4.repayment.ui.model.RepaymentItem;
import com.hive.iapv4.repayment.ui.model.RepaymentListener;
import com.hive.iapv4.repayment.ui.model.RepaymentState;
import com.hive.iapv4.repayment.ui.source.RepaymentSource;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.iapv4.RefundInfo;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.OnActivityLifecycle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Repayment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0011\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\"\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010!j\n\u0012\u0004\u0012\u00020\"\u0018\u0001`#H\u0082@¢\u0006\u0002\u0010$J.\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0082@¢\u0006\u0002\u0010$J$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010)0'2\u0006\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010,J\"\u0010-\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010!j\n\u0012\u0004\u0012\u00020)\u0018\u0001`#H\u0082@¢\u0006\u0002\u0010$J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u0015H\u0002J\u000e\u00100\u001a\u000201H\u0082@¢\u0006\u0002\u0010$J\u001a\u00102\u001a\u0004\u0018\u00010\r2\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0002J\"\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020)2\n\b\u0002\u00108\u001a\u0004\u0018\u00010+H\u0082@¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010$J\u000e\u0010;\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/hive/iapv4/repayment/Repayment;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;)V", "getActivity", "()Landroid/app/Activity;", "getAccount", "()Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "dataSource", "Lcom/hive/iapv4/repayment/ui/source/RepaymentSource;", "repaymentUi", "Lcom/hive/iapv4/repayment/ui/RepaymentUi;", "repaymentUiActivityLifecycle", "com/hive/iapv4/repayment/Repayment$repaymentUiActivityLifecycle$1", "Lcom/hive/iapv4/repayment/Repayment$repaymentUiActivityLifecycle$1;", "productMap", "Ljava/util/HashMap;", "", "Lcom/hive/IAPV4$IAPV4Product;", "Lkotlin/collections/HashMap;", "init", "", "isRequireRepayment", "showListener", "Lkotlin/Function0;", "", "show", "startGameListener", "iapV4marketConnect", "Ljava/util/ArrayList;", "Lcom/hive/IAPV4$IAPV4Type;", "Lkotlin/collections/ArrayList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iapV4getProductInfo", "iapV4voidPurchase", "Lkotlin/Pair;", "Lcom/hive/ResultAPI;", "Lcom/hive/IAPV4$IAPV4Receipt;", "item", "Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;", "(Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iapV4voidRestore", "iapV4voidTransactionFinish", "marketPid", "getRefundInfo", "Lcom/hive/protocol/iapv4/RefundInfo$RefundInfoResponse;", "createSource", "selectedMarket", "refundInfoResponse", "repayment", "verifyRepayment", "receipt", "selectedItem", "(Lcom/hive/IAPV4$IAPV4Receipt;Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreRepayment", "refresh", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Repayment {
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private final RepaymentSource dataSource;
    private boolean init;
    private boolean isRequireRepayment;
    private HashMap<String, IAPV4.IAPV4Product> productMap;
    private final RepaymentUi repaymentUi;
    private final Repayment$repaymentUiActivityLifecycle$1 repaymentUiActivityLifecycle;
    private Function0<Unit> showListener;

    /* JADX INFO: renamed from: com.hive.iapv4.repayment.Repayment$restoreRepayment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Repayment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.repayment.Repayment", f = "Repayment.kt", i = {}, l = {TypedValues.CycleType.TYPE_WAVE_OFFSET, 426}, m = "restoreRepayment", n = {}, s = {})
    static final class C29281 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29281(Continuation<? super C29281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Repayment.this.restoreRepayment(this);
        }
    }

    /* JADX INFO: renamed from: com.hive.iapv4.repayment.Repayment$verifyRepayment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Repayment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.repayment.Repayment", f = "Repayment.kt", i = {0, 0}, l = {TTAdConstant.LANDING_PAGE_TYPE_CODE}, m = "verifyRepayment", n = {"receipt", "item"}, s = {"L$0", "L$1"})
    static final class C29301 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C29301(Continuation<? super C29301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Repayment.this.verifyRepayment(null, null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [com.hive.iapv4.repayment.Repayment$repaymentUiActivityLifecycle$1] */
    public Repayment(Activity activity, HiveLifecycle.HiveAccount account) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        this.activity = activity;
        this.account = account;
        RepaymentSource repaymentSource = new RepaymentSource(0, null, null, null, null, null, 63, null);
        this.dataSource = repaymentSource;
        this.repaymentUi = new RepaymentUi(activity, repaymentSource, null, 4, null);
        this.repaymentUiActivityLifecycle = new OnActivityLifecycle() { // from class: com.hive.iapv4.repayment.Repayment$repaymentUiActivityLifecycle$1
            @Override // com.hive.ui.OnActivityLifecycle
            public void onStart(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
                IapV4Impl.INSTANCE.onStart(activity2);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onResume(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
                IapV4Impl.INSTANCE.onResume(activity2);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onPause(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
                IapV4Impl.INSTANCE.onPause(activity2);
            }

            @Override // com.hive.ui.OnActivityLifecycle
            public void onActivityResult(Activity activity2, int requestCode, int resultCode, Intent data) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
                IapV4Impl.INSTANCE.onActivityResult(activity2, requestCode, resultCode, data);
            }
        };
        this.productMap = new HashMap<>();
        this.isRequireRepayment = true;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    }

    public /* synthetic */ Repayment(Activity activity, HiveLifecycle.HiveAccount hiveAccount, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i & 2) != 0 ? HiveLifecycle.INSTANCE.getAccount() : hiveAccount);
    }

    public final HiveLifecycle.HiveAccount getAccount() {
        return this.account;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: com.hive.iapv4.repayment.Repayment$1, reason: invalid class name */
    /* JADX INFO: compiled from: Repayment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.repayment.Repayment$1", f = "Repayment.kt", i = {3, 4}, l = {84, 88, 89, 99, 100, 106, 114}, m = "invokeSuspend", n = {"refundInfoResponse", "refundInfoResponse"}, s = {"L$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Repayment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ff  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007e -> B:25:0x0081). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 320
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.repayment.Repayment.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void show(Function0<Unit> startGameListener) {
        Intrinsics.checkNotNullParameter(startGameListener, "startGameListener");
        LoggerImpl.INSTANCE.i("[Repayment] show");
        if (this.init) {
            this.showListener = null;
            this.repaymentUi.show(new C29291(startGameListener));
        } else {
            this.showListener = startGameListener;
        }
    }

    /* JADX INFO: renamed from: com.hive.iapv4.repayment.Repayment$show$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Repayment.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/hive/iapv4/repayment/Repayment$show$1", "Lcom/hive/iapv4/repayment/ui/model/RepaymentListener;", "onRepayment", "", "item", "Lcom/hive/iapv4/repayment/ui/model/RepaymentItem;", "onRefresh", "onInquiry", "url", "", "onStartGame", "onDestroy", "hive-iapv4-repayment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C29291 implements RepaymentListener {
        final /* synthetic */ Function0<Unit> $startGameListener;

        C29291(Function0<Unit> function0) {
            this.$startGameListener = function0;
        }

        @Override // com.hive.iapv4.repayment.ui.model.RepaymentListener
        public void onRepayment(RepaymentItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            LoggerImpl.INSTANCE.i("[Repayment] onRepayment");
            Activity lunchActivity = Repayment.this.repaymentUi.getLunchActivity();
            if (lunchActivity != null) {
                Repayment repayment = Repayment.this;
                HiveActivity.INSTANCE.setRecentActivity(lunchActivity);
                repayment.repaymentUi.setActivityLifecycle(repayment.repaymentUiActivityLifecycle);
            }
            Repayment.this.repayment(item);
        }

        @Override // com.hive.iapv4.repayment.ui.model.RepaymentListener
        public void onRefresh() {
            LoggerImpl.INSTANCE.i("[Repayment] onRefresh");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new Repayment$show$1$onRefresh$1(Repayment.this, null), 3, null);
        }

        @Override // com.hive.iapv4.repayment.ui.model.RepaymentListener
        public void onInquiry(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.i("[Repayment] onInquiry");
            if (!StringsKt.isBlank(url)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching(Repayment.this.getActivity(), intent, new Function1() { // from class: com.hive.iapv4.repayment.Repayment$show$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Repayment.C29291.onInquiry$lambda$1((Throwable) obj);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onInquiry$lambda$1(Throwable it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.printStackTrace();
            return Unit.INSTANCE;
        }

        @Override // com.hive.iapv4.repayment.ui.model.RepaymentListener
        public void onStartGame() {
            LoggerImpl.INSTANCE.i("[Repayment] onStartGame");
            if (Repayment.this.dataSource.isFullComplete()) {
                LoggerImpl.INSTANCE.i("[Repayment] onStartGame - Full Completed");
                HiveActivity.INSTANCE.setRecentActivity(Repayment.this.getActivity());
                Repayment.this.repaymentUi.setActivityLifecycle(null);
                Handler handler = new Handler(Looper.getMainLooper());
                final Function0<Unit> function0 = this.$startGameListener;
                handler.post(new Runnable() { // from class: com.hive.iapv4.repayment.Repayment$show$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        function0.invoke();
                    }
                });
            }
        }

        @Override // com.hive.iapv4.repayment.ui.model.RepaymentListener
        public void onDestroy() {
            LoggerImpl.INSTANCE.e("[Repayment] onDestroy");
            HiveActivity.INSTANCE.setRecentActivity(Repayment.this.getActivity());
            Handler handler = new Handler(Looper.getMainLooper());
            final Repayment repayment = Repayment.this;
            final Function0<Unit> function0 = this.$startGameListener;
            handler.post(new Runnable() { // from class: com.hive.iapv4.repayment.Repayment$show$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    repayment.show(function0);
                }
            });
        }
    }

    private final void iapV4voidTransactionFinish(String marketPid) {
        LoggerImpl.INSTANCE.d("[Repayment] iapV4voidTransactionFinish: " + marketPid);
        IAPV4.transactionFinish(marketPid, new IAPV4.IAPV4TransactionFinishListener() { // from class: com.hive.iapv4.repayment.Repayment.iapV4voidTransactionFinish.1
            @Override // com.hive.IAPV4.IAPV4TransactionFinishListener
            public void onIAPV4TransactionFinish(ResultAPI result, String marketPid2) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(marketPid2, "marketPid");
                LoggerImpl.INSTANCE.d("[Repayment] iapV4voidTransactionFinish result: " + result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getRefundInfo(Continuation<? super RefundInfo.RefundInfoResponse> continuation) {
        LoggerImpl.INSTANCE.d("[Repayment] getRefundInfo");
        return RepaymentNetwork.INSTANCE.refundInfo(this.account, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RepaymentSource createSource(IAPV4.IAPV4Type selectedMarket, RefundInfo.RefundInfoResponse refundInfoResponse) {
        int length;
        Object objM7415constructorimpl;
        String str;
        RepaymentState repaymentState;
        String str2;
        String title;
        LoggerImpl.INSTANCE.d("[Repayment] createSource");
        if (!refundInfoResponse.isSuccess()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray refundList = refundInfoResponse.getRefundList();
        if (refundList != null && (length = refundList.length()) >= 0) {
            int i = 0;
            while (true) {
                JSONObject jSONObjectOptJSONObject = refundList.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        int i2 = jSONObjectOptJSONObject.getInt("refund_idx");
                        int i3 = jSONObjectOptJSONObject.getInt("market_id");
                        String displayName = IAPV4.IAPV4Type.INSTANCE.findValue(i3).getDisplayName();
                        String string = jSONObjectOptJSONObject.getString("market_pid");
                        String string2 = jSONObjectOptJSONObject.getString("refund_time");
                        int iOptInt = jSONObjectOptJSONObject.optInt("quantity", 1);
                        if (iOptInt > 1) {
                            str = " x " + iOptInt;
                        } else {
                            str = "";
                        }
                        IAPV4.IAPV4Product iAPV4Product = this.productMap.get(string);
                        if (i3 != selectedMarket.getValue()) {
                            iAPV4Product = null;
                        }
                        IAPV4.IAPV4Product iAPV4Product2 = iAPV4Product;
                        if (iAPV4Product2 != null) {
                            title = iAPV4Product2.getTitle();
                            String str3 = iAPV4Product2.getDisplayPrice() + str;
                            repaymentState = RepaymentState.Require;
                            str2 = str3;
                        } else {
                            String string3 = this.activity.getString(R.string.hive_repayment_non_payable_product);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                            repaymentState = RepaymentState.Impossible;
                            str2 = "";
                            title = string3;
                        }
                        Intrinsics.checkNotNull(string);
                        Intrinsics.checkNotNull(string2);
                        RepaymentItem repaymentItem = new RepaymentItem(i2, i3, displayName, string, title, str2, string2, iOptInt, repaymentState);
                        LoggerImpl.INSTANCE.d("[Repayment] createSource - RepaymentItem : " + repaymentItem);
                        objM7415constructorimpl = Result.m7415constructorimpl(Boolean.valueOf(arrayList.add(repaymentItem)));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                    if (thM7418exceptionOrNullimpl != null) {
                        LoggerImpl.INSTANCE.w("[Repayment] createSource exception : " + thM7418exceptionOrNullimpl);
                    }
                    Result.m7414boximpl(objM7415constructorimpl);
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        int value = selectedMarket.getValue();
        String customerSite = refundInfoResponse.getCustomerSite();
        String vid = this.account.getVid();
        return new RepaymentSource(value, customerSite, (vid == null && (vid = this.account.getUid()) == null) ? "" : vid, arrayList, refundInfoResponse.getGuideTitle(), refundInfoResponse.getGuideContent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void repayment(RepaymentItem item) {
        LoggerImpl.INSTANCE.d("[Repayment] repayment");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29271(item, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.iapv4.repayment.Repayment$repayment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Repayment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.repayment.Repayment$repayment$1", f = "Repayment.kt", i = {}, l = {383, 385, 394, 397}, m = "invokeSuspend", n = {}, s = {})
    static final class C29271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RepaymentItem $item;
        Object L$0;
        int label;
        final /* synthetic */ Repayment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29271(RepaymentItem repaymentItem, Repayment repayment, Continuation<? super C29271> continuation) {
            super(2, continuation);
            this.$item = repaymentItem;
            this.this$0 = repayment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29271(this.$item, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2d
                if (r1 == r5) goto L29
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                goto L1d
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1d:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L92
            L21:
                java.lang.Object r1 = r6.L$0
                com.hive.iapv4.repayment.Repayment r1 = (com.hive.iapv4.repayment.Repayment) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L78
            L29:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L4a
            L2d:
                kotlin.ResultKt.throwOnFailure(r7)
                com.hive.iapv4.repayment.ui.model.RepaymentItem r7 = r6.$item
                com.hive.iapv4.repayment.ui.model.RepaymentState r7 = r7.getState()
                com.hive.iapv4.repayment.ui.model.RepaymentState r1 = com.hive.iapv4.repayment.ui.model.RepaymentState.Require
                if (r7 != r1) goto L84
                com.hive.iapv4.repayment.Repayment r7 = r6.this$0
                com.hive.iapv4.repayment.ui.model.RepaymentItem r1 = r6.$item
                r2 = r6
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r6.label = r5
                java.lang.Object r7 = com.hive.iapv4.repayment.Repayment.access$iapV4voidPurchase(r7, r1, r2)
                if (r7 != r0) goto L4a
                return r0
            L4a:
                com.hive.iapv4.repayment.Repayment r1 = r6.this$0
                com.hive.iapv4.repayment.ui.model.RepaymentItem r2 = r6.$item
                kotlin.Pair r7 = (kotlin.Pair) r7
                java.lang.Object r5 = r7.getFirst()
                com.hive.ResultAPI r5 = (com.hive.ResultAPI) r5
                boolean r5 = r5.isSuccess()
                if (r5 == 0) goto L6f
                java.lang.Object r7 = r7.getSecond()
                com.hive.IAPV4$IAPV4Receipt r7 = (com.hive.IAPV4.IAPV4Receipt) r7
                if (r7 == 0) goto L78
                r6.L$0 = r1
                r6.label = r4
                java.lang.Object r7 = com.hive.iapv4.repayment.Repayment.access$verifyRepayment(r1, r7, r2, r6)
                if (r7 != r0) goto L78
                return r0
            L6f:
                java.lang.Object r7 = r7.getFirst()
                com.hive.ResultAPI r7 = (com.hive.ResultAPI) r7
                r7.getErrorCode()
            L78:
                r7 = 0
                r6.L$0 = r7
                r6.label = r3
                java.lang.Object r7 = com.hive.iapv4.repayment.Repayment.access$refresh(r1, r6)
                if (r7 != r0) goto L92
                return r0
            L84:
                com.hive.iapv4.repayment.Repayment r7 = r6.this$0
                r1 = r6
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6.label = r2
                java.lang.Object r7 = com.hive.iapv4.repayment.Repayment.access$refresh(r7, r1)
                if (r7 != r0) goto L92
                return r0
            L92:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.repayment.Repayment.C29271.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object verifyRepayment(com.hive.IAPV4.IAPV4Receipt r5, com.hive.iapv4.repayment.ui.model.RepaymentItem r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.repayment.Repayment.verifyRepayment(com.hive.IAPV4$IAPV4Receipt, com.hive.iapv4.repayment.ui.model.RepaymentItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object verifyRepayment$default(Repayment repayment, IAPV4.IAPV4Receipt iAPV4Receipt, RepaymentItem repaymentItem, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            repaymentItem = null;
        }
        return repayment.verifyRepayment(iAPV4Receipt, repaymentItem, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object restoreRepayment(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.hive.iapv4.repayment.Repayment.C29281
            if (r0 == 0) goto L14
            r0 = r11
            com.hive.iapv4.repayment.Repayment$restoreRepayment$1 r0 = (com.hive.iapv4.repayment.Repayment.C29281) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.hive.iapv4.repayment.Repayment$restoreRepayment$1 r0 = new com.hive.iapv4.repayment.Repayment$restoreRepayment$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r2 = r0.L$0
            java.util.Iterator r2 = (java.util.Iterator) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5b
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L39:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L50
        L3d:
            kotlin.ResultKt.throwOnFailure(r11)
            com.hive.logger.LoggerImpl r11 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.String r2 = "[Repayment] restoreRepayment"
            r11.d(r2)
            r0.label = r4
            java.lang.Object r11 = r10.iapV4voidRestore(r0)
            if (r11 != r1) goto L50
            return r1
        L50:
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            if (r11 == 0) goto L78
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r2 = r11
        L5b:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto L78
            java.lang.Object r11 = r2.next()
            r5 = r11
            com.hive.IAPV4$IAPV4Receipt r5 = (com.hive.IAPV4.IAPV4Receipt) r5
            r0.L$0 = r2
            r0.label = r3
            r6 = 0
            r8 = 2
            r9 = 0
            r4 = r10
            r7 = r0
            java.lang.Object r11 = verifyRepayment$default(r4, r5, r6, r7, r8, r9)
            if (r11 != r1) goto L5b
            return r1
        L78:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.iapv4.repayment.Repayment.restoreRepayment(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.hive.iapv4.repayment.Repayment$refresh$2, reason: invalid class name */
    /* JADX INFO: compiled from: Repayment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.iapv4.repayment.Repayment$refresh$2", f = "Repayment.kt", i = {}, l = {435, 442}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Repayment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoggerImpl.INSTANCE.d("[Repayment] refresh");
                this.label = 1;
                obj = Repayment.this.getRefundInfo(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Repayment.this.repaymentUi.refresh();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            RefundInfo.RefundInfoResponse refundInfoResponse = (RefundInfo.RefundInfoResponse) obj;
            if (refundInfoResponse.isSuccess()) {
                RepaymentSource repaymentSourceCreateSource = Repayment.this.createSource(IAPV4.getSelectedMarket(), refundInfoResponse);
                if (repaymentSourceCreateSource != null) {
                    Repayment.this.dataSource.mergeTo(repaymentSourceCreateSource);
                }
                this.label = 2;
                if (Repayment.this.restoreRepayment(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Repayment.this.repaymentUi.refresh();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object refresh(Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object iapV4marketConnect(Continuation<? super ArrayList<IAPV4.IAPV4Type>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LoggerImpl.INSTANCE.d("[Repayment] iapV4marketConnect");
        IAPV4.marketConnect(new IAPV4.IAPV4MarketInfoListener() { // from class: com.hive.iapv4.repayment.Repayment$iapV4marketConnect$2$1
            @Override // com.hive.IAPV4.IAPV4MarketInfoListener
            public void onIAPV4MarketInfo(ResultAPI result, ArrayList<IAPV4.IAPV4Type> iapV4TypeList) {
                Intrinsics.checkNotNullParameter(result, "result");
                LoggerImpl.INSTANCE.d("[Repayment] iapV4marketConnect result: " + result);
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<ArrayList<IAPV4.IAPV4Type>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(iapV4TypeList));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object iapV4getProductInfo(Continuation<? super HashMap<String, IAPV4.IAPV4Product>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LoggerImpl.INSTANCE.d("[Repayment] iapV4getProductInfo");
        IAPV4.getProductInfo(new IAPV4.IAPV4ProductInfoListener() { // from class: com.hive.iapv4.repayment.Repayment$iapV4getProductInfo$2$1
            /* JADX WARN: Type inference failed for: r6v4, types: [T, java.util.HashMap] */
            @Override // com.hive.IAPV4.IAPV4ProductInfoListener
            public void onIAPV4ProductInfo(ResultAPI result, ArrayList<IAPV4.IAPV4Product> iapV4ProductList, int balance) {
                Intrinsics.checkNotNullParameter(result, "result");
                LoggerImpl.INSTANCE.d("[Repayment] iapV4getProductInfo result: " + result);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                if (iapV4ProductList != null) {
                    ?? map = new HashMap();
                    Iterator<IAPV4.IAPV4Product> it = iapV4ProductList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        IAPV4.IAPV4Product next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        IAPV4.IAPV4Product iAPV4Product = next;
                        ((Map) map).put(iAPV4Product.getMarketPid(), iAPV4Product);
                    }
                    objectRef.element = map;
                }
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<HashMap<String, IAPV4.IAPV4Product>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(objectRef.element));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object iapV4voidPurchase(RepaymentItem repaymentItem, Continuation<? super Pair<ResultAPI, ? extends IAPV4.IAPV4Receipt>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LoggerImpl.INSTANCE.d("[Repayment] iapV4voidPurchase: " + repaymentItem.getMarketPid());
        IAPV4.voidPurchase(repaymentItem.getMarketPid(), null, repaymentItem.getQuantity(), repaymentItem.getRefundIndex(), new IAPV4.IAPV4PurchaseListener() { // from class: com.hive.iapv4.repayment.Repayment$iapV4voidPurchase$2$1
            @Override // com.hive.IAPV4.IAPV4PurchaseListener
            public void onIAPV4Purchase(ResultAPI result, IAPV4.IAPV4Receipt iapV4Receipt) {
                Intrinsics.checkNotNullParameter(result, "result");
                LoggerImpl.INSTANCE.d("[Repayment] iapV4voidPurchase result: " + result);
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<Pair<ResultAPI, ? extends IAPV4.IAPV4Receipt>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(new Pair(result, iapV4Receipt)));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object iapV4voidRestore(Continuation<? super ArrayList<IAPV4.IAPV4Receipt>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LoggerImpl.INSTANCE.d("[Repayment] iapV4voidRestore");
        IAPV4.restore(new IAPV4.IAPV4RestoreListener() { // from class: com.hive.iapv4.repayment.Repayment$iapV4voidRestore$2$1
            @Override // com.hive.IAPV4.IAPV4RestoreListener
            public void onIAPV4Restore(ResultAPI result, ArrayList<IAPV4.IAPV4Receipt> iapv4ReceiptList) {
                Intrinsics.checkNotNullParameter(result, "result");
                LoggerImpl.INSTANCE.d("[Repayment] iapV4voidRestore result: " + result);
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<ArrayList<IAPV4.IAPV4Receipt>> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(iapv4ReceiptList));
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
