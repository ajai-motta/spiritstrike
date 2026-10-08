package com.google.android.gms.internal.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.recaptchabase.ExecuteResult;
import com.google.android.gms.recaptchabase.InitResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-recaptchabase@@16.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zze extends IInterface {
    void zzb(Status status, ExecuteResult executeResult) throws RemoteException;

    void zzc(Status status, InitResult initResult) throws RemoteException;
}
