package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzve extends IllegalArgumentException {
    zzve(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
