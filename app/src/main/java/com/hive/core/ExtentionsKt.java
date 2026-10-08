package com.hive.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import com.hive.core.Logger;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Extentions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u001aA\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u001a\n\u0010\u000f\u001a\u00020\u0002*\u00020\f\u001a$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0013*\u00020\u0014\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00172\u0006\u0010\t\u001a\u00020\u0016\u001a\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u00172\u0006\u0010\t\u001a\u00020\u0016¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u0019*\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u001a\u0014\u0010\u001b\u001a\u00020\u0019*\u00020\u001e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u001a\n\u0010\u001f\u001a\u00020\u0014*\u00020 \u001a\n\u0010!\u001a\u00020 *\u00020\u0014\u001a#\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010#*\b\u0012\u0004\u0012\u0002H#0$2\u0006\u0010%\u001a\u0002H#¢\u0006\u0002\u0010&¨\u0006'"}, d2 = {"startActivityCatching", "", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "catch", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "t", "startActivityForResultCatching", "Landroid/app/Activity;", "requestCode", "", "getResourceContext", "toMutableMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "optStringOrNull", "", "Lorg/json/JSONObject;", "optBooleanOrNull", "", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Boolean;", "similar", "other", "", "Lorg/json/JSONArray;", "asBytes", "Ljava/util/UUID;", "asUuid", "resumeIfActive", "T", "Lkotlinx/coroutines/CancellableContinuation;", "value", "(Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/Object;)V", "hive-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExtentionsKt {
    public static /* synthetic */ void startActivityCatching$default(Context context, Intent intent, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        startActivityCatching(context, intent, function1);
    }

    public static final void startActivityCatching(Context context, Intent intent, Function1<? super Throwable, Unit> function1) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            context.startActivity(intent);
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.coreLog$hive_core_release("startActivityCatching exception: " + thM7418exceptionOrNullimpl, Logger.LogType.Warning);
            if (function1 != null) {
                function1.invoke(thM7418exceptionOrNullimpl);
            }
        }
    }

    public static /* synthetic */ void startActivityForResultCatching$default(Activity activity, Intent intent, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        startActivityForResultCatching(activity, intent, i, function1);
    }

    public static final void startActivityForResultCatching(Activity activity, Intent intent, int i, Function1<? super Throwable, Unit> function1) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            activity.startActivityForResult(intent, i);
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.coreLog$hive_core_release("startActivityForResultCatching exception: " + thM7418exceptionOrNullimpl, Logger.LogType.Warning);
            if (function1 != null) {
                function1.invoke(thM7418exceptionOrNullimpl);
            }
        }
    }

    public static final Context getResourceContext(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Context contextCreateConfigurationContext = activity.createConfigurationContext(new android.content.res.Configuration(activity.getResources().getConfiguration()));
        Intrinsics.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    public static final <K, V> Map<K, V> toMutableMap(byte[] bArr) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                Object object = objectInputStream.readObject();
                Map map = (object == null || !TypeIntrinsics.isMutableMap(object)) ? null : (Map) object;
                CloseableKt.closeFinally(objectInputStream, null);
                objM7415constructorimpl = kotlin.Result.m7415constructorimpl(map);
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "ByteArray.toMutableMap() exception\n" + thM7418exceptionOrNullimpl.getMessage(), null, 2, null);
        }
        return (Map) (kotlin.Result.m7421isFailureimpl(objM7415constructorimpl) ? null : objM7415constructorimpl);
    }

    public static final String optStringOrNull(JSONObject jSONObject, String name) {
        Object objOpt;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Object objOpt2 = jSONObject.opt(name);
        if (objOpt2 == null || Intrinsics.areEqual(objOpt2, JSONObject.NULL) || (objOpt = jSONObject.opt(name)) == null) {
            return null;
        }
        return objOpt.toString();
    }

    public static final Boolean optBooleanOrNull(JSONObject jSONObject, String name) {
        String lowerCase;
        String string;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Object objOpt = jSONObject.opt(name);
        if (objOpt == null || (string = objOpt.toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        }
        if (Intrinsics.areEqual(lowerCase, "true")) {
            return true;
        }
        return Intrinsics.areEqual(lowerCase, "false") ? false : null;
    }

    public static final boolean similar(JSONObject jSONObject, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        try {
            if (!(obj instanceof JSONObject) || jSONObject.length() != ((JSONObject) obj).length()) {
                return false;
            }
            Iterator<String> itKeys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!((JSONObject) obj).has(next)) {
                    return false;
                }
                Object obj2 = jSONObject.get(next);
                Object obj3 = ((JSONObject) obj).get(next);
                if (obj2 instanceof JSONObject) {
                    if (!similar((JSONObject) obj2, obj3)) {
                        return false;
                    }
                } else if (obj2 instanceof JSONArray) {
                    if (!similar((JSONArray) obj2, obj3)) {
                        return false;
                    }
                } else if ((obj2 instanceof Number) && (obj3 instanceof Number)) {
                    if (((Number) obj2).doubleValue() != ((Number) obj3).doubleValue()) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(obj2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final boolean similar(JSONArray jSONArray, Object obj) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        try {
            if (!(obj instanceof JSONArray) || jSONArray.length() != ((JSONArray) obj).length()) {
                return false;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj2 = jSONArray.get(i);
                Object obj3 = ((JSONArray) obj).get(i);
                if (!Intrinsics.areEqual(obj2, obj3)) {
                    if (obj2 instanceof JSONObject) {
                        if (!similar((JSONObject) obj2, obj3)) {
                            return false;
                        }
                    } else if (obj2 instanceof JSONArray) {
                        if (!similar((JSONArray) obj2, obj3)) {
                            return false;
                        }
                    } else if ((obj2 instanceof Number) && (obj3 instanceof Number)) {
                        if (((Number) obj2).doubleValue() != ((Number) obj3).doubleValue()) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(obj2, obj3)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final byte[] asBytes(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[16]);
        byteBufferWrap.putLong(uuid.getMostSignificantBits());
        byteBufferWrap.putLong(uuid.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public static final UUID asUuid(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    public static final <T> void resumeIfActive(CancellableContinuation<? super T> cancellableContinuation, T t) {
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        if (cancellableContinuation.isActive()) {
            Result.Companion companion = kotlin.Result.INSTANCE;
            cancellableContinuation.resumeWith(kotlin.Result.m7415constructorimpl(t));
        }
    }
}
