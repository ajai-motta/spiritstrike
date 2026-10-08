package com.hive.plugin;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.Chat;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Chat {
    private final ICallEngine callEngine;

    public Chat(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String connect(final String str, final JSONObject jSONObject) {
        com.hive.Chat.connect(new Chat.ConnectListener() { // from class: com.hive.plugin.Chat.1
            @Override // com.hive.Chat.ConnectListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String reconnect(final String str, final JSONObject jSONObject) {
        com.hive.Chat.reconnect(new Chat.ReconnectListener() { // from class: com.hive.plugin.Chat.2
            @Override // com.hive.Chat.ReconnectListener
            public void onResult(ResultAPI resultAPI, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObjectCreateResponse.put("channelIds", jSONArray);
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<String> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        jSONArray2.put(it2.next());
                    }
                    jSONObjectCreateResponse.put("failChannelIds", jSONArray2);
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String disconnect(final String str, final JSONObject jSONObject) {
        com.hive.Chat chat = com.hive.Chat.INSTANCE;
        com.hive.Chat.disconnect(new Chat.DisconnectListener() { // from class: com.hive.plugin.Chat.3
            @Override // com.hive.Chat.DisconnectListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String sendMessageWithChannelSendMessageParams(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        Chat.ChannelSendMessageParams channelSendMessageParams = new Chat.ChannelSendMessageParams(jSONObject2);
        final String strOptString = jSONObject.optString("uniqueKey");
        if (TextUtils.isEmpty(strOptString)) {
            com.hive.Chat.sendMessage(channelSendMessageParams);
            return "";
        }
        com.hive.Chat.sendMessage(channelSendMessageParams, new Chat.ChannelSendMessageListener() { // from class: com.hive.plugin.Chat.4
            @Override // com.hive.Chat.ChannelSendMessageListener
            public void onResult(ResultAPI resultAPI, Chat.ChannelSendMessageParams channelSendMessageParams2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("uniqueKey", strOptString);
                } catch (Exception unused2) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String sendMessageWithDirectSendMessageParams(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        Chat.DirectSendMessageParams directSendMessageParams = new Chat.DirectSendMessageParams(jSONObject2);
        final String strOptString = jSONObject.optString("uniqueKey");
        if (TextUtils.isEmpty(strOptString)) {
            com.hive.Chat.sendMessage(directSendMessageParams);
            return "";
        }
        com.hive.Chat.sendMessage(directSendMessageParams, new Chat.DirectSendMessageListener() { // from class: com.hive.plugin.Chat.5
            @Override // com.hive.Chat.DirectSendMessageListener
            public void onResult(ResultAPI resultAPI, Chat.DirectSendMessageParams directSendMessageParams2) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("uniqueKey", strOptString);
                } catch (Exception unused2) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String isConnected(String str, JSONObject jSONObject) {
        boolean zIsConnected = com.hive.Chat.isConnected();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("isConnected", zIsConnected);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject createEventResponse(String str, ResultAPI resultAPI, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("class", jSONObject.optString("class"));
            jSONObject2.put(FirebaseAnalytics.Param.METHOD, jSONObject.optString(FirebaseAnalytics.Param.METHOD));
            jSONObject2.put("event", str);
            jSONObject2.put("uniqueKey", jSONObject.optString("uniqueKey"));
            if (resultAPI != null) {
                jSONObject2.put("resultAPI", resultAPI.toJson());
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public String addConnectionListener(final String str, final JSONObject jSONObject) {
        com.hive.Chat.addConnectionListener(jSONObject.optString("uniqueKey"), new Chat.ConnectionListener() { // from class: com.hive.plugin.Chat.6
            @Override // com.hive.Chat.ConnectionListener
            public void onConnected() {
                Chat.this.callEngine.callEngine(str, Chat.this.createEventResponse("onConnected", null, jSONObject).toString());
            }

            @Override // com.hive.Chat.ConnectionListener
            public void onReconnectStarted() {
                Chat.this.callEngine.callEngine(str, Chat.this.createEventResponse("onReconnectStarted", null, jSONObject).toString());
            }

            @Override // com.hive.Chat.ConnectionListener
            public void onReconnected(ResultAPI resultAPI, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onReconnected", resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next());
                    }
                    jSONObjectCreateEventResponse.put("channelIds", jSONArray);
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<String> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        jSONArray2.put(it2.next());
                    }
                    jSONObjectCreateEventResponse.put("failChannelIds", jSONArray2);
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }

            @Override // com.hive.Chat.ConnectionListener
            public void onDisconnected() {
                Chat.this.callEngine.callEngine(str, Chat.this.createEventResponse("onDisconnected", null, jSONObject).toString());
            }
        });
        return "";
    }

    public String addChannelListener(final String str, final JSONObject jSONObject) {
        com.hive.Chat.addChannelListener(jSONObject.optString("uniqueKey"), new Chat.ChannelListener() { // from class: com.hive.plugin.Chat.7
            @Override // com.hive.Chat.ChannelListener
            public void onEnteredMember(Chat.EnteredMember enteredMember) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onEnteredMember", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("member", enteredMember.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }

            @Override // com.hive.Chat.ChannelListener
            public void onExitedMember(Chat.ExitedMember exitedMember) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onExitedMember", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("member", exitedMember.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }

            @Override // com.hive.Chat.ChannelListener
            public void onDeletedChannel(Chat.DeletedChannel deletedChannel) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onDeletedChannel", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("channel", deletedChannel.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }

            @Override // com.hive.Chat.ChannelListener
            public void onNoticeMessage(Chat.ChannelNoticeMessage channelNoticeMessage) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onNoticeMessage", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("message", channelNoticeMessage.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }

            @Override // com.hive.Chat.ChannelListener
            public void onChannelMessage(Chat.ChannelMessage channelMessage) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onChannelMessage", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("message", channelMessage.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }

            @Override // com.hive.Chat.ChannelListener
            public void onAddReaction(Chat.Reaction reaction) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onAddReaction", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("reaction", reaction.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }

            @Override // com.hive.Chat.ChannelListener
            public void onRemoveReaction(Chat.Reaction reaction) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onRemoveReaction", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("reaction", reaction.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }
        });
        return "";
    }

    public String addDirectMessageListener(final String str, final JSONObject jSONObject) {
        com.hive.Chat.addDirectMessageListener(jSONObject.optString("uniqueKey"), new Chat.DirectMessageListener() { // from class: com.hive.plugin.Chat.8
            @Override // com.hive.Chat.DirectMessageListener
            public void onDirectMessage(Chat.DirectMessage directMessage) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onDirectMessage", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("message", directMessage.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }
        });
        return "";
    }

    public String addUserListener(final String str, final JSONObject jSONObject) {
        com.hive.Chat.addUserListener(jSONObject.optString("uniqueKey"), new Chat.UserListener() { // from class: com.hive.plugin.Chat.9
            @Override // com.hive.Chat.UserListener
            public void onDirectMessage(Chat.DirectMessage directMessage) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onDirectMessage", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("message", directMessage.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }

            @Override // com.hive.Chat.UserListener
            public void onNoticeMessage(Chat.NoticeMessage noticeMessage) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onNoticeMessage", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("message", noticeMessage.toJSON());
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }
        });
        return "";
    }

    public String addCustomDataListener(final String str, final JSONObject jSONObject) {
        com.hive.Chat.addCustomDataListener(jSONObject.optString("uniqueKey"), new Chat.CustomDataListener() { // from class: com.hive.plugin.Chat.10
            @Override // com.hive.Chat.CustomDataListener
            public void onCustomData(String str2) {
                JSONObject jSONObjectCreateEventResponse = Chat.this.createEventResponse("onCustomData", null, jSONObject);
                try {
                    jSONObjectCreateEventResponse.put("data", str2);
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateEventResponse.toString());
            }
        });
        return "";
    }

    public String removeConnectionListener(String str, JSONObject jSONObject) {
        com.hive.Chat.removeConnectionListener(jSONObject.optString("uniqueKey"));
        return "";
    }

    public String removeChannelListener(String str, JSONObject jSONObject) {
        com.hive.Chat.removeChannelListener(jSONObject.optString("uniqueKey"));
        return "";
    }

    public String removeDirectMessageListener(String str, JSONObject jSONObject) {
        com.hive.Chat.removeDirectMessageListener(jSONObject.optString("uniqueKey"));
        return "";
    }

    public String removeUserListener(String str, JSONObject jSONObject) {
        com.hive.Chat.removeUserListener(jSONObject.optString("uniqueKey"));
        return "";
    }

    public String removeCustomDataListener(String str, JSONObject jSONObject) {
        com.hive.Chat.removeCustomDataListener(jSONObject.optString("uniqueKey"));
        return "";
    }

    public String createChannel(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        com.hive.Chat.createChannel(new Chat.CreateChannelParams(jSONObject2), new Chat.CreateChannelListener() { // from class: com.hive.plugin.Chat.11
            @Override // com.hive.Chat.CreateChannelListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String getChannels(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        Chat.GetChannelsParams getChannelsParams;
        String strOptString = jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS);
        if (TextUtils.isEmpty(strOptString)) {
            getChannelsParams = null;
        } else {
            try {
                jSONObject2 = new JSONObject(strOptString);
            } catch (Exception unused) {
                jSONObject2 = new JSONObject();
            }
            getChannelsParams = new Chat.GetChannelsParams(jSONObject2);
        }
        com.hive.Chat.getChannels(getChannelsParams, new Chat.GetChannelsListener() { // from class: com.hive.plugin.Chat.12
            @Override // com.hive.Chat.GetChannelsListener
            public void onResult(ResultAPI resultAPI, ArrayList<Chat.Channel> arrayList, Chat.ChannelPage channelPage) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<Chat.Channel> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                    jSONObjectCreateResponse.put("channels", jSONArray);
                    if (channelPage != null) {
                        jSONObjectCreateResponse.put("channelPage", channelPage.toJSON());
                    }
                } catch (Exception unused2) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getChannelInfo(final String str, final JSONObject jSONObject) {
        com.hive.Chat.getChannelInfo(jSONObject.optString("channelId"), new Chat.GetChannelInfoListener() { // from class: com.hive.plugin.Chat.13
            @Override // com.hive.Chat.GetChannelInfoListener
            public void onResult(ResultAPI resultAPI, Chat.Channel channel, ArrayList<Chat.Member> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (channel != null) {
                    try {
                        jSONObjectCreateResponse.put("channel", channel.toJSON());
                    } catch (Exception unused) {
                    }
                }
                JSONArray jSONArray = new JSONArray();
                Iterator<Chat.Member> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
                jSONObjectCreateResponse.put("members", jSONArray);
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getChannelMembers(final String str, final JSONObject jSONObject) {
        com.hive.Chat.getChannelMembers(jSONObject.optString("channelId"), new Chat.GetChannelMembersListener() { // from class: com.hive.plugin.Chat.14
            @Override // com.hive.Chat.GetChannelMembersListener
            public void onResult(ResultAPI resultAPI, ArrayList<Chat.Member> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<Chat.Member> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                    jSONObjectCreateResponse.put("members", jSONArray);
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String deleteChannel(final String str, final JSONObject jSONObject) {
        com.hive.Chat.deleteChannel(jSONObject.optString("channelId"), new Chat.DeleteChannelListener() { // from class: com.hive.plugin.Chat.15
            @Override // com.hive.Chat.DeleteChannelListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String enterChannel(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        com.hive.Chat.enterChannel(new Chat.EnterChannelParams(jSONObject2), new Chat.EnterChannelListener() { // from class: com.hive.plugin.Chat.16
            @Override // com.hive.Chat.EnterChannelListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String exitChannel(final String str, final JSONObject jSONObject) {
        com.hive.Chat.exitChannel(jSONObject.optString("channelId"), new Chat.ExitChannelListener() { // from class: com.hive.plugin.Chat.17
            @Override // com.hive.Chat.ExitChannelListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String getChannelsByUser(final String str, final JSONObject jSONObject) {
        com.hive.Chat.getChannelsByUser(new Chat.GetChannelsByUserListener() { // from class: com.hive.plugin.Chat.18
            @Override // com.hive.Chat.GetChannelsByUserListener
            public void onResult(ResultAPI resultAPI, ArrayList<Chat.Channel> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<Chat.Channel> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                    jSONObjectCreateResponse.put("channels", jSONArray);
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String getBlockMembers(final String str, final JSONObject jSONObject) {
        com.hive.Chat.getBlockMembers(new Chat.GetBlockMembersListener() { // from class: com.hive.plugin.Chat.19
            @Override // com.hive.Chat.GetBlockMembersListener
            public void onResult(ResultAPI resultAPI, ArrayList<Chat.BlockMember> arrayList) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<Chat.BlockMember> it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().toJSON());
                    }
                    jSONObjectCreateResponse.put("blockMembers", jSONArray);
                } catch (Exception unused) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String blockMember(final String str, final JSONObject jSONObject) {
        com.hive.Chat.blockMember(jSONObject.optLong("blockPlayerId"), new Chat.BlockMemberListener() { // from class: com.hive.plugin.Chat.20
            @Override // com.hive.Chat.BlockMemberListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String unblockMember(final String str, final JSONObject jSONObject) {
        com.hive.Chat.unblockMember(jSONObject.optLong("blockPlayerId"), new Chat.UnblockMemberListener() { // from class: com.hive.plugin.Chat.21
            @Override // com.hive.Chat.UnblockMemberListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String ChannelMessageListQuery(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String strOptString = jSONObject.optString("channel");
        String strOptString2 = jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS);
        try {
            jSONObject2 = new JSONObject(strOptString);
            jSONObject3 = new JSONObject(strOptString2);
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
            jSONObject3 = new JSONObject();
        }
        new Chat.Channel(jSONObject2).query(new Chat.ChannelMessageListQueryParams(jSONObject3), new Chat.ChannelMessageListQueryListener() { // from class: com.hive.plugin.Chat.22
            @Override // com.hive.Chat.ChannelMessageListQueryListener
            public void onResult(ResultAPI resultAPI, Chat.ChannelMessageListQueryResponse channelMessageListQueryResponse) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (channelMessageListQueryResponse != null) {
                    try {
                        jSONObjectCreateResponse.put("response", channelMessageListQueryResponse.toJSON());
                    } catch (Exception unused2) {
                    }
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String ChannelSetTranslationEnabled(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString("channel"));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        new Chat.Channel(jSONObject2).setTranslationEnabled(jSONObject.optBoolean("isEnabled"), new Chat.ChannelTranslationSettingListener() { // from class: com.hive.plugin.Chat.23
            @Override // com.hive.Chat.ChannelTranslationSettingListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String ChannelAddReaction(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString("channel"));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        Chat.Channel channel = new Chat.Channel(jSONObject2);
        String strOptString = jSONObject.optString("messageId");
        Chat.ReactionType value = Chat.ReactionType.getValue(jSONObject.optString("type"));
        if (value == null) {
            value = Chat.ReactionType.Like;
        }
        channel.addReaction(strOptString, value, new Chat.ReactionListener() { // from class: com.hive.plugin.Chat.24
            @Override // com.hive.Chat.ReactionListener
            public void onResult(ResultAPI resultAPI, Chat.ReactionType reactionType) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("type", reactionType.name());
                } catch (Exception unused2) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String ChannelRemoveReaction(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString("channel"));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        Chat.Channel channel = new Chat.Channel(jSONObject2);
        String strOptString = jSONObject.optString("messageId");
        Chat.ReactionType value = Chat.ReactionType.getValue(jSONObject.optString("type"));
        if (value == null) {
            value = Chat.ReactionType.Like;
        }
        channel.removeReaction(strOptString, value, new Chat.ReactionListener() { // from class: com.hive.plugin.Chat.25
            @Override // com.hive.Chat.ReactionListener
            public void onResult(ResultAPI resultAPI, Chat.ReactionType reactionType) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("type", reactionType.name());
                } catch (Exception unused2) {
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String translate(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        com.hive.Chat.translate(new Chat.TranslateParams(jSONObject2), new Chat.TranslateListener() { // from class: com.hive.plugin.Chat.26
            @Override // com.hive.Chat.TranslateListener
            public void onResult(ResultAPI resultAPI, Chat.TranslationData translationData) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                if (translationData != null) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        for (Map.Entry<String, String> entry : translationData.getTranslations().entrySet()) {
                            jSONObject3.put(entry.getKey(), entry.getValue());
                        }
                        jSONObjectCreateResponse.put("translations", jSONObject3);
                    } catch (Exception unused2) {
                    }
                }
                Chat.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String reportMessage(final String str, final JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject(jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS));
        } catch (Exception unused) {
            jSONObject2 = new JSONObject();
        }
        com.hive.Chat.reportMessage(new Chat.ReportMessageParams(jSONObject2), new Chat.ReportMessageListener() { // from class: com.hive.plugin.Chat.27
            @Override // com.hive.Chat.ReportMessageListener
            public void onResult(ResultAPI resultAPI) {
                Chat.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        if ("isConnected".equals(str)) {
            return isConnected(str2, jSONObject);
        }
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.Chat.28
            @Override // java.lang.Runnable
            public void run() {
                if ("connect".equals(str)) {
                    Chat.this.connect(str2, jSONObject);
                    return;
                }
                if ("reconnect".equals(str)) {
                    Chat.this.reconnect(str2, jSONObject);
                    return;
                }
                if ("disconnect".equals(str)) {
                    Chat.this.disconnect(str2, jSONObject);
                    return;
                }
                if ("sendMessageWithChannelSendMessageParams".equals(str)) {
                    Chat.this.sendMessageWithChannelSendMessageParams(str2, jSONObject);
                    return;
                }
                if ("sendMessageWithDirectSendMessageParams".equals(str)) {
                    Chat.this.sendMessageWithDirectSendMessageParams(str2, jSONObject);
                    return;
                }
                if ("addConnectionListener".equals(str)) {
                    Chat.this.addConnectionListener(str2, jSONObject);
                    return;
                }
                if ("addChannelListener".equals(str)) {
                    Chat.this.addChannelListener(str2, jSONObject);
                    return;
                }
                if ("addDirectMessageListener".equals(str)) {
                    Chat.this.addDirectMessageListener(str2, jSONObject);
                    return;
                }
                if ("addUserListener".equals(str)) {
                    Chat.this.addUserListener(str2, jSONObject);
                    return;
                }
                if ("addCustomDataListener".equals(str)) {
                    Chat.this.addCustomDataListener(str2, jSONObject);
                    return;
                }
                if ("removeConnectionListener".equals(str)) {
                    Chat.this.removeConnectionListener(str2, jSONObject);
                    return;
                }
                if ("removeChannelListener".equals(str)) {
                    Chat.this.removeChannelListener(str2, jSONObject);
                    return;
                }
                if ("removeDirectMessageListener".equals(str)) {
                    Chat.this.removeDirectMessageListener(str2, jSONObject);
                    return;
                }
                if ("removeUserListener".equals(str)) {
                    Chat.this.removeUserListener(str2, jSONObject);
                    return;
                }
                if ("removeCustomDataListener".equals(str)) {
                    Chat.this.removeCustomDataListener(str2, jSONObject);
                    return;
                }
                if ("createChannel".equals(str)) {
                    Chat.this.createChannel(str2, jSONObject);
                    return;
                }
                if ("getChannels".equals(str)) {
                    Chat.this.getChannels(str2, jSONObject);
                    return;
                }
                if ("getChannelInfo".equals(str)) {
                    Chat.this.getChannelInfo(str2, jSONObject);
                    return;
                }
                if ("getChannelMembers".equals(str)) {
                    Chat.this.getChannelMembers(str2, jSONObject);
                    return;
                }
                if ("deleteChannel".equals(str)) {
                    Chat.this.deleteChannel(str2, jSONObject);
                    return;
                }
                if ("enterChannel".equals(str)) {
                    Chat.this.enterChannel(str2, jSONObject);
                    return;
                }
                if ("exitChannel".equals(str)) {
                    Chat.this.exitChannel(str2, jSONObject);
                    return;
                }
                if ("getChannelsByUser".equals(str)) {
                    Chat.this.getChannelsByUser(str2, jSONObject);
                    return;
                }
                if ("getBlockMembers".equals(str)) {
                    Chat.this.getBlockMembers(str2, jSONObject);
                    return;
                }
                if ("blockMember".equals(str)) {
                    Chat.this.blockMember(str2, jSONObject);
                    return;
                }
                if ("unblockMember".equals(str)) {
                    Chat.this.unblockMember(str2, jSONObject);
                    return;
                }
                if ("ChannelMessageListQuery".equals(str)) {
                    Chat.this.ChannelMessageListQuery(str2, jSONObject);
                    return;
                }
                if ("ChannelSetTranslationEnabled".equals(str)) {
                    Chat.this.ChannelSetTranslationEnabled(str2, jSONObject);
                    return;
                }
                if ("ChannelAddReaction".equals(str)) {
                    Chat.this.ChannelAddReaction(str2, jSONObject);
                    return;
                }
                if ("ChannelRemoveReaction".equals(str)) {
                    Chat.this.ChannelRemoveReaction(str2, jSONObject);
                } else if ("translate".equals(str)) {
                    Chat.this.translate(str2, jSONObject);
                } else if ("reportMessage".equals(str)) {
                    Chat.this.reportMessage(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
