package com.fyber.inneractive.sdk.serverapi;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.facebook.appevents.AppEventsConstants;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.util.k;
import com.fyber.inneractive.sdk.util.o;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements d {
    public static final List c = Arrays.asList(5);
    public static final List d = Arrays.asList(Integer.valueOf(com.fyber.inneractive.sdk.rtb.data.types.a.VAST_2_0.a()), Integer.valueOf(com.fyber.inneractive.sdk.rtb.data.types.a.VAST_2_0_WRAPPER.a()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f1623a;
    public final String b;

    public c(r rVar) {
        String networkOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) o.f1662a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            networkOperator = telephonyManager.getNetworkOperator();
            if (telephonyManager.getPhoneType() == 2 && k.n()) {
                networkOperator = telephonyManager.getSimOperator();
            }
        } catch (Exception unused) {
            networkOperator = null;
        }
        this.b = networkOperator;
        this.f1623a = rVar;
    }

    public final String a() {
        try {
            return ((TelephonyManager) o.f1662a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperatorName();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(String str, HashMap map) {
        String str2;
        a aVar = b.f1622a;
        try {
            Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            str2 = "unity3d";
        } catch (Throwable unused) {
            str2 = "native";
        }
        map.put("frmn", str2);
        map.put("headset", a(b.m()));
        map.put("is_muted", a(b.k()));
        map.put("btry_c", a(b.i()));
        map.put("btry_l", b.b());
        map.put("bt_con", a(b.g()));
        Long lE = b.e();
        map.put("tod", lE == null ? "" : String.valueOf(lE));
        map.put("apnm", a(b.f()));
        map.put("dnd", a(b.l()));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        map.put("lng", iAConfigManager.o);
        String strA = iAConfigManager.x.a(b.a(str), "LAST_DOMAIN_SHOWED");
        if (!TextUtils.isEmpty(strA) && strA.contains(",")) {
            strA = strA.split(",")[0];
        }
        map.put("ldomain", strA);
        map.put("lbundle", iAConfigManager.x.a(b.a(str), "LAST_APP_BUNDLE_ID"));
        String strA2 = iAConfigManager.x.a(b.a(str), "LAST_CLICKED");
        if (TextUtils.equals(strA2, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            strA2 = "";
        }
        map.put("lclick", strA2);
        String strA3 = iAConfigManager.x.a(b.a(str), "LAST_VAST_SKIPED");
        if (TextUtils.equals(strA3, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            strA3 = "";
        }
        map.put("v_lskip", strA3);
        UnitDisplayType unitDisplayTypeA = b.a(str);
        map.put("v_lclicktype", unitDisplayTypeA.isFullscreenUnit() ? iAConfigManager.x.a(unitDisplayTypeA, "LAST_VAST_CLICKED_TYPE") : "");
        map.put("sdur", String.valueOf(b.c()));
        map.put("userid", iAConfigManager.D.g);
        map.put("low_power_mode", a(b.n()));
        map.put("dark_mode", a(b.h()));
        map.put("d_api", b.d());
        map.put("media_muted", a(b.j()));
        Integer numA = b.a();
        map.put("asv", numA != null ? String.valueOf(numA) : "");
    }

    public static String a(Boolean bool) {
        return bool != null ? bool.booleanValue() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO : "";
    }
}
