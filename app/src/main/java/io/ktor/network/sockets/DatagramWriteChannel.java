package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: Datagram.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lio/ktor/network/sockets/DatagramWriteChannel;", "", "Lio/ktor/network/sockets/Datagram;", "datagram", "", "send", "(Lio/ktor/network/sockets/Datagram;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "getOutgoing", "()Lkotlinx/coroutines/channels/SendChannel;", "outgoing", "ktor-network"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DatagramWriteChannel {
    SendChannel<Datagram> getOutgoing();

    Object send(Datagram datagram, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: Datagram.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object send(DatagramWriteChannel datagramWriteChannel, Datagram datagram, Continuation<? super Unit> continuation) {
            Object objSend = datagramWriteChannel.getOutgoing().send(datagram, continuation);
            return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
        }
    }
}
