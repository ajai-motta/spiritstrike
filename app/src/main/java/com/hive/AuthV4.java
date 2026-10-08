package com.hive;

import androidx.autofill.HintConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.Permission;
import com.hive.authv4.AuthV4Account;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.helper.AuthV4Helper;
import com.hive.authv4.helper.AuthV4HelperLegacy;
import com.hive.authv4.helper.AuthV4HelperPlayGames;
import com.hive.base.Android;
import com.hive.base.DataModel;
import com.hive.logger.LoggerImpl;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\bÆ\u0002\u0018\u00002\u00020\u0001:3ijklmnopqrstuvwxyz{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u001a\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0007J\u001c\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0007J\"\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u001fH\u0007J\u0012\u0010 \u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010!H\u0007J\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010#H\u0007J\u0012\u0010$\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010%H\u0007J\u0012\u0010&\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010%H\u0007J\u001c\u0010'\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010(H\u0007J\u001c\u0010)\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010(H\u0007J\u001c\u0010*\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010+H\u0007J\u001c\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010+H\u0007J\u001a\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u00100\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u000101H\u0007J.\u00102\u001a\u00020\u00122\u001a\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u000104j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`52\b\u0010\u0013\u001a\u0004\u0018\u000106H\u0007J\u0012\u00107\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0007J>\u00108\u001a\u00020\u00122\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010:2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010:2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010<\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010=H\u0007J\u0012\u0010>\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010?H\u0007J\u0012\u0010@\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010AH\u0007J\u001a\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010DH\u0007J\u0012\u0010E\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010FH\u0007J\u0012\u0010G\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010HH\u0007J\u0012\u0010I\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010JH\u0007J\u001c\u0010K\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010LH\u0007J\u001a\u0010M\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010OH\u0007J\u0010\u0010P\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020QH\u0007J\u001a\u0010R\u001a\u00020\u00122\u0006\u0010N\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010OH\u0007J\u0012\u0010S\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010LH\u0007J\b\u0010T\u001a\u00020\u0012H\u0007J\u0016\u0010U\u001a\u00020\u00122\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0007J\u001a\u0010W\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010XH\u0007J\u0010\u0010Y\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020ZH\u0007J\u0010\u0010[\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\\H\u0007J\u0010\u0010]\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020^H\u0007J\u0018\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020aH\u0007J\u0018\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020dH\u0007J\u0010\u0010e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020fH\u0007J\u0018\u0010g\u001a\u00020\u00122\u0006\u0010h\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020fH\u0007R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\u008e\u0001"}, d2 = {"Lcom/hive/AuthV4;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "isAutoSignIn", "", "getAgeGateU13", "getPlayerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "getIdpList", "", "Lcom/hive/AuthV4$ProviderType;", "setup", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/AuthV4$AuthV4SetupListener;", "signIn", "providerType", "Lcom/hive/AuthV4$AuthV4SignInListener;", "signInWithAuthKey", "authKey", "signInWithStoredPlayerId", "playerId", "", "useAutoSignIn", "getStoredPlayerIdList", "Lcom/hive/AuthV4$AuthV4PlayerIdListListener;", "storeCurrentPlayerId", "Lcom/hive/AuthV4$AuthV4StorePlayerIdListener;", "deleteStoredPlayerId", "Lcom/hive/AuthV4$AuthV4DeletePlayerIdListener;", "signOut", "Lcom/hive/AuthV4$AuthV4SignOutListener;", "playerDelete", "connect", "Lcom/hive/AuthV4$AuthV4ConnectListener;", "connectWithAuthKey", "disconnect", "Lcom/hive/AuthV4$AuthV4DisconnectListener;", "disconnectWithName", "providerName", "selectConflict", "selectedPlayerId", "resolveConflict", "Lcom/hive/AuthV4$AuthV4ResolveConflictListener;", "getProfile", "playerIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/hive/AuthV4$AuthV4GetProfileListener;", "showSignIn", "showConflictSelection", "currentPlayerData", "", "conflictPlayerData", "showProfile", "Lcom/hive/AuthV4$AuthV4ShowProfileListener;", "showInquiry", "Lcom/hive/AuthV4$AuthV4ShowInquiryListener;", "showMyInquiry", "Lcom/hive/AuthV4$AuthV4ShowMyInquiryListener;", "showChatbotInquiry", "additionalInfo", "Lcom/hive/AuthV4$AuthV4ShowChatbotInquiryListener;", "showTerms", "Lcom/hive/AuthV4$AuthV4ShowTermsListener;", "showAdultConfirm", "Lcom/hive/AuthV4$AuthV4AdultConfirmListener;", "showIdentityVerification", "Lcom/hive/AuthV4$AuthV4ShowIdentityVerificationListener;", "checkProvider", "Lcom/hive/AuthV4$AuthV4CheckProviderListener;", "checkMaintenance", "isShow", "Lcom/hive/AuthV4$AuthV4MaintenanceListener;", "requestPermissionViewData", "Lcom/hive/Permission$PermissionViewDataListener;", "checkBlacklist", "setProviderChangedListener", "resetAgreement", "setFacebookPermission", "permission", "getProviderFriendsList", "Lcom/hive/AuthV4$AuthV4ProviderFriendsListener;", "showDeviceManagement", "Lcom/hive/AuthV4$AuthV4ShowDeviceManagementListener;", "refreshAccessToken", "Lcom/hive/AuthV4$AuthV4RefreshAccessTokenListener;", "getHashedDi", "Lcom/hive/AuthV4$AuthV4GetHashedDiListener;", "checkAgeGate", "useCloseButton", "Lcom/hive/AuthV4$AuthV4AgeGateListener;", "setAutoLoginEnabled", "enabled", "Lcom/hive/AuthV4$AuthV4SetAutoLoginEnabledListener;", "getAgeRange", "Lcom/hive/AuthV4$AuthV4GetAgeRangeListener;", "showAgeRangeUpdatePermission", "description", "ProviderType", "AuthV4MaintenanceActionType", "ProfileInfo", "PlayerInfo", "ProviderInfo", "AuthV4MaintenanceInfo", "AuthV4MaintenanceExtraButton", "Identity", "AgeRange", "UserStatus", "AuthV4SetupListener", "AuthV4SignInListener", "AuthV4SignOutListener", "AuthV4ConnectListener", "AuthV4DisconnectListener", "AuthV4GetProfileListener", "AuthV4ShowProfileListener", "AuthV4ShowInquiryListener", "AuthV4ShowMyInquiryListener", "AuthV4ShowChatbotInquiryListener", "AuthV4ShowTermsListener", "AuthV4AdultConfirmListener", "AuthV4ShowIdentityVerificationListener", "AuthV4CheckProviderListener", "AuthV4MaintenanceListener", "AuthV4ProviderFriendsListener", "AuthV4ResolveConflictListener", "AuthV4ShowDeviceManagementListener", "AuthV4RefreshAccessTokenListener", "AuthV4PlayerIdListListener", "AuthV4StorePlayerIdListener", "AuthV4DeletePlayerIdListener", "AuthV4GetHashedDiListener", "AuthV4AgeGateListener", "AuthV4SetAutoLoginEnabledListener", "AuthV4GetAgeRangeListener", "Helper", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4 {
    public static final AuthV4 INSTANCE = new AuthV4();
    private static final String TAG;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/hive/AuthV4$AgeRange;", "Lcom/hive/base/DataModel;", "<init>", "()V", "userStatus", "", "getUserStatus", "()I", "setUserStatus", "(I)V", "ageLower", "getAgeLower", "setAgeLower", "ageUpper", "getAgeUpper", "setAgeUpper", "mostRecentApprovalDate", "", "getMostRecentApprovalDate", "()Ljava/lang/String;", "setMostRecentApprovalDate", "(Ljava/lang/String;)V", "ageRangeId", "getAgeRangeId", "setAgeRangeId", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AgeRange extends DataModel {
        private int userStatus = UserStatus.UNKNOWN.getValue();
        private int ageLower = -1;
        private int ageUpper = -1;
        private String mostRecentApprovalDate = "";
        private String ageRangeId = "";

        public final int getAgeLower() {
            return this.ageLower;
        }

        public final String getAgeRangeId() {
            return this.ageRangeId;
        }

        public final int getAgeUpper() {
            return this.ageUpper;
        }

        public final String getMostRecentApprovalDate() {
            return this.mostRecentApprovalDate;
        }

        public final int getUserStatus() {
            return this.userStatus;
        }

        public final void setAgeLower(int i) {
            this.ageLower = i;
        }

        public final void setAgeRangeId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ageRangeId = str;
        }

        public final void setAgeUpper(int i) {
            this.ageUpper = i;
        }

        public final void setMostRecentApprovalDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mostRecentApprovalDate = str;
        }

        public final void setUserStatus(int i) {
            this.userStatus = i;
        }

        @Override // com.hive.base.DataModel
        public String toString() {
            StringBuilder sb = new StringBuilder("AgeRange(userStatus=");
            UserStatus userStatus = UserStatus.INSTANCE.getUserStatus(this.userStatus);
            sb.append(userStatus != null ? userStatus.name() : null);
            sb.append('(');
            sb.append(this.userStatus);
            sb.append("), ageLower=");
            sb.append(this.ageLower);
            sb.append(", ageUpper=");
            sb.append(this.ageUpper);
            sb.append(", mostRecentApprovalDate=");
            sb.append(this.mostRecentApprovalDate);
            return sb.toString();
        }
    }

    @Deprecated(message = "25.7.0")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4AdultConfirmListener;", "", "onAuthV4AdultConfirm", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4AdultConfirmListener {
        @Deprecated(message = "25.7.0")
        void onAuthV4AdultConfirm(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4AgeGateListener;", "", "onAuthV4AgeGate", "", "result", "Lcom/hive/ResultAPI;", "dateOfBirth", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4AgeGateListener {
        void onAuthV4AgeGate(ResultAPI result, String dateOfBirth);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4CheckProviderListener;", "", "onDeviceProviderInfo", "", "result", "Lcom/hive/ResultAPI;", "providerInfo", "Lcom/hive/AuthV4$ProviderInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4CheckProviderListener {
        void onDeviceProviderInfo(ResultAPI result, ProviderInfo providerInfo);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4ConnectListener;", "", "onAuthV4Connect", "", "result", "Lcom/hive/ResultAPI;", "conflictPlayer", "Lcom/hive/AuthV4$PlayerInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ConnectListener {
        void onAuthV4Connect(ResultAPI result, PlayerInfo conflictPlayer);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4DeletePlayerIdListener;", "", "onAuthV4DeletePlayerId", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4DeletePlayerIdListener {
        void onAuthV4DeletePlayerId(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4DisconnectListener;", "", "onAuthV4Disconnect", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4DisconnectListener {
        void onAuthV4Disconnect(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4GetAgeRangeListener;", "", "onAuthV4GetAgeRange", "", "result", "Lcom/hive/ResultAPI;", "ageRange", "Lcom/hive/AuthV4$AgeRange;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4GetAgeRangeListener {
        void onAuthV4GetAgeRange(ResultAPI result, AgeRange ageRange);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4GetHashedDiListener;", "", "onAuthV4GetHashedDi", "", "resultApi", "Lcom/hive/ResultAPI;", "hashedDi", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4GetHashedDiListener {
        void onAuthV4GetHashedDi(ResultAPI resultApi, String hashedDi);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/AuthV4$AuthV4GetProfileListener;", "", "onAuthV4GetProfile", "", "result", "Lcom/hive/ResultAPI;", "profileInfoList", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$ProfileInfo;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4GetProfileListener {
        void onAuthV4GetProfile(ResultAPI result, ArrayList<ProfileInfo> profileInfoList);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0012"}, d2 = {"Lcom/hive/AuthV4$AuthV4MaintenanceActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "TIMEOVER", "OPEN_URL", "EXIT", "DONE", "stringValue", "", "getStringValue", "()Ljava/lang/String;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthV4MaintenanceActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AuthV4MaintenanceActionType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int value;
        public static final AuthV4MaintenanceActionType UNDEFINED = new AuthV4MaintenanceActionType("UNDEFINED", 0, -1);
        public static final AuthV4MaintenanceActionType TIMEOVER = new AuthV4MaintenanceActionType("TIMEOVER", 1, 0);
        public static final AuthV4MaintenanceActionType OPEN_URL = new AuthV4MaintenanceActionType("OPEN_URL", 2, 1);
        public static final AuthV4MaintenanceActionType EXIT = new AuthV4MaintenanceActionType("EXIT", 3, 2);
        public static final AuthV4MaintenanceActionType DONE = new AuthV4MaintenanceActionType("DONE", 4, 3);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4MaintenanceActionType$Companion;", "", "<init>", "()V", "findValue", "Lcom/hive/AuthV4$AuthV4MaintenanceActionType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final AuthV4MaintenanceActionType findValue(int value) {
                if (value == 0) {
                    return AuthV4MaintenanceActionType.TIMEOVER;
                }
                if (value == 1) {
                    return AuthV4MaintenanceActionType.OPEN_URL;
                }
                if (value == 2) {
                    return AuthV4MaintenanceActionType.EXIT;
                }
                if (value != 3) {
                    return null;
                }
                return AuthV4MaintenanceActionType.DONE;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ AuthV4MaintenanceActionType[] $values() {
            return new AuthV4MaintenanceActionType[]{UNDEFINED, TIMEOVER, OPEN_URL, EXIT, DONE};
        }

        static {
            AuthV4MaintenanceActionType[] authV4MaintenanceActionTypeArr$values = $values();
            $VALUES = authV4MaintenanceActionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(authV4MaintenanceActionTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private AuthV4MaintenanceActionType(String str, int i, int i2) {
            this.value = i2;
        }

        @JvmStatic
        public static final AuthV4MaintenanceActionType findValue(int i) {
            return INSTANCE.findValue(i);
        }

        public static EnumEntries<AuthV4MaintenanceActionType> getEntries() {
            return $ENTRIES;
        }

        public static AuthV4MaintenanceActionType valueOf(String str) {
            return (AuthV4MaintenanceActionType) Enum.valueOf(AuthV4MaintenanceActionType.class, str);
        }

        public static AuthV4MaintenanceActionType[] values() {
            return (AuthV4MaintenanceActionType[]) $VALUES.clone();
        }

        public final String getStringValue() {
            return String.valueOf(this.value);
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/hive/AuthV4$AuthV4MaintenanceExtraButton;", "", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/hive/AuthV4$AuthV4MaintenanceActionType;", "url", "", "button", "<init>", "(Lcom/hive/AuthV4$AuthV4MaintenanceActionType;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Lcom/hive/AuthV4$AuthV4MaintenanceActionType;", "setAction", "(Lcom/hive/AuthV4$AuthV4MaintenanceActionType;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getButton", "setButton", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthV4MaintenanceExtraButton {
        private AuthV4MaintenanceActionType action;
        private String button;
        private String url;

        public AuthV4MaintenanceExtraButton(AuthV4MaintenanceActionType action, String url, String button) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(button, "button");
            this.action = action;
            this.url = url;
            this.button = button;
        }

        public final AuthV4MaintenanceActionType getAction() {
            return this.action;
        }

        public final String getButton() {
            return this.button;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setAction(AuthV4MaintenanceActionType authV4MaintenanceActionType) {
            Intrinsics.checkNotNullParameter(authV4MaintenanceActionType, "<set-?>");
            this.action = authV4MaintenanceActionType;
        }

        public final void setButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.button = str;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/AuthV4$AuthV4MaintenanceListener;", "", "onAuthV4Maintenance", "", "result", "Lcom/hive/ResultAPI;", "maintenanceInfo", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$AuthV4MaintenanceInfo;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4MaintenanceListener {
        void onAuthV4Maintenance(ResultAPI result, ArrayList<AuthV4MaintenanceInfo> maintenanceInfo);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/AuthV4$AuthV4PlayerIdListListener;", "", "onAuthV4GetPlayerIdList", "", "result", "Lcom/hive/ResultAPI;", "playerIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4PlayerIdListListener {
        void onAuthV4GetPlayerIdList(ResultAPI result, ArrayList<Long> playerIdList);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH&¨\u0006\f"}, d2 = {"Lcom/hive/AuthV4$AuthV4ProviderFriendsListener;", "", "onGetProviderFriendsList", "", "result", "Lcom/hive/ResultAPI;", "providerType", "Lcom/hive/AuthV4$ProviderType;", "providerUserIdList", "", "", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ProviderFriendsListener {
        void onGetProviderFriendsList(ResultAPI result, ProviderType providerType, Map<String, Long> providerUserIdList);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4RefreshAccessTokenListener;", "", "onAuthV4RefreshAccessToken", "", "resultApi", "Lcom/hive/ResultAPI;", "accessToken", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4RefreshAccessTokenListener {
        void onAuthV4RefreshAccessToken(ResultAPI resultApi, String accessToken);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4ResolveConflictListener;", "", "onAuthV4ResolveConflict", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ResolveConflictListener {
        void onAuthV4ResolveConflict(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4SetAutoLoginEnabledListener;", "", "onAuthV4SetAutoLoginEnabled", "", "resultApi", "Lcom/hive/ResultAPI;", "enabled", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4SetAutoLoginEnabledListener {
        void onAuthV4SetAutoLoginEnabled(ResultAPI resultApi, boolean enabled);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rH&¨\u0006\u000e"}, d2 = {"Lcom/hive/AuthV4$AuthV4SetupListener;", "", "onAuthV4Setup", "", "result", "Lcom/hive/ResultAPI;", "isAutoSignIn", "", "did", "", "providerTypeList", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$ProviderType;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4SetupListener {
        void onAuthV4Setup(ResultAPI result, boolean isAutoSignIn, String did, ArrayList<ProviderType> providerTypeList);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4ShowChatbotInquiryListener;", "", "onAuthV4ShowChatbotInquiry", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ShowChatbotInquiryListener {
        void onAuthV4ShowChatbotInquiry(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4ShowDeviceManagementListener;", "", "onAuthV4ShowDeviceManagement", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ShowDeviceManagementListener {
        void onAuthV4ShowDeviceManagement(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4ShowIdentityVerificationListener;", "", "onAuthV4ShowIdentityVerification", "", "result", "Lcom/hive/ResultAPI;", "identity", "Lcom/hive/AuthV4$Identity;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ShowIdentityVerificationListener {
        void onAuthV4ShowIdentityVerification(ResultAPI result, Identity identity);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4ShowInquiryListener;", "", "onAuthV4ShowInquiry", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ShowInquiryListener {
        void onAuthV4ShowInquiry(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4ShowMyInquiryListener;", "", "onAuthV4ShowMyInquiry", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ShowMyInquiryListener {
        void onAuthV4ShowMyInquiry(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4ShowProfileListener;", "", "onAuthV4ShowProfile", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ShowProfileListener {
        void onAuthV4ShowProfile(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4ShowTermsListener;", "", "onAuthV4ShowTerms", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4ShowTermsListener {
        void onAuthV4ShowTerms(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$AuthV4SignInListener;", "", "onAuthV4SignIn", "", "result", "Lcom/hive/ResultAPI;", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4SignInListener {
        void onAuthV4SignIn(ResultAPI result, PlayerInfo playerInfo);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4SignOutListener;", "", "onAuthV4SignOut", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4SignOutListener {
        void onAuthV4SignOut(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/AuthV4$AuthV4StorePlayerIdListener;", "", "onAuthV4StorePlayerId", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4StorePlayerIdListener {
        void onAuthV4StorePlayerId(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002*+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u001a\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0005H\u0007J\u001a\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0007J\"\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0007J\"\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006,"}, d2 = {"Lcom/hive/AuthV4$Helper;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getHelper", "Lcom/hive/authv4/helper/AuthV4Helper;", "getIdpList", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$ProviderType;", "Lkotlin/collections/ArrayList;", "syncAccount", "", "providerType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/AuthV4$Helper$AuthV4HelperListener;", "signIn", "signOut", "playerDelete", "connect", "disconnect", "showConflict", "conflictData", "Lcom/hive/AuthV4$Helper$ConflictSingleViewInfo;", "switchAccount", "resolveConflict", "showAchievements", "achievementsReveal", "achievementId", "achievementsUnlock", "achievementsIncrement", "incrementalAchievementId", "value", "", "showLeaderboard", "leaderboardsSubmitScore", "leaderboardId", FirebaseAnalytics.Param.SCORE, "", "AuthV4HelperListener", "ConflictSingleViewInfo", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Helper {
        public static final Helper INSTANCE = new Helper();
        private static final String TAG;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$Helper$AuthV4HelperListener;", "", "onAuthV4Helper", "", "result", "Lcom/hive/ResultAPI;", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public interface AuthV4HelperListener {
            void onAuthV4Helper(ResultAPI result, PlayerInfo playerInfo);
        }

        static {
            String simpleName = Helper.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            TAG = simpleName;
        }

        private Helper() {
        }

        @JvmStatic
        public static final void achievementsIncrement(String incrementalAchievementId, int value) {
            Intrinsics.checkNotNullParameter(incrementalAchievementId, "incrementalAchievementId");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, incrementalAchievementId + ", " + value);
            achievementsIncrement(incrementalAchievementId, value, null);
            loggerImpl.apiReturnLog(str, "");
        }

        @JvmStatic
        public static final void achievementsReveal(String achievementId) {
            Intrinsics.checkNotNullParameter(achievementId, "achievementId");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, achievementId);
            achievementsReveal(achievementId, null);
            loggerImpl.apiReturnLog(str, "");
        }

        @JvmStatic
        public static final void achievementsUnlock(String achievementId) {
            Intrinsics.checkNotNullParameter(achievementId, "achievementId");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, achievementId);
            achievementsUnlock(achievementId, null);
            loggerImpl.apiReturnLog(str, "");
        }

        @JvmStatic
        public static final void connect(ProviderType providerType, AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().connect(providerType, listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void disconnect(ProviderType providerType, AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().disconnect(providerType, listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        private final AuthV4Helper getHelper() {
            return com.hive.core.Configuration.INSTANCE.getGoogleLegacySupport() ? AuthV4HelperLegacy.INSTANCE : AuthV4HelperPlayGames.INSTANCE;
        }

        @JvmStatic
        public static final ArrayList<ProviderType> getIdpList() {
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, "");
            ArrayList<ProviderType> arrayList = new ArrayList<>(AuthV4.getIdpList());
            loggerImpl.apiReturnLog(str, "getIDPList");
            return arrayList;
        }

        @JvmStatic
        public static final void leaderboardsSubmitScore(String leaderboardId, long score) {
            Intrinsics.checkNotNullParameter(leaderboardId, "leaderboardId");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, leaderboardId);
            leaderboardsSubmitScore(leaderboardId, score, null);
            loggerImpl.apiReturnLog(str, "");
        }

        @JvmStatic
        public static final void playerDelete(AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().playerDelete(listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void resolveConflict(AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().resolveConflict(listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void showAchievements(AuthV4HelperListener listener) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().showAchievements(listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void showConflict(AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().showConflict(listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void showLeaderboard(AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().showLeaderboard(listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void signIn(AuthV4HelperListener listener) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().signIn(listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void signOut(AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().signOut(listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void switchAccount(AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().switchAccount(listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        @JvmStatic
        public static final void syncAccount(ProviderType providerType, AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().syncAccount(providerType, listener);
            loggerImpl.apiReturnLog(str2, "");
        }

        public final String getTAG() {
            return TAG;
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u00020\r2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tJ\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/hive/AuthV4$Helper$ConflictSingleViewInfo;", "", "playerId", "", "<init>", "(J)V", "getPlayerId", "()J", "playerData", "", "", "gameData", "setValue", "", "key", "value", "", "", "setGameData", "getPlayerData", "ToJSONObject", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ConflictSingleViewInfo {
            private final long playerId;
            private Map<String, Object> playerData = new LinkedHashMap();
            private Map<String, Object> gameData = new LinkedHashMap();

            public ConflictSingleViewInfo(long j) {
                this.playerId = j;
            }

            public final JSONObject ToJSONObject() {
                Object objM7415constructorimpl;
                JSONObject jSONObject = new JSONObject();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    jSONObject.put("playerId", this.playerId);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : this.playerData.keySet()) {
                        Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                        String str2 = str;
                        jSONObject2.put(str2, this.playerData.get(str2));
                    }
                    objM7415constructorimpl = Result.m7415constructorimpl(jSONObject.put("conflictSingleViewInfo", jSONObject2));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                JSONObject jSONObject3 = new JSONObject();
                if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                    objM7415constructorimpl = jSONObject3;
                }
                return (JSONObject) objM7415constructorimpl;
            }

            public final Map<String, Object> getPlayerData() {
                this.playerData.put("game_data", this.gameData);
                return this.playerData;
            }

            public final long getPlayerId() {
                return this.playerId;
            }

            public final void setGameData(Map<String, Object> gameData) {
                Intrinsics.checkNotNullParameter(gameData, "gameData");
                this.gameData = gameData;
            }

            public final void setValue(String key, double value) {
                Intrinsics.checkNotNullParameter(key, "key");
                setValue(key, String.valueOf(value));
            }

            public final void setValue(String key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                this.gameData.put(key, value);
            }

            public final void setValue(String key, int value) {
                Intrinsics.checkNotNullParameter(key, "key");
                setValue(key, String.valueOf(value));
            }
        }

        @JvmStatic
        public static final void achievementsIncrement(String incrementalAchievementId, int value, AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(incrementalAchievementId, "incrementalAchievementId");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, incrementalAchievementId + ", " + value);
            INSTANCE.getHelper().achievementsIncrement(incrementalAchievementId, value, listener);
            loggerImpl.apiReturnLog(str, "");
        }

        @JvmStatic
        public static final void achievementsReveal(String achievementId, AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(achievementId, "achievementId");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, achievementId);
            INSTANCE.getHelper().achievementsReveal(achievementId, listener);
            loggerImpl.apiReturnLog(str, "");
        }

        @JvmStatic
        public static final void achievementsUnlock(String achievementId, AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(achievementId, "achievementId");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, achievementId);
            INSTANCE.getHelper().achievementsUnlock(achievementId, listener);
            loggerImpl.apiReturnLog(str, "");
        }

        @JvmStatic
        public static final void leaderboardsSubmitScore(String leaderboardId, long score, AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(leaderboardId, "leaderboardId");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str = TAG;
            loggerImpl.apiCalledLog(str, leaderboardId);
            INSTANCE.getHelper().leaderboardsSubmitScore(leaderboardId, score, listener);
            loggerImpl.apiReturnLog(str, "");
        }

        @JvmStatic
        public static final void showConflict(ConflictSingleViewInfo conflictData, AuthV4HelperListener listener) {
            Intrinsics.checkNotNullParameter(conflictData, "conflictData");
            Intrinsics.checkNotNullParameter(listener, "listener");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            String str2 = TAG;
            loggerImpl.apiCalledLog(str2, str);
            INSTANCE.getHelper().showConflict(conflictData, listener);
            loggerImpl.apiReturnLog(str2, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/hive/AuthV4$Identity;", "Lcom/hive/base/DataModel;", "<init>", "()V", "phoneCode", "", "getPhoneCode", "()Ljava/lang/String;", "setPhoneCode", "(Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "getPhoneNumber", "setPhoneNumber", "dateOfBirth", "getDateOfBirth", "setDateOfBirth", "hashedDi", "getHashedDi", "setHashedDi", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Identity extends DataModel {
        private String phoneCode = "";
        private String phoneNumber = "";
        private String dateOfBirth = "";
        private String hashedDi = "";

        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        public final String getHashedDi() {
            return this.hashedDi;
        }

        public final String getPhoneCode() {
            return this.phoneCode;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final void setDateOfBirth(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.dateOfBirth = str;
        }

        public final void setHashedDi(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.hashedDi = str;
        }

        public final void setPhoneCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.phoneCode = str;
        }

        public final void setPhoneNumber(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.phoneNumber = str;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\rB#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\u000eJ\b\u0010\u001d\u001a\u00020\bH\u0016R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/hive/AuthV4$ProviderInfo;", "Lcom/hive/base/DataModel;", "Ljava/io/Serializable;", "providerType", "Lcom/hive/AuthV4$ProviderType;", "<init>", "(Lcom/hive/AuthV4$ProviderType;)V", "providerUserId", "", "(Lcom/hive/AuthV4$ProviderType;Ljava/lang/String;)V", "providerAppId", "(Lcom/hive/AuthV4$ProviderType;Ljava/lang/String;Ljava/lang/String;)V", "providerName", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProviderName", "()Ljava/lang/String;", "setProviderName", "(Ljava/lang/String;)V", "getProviderType", "()Lcom/hive/AuthV4$ProviderType;", "setProviderType", "getProviderUserId", "setProviderUserId", "getProviderAppId", "setProviderAppId", "providerEmail", "getProviderEmail", "setProviderEmail", InAppPurchaseConstants.METHOD_TO_STRING, k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProviderInfo extends DataModel implements Serializable {
        private static final long serialVersionUID = 9834592837492L;
        private String providerAppId;
        private String providerEmail;
        private String providerName;
        private ProviderType providerType;
        private String providerUserId;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ProviderInfo(ProviderType providerType) {
            this(providerType, "", (String) null);
            Intrinsics.checkNotNullParameter(providerType, "providerType");
        }

        public final String getProviderAppId() {
            return this.providerAppId;
        }

        public final String getProviderEmail() {
            return this.providerEmail;
        }

        public final String getProviderName() {
            return this.providerName;
        }

        public final ProviderType getProviderType() {
            return this.providerType;
        }

        public final String getProviderUserId() {
            return this.providerUserId;
        }

        public final void setProviderAppId(String str) {
            this.providerAppId = str;
        }

        public final void setProviderEmail(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.providerEmail = str;
        }

        public final void setProviderName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.providerName = str;
        }

        public final void setProviderType(ProviderType providerType) {
            Intrinsics.checkNotNullParameter(providerType, "<set-?>");
            this.providerType = providerType;
        }

        public final void setProviderUserId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.providerUserId = str;
        }

        @Override // com.hive.base.DataModel
        public String toString() {
            String str = "\n      providerName: " + this.providerName + "\n      providerType: " + this.providerType + "\n      providerUserId: " + this.providerUserId + "\n      providerAppId: " + this.providerAppId + "\n      providerEmail: " + this.providerEmail + "\n";
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            return str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ProviderInfo(ProviderType providerType, String providerUserId) {
            this(providerType, providerUserId, (String) null);
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            Intrinsics.checkNotNullParameter(providerUserId, "providerUserId");
        }

        public ProviderInfo(ProviderType providerType, String providerUserId, String str) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            Intrinsics.checkNotNullParameter(providerUserId, "providerUserId");
            this.providerName = "";
            this.providerUserId = "";
            this.providerEmail = "";
            this.providerName = providerType.getValue();
            this.providerType = providerType;
            this.providerUserId = providerUserId;
            this.providerAppId = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ProviderInfo(String providerName, String providerUserId) {
            this(providerName, providerUserId, (String) null);
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            Intrinsics.checkNotNullParameter(providerUserId, "providerUserId");
        }

        public ProviderInfo(String providerName, String providerUserId, String str) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            Intrinsics.checkNotNullParameter(providerUserId, "providerUserId");
            this.providerUserId = "";
            this.providerEmail = "";
            this.providerName = providerName;
            ProviderType providerType = ProviderType.INSTANCE.getProviderType(providerName);
            this.providerType = providerType == null ? ProviderType.CUSTOM : providerType;
            this.providerUserId = providerUserId;
            this.providerAppId = str;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\u0081\u0002\u0018\u0000 !2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001!B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/hive/AuthV4$ProviderType;", "Ljava/io/Serializable;", "", "value", "", FirebaseAnalytics.Param.INDEX, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getIndex", "()I", "GUEST", "HIVE", "FACEBOOK", "GOOGLE", "QQ", "VK", "WECHAT", "APPLE", "SIGNIN_APPLE", "LINE", "WEVERSE", "GOOGLE_PLAY_GAMES", "HUAWEI", "FUNTAP", "STEAM", "X", "TELEGRAM", "XIAOMI", "CUSTOM", "AUTO", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProviderType implements Serializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProviderType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static final HashMap<String, ProviderType> map;
        private final int index;
        private final String value;
        public static final ProviderType GUEST = new ProviderType("GUEST", 0, "GUEST", 0);
        public static final ProviderType HIVE = new ProviderType("HIVE", 1, "HIVE", 1);
        public static final ProviderType FACEBOOK = new ProviderType("FACEBOOK", 2, "FACEBOOK", 2);
        public static final ProviderType GOOGLE = new ProviderType("GOOGLE", 3, "GOOGLE", 3);
        public static final ProviderType QQ = new ProviderType("QQ", 4, "QQ", 4);
        public static final ProviderType VK = new ProviderType("VK", 5, "VK", 6);
        public static final ProviderType WECHAT = new ProviderType("WECHAT", 6, "WECHAT", 7);
        public static final ProviderType APPLE = new ProviderType("APPLE", 7, "APPLE", 8);
        public static final ProviderType SIGNIN_APPLE = new ProviderType("SIGNIN_APPLE", 8, "SIGNIN_APPLE", 9);
        public static final ProviderType LINE = new ProviderType("LINE", 9, "LINE", 10);
        public static final ProviderType WEVERSE = new ProviderType("WEVERSE", 10, "WEVERSE", 12);
        public static final ProviderType GOOGLE_PLAY_GAMES = new ProviderType("GOOGLE_PLAY_GAMES", 11, "GOOGLE_PLAY_GAMES", 14);
        public static final ProviderType HUAWEI = new ProviderType("HUAWEI", 12, "HUAWEI", 15);
        public static final ProviderType FUNTAP = new ProviderType("FUNTAP", 13, "FUNTAP", 16);
        public static final ProviderType STEAM = new ProviderType("STEAM", 14, "STEAM", 18);
        public static final ProviderType X = new ProviderType("X", 15, "X", 19);
        public static final ProviderType TELEGRAM = new ProviderType("TELEGRAM", 16, "TELEGRAM", 20);
        public static final ProviderType XIAOMI = new ProviderType("XIAOMI", 17, "XIAOMI", 21);
        public static final ProviderType CUSTOM = new ProviderType("CUSTOM", 18, "CUSTOM", 98);
        public static final ProviderType AUTO = new ProviderType("AUTO", 19, "AUTO", 99);

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/hive/AuthV4$ProviderType$Companion;", "", "<init>", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/hive/AuthV4$ProviderType;", "getProviderType", "key", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final ProviderType getProviderType(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return (ProviderType) ProviderType.map.get(key);
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ ProviderType[] $values() {
            return new ProviderType[]{GUEST, HIVE, FACEBOOK, GOOGLE, QQ, VK, WECHAT, APPLE, SIGNIN_APPLE, LINE, WEVERSE, GOOGLE_PLAY_GAMES, HUAWEI, FUNTAP, STEAM, X, TELEGRAM, XIAOMI, CUSTOM, AUTO};
        }

        static {
            ProviderType[] providerTypeArr$values = $values();
            $VALUES = providerTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(providerTypeArr$values);
            INSTANCE = new Companion(null);
            map = new HashMap<>();
            for (ProviderType providerType : values()) {
                map.put(providerType.value, providerType);
            }
        }

        private ProviderType(String str, int i, String str2, int i2) {
            this.value = str2;
            this.index = i2;
        }

        public static EnumEntries<ProviderType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final ProviderType getProviderType(String str) {
            return INSTANCE.getProviderType(str);
        }

        public static ProviderType valueOf(String str) {
            return (ProviderType) Enum.valueOf(ProviderType.class, str);
        }

        public static ProviderType[] values() {
            return (ProviderType[]) $VALUES.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/hive/AuthV4$UserStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VERIFIED", "SUPERVISED", "SUPERVISED_APPROVAL_PENDING", "SUPERVISED_APPROVAL_DENIED", com.hive.core.Configuration.HIVE_COUNTRY_DEFAULT, "REQUIRED", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UserStatus[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int value;
        public static final UserStatus VERIFIED = new UserStatus("VERIFIED", 0, 0);
        public static final UserStatus SUPERVISED = new UserStatus("SUPERVISED", 1, 1);
        public static final UserStatus SUPERVISED_APPROVAL_PENDING = new UserStatus("SUPERVISED_APPROVAL_PENDING", 2, 2);
        public static final UserStatus SUPERVISED_APPROVAL_DENIED = new UserStatus("SUPERVISED_APPROVAL_DENIED", 3, 3);
        public static final UserStatus UNKNOWN = new UserStatus(com.hive.core.Configuration.HIVE_COUNTRY_DEFAULT, 4, 4);
        public static final UserStatus REQUIRED = new UserStatus("REQUIRED", 5, 5);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/AuthV4$UserStatus$Companion;", "", "<init>", "()V", "getUserStatus", "Lcom/hive/AuthV4$UserStatus;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final UserStatus getUserStatus(int value) {
                if (value == 0) {
                    return UserStatus.VERIFIED;
                }
                if (value == 1) {
                    return UserStatus.SUPERVISED;
                }
                if (value == 2) {
                    return UserStatus.SUPERVISED_APPROVAL_PENDING;
                }
                if (value == 3) {
                    return UserStatus.SUPERVISED_APPROVAL_DENIED;
                }
                if (value == 4) {
                    return UserStatus.UNKNOWN;
                }
                if (value != 5) {
                    return null;
                }
                return UserStatus.REQUIRED;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ UserStatus[] $values() {
            return new UserStatus[]{VERIFIED, SUPERVISED, SUPERVISED_APPROVAL_PENDING, SUPERVISED_APPROVAL_DENIED, UNKNOWN, REQUIRED};
        }

        static {
            UserStatus[] userStatusArr$values = $values();
            $VALUES = userStatusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(userStatusArr$values);
            INSTANCE = new Companion(null);
        }

        private UserStatus(String str, int i, int i2) {
            this.value = i2;
        }

        public static EnumEntries<UserStatus> getEntries() {
            return $ENTRIES;
        }

        public static UserStatus valueOf(String str) {
            return (UserStatus) Enum.valueOf(UserStatus.class, str);
        }

        public static UserStatus[] values() {
            return (UserStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: renamed from: com.hive.AuthV4$refreshAccessToken$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.AuthV4$refreshAccessToken$1", f = "AuthV4.kt", i = {}, l = {2415}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AuthV4RefreshAccessTokenListener $listener;
        int label;

        /* JADX INFO: renamed from: com.hive.AuthV4$refreshAccessToken$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.AuthV4$refreshAccessToken$1$1", f = "AuthV4.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C03491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AuthV4RefreshAccessTokenListener $listener;
            final /* synthetic */ ResultAPI $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03491(AuthV4RefreshAccessTokenListener authV4RefreshAccessTokenListener, ResultAPI resultAPI, Continuation<? super C03491> continuation) {
                super(2, continuation);
                this.$listener = authV4RefreshAccessTokenListener;
                this.$result = resultAPI;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03491(this.$listener, this.$result, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                AuthV4RefreshAccessTokenListener authV4RefreshAccessTokenListener = this.$listener;
                ResultAPI resultAPI = this.$result;
                authV4RefreshAccessTokenListener.onAuthV4RefreshAccessToken(resultAPI, resultAPI.isSuccess() ? AuthV4Account.INSTANCE.getAccessToken() : "");
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AuthV4RefreshAccessTokenListener authV4RefreshAccessTokenListener, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listener = authV4RefreshAccessTokenListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ResultAPI resultAPIRefreshWithResultApi = AuthV4Account.INSTANCE.refreshWithResultApi();
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C03491 c03491 = new C03491(this.$listener, resultAPIRefreshWithResultApi, null);
                this.label = 1;
                if (BuildersKt.withContext(main, c03491, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("AuthV4", "getSimpleName(...)");
        TAG = "AuthV4";
    }

    private AuthV4() {
    }

    @JvmStatic
    public static final void checkAgeGate(boolean useCloseButton, AuthV4AgeGateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.checkAgeGate(useCloseButton, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void checkBlacklist(boolean isShow, AuthV4MaintenanceListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("isShow = %b, listener = %s", Arrays.copyOf(new Object[]{Boolean.valueOf(isShow), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.checkBlacklist(isShow, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void checkMaintenance(boolean isShow, AuthV4MaintenanceListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("isShow = %b, listener = %s", Arrays.copyOf(new Object[]{Boolean.valueOf(isShow), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.checkMaintenance(isShow, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void checkProvider(ProviderType providerType, AuthV4CheckProviderListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ProviderType = " + providerType + ", listener = " + listener, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.checkProvider(providerType, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void connect(ProviderType providerType, AuthV4ConnectListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ProviderType = " + providerType + ", listener = " + listener, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.connect(providerType, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void connectWithAuthKey(String authKey, AuthV4ConnectListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = " + listener, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.connectWithAuthKey(authKey, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void deleteStoredPlayerId(long playerId, AuthV4DeletePlayerIdListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("playerId = %s, listener = %s", Arrays.copyOf(new Object[]{Long.valueOf(playerId), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.deleteStoredPlayerId(playerId, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void disconnect(ProviderType providerType, AuthV4DisconnectListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ProviderType = " + providerType + ", listener = " + listener, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.disconnect(providerType, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void disconnectWithName(String providerName, AuthV4DisconnectListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("providerName = " + providerName + ", listener = " + listener, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.disconnect(providerName, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getAgeRange(AuthV4GetAgeRangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.getAgeRange(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getHashedDi(AuthV4GetHashedDiListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.getHashedDi(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final List<ProviderType> getIdpList() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        ArrayList<ProviderType> idpList = AuthV4Impl.INSTANCE.getIdpList();
        loggerImpl.apiReturnLog(str, "getIDPList");
        return idpList;
    }

    @JvmStatic
    public static final PlayerInfo getPlayerInfo() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        loggerImpl.iL(str, "PlayerInfo : " + playerInfo);
        StringBuilder sb = new StringBuilder("getPlayerInfo : ");
        sb.append(playerInfo != null ? Long.valueOf(playerInfo.getPlayerId()) : null);
        loggerImpl.apiReturnLog(str, sb.toString());
        return playerInfo;
    }

    @JvmStatic
    public static final void getProfile(ArrayList<Long> playerIdList, AuthV4GetProfileListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.getProfile(playerIdList, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getProviderFriendsList(ProviderType providerType, AuthV4ProviderFriendsListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.getProviderFriendsList(providerType, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getStoredPlayerIdList(AuthV4PlayerIdListListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.getStoredPlayerIdList(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    @JvmStatic
    public static final boolean isAutoSignIn() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        boolean zIsAutoSignIn = AuthV4Impl.INSTANCE.isAutoSignIn();
        loggerImpl.apiReturnLog(str, "isAutoSignIn : " + zIsAutoSignIn);
        return zIsAutoSignIn;
    }

    @JvmStatic
    public static final void playerDelete(AuthV4SignOutListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.playerDelete(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void refreshAccessToken(AuthV4RefreshAccessTokenListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(listener, null), 3, null);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void resetAgreement() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        AuthV4Impl.INSTANCE.resetAgreement();
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void resolveConflict(AuthV4ResolveConflictListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.resolveConflict(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void selectConflict(long selectedPlayerId, AuthV4SignInListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("PlayerInfo = %s, listener = %s", Arrays.copyOf(new Object[]{Long.valueOf(selectedPlayerId), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.selectConflict(selectedPlayerId, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void setAutoLoginEnabled(boolean enabled, AuthV4SetAutoLoginEnabledListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.setAutoLoginEnabled(enabled, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void setFacebookPermission(List<String> permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        AuthV4Impl.INSTANCE.setFacebookPermission(permission);
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void setProviderChangedListener(AuthV4CheckProviderListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.setProviderChangedListener(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void setup(AuthV4SetupListener listener) {
        AuthV4Impl.INSTANCE.setup(listener);
        LoggerImpl.INSTANCE.apiReturnLog(TAG, "");
    }

    @Deprecated(message = "25.7.0")
    @JvmStatic
    public static final void showAdultConfirm(AuthV4AdultConfirmListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showAdultConfirm(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showAgeRangeUpdatePermission(String description, AuthV4GetAgeRangeListener listener) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showAgeRangeUpdatePermission(description, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showChatbotInquiry(String additionalInfo, AuthV4ShowChatbotInquiryListener listener) {
        Intrinsics.checkNotNullParameter(additionalInfo, "additionalInfo");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showChatbotInquiry(additionalInfo, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showConflictSelection(Map<String, ? extends Object> currentPlayerData, Map<String, ? extends Object> conflictPlayerData, AuthV4SignInListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showConflictSelection(currentPlayerData, conflictPlayerData, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showDeviceManagement(AuthV4ShowDeviceManagementListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showDeviceManagement(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showIdentityVerification(AuthV4ShowIdentityVerificationListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showIdentityVerification(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showInquiry(AuthV4ShowInquiryListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showInquiry(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showMyInquiry(AuthV4ShowMyInquiryListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showMyInquiry(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showProfile(long playerId, AuthV4ShowProfileListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("playerId = %s, listener = %s", Arrays.copyOf(new Object[]{Long.valueOf(playerId), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showProfile(playerId, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showSignIn(AuthV4SignInListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showSignIn(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void showTerms(AuthV4ShowTermsListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.showTerms(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void signIn(ProviderType providerType, AuthV4SignInListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ProviderType = %s, listener = %s", Arrays.copyOf(new Object[]{providerType.getValue(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.signIn(providerType, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void signInWithAuthKey(String authKey, AuthV4SignInListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("authKey = %s, listener = %s", Arrays.copyOf(new Object[]{authKey, listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.signInWithAuthKey(authKey, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void signInWithStoredPlayerId(long playerId, boolean useAutoSignIn, AuthV4SignInListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("playerId = %s, useAutoSignIn = %b, listener = %s", Arrays.copyOf(new Object[]{Long.valueOf(playerId), Boolean.valueOf(useAutoSignIn), listener}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.signInWithStoredPlayerId(playerId, useAutoSignIn, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void signOut(AuthV4SignOutListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.signOut(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void storeCurrentPlayerId(AuthV4StorePlayerIdListener listener) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.storeCurrentPlayerId(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @Deprecated(message = "4.10.1")
    public final boolean getAgeGateU13() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        boolean ageGateU13 = Configuration.getAgeGateU13();
        loggerImpl.apiReturnLog(str, "getAgeGateU13 : " + ageGateU13);
        return ageGateU13;
    }

    @Deprecated(message = "kotlin version")
    public final void requestPermissionViewData(Permission.PermissionViewDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        AuthV4Impl.INSTANCE.requestPermissionViewData(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0016\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0003\u0010\nJ\b\u0010\u0015\u001a\u00020\bH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/hive/AuthV4$ProfileInfo;", "Lcom/hive/base/DataModel;", "Ljava/io/Serializable;", "<init>", "()V", "playerId", "", "playerName", "", "playerImageUrl", "(JLjava/lang/String;Ljava/lang/String;)V", "getPlayerId", "()J", "setPlayerId", "(J)V", "getPlayerName", "()Ljava/lang/String;", "setPlayerName", "(Ljava/lang/String;)V", "getPlayerImageUrl", "setPlayerImageUrl", InAppPurchaseConstants.METHOD_TO_STRING, k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ProfileInfo extends DataModel implements Serializable {
        private static final long serialVersionUID = 4839752348329L;
        private long playerId;
        private String playerImageUrl;
        private String playerName;

        public ProfileInfo() {
            this.playerName = "";
            this.playerImageUrl = "";
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public final String getPlayerImageUrl() {
            return this.playerImageUrl;
        }

        public final String getPlayerName() {
            return this.playerName;
        }

        public final void setPlayerId(long j) {
            this.playerId = j;
        }

        public final void setPlayerImageUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.playerImageUrl = str;
        }

        public final void setPlayerName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.playerName = str;
        }

        @Override // com.hive.base.DataModel
        public String toString() {
            String str = getClass().getSimpleName() + " =\n    playerId: " + this.playerId + "\n    playerName: " + this.playerName + "\n    playerImageUrl: " + this.playerImageUrl + "\n\n";
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            return str;
        }

        public ProfileInfo(long j, String playerName, String playerImageUrl) {
            Intrinsics.checkNotNullParameter(playerName, "playerName");
            Intrinsics.checkNotNullParameter(playerImageUrl, "playerImageUrl");
            this.playerId = j;
            this.playerName = playerName;
            this.playerImageUrl = playerImageUrl;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004BE\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0003\u0010\u0010BY\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0003\u0010\u0012J\b\u0010\"\u001a\u0004\u0018\u00010\bJ\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\bH\u0016R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f¨\u0006'"}, d2 = {"Lcom/hive/AuthV4$PlayerInfo;", "Lcom/hive/AuthV4$ProfileInfo;", "Ljava/io/Serializable;", "<init>", "()V", "playerId", "", "playerName", "", "playerImageUrl", "playerToken", "did", "providerInfoData", "Ljava/util/HashMap;", "Lcom/hive/AuthV4$ProviderType;", "Lcom/hive/AuthV4$ProviderInfo;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "customProviderInfoData", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;)V", "accessToken", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getPlayerToken", "setPlayerToken", "getDid", "setDid", "getProviderInfoData", "()Ljava/util/HashMap;", "setProviderInfoData", "(Ljava/util/HashMap;)V", "getCustomProviderInfoData", "setCustomProviderInfoData", "serialize", "isGuest", "", InAppPurchaseConstants.METHOD_TO_STRING, k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PlayerInfo extends ProfileInfo implements Serializable {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final long serialVersionUID = 3738492374234L;
        private String accessToken;
        private HashMap<String, ProviderInfo> customProviderInfoData;
        private String did;
        private String playerToken;
        private HashMap<ProviderType, ProviderInfo> providerInfoData;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/hive/AuthV4$PlayerInfo$Companion;", "", "<init>", "()V", "serialVersionUID", "", "deserialize", "Lcom/hive/AuthV4$PlayerInfo;", "hexString", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PlayerInfo deserialize(String hexString) {
                if (hexString == null || StringsKt.isBlank(hexString)) {
                    return null;
                }
                try {
                    Object objDeserialize = Android.INSTANCE.deserialize(hexString);
                    if (objDeserialize instanceof PlayerInfo) {
                        return (PlayerInfo) objDeserialize;
                    }
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }

            private Companion() {
            }
        }

        public PlayerInfo() {
            this.accessToken = "";
            this.playerToken = "";
            this.did = "";
            this.providerInfoData = new HashMap<>();
            this.customProviderInfoData = new HashMap<>();
        }

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final HashMap<String, ProviderInfo> getCustomProviderInfoData() {
            return this.customProviderInfoData;
        }

        public final String getDid() {
            return this.did;
        }

        public final String getPlayerToken() {
            return this.playerToken;
        }

        public final HashMap<ProviderType, ProviderInfo> getProviderInfoData() {
            return this.providerInfoData;
        }

        public final boolean isGuest() {
            return this.providerInfoData.isEmpty() && this.customProviderInfoData.isEmpty();
        }

        public final String serialize() {
            return Android.INSTANCE.serialize(this);
        }

        public final void setAccessToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.accessToken = str;
        }

        public final void setCustomProviderInfoData(HashMap<String, ProviderInfo> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.customProviderInfoData = map;
        }

        public final void setDid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.did = str;
        }

        public final void setPlayerToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.playerToken = str;
        }

        public final void setProviderInfoData(HashMap<ProviderType, ProviderInfo> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.providerInfoData = map;
        }

        @Override // com.hive.AuthV4.ProfileInfo, com.hive.base.DataModel
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(PlayerInfo.class.getSimpleName());
            sb.append(" =\n    playerId : ");
            sb.append(getPlayerId());
            sb.append("\n    playerName : ");
            sb.append(getPlayerName());
            sb.append("\n    playerImageUrl : ");
            sb.append(getPlayerImageUrl());
            sb.append("\n    playerToken : ");
            sb.append(this.playerToken);
            sb.append("\n    did : ");
            sb.append(this.did);
            sb.append("\n    providerInfoData : \n\n");
            for (ProviderType providerType : this.providerInfoData.keySet()) {
                Intrinsics.checkNotNullExpressionValue(providerType, "next(...)");
                ProviderType providerType2 = providerType;
                sb.append("    " + providerType2 + " : ");
                sb.append(this.providerInfoData.get(providerType2));
                sb.append("\n");
            }
            sb.append("    customProviderInfoData : \n\n");
            for (String str : this.customProviderInfoData.keySet()) {
                Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                String str2 = str;
                sb.append("    " + str2 + " : ");
                sb.append(this.customProviderInfoData.get(str2));
                sb.append("\n");
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        public PlayerInfo(long j, String playerName, String playerImageUrl, String playerToken, String did, HashMap<ProviderType, ProviderInfo> providerInfoData) {
            Intrinsics.checkNotNullParameter(playerName, "playerName");
            Intrinsics.checkNotNullParameter(playerImageUrl, "playerImageUrl");
            Intrinsics.checkNotNullParameter(playerToken, "playerToken");
            Intrinsics.checkNotNullParameter(did, "did");
            Intrinsics.checkNotNullParameter(providerInfoData, "providerInfoData");
            this.accessToken = "";
            this.playerToken = "";
            this.did = "";
            this.providerInfoData = new HashMap<>();
            this.customProviderInfoData = new HashMap<>();
            setPlayerId(j);
            setPlayerName(playerName);
            setPlayerImageUrl(playerImageUrl);
            this.playerToken = playerToken;
            this.did = did;
            this.providerInfoData = providerInfoData;
        }

        public PlayerInfo(long j, String playerName, String playerImageUrl, String playerToken, String did, HashMap<ProviderType, ProviderInfo> providerInfoData, HashMap<String, ProviderInfo> customProviderInfoData) {
            Intrinsics.checkNotNullParameter(playerName, "playerName");
            Intrinsics.checkNotNullParameter(playerImageUrl, "playerImageUrl");
            Intrinsics.checkNotNullParameter(playerToken, "playerToken");
            Intrinsics.checkNotNullParameter(did, "did");
            Intrinsics.checkNotNullParameter(providerInfoData, "providerInfoData");
            Intrinsics.checkNotNullParameter(customProviderInfoData, "customProviderInfoData");
            this.accessToken = "";
            this.playerToken = "";
            this.did = "";
            this.providerInfoData = new HashMap<>();
            this.customProviderInfoData = new HashMap<>();
            setPlayerId(j);
            setPlayerName(playerName);
            setPlayerImageUrl(playerImageUrl);
            this.playerToken = playerToken;
            this.did = did;
            this.providerInfoData = providerInfoData;
            this.customProviderInfoData = customProviderInfoData;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\b\u0016\u0018\u00002\u00020\u0001BQ\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fBY\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0012B_\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u000e\u0010\u0016J\b\u00107\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/hive/AuthV4$AuthV4MaintenanceInfo;", "Lcom/hive/base/DataModel;", "type", "", "title", "", "message", "button", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/hive/AuthV4$AuthV4MaintenanceActionType;", "url", "remainingTime", "startDate", "endDate", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/AuthV4$AuthV4MaintenanceActionType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "customerButton", "customerLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/AuthV4$AuthV4MaintenanceActionType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "exButtons", "", "Lcom/hive/AuthV4$AuthV4MaintenanceExtraButton;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/AuthV4$AuthV4MaintenanceActionType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getType", "()I", "setType", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getButton", "setButton", "getAction", "()Lcom/hive/AuthV4$AuthV4MaintenanceActionType;", "setAction", "(Lcom/hive/AuthV4$AuthV4MaintenanceActionType;)V", "getUrl", "setUrl", "getRemainingTime", "setRemainingTime", "getStartDate", "setStartDate", "getEndDate", "setEndDate", "getCustomerButton", "setCustomerButton", "getCustomerLink", "setCustomerLink", "getExButtons", "()Ljava/util/List;", "setExButtons", "(Ljava/util/List;)V", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class AuthV4MaintenanceInfo extends DataModel {
        private AuthV4MaintenanceActionType action;
        private String button;
        private String customerButton;
        private String customerLink;
        private String endDate;
        private List<AuthV4MaintenanceExtraButton> exButtons;
        private String message;
        private int remainingTime;
        private String startDate;
        private String title;
        private int type;
        private String url;

        public AuthV4MaintenanceInfo(int i, String title, String message, String button, AuthV4MaintenanceActionType action, String url, int i2, String startDate, String endDate) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            Intrinsics.checkNotNullParameter(endDate, "endDate");
            this.customerButton = "";
            this.customerLink = "";
            this.type = i;
            this.title = title;
            this.message = message;
            this.button = button;
            this.action = action;
            this.url = url;
            this.remainingTime = i2;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public final AuthV4MaintenanceActionType getAction() {
            return this.action;
        }

        public final String getButton() {
            return this.button;
        }

        public final String getCustomerButton() {
            return this.customerButton;
        }

        public final String getCustomerLink() {
            return this.customerLink;
        }

        public final String getEndDate() {
            return this.endDate;
        }

        public final List<AuthV4MaintenanceExtraButton> getExButtons() {
            return this.exButtons;
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getRemainingTime() {
            return this.remainingTime;
        }

        public final String getStartDate() {
            return this.startDate;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setAction(AuthV4MaintenanceActionType authV4MaintenanceActionType) {
            Intrinsics.checkNotNullParameter(authV4MaintenanceActionType, "<set-?>");
            this.action = authV4MaintenanceActionType;
        }

        public final void setButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.button = str;
        }

        public final void setCustomerButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.customerButton = str;
        }

        public final void setCustomerLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.customerLink = str;
        }

        public final void setEndDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.endDate = str;
        }

        public final void setExButtons(List<AuthV4MaintenanceExtraButton> list) {
            this.exButtons = list;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final void setRemainingTime(int i) {
            this.remainingTime = i;
        }

        public final void setStartDate(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.startDate = str;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        @Override // com.hive.base.DataModel
        public String toString() {
            String str = "AuthV4MaintenanceInfo: \n    type: " + this.type + "\n    title: " + this.title + "\n    message: " + this.message + "\n    button: " + this.button + "\n    action: " + this.action + "\n    url: " + this.url + "\n    remainingTime: " + this.remainingTime + "\n    startDate: " + this.startDate + "\n    endDate: " + this.endDate + "\n    customerButton: " + this.customerButton + "\n    customerLink: " + this.customerLink + "\n\n";
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            return str;
        }

        public AuthV4MaintenanceInfo(String title, String message, String button, AuthV4MaintenanceActionType action, String url, int i, String startDate, String endDate, String customerButton, String customerLink) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            Intrinsics.checkNotNullParameter(endDate, "endDate");
            Intrinsics.checkNotNullParameter(customerButton, "customerButton");
            Intrinsics.checkNotNullParameter(customerLink, "customerLink");
            this.title = title;
            this.message = message;
            this.button = button;
            this.action = action;
            this.url = url;
            this.remainingTime = i;
            this.startDate = startDate;
            this.endDate = endDate;
            this.customerButton = customerButton;
            this.customerLink = customerLink;
        }

        public AuthV4MaintenanceInfo(int i, String title, String message, String button, AuthV4MaintenanceActionType action, String url, int i2, String startDate, String endDate, List<AuthV4MaintenanceExtraButton> exButtons) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(startDate, "startDate");
            Intrinsics.checkNotNullParameter(endDate, "endDate");
            Intrinsics.checkNotNullParameter(exButtons, "exButtons");
            this.customerButton = "";
            this.customerLink = "";
            this.type = i;
            this.title = title;
            this.message = message;
            this.button = button;
            this.action = action;
            this.url = url;
            this.remainingTime = i2;
            this.startDate = startDate;
            this.endDate = endDate;
            this.exButtons = exButtons;
        }
    }
}
