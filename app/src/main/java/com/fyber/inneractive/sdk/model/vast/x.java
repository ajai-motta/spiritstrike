package com.fyber.inneractive.sdk.model.vast;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public enum x {
    EVENT_FINAL_RETURN("finalReturn"),
    EVENT_IMPRESSION("impression"),
    EVENT_START(TtmlNode.START),
    EVENT_FIRSTQ("firstQuartile"),
    EVENT_MID("midpoint"),
    EVENT_THIRDQ("thirdQuartile"),
    EVENT_COMPLETE("complete"),
    EVENT_MUTE("mute"),
    EVENT_UNMUTE("unmute"),
    EVENT_PAUSE("pause"),
    EVENT_RESUME("resume"),
    EVENT_FULLSCREEN("fullscreen"),
    EVENT_EXIT_FULLSCREEN("exitFullscreen"),
    EVENT_CREATIVE_VIEW("creativeView"),
    EVENT_CLICK("click"),
    EVENT_ERROR("error"),
    EVENT_REWIND("rewind"),
    EVENT_CLOSE("close"),
    EVENT_VERIFICATION_NOT_EXECUTED("verificationNotExecuted"),
    EVENT_EXPAND(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n.e),
    EVENT_COLLAPSE("collapse"),
    EVENT_CLOSE_LINEAR("closeLinear"),
    EVENT_PROGRESS("progress"),
    EVENT_SKIP("skip"),
    UNKNOWN("UnkownEvent");

    private static final Map<String, x> sEventsMap = new HashMap();
    private final String mKey;

    static {
        for (x xVar : values()) {
            sEventsMap.put(xVar.mKey, xVar);
        }
    }

    x(String str) {
        this.mKey = str;
    }

    public final String a() {
        return this.mKey;
    }

    public static x a(String str) {
        Map<String, x> map = sEventsMap;
        return map.containsKey(str) ? map.get(str) : UNKNOWN;
    }
}
