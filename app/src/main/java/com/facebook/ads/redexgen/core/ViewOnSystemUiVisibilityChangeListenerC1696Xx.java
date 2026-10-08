package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ViewOnSystemUiVisibilityChangeListenerC1696Xx implements View.OnSystemUiVisibilityChangeListener {
    public static String[] A05 = {"dzM0rIEz66", "2I5EpQxo3JaAydz5j2evjw", "riIr", "aw8X8aEsXK", "46V10M2ortldVuyFN9G4Mh", "Zv9bhia2uUXHxfPHNrQGPj2Fgj", "UQeU", "fL70pxGMq2jlNC9xIpTd7nvL"};
    public int A00;
    public Window A01;
    public final View A03;
    public EnumC1695Xw A02 = EnumC1695Xw.A02;
    public final Runnable A04 = new QB(this);

    public ViewOnSystemUiVisibilityChangeListenerC1696Xx(View view) {
        this.A03 = view;
        this.A03.setOnSystemUiVisibilityChangeListener(this);
    }

    private void A00(int i, boolean z) {
        if (this.A01 == null) {
            return;
        }
        WindowManager.LayoutParams attributes = this.A01.getAttributes();
        if (z) {
            attributes.flags |= i;
        } else {
            int i2 = attributes.flags;
            String[] strArr = A05;
            if (strArr[0].length() != strArr[3].length()) {
                A05[5] = "Y2LIVjWWRefqfkQFwWbZLdxa4m";
                attributes.flags = i2 & (~i);
            } else {
                String[] strArr2 = A05;
                strArr2[0] = "3EQzEkO0gc";
                strArr2[3] = "SinRvB2gIw";
                attributes.flags = i2 & (~i);
            }
        }
        Window window = this.A01;
        String[] strArr3 = A05;
        if (strArr3[1].length() != strArr3[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr4 = A05;
        strArr4[1] = "fe0FngUkI8h9c1BO2CK76I";
        strArr4[4] = "nmFu9vDS7iLUjXhy5dSdRg";
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(boolean z) {
        if (EnumC1695Xw.A02.equals(this.A02)) {
            return;
        }
        int i = 3840;
        if (!z) {
            i = 3840 | 7;
        }
        Handler handler = this.A03.getHandler();
        if (handler != null && z) {
            handler.removeCallbacks(this.A04);
            handler.postDelayed(this.A04, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        this.A03.setSystemUiVisibility(i);
    }

    public final void A03() {
        this.A01 = null;
    }

    public final void A04(Window window) {
        this.A01 = window;
    }

    public final void A05(EnumC1695Xw enumC1695Xw) {
        this.A02 = enumC1695Xw;
        switch (this.A02.ordinal()) {
            case 1:
                A00(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL, true);
                A00(C.BUFFER_FLAG_FIRST_SAMPLE, true);
                A02(false);
                break;
            default:
                A00(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL, false);
                A00(C.BUFFER_FLAG_FIRST_SAMPLE, false);
                this.A03.setSystemUiVisibility(0);
                break;
        }
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        int diff = this.A00 ^ i;
        this.A00 = i;
        if ((diff & 2) != 0) {
            int i2 = i & 2;
            if (A05[5].length() != 26) {
                throw new RuntimeException();
            }
            A05[5] = "1GVM4GUQqWgiX1iklRLLb2m9Tx";
            if (i2 == 0) {
                if (A05[5].length() != 26) {
                    A02(true);
                    return;
                }
                String[] strArr = A05;
                strArr[0] = "67GBv9MjXI";
                strArr[3] = "0u8xrudpsw";
                A02(true);
            }
        }
    }
}
