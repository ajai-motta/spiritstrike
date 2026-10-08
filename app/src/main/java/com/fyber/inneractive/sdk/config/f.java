package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.enums.Vendor;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.util.IAlog;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlinx.io.files.FileSystemKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.fyber.inneractive.sdk.cache.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f939a = false;

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String a() {
        String str = IAConfigManager.O.c;
        StringBuilder sb = new StringBuilder("https://");
        int i = k.f959a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.baseConfigUrl");
        if (TextUtils.isEmpty(property)) {
            sb.append("cdn2.inner-active.mobi/ia-sdk-config/apps/");
        } else {
            sb.append(property);
        }
        sb.append(str);
        sb.append(FileSystemKt.UnixPathSeparator);
        sb.append(str);
        sb.append(".json");
        String string = sb.toString();
        IAlog.d("%s: %s", "APP_CONFIG_REQUEST", string);
        return string;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String b() {
        return "IALastModifiedFromHeader";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String c() {
        return "inneractive.config";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final boolean d() {
        String string = com.fyber.inneractive.sdk.util.o.f1662a.getSharedPreferences("IAConfigurationPreferences", 0).getString("cached.config.appid", null);
        return string != null && string.equalsIgnoreCase(IAConfigManager.O.c);
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final void a(Object obj) {
        h0 h0Var = (h0) obj;
        if (h0Var == null || h0Var.f956a == null) {
            return;
        }
        com.fyber.inneractive.sdk.util.o.f1662a.getSharedPreferences("IAConfigurationPreferences", 0).edit().putString("cached.config.appid", h0Var.f956a).apply();
    }

    public final void a(String str, Throwable th) {
        String strSubstring;
        String name;
        String localizedMessage;
        if (this.f939a) {
            return;
        }
        this.f939a = true;
        if (TextUtils.isEmpty(str)) {
            strSubstring = "Empty Json Data";
        } else {
            strSubstring = str.substring(0, str.length() > 501 ? 500 : str.length() - 1);
        }
        if (th != null) {
            name = th.getClass().getName();
            localizedMessage = th.getLocalizedMessage();
        } else {
            name = "Bad remote configuration";
            localizedMessage = UnityAdsConstants.Messages.MSG_INTERNAL_ERROR;
        }
        String str2 = IAConfigManager.O.c;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(com.fyber.inneractive.sdk.network.t.FATAL_CONFIGURATION_ERROR);
        if (localizedMessage == null) {
            localizedMessage = "No message";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "EMPTY_APP_ID";
        }
        wVar.a("exception", name, "message", localizedMessage, "data", strSubstring, "appId", str2).a((String) null);
    }

    public static h0 a(com.fyber.inneractive.sdk.config.remote.e eVar) {
        boolean z;
        Iterator it;
        h0 h0Var;
        HashMap map;
        String str;
        HashMap map2;
        Iterator it2;
        ArrayList arrayList;
        UnitDisplayType unitDisplayType;
        int i;
        Set set;
        Integer num;
        Boolean bool;
        UnitDisplayType unitDisplayType2;
        String strB;
        com.fyber.inneractive.sdk.config.remote.e eVar2 = eVar;
        h0 h0Var2 = new h0();
        h0Var2.c = eVar2.c;
        com.fyber.inneractive.sdk.config.remote.a aVar = eVar2.f973a;
        h0Var2.b = aVar.b;
        h0Var2.f956a = aVar.f971a;
        Iterator it3 = eVar2.b.iterator();
        while (it3.hasNext()) {
            com.fyber.inneractive.sdk.config.remote.h hVar = (com.fyber.inneractive.sdk.config.remote.h) it3.next();
            HashMap map3 = h0Var2.d;
            String str2 = hVar.f975a;
            com.fyber.inneractive.sdk.config.remote.a aVar2 = eVar2.f973a;
            HashMap map4 = h0Var2.e;
            j0 j0Var = h0Var2.f;
            q0 q0Var = new q0();
            int i2 = 2;
            com.fyber.inneractive.sdk.config.remote.c[] cVarArr = {aVar2, hVar};
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                }
                com.fyber.inneractive.sdk.config.remote.c cVar = cVarArr[i3];
                if (cVar != null && (strB = cVar.b()) != null && strB.equals("false")) {
                    z = false;
                    break;
                }
                i3++;
                i2 = 2;
            }
            q0Var.b = z;
            Iterator it4 = hVar.g.iterator();
            while (it4.hasNext()) {
                com.fyber.inneractive.sdk.config.remote.i iVar = (com.fyber.inneractive.sdk.config.remote.i) it4.next();
                r0 r0Var = new r0();
                String str3 = iVar.f976a;
                if (str3 != null) {
                    String str4 = iVar.b;
                    if (str4 != null) {
                        r0Var.f970a = str3;
                        r0Var.b = str4;
                        com.fyber.inneractive.sdk.config.remote.b bVar = iVar.c;
                        if (bVar != null) {
                            com.fyber.inneractive.sdk.config.remote.b bVar2 = hVar.c;
                            com.fyber.inneractive.sdk.config.remote.b bVar3 = aVar2.e;
                            l0 l0Var = new l0();
                            it = it3;
                            UnitDisplayType unitDisplayType3 = bVar.f972a;
                            it2 = it4;
                            if (unitDisplayType3 == UnitDisplayType.BANNER || unitDisplayType3 == UnitDisplayType.MRECT || unitDisplayType3.isFullscreenUnit()) {
                                l0Var.b = bVar.f972a;
                                Integer num2 = bVar.c;
                                Integer num3 = bVar2 != null ? bVar2.c : null;
                                if (bVar3 != null) {
                                    h0Var = h0Var2;
                                    num = bVar3.c;
                                    map = map3;
                                    str = str2;
                                } else {
                                    h0Var = h0Var2;
                                    map = map3;
                                    str = str2;
                                    num = null;
                                }
                                Integer num4 = (Integer) a((Object) null, num2, num3, num);
                                if (num4 != null && num4.intValue() >= 5 && num4.intValue() <= 60) {
                                    l0Var.f962a = num4;
                                }
                                Boolean bool2 = Boolean.TRUE;
                                Boolean bool3 = bVar.b;
                                Boolean bool4 = bVar2 != null ? bVar2.b : null;
                                if (bVar3 != null) {
                                    bool = bVar3.b;
                                    map2 = map4;
                                } else {
                                    map2 = map4;
                                    bool = null;
                                }
                                Boolean bool5 = (Boolean) a(bool2, bool3, bool4, bool);
                                bool5.getClass();
                                l0Var.c = bool5;
                                Integer num5 = (Integer) a((Object) null, bVar.d, bVar2 != null ? bVar2.d : null, bVar3 != null ? bVar3.d : null);
                                if (num5 != null && num5.intValue() >= 5 && num5.intValue() <= 60) {
                                    l0Var.d = num5;
                                }
                                if (l0Var.d == null && !l0Var.c.booleanValue() && ((unitDisplayType2 = bVar.f972a) == UnitDisplayType.INTERSTITIAL || unitDisplayType2 == UnitDisplayType.REWARDED)) {
                                    l0Var.c = bool2;
                                }
                                r0Var.c = l0Var;
                            } else {
                                it3 = it;
                                it4 = it2;
                            }
                        } else {
                            h0Var = h0Var2;
                            it = it3;
                            map = map3;
                            str = str2;
                            map2 = map4;
                            it2 = it4;
                        }
                        com.fyber.inneractive.sdk.config.remote.j jVar = iVar.f;
                        if (jVar != null || iVar.e != null) {
                            if (jVar != null) {
                                UnitDisplayType unitDisplayType4 = jVar.j;
                                UnitDisplayType unitDisplayType5 = UnitDisplayType.REWARDED;
                                if (unitDisplayType4 == unitDisplayType5 && iVar.c == null) {
                                    l0 l0Var2 = new l0();
                                    r0Var.c = l0Var2;
                                    l0Var2.c = Boolean.FALSE;
                                    l0Var2.d = -1;
                                    l0 l0Var3 = r0Var.c;
                                    l0Var3.b = unitDisplayType5;
                                    l0Var3.f962a = -1;
                                }
                            }
                            t0 t0Var = new t0();
                            com.fyber.inneractive.sdk.config.remote.j jVar2 = iVar.f;
                            com.fyber.inneractive.sdk.config.remote.j jVar3 = hVar.e;
                            com.fyber.inneractive.sdk.config.remote.j jVar4 = aVar2.d;
                            if (jVar2 != null && ((unitDisplayType = jVar2.j) == UnitDisplayType.LANDSCAPE || unitDisplayType == UnitDisplayType.SQUARE || unitDisplayType == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.VERTICAL || unitDisplayType == UnitDisplayType.REWARDED || unitDisplayType == UnitDisplayType.MRECT)) {
                                t0Var.j = unitDisplayType;
                            } else if (iVar.e != null) {
                                t0Var.j = UnitDisplayType.NATIVE;
                                r0Var.e = new p0();
                            } else {
                                it3 = it;
                                it4 = it2;
                                h0Var2 = h0Var;
                                map3 = map;
                                str2 = str;
                                map4 = map2;
                            }
                            Object objA = a((Object) null, jVar2 != null ? jVar2.f977a : null, jVar3 != null ? jVar3.f977a : null, jVar4 != null ? jVar4.f977a : null);
                            if (objA != null) {
                                t0Var.f981a = (Boolean) objA;
                                t0Var.b = (Integer) a((Object) 5000, jVar2 != null ? jVar2.b : null, jVar3 != null ? jVar3.b : null, jVar4 != null ? jVar4.b : null);
                                Integer num6 = (Integer) a((Object) 0, jVar2 != null ? jVar2.c : null, jVar3 != null ? jVar3.c : null, jVar4 != null ? jVar4.c : null);
                                t0Var.c = Integer.valueOf(num6.intValue() < 0 ? 0 : num6.intValue());
                                t0Var.d = (Boolean) a(Boolean.TRUE, jVar2 != null ? jVar2.e : null, jVar3 != null ? jVar3.e : null, jVar4 != null ? jVar4.e : null);
                                t0Var.e = (Orientation) a(Orientation.USER, jVar2 != null ? jVar2.g : null, jVar3 != null ? jVar3.g : null, jVar4 != null ? jVar4.g : null);
                                Integer num7 = (Integer) a((Object) 0, jVar2 != null ? jVar2.i : null, jVar3 != null ? jVar3.i : null, jVar4 != null ? jVar4.i : null);
                                t0Var.f = Integer.valueOf(num7.intValue() < 0 ? 0 : num7.intValue());
                                Integer num8 = (Integer) a((Object) 2048, jVar2 != null ? jVar2.h : null, jVar3 != null ? jVar3.h : null, jVar4 != null ? jVar4.h : null);
                                if (num8.intValue() > t0Var.b.intValue()) {
                                    num8 = t0Var.b;
                                }
                                t0Var.g = num8;
                                t0Var.h = (Skip) a(Skip._0, jVar2 != null ? jVar2.d : null, jVar3 != null ? jVar3.d : null, jVar4 != null ? jVar4.d : null);
                                t0Var.i = (TapAction) a(TapAction.DO_NOTHING, jVar2 != null ? jVar2.f : null, jVar3 != null ? jVar3.f : null, jVar4 != null ? jVar4.f : null);
                                ArrayList arrayList2 = new ArrayList();
                                com.fyber.inneractive.sdk.config.remote.j jVarA = new com.fyber.inneractive.sdk.config.remote.d[]{iVar}[0].a();
                                if (jVarA != null && (arrayList = jVarA.k) != null && arrayList.size() > 0) {
                                    arrayList2 = jVarA.k;
                                }
                                t0Var.k = arrayList2;
                                r0Var.f = t0Var;
                            } else {
                                it3 = it;
                                it4 = it2;
                                h0Var2 = h0Var;
                                map3 = map;
                                str2 = str;
                                map4 = map2;
                            }
                        }
                        o0 o0Var = new o0();
                        HashSet hashSet = new HashSet();
                        com.fyber.inneractive.sdk.config.remote.f fVar = iVar.d;
                        Set set2 = fVar != null ? fVar.f974a : null;
                        com.fyber.inneractive.sdk.config.remote.f fVar2 = hVar.d;
                        Set set3 = fVar2 != null ? fVar2.f974a : null;
                        com.fyber.inneractive.sdk.config.remote.f fVar3 = aVar2.c;
                        o0Var.f966a = (Set) a(hashSet, set2, set3, fVar3 != null ? fVar3.f974a : null);
                        r0Var.d = o0Var;
                        u0 u0Var = new u0();
                        com.fyber.inneractive.sdk.config.remote.k kVar = iVar.g;
                        com.fyber.inneractive.sdk.config.remote.k kVar2 = hVar.f;
                        com.fyber.inneractive.sdk.config.remote.k kVar3 = aVar2.f;
                        Integer num9 = (Integer) a((Object) 1, kVar != null ? kVar.f978a : null, kVar2 != null ? kVar2.f978a : null, kVar3 != null ? kVar3.f978a : null);
                        if (num9.intValue() <= 0 && num9.intValue() > 100) {
                            u0Var.f983a = 1;
                        } else {
                            u0Var.f983a = num9;
                        }
                        Integer num10 = (Integer) a((Object) 0, kVar != null ? kVar.b : null, kVar2 != null ? kVar2.b : null, kVar3 != null ? kVar3.b : null);
                        if (num10.intValue() < 0 && num10.intValue() > 100) {
                            u0Var.b = 0;
                        } else {
                            u0Var.b = num10;
                        }
                        HashSet hashSet2 = new HashSet();
                        Set set4 = kVar != null ? kVar.c : null;
                        Set set5 = kVar2 != null ? kVar2.c : null;
                        if (kVar3 != null) {
                            set = kVar3.c;
                            i = 3;
                        } else {
                            i = 3;
                            set = null;
                        }
                        Object[] objArr = new Object[i];
                        objArr[0] = set4;
                        objArr[1] = set5;
                        objArr[2] = set;
                        Set<Vendor> set6 = (Set) a(hashSet2, objArr);
                        u0Var.c = set6;
                        r0Var.g = u0Var;
                        if (j0Var != null && set6 != null) {
                            for (Vendor vendor : set6) {
                                if (vendor != null && !j0Var.f958a.contains(vendor)) {
                                    j0Var.f958a.add(vendor);
                                }
                            }
                        }
                        q0Var.f969a.add(r0Var);
                        HashMap map5 = map2;
                        map5.put(r0Var.f970a, r0Var);
                        it4 = it2;
                        h0Var2 = h0Var;
                        map3 = map;
                        str2 = str;
                        map4 = map5;
                    }
                } else {
                    it = it3;
                }
                it3 = it;
            }
            map3.put(str2, q0Var);
            eVar2 = eVar;
        }
        return h0Var2;
    }

    public static Object a(Object obj, Object... objArr) {
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                return obj2;
            }
        }
        return obj;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final Object a(String str) {
        try {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            iAConfigManager.D.f();
            com.fyber.inneractive.sdk.config.remote.e eVarA = com.fyber.inneractive.sdk.config.remote.e.a(new JSONObject(str));
            String str2 = iAConfigManager.c;
            if (eVarA != null && str2.equals(eVarA.f973a.f971a)) {
                return a(eVarA);
            }
            IAlog.b("internal error while parsing local configuration", new Object[0]);
            if (eVarA != null && !str2.equals(eVarA.f973a.f971a)) {
                throw new InvalidAppIdException();
            }
            a(str, (Throwable) null);
            return null;
        } catch (Throwable th) {
            a(str, th);
            IAlog.b("Exception Error while parsing local configuration", new Object[0]);
            throw th;
        }
    }
}
