package com.bykv.vk.openvk.qdl.qdl.qdl.lnr;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.http.ContentDisposition;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ud {
    private int exu;
    private int fs;
    private String jpc;
    private long lnr;
    private double mml;
    private String mo;
    private String mzz;
    private int qdl;
    private double rq;
    private String to;
    private String tvp;
    private int ud;
    private String wd;
    private float rdp = -1.0f;
    private int bjy = 0;
    private int jtx = 0;
    private int yt = 0;
    private int jl = 0;
    private int exc = 307200;
    private int aaj = 1;

    public int qdl() {
        return this.fs;
    }

    public void qdl(int i) {
        this.fs = i;
    }

    public int ud() {
        return this.qdl;
    }

    public void ud(int i) {
        this.qdl = i;
    }

    public int lnr() {
        return this.ud;
    }

    public void lnr(int i) {
        this.ud = i;
    }

    public int mml() {
        return this.exu;
    }

    public void mml(int i) {
        this.exu = i;
    }

    public long mzz() {
        return this.lnr;
    }

    public void qdl(long j) {
        this.lnr = j;
    }

    public double mo() {
        return this.mml;
    }

    public void qdl(double d) {
        this.mml = d;
    }

    public double wd() {
        return this.rq;
    }

    public float jpc() {
        return this.rdp;
    }

    public String tvp() {
        return this.mzz;
    }

    public void qdl(String str) {
        this.mzz = str;
    }

    public String to() {
        return this.mo;
    }

    public void ud(String str) {
        this.mo = str;
    }

    public String rq() {
        return this.wd;
    }

    public void lnr(String str) {
        this.wd = str;
    }

    public String fs() {
        return this.jpc;
    }

    public void mml(String str) {
        this.jpc = str;
    }

    public String exu() {
        return this.tvp;
    }

    public void mzz(String str) {
        this.tvp = str;
    }

    public String rdp() {
        if (TextUtils.isEmpty(this.to)) {
            this.to = com.bykv.vk.openvk.qdl.qdl.qdl.wd.ud.qdl(this.wd);
        }
        return this.to;
    }

    public void mo(String str) {
        this.to = str;
    }

    public int bjy() {
        if (this.exc < 0) {
            this.exc = 307200;
        }
        long j = this.exc;
        long j2 = this.lnr;
        if (j > j2) {
            this.exc = (int) j2;
        }
        return this.exc;
    }

    public void mzz(int i) {
        this.exc = i;
    }

    public int jtx() {
        return this.yt;
    }

    public void mo(int i) {
        this.yt = i;
    }

    public int yt() {
        return this.jl;
    }

    public void wd(int i) {
        this.jl = i;
    }

    public JSONObject jl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", ud());
            jSONObject.put("cover_url", to());
            jSONObject.put("cover_width", lnr());
            jSONObject.put("endcard", fs());
            jSONObject.put("file_hash", rdp());
            jSONObject.put("resolution", tvp());
            jSONObject.put(ContentDisposition.Parameters.Size, mzz());
            jSONObject.put("video_duration", mo());
            jSONObject.put(InneractiveRichMediaVideoPlayerActivityCore.VIDEO_URL, rq());
            jSONObject.put("playable_download_url", exu());
            jSONObject.put("if_playable_loading_show", exc());
            jSONObject.put("remove_loading_page_type", aaj());
            jSONObject.put("fallback_endcard_judge", qdl());
            jSONObject.put("video_preload_size", bjy());
            jSONObject.put("reward_video_cached_type", jtx());
            jSONObject.put("execute_cached_type", yt());
            jSONObject.put("endcard_render", mml());
            jSONObject.put("replay_time", oth());
            jSONObject.put("play_speed_ratio", jpc());
            if (wd() > 0.0d) {
                jSONObject.put(TtmlNode.START, wd());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int exc() {
        return this.bjy;
    }

    public void jpc(int i) {
        this.bjy = i;
    }

    public int aaj() {
        return this.jtx;
    }

    public void tvp(int i) {
        this.jtx = i;
    }

    public boolean jyq() {
        return this.yt == 0;
    }

    public void to(int i) {
        this.aaj = Math.min(4, Math.max(1, i));
    }

    public int oth() {
        return this.aaj;
    }
}
