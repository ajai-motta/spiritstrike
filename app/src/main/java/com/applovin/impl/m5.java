package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.d0;
import com.applovin.impl.e0;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v3;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m5 extends j5 implements v3.a {
    protected final com.applovin.impl.sdk.ad.b g;
    private AppLovinAdLoadListener h;
    protected final String i;
    private final com.applovin.impl.sdk.m j;
    private final Collection k;
    private boolean l;
    protected ExecutorService m;
    protected ExecutorService n;
    protected List o;
    private d0 p;

    class a implements e0.a {
        a() {
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            m5.this.g.a(uri);
            com.applovin.impl.sdk.o oVar = m5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                m5 m5Var = m5.this;
                m5Var.c.a(m5Var.b, "Ad updated with muteImageUri = " + uri);
            }
        }
    }

    class b implements e0.a {
        b() {
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            m5.this.g.b(uri);
            com.applovin.impl.sdk.o oVar = m5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                m5 m5Var = m5.this;
                m5Var.c.a(m5Var.b, "Ad updated with unmuteImageUri = " + uri);
            }
        }
    }

    class c implements e0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e0.a f468a;

        c(e0.a aVar) {
            this.f468a = aVar;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri == null) {
                com.applovin.impl.sdk.o oVar = m5.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    m5 m5Var = m5.this;
                    m5Var.c.b(m5Var.b, "Failed to cache video");
                }
                m5.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
                Bundle bundle = new Bundle();
                bundle.putLong("ad_id", m5.this.g.getAdIdNumber());
                m5.this.f428a.t().a(bundle, "video_caching_failed");
                return;
            }
            com.applovin.impl.sdk.o oVar2 = m5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                m5 m5Var2 = m5.this;
                m5Var2.c.a(m5Var2.b, "Finish caching video for ad #" + m5.this.g.getAdIdNumber() + ". Updating ad with cachedVideoURL = " + uri);
            }
            this.f468a.a(uri);
        }
    }

    class d implements d0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f469a;

        d(e eVar) {
            this.f469a = eVar;
        }

        @Override // com.applovin.impl.d0.c
        public void a(String str, boolean z) {
            if (z) {
                m5.this.a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_HTML_RESOURCES);
                return;
            }
            e eVar = this.f469a;
            if (eVar != null) {
                eVar.a(str);
            }
        }
    }

    public interface e {
        void a(String str);
    }

    m5(String str, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super(str, kVar);
        this.i = UUID.randomUUID().toString();
        if (bVar == null) {
            throw new IllegalArgumentException("No ad specified.");
        }
        this.g = bVar;
        this.h = appLovinAdLoadListener;
        this.j = kVar.G();
        this.k = h();
        if (((Boolean) kVar.a(y4.N0)).booleanValue()) {
            if (kVar.r0().f()) {
                this.m = kVar.r0().a();
                this.n = kVar.r0().e();
                return;
            }
            String mediationServeId = StringUtils.isValidString(bVar.getMediationServeId()) ? bVar.getMediationServeId() : UUID.randomUUID().toString();
            this.m = kVar.r0().a("com.applovin.sdk.caching." + mediationServeId, ((Integer) kVar.a(y4.P0)).intValue());
            this.n = kVar.r0().a("com.applovin.sdk.caching.html." + mediationServeId, ((Integer) kVar.a(y4.Q0)).intValue());
        }
    }

    private Collection h() {
        HashSet hashSet = new HashSet();
        for (char c2 : ((String) this.f428a.a(y4.I0)).toCharArray()) {
            hashSet.add(Character.valueOf(c2));
        }
        hashSet.add('\"');
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        AppLovinAdLoadListener appLovinAdLoadListener = this.h;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(this.g);
            this.h = null;
        }
    }

    @Override // com.applovin.impl.v3.a
    public void a(y2 y2Var) {
        if (y2Var.O().equalsIgnoreCase(this.g.getMediationServeId())) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Updating flag for timeout...");
            }
            g();
        }
        this.f428a.Z().b(this);
    }

    protected e0 b(String str, e0.a aVar) {
        return a(str, this.g.S(), true, aVar);
    }

    Uri c(String str) {
        return b(str, this.g.S(), true);
    }

    protected List e() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching mute images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.g.G() != null) {
            arrayList.add(a(this.g.G().toString(), new a()));
        }
        if (this.g.Y() != null) {
            arrayList.add(a(this.g.Y().toString(), new b()));
        }
        return arrayList;
    }

    void f() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Rendered new ad:" + this.g);
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.m5$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.i();
            }
        });
    }

    protected void g() {
        this.l = true;
        List list = this.o;
        if (list != null && !list.isEmpty()) {
            Iterator it = this.o.iterator();
            while (it.hasNext()) {
                ((c0) it.next()).a(true);
            }
        }
        if (this.f428a.r0().f()) {
            d0 d0Var = this.p;
            if (d0Var != null) {
                d0Var.c();
                return;
            }
            return;
        }
        ExecutorService executorService = this.m;
        if (executorService != null) {
            executorService.shutdown();
            this.m = null;
        }
        ExecutorService executorService2 = this.n;
        if (executorService2 != null) {
            executorService2.shutdown();
            this.n = null;
        }
    }

    void j() {
        if (o0.e()) {
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching mute images...");
        }
        Uri uriA = a(this.g.G(), "mute");
        if (uriA != null) {
            this.g.a(uriA);
        }
        Uri uriA2 = a(this.g.Y(), "unmute");
        if (uriA2 != null) {
            this.g.b(uriA2);
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Ad updated with muteImageFilename = " + this.g.G() + ", unmuteImageFilename = " + this.g.Y());
        }
    }

    protected void k() {
        this.f428a.Z().b(this);
        if (!this.f428a.r0().f()) {
            ExecutorService executorService = this.m;
            if (executorService != null) {
                executorService.shutdown();
                this.m = null;
            }
            ExecutorService executorService2 = this.n;
            if (executorService2 != null) {
                executorService2.shutdown();
                this.n = null;
            }
        }
        MaxAdFormat maxAdFormatD = this.g.getAdZone().d();
        if (((Boolean) this.f428a.a(y4.c1)).booleanValue() && maxAdFormatD != null && maxAdFormatD.isFullscreenAd()) {
            this.f428a.h().b(this.g);
        }
        this.f428a.d0().a(this.i);
    }

    protected boolean l() {
        return this.l;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.g.b1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Subscribing to timeout events...");
            }
            this.f428a.Z().a(this);
        }
    }

    Uri b(String str, List list, boolean z) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video " + str + "...");
        }
        int iA = this.f428a.G().a(str, this.g);
        Map mapA = f2.a((AppLovinAdImpl) this.g);
        String strA = this.j.a(a(), str, this.g.getCachePrefix(), list, z, iA, this.i, mapA);
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to cache video: " + str);
            }
            a(str, "cacheVideo", mapA);
            a(AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
            return null;
        }
        File fileA = this.j.a(strA, a());
        if (fileA == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to retrieve File from cached video filename = " + strA);
            }
            a(strA, "retrieveVideoFile", mapA);
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to create URI from cached video file = " + fileA);
            }
            a(strA, "extractUriFromVideoFile", mapA);
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finish caching video for ad #" + this.g.getAdIdNumber() + ". Updating ad with cachedVideoFilename = " + strA);
        }
        return uriFromFile;
    }

    protected String c(String str, List list, boolean z) {
        try {
            InputStream inputStreamA = this.j.a(str, list, z, f2.a((AppLovinAdImpl) this.g));
            if (inputStreamA == null) {
                if (inputStreamA != null) {
                    inputStreamA.close();
                }
                return null;
            }
            try {
                String strA = this.j.a(inputStreamA);
                inputStreamA.close();
                return strA;
            } finally {
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unknown failure to read input stream.", th);
            }
            this.c.a(this.b, th);
            this.f428a.D().a(this.b, "readInputStreamAsString", th);
            return null;
        }
    }

    protected List a(List list) {
        this.o = list;
        return this.f428a.r0().a(list, this.m);
    }

    protected e0 a(String str, e0.a aVar) {
        return new e0(str, this.g, this.i, this.f428a, aVar);
    }

    protected e0 a(String str, List list, boolean z, e0.a aVar) {
        if (TextUtils.isEmpty(str)) {
            if (!com.applovin.impl.sdk.o.a()) {
                return null;
            }
            this.c.a(this.b, "No video to cache, skipping...");
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video " + str + "...");
        }
        return new e0(str, this.g, list, z, this.i, this.f428a, new c(aVar));
    }

    protected d0 a(String str, List list, e eVar) {
        d0 d0Var = new d0(str, this.g, list, this.n, this.i, this.f428a, new d(eVar));
        this.p = d0Var;
        return d0Var;
    }

    protected Uri a(Uri uri, String str) {
        if (uri == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No " + str + " image to cache");
            }
            return null;
        }
        String string = uri.toString();
        if (TextUtils.isEmpty(string)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to cache " + str + " image");
            }
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching " + str + " image...");
        }
        return b(string);
    }

    Uri a(String str, List list, boolean z) {
        try {
            int iA = this.f428a.G().a(str, this.g);
            Map mapA = f2.a((AppLovinAdImpl) this.g);
            String strA = this.j.a(a(), str, this.g.getCachePrefix(), list, z, iA, this.i, mapA);
            if (StringUtils.isValidString(strA)) {
                File fileA = this.j.a(strA, a());
                if (fileA != null) {
                    Uri uriFromFile = Uri.fromFile(fileA);
                    if (uriFromFile != null) {
                        return uriFromFile;
                    }
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.b(this.b, "Unable to extract Uri from image file");
                    }
                    a(strA, "extractUriFromImageFile", mapA);
                    return null;
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Unable to retrieve File from cached image filename = " + strA);
                }
                a(strA, "retrieveImageFile", mapA);
                return null;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to cache image: " + str);
            }
            a(str, "cacheImageResource", mapA);
            return null;
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to cache image at url = " + str, th);
            }
            Map mapA2 = f2.a((AppLovinAdImpl) this.g);
            CollectionUtils.putStringIfValid("url", str, mapA2);
            this.f428a.D().a(this.b, "cacheImageResource", th, mapA2);
            return null;
        }
    }

    protected Uri b(String str) {
        return a(str, this.g.S(), true);
    }

    void a(com.applovin.impl.sdk.ad.b bVar) {
        String strA0 = bVar.a0();
        if (bVar.J0() && StringUtils.isValidString(strA0)) {
            String strA = a(strA0, bVar.S(), bVar);
            bVar.c(strA);
            this.c.f(this.b, "Ad updated with video button HTML assets cached = " + strA);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0038, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String a(java.lang.String r12, java.util.List r13, com.applovin.impl.sdk.ad.b r14) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.m5.a(java.lang.String, java.util.List, com.applovin.impl.sdk.ad.b):java.lang.String");
    }

    private Uri a(String str, String str2) {
        File fileA = this.j.a(o7.a(Uri.parse(str2), this.g.getCachePrefix(), this.f428a), com.applovin.impl.sdk.k.o());
        if (fileA == null) {
            return null;
        }
        if (!((Boolean) this.f428a.a(y4.R6)).booleanValue() && this.j.a(fileA)) {
            return Uri.parse("file://" + fileA.getAbsolutePath());
        }
        String str3 = str + str2;
        if (!this.j.a(fileA, str3, Arrays.asList(str), this.f428a.G().a(str3, this.g), this.i, f2.a((AppLovinAdImpl) this.g))) {
            return null;
        }
        return Uri.parse("file://" + fileA.getAbsolutePath());
    }

    void a(int i) {
        if (this.h != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Calling back ad load failed with error code: " + i);
            }
            this.h.failedToReceiveAd(i);
            this.h = null;
        }
        g();
    }

    protected void a(String str, String str2, Map map) {
        HashMap map2 = new HashMap(map);
        CollectionUtils.putStringIfValid("url", str, map2);
        this.f428a.D().a(d2.M0, str2, map2);
    }
}
