package com.tnkfactory.ad.pub;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class b0 {
    protected static String ENC_ACTION_BUTTON_LABEL = "c76c0399f1579473fa";
    protected static String ENC_CLOSE_BUTTON_LABEL = "c27e0490ed49c27cff";
    protected static String ENC_EXIT_BUTTON_LABEL = "cf6004c5ef5d956de0";
    protected static String ENC_FRAME_TITLE = "c875119afe54976fe0";
    protected static String ENC_USE_WINDOW_MODE = "de7c0393ef50906ff5";
    private static String KEY_ACTION_BUTTON_LABEL = "atboxfexi";
    private static String KEY_CLOSE_BUTTON_LABEL = "dfefdx3wl";
    private static String KEY_EXIT_BUTTON_LABEL = "ixe3fldfs";
    private static String KEY_FRAME_TITLE = "nmplwefds";
    static String KEY_USE_TEST_MODE = "xdbefaadf";
    protected static b0 adStyle = new b0();
    protected Map<String, String> map = new HashMap();

    public static b0 instance() {
        return adStyle;
    }

    public String getActionButtonLabel() {
        return getString(KEY_ACTION_BUTTON_LABEL);
    }

    public boolean getBoolean(String str) {
        return "Y".equals(this.map.get(str));
    }

    public String getCloseButtonLabel() {
        return getString(KEY_CLOSE_BUTTON_LABEL);
    }

    public String getExitButtonLabel() {
        return getString(KEY_EXIT_BUTTON_LABEL);
    }

    public String getFrameTitle() {
        return getString(KEY_FRAME_TITLE);
    }

    public String getString(String str) {
        return this.map.get(str);
    }

    public String getTestCode() {
        return getString(KEY_USE_TEST_MODE);
    }

    public void set(String str, String str2) {
        this.map.put(h1.a(str), str2);
    }

    public void set(String str, boolean z) {
        set(str, z ? "Y" : "N");
    }
}
