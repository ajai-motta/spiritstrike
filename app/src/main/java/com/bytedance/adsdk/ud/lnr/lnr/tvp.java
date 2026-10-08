package com.bytedance.adsdk.ud.lnr.lnr;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.ud.lnr.qdl.rq;
import com.bytedance.adsdk.ud.lnr.ud;
import com.bytedance.adsdk.ud.lnr.ud.jtx;
import com.bytedance.adsdk.ud.qdl.ud.bjy;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class tvp extends com.bytedance.adsdk.ud.lnr.lnr.qdl {
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> aaj;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> bch;
    private final bjy bjy;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Typeface, Typeface> bqt;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> exc;
    private final LongSparseArray<String> exu;
    private final Map<com.bytedance.adsdk.ud.lnr.mml, List<com.bytedance.adsdk.ud.qdl.qdl.mml>> fs;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> jl;
    private final RectF jpc;
    private final com.bytedance.adsdk.ud.tvp jtx;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> jyq;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> ljh;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> oth;
    private final List<qdl> rdp;
    private final Paint rq;
    private final Paint to;
    private final Matrix tvp;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> uw;
    private final StringBuilder wd;
    private com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> xmv;
    private final com.bytedance.adsdk.ud.wd yt;

    tvp(com.bytedance.adsdk.ud.tvp tvpVar, mzz mzzVar) {
        super(tvpVar, mzzVar);
        this.wd = new StringBuilder(2);
        this.jpc = new RectF();
        this.tvp = new Matrix();
        int i = 1;
        this.to = new Paint(i) { // from class: com.bytedance.adsdk.ud.lnr.lnr.tvp.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.rq = new Paint(i) { // from class: com.bytedance.adsdk.ud.lnr.lnr.tvp.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.fs = new HashMap();
        this.exu = new LongSparseArray<>();
        this.rdp = new ArrayList();
        this.jtx = tvpVar;
        this.yt = mzzVar.qdl();
        bjy bjyVarQdl = mzzVar.exc().qdl();
        this.bjy = bjyVarQdl;
        bjyVarQdl.qdl(this);
        qdl(bjyVarQdl);
        rq rqVarAaj = mzzVar.aaj();
        if (rqVarAaj != null && rqVarAaj.qdl != null) {
            com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVarQdl = rqVarAaj.qdl.qdl();
            this.jl = qdlVarQdl;
            qdlVarQdl.qdl(this);
            qdl(this.jl);
        }
        if (rqVarAaj != null && rqVarAaj.ud != null) {
            com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVarQdl2 = rqVarAaj.ud.qdl();
            this.aaj = qdlVarQdl2;
            qdlVarQdl2.qdl(this);
            qdl(this.aaj);
        }
        if (rqVarAaj != null && rqVarAaj.lnr != null) {
            com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl3 = rqVarAaj.lnr.qdl();
            this.oth = qdlVarQdl3;
            qdlVarQdl3.qdl(this);
            qdl(this.oth);
        }
        if (rqVarAaj == null || rqVarAaj.mml == null) {
            return;
        }
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl4 = rqVarAaj.mml.qdl();
        this.bch = qdlVarQdl4;
        qdlVarQdl4.qdl(this);
        qdl(this.bch);
    }

    @Override // com.bytedance.adsdk.ud.lnr.lnr.qdl, com.bytedance.adsdk.ud.qdl.qdl.mzz
    public void qdl(RectF rectF, Matrix matrix, boolean z) {
        super.qdl(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.yt.mml().width(), this.yt.mml().height());
    }

    @Override // com.bytedance.adsdk.ud.lnr.lnr.qdl
    public void ud(Canvas canvas, Matrix matrix, int i) {
        super.ud(canvas, matrix, i);
        com.bytedance.adsdk.ud.lnr.ud udVarWd = this.bjy.wd();
        com.bytedance.adsdk.ud.lnr.lnr lnrVar = this.yt.bjy().get(udVarWd.ud);
        if (lnrVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        qdl(udVarWd, matrix);
        if (this.jtx.uw()) {
            qdl(udVarWd, matrix, lnrVar, canvas);
        } else {
            qdl(udVarWd, lnrVar, canvas);
        }
        canvas.restore();
    }

    private void qdl(com.bytedance.adsdk.ud.lnr.ud udVar, Matrix matrix) {
        com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar = this.exc;
        if (qdlVar != null) {
            this.to.setColor(qdlVar.wd().intValue());
        } else {
            com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar2 = this.jl;
            if (qdlVar2 != null) {
                this.to.setColor(qdlVar2.wd().intValue());
            } else {
                this.to.setColor(udVar.jpc);
            }
        }
        com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar3 = this.jyq;
        if (qdlVar3 != null) {
            this.rq.setColor(qdlVar3.wd().intValue());
        } else {
            com.bytedance.adsdk.ud.qdl.ud.qdl<Integer, Integer> qdlVar4 = this.aaj;
            if (qdlVar4 != null) {
                this.rq.setColor(qdlVar4.wd().intValue());
            } else {
                this.rq.setColor(udVar.tvp);
            }
        }
        int iIntValue = ((this.mml.qdl() == null ? 100 : this.mml.qdl().wd().intValue()) * 255) / 100;
        this.to.setAlpha(iIntValue);
        this.rq.setAlpha(iIntValue);
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVar5 = this.ljh;
        if (qdlVar5 != null) {
            this.rq.setStrokeWidth(qdlVar5.wd().floatValue());
            return;
        }
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVar6 = this.oth;
        if (qdlVar6 != null) {
            this.rq.setStrokeWidth(qdlVar6.wd().floatValue());
        } else {
            this.rq.setStrokeWidth(udVar.to * com.bytedance.adsdk.ud.mo.mo.qdl());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(com.bytedance.adsdk.ud.lnr.ud r21, android.graphics.Matrix r22, com.bytedance.adsdk.ud.lnr.lnr r23, android.graphics.Canvas r24) {
        /*
            r20 = this;
            r8 = r20
            r9 = r21
            com.bytedance.adsdk.ud.qdl.ud.qdl<java.lang.Float, java.lang.Float> r0 = r8.xmv
            if (r0 == 0) goto L13
            java.lang.Object r0 = r0.wd()
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            goto L15
        L13:
            float r0 = r9.lnr
        L15:
            r1 = 1120403456(0x42c80000, float:100.0)
            float r10 = r0 / r1
            float r11 = com.bytedance.adsdk.ud.mo.mo.qdl(r22)
            java.lang.String r0 = r9.qdl
            java.util.List r12 = r8.qdl(r0)
            int r13 = r12.size()
            int r0 = r9.mzz
            float r0 = (float) r0
            r1 = 1092616192(0x41200000, float:10.0)
            float r0 = r0 / r1
            com.bytedance.adsdk.ud.qdl.ud.qdl<java.lang.Float, java.lang.Float> r1 = r8.uw
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r1.wd()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
        L3b:
            float r0 = r0 + r1
            goto L4c
        L3d:
            com.bytedance.adsdk.ud.qdl.ud.qdl<java.lang.Float, java.lang.Float> r1 = r8.bch
            if (r1 == 0) goto L4c
            java.lang.Object r1 = r1.wd()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L3b
        L4c:
            r14 = r0
            r15 = 0
            r0 = -1
            r7 = r0
            r6 = r15
        L51:
            if (r6 >= r13) goto Lb3
            java.lang.Object r0 = r12.get(r6)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r0 = r9.exu
            if (r0 != 0) goto L60
            r0 = 0
            goto L64
        L60:
            android.graphics.PointF r0 = r9.exu
            float r0 = r0.x
        L64:
            r2 = r0
            r16 = 1
            r0 = r20
            r3 = r23
            r4 = r10
            r5 = r14
            r17 = r6
            r6 = r16
            java.util.List r6 = r0.qdl(r1, r2, r3, r4, r5, r6)
            r5 = r15
        L76:
            int r0 = r6.size()
            if (r5 >= r0) goto Lb0
            java.lang.Object r0 = r6.get(r5)
            com.bytedance.adsdk.ud.lnr.lnr.tvp$qdl r0 = (com.bytedance.adsdk.ud.lnr.lnr.tvp.qdl) r0
            int r7 = r7 + 1
            r24.save()
            float r1 = com.bytedance.adsdk.ud.lnr.lnr.tvp.qdl.qdl(r0)
            r4 = r24
            r8.qdl(r4, r9, r7, r1)
            java.lang.String r1 = com.bytedance.adsdk.ud.lnr.lnr.tvp.qdl.ud(r0)
            r0 = r20
            r2 = r21
            r3 = r23
            r16 = r5
            r5 = r11
            r18 = r6
            r6 = r10
            r19 = r7
            r7 = r14
            r0.qdl(r1, r2, r3, r4, r5, r6, r7)
            r24.restore()
            int r5 = r16 + 1
            r6 = r18
            r7 = r19
            goto L76
        Lb0:
            int r6 = r17 + 1
            goto L51
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.lnr.lnr.tvp.qdl(com.bytedance.adsdk.ud.lnr.ud, android.graphics.Matrix, com.bytedance.adsdk.ud.lnr.lnr, android.graphics.Canvas):void");
    }

    private void qdl(String str, com.bytedance.adsdk.ud.lnr.ud udVar, com.bytedance.adsdk.ud.lnr.lnr lnrVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.bytedance.adsdk.ud.lnr.mml mmlVar = this.yt.rdp().get(com.bytedance.adsdk.ud.lnr.mml.qdl(str.charAt(i), lnrVar.qdl(), lnrVar.lnr()));
            if (mmlVar != null) {
                qdl(mmlVar, f2, udVar, canvas);
                canvas.translate((((float) mmlVar.ud()) * f2 * com.bytedance.adsdk.ud.mo.mo.qdl()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(com.bytedance.adsdk.ud.lnr.ud r19, com.bytedance.adsdk.ud.lnr.lnr r20, android.graphics.Canvas r21) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.lnr.lnr.tvp.qdl(com.bytedance.adsdk.ud.lnr.ud, com.bytedance.adsdk.ud.lnr.lnr, android.graphics.Canvas):void");
    }

    private void qdl(Canvas canvas, com.bytedance.adsdk.ud.lnr.ud udVar, int i, float f) {
        PointF pointF = udVar.fs;
        PointF pointF2 = udVar.exu;
        float fQdl = com.bytedance.adsdk.ud.mo.mo.qdl();
        float f2 = (i * udVar.mo * fQdl) + (pointF == null ? 0.0f : (udVar.mo * 0.6f * fQdl) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.qdl[udVar.mml.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ud.lnr.lnr.tvp$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] qdl;

        static {
            int[] iArr = new int[ud.qdl.values().length];
            qdl = iArr;
            try {
                iArr[ud.qdl.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                qdl[ud.qdl.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                qdl[ud.qdl.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private Typeface qdl(com.bytedance.adsdk.ud.lnr.lnr lnrVar) {
        Typeface typefaceWd;
        com.bytedance.adsdk.ud.qdl.ud.qdl<Typeface, Typeface> qdlVar = this.bqt;
        if (qdlVar != null && (typefaceWd = qdlVar.wd()) != null) {
            return typefaceWd;
        }
        Typeface typefaceQdl = this.jtx.qdl(lnrVar);
        return typefaceQdl != null ? typefaceQdl : lnrVar.mml();
    }

    private List<String> qdl(String str) {
        return Arrays.asList(str.replaceAll(ServerSentEventKt.END_OF_LINE, "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void qdl(String str, com.bytedance.adsdk.ud.lnr.ud udVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strQdl = qdl(str, length);
            length += strQdl.length();
            qdl(strQdl, udVar, canvas);
            canvas.translate(this.to.measureText(strQdl) + f, 0.0f);
        }
    }

    private List<qdl> qdl(String str, float f, com.bytedance.adsdk.ud.lnr.lnr lnrVar, float f2, float f3, boolean z) {
        float fMeasureText;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                com.bytedance.adsdk.ud.lnr.mml mmlVar = this.yt.rdp().get(com.bytedance.adsdk.ud.lnr.mml.qdl(cCharAt, lnrVar.qdl(), lnrVar.lnr()));
                if (mmlVar != null) {
                    fMeasureText = ((float) mmlVar.ud()) * f2 * com.bytedance.adsdk.ud.mo.mo.qdl();
                }
            } else {
                fMeasureText = this.to.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = fMeasureText + f3;
            if (cCharAt == ' ') {
                z2 = true;
                f6 = f7;
            } else if (z2) {
                z2 = false;
                i3 = i4;
                f5 = f7;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && cCharAt != ' ') {
                i++;
                qdl qdlVarUd = ud(i);
                if (i3 == i2) {
                    qdlVarUd.qdl(str.substring(i2, i4).trim(), (f4 - f7) - ((r9.length() - r7.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    qdlVarUd.qdl(str.substring(i2, i3 - 1).trim(), ((f4 - f5) - ((r7.length() - r13.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            ud(i).qdl(str.substring(i2), f4);
        }
        return this.rdp.subList(0, i);
    }

    private qdl ud(int i) {
        for (int size = this.rdp.size(); size < i; size++) {
            this.rdp.add(new qdl());
        }
        return this.rdp.get(i - 1);
    }

    private void qdl(com.bytedance.adsdk.ud.lnr.mml mmlVar, float f, com.bytedance.adsdk.ud.lnr.ud udVar, Canvas canvas) {
        List<com.bytedance.adsdk.ud.qdl.qdl.mml> listQdl = qdl(mmlVar);
        for (int i = 0; i < listQdl.size(); i++) {
            Path pathMml = listQdl.get(i).mml();
            pathMml.computeBounds(this.jpc, false);
            this.tvp.reset();
            this.tvp.preTranslate(0.0f, (-udVar.wd) * com.bytedance.adsdk.ud.mo.mo.qdl());
            this.tvp.preScale(f, f);
            pathMml.transform(this.tvp);
            if (udVar.rq) {
                qdl(pathMml, this.to, canvas);
                qdl(pathMml, this.rq, canvas);
            } else {
                qdl(pathMml, this.rq, canvas);
                qdl(pathMml, this.to, canvas);
            }
        }
    }

    private void qdl(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void qdl(String str, com.bytedance.adsdk.ud.lnr.ud udVar, Canvas canvas) {
        if (udVar.rq) {
            qdl(str, this.to, canvas);
            qdl(str, this.rq, canvas);
        } else {
            qdl(str, this.rq, canvas);
            qdl(str, this.to, canvas);
        }
    }

    private void qdl(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.ud.qdl.qdl.mml> qdl(com.bytedance.adsdk.ud.lnr.mml mmlVar) {
        if (this.fs.containsKey(mmlVar)) {
            return this.fs.get(mmlVar);
        }
        List<jtx> listQdl = mmlVar.qdl();
        int size = listQdl.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.bytedance.adsdk.ud.qdl.qdl.mml(this.jtx, this, listQdl.get(i), this.yt));
        }
        this.fs.put(mmlVar, arrayList);
        return arrayList;
    }

    private String qdl(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!lnr(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.exu.indexOfKey(j) >= 0) {
            return this.exu.get(j);
        }
        this.wd.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.wd.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.wd.toString();
        this.exu.put(j, string);
        return string;
    }

    private boolean lnr(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private static class qdl {
        private String qdl;
        private float ud;

        private qdl() {
            this.qdl = "";
            this.ud = 0.0f;
        }

        void qdl(String str, float f) {
            this.qdl = str;
            this.ud = f;
        }
    }
}
