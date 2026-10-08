package com.bytedance.sdk.component.jpc;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.bjy;
import com.google.android.exoplayer2.ExoPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
class ud implements Comparable, Runnable {
    private long lnr;
    private Thread mml = null;
    private jpc qdl;
    private qdl ud;

    private void qdl(String str, String str2, long j) {
    }

    public ud(jpc jpcVar, qdl qdlVar) {
        this.lnr = 0L;
        this.qdl = jpcVar;
        this.ud = qdlVar;
        this.lnr = SystemClock.uptimeMillis();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // java.lang.Runnable
    public void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.lnr;
        this.mml = Thread.currentThread();
        jpc jpcVar = this.qdl;
        if (jpcVar != null) {
            jpcVar.run();
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        if (this.ud != null) {
            mml.qdl();
        }
        if (bjy.qdl()) {
            qdl qdlVar = this.ud;
            if (qdlVar != null) {
                qdlVar.qdl();
            }
            Long.valueOf(j);
            Long.valueOf(jUptimeMillis2);
            jpc jpcVar2 = this.qdl;
            if (jpcVar2 != null) {
                jpcVar2.getName();
            }
            String strQdl = this.ud.qdl();
            strQdl.hashCode();
            byte b = -1;
            switch (strQdl.hashCode()) {
                case 3107:
                    if (strQdl.equals("ad")) {
                        b = 0;
                    }
                    break;
                case 3366:
                    if (strQdl.equals("io")) {
                        b = 1;
                    }
                    break;
                case 107332:
                    if (strQdl.equals("log")) {
                        b = 2;
                    }
                    break;
                case 3237136:
                    if (strQdl.equals("init")) {
                        b = 3;
                    }
                    break;
                case 212371911:
                    if (strQdl.equals("computation")) {
                        b = 4;
                    }
                    break;
            }
            String name = AbstractJsonLexerKt.NULL;
            switch (b) {
                case 0:
                case 3:
                    if (jUptimeMillis2 > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
                        qdl qdlVar2 = this.ud;
                        String strQdl2 = qdlVar2 != null ? qdlVar2.qdl() : AbstractJsonLexerKt.NULL;
                        jpc jpcVar3 = this.qdl;
                        if (jpcVar3 != null) {
                            name = jpcVar3.getName();
                        }
                        qdl(strQdl2, name, jUptimeMillis2);
                    }
                    break;
                case 1:
                    if (jUptimeMillis2 > 5000) {
                        qdl qdlVar3 = this.ud;
                        String strQdl3 = qdlVar3 != null ? qdlVar3.qdl() : AbstractJsonLexerKt.NULL;
                        jpc jpcVar4 = this.qdl;
                        if (jpcVar4 != null) {
                            name = jpcVar4.getName();
                        }
                        qdl(strQdl3, name, jUptimeMillis2);
                    }
                    break;
                case 2:
                    if (jUptimeMillis2 > 3000) {
                        qdl qdlVar4 = this.ud;
                        String strQdl4 = qdlVar4 != null ? qdlVar4.qdl() : AbstractJsonLexerKt.NULL;
                        jpc jpcVar5 = this.qdl;
                        if (jpcVar5 != null) {
                            name = jpcVar5.getName();
                        }
                        qdl(strQdl4, name, jUptimeMillis2);
                    }
                    break;
                case 4:
                    if (jUptimeMillis2 > 1000) {
                        qdl qdlVar5 = this.ud;
                        String strQdl5 = qdlVar5 != null ? qdlVar5.qdl() : AbstractJsonLexerKt.NULL;
                        jpc jpcVar6 = this.qdl;
                        if (jpcVar6 != null) {
                            name = jpcVar6.getName();
                        }
                        qdl(strQdl5, name, jUptimeMillis2);
                    }
                    break;
            }
        }
    }

    public jpc qdl() {
        return this.qdl;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof ud) {
            return this.qdl.compareTo(((ud) obj).qdl());
        }
        return 0;
    }

    public int hashCode() {
        return this.qdl.hashCode();
    }

    public boolean equals(Object obj) {
        jpc jpcVar;
        return (obj instanceof ud) && (jpcVar = this.qdl) != null && jpcVar.equals(((ud) obj).qdl());
    }
}
