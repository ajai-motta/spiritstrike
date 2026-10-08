package com.bytedance.sdk.openadsdk.jtx;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.aaj;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl implements Comparable<qdl> {
    private int lnr;
    private int mzz;
    private long rdp;
    private final String ud;
    private int wd;
    private final ArrayList<Long> qdl = new ArrayList<>();
    private final ArrayList<Long> mml = new ArrayList<>();
    private final ArrayList<Long> mo = new ArrayList<>();
    private final ArrayList<Long> jpc = new ArrayList<>();
    private final HashMap<String, ud> tvp = new HashMap<>();
    private int to = 0;
    private int rq = 0;
    private final HashMap<String, ud> fs = new HashMap<>();
    private int exu = 0;
    private final ArrayList<String> bjy = new ArrayList<>();

    public qdl(String str) {
        this.ud = str;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void qdl(String str, String str2) {
        ud udVar;
        ud udVar2;
        ud udVar3;
        ud udVar4;
        ud udVar5;
        ud udVar6;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1908685858:
                if (str.equals("landingContinue")) {
                    b = 0;
                }
                break;
            case -1769688545:
                if (str.equals("landingPause")) {
                    b = 1;
                }
                break;
            case -1766371189:
                if (str.equals("landingStart")) {
                    b = 2;
                }
                break;
            case -1643912491:
                if (str.equals("feed_over")) {
                    b = 3;
                }
                break;
            case -1643892427:
                if (str.equals("feed_play")) {
                    b = 4;
                }
                break;
            case 3529469:
                if (str.equals("show")) {
                    b = 5;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 6;
                }
                break;
            case 533457448:
                if (str.equals("feed_continue")) {
                    b = 7;
                }
                break;
            case 566194974:
                if (str.equals("feed_break")) {
                    b = 8;
                }
                break;
            case 578633749:
                if (str.equals("feed_pause")) {
                    b = 9;
                }
                break;
            case 695109002:
                if (str.equals("landingFinish")) {
                    b = 10;
                }
                break;
            case 702698279:
                if (str.equals("videoPercent30")) {
                    b = Ascii.VT;
                }
                break;
            case 1338624943:
                if (str.equals("videoForceBreak")) {
                    b = Ascii.FF;
                }
                break;
            case 1671642405:
                if (str.equals("dislike")) {
                    b = Ascii.CR;
                }
                break;
            case 1912965437:
                if (str.equals("play_error")) {
                    b = Ascii.SO;
                }
                break;
        }
        switch (b) {
            case 0:
                if (!TextUtils.isEmpty(str2) && (udVar = this.fs.get(str2)) != null) {
                    udVar.mml(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 1:
                if (!TextUtils.isEmpty(str2) && (udVar2 = this.fs.get(str2)) != null) {
                    udVar2.lnr(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 2:
                if (!TextUtils.isEmpty(str2) && this.fs.get(str2) == null) {
                    ud udVar7 = new ud();
                    this.fs.put(str2, udVar7);
                    udVar7.qdl(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 3:
            case 8:
            case 12:
            case 14:
                if (!TextUtils.isEmpty(str2) && (udVar3 = this.tvp.get(str2)) != null && udVar3.qdl() != ud.mzz) {
                    udVar3.ud(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.mo.qdl.qdl().bjy()) {
                        this.to = (int) (((long) this.to) + udVar3.qdl(this.rdp, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case 4:
                this.mo.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.mo.qdl.qdl().jpc()) {
                    this.wd++;
                }
                if (!TextUtils.isEmpty(str2) && this.tvp.get(str2) == null) {
                    ud udVar8 = new ud();
                    this.tvp.put(str2, udVar8);
                    udVar8.qdl(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 5:
                this.qdl.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.mo.qdl.qdl().mo()) {
                    this.lnr++;
                }
                break;
            case 6:
                if (!this.bjy.contains(str2)) {
                    if (this.bjy.size() > 50) {
                        this.bjy.subList(0, 25).clear();
                    }
                    this.bjy.add(str2);
                    this.mml.add(Long.valueOf(SystemClock.elapsedRealtime()));
                    if (com.bytedance.sdk.openadsdk.mo.qdl.qdl().wd()) {
                        this.mzz++;
                    }
                    break;
                }
                break;
            case 7:
                if (!TextUtils.isEmpty(str2) && (udVar4 = this.tvp.get(str2)) != null) {
                    udVar4.mml(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 9:
                if (!TextUtils.isEmpty(str2) && (udVar5 = this.tvp.get(str2)) != null) {
                    udVar5.lnr(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 10:
                if (!TextUtils.isEmpty(str2) && (udVar6 = this.fs.get(str2)) != null && udVar6.qdl() != ud.mzz) {
                    udVar6.ud(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.mo.qdl.qdl().rdp()) {
                        this.exu = (int) (((long) this.exu) + udVar6.qdl(this.rdp, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case 11:
                if (com.bytedance.sdk.openadsdk.mo.qdl.qdl().yt()) {
                    this.rq++;
                }
                break;
            case 13:
                this.jpc.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
        }
    }

    public JSONObject qdl(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            qdl(jSONObject2, jSONObject);
            ud(jSONObject2, jSONObject);
        } catch (Throwable th) {
            aaj.lnr(th.getMessage(), new Object[0]);
        }
        return jSONObject2;
    }

    private void qdl(String str, JSONObject jSONObject, ArrayList<Long> arrayList, int[] iArr, long j, JSONObject jSONObject2) throws JSONException {
        int size = arrayList.size() - 1;
        int i = 0;
        for (int i2 : iArr) {
            long j2 = j - (((long) i2) * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                jSONObject.put(str + i2, i);
                int iOptInt = jSONObject2.optInt(str + i2) + i;
                if (iOptInt != 0) {
                    jSONObject2.put(str + i2, iOptInt);
                }
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void qdl(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i;
        int i2;
        int i3;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        qdl("show_c_", jSONObject, this.qdl, com.bytedance.sdk.openadsdk.mo.qdl.qdl().tvp(), jElapsedRealtime, jSONObject2);
        qdl("click_c_", jSONObject, this.mml, com.bytedance.sdk.openadsdk.mo.qdl.qdl().to(), jElapsedRealtime, jSONObject2);
        qdl("v_play_c_", jSONObject, this.mo, com.bytedance.sdk.openadsdk.mo.qdl.qdl().rq(), jElapsedRealtime, jSONObject2);
        qdl("dislike_c_", jSONObject, this.jpc, com.bytedance.sdk.openadsdk.mo.qdl.qdl().jtx(), jElapsedRealtime, jSONObject2);
        if (com.bytedance.sdk.openadsdk.mo.qdl.qdl().mo() && (i3 = this.lnr) != 0) {
            jSONObject.put("show_c_s", i3);
            int iOptInt = jSONObject2.optInt("show_c_s") + this.lnr;
            if (iOptInt != 0) {
                jSONObject2.put("show_c_s", iOptInt);
            }
        }
        if (com.bytedance.sdk.openadsdk.mo.qdl.qdl().wd() && (i2 = this.mzz) != 0) {
            jSONObject.put("click_c_s", i2);
            int iOptInt2 = jSONObject2.optInt("click_c_s") + this.mzz;
            if (iOptInt2 != 0) {
                jSONObject2.put("click_c_s", iOptInt2);
            }
        }
        if (!com.bytedance.sdk.openadsdk.mo.qdl.qdl().jpc() || (i = this.wd) == 0) {
            return;
        }
        jSONObject.put("v_play_c_s", i);
        int iOptInt3 = jSONObject2.optInt("v_play_c_s") + this.wd;
        if (iOptInt3 != 0) {
            jSONObject2.put("v_play_c_s", iOptInt3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0107 A[PHI: r10 r14
  0x0107: PHI (r10v3 int) = (r10v2 int), (r10v5 int), (r10v5 int) binds: [B:34:0x00e6, B:39:0x00fa, B:41:0x00ff] A[DONT_GENERATE, DONT_INLINE]
  0x0107: PHI (r14v2 long) = (r14v1 long), (r14v4 long), (r14v4 long) binds: [B:34:0x00e6, B:39:0x00fa, B:41:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ud(org.json.JSONObject r25, org.json.JSONObject r26) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.jtx.qdl.ud(org.json.JSONObject, org.json.JSONObject):void");
    }

    public void qdl() {
        this.rdp = SystemClock.elapsedRealtime();
        this.rq = 0;
        this.mzz = 0;
        this.lnr = 0;
        this.exu = 0;
        this.to = 0;
        this.wd = 0;
    }

    public String ud() {
        return this.ud;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
    public int compareTo(qdl qdlVar) {
        return qdlVar.lnr - this.lnr;
    }
}
