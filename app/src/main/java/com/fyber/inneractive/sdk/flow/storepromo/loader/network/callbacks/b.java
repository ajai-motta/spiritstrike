package com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks;

import com.fyber.inneractive.sdk.flow.storepromo.loader.g;
import com.fyber.inneractive.sdk.network.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1108a;
    public final com.fyber.inneractive.sdk.flow.storepromo.model.b b;
    public final String c;
    public final int d;

    public b(com.fyber.inneractive.sdk.flow.storepromo.model.b bVar, String str, g gVar) {
        this.b = bVar;
        this.c = str;
        this.f1108a = gVar;
        this.d = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a5  */
    @Override // com.fyber.inneractive.sdk.network.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r7, java.lang.Exception r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r7 = (java.lang.String) r7
            r9 = 0
            r0 = 2
            r1 = 1
            if (r7 == 0) goto L3c
            if (r8 != 0) goto L3c
            com.fyber.inneractive.sdk.flow.storepromo.loader.g r8 = r6.f1108a
            com.fyber.inneractive.sdk.flow.storepromo.model.b r2 = r6.b
            int r3 = r6.d
            r8.getClass()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r9] = r2
            r0[r1] = r4
            java.lang.String r4 = "StorePromoResourcesLoader: onAssetDownloaded: type: %s, sortIndex: %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r4, r0)
            com.fyber.inneractive.sdk.flow.storepromo.model.c r0 = r8.d
            com.fyber.inneractive.sdk.flow.storepromo.model.a r4 = new com.fyber.inneractive.sdk.flow.storepromo.model.a
            r4.<init>(r7, r2, r3)
            java.util.ArrayList r7 = r0.f1111a
            r7.add(r4)
            com.fyber.inneractive.sdk.flow.storepromo.model.b r7 = com.fyber.inneractive.sdk.flow.storepromo.model.b.SCREENSHOT
            if (r2 != r7) goto L36
            int r7 = r0.i
            int r7 = r7 + r1
            r0.i = r7
        L36:
            r7 = 0
            r8.a(r7, r9, r7, r7)
            goto La9
        L3c:
            boolean r7 = r8 instanceof com.fyber.inneractive.sdk.flow.storepromo.loader.network.exception.a
            if (r7 == 0) goto L43
            com.fyber.inneractive.sdk.flow.storepromo.events.a r7 = com.fyber.inneractive.sdk.flow.storepromo.events.a.FILE_SIZE_EXCEEDS_LIMIT
            goto L45
        L43:
            com.fyber.inneractive.sdk.flow.storepromo.events.a r7 = com.fyber.inneractive.sdk.flow.storepromo.events.a.DOWNLOAD_RESOURCE_ERROR
        L45:
            com.fyber.inneractive.sdk.flow.storepromo.model.b r2 = r6.b
            if (r8 == 0) goto L59
            java.lang.String r3 = r8.getMessage()
            if (r3 == 0) goto L54
            java.lang.String r8 = r8.getMessage()
            goto L5b
        L54:
            java.lang.String r8 = r8.toString()
            goto L5b
        L59:
            java.lang.String r8 = ""
        L5b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unable download store promo asset type: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = ", error: "
            r3.append(r2)
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            com.fyber.inneractive.sdk.flow.storepromo.loader.g r2 = r6.f1108a
            java.lang.String r3 = r6.c
            com.fyber.inneractive.sdk.flow.storepromo.model.b r4 = r6.b
            int[] r5 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks.a.f1107a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            if (r4 == r1) goto L95
            if (r4 == r0) goto L92
            r5 = 3
            if (r4 == r5) goto L8f
            r5 = 4
            if (r4 == r5) goto L8c
            com.fyber.inneractive.sdk.flow.storepromo.loader.network.b r4 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.UNKNOWN_FAILURE
            goto L97
        L8c:
            com.fyber.inneractive.sdk.flow.storepromo.loader.network.b r4 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.RATING_ICON_FAILURE
            goto L97
        L8f:
            com.fyber.inneractive.sdk.flow.storepromo.loader.network.b r4 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.VIDEO_FAILURE
            goto L97
        L92:
            com.fyber.inneractive.sdk.flow.storepromo.loader.network.b r4 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.SCREENSHOT_FAILURE
            goto L97
        L95:
            com.fyber.inneractive.sdk.flow.storepromo.loader.network.b r4 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.APP_ICON_FAILURE
        L97:
            com.fyber.inneractive.sdk.flow.storepromo.loader.network.b r5 = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.SCREENSHOT_FAILURE
            if (r4 != r5) goto La5
            int r4 = r2.f
            int r5 = r2.g
            int r5 = r5 + r1
            r2.g = r5
            int r4 = r4 - r5
            if (r4 >= r0) goto La6
        La5:
            r9 = r1
        La6:
            r2.a(r7, r9, r8, r3)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks.b.a(java.lang.Object, java.lang.Exception, boolean):void");
    }

    public b(com.fyber.inneractive.sdk.flow.storepromo.model.b bVar, String str, g gVar, int i) {
        this.b = bVar;
        this.c = str;
        this.f1108a = gVar;
        this.d = i;
    }
}
