package com.fyber.inneractive.sdk.config.enums;

import com.adxcorp.ads.mediation.util.ReportUtil;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public enum UnitDisplayType {
    INTERSTITIAL(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, false),
    LANDSCAPE("landscape", true),
    MRECT("mrect", false),
    BANNER(ReportUtil.INVENTORY_TYPE_BANNER, false),
    REWARDED("rewarded", false),
    NATIVE("typenative", false),
    SQUARE("square", true),
    VERTICAL("vertical", true),
    DEFAULT("default", false);

    private static final Map<String, UnitDisplayType> CONSTANTS = new HashMap();
    private final boolean deprecated;
    private String stringValue;

    static {
        for (UnitDisplayType unitDisplayType : values()) {
            CONSTANTS.put(unitDisplayType.stringValue, unitDisplayType);
        }
    }

    UnitDisplayType(String str, boolean z) {
        this.stringValue = str;
        this.deprecated = z;
    }

    public static UnitDisplayType fromValue(String str) {
        UnitDisplayType unitDisplayType = str != null ? CONSTANTS.get(str.toLowerCase(Locale.US)) : null;
        return unitDisplayType != null ? unitDisplayType : DEFAULT;
    }

    public boolean isDeprecated() {
        return this.deprecated;
    }

    public boolean isFullscreenUnit() {
        return this == INTERSTITIAL || this == REWARDED;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.stringValue;
    }

    public String value() {
        return this.stringValue;
    }
}
