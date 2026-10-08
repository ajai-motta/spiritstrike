package com.bytedance.adsdk.ugeno.qdl;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class lnr {
    private String jpc;
    private int lnr;
    private String mml;
    private qdl mo;
    private long mzz;
    private Map<String, TreeMap<Float, String>> qdl;
    private JSONObject to;
    private int tvp = 1;
    private long ud;
    private String wd;

    public static class qdl {
        public String qdl;
        public String ud;
    }

    public JSONObject qdl() {
        return this.to;
    }

    public void qdl(JSONObject jSONObject) {
        this.to = jSONObject;
    }

    public Map<String, TreeMap<Float, String>> ud() {
        return this.qdl;
    }

    public void qdl(Map<String, TreeMap<Float, String>> map) {
        this.qdl = map;
    }

    public long lnr() {
        return this.ud;
    }

    public void qdl(long j) {
        this.ud = j;
    }

    public int mml() {
        return this.lnr;
    }

    public void qdl(int i) {
        this.lnr = i;
    }

    public String mzz() {
        return this.mml;
    }

    public void qdl(String str) {
        this.mml = str;
    }

    public long mo() {
        return this.mzz;
    }

    public void ud(long j) {
        this.mzz = j;
    }

    public qdl wd() {
        return this.mo;
    }

    public void qdl(qdl qdlVar) {
        this.mo = qdlVar;
    }

    public String jpc() {
        return this.wd;
    }

    public void ud(String str) {
        this.wd = str;
    }

    public String tvp() {
        return this.jpc;
    }

    public void lnr(String str) {
        this.jpc = str;
    }

    public int to() {
        return this.tvp;
    }

    public void ud(int i) {
        this.tvp = i;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.qdl + ", mDuration=" + this.ud + ", mPlayCount=" + this.lnr + ", mPlayDirection=" + this.mml + ", mDelay=" + this.mzz + ", mName=" + this.jpc + ", mPlayState=" + this.tvp + ", mTransformOrigin='" + this.mo + "', mTimingFunction='" + this.wd + "'}";
    }
}
