package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d extends g {
    public static final int j = 0;
    public final String i;

    public static final class a extends d {
        public static final a k = new a();
        public static final int l = 0;

        public a() {
            super("net::ERR_PROXY_CONNECTION_FAILED", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 120626217;
        }

        public String toString() {
            return "ERR_PROXY_CONNECTION_FAILED";
        }
    }

    public /* synthetic */ d(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public String c() {
        return this.i;
    }

    public d(String str) {
        super(-5, str, false, true, false, 16, null);
        this.i = str;
    }
}
