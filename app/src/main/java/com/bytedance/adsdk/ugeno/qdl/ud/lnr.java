package com.bytedance.adsdk.ugeno.qdl.ud;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.qdl.mzz;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class lnr extends qdl {
    public lnr(Context context, com.bytedance.adsdk.ugeno.ud.lnr lnrVar, String str, TreeMap<Float, String> treeMap) {
        super(context, lnrVar, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.ud.qdl
    public void ud() {
        if (this.mml == mzz.BACKGROUND_COLOR) {
            this.mzz.add(Keyframe.ofInt(0.0f, this.wd.ax()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.ud.qdl
    public void qdl(float f, String str) {
        Keyframe keyframeOfInt;
        if (this.mml == mzz.BACKGROUND_COLOR) {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.wd.qdl.qdl(str));
        } else {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str, 0));
        }
        this.mzz.add(keyframeOfInt);
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.ud.qdl
    public TypeEvaluator mo() {
        if (this.mml == mzz.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
