package com.unity3d.scar.adapter.common.signals;

/* JADX INFO: loaded from: classes6.dex */
public interface ISignalCallbackListener<T> {
    void onFailure(String str);

    void onSuccess(String str, String str2, T t);
}
