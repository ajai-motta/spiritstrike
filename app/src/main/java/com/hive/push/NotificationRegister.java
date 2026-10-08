package com.hive.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.C;
import com.hive.Configuration;
import com.hive.logger.LoggerImpl;
import com.hive.push.action.PushActionReceiver;
import com.hive.ui.Resource;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001d\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J9\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/hive/push/NotificationRegister;", "", "<init>", "()V", "TAG", "", "defaultChannelId", "defaultChannelName", "setNotification", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "setNotification$hive_service_release", "addActionData", "Landroidx/core/app/NotificationCompat$Builder;", "builder", "setToast", "setToast$hive_service_release", "findSoundId", "", "packageName", "variable", "createNotificationChannel", "channelId", "channelName", "soundUri", "Landroid/net/Uri;", "createNotificationChannel$hive_service_release", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationRegister {
    public static final NotificationRegister INSTANCE = new NotificationRegister();
    private static final String TAG = "NotificationRegister";
    private static final String defaultChannelId = "hive_default_channel";
    private static final String defaultChannelName = "Notification";

    private NotificationRegister() {
    }

    private final NotificationCompat.Builder addActionData(Context context, Intent intent, NotificationCompat.Builder builder) {
        String string;
        Object objM7415constructorimpl;
        Resource resource;
        String str;
        Bundle extras = intent.getExtras();
        if (extras == null || (string = extras.getString("actionInfo")) == null) {
            LoggerImpl.INSTANCE.d(PushConfig.INSTANCE.getTAG(), "NotificationRegister addActionData is null");
            return builder;
        }
        if (!Intrinsics.areEqual(string, AbstractJsonLexerKt.NULL)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject jSONObject = new JSONObject(string);
                String strOptString = jSONObject.optString("category");
                intent.putExtra("category", strOptString);
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                PushConfig pushConfig = PushConfig.INSTANCE;
                loggerImpl.d(pushConfig.getTAG(), "NotificationRegister addActionData, category: " + strOptString);
                JSONArray jSONArray = jSONObject.getJSONArray("actions");
                loggerImpl.d(pushConfig.getTAG(), "NotificationRegister addActionData, jsonArrayActions: " + jSONArray);
                int length = jSONArray.length();
                int i = 0;
                while (i < length) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string2 = jSONObject2.getString("actionId");
                    String string3 = jSONObject2.getString(NativeProtocol.WEB_DIALOG_ACTION);
                    String string4 = jSONObject2.getString("actionType");
                    String string5 = jSONObject2.getString("title");
                    LoggerImpl loggerImpl2 = LoggerImpl.INSTANCE;
                    PushConfig pushConfig2 = PushConfig.INSTANCE;
                    String tag = pushConfig2.getTAG();
                    int i2 = length;
                    StringBuilder sb = new StringBuilder();
                    JSONArray jSONArray2 = jSONArray;
                    sb.append("NotificationRegister addActionData, actionId: ");
                    sb.append(string2);
                    loggerImpl2.w(tag, sb.toString());
                    loggerImpl2.w(pushConfig2.getTAG(), "NotificationRegister addActionData, action: " + string3);
                    loggerImpl2.w(pushConfig2.getTAG(), "NotificationRegister addActionData, actionType: " + string4);
                    loggerImpl2.w(pushConfig2.getTAG(), "NotificationRegister addActionData, title: " + string5);
                    if (Configuration.getHiveTheme() == Configuration.HiveTheme.HiveLight) {
                        resource = Resource.INSTANCE;
                        str = "ic_push_action_send";
                    } else {
                        resource = Resource.INSTANCE;
                        str = "ic_push_action_send_black";
                    }
                    int drawableId = resource.getDrawableId(context, str);
                    intent.putExtra("actionType", string4);
                    intent.putExtra("actionId", string2);
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, string3);
                    Intent intent2 = new Intent(context, (Class<?>) PushActionReceiver.class);
                    intent2.putExtras(new Bundle(intent.getExtras()));
                    Bundle extras2 = intent.getExtras();
                    builder.addAction(drawableId, string5, PendingIntent.getBroadcast(context, ((extras2 != null ? extras2.getInt("noticeID") : -1) << 8) + i, intent2, Build.VERSION.SDK_INT >= 31 ? 201326592 : C.BUFFER_FLAG_FIRST_SAMPLE));
                    i++;
                    length = i2;
                    jSONArray = jSONArray2;
                }
                objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                LoggerImpl.INSTANCE.d(PushConfig.INSTANCE.getTAG(), "NotificationRegister addActionData onFailure : " + thM7418exceptionOrNullimpl);
            }
            Result.m7414boximpl(objM7415constructorimpl);
        }
        return builder;
    }

    public static /* synthetic */ void createNotificationChannel$hive_service_release$default(NotificationRegister notificationRegister, Context context, String str, String str2, Uri uri, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            uri = null;
        }
        notificationRegister.createNotificationChannel$hive_service_release(context, str, str2, uri);
    }

    private final int findSoundId(String packageName, String variable) {
        try {
            Class<?> cls = Class.forName(packageName + ".R$raw");
            return cls.getField(variable).getInt(cls);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setToast$lambda$8(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        Toast.makeText(context, Html.fromHtml(extras != null ? extras.getString(NotificationCompat.CATEGORY_MESSAGE) : null), 1).show();
    }

    public final void createNotificationChannel$hive_service_release(Context context, String channelId, String channelName, Uri soundUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Result.Companion companion = Result.INSTANCE;
                if (channelId == null) {
                    channelId = defaultChannelId;
                }
                if (channelName == null) {
                    channelName = defaultChannelName;
                }
                if (soundUri == null) {
                    soundUri = RingtoneManager.getDefaultUri(2);
                }
                NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, 4);
                notificationChannel.enableLights(true);
                notificationChannel.setShowBadge(true);
                notificationChannel.enableVibration(true);
                notificationChannel.setDescription("This is Notification Channel of Hive.");
                notificationChannel.setSound(soundUri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
                NotificationManagerCompat.from(context).createNotificationChannel(notificationChannel);
                Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:93|(1:95)(1:96)|(1:98)(1:99)|100|(1:102)|103|(1:105)|(1:108)|109|(14:223|111|112|225|113|114|180|(2:182|(5:187|(1:189)|190|(1:192)|193)(1:186))|(1:195)|(1:197)|234|198|(1:200)(3:201|231|(5:203|204|(4:207|(3:235|209|239)(1:238)|237|205)|236|210)(1:211))|218)(1:120)|121|(2:123|(6:133|(1:135)(1:136)|137|(1:139)(1:140)|141|(1:(1:144)(6:145|(1:147)|240|148|(1:150)|151))(10:152|(1:154)|241|155|156|(8:158|229|159|160|232|161|244|168)|242|169|(1:171)|172))(3:126|(3:128|(1:130)|131)|132))(3:173|(3:175|(1:177)|178)|179)|180|(0)|(0)|(0)|234|198|(0)(0)|218) */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x060f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0610, code lost:
    
        r5 = r16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04d7 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x052c A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x055f A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0566 A[Catch: all -> 0x0634, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0573 A[Catch: all -> 0x060f, TryCatch #6 {all -> 0x060f, blocks: (B:198:0x056b, B:200:0x0573, B:201:0x057a), top: B:234:0x056b }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x057a A[Catch: all -> 0x060f, TRY_LEAVE, TryCatch #6 {all -> 0x060f, blocks: (B:198:0x056b, B:200:0x0573, B:201:0x057a), top: B:234:0x056b }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ac A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00de A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f1 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f8 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0126 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013a A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014c A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0160 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0170 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b6 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c9 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f4 A[Catch: all -> 0x0634, TryCatch #2 {, blocks: (B:4:0x0013, B:6:0x0023, B:9:0x002f, B:11:0x0036, B:13:0x003f, B:16:0x0049, B:18:0x0050, B:21:0x005a, B:23:0x0060, B:26:0x006a, B:28:0x0070, B:31:0x007a, B:33:0x0081, B:38:0x0090, B:40:0x0097, B:45:0x00a6, B:47:0x00ac, B:52:0x00bb, B:54:0x00de, B:55:0x00e2, B:57:0x00f1, B:59:0x00fe, B:61:0x0126, B:63:0x0133, B:65:0x013a, B:67:0x0145, B:69:0x014c, B:71:0x015a, B:73:0x0160, B:76:0x016a, B:78:0x0170, B:80:0x0182, B:82:0x01b6, B:84:0x01be, B:86:0x01c9, B:87:0x01cf, B:91:0x01e6, B:93:0x01f4, B:95:0x01fd, B:98:0x023c, B:100:0x0271, B:102:0x0284, B:103:0x0289, B:105:0x02a5, B:108:0x02b1, B:111:0x02b9, B:113:0x02c4, B:180:0x050f, B:182:0x052c, B:184:0x0538, B:186:0x053e, B:187:0x0547, B:189:0x054e, B:190:0x0551, B:192:0x0557, B:193:0x055b, B:195:0x055f, B:197:0x0566, B:217:0x0612, B:119:0x02f1, B:121:0x0306, B:126:0x0324, B:128:0x0331, B:130:0x0352, B:131:0x0357, B:132:0x035a, B:133:0x035e, B:137:0x036d, B:139:0x0378, B:141:0x037b, B:144:0x03a3, B:145:0x03a7, B:147:0x03bb, B:148:0x03cd, B:150:0x0423, B:151:0x0426, B:152:0x042f, B:154:0x043e, B:155:0x046f, B:159:0x047b, B:161:0x048f, B:168:0x04be, B:167:0x04a6, B:169:0x04c3, B:171:0x04cc, B:172:0x04cf, B:173:0x04d7, B:175:0x04e8, B:177:0x0507, B:178:0x050a, B:179:0x050d, B:99:0x0252, B:58:0x00f8, B:8:0x002b), top: B:227:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0238  */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v7, types: [int] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v66 */
    /* JADX WARN: Type inference failed for: r5v67 */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void setNotification$hive_service_release(android.content.Context r41, android.content.Intent r42) {
        /*
            Method dump skipped, instruction units count: 1591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.push.NotificationRegister.setNotification$hive_service_release(android.content.Context, android.content.Intent):void");
    }

    public final void setToast$hive_service_release(final Context context, final Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.hive.push.NotificationRegister$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NotificationRegister.setToast$lambda$8(context, intent);
            }
        });
    }
}
