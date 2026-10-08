package com.hive;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.base.DataModel;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveMatchMaking;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\n123456789:B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0015H\u0007J*\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0017H\u0007J2\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0017H\u0007J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0015H\u0007J \u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0017H\u0007J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0017H\u0007J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0017H\u0007J2\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0017H\u0007J\u0018\u0010#\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0017H\u0007J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0017H\u0007J\"\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\"\u0010+\u001a\u0012\u0012\u0004\u0012\u00020,0&j\b\u0012\u0004\u0012\u00020,`(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\"\u0010-\u001a\u0012\u0012\u0004\u0012\u00020.0&j\b\u0012\u0004\u0012\u00020.`(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\b\u0010/\u001a\u000200H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006;"}, d2 = {"Lcom/hive/MatchMaking;", "", "<init>", "()V", "matchMaking", "Lcom/hive/module/interfaces/HiveMatchMaking;", "getMatchMaking", "()Lcom/hive/module/interfaces/HiveMatchMaking;", "matchMaking$delegate", "Lkotlin/Lazy;", "requestMatchMaking", "", "matchId", "", "point", "extraData", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/MatchMaking$MatchMakingDataListener;", "getRequestingStatus", "deleteRequesting", "Lcom/hive/MatchMaking$MatchMakingResultListener;", "createGroup", "Lcom/hive/MatchMaking$MatchMakingGroupDataListener;", "joinGroup", "groupCode", "leaveGroup", "kickGroupUser", "targetPlayerId", "", "getGroupInfoByUser", "getGroupInfoByGroupCode", "updateGroupUser", "ready", "", "requestGroupMatching", "deleteGroupMatching", "createMatchingPlayerInfoList", "Ljava/util/ArrayList;", "Lcom/hive/MatchMaking$MatchingResultPlayerInfo;", "Lkotlin/collections/ArrayList;", "array", "Lorg/json/JSONArray;", "createMatchingTeamInfoList", "Lcom/hive/MatchMaking$MatchingResultTeamInfo;", "createMatchMemberInfoList", "Lcom/hive/MatchMaking$MatchMemberInfo;", "getLibraryMissingError", "Lcom/hive/ResultAPI;", "MatchMakingDataListener", "MatchMakingGroupDataListener", "MatchMakingResultListener", "MatchingType", "IMatchMakingData", "MatchMakingData", "MatchMakingGroupData", "MatchingResultTeamInfo", "MatchingResultPlayerInfo", "MatchMemberInfo", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MatchMaking {
    public static final MatchMaking INSTANCE = new MatchMaking();

    /* JADX INFO: renamed from: matchMaking$delegate, reason: from kotlin metadata */
    private static final Lazy matchMaking = LazyKt.lazy(new Function0() { // from class: com.hive.MatchMaking$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MatchMaking.matchMaking_delegate$lambda$0();
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/MatchMaking$MatchMakingDataListener;", "", "onMatchMakingData", "", "result", "Lcom/hive/ResultAPI;", "data", "Lcom/hive/MatchMaking$MatchMakingData;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface MatchMakingDataListener {
        void onMatchMakingData(ResultAPI result, MatchMakingData data);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/MatchMaking$MatchMakingGroupDataListener;", "", "onMatchMakingGroupData", "", "result", "Lcom/hive/ResultAPI;", "data", "Lcom/hive/MatchMaking$MatchMakingGroupData;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface MatchMakingGroupDataListener {
        void onMatchMakingGroupData(ResultAPI result, MatchMakingGroupData data);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/MatchMaking$MatchMakingResultListener;", "", "onMatchMakingResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface MatchMakingResultListener {
        void onMatchMakingResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0013\b\u0016\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J1\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/hive/MatchMaking$MatchMemberInfo;", "", "playerId", "", "ready", "", "point", "", "extraData", "", "<init>", "(JZILjava/lang/String;)V", "jsonData", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getPlayerId", "()J", "setPlayerId", "(J)V", "getReady", "()Z", "setReady", "(Z)V", "getPoint", "()I", "setPoint", "(I)V", "getExtraData", "()Ljava/lang/String;", "setExtraData", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class MatchMemberInfo {
        private String extraData;
        private long playerId;
        private int point;
        private boolean ready;

        public MatchMemberInfo() {
            this(0L, false, 0, null, 15, null);
        }

        public static /* synthetic */ MatchMemberInfo copy$default(MatchMemberInfo matchMemberInfo, long j, boolean z, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = matchMemberInfo.playerId;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                z = matchMemberInfo.ready;
            }
            boolean z2 = z;
            if ((i2 & 4) != 0) {
                i = matchMemberInfo.point;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                str = matchMemberInfo.extraData;
            }
            return matchMemberInfo.copy(j2, z2, i3, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPlayerId() {
            return this.playerId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getReady() {
            return this.ready;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPoint() {
            return this.point;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getExtraData() {
            return this.extraData;
        }

        public final MatchMemberInfo copy(long playerId, boolean ready, int point, String extraData) {
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            return new MatchMemberInfo(playerId, ready, point, extraData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MatchMemberInfo)) {
                return false;
            }
            MatchMemberInfo matchMemberInfo = (MatchMemberInfo) other;
            return this.playerId == matchMemberInfo.playerId && this.ready == matchMemberInfo.ready && this.point == matchMemberInfo.point && Intrinsics.areEqual(this.extraData, matchMemberInfo.extraData);
        }

        public final String getExtraData() {
            return this.extraData;
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public final int getPoint() {
            return this.point;
        }

        public final boolean getReady() {
            return this.ready;
        }

        public int hashCode() {
            return (((((UByte$$ExternalSyntheticBackport0.m(this.playerId) * 31) + UByte$$ExternalSyntheticBackport0.m(this.ready)) * 31) + this.point) * 31) + this.extraData.hashCode();
        }

        public final void setExtraData(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.extraData = str;
        }

        public final void setPlayerId(long j) {
            this.playerId = j;
        }

        public final void setPoint(int i) {
            this.point = i;
        }

        public final void setReady(boolean z) {
            this.ready = z;
        }

        public String toString() {
            return "MatchMemberInfo(playerId=" + this.playerId + ", ready=" + this.ready + ", point=" + this.point + ", extraData=" + this.extraData + ')';
        }

        public MatchMemberInfo(long j, boolean z, int i, String extraData) {
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            this.playerId = j;
            this.ready = z;
            this.point = i;
            this.extraData = extraData;
        }

        public /* synthetic */ MatchMemberInfo(long j, boolean z, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str);
        }

        public MatchMemberInfo(JSONObject jSONObject) {
            this(0L, false, 0, null, 15, null);
            if (jSONObject != null) {
                this.playerId = jSONObject.optLong("playerId");
                this.ready = jSONObject.optBoolean("ready");
                this.point = jSONObject.optInt("point", 0);
                String strOptString = jSONObject.optString("extraData");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.extraData = strOptString;
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0013\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/hive/MatchMaking$MatchingResultPlayerInfo;", "", "playerId", "", "point", "", "extraData", "", "<init>", "(JILjava/lang/String;)V", "jsonData", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getPlayerId", "()J", "setPlayerId", "(J)V", "getPoint", "()I", "setPoint", "(I)V", "getExtraData", "()Ljava/lang/String;", "setExtraData", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class MatchingResultPlayerInfo {
        private String extraData;
        private long playerId;
        private int point;

        public MatchingResultPlayerInfo() {
            this(0L, 0, null, 7, null);
        }

        public static /* synthetic */ MatchingResultPlayerInfo copy$default(MatchingResultPlayerInfo matchingResultPlayerInfo, long j, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = matchingResultPlayerInfo.playerId;
            }
            if ((i2 & 2) != 0) {
                i = matchingResultPlayerInfo.point;
            }
            if ((i2 & 4) != 0) {
                str = matchingResultPlayerInfo.extraData;
            }
            return matchingResultPlayerInfo.copy(j, i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPlayerId() {
            return this.playerId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getPoint() {
            return this.point;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getExtraData() {
            return this.extraData;
        }

        public final MatchingResultPlayerInfo copy(long playerId, int point, String extraData) {
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            return new MatchingResultPlayerInfo(playerId, point, extraData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MatchingResultPlayerInfo)) {
                return false;
            }
            MatchingResultPlayerInfo matchingResultPlayerInfo = (MatchingResultPlayerInfo) other;
            return this.playerId == matchingResultPlayerInfo.playerId && this.point == matchingResultPlayerInfo.point && Intrinsics.areEqual(this.extraData, matchingResultPlayerInfo.extraData);
        }

        public final String getExtraData() {
            return this.extraData;
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public final int getPoint() {
            return this.point;
        }

        public int hashCode() {
            return (((UByte$$ExternalSyntheticBackport0.m(this.playerId) * 31) + this.point) * 31) + this.extraData.hashCode();
        }

        public final void setExtraData(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.extraData = str;
        }

        public final void setPlayerId(long j) {
            this.playerId = j;
        }

        public final void setPoint(int i) {
            this.point = i;
        }

        public String toString() {
            return "MatchingResultPlayerInfo(playerId=" + this.playerId + ", point=" + this.point + ", extraData=" + this.extraData + ')';
        }

        public MatchingResultPlayerInfo(long j, int i, String extraData) {
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            this.playerId = j;
            this.point = i;
            this.extraData = extraData;
        }

        public /* synthetic */ MatchingResultPlayerInfo(long j, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str);
        }

        public MatchingResultPlayerInfo(JSONObject jSONObject) {
            this(0L, 0, null, 7, null);
            if (jSONObject != null) {
                this.playerId = jSONObject.optLong("playerId");
                this.point = jSONObject.optInt("point", 0);
                String strOptString = jSONObject.optString("extraData");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.extraData = strOptString;
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\b\u0010\tB\u0013\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/hive/MatchMaking$MatchingResultTeamInfo;", "", "teamIndex", "", "playerInfos", "Ljava/util/ArrayList;", "Lcom/hive/MatchMaking$MatchingResultPlayerInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(ILjava/util/ArrayList;)V", "jsonData", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getTeamIndex", "()I", "setTeamIndex", "(I)V", "getPlayerInfos", "()Ljava/util/ArrayList;", "setPlayerInfos", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class MatchingResultTeamInfo {
        private ArrayList<MatchingResultPlayerInfo> playerInfos;
        private int teamIndex;

        public MatchingResultTeamInfo() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MatchingResultTeamInfo copy$default(MatchingResultTeamInfo matchingResultTeamInfo, int i, ArrayList arrayList, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = matchingResultTeamInfo.teamIndex;
            }
            if ((i2 & 2) != 0) {
                arrayList = matchingResultTeamInfo.playerInfos;
            }
            return matchingResultTeamInfo.copy(i, arrayList);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTeamIndex() {
            return this.teamIndex;
        }

        public final ArrayList<MatchingResultPlayerInfo> component2() {
            return this.playerInfos;
        }

        public final MatchingResultTeamInfo copy(int teamIndex, ArrayList<MatchingResultPlayerInfo> playerInfos) {
            Intrinsics.checkNotNullParameter(playerInfos, "playerInfos");
            return new MatchingResultTeamInfo(teamIndex, playerInfos);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MatchingResultTeamInfo)) {
                return false;
            }
            MatchingResultTeamInfo matchingResultTeamInfo = (MatchingResultTeamInfo) other;
            return this.teamIndex == matchingResultTeamInfo.teamIndex && Intrinsics.areEqual(this.playerInfos, matchingResultTeamInfo.playerInfos);
        }

        public final ArrayList<MatchingResultPlayerInfo> getPlayerInfos() {
            return this.playerInfos;
        }

        public final int getTeamIndex() {
            return this.teamIndex;
        }

        public int hashCode() {
            return (this.teamIndex * 31) + this.playerInfos.hashCode();
        }

        public final void setPlayerInfos(ArrayList<MatchingResultPlayerInfo> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.playerInfos = arrayList;
        }

        public final void setTeamIndex(int i) {
            this.teamIndex = i;
        }

        public String toString() {
            return "MatchingResultTeamInfo(teamIndex=" + this.teamIndex + ", playerInfos=" + this.playerInfos + ')';
        }

        public MatchingResultTeamInfo(int i, ArrayList<MatchingResultPlayerInfo> playerInfos) {
            Intrinsics.checkNotNullParameter(playerInfos, "playerInfos");
            this.teamIndex = i;
            this.playerInfos = playerInfos;
        }

        public /* synthetic */ MatchingResultTeamInfo(int i, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? new ArrayList() : arrayList);
        }

        public MatchingResultTeamInfo(JSONObject jSONObject) {
            this(0, null, 3, 0 == true ? 1 : 0);
            if (jSONObject != null) {
                this.teamIndex = jSONObject.optInt("teamIndex", -1);
                this.playerInfos = MatchMaking.INSTANCE.createMatchingPlayerInfoList(jSONObject.optJSONArray("playerInfos"));
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/MatchMaking$MatchingType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PLAYER", "TEAM", com.hive.core.Configuration.HIVE_COUNTRY_DEFAULT, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MatchingType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MatchingType[] $VALUES;
        public static final MatchingType PLAYER = new MatchingType("PLAYER", 0, "player");
        public static final MatchingType TEAM = new MatchingType("TEAM", 1, "team");
        public static final MatchingType UNKNOWN = new MatchingType(com.hive.core.Configuration.HIVE_COUNTRY_DEFAULT, 2, "unknown");
        private final String value;

        private static final /* synthetic */ MatchingType[] $values() {
            return new MatchingType[]{PLAYER, TEAM, UNKNOWN};
        }

        static {
            MatchingType[] matchingTypeArr$values = $values();
            $VALUES = matchingTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(matchingTypeArr$values);
        }

        private MatchingType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<MatchingType> getEntries() {
            return $ENTRIES;
        }

        public static MatchingType valueOf(String str) {
            return (MatchingType) Enum.valueOf(MatchingType.class, str);
        }

        public static MatchingType[] values() {
            return (MatchingType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private MatchMaking() {
    }

    @JvmStatic
    public static final void createGroup(int matchId, int point, String extraData, MatchMakingGroupDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.createGroup(matchId, point, extraData, listener);
        } else {
            listener.onMatchMakingGroupData(matchMaking2.getLibraryMissingError(), new MatchMakingGroupData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<MatchMemberInfo> createMatchMemberInfoList(JSONArray array) {
        if (array == null) {
            return new ArrayList<>();
        }
        ArrayList<MatchMemberInfo> arrayList = new ArrayList<>();
        int length = array.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(new MatchMemberInfo(array.optJSONObject(i)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<MatchingResultPlayerInfo> createMatchingPlayerInfoList(JSONArray array) {
        if (array == null) {
            return new ArrayList<>();
        }
        ArrayList<MatchingResultPlayerInfo> arrayList = new ArrayList<>();
        int length = array.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(new MatchingResultPlayerInfo(array.optJSONObject(i)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<MatchingResultTeamInfo> createMatchingTeamInfoList(JSONArray array) {
        if (array == null) {
            return new ArrayList<>();
        }
        ArrayList<MatchingResultTeamInfo> arrayList = new ArrayList<>();
        int length = array.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(new MatchingResultTeamInfo(array.optJSONObject(i)));
        }
        return arrayList;
    }

    @JvmStatic
    public static final void deleteGroupMatching(int matchId, MatchMakingGroupDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.deleteGroupMatching(matchId, listener);
        } else {
            listener.onMatchMakingGroupData(matchMaking2.getLibraryMissingError(), new MatchMakingGroupData());
        }
    }

    @JvmStatic
    public static final void deleteRequesting(int matchId, MatchMakingResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.deleteRequesting(matchId, listener);
        } else {
            listener.onMatchMakingResult(matchMaking2.getLibraryMissingError());
        }
    }

    @JvmStatic
    public static final void getGroupInfoByGroupCode(String groupCode, MatchMakingGroupDataListener listener) {
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.getGroupInfoByGroupCode(groupCode, listener);
        } else {
            listener.onMatchMakingGroupData(matchMaking2.getLibraryMissingError(), new MatchMakingGroupData());
        }
    }

    @JvmStatic
    public static final void getGroupInfoByUser(int matchId, MatchMakingGroupDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.getGroupInfoByUser(matchId, listener);
        } else {
            listener.onMatchMakingGroupData(matchMaking2.getLibraryMissingError(), new MatchMakingGroupData());
        }
    }

    private final ResultAPI getLibraryMissingError() {
        return new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "MatchMaking library missing.");
    }

    private final HiveMatchMaking getMatchMaking() {
        return (HiveMatchMaking) matchMaking.getValue();
    }

    @JvmStatic
    public static final void getRequestingStatus(int matchId, MatchMakingDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.getRequestingStatus(matchId, listener);
        } else {
            listener.onMatchMakingData(matchMaking2.getLibraryMissingError(), new MatchMakingData());
        }
    }

    @JvmStatic
    public static final void joinGroup(int matchId, String groupCode, int point, String extraData, MatchMakingGroupDataListener listener) {
        Intrinsics.checkNotNullParameter(groupCode, "groupCode");
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.joinGroup(matchId, groupCode, point, extraData, listener);
        } else {
            listener.onMatchMakingGroupData(matchMaking2.getLibraryMissingError(), new MatchMakingGroupData());
        }
    }

    @JvmStatic
    public static final void kickGroupUser(int matchId, long targetPlayerId, MatchMakingGroupDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.kickGroupUser(matchId, targetPlayerId, listener);
        } else {
            listener.onMatchMakingGroupData(matchMaking2.getLibraryMissingError(), new MatchMakingGroupData());
        }
    }

    @JvmStatic
    public static final void leaveGroup(int matchId, MatchMakingResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.leaveGroup(matchId, listener);
        } else {
            listener.onMatchMakingResult(matchMaking2.getLibraryMissingError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiveMatchMaking matchMaking_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveMatchMaking.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveMatchMaking)) {
            hiveModule = null;
        }
        return (HiveMatchMaking) (hiveModule instanceof HiveMatchMaking ? hiveModule : null);
    }

    @JvmStatic
    public static final void requestGroupMatching(int matchId, MatchMakingGroupDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.requestGroupMatching(matchId, listener);
        } else {
            listener.onMatchMakingGroupData(matchMaking2.getLibraryMissingError(), new MatchMakingGroupData());
        }
    }

    @JvmStatic
    public static final void requestMatchMaking(int matchId, int point, String extraData, MatchMakingDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.requestMatchMaking(matchId, point, extraData, listener);
        } else {
            listener.onMatchMakingData(matchMaking2.getLibraryMissingError(), new MatchMakingData());
        }
    }

    @JvmStatic
    public static final void updateGroupUser(int matchId, boolean ready, int point, String extraData, MatchMakingGroupDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MatchMaking matchMaking2 = INSTANCE;
        HiveMatchMaking matchMaking3 = matchMaking2.getMatchMaking();
        if (matchMaking3 != null) {
            matchMaking3.updateGroupUser(matchId, ready, point, extraData, listener);
        } else {
            listener.onMatchMakingGroupData(matchMaking2.getLibraryMissingError(), new MatchMakingGroupData());
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010%\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\"\u0018\u0001`\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 ¨\u0006&"}, d2 = {"Lcom/hive/MatchMaking$MatchMakingData;", "Lcom/hive/MatchMaking$IMatchMakingData;", "<init>", "()V", "jsonData", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "requestPlayerId", "", "getRequestPlayerId", "()J", "setRequestPlayerId", "(J)V", "requestPoint", "", "getRequestPoint", "()I", "setRequestPoint", "(I)V", "requestExtraData", "", "getRequestExtraData", "()Ljava/lang/String;", "setRequestExtraData", "(Ljava/lang/String;)V", "matchingPlayerInfoList", "Ljava/util/ArrayList;", "Lcom/hive/MatchMaking$MatchingResultPlayerInfo;", "Lkotlin/collections/ArrayList;", "getMatchingPlayerInfoList", "()Ljava/util/ArrayList;", "setMatchingPlayerInfoList", "(Ljava/util/ArrayList;)V", "matchingTeamInfoList", "Lcom/hive/MatchMaking$MatchingResultTeamInfo;", "getMatchingTeamInfoList", "setMatchingTeamInfoList", "toJson", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MatchMakingData extends IMatchMakingData {
        private ArrayList<MatchingResultPlayerInfo> matchingPlayerInfoList;
        private ArrayList<MatchingResultTeamInfo> matchingTeamInfoList;
        private String requestExtraData;
        private long requestPlayerId;
        private int requestPoint;

        public MatchMakingData() {
            this.requestExtraData = "";
        }

        public final ArrayList<MatchingResultPlayerInfo> getMatchingPlayerInfoList() {
            return this.matchingPlayerInfoList;
        }

        public final ArrayList<MatchingResultTeamInfo> getMatchingTeamInfoList() {
            return this.matchingTeamInfoList;
        }

        public final String getRequestExtraData() {
            return this.requestExtraData;
        }

        public final long getRequestPlayerId() {
            return this.requestPlayerId;
        }

        public final int getRequestPoint() {
            return this.requestPoint;
        }

        public final void setMatchingPlayerInfoList(ArrayList<MatchingResultPlayerInfo> arrayList) {
            this.matchingPlayerInfoList = arrayList;
        }

        public final void setMatchingTeamInfoList(ArrayList<MatchingResultTeamInfo> arrayList) {
            this.matchingTeamInfoList = arrayList;
        }

        public final void setRequestExtraData(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.requestExtraData = str;
        }

        public final void setRequestPlayerId(long j) {
            this.requestPlayerId = j;
        }

        public final void setRequestPoint(int i) {
            this.requestPoint = i;
        }

        @Override // com.hive.MatchMaking.IMatchMakingData
        public JSONObject toJson() {
            Object objM7415constructorimpl;
            JSONObject jSONObjectPut;
            JSONObject json = super.toJson();
            try {
                Result.Companion companion = Result.INSTANCE;
                json.put("requestPlayerId", this.requestPlayerId);
                json.put("requestPoint", this.requestPoint);
                json.put("requestExtraData", this.requestExtraData);
                ArrayList<MatchingResultPlayerInfo> arrayList = this.matchingPlayerInfoList;
                if (arrayList != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<MatchingResultPlayerInfo> it = arrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        MatchingResultPlayerInfo next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        MatchingResultPlayerInfo matchingResultPlayerInfo = next;
                        long playerId = matchingResultPlayerInfo.getPlayerId();
                        int point = matchingResultPlayerInfo.getPoint();
                        String extraData = matchingResultPlayerInfo.getExtraData();
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("playerId", playerId);
                            jSONObject.put("point", point);
                            jSONObject.put("extraData", extraData);
                            jSONArray.put(jSONObject);
                            Result.m7415constructorimpl(jSONObject);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m7415constructorimpl(ResultKt.createFailure(th));
                        }
                    }
                    json.put("matchingPlayerInfoList", jSONArray);
                }
                ArrayList<MatchingResultTeamInfo> arrayList2 = this.matchingTeamInfoList;
                if (arrayList2 != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<MatchingResultTeamInfo> it2 = arrayList2.iterator();
                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        MatchingResultTeamInfo next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                        MatchingResultTeamInfo matchingResultTeamInfo = next2;
                        int teamIndex = matchingResultTeamInfo.getTeamIndex();
                        ArrayList<MatchingResultPlayerInfo> arrayListComponent2 = matchingResultTeamInfo.component2();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("teamIndex", teamIndex);
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<MatchingResultPlayerInfo> it3 = arrayListComponent2.iterator();
                        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                        while (it3.hasNext()) {
                            MatchingResultPlayerInfo next3 = it3.next();
                            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                            MatchingResultPlayerInfo matchingResultPlayerInfo2 = next3;
                            long playerId2 = matchingResultPlayerInfo2.getPlayerId();
                            int point2 = matchingResultPlayerInfo2.getPoint();
                            String extraData2 = matchingResultPlayerInfo2.getExtraData();
                            try {
                                Result.Companion companion4 = Result.INSTANCE;
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("playerId", playerId2);
                                jSONObject3.put("point", point2);
                                jSONObject3.put("extraData", extraData2);
                                jSONArray3.put(jSONObject3);
                                Result.m7415constructorimpl(jSONObject3);
                            } catch (Throwable th2) {
                                Result.Companion companion5 = Result.INSTANCE;
                                Result.m7415constructorimpl(ResultKt.createFailure(th2));
                            }
                        }
                        jSONObject2.put("playerInfos", jSONArray3);
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObjectPut = json.put("matchingTeamInfoList", jSONArray2);
                } else {
                    jSONObjectPut = null;
                }
                objM7415constructorimpl = Result.m7415constructorimpl(jSONObjectPut);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th3));
            }
            Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            return json;
        }

        public MatchMakingData(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject;
            super(jSONObject);
            this.requestExtraData = "";
            if (jSONObject != null) {
                this.requestPlayerId = jSONObject.optLong("playerId");
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("requestingInfo");
                if (jSONObjectOptJSONObject2 != null) {
                    this.requestPoint = jSONObjectOptJSONObject2.optInt("point", 0);
                    String strOptString = jSONObjectOptJSONObject2.optString("extraData");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.requestExtraData = strOptString;
                }
                if (!Intrinsics.areEqual(getMatchingStatus(), "matched") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("matchingInfo")) == null) {
                    return;
                }
                if (jSONObjectOptJSONObject.has("privateInfos")) {
                    this.matchingPlayerInfoList = MatchMaking.INSTANCE.createMatchingPlayerInfoList(jSONObjectOptJSONObject.optJSONArray("privateInfos"));
                    setMatchingType(MatchingType.PLAYER.getValue());
                } else if (jSONObjectOptJSONObject.has("teamInfos")) {
                    this.matchingTeamInfoList = MatchMaking.INSTANCE.createMatchingTeamInfoList(jSONObjectOptJSONObject.optJSONArray("teamInfos"));
                    setMatchingType(MatchingType.TEAM.getValue());
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001a¨\u0006 "}, d2 = {"Lcom/hive/MatchMaking$MatchMakingGroupData;", "Lcom/hive/MatchMaking$IMatchMakingData;", "<init>", "()V", "jsonData", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "groupCode", "", "getGroupCode", "()Ljava/lang/String;", "setGroupCode", "(Ljava/lang/String;)V", "ownerPlayerId", "", "getOwnerPlayerId", "()J", "setOwnerPlayerId", "(J)V", "memberInfoList", "Ljava/util/ArrayList;", "Lcom/hive/MatchMaking$MatchMemberInfo;", "Lkotlin/collections/ArrayList;", "getMemberInfoList", "()Ljava/util/ArrayList;", "setMemberInfoList", "(Ljava/util/ArrayList;)V", "matchingTeamInfoList", "Lcom/hive/MatchMaking$MatchingResultTeamInfo;", "getMatchingTeamInfoList", "setMatchingTeamInfoList", "toJson", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MatchMakingGroupData extends IMatchMakingData {
        private String groupCode;
        private ArrayList<MatchingResultTeamInfo> matchingTeamInfoList;
        private ArrayList<MatchMemberInfo> memberInfoList;
        private long ownerPlayerId;

        public MatchMakingGroupData() {
            this.groupCode = "";
        }

        public final String getGroupCode() {
            return this.groupCode;
        }

        public final ArrayList<MatchingResultTeamInfo> getMatchingTeamInfoList() {
            return this.matchingTeamInfoList;
        }

        public final ArrayList<MatchMemberInfo> getMemberInfoList() {
            return this.memberInfoList;
        }

        public final long getOwnerPlayerId() {
            return this.ownerPlayerId;
        }

        public final void setGroupCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.groupCode = str;
        }

        public final void setMatchingTeamInfoList(ArrayList<MatchingResultTeamInfo> arrayList) {
            this.matchingTeamInfoList = arrayList;
        }

        public final void setMemberInfoList(ArrayList<MatchMemberInfo> arrayList) {
            this.memberInfoList = arrayList;
        }

        public final void setOwnerPlayerId(long j) {
            this.ownerPlayerId = j;
        }

        @Override // com.hive.MatchMaking.IMatchMakingData
        public JSONObject toJson() {
            Object objM7415constructorimpl;
            JSONObject jSONObjectPut;
            JSONObject json = super.toJson();
            try {
                Result.Companion companion = Result.INSTANCE;
                json.put("groupCode", this.groupCode);
                json.put("ownerPlayerId", this.ownerPlayerId);
                ArrayList<MatchMemberInfo> arrayList = this.memberInfoList;
                if (arrayList != null) {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<MatchMemberInfo> it = arrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        MatchMemberInfo next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        MatchMemberInfo matchMemberInfo = next;
                        long playerId = matchMemberInfo.getPlayerId();
                        boolean ready = matchMemberInfo.getReady();
                        int point = matchMemberInfo.getPoint();
                        String extraData = matchMemberInfo.getExtraData();
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("playerId", playerId);
                            jSONObject.put("ready", ready);
                            jSONObject.put("point", point);
                            jSONObject.put("extraData", extraData);
                            jSONArray.put(jSONObject);
                            Result.m7415constructorimpl(jSONObject);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m7415constructorimpl(ResultKt.createFailure(th));
                        }
                    }
                    json.put("memberInfoList", jSONArray);
                }
                ArrayList<MatchingResultTeamInfo> arrayList2 = this.matchingTeamInfoList;
                if (arrayList2 != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<MatchingResultTeamInfo> it2 = arrayList2.iterator();
                    Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        MatchingResultTeamInfo next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                        MatchingResultTeamInfo matchingResultTeamInfo = next2;
                        int teamIndex = matchingResultTeamInfo.getTeamIndex();
                        ArrayList<MatchingResultPlayerInfo> arrayListComponent2 = matchingResultTeamInfo.component2();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("teamIndex", teamIndex);
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<MatchingResultPlayerInfo> it3 = arrayListComponent2.iterator();
                        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                        while (it3.hasNext()) {
                            MatchingResultPlayerInfo next3 = it3.next();
                            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
                            MatchingResultPlayerInfo matchingResultPlayerInfo = next3;
                            long playerId2 = matchingResultPlayerInfo.getPlayerId();
                            int point2 = matchingResultPlayerInfo.getPoint();
                            String extraData2 = matchingResultPlayerInfo.getExtraData();
                            try {
                                Result.Companion companion4 = Result.INSTANCE;
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("playerId", playerId2);
                                jSONObject3.put("point", point2);
                                jSONObject3.put("extraData", extraData2);
                                jSONArray3.put(jSONObject3);
                                Result.m7415constructorimpl(jSONObject3);
                            } catch (Throwable th2) {
                                Result.Companion companion5 = Result.INSTANCE;
                                Result.m7415constructorimpl(ResultKt.createFailure(th2));
                            }
                        }
                        jSONObject2.put("playerInfos", jSONArray3);
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObjectPut = json.put("matchingTeamInfoList", jSONArray2);
                } else {
                    jSONObjectPut = null;
                }
                objM7415constructorimpl = Result.m7415constructorimpl(jSONObjectPut);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th3));
            }
            Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            return json;
        }

        public MatchMakingGroupData(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject;
            super(jSONObject);
            this.groupCode = "";
            if (jSONObject != null) {
                String strOptString = jSONObject.optString("groupCode");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.groupCode = strOptString;
                this.ownerPlayerId = jSONObject.optLong("ownerPlayerId");
                MatchMaking matchMaking = MatchMaking.INSTANCE;
                this.memberInfoList = matchMaking.createMatchMemberInfoList(jSONObject.optJSONArray("memberInfos"));
                if (Intrinsics.areEqual(getMatchingStatus(), "matched") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("matchingInfo")) != null && jSONObjectOptJSONObject.has("teamInfos")) {
                    this.matchingTeamInfoList = matchMaking.createMatchingTeamInfoList(jSONObjectOptJSONObject.optJSONArray("teamInfos"));
                    setMatchingType(MatchingType.TEAM.getValue());
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\"\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u0006#"}, d2 = {"Lcom/hive/MatchMaking$IMatchMakingData;", "Lcom/hive/base/DataModel;", "<init>", "()V", "jsonData", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "requestGameIndex", "", "getRequestGameIndex", "()I", "setRequestGameIndex", "(I)V", "requestMatchId", "getRequestMatchId", "setRequestMatchId", "requestStatus", "", "getRequestStatus", "()Ljava/lang/String;", "setRequestStatus", "(Ljava/lang/String;)V", "requestTimeUtc", "getRequestTimeUtc", "setRequestTimeUtc", "matchingStatus", "getMatchingStatus", "setMatchingStatus", "matchingId", "getMatchingId", "setMatchingId", "matchingType", "getMatchingType", "setMatchingType", "toJson", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class IMatchMakingData extends DataModel {
        private String matchingId;
        private String matchingStatus;
        private String matchingType;
        private int requestGameIndex;
        private int requestMatchId;
        private String requestStatus;
        private String requestTimeUtc;

        public IMatchMakingData() {
            this.requestStatus = "";
            this.requestTimeUtc = "";
            this.matchingStatus = "";
            this.matchingId = "";
            this.matchingType = MatchingType.UNKNOWN.getValue();
        }

        public final String getMatchingId() {
            return this.matchingId;
        }

        public final String getMatchingStatus() {
            return this.matchingStatus;
        }

        public final String getMatchingType() {
            return this.matchingType;
        }

        public final int getRequestGameIndex() {
            return this.requestGameIndex;
        }

        public final int getRequestMatchId() {
            return this.requestMatchId;
        }

        public final String getRequestStatus() {
            return this.requestStatus;
        }

        public final String getRequestTimeUtc() {
            return this.requestTimeUtc;
        }

        public final void setMatchingId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.matchingId = str;
        }

        public final void setMatchingStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.matchingStatus = str;
        }

        public final void setMatchingType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.matchingType = str;
        }

        public final void setRequestGameIndex(int i) {
            this.requestGameIndex = i;
        }

        public final void setRequestMatchId(int i) {
            this.requestMatchId = i;
        }

        public final void setRequestStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.requestStatus = str;
        }

        public final void setRequestTimeUtc(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.requestTimeUtc = str;
        }

        public JSONObject toJson() {
            Object objM7415constructorimpl;
            JSONObject jSONObject = new JSONObject();
            try {
                Result.Companion companion = Result.INSTANCE;
                jSONObject.put("requestGameIndex", this.requestGameIndex);
                jSONObject.put("requestMatchId", this.requestMatchId);
                jSONObject.put("requestStatus", this.requestStatus);
                jSONObject.put("requestTimeUtc", this.requestTimeUtc);
                jSONObject.put("matchingStatus", this.matchingStatus);
                jSONObject.put("matchingId", this.matchingId);
                objM7415constructorimpl = Result.m7415constructorimpl(jSONObject.put("matchingType", this.matchingType));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            return jSONObject;
        }

        public IMatchMakingData(JSONObject jSONObject) {
            this.requestStatus = "";
            this.requestTimeUtc = "";
            this.matchingStatus = "";
            this.matchingId = "";
            this.matchingType = MatchingType.UNKNOWN.getValue();
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("matchInfo");
                if (jSONObjectOptJSONObject != null) {
                    this.requestGameIndex = jSONObjectOptJSONObject.optInt("gameIndex", 0);
                    this.requestMatchId = jSONObjectOptJSONObject.optInt("matchId", 0);
                }
                String strOptString = jSONObject.optString("requestingStatus");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                this.requestStatus = strOptString;
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("requestingInfo");
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString2 = jSONObjectOptJSONObject2.optString("requestTimeUtc");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.requestTimeUtc = strOptString2;
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("matchingInfo");
                if (jSONObjectOptJSONObject3 != null) {
                    String strOptString3 = jSONObjectOptJSONObject3.optString("status");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    this.matchingStatus = strOptString3;
                    String strOptString4 = jSONObjectOptJSONObject3.optString("matchingId");
                    Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                    this.matchingId = strOptString4;
                }
            }
        }
    }
}
