package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes5.dex */
public interface EciesAeadHkdfDemHelper {
    Aead getAead(final byte[] symmetricKeyValue) throws GeneralSecurityException;

    int getSymmetricKeySizeInBytes();
}
