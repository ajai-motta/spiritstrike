package com.bykv.vk.openvk.preload.a;

/* JADX INFO: loaded from: classes2.dex */
public interface e {
    <T> T a(Class<T> cls);

    public static class a implements e {
        @Override // com.bykv.vk.openvk.preload.a.e
        public final <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
