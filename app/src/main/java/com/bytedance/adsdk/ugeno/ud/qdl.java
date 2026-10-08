package com.bytedance.adsdk.ugeno.ud;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.wd.jpc;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class qdl<E extends ViewGroup> extends lnr {
    protected List<lnr<View>> qdl;

    public qdl(Context context) {
        this(context, null);
    }

    public qdl(Context context, qdl qdlVar) {
        super(context, qdlVar);
        this.qdl = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        super.ud();
    }

    public void qdl(lnr lnrVar) {
        if (lnrVar == null) {
            return;
        }
        this.qdl.add(lnrVar);
        View viewRq = lnrVar.rq();
        if (viewRq != null) {
            ((ViewGroup) this.mzz).addView(viewRq);
        }
    }

    public void qdl(lnr lnrVar, ViewGroup.LayoutParams layoutParams) {
        if (lnrVar == null) {
            return;
        }
        this.qdl.add(lnrVar);
        View viewRq = lnrVar.rq();
        if (viewRq != null) {
            ((ViewGroup) this.mzz).addView(viewRq, layoutParams);
        }
    }

    public List<lnr<View>> tvp() {
        return this.qdl;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public lnr qdl(String str) {
        lnr<T> lnrVarMzz;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.rq)) {
            return this;
        }
        for (lnr<View> lnrVar : this.qdl) {
            if (lnrVar != null && (lnrVarMzz = lnrVar.mzz(str)) != 0) {
                return lnrVarMzz;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public lnr ud(String str) {
        lnr<T> lnrVarMo;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.fs)) {
            return this;
        }
        for (lnr<View> lnrVar : this.qdl) {
            if (lnrVar != null && (lnrVarMo = lnrVar.mo(str)) != 0) {
                return lnrVarMo;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    protected lnr lnr(String str) {
        lnr<T> lnrVarWd;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.fs) && this.mlb == 0) {
            return this;
        }
        if (this.mlb != 0) {
            return null;
        }
        for (lnr<View> lnrVar : this.qdl) {
            if (lnrVar != null && (lnrVarWd = lnrVar.wd(str)) != 0) {
                return lnrVarWd;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    protected lnr mml(String str) {
        lnr<T> lnrVarJpc;
        if (!TextUtils.isEmpty(str) && exu(str) != null) {
            return this;
        }
        for (lnr<View> lnrVar : this.qdl) {
            if (lnrVar != null && (lnrVarJpc = lnrVar.jpc(str)) != 0) {
                return lnrVarJpc;
            }
        }
        return null;
    }

    public C0190qdl to() {
        return new C0190qdl(this);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.ud.qdl$qdl, reason: collision with other inner class name */
    public static class C0190qdl {
        protected boolean aaj;
        protected ViewGroup.LayoutParams bch;
        protected boolean bjy;
        protected boolean exc;
        protected float exu;
        protected float fs;
        protected boolean jl;
        protected float jpc;
        protected boolean jtx;
        protected boolean jyq;
        protected boolean ljh;
        protected float mo;
        protected float mzz;
        protected boolean oth;
        protected float rdp;
        protected float rq;
        protected float to;
        protected float tvp;
        protected qdl uw;
        protected float wd;
        protected boolean yt;
        protected float qdl = -2.0f;
        protected float ud = -2.0f;
        protected float lnr = 0.0f;
        protected float mml = 0.0f;

        public C0190qdl(qdl qdlVar) {
            this.uw = qdlVar;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public void qdl(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            str.hashCode();
            byte b = -1;
            switch (str.hashCode()) {
                case -1501175880:
                    if (str.equals("paddingLeft")) {
                        b = 0;
                    }
                    break;
                case -1375815020:
                    if (str.equals("minWidth")) {
                        b = 1;
                    }
                    break;
                case -1221029593:
                    if (str.equals(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                        b = 2;
                    }
                    break;
                case -1081309778:
                    if (str.equals("margin")) {
                        b = 3;
                    }
                    break;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        b = 4;
                    }
                    break;
                case -806339567:
                    if (str.equals("padding")) {
                        b = 5;
                    }
                    break;
                case -289173127:
                    if (str.equals("marginBottom")) {
                        b = 6;
                    }
                    break;
                case -133587431:
                    if (str.equals("minHeight")) {
                        b = 7;
                    }
                    break;
                case 90130308:
                    if (str.equals("paddingTop")) {
                        b = 8;
                    }
                    break;
                case 113126854:
                    if (str.equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                        b = 9;
                    }
                    break;
                case 202355100:
                    if (str.equals("paddingBottom")) {
                        b = 10;
                    }
                    break;
                case 713848971:
                    if (str.equals("paddingRight")) {
                        b = Ascii.VT;
                    }
                    break;
                case 975087886:
                    if (str.equals("marginRight")) {
                        b = Ascii.FF;
                    }
                    break;
                case 1970934485:
                    if (str.equals("marginLeft")) {
                        b = Ascii.CR;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    this.rq = jpc.qdl(context, str2);
                    this.jtx = true;
                    break;
                case 1:
                    this.lnr = jpc.qdl(context, str2);
                    break;
                case 2:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.ud = -1.0f;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.ud = -2.0f;
                    } else {
                        this.ud = jpc.qdl(context, str2);
                    }
                    break;
                case 3:
                    this.mzz = jpc.qdl(context, str2);
                    break;
                case 4:
                    this.jpc = jpc.qdl(context, str2);
                    this.oth = true;
                    break;
                case 5:
                    this.to = jpc.qdl(context, str2);
                    this.bjy = true;
                    break;
                case 6:
                    this.tvp = jpc.qdl(context, str2);
                    this.ljh = true;
                    break;
                case 7:
                    this.mml = jpc.qdl(context, str2);
                    break;
                case 8:
                    this.fs = jpc.qdl(context, str2);
                    this.jl = true;
                    break;
                case 9:
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.qdl = -1.0f;
                    } else if (TextUtils.equals(str2, "wrap_content")) {
                        this.qdl = -2.0f;
                    } else {
                        this.qdl = jpc.qdl(context, str2);
                    }
                    break;
                case 10:
                    this.rdp = jpc.qdl(context, str2);
                    this.exc = true;
                    break;
                case 11:
                    this.exu = jpc.qdl(context, str2);
                    this.yt = true;
                    break;
                case 12:
                    this.wd = jpc.qdl(context, str2);
                    this.jyq = true;
                    break;
                case 13:
                    this.mo = jpc.qdl(context, str2);
                    this.aaj = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.qdl + ", mHeight=" + this.ud + ", mMargin=" + this.mzz + ", mMarginLeft=" + this.mo + ", mMarginRight=" + this.wd + ", mMarginTop=" + this.jpc + ", mMarginBottom=" + this.tvp + ", mParams=" + this.bch + AbstractJsonLexerKt.END_OBJ;
        }

        public ViewGroup.LayoutParams qdl() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.qdl, (int) this.ud);
            marginLayoutParams.leftMargin = (int) (this.aaj ? this.mo : this.mzz);
            marginLayoutParams.rightMargin = (int) (this.jyq ? this.wd : this.mzz);
            marginLayoutParams.topMargin = (int) (this.oth ? this.jpc : this.mzz);
            marginLayoutParams.bottomMargin = (int) (this.ljh ? this.tvp : this.mzz);
            return marginLayoutParams;
        }
    }
}
