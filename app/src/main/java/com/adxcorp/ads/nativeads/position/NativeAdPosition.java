package com.adxcorp.ads.nativeads.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class NativeAdPosition {

    public static class ServerPosition {
    }

    static ClientPosition clone(ClientPosition clientPosition) {
        ClientPosition clientPosition2 = new ClientPosition();
        clientPosition2.mFixedPositions.addAll(clientPosition.mFixedPositions);
        clientPosition2.mRepeatInterval = clientPosition.mRepeatInterval;
        return clientPosition2;
    }

    public static ClientPosition clientPositioning() {
        return new ClientPosition();
    }

    public static ServerPosition serverPositioning() {
        return new ServerPosition();
    }

    public static class ClientPosition {
        public static final int NO_REPEAT = Integer.MAX_VALUE;
        private final ArrayList<Integer> mFixedPositions = new ArrayList<>();
        private int mRepeatInterval = Integer.MAX_VALUE;

        public ClientPosition addFixedPosition(int i) {
            int iBinarySearch;
            if (i >= 0 && (iBinarySearch = Collections.binarySearch(this.mFixedPositions, Integer.valueOf(i))) < 0) {
                this.mFixedPositions.add(~iBinarySearch, Integer.valueOf(i));
            }
            return this;
        }

        public List<Integer> getFixedPositions() {
            return this.mFixedPositions;
        }

        public ClientPosition enableRepeatingPositions(int i) {
            if (i <= 1) {
                this.mRepeatInterval = Integer.MAX_VALUE;
                return this;
            }
            this.mRepeatInterval = i;
            return this;
        }

        public int getRepeatingInterval() {
            return this.mRepeatInterval;
        }
    }
}
