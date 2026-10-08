package com.fyber.inneractive.sdk.mraid;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.g1;
import com.fyber.inneractive.sdk.web.i0;
import com.fyber.inneractive.sdk.web.j1;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends e {
    public r(LinkedHashMap linkedHashMap, i0 i0Var, g1 g1Var) {
        super(linkedHashMap, i0Var, g1Var);
    }

    @Override // com.fyber.inneractive.sdk.mraid.f
    public final void a() {
        String str = (String) this.b.get(ShareConstants.MEDIA_URI);
        if (TextUtils.isEmpty(str)) {
            this.c.a(k.PLAY_VIDEO, "Video can't be played with null or empty URL");
            return;
        }
        j1 j1Var = ((IAmraidWebViewController) this.c).g;
        if (j1Var != null) {
            ((com.fyber.inneractive.sdk.web.b0) j1Var).a(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.mraid.e
    public final String c() {
        return (String) this.b.get(ShareConstants.MEDIA_URI);
    }
}
