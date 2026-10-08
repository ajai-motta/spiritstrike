package com.hive.iapv4;

import com.hive.ResultAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IapException.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eB%\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0006\u0010\u000fB-\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0006\u0010\u0010R$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/hive/iapv4/IapException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "result", "Lcom/hive/ResultAPI;", "e", "<init>", "(Lcom/hive/ResultAPI;Ljava/lang/Exception;)V", "resultCode", "", "code", "Lcom/hive/ResultAPI$Code;", "resultMsg", "", "(ILcom/hive/ResultAPI$Code;Ljava/lang/String;)V", "(ILcom/hive/ResultAPI$Code;Ljava/lang/Exception;)V", "(ILcom/hive/ResultAPI$Code;Ljava/lang/String;Ljava/lang/Exception;)V", "value", "iapResult", "getIapResult", "()Lcom/hive/ResultAPI;", "setIapResult$hive_iapv4_base_release", "(Lcom/hive/ResultAPI;)V", "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IapException extends Exception {
    private ResultAPI iapResult;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IapException(ResultAPI result) {
        this(result, (Exception) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        Intrinsics.checkNotNullParameter(result, "result");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IapException(ResultAPI result, Exception exc) {
        super(result.getMessage(), exc);
        Intrinsics.checkNotNullParameter(result, "result");
        this.iapResult = result;
    }

    public /* synthetic */ IapException(ResultAPI resultAPI, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(resultAPI, (i & 2) != 0 ? null : exc);
    }

    public final ResultAPI getIapResult() {
        return this.iapResult;
    }

    public final void setIapResult$hive_iapv4_base_release(ResultAPI resultAPI) {
        Intrinsics.checkNotNullParameter(resultAPI, "<set-?>");
        this.iapResult = resultAPI;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IapException(int i, ResultAPI.Code code, String resultMsg) {
        this(new ResultAPI(i, code, resultMsg), (Exception) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IapException(int i, ResultAPI.Code code, Exception e) {
        this(new ResultAPI(i, code, e.toString()), e);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IapException(int i, ResultAPI.Code code, String resultMsg, Exception e) {
        this(new ResultAPI(i, code, resultMsg), e);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
        Intrinsics.checkNotNullParameter(e, "e");
    }
}
