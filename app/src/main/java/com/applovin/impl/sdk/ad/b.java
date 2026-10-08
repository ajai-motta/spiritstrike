package com.applovin.impl.sdk.ad;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.arch.core.util.Function;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.applovin.impl.adview.e;
import com.applovin.impl.adview.m;
import com.applovin.impl.e8;
import com.applovin.impl.f4;
import com.applovin.impl.g1;
import com.applovin.impl.i5;
import com.applovin.impl.o0;
import com.applovin.impl.o4;
import com.applovin.impl.o7;
import com.applovin.impl.o8;
import com.applovin.impl.q4;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.y4;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends AppLovinAdImpl implements q4 {
    private final Map d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    private final AtomicReference g;
    private final Bundle h;
    private String i;
    private long j;
    private int k;
    private String l;
    private d m;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.ad.b$b, reason: collision with other inner class name */
    public enum EnumC0158b {
        UNSPECIFIED,
        DISMISS,
        DO_NOT_DISMISS
    }

    public enum c {
        DEFAULT,
        ACTIVITY_PORTRAIT,
        ACTIVITY_LANDSCAPE
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f620a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        private d() {
            this.f620a = AppLovinSdkUtils.dpToPx(k.o(), b.this.o());
            this.b = AppLovinSdkUtils.dpToPx(k.o(), b.this.q());
            this.c = AppLovinSdkUtils.dpToPx(k.o(), b.this.m());
            this.d = AppLovinSdkUtils.dpToPx(k.o(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(y4.o1)).intValue());
            this.e = AppLovinSdkUtils.dpToPx(k.o(), ((Integer) ((AppLovinAdBase) b.this).sdk.a(y4.n1)).intValue());
        }
    }

    public enum e {
        RESIZE_ASPECT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public b(JSONObject jSONObject, JSONObject jSONObject2, k kVar) {
        super(jSONObject, jSONObject2, kVar);
        this.d = Collections.synchronizedMap(new HashMap());
        this.e = new AtomicBoolean();
        this.f = new AtomicBoolean();
        this.g = new AtomicReference();
        this.h = new Bundle();
    }

    private List E() {
        return getIntegerListFromAdObject("multi_close_style", null);
    }

    private String h0() {
        String stringFromAdObject = getStringFromAdObject("video_end_url", null);
        if (stringFromAdObject != null) {
            return stringFromAdObject.replace("{CLCODE}", getClCode());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List i(i5 i5Var) {
        return o7.a(i5Var.a("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List k(i5 i5Var) {
        return o7.a(i5Var.a("imp_urls", new JSONObject()), getClCode(), null, null, J(), N0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String n(i5 i5Var) {
        return JsonUtils.getString(i5Var.a("video_button_properties", (JSONObject) null), "video_button_html", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ e8 o(i5 i5Var) {
        return new e8(i5Var.a("video_button_properties", (JSONObject) null), this.sdk);
    }

    public List A() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda7
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.k((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("imp_urls", new JSONObject()), getClCode(), null, null, J(), N0(), this.sdk);
        }
        return listA;
    }

    public boolean A0() {
        return getBooleanFromAdObject("lhs_skip_button", (Boolean) this.sdk.a(y4.d2));
    }

    public int B() {
        return getIntFromAdObject("mdafra", ((Integer) this.sdk.a(y4.X0)).intValue());
    }

    public boolean B0() {
        return getBooleanFromAdObject("video_clickable", Boolean.FALSE);
    }

    public boolean C() {
        return getBooleanFromAdObject("playback_requires_user_action", Boolean.TRUE);
    }

    public abstract boolean C0();

    public List D() {
        List listE = E();
        if (listE == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listE.size());
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(a(((Integer) it.next()).intValue()));
        }
        return arrayList;
    }

    public boolean D0() {
        return getBooleanFromAdObject("web_contents_debugging_enabled", Boolean.valueOf(o7.j(k.o()) || o7.h(k.o()) || ((Boolean) this.sdk.a(y4.A6)).booleanValue()));
    }

    public abstract void E0();

    public List F() {
        return getIntegerListFromAdObject("multi_close_delay_graphic", null);
    }

    public boolean F0() {
        return getBooleanFromAdObject("aarwdc", (Boolean) this.sdk.a(y4.B2));
    }

    public Uri G() {
        String stringFromAdObject = getStringFromAdObject("mute_image", "https://assets.applovin.com/sound_off.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean G0() {
        return getBooleanFromAdObject("always_reward_user", (Boolean) this.sdk.a(y4.l1));
    }

    public List H() {
        String stringFromAdObject = getStringFromAdObject("optional_html_resources", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    public boolean H0() {
        return getBooleanFromAdObject("should_apply_mute_setting_to_poststitial", Boolean.FALSE);
    }

    public abstract String I();

    public boolean I0() {
        return getBooleanFromAdObject("should_apply_web_view_settings_to_web_view_button", (Boolean) this.sdk.a(y4.E6));
    }

    public Map J() {
        HashMap map = new HashMap();
        try {
            i5 i5Var = this.synchronizedAdObject;
            map.putAll(i5Var != null ? (Map) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda12
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.l((i5) obj);
                }
            }) : JsonUtils.toStringMap(getJsonObjectFromAdObject("http_headers_for_postbacks", new JSONObject())));
        } catch (JSONException e2) {
            this.sdk.O();
            if (o.a()) {
                this.sdk.O().a("DirectAd", "Failed to retrieve http headers for postbacks", e2);
            }
        }
        if (getBooleanFromAdObject("use_webview_ua_for_postbacks", Boolean.FALSE)) {
            map.put(HttpHeaders.USER_AGENT, o8.a());
        }
        return map;
    }

    public boolean J0() {
        i5 i5Var = this.synchronizedAdObject;
        return i5Var != null ? ((Boolean) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.r((i5) obj);
            }
        })).booleanValue() : JsonUtils.getBoolean(getJsonObjectFromAdObject("video_button_properties", null), "should_cache_video_button_html_assets", Boolean.FALSE).booleanValue();
    }

    public EnumC0158b K() {
        String stringFromAdObject = getStringFromAdObject("poststitial_dismiss_type", null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            if ("dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0158b.DISMISS;
            }
            if ("no_dismiss".equalsIgnoreCase(stringFromAdObject)) {
                return EnumC0158b.DO_NOT_DISMISS;
            }
        }
        return EnumC0158b.UNSPECIFIED;
    }

    public boolean K0() {
        return this.f.get();
    }

    public int L() {
        return getColorFromAdObject("postitial_progress_bar_color", -922746881);
    }

    public boolean L0() {
        return U0() || S0() || T0();
    }

    public long M() {
        return getLongFromAdObject("postitial_progress_bar_total_ms", -1L);
    }

    public boolean M0() {
        return getBooleanFromAdObject("serfaad", (Boolean) this.sdk.a(y4.W0));
    }

    public List N() {
        return getStringListFromAdObject("pbpn", this.sdk.c(y4.P6));
    }

    public boolean N0() {
        return getBooleanFromAdObject("fire_postbacks_from_webview", Boolean.FALSE);
    }

    public long O() {
        long longFromAdObject = getLongFromAdObject("report_reward_duration", -1L);
        if (longFromAdObject >= 0) {
            return TimeUnit.SECONDS.toMillis(longFromAdObject);
        }
        return -1L;
    }

    public boolean O0() {
        return getBooleanFromAdObject("should_forward_close_button_tapped_to_poststitial", Boolean.FALSE);
    }

    public int P() {
        return getIntFromAdObject("report_reward_percent", -1);
    }

    public boolean P0() {
        return getBooleanFromAdObject("fmsstwvoar", Boolean.FALSE);
    }

    public List Q() {
        String stringFromAdObject = getStringFromAdObject("required_html_resources", null);
        return stringFromAdObject != null ? CollectionUtils.explode(stringFromAdObject) : Collections.emptyList();
    }

    public boolean Q0() {
        return getBooleanFromAdObject("sftbpn", Boolean.FALSE);
    }

    public int R() {
        return this.k;
    }

    public boolean R0() {
        return getBooleanFromAdObject("fvcetwv", Boolean.FALSE);
    }

    public List S() {
        String stringFromAdObject = getStringFromAdObject("resource_cache_prefix", null);
        ArrayList arrayList = stringFromAdObject != null ? new ArrayList(CollectionUtils.explode(stringFromAdObject)) : new ArrayList(this.sdk.c(y4.K0));
        if (o7.j(k.o())) {
            arrayList.add("https://p.applov.in/");
        }
        return arrayList;
    }

    public boolean S0() {
        return getStringListFromAdObject("system_bars_hide_list", this.sdk.c(y4.A2)).contains(NotificationCompat.CATEGORY_NAVIGATION);
    }

    public List T() {
        return getStringListFromAdObject("rea", Q());
    }

    public boolean T0() {
        return getStringListFromAdObject("system_bars_hide_list", this.sdk.c(y4.A2)).contains("none");
    }

    public e.a U() {
        int intFromAdObject = getIntFromAdObject("skip_style", -1);
        return intFromAdObject == -1 ? p() : a(intFromAdObject);
    }

    public boolean U0() {
        return getStringListFromAdObject("system_bars_hide_list", this.sdk.c(y4.A2)).contains("status");
    }

    public List V() {
        return getStringListFromAdObject("substrings_for_disabled_click_logic", Collections.emptyList());
    }

    public boolean V0() {
        return getBooleanFromAdObject("avoms", Boolean.FALSE);
    }

    public c W() {
        c cVar = c.DEFAULT;
        String upperCase = getStringFromAdObject("ad_target", cVar.toString()).toUpperCase(Locale.ENGLISH);
        return "ACTIVITY_PORTRAIT".equalsIgnoreCase(upperCase) ? c.ACTIVITY_PORTRAIT : "ACTIVITY_LANDSCAPE".equalsIgnoreCase(upperCase) ? c.ACTIVITY_LANDSCAPE : cVar;
    }

    public boolean W0() {
        return getBooleanFromAdObject("report_reward_percent_include_close_delay", Boolean.TRUE);
    }

    public String X() {
        return this.l;
    }

    public boolean X0() {
        return getBooleanFromAdObject("require_interaction_for_click", Boolean.FALSE);
    }

    public Uri Y() {
        String stringFromAdObject = getStringFromAdObject("unmute_image", "https://assets.applovin.com/sound_on.png");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    public boolean Y0() {
        return getBooleanFromAdObject("sruifwvc", Boolean.FALSE);
    }

    public String Z() {
        i5 i5Var = this.synchronizedAdObject;
        return i5Var != null ? (String) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.m((i5) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_base_url", DomExceptionUtils.SEPARATOR);
    }

    public boolean Z0() {
        return g() >= 0;
    }

    public String a0() {
        i5 i5Var = this.synchronizedAdObject;
        return i5Var != null ? (String) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return b.n((i5) obj);
            }
        }) : JsonUtils.getString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", "");
    }

    public boolean a1() {
        return getBooleanFromAdObject("respect_adview_fully_watched", Boolean.FALSE);
    }

    public e8 b0() {
        i5 i5Var = this.synchronizedAdObject;
        return i5Var != null ? (e8) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda10
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f$0.o((i5) obj);
            }
        }) : new e8(getJsonObjectFromAdObject("video_button_properties", null), this.sdk);
    }

    public boolean b1() {
        return getBooleanFromAdObject("sscomt", Boolean.FALSE);
    }

    public void c(final String str) {
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            i5Var.a(new Consumer() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda13
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    b.a(str, (i5) obj);
                }
            });
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(getJsonObjectFromAdObject("video_button_properties", null), "video_button_html", str);
        }
    }

    public abstract Uri c0();

    public boolean c1() {
        return getBooleanFromAdObject("sudbia", (Boolean) this.sdk.a(y4.O6));
    }

    public List d(MotionEvent motionEvent, boolean z) {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        Map mapA = a(motionEvent, z);
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(StringUtils.replace(it.next(), mapA));
        }
        return arrayList;
    }

    public long d0() {
        return getLongFromAdObject("close_delay", 0L);
    }

    public boolean d1() {
        return getBooleanFromAdObject("upiosp", Boolean.FALSE);
    }

    public List e() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda22
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.a((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public long e0() {
        return TimeUnit.SECONDS.toMillis(getLongFromAdObject("close_delay_max_buffering_time_seconds", 5L));
    }

    public long f() {
        return getLongFromAdObject("ad_dismiss_delay_on_app_launch_ms", TimeUnit.SECONDS.toMillis(3L));
    }

    public int f0() {
        return o7.c(getIntFromAdObject("video_completion_percent", -1));
    }

    public long g() {
        return getLongFromAdObject("ad_reshow_delay_on_app_launch_ms", -1L);
    }

    public List g0() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda18
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.p((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("video_end_urls", new JSONObject()), getClCode(), h0(), this.sdk);
        }
        return listA;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.e4
    public abstract f4 getAdEventTracker();

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", null);
    }

    public Bundle getCustomTabsHeaders() {
        Map map;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            map = (Map) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda20
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.c((i5) obj);
                }
            });
        } else {
            try {
                map = JsonUtils.toStringMap(getJsonObjectFromAdObject("custom_tabs_http_headers", new JSONObject()));
            } catch (JSONException e2) {
                this.sdk.O();
                if (o.a()) {
                    this.sdk.O().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e2);
                }
                map = new HashMap();
            }
        }
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        if (getBooleanFromAdObject("custom_tabs_should_use_webview_ua", Boolean.FALSE)) {
            bundle.putString(HttpHeaders.USER_AGENT, o8.a());
        }
        return bundle;
    }

    public List getCustomTabsNavigationAbortedPostbacks() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda3
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.d((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List getCustomTabsNavigationFailedPostbacks() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda8
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.e((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List getCustomTabsNavigationFinishedPostbacks() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda14
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.f((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List getCustomTabsNavigationStartedPostbacks() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda5
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.g((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public g1 getCustomTabsSettings() {
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (g1) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda17
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.h((i5) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("custom_tabs_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new g1(jsonObjectFromAdObject);
        }
        return null;
    }

    public List getCustomTabsTabHiddenPostbacks() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.i((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("custom_tabs_tab_hidden_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List getCustomTabsTabShownPostbacks() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda11
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.j((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public List getCustomTabsWarmupUrls() {
        return getStringListFromAdObject("custom_tabs_warmup_urls", Collections.emptyList());
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.e4
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.e4
    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.e4
    public List getOpenMeasurementVerificationScriptResources() {
        List list;
        final Function function = new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda15
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f$0.a((JSONArray) obj);
            }
        };
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda16
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.a(function, (i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            list = (List) function.apply(getJsonArrayFromAdObject("omid_verification_script_resources", null));
        }
        return list;
    }

    public List getPrivacySandboxImpressionAttributionUrls() {
        List<String> stringListFromAdObject = getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.emptyList());
        if (stringListFromAdObject.isEmpty()) {
            return stringListFromAdObject;
        }
        ArrayList arrayList = new ArrayList(stringListFromAdObject.size());
        String clCode = getClCode();
        Iterator<String> it = stringListFromAdObject.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().replace("{CLCODE}", clCode));
        }
        return arrayList;
    }

    public Bundle h() {
        return this.h;
    }

    public e i0() {
        String stringFromAdObject = getStringFromAdObject("video_gravity", null);
        return ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(stringFromAdObject) ? e.TOP : "bottom".equals(stringFromAdObject) ? e.BOTTOM : "left".equals(stringFromAdObject) ? e.LEFT : TtmlNode.RIGHT.equals(stringFromAdObject) ? e.RIGHT : e.RESIZE_ASPECT;
    }

    public boolean isCustomTabsClientWarmupEnabled() {
        return getBooleanFromAdObject("custom_tabs_client_warmup_enabled", Boolean.FALSE);
    }

    public boolean isCustomTabsEnabled() {
        return getBooleanFromAdObject("custom_tabs_enabled", Boolean.FALSE);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.e4
    public abstract boolean isOpenMeasurementEnabled();

    public List j() {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda9
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.b((i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
        }
        return listA;
    }

    public int j0() {
        return getColorFromAdObject("progress_bar_color", -922746881);
    }

    public boolean k0() {
        return getBooleanFromAdObject("progress_bar_enabled", Boolean.FALSE);
    }

    public Map l() {
        return this.d;
    }

    public abstract Uri l0();

    public int m() {
        return getIntFromAdObject("close_button_horizontal_margin", ((Integer) this.sdk.a(y4.R1)).intValue());
    }

    public int m0() {
        return getIntFromAdObject("whalt", o7.a(getSize()) ? 1 : ((Boolean) this.sdk.a(y4.b6)).booleanValue() ? 0 : -1);
    }

    public m n0() {
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (m) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda21
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return b.q((i5) obj);
                }
            });
        }
        JSONObject jsonObjectFromAdObject = getJsonObjectFromAdObject("web_view_settings", null);
        if (jsonObjectFromAdObject != null) {
            return new m(jsonObjectFromAdObject);
        }
        return null;
    }

    public List o0() {
        return CollectionUtils.explode(getStringFromAdObject("wlh", null));
    }

    public e.a p() {
        List listE = E();
        int intFromAdObject = getIntFromAdObject("close_style", (listE == null || listE.size() <= 0) ? -1 : ((Integer) listE.get(0)).intValue());
        return intFromAdObject == -1 ? a(hasVideoUrl()) : a(intFromAdObject);
    }

    public List p0() {
        return CollectionUtils.explode(getStringFromAdObject("wls", ""));
    }

    public int q() {
        return getIntFromAdObject("close_button_top_margin", ((Integer) this.sdk.a(y4.T1)).intValue());
    }

    public void q0() {
        this.k++;
    }

    public long r() {
        List listF = F();
        long longFromAdObject = getLongFromAdObject("close_delay_graphic", (listF == null || listF.size() <= 0) ? 0L : ((Integer) listF.get(0)).intValue());
        if (longFromAdObject == -1 || longFromAdObject == -2) {
            return 0L;
        }
        return longFromAdObject;
    }

    public boolean r0() {
        return getBooleanFromAdObject("aocve", (Boolean) this.sdk.a(y4.v6));
    }

    public int s() {
        return getColorFromAdObject("countdown_color", -922746881);
    }

    public boolean s0() {
        return this.k > 0;
    }

    public boolean shouldCustomTabsTrackEvents() {
        return getBooleanFromAdObject("custom_tabs_should_track_events", Boolean.FALSE);
    }

    public int t() {
        return getIntFromAdObject("countdown_length", 0);
    }

    public boolean t0() {
        return getBooleanFromAdObject("bvde", (Boolean) this.sdk.a(y4.i6));
    }

    public boolean u() {
        return getBooleanFromAdObject("dismiss_on_skip", Boolean.FALSE);
    }

    public boolean u0() {
        return getBooleanFromAdObject("lhs_close_button", (Boolean) this.sdk.a(y4.Q1));
    }

    public String v() {
        return this.i;
    }

    public boolean v0() {
        return getBooleanFromAdObject("forward_lifecycle_events_to_webview", Boolean.FALSE);
    }

    public int w() {
        return getIntFromAdObject("poststitial_dismiss_forward_delay_millis", -1);
    }

    public boolean w0() {
        return getBooleanFromAdObject("gase", Boolean.FALSE);
    }

    public int x() {
        return getIntFromAdObject("poststitial_shown_forward_delay_millis", -1);
    }

    public boolean x0() {
        return getBooleanFromAdObject("lock_current_orientation", Boolean.FALSE);
    }

    public int y() {
        return o7.a(getIntFromAdObject("graphic_completion_percent", -1), 90);
    }

    public abstract boolean y0();

    public long z() {
        return this.j;
    }

    public AtomicBoolean z0() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List f(i5 i5Var) {
        return o7.a(i5Var.a("custom_tabs_navigation_finished_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List g(i5 i5Var) {
        return o7.a(i5Var.a("custom_tabs_navigation_started_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g1 h(i5 i5Var) {
        JSONObject jSONObjectA = i5Var.a("custom_tabs_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new g1(jSONObjectA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map l(i5 i5Var) {
        try {
            return JsonUtils.toStringMap(i5Var.a("http_headers_for_postbacks", new JSONObject()));
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String m(i5 i5Var) {
        return JsonUtils.getString(i5Var.a("video_button_properties", (JSONObject) null), "video_button_base_url", DomExceptionUtils.SEPARATOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ m q(i5 i5Var) {
        JSONObject jSONObjectA = i5Var.a("web_view_settings", (JSONObject) null);
        if (jSONObjectA != null) {
            return new m(jSONObjectA);
        }
        return null;
    }

    public void a(String str) {
        this.i = str;
    }

    public void b(String str) {
        this.l = str;
    }

    public void a(long j) {
        this.j = j;
    }

    public void b(boolean z) {
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            i5Var.a("html_resources_cached", z);
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putBoolean(this.adObject, "html_resources_cached", z);
        }
    }

    public o4 i() {
        return (o4) this.g.getAndSet(null);
    }

    public String k() {
        String stringFromAdObject = getStringFromAdObject("base_url", DomExceptionUtils.SEPARATOR);
        if (AbstractJsonLexerKt.NULL.equalsIgnoreCase(stringFromAdObject)) {
            return null;
        }
        return stringFromAdObject;
    }

    public d n() {
        if (this.m == null) {
            this.m = new d();
        }
        return this.m;
    }

    public int o() {
        return getIntFromAdObject("close_button_size", ((Integer) this.sdk.a(y4.S1)).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            try {
                URL url = new URL(JsonUtils.getString(jSONObject, "url", null));
                String string = JsonUtils.getString(jSONObject, "vendor_key", null);
                String string2 = JsonUtils.getString(jSONObject, "parameters", null);
                if (StringUtils.isValidString(string) && StringUtils.isValidString(string2)) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                }
            } catch (Throwable th) {
                this.sdk.O();
                if (o.a()) {
                    this.sdk.O().a("DirectAd", "Failed to parse OMID verification script resource", th);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean r(i5 i5Var) {
        return JsonUtils.getBoolean(i5Var.a("video_button_properties", (JSONObject) null), "should_cache_video_button_html_assets", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List p(i5 i5Var) {
        return o7.a(i5Var.a("video_end_urls", new JSONObject()), getClCode(), h0(), this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List d(i5 i5Var) {
        return o7.a(i5Var.a("custom_tabs_navigation_aborted_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    public void d() {
        this.f.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List b(i5 i5Var) {
        return o7.a(i5Var.a("app_killed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List e(i5 i5Var) {
        return o7.a(i5Var.a("custom_tabs_navigation_failed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List j(i5 i5Var) {
        return o7.a(i5Var.a("custom_tabs_tab_shown_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    private List b(final MotionEvent motionEvent, final boolean z) {
        List listA;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            return (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda19
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.a(motionEvent, z, (i5) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = o7.a(getJsonObjectFromAdObject("click_tracking_urls", new JSONObject()), a(motionEvent, z), c(motionEvent, z), J(), N0(), this.sdk);
        }
        return listA;
    }

    public long c() {
        return getLongFromAdObject("batfort", TimeUnit.SECONDS.toMillis(1L));
    }

    private String c(MotionEvent motionEvent, boolean z) {
        String stringFromAdObject = getStringFromAdObject("click_tracking_url", null);
        Map mapA = a(motionEvent, z);
        if (stringFromAdObject != null) {
            return StringUtils.replace(stringFromAdObject, mapA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map c(i5 i5Var) {
        try {
            return JsonUtils.toStringMap(i5Var.a("custom_tabs_http_headers", new JSONObject()));
        } catch (JSONException e2) {
            this.sdk.O();
            if (o.a()) {
                this.sdk.O().a("DirectAd", "Failed to retrieve http headers for Custom Tabs", e2);
            }
            return new HashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List a(Function function, i5 i5Var) {
        return (List) function.apply(i5Var.a("omid_verification_script_resources", (JSONArray) null));
    }

    public void a(String str, String str2) {
        this.d.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, i5 i5Var) {
        JsonUtils.putString(i5Var.a("video_button_properties", (JSONObject) null), "video_button_html", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(i5 i5Var) {
        return o7.a(i5Var.a("ad_closed_urls", new JSONObject()), getClCode(), (String) null, this.sdk);
    }

    public List a(MotionEvent motionEvent) {
        return b(motionEvent, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, boolean z, i5 i5Var) {
        return o7.a(i5Var.a("click_tracking_urls", new JSONObject()), a(motionEvent, z), c(motionEvent, z), J(), N0(), this.sdk);
    }

    public List b(final MotionEvent motionEvent) {
        List listA;
        List list;
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            list = (List) i5Var.a(new Function() { // from class: com.applovin.impl.sdk.ad.b$$ExternalSyntheticLambda6
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.a(motionEvent, (i5) obj);
                }
            });
        } else {
            synchronized (this.adObjectLock) {
                listA = o7.a(getJsonObjectFromAdObject("video_click_tracking_urls", new JSONObject()), a(motionEvent, true), null, J(), N0(), this.sdk);
            }
            list = listA;
        }
        return list.isEmpty() ? b(motionEvent, true) : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List a(MotionEvent motionEvent, i5 i5Var) {
        return o7.a(i5Var.a("video_click_tracking_urls", new JSONObject()), a(motionEvent, true), null, J(), N0(), this.sdk);
    }

    private Map a(MotionEvent motionEvent, boolean z) {
        Point pointB = o0.b(k.o());
        HashMap map = new HashMap(7);
        map.put("{CLCODE}", getClCode());
        map.put("{CLICK_X}", String.valueOf(motionEvent != null ? motionEvent.getRawX() : -1.0f));
        map.put("{CLICK_Y}", String.valueOf(motionEvent != null ? motionEvent.getRawY() : -1.0f));
        map.put("{SCREEN_WIDTH}", String.valueOf(pointB.x));
        map.put("{SCREEN_HEIGHT}", String.valueOf(pointB.y));
        map.put("{IS_VIDEO_CLICK}", String.valueOf(z));
        return map;
    }

    public void a(Uri uri) {
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            i5Var.b("mute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "mute_image", uri.toString());
        }
    }

    public void b(Uri uri) {
        i5 i5Var = this.synchronizedAdObject;
        if (i5Var != null) {
            i5Var.b("unmute_image", uri.toString());
            return;
        }
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "unmute_image", uri.toString());
        }
    }

    public void a(o4 o4Var) {
        this.g.set(o4Var);
    }

    private e.a a(boolean z) {
        return z ? e.a.WHITE_ON_TRANSPARENT : e.a.WHITE_ON_BLACK;
    }

    protected e.a a(int i) {
        if (i == 1) {
            return e.a.WHITE_ON_TRANSPARENT;
        }
        if (i == 2) {
            return e.a.INVISIBLE;
        }
        if (i == 3) {
            return e.a.TRANSPARENT_SKIP;
        }
        return e.a.WHITE_ON_BLACK;
    }
}
