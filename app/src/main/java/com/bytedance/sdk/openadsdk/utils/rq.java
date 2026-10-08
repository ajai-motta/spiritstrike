package com.bytedance.sdk.openadsdk.utils;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Pair;
import androidx.core.view.GravityCompat;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes3.dex */
public class rq {
    private static final Map<String, Pair<? extends Drawable, Integer>> qdl = new HashMap();
    private static Integer ud = null;

    public static Drawable qdl(Context context, String str) {
        return qdl(context, str, true);
    }

    public static Drawable qdl(Context context, String str, boolean z) {
        Pair<? extends Drawable, Integer> pair;
        ud = Integer.valueOf(com.bytedance.sdk.openadsdk.core.yt.mml().exu());
        "drawable name is: ".concat(String.valueOf(str));
        Map<String, Pair<? extends Drawable, Integer>> map = qdl;
        Integer.valueOf(map.size());
        if (map.containsKey(str) && (pair = map.get(str)) != null) {
            Drawable drawable = (Drawable) pair.first;
            map.put(str, new Pair<>(drawable, Integer.valueOf(((Integer) pair.second).intValue() + 1)));
            return drawable;
        }
        qdl();
        return qdl(str, context, z);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Drawable qdl(String str, Context context, boolean z) {
        byte b;
        Drawable layerDrawable;
        Drawable drawableQdl;
        str.hashCode();
        switch (str.hashCode()) {
            case -2137782317:
                b = !str.equals("tt_leftbackicon_selector_for_dark") ? (byte) -1 : (byte) 0;
                break;
            case -2023672829:
                b = !str.equals("tt_dislike_dialog_bg") ? (byte) -1 : (byte) 1;
                break;
            case -2010340681:
                b = !str.equals("tt_leftbackbutton_titlebar_photo_preview") ? (byte) -1 : (byte) 2;
                break;
            case -1888785259:
                b = !str.equals("tt_seek_progress") ? (byte) -1 : (byte) 3;
                break;
            case -1883903877:
                b = !str.equals("tt_dislike_middle_seletor") ? (byte) -1 : (byte) 4;
                break;
            case -1881901373:
                b = !str.equals("tt_ad_cover_btn_begin_bg") ? (byte) -1 : (byte) 5;
                break;
            case -1818605128:
                b = !str.equals("tt_leftbackicon_selector") ? (byte) -1 : (byte) 6;
                break;
            case -1724866088:
                b = !str.equals("tt_seek_thumb_normal") ? (byte) -1 : (byte) 7;
                break;
            case -1698792361:
                b = !str.equals("tt_stop_movebar_textpage") ? (byte) -1 : (byte) 8;
                break;
            case -1500492368:
                b = !str.equals("tt_backup_btn_1") ? (byte) -1 : (byte) 9;
                break;
            case -1308443384:
                b = !str.equals("tt_ad_report_info_bg") ? (byte) -1 : (byte) 10;
                break;
            case -1222892514:
                b = !str.equals("tt_playable_btn_bk") ? (byte) -1 : Ascii.VT;
                break;
            case -1163545839:
                b = !str.equals("tt_dislike_bottom_seletor") ? (byte) -1 : Ascii.FF;
                break;
            case -1150582740:
                b = !str.equals("tt_seek_thumb_fullscreen") ? (byte) -1 : Ascii.CR;
                break;
            case -1147412691:
                b = !str.equals("tt_custom_dialog_bg") ? (byte) -1 : Ascii.SO;
                break;
            case -1107858393:
                b = !str.equals("tt_ad_loading_three_mid") ? (byte) -1 : Ascii.SI;
                break;
            case -876774215:
                b = !str.equals("tt_close_move_detail") ? (byte) -1 : Ascii.DLE;
                break;
            case -875200849:
                b = !str.equals("tt_mute_btn_bg") ? (byte) -1 : (byte) 17;
                break;
            case -847552402:
                b = !str.equals("tt_seek_thumb") ? (byte) -1 : Ascii.DC2;
                break;
            case -561153052:
                b = !str.equals("tt_reward_countdown_bg") ? (byte) -1 : (byte) 19;
                break;
            case -508263579:
                b = !str.equals("tt_play_movebar_textpage") ? (byte) -1 : Ascii.DC4;
                break;
            case -473198695:
                b = !str.equals("tt_refreshing_video_textpage") ? (byte) -1 : Ascii.NAK;
                break;
            case -404284879:
                b = !str.equals("tt_playable_progress_style") ? (byte) -1 : Ascii.SYN;
                break;
            case -292612462:
                b = !str.equals("tt_seek_thumb_fullscreen_selector") ? (byte) -1 : Ascii.ETB;
                break;
            case -226695937:
                b = !str.equals("tt_ad_landing_loading_three_mid") ? (byte) -1 : Ascii.CAN;
                break;
            case -154809169:
                b = !str.equals("tt_pangle_ad_mute_btn_bg") ? (byte) -1 : Ascii.EM;
                break;
            case -97103333:
                b = !str.equals("tt_video_black_desc_gradient") ? (byte) -1 : Ascii.SUB;
                break;
            case 16094728:
                b = !str.equals("tt_ad_loading_three_left") ? (byte) -1 : Ascii.ESC;
                break;
            case 27541452:
                b = !str.equals("tt_mute_wrapper") ? (byte) -1 : Ascii.FS;
                break;
            case 57270120:
                b = !str.equals("tt_dislike_top_bg") ? (byte) -1 : Ascii.GS;
                break;
            case 106179457:
                b = !str.equals("tt_comment_tv") ? (byte) -1 : Ascii.RS;
                break;
            case 242455215:
                b = !str.equals("tt_reward_full_new_bar_bg") ? (byte) -1 : Ascii.US;
                break;
            case 247520514:
                b = !str.equals("tt_reward_full_video_backup_btn_bg") ? (byte) -1 : (byte) 32;
                break;
            case 310787585:
                b = !str.equals("tt_full_reward_loading_progress_style") ? (byte) -1 : (byte) 33;
                break;
            case 314734139:
                b = !str.equals("tt_detail_video_btn_bg") ? (byte) -1 : (byte) 34;
                break;
            case 410262782:
                b = !str.equals("tt_pangle_banner_btn_bg") ? (byte) -1 : (byte) 35;
                break;
            case 484030064:
                b = !str.equals("tt_seek_thumb_fullscreen_press") ? (byte) -1 : (byte) 36;
                break;
            case 494589792:
                b = !str.equals("tt_browser_download_selector") ? (byte) -1 : (byte) 37;
                break;
            case 504597563:
                b = !str.equals("tt_ad_loading_three_right") ? (byte) -1 : (byte) 38;
                break;
            case 507305701:
                b = !str.equals("tt_pangle_btn_bg") ? (byte) -1 : (byte) 39;
                break;
            case 708409173:
                b = !str.equals("tt_privacy_progress_style") ? (byte) -1 : (byte) 40;
                break;
            case 991946046:
                b = !str.equals("tt_privacy_btn_bg") ? (byte) -1 : (byte) 41;
                break;
            case 1054661938:
                b = !str.equals("tt_seek_thumb_press") ? (byte) -1 : (byte) 42;
                break;
            case 1094767909:
                b = !str.equals("tt_unmute_wrapper") ? (byte) -1 : (byte) 43;
                break;
            case 1115144587:
                b = !str.equals("tt_titlebar_close_seletor_for_dark") ? (byte) -1 : (byte) 44;
                break;
            case 1193160467:
                b = !str.equals("tt_ad_landing_loading_three_right") ? (byte) -1 : (byte) 45;
                break;
            case 1234814491:
                b = !str.equals("tt_landingpage_loading_text_rect") ? (byte) -1 : (byte) 46;
                break;
            case 1241312517:
                b = !str.equals("tt_shadow_btn_back_withoutnight") ? (byte) -1 : (byte) 47;
                break;
            case 1360033453:
                b = !str.equals("tt_circle_solid_mian") ? (byte) -1 : (byte) 48;
                break;
            case 1391934389:
                b = !str.equals("tt_browser_progress_style") ? (byte) -1 : (byte) 49;
                break;
            case 1459143575:
                b = !str.equals("tt_download_corner_bg") ? (byte) -1 : (byte) 50;
                break;
            case 1473061455:
                b = !str.equals("tt_ad_report_info_button_bg") ? (byte) -1 : (byte) 51;
                break;
            case 1562327088:
                b = !str.equals("tt_ad_landing_loading_three_left") ? (byte) -1 : (byte) 52;
                break;
            case 1635801742:
                b = !str.equals("tt_pangle_ad_close_btn_bg") ? (byte) -1 : (byte) 53;
                break;
            case 1733712735:
                b = !str.equals("tt_lefterbackicon_titlebar_press_wrapper") ? (byte) -1 : (byte) 54;
                break;
            case 1859118378:
                b = !str.equals("tt_reward_video_download_btn_bg") ? (byte) -1 : (byte) 55;
                break;
            case 1908435428:
                b = !str.equals("tt_ad_loading_rect") ? (byte) -1 : (byte) 56;
                break;
            case 1967077738:
                b = !str.equals("tt_shadow_btn_back") ? (byte) -1 : (byte) 57;
                break;
            case 1986221289:
                b = !str.equals("tt_dislike_top_seletor") ? (byte) -1 : (byte) 58;
                break;
            case 1987199879:
                b = !str.equals("tt_video_loading_progress_bar") ? (byte) -1 : (byte) 59;
                break;
            case 1995246663:
                b = !str.equals("tt_ad_skip_btn_bg2") ? (byte) -1 : (byte) 60;
                break;
            case 2051103617:
                b = !str.equals("tt_privacy_webview_bg") ? (byte) -1 : Base64.padSymbol;
                break;
            case 2091139328:
                b = !str.equals("tt_titlebar_close_seletor") ? (byte) -1 : (byte) 62;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                drawableQdl = qdl(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_lefterbackicon_titlebar_press_for_dark"), com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_lefterbackicon_titlebar_for_dark"));
                break;
            case 1:
                drawableQdl = qdl(0, -1, new int[]{ax.ud(context, 8.0f)}, null, null, null);
                break;
            case 2:
                drawableQdl = qdl(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_white_lefterbackicon_titlebar_press"), com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_white_lefterbackicon_titlebar"));
                break;
            case 3:
                layerDrawable = new LayerDrawable(new Drawable[]{qdl(0, Integer.valueOf(Color.parseColor("#A5FFFFFF")), new int[]{ax.ud(context, 1.5f)}, new int[]{-1, ax.ud(context, 1.0f)}, null, null), new ClipDrawable(qdl(0, -1, new int[]{ax.ud(context, 1.5f)}, new int[]{-1, ax.ud(context, 1.0f)}, null, null), GravityCompat.START, 1), new ClipDrawable(qdl(0, Integer.valueOf(Color.parseColor("#fff85959")), new int[]{ax.ud(context, 1.5f)}, new int[]{-1, ax.ud(context, 1.0f)}, null, null), GravityCompat.START, 1)});
                drawableQdl = layerDrawable;
                break;
            case 4:
                drawableQdl = qdl(qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_fde6e6e6")), null, null, null, null), qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_fdffffff")), null, null, null, null));
                break;
            case 5:
                drawableQdl = qdl(qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_2a90d7")), new int[]{ax.ud(context, 6.0f)}, null, Integer.valueOf(ax.ud(context, 1.0f)), Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "@color/tt_7f2a90d7"))), qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_2a90d7")), new int[]{ax.ud(context, 6.0f)}, null, Integer.valueOf(ax.ud(context, 1.0f)), Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "@color/tt_2a90d7"))));
                break;
            case 6:
                drawableQdl = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_lefterbackicon_titlebar");
                break;
            case 7:
                drawableQdl = qdl(1, -1, null, new int[]{ax.ud(context, 15.0f), ax.ud(context, 15.0f)}, Integer.valueOf(ax.ud(context, 1.0f)), 0);
                break;
            case 8:
                drawableQdl = qdl(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_new_pause_video_press"), com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_new_pause_video"));
                break;
            case 9:
                drawableQdl = qdl(qdl(0, Integer.valueOf(Color.parseColor("#33f32830")), new int[]{ax.ud(context, 4.0f)}, null, null, null), qdl(0, Integer.valueOf(Color.parseColor("#f32830")), new int[]{ax.ud(context, 4.0f)}, null, null, null));
                break;
            case 10:
                drawableQdl = qdl(0, -1, new int[]{ax.ud(context, 12.0f), ax.ud(context, 12.0f), 0, 0}, null, null, null);
                break;
            case 11:
                drawableQdl = qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_00000000")), new int[]{ax.ud(context, 30.0f)}, null, Integer.valueOf(ax.ud(context, 1.0f)), -1);
                break;
            case 12:
                drawableQdl = qdl(qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_fde6e6e6")), new int[]{0, 0, ax.ud(context, 5.0f), ax.ud(context, 5.0f)}, null, null, null), qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_fdffffff")), new int[]{0, 0, ax.ud(context, 5.0f), ax.ud(context, 5.0f)}, null, null, null));
                break;
            case 13:
                drawableQdl = qdl(1, -1, null, new int[]{ax.ud(context, 18.0f), ax.ud(context, 18.0f)}, null, null);
                break;
            case 14:
                drawableQdl = qdl(0, -1, new int[]{ax.ud(context, 6.0f)}, null, Integer.valueOf(ax.ud(context, 0.8f)), -1);
                break;
            case 15:
                drawableQdl = qdl(0, null, null, null, Integer.valueOf(ax.ud(context, 1.5f)), -1);
                break;
            case 16:
                drawableQdl = qdl(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_close_move_details_pressed"), com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_close_move_details_normal"));
                break;
            case 17:
                drawableQdl = qdl(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{ax.ud(context, 28.0f), ax.ud(context, 28.0f)}, null, null);
                break;
            case 18:
                drawableQdl = qdl(qdl(1, -1, null, new int[]{ax.ud(context, 22.0f), ax.ud(context, 22.0f)}, Integer.valueOf(ax.ud(context, 1.0f)), 0), qdl(1, -1, null, new int[]{ax.ud(context, 15.0f), ax.ud(context, 15.0f)}, Integer.valueOf(ax.ud(context, 1.0f)), 0));
                break;
            case 19:
                drawableQdl = qdl(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{ax.ud(context, 28.0f), ax.ud(context, 28.0f)}, null, null);
                break;
            case 20:
                drawableQdl = qdl(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_new_play_video"), com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_new_play_video"));
                break;
            case 21:
                drawableQdl = qdl(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_refreshing_video_textpage_pressed"), com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_refreshing_video_textpage_normal"));
                break;
            case 22:
                layerDrawable = new LayerDrawable(new Drawable[]{qdl(0, Integer.valueOf(Color.parseColor("#4DFC625C")), new int[]{ax.ud(context, 3.0f)}, null, null, null), new ClipDrawable(qdl(0, Integer.valueOf(Color.parseColor("#FC625C")), new int[]{ax.ud(context, 3.0f)}, null, null, null), GravityCompat.START, 1)});
                drawableQdl = layerDrawable;
                break;
            case 23:
                drawableQdl = qdl(qdl(1, -1, null, new int[]{ax.ud(context, 18.0f), ax.ud(context, 18.0f)}, Integer.valueOf(ax.ud(context, 1.0f)), 0), qdl(1, -1, null, new int[]{ax.ud(context, 18.0f), ax.ud(context, 18.0f)}, Integer.valueOf(ax.ud(context, 1.0f)), 0));
                break;
            case 24:
                drawableQdl = qdl(0, null, null, null, Integer.valueOf(ax.ud(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case 25:
                drawableQdl = qdl(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{ax.ud(context, 28.0f), ax.ud(context, 28.0f)}, null, null);
                break;
            case 26:
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setGradientType(0);
                gradientDrawable.setColors(new int[]{com.bytedance.sdk.component.utils.ljh.wd(context, "tt_ff1a1a1a"), com.bytedance.sdk.component.utils.ljh.wd(context, "tt_00000000")});
                gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                layerDrawable = gradientDrawable;
                drawableQdl = layerDrawable;
                break;
            case 27:
                drawableQdl = qdl(0, null, new int[]{ax.ud(context, 6.0f), 0, 0, ax.ud(context, 6.0f)}, null, Integer.valueOf(ax.ud(context, 1.5f)), -1);
                break;
            case 28:
                Drawable drawableLnr = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_mute");
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[0], drawableLnr);
                stateListDrawable.setAutoMirrored(true);
                layerDrawable = stateListDrawable;
                drawableQdl = layerDrawable;
                break;
            case 29:
                drawableQdl = qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_fdffffff")), new int[]{ax.ud(context, 5.0f), ax.ud(context, 5.0f), 0, 0}, null, null, null);
                break;
            case 30:
                drawableQdl = qdl(0, -1, new int[]{ax.ud(context, 4.0f)}, null, Integer.valueOf(ax.ud(context, 1.0f)), Integer.valueOf(Color.parseColor("#0F161823")));
                break;
            case 31:
                drawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#ccffffff")), new int[]{ax.ud(context, 18.0f)}, null, null, null);
                break;
            case 32:
                drawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#ff0088ff")), new int[]{ax.ud(context, 6.0f)}, null, null, null);
                break;
            case 33:
                GradientDrawable gradientDrawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#EAEAEA")), new int[]{ax.ud(context, 50.0f)}, null, null, null);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(ax.ud(context, 15.0f));
                gradientDrawable2.setColors(new int[]{Color.parseColor("#1A73E8"), Color.parseColor("#569FFF")});
                gradientDrawable2.setGradientType(0);
                gradientDrawable2.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                drawableQdl = new LayerDrawable(new Drawable[]{gradientDrawableQdl, new ScaleDrawable(gradientDrawable2, GravityCompat.START, 1.0f, -1.0f)});
                break;
            case 34:
                drawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#26000000")), new int[]{ax.ud(context, 4.0f)}, null, null, null);
                break;
            case 35:
                drawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#ff2f87f8")), new int[]{ax.ud(context, 2.0f)}, new int[]{ax.ud(context, 98.0f), ax.ud(context, 25.0f)}, null, null);
                break;
            case 36:
                drawableQdl = qdl(1, -1, null, new int[]{ax.ud(context, 18.0f), ax.ud(context, 18.0f)}, Integer.valueOf(ax.ud(context, 1.0f)), 0);
                break;
            case 37:
                drawableQdl = qdl(qdl(0, Integer.valueOf(Color.parseColor("#2582c3")), null, null, null, null), qdl(0, Integer.valueOf(Color.parseColor("#2a90d7")), null, null, null, null));
                break;
            case 38:
                drawableQdl = qdl(0, null, new int[]{0, ax.ud(context, 6.0f), ax.ud(context, 6.0f), 0}, null, Integer.valueOf(ax.ud(context, 1.5f)), -1);
                break;
            case 39:
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setShape(0);
                gradientDrawable3.setSize(ax.ud(context, 280.0f), ax.ud(context, 38.0f));
                gradientDrawable3.setCornerRadius(ax.ud(context, 19.0f));
                gradientDrawable3.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable3.setColors(new int[]{Color.parseColor("#fff02d42"), Color.parseColor("#fffc4b3c")});
                gradientDrawable3.setGradientType(0);
                gradientDrawable3.setUseLevel(true);
                layerDrawable = gradientDrawable3;
                drawableQdl = layerDrawable;
                break;
            case 40:
                drawableQdl = new LayerDrawable(new Drawable[]{qdl(0, Integer.valueOf(Color.parseColor("#33007AFF")), null, null, null, null), new ClipDrawable(qdl(0, Integer.valueOf(Color.parseColor("#007AFF")), null, null, null, null), GravityCompat.START, 1)});
                break;
            case 41:
                GradientDrawable gradientDrawable4 = new GradientDrawable();
                gradientDrawable4.setShape(0);
                gradientDrawable4.setSize(ax.ud(context, 258.0f), ax.ud(context, 43.0f));
                gradientDrawable4.setCornerRadius(ax.ud(context, 22.0f));
                gradientDrawable4.setColors(new int[]{Color.parseColor("#73CBFC"), Color.parseColor("#3F9CF7")});
                gradientDrawable4.setGradientType(0);
                layerDrawable = gradientDrawable4;
                drawableQdl = layerDrawable;
                break;
            case 42:
                drawableQdl = qdl(1, -1, null, new int[]{ax.ud(context, 22.0f), ax.ud(context, 22.0f)}, Integer.valueOf(ax.ud(context, 1.0f)), 0);
                break;
            case 43:
                Drawable drawableLnr2 = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_unmute");
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[0], drawableLnr2);
                stateListDrawable2.setAutoMirrored(true);
                layerDrawable = stateListDrawable2;
                drawableQdl = layerDrawable;
                break;
            case 44:
                drawableQdl = qdl(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_titlebar_close_press_for_dark"), com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_titlebar_close_for_dark"));
                break;
            case 45:
                drawableQdl = qdl(0, null, new int[]{0, ax.ud(context, 6.0f), ax.ud(context, 6.0f), 0}, null, Integer.valueOf(ax.ud(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case 46:
                drawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#141A73E8")), new int[]{ax.ud(context, 5.0f)}, null, null, null);
                break;
            case 47:
                Drawable drawableLnr3 = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_shadow_lefterback_titlebar_press_withoutnight");
                StateListDrawable stateListDrawableQdl = qdl(drawableLnr3, com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_shadow_lefterback_titlebar_withoutnight"));
                stateListDrawableQdl.addState(new int[]{-16842910}, drawableLnr3);
                drawableQdl = stateListDrawableQdl;
                break;
            case 48:
                drawableQdl = qdl(1, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_e0e0e0")), null, null, null, null);
                break;
            case 49:
                drawableQdl = new LayerDrawable(new Drawable[]{qdl(0, -1, new int[]{0}, null, null, null), new ClipDrawable(qdl(0, Integer.valueOf(Color.parseColor("#1A73E8")), new int[]{0}, null, null, null), 3, 1)});
                break;
            case 50:
                drawableQdl = qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_4a90e2")), new int[]{ax.ud(context, 4.0f)}, null, null, null);
                break;
            case 51:
                drawableQdl = qdl(qdl(0, Integer.valueOf(Color.parseColor("#0D000000")), new int[]{ax.ud(context, 2.0f)}, null, Integer.valueOf(ax.ud(context, 1.0f)), Integer.valueOf(Color.parseColor("#1F000000"))), qdl(0, -1, new int[]{ax.ud(context, 2.0f)}, null, Integer.valueOf(ax.ud(context, 1.0f)), Integer.valueOf(Color.parseColor("#1618231F"))));
                break;
            case 52:
                drawableQdl = qdl(0, null, new int[]{ax.ud(context, 6.0f), 0, 0, ax.ud(context, 6.0f)}, null, Integer.valueOf(ax.ud(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case 53:
                drawableQdl = qdl(1, Integer.valueOf(Color.parseColor("#30333333")), null, new int[]{ax.ud(context, 28.0f), ax.ud(context, 28.0f)}, null, null);
                break;
            case 54:
                Drawable drawableLnr4 = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_lefterbackicon_titlebar_press");
                StateListDrawable stateListDrawable3 = new StateListDrawable();
                stateListDrawable3.addState(new int[0], drawableLnr4);
                stateListDrawable3.setAutoMirrored(true);
                layerDrawable = stateListDrawable3;
                drawableQdl = layerDrawable;
                break;
            case 55:
                drawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#ff007aff")), new int[]{ax.ud(context, 18.0f)}, null, null, null);
                break;
            case 56:
                drawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#33FFFFFF")), new int[]{ax.ud(context, 15.0f)}, null, null, null);
                break;
            case 57:
                Drawable drawableLnr5 = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_shadow_lefterback_titlebar_press");
                StateListDrawable stateListDrawableQdl2 = qdl(drawableLnr5, com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_shadow_lefterback_titlebar"));
                stateListDrawableQdl2.addState(new int[]{-16842910}, drawableLnr5);
                drawableQdl = stateListDrawableQdl2;
                break;
            case 58:
                drawableQdl = qdl(qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_fde6e6e6")), new int[]{ax.ud(context, 5.0f), ax.ud(context, 5.0f), 0, 0}, null, null, null), qdl(0, Integer.valueOf(com.bytedance.sdk.component.utils.ljh.wd(context, "tt_fdffffff")), new int[]{ax.ud(context, 5.0f), ax.ud(context, 5.0f), 0, 0}, null, null, null));
                break;
            case 59:
                RotateDrawable rotateDrawable = new RotateDrawable();
                rotateDrawable.setDrawable(com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_normalscreen_loading"));
                rotateDrawable.setFromDegrees(0.0f);
                rotateDrawable.setToDegrees(360.0f);
                rotateDrawable.setPivotX(0.5f);
                rotateDrawable.setPivotY(0.5f);
                layerDrawable = rotateDrawable;
                drawableQdl = layerDrawable;
                break;
            case 60:
                drawableQdl = qdl(0, Integer.valueOf(Color.parseColor("#66161823")), new int[]{ax.ud(context, 14.0f)}, null, null, null);
                break;
            case 61:
                drawableQdl = qdl(0, -1, new int[]{ax.ud(context, 14.5f)}, null, null, null);
                break;
            case 62:
                drawableQdl = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_titlebar_close_drawable");
                break;
            default:
                drawableQdl = null;
                break;
        }
        if (z) {
            qdl.put(str, new Pair<>(drawableQdl, 1));
        }
        return drawableQdl;
    }

    private static void qdl() {
        Map<String, Pair<? extends Drawable, Integer>> map = qdl;
        if (map.size() < ud.intValue()) {
            return;
        }
        String key = null;
        int iIntValue = Integer.MAX_VALUE;
        for (Map.Entry<String, Pair<? extends Drawable, Integer>> entry : map.entrySet()) {
            if (((Integer) entry.getValue().second).intValue() < iIntValue) {
                key = entry.getKey();
                iIntValue = ((Integer) entry.getValue().second).intValue();
                if (iIntValue == 1) {
                    break;
                }
            }
        }
        qdl.remove(key);
    }

    private static GradientDrawable qdl(int i, Integer num, int[] iArr, int[] iArr2, Integer num2, Integer num3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i);
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        int length = iArr != null ? iArr.length : 0;
        if (length == 1) {
            gradientDrawable.setCornerRadius(iArr[0]);
        } else if (length == 4) {
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            gradientDrawable.setCornerRadii(new float[]{i2, i2, i3, i3, i4, i4, i5, i5});
        }
        if (iArr2 != null && iArr2.length == 2) {
            gradientDrawable.setSize(iArr2[0], iArr2[1]);
        }
        if (num2 != null && num3 != null) {
            gradientDrawable.setStroke(num2.intValue(), num3.intValue());
        }
        return gradientDrawable;
    }

    private static StateListDrawable qdl(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (drawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable);
        }
        if (drawable2 != null) {
            stateListDrawable.addState(new int[0], drawable2);
        }
        return stateListDrawable;
    }

    public static Drawable qdl(Context context, int i) {
        return qdl(context, Color.parseColor("#1A73E8"), i);
    }

    public static Drawable qdl(Context context, int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(ax.ud(context, i2));
        return gradientDrawable;
    }
}
