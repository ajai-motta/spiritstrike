package com.google.android.recaptcha.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzch {
    public zzch() {
        new ConcurrentHashMap();
        zzb();
    }

    public static final Set zza(Context context) {
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
                linkedHashSet.add(zzvs.TRANSPORT_WIFI);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(0)) {
                linkedHashSet.add(zzvs.TRANSPORT_CELLULAR);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                linkedHashSet.add(zzvs.TRANSPORT_VPN);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(3)) {
                linkedHashSet.add(zzvs.TRANSPORT_ETHERNET);
            }
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                linkedHashSet.add(zzvs.NET_CAPABILITY_VALIDATED);
            }
            return linkedHashSet;
        } catch (Exception unused) {
            return SetsKt.emptySet();
        }
    }

    private static final Map zzb() {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(0, zzvs.NET_CAPABILITY_MMS), TuplesKt.to(1, zzvs.NET_CAPABILITY_SUPL), TuplesKt.to(2, zzvs.NET_CAPABILITY_DUN), TuplesKt.to(3, zzvs.NET_CAPABILITY_FOTA), TuplesKt.to(4, zzvs.NET_CAPABILITY_IMS), TuplesKt.to(5, zzvs.NET_CAPABILITY_CBS), TuplesKt.to(6, zzvs.NET_CAPABILITY_WIFI_P2P), TuplesKt.to(7, zzvs.NET_CAPABILITY_IA), TuplesKt.to(8, zzvs.NET_CAPABILITY_RCS), TuplesKt.to(9, zzvs.NET_CAPABILITY_XCAP), TuplesKt.to(10, zzvs.NET_CAPABILITY_EIMS), TuplesKt.to(11, zzvs.NET_CAPABILITY_NOT_METERED), TuplesKt.to(12, zzvs.NET_CAPABILITY_INTERNET), TuplesKt.to(13, zzvs.NET_CAPABILITY_NOT_RESTRICTED), TuplesKt.to(14, zzvs.NET_CAPABILITY_TRUSTED), TuplesKt.to(15, zzvs.NET_CAPABILITY_NOT_VPN));
        mapMutableMapOf.put(17, zzvs.NET_CAPABILITY_CAPTIVE_PORTAL);
        mapMutableMapOf.put(16, zzvs.NET_CAPABILITY_VALIDATED);
        if (Build.VERSION.SDK_INT >= 28) {
            mapMutableMapOf.put(18, zzvs.NET_CAPABILITY_NOT_ROAMING);
            mapMutableMapOf.put(19, zzvs.NET_CAPABILITY_FOREGROUND);
            mapMutableMapOf.put(20, zzvs.NET_CAPABILITY_NOT_CONGESTED);
            mapMutableMapOf.put(21, zzvs.NET_CAPABILITY_NOT_SUSPENDED);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            mapMutableMapOf.put(23, zzvs.NET_CAPABILITY_MCX);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            mapMutableMapOf.put(25, zzvs.NET_CAPABILITY_TEMPORARILY_NOT_METERED);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            mapMutableMapOf.put(32, zzvs.NET_CAPABILITY_HEAD_UNIT);
            mapMutableMapOf.put(29, zzvs.NET_CAPABILITY_ENTERPRISE);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            mapMutableMapOf.put(35, zzvs.NET_CAPABILITY_PRIORITIZE_BANDWIDTH);
            mapMutableMapOf.put(34, zzvs.NET_CAPABILITY_PRIORITIZE_LATENCY);
            mapMutableMapOf.put(33, zzvs.NET_CAPABILITY_MMTEL);
        }
        return mapMutableMapOf;
    }
}
