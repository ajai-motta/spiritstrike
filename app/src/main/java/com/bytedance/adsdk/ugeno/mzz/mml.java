package com.bytedance.adsdk.ugeno.mzz;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
class mml {
    static final /* synthetic */ boolean lnr = true;
    private final com.bytedance.adsdk.ugeno.mzz.qdl mml;
    private long[] mo;
    private boolean[] mzz;
    int[] qdl;
    long[] ud;

    int qdl(long j) {
        return (int) j;
    }

    int ud(long j) {
        return (int) (j >> 32);
    }

    long ud(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    mml(com.bytedance.adsdk.ugeno.mzz.qdl qdlVar) {
        this.mml = qdlVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] qdl(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mml.getFlexItemCount();
        List<ud> listUd = ud(flexItemCount);
        ud udVar = new ud();
        if (view != null && (layoutParams instanceof com.bytedance.adsdk.ugeno.mzz.ud)) {
            udVar.ud = ((com.bytedance.adsdk.ugeno.mzz.ud) layoutParams).lnr();
        } else {
            udVar.ud = 1;
        }
        if (i != -1 && i != flexItemCount && i < this.mml.getFlexItemCount()) {
            udVar.qdl = i;
            while (i < flexItemCount) {
                listUd.get(i).qdl++;
                i++;
            }
        } else {
            udVar.qdl = flexItemCount;
        }
        listUd.add(udVar);
        return qdl(flexItemCount + 1, listUd, sparseIntArray);
    }

    int[] qdl(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mml.getFlexItemCount();
        return qdl(flexItemCount, ud(flexItemCount), sparseIntArray);
    }

    private List<ud> ud(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) this.mml.qdl(i2).getLayoutParams();
            ud udVar2 = new ud();
            udVar2.ud = udVar.lnr();
            udVar2.qdl = i2;
            arrayList.add(udVar2);
        }
        return arrayList;
    }

    boolean ud(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mml.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewQdl = this.mml.qdl(i);
            if (viewQdl != null && ((com.bytedance.adsdk.ugeno.mzz.ud) viewQdl.getLayoutParams()).lnr() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] qdl(int i, List<ud> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (ud udVar : list) {
            iArr[i2] = udVar.qdl;
            sparseIntArray.append(udVar.qdl, udVar.ud);
            i2++;
        }
        return iArr;
    }

    void qdl(qdl qdlVar, int i, int i2) {
        qdl(qdlVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<lnr>) null);
    }

    void ud(qdl qdlVar, int i, int i2) {
        qdl(qdlVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<lnr>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void qdl(qdl qdlVar, int i, int i2, int i3, int i4, int i5, List<lnr> list) {
        int i6;
        qdl qdlVar2;
        int i7;
        int i8;
        int i9;
        List<lnr> list2;
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i;
        int i19 = i2;
        int i20 = i5;
        boolean zQdl = this.mml.qdl();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<lnr> arrayList = list == null ? new ArrayList() : list;
        qdlVar.qdl = arrayList;
        int i21 = i20 == -1 ? 1 : 0;
        int iQdl = qdl(zQdl);
        int iUd = ud(zQdl);
        int iLnr = lnr(zQdl);
        int iMml = mml(zQdl);
        lnr lnrVar = new lnr();
        int i22 = i4;
        lnrVar.bjy = i22;
        int i23 = iUd + iQdl;
        lnrVar.mzz = i23;
        int flexItemCount = this.mml.getFlexItemCount();
        int i24 = i21;
        int i25 = Integer.MIN_VALUE;
        int i26 = 0;
        int iCombineMeasuredStates = 0;
        int i27 = 0;
        while (true) {
            if (i22 >= flexItemCount) {
                i6 = iCombineMeasuredStates;
                qdlVar2 = qdlVar;
                break;
            }
            View viewUd = this.mml.ud(i22);
            if (viewUd == null) {
                if (qdl(i22, flexItemCount, lnrVar)) {
                    qdl(arrayList, lnrVar, i22, i26);
                }
            } else if (viewUd.getVisibility() == 8) {
                lnrVar.tvp++;
                lnrVar.jpc++;
                if (qdl(i22, flexItemCount, lnrVar)) {
                    qdl(arrayList, lnrVar, i22, i26);
                }
            } else {
                if (viewUd instanceof CompoundButton) {
                    qdl((CompoundButton) viewUd);
                }
                com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) viewUd.getLayoutParams();
                int i28 = flexItemCount;
                if (udVar.mo() == 4) {
                    lnrVar.rdp.add(Integer.valueOf(i22));
                }
                int iQdl2 = qdl(udVar, zQdl);
                if (udVar.fs() != -1.0f && mode == 1073741824) {
                    iQdl2 = Math.round(size * udVar.fs());
                }
                if (zQdl) {
                    int iQdl3 = this.mml.qdl(i18, i23 + lnr(udVar, true) + mml(udVar, true), iQdl2);
                    i7 = size;
                    i8 = mode;
                    int iUd2 = this.mml.ud(i19, iLnr + iMml + mzz(udVar, true) + mo(udVar, true) + i26, ud(udVar, true));
                    viewUd.measure(iQdl3, iUd2);
                    qdl(i22, iQdl3, iUd2, viewUd);
                    i9 = iQdl3;
                } else {
                    i7 = size;
                    i8 = mode;
                    int iQdl4 = this.mml.qdl(i19, iLnr + iMml + mzz(udVar, false) + mo(udVar, false) + i26, ud(udVar, false));
                    int iUd3 = this.mml.ud(i18, lnr(udVar, false) + i23 + mml(udVar, false), iQdl2);
                    viewUd.measure(iQdl4, iUd3);
                    qdl(i22, iQdl4, iUd3, viewUd);
                    i9 = iUd3;
                }
                qdl(viewUd, i22);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewUd.getMeasuredState());
                int i29 = i26;
                int i30 = i23;
                lnr lnrVar2 = lnrVar;
                int i31 = i22;
                list2 = arrayList;
                int i32 = i9;
                if (qdl(viewUd, i8, i7, lnrVar.mzz, mml(udVar, zQdl) + qdl(viewUd, zQdl) + lnr(udVar, zQdl), udVar, i31, i27, arrayList.size())) {
                    if (lnrVar2.ud() > 0) {
                        qdl(list2, lnrVar2, i31 > 0 ? i31 - 1 : 0, i29);
                        i26 = lnrVar2.wd + i29;
                    } else {
                        i26 = i29;
                    }
                    if (zQdl) {
                        if (udVar.ud() == -1) {
                            com.bytedance.adsdk.ugeno.mzz.qdl qdlVar3 = this.mml;
                            i10 = i2;
                            i22 = i31;
                            view = viewUd;
                            view.measure(i32, qdlVar3.ud(i10, qdlVar3.getPaddingTop() + this.mml.getPaddingBottom() + udVar.rdp() + udVar.jtx() + i26, udVar.ud()));
                            qdl(view, i22);
                        } else {
                            i10 = i2;
                            view = viewUd;
                            i22 = i31;
                        }
                    } else {
                        i10 = i2;
                        view = viewUd;
                        i22 = i31;
                        if (udVar.qdl() == -1) {
                            com.bytedance.adsdk.ugeno.mzz.qdl qdlVar4 = this.mml;
                            view.measure(qdlVar4.qdl(i10, qdlVar4.getPaddingLeft() + this.mml.getPaddingRight() + udVar.exu() + udVar.bjy() + i26, udVar.qdl()), i32);
                            qdl(view, i22);
                        }
                    }
                    lnrVar = new lnr();
                    i12 = 1;
                    lnrVar.jpc = 1;
                    i11 = i30;
                    lnrVar.mzz = i11;
                    lnrVar.bjy = i22;
                    i14 = Integer.MIN_VALUE;
                    i13 = 0;
                } else {
                    i10 = i2;
                    view = viewUd;
                    i22 = i31;
                    lnrVar = lnrVar2;
                    i11 = i30;
                    i12 = 1;
                    lnrVar.jpc++;
                    i13 = i27 + 1;
                    i26 = i29;
                    i14 = i25;
                }
                lnrVar.yt = (lnrVar.yt ? 1 : 0) | (udVar.mml() != 0.0f ? i12 : 0);
                lnrVar.jl = (lnrVar.jl ? 1 : 0) | (udVar.mzz() != 0.0f ? i12 : 0);
                int[] iArr = this.qdl;
                if (iArr != null) {
                    iArr[i22] = list2.size();
                }
                lnrVar.mzz += qdl(view, zQdl) + lnr(udVar, zQdl) + mml(udVar, zQdl);
                lnrVar.to += udVar.mml();
                lnrVar.rq += udVar.mzz();
                this.mml.qdl(view, i22, i13, lnrVar);
                int iMax = Math.max(i14, ud(view, zQdl) + mzz(udVar, zQdl) + mo(udVar, zQdl) + this.mml.qdl(view));
                lnrVar.wd = Math.max(lnrVar.wd, iMax);
                if (zQdl) {
                    if (this.mml.getFlexWrap() != 2) {
                        lnrVar.fs = Math.max(lnrVar.fs, view.getBaseline() + udVar.rdp());
                    } else {
                        lnrVar.fs = Math.max(lnrVar.fs, (view.getMeasuredHeight() - view.getBaseline()) + udVar.jtx());
                    }
                }
                i15 = i28;
                if (qdl(i22, i15, lnrVar)) {
                    qdl(list2, lnrVar, i22, i26);
                    i26 += lnrVar.wd;
                }
                i16 = i5;
                if (i16 == -1 || list2.size() <= 0 || list2.get(list2.size() - i12).jtx < i16 || i22 < i16 || i24 != 0) {
                    i17 = i3;
                } else {
                    i26 = -lnrVar.qdl();
                    i17 = i3;
                    i24 = i12;
                }
                if (i26 > i17 && i24 != 0) {
                    qdlVar2 = qdlVar;
                    i6 = iCombineMeasuredStates;
                    break;
                }
                i27 = i13;
                i25 = iMax;
                i22++;
                i18 = i;
                flexItemCount = i15;
                i19 = i10;
                i23 = i11;
                arrayList = list2;
                size = i7;
                i20 = i16;
                mode = i8;
            }
            i7 = size;
            i8 = mode;
            i10 = i19;
            i16 = i20;
            list2 = arrayList;
            i11 = i23;
            i15 = flexItemCount;
            i22++;
            i18 = i;
            flexItemCount = i15;
            i19 = i10;
            i23 = i11;
            arrayList = list2;
            size = i7;
            i20 = i16;
            mode = i8;
        }
        qdlVar2.ud = i6;
    }

    private void qdl(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) compoundButton.getLayoutParams();
        int iWd = udVar.wd();
        int iJpc = udVar.jpc();
        Drawable drawableQdl = com.bytedance.adsdk.ugeno.wd.mzz.qdl(compoundButton);
        int minimumWidth = drawableQdl == null ? 0 : drawableQdl.getMinimumWidth();
        int minimumHeight = drawableQdl != null ? drawableQdl.getMinimumHeight() : 0;
        if (iWd == -1) {
            iWd = minimumWidth;
        }
        udVar.qdl(iWd);
        if (iJpc == -1) {
            iJpc = minimumHeight;
        }
        udVar.ud(iJpc);
    }

    private int qdl(boolean z) {
        if (z) {
            return this.mml.getPaddingStart();
        }
        return this.mml.getPaddingTop();
    }

    private int ud(boolean z) {
        if (z) {
            return this.mml.getPaddingEnd();
        }
        return this.mml.getPaddingBottom();
    }

    private int lnr(boolean z) {
        if (z) {
            return this.mml.getPaddingTop();
        }
        return this.mml.getPaddingStart();
    }

    private int mml(boolean z) {
        if (z) {
            return this.mml.getPaddingBottom();
        }
        return this.mml.getPaddingEnd();
    }

    private int qdl(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int ud(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int qdl(com.bytedance.adsdk.ugeno.mzz.ud udVar, boolean z) {
        if (z) {
            return udVar.qdl();
        }
        return udVar.ud();
    }

    private int ud(com.bytedance.adsdk.ugeno.mzz.ud udVar, boolean z) {
        if (z) {
            return udVar.ud();
        }
        return udVar.qdl();
    }

    private int lnr(com.bytedance.adsdk.ugeno.mzz.ud udVar, boolean z) {
        if (z) {
            return udVar.exu();
        }
        return udVar.rdp();
    }

    private int mml(com.bytedance.adsdk.ugeno.mzz.ud udVar, boolean z) {
        if (z) {
            return udVar.bjy();
        }
        return udVar.jtx();
    }

    private int mzz(com.bytedance.adsdk.ugeno.mzz.ud udVar, boolean z) {
        if (z) {
            return udVar.rdp();
        }
        return udVar.exu();
    }

    private int mo(com.bytedance.adsdk.ugeno.mzz.ud udVar, boolean z) {
        if (z) {
            return udVar.jtx();
        }
        return udVar.bjy();
    }

    private boolean qdl(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.mzz.ud udVar, int i5, int i6, int i7) {
        if (this.mml.getFlexWrap() == 0) {
            return false;
        }
        if (udVar.rq()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.mml.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iQdl = this.mml.qdl(view, i5, i6);
        if (iQdl > 0) {
            i4 += iQdl;
        }
        return i2 < i3 + i4;
    }

    private boolean qdl(int i, int i2, lnr lnrVar) {
        return i == i2 - 1 && lnrVar.ud() != 0;
    }

    private void qdl(List<lnr> list, lnr lnrVar, int i, int i2) {
        lnrVar.exu = i2;
        this.mml.qdl(lnrVar);
        lnrVar.jtx = i;
        list.add(lnrVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.bytedance.adsdk.ugeno.mzz.ud r0 = (com.bytedance.adsdk.ugeno.mzz.ud) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.wd()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.wd()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.tvp()
            if (r1 <= r3) goto L26
            int r1 = r0.tvp()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.jpc()
            if (r2 >= r5) goto L32
            int r2 = r0.jpc()
            goto L3e
        L32:
            int r5 = r0.to()
            if (r2 <= r5) goto L3d
            int r2 = r0.to()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L50
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.qdl(r8, r1, r0, r7)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.mzz.mml.qdl(android.view.View, int):void");
    }

    void qdl(int i, int i2) {
        qdl(i, i2, 0);
    }

    void qdl(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        lnr(this.mml.getFlexItemCount());
        if (i3 >= this.mml.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mml.getFlexDirection();
        int flexDirection2 = this.mml.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.mml.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.mml.getPaddingLeft();
            paddingRight = this.mml.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.mml.getLargestMainSize();
            }
            paddingLeft = this.mml.getPaddingTop();
            paddingRight = this.mml.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.qdl;
        List<lnr> flexLinesInternal = this.mml.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            lnr lnrVar = flexLinesInternal.get(i5);
            if (lnrVar.mzz < size && lnrVar.yt) {
                qdl(i, i2, lnrVar, size, i4, false);
            } else if (lnrVar.mzz > size && lnrVar.jl) {
                ud(i, i2, lnrVar, size, i4, false);
            }
        }
    }

    private void lnr(int i) {
        boolean[] zArr = this.mzz;
        if (zArr == null) {
            this.mzz = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.mzz = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void qdl(int i, int i2, lnr lnrVar, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        double d;
        int i6;
        double d2;
        float f = 0.0f;
        if (lnrVar.to <= 0.0f || i3 < lnrVar.mzz) {
            return;
        }
        int i7 = lnrVar.mzz;
        float f2 = (i3 - lnrVar.mzz) / lnrVar.to;
        lnrVar.mzz = i4 + lnrVar.mo;
        if (!z) {
            lnrVar.wd = Integer.MIN_VALUE;
        }
        int i8 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i9 = 0;
        while (i8 < lnrVar.jpc) {
            int i10 = lnrVar.bjy + i8;
            View viewUd = this.mml.ud(i10);
            if (viewUd == null || viewUd.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) viewUd.getLayoutParams();
                int flexDirection = this.mml.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i7;
                    int measuredWidth = viewUd.getMeasuredWidth();
                    long[] jArr = this.mo;
                    if (jArr != null) {
                        measuredWidth = qdl(jArr[i10]);
                    }
                    int measuredHeight = viewUd.getMeasuredHeight();
                    long[] jArr2 = this.mo;
                    i5 = i11;
                    if (jArr2 != null) {
                        measuredHeight = ud(jArr2[i10]);
                    }
                    if (!this.mzz[i10] && udVar.mml() > 0.0f) {
                        float fMml = measuredWidth + (udVar.mml() * f2);
                        if (i8 == lnrVar.jpc - 1) {
                            fMml += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fMml);
                        if (iRound > udVar.tvp()) {
                            iRound = udVar.tvp();
                            this.mzz[i10] = true;
                            lnrVar.to -= udVar.mml();
                            z2 = true;
                        } else {
                            f3 += fMml - iRound;
                            double d3 = f3;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d = d3 + 1.0d;
                            }
                            f3 = (float) d;
                        }
                        int iUd = ud(i2, udVar, lnrVar.exu);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewUd.measure(iMakeMeasureSpec, iUd);
                        int measuredWidth2 = viewUd.getMeasuredWidth();
                        int measuredHeight2 = viewUd.getMeasuredHeight();
                        qdl(i10, iMakeMeasureSpec, iUd, viewUd);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + udVar.rdp() + udVar.jtx() + this.mml.qdl(viewUd));
                    lnrVar.mzz += measuredWidth + udVar.exu() + udVar.bjy();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewUd.getMeasuredHeight();
                    long[] jArr3 = this.mo;
                    if (jArr3 != null) {
                        measuredHeight3 = ud(jArr3[i10]);
                    }
                    int measuredWidth3 = viewUd.getMeasuredWidth();
                    long[] jArr4 = this.mo;
                    if (jArr4 != null) {
                        measuredWidth3 = qdl(jArr4[i10]);
                    }
                    if (this.mzz[i10] || udVar.mml() <= f) {
                        i6 = i7;
                    } else {
                        float fMml2 = measuredHeight3 + (udVar.mml() * f2);
                        if (i8 == lnrVar.jpc - 1) {
                            fMml2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fMml2);
                        if (iRound2 > udVar.to()) {
                            iRound2 = udVar.to();
                            this.mzz[i10] = true;
                            lnrVar.to -= udVar.mml();
                            i6 = i7;
                            z2 = true;
                        } else {
                            f3 += fMml2 - iRound2;
                            i6 = i7;
                            double d4 = f3;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            }
                            f3 = (float) d2;
                        }
                        int iQdl = qdl(i, udVar, lnrVar.exu);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewUd.measure(iQdl, iMakeMeasureSpec2);
                        measuredWidth3 = viewUd.getMeasuredWidth();
                        int measuredHeight4 = viewUd.getMeasuredHeight();
                        qdl(i10, iQdl, iMakeMeasureSpec2, viewUd);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + udVar.exu() + udVar.bjy() + this.mml.qdl(viewUd));
                    lnrVar.mzz += measuredHeight3 + udVar.rdp() + udVar.jtx();
                    i5 = i6;
                }
                lnrVar.wd = Math.max(lnrVar.wd, iMax);
                i9 = iMax;
            }
            i8++;
            i7 = i5;
            f = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == lnrVar.mzz) {
            return;
        }
        qdl(i, i2, lnrVar, i3, i4, true);
    }

    private void ud(int i, int i2, lnr lnrVar, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        int i6 = lnrVar.mzz;
        float f = 0.0f;
        if (lnrVar.rq <= 0.0f || i3 > lnrVar.mzz) {
            return;
        }
        float f2 = (lnrVar.mzz - i3) / lnrVar.rq;
        lnrVar.mzz = i4 + lnrVar.mo;
        if (!z) {
            lnrVar.wd = Integer.MIN_VALUE;
        }
        int i7 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i8 = 0;
        while (i7 < lnrVar.jpc) {
            int i9 = lnrVar.bjy + i7;
            View viewUd = this.mml.ud(i9);
            if (viewUd == null || viewUd.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) viewUd.getLayoutParams();
                int flexDirection = this.mml.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int measuredWidth = viewUd.getMeasuredWidth();
                    long[] jArr = this.mo;
                    if (jArr != null) {
                        measuredWidth = qdl(jArr[i9]);
                    }
                    int measuredHeight = viewUd.getMeasuredHeight();
                    long[] jArr2 = this.mo;
                    if (jArr2 != null) {
                        measuredHeight = ud(jArr2[i9]);
                    }
                    if (!this.mzz[i9] && udVar.mzz() > 0.0f) {
                        float fMzz = measuredWidth - (udVar.mzz() * f2);
                        if (i5 == lnrVar.jpc - 1) {
                            fMzz += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fMzz);
                        if (iRound < udVar.wd()) {
                            iRound = udVar.wd();
                            this.mzz[i9] = true;
                            lnrVar.rq -= udVar.mzz();
                            z2 = true;
                        } else {
                            f3 += fMzz - iRound;
                            double d = f3;
                            if (d > 1.0d) {
                                iRound++;
                                f3 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f3 += 1.0f;
                            }
                        }
                        int iUd = ud(i2, udVar, lnrVar.exu);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewUd.measure(iMakeMeasureSpec, iUd);
                        int measuredWidth2 = viewUd.getMeasuredWidth();
                        int measuredHeight2 = viewUd.getMeasuredHeight();
                        qdl(i9, iMakeMeasureSpec, iUd, viewUd);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i8, measuredHeight + udVar.rdp() + udVar.jtx() + this.mml.qdl(viewUd));
                    lnrVar.mzz += measuredWidth + udVar.exu() + udVar.bjy();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewUd.getMeasuredHeight();
                    long[] jArr3 = this.mo;
                    if (jArr3 != null) {
                        measuredHeight3 = ud(jArr3[i9]);
                    }
                    int measuredWidth3 = viewUd.getMeasuredWidth();
                    long[] jArr4 = this.mo;
                    if (jArr4 != null) {
                        measuredWidth3 = qdl(jArr4[i9]);
                    }
                    if (this.mzz[i9] || udVar.mzz() <= f) {
                        i5 = i7;
                    } else {
                        float fMzz2 = measuredHeight3 - (udVar.mzz() * f2);
                        if (i7 == lnrVar.jpc - 1) {
                            fMzz2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fMzz2);
                        if (iRound2 < udVar.jpc()) {
                            iRound2 = udVar.jpc();
                            this.mzz[i9] = true;
                            lnrVar.rq -= udVar.mzz();
                            i5 = i7;
                            z2 = true;
                        } else {
                            f3 += fMzz2 - iRound2;
                            i5 = i7;
                            double d2 = f3;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f3 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f3 += 1.0f;
                            }
                        }
                        int iQdl = qdl(i, udVar, lnrVar.exu);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewUd.measure(iQdl, iMakeMeasureSpec2);
                        measuredWidth3 = viewUd.getMeasuredWidth();
                        int measuredHeight4 = viewUd.getMeasuredHeight();
                        qdl(i9, iQdl, iMakeMeasureSpec2, viewUd);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i8, measuredWidth3 + udVar.exu() + udVar.bjy() + this.mml.qdl(viewUd));
                    lnrVar.mzz += measuredHeight3 + udVar.rdp() + udVar.jtx();
                }
                lnrVar.wd = Math.max(lnrVar.wd, iMax);
                i8 = iMax;
            }
            i7 = i5 + 1;
            f = 0.0f;
        }
        if (!z2 || i6 == lnrVar.mzz) {
            return;
        }
        ud(i, i2, lnrVar, i3, i4, true);
    }

    private int qdl(int i, com.bytedance.adsdk.ugeno.mzz.ud udVar, int i2) {
        com.bytedance.adsdk.ugeno.mzz.qdl qdlVar = this.mml;
        int iQdl = qdlVar.qdl(i, qdlVar.getPaddingLeft() + this.mml.getPaddingRight() + udVar.exu() + udVar.bjy() + i2, udVar.qdl());
        int size = View.MeasureSpec.getSize(iQdl);
        if (size > udVar.tvp()) {
            return View.MeasureSpec.makeMeasureSpec(udVar.tvp(), View.MeasureSpec.getMode(iQdl));
        }
        return size < udVar.wd() ? View.MeasureSpec.makeMeasureSpec(udVar.wd(), View.MeasureSpec.getMode(iQdl)) : iQdl;
    }

    private int ud(int i, com.bytedance.adsdk.ugeno.mzz.ud udVar, int i2) {
        com.bytedance.adsdk.ugeno.mzz.qdl qdlVar = this.mml;
        int iUd = qdlVar.ud(i, qdlVar.getPaddingTop() + this.mml.getPaddingBottom() + udVar.rdp() + udVar.jtx() + i2, udVar.ud());
        int size = View.MeasureSpec.getSize(iUd);
        if (size > udVar.to()) {
            return View.MeasureSpec.makeMeasureSpec(udVar.to(), View.MeasureSpec.getMode(iUd));
        }
        return size < udVar.jpc() ? View.MeasureSpec.makeMeasureSpec(udVar.jpc(), View.MeasureSpec.getMode(iUd)) : iUd;
    }

    void ud(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.mml.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else if (flexDirection == 2 || flexDirection == 3) {
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        List<lnr> flexLinesInternal = this.mml.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mml.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).wd = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.mml.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    lnr lnrVar = new lnr();
                    lnrVar.wd = i5;
                    flexLinesInternal.add(0, lnrVar);
                    return;
                }
                if (alignContent == 2) {
                    this.mml.setFlexLines(qdl(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i4 < size4) {
                            arrayList.add(flexLinesInternal.get(i4));
                            if (i4 != flexLinesInternal.size() - 1) {
                                lnr lnrVar2 = new lnr();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    lnrVar2.wd = Math.round(f + size3);
                                    f = 0.0f;
                                } else {
                                    lnrVar2.wd = Math.round(size3);
                                }
                                f += size3 - lnrVar2.wd;
                                if (f > 1.0f) {
                                    lnrVar2.wd++;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    lnrVar2.wd--;
                                    f += 1.0f;
                                }
                                arrayList.add(lnrVar2);
                            }
                            i4++;
                        }
                        this.mml.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.mml.setFlexLines(qdl(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    lnr lnrVar3 = new lnr();
                    lnrVar3.wd = size5;
                    for (lnr lnrVar4 : flexLinesInternal) {
                        arrayList2.add(lnrVar3);
                        arrayList2.add(lnrVar4);
                        arrayList2.add(lnrVar3);
                    }
                    this.mml.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        lnr lnrVar5 = flexLinesInternal.get(i4);
                        float f3 = lnrVar5.wd + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        lnrVar5.wd = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private List<lnr> qdl(List<lnr> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        lnr lnrVar = new lnr();
        lnrVar.wd = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(lnrVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(lnrVar);
            }
        }
        return arrayList;
    }

    void qdl() {
        qdl(0);
    }

    void qdl(int i) {
        View viewUd;
        if (i >= this.mml.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mml.getFlexDirection();
        if (this.mml.getAlignItems() == 4) {
            int[] iArr = this.qdl;
            List<lnr> flexLinesInternal = this.mml.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                lnr lnrVar = flexLinesInternal.get(i2);
                int i3 = lnrVar.jpc;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = lnrVar.bjy + i4;
                    if (i4 < this.mml.getFlexItemCount() && (viewUd = this.mml.ud(i5)) != null && viewUd.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) viewUd.getLayoutParams();
                        if (udVar.mo() == -1 || udVar.mo() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                qdl(viewUd, lnrVar.wd, i5);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                ud(viewUd, lnrVar.wd, i5);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                        }
                    }
                }
            }
            return;
        }
        for (lnr lnrVar2 : this.mml.getFlexLinesInternal()) {
            for (Integer num : lnrVar2.rdp) {
                View viewUd2 = this.mml.ud(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    qdl(viewUd2, lnrVar2.wd, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    ud(viewUd2, lnrVar2.wd, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                }
            }
        }
    }

    private void qdl(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - udVar.rdp()) - udVar.jtx()) - this.mml.qdl(view), udVar.jpc()), udVar.to());
        long[] jArr = this.mo;
        if (jArr != null) {
            measuredWidth = qdl(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        qdl(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    private void ud(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - udVar.exu()) - udVar.bjy()) - this.mml.qdl(view), udVar.wd()), udVar.tvp());
        long[] jArr = this.mo;
        if (jArr != null) {
            measuredHeight = ud(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        qdl(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    void qdl(View view, lnr lnrVar, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) view.getLayoutParams();
        int alignItems = this.mml.getAlignItems();
        if (udVar.mo() != -1) {
            alignItems = udVar.mo();
        }
        int i5 = lnrVar.wd;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.mml.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - udVar.jtx(), i3, i6 - udVar.jtx());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + udVar.rdp(), i3, (i4 - i5) + view.getMeasuredHeight() + udVar.rdp());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + udVar.rdp()) - udVar.jtx()) / 2;
                if (this.mml.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.mml.getFlexWrap() != 2) {
                    int iMax = Math.max(lnrVar.fs - view.getBaseline(), udVar.rdp());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((lnrVar.fs - view.getMeasuredHeight()) + view.getBaseline(), udVar.jtx());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.mml.getFlexWrap() != 2) {
            view.layout(i, i2 + udVar.rdp(), i3, i4 + udVar.rdp());
        } else {
            view.layout(i, i2 - udVar.jtx(), i3, i4 - udVar.jtx());
        }
    }

    void qdl(View view, lnr lnrVar, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.mzz.ud udVar = (com.bytedance.adsdk.ugeno.mzz.ud) view.getLayoutParams();
        int alignItems = this.mml.getAlignItems();
        if (udVar.mo() != -1) {
            alignItems = udVar.mo();
        }
        int i5 = lnrVar.wd;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - udVar.bjy(), i2, ((i3 + i5) - view.getMeasuredWidth()) - udVar.bjy(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + udVar.exu(), i2, (i3 - i5) + view.getMeasuredWidth() + udVar.exu(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + com.bytedance.adsdk.ugeno.wd.mo.qdl(marginLayoutParams)) - com.bytedance.adsdk.ugeno.wd.mo.ud(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + udVar.exu(), i2, i3 + udVar.exu(), i4);
        } else {
            view.layout(i - udVar.bjy(), i2, i3 - udVar.bjy(), i4);
        }
    }

    private void qdl(int i, int i2, int i3, View view) {
        long[] jArr = this.ud;
        if (jArr != null) {
            jArr[i] = ud(i2, i3);
        }
        long[] jArr2 = this.mo;
        if (jArr2 != null) {
            jArr2[i] = ud(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private static class ud implements Comparable<ud> {
        int qdl;
        int ud;

        private ud() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public int compareTo(ud udVar) {
            int i = this.ud;
            int i2 = udVar.ud;
            return i != i2 ? i - i2 : this.qdl - udVar.qdl;
        }

        public String toString() {
            return "Order{order=" + this.ud + ", index=" + this.qdl + AbstractJsonLexerKt.END_OBJ;
        }
    }

    static class qdl {
        List<lnr> qdl;
        int ud;

        qdl() {
        }

        void qdl() {
            this.qdl = null;
            this.ud = 0;
        }
    }
}
