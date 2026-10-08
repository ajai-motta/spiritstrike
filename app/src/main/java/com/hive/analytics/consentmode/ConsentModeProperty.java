package com.hive.analytics.consentmode;

import com.hive.Analytics;
import com.hive.base.Property;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConsentModeProperty.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0000¢\u0006\u0002\b\u000fJ\u001b\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0002\b\u0013J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/hive/analytics/consentmode/ConsentModeProperty;", "", "<init>", "()V", "property", "Lcom/hive/base/Property;", "getProperty", "()Lcom/hive/base/Property;", "property$delegate", "Lkotlin/Lazy;", "KEY", "", "loadConsentStatus", "", "Lcom/hive/Analytics$ConsentMode$ConsentStatus;", "loadConsentStatus$hive_analytics_consent_mode_release", "writeConsentStatus", "", "statusList", "writeConsentStatus$hive_analytics_consent_mode_release", "convertConsentFormat", "oldJsonString", "addMonthsWithCalendar", "", "millis", "months", "", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConsentModeProperty {
    private static final String KEY = "ConsentStatus";
    public static final ConsentModeProperty INSTANCE = new ConsentModeProperty();

    /* JADX INFO: renamed from: property$delegate, reason: from kotlin metadata */
    private static final Lazy property = LazyKt.lazy(new Function0() { // from class: com.hive.analytics.consentmode.ConsentModeProperty$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ConsentModeProperty.property_delegate$lambda$0();
        }
    });

    private ConsentModeProperty() {
    }

    private final Property getProperty() {
        return (Property) property.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Property property_delegate$lambda$0() {
        return new Property("analytics_consent_mode.dat");
    }

    public final List<Analytics.ConsentMode.ConsentStatus> loadConsentStatus$hive_analytics_consent_mode_release() {
        JSONObject jSONObjectOptJSONObject;
        String value = getProperty().getValue(KEY);
        ArrayList arrayList = null;
        if (value != null) {
            if (!(!StringsKt.isBlank(value))) {
                value = null;
            }
            if (value != null) {
                arrayList = new ArrayList();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONArray jSONArray = new JSONArray(value);
                    if (jSONArray.length() > 0 && (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) != null && jSONObjectOptJSONObject.has("providerName")) {
                        value = INSTANCE.convertConsentFormat(value);
                    }
                    JSONArray jSONArray2 = new JSONArray(value);
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        Analytics.ConsentMode.ConsentStatus.Companion companion2 = Analytics.ConsentMode.ConsentStatus.INSTANCE;
                        JSONObject jSONObjectOptJSONObject2 = jSONArray2.optJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObjectOptJSONObject2, "optJSONObject(...)");
                        arrayList.add(companion2.fromJson(jSONObjectOptJSONObject2));
                    }
                    Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
            }
        }
        return arrayList;
    }

    public final void writeConsentStatus$hive_analytics_consent_mode_release(List<Analytics.ConsentMode.ConsentStatus> statusList) {
        Object next;
        Intrinsics.checkNotNullParameter(statusList, "statusList");
        try {
            Result.Companion companion = Result.INSTANCE;
            List<Analytics.ConsentMode.ConsentStatus> listLoadConsentStatus$hive_analytics_consent_mode_release = INSTANCE.loadConsentStatus$hive_analytics_consent_mode_release();
            if (listLoadConsentStatus$hive_analytics_consent_mode_release != null) {
                for (Analytics.ConsentMode.ConsentStatus consentStatus : listLoadConsentStatus$hive_analytics_consent_mode_release) {
                    Iterator<T> it = statusList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (Intrinsics.areEqual(((Analytics.ConsentMode.ConsentStatus) next).getId(), consentStatus.getId())) {
                                break;
                            }
                        } else {
                            next = null;
                            break;
                        }
                    }
                    if (next == null) {
                        statusList.add(consentStatus);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it2 = statusList.iterator();
            while (it2.hasNext()) {
                jSONArray.put(((Analytics.ConsentMode.ConsentStatus) it2.next()).toJson());
            }
            ConsentModeProperty consentModeProperty = INSTANCE;
            Property.setValue$default(consentModeProperty.getProperty(), KEY, jSONArray.toString(), null, 4, null);
            Result.m7415constructorimpl(Boolean.valueOf(consentModeProperty.getProperty().writeProperties()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final String convertConsentFormat(String oldJsonString) {
        Object objM7415constructorimpl;
        String str;
        String str2;
        Object obj;
        String string;
        Object obj2;
        long j;
        Intrinsics.checkNotNullParameter(oldJsonString, "oldJsonString");
        LoggerImpl.INSTANCE.dR("[ConsentMode] Called convertConsentFormat()");
        LoggerImpl.INSTANCE.dL("[ConsentMode] Called convertConsentFormat() \noldJsonString = " + oldJsonString);
        try {
            Result.Companion companion = Result.INSTANCE;
            ConsentModeProperty consentModeProperty = this;
            JSONArray jSONArray = new JSONArray(oldJsonString);
            JSONArray jSONArray2 = new JSONArray();
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!Intrinsics.areEqual(jSONObject.getString("providerName"), "main")) {
                    Intrinsics.checkNotNull(jSONObject);
                    arrayList.add(jSONObject);
                }
            }
            if (arrayList.isEmpty()) {
                LoggerImpl.INSTANCE.d("[ConsentMode] convertConsentFormat() : providersWithoutMain is empty");
                string = new JSONArray().toString();
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : arrayList) {
                    if (Intrinsics.areEqual(((JSONObject) obj3).getString("consentForDataUsage"), Analytics.CONSENT_GRANTED)) {
                        arrayList2.add(obj3);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                if (!arrayList3.isEmpty()) {
                    Iterator it = arrayList3.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    str = "providerName";
                    long j2 = ((JSONObject) it.next()).getLong("consentDate");
                    while (it.hasNext()) {
                        long j3 = ((JSONObject) it.next()).getLong("consentDate");
                        if (j2 > j3) {
                            j2 = j3;
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", Analytics.CONSENT_TYPE_AD_USER_DATA);
                    jSONObject2.put(Analytics.CONSENT_GRANTED, Analytics.CONSENT_GRANTED);
                    jSONObject2.put("consentDate", j2);
                    jSONObject2.put("expiredDate", addMonthsWithCalendar(j2, 14));
                    jSONArray2.put(jSONObject2);
                } else {
                    str = "providerName";
                    Iterator it2 = arrayList.iterator();
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long j4 = ((JSONObject) it2.next()).getLong("consentDate");
                    while (it2.hasNext()) {
                        long j5 = ((JSONObject) it2.next()).getLong("consentDate");
                        if (j4 > j5) {
                            j4 = j5;
                        }
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", Analytics.CONSENT_TYPE_AD_USER_DATA);
                    jSONObject3.put(Analytics.CONSENT_GRANTED, Analytics.CONSENT_DENIED);
                    jSONObject3.put("consentDate", j4);
                    jSONObject3.put("expiredDate", addMonthsWithCalendar(j4, 14));
                    jSONArray2.put(jSONObject3);
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : arrayList) {
                    if (Intrinsics.areEqual(((JSONObject) obj4).getString("consentForPersonalization"), Analytics.CONSENT_GRANTED)) {
                        arrayList4.add(obj4);
                    }
                }
                ArrayList arrayList5 = arrayList4;
                if (!arrayList5.isEmpty()) {
                    Iterator it3 = arrayList5.iterator();
                    if (!it3.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long j6 = ((JSONObject) it3.next()).getLong("consentDate");
                    str2 = "consentForPersonalization";
                    loop4: while (true) {
                        j = j6;
                        while (it3.hasNext()) {
                            j6 = ((JSONObject) it3.next()).getLong("consentDate");
                            if (j > j6) {
                                break;
                            }
                        }
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("id", Analytics.CONSENT_TYPE_AD_PERSONALIZATION);
                    jSONObject4.put(Analytics.CONSENT_GRANTED, Analytics.CONSENT_GRANTED);
                    jSONObject4.put("consentDate", j);
                    jSONObject4.put("expiredDate", addMonthsWithCalendar(j, 14));
                    jSONArray2.put(jSONObject4);
                } else {
                    str2 = "consentForPersonalization";
                    Iterator it4 = arrayList.iterator();
                    if (!it4.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    long j7 = ((JSONObject) it4.next()).getLong("consentDate");
                    while (it4.hasNext()) {
                        Iterator it5 = it4;
                        long j8 = ((JSONObject) it4.next()).getLong("consentDate");
                        if (j7 > j8) {
                            it4 = it5;
                            j7 = j8;
                        } else {
                            it4 = it5;
                        }
                    }
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("id", Analytics.CONSENT_TYPE_AD_PERSONALIZATION);
                    jSONObject5.put(Analytics.CONSENT_GRANTED, Analytics.CONSENT_DENIED);
                    jSONObject5.put("consentDate", j7);
                    jSONObject5.put("expiredDate", addMonthsWithCalendar(j7, 14));
                    jSONArray2.put(jSONObject5);
                }
                Iterator it6 = CollectionsKt.listOf((Object[]) new String[]{"google", "appsflyer", "adjust", "singular", "airbridge"}).iterator();
                while (it6.hasNext()) {
                    String str3 = (String) it6.next();
                    Iterator it7 = arrayList.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        Object next = it7.next();
                        if (Intrinsics.areEqual(((JSONObject) next).getString(str), str3)) {
                            obj2 = next;
                            break;
                        }
                    }
                    JSONObject jSONObject6 = (JSONObject) obj2;
                    if (jSONObject6 != null) {
                        long j9 = jSONObject6.getLong("consentDate");
                        Iterator it8 = it6;
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("id", str3);
                        jSONObject7.put(Analytics.CONSENT_GRANTED, jSONObject6.getString(str2));
                        jSONObject7.put("consentDate", j9);
                        jSONObject7.put("expiredDate", jSONObject6.getLong("expiredDate"));
                        jSONArray2.put(jSONObject7);
                        it6 = it8;
                    }
                }
                Iterator it9 = arrayList.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next2 = it9.next();
                    if (Intrinsics.areEqual(((JSONObject) next2).getString(str), "google")) {
                        obj = next2;
                        break;
                    }
                }
                JSONObject jSONObject8 = (JSONObject) obj;
                if (jSONObject8 != null) {
                    long j10 = jSONObject8.getLong("consentDate");
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject9.put("id", Analytics.CONSENT_TYPE_ANALYTICS_STORAGE);
                    jSONObject9.put(Analytics.CONSENT_GRANTED, jSONObject8.getString("consentForDataUsage"));
                    jSONObject9.put("consentDate", j10);
                    jSONObject9.put("expiredDate", addMonthsWithCalendar(j10, 14));
                    jSONArray2.put(jSONObject9);
                }
                string = jSONArray2.toString();
                LoggerImpl.INSTANCE.dR("[ConsentMode] Succeeded convertConsentFormat()");
                LoggerImpl.INSTANCE.dL("[ConsentMode] Succeeded convertConsentFormat()\nResult = " + string);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(string);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[ConsentMode] Exception convertConsentFormat() : " + thM7418exceptionOrNullimpl.getMessage());
            objM7415constructorimpl = new JSONArray().toString();
            Intrinsics.checkNotNullExpressionValue(objM7415constructorimpl, "toString(...)");
        }
        return (String) objM7415constructorimpl;
    }

    public final long addMonthsWithCalendar(long millis, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        calendar.add(2, months);
        return calendar.getTimeInMillis();
    }
}
