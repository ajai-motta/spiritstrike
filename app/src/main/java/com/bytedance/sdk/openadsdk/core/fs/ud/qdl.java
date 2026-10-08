package com.bytedance.sdk.openadsdk.core.fs.ud;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.core.fs.ud.lnr;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends lnr implements Comparable<qdl> {
    public long qdl;

    protected qdl(long j, String str, lnr.EnumC0234lnr enumC0234lnr, Boolean bool) {
        super(str, enumC0234lnr, bool);
        this.qdl = j;
    }

    public long qdl() {
        return this.qdl;
    }

    public static int qdl(String str) {
        if (TextUtils.isEmpty(str)) {
            return Integer.MIN_VALUE;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 3) {
            try {
                return (int) ((Integer.parseInt(strArrSplit[0]) * Constants.ONE_HOUR) + (Integer.parseInt(strArrSplit[1]) * 60000) + (Float.parseFloat(strArrSplit[2]) * 1000.0f));
            } catch (Throwable unused) {
            }
        }
        return Integer.MIN_VALUE;
    }

    public boolean qdl(long j) {
        return this.qdl <= j && !mzz();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
    public int compareTo(qdl qdlVar) {
        if (qdlVar == null) {
            return 1;
        }
        long j = this.qdl;
        long j2 = qdlVar.qdl;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.fs.ud.qdl$qdl, reason: collision with other inner class name */
    public static class C0235qdl {
        private lnr.EnumC0234lnr lnr = lnr.EnumC0234lnr.TRACKING_URL;
        private final String qdl;
        private final long ud;

        public C0235qdl(String str, long j) {
            this.qdl = str;
            this.ud = j;
        }

        public qdl qdl() {
            return new qdl(this.ud, this.qdl, this.lnr, Boolean.FALSE);
        }
    }

    public JSONObject ud() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", lnr());
        jSONObject.put("trackingMilliseconds", this.qdl);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
