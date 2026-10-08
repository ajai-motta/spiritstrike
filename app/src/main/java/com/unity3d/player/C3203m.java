package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Map;

/* JADX INFO: renamed from: com.unity3d.player.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3203m implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerStatusQueryCallback f3322a;
    private Looper b = Looper.myLooper();
    private String[] c;

    public C3203m(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.f3322a = iAssetPackManagerStatusQueryCallback;
        this.c = strArr;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        if (this.f3322a == null) {
            return;
        }
        int i = 0;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map mapPackStates = assetPackStates.packStates();
            int size = mapPackStates.size();
            String[] strArr = new String[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (AssetPackState assetPackState : mapPackStates.values()) {
                strArr[i] = assetPackState.name();
                iArr[i] = assetPackState.status();
                iArr2[i] = assetPackState.errorCode();
                i++;
            }
            new Handler(this.b).post(new RunnableC3201l(this.f3322a, assetPackStates.totalBytes(), strArr, iArr, iArr2));
        } catch (RuntimeExecutionException e) {
            e = e;
            String message = e.getMessage();
            String[] strArr2 = this.c;
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                int errorCode2 = -100;
                if (i2 >= length) {
                    String[] strArr3 = this.c;
                    int[] iArr3 = new int[strArr3.length];
                    int[] iArr4 = new int[strArr3.length];
                    for (int i3 = 0; i3 < this.c.length; i3++) {
                        iArr3[i3] = 0;
                        AssetPackException cause = e;
                        while (true) {
                            if (cause instanceof AssetPackException) {
                                errorCode = cause.getErrorCode();
                                break;
                            }
                            cause = cause.getCause();
                            if (cause == null) {
                                errorCode = -100;
                                break;
                            }
                        }
                        iArr4[i3] = errorCode;
                    }
                    new Handler(this.b).post(new RunnableC3201l(this.f3322a, 0L, this.c, iArr3, iArr4));
                    return;
                }
                String str = strArr2[i2];
                if (message.contains(str)) {
                    Handler handler = new Handler(this.b);
                    IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback = this.f3322a;
                    String[] strArr4 = {str};
                    int[] iArr5 = {0};
                    int[] iArr6 = new int[1];
                    while (true) {
                        if (!(e instanceof AssetPackException)) {
                            e = e.getCause();
                            if (e == null) {
                                break;
                            }
                        } else {
                            errorCode2 = e.getErrorCode();
                            break;
                        }
                    }
                    iArr6[0] = errorCode2;
                    handler.post(new RunnableC3201l(iAssetPackManagerStatusQueryCallback, 0L, strArr4, iArr5, iArr6));
                    return;
                }
                i2++;
            }
        }
    }
}
