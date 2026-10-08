package com.hive.push.local;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hive.Configuration;
import com.hive.logger.LoggerImpl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tJ\"\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/hive/push/local/PushResourceHandler;", "", "<init>", "()V", "PUSH_FILE_NAME", "", "TAG", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/hive/push/local/PushResource;", "getMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "map$delegate", "Lkotlin/Lazy;", ProductAction.ACTION_ADD, "", "context", "Landroid/content/Context;", "noticeId", "pushResource", ProductAction.ACTION_REMOVE, "save", "load", "putIntentExtra", "Landroid/content/Intent;", "intent", "res", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PushResourceHandler {
    private static final String PUSH_FILE_NAME = "PushResource.dat";
    private static final String TAG = "PushResourceHandler";
    public static final PushResourceHandler INSTANCE = new PushResourceHandler();

    /* JADX INFO: renamed from: map$delegate, reason: from kotlin metadata */
    private static final Lazy map = LazyKt.lazy(new Function0() { // from class: com.hive.push.local.PushResourceHandler$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PushResourceHandler.map_delegate$lambda$0();
        }
    });

    private PushResourceHandler() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.ObjectInputStream] */
    private final synchronized ConcurrentHashMap<Integer, PushResource> load(Context context) {
        ConcurrentHashMap<Integer, PushResource> concurrentHashMap;
        ?? objectInputStream;
        concurrentHashMap = new ConcurrentHashMap<>();
        ?? r3 = 0;
        ?? r32 = 0;
        try {
            try {
                objectInputStream = new ObjectInputStream(new BufferedInputStream(context.openFileInput(PUSH_FILE_NAME)));
                try {
                    Object object = objectInputStream.readObject();
                    String str = "null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<kotlin.Int, com.hive.push.local.PushResource>";
                    Intrinsics.checkNotNull(object, "null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<kotlin.Int, com.hive.push.local.PushResource>");
                    ConcurrentHashMap<Integer, PushResource> concurrentHashMap2 = (ConcurrentHashMap) object;
                    try {
                        objectInputStream.close();
                    } catch (Exception unused) {
                    }
                    concurrentHashMap = concurrentHashMap2;
                    r3 = str;
                } catch (Exception e) {
                    e = e;
                    r32 = objectInputStream;
                    LoggerImpl.INSTANCE.w(TAG, "[PushResourceHandler]load Exception: " + e);
                    r3 = r32;
                    if (r32 != 0) {
                        try {
                            r32.close();
                            r3 = r32;
                        } catch (Exception unused2) {
                        }
                    }
                    LoggerImpl.INSTANCE.d(TAG, "[PushResourceHandler]load: " + concurrentHashMap);
                    return concurrentHashMap;
                } catch (Throwable th) {
                    th = th;
                    if (objectInputStream != 0) {
                        try {
                            objectInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            LoggerImpl.INSTANCE.d(TAG, "[PushResourceHandler]load: " + concurrentHashMap);
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = r3;
        }
        return concurrentHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap map_delegate$lambda$0() {
        PushResourceHandler pushResourceHandler = INSTANCE;
        Context applicationContext = Configuration.getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return pushResourceHandler.load(applicationContext);
    }

    public final synchronized void add(Context context, int noticeId, PushResource pushResource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pushResource, "pushResource");
        getMap().put(Integer.valueOf(noticeId), pushResource);
        save(context, getMap());
    }

    public final ConcurrentHashMap<Integer, PushResource> getMap() {
        return (ConcurrentHashMap) map.getValue();
    }

    public final Intent putIntentExtra(Intent intent, PushResource res) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(res, "res");
        intent.putExtra("noticeID", res.getNoticeID());
        intent.putExtra("title", res.getTitle());
        intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, res.getMsg());
        intent.putExtra("groupId", res.getGroupId());
        intent.putExtra("bigmsg", res.getBigmsg());
        intent.putExtra("ticker", res.getTicker());
        intent.putExtra("type", res.getType());
        intent.putExtra("icon", res.getIcon());
        intent.putExtra("sound", res.getSound());
        intent.putExtra(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, res.getActive());
        intent.putExtra("broadcastAction", res.getBroadcastAction());
        intent.putExtra("buckettype", res.getBuckettype());
        intent.putExtra("bucketsize", res.getBucketsize());
        intent.putExtra("bigpicture", res.getBigpicture());
        intent.putExtra("icon_color", res.getIcon_color());
        intent.putExtra("packageName", res.getPackageName());
        return intent;
    }

    public final synchronized void remove(Context context, int noticeId) {
        Intrinsics.checkNotNullParameter(context, "context");
        getMap().remove(Integer.valueOf(noticeId));
        save(context, getMap());
    }

    public final synchronized void save(Context context, ConcurrentHashMap<Integer, PushResource> map2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map2, "map");
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(PUSH_FILE_NAME, 0)));
                    try {
                        objectOutputStream2.writeObject(map2);
                        objectOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        LoggerImpl.INSTANCE.w(TAG, "[PushResourceHandler]save Exception: " + e);
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        LoggerImpl.INSTANCE.d(TAG, "[PushResourceHandler]save: " + map2);
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception unused2) {
        }
        LoggerImpl.INSTANCE.d(TAG, "[PushResourceHandler]save: " + map2);
    }
}
