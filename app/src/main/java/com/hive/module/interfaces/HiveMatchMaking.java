package com.hive.module.interfaces;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.MatchMaking;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eH&J*\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0010H&J2\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0010H&J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eH&J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0010H&J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0010H&J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0010H&J2\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0010H&J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0010H&J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0010H&¨\u0006\u001e"}, d2 = {"Lcom/hive/module/interfaces/HiveMatchMaking;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "requestMatchMaking", "", "matchId", "", "point", "extraData", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/MatchMaking$MatchMakingDataListener;", "getRequestingStatus", "deleteRequesting", "Lcom/hive/MatchMaking$MatchMakingResultListener;", "createGroup", "Lcom/hive/MatchMaking$MatchMakingGroupDataListener;", "joinGroup", "groupCode", "leaveGroup", "kickGroupUser", "targetPlayerId", "", "getGroupInfoByUser", "getGroupInfoByGroupCode", "updateGroupUser", "ready", "", "requestGroupMatching", "deleteGroupMatching", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveMatchMaking extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(HiveMatchMaking hiveMatchMaking) {
            return HiveModuleName.INSTANCE.getMatchMaking();
        }
    }

    void createGroup(int matchId, int point, String extraData, MatchMaking.MatchMakingGroupDataListener listener);

    void deleteGroupMatching(int matchId, MatchMaking.MatchMakingGroupDataListener listener);

    void deleteRequesting(int matchId, MatchMaking.MatchMakingResultListener listener);

    void getGroupInfoByGroupCode(String groupCode, MatchMaking.MatchMakingGroupDataListener listener);

    void getGroupInfoByUser(int matchId, MatchMaking.MatchMakingGroupDataListener listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void getRequestingStatus(int matchId, MatchMaking.MatchMakingDataListener listener);

    void joinGroup(int matchId, String groupCode, int point, String extraData, MatchMaking.MatchMakingGroupDataListener listener);

    void kickGroupUser(int matchId, long targetPlayerId, MatchMaking.MatchMakingGroupDataListener listener);

    void leaveGroup(int matchId, MatchMaking.MatchMakingResultListener listener);

    void requestGroupMatching(int matchId, MatchMaking.MatchMakingGroupDataListener listener);

    void requestMatchMaking(int matchId, int point, String extraData, MatchMaking.MatchMakingDataListener listener);

    void updateGroupUser(int matchId, boolean ready, int point, String extraData, MatchMaking.MatchMakingGroupDataListener listener);
}
