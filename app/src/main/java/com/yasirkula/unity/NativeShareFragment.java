package com.yasirkula.unity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class NativeShareFragment extends Fragment {
    public static final String FILES_ID = "NS_FILES";
    public static final String MIMES_ID = "NS_MIMES";
    private static final int SHARE_RESULT_CODE = 774457;
    public static final String SUBJECT_ID = "NS_SUBJECT";
    public static final String TARGET_CLASS_ID = "NS_TARGET_CLASS";
    public static final String TARGET_PACKAGE_ID = "NS_TARGET_PACKAGE";
    public static final String TEXT_ID = "NS_TEXT";
    public static final String TITLE_ID = "NS_TITLE";

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (NativeShare.shareResultReceiver == null) {
            getFragmentManager().beginTransaction().remove(this).commit();
        } else {
            startActivityForResult(Intent.createChooser(NativeShare.CreateIntentFromBundle(getActivity(), getArguments()), getArguments().getString(TITLE_ID), NativeShareBroadcastListener.Initialize(getActivity())), SHARE_RESULT_CODE);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != SHARE_RESULT_CODE) {
            return;
        }
        if (NativeShare.shareResultReceiver != null) {
            StringBuilder sb = new StringBuilder("Reported share result (may not be correct): ");
            sb.append(i2 == -1);
            Log.d("Unity", sb.toString());
            if (i2 == -1) {
                NativeShare.shareResultReceiver.OnShareCompleted(1, "");
            } else {
                NativeShare.shareResultReceiver.OnShareCompleted(2, "");
            }
        } else {
            Log.e("Unity", "NativeShareResultReceiver was null!");
        }
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
