package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class i extends g {
    public static final int j = 0;
    public final String i;

    public static final class a extends i {
        public static final a k = new a();
        public static final int l = 0;

        public a() {
            super("net::ERR_CONNECTION_TIMED_OUT", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -56384004;
        }

        public String toString() {
            return "ERR_CONNECTION_TIMED_OUT";
        }
    }

    public static final class b extends i {
        public static final b k = new b();
        public static final int l = 0;

        public b() {
            super("net::ERR_TIMED_OUT", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 389383759;
        }

        public String toString() {
            return "ERR_TIMED_OUT";
        }
    }

    public /* synthetic */ i(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public String c() {
        return this.i;
    }

    public i(String str) {
        super(-8, str, true, false, false, 16, null);
        this.i = str;
    }
}
