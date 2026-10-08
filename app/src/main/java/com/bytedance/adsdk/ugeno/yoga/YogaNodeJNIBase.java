package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class YogaNodeJNIBase extends to implements Cloneable {
    private float[] arr;
    private List<YogaNodeJNIBase> lnr;
    private int mLayoutDirection;
    private wd mml;
    private Object mo;
    private ud mzz;
    protected long qdl;
    private YogaNodeJNIBase ud;
    private boolean wd;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.wd = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.qdl = j;
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public int qdl() {
        List<YogaNodeJNIBase> list = this.lnr;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    /* JADX INFO: renamed from: lnr, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase qdl(int i) {
        List<YogaNodeJNIBase> list = this.lnr;
        if (list == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return list.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(to toVar, int i) {
        if (toVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) toVar;
            if (yogaNodeJNIBase.ud != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.lnr == null) {
                this.lnr = new ArrayList(4);
            }
            this.lnr.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.ud = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.qdl, yogaNodeJNIBase.qdl, i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    /* JADX INFO: renamed from: mml, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase ud(int i) {
        List<YogaNodeJNIBase> list = this.lnr;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.ud = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.qdl, yogaNodeJNIBaseRemove.qdl);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    /* JADX INFO: renamed from: rq, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase ud() {
        return this.ud;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public int qdl(to toVar) {
        List<YogaNodeJNIBase> list = this.lnr;
        if (list == null) {
            return -1;
        }
        return list.indexOf(toVar);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(float f, float f2) {
        ud((to) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.lnr;
            if (list != null) {
                for (YogaNodeJNIBase yogaNodeJNIBase2 : list) {
                    yogaNodeJNIBase2.ud(yogaNodeJNIBase);
                    arrayList.add(yogaNodeJNIBase2);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].qdl;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.qdl, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    private void ud(to toVar) {
        to();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(lnr lnrVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.qdl, lnrVar.qdl());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(mzz mzzVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.qdl, mzzVar.qdl());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(mo moVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.qdl, moVar.qdl());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(qdl qdlVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.qdl, qdlVar.qdl());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void ud(qdl qdlVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.qdl, qdlVar.qdl());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void lnr(qdl qdlVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.qdl, qdlVar.qdl());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(exu exuVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.qdl, exuVar.qdl());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(rdp rdpVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.qdl, rdpVar.qdl());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void ud(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void lnr(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void lnr() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.qdl);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(mml mmlVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.qdl, mmlVar.qdl(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void ud(mml mmlVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.qdl, mmlVar.qdl(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void lnr(mml mmlVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.qdl, mmlVar.qdl(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void mml(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void mzz(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void mml() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.qdl);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void mo(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void wd(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void mzz() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.qdl);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void jpc(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void tvp(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void to(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void rq(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void fs(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.qdl, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(wd wdVar) {
        this.mml = wdVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.qdl, wdVar != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.qdl, z);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (!fs()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.mml.qdl(this, f, jpc.qdl(i), f2, jpc.qdl(i2));
    }

    public final float baseline(float f, float f2) {
        return this.mzz.qdl(this, f, f2);
    }

    public boolean fs() {
        return this.mml != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public void qdl(Object obj) {
        this.mo = obj;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public Object to() {
        return this.mo;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.lnr;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.lnr.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.ud = this;
        return yogaNodeJNIBase.qdl;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public float mo() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public float wd() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public float jpc() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.to
    public float tvp() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }
}
