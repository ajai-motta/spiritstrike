package com.fyber.inneractive.sdk.config.global.features;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends h {
    public q() {
        super("store_webpage");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h b() {
        q qVar = new q();
        a(qVar);
        return qVar;
    }

    public final p c() {
        String strA = a("presentation_mode", null);
        if (strA != null) {
            for (p pVar : p.values()) {
                Locale locale = Locale.US;
                if (strA.toLowerCase(locale).equals(pVar.value.toLowerCase(locale))) {
                    return pVar;
                }
            }
        }
        return p.FullScreen;
    }
}
