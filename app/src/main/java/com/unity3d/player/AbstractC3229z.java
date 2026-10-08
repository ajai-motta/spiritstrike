package com.unity3d.player;

import android.util.Log;

/* JADX INFO: renamed from: com.unity3d.player.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractC3229z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static boolean f3342a;

    protected static void Log(int i, String str) {
        if (f3342a) {
            return;
        }
        if (i == 6) {
            Log.e("Unity", str);
        }
        if (i == 5) {
            Log.w("Unity", str);
        }
    }
}
