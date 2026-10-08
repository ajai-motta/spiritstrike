package com.unity3d.services.core.configuration;

/* JADX INFO: loaded from: classes6.dex */
public enum PrivacyConfigStatus {
    UNKNOWN,
    ALLOWED,
    DENIED;

    public String toLowerCase() {
        return name().toLowerCase();
    }
}
