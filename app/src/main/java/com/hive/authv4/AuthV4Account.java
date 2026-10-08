package com.hive.authv4;

import com.facebook.appevents.AppEventsConstants;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderHive;
import com.hive.base.Property;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.core.HiveKeys;
import com.hive.core.OauthToken;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.authv4.OauthToken;
import com.hive.standalone.HiveLifecycle;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J0\u0010#\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u00172\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010(\u001a\u00020'J\u0010\u0010)\u001a\u0004\u0018\u00010\u001d2\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u0010J\b\u0010,\u001a\u00020'H\u0002J\u000e\u0010-\u001a\u00020'2\u0006\u0010*\u001a\u00020\u0006J\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00060/j\b\u0012\u0004\u0012\u00020\u0006`0J\u0006\u00101\u001a\u00020'J\u0016\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nJ\u0006\u00105\u001a\u00020'J\u0006\u00106\u001a\u00020'J\b\u00107\u001a\u00020\u0010H\u0017J\b\u00108\u001a\u000209H\u0007J\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020'2\u0006\u0010*\u001a\u00020\nJ\u0006\u0010=\u001a\u00020\nJ\u0006\u0010>\u001a\u00020'J\u0006\u0010?\u001a\u00020\u0010J\u0006\u0010@\u001a\u00020'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014Rd\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u00172&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016j\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u0017@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006A"}, d2 = {"Lcom/hive/authv4/AuthV4Account;", "Lcom/hive/core/OauthToken;", "Ljava/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "readResolve", "", "PLAYER_INFO_SERIALIZE", "", "STORED_PLAYER_INFOS", "CLIENT_ACCESS_TOKEN", "CLIENT_REFRESH_TOKEN", "ENABLE_AUTO_LOGIN", "enableAutoLogin", "", "getEnableAutoLogin", "()Z", "setEnableAutoLogin", "(Z)V", "value", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "storedPlayerInfos", "getStoredPlayerInfos", "()Ljava/util/HashMap;", "setStoredPlayerInfos", "(Ljava/util/HashMap;)V", "Lcom/hive/AuthV4$PlayerInfo;", "playerInfo", "getPlayerInfo", "()Lcom/hive/AuthV4$PlayerInfo;", "setPlayerInfo", "(Lcom/hive/AuthV4$PlayerInfo;)V", "parseStringToMap", "input", "readPlayerInfo", "writePlayerInfo", "", "removePlayerInfo", "readPlayerInfoList", "playerId", "writePlayerInfoList", "updatePlayerInfoList", "removePlayerInfoList", "getAccountPlayerIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "loadToken", "writeToken", "accessToken", "refreshToken", "removeToken", "memoryReset", "refresh", "refreshWithResultApi", "Lcom/hive/ResultAPI;", "toHiveAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "writeOfflineSignInFinish", "readOfflineSignInFinish", "resetEnableAutoLogin", "savedAutoLoginEnabled", "writeAutoLoginEnabled", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Account extends OauthToken implements Serializable {
    private static final String CLIENT_ACCESS_TOKEN = "authv4.client_access_token";
    private static final String CLIENT_REFRESH_TOKEN = "authv4.client_refresh_token";
    private static final String ENABLE_AUTO_LOGIN = "authv4.enable_auto_login";
    public static final AuthV4Account INSTANCE;
    private static final String PLAYER_INFO_SERIALIZE = "authv4.player_info_json";
    private static final String STORED_PLAYER_INFOS = "authv4.stored_player_infos";
    private static boolean enableAutoLogin = false;
    private static AuthV4.PlayerInfo playerInfo = null;
    private static final long serialVersionUID = 34827623457863L;
    private static HashMap<String, String> storedPlayerInfos;

    static {
        AuthV4Account authV4Account = new AuthV4Account();
        INSTANCE = authV4Account;
        enableAutoLogin = true;
        storedPlayerInfos = new HashMap<>();
        String value = Property.INSTANCE.getINSTANCE().getValue(STORED_PLAYER_INFOS);
        if (value != null) {
            authV4Account.setStoredPlayerInfos(authV4Account.parseStringToMap(value));
        }
    }

    private AuthV4Account() {
    }

    private final HashMap<String, String> parseStringToMap(String input) {
        String strRemoveSuffix = StringsKt.removeSuffix(StringsKt.removePrefix(input, (CharSequence) "{"), (CharSequence) "}");
        if (StringsKt.isBlank(strRemoveSuffix)) {
            return new HashMap<>();
        }
        List listSplit$default = StringsKt.split$default((CharSequence) strRemoveSuffix, new String[]{", "}, false, 0, 6, (Object) null);
        ArrayList<List> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.split$default((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (List list : arrayList) {
            Pair pair = TuplesKt.to(list.get(0), list.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new HashMap<>(linkedHashMap);
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    private final void setPlayerInfo(AuthV4.PlayerInfo playerInfo2) {
        playerInfo = playerInfo2;
        HiveLifecycle.INSTANCE.setAccount(toHiveAccount());
    }

    private final void setStoredPlayerInfos(HashMap<String, String> map) {
        storedPlayerInfos = map;
    }

    private final void updatePlayerInfoList() {
        AuthV4.PlayerInfo playerInfo2 = playerInfo;
        if (playerInfo2 != null) {
            AuthV4Account authV4Account = INSTANCE;
            if (authV4Account.getAccountPlayerIdList().contains(Long.valueOf(playerInfo2.getPlayerId()))) {
                authV4Account.writePlayerInfoList();
            }
        }
    }

    public final ArrayList<Long> getAccountPlayerIdList() {
        HashMap<String, String> map = storedPlayerInfos;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(Long.parseLong(it.next().getKey())));
        }
        return new ArrayList<>(arrayList);
    }

    public final boolean getEnableAutoLogin() {
        return enableAutoLogin;
    }

    public final AuthV4.PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public final HashMap<String, String> getStoredPlayerInfos() {
        return storedPlayerInfos;
    }

    public final void loadToken() {
        Property instance = Property.INSTANCE.getINSTANCE();
        AuthV4Account authV4Account = INSTANCE;
        authV4Account.setAccessToken(instance.getValue(CLIENT_ACCESS_TOKEN));
        authV4Account.setRefreshToken(instance.getValue(CLIENT_REFRESH_TOKEN));
    }

    public final void memoryReset() {
        setPlayerInfo(null);
        setAccessToken(null);
        setRefreshToken(null);
    }

    public final String readOfflineSignInFinish() {
        return Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.OFFLINE_AUTHV4_SIGN_IN_FINISH, "");
    }

    public final AuthV4.PlayerInfo readPlayerInfo() {
        Property instance = Property.INSTANCE.getINSTANCE();
        AuthV4.PlayerInfo playerInfoDeserialize = AuthV4.PlayerInfo.INSTANCE.deserialize(instance.getValue(PLAYER_INFO_SERIALIZE));
        if (playerInfoDeserialize == null) {
            instance.removeValue(PLAYER_INFO_SERIALIZE);
            instance.writeProperties();
        }
        return playerInfoDeserialize == null ? playerInfo : playerInfoDeserialize;
    }

    public final AuthV4.PlayerInfo readPlayerInfoList(long playerId) {
        Property instance = Property.INSTANCE.getINSTANCE();
        AuthV4.PlayerInfo playerInfoDeserialize = AuthV4.PlayerInfo.INSTANCE.deserialize(storedPlayerInfos.get(String.valueOf(playerId)));
        if (playerInfoDeserialize == null) {
            storedPlayerInfos.remove(String.valueOf(playerId));
            Property.setValue$default(instance, STORED_PLAYER_INFOS, storedPlayerInfos.toString(), null, 4, null);
            instance.writeProperties();
        }
        return playerInfoDeserialize;
    }

    @Override // com.hive.core.OauthToken
    public boolean refresh() {
        return refreshWithResultApi().isSuccess();
    }

    public final ResultAPI refreshWithResultApi() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4Account] refresh()");
        String did = HiveLifecycle.INSTANCE.getDid();
        String primaryClientId = Configuration.INSTANCE.getPrimaryClientId();
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<com.hive.protocol.authv4.OauthToken>() { // from class: com.hive.authv4.AuthV4Account$refreshWithResultApi$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.authv4.OauthToken] */
            @Override // kotlin.jvm.functions.Function0
            public final com.hive.protocol.authv4.OauthToken invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = com.hive.protocol.authv4.OauthToken.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setAutoRefreshOauthToken(false);
        protocol.setParam(HiveKeys.KEY_appid, ConfigurationImpl.INSTANCE.getAppId());
        protocol.setParam(HiveKeys.KEY_grant_type, "refresh_token");
        protocol.setParam(HiveKeys.KEY_did, did);
        protocol.setParam(HiveKeys.KEY_client_id, primaryClientId);
        HiveKeys hiveKeys = HiveKeys.KEY_refresh_token;
        AuthV4Account authV4Account = INSTANCE;
        protocol.setParam(hiveKeys, authV4Account.getRefreshToken());
        OauthToken.OauthTokenResponse response = ((com.hive.protocol.authv4.OauthToken) protocol.request()).getResponse();
        ResultAPI resultAPI$hive_service_release = AuthV4Network.INSTANCE.toResultAPI$hive_service_release(response);
        if (!resultAPI$hive_service_release.isSuccess()) {
            loggerImpl.w("[AuthV4Account] refresh() failed: " + resultAPI$hive_service_release + '\n');
            return resultAPI$hive_service_release;
        }
        AuthV4.PlayerInfo playerInfo2 = playerInfo;
        if (playerInfo2 != null) {
            playerInfo2.setAccessToken(response.getAccessToken());
        }
        authV4Account.writeToken(response.getAccessToken(), response.getRefreshToken());
        loggerImpl.d("[AuthV4Account] refresh() success.");
        return resultAPI$hive_service_release;
    }

    public final void removePlayerInfo() {
        setPlayerInfo(null);
        Property instance = Property.INSTANCE.getINSTANCE();
        instance.removeValue(PLAYER_INFO_SERIALIZE);
        instance.writeProperties();
    }

    public final void removePlayerInfoList(long playerId) {
        Property instance = Property.INSTANCE.getINSTANCE();
        storedPlayerInfos.remove(String.valueOf(playerId));
        Property.setValue$default(instance, STORED_PLAYER_INFOS, storedPlayerInfos.toString(), null, 4, null);
        instance.writeProperties();
    }

    public final void removeToken() {
        LoggerImpl.INSTANCE.d("[AuthV4Account] Remove OAuthToken");
        setAccessToken(null);
        setRefreshToken(null);
        Property instance = Property.INSTANCE.getINSTANCE();
        instance.removeValue(CLIENT_ACCESS_TOKEN);
        instance.removeValue(CLIENT_REFRESH_TOKEN);
        instance.writeProperties();
    }

    public final void resetEnableAutoLogin() {
        enableAutoLogin = true;
        writeAutoLoginEnabled();
    }

    public final boolean savedAutoLoginEnabled() {
        return !Intrinsics.areEqual(Property.INSTANCE.getINSTANCE().getValue(ENABLE_AUTO_LOGIN), AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public final void setEnableAutoLogin(boolean z) {
        enableAutoLogin = z;
    }

    public final HiveLifecycle.HiveAccount toHiveAccount() {
        HiveLifecycle.HiveAccount hiveAccount = new HiveLifecycle.HiveAccount();
        hiveAccount.setVidType("v4");
        AuthV4.PlayerInfo playerInfo2 = playerInfo;
        if (playerInfo2 != null) {
            hiveAccount.setVid(playerInfo2.getPlayerId() == 0 ? null : String.valueOf(playerInfo2.getPlayerId()));
            hiveAccount.setVidSession(playerInfo2.getPlayerToken());
            hiveAccount.setOauthToken(INSTANCE);
            hiveAccount.setDid(HiveLifecycle.INSTANCE.getDid());
            AuthV4.ProviderInfo providerInfo = playerInfo2.getProviderInfoData().get(AuthV4.ProviderType.HIVE);
            if (providerInfo != null) {
                hiveAccount.setUid(providerInfo.getProviderUserId());
                hiveAccount.setUidSession(AuthV4ProviderHive.INSTANCE.getUserToken());
            }
            String uid = hiveAccount.getUid();
            if (uid != null && !StringsKt.isBlank(uid)) {
                return hiveAccount;
            }
            hiveAccount.setUid(null);
            hiveAccount.setUidSession(null);
        }
        return hiveAccount;
    }

    public final void writeAutoLoginEnabled() {
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), ENABLE_AUTO_LOGIN, enableAutoLogin ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO, null, 4, null);
        companion.getINSTANCE().writeProperties();
    }

    public final void writeOfflineSignInFinish(String playerId) {
        Intrinsics.checkNotNullParameter(playerId, "playerId");
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.OFFLINE_AUTHV4_SIGN_IN_FINISH, playerId, null, 4, null);
        companion.getINSTANCE().writeProperties();
    }

    public final void writePlayerInfo(AuthV4.PlayerInfo playerInfo2) {
        Intrinsics.checkNotNullParameter(playerInfo2, "playerInfo");
        setPlayerInfo(playerInfo2);
        if (enableAutoLogin) {
            Property instance = Property.INSTANCE.getINSTANCE();
            Property.setValue$default(instance, PLAYER_INFO_SERIALIZE, playerInfo2.serialize(), null, 4, null);
            instance.writeProperties();
        }
        Property.INSTANCE.getINSTANCE();
        INSTANCE.updatePlayerInfoList();
    }

    public final boolean writePlayerInfoList() {
        if (playerInfo == null) {
            return false;
        }
        Property instance = Property.INSTANCE.getINSTANCE();
        HashMap<String, String> map = storedPlayerInfos;
        AuthV4.PlayerInfo playerInfo2 = playerInfo;
        String strValueOf = String.valueOf(playerInfo2 != null ? Long.valueOf(playerInfo2.getPlayerId()) : null);
        AuthV4.PlayerInfo playerInfo3 = playerInfo;
        map.put(strValueOf, playerInfo3 != null ? playerInfo3.serialize() : null);
        Property.setValue$default(instance, STORED_PLAYER_INFOS, storedPlayerInfos.toString(), null, 4, null);
        return instance.writeProperties();
    }

    public final void writeToken(String accessToken, String refreshToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        LoggerImpl.INSTANCE.d("[AuthV4Account] Write OAuthToken");
        setAccessToken(accessToken);
        setRefreshToken(refreshToken);
        Property instance = Property.INSTANCE.getINSTANCE();
        Property.setValue$default(instance, CLIENT_ACCESS_TOKEN, accessToken, null, 4, null);
        Property.setValue$default(instance, CLIENT_REFRESH_TOKEN, refreshToken, null, 4, null);
        instance.writeProperties();
    }
}
