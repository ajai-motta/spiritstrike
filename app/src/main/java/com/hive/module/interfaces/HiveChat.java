package com.hive.module.interfaces;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Chat;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000fH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0010H&J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0018H&J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001aH&J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001cH&J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020&H&J\u001a\u0010'\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010(2\u0006\u0010\u0006\u001a\u00020)H&J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020,H&J\u0018\u0010-\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020.H&J\u0018\u0010/\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u000200H&J\u0018\u00101\u001a\u00020\u00052\u0006\u0010\r\u001a\u0002022\u0006\u0010\u0006\u001a\u000203H&J\u0018\u00104\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u000205H&J \u00106\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u0010\r\u001a\u0002092\u0006\u0010\u0006\u001a\u00020:H&J \u0010;\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u0010<\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020=H&J(\u0010>\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020BH&J(\u0010C\u001a\u00020\u00052\u0006\u00107\u001a\u0002082\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0006\u001a\u00020BH&J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020EH&J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020GH&J\u0018\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00020J2\u0006\u0010\u0006\u001a\u00020KH&J\u0018\u0010L\u001a\u00020\u00052\u0006\u0010I\u001a\u00020J2\u0006\u0010\u0006\u001a\u00020MH&J\u0018\u0010N\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020O2\u0006\u0010\u0006\u001a\u00020PH&J\u0018\u0010Q\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020SH&¨\u0006T"}, d2 = {"Lcom/hive/module/interfaces/HiveChat;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "connect", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Chat$ConnectListener;", "reconnect", "Lcom/hive/Chat$ReconnectListener;", "disconnect", "Lcom/hive/Chat$DisconnectListener;", "sendMessage", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/hive/Chat$ChannelSendMessageParams;", "Lcom/hive/Chat$ChannelSendMessageListener;", "Lcom/hive/Chat$DirectSendMessageParams;", "Lcom/hive/Chat$DirectSendMessageListener;", "isConnected", "", "addConnectionListener", "uniqueKey", "Lcom/hive/Chat$ConnectionListener;", "addChannelListener", "Lcom/hive/Chat$ChannelListener;", "addDirectMessageListener", "Lcom/hive/Chat$DirectMessageListener;", "addUserListener", "Lcom/hive/Chat$UserListener;", "addCustomDataListener", "Lcom/hive/Chat$CustomDataListener;", "removeConnectionListener", "removeChannelListener", "removeDirectMessageListener", "removeUserListener", "removeCustomDataListener", "createChannel", "Lcom/hive/Chat$CreateChannelParams;", "Lcom/hive/Chat$CreateChannelListener;", "getChannels", "Lcom/hive/Chat$GetChannelsParams;", "Lcom/hive/Chat$GetChannelsListener;", "getChannelInfo", "channelId", "Lcom/hive/Chat$GetChannelInfoListener;", "getChannelMembers", "Lcom/hive/Chat$GetChannelMembersListener;", "deleteChannel", "Lcom/hive/Chat$DeleteChannelListener;", "enterChannel", "Lcom/hive/Chat$EnterChannelParams;", "Lcom/hive/Chat$EnterChannelListener;", "exitChannel", "Lcom/hive/Chat$ExitChannelListener;", "queryChannelMessageList", "channel", "Lcom/hive/Chat$Channel;", "Lcom/hive/Chat$ChannelMessageListQueryParams;", "Lcom/hive/Chat$ChannelMessageListQueryListener;", "setTranslationEnabled", "isEnabled", "Lcom/hive/Chat$ChannelTranslationSettingListener;", "addReaction", "messageId", "type", "Lcom/hive/Chat$ReactionType;", "Lcom/hive/Chat$ReactionListener;", "removeReaction", "getChannelsByUser", "Lcom/hive/Chat$GetChannelsByUserListener;", "getBlockMembers", "Lcom/hive/Chat$GetBlockMembersListener;", "blockMember", "blockPlayerId", "", "Lcom/hive/Chat$BlockMemberListener;", "unblockMember", "Lcom/hive/Chat$UnblockMemberListener;", "translate", "Lcom/hive/Chat$TranslateParams;", "Lcom/hive/Chat$TranslateListener;", "reportMessage", "Lcom/hive/Chat$ReportMessageParams;", "Lcom/hive/Chat$ReportMessageListener;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveChat extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(HiveChat hiveChat) {
            return HiveModuleName.INSTANCE.getChat();
        }
    }

    void addChannelListener(String uniqueKey, Chat.ChannelListener listener);

    void addConnectionListener(String uniqueKey, Chat.ConnectionListener listener);

    void addCustomDataListener(String uniqueKey, Chat.CustomDataListener listener);

    void addDirectMessageListener(String uniqueKey, Chat.DirectMessageListener listener);

    void addReaction(Chat.Channel channel, String messageId, Chat.ReactionType type, Chat.ReactionListener listener);

    void addUserListener(String uniqueKey, Chat.UserListener listener);

    void blockMember(long blockPlayerId, Chat.BlockMemberListener listener);

    void connect(Chat.ConnectListener listener);

    void createChannel(Chat.CreateChannelParams params, Chat.CreateChannelListener listener);

    void deleteChannel(String channelId, Chat.DeleteChannelListener listener);

    void disconnect(Chat.DisconnectListener listener);

    void enterChannel(Chat.EnterChannelParams params, Chat.EnterChannelListener listener);

    void exitChannel(String channelId, Chat.ExitChannelListener listener);

    void getBlockMembers(Chat.GetBlockMembersListener listener);

    void getChannelInfo(String channelId, Chat.GetChannelInfoListener listener);

    void getChannelMembers(String channelId, Chat.GetChannelMembersListener listener);

    void getChannels(Chat.GetChannelsParams params, Chat.GetChannelsListener listener);

    void getChannelsByUser(Chat.GetChannelsByUserListener listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    boolean isConnected();

    void queryChannelMessageList(Chat.Channel channel, Chat.ChannelMessageListQueryParams params, Chat.ChannelMessageListQueryListener listener);

    void reconnect(Chat.ReconnectListener listener);

    void removeChannelListener(String uniqueKey);

    void removeConnectionListener(String uniqueKey);

    void removeCustomDataListener(String uniqueKey);

    void removeDirectMessageListener(String uniqueKey);

    void removeReaction(Chat.Channel channel, String messageId, Chat.ReactionType type, Chat.ReactionListener listener);

    void removeUserListener(String uniqueKey);

    void reportMessage(Chat.ReportMessageParams params, Chat.ReportMessageListener listener);

    void sendMessage(Chat.ChannelSendMessageParams params);

    void sendMessage(Chat.ChannelSendMessageParams params, Chat.ChannelSendMessageListener listener);

    void sendMessage(Chat.DirectSendMessageParams params);

    void sendMessage(Chat.DirectSendMessageParams params, Chat.DirectSendMessageListener listener);

    void setTranslationEnabled(Chat.Channel channel, boolean isEnabled, Chat.ChannelTranslationSettingListener listener);

    void translate(Chat.TranslateParams params, Chat.TranslateListener listener);

    void unblockMember(long blockPlayerId, Chat.UnblockMemberListener listener);
}
