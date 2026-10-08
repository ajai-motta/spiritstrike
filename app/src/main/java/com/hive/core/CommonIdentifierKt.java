package com.hive.core;

import com.hive.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CommonIdentifier.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\u0010\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¨\u0006\f"}, d2 = {"put", "Lorg/json/JSONObject;", "key", "Lcom/hive/core/HiveKeys;", "value", "", "putCI", "putCheck", "name", "", "checkJsonNull", "ref", "hive-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CommonIdentifierKt {

    /* JADX INFO: compiled from: CommonIdentifier.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HiveKeys.values().length];
            try {
                iArr[HiveKeys.KEY_language.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HiveKeys.KEY_game_language.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HiveKeys.KEY_device_country.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HiveKeys.KEY_hive_country.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HiveKeys.KEY_server_id.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HiveKeys.KEY_sdk_version.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HiveKeys.KEY_timezone.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[HiveKeys.KEY_analytics_id.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[HiveKeys.KEY_app_version.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[HiveKeys.KEY_app_version_display.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[HiveKeys.KEY_is_url_encode.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[HiveKeys.KEY_mac.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[HiveKeys.KEY_mcc.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[HiveKeys.KEY_mnc.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[HiveKeys.KEY_mq_mac.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[HiveKeys.KEY_mq_mcc.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[HiveKeys.KEY_mq_mnc.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[HiveKeys.KEY_mq_imei.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[HiveKeys.KEY_oq_mac.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[HiveKeys.KEY_oq_mcc.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[HiveKeys.KEY_oq_mnc.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final JSONObject put(JSONObject jSONObject, HiveKeys key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return putCheck(jSONObject, key.getValue(), JSONObject.NULL);
    }

    public static final JSONObject put(JSONObject jSONObject, HiveKeys key, Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        switch (WhenMappings.$EnumSwitchMapping$0[key.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                Object objCheckJsonNull = checkJsonNull(obj);
                return Intrinsics.areEqual(JSONObject.NULL, objCheckJsonNull) ? jSONObject : putCheck(jSONObject, key.getValue(), objCheckJsonNull);
            default:
                return putCheck(jSONObject, key.getValue(), obj);
        }
    }

    public static final JSONObject putCI(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (jSONObject.isNull(HiveKeys.KEY_language.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_language.getValue(), Platform.INSTANCE.getLanguage());
        }
        if (jSONObject.isNull(HiveKeys.KEY_game_language.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_game_language.getValue(), Configuration.INSTANCE.getGameLanguage());
        }
        if (jSONObject.isNull(HiveKeys.KEY_device_country.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_device_country.getValue(), Platform.INSTANCE.getCountry());
        }
        if (jSONObject.isNull(HiveKeys.KEY_hive_country.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_hive_country.getValue(), Configuration.INSTANCE.getHiveCountry());
        }
        if (jSONObject.isNull(HiveKeys.KEY_server_id.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_server_id.getValue(), Configuration.INSTANCE.getServerId());
        }
        if (jSONObject.isNull(HiveKeys.KEY_sdk_version.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_sdk_version.getValue(), Configuration.INSTANCE.getSdkVersion());
        }
        if (jSONObject.isNull(HiveKeys.KEY_track.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_track.getValue(), Configuration.INSTANCE.getTrackVersion());
        }
        if (jSONObject.isNull(HiveKeys.KEY_interface_version.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_interface_version.getValue(), Configuration.INSTANCE.getInterfaceVersion());
        }
        if (jSONObject.isNull(HiveKeys.KEY_build_time.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_build_time.getValue(), Configuration.INSTANCE.getSdkBuildTime());
        }
        if (jSONObject.isNull(HiveKeys.KEY_timezone.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_timezone.getValue(), Configuration.INSTANCE.getTimezone());
        }
        if (jSONObject.isNull(HiveKeys.KEY_analytics_id.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_analytics_id.getValue(), Configuration.INSTANCE.getAnalyticsId());
        }
        if (jSONObject.isNull(HiveKeys.KEY_app_version.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_app_version.getValue(), Product.INSTANCE.getBuildVersion());
        }
        if (jSONObject.isNull(HiveKeys.KEY_app_version_display.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_app_version_display.getValue(), Product.INSTANCE.getBuildVersion());
        }
        if (jSONObject.isNull(HiveKeys.KEY_age_gate_u13.getValue()) && Configuration.INSTANCE.getAgeGateU13()) {
            putCheck(jSONObject, HiveKeys.KEY_age_gate_u13.getValue(), true);
        }
        if (jSONObject.isNull(HiveKeys.KEY_is_url_encode.getValue())) {
            putCheck(jSONObject, HiveKeys.KEY_is_url_encode.getValue(), Configuration.INSTANCE.isUrlEncode());
        }
        return jSONObject;
    }

    public static final JSONObject putCheck(JSONObject jSONObject, String name, Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            JSONObject jSONObjectPut = jSONObject.put(name, checkJsonNull(obj));
            Intrinsics.checkNotNull(jSONObjectPut);
            return jSONObjectPut;
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("key: " + name + " Exception - " + e, Logger.LogType.Warning);
            JSONObject jSONObjectPut2 = jSONObject.put(name, JSONObject.NULL);
            Intrinsics.checkNotNull(jSONObjectPut2);
            return jSONObjectPut2;
        }
    }

    public static final Object checkJsonNull(Object obj) {
        if (obj != null) {
            return obj;
        }
        Object NULL = JSONObject.NULL;
        Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
        return NULL;
    }
}
