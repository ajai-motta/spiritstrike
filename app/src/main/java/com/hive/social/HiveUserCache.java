package com.hive.social;

import com.google.android.gms.common.Scopes;
import com.hive.SocialHive;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u0006R'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/hive/social/HiveUserCache;", "", "<init>", "()V", "uidToProfile", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/hive/SocialHive$ProfileHive;", "getUidToProfile", "()Ljava/util/concurrent/ConcurrentHashMap;", "uidToProfile$delegate", "Lkotlin/Lazy;", "vidToUid", "getVidToUid", "vidToUid$delegate", "allUsers", "", "getAllUsers", "()[Lcom/hive/SocialHive$ProfileHive;", "addProfile", "", Scopes.PROFILE, "addProfiles", "profileList", "", "getProfileByVID", "vid", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveUserCache {
    public static final HiveUserCache INSTANCE = new HiveUserCache();

    /* JADX INFO: renamed from: uidToProfile$delegate, reason: from kotlin metadata */
    private static final Lazy uidToProfile = LazyKt.lazy(new Function0() { // from class: com.hive.social.HiveUserCache$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HiveUserCache.uidToProfile_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: vidToUid$delegate, reason: from kotlin metadata */
    private static final Lazy vidToUid = LazyKt.lazy(new Function0() { // from class: com.hive.social.HiveUserCache$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return HiveUserCache.vidToUid_delegate$lambda$1();
        }
    });

    private HiveUserCache() {
    }

    private final ConcurrentHashMap<String, SocialHive.ProfileHive> getUidToProfile() {
        return (ConcurrentHashMap) uidToProfile.getValue();
    }

    private final ConcurrentHashMap<String, String> getVidToUid() {
        return (ConcurrentHashMap) vidToUid.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap uidToProfile_delegate$lambda$0() {
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap vidToUid_delegate$lambda$1() {
        return new ConcurrentHashMap();
    }

    public final void addProfile(SocialHive.ProfileHive profile) {
        String uid;
        if (profile == null || (uid = profile.getUid()) == null) {
            return;
        }
        if (StringsKt.isBlank(uid)) {
            uid = null;
        }
        if (uid != null) {
            HiveUserCache hiveUserCache = INSTANCE;
            hiveUserCache.getUidToProfile().put(uid, profile);
            String vid = profile.getVid();
            if (vid != null) {
                String str = StringsKt.isBlank(vid) ? null : vid;
                if (str != null) {
                    hiveUserCache.getVidToUid().put(str, uid);
                }
            }
        }
    }

    public final void addProfiles(List<SocialHive.ProfileHive> profileList) {
        Intrinsics.checkNotNullParameter(profileList, "profileList");
        Iterator<SocialHive.ProfileHive> it = profileList.iterator();
        while (it.hasNext()) {
            addProfile(it.next());
        }
    }

    public final SocialHive.ProfileHive[] getAllUsers() {
        Collection<SocialHive.ProfileHive> collectionValues = getUidToProfile().values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        return (SocialHive.ProfileHive[]) collectionValues.toArray(new SocialHive.ProfileHive[0]);
    }

    public final SocialHive.ProfileHive getProfileByVID(String vid) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        String str = getVidToUid().get(vid);
        if (str != null) {
            return INSTANCE.getUidToProfile().get(str);
        }
        return null;
    }
}
