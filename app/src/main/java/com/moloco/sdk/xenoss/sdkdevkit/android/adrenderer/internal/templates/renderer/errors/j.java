package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public abstract class j extends g {
    public static final int j = 0;
    public final String i;

    public static final class a extends j {
        public static final a k = new a();
        public static final int l = 0;

        public a() {
            super("net::ERR_UNKNOWN_URL_SCHEME", null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 284504500;
        }

        public String toString() {
            return "ERR_UNKNOWN_URL_SCHEME";
        }
    }

    public /* synthetic */ j(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.g
    public String c() {
        return this.i;
    }

    public j(String str) {
        super(-10, str, false, true, false, 16, null);
        this.i = str;
    }
}
