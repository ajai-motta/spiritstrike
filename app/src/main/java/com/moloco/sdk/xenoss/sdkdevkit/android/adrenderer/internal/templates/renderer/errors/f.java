package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f extends g {
    public static final int j = 0;
    public final String i;

    public static final class a extends f {
        public static final a k = new a();
        public static final int l = 0;

        public a() {
            super("net::ERR_SSL_BAD_RECORD_MAC_ALERT", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1157822157;
        }

        public String toString() {
            return "ERR_SSL_BAD_RECORD_MAC_ALERT";
        }
    }

    public static final class b extends f {
        public static final b k = new b();
        public static final int l = 0;

        public b() {
            super("net::ERR_SSL_PROTOCOL_ERROR", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -715617482;
        }

        public String toString() {
            return "ERR_SSL_PROTOCOL_ERROR";
        }
    }

    public static final class c extends f {
        public static final c k = new c();
        public static final int l = 0;

        public c() {
            super("net::ERR_SSL_VERSION_OR_CIPHER_MISMATCH", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return 516103234;
        }

        public String toString() {
            return "ERR_SSL_VERSION_OR_CIPHER_MISMATCH";
        }
    }

    public /* synthetic */ f(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public String c() {
        return this.i;
    }

    public f(String str) {
        super(-11, str, false, true, false, 16, null);
        this.i = str;
    }
}
