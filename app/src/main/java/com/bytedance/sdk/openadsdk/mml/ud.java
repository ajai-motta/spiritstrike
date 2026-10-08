package com.bytedance.sdk.openadsdk.mml;

import com.bytedance.sdk.openadsdk.mml.lnr.qdl;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    public static final String qdl = qdl.InterfaceC0264qdl.qdl;
    public static final String ud = qdl.InterfaceC0264qdl.ud;
    public static final String lnr = qdl.InterfaceC0264qdl.lnr;
    public static final String mml = qdl.InterfaceC0264qdl.mml;
    public static final String mzz = qdl.InterfaceC0264qdl.mzz;
    public static final String mo = qdl.InterfaceC0264qdl.mo;
    public static final Set<String> wd = new HashSet(Arrays.asList("click", "show", "insight_log"));

    public static class qdl {
        public static String lnr = "direct";
        public static String mml = "saLandingPageLinks";
        public static String qdl = "openDetailPage";
        public static String ud = "openAdLandPageLinks";
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.mml.ud$ud, reason: collision with other inner class name */
    public static class C0269ud {
        public static int lnr = 100;
        public static int qdl = 1;
        public static int ud = 2;
    }

    public static boolean qdl(String str) {
        return "embeded_ad".equals(str) || "banner_ad".equals(str) || "interaction".equals(str) || "slide_banner_ad".equals(str);
    }
}
