package com.hive.platformhelper;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001`\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/hive/platformhelper/PlatformShare;", "", "<init>", "()V", PlatformShare.SHARE_TYPE, "", "getShareType", "()I", "setShareType", "(I)V", "shareData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "subject", "getSubject", "()Ljava/lang/String;", "setSubject", "(Ljava/lang/String;)V", "text", "getText", "setText", "media", "", "getMedia", "()[Ljava/lang/String;", "setMedia", "([Ljava/lang/String;)V", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlatformShare {
    public static final String DATA_MEDIA = "shareMedia";
    public static final String DATA_SUBJECT = "shareSubject";
    public static final String DATA_TEXT = "shareText";
    public static final int SHARE_MEDIA = 2;
    public static final int SHARE_TEXT = 1;
    public static final String SHARE_TYPE = "shareType";
    private final HashMap<String, Object> shareData = new HashMap<>();
    private int shareType;

    public final String[] getMedia() {
        Object obj = this.shareData.get(DATA_MEDIA);
        String[] strArr = obj instanceof String[] ? (String[]) obj : null;
        return strArr == null ? new String[0] : strArr;
    }

    public final int getShareType() {
        return this.shareType;
    }

    public final String getSubject() {
        Object obj = this.shareData.get(DATA_SUBJECT);
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    public final String getText() {
        Object obj = this.shareData.get(DATA_TEXT);
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    public final void setMedia(String[] media) {
        Intrinsics.checkNotNullParameter(media, "media");
        this.shareData.put(DATA_MEDIA, media);
    }

    public final void setShareType(int i) {
        this.shareType = i;
    }

    public final void setSubject(String subject) {
        Intrinsics.checkNotNullParameter(subject, "subject");
        this.shareData.put(DATA_SUBJECT, subject);
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.shareData.put(DATA_TEXT, text);
    }
}
