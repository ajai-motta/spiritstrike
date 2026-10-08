package com.hive;

import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.AccessToken;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.ResultAPI;
import com.hive.SocialV4;
import com.hive.base.DataModel;
import com.hive.logger.LoggerImpl;
import com.hive.social.SocialHiveImpl;
import com.hive.social.SocialKeys;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "")
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001:\u001d3456789:;<=>?@ABCDEFGHIJKLMNOB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\u0016J!\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u001eJ \u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020\u0016J(\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020'J(\u0010(\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020'J(\u0010)\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020'J(\u0010*\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u000b\u001a\u00020'J\u001e\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020/J(\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020/J\u000e\u00101\u001a\u00020\n2\u0006\u0010\u000b\u001a\u000202R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006P"}, d2 = {"Lcom/hive/SocialHive;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "getMyProfile", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/SocialHive$ProfileListener;", "setMyProfile", "displayName", "getFriends", "friendType", "Lcom/hive/SocialHive$FriendType;", "getInvitations", "", "getFriendsParam", "Lcom/hive/SocialHive$GetFriendsParam;", "Lcom/hive/SocialHive$AsyncRequestListener;", "getProfiles", "vidList", "", "([Ljava/lang/String;Lcom/hive/SocialHive$ProfileListener;)V", "sendMessage", "messageContent", "Lcom/hive/SocialHive$MessageContent;", "Lcom/hive/SocialHive$SendMessageListener;", "sendInvitationMessage", "asyncRequest", "subPath", "jsonData", "Lorg/json/JSONObject;", "socialRequest", NotificationCompat.CATEGORY_SERVICE, "apiName", "Lcom/hive/SocialHive$SocialRequestListener;", "socialRequestFacebook", "socialRequestGoogle", "socialRequestChina", "showHiveDialog", "hiveDialogType", "Lcom/hive/SocialHive$HiveDialogType;", "vid", "Lcom/hive/SocialHive$ShowHiveDialogListener;", "additionalInfo", "getBadgeInfo", "Lcom/hive/SocialHive$SocialBadgeListener;", "ProfileListener", "SendMessageListener", "SendMessageListenerEx", "GetVidListener", "AsyncRequestListener", "SocialRequestListener", "ShowPeppermintDialogListener", "ShowHiveDialogListener", "ShowHiveDialogDataListener", "SocialBadgeListener", "FriendType", "HiveDialogType", "HiveRelationRoute", "ProfileHive", "ProfileGetUser", "MessageContent", "SocialBadge", "GuestGenerateParam", "GuestLoginParam", "GuestAuthParam", "UploadSaveDataParam", "UploadImageParam", "WallWriteParam", "GetFriendsParam", "FriendsFacebookRequestParam", "FriendsRejectRequestParam", "FriendsRequestParam", "FriendsReceiveListParam", "GuestStatusSaveDataParam", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialHive {
    public static final SocialHive INSTANCE = new SocialHive();
    private static final String TAG = "SocialHive";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/SocialHive$AsyncRequestListener;", "", "onComplete", "", "result", "Lcom/hive/ResultAPI;", "responseJsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AsyncRequestListener {
        void onComplete(ResultAPI result, JSONObject responseJsonData);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/hive/SocialHive$FriendType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IN_GAME", "OUT_GAME", "INVITED", "ALL_GAME", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FriendType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FriendType[] $VALUES;
        private final String value;
        public static final FriendType IN_GAME = new FriendType("IN_GAME", 0, "ingame");
        public static final FriendType OUT_GAME = new FriendType("OUT_GAME", 1, "outgame");
        public static final FriendType INVITED = new FriendType("INVITED", 2, "invited");
        public static final FriendType ALL_GAME = new FriendType("ALL_GAME", 3, "allgame");

        private static final /* synthetic */ FriendType[] $values() {
            return new FriendType[]{IN_GAME, OUT_GAME, INVITED, ALL_GAME};
        }

        static {
            FriendType[] friendTypeArr$values = $values();
            $VALUES = friendTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(friendTypeArr$values);
        }

        private FriendType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<FriendType> getEntries() {
            return $ENTRIES;
        }

        public static FriendType valueOf(String str) {
            return (FriendType) Enum.valueOf(FriendType.class, str);
        }

        public static FriendType[] values() {
            return (FriendType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/hive/SocialHive$GetFriendsParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "limit", "", "(I)V", "getLimit", "()I", "setLimit", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetFriendsParam extends DataModel {
        private int limit;

        public GetFriendsParam() {
        }

        public final int getLimit() {
            return this.limit;
        }

        public final void setLimit(int i) {
            this.limit = i;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            this.limit = jsonData.optInt("limit");
        }

        public GetFriendsParam(int i) {
            this.limit = i;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/SocialHive$GetVidListener;", "", "onComplete", "", "result", "Lcom/hive/ResultAPI;", "vidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GetVidListener {
        void onComplete(ResultAPI result, ArrayList<String> vidList);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/hive/SocialHive$HiveDialogType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HOME", "GAME", "USER", "INQUIRY", "MESSAGE", "CHATBOT", "EDIT_PROFILE_PICTURE", "EDIT_FACEBOOK", "MYINQUIRY", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveDialogType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HiveDialogType[] $VALUES;
        private final String value;
        public static final HiveDialogType HOME = new HiveDialogType("HOME", 0, "home");
        public static final HiveDialogType GAME = new HiveDialogType("GAME", 1, "game");
        public static final HiveDialogType USER = new HiveDialogType("USER", 2, "user");
        public static final HiveDialogType INQUIRY = new HiveDialogType("INQUIRY", 3, "inquiry");
        public static final HiveDialogType MESSAGE = new HiveDialogType("MESSAGE", 4, "message");
        public static final HiveDialogType CHATBOT = new HiveDialogType("CHATBOT", 5, "chatbot");
        public static final HiveDialogType EDIT_PROFILE_PICTURE = new HiveDialogType("EDIT_PROFILE_PICTURE", 6, "edit/profile/picture");
        public static final HiveDialogType EDIT_FACEBOOK = new HiveDialogType("EDIT_FACEBOOK", 7, "edit/facebook");
        public static final HiveDialogType MYINQUIRY = new HiveDialogType("MYINQUIRY", 8, "myinquiry");

        private static final /* synthetic */ HiveDialogType[] $values() {
            return new HiveDialogType[]{HOME, GAME, USER, INQUIRY, MESSAGE, CHATBOT, EDIT_PROFILE_PICTURE, EDIT_FACEBOOK, MYINQUIRY};
        }

        static {
            HiveDialogType[] hiveDialogTypeArr$values = $values();
            $VALUES = hiveDialogTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hiveDialogTypeArr$values);
        }

        private HiveDialogType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<HiveDialogType> getEntries() {
            return $ENTRIES;
        }

        public static HiveDialogType valueOf(String str) {
            return (HiveDialogType) Enum.valueOf(HiveDialogType.class, str);
        }

        public static HiveDialogType[] values() {
            return (HiveDialogType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/hive/SocialHive$HiveRelationRoute;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "HIVE", "FACEBOOK", "GAME", "CONTACT", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveRelationRoute {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HiveRelationRoute[] $VALUES;
        private final String value;
        public static final HiveRelationRoute DEFAULT = new HiveRelationRoute("DEFAULT", 0, "default");
        public static final HiveRelationRoute HIVE = new HiveRelationRoute("HIVE", 1, "hive");
        public static final HiveRelationRoute FACEBOOK = new HiveRelationRoute("FACEBOOK", 2, "facebook");
        public static final HiveRelationRoute GAME = new HiveRelationRoute("GAME", 3, "game");
        public static final HiveRelationRoute CONTACT = new HiveRelationRoute("CONTACT", 4, "contact");

        private static final /* synthetic */ HiveRelationRoute[] $values() {
            return new HiveRelationRoute[]{DEFAULT, HIVE, FACEBOOK, GAME, CONTACT};
        }

        static {
            HiveRelationRoute[] hiveRelationRouteArr$values = $values();
            $VALUES = hiveRelationRouteArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hiveRelationRouteArr$values);
        }

        private HiveRelationRoute(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<HiveRelationRoute> getEntries() {
            return $ENTRIES;
        }

        public static HiveRelationRoute valueOf(String str) {
            return (HiveRelationRoute) Enum.valueOf(HiveRelationRoute.class, str);
        }

        public static HiveRelationRoute[] values() {
            return (HiveRelationRoute[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001c\u0010(\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u0006+"}, d2 = {"Lcom/hive/SocialHive$ProfileGetUser;", "Lcom/hive/base/DataModel;", "<init>", "()V", "playerId", "", "getPlayerId", "()Ljava/lang/String;", "setPlayerId", "(Ljava/lang/String;)V", "userId", "getUserId", "setUserId", "publisherId", "getPublisherId", "setPublisherId", "idpIndex", "getIdpIndex", "setIdpIndex", "profileName", "getProfileName", "setProfileName", "defaultImg", "getDefaultImg", "setDefaultImg", "profileImg", "getProfileImg", "setProfileImg", "imageType", "getImageType", "setImageType", "status", "getStatus", "setStatus", "adddate", "getAdddate", "setAdddate", "moddate", "getModdate", "setModdate", "idpId", "getIdpId", "setIdpId", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProfileGetUser extends DataModel {
        private String adddate;
        private String defaultImg;
        private String idpId;
        private String idpIndex;
        private String imageType;
        private String moddate;
        private String playerId;
        private String profileImg;
        private String profileName;
        private String publisherId;
        private String status;
        private String userId;

        public final String getAdddate() {
            return this.adddate;
        }

        public final String getDefaultImg() {
            return this.defaultImg;
        }

        public final String getIdpId() {
            return this.idpId;
        }

        public final String getIdpIndex() {
            return this.idpIndex;
        }

        public final String getImageType() {
            return this.imageType;
        }

        public final String getModdate() {
            return this.moddate;
        }

        public final String getPlayerId() {
            return this.playerId;
        }

        public final String getProfileImg() {
            return this.profileImg;
        }

        public final String getProfileName() {
            return this.profileName;
        }

        public final String getPublisherId() {
            return this.publisherId;
        }

        public final String getStatus() {
            return this.status;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final void setAdddate(String str) {
            this.adddate = str;
        }

        public final void setDefaultImg(String str) {
            this.defaultImg = str;
        }

        public final void setIdpId(String str) {
            this.idpId = str;
        }

        public final void setIdpIndex(String str) {
            this.idpIndex = str;
        }

        public final void setImageType(String str) {
            this.imageType = str;
        }

        public final void setModdate(String str) {
            this.moddate = str;
        }

        public final void setPlayerId(String str) {
            this.playerId = str;
        }

        public final void setProfileImg(String str) {
            this.profileImg = str;
        }

        public final void setProfileName(String str) {
            this.profileName = str;
        }

        public final void setPublisherId(String str) {
            this.publisherId = str;
        }

        public final void setStatus(String str) {
            this.status = str;
        }

        public final void setUserId(String str) {
            this.userId = str;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010)\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001c\u0010,\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR\u001c\u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR\u001c\u00102\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\tR\u001e\u00105\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R\u001c\u00108\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0007\"\u0004\b:\u0010\tR\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/hive/SocialHive$ProfileHive;", "Lcom/hive/base/DataModel;", "<init>", "()V", "vid", "", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "uid", "getUid", "setUid", "identifier", "getIdentifier", "setIdentifier", "userName", "getUserName", "setUserName", "facebookId", "getFacebookId", "setFacebookId", "googleplusId", "getGoogleplusId", "setGoogleplusId", "profileImageUrl", "getProfileImageUrl", "setProfileImageUrl", UserDataStore.COUNTRY, "getCountry", "setCountry", "comment", "getComment", "setComment", "cached", "", "getCached", "()Ljava/lang/Boolean;", "setCached", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "testAccount", "getTestAccount", "setTestAccount", "email", "getEmail", "setEmail", "birthday", "getBirthday", "setBirthday", "gender", "getGender", "setGender", "gameFriend", "getGameFriend", "setGameFriend", "assnet", "getAssnet", "setAssnet", "relationRoute", "Lcom/hive/SocialHive$HiveRelationRoute;", "getRelationRoute", "()Lcom/hive/SocialHive$HiveRelationRoute;", "setRelationRoute", "(Lcom/hive/SocialHive$HiveRelationRoute;)V", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ProfileHive extends DataModel {
        private String assnet;
        private String birthday;
        private Boolean cached;
        private String comment;
        private String country;
        private String email;
        private String facebookId;
        private Boolean gameFriend;
        private String gender;
        private String googleplusId;
        private String identifier;
        private String profileImageUrl;
        private HiveRelationRoute relationRoute;
        private Boolean testAccount;
        private String uid;
        private String userName;
        private String vid;

        public final String getAssnet() {
            return this.assnet;
        }

        public final String getBirthday() {
            return this.birthday;
        }

        public final Boolean getCached() {
            return this.cached;
        }

        public final String getComment() {
            return this.comment;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getFacebookId() {
            return this.facebookId;
        }

        public final Boolean getGameFriend() {
            return this.gameFriend;
        }

        public final String getGender() {
            return this.gender;
        }

        public final String getGoogleplusId() {
            return this.googleplusId;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final String getProfileImageUrl() {
            return this.profileImageUrl;
        }

        public final HiveRelationRoute getRelationRoute() {
            return this.relationRoute;
        }

        public final Boolean getTestAccount() {
            return this.testAccount;
        }

        public final String getUid() {
            return this.uid;
        }

        public final String getUserName() {
            return this.userName;
        }

        public final String getVid() {
            return this.vid;
        }

        public final void setAssnet(String str) {
            this.assnet = str;
        }

        public final void setBirthday(String str) {
            this.birthday = str;
        }

        public final void setCached(Boolean bool) {
            this.cached = bool;
        }

        public final void setComment(String str) {
            this.comment = str;
        }

        public final void setCountry(String str) {
            this.country = str;
        }

        public final void setEmail(String str) {
            this.email = str;
        }

        public final void setFacebookId(String str) {
            this.facebookId = str;
        }

        public final void setGameFriend(Boolean bool) {
            this.gameFriend = bool;
        }

        public final void setGender(String str) {
            this.gender = str;
        }

        public final void setGoogleplusId(String str) {
            this.googleplusId = str;
        }

        public final void setIdentifier(String str) {
            this.identifier = str;
        }

        public final void setProfileImageUrl(String str) {
            this.profileImageUrl = str;
        }

        public final void setRelationRoute(HiveRelationRoute hiveRelationRoute) {
            this.relationRoute = hiveRelationRoute;
        }

        public final void setTestAccount(Boolean bool) {
            this.testAccount = bool;
        }

        public final void setUid(String str) {
            this.uid = str;
        }

        public final void setUserName(String str) {
            this.userName = str;
        }

        public final void setVid(String str) {
            this.vid = str;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/SocialHive$ProfileListener;", "", "onProfile", "", "result", "Lcom/hive/ResultAPI;", "profileList", "Ljava/util/ArrayList;", "Lcom/hive/SocialHive$ProfileHive;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ProfileListener {
        void onProfile(ResultAPI result, ArrayList<ProfileHive> profileList);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/SocialHive$SendMessageListener;", "", "onSendMessage", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SendMessageListener {
        void onSendMessage(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/SocialHive$SendMessageListenerEx;", "", "onSendMessage", "", "result", "Lcom/hive/ResultAPI;", "responseJsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SendMessageListenerEx {
        void onSendMessage(ResultAPI result, JSONObject responseJsonData);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "", "onShowHiveDialogWithData", "", "result", "Lcom/hive/ResultAPI;", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ShowHiveDialogDataListener {
        void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/SocialHive$ShowHiveDialogListener;", "", "onShowHiveDialog", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ShowHiveDialogListener {
        void onShowHiveDialog(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/SocialHive$ShowPeppermintDialogListener;", "", "onPeppermintDialog", "", "result", "Lcom/hive/ResultAPI;", "responseJsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ShowPeppermintDialogListener {
        void onPeppermintDialog(ResultAPI result, JSONObject responseJsonData);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/hive/SocialHive$SocialBadge;", "Lcom/hive/base/DataModel;", "<init>", "()V", "messageCount", "", "getMessageCount", "()I", "setMessageCount", "(I)V", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SocialBadge extends DataModel {
        private int messageCount;

        public final int getMessageCount() {
            return this.messageCount;
        }

        public final void setMessageCount(int i) {
            this.messageCount = i;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/SocialHive$SocialBadgeListener;", "", "onSocialBadge", "", "result", "Lcom/hive/ResultAPI;", "badge", "Lcom/hive/SocialHive$SocialBadge;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocialBadgeListener {
        void onSocialBadge(ResultAPI result, SocialBadge badge);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/SocialHive$SocialRequestListener;", "", "onComplete", "", "result", "Lcom/hive/ResultAPI;", "responseJsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocialRequestListener {
        void onComplete(ResultAPI result, JSONObject responseJsonData);
    }

    private SocialHive() {
    }

    public final int asyncRequest(String subPath, JSONObject jsonData, AsyncRequestListener listener) {
        Intrinsics.checkNotNullParameter(subPath, "subPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringBuilder sb = new StringBuilder("subPath: ");
        sb.append(subPath);
        sb.append(", jsonData: ");
        sb.append(jsonData != null ? jsonData.toString() : null);
        sb.append(", listener: ");
        sb.append(listener);
        String string = sb.toString();
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, string);
        int iAsyncRequest = SocialHiveImpl.INSTANCE.asyncRequest(subPath, jsonData, listener);
        loggerImpl.apiReturnLog(str, "");
        return iAsyncRequest;
    }

    public final void getBadgeInfo(SocialBadgeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.getBadgeInfo(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final void getFriends(FriendType friendType, ProfileListener listener) {
        Intrinsics.checkNotNullParameter(friendType, "friendType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("friendType = %s, listener = %s", Arrays.copyOf(new Object[]{friendType.getValue(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.getFriends(friendType, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final int getInvitations(GetFriendsParam getFriendsParam, AsyncRequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        int invitations = SocialHiveImpl.INSTANCE.getInvitations(getFriendsParam, listener);
        loggerImpl.apiReturnLog(str2, "");
        return invitations;
    }

    public final void getMyProfile(ProfileListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.getMyProfile(listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final void getProfiles(String[] vidList, ProfileListener listener) {
        Intrinsics.checkNotNullParameter(vidList, "vidList");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("vidList = %s, listener = %s", Arrays.copyOf(new Object[]{vidList, listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.getProfiles(vidList, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final String getTAG() {
        return TAG;
    }

    public final void sendInvitationMessage(MessageContent messageContent, SendMessageListener listener) {
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("messageContent = %s, listener = %s", Arrays.copyOf(new Object[]{messageContent.toString(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.sendInvitationMessage(messageContent, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final void sendMessage(MessageContent messageContent, SendMessageListener listener) {
        Intrinsics.checkNotNullParameter(messageContent, "messageContent");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("messageContent = %s, listener = %s", Arrays.copyOf(new Object[]{messageContent.toString(), listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.sendMessage(messageContent, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final void setMyProfile(String displayName, ProfileListener listener) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("listener = %s", Arrays.copyOf(new Object[]{listener}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.setMyProfile(displayName, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final void showHiveDialog(HiveDialogType hiveDialogType, String vid, ShowHiveDialogListener listener) {
        Intrinsics.checkNotNullParameter(hiveDialogType, "hiveDialogType");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("vid = %s, listener = %s", Arrays.copyOf(new Object[]{vid, listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.showHiveDialog(hiveDialogType, vid, (String) null, listener);
        loggerImpl.apiReturnLog(str2, "");
    }

    public final int socialRequest(String service, String apiName, JSONObject jsonData, SocialRequestListener listener) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (service.equals("facebook")) {
            return socialRequestFacebook(service, apiName, jsonData, listener);
        }
        if (service.equals("googleplus")) {
            return socialRequestGoogle(service, apiName, jsonData, listener);
        }
        if (Intrinsics.areEqual(service, "huawei") || Intrinsics.areEqual(service, "oppo") || Intrinsics.areEqual(service, Constants.REFERRER_API_VIVO) || Intrinsics.areEqual(service, Constants.REFERRER_API_XIAOMI)) {
            return socialRequestChina(service, apiName, jsonData, listener);
        }
        return -9;
    }

    public final int socialRequestChina(String service, String apiName, JSONObject jsonData, final SocialRequestListener listener) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialV4ProviderAdapter addedChinaProvider = SocialV4ProviderAdapter.INSTANCE.getAddedChinaProvider();
        if (addedChinaProvider == null) {
            LoggerImpl.INSTANCE.d(TAG, "Provider is null");
            listener.onComplete(new ResultAPI(-1, ResultAPI.Code.SocialInvalidParam), null);
            return -9;
        }
        if (!Intrinsics.areEqual(apiName, SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_APP_EXIT)) {
            return -16;
        }
        LoggerImpl.INSTANCE.i(TAG, "social/appexit handleSocialRequestAppExitScheme");
        addedChinaProvider.handleSocialRequestAppExitScheme(new SocialV4ProviderAdapter.SocialSchemeListener() { // from class: com.hive.SocialHive.socialRequestChina.1
            @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialSchemeListener
            public void onResult(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                listener.onComplete(new ResultAPI(), jsonObject);
            }
        });
        return 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int socialRequestFacebook(String service, final String apiName, JSONObject jsonData, final SocialRequestListener listener) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialV4ProviderAdapter.Companion companion = SocialV4ProviderAdapter.INSTANCE;
        SocialV4.ProviderType providerType = SocialV4.ProviderType.FACEBOOK;
        if (companion.getInstance(providerType) == null) {
            listener.onComplete(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Facebook does not exist"), null);
            return -9;
        }
        switch (apiName.hashCode()) {
            case -2142407757:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE_IMAGE)) {
                    return -16;
                }
                if (jsonData != null) {
                    if (!jsonData.has(AccessToken.USER_ID_KEY)) {
                        return -9;
                    }
                    SocialV4ProviderAdapter companion2 = companion.getInstance(providerType);
                    Intrinsics.checkNotNull(companion2);
                    return companion2.requestUserProfileImage(jsonData, new SocialV4ProviderAdapter.SocialV4RequestListener() { // from class: com.hive.SocialHive.socialRequestFacebook.5
                        @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4RequestListener
                        public void onComplete(ResultAPI result, String responseData) {
                            JSONObject jSONObject;
                            Intrinsics.checkNotNullParameter(result, "result");
                            Intrinsics.checkNotNullParameter(responseData, "responseData");
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject = new JSONObject(responseData);
                                try {
                                    jSONObject.put("url", jSONObject.optJSONObject("data").optString("url"));
                                    jSONObject.remove("data");
                                } catch (Exception e) {
                                    e = e;
                                    jSONObject2 = jSONObject;
                                    e.printStackTrace();
                                    jSONObject = jSONObject2;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            listener.onComplete(result, jSONObject);
                        }
                    });
                }
                return 0;
            case -2084545105:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_SHARE_APP_ACTIVITY)) {
                    return -16;
                }
                if (jsonData == null || !jsonData.has("link")) {
                    return -9;
                }
                SocialV4ProviderAdapter companion3 = companion.getInstance(providerType);
                Intrinsics.checkNotNull(companion3);
                String strOptString = jsonData.optString("link");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                companion3.postFacebookWithContentURL(strOptString, new SocialV4ProviderAdapter.PostFacebookListener() { // from class: com.hive.SocialHive.socialRequestFacebook.6
                    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.PostFacebookListener
                    public void onPostFacebook(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                            jSONObject.put("type", apiName);
                            if (result.getErrorCode() == 0) {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                            } else if (result.getErrorCode() == -6) {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2004);
                                jSONObject.put("error_msg", "user cancelled");
                                jSONObject.put("result", false);
                            } else {
                                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                jSONObject.put("error_msg", result.getErrorMessage());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        listener.onComplete(result, jSONObject);
                    }
                });
                return 0;
            case -1615357924:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_INVITE_DIALOG)) {
                    return -16;
                }
                if (jsonData != null) {
                    SocialV4ProviderAdapter.SocialV4FacebookMessage socialV4FacebookMessage = new SocialV4ProviderAdapter.SocialV4FacebookMessage();
                    try {
                        final JSONObject jSONObject = new JSONObject();
                        if (!jsonData.has("message")) {
                            Unit unit = Unit.INSTANCE;
                            return -9;
                        }
                        String strOptString2 = jsonData.optString("message");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        socialV4FacebookMessage.setMessage(strOptString2);
                        SocialV4ProviderAdapter companion4 = companion.getInstance(providerType);
                        if (companion4 != null) {
                            companion4.showInvitationDialog(socialV4FacebookMessage, new SocialV4ProviderAdapter.ShowInvitationDialogListener() { // from class: com.hive.SocialHive.socialRequestFacebook.2
                                @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.ShowInvitationDialogListener
                                public void onShowInvitationDialog(ResultAPI result, List<String> invitedUserList) {
                                    Intrinsics.checkNotNullParameter(result, "result");
                                    try {
                                        jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                        jSONObject.put("type", apiName);
                                        if (result.isSuccess()) {
                                            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                                            jSONObject.put("error_msg", result.getErrorMessage());
                                            if (invitedUserList != null && !invitedUserList.isEmpty()) {
                                                JSONArray jSONArray = new JSONArray();
                                                Iterator<String> it = invitedUserList.iterator();
                                                while (it.hasNext()) {
                                                    jSONArray.put(it.next());
                                                }
                                                jSONObject.put("receivers", jSONArray);
                                            }
                                            Unit unit2 = Unit.INSTANCE;
                                        } else if (result.getCode() == ResultAPI.Code.SocialFacebookCancelShowInvitation) {
                                            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2004);
                                            jSONObject.put("error_msg", result.getErrorMessage());
                                        } else {
                                            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                            jSONObject.put("error_msg", result.getErrorMessage());
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    listener.onComplete(result, jSONObject);
                                }
                            });
                            Unit unit2 = Unit.INSTANCE;
                        }
                        return 0;
                    } catch (Exception e) {
                        e.printStackTrace();
                        Unit unit3 = Unit.INSTANCE;
                        return -9;
                    }
                }
                return 0;
            case -1588770233:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE)) {
                    return -16;
                }
                SocialV4ProviderAdapter companion5 = companion.getInstance(providerType);
                if (companion5 != null) {
                    companion5.getMyFacebookProfile(new SocialV4ProviderAdapter.SocialV4FacebookProfileListener() { // from class: com.hive.SocialHive.socialRequestFacebook.1
                        @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4FacebookProfileListener
                        public void onProfile(ResultAPI resultAPI, ArrayList<SocialV4ProviderAdapter.SocialV4FacebookProfile> profileList) {
                            Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                jSONObject2.put("type", apiName);
                                if (resultAPI.isSuccess()) {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                                    jSONObject2.put("error_msg", resultAPI.getErrorMessage());
                                    if (profileList != null && !profileList.isEmpty()) {
                                        jSONObject2.put("uid", profileList.get(0).getUid());
                                        jSONObject2.put("email", profileList.get(0).getEmail());
                                        jSONObject2.put("username", profileList.get(0).getUsername());
                                        jSONObject2.put("profileImageUrl", profileList.get(0).getProfileImageUrl());
                                    }
                                } else {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                    jSONObject2.put("error_msg", resultAPI.getErrorMessage());
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            listener.onComplete(resultAPI, jSONObject2);
                        }
                    });
                    return 0;
                }
                return 0;
            case -1465831250:
                if (!apiName.equals("social/set_permission")) {
                    return -16;
                }
                SocialV4ProviderAdapter companion6 = companion.getInstance(providerType);
                Intrinsics.checkNotNull(companion6);
                return companion6.setFacebookPermissions(jsonData, new SocialV4ProviderAdapter.SocialV4RequestListener() { // from class: com.hive.SocialHive.socialRequestFacebook.10
                    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4RequestListener
                    public void onComplete(ResultAPI resultAPI, String responseData) {
                        Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                        Intrinsics.checkNotNullParameter(responseData, "responseData");
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2 = new JSONObject(responseData);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        listener.onComplete(resultAPI, jSONObject2);
                    }
                });
            case -1220732308:
                apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_LOGOUT);
                return -16;
            case -1093190333:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_FRIENDS)) {
                    return -16;
                }
                SocialV4ProviderAdapter companion7 = companion.getInstance(providerType);
                if (companion7 != null) {
                    companion7.getFacebookFriends(new SocialV4ProviderAdapter.SocialV4FacebookProfileListener() { // from class: com.hive.SocialHive.socialRequestFacebook.4
                        /* JADX WARN: Type inference fix 'apply assigned field type' failed
                        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                         */
                        @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4FacebookProfileListener
                        public void onProfile(ResultAPI result, ArrayList<SocialV4ProviderAdapter.SocialV4FacebookProfile> profileList) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                jSONObject2.put("type", apiName);
                                if (result.getCode() == ResultAPI.Code.Success) {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                                    if (profileList != null && !profileList.isEmpty()) {
                                        JSONArray jSONArray = new JSONArray();
                                        Iterator<SocialV4ProviderAdapter.SocialV4FacebookProfile> it = profileList.iterator();
                                        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                                        while (it.hasNext()) {
                                            SocialV4ProviderAdapter.SocialV4FacebookProfile next = it.next();
                                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                            jSONArray.put(next.getUid());
                                        }
                                        jSONObject2.put(NativeProtocol.AUDIENCE_FRIENDS, jSONArray);
                                    }
                                    Unit unit4 = Unit.INSTANCE;
                                } else if (result.getErrorCode() == -6) {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2004);
                                    jSONObject2.put("error_msg", result.getErrorMessage());
                                } else {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                    jSONObject2.put("error_msg", result.getErrorMessage());
                                    jSONObject2.put(NativeProtocol.AUDIENCE_FRIENDS, JSONObject.NULL);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            listener.onComplete(result, jSONObject2);
                        }
                    });
                    return 0;
                }
                return 0;
            case 900270615:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_TOKEN)) {
                    return -16;
                }
                SocialV4ProviderAdapter companion8 = companion.getInstance(providerType);
                Intrinsics.checkNotNull(companion8);
                return companion8.requestUserTokenWithResponseCallback(new SocialV4ProviderAdapter.SocialV4RequestListener() { // from class: com.hive.SocialHive.socialRequestFacebook.9
                    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4RequestListener
                    public void onComplete(ResultAPI result, String responseData) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Intrinsics.checkNotNullParameter(responseData, "responseData");
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2 = new JSONObject(responseData);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        listener.onComplete(result, jSONObject2);
                    }
                });
            case 1057746053:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_RECEIVED_INVITE)) {
                    return -16;
                }
                SocialV4ProviderAdapter companion9 = companion.getInstance(providerType);
                Intrinsics.checkNotNull(companion9);
                return companion9.requestReceivedInvite(jsonData, new SocialV4ProviderAdapter.SocialV4RequestListener() { // from class: com.hive.SocialHive.socialRequestFacebook.3
                    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4RequestListener
                    public void onComplete(ResultAPI result, String responseData) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Intrinsics.checkNotNullParameter(responseData, "responseData");
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2 = new JSONObject(responseData);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        listener.onComplete(result, jSONObject2);
                    }
                });
            case 1420824648:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_CONNECT)) {
                    return -16;
                }
                SocialV4ProviderAdapter companion10 = companion.getInstance(providerType);
                Intrinsics.checkNotNull(companion10);
                return companion10.requestConnect(new SocialV4ProviderAdapter.SocialV4RequestListener() { // from class: com.hive.SocialHive.socialRequestFacebook.8
                    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4RequestListener
                    public void onComplete(ResultAPI result, String responseData) {
                        JSONObject jSONObject2;
                        Intrinsics.checkNotNullParameter(result, "result");
                        Intrinsics.checkNotNullParameter(responseData, "responseData");
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject2 = new JSONObject(responseData);
                            try {
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "facebook");
                                jSONObject2.put("type", apiName);
                                if (result.getErrorCode() == 0) {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                                } else {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_NETWORK_BAD_RESPONSE);
                                }
                            } catch (Exception e2) {
                                e = e2;
                                jSONObject3 = jSONObject2;
                                e.printStackTrace();
                                jSONObject2 = jSONObject3;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                        listener.onComplete(result, jSONObject2);
                    }
                });
            case 1563318446:
                if (!apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_IS_AUTHORIZED)) {
                    return -16;
                }
                SocialV4ProviderAdapter companion11 = companion.getInstance(providerType);
                Intrinsics.checkNotNull(companion11);
                return companion11.isAuthorized(new SocialV4ProviderAdapter.SocialV4RequestListener() { // from class: com.hive.SocialHive.socialRequestFacebook.7
                    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4RequestListener
                    public void onComplete(ResultAPI result, String responseData) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        Intrinsics.checkNotNullParameter(responseData, "responseData");
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2 = new JSONObject(responseData);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        listener.onComplete(result, jSONObject2);
                    }
                });
            default:
                return -16;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int socialRequestGoogle(String service, final String apiName, JSONObject jsonData, final SocialRequestListener listener) {
        String str;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialV4ProviderAdapter.Companion companion = SocialV4ProviderAdapter.INSTANCE;
        SocialV4.ProviderType providerType = SocialV4.ProviderType.GOOGLE;
        if (companion.getInstance(providerType) == null) {
            listener.onComplete(new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "Google Services do not exist"), null);
            return -9;
        }
        switch (apiName.hashCode()) {
            case -2142407757:
                apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE_IMAGE);
                return -16;
            case -2084545105:
                if (apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_SHARE_APP_ACTIVITY)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "googleplus");
                        jSONObject.put("type", apiName);
                        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_SOCIAL_NOTSUP);
                        jSONObject.put("error_msg", "not supported");
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    listener.onComplete(new ResultAPI(-2, ResultAPI.Code.SocialGoogleCancelConnect), jSONObject);
                    return -16;
                }
                return -16;
            case -1615357924:
                apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_INVITE_DIALOG);
                return -16;
            case -1588770233:
                if (apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_PROFILE)) {
                    SocialV4ProviderAdapter companion2 = companion.getInstance(providerType);
                    Intrinsics.checkNotNull(companion2);
                    companion2.getMyGoogleProfile(new SocialV4ProviderAdapter.SocialV4GoogleProfileListener() { // from class: com.hive.SocialHive.socialRequestGoogle.1
                        @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4GoogleProfileListener
                        public void onProfile(ResultAPI result, ArrayList<SocialV4ProviderAdapter.SocialV4GoogleProfile> profile) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "googleplus");
                                jSONObject2.put("type", apiName);
                                if (result.getErrorCode() == 0) {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                                } else {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 2003);
                                }
                                if (profile != null) {
                                    Iterator<SocialV4ProviderAdapter.SocialV4GoogleProfile> it = profile.iterator();
                                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                                    if (it.hasNext()) {
                                        SocialV4ProviderAdapter.SocialV4GoogleProfile next = it.next();
                                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                        SocialV4ProviderAdapter.SocialV4GoogleProfile socialV4GoogleProfile = next;
                                        jSONObject2.put("uid", socialV4GoogleProfile.getUserId());
                                        jSONObject2.put("email", socialV4GoogleProfile.getEmail());
                                        jSONObject2.put(FirebaseAnalytics.Param.SCREEN_NAME, socialV4GoogleProfile.getDisplayName());
                                        jSONObject2.put("picture", socialV4GoogleProfile.getProfileImageUrl());
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            listener.onComplete(result, jSONObject2);
                        }
                    });
                    return 0;
                }
                return -16;
            case -1220732308:
                str = SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_LOGOUT;
                apiName.equals(str);
                return -16;
            case -1093190333:
                str = SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_FRIENDS;
                apiName.equals(str);
                return -16;
            case 1057746053:
                str = SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_RECEIVED_INVITE;
                apiName.equals(str);
                return -16;
            case 1420824648:
                if (apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_CONNECT)) {
                    SocialV4ProviderAdapter companion3 = companion.getInstance(providerType);
                    Intrinsics.checkNotNull(companion3);
                    return companion3.requestSocialConnect(new SocialV4ProviderAdapter.SocialV4RequestListener() { // from class: com.hive.SocialHive.socialRequestGoogle.3
                        @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4RequestListener
                        public void onComplete(ResultAPI result, String responseData) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            Intrinsics.checkNotNullParameter(responseData, "responseData");
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                if (responseData.length() != 0) {
                                    jSONObject2 = new JSONObject(responseData);
                                }
                                jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, "googleplus");
                                jSONObject2.put("type", apiName);
                                if (result.getErrorCode() == 0) {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
                                } else {
                                    jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, ResultAPI.PeppermintErrCode.HUB_E_NETWORK_BAD_RESPONSE);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            listener.onComplete(result, jSONObject2);
                        }
                    });
                }
                return -16;
            case 1563318446:
                if (apiName.equals(SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_IS_AUTHORIZED)) {
                    SocialV4ProviderAdapter companion4 = companion.getInstance(providerType);
                    Intrinsics.checkNotNull(companion4);
                    return companion4.isAuthorized(new SocialV4ProviderAdapter.SocialV4RequestListener() { // from class: com.hive.SocialHive.socialRequestGoogle.2
                        @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter.SocialV4RequestListener
                        public void onComplete(ResultAPI result, String responseData) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            Intrinsics.checkNotNullParameter(responseData, "responseData");
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                if (responseData.length() != 0) {
                                    jSONObject2 = new JSONObject(responseData);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            listener.onComplete(result, jSONObject2);
                        }
                    });
                }
                return -16;
            default:
                return -16;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/hive/SocialHive$FriendsReceiveListParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "count", "", "(I)V", "getCount", "()I", "setCount", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FriendsReceiveListParam extends DataModel {
        private int count;

        public FriendsReceiveListParam() {
            this.count = 5;
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            this.count = jsonData.optInt("count");
        }

        public FriendsReceiveListParam(int i) {
            this.count = i;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/hive/SocialHive$FriendsRejectRequestParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "uid", "", "(Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "setUid", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FriendsRejectRequestParam extends DataModel {
        private String uid;

        public FriendsRejectRequestParam() {
            this.uid = "";
        }

        public final String getUid() {
            return this.uid;
        }

        public final void setUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString = jsonData.optString("uid");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.uid = strOptString;
        }

        public FriendsRejectRequestParam(String uid) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            this.uid = uid;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/hive/SocialHive$GuestAuthParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "guestUid", "", "(Ljava/lang/String;)V", "getGuestUid", "()Ljava/lang/String;", "setGuestUid", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GuestAuthParam extends DataModel {
        private String guestUid;

        public GuestAuthParam() {
            this.guestUid = "";
        }

        public final String getGuestUid() {
            return this.guestUid;
        }

        public final void setGuestUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guestUid = str;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString = jsonData.optString("guest_uid");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.guestUid = strOptString;
        }

        public GuestAuthParam(String guestUid) {
            Intrinsics.checkNotNullParameter(guestUid, "guestUid");
            this.guestUid = guestUid;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/hive/SocialHive$GuestStatusSaveDataParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "uid", "", "(Ljava/lang/String;)V", "getUid", "()Ljava/lang/String;", "setUid", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GuestStatusSaveDataParam extends DataModel {
        private String uid;

        public GuestStatusSaveDataParam() {
            this.uid = "";
        }

        public final String getUid() {
            return this.uid;
        }

        public final void setUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString = jsonData.optString("uid");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.uid = strOptString;
        }

        public GuestStatusSaveDataParam(String uid) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            this.uid = uid;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/hive/SocialHive$UploadImageParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "image", "", "(Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "setImage", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UploadImageParam extends DataModel {
        private String image;

        public UploadImageParam() {
            this.image = "";
        }

        public final String getImage() {
            return this.image;
        }

        public final void setImage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.image = str;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString = jsonData.optString("image");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.image = strOptString;
        }

        public UploadImageParam(String image) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.image = image;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/hive/SocialHive$FriendsRequestParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "friendUid", "", "showStatus", "", "(Ljava/lang/String;Z)V", "getFriendUid", "()Ljava/lang/String;", "setFriendUid", "(Ljava/lang/String;)V", "getShowStatus", "()Z", "setShowStatus", "(Z)V", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FriendsRequestParam extends DataModel {
        private String friendUid;
        private boolean showStatus;

        public FriendsRequestParam() {
            this.friendUid = "";
            this.showStatus = true;
        }

        public final String getFriendUid() {
            return this.friendUid;
        }

        public final boolean getShowStatus() {
            return this.showStatus;
        }

        public final void setFriendUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.friendUid = str;
        }

        public final void setShowStatus(boolean z) {
            this.showStatus = z;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString = jsonData.optString("friend_uid");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.friendUid = strOptString;
            this.showStatus = jsonData.optBoolean("show_status");
        }

        public FriendsRequestParam(String friendUid, boolean z) {
            Intrinsics.checkNotNullParameter(friendUid, "friendUid");
            this.friendUid = friendUid;
            this.showStatus = z;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/hive/SocialHive$GuestGenerateParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", InAppPurchaseMetaData.KEY_SIGNATURE, "", "publicKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getSignature", "()Ljava/lang/String;", "setSignature", "(Ljava/lang/String;)V", "getPublicKey", "setPublicKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GuestGenerateParam extends DataModel {
        private String publicKey;
        private String signature;

        public GuestGenerateParam() {
            this.signature = "";
            this.publicKey = "";
        }

        public final String getPublicKey() {
            return this.publicKey;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final void setPublicKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.publicKey = str;
        }

        public final void setSignature(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.signature = str;
        }

        public GuestGenerateParam(String signature, String publicKey) {
            Intrinsics.checkNotNullParameter(signature, "signature");
            Intrinsics.checkNotNullParameter(publicKey, "publicKey");
            this.signature = signature;
            this.publicKey = publicKey;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/hive/SocialHive$UploadSaveDataParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "data", "", "hash", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getHash", "setHash", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UploadSaveDataParam extends DataModel {
        private String data;
        private String hash;

        public UploadSaveDataParam() {
            this.data = "";
            this.hash = "";
        }

        public final String getData() {
            return this.data;
        }

        public final String getHash() {
            return this.hash;
        }

        public final void setData(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.data = str;
        }

        public final void setHash(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.hash = str;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString = jsonData.optString("data");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.data = strOptString;
            String strOptString2 = jsonData.optString("hash");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.hash = strOptString2;
        }

        public UploadSaveDataParam(String data, String hash) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(hash, "hash");
            this.data = data;
            this.hash = hash;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/hive/SocialHive$GuestLoginParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "guestUid", "", InAppPurchaseMetaData.KEY_SIGNATURE, "publicKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGuestUid", "()Ljava/lang/String;", "setGuestUid", "(Ljava/lang/String;)V", "getSignature", "setSignature", "getPublicKey", "setPublicKey", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GuestLoginParam extends DataModel {
        private String guestUid;
        private String publicKey;
        private String signature;

        public GuestLoginParam() {
            this.guestUid = "";
            this.signature = "";
            this.publicKey = "";
        }

        public final String getGuestUid() {
            return this.guestUid;
        }

        public final String getPublicKey() {
            return this.publicKey;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final void setGuestUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.guestUid = str;
        }

        public final void setPublicKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.publicKey = str;
        }

        public final void setSignature(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.signature = str;
        }

        public GuestLoginParam(String guestUid, String signature, String publicKey) {
            Intrinsics.checkNotNullParameter(guestUid, "guestUid");
            Intrinsics.checkNotNullParameter(signature, "signature");
            Intrinsics.checkNotNullParameter(publicKey, "publicKey");
            this.guestUid = guestUid;
            this.signature = signature;
            this.publicKey = publicKey;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/hive/SocialHive$WallWriteParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "text", "", "picture", "videoLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getPicture", "setPicture", "getVideoLink", "setVideoLink", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WallWriteParam extends DataModel {
        private String picture;
        private String text;
        private String videoLink;

        public WallWriteParam() {
            this.text = "";
            this.picture = "";
            this.videoLink = "";
        }

        public final String getPicture() {
            return this.picture;
        }

        public final String getText() {
            return this.text;
        }

        public final String getVideoLink() {
            return this.videoLink;
        }

        public final void setPicture(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.picture = str;
        }

        public final void setText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        public final void setVideoLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.videoLink = str;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString = jsonData.optString("text");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.text = strOptString;
            String strOptString2 = jsonData.optString("picture");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.picture = strOptString2;
            String strOptString3 = jsonData.optString("video_link");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.videoLink = strOptString3;
        }

        public WallWriteParam(String text, String picture, String videoLink) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(picture, "picture");
            Intrinsics.checkNotNullParameter(videoLink, "videoLink");
            this.text = text;
            this.picture = picture;
            this.videoLink = videoLink;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/hive/SocialHive$FriendsFacebookRequestParam;", "Lcom/hive/base/DataModel;", "<init>", "()V", "token", "", "facebookAppId", NotificationCompat.CATEGORY_SERVICE, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getFacebookAppId", "setFacebookAppId", "getService", "setService", "getType", "setType", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FriendsFacebookRequestParam extends DataModel {
        private String facebookAppId;
        private String service;
        private String token;
        private String type;

        public FriendsFacebookRequestParam() {
            this.token = "";
            this.facebookAppId = "";
            this.service = "";
            this.type = "";
        }

        public final String getFacebookAppId() {
            return this.facebookAppId;
        }

        public final String getService() {
            return this.service;
        }

        public final String getToken() {
            return this.token;
        }

        public final String getType() {
            return this.type;
        }

        public final void setFacebookAppId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.facebookAppId = str;
        }

        public final void setService(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.service = str;
        }

        public final void setToken(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.token = str;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final void toDataModel(JSONObject jsonData) {
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString = jsonData.optString("token");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.token = strOptString;
            String strOptString2 = jsonData.optString(PangleConstants.APP_ID);
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.facebookAppId = strOptString2;
            String strOptString3 = jsonData.optString(NotificationCompat.CATEGORY_SERVICE);
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.service = strOptString3;
            String strOptString4 = jsonData.optString("type");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this.type = strOptString4;
        }

        public FriendsFacebookRequestParam(String token, String facebookAppId, String service, String type) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(facebookAppId, "facebookAppId");
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(type, "type");
            this.token = token;
            this.facebookAppId = facebookAppId;
            this.service = service;
            this.type = type;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B9\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0002\u0010\fBA\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0002\u0010\u000eJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006%"}, d2 = {"Lcom/hive/SocialHive$MessageContent;", "Lcom/hive/base/DataModel;", "<init>", "()V", "vid", "", "uid", "message", "imageUrl", "thumbnailUrl", "usePush", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", AppLovinEventTypes.USER_SENT_INVITATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "getUid", "setUid", "getMessage", "setMessage", "getImageUrl", "setImageUrl", "getThumbnailUrl", "setThumbnailUrl", "getUsePush", "()Z", "setUsePush", "(Z)V", "getInvite", "setInvite", "toDataModel", "", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageContent extends DataModel {
        private String imageUrl;
        private boolean invite;
        private String message;
        private String thumbnailUrl;
        private String uid;
        private boolean usePush;
        private String vid;

        public MessageContent() {
            this.vid = "";
            this.uid = "";
            this.message = "";
            this.imageUrl = "";
            this.thumbnailUrl = "";
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final boolean getInvite() {
            return this.invite;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getThumbnailUrl() {
            return this.thumbnailUrl;
        }

        public final String getUid() {
            return this.uid;
        }

        public final boolean getUsePush() {
            return this.usePush;
        }

        public final String getVid() {
            return this.vid;
        }

        public final void setImageUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imageUrl = str;
        }

        public final void setInvite(boolean z) {
            this.invite = z;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final void setThumbnailUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.thumbnailUrl = str;
        }

        public final void setUid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }

        public final void setUsePush(boolean z) {
            this.usePush = z;
        }

        public final void setVid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.vid = str;
        }

        public final void toDataModel(JSONObject jsonData) {
            String strOptString;
            Intrinsics.checkNotNullParameter(jsonData, "jsonData");
            String strOptString2 = jsonData.optString("uid");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.uid = strOptString2;
            String strOptString3 = jsonData.optString("text");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.message = strOptString3;
            String strOptString4 = "";
            if (jsonData.has("picture")) {
                strOptString = jsonData.optString("picture");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            } else {
                strOptString = "";
            }
            this.imageUrl = strOptString;
            if (jsonData.has("thumbnail")) {
                strOptString4 = jsonData.optString("thumbnail");
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            }
            this.thumbnailUrl = strOptString4;
            this.usePush = jsonData.has(Constants.PUSH) ? jsonData.optBoolean(Constants.PUSH) : false;
            this.invite = jsonData.has(AppLovinEventTypes.USER_SENT_INVITATION) ? jsonData.optBoolean(AppLovinEventTypes.USER_SENT_INVITATION) : false;
        }

        public MessageContent(String vid, String uid, String message, String imageUrl, String thumbnailUrl, boolean z) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
            this.vid = vid;
            this.uid = uid;
            this.message = message;
            this.imageUrl = imageUrl;
            this.thumbnailUrl = thumbnailUrl;
            this.usePush = z;
        }

        public MessageContent(String vid, String uid, String message, String imageUrl, String thumbnailUrl, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
            this.vid = vid;
            this.uid = uid;
            this.message = message;
            this.imageUrl = imageUrl;
            this.thumbnailUrl = thumbnailUrl;
            this.usePush = z;
            this.invite = z2;
        }
    }

    public final void showHiveDialog(HiveDialogType hiveDialogType, String vid, String additionalInfo, ShowHiveDialogListener listener) {
        Intrinsics.checkNotNullParameter(hiveDialogType, "hiveDialogType");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("vid = %s, listener = %s", Arrays.copyOf(new Object[]{vid, listener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        SocialHiveImpl.INSTANCE.showHiveDialog(hiveDialogType, vid, additionalInfo, listener);
        loggerImpl.apiReturnLog(str2, "");
    }
}
