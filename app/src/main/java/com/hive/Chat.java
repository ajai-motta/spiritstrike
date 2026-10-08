package com.hive;

import androidx.autofill.HintConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveChat;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\bÆ\u0002\u0018\u00002\u00020\u0001:<TUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001bH\u0007J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001cH\u0007J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020$H\u0007J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020&H\u0007J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020(H\u0007J\u0018\u0010)\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020*H\u0007J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0005H\u0007J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0005H\u0007J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0005H\u0007J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0005H\u0007J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0005H\u0007J\u0018\u00100\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u0002012\u0006\u0010\u0012\u001a\u000202H\u0007J\u001a\u00103\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u0001042\u0006\u0010\u0012\u001a\u000205H\u0007J\u0018\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u000208H\u0007J\u0018\u00109\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020:H\u0007J\u0018\u0010;\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020<H\u0007J\u0018\u0010=\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020>2\u0006\u0010\u0012\u001a\u00020?H\u0007J\u0018\u0010@\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020AH\u0007J\u0010\u0010B\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020CH\u0007J\u0010\u0010D\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020EH\u0007J\u0018\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020H2\u0006\u0010\u0012\u001a\u00020IH\u0007J\u0018\u0010J\u001a\u00020\u00102\u0006\u0010G\u001a\u00020H2\u0006\u0010\u0012\u001a\u00020KH\u0007J\u0018\u0010L\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020M2\u0006\u0010\u0012\u001a\u00020NH\u0007J\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020P2\u0006\u0010\u0012\u001a\u00020QH\u0007J\b\u0010R\u001a\u00020SH\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0088\u0001"}, d2 = {"Lcom/hive/Chat;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "hiveChat", "Lcom/hive/module/interfaces/HiveChat;", "getHiveChat", "()Lcom/hive/module/interfaces/HiveChat;", "hiveChat$delegate", "Lkotlin/Lazy;", "connect", "", "extraData", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Chat$ConnectListener;", "reconnect", "Lcom/hive/Chat$ReconnectListener;", "disconnect", "Lcom/hive/Chat$DisconnectListener;", "sendMessage", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/hive/Chat$ChannelSendMessageParams;", "Lcom/hive/Chat$ChannelSendMessageListener;", "Lcom/hive/Chat$DirectSendMessageParams;", "Lcom/hive/Chat$DirectSendMessageListener;", "isConnected", "", "addConnectionListener", "uniqueKey", "Lcom/hive/Chat$ConnectionListener;", "addChannelListener", "Lcom/hive/Chat$ChannelListener;", "addDirectMessageListener", "Lcom/hive/Chat$DirectMessageListener;", "addUserListener", "Lcom/hive/Chat$UserListener;", "addCustomDataListener", "Lcom/hive/Chat$CustomDataListener;", "removeConnectionListener", "removeChannelListener", "removeDirectMessageListener", "removeUserListener", "removeCustomDataListener", "createChannel", "Lcom/hive/Chat$CreateChannelParams;", "Lcom/hive/Chat$CreateChannelListener;", "getChannels", "Lcom/hive/Chat$GetChannelsParams;", "Lcom/hive/Chat$GetChannelsListener;", "getChannelInfo", "channelId", "Lcom/hive/Chat$GetChannelInfoListener;", "getChannelMembers", "Lcom/hive/Chat$GetChannelMembersListener;", "deleteChannel", "Lcom/hive/Chat$DeleteChannelListener;", "enterChannel", "Lcom/hive/Chat$EnterChannelParams;", "Lcom/hive/Chat$EnterChannelListener;", "exitChannel", "Lcom/hive/Chat$ExitChannelListener;", "getChannelsByUser", "Lcom/hive/Chat$GetChannelsByUserListener;", "getBlockMembers", "Lcom/hive/Chat$GetBlockMembersListener;", "blockMember", "blockPlayerId", "", "Lcom/hive/Chat$BlockMemberListener;", "unblockMember", "Lcom/hive/Chat$UnblockMemberListener;", "translate", "Lcom/hive/Chat$TranslateParams;", "Lcom/hive/Chat$TranslateListener;", "reportMessage", "Lcom/hive/Chat$ReportMessageParams;", "Lcom/hive/Chat$ReportMessageListener;", "getLibraryMissingError", "Lcom/hive/ResultAPI;", "ChannelType", "SortType", "ReactionType", "ReportReasonType", "ChannelSendMessageParams", "DirectSendMessageParams", "CreateChannelParams", "GetChannelsParams", "EnterChannelParams", "ChannelMessageListQueryParams", "TranslateParams", "ReportMessageParams", "Channel", "ChannelPage", "Member", "BlockMember", "ChannelMessageListQueryResponse", "TranslationData", "CreateChannelListener", "GetChannelsListener", "GetChannelInfoListener", "GetChannelMembersListener", "DeleteChannelListener", "EnterChannelListener", "ExitChannelListener", "GetChannelsByUserListener", "GetBlockMembersListener", "BlockMemberListener", "UnblockMemberListener", "ConnectListener", "ReconnectListener", "DisconnectListener", "ChannelSendMessageListener", "DirectSendMessageListener", "ChannelMessageListQueryListener", "ChannelTranslationSettingListener", "TranslateListener", "ReactionListener", "ReportMessageListener", "EnteredMember", "ExitedMember", "DeletedChannel", "ChannelNoticeMessage", "ChannelMessage", "DirectMessage", "NoticeMessage", "Reaction", "ConnectionListener", "ChannelListener", "DirectMessageListener", "UserListener", "CustomDataListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Chat {
    public static final Chat INSTANCE = new Chat();
    private static final String TAG;

    /* JADX INFO: renamed from: hiveChat$delegate, reason: from kotlin metadata */
    private static final Lazy hiveChat;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/hive/Chat$BlockMember;", "", "playerId", "", "blockedTime", "", "blockedTimeMillis", "<init>", "(JLjava/lang/String;J)V", "getPlayerId", "()J", "getBlockedTime", "()Ljava/lang/String;", "getBlockedTimeMillis", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class BlockMember {
        private final String blockedTime;
        private final long blockedTimeMillis;
        private final long playerId;

        public BlockMember(long j, String blockedTime, long j2) {
            Intrinsics.checkNotNullParameter(blockedTime, "blockedTime");
            this.playerId = j;
            this.blockedTime = blockedTime;
            this.blockedTimeMillis = j2;
        }

        public static /* synthetic */ BlockMember copy$default(BlockMember blockMember, long j, String str, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = blockMember.playerId;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                str = blockMember.blockedTime;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                j2 = blockMember.blockedTimeMillis;
            }
            return blockMember.copy(j3, str2, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPlayerId() {
            return this.playerId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getBlockedTime() {
            return this.blockedTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getBlockedTimeMillis() {
            return this.blockedTimeMillis;
        }

        public final BlockMember copy(long playerId, String blockedTime, long blockedTimeMillis) {
            Intrinsics.checkNotNullParameter(blockedTime, "blockedTime");
            return new BlockMember(playerId, blockedTime, blockedTimeMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlockMember)) {
                return false;
            }
            BlockMember blockMember = (BlockMember) other;
            return this.playerId == blockMember.playerId && Intrinsics.areEqual(this.blockedTime, blockMember.blockedTime) && this.blockedTimeMillis == blockMember.blockedTimeMillis;
        }

        public final String getBlockedTime() {
            return this.blockedTime;
        }

        public final long getBlockedTimeMillis() {
            return this.blockedTimeMillis;
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public int hashCode() {
            return (((UByte$$ExternalSyntheticBackport0.m(this.playerId) * 31) + this.blockedTime.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.blockedTimeMillis);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playerId", this.playerId);
                jSONObject.put("blockedTime", this.blockedTime);
                jSONObject.put("blockedTimeMillis", this.blockedTimeMillis);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("BlockMember toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "BlockMember(playerId=" + this.playerId + ", blockedTime=" + this.blockedTime + ", blockedTimeMillis=" + this.blockedTimeMillis + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$BlockMemberListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface BlockMemberListener {
        void onResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/hive/Chat$ChannelListener;", "", "onEnteredMember", "", "member", "Lcom/hive/Chat$EnteredMember;", "onExitedMember", "Lcom/hive/Chat$ExitedMember;", "onDeletedChannel", "channel", "Lcom/hive/Chat$DeletedChannel;", "onNoticeMessage", "message", "Lcom/hive/Chat$ChannelNoticeMessage;", "onChannelMessage", "Lcom/hive/Chat$ChannelMessage;", "onAddReaction", "reaction", "Lcom/hive/Chat$Reaction;", "onRemoveReaction", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ChannelListener {
        void onAddReaction(Reaction reaction);

        void onChannelMessage(ChannelMessage message);

        void onDeletedChannel(DeletedChannel channel);

        void onEnteredMember(EnteredMember member);

        void onExitedMember(ExitedMember member);

        void onNoticeMessage(ChannelNoticeMessage message);

        void onRemoveReaction(Reaction reaction);
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0013\u0012H\b\u0002\u0010\u0014\u001aB\u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u0013\u0018\u00010\u0015j \u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u0013\u0018\u0001`\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010-\u001a\u00020.J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0013HÆ\u0003JI\u0010<\u001aB\u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u0013\u0018\u00010\u0015j \u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u0013\u0018\u0001`\u0017HÆ\u0003Jï\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00132H\b\u0002\u0010\u0014\u001aB\u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u0013\u0018\u00010\u0015j \u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u0013\u0018\u0001`\u0017HÆ\u0001J\u0013\u0010>\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR%\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*RQ\u0010\u0014\u001aB\u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u0013\u0018\u00010\u0015j \u0012\u0004\u0012\u00020\u0016\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0012j\b\u0012\u0004\u0012\u00020\u0005`\u0013\u0018\u0001`\u0017¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006C"}, d2 = {"Lcom/hive/Chat$ChannelMessage;", "", "messageId", "", "from", "", "to", "message", "translated", "", "translatedMessage", "extraData", "timestamp", "timestampMillis", "replyMessageId", "replyMessage", "replyExtraData", "mentionedPlayerIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reactions", "Ljava/util/HashMap;", "Lcom/hive/Chat$ReactionType;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;)V", "getMessageId", "()Ljava/lang/String;", "getFrom", "()J", "getTo", "getMessage", "getTranslated", "()Z", "getTranslatedMessage", "getExtraData", "getTimestamp", "getTimestampMillis", "getReplyMessageId", "getReplyMessage", "getReplyExtraData", "getMentionedPlayerIds", "()Ljava/util/ArrayList;", "getReactions", "()Ljava/util/HashMap;", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ChannelMessage {
        private final String extraData;
        private final long from;
        private final ArrayList<Long> mentionedPlayerIds;
        private final String message;
        private final String messageId;
        private final HashMap<ReactionType, ArrayList<Long>> reactions;
        private final String replyExtraData;
        private final String replyMessage;
        private final String replyMessageId;
        private final String timestamp;
        private final long timestampMillis;
        private final String to;
        private final boolean translated;
        private final String translatedMessage;

        public ChannelMessage() {
            this(null, 0L, null, null, false, null, null, null, 0L, null, null, null, null, null, 16383, null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getReplyMessageId() {
            return this.replyMessageId;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getReplyMessage() {
            return this.replyMessage;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getReplyExtraData() {
            return this.replyExtraData;
        }

        public final ArrayList<Long> component13() {
            return this.mentionedPlayerIds;
        }

        public final HashMap<ReactionType, ArrayList<Long>> component14() {
            return this.reactions;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTo() {
            return this.to;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getTranslated() {
            return this.translated;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getTranslatedMessage() {
            return this.translatedMessage;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getExtraData() {
            return this.extraData;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final ChannelMessage copy(String messageId, long from, String to, String message, boolean translated, String translatedMessage, String extraData, String timestamp, long timestampMillis, String replyMessageId, String replyMessage, String replyExtraData, ArrayList<Long> mentionedPlayerIds, HashMap<ReactionType, ArrayList<Long>> reactions) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(to, "to");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(translatedMessage, "translatedMessage");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            return new ChannelMessage(messageId, from, to, message, translated, translatedMessage, extraData, timestamp, timestampMillis, replyMessageId, replyMessage, replyExtraData, mentionedPlayerIds, reactions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelMessage)) {
                return false;
            }
            ChannelMessage channelMessage = (ChannelMessage) other;
            return Intrinsics.areEqual(this.messageId, channelMessage.messageId) && this.from == channelMessage.from && Intrinsics.areEqual(this.to, channelMessage.to) && Intrinsics.areEqual(this.message, channelMessage.message) && this.translated == channelMessage.translated && Intrinsics.areEqual(this.translatedMessage, channelMessage.translatedMessage) && Intrinsics.areEqual(this.extraData, channelMessage.extraData) && Intrinsics.areEqual(this.timestamp, channelMessage.timestamp) && this.timestampMillis == channelMessage.timestampMillis && Intrinsics.areEqual(this.replyMessageId, channelMessage.replyMessageId) && Intrinsics.areEqual(this.replyMessage, channelMessage.replyMessage) && Intrinsics.areEqual(this.replyExtraData, channelMessage.replyExtraData) && Intrinsics.areEqual(this.mentionedPlayerIds, channelMessage.mentionedPlayerIds) && Intrinsics.areEqual(this.reactions, channelMessage.reactions);
        }

        public final String getExtraData() {
            return this.extraData;
        }

        public final long getFrom() {
            return this.from;
        }

        public final ArrayList<Long> getMentionedPlayerIds() {
            return this.mentionedPlayerIds;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final HashMap<ReactionType, ArrayList<Long>> getReactions() {
            return this.reactions;
        }

        public final String getReplyExtraData() {
            return this.replyExtraData;
        }

        public final String getReplyMessage() {
            return this.replyMessage;
        }

        public final String getReplyMessageId() {
            return this.replyMessageId;
        }

        public final String getTimestamp() {
            return this.timestamp;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final String getTo() {
            return this.to;
        }

        public final boolean getTranslated() {
            return this.translated;
        }

        public final String getTranslatedMessage() {
            return this.translatedMessage;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((this.messageId.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.from)) * 31) + this.to.hashCode()) * 31) + this.message.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.translated)) * 31) + this.translatedMessage.hashCode()) * 31) + this.extraData.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestampMillis)) * 31;
            String str = this.replyMessageId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.replyMessage;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.replyExtraData;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            ArrayList<Long> arrayList = this.mentionedPlayerIds;
            int iHashCode5 = (iHashCode4 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
            HashMap<ReactionType, ArrayList<Long>> map = this.reactions;
            return iHashCode5 + (map != null ? map.hashCode() : 0);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("messageId", this.messageId);
                jSONObject.put("from", this.from);
                jSONObject.put("to", this.to);
                jSONObject.put("message", this.message);
                jSONObject.put("translated", this.translated);
                jSONObject.put("translatedMessage", this.translatedMessage);
                jSONObject.put("extraData", this.extraData);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put("timestampMillis", this.timestampMillis);
                String str = this.replyMessageId;
                if (str != null) {
                    jSONObject.put("replyMessageId", str);
                }
                String str2 = this.replyMessage;
                if (str2 != null) {
                    jSONObject.put("replyMessage", str2);
                }
                String str3 = this.replyExtraData;
                if (str3 != null) {
                    jSONObject.put("replyExtraData", str3);
                }
                ArrayList<Long> arrayList = this.mentionedPlayerIds;
                if (arrayList != null) {
                    jSONObject.put("mentionedPlayerIds", new JSONArray((Collection) arrayList));
                }
                HashMap<ReactionType, ArrayList<Long>> map = this.reactions;
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<ReactionType, ArrayList<Long>> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey().name(), new JSONArray((Collection) entry.getValue()));
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.put("reactions", jSONObject2);
                        return jSONObject;
                    }
                }
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("ChannelMessage toJSON(e: " + e.getMessage() + ')');
            }
            return jSONObject;
        }

        public String toString() {
            return "ChannelMessage(messageId=" + this.messageId + ", from=" + this.from + ", to=" + this.to + ", message=" + this.message + ", translated=" + this.translated + ", translatedMessage=" + this.translatedMessage + ", extraData=" + this.extraData + ", timestamp=" + this.timestamp + ", timestampMillis=" + this.timestampMillis + ", replyMessageId=" + this.replyMessageId + ", replyMessage=" + this.replyMessage + ", replyExtraData=" + this.replyExtraData + ", mentionedPlayerIds=" + this.mentionedPlayerIds + ", reactions=" + this.reactions + ')';
        }

        public ChannelMessage(String messageId, long j, String to, String message, boolean z, String translatedMessage, String extraData, String timestamp, long j2, String str, String str2, String str3, ArrayList<Long> arrayList, HashMap<ReactionType, ArrayList<Long>> map) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(to, "to");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(translatedMessage, "translatedMessage");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.messageId = messageId;
            this.from = j;
            this.to = to;
            this.message = message;
            this.translated = z;
            this.translatedMessage = translatedMessage;
            this.extraData = extraData;
            this.timestamp = timestamp;
            this.timestampMillis = j2;
            this.replyMessageId = str;
            this.replyMessage = str2;
            this.replyExtraData = str3;
            this.mentionedPlayerIds = arrayList;
            this.reactions = map;
        }

        public /* synthetic */ ChannelMessage(String str, long j, String str2, String str3, boolean z, String str4, String str5, String str6, long j2, String str7, String str8, String str9, ArrayList arrayList, HashMap map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5, (i & 128) == 0 ? str6 : "", (i & 256) == 0 ? j2 : 0L, (i & 512) != 0 ? null : str7, (i & 1024) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? null : arrayList, (i & 8192) != 0 ? null : map);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Chat$ChannelMessageListQueryListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "response", "Lcom/hive/Chat$ChannelMessageListQueryResponse;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ChannelMessageListQueryListener {
        void onResult(ResultAPI result, ChannelMessageListQueryResponse response);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/hive/Chat$ChannelMessageListQueryParams;", "", "prevSize", "", "nextSize", "messageId", "", "order", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getPrevSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNextSize", "getMessageId", "()Ljava/lang/String;", "getOrder", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/hive/Chat$ChannelMessageListQueryParams;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ChannelMessageListQueryParams {
        private final String messageId;
        private final Integer nextSize;
        private final String order;
        private final Integer prevSize;

        public ChannelMessageListQueryParams() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ ChannelMessageListQueryParams copy$default(ChannelMessageListQueryParams channelMessageListQueryParams, Integer num, Integer num2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = channelMessageListQueryParams.prevSize;
            }
            if ((i & 2) != 0) {
                num2 = channelMessageListQueryParams.nextSize;
            }
            if ((i & 4) != 0) {
                str = channelMessageListQueryParams.messageId;
            }
            if ((i & 8) != 0) {
                str2 = channelMessageListQueryParams.order;
            }
            return channelMessageListQueryParams.copy(num, num2, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getPrevSize() {
            return this.prevSize;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getNextSize() {
            return this.nextSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOrder() {
            return this.order;
        }

        public final ChannelMessageListQueryParams copy(Integer prevSize, Integer nextSize, String messageId, String order) {
            return new ChannelMessageListQueryParams(prevSize, nextSize, messageId, order);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelMessageListQueryParams)) {
                return false;
            }
            ChannelMessageListQueryParams channelMessageListQueryParams = (ChannelMessageListQueryParams) other;
            return Intrinsics.areEqual(this.prevSize, channelMessageListQueryParams.prevSize) && Intrinsics.areEqual(this.nextSize, channelMessageListQueryParams.nextSize) && Intrinsics.areEqual(this.messageId, channelMessageListQueryParams.messageId) && Intrinsics.areEqual(this.order, channelMessageListQueryParams.order);
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final Integer getNextSize() {
            return this.nextSize;
        }

        public final String getOrder() {
            return this.order;
        }

        public final Integer getPrevSize() {
            return this.prevSize;
        }

        public int hashCode() {
            Integer num = this.prevSize;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.nextSize;
            int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.messageId;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.order;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ChannelMessageListQueryParams(prevSize=" + this.prevSize + ", nextSize=" + this.nextSize + ", messageId=" + this.messageId + ", order=" + this.order + ')';
        }

        public ChannelMessageListQueryParams(Integer num, Integer num2, String str, String str2) {
            this.prevSize = num;
            this.nextSize = num2;
            this.messageId = str;
            this.order = str2;
        }

        public /* synthetic */ ChannelMessageListQueryParams(Integer num, Integer num2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ChannelMessageListQueryParams(JSONObject jsonObject) {
            this(jsonObject.has("prevSize") ? Integer.valueOf(jsonObject.optInt("prevSize", -1)) : null, jsonObject.has("nextSize") ? Integer.valueOf(jsonObject.optInt("nextSize", -1)) : null, ExtentionsKt.optStringOrNull(jsonObject, "messageId"), ExtentionsKt.optStringOrNull(jsonObject, "order"));
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/hive/Chat$ChannelMessageListQueryResponse;", "", "hasNext", "", "nextMessageId", "", "hasPrev", "prevMessageId", "content", "Ljava/util/ArrayList;", "Lcom/hive/Chat$ChannelMessage;", "Lkotlin/collections/ArrayList;", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;Ljava/util/ArrayList;)V", "getHasNext", "()Z", "getNextMessageId", "()Ljava/lang/String;", "getHasPrev", "getPrevMessageId", "getContent", "()Ljava/util/ArrayList;", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ChannelMessageListQueryResponse {
        private final ArrayList<ChannelMessage> content;
        private final boolean hasNext;
        private final boolean hasPrev;
        private final String nextMessageId;
        private final String prevMessageId;

        public ChannelMessageListQueryResponse(boolean z, String nextMessageId, boolean z2, String prevMessageId, ArrayList<ChannelMessage> content) {
            Intrinsics.checkNotNullParameter(nextMessageId, "nextMessageId");
            Intrinsics.checkNotNullParameter(prevMessageId, "prevMessageId");
            Intrinsics.checkNotNullParameter(content, "content");
            this.hasNext = z;
            this.nextMessageId = nextMessageId;
            this.hasPrev = z2;
            this.prevMessageId = prevMessageId;
            this.content = content;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelMessageListQueryResponse copy$default(ChannelMessageListQueryResponse channelMessageListQueryResponse, boolean z, String str, boolean z2, String str2, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                z = channelMessageListQueryResponse.hasNext;
            }
            if ((i & 2) != 0) {
                str = channelMessageListQueryResponse.nextMessageId;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                z2 = channelMessageListQueryResponse.hasPrev;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                str2 = channelMessageListQueryResponse.prevMessageId;
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                arrayList = channelMessageListQueryResponse.content;
            }
            return channelMessageListQueryResponse.copy(z, str3, z3, str4, arrayList);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getHasNext() {
            return this.hasNext;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNextMessageId() {
            return this.nextMessageId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getHasPrev() {
            return this.hasPrev;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPrevMessageId() {
            return this.prevMessageId;
        }

        public final ArrayList<ChannelMessage> component5() {
            return this.content;
        }

        public final ChannelMessageListQueryResponse copy(boolean hasNext, String nextMessageId, boolean hasPrev, String prevMessageId, ArrayList<ChannelMessage> content) {
            Intrinsics.checkNotNullParameter(nextMessageId, "nextMessageId");
            Intrinsics.checkNotNullParameter(prevMessageId, "prevMessageId");
            Intrinsics.checkNotNullParameter(content, "content");
            return new ChannelMessageListQueryResponse(hasNext, nextMessageId, hasPrev, prevMessageId, content);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelMessageListQueryResponse)) {
                return false;
            }
            ChannelMessageListQueryResponse channelMessageListQueryResponse = (ChannelMessageListQueryResponse) other;
            return this.hasNext == channelMessageListQueryResponse.hasNext && Intrinsics.areEqual(this.nextMessageId, channelMessageListQueryResponse.nextMessageId) && this.hasPrev == channelMessageListQueryResponse.hasPrev && Intrinsics.areEqual(this.prevMessageId, channelMessageListQueryResponse.prevMessageId) && Intrinsics.areEqual(this.content, channelMessageListQueryResponse.content);
        }

        public final ArrayList<ChannelMessage> getContent() {
            return this.content;
        }

        public final boolean getHasNext() {
            return this.hasNext;
        }

        public final boolean getHasPrev() {
            return this.hasPrev;
        }

        public final String getNextMessageId() {
            return this.nextMessageId;
        }

        public final String getPrevMessageId() {
            return this.prevMessageId;
        }

        public int hashCode() {
            return (((((((UByte$$ExternalSyntheticBackport0.m(this.hasNext) * 31) + this.nextMessageId.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.hasPrev)) * 31) + this.prevMessageId.hashCode()) * 31) + this.content.hashCode();
        }

        public final JSONObject toJSON() throws JSONException {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = this.content.iterator();
            while (it.hasNext()) {
                jSONArray.put(((ChannelMessage) it.next()).toJSON());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hasNext", this.hasNext);
            jSONObject.put("nextMessageId", this.nextMessageId);
            jSONObject.put("hasPrev", this.hasPrev);
            jSONObject.put("prevMessageId", this.prevMessageId);
            jSONObject.put("content", jSONArray);
            return jSONObject;
        }

        public String toString() {
            return "ChannelMessageListQueryResponse(hasNext=" + this.hasNext + ", nextMessageId=" + this.nextMessageId + ", hasPrev=" + this.hasPrev + ", prevMessageId=" + this.prevMessageId + ", content=" + this.content + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/hive/Chat$ChannelNoticeMessage;", "", "channelId", "", "from", "message", "timestamp", "timestampMillis", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getChannelId", "()Ljava/lang/String;", "getFrom", "getMessage", "getTimestamp", "getTimestampMillis", "()J", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ChannelNoticeMessage {
        private final String channelId;
        private final String from;
        private final String message;
        private final String timestamp;
        private final long timestampMillis;

        public ChannelNoticeMessage() {
            this(null, null, null, null, 0L, 31, null);
        }

        public static /* synthetic */ ChannelNoticeMessage copy$default(ChannelNoticeMessage channelNoticeMessage, String str, String str2, String str3, String str4, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelNoticeMessage.channelId;
            }
            if ((i & 2) != 0) {
                str2 = channelNoticeMessage.from;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = channelNoticeMessage.message;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = channelNoticeMessage.timestamp;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                j = channelNoticeMessage.timestampMillis;
            }
            return channelNoticeMessage.copy(str, str5, str6, str7, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final ChannelNoticeMessage copy(String channelId, String from, String message, String timestamp, long timestampMillis) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            return new ChannelNoticeMessage(channelId, from, message, timestamp, timestampMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelNoticeMessage)) {
                return false;
            }
            ChannelNoticeMessage channelNoticeMessage = (ChannelNoticeMessage) other;
            return Intrinsics.areEqual(this.channelId, channelNoticeMessage.channelId) && Intrinsics.areEqual(this.from, channelNoticeMessage.from) && Intrinsics.areEqual(this.message, channelNoticeMessage.message) && Intrinsics.areEqual(this.timestamp, channelNoticeMessage.timestamp) && this.timestampMillis == channelNoticeMessage.timestampMillis;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTimestamp() {
            return this.timestamp;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public int hashCode() {
            return (((((((this.channelId.hashCode() * 31) + this.from.hashCode()) * 31) + this.message.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestampMillis);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channelId", this.channelId);
                jSONObject.put("from", this.from);
                jSONObject.put("message", this.message);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put("timestampMillis", this.timestampMillis);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("ChannelNoticeMessage toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "ChannelNoticeMessage(channelId=" + this.channelId + ", from=" + this.from + ", message=" + this.message + ", timestamp=" + this.timestamp + ", timestampMillis=" + this.timestampMillis + ')';
        }

        public ChannelNoticeMessage(String channelId, String from, String message, String timestamp, long j) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.channelId = channelId;
            this.from = from;
            this.message = message;
            this.timestamp = timestamp;
            this.timestampMillis = j;
        }

        public /* synthetic */ ChannelNoticeMessage(String str, String str2, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? 0L : j);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/hive/Chat$ChannelPage;", "", ContentDisposition.Parameters.Size, "", "currentPage", "totalElements", "totalPages", "<init>", "(IIII)V", "getSize", "()I", "getCurrentPage", "getTotalElements", "getTotalPages", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ChannelPage {
        private final int currentPage;
        private final int size;
        private final int totalElements;
        private final int totalPages;

        public ChannelPage(int i, int i2, int i3, int i4) {
            this.size = i;
            this.currentPage = i2;
            this.totalElements = i3;
            this.totalPages = i4;
        }

        public static /* synthetic */ ChannelPage copy$default(ChannelPage channelPage, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = channelPage.size;
            }
            if ((i5 & 2) != 0) {
                i2 = channelPage.currentPage;
            }
            if ((i5 & 4) != 0) {
                i3 = channelPage.totalElements;
            }
            if ((i5 & 8) != 0) {
                i4 = channelPage.totalPages;
            }
            return channelPage.copy(i, i2, i3, i4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCurrentPage() {
            return this.currentPage;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTotalElements() {
            return this.totalElements;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getTotalPages() {
            return this.totalPages;
        }

        public final ChannelPage copy(int size, int currentPage, int totalElements, int totalPages) {
            return new ChannelPage(size, currentPage, totalElements, totalPages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelPage)) {
                return false;
            }
            ChannelPage channelPage = (ChannelPage) other;
            return this.size == channelPage.size && this.currentPage == channelPage.currentPage && this.totalElements == channelPage.totalElements && this.totalPages == channelPage.totalPages;
        }

        public final int getCurrentPage() {
            return this.currentPage;
        }

        public final int getSize() {
            return this.size;
        }

        public final int getTotalElements() {
            return this.totalElements;
        }

        public final int getTotalPages() {
            return this.totalPages;
        }

        public int hashCode() {
            return (((((this.size * 31) + this.currentPage) * 31) + this.totalElements) * 31) + this.totalPages;
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContentDisposition.Parameters.Size, this.size);
                jSONObject.put("currentPage", this.currentPage);
                jSONObject.put("totalElements", this.totalElements);
                jSONObject.put("totalPages", this.totalPages);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("ChannelPage toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "ChannelPage(size=" + this.size + ", currentPage=" + this.currentPage + ", totalElements=" + this.totalElements + ", totalPages=" + this.totalPages + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Chat$ChannelSendMessageListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "retryPrams", "Lcom/hive/Chat$ChannelSendMessageParams;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ChannelSendMessageListener {
        void onResult(ResultAPI result, ChannelSendMessageParams retryPrams);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$ChannelTranslationSettingListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ChannelTranslationSettingListener {
        void onResult(ResultAPI result);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/hive/Chat$ChannelType;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVATE", "PUBLIC", "GROUP", "ONE_ON_ONE", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChannelType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ChannelType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ChannelType PRIVATE = new ChannelType("PRIVATE", 0);
        public static final ChannelType PUBLIC = new ChannelType("PUBLIC", 1);
        public static final ChannelType GROUP = new ChannelType("GROUP", 2);
        public static final ChannelType ONE_ON_ONE = new ChannelType("ONE_ON_ONE", 3);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\n"}, d2 = {"Lcom/hive/Chat$ChannelType$Companion;", "", "<init>", "()V", "getValueOrDefault", "Lcom/hive/Chat$ChannelType;", "name", "", "fallback", "getValue", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ ChannelType getValueOrDefault$default(Companion companion, String str, ChannelType channelType, int i, Object obj) {
                if ((i & 2) != 0) {
                    channelType = ChannelType.PUBLIC;
                }
                return companion.getValueOrDefault(str, channelType);
            }

            @JvmStatic
            public final ChannelType getValue(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                try {
                    return ChannelType.valueOf(name);
                } catch (Exception unused) {
                    return null;
                }
            }

            @JvmStatic
            public final ChannelType getValueOrDefault(String name, ChannelType fallback) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(fallback, "fallback");
                try {
                    return ChannelType.valueOf(name);
                } catch (Exception unused) {
                    return fallback;
                }
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ ChannelType[] $values() {
            return new ChannelType[]{PRIVATE, PUBLIC, GROUP, ONE_ON_ONE};
        }

        static {
            ChannelType[] channelTypeArr$values = $values();
            $VALUES = channelTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(channelTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private ChannelType(String str, int i) {
        }

        public static EnumEntries<ChannelType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final ChannelType getValue(String str) {
            return INSTANCE.getValue(str);
        }

        @JvmStatic
        public static final ChannelType getValueOrDefault(String str, ChannelType channelType) {
            return INSTANCE.getValueOrDefault(str, channelType);
        }

        public static ChannelType valueOf(String str) {
            return (ChannelType) Enum.valueOf(ChannelType.class, str);
        }

        public static ChannelType[] values() {
            return (ChannelType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$ConnectListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ConnectListener {
        void onResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J@\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/hive/Chat$ConnectionListener;", "", "onConnected", "", "onReconnectStarted", "onReconnected", "result", "Lcom/hive/ResultAPI;", "channelIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "failChannelIds", "onDisconnected", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ConnectionListener {
        void onConnected();

        void onDisconnected();

        void onReconnectStarted();

        void onReconnected(ResultAPI result, ArrayList<String> channelIds, ArrayList<String> failChannelIds);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$CreateChannelListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CreateChannelListener {
        void onResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$CustomDataListener;", "", "onCustomData", "", "data", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CustomDataListener {
        void onCustomData(String data);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$DeleteChannelListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DeleteChannelListener {
        void onResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/hive/Chat$DeletedChannel;", "", "channelId", "", "timestamp", "timestampMillis", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getChannelId", "()Ljava/lang/String;", "getTimestamp", "getTimestampMillis", "()J", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class DeletedChannel {
        private final String channelId;
        private final String timestamp;
        private final long timestampMillis;

        public DeletedChannel() {
            this(null, null, 0L, 7, null);
        }

        public static /* synthetic */ DeletedChannel copy$default(DeletedChannel deletedChannel, String str, String str2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deletedChannel.channelId;
            }
            if ((i & 2) != 0) {
                str2 = deletedChannel.timestamp;
            }
            if ((i & 4) != 0) {
                j = deletedChannel.timestampMillis;
            }
            return deletedChannel.copy(str, str2, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final DeletedChannel copy(String channelId, String timestamp, long timestampMillis) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            return new DeletedChannel(channelId, timestamp, timestampMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeletedChannel)) {
                return false;
            }
            DeletedChannel deletedChannel = (DeletedChannel) other;
            return Intrinsics.areEqual(this.channelId, deletedChannel.channelId) && Intrinsics.areEqual(this.timestamp, deletedChannel.timestamp) && this.timestampMillis == deletedChannel.timestampMillis;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getTimestamp() {
            return this.timestamp;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public int hashCode() {
            return (((this.channelId.hashCode() * 31) + this.timestamp.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestampMillis);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channelId", this.channelId);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put("timestampMillis", this.timestampMillis);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("DeletedChannel toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "DeletedChannel(channelId=" + this.channelId + ", timestamp=" + this.timestamp + ", timestampMillis=" + this.timestampMillis + ')';
        }

        public DeletedChannel(String channelId, String timestamp, long j) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.channelId = channelId;
            this.timestamp = timestamp;
            this.timestampMillis = j;
        }

        public /* synthetic */ DeletedChannel(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : j);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006&"}, d2 = {"Lcom/hive/Chat$DirectMessage;", "", "messageId", "", "from", "", "to", "message", "extraData", "timestamp", "timestampMillis", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getMessageId", "()Ljava/lang/String;", "getFrom", "()J", "getTo", "getMessage", "getExtraData", "getTimestamp", "getTimestampMillis", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class DirectMessage {
        private final String extraData;
        private final long from;
        private final String message;
        private final String messageId;
        private final String timestamp;
        private final long timestampMillis;
        private final long to;

        public DirectMessage() {
            this(null, 0L, 0L, null, null, null, 0L, 127, null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getTo() {
            return this.to;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getExtraData() {
            return this.extraData;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final DirectMessage copy(String messageId, long from, long to, String message, String extraData, String timestamp, long timestampMillis) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            return new DirectMessage(messageId, from, to, message, extraData, timestamp, timestampMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DirectMessage)) {
                return false;
            }
            DirectMessage directMessage = (DirectMessage) other;
            return Intrinsics.areEqual(this.messageId, directMessage.messageId) && this.from == directMessage.from && this.to == directMessage.to && Intrinsics.areEqual(this.message, directMessage.message) && Intrinsics.areEqual(this.extraData, directMessage.extraData) && Intrinsics.areEqual(this.timestamp, directMessage.timestamp) && this.timestampMillis == directMessage.timestampMillis;
        }

        public final String getExtraData() {
            return this.extraData;
        }

        public final long getFrom() {
            return this.from;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final String getTimestamp() {
            return this.timestamp;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final long getTo() {
            return this.to;
        }

        public int hashCode() {
            return (((((((((((this.messageId.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.from)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.to)) * 31) + this.message.hashCode()) * 31) + this.extraData.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestampMillis);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("messageId", this.messageId);
                jSONObject.put("from", this.from);
                jSONObject.put("to", this.to);
                jSONObject.put("message", this.message);
                jSONObject.put("extraData", this.extraData);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put("timestampMillis", this.timestampMillis);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("DirectMessage toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "DirectMessage(messageId=" + this.messageId + ", from=" + this.from + ", to=" + this.to + ", message=" + this.message + ", extraData=" + this.extraData + ", timestamp=" + this.timestamp + ", timestampMillis=" + this.timestampMillis + ')';
        }

        public DirectMessage(String messageId, long j, long j2, String message, String extraData, String timestamp, long j3) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(extraData, "extraData");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.messageId = messageId;
            this.from = j;
            this.to = j2;
            this.message = message;
            this.extraData = extraData;
            this.timestamp = timestamp;
            this.timestampMillis = j3;
        }

        public /* synthetic */ DirectMessage(String str, long j, long j2, String str2, String str3, String str4, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) == 0 ? str4 : "", (i & 64) == 0 ? j3 : 0L);
        }
    }

    @Deprecated(message = "This interface is no longer used. Please use [UserListener] instead")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$DirectMessageListener;", "", "onDirectMessage", "", "message", "Lcom/hive/Chat$DirectMessage;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DirectMessageListener {
        void onDirectMessage(DirectMessage message);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Chat$DirectSendMessageListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "retryPrams", "Lcom/hive/Chat$DirectSendMessageParams;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DirectSendMessageListener {
        void onResult(ResultAPI result, DirectSendMessageParams retryPrams);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$DisconnectListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DisconnectListener {
        void onResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$EnterChannelListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface EnterChannelListener {
        void onResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/hive/Chat$EnteredMember;", "", "channelId", "", "playerId", "", "timestamp", "timestampMillis", "<init>", "(Ljava/lang/String;JLjava/lang/String;J)V", "getChannelId", "()Ljava/lang/String;", "getPlayerId", "()J", "getTimestamp", "getTimestampMillis", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class EnteredMember {
        private final String channelId;
        private final long playerId;
        private final String timestamp;
        private final long timestampMillis;

        public EnteredMember() {
            this(null, 0L, null, 0L, 15, null);
        }

        public static /* synthetic */ EnteredMember copy$default(EnteredMember enteredMember, String str, long j, String str2, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = enteredMember.channelId;
            }
            if ((i & 2) != 0) {
                j = enteredMember.playerId;
            }
            long j3 = j;
            if ((i & 4) != 0) {
                str2 = enteredMember.timestamp;
            }
            String str3 = str2;
            if ((i & 8) != 0) {
                j2 = enteredMember.timestampMillis;
            }
            return enteredMember.copy(str, j3, str3, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getPlayerId() {
            return this.playerId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final EnteredMember copy(String channelId, long playerId, String timestamp, long timestampMillis) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            return new EnteredMember(channelId, playerId, timestamp, timestampMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EnteredMember)) {
                return false;
            }
            EnteredMember enteredMember = (EnteredMember) other;
            return Intrinsics.areEqual(this.channelId, enteredMember.channelId) && this.playerId == enteredMember.playerId && Intrinsics.areEqual(this.timestamp, enteredMember.timestamp) && this.timestampMillis == enteredMember.timestampMillis;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public final String getTimestamp() {
            return this.timestamp;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public int hashCode() {
            return (((((this.channelId.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.playerId)) * 31) + this.timestamp.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestampMillis);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channelId", this.channelId);
                jSONObject.put("playerId", this.playerId);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put("timestampMillis", this.timestampMillis);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("EnteredMember toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "EnteredMember(channelId=" + this.channelId + ", playerId=" + this.playerId + ", timestamp=" + this.timestamp + ", timestampMillis=" + this.timestampMillis + ')';
        }

        public EnteredMember(String channelId, long j, String timestamp, long j2) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.channelId = channelId;
            this.playerId = j;
            this.timestamp = timestamp;
            this.timestampMillis = j2;
        }

        public /* synthetic */ EnteredMember(String str, long j, String str2, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) == 0 ? str2 : "", (i & 8) != 0 ? 0L : j2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$ExitChannelListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ExitChannelListener {
        void onResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/hive/Chat$ExitedMember;", "", "channelId", "", "playerId", "", "timestamp", "timestampMillis", "<init>", "(Ljava/lang/String;JLjava/lang/String;J)V", "getChannelId", "()Ljava/lang/String;", "getPlayerId", "()J", "getTimestamp", "getTimestampMillis", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ExitedMember {
        private final String channelId;
        private final long playerId;
        private final String timestamp;
        private final long timestampMillis;

        public ExitedMember() {
            this(null, 0L, null, 0L, 15, null);
        }

        public static /* synthetic */ ExitedMember copy$default(ExitedMember exitedMember, String str, long j, String str2, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = exitedMember.channelId;
            }
            if ((i & 2) != 0) {
                j = exitedMember.playerId;
            }
            long j3 = j;
            if ((i & 4) != 0) {
                str2 = exitedMember.timestamp;
            }
            String str3 = str2;
            if ((i & 8) != 0) {
                j2 = exitedMember.timestampMillis;
            }
            return exitedMember.copy(str, j3, str3, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getPlayerId() {
            return this.playerId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final ExitedMember copy(String channelId, long playerId, String timestamp, long timestampMillis) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            return new ExitedMember(channelId, playerId, timestamp, timestampMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExitedMember)) {
                return false;
            }
            ExitedMember exitedMember = (ExitedMember) other;
            return Intrinsics.areEqual(this.channelId, exitedMember.channelId) && this.playerId == exitedMember.playerId && Intrinsics.areEqual(this.timestamp, exitedMember.timestamp) && this.timestampMillis == exitedMember.timestampMillis;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public final String getTimestamp() {
            return this.timestamp;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public int hashCode() {
            return (((((this.channelId.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.playerId)) * 31) + this.timestamp.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestampMillis);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channelId", this.channelId);
                jSONObject.put("playerId", this.playerId);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put("timestampMillis", this.timestampMillis);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("ExitedMember toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "ExitedMember(channelId=" + this.channelId + ", playerId=" + this.playerId + ", timestamp=" + this.timestamp + ", timestampMillis=" + this.timestampMillis + ')';
        }

        public ExitedMember(String channelId, long j, String timestamp, long j2) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.channelId = channelId;
            this.playerId = j;
            this.timestamp = timestamp;
            this.timestampMillis = j2;
        }

        public /* synthetic */ ExitedMember(String str, long j, String str2, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) == 0 ? str2 : "", (i & 8) != 0 ? 0L : j2);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/Chat$GetBlockMembersListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "blockMembers", "Ljava/util/ArrayList;", "Lcom/hive/Chat$BlockMember;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GetBlockMembersListener {
        void onResult(ResultAPI result, ArrayList<BlockMember> blockMembers);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH&¨\u0006\f"}, d2 = {"Lcom/hive/Chat$GetChannelInfoListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "channel", "Lcom/hive/Chat$Channel;", "members", "Ljava/util/ArrayList;", "Lcom/hive/Chat$Member;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GetChannelInfoListener {
        void onResult(ResultAPI result, Channel channel, ArrayList<Member> members);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/Chat$GetChannelMembersListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "members", "Ljava/util/ArrayList;", "Lcom/hive/Chat$Member;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GetChannelMembersListener {
        void onResult(ResultAPI result, ArrayList<Member> members);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&¨\u0006\n"}, d2 = {"Lcom/hive/Chat$GetChannelsByUserListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "channels", "Ljava/util/ArrayList;", "Lcom/hive/Chat$Channel;", "Lkotlin/collections/ArrayList;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GetChannelsByUserListener {
        void onResult(ResultAPI result, ArrayList<Channel> channels);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/hive/Chat$GetChannelsListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "channels", "Ljava/util/ArrayList;", "Lcom/hive/Chat$Channel;", "Lkotlin/collections/ArrayList;", "channelPage", "Lcom/hive/Chat$ChannelPage;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GetChannelsListener {
        void onResult(ResultAPI result, ArrayList<Channel> channels, ChannelPage channelPage);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJb\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000bHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001b¨\u0006,"}, d2 = {"Lcom/hive/Chat$GetChannelsParams;", "", "type", "Lcom/hive/Chat$ChannelType;", "channelId", "", "channelName", "sort", "Lcom/hive/Chat$SortType;", "pageOrder", "pageSize", "", "pageNumber", "<init>", "(Lcom/hive/Chat$ChannelType;Ljava/lang/String;Ljava/lang/String;Lcom/hive/Chat$SortType;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getType", "()Lcom/hive/Chat$ChannelType;", "getChannelId", "()Ljava/lang/String;", "getChannelName", "getSort", "()Lcom/hive/Chat$SortType;", "getPageOrder", "getPageSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/hive/Chat$ChannelType;Ljava/lang/String;Ljava/lang/String;Lcom/hive/Chat$SortType;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/hive/Chat$GetChannelsParams;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class GetChannelsParams {
        private final String channelId;
        private final String channelName;
        private final Integer pageNumber;
        private final String pageOrder;
        private final Integer pageSize;
        private final SortType sort;
        private final ChannelType type;

        public GetChannelsParams() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ GetChannelsParams copy$default(GetChannelsParams getChannelsParams, ChannelType channelType, String str, String str2, SortType sortType, String str3, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                channelType = getChannelsParams.type;
            }
            if ((i & 2) != 0) {
                str = getChannelsParams.channelId;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = getChannelsParams.channelName;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                sortType = getChannelsParams.sort;
            }
            SortType sortType2 = sortType;
            if ((i & 16) != 0) {
                str3 = getChannelsParams.pageOrder;
            }
            String str6 = str3;
            if ((i & 32) != 0) {
                num = getChannelsParams.pageSize;
            }
            Integer num3 = num;
            if ((i & 64) != 0) {
                num2 = getChannelsParams.pageNumber;
            }
            return getChannelsParams.copy(channelType, str4, str5, sortType2, str6, num3, num2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ChannelType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final SortType getSort() {
            return this.sort;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPageOrder() {
            return this.pageOrder;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getPageSize() {
            return this.pageSize;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getPageNumber() {
            return this.pageNumber;
        }

        public final GetChannelsParams copy(ChannelType type, String channelId, String channelName, SortType sort, String pageOrder, Integer pageSize, Integer pageNumber) {
            return new GetChannelsParams(type, channelId, channelName, sort, pageOrder, pageSize, pageNumber);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetChannelsParams)) {
                return false;
            }
            GetChannelsParams getChannelsParams = (GetChannelsParams) other;
            return this.type == getChannelsParams.type && Intrinsics.areEqual(this.channelId, getChannelsParams.channelId) && Intrinsics.areEqual(this.channelName, getChannelsParams.channelName) && this.sort == getChannelsParams.sort && Intrinsics.areEqual(this.pageOrder, getChannelsParams.pageOrder) && Intrinsics.areEqual(this.pageSize, getChannelsParams.pageSize) && Intrinsics.areEqual(this.pageNumber, getChannelsParams.pageNumber);
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getChannelName() {
            return this.channelName;
        }

        public final Integer getPageNumber() {
            return this.pageNumber;
        }

        public final String getPageOrder() {
            return this.pageOrder;
        }

        public final Integer getPageSize() {
            return this.pageSize;
        }

        public final SortType getSort() {
            return this.sort;
        }

        public final ChannelType getType() {
            return this.type;
        }

        public int hashCode() {
            ChannelType channelType = this.type;
            int iHashCode = (channelType == null ? 0 : channelType.hashCode()) * 31;
            String str = this.channelId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.channelName;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            SortType sortType = this.sort;
            int iHashCode4 = (iHashCode3 + (sortType == null ? 0 : sortType.hashCode())) * 31;
            String str3 = this.pageOrder;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.pageSize;
            int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.pageNumber;
            return iHashCode6 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "GetChannelsParams(type=" + this.type + ", channelId=" + this.channelId + ", channelName=" + this.channelName + ", sort=" + this.sort + ", pageOrder=" + this.pageOrder + ", pageSize=" + this.pageSize + ", pageNumber=" + this.pageNumber + ')';
        }

        public GetChannelsParams(ChannelType channelType, String str, String str2, SortType sortType, String str3, Integer num, Integer num2) {
            this.type = channelType;
            this.channelId = str;
            this.channelName = str2;
            this.sort = sortType;
            this.pageOrder = str3;
            this.pageSize = num;
            this.pageNumber = num2;
        }

        public /* synthetic */ GetChannelsParams(ChannelType channelType, String str, String str2, SortType sortType, String str3, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : channelType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : sortType, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public GetChannelsParams(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String strOptString = jsonObject.optString("type");
            ChannelType.Companion companion = ChannelType.INSTANCE;
            Intrinsics.checkNotNull(strOptString);
            ChannelType value = companion.getValue(strOptString);
            String strOptString2 = jsonObject.optString("channelId");
            String strOptString3 = jsonObject.optString("channelName");
            SortType.Companion companion2 = SortType.INSTANCE;
            String strOptString4 = jsonObject.optString("sort");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this(value, strOptString2, strOptString3, companion2.fromValue(strOptString4), jsonObject.optString("pageOrder"), Integer.valueOf(jsonObject.optInt("pageSize")), Integer.valueOf(jsonObject.optInt("pageNumber")));
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/hive/Chat$Member;", "", "playerId", "", "connectedTime", "", "connectedTimeMillis", "<init>", "(JLjava/lang/String;J)V", "getPlayerId", "()J", "getConnectedTime", "()Ljava/lang/String;", "getConnectedTimeMillis", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Member {
        private final String connectedTime;
        private final long connectedTimeMillis;
        private final long playerId;

        public Member(long j, String connectedTime, long j2) {
            Intrinsics.checkNotNullParameter(connectedTime, "connectedTime");
            this.playerId = j;
            this.connectedTime = connectedTime;
            this.connectedTimeMillis = j2;
        }

        public static /* synthetic */ Member copy$default(Member member, long j, String str, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = member.playerId;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                str = member.connectedTime;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                j2 = member.connectedTimeMillis;
            }
            return member.copy(j3, str2, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getPlayerId() {
            return this.playerId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getConnectedTime() {
            return this.connectedTime;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getConnectedTimeMillis() {
            return this.connectedTimeMillis;
        }

        public final Member copy(long playerId, String connectedTime, long connectedTimeMillis) {
            Intrinsics.checkNotNullParameter(connectedTime, "connectedTime");
            return new Member(playerId, connectedTime, connectedTimeMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Member)) {
                return false;
            }
            Member member = (Member) other;
            return this.playerId == member.playerId && Intrinsics.areEqual(this.connectedTime, member.connectedTime) && this.connectedTimeMillis == member.connectedTimeMillis;
        }

        public final String getConnectedTime() {
            return this.connectedTime;
        }

        public final long getConnectedTimeMillis() {
            return this.connectedTimeMillis;
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public int hashCode() {
            return (((UByte$$ExternalSyntheticBackport0.m(this.playerId) * 31) + this.connectedTime.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.connectedTimeMillis);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playerId", this.playerId);
                jSONObject.put("connectedTime", this.connectedTime);
                jSONObject.put("connectedTimeMillis", this.connectedTimeMillis);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("Member toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "Member(playerId=" + this.playerId + ", connectedTime=" + this.connectedTime + ", connectedTimeMillis=" + this.connectedTimeMillis + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/hive/Chat$NoticeMessage;", "", "from", "", "message", "timestamp", "timestampMillis", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getFrom", "()Ljava/lang/String;", "getMessage", "getTimestamp", "getTimestampMillis", "()J", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class NoticeMessage {
        private final String from;
        private final String message;
        private final String timestamp;
        private final long timestampMillis;

        public NoticeMessage() {
            this(null, null, null, 0L, 15, null);
        }

        public static /* synthetic */ NoticeMessage copy$default(NoticeMessage noticeMessage, String str, String str2, String str3, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = noticeMessage.from;
            }
            if ((i & 2) != 0) {
                str2 = noticeMessage.message;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = noticeMessage.timestamp;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                j = noticeMessage.timestampMillis;
            }
            return noticeMessage.copy(str, str4, str5, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFrom() {
            return this.from;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public final NoticeMessage copy(String from, String message, String timestamp, long timestampMillis) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            return new NoticeMessage(from, message, timestamp, timestampMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NoticeMessage)) {
                return false;
            }
            NoticeMessage noticeMessage = (NoticeMessage) other;
            return Intrinsics.areEqual(this.from, noticeMessage.from) && Intrinsics.areEqual(this.message, noticeMessage.message) && Intrinsics.areEqual(this.timestamp, noticeMessage.timestamp) && this.timestampMillis == noticeMessage.timestampMillis;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTimestamp() {
            return this.timestamp;
        }

        public final long getTimestampMillis() {
            return this.timestampMillis;
        }

        public int hashCode() {
            return (((((this.from.hashCode() * 31) + this.message.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.timestampMillis);
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.from);
                jSONObject.put("message", this.message);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put("timestampMillis", this.timestampMillis);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("NoticeMessage toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "NoticeMessage(from=" + this.from + ", message=" + this.message + ", timestamp=" + this.timestamp + ", timestampMillis=" + this.timestampMillis + ')';
        }

        public NoticeMessage(String from, String message, String timestamp, long j) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            this.from = from;
            this.message = message;
            this.timestamp = timestamp;
            this.timestampMillis = j;
        }

        public /* synthetic */ NoticeMessage(String str, String str2, String str3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? 0L : j);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Chat$ReactionListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "type", "Lcom/hive/Chat$ReactionType;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ReactionListener {
        void onResult(ResultAPI result, ReactionType type);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$ReactionType;", "", "<init>", "(Ljava/lang/String;I)V", "Like", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReactionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ReactionType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ReactionType Like = new ReactionType("Like", 0);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Chat$ReactionType$Companion;", "", "<init>", "()V", "getValue", "Lcom/hive/Chat$ReactionType;", "name", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final ReactionType getValue(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                try {
                    return ReactionType.valueOf(name);
                } catch (Exception unused) {
                    return null;
                }
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ ReactionType[] $values() {
            return new ReactionType[]{Like};
        }

        static {
            ReactionType[] reactionTypeArr$values = $values();
            $VALUES = reactionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(reactionTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private ReactionType(String str, int i) {
        }

        public static EnumEntries<ReactionType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final ReactionType getValue(String str) {
            return INSTANCE.getValue(str);
        }

        public static ReactionType valueOf(String str) {
            return (ReactionType) Enum.valueOf(ReactionType.class, str);
        }

        public static ReactionType[] values() {
            return (ReactionType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&¨\u0006\u000b"}, d2 = {"Lcom/hive/Chat$ReconnectListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "channelIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "failChannelIds", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ReconnectListener {
        void onResult(ResultAPI result, ArrayList<String> channelIds, ArrayList<String> failChannelIds);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$ReportMessageListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ReportMessageListener {
        void onResult(ResultAPI result);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/hive/Chat$ReportReasonType;", "", "<init>", "(Ljava/lang/String;I)V", "INSULT", "FRAUD", "SPAM", "ETC", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReportReasonType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ReportReasonType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ReportReasonType INSULT = new ReportReasonType("INSULT", 0);
        public static final ReportReasonType FRAUD = new ReportReasonType("FRAUD", 1);
        public static final ReportReasonType SPAM = new ReportReasonType("SPAM", 2);
        public static final ReportReasonType ETC = new ReportReasonType("ETC", 3);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\n"}, d2 = {"Lcom/hive/Chat$ReportReasonType$Companion;", "", "<init>", "()V", "getValueOrDefault", "Lcom/hive/Chat$ReportReasonType;", "name", "", "fallback", "getValue", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ ReportReasonType getValueOrDefault$default(Companion companion, String str, ReportReasonType reportReasonType, int i, Object obj) {
                if ((i & 2) != 0) {
                    reportReasonType = ReportReasonType.ETC;
                }
                return companion.getValueOrDefault(str, reportReasonType);
            }

            @JvmStatic
            public final ReportReasonType getValue(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                try {
                    return ReportReasonType.valueOf(name);
                } catch (Exception unused) {
                    return null;
                }
            }

            @JvmStatic
            public final ReportReasonType getValueOrDefault(String name, ReportReasonType fallback) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(fallback, "fallback");
                try {
                    return ReportReasonType.valueOf(name);
                } catch (Exception unused) {
                    return fallback;
                }
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ ReportReasonType[] $values() {
            return new ReportReasonType[]{INSULT, FRAUD, SPAM, ETC};
        }

        static {
            ReportReasonType[] reportReasonTypeArr$values = $values();
            $VALUES = reportReasonTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(reportReasonTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private ReportReasonType(String str, int i) {
        }

        public static EnumEntries<ReportReasonType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final ReportReasonType getValue(String str) {
            return INSTANCE.getValue(str);
        }

        @JvmStatic
        public static final ReportReasonType getValueOrDefault(String str, ReportReasonType reportReasonType) {
            return INSTANCE.getValueOrDefault(str, reportReasonType);
        }

        public static ReportReasonType valueOf(String str) {
            return (ReportReasonType) Enum.valueOf(ReportReasonType.class, str);
        }

        public static ReportReasonType[] values() {
            return (ReportReasonType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\f"}, d2 = {"Lcom/hive/Chat$SortType;", "", "<init>", "(Ljava/lang/String;I)V", "ChannelId", "ChannelName", "RegTime", "value", "", "getValue", "()Ljava/lang/String;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SortType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SortType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SortType ChannelId = new SortType("ChannelId", 0);
        public static final SortType ChannelName = new SortType("ChannelName", 1);
        public static final SortType RegTime = new SortType("RegTime", 2);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Chat$SortType$Companion;", "", "<init>", "()V", "fromValue", "Lcom/hive/Chat$SortType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final SortType fromValue(String value) {
                SortType next;
                Intrinsics.checkNotNullParameter(value, "value");
                Iterator<SortType> it = SortType.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    String value2 = next.getValue();
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String upperCase = value2.toUpperCase(US);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String upperCase2 = value.toUpperCase(US);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    if (Intrinsics.areEqual(upperCase, upperCase2)) {
                        break;
                    }
                }
                return next;
            }

            private Companion() {
            }
        }

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SortType.values().length];
                try {
                    iArr[SortType.ChannelId.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SortType.ChannelName.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SortType.RegTime.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ SortType[] $values() {
            return new SortType[]{ChannelId, ChannelName, RegTime};
        }

        static {
            SortType[] sortTypeArr$values = $values();
            $VALUES = sortTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(sortTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private SortType(String str, int i) {
        }

        public static EnumEntries<SortType> getEntries() {
            return $ENTRIES;
        }

        public static SortType valueOf(String str) {
            return (SortType) Enum.valueOf(SortType.class, str);
        }

        public static SortType[] values() {
            return (SortType[]) $VALUES.clone();
        }

        public final String getValue() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return "channelId";
            }
            if (i == 2) {
                return "channelName";
            }
            if (i == 3) {
                return "regTime";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Chat$TranslateListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "data", "Lcom/hive/Chat$TranslationData;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface TranslateListener {
        void onResult(ResultAPI result, TranslationData data);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J/\u0010\u000b\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/hive/Chat$TranslationData;", "", "translations", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getTranslations", "()Ljava/util/HashMap;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TranslationData {
        private final HashMap<String, String> translations;

        public TranslationData(HashMap<String, String> translations) {
            Intrinsics.checkNotNullParameter(translations, "translations");
            this.translations = translations;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TranslationData copy$default(TranslationData translationData, HashMap map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = translationData.translations;
            }
            return translationData.copy(map);
        }

        public final HashMap<String, String> component1() {
            return this.translations;
        }

        public final TranslationData copy(HashMap<String, String> translations) {
            Intrinsics.checkNotNullParameter(translations, "translations");
            return new TranslationData(translations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TranslationData) && Intrinsics.areEqual(this.translations, ((TranslationData) other).translations);
        }

        public final HashMap<String, String> getTranslations() {
            return this.translations;
        }

        public int hashCode() {
            return this.translations.hashCode();
        }

        public String toString() {
            return "TranslationData(translations=" + this.translations + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/Chat$UnblockMemberListener;", "", "onResult", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface UnblockMemberListener {
        void onResult(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/Chat$UserListener;", "", "onDirectMessage", "", "message", "Lcom/hive/Chat$DirectMessage;", "onNoticeMessage", "Lcom/hive/Chat$NoticeMessage;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface UserListener {
        void onDirectMessage(DirectMessage message);

        void onNoticeMessage(NoticeMessage message);
    }

    static {
        Intrinsics.checkNotNullExpressionValue("Chat", "getSimpleName(...)");
        TAG = "Chat";
        hiveChat = LazyKt.lazy(new Function0() { // from class: com.hive.Chat$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Chat.hiveChat_delegate$lambda$0();
            }
        });
    }

    private Chat() {
    }

    @JvmStatic
    public static final void addChannelListener(String uniqueKey, ChannelListener listener) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.addChannelListener(uniqueKey, listener);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void addConnectionListener(String uniqueKey, ConnectionListener listener) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.addConnectionListener(uniqueKey, listener);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void addCustomDataListener(String uniqueKey, CustomDataListener listener) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.addCustomDataListener(uniqueKey, listener);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @Deprecated(message = "This method is no longer used. Please use [UserListener] instead")
    @JvmStatic
    public static final void addDirectMessageListener(String uniqueKey, DirectMessageListener listener) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.addDirectMessageListener(uniqueKey, listener);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void addUserListener(String uniqueKey, UserListener listener) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.addUserListener(uniqueKey, listener);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void blockMember(long blockPlayerId, BlockMemberListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("blockPlayerId = %s", Arrays.copyOf(new Object[]{Long.valueOf(blockPlayerId)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.blockMember(blockPlayerId, listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @Deprecated(message = "This method is no longer used. Please use [connect(listener: ConnectListener)] instead")
    @JvmStatic
    public static final void connect(String extraData, ConnectListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("extraData = %s", Arrays.copyOf(new Object[]{extraData}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        loggerImpl.w("This method is no longer used. Please use [connect(listener: ConnectListener)] instead");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.connect(listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void createChannel(CreateChannelParams params, CreateChannelListener listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("params = %s", Arrays.copyOf(new Object[]{params.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.createChannel(params, listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void deleteChannel(String channelId, DeleteChannelListener listener) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("channelId = %s", Arrays.copyOf(new Object[]{channelId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.deleteChannel(channelId, listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void disconnect(DisconnectListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.disconnect(listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void enterChannel(EnterChannelParams params, EnterChannelListener listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("params = %s", Arrays.copyOf(new Object[]{params.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.enterChannel(params, listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void exitChannel(String channelId, ExitChannelListener listener) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("channelId = %s", Arrays.copyOf(new Object[]{channelId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.exitChannel(channelId, listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getBlockMembers(GetBlockMembersListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.getBlockMembers(listener);
        } else {
            listener.onResult(getLibraryMissingError(), new ArrayList<>());
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void getChannelInfo(String channelId, GetChannelInfoListener listener) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("channelId = %s", Arrays.copyOf(new Object[]{channelId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.getChannelInfo(channelId, listener);
        } else {
            listener.onResult(getLibraryMissingError(), null, new ArrayList<>());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getChannelMembers(String channelId, GetChannelMembersListener listener) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("channelId = %s", Arrays.copyOf(new Object[]{channelId}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.getChannelMembers(channelId, listener);
        } else {
            listener.onResult(getLibraryMissingError(), new ArrayList<>());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getChannels(GetChannelsParams params, GetChannelsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("params = %s", Arrays.copyOf(new Object[]{String.valueOf(params)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.getChannels(params, listener);
        } else {
            listener.onResult(getLibraryMissingError(), new ArrayList<>(), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void getChannelsByUser(GetChannelsByUserListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.getChannelsByUser(listener);
        } else {
            listener.onResult(getLibraryMissingError(), new ArrayList<>());
        }
        loggerImpl.apiReturnLog(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HiveChat getHiveChat() {
        return (HiveChat) hiveChat.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final ResultAPI getLibraryMissingError() {
        return new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "HiveChat");
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiveChat hiveChat_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveChat.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveChat)) {
            hiveModule = null;
        }
        return (HiveChat) (hiveModule instanceof HiveChat ? hiveModule : null);
    }

    @JvmStatic
    public static final boolean isConnected() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        boolean zIsConnected = hiveChat2 != null ? hiveChat2.isConnected() : false;
        loggerImpl.apiReturnLog(str, "result = " + zIsConnected);
        return zIsConnected;
    }

    @JvmStatic
    public static final void reconnect(ReconnectListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.reconnect(listener);
        } else {
            listener.onResult(getLibraryMissingError(), new ArrayList<>(), new ArrayList<>());
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void removeChannelListener(String uniqueKey) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.removeChannelListener(uniqueKey);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void removeConnectionListener(String uniqueKey) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.removeConnectionListener(uniqueKey);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void removeCustomDataListener(String uniqueKey) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.removeCustomDataListener(uniqueKey);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @Deprecated(message = "This method is no longer used. Please use [UserListener] instead")
    @JvmStatic
    public static final void removeDirectMessageListener(String uniqueKey) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.removeDirectMessageListener(uniqueKey);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void removeUserListener(String uniqueKey) {
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("uniqueKey = %s", Arrays.copyOf(new Object[]{uniqueKey}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.removeUserListener(uniqueKey);
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void reportMessage(ReportMessageParams params, ReportMessageListener listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("params = %s", Arrays.copyOf(new Object[]{params}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.reportMessage(params, listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void sendMessage(ChannelSendMessageParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.sendMessage(params);
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void translate(TranslateParams params, TranslateListener listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("params = %s", Arrays.copyOf(new Object[]{params}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.translate(params, listener);
        } else {
            listener.onResult(getLibraryMissingError(), null);
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @JvmStatic
    public static final void unblockMember(long blockPlayerId, UnblockMemberListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("blockPlayerId = %s", Arrays.copyOf(new Object[]{Long.valueOf(blockPlayerId)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.apiCalledLog(str2, str);
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.unblockMember(blockPlayerId, listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(str2, "");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/hive/Chat$EnterChannelParams;", "", "channelId", "", HintConstants.AUTOFILL_HINT_PASSWORD, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getChannelId", "()Ljava/lang/String;", "getPassword", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class EnterChannelParams {
        private final String channelId;
        private final String password;

        public EnterChannelParams(String channelId, String str) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.channelId = channelId;
            this.password = str;
        }

        public static /* synthetic */ EnterChannelParams copy$default(EnterChannelParams enterChannelParams, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = enterChannelParams.channelId;
            }
            if ((i & 2) != 0) {
                str2 = enterChannelParams.password;
            }
            return enterChannelParams.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        public final EnterChannelParams copy(String channelId, String password) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new EnterChannelParams(channelId, password);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EnterChannelParams)) {
                return false;
            }
            EnterChannelParams enterChannelParams = (EnterChannelParams) other;
            return Intrinsics.areEqual(this.channelId, enterChannelParams.channelId) && Intrinsics.areEqual(this.password, enterChannelParams.password);
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getPassword() {
            return this.password;
        }

        public int hashCode() {
            int iHashCode = this.channelId.hashCode() * 31;
            String str = this.password;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "EnterChannelParams(channelId=" + this.channelId + ", password=" + this.password + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public EnterChannelParams(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String strOptString = jsonObject.optString("channelId");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this(strOptString, jsonObject.optString(HintConstants.AUTOFILL_HINT_PASSWORD));
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/hive/Chat$DirectSendMessageParams;", "", "toPlayerId", "", "message", "", "extraData", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getToPlayerId", "()J", "getMessage", "()Ljava/lang/String;", "getExtraData", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class DirectSendMessageParams {
        private final String extraData;
        private final String message;
        private final long toPlayerId;

        public DirectSendMessageParams(long j, String message, String str) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.toPlayerId = j;
            this.message = message;
            this.extraData = str;
        }

        public static /* synthetic */ DirectSendMessageParams copy$default(DirectSendMessageParams directSendMessageParams, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = directSendMessageParams.toPlayerId;
            }
            if ((i & 2) != 0) {
                str = directSendMessageParams.message;
            }
            if ((i & 4) != 0) {
                str2 = directSendMessageParams.extraData;
            }
            return directSendMessageParams.copy(j, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getToPlayerId() {
            return this.toPlayerId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getExtraData() {
            return this.extraData;
        }

        public final DirectSendMessageParams copy(long toPlayerId, String message, String extraData) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new DirectSendMessageParams(toPlayerId, message, extraData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DirectSendMessageParams)) {
                return false;
            }
            DirectSendMessageParams directSendMessageParams = (DirectSendMessageParams) other;
            return this.toPlayerId == directSendMessageParams.toPlayerId && Intrinsics.areEqual(this.message, directSendMessageParams.message) && Intrinsics.areEqual(this.extraData, directSendMessageParams.extraData);
        }

        public final String getExtraData() {
            return this.extraData;
        }

        public final String getMessage() {
            return this.message;
        }

        public final long getToPlayerId() {
            return this.toPlayerId;
        }

        public int hashCode() {
            int iM = ((UByte$$ExternalSyntheticBackport0.m(this.toPlayerId) * 31) + this.message.hashCode()) * 31;
            String str = this.extraData;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "DirectSendMessageParams(toPlayerId=" + this.toPlayerId + ", message=" + this.message + ", extraData=" + this.extraData + ')';
        }

        public /* synthetic */ DirectSendMessageParams(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, (i & 4) != 0 ? null : str2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public DirectSendMessageParams(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            long jOptLong = jsonObject.optLong("toPlayerId");
            String strOptString = jsonObject.optString("message");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this(jOptLong, strOptString, ExtentionsKt.optStringOrNull(jsonObject, "extraData"));
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/hive/Chat$TranslateParams;", "", "message", "", "sourceLanguage", "targetLanguage", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getMessage", "()Ljava/lang/String;", "getSourceLanguage", "getTargetLanguage", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class TranslateParams {
        private final String message;
        private final String sourceLanguage;
        private final ArrayList<String> targetLanguage;

        public TranslateParams(String message, String sourceLanguage, ArrayList<String> targetLanguage) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
            Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
            this.message = message;
            this.sourceLanguage = sourceLanguage;
            this.targetLanguage = targetLanguage;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TranslateParams copy$default(TranslateParams translateParams, String str, String str2, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                str = translateParams.message;
            }
            if ((i & 2) != 0) {
                str2 = translateParams.sourceLanguage;
            }
            if ((i & 4) != 0) {
                arrayList = translateParams.targetLanguage;
            }
            return translateParams.copy(str, str2, arrayList);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSourceLanguage() {
            return this.sourceLanguage;
        }

        public final ArrayList<String> component3() {
            return this.targetLanguage;
        }

        public final TranslateParams copy(String message, String sourceLanguage, ArrayList<String> targetLanguage) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
            Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
            return new TranslateParams(message, sourceLanguage, targetLanguage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TranslateParams)) {
                return false;
            }
            TranslateParams translateParams = (TranslateParams) other;
            return Intrinsics.areEqual(this.message, translateParams.message) && Intrinsics.areEqual(this.sourceLanguage, translateParams.sourceLanguage) && Intrinsics.areEqual(this.targetLanguage, translateParams.targetLanguage);
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getSourceLanguage() {
            return this.sourceLanguage;
        }

        public final ArrayList<String> getTargetLanguage() {
            return this.targetLanguage;
        }

        public int hashCode() {
            return (((this.message.hashCode() * 31) + this.sourceLanguage.hashCode()) * 31) + this.targetLanguage.hashCode();
        }

        public String toString() {
            return "TranslateParams(message=" + this.message + ", sourceLanguage=" + this.sourceLanguage + ", targetLanguage=" + this.targetLanguage + ')';
        }

        public /* synthetic */ TranslateParams(String str, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "auto" : str2, arrayList);
        }

        public TranslateParams(JSONObject jsonObject) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String strOptStringOrNull = ExtentionsKt.optStringOrNull(jsonObject, "message");
            strOptStringOrNull = strOptStringOrNull == null ? "" : strOptStringOrNull;
            String strOptStringOrNull2 = ExtentionsKt.optStringOrNull(jsonObject, "sourceLanguage");
            String str = strOptStringOrNull2 != null ? strOptStringOrNull2 : "";
            JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray("targetLanguage");
            if (jSONArrayOptJSONArray != null) {
                arrayList = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (strOptString != null) {
                        arrayList.add(strOptString);
                    }
                }
            } else {
                arrayList = new ArrayList();
            }
            this(strOptStringOrNull, str, arrayList);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000b\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003JS\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/hive/Chat$ChannelSendMessageParams;", "", "channelId", "", "message", "extraData", "replyMessageId", "mentionedPlayerIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getChannelId", "()Ljava/lang/String;", "getMessage", "getExtraData", "getReplyMessageId", "getMentionedPlayerIds", "()Ljava/util/ArrayList;", "setMentionedPlayerIds", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ChannelSendMessageParams {
        private final String channelId;
        private final String extraData;
        private ArrayList<Long> mentionedPlayerIds;
        private final String message;
        private final String replyMessageId;

        public ChannelSendMessageParams(String channelId, String message, String str, String str2, ArrayList<Long> arrayList) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(message, "message");
            this.channelId = channelId;
            this.message = message;
            this.extraData = str;
            this.replyMessageId = str2;
            this.mentionedPlayerIds = arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelSendMessageParams copy$default(ChannelSendMessageParams channelSendMessageParams, String str, String str2, String str3, String str4, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelSendMessageParams.channelId;
            }
            if ((i & 2) != 0) {
                str2 = channelSendMessageParams.message;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = channelSendMessageParams.extraData;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = channelSendMessageParams.replyMessageId;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                arrayList = channelSendMessageParams.mentionedPlayerIds;
            }
            return channelSendMessageParams.copy(str, str5, str6, str7, arrayList);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getExtraData() {
            return this.extraData;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getReplyMessageId() {
            return this.replyMessageId;
        }

        public final ArrayList<Long> component5() {
            return this.mentionedPlayerIds;
        }

        public final ChannelSendMessageParams copy(String channelId, String message, String extraData, String replyMessageId, ArrayList<Long> mentionedPlayerIds) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(message, "message");
            return new ChannelSendMessageParams(channelId, message, extraData, replyMessageId, mentionedPlayerIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelSendMessageParams)) {
                return false;
            }
            ChannelSendMessageParams channelSendMessageParams = (ChannelSendMessageParams) other;
            return Intrinsics.areEqual(this.channelId, channelSendMessageParams.channelId) && Intrinsics.areEqual(this.message, channelSendMessageParams.message) && Intrinsics.areEqual(this.extraData, channelSendMessageParams.extraData) && Intrinsics.areEqual(this.replyMessageId, channelSendMessageParams.replyMessageId) && Intrinsics.areEqual(this.mentionedPlayerIds, channelSendMessageParams.mentionedPlayerIds);
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getExtraData() {
            return this.extraData;
        }

        public final ArrayList<Long> getMentionedPlayerIds() {
            return this.mentionedPlayerIds;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getReplyMessageId() {
            return this.replyMessageId;
        }

        public int hashCode() {
            int iHashCode = ((this.channelId.hashCode() * 31) + this.message.hashCode()) * 31;
            String str = this.extraData;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.replyMessageId;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            ArrayList<Long> arrayList = this.mentionedPlayerIds;
            return iHashCode3 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public final void setMentionedPlayerIds(ArrayList<Long> arrayList) {
            this.mentionedPlayerIds = arrayList;
        }

        public String toString() {
            return "ChannelSendMessageParams(channelId=" + this.channelId + ", message=" + this.message + ", extraData=" + this.extraData + ", replyMessageId=" + this.replyMessageId + ", mentionedPlayerIds=" + this.mentionedPlayerIds + ')';
        }

        public /* synthetic */ ChannelSendMessageParams(String str, String str2, String str3, String str4, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : arrayList);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ChannelSendMessageParams(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String strOptString = jsonObject.optString("channelId");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strOptString2 = jsonObject.optString("message");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this(strOptString, strOptString2, ExtentionsKt.optStringOrNull(jsonObject, "extraData"), ExtentionsKt.optStringOrNull(jsonObject, "replyMessageId"), null, 16, null);
            JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray("mentionedPlayerIds");
            if (jSONArrayOptJSONArray != null) {
                ArrayList<Long> arrayList = new ArrayList<>();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(Long.valueOf(jSONArrayOptJSONArray.optLong(i)));
                }
                if (arrayList.size() > 0) {
                    this.mentionedPlayerIds = arrayList;
                }
            }
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006#"}, d2 = {"Lcom/hive/Chat$ReportMessageParams;", "", "channelId", "", "messageId", "reporteePlayerId", "", "reasonType", "Lcom/hive/Chat$ReportReasonType;", "reasonDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/hive/Chat$ReportReasonType;Ljava/lang/String;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getChannelId", "()Ljava/lang/String;", "getMessageId", "getReporteePlayerId", "()J", "getReasonType", "()Lcom/hive/Chat$ReportReasonType;", "getReasonDetail", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ReportMessageParams {
        private final String channelId;
        private final String messageId;
        private final String reasonDetail;
        private final ReportReasonType reasonType;
        private final long reporteePlayerId;

        public ReportMessageParams(String channelId, String messageId, long j, ReportReasonType reasonType, String str) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(reasonType, "reasonType");
            this.channelId = channelId;
            this.messageId = messageId;
            this.reporteePlayerId = j;
            this.reasonType = reasonType;
            this.reasonDetail = str;
        }

        public static /* synthetic */ ReportMessageParams copy$default(ReportMessageParams reportMessageParams, String str, String str2, long j, ReportReasonType reportReasonType, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reportMessageParams.channelId;
            }
            if ((i & 2) != 0) {
                str2 = reportMessageParams.messageId;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                j = reportMessageParams.reporteePlayerId;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                reportReasonType = reportMessageParams.reasonType;
            }
            ReportReasonType reportReasonType2 = reportReasonType;
            if ((i & 16) != 0) {
                str3 = reportMessageParams.reasonDetail;
            }
            return reportMessageParams.copy(str, str4, j2, reportReasonType2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getReporteePlayerId() {
            return this.reporteePlayerId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ReportReasonType getReasonType() {
            return this.reasonType;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getReasonDetail() {
            return this.reasonDetail;
        }

        public final ReportMessageParams copy(String channelId, String messageId, long reporteePlayerId, ReportReasonType reasonType, String reasonDetail) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(reasonType, "reasonType");
            return new ReportMessageParams(channelId, messageId, reporteePlayerId, reasonType, reasonDetail);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportMessageParams)) {
                return false;
            }
            ReportMessageParams reportMessageParams = (ReportMessageParams) other;
            return Intrinsics.areEqual(this.channelId, reportMessageParams.channelId) && Intrinsics.areEqual(this.messageId, reportMessageParams.messageId) && this.reporteePlayerId == reportMessageParams.reporteePlayerId && this.reasonType == reportMessageParams.reasonType && Intrinsics.areEqual(this.reasonDetail, reportMessageParams.reasonDetail);
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final String getReasonDetail() {
            return this.reasonDetail;
        }

        public final ReportReasonType getReasonType() {
            return this.reasonType;
        }

        public final long getReporteePlayerId() {
            return this.reporteePlayerId;
        }

        public int hashCode() {
            int iHashCode = ((((((this.channelId.hashCode() * 31) + this.messageId.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.reporteePlayerId)) * 31) + this.reasonType.hashCode()) * 31;
            String str = this.reasonDetail;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ReportMessageParams(channelId=" + this.channelId + ", messageId=" + this.messageId + ", reporteePlayerId=" + this.reporteePlayerId + ", reasonType=" + this.reasonType + ", reasonDetail=" + this.reasonDetail + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ReportMessageParams(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String strOptString = jsonObject.optString("channelId");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strOptString2 = jsonObject.optString("messageId");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            long jOptLong = jsonObject.optLong("reporteePlayerId");
            String strOptString3 = jsonObject.optString("reasonType");
            ReportReasonType.Companion companion = ReportReasonType.INSTANCE;
            Intrinsics.checkNotNull(strOptString3);
            this(strOptString, strOptString2, jOptLong, ReportReasonType.Companion.getValueOrDefault$default(companion, strOptString3, null, 2, null), jsonObject.optString("reasonDetail"));
        }
    }

    @JvmStatic
    public static final void sendMessage(ChannelSendMessageParams params, ChannelSendMessageListener listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.sendMessage(params, listener);
        } else {
            listener.onResult(getLibraryMissingError(), params);
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/hive/Chat$Reaction;", "", "channelId", "", "messageId", "playerId", "", "type", "Lcom/hive/Chat$ReactionType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/hive/Chat$ReactionType;)V", "getChannelId", "()Ljava/lang/String;", "getMessageId", "getPlayerId", "()J", "getType", "()Lcom/hive/Chat$ReactionType;", "toJSON", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Reaction {
        private final String channelId;
        private final String messageId;
        private final long playerId;
        private final ReactionType type;

        public Reaction(String channelId, String messageId, long j, ReactionType type) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(type, "type");
            this.channelId = channelId;
            this.messageId = messageId;
            this.playerId = j;
            this.type = type;
        }

        public static /* synthetic */ Reaction copy$default(Reaction reaction, String str, String str2, long j, ReactionType reactionType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reaction.channelId;
            }
            if ((i & 2) != 0) {
                str2 = reaction.messageId;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                j = reaction.playerId;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                reactionType = reaction.type;
            }
            return reaction.copy(str, str3, j2, reactionType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getPlayerId() {
            return this.playerId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ReactionType getType() {
            return this.type;
        }

        public final Reaction copy(String channelId, String messageId, long playerId, ReactionType type) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Reaction(channelId, messageId, playerId, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Reaction)) {
                return false;
            }
            Reaction reaction = (Reaction) other;
            return Intrinsics.areEqual(this.channelId, reaction.channelId) && Intrinsics.areEqual(this.messageId, reaction.messageId) && this.playerId == reaction.playerId && this.type == reaction.type;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getMessageId() {
            return this.messageId;
        }

        public final long getPlayerId() {
            return this.playerId;
        }

        public final ReactionType getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((this.channelId.hashCode() * 31) + this.messageId.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.playerId)) * 31) + this.type.hashCode();
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channelId", this.channelId);
                jSONObject.put("messageId", this.messageId);
                jSONObject.put("playerId", this.playerId);
                jSONObject.put("type", this.type.name());
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("Reaction toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        public String toString() {
            return "Reaction(channelId=" + this.channelId + ", messageId=" + this.messageId + ", playerId=" + this.playerId + ", type=" + this.type + ')';
        }

        public /* synthetic */ Reaction(String str, String str2, long j, ReactionType reactionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : j, reactionType);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u000e\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003JQ\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0007HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/hive/Chat$CreateChannelParams;", "", "channelId", "", HintConstants.AUTOFILL_HINT_PASSWORD, "channelName", "maxMemberCount", "", "type", "Lcom/hive/Chat$ChannelType;", "chatHistoryAllowed", "", "otherPlayerId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/hive/Chat$ChannelType;ZJ)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getChannelId", "()Ljava/lang/String;", "getPassword", "getChannelName", "getMaxMemberCount", "()I", "getType", "()Lcom/hive/Chat$ChannelType;", "getChatHistoryAllowed", "()Z", "getOtherPlayerId", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class CreateChannelParams {
        private final String channelId;
        private final String channelName;
        private final boolean chatHistoryAllowed;
        private final int maxMemberCount;
        private final long otherPlayerId;
        private final String password;
        private final ChannelType type;

        public CreateChannelParams(String channelId, String str, String channelName, int i, ChannelType type, boolean z, long j) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(channelName, "channelName");
            Intrinsics.checkNotNullParameter(type, "type");
            this.channelId = channelId;
            this.password = str;
            this.channelName = channelName;
            this.maxMemberCount = i;
            this.type = type;
            this.chatHistoryAllowed = z;
            this.otherPlayerId = j;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChannelName() {
            return this.channelName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getMaxMemberCount() {
            return this.maxMemberCount;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ChannelType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getChatHistoryAllowed() {
            return this.chatHistoryAllowed;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final long getOtherPlayerId() {
            return this.otherPlayerId;
        }

        public final CreateChannelParams copy(String channelId, String password, String channelName, int maxMemberCount, ChannelType type, boolean chatHistoryAllowed, long otherPlayerId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(channelName, "channelName");
            Intrinsics.checkNotNullParameter(type, "type");
            return new CreateChannelParams(channelId, password, channelName, maxMemberCount, type, chatHistoryAllowed, otherPlayerId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateChannelParams)) {
                return false;
            }
            CreateChannelParams createChannelParams = (CreateChannelParams) other;
            return Intrinsics.areEqual(this.channelId, createChannelParams.channelId) && Intrinsics.areEqual(this.password, createChannelParams.password) && Intrinsics.areEqual(this.channelName, createChannelParams.channelName) && this.maxMemberCount == createChannelParams.maxMemberCount && this.type == createChannelParams.type && this.chatHistoryAllowed == createChannelParams.chatHistoryAllowed && this.otherPlayerId == createChannelParams.otherPlayerId;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getChannelName() {
            return this.channelName;
        }

        public final boolean getChatHistoryAllowed() {
            return this.chatHistoryAllowed;
        }

        public final int getMaxMemberCount() {
            return this.maxMemberCount;
        }

        public final long getOtherPlayerId() {
            return this.otherPlayerId;
        }

        public final String getPassword() {
            return this.password;
        }

        public final ChannelType getType() {
            return this.type;
        }

        public int hashCode() {
            int iHashCode = this.channelId.hashCode() * 31;
            String str = this.password;
            return ((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.channelName.hashCode()) * 31) + this.maxMemberCount) * 31) + this.type.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.chatHistoryAllowed)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.otherPlayerId);
        }

        public String toString() {
            return "CreateChannelParams(channelId=" + this.channelId + ", password=" + this.password + ", channelName=" + this.channelName + ", maxMemberCount=" + this.maxMemberCount + ", type=" + this.type + ", chatHistoryAllowed=" + this.chatHistoryAllowed + ", otherPlayerId=" + this.otherPlayerId + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public CreateChannelParams(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String strOptString = jsonObject.optString("channelId");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strOptString2 = jsonObject.optString(HintConstants.AUTOFILL_HINT_PASSWORD);
            String strOptString3 = jsonObject.optString("channelName");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            int iOptInt = jsonObject.optInt("maxMemberCount");
            String strOptString4 = jsonObject.optString("type");
            ChannelType.Companion companion = ChannelType.INSTANCE;
            Intrinsics.checkNotNull(strOptString4);
            this(strOptString, strOptString2, strOptString3, iOptInt, ChannelType.Companion.getValueOrDefault$default(companion, strOptString4, null, 2, null), jsonObject.optBoolean("chatHistoryAllowed"), jsonObject.optLong("otherPlayerId"));
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0010\u0010\u0014J\u0006\u0010#\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020,J\u001e\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020/2\u0006\u0010(\u001a\u000200J\u001e\u00101\u001a\u00020%2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020/2\u0006\u0010(\u001a\u000200R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/hive/Chat$Channel;", "", "channelId", "", "type", "Lcom/hive/Chat$ChannelType;", "owner", "channelName", "memberCount", "", "maxMemberCount", "regTime", "regTimeMillis", "", "chatHistoryAllowed", "", "<init>", "(Ljava/lang/String;Lcom/hive/Chat$ChannelType;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;JZ)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getChannelId", "()Ljava/lang/String;", "getType", "()Lcom/hive/Chat$ChannelType;", "getOwner", "getChannelName", "getMemberCount", "()I", "getMaxMemberCount", "getRegTime", "getRegTimeMillis", "()J", "getChatHistoryAllowed", "()Z", "toJSON", "query", "", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/hive/Chat$ChannelMessageListQueryParams;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Chat$ChannelMessageListQueryListener;", "setTranslationEnabled", "isEnabled", "Lcom/hive/Chat$ChannelTranslationSettingListener;", "addReaction", "messageId", "Lcom/hive/Chat$ReactionType;", "Lcom/hive/Chat$ReactionListener;", "removeReaction", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Channel {
        private final String channelId;
        private final String channelName;
        private final boolean chatHistoryAllowed;
        private final int maxMemberCount;
        private final int memberCount;
        private final String owner;
        private final String regTime;
        private final long regTimeMillis;
        private final ChannelType type;

        public Channel(String channelId, ChannelType type, String owner, String channelName, int i, int i2, String regTime, long j, boolean z) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(channelName, "channelName");
            Intrinsics.checkNotNullParameter(regTime, "regTime");
            this.channelId = channelId;
            this.type = type;
            this.owner = owner;
            this.channelName = channelName;
            this.memberCount = i;
            this.maxMemberCount = i2;
            this.regTime = regTime;
            this.regTimeMillis = j;
            this.chatHistoryAllowed = z;
        }

        public final void addReaction(String messageId, ReactionType type, ReactionListener listener) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(listener, "listener");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.apiCalledLog(Chat.getTAG(), "messageId = " + messageId);
            HiveChat hiveChat = Chat.INSTANCE.getHiveChat();
            if (hiveChat != null) {
                hiveChat.addReaction(this, messageId, type, listener);
            } else {
                listener.onResult(Chat.getLibraryMissingError(), type);
            }
            loggerImpl.apiReturnLog(Chat.getTAG(), "");
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getChannelName() {
            return this.channelName;
        }

        public final boolean getChatHistoryAllowed() {
            return this.chatHistoryAllowed;
        }

        public final int getMaxMemberCount() {
            return this.maxMemberCount;
        }

        public final int getMemberCount() {
            return this.memberCount;
        }

        public final String getOwner() {
            return this.owner;
        }

        public final String getRegTime() {
            return this.regTime;
        }

        public final long getRegTimeMillis() {
            return this.regTimeMillis;
        }

        public final ChannelType getType() {
            return this.type;
        }

        public final void query(ChannelMessageListQueryParams params, ChannelMessageListQueryListener listener) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(listener, "listener");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.apiCalledLog(Chat.getTAG(), "params = " + params);
            HiveChat hiveChat = Chat.INSTANCE.getHiveChat();
            if (hiveChat != null) {
                hiveChat.queryChannelMessageList(this, params, listener);
            } else {
                listener.onResult(Chat.getLibraryMissingError(), null);
            }
            loggerImpl.apiReturnLog(Chat.getTAG(), "");
        }

        public final void removeReaction(String messageId, ReactionType type, ReactionListener listener) {
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(listener, "listener");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.apiCalledLog(Chat.getTAG(), "messageId = " + messageId);
            HiveChat hiveChat = Chat.INSTANCE.getHiveChat();
            if (hiveChat != null) {
                hiveChat.removeReaction(this, messageId, type, listener);
            } else {
                listener.onResult(Chat.getLibraryMissingError(), type);
            }
            loggerImpl.apiReturnLog(Chat.getTAG(), "");
        }

        public final void setTranslationEnabled(boolean isEnabled, ChannelTranslationSettingListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.apiCalledLog(Chat.getTAG(), "isEnabled = " + isEnabled);
            HiveChat hiveChat = Chat.INSTANCE.getHiveChat();
            if (hiveChat != null) {
                hiveChat.setTranslationEnabled(this, isEnabled, listener);
            } else {
                listener.onResult(Chat.getLibraryMissingError());
            }
            loggerImpl.apiReturnLog(Chat.getTAG(), "");
        }

        public final JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channelId", this.channelId);
                jSONObject.put("type", this.type.name());
                jSONObject.put("owner", this.owner);
                jSONObject.put("channelName", this.channelName);
                jSONObject.put("memberCount", this.memberCount);
                jSONObject.put("maxMemberCount", this.maxMemberCount);
                jSONObject.put("regTime", this.regTime);
                jSONObject.put("regTimeMillis", this.regTimeMillis);
                jSONObject.put("chatHistoryAllowed", this.chatHistoryAllowed);
                return jSONObject;
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w("Channel toJSON(e: " + e.getMessage() + ')');
                return jSONObject;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Channel(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            String strOptString = jsonObject.optString("channelId");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            String strOptString2 = jsonObject.optString("type");
            ChannelType.Companion companion = ChannelType.INSTANCE;
            Intrinsics.checkNotNull(strOptString2);
            ChannelType valueOrDefault$default = ChannelType.Companion.getValueOrDefault$default(companion, strOptString2, null, 2, null);
            String strOptString3 = jsonObject.optString("owner");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            String strOptString4 = jsonObject.optString("channelName");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            int iOptInt = jsonObject.optInt("memberCount");
            int iOptInt2 = jsonObject.optInt("maxMemberCount");
            String strOptString5 = jsonObject.optString("regTime");
            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
            this(strOptString, valueOrDefault$default, strOptString3, strOptString4, iOptInt, iOptInt2, strOptString5, jsonObject.optLong("regTimeMillis", 0L), jsonObject.optBoolean("chatHistoryAllowed", false));
        }
    }

    @JvmStatic
    public static final void connect(ConnectListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.apiCalledLog(TAG, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.connect(listener);
        } else {
            listener.onResult(getLibraryMissingError());
        }
        loggerImpl.apiReturnLog(Promotion.getTAG(), "");
    }

    @JvmStatic
    public static final void sendMessage(DirectSendMessageParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.sendMessage(params);
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void sendMessage(DirectSendMessageParams params, DirectSendMessageListener listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        HiveChat hiveChat2 = INSTANCE.getHiveChat();
        if (hiveChat2 != null) {
            hiveChat2.sendMessage(params, listener);
        } else {
            listener.onResult(getLibraryMissingError(), params);
        }
        loggerImpl.apiReturnLog(str, "");
    }
}
