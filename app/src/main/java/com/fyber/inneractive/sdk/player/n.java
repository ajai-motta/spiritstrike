package com.fyber.inneractive.sdk.player;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.AppEventsConstants;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.network.x;
import com.fyber.inneractive.sdk.network.z0;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.media.Position;
import com.iab.omid.library.fyber.adsession.media.VastProperties;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends f implements a {
    public static final k x = new k();
    public final com.fyber.inneractive.sdk.model.vast.b p;
    public com.fyber.inneractive.sdk.player.enums.a q;
    public boolean r;
    public final s0 s;
    public final com.fyber.inneractive.sdk.flow.endcard.k t;
    public final com.fyber.inneractive.sdk.player.ui.remote.g u;
    public final com.fyber.inneractive.sdk.flow.storepromo.b v;
    public final AtomicBoolean w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x06d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public n(android.content.Context r21, com.fyber.inneractive.sdk.response.g r22, com.fyber.inneractive.sdk.config.s0 r23, com.fyber.inneractive.sdk.external.InneractiveAdRequest r24, com.fyber.inneractive.sdk.flow.t0 r25, com.fyber.inneractive.sdk.measurement.e r26) {
        /*
            Method dump skipped, instruction units count: 2024
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.n.<init>(android.content.Context, com.fyber.inneractive.sdk.response.g, com.fyber.inneractive.sdk.config.s0, com.fyber.inneractive.sdk.external.InneractiveAdRequest, com.fyber.inneractive.sdk.flow.t0, com.fyber.inneractive.sdk.measurement.e):void");
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        boolean zA;
        String str;
        int i;
        int i2;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.response.e eVar2;
        com.fyber.inneractive.sdk.response.e eVar3;
        s0 s0Var;
        IAlog.a("IAMediaPlayerFlowManager: onPlayerStateChanged with - %s", bVar);
        p pVar = this.f;
        if (pVar != null && bVar != com.fyber.inneractive.sdk.player.enums.b.Prepared) {
            pVar.a(bVar);
        } else if (bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared && pVar != null) {
            pVar.d = true;
        }
        int i3 = d.f1260a[bVar.ordinal()];
        if (i3 == 1) {
            IAlog.a("IAMediaPlayerFlowManager: onPlayerPrepared called", new Object[0]);
            if (this.i) {
                IAlog.a("IMediaPlayerFlowManager: onPlayerPrepared is called, but object is already destroyed?? ignore", new Object[0]);
            } else {
                this.h = true;
                if (this.e != null && this.b != null && (s0Var = this.s) != null) {
                    int iIntValue = ((r0) s0Var).f.h.value().intValue();
                    boolean zA2 = f.a(this.f1498a.c(), ((com.fyber.inneractive.sdk.response.g) this.b.b).y, this.s);
                    boolean zBooleanValue = ((r0) this.s).f.f981a.booleanValue();
                    com.fyber.inneractive.sdk.measurement.f fVar = this.e;
                    if (!zA2) {
                        iIntValue = 0;
                    }
                    if (fVar.b != null) {
                        try {
                            fVar.b.loaded(zA2 ? VastProperties.createVastPropertiesForSkippableMedia(iIntValue, zBooleanValue, Position.STANDALONE) : VastProperties.createVastPropertiesForNonSkippableMedia(zBooleanValue, Position.STANDALONE));
                        } catch (Throwable th) {
                            fVar.a(th);
                        }
                    }
                }
                if (this.l != null) {
                    t0 t0Var = this.b;
                    if (t0Var == null || (eVar3 = t0Var.b) == null) {
                        zA = false;
                    } else {
                        zA = f.a(this.f1498a.c(), eVar3.y, this.s);
                        eVar3.t.setVideo(new ImpressionData.Video(zA, (int) TimeUnit.MILLISECONDS.toSeconds(this.f1498a.c())));
                    }
                    try {
                        t0 t0Var2 = this.b;
                        com.fyber.inneractive.sdk.response.g gVar = t0Var2 != null ? (com.fyber.inneractive.sdk.response.g) t0Var2.b : null;
                        u uVar = u.EVENT_READY_ON_CLIENT;
                        InneractiveAdRequest inneractiveAdRequest = this.c;
                        t0 t0Var3 = this.b;
                        JSONArray jSONArrayB = t0Var3 == null ? null : t0Var3.c.b();
                        w wVar = new w(gVar);
                        wVar.c = uVar;
                        wVar.f1220a = inneractiveAdRequest;
                        wVar.d = jSONArrayB;
                        if (this.n != null && gVar != null) {
                            IAlog.a("Video content loader: Vast load took: " + (System.currentTimeMillis() - gVar.N) + " msec", new Object[0]);
                            t0 t0Var4 = this.b;
                            if (t0Var4 == null || (eVar2 = t0Var4.b) == null || ((com.fyber.inneractive.sdk.response.g) eVar2).O == null) {
                                str = "";
                                i = 0;
                                i2 = 0;
                            } else {
                                i = ((com.fyber.inneractive.sdk.response.g) eVar2).O.i;
                                i2 = ((com.fyber.inneractive.sdk.response.g) eVar2).O.j;
                                str = ((com.fyber.inneractive.sdk.response.g) eVar2).O.f1159a;
                            }
                            String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            if (t0Var4 != null && (eVar = t0Var4.b) != null && !TextUtils.isEmpty(((com.fyber.inneractive.sdk.response.g) eVar).E)) {
                                str2 = ((com.fyber.inneractive.sdk.response.g) this.b.b).E;
                            }
                            x xVar = new x();
                            xVar.a(Integer.valueOf(this.f1498a.c() / 1000), TypedValues.TransitionType.S_DURATION).a(this.n.g, "url").a(this.n.e, "bitrate").a(TextUtils.isEmpty(this.n.d) ? "na" : this.n.d, "mime").a(this.n.f1171a, "delivery").a(Long.valueOf(System.currentTimeMillis() - gVar.N), "load_time").a(Integer.valueOf(this.k), "media_file_index").a(this.f1498a.d(), "player").a(Boolean.valueOf(zA), "is_video_skippable").a(Integer.valueOf(i), "supported_media_files").a(Integer.valueOf(i2), "total_media_files").a(str, "vast_version");
                            if (str2 != null && str2.equals("1")) {
                                xVar.a(str2, "hide_endcard");
                            }
                            wVar.f.put(xVar.f1221a);
                        }
                        wVar.a((String) null);
                    } catch (Exception unused) {
                    }
                    t tVar = (t) this.l;
                    if (!tVar.g) {
                        tVar.g = true;
                        s sVar = tVar.d;
                        if (sVar != null) {
                            sVar.c();
                        }
                    }
                }
            }
        } else if (i3 == 2) {
            IAlog.a("IAMediaPlayerFlowManager: onPlayerBuffering", new Object[0]);
        } else if (i3 == 3) {
            this.f1498a.b();
        }
        int i4 = l.f1501a[bVar.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                if (this.q.equals(com.fyber.inneractive.sdk.player.enums.a.Completed)) {
                    a(com.fyber.inneractive.sdk.player.enums.a.Restarted);
                    return;
                }
                return;
            } else {
                if (i4 != 3) {
                    return;
                }
                b(this.f1498a.c());
                a(com.fyber.inneractive.sdk.player.enums.a.Completed);
                return;
            }
        }
        com.fyber.inneractive.sdk.model.vast.b bVar2 = this.p;
        if (bVar2 == null || bVar2.m.size() == 0) {
            return;
        }
        int iC = this.f1498a.c();
        for (com.fyber.inneractive.sdk.model.vast.e eVar4 : this.p.m) {
            int i5 = -1;
            if (eVar4.c == -1) {
                if (!TextUtils.isEmpty(eVar4.b)) {
                    String str3 = eVar4.b;
                    i5 = Integer.parseInt(str3.substring(0, str3.length() - 1));
                }
                eVar4.c = (i5 * iC) / 100;
            }
        }
        Collections.sort(this.p.m, new com.fyber.inneractive.sdk.model.vast.d());
    }

    public final void b(int i) {
        com.fyber.inneractive.sdk.model.vast.b bVar = this.p;
        if (bVar == null || bVar.m.isEmpty()) {
            return;
        }
        while (this.p.m.size() > 0 && i >= ((com.fyber.inneractive.sdk.model.vast.e) this.p.m.get(0)).c) {
            com.fyber.inneractive.sdk.model.vast.e eVar = (com.fyber.inneractive.sdk.model.vast.e) this.p.m.get(0);
            String str = eVar.f1161a;
            if (!TextUtils.isEmpty(str)) {
                IAlog.a("IAVastMediaPlayerFlowManager: Firing event for type: progress", new Object[0]);
                z0.b(str);
            }
            this.p.m.remove(eVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void d() {
    }

    public final void b(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject) {
        try {
            if (this.n != null && inneractiveVideoError.getPlayerError() != InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES) {
                jSONObject.put("url", this.n.g);
                jSONObject.put("bitrate", this.n.e);
                jSONObject.put("mime", this.n.d);
                jSONObject.put("delivery", this.n.f1171a);
            }
            com.fyber.inneractive.sdk.player.controller.q qVar = this.f1498a;
            jSONObject.put("player", qVar != null ? qVar.d() : "");
            if (inneractiveVideoError.getCause() != null) {
                jSONObject.put("exception", inneractiveVideoError.getCause().getClass().getName());
                jSONObject.put("message", inneractiveVideoError.getCause().getMessage() == null ? "empty" : inneractiveVideoError.getCause().getMessage());
            }
        } catch (Exception unused) {
            IAlog.a("onReportError: Failed creating Json object from media file!", new Object[0]);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.o
    public final void a(int i) {
        int iC = this.f1498a.c();
        b(i);
        int i2 = l.b[this.q.ordinal()];
        if (i2 == 1) {
            if (this.f1498a.e != com.fyber.inneractive.sdk.player.enums.b.Buffering) {
                a(com.fyber.inneractive.sdk.player.enums.a.Started);
                com.fyber.inneractive.sdk.measurement.f fVar = this.e;
                if (fVar != null) {
                    if (fVar.b != null && !fVar.e) {
                        IAlog.a("%s impression", "OMVideo");
                        fVar.e = true;
                        try {
                            fVar.b.impressionOccurred();
                        } catch (Throwable th) {
                            fVar.a(th);
                        }
                    }
                    com.fyber.inneractive.sdk.measurement.f fVar2 = this.e;
                    long jC = this.f1498a.c();
                    float f = this.f1498a.g() ? 0.0f : 1.0f;
                    if (fVar2.c == null || fVar2.d) {
                        return;
                    }
                    fVar2.d = true;
                    IAlog.a("%s start", "OMVideo");
                    try {
                        fVar2.c.start(jC, f);
                        return;
                    } catch (Throwable th2) {
                        fVar2.a(th2);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (i > iC / 4) {
                a(com.fyber.inneractive.sdk.player.enums.a.FirstQuarter);
                com.fyber.inneractive.sdk.measurement.f fVar3 = this.e;
                if (fVar3 == null || fVar3.c == null) {
                    return;
                }
                IAlog.a("%s firstQuartile", "OMVideo");
                try {
                    fVar3.c.firstQuartile();
                    return;
                } catch (Throwable th3) {
                    fVar3.a(th3);
                    return;
                }
            }
            return;
        }
        if (i2 != 3) {
            if (i2 == 4 && i > (iC / 4) * 3) {
                a(com.fyber.inneractive.sdk.player.enums.a.ThirdPQuarter);
                com.fyber.inneractive.sdk.measurement.f fVar4 = this.e;
                if (fVar4 == null || fVar4.c == null) {
                    return;
                }
                IAlog.a("%s thirdQuartile", "OMVideo");
                try {
                    fVar4.c.thirdQuartile();
                    return;
                } catch (Throwable th4) {
                    fVar4.a(th4);
                    return;
                }
            }
            return;
        }
        if (i > iC / 2) {
            a(com.fyber.inneractive.sdk.player.enums.a.MidPoint);
            com.fyber.inneractive.sdk.measurement.f fVar5 = this.e;
            if (fVar5 == null || fVar5.c == null) {
                return;
            }
            IAlog.a("%s midpoint", "OMVideo");
            try {
                fVar5.c.midpoint();
            } catch (Throwable th5) {
                fVar5.a(th5);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.f
    public final void a(InneractiveVideoError inneractiveVideoError, JSONObject jSONObject) {
        a(this.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_ERROR);
        b(inneractiveVideoError, jSONObject);
        IAlog.f("IAMediaPlayerFlowManager: reporting error to listeners: %s", inneractiveVideoError.getPlayerError().toString());
        q qVar = this.l;
        if (qVar != null) {
            try {
                ((t) qVar).a(inneractiveVideoError, jSONObject, false);
            } catch (Exception e) {
                if (IAlog.f1642a <= 3) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.f
    public final void a(com.fyber.inneractive.sdk.response.i iVar, VideoClickOrigin videoClickOrigin, com.fyber.inneractive.sdk.model.vast.x... xVarArr) {
        if (xVarArr.length == 0) {
            IAlog.f("IAVastMediaPlayerFlowManager: eventTypes array is empty", new Object[0]);
            return;
        }
        if (iVar == null) {
            IAlog.f("IAVastMediaPlayerFlowManager: parser is null", new Object[0]);
            return;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (com.fyber.inneractive.sdk.model.vast.x xVar : xVarArr) {
            String strA = xVar.a();
            IAlog.a("IAVastMediaPlayerFlowManager: Firing events for type: %s", strA);
            List<String> listA = iVar.a(xVar);
            if (listA != null && !listA.isEmpty()) {
                arrayList.addAll(listA);
                IAlog.a("found %d events for type: %s, url: %s", Integer.valueOf(listA.size()), strA, listA.get(0));
                for (String str : listA) {
                    IAlog.a("   event url: %s", str);
                    if (!TextUtils.isEmpty(str)) {
                        IAlog.d("%s %s %s", "VAST_EVENT", xVar.a(), str);
                        IAlog.d("Tracking URLs array: %s", "VPAID", str);
                    }
                }
            } else {
                IAlog.a("IAVastMediaPlayerFlowManager: no events for type: %s", strA);
            }
            if (xVar == com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK) {
                for (Map.Entry entry : x.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String strA2 = ((m) entry.getValue()).a(this.f1498a, videoClickOrigin);
                    for (int i = 0; i < arrayList.size(); i++) {
                        String str3 = (String) arrayList.get(i);
                        if (str3.contains(str2)) {
                            arrayList.set(i, str3.replace(str2, strA2));
                        }
                    }
                }
            }
        }
        for (String str4 : arrayList) {
            if (!TextUtils.isEmpty(str4)) {
                z0.b(str4);
            }
        }
    }

    public static void a(com.fyber.inneractive.sdk.response.i iVar, com.fyber.inneractive.sdk.model.vast.x... xVarArr) {
        ArrayList<String> arrayList = new ArrayList();
        for (com.fyber.inneractive.sdk.model.vast.x xVar : xVarArr) {
            String strA = xVar.a();
            IAlog.a("IAVastMediaPlayerFlowManager: Firing events for type: %s", strA);
            List<String> listA = iVar.a(xVar);
            if (listA != null && listA.size() != 0) {
                arrayList.addAll(listA);
                IAlog.a("found %d events for type: %s", Integer.valueOf(listA.size()), strA);
                for (String str : listA) {
                    IAlog.a("   event url: %s", str);
                    if (!TextUtils.isEmpty(str)) {
                        IAlog.d("%s %s %s", "VAST_EVENT", xVar.a(), str);
                        IAlog.d("Tracking URLs array: %s", "VPAID", str);
                    }
                }
            } else {
                IAlog.a("IAVastMediaPlayerFlowManager: no events for type: %s", strA);
            }
        }
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str2)) {
                z0.b(str2);
            }
        }
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.a aVar) {
        if (this.q == aVar) {
            return;
        }
        if (aVar == com.fyber.inneractive.sdk.player.enums.a.Started) {
            this.r = false;
            if (this.w.compareAndSet(false, true)) {
                a(this.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_IMPRESSION, com.fyber.inneractive.sdk.model.vast.x.EVENT_START);
            } else {
                IAlog.a("%sreportPlayStartEvents called, but start events was already reported", IAlog.a(this));
            }
        } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.FirstQuarter) {
            a(this.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_FIRSTQ);
        } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.MidPoint) {
            a(this.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_MID);
        } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.ThirdPQuarter) {
            a(this.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_THIRDQ);
        } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.Completed && !this.r) {
            this.r = true;
            a(this.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_COMPLETE);
        } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.Restarted) {
            a(this.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_REWIND);
        } else if (aVar == com.fyber.inneractive.sdk.player.enums.a.Progress) {
            a(this.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_PROGRESS);
        }
        this.q = aVar;
    }
}
