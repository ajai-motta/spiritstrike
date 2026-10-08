package com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks;

import com.fyber.inneractive.sdk.flow.storepromo.loader.g;
import com.fyber.inneractive.sdk.network.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1109a;
    public boolean b = false;
    public final String c;

    public c(g gVar, String str) {
        this.f1109a = gVar;
        this.c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0077  */
    @Override // com.fyber.inneractive.sdk.network.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r6, java.lang.Exception r7, boolean r8) {
        /*
            r5 = this;
            java.lang.String r6 = (java.lang.String) r6
            boolean r0 = r5.b
            r1 = 0
            if (r0 == 0) goto Lf
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "StorePromoTemplateCallback: onNetworkResult: the cached response was applied and this one being cached"
            com.fyber.inneractive.sdk.util.IAlog.a(r7, r6)
            goto L7b
        Lf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "StorePromoTemplateCallback: onNetworkResult: fromCache: "
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            com.fyber.inneractive.sdk.util.IAlog.a(r8, r0)
            r8 = 1
            r5.b = r8
            if (r6 == 0) goto L3e
            if (r7 != 0) goto L3e
            com.fyber.inneractive.sdk.flow.storepromo.loader.g r7 = r5.f1109a
            r7.getClass()
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r0 = "StorePromoResourcesLoader: onTemplateDownloaded"
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r8)
            com.fyber.inneractive.sdk.flow.storepromo.model.c r8 = r7.d
            r8.c = r6
            r6 = 0
            r7.a(r6, r1, r6, r6)
            goto L7b
        L3e:
            if (r7 == 0) goto L50
            java.lang.String r6 = r7.getMessage()
            if (r6 == 0) goto L4b
            java.lang.String r6 = r7.getMessage()
            goto L52
        L4b:
            java.lang.String r6 = r7.toString()
            goto L52
        L50:
            java.lang.String r6 = ""
        L52:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable download store promo template, error: "
            r7.<init>(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.fyber.inneractive.sdk.flow.storepromo.loader.g r7 = r5.f1109a
            com.fyber.inneractive.sdk.flow.storepromo.events.a r0 = com.fyber.inneractive.sdk.flow.storepromo.events.a.DOWNLOAD_RESOURCE_ERROR
            java.lang.String r2 = r5.c
            com.fyber.inneractive.sdk.flow.storepromo.loader.network.b r3 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.TEMPLATE_FAILURE
            com.fyber.inneractive.sdk.flow.storepromo.loader.network.b r4 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.SCREENSHOT_FAILURE
            if (r3 != r4) goto L77
            int r3 = r7.f
            int r4 = r7.g
            int r4 = r4 + r8
            r7.g = r4
            int r3 = r3 - r4
            r4 = 2
            if (r3 >= r4) goto L78
        L77:
            r1 = r8
        L78:
            r7.a(r0, r1, r6, r2)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks.c.a(java.lang.Object, java.lang.Exception, boolean):void");
    }
}
