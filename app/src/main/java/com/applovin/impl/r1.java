package com.applovin.impl;

import com.applovin.impl.d2;
import com.applovin.impl.e6;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.internal.AnalyticsEvents;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r1 extends e2 {
    private JSONObject i;

    public r1(com.applovin.impl.sdk.k kVar) {
        super(kVar, d2.b.ERROR);
    }

    public void a(String str, Throwable th) {
        a(str, th, new HashMap());
    }

    public void b() {
        this.i = JsonUtils.deserialize((String) this.f363a.a(y4.K));
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(String str, String str2, Throwable th) {
        a(str, str2, th, new HashMap());
    }

    public void a(String str, String str2, Throwable th, Map map) {
        a(str + ":" + str2, th, map);
    }

    public void b(final String str, final String str2, final Throwable th) {
        this.f363a.r0().a((j5) new s6(this.f363a, "reportCaughtException", new Runnable() { // from class: com.applovin.impl.r1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, str2, th);
            }
        }), e6.b.OTHER);
    }

    public void a(String str, Throwable th, Map map) {
        map.put("source", str);
        map.put("top_main_method", th.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        for (Throwable th2 : th.getSuppressed()) {
            HashMap map2 = new HashMap();
            CollectionUtils.putStringIfValid("source", str, map2);
            CollectionUtils.putStringIfValid("top_main_method", th.toString(), map2);
            CollectionUtils.putStringIfValid("suppressed_throwable", th2.toString(), map2);
            arrayList.add(map2);
        }
        a(d2.N0, arrayList, 0L);
    }

    public void a(String str, String str2, com.applovin.impl.sdk.ad.b bVar) {
        HashMap map = new HashMap();
        map.put("source", str);
        map.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2);
        if (bVar != null) {
            map.putAll(f2.a((AppLovinAdImpl) bVar));
            map.putAll(f2.a(bVar));
            boolean zC0 = bVar.C0();
            map.put("is_video_stream", String.valueOf(zC0));
            if (zC0 && (bVar instanceof com.applovin.impl.sdk.ad.a)) {
                CollectionUtils.putStringIfValid(InneractiveRichMediaVideoPlayerActivityCore.VIDEO_URL, ((com.applovin.impl.sdk.ad.a) bVar).i1(), map);
            } else {
                CollectionUtils.putStringIfValid(InneractiveRichMediaVideoPlayerActivityCore.VIDEO_URL, bVar.I(), map);
            }
        }
        d(d2.T0, map);
    }

    public void a(String str, String str2, int i, String str3) {
        List listA = a(str2);
        boolean z = listA != null;
        if (z && listA.contains(Integer.valueOf(i))) {
            return;
        }
        if (z || i >= 400) {
            HashMap map = new HashMap(4);
            map.put("source", str);
            map.put("url", StringUtils.emptyIfNull(str2));
            map.put("code", String.valueOf(i));
            map.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, f2.a(str3));
            d(d2.W0, map);
        }
    }

    private List a(String str) {
        List<Integer> integerList = JsonUtils.getIntegerList(this.i, StringUtils.getHost(str), null);
        return integerList == null ? JsonUtils.getIntegerList(this.i, "default", null) : integerList;
    }
}
