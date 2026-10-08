package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class k extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g {
    public static final int k = 0;
    public final String i;
    public final boolean j;

    public static final class a extends k {
        public static final a l = new a();
        public static final int m = 0;

        public a() {
            super("net::ERR_BLOCKED_BY_ORTB", false, 2, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 2086682310;
        }

        public String toString() {
            return "ERR_BLOCKED_BY_ORTB";
        }
    }

    public static final class b extends k {
        public static final b l = new b();
        public static final int m = 0;

        public b() {
            super("net::ERR_CLEARTEXT_NOT_PERMITTED", false, 2, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1499225977;
        }

        public String toString() {
            return "ERR_CLEARTEXT_NOT_PERMITTED";
        }
    }

    public static final class c extends k {
        public static final c l = new c();
        public static final int m = 0;

        public c() {
            super("net::ERR_FAILED", true, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 1678282877;
        }

        public String toString() {
            return "ERR_FAILED";
        }
    }

    public static final class d extends k {
        public static final d l = new d();
        public static final int m = 0;

        public d() {
            super("net::ERR_HTTP2_PING_FAILED", false, 2, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 505018197;
        }

        public String toString() {
            return "ERR_HTTP2_PING_FAILED";
        }
    }

    public static final class e extends k {
        public static final e l = new e();
        public static final int m = 0;

        public e() {
            super("net::ERR_HTTP2_PROTOCOL_ERROR", false, 2, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return 1437709814;
        }

        public String toString() {
            return "ERR_HTTP2_PROTOCOL_ERROR";
        }
    }

    public static final class f extends k {
        public static final f l = new f();
        public static final int m = 0;

        public f() {
            super("net::ERR_NETWORK_CHANGED", false, 2, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof f);
        }

        public int hashCode() {
            return -1485714141;
        }

        public String toString() {
            return "ERR_NETWORK_CHANGED";
        }
    }

    public static final class g extends k {
        public static final g l = new g();
        public static final int m = 0;

        public g() {
            super("net::ERR_QUIC_PROTOCOL_ERROR", false, 2, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof g);
        }

        public int hashCode() {
            return -1472226974;
        }

        public String toString() {
            return "ERR_QUIC_PROTOCOL_ERROR";
        }
    }

    public /* synthetic */ k(String str, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public String c() {
        return this.i;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public boolean e() {
        return this.j;
    }

    public k(String str, boolean z) {
        super(-1, str, true, false, z, null);
        this.i = str;
        this.j = z;
    }

    public /* synthetic */ k(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, null);
    }
}
