package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends g {
    public static final int j = 0;
    public final String i;

    public static final class a extends b {
        public static final a k = new a();
        public static final int l = 0;

        public a() {
            super("net::ERR_CONNECTION_ABORTED", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -262105110;
        }

        public String toString() {
            return "ERR_CONNECTION_ABORTED";
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.b$b, reason: collision with other inner class name */
    public static final class C0463b extends b {
        public static final C0463b k = new C0463b();
        public static final int l = 0;

        public C0463b() {
            super("net::ERR_CONNECTION_CLOSED", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof C0463b);
        }

        public int hashCode() {
            return -219055663;
        }

        public String toString() {
            return "ERR_CONNECTION_CLOSED";
        }
    }

    public static final class c extends b {
        public static final c k = new c();
        public static final int l = 0;

        public c() {
            super("net::ERR_CONNECTION_REFUSED", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 2018219755;
        }

        public String toString() {
            return "ERR_CONNECTION_REFUSED";
        }
    }

    public static final class d extends b {
        public static final d k = new d();
        public static final int l = 0;

        public d() {
            super("net::ERR_CONNECTION_RESET", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public int hashCode() {
            return 976412714;
        }

        public String toString() {
            return "ERR_CONNECTION_RESET";
        }
    }

    public static final class e extends b {
        public static final e k = new e();
        public static final int l = 0;

        public e() {
            super("net::ERR_SOCKET_NOT_CONNECTED", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof e);
        }

        public int hashCode() {
            return 1961158189;
        }

        public String toString() {
            return "ERR_SOCKET_NOT_CONNECTED";
        }
    }

    public /* synthetic */ b(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public String c() {
        return this.i;
    }

    public b(String str) {
        super(-6, str, true, false, false, 16, null);
        this.i = str;
    }
}
