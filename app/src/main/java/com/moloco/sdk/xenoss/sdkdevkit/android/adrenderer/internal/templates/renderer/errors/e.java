package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e extends g {
    public static final int j = 0;
    public final String i;

    public static final class a extends e {
        public static final a k = new a();
        public static final int l = 0;

        public a() {
            super("net::ERR_TOO_MANY_REDIRECTS", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return -1800342769;
        }

        public String toString() {
            return "ERR_TOO_MANY_REDIRECTS";
        }
    }

    public /* synthetic */ e(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public String c() {
        return this.i;
    }

    public e(String str) {
        super(-9, str, true, true, false, 16, null);
        this.i = str;
    }
}
