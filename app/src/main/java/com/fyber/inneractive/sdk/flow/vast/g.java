package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.model.vast.r;
import com.fyber.inneractive.sdk.model.vast.t;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1125a;
    public final int b;
    public final int c;

    public g(int i, int i2, int i3) {
        this.f1125a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        r rVar = (r) obj;
        r rVar2 = (r) obj2;
        int i = -1;
        if (TextUtils.equals("VPAID", rVar2.f)) {
            return -1;
        }
        if (!TextUtils.equals("VPAID", rVar.f)) {
            Integer num = rVar.e;
            int iIntValue = num == null ? 0 : num.intValue();
            Integer num2 = rVar2.e;
            int iIntValue2 = num2 == null ? 0 : num2.intValue();
            int i2 = this.f1125a;
            if (iIntValue2 > i2 && iIntValue <= i2) {
                return -1;
            }
            if (iIntValue <= i2 || iIntValue2 > i2) {
                t tVarA = t.a(rVar2.d);
                t tVar = t.MEDIA_TYPE_MP4;
                Integer num3 = tVarA == tVar ? 3 : tVarA == t.MEDIA_TYPE_3GPP ? 2 : tVarA == t.MEDIA_TYPE_WEBM ? 1 : -1;
                t tVarA2 = t.a(rVar.d);
                if (tVarA2 == tVar) {
                    i = 3;
                } else if (tVarA2 == t.MEDIA_TYPE_3GPP) {
                    i = 2;
                } else if (tVarA2 == t.MEDIA_TYPE_WEBM) {
                    i = 1;
                }
                int iCompareTo = num3.compareTo(i);
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                if (iIntValue >= iIntValue2) {
                    if (iIntValue > iIntValue2) {
                        return -1;
                    }
                    Integer num4 = rVar.b;
                    int iIntValue3 = num4 == null ? 0 : num4.intValue();
                    Integer num5 = rVar.c;
                    int iIntValue4 = num5 == null ? 0 : num5.intValue();
                    Integer num6 = rVar2.b;
                    int iIntValue5 = num6 == null ? 0 : num6.intValue();
                    Integer num7 = rVar2.c;
                    int i3 = iIntValue3 * iIntValue4;
                    int iIntValue6 = iIntValue5 * (num7 == null ? 0 : num7.intValue());
                    int i4 = this.b * this.c;
                    int iAbs = Math.abs(i3 - i4);
                    int iAbs2 = Math.abs(iIntValue6 - i4);
                    if (iAbs < iAbs2) {
                        return -1;
                    }
                    if (iAbs <= iAbs2) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}
