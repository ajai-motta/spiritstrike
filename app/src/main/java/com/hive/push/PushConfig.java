package com.hive.push;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.messaging.Constants;
import com.hive.Push;
import com.hive.base.Property;
import com.hive.core.Network;
import com.hive.core.Request;
import com.hive.logger.LoggerImpl;
import com.hive.push.PushImpl;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u001a\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0002\b\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u001dJ*\u0010\u001e\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001d\u0010$\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'J\u0017\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0002\b+J\u0012\u0010,\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006-"}, d2 = {"Lcom/hive/push/PushConfig;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setReceiveDataNew", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "intent", "setReceiveData", "startPushWakeLock", "", "setPushType", "clearBadge", "increaseBadge", "setBadge", "badgeCount", "", "getBitmapFromByteArray", "Landroid/graphics/Bitmap;", "bitmapData", "", "getBitmapFromByteArray$hive_service_release", "getByteFromUrl", "url", "getByteFromUrl$hive_service_release", "resourceID", "name", "type", "packageName", "isRunningThisActivity", "getLauncherClassName", "saveReceivedPush", "data", "Landroid/os/Bundle;", "saveReceivedPush$hive_service_release", "sendReceivedPushWithCallback", "pushCallback", "Lcom/hive/push/PushImpl$PushCallback;", "sendReceivedPushWithCallback$hive_service_release", "sendReceivedPush", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushConfig {
    public static final PushConfig INSTANCE = new PushConfig();
    private static final String TAG = "Push";

    private PushConfig() {
    }

    private final String getLauncherClassName(Context context) {
        ComponentName component;
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            String className = (launchIntentForPackage == null || (component = launchIntentForPackage.getComponent()) == null) ? null : component.getClassName();
            LoggerImpl.INSTANCE.d(TAG, "getLauncherClassName : " + className);
            return className;
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(Push.getTAG(), "getLauncherClassName exception - " + e);
            return null;
        }
    }

    private final int isRunningThisActivity(Context context) {
        LoggerImpl.INSTANCE.d(Push.getTAG(), "isRunningThisActivity check");
        Object systemService = context.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        HashSet hashSet = new HashSet();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    String[] strArr = runningAppProcessInfo.pkgList;
                    hashSet.addAll(Arrays.asList(Arrays.copyOf(strArr, strArr.length)));
                }
            }
        }
        for (String str : (String[]) hashSet.toArray(new String[0])) {
            if (Intrinsics.areEqual(str, context.getPackageName())) {
                LoggerImpl.INSTANCE.d(Push.getTAG(), "isRunningThisActivity - gaming");
                return 1;
            }
        }
        LoggerImpl.INSTANCE.d(Push.getTAG(), "isRunningThisActivity - show nothing");
        return 0;
    }

    private final int resourceID(Context context, String name, String type, String packageName) {
        return context.getResources().getIdentifier(name, type, packageName);
    }

    private final synchronized void sendReceivedPush(final PushImpl.PushCallback pushCallback) {
        boolean z;
        Exception e;
        final int iCountTokens;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(Push.getTAG(), "sendReceivedPush");
        if (pushCallback == null) {
            loggerImpl.d(Push.getTAG(), "PushCallback is null");
            return;
        }
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        String value = instance.getValue(pushKeys.getRECEIVED_PUSH());
        loggerImpl.d(Push.getTAG(), "receivedPushIDs : " + value);
        if (value != null && !StringsKt.isBlank(value)) {
            Property.setValue$default(companion.getINSTANCE(), pushKeys.getRECEIVED_PUSH(), "", null, 4, null);
            companion.getINSTANCE().writeProperties();
            StringTokenizer stringTokenizer = new StringTokenizer(value, "|");
            final int iIntValue = -1;
            while (stringTokenizer.hasMoreElements()) {
                boolean z2 = false;
                try {
                    String strNextToken = stringTokenizer.nextToken();
                    Intrinsics.checkNotNull(strNextToken);
                    if (StringsKt.startsWith$default(strNextToken, Constants.MessageTypes.MESSAGE, false, 2, (Object) null)) {
                        z = true;
                        try {
                            String strSubstring = strNextToken.substring(3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            Integer numValueOf = Integer.valueOf(strSubstring);
                            Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(...)");
                            iIntValue = numValueOf.intValue();
                            z2 = true;
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            LoggerImpl.INSTANCE.w(Push.getTAG(), "Received PushID Error. : " + iIntValue);
                            iIntValue = -1;
                            iCountTokens = -1;
                            z2 = z;
                        }
                    } else {
                        String strSubstring2 = strNextToken.substring(5);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        Integer numValueOf2 = Integer.valueOf(strSubstring2);
                        Intrinsics.checkNotNullExpressionValue(numValueOf2, "valueOf(...)");
                        iIntValue = numValueOf2.intValue();
                    }
                    iCountTokens = stringTokenizer.countTokens();
                } catch (Exception e3) {
                    z = false;
                    e = e3;
                }
                if (z2) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.push.PushConfig$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            PushConfig.sendReceivedPush$lambda$14(iIntValue, iCountTokens, pushCallback);
                        }
                    });
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.push.PushConfig$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            PushConfig.sendReceivedPush$lambda$16(iIntValue, iCountTokens, pushCallback);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendReceivedPush$lambda$14(int i, int i2, PushImpl.PushCallback pushCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pushid", i);
            jSONObject.put("remain", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pushCallback.onReceivedGCMPush(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendReceivedPush$lambda$16(int i, int i2, PushImpl.PushCallback pushCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pushid", i);
            jSONObject.put("remain", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pushCallback.onReceivedLocalPush(i, i2);
    }

    public final void clearBadge(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setBadge(context, 0);
    }

    public final Bitmap getBitmapFromByteArray$hive_service_release(byte[] bitmapData) {
        LoggerImpl.INSTANCE.d(TAG, "getBitmapFromByteArray");
        if (bitmapData != null) {
            try {
                return BitmapFactory.decodeByteArray(bitmapData, 0, bitmapData.length);
            } catch (Exception e) {
                LoggerImpl.INSTANCE.w(TAG, "getBitmapFromByteArray Exception : " + e);
            }
        }
        return null;
    }

    public final byte[] getByteFromUrl$hive_service_release(String url) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.d(str, "getByteFromUrl : " + url);
        if (url != null && !StringsKt.isBlank(url)) {
            return Network.INSTANCE.sync(new Request(url, Request.MethodType.GET)).getContent();
        }
        loggerImpl.d(str, "url is Empty");
        return null;
    }

    public final String getTAG() {
        return TAG;
    }

    public final void increaseBadge(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        setBadge(context, -1);
    }

    public final void saveReceivedPush$hive_service_release(Context context, Bundle data) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str2 = TAG;
        loggerImpl.d(str2, "saveReceivedPush() : " + data.getInt("noticeID"));
        int i = data.getInt("noticeID", 0);
        if (i == 0) {
            return;
        }
        if (data.getBoolean("isRemotePush")) {
            str = Constants.MessageTypes.MESSAGE + i;
        } else {
            str = "local" + i;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Property.Companion companion = Property.INSTANCE;
        Property instance = companion.getINSTANCE();
        PushKeys pushKeys = PushKeys.INSTANCE;
        String value = instance.getValue(pushKeys.getRECEIVED_PUSH());
        loggerImpl.d(str2, "saveReceivedPush() saved Received Push : " + value);
        if (value == null || StringsKt.isBlank(value) || Intrinsics.areEqual(value, AbstractJsonLexerKt.NULL)) {
            stringBuffer.append(str);
            Property.setValue$default(companion.getINSTANCE(), pushKeys.getRECEIVED_PUSH(), stringBuffer.toString(), null, 4, null);
        } else {
            stringBuffer.append("|").append(str);
            Property.setValue$default(companion.getINSTANCE(), pushKeys.getRECEIVED_PUSH(), value + ((Object) stringBuffer), null, 4, null);
        }
        companion.getINSTANCE().writeProperties();
        sendReceivedPush(PushImpl.INSTANCE.getC2sPushCallback());
    }

    public final void sendReceivedPushWithCallback$hive_service_release(PushImpl.PushCallback pushCallback) {
        sendReceivedPush(pushCallback);
    }

    public final void setBadge(Context context, int badgeCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            LoggerImpl.INSTANCE.d(TAG, "setBadge : " + badgeCount);
            if (badgeCount == -1) {
                try {
                    badgeCount = Integer.parseInt(Property.INSTANCE.getINSTANCE().getValue(PushKeys.INSTANCE.getBADGE_COUNT(), AppEventsConstants.EVENT_PARAM_VALUE_NO)) + 1;
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.w(TAG, e.toString());
                    badgeCount = 1;
                }
            }
            Property.Companion companion = Property.INSTANCE;
            Property.setValue$default(companion.getINSTANCE(), PushKeys.INSTANCE.getBADGE_COUNT(), String.valueOf(badgeCount), null, 4, null);
            companion.getINSTANCE().writeProperties();
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", badgeCount);
            intent.putExtra("badge_count_package_name", context.getPackageName());
            intent.putExtra("badge_count_class_name", getLauncherClassName(context));
            context.sendBroadcast(intent);
        }
    }

    public final void setPushType(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.getIntExtra("isRunning", 0);
        intent.getBooleanExtra("bScreenLock", false);
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString("type") : null;
        if (string == null || !(!StringsKt.isBlank(string))) {
            LoggerImpl.INSTANCE.d(TAG, "setPushType : type is null, default bar");
            NotificationRegister.INSTANCE.setNotification$hive_service_release(context, intent);
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
            while (stringTokenizer.hasMoreElements()) {
                String strNextToken = stringTokenizer.nextToken();
                Intrinsics.checkNotNullExpressionValue(strNextToken, "nextToken(...)");
                String lowerCase = strNextToken.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String string2 = StringsKt.trim((CharSequence) lowerCase).toString();
                int iHashCode = string2.hashCode();
                if (iHashCode != 97299) {
                    if (iHashCode != 3076010) {
                        if (iHashCode == 110532135 && string2.equals("toast")) {
                            LoggerImpl.INSTANCE.d(TAG, "setPushType : toast");
                            NotificationRegister.INSTANCE.setToast$hive_service_release(context, intent);
                        }
                    } else if (string2.equals("data")) {
                        LoggerImpl.INSTANCE.d(TAG, "setPushType : data");
                        return;
                    }
                    LoggerImpl.INSTANCE.w(TAG, "setPushType : this type(" + string2 + ") is not supported");
                } else if (string2.equals("bar")) {
                    LoggerImpl.INSTANCE.d(TAG, "setPushType : bar");
                    NotificationRegister.INSTANCE.setNotification$hive_service_release(context, intent);
                } else {
                    LoggerImpl.INSTANCE.w(TAG, "setPushType : this type(" + string2 + ") is not supported");
                }
            }
        }
        int intExtra = intent.getIntExtra("badge", 1);
        if (intExtra == 1) {
            increaseBadge(context);
        } else {
            setBadge(context, intExtra);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(81:10|(2:237|11)|15|(1:17)|18|(1:20)|21|(79:23|(1:25)(1:26)|27|(1:39)(4:31|234|32|(1:34)(1:35))|36|40|43|(1:45)|(3:47|(1:49)(1:50)|51)(1:52)|53|(1:57)(1:56)|58|(1:66)(2:232|62)|67|(1:73)(1:72)|74|243|75|76|247|77|(4:79|80|235|81)(1:82)|83|84|(1:94)(1:93)|95|239|96|(1:98)(1:99)|100|101|(1:109)(1:108)|110|(1:116)(1:115)|117|252|118|122|(1:124)(1:125)|126|(1:138)(5:130|250|131|(1:133)(1:134)|249)|139|241|140|(1:145)(1:144)|146|150|245|151|(1:153)(1:154)|155|159|(2:161|(1:163))(1:164)|165|(1:169)|170|(2:172|(1:174))(1:175)|176|(1:180)|181|(1:185)|186|(1:190)|191|(2:193|(1:195))(1:196)|197|(1:203)(1:202)|204|(1:208)|209|(1:213)|214|(1:218)|219|(1:223)|224|(1:226)|227|228)(1:41)|42|43|(0)|(0)(0)|53|(1:57)(0)|58|(2:60|66)(0)|67|(2:69|73)(0)|74|243|75|76|247|77|(0)(0)|83|84|(0)(1:94)|95|239|96|(0)(0)|100|101|(0)(1:109)|110|(2:112|116)(0)|117|252|118|122|(0)(0)|126|(2:128|138)(0)|139|241|140|(3:142|145|146)(0)|150|245|151|(0)(0)|155|159|(0)(0)|165|(2:167|169)|170|(0)(0)|176|(2:178|180)|181|(2:183|185)|186|(2:188|190)|191|(0)(0)|197|(2:199|203)(0)|204|(2:206|208)(0)|209|(2:211|213)(0)|214|(2:216|218)(0)|219|(2:221|223)(0)|224|(0)|227|228) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02b6, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x030f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0310, code lost:
    
        r8 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m7415constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03a5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x03a6, code lost:
    
        com.hive.logger.LoggerImpl.INSTANCE.w(com.hive.push.PushConfig.TAG, r0.toString());
        r24.putExtra("buckettype", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03c3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03c4, code lost:
    
        com.hive.logger.LoggerImpl.INSTANCE.w(com.hive.push.PushConfig.TAG, r0.toString());
        r24.putExtra("bucketsize", 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0252, code lost:
    
        r16 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0255, code lost:
    
        r16 = r7;
        r17 = "smallIconResID";
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0226 A[Catch: Exception -> 0x0252, TRY_LEAVE, TryCatch #8 {Exception -> 0x0252, blocks: (B:77:0x021c, B:79:0x0226), top: B:247:0x021c }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x028e A[Catch: Exception -> 0x02b6, TryCatch #4 {Exception -> 0x02b6, blocks: (B:96:0x027a, B:98:0x028e, B:100:0x02a0), top: B:239:0x027a }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x029f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.content.Intent setReceiveData(android.content.Context r23, android.content.Intent r24) {
        /*
            Method dump skipped, instruction units count: 2258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.push.PushConfig.setReceiveData(android.content.Context, android.content.Intent):android.content.Intent");
    }

    public final Intent setReceiveDataNew(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String string = extras.getString("contents");
            if (string != null) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    intent.putExtra("title", jSONObject.getString("title"));
                    intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, jSONObject.getString("message"));
                    intent.putExtra("bigmsg", jSONObject.getString("messageExpanded"));
                    intent.putExtra("ticker", jSONObject.getString("ticker"));
                    intent.putExtra("summaryText", jSONObject.getString("summaryText"));
                    Intrinsics.checkNotNull(intent.putExtra("bigpicture", jSONObject.getString("imageUrl")));
                } catch (Exception e) {
                    e.printStackTrace();
                    Unit unit = Unit.INSTANCE;
                }
            }
            String string2 = extras.getString("option");
            if (string2 != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(string2);
                    intent.putExtra("badge", jSONObject2.getInt("badge"));
                    intent.putExtra("noticeID", jSONObject2.getInt("collapseKey"));
                    intent.putExtra(NativeProtocol.WEB_DIALOG_ACTION, jSONObject2.getString("engagement"));
                    Intrinsics.checkNotNull(intent.putExtra("sound", jSONObject2.getString("sound")));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
        return intent;
    }

    public final void startPushWakeLock(Context context) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") != 0) {
            LoggerImpl.INSTANCE.d(TAG, "WAKE_LOCK check return");
            return;
        }
        LoggerImpl.INSTANCE.d(TAG, "PushWakeLock, Acquiring cpu wake lock");
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null || (wakeLockNewWakeLock = powerManager.newWakeLock(268435462, "HIVE_Push_Notification")) == null) {
            return;
        }
        wakeLockNewWakeLock.acquire(5000L);
    }
}
