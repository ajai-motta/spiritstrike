package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
public interface Function<F, T> {
    @ParametricNullness
    T apply(@ParametricNullness F f);

    boolean equals(@CheckForNull Object obj);
}
