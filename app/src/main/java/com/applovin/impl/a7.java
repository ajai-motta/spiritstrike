package com.applovin.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: loaded from: classes2.dex */
public class a7 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f290a;
    private final SharedPreferences b;
    private Integer c;
    private Integer d;
    private Integer e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public a7(com.applovin.impl.sdk.k kVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.k.o());
        this.b = defaultSharedPreferences;
        this.f290a = kVar;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.c = a(a5.u.a());
        this.d = a(a5.v.a());
        this.e = h();
        this.f = (String) b5.a(a5.x, (Object) null, defaultSharedPreferences, false);
        this.g = (String) b5.a(a5.y, (Object) null, defaultSharedPreferences, false);
        this.h = (String) b5.a(a5.z, (Object) null, defaultSharedPreferences, false);
        this.i = (String) b5.a(a5.B, (Object) null, defaultSharedPreferences, false);
        this.j = (String) b5.a(a5.D, (Object) null, defaultSharedPreferences, false);
        b(this.g);
    }

    private Integer h() {
        String strA = a5.w.a();
        if (this.b.contains(strA)) {
            Integer num = (Integer) b5.a(strA, null, Integer.class, this.b, false);
            if (num != null) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    return num;
                }
                this.f290a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f290a.O().b("TcfManager", "Integer value (" + num + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Long l = (Long) b5.a(strA, null, Long.class, this.b, false);
            if (l != null) {
                if (l.longValue() == 1 || l.longValue() == 0) {
                    return Integer.valueOf(l.intValue());
                }
                this.f290a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f290a.O().b("TcfManager", "Long value (" + l + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Boolean bool = (Boolean) b5.a(strA, null, Boolean.class, this.b, false);
            if (bool != null) {
                return Integer.valueOf(bool.booleanValue() ? 1 : 0);
            }
            String str = (String) b5.a(strA, null, String.class, this.b, false);
            if (str != null) {
                if ("1".equals(str) || "true".equals(str)) {
                    return 1;
                }
                if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "false".equals(str)) {
                    return 0;
                }
                this.f290a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f290a.O().b("TcfManager", "String value (" + str + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
        }
        return null;
    }

    public Boolean a(int i) {
        return d7.a(i, this.g);
    }

    public boolean b() {
        return d7.a(this.g);
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return y6.a(this.c);
    }

    public Integer e() {
        return this.c;
    }

    public Integer f() {
        return this.d;
    }

    public Integer g() {
        return this.e;
    }

    public String i() {
        return a("CMP Name", d()) + a("CMP SDK ID", this.c) + a("CMP SDK Version", this.d) + a(a5.w.a(), this.e) + a(a5.x.a(), this.f) + a(a5.y.a(), this.g);
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.h;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences are cleared - setting all stored TC data to null");
            }
            a();
            return;
        }
        if (str.equals(a5.u.a())) {
            this.c = a(str);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.c);
            }
            this.f290a.S0();
            return;
        }
        if (str.equals(a5.v.a())) {
            this.d = a(str);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.d);
                return;
            }
            return;
        }
        if (str.equals(a5.w.a())) {
            this.e = h();
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.e);
                return;
            }
            return;
        }
        if (str.equals(a5.x.a())) {
            this.f = (String) b5.a(str, (Object) null, String.class, sharedPreferences);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f);
            }
            this.f290a.S0();
            return;
        }
        if (str.equals(a5.y.a())) {
            this.g = (String) b5.a(str, (Object) null, String.class, sharedPreferences);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.g);
            }
            b(this.g);
            return;
        }
        if (str.equals(a5.z.a())) {
            this.h = (String) b5.a(str, (Object) null, String.class, sharedPreferences);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.h);
                return;
            }
            return;
        }
        if (str.equals(a5.A.a())) {
            String str2 = (String) b5.a(str, (Object) null, String.class, sharedPreferences);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str2);
                return;
            }
            return;
        }
        if (str.equals(a5.B.a())) {
            this.i = (String) b5.a(str, (Object) null, String.class, sharedPreferences);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.i);
                return;
            }
            return;
        }
        if (str.equals(a5.C.a())) {
            String str3 = (String) b5.a(str, (Object) null, String.class, sharedPreferences);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str3);
                return;
            }
            return;
        }
        if (str.equals(a5.D.a())) {
            this.j = (String) b5.a(str, (Object) null, String.class, sharedPreferences);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.j);
                return;
            }
            return;
        }
        if (str.contains("IABTCF_PublisherRestrictions")) {
            String str4 = (String) b5.a(str, (Object) null, String.class, sharedPreferences);
            this.f290a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f290a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str4);
            }
        }
    }

    private Integer a(String str) {
        if (this.b.contains(str)) {
            Integer num = (Integer) b5.a(str, null, Integer.class, this.b, false);
            if (num != null) {
                return num;
            }
            Long l = (Long) b5.a(str, null, Long.class, this.b, false);
            if (l != null && l.longValue() >= -2147483648L && l.longValue() <= 2147483647L) {
                return Integer.valueOf(l.intValue());
            }
            String str2 = (String) b5.a(str, null, String.class, this.b, false);
            if (str2 != null) {
                if (StringUtils.isNumeric(str2)) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                this.f290a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f290a.O().b("TcfManager", "String value (" + str2 + ") for " + str + " is not numeric - storing value as null");
                }
            }
        }
        return null;
    }

    public Boolean b(int i) {
        String str = this.i;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(d7.a(str, i - 1));
    }

    public Boolean c(int i) {
        String str = this.j;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(d7.a(str, i - 1));
    }

    public Boolean d(int i) {
        String str = this.h;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(d7.a(str, i - 1));
    }

    private void b(String str) {
        this.f290a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f290a.O().a("TcfManager", "Attempting to update consent from Additional Consent string: " + str);
        }
        Boolean boolA = d7.a(1301, str);
        if (boolA != null) {
            if (boolA.booleanValue()) {
                this.f290a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f290a.O().a("TcfManager", "Found AppLovin ID in the list of consented ATP IDs - setting user consent to true");
                }
                p0.b(true, com.applovin.impl.sdk.k.o());
            } else {
                this.f290a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f290a.O().a("TcfManager", "Could not find AppLovin ID in the list of consented ATP IDs - setting user consent to false");
                }
                p0.b(false, com.applovin.impl.sdk.k.o());
            }
            this.f290a.S0();
            return;
        }
        this.f290a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f290a.O().a("TcfManager", "AC string is not valid or AppLovin was not listed on the CMP flow - no consent update");
        }
    }

    private void a() {
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    private String a(String str, Object obj) {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(str);
        sb.append(" - ");
        sb.append(obj != null ? obj.toString() : "No value set");
        return sb.toString();
    }
}
