package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.google.android.exoplayer2.C;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e {
    public long b;

    public c() {
        super(null);
        this.b = C.TIME_UNSET;
    }

    public final void a(n nVar, long j) throws r {
        if (nVar.j() != 2) {
            throw new r();
        }
        int iO = nVar.o();
        int i = nVar.b;
        nVar.e(i + iO);
        if ("onMetaData".equals(new String(nVar.f1472a, i, iO)) && nVar.j() == 8) {
            HashMap mapA = a(nVar);
            if (mapA.containsKey(TypedValues.TransitionType.S_DURATION)) {
                double dDoubleValue = ((Double) mapA.get(TypedValues.TransitionType.S_DURATION)).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.b = (long) (dDoubleValue * 1000000.0d);
                }
            }
        }
    }

    public static Serializable a(int i, n nVar) {
        if (i == 8) {
            return a(nVar);
        }
        if (i == 10) {
            int iM = nVar.m();
            ArrayList arrayList = new ArrayList(iM);
            for (int i2 = 0; i2 < iM; i2++) {
                arrayList.add(a(nVar.j(), nVar));
            }
            return arrayList;
        }
        if (i == 11) {
            Date date = new Date((long) Double.longBitsToDouble(nVar.g()));
            nVar.e(nVar.b + 2);
            return date;
        }
        if (i == 0) {
            return Double.valueOf(Double.longBitsToDouble(nVar.g()));
        }
        if (i == 1) {
            return Boolean.valueOf(nVar.j() == 1);
        }
        if (i == 2) {
            int iO = nVar.o();
            int i3 = nVar.b;
            nVar.e(i3 + iO);
            return new String(nVar.f1472a, i3, iO);
        }
        if (i != 3) {
            return null;
        }
        HashMap map = new HashMap();
        while (true) {
            int iO2 = nVar.o();
            int i4 = nVar.b;
            nVar.e(i4 + iO2);
            String str = new String(nVar.f1472a, i4, iO2);
            int iJ = nVar.j();
            if (iJ == 9) {
                return map;
            }
            map.put(str, a(iJ, nVar));
        }
    }

    public static HashMap a(n nVar) {
        int iM = nVar.m();
        HashMap map = new HashMap(iM);
        for (int i = 0; i < iM; i++) {
            int iO = nVar.o();
            int i2 = nVar.b;
            nVar.e(i2 + iO);
            map.put(new String(nVar.f1472a, i2, iO), a(nVar.j(), nVar));
        }
        return map;
    }
}
