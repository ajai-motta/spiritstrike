package com.hive;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderFuntapAppraisal;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002#$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u0012\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0015H\u0002R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/hive/ProviderFuntap;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "funtap", "Lcom/hive/module/interfaces/authv4/provider/ProviderFuntap;", "getFuntap", "()Lcom/hive/module/interfaces/authv4/provider/ProviderFuntap;", "funtap$delegate", "Lkotlin/Lazy;", "funtapAppraisal", "Lcom/hive/module/interfaces/authv4/provider/ProviderFuntapAppraisal;", "getFuntapAppraisal", "()Lcom/hive/module/interfaces/authv4/provider/ProviderFuntapAppraisal;", "funtapAppraisal$delegate", "isFunTapUnderGovernmentReview", "", "checkUserInfoComplete", "", "userId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/ProviderFuntap$CheckUserInfoCompleteListener;", "showUpdateUserInfo", "Lcom/hive/ProviderFuntap$ShowUpdateUserInfoListener;", "saveCharacter", "roleId", "areaId", "getLibraryMissingError", "Lcom/hive/ResultAPI;", "isAppraisalSdk", "CheckUserInfoCompleteListener", "ShowUpdateUserInfoListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProviderFuntap {
    public static final ProviderFuntap INSTANCE = new ProviderFuntap();
    private static final String TAG;

    /* JADX INFO: renamed from: funtap$delegate, reason: from kotlin metadata */
    private static final Lazy funtap;

    /* JADX INFO: renamed from: funtapAppraisal$delegate, reason: from kotlin metadata */
    private static final Lazy funtapAppraisal;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/ProviderFuntap$CheckUserInfoCompleteListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "isCompleted", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CheckUserInfoCompleteListener {
        void onResult(ResultAPI result, boolean isCompleted);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/ProviderFuntap$ShowUpdateUserInfoListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ShowUpdateUserInfoListener {
        void onResult(ResultAPI result);
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ProviderFuntap", "getSimpleName(...)");
        TAG = "ProviderFuntap";
        funtap = LazyKt.lazy(new Function0() { // from class: com.hive.ProviderFuntap$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProviderFuntap.funtap_delegate$lambda$0();
            }
        });
        funtapAppraisal = LazyKt.lazy(new Function0() { // from class: com.hive.ProviderFuntap$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProviderFuntap.funtapAppraisal_delegate$lambda$1();
            }
        });
    }

    private ProviderFuntap() {
    }

    @JvmStatic
    public static final void checkUserInfoComplete(String userId, final CheckUserInfoCompleteListener listener) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "userId = " + userId);
        ProviderFuntap providerFuntap = INSTANCE;
        com.hive.module.interfaces.authv4.provider.ProviderFuntap funtap2 = providerFuntap.getFuntap();
        if (funtap2 != null) {
            funtap2.checkUserInfoComplete(userId, new Function2() { // from class: com.hive.ProviderFuntap$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProviderFuntap.checkUserInfoComplete$lambda$2(listener, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                }
            });
        } else {
            listener.onResult(getLibraryMissingError$default(providerFuntap, false, 1, null), false);
        }
        loggerImpl.apiReturnLog(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkUserInfoComplete$lambda$2(CheckUserInfoCompleteListener checkUserInfoCompleteListener, boolean z, boolean z2) {
        if (z) {
            checkUserInfoCompleteListener.onResult(new ResultAPI(), z2);
        } else {
            checkUserInfoCompleteListener.onResult(new ResultAPI(-99, ResultAPI.Code.CommonUnknown, "Funtap server error"), false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderFuntapAppraisal funtapAppraisal_delegate$lambda$1() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderFuntapAppraisal.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderFuntapAppraisal)) {
            hiveModule = null;
        }
        return (ProviderFuntapAppraisal) (hiveModule instanceof ProviderFuntapAppraisal ? hiveModule : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.hive.module.interfaces.authv4.provider.ProviderFuntap funtap_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = com.hive.module.interfaces.authv4.provider.ProviderFuntap.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof com.hive.module.interfaces.authv4.provider.ProviderFuntap)) {
            hiveModule = null;
        }
        return (com.hive.module.interfaces.authv4.provider.ProviderFuntap) (hiveModule instanceof com.hive.module.interfaces.authv4.provider.ProviderFuntap ? hiveModule : null);
    }

    private final com.hive.module.interfaces.authv4.provider.ProviderFuntap getFuntap() {
        return (com.hive.module.interfaces.authv4.provider.ProviderFuntap) funtap.getValue();
    }

    private final ProviderFuntapAppraisal getFuntapAppraisal() {
        return (ProviderFuntapAppraisal) funtapAppraisal.getValue();
    }

    private final ResultAPI getLibraryMissingError(boolean isAppraisalSdk) {
        return new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, isAppraisalSdk ? "Funtap-Appraisal" : "Funtap");
    }

    public static /* synthetic */ ResultAPI getLibraryMissingError$default(ProviderFuntap providerFuntap, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return providerFuntap.getLibraryMissingError(z);
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    @JvmStatic
    public static final boolean isFunTapUnderGovernmentReview() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        boolean zIsFunTapUnderGovernmentReview = com.hive.core.Configuration.INSTANCE.isFunTapUnderGovernmentReview();
        loggerImpl.apiReturnLog(str, "result = " + zIsFunTapUnderGovernmentReview);
        return zIsFunTapUnderGovernmentReview;
    }

    @JvmStatic
    public static final void saveCharacter(String roleId, String areaId) {
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        Intrinsics.checkNotNullParameter(areaId, "areaId");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "roleId = " + roleId + ", areaId = " + areaId);
        ProviderFuntapAppraisal funtapAppraisal2 = INSTANCE.getFuntapAppraisal();
        if (funtapAppraisal2 != null) {
            funtapAppraisal2.saveCharacter(HiveActivity.INSTANCE.getRecentActivity(), roleId, areaId);
        } else {
            loggerImpl.w(str, "[ProviderFuntap] CommonLibraryMissing Funtap-Appraisal");
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void showUpdateUserInfo(String userId, final ShowUpdateUserInfoListener listener) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "userId = " + userId);
        ProviderFuntap providerFuntap = INSTANCE;
        com.hive.module.interfaces.authv4.provider.ProviderFuntap funtap2 = providerFuntap.getFuntap();
        if (funtap2 != null) {
            funtap2.showUpdateUserInfo(HiveActivity.INSTANCE.getRecentActivity(), userId, new Function1() { // from class: com.hive.ProviderFuntap$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ProviderFuntap.showUpdateUserInfo$lambda$4(listener, ((Boolean) obj).booleanValue());
                }
            });
        } else {
            listener.onResult(getLibraryMissingError$default(providerFuntap, false, 1, null));
        }
        loggerImpl.apiReturnLog(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showUpdateUserInfo$lambda$4(ShowUpdateUserInfoListener showUpdateUserInfoListener, boolean z) {
        if (z) {
            showUpdateUserInfoListener.onResult(new ResultAPI());
        } else {
            showUpdateUserInfoListener.onResult(new ResultAPI(-99, ResultAPI.Code.CommonUnknown, "User is not completed"));
        }
        return Unit.INSTANCE;
    }
}
