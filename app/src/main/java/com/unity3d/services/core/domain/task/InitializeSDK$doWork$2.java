package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeSDK.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", i = {0, 1, 2, 2, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 9, 9, 10, 11}, l = {48, 53, 58, 60, 65, 67, 71, 74, 89, 92, 100, 103, 106}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "$this$withContext", "configuration", "resetResult", "$this$withContext", "configuration", "$this$withContext", "configuration", "configResult", "$this$withContext", "configuration", "configResult", "loadCacheResult", "configResult", "configResult", "loadWebResult", "configResult", "configResult"}, s = {"L$0", "L$0", "L$0", "L$2", "L$0", "L$0", "L$2", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$1", "L$1", "L$2", "L$1", "L$1"})
final class InitializeSDK$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, continuation);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeSDK$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02e4 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x032d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0338 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0369 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0178 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0182 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c7 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e3 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f1 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0215 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x024d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0254 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0273 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0281 A[Catch: all -> 0x0380, CancellationException -> 0x03ad, TryCatch #2 {CancellationException -> 0x03ad, all -> 0x0380, blocks: (B:6:0x0017, B:129:0x036a, B:9:0x0028, B:126:0x034b, B:12:0x0033, B:121:0x0332, B:123:0x0338, B:15:0x0046, B:114:0x02f9, B:117:0x030a, B:18:0x0051, B:109:0x02de, B:111:0x02e4, B:21:0x0061, B:94:0x026d, B:96:0x0273, B:97:0x0280, B:24:0x0079, B:89:0x024e, B:91:0x0254, B:98:0x0281, B:100:0x028c, B:102:0x0296, B:104:0x029c, B:105:0x02b9, B:115:0x0304, B:130:0x0374, B:131:0x037f, B:27:0x0096, B:86:0x022b, B:30:0x00a7, B:81:0x020f, B:83:0x0215, B:33:0x00b8, B:73:0x01dd, B:75:0x01e3, B:76:0x01f0, B:36:0x00ce, B:68:0x01c1, B:70:0x01c7, B:77:0x01f1, B:39:0x00e4, B:58:0x017c, B:60:0x0182, B:61:0x0195, B:64:0x01a1, B:42:0x00f7, B:53:0x0158, B:54:0x015b, B:45:0x0105, B:47:0x0122, B:49:0x0128), top: B:144:0x000c }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 976
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
