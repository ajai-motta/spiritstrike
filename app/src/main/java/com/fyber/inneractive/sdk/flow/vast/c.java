package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.a0;
import com.fyber.inneractive.sdk.model.vast.k;
import com.fyber.inneractive.sdk.model.vast.l;
import com.fyber.inneractive.sdk.model.vast.r;
import com.fyber.inneractive.sdk.model.vast.w;
import com.fyber.inneractive.sdk.model.vast.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import com.fyber.inneractive.sdk.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1122a;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public boolean e = false;
    public boolean f = false;
    public final LinkedHashMap g = new LinkedHashMap();
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final ArrayList j = new ArrayList();
    public final ArrayList k = new ArrayList();

    public c(boolean z) {
        this.f1122a = true;
        this.f1122a = z;
    }

    public final void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.h hVar, int i) throws b {
        String str;
        List list;
        Integer num;
        Integer num2;
        String str2;
        ArrayList<String> arrayList = hVar.h;
        if (arrayList.size() > 0) {
            for (String str3 : arrayList) {
                if (!h0.e(str3)) {
                    throw new b("Found non-secure click tracking url for companion. url: " + str3, 0);
                }
            }
            if (i > 0) {
                this.i.add(hVar);
            }
        }
        String str4 = hVar.g;
        if (!h0.e(str4)) {
            throw new b("Found non-secure click through url: " + str4, 0);
        }
        if (!hVar.a()) {
            if (this.j.contains(hVar)) {
                return;
            }
            this.j.add(hVar);
            return;
        }
        Integer num3 = hVar.f1164a;
        Integer num4 = hVar.b;
        if (num3 == null || num4 == null || num3.intValue() < 100 || num4.intValue() < 100) {
            throw new b("Incompatible size: " + num3 + "," + num4, 16);
        }
        ArrayList<w> arrayList2 = hVar.j;
        for (w wVar : arrayList2) {
            if (!h0.e(wVar.b)) {
                throw new b("Found non-secure tracking event: " + wVar, 0);
            }
        }
        String str5 = hVar.c;
        l lVar = hVar.d;
        if (lVar != null) {
            k kVarA = k.a(lVar.f1166a);
            if (kVarA == null) {
                throw new b("Found invalid creative type: " + lVar.f1166a, 32);
            }
            str = str5;
            list = arrayList2;
            num = num4;
            num2 = num3;
            str2 = str4;
            a(bVar, com.fyber.inneractive.sdk.model.vast.i.Static, i, num3.intValue(), num4.intValue(), str5, str4, arrayList, list, lVar.b, kVarA);
        } else {
            str = str5;
            list = arrayList2;
            num = num4;
            num2 = num3;
            str2 = str4;
        }
        String str6 = hVar.e;
        if (!TextUtils.isEmpty(str6)) {
            if (!h0.e(str6)) {
                throw new b("Found non-secure iframe url: " + str6, 0);
            }
            a(bVar, com.fyber.inneractive.sdk.model.vast.i.Iframe, i, num2.intValue(), num.intValue(), str, str2, arrayList, list, str6, null);
        }
        String str7 = hVar.f;
        if (!TextUtils.isEmpty(str7)) {
            a(bVar, com.fyber.inneractive.sdk.model.vast.i.Html, i, num2.intValue(), num.intValue(), str, str2, arrayList, list, str7, null);
        }
        bVar.g.size();
    }

    public final com.fyber.inneractive.sdk.model.vast.b a(com.fyber.inneractive.sdk.model.vast.f fVar, List list, String str) {
        int iE = o.e();
        int iD = o.d();
        IAlog.a("%sprocess started", "VastProcessor: ");
        if (fVar != null && fVar.c != null) {
            com.fyber.inneractive.sdk.model.vast.b bVar = new com.fyber.inneractive.sdk.model.vast.b(new g(this.d, iE, iD), new d(iE, iD));
            bVar.f1159a = str;
            ArrayList arrayList = fVar.c.c;
            if (arrayList != null) {
                List list2 = list;
                if (!arrayList.isEmpty()) {
                    if (list == null) {
                        list2 = list;
                        if (fVar.b != null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(fVar);
                            list2 = arrayList2;
                        }
                    }
                    if (list2 != null) {
                        Iterator it = list2.iterator();
                        while (it.hasNext()) {
                            a0 a0Var = ((com.fyber.inneractive.sdk.model.vast.f) it.next()).b;
                            if (a0Var != null) {
                                a(bVar, a0Var);
                            }
                        }
                    }
                    a(bVar, fVar.c);
                    if (bVar.d.size() == 0) {
                        if (this.g.isEmpty()) {
                            throw new h("ErrorNoMediaFiles", "No media files exist after merge");
                        }
                        throw new h("ErrorNoCompatibleMediaFile", "No compatible media files after filtering");
                    }
                    ArrayList<com.fyber.inneractive.sdk.model.vast.c> arrayList3 = new ArrayList(bVar.g);
                    Collections.sort(arrayList3, bVar.h);
                    if (!arrayList3.isEmpty()) {
                        for (com.fyber.inneractive.sdk.model.vast.h hVar : this.j) {
                            if (!hVar.a()) {
                                for (com.fyber.inneractive.sdk.model.vast.c cVar : arrayList3) {
                                    ArrayList arrayList4 = hVar.h;
                                    if (arrayList4 != null) {
                                        Iterator it2 = arrayList4.iterator();
                                        while (it2.hasNext()) {
                                            cVar.a(x.EVENT_CLICK, (String) it2.next());
                                        }
                                    }
                                    String str2 = hVar.g;
                                    if (TextUtils.isEmpty(cVar.g)) {
                                        cVar.g = str2;
                                    }
                                    ArrayList<w> arrayList5 = hVar.j;
                                    if (arrayList5 != null) {
                                        for (w wVar : arrayList5) {
                                            x xVarA = x.a(wVar.f1174a);
                                            String str3 = wVar.b;
                                            if (xVarA != null && str3 != null) {
                                                cVar.a(xVarA, str3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (IAlog.f1642a == 2) {
                        IAlog.e("%sLogging merged model media files: ", "VastProcessor: ");
                        Iterator it3 = new ArrayList(bVar.d).iterator();
                        int i = 0;
                        while (it3.hasNext()) {
                            IAlog.e("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i), (r) it3.next());
                            i++;
                        }
                    }
                    if (IAlog.f1642a == 2) {
                        IAlog.e("%sLogging merged model companion ads: ", "VastProcessor: ");
                        ArrayList arrayList6 = new ArrayList(bVar.g);
                        Collections.sort(arrayList6, bVar.h);
                        if (arrayList6.size() > 0) {
                            Iterator it4 = arrayList6.iterator();
                            int i2 = 0;
                            while (it4.hasNext()) {
                                IAlog.e("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i2), ((com.fyber.inneractive.sdk.model.vast.c) it4.next()).a());
                                i2++;
                            }
                        } else {
                            IAlog.e("%sNo companion ads found!", "VastProcessor: ");
                        }
                    }
                    return bVar;
                }
            }
            throw new h("ErrorNoMediaFiles", "Empty inline with no creatives");
        }
        IAlog.a("%sno inline found", "VastProcessor: ");
        throw new h("ErrorNoMediaFiles", "Empty inline ad found");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.fyber.inneractive.sdk.model.vast.b r18, com.fyber.inneractive.sdk.model.vast.g r19) {
        /*
            Method dump skipped, instruction units count: 814
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.vast.c.a(com.fyber.inneractive.sdk.model.vast.b, com.fyber.inneractive.sdk.model.vast.g):void");
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    public final void a(com.fyber.inneractive.sdk.model.vast.b r10, com.fyber.inneractive.sdk.model.vast.i r11, int r12, int r13, int r14, java.lang.String r15, java.lang.String r16, java.util.List r17, java.util.List r18, java.lang.String r19, com.fyber.inneractive.sdk.model.vast.k r20) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.vast.c.a(com.fyber.inneractive.sdk.model.vast.b, com.fyber.inneractive.sdk.model.vast.i, int, int, int, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, com.fyber.inneractive.sdk.model.vast.k):void");
    }
}
