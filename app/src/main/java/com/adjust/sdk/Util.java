package com.adjust.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import com.adjust.sdk.GooglePlayServicesClient;
import com.adjust.sdk.scheduler.AsyncTaskExecutor;
import com.adjust.sdk.scheduler.SingleThreadFutureScheduler;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.io.BufferedOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Util {
    private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";
    public static final DecimalFormat SecondsDisplayFormat = newLocalDecimalFormat();
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);
    private static volatile SingleThreadFutureScheduler playAdIdScheduler = null;

    public static AdjustAttribution attributionFromJson(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        AdjustAttribution adjustAttribution = new AdjustAttribution();
        adjustAttribution.jsonResponse = jSONObject.toString();
        if ("unity".equals(str)) {
            adjustAttribution.trackerToken = jSONObject.optString("tracker_token", "");
            adjustAttribution.trackerName = jSONObject.optString("tracker_name", "");
            adjustAttribution.network = jSONObject.optString("network", "");
            adjustAttribution.campaign = jSONObject.optString("campaign", "");
            adjustAttribution.adgroup = jSONObject.optString("adgroup", "");
            adjustAttribution.creative = jSONObject.optString("creative", "");
            adjustAttribution.clickLabel = jSONObject.optString("click_label", "");
            adjustAttribution.costType = jSONObject.optString("cost_type", "");
            adjustAttribution.costAmount = Double.valueOf(jSONObject.optDouble("cost_amount", 0.0d));
            adjustAttribution.costCurrency = jSONObject.optString("cost_currency", "");
            adjustAttribution.fbInstallReferrer = jSONObject.optString("fb_install_referrer", "");
            return adjustAttribution;
        }
        adjustAttribution.trackerToken = jSONObject.optString("tracker_token");
        adjustAttribution.trackerName = jSONObject.optString("tracker_name");
        adjustAttribution.network = jSONObject.optString("network");
        adjustAttribution.campaign = jSONObject.optString("campaign");
        adjustAttribution.adgroup = jSONObject.optString("adgroup");
        adjustAttribution.creative = jSONObject.optString("creative");
        adjustAttribution.clickLabel = jSONObject.optString("click_label");
        adjustAttribution.costType = jSONObject.optString("cost_type");
        adjustAttribution.costAmount = Double.valueOf(jSONObject.optDouble("cost_amount"));
        adjustAttribution.costCurrency = jSONObject.optString("cost_currency");
        adjustAttribution.fbInstallReferrer = jSONObject.optString("fb_install_referrer");
        return adjustAttribution;
    }

    public static boolean canReadNonPlayIds(AdjustConfig adjustConfig) {
        return (adjustConfig.coppaComplianceEnabled || adjustConfig.playStoreKidsComplianceEnabled) ? false : true;
    }

    public static boolean canReadPlayIds(AdjustConfig adjustConfig) {
        return (adjustConfig.coppaComplianceEnabled || adjustConfig.playStoreKidsComplianceEnabled) ? false : true;
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            getLogger().debug("Unable to check permission '%s' with message (%s)", str, e.getMessage());
            return false;
        }
    }

    public static String convertToHex(byte[] bArr) {
        return formatString("%0" + (bArr.length << 1) + "x", new BigInteger(1, bArr));
    }

    public static String createUuid() {
        return UUID.randomUUID().toString();
    }

    public static boolean equalBoolean(Boolean bool, Boolean bool2) {
        return equalObject(bool, bool2);
    }

    public static boolean equalEnum(Enum r0, Enum r1) {
        return equalObject(r0, r1);
    }

    public static boolean equalInt(Integer num, Integer num2) {
        return equalObject(num, num2);
    }

    public static boolean equalLong(Long l, Long l2) {
        return equalObject(l, l2);
    }

    public static boolean equalObject(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? obj == null && obj2 == null : obj.equals(obj2);
    }

    public static boolean equalString(String str, String str2) {
        return equalObject(str, str2);
    }

    public static boolean equalsDouble(Double d, Double d2) {
        return (d == null || d2 == null) ? d == null && d2 == null : Double.doubleToLongBits(d.doubleValue()) == Double.doubleToLongBits(d2.doubleValue());
    }

    public static String formatString(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Object getAdvertisingInfoObject(final Context context, long j) {
        return runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<Object>() { // from class: com.adjust.sdk.Util.1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                try {
                    return Reflection.getAdvertisingInfoObject(context);
                } catch (Exception unused) {
                    return null;
                }
            }
        }, j);
    }

    public static String getAndroidId(Context context) {
        return AndroidIdUtil.getAndroidId(context);
    }

    public static String getCpuAbi() {
        return null;
    }

    public static void getGoogleAdId(Context context, final OnGoogleAdIdReadListener onGoogleAdIdReadListener) {
        new AsyncTaskExecutor<Context, String>() { // from class: com.adjust.sdk.Util.4
            @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
            public final String doInBackground(Context[] contextArr) {
                ILogger logger = AdjustFactory.getLogger();
                String googleAdId = Util.getGoogleAdId(contextArr[0]);
                logger.debug("GoogleAdId read " + googleAdId, new Object[0]);
                return googleAdId;
            }

            @Override // com.adjust.sdk.scheduler.AsyncTaskExecutor
            public final void onPostExecute(String str) {
                String str2 = str;
                OnGoogleAdIdReadListener onGoogleAdIdReadListener2 = onGoogleAdIdReadListener;
                if (onGoogleAdIdReadListener2 != null) {
                    onGoogleAdIdReadListener2.onGoogleAdIdRead(str2);
                }
            }
        }.execute(context);
    }

    public static Locale getLocale(Configuration configuration) {
        LocaleList locales;
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && (locales = configuration.getLocales()) != null && !locales.isEmpty()) {
            return locales.get(0);
        }
        if (i < 24) {
            return configuration.locale;
        }
        return null;
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public static String getPlayAdId(final Context context, final Object obj, long j) {
        return (String) runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<String>() { // from class: com.adjust.sdk.Util.2
            @Override // java.util.concurrent.Callable
            public final String call() {
                return Reflection.getPlayAdId(context, obj);
            }
        }, j);
    }

    public static String getReasonString(String str, Throwable th) {
        return th != null ? formatString("%s: %s", str, th) : formatString("%s", str);
    }

    public static String getRootCause(Exception exc) {
        if (!hasRootCause(exc)) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        int iIndexOf = string.indexOf("Caused by:");
        return string.substring(iIndexOf, string.indexOf("\n", iIndexOf));
    }

    private static String getSdkPrefix(String str) {
        String[] strArrSplit;
        if (str != null && str.contains("@") && (strArrSplit = str.split("@")) != null && strArrSplit.length == 2) {
            return strArrSplit[0];
        }
        return null;
    }

    public static String getSdkPrefixPlatform(String str) {
        String[] strArrSplit;
        String sdkPrefix = getSdkPrefix(str);
        if (sdkPrefix == null || (strArrSplit = sdkPrefix.split("\\d+", 2)) == null || strArrSplit.length == 0) {
            return null;
        }
        return strArrSplit[0];
    }

    public static String getSdkVersion() {
        return Constants.CLIENT_SDK;
    }

    public static long getWaitingTime(int i, BackoffStrategy backoffStrategy) {
        if (i < backoffStrategy.minRetries) {
            return 0L;
        }
        return (long) (Math.min(((long) Math.pow(2.0d, i - r0)) * backoffStrategy.milliSecondMultiplier, backoffStrategy.maxWait) * randomInRange(backoffStrategy.minRange, backoffStrategy.maxRange));
    }

    public static boolean hasRootCause(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().contains("Caused by:");
    }

    public static String hash(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(bytes, 0, bytes.length);
            return convertToHex(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public static int hashBoolean(Boolean bool, int i) {
        int i2 = i * 37;
        return bool == null ? i2 : bool.hashCode() + i2;
    }

    public static int hashDouble(Double d, int i) {
        int i2 = i * 37;
        return d == null ? i2 : d.hashCode() + i2;
    }

    public static int hashEnum(Enum r0, int i) {
        int i2 = i * 37;
        return r0 == null ? i2 : r0.hashCode() + i2;
    }

    public static int hashLong(Long l, int i) {
        int i2 = i * 37;
        return l == null ? i2 : l.hashCode() + i2;
    }

    public static int hashObject(Object obj, int i) {
        int i2 = i * 37;
        return obj == null ? i2 : obj.hashCode() + i2;
    }

    public static int hashString(String str, int i) {
        int i2 = i * 37;
        return str == null ? i2 : str.hashCode() + i2;
    }

    public static boolean isAdjustUninstallDetectionPayload(Map<String, String> map) {
        return map != null && map.size() == 1 && Objects.equals(map.get(Constants.FCM_PAYLOAD_KEY), Constants.FCM_PAYLOAD_VALUE);
    }

    public static boolean isEnabledFromActivityStateFile(Context context) {
        ActivityState activityState = (ActivityState) readObject(context, Constants.ACTIVITY_STATE_FILENAME, "Activity state", ActivityState.class);
        if (activityState == null) {
            return true;
        }
        return activityState.enabled;
    }

    private static boolean isEqualGoogleReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTime && referrerDetails.installBeginTimestampSeconds == activityState.installBegin && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServer && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServer && equalString(referrerDetails.installReferrer, activityState.installReferrer) && equalString(referrerDetails.installVersion, activityState.installVersion) && equalBoolean(referrerDetails.googlePlayInstant, activityState.googlePlayInstant);
    }

    private static boolean isEqualHuaweiReferrerAdsDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuawei);
    }

    private static boolean isEqualHuaweiReferrerAppGalleryDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeHuawei && referrerDetails.installBeginTimestampSeconds == activityState.installBeginHuawei && equalString(referrerDetails.installReferrer, activityState.installReferrerHuaweiAppGallery);
    }

    private static boolean isEqualMetaReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeMeta && equalString(referrerDetails.installReferrer, activityState.installReferrerMeta) && equalBoolean(referrerDetails.isClick, activityState.isClickMeta);
    }

    public static boolean isEqualReferrerDetails(ReferrerDetails referrerDetails, String str, ActivityState activityState) {
        if (str.equals("google")) {
            return isEqualGoogleReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_HUAWEI_ADS)) {
            return isEqualHuaweiReferrerAdsDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_HUAWEI_APP_GALLERY)) {
            return isEqualHuaweiReferrerAppGalleryDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_SAMSUNG)) {
            return isEqualSamsungReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_XIAOMI)) {
            return isEqualXiaomiReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_VIVO)) {
            return isEqualVivoReferrerDetails(referrerDetails, activityState);
        }
        if (str.equals(Constants.REFERRER_API_META)) {
            return isEqualMetaReferrerDetails(referrerDetails, activityState);
        }
        return false;
    }

    private static boolean isEqualSamsungReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeSamsung && referrerDetails.installBeginTimestampSeconds == activityState.installBeginSamsung && equalString(referrerDetails.installReferrer, activityState.installReferrerSamsung);
    }

    private static boolean isEqualVivoReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeVivo && referrerDetails.installBeginTimestampSeconds == activityState.installBeginVivo && equalString(referrerDetails.installReferrer, activityState.installReferrerVivo) && equalString(referrerDetails.installVersion, activityState.installVersionVivo);
    }

    private static boolean isEqualXiaomiReferrerDetails(ReferrerDetails referrerDetails, ActivityState activityState) {
        return referrerDetails.referrerClickTimestampSeconds == activityState.clickTimeXiaomi && referrerDetails.installBeginTimestampSeconds == activityState.installBeginXiaomi && referrerDetails.referrerClickTimestampServerSeconds == activityState.clickTimeServerXiaomi && referrerDetails.installBeginTimestampServerSeconds == activityState.installBeginServerXiaomi && equalString(referrerDetails.installReferrer, activityState.installReferrerXiaomi) && equalString(referrerDetails.installVersion, activityState.installVersionXiaomi);
    }

    public static boolean isGooglePlayGamesForPC(Context context) {
        return context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
    }

    public static Boolean isPlayTrackingEnabled(final Context context, final Object obj, long j) {
        return (Boolean) runSyncInPlayAdIdSchedulerWithTimeout(context, new Callable<Boolean>() { // from class: com.adjust.sdk.Util.3
            @Override // java.util.concurrent.Callable
            public final Boolean call() {
                return Reflection.isPlayTrackingEnabled(context, obj);
            }
        }, j);
    }

    public static boolean isUrlFilteredOut(Uri uri) {
        String string;
        return uri == null || (string = uri.toString()) == null || string.length() == 0 || string.matches(Constants.FB_AUTH_REGEX);
    }

    public static boolean isUrlWithTrackerQueryParam(Uri uri) {
        try {
            if (uri.getQueryParameter("adj_t") != null) {
                return true;
            }
            return uri.getQueryParameter("adjust_t") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isValidParameter(String str, String str2, String str3) {
        if (str == null) {
            getLogger().error("%s parameter %s is missing", str3, str2);
            return false;
        }
        if (!str.equals("")) {
            return true;
        }
        getLogger().error("%s parameter %s is empty", str3, str2);
        return false;
    }

    public static Map<String, String> mergeParameters(Map<String, String> map, Map<String, String> map2, String str) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap map3 = new HashMap(map);
        ILogger logger = getLogger();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String str2 = (String) map3.put(entry.getKey(), entry.getValue());
            if (str2 != null) {
                logger.warn("Key %s with value %s from %s parameter was replaced by value %s", entry.getKey(), str2, str, entry.getValue());
            }
        }
        return map3;
    }

    private static DecimalFormat newLocalDecimalFormat() {
        return new DecimalFormat(IdManager.DEFAULT_VERSION_NAME, new DecimalFormatSymbols(Locale.US));
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        return !Pattern.compile("\\s").matcher(str).find() ? str : formatString("'%s'", str);
    }

    private static double randomInRange(double d, double d2) {
        return (new Random().nextDouble() * (d2 - d)) + d;
    }

    public static boolean readBooleanField(ObjectInputStream.GetField getField, String str, boolean z) {
        try {
            return getField.get(str, z);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return z;
        }
    }

    public static double readDoubleField(ObjectInputStream.GetField getField, String str, double d) {
        try {
            return getField.get(str, d);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return d;
        }
    }

    public static int readIntField(ObjectInputStream.GetField getField, String str, int i) {
        try {
            return getField.get(str, i);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return i;
        }
    }

    public static long readLongField(ObjectInputStream.GetField getField, String str, long j) {
        try {
            return getField.get(str, j);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return j;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T readObject(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.Class<T> r10) {
        /*
            r0 = 2
            r1 = 0
            r2 = 1
            r3 = 0
            java.io.FileInputStream r7 = r7.openFileInput(r8)     // Catch: java.lang.Exception -> L76 java.io.FileNotFoundException -> L8c
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r8.<init>(r7)     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            java.io.ObjectInputStream r7 = new java.io.ObjectInputStream     // Catch: java.lang.Exception -> L6b java.io.FileNotFoundException -> L8f
            r7.<init>(r8)     // Catch: java.lang.Exception -> L6b java.io.FileNotFoundException -> L8f
            java.lang.Object r8 = r7.readObject()     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            java.lang.Object r3 = r10.cast(r8)     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            com.adjust.sdk.ILogger r8 = getLogger()     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            java.lang.String r10 = "Read %s: %s"
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            r4[r1] = r9     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            r4[r2] = r3     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            r8.debug(r10, r4)     // Catch: java.lang.Exception -> L2b java.lang.ClassCastException -> L41 java.lang.ClassNotFoundException -> L56
            goto L9d
        L2b:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            java.lang.String r4 = "Failed to read %s object (%s)"
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r5[r1] = r9     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r5[r2] = r8     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            goto L9d
        L41:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            java.lang.String r4 = "Failed to cast %s object (%s)"
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r5[r1] = r9     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r5[r2] = r8     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            goto L9d
        L56:
            r8 = move-exception
            com.adjust.sdk.ILogger r10 = getLogger()     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            java.lang.String r4 = "Failed to find %s class (%s)"
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r5[r1] = r9     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r5[r2] = r8     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            r10.error(r4, r5)     // Catch: java.lang.Exception -> L6d java.io.FileNotFoundException -> L72
            goto L9d
        L6b:
            r7 = move-exception
            goto L7c
        L6d:
            r8 = move-exception
            r6 = r3
            r3 = r7
            r7 = r6
            goto L78
        L72:
            r6 = r3
            r3 = r7
            r7 = r6
            goto L8d
        L76:
            r8 = move-exception
            r7 = r3
        L78:
            r6 = r3
            r3 = r7
            r7 = r8
            r8 = r6
        L7c:
            com.adjust.sdk.ILogger r10 = getLogger()
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r1] = r9
            r4[r2] = r7
            java.lang.String r7 = "Failed to open %s file for reading (%s)"
            r10.error(r7, r4)
            goto L9c
        L8c:
            r7 = r3
        L8d:
            r8 = r3
            r3 = r7
        L8f:
            com.adjust.sdk.ILogger r7 = getLogger()
            java.lang.Object[] r10 = new java.lang.Object[r2]
            r10[r1] = r9
            java.lang.String r4 = "%s file not found"
            r7.debug(r4, r10)
        L9c:
            r7 = r8
        L9d:
            if (r7 == 0) goto Lb3
            r7.close()     // Catch: java.lang.Exception -> La3
            goto Lb3
        La3:
            r7 = move-exception
            com.adjust.sdk.ILogger r8 = getLogger()
            java.lang.Object[] r10 = new java.lang.Object[r0]
            r10[r1] = r9
            r10[r2] = r7
            java.lang.String r7 = "Failed to close %s file for reading (%s)"
            r8.error(r7, r10)
        Lb3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.Util.readObject(android.content.Context, java.lang.String, java.lang.String, java.lang.Class):java.lang.Object");
    }

    public static <T> T readObjectField(ObjectInputStream.GetField getField, String str, T t) {
        try {
            return (T) getField.get(str, t);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return t;
        }
    }

    public static String readStringField(ObjectInputStream.GetField getField, String str, String str2) {
        return (String) readObjectField(getField, str, str2);
    }

    public static boolean resolveContentProvider(Context context, String str) {
        return context.getPackageManager().resolveContentProvider(str, 0) != null;
    }

    private static <R> R runSyncInPlayAdIdSchedulerWithTimeout(Context context, Callable<R> callable, long j) {
        if (playAdIdScheduler == null) {
            synchronized (Util.class) {
                if (playAdIdScheduler == null) {
                    playAdIdScheduler = new SingleThreadFutureScheduler("PlayAdIdLibrary", true);
                }
            }
        }
        try {
            return (R) playAdIdScheduler.scheduleFutureWithReturn(callable, 0L).get(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    public static <T> void writeObject(T t, Context context, String str, String str2) {
        ?? OpenFileOutput;
        ?? bufferedOutputStream;
        ?? r6;
        try {
            OpenFileOutput = context.openFileOutput(str, 0);
            try {
                bufferedOutputStream = new BufferedOutputStream(OpenFileOutput);
                try {
                    OpenFileOutput = new ObjectOutputStream(bufferedOutputStream);
                    try {
                        OpenFileOutput.writeObject(t);
                        getLogger().debug("Wrote %s: %s", str2, t);
                        r6 = OpenFileOutput;
                    } catch (NotSerializableException unused) {
                        getLogger().error("Failed to serialize %s", str2);
                        r6 = OpenFileOutput;
                    }
                } catch (Exception e) {
                    e = e;
                    getLogger().error("Failed to open %s for writing (%s)", str2, e);
                    r6 = bufferedOutputStream;
                }
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream = OpenFileOutput;
                getLogger().error("Failed to open %s for writing (%s)", str2, e);
                r6 = bufferedOutputStream;
            }
        } catch (Exception e3) {
            e = e3;
            OpenFileOutput = 0;
        }
        if (r6 != 0) {
            try {
                r6.close();
            } catch (Exception e4) {
                getLogger().error("Failed to close %s file for writing (%s)", str2, e4);
            }
        }
    }

    public static String[] getSupportedAbis() {
        return Build.SUPPORTED_ABIS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getGoogleAdId(Context context) {
        Object advertisingInfoObject;
        GooglePlayServicesClient.GooglePlayServicesInfo googlePlayServicesInfo;
        try {
            googlePlayServicesInfo = GooglePlayServicesClient.getGooglePlayServicesInfo(context, 11000L);
        } catch (Exception unused) {
        }
        String gpsAdid = googlePlayServicesInfo != null ? googlePlayServicesInfo.getGpsAdid() : null;
        return (gpsAdid != null || (advertisingInfoObject = getAdvertisingInfoObject(context, 11000L)) == null) ? gpsAdid : getPlayAdId(context, advertisingInfoObject, 1000L);
    }
}
