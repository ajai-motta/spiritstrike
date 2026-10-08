package com.google.zxing.datamatrix.encoder;

/* JADX INFO: loaded from: classes5.dex */
final class EdifactEncoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 4;
    }

    EdifactEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            encodeChar(encoderContext.getCurrentChar(), sb);
            encoderContext.pos++;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        handleEOD(encoderContext, sb);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void handleEOD(com.google.zxing.datamatrix.encoder.EncoderContext r7, java.lang.CharSequence r8) {
        /*
            r0 = 0
            int r1 = r8.length()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto Lb
            r7.signalEncoderChange(r0)
            return
        Lb:
            r2 = 2
            r3 = 1
            if (r1 != r3) goto L42
            r7.updateSymbolInfo()     // Catch: java.lang.Throwable -> L96
            com.google.zxing.datamatrix.encoder.SymbolInfo r4 = r7.getSymbolInfo()     // Catch: java.lang.Throwable -> L96
            int r4 = r4.getDataCapacity()     // Catch: java.lang.Throwable -> L96
            int r5 = r7.getCodewordCount()     // Catch: java.lang.Throwable -> L96
            int r4 = r4 - r5
            int r5 = r7.getRemainingCharacters()     // Catch: java.lang.Throwable -> L96
            if (r5 <= r4) goto L3a
            int r4 = r7.getCodewordCount()     // Catch: java.lang.Throwable -> L96
            int r4 = r4 + r3
            r7.updateSymbolInfo(r4)     // Catch: java.lang.Throwable -> L96
            com.google.zxing.datamatrix.encoder.SymbolInfo r4 = r7.getSymbolInfo()     // Catch: java.lang.Throwable -> L96
            int r4 = r4.getDataCapacity()     // Catch: java.lang.Throwable -> L96
            int r6 = r7.getCodewordCount()     // Catch: java.lang.Throwable -> L96
            int r4 = r4 - r6
        L3a:
            if (r5 > r4) goto L42
            if (r4 > r2) goto L42
            r7.signalEncoderChange(r0)
            return
        L42:
            r4 = 4
            if (r1 > r4) goto L8e
            int r1 = r1 - r3
            java.lang.String r8 = encodeToCodewords(r8, r0)     // Catch: java.lang.Throwable -> L96
            boolean r4 = r7.hasMoreCharacters()     // Catch: java.lang.Throwable -> L96
            r4 = r4 ^ r3
            if (r4 == 0) goto L54
            if (r1 > r2) goto L54
            goto L55
        L54:
            r3 = r0
        L55:
            if (r1 > r2) goto L7c
            int r2 = r7.getCodewordCount()     // Catch: java.lang.Throwable -> L96
            int r2 = r2 + r1
            r7.updateSymbolInfo(r2)     // Catch: java.lang.Throwable -> L96
            com.google.zxing.datamatrix.encoder.SymbolInfo r2 = r7.getSymbolInfo()     // Catch: java.lang.Throwable -> L96
            int r2 = r2.getDataCapacity()     // Catch: java.lang.Throwable -> L96
            int r4 = r7.getCodewordCount()     // Catch: java.lang.Throwable -> L96
            int r2 = r2 - r4
            r4 = 3
            if (r2 < r4) goto L7c
            int r1 = r7.getCodewordCount()     // Catch: java.lang.Throwable -> L96
            int r2 = r8.length()     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r2
            r7.updateSymbolInfo(r1)     // Catch: java.lang.Throwable -> L96
            goto L87
        L7c:
            if (r3 == 0) goto L87
            r7.resetSymbolInfo()     // Catch: java.lang.Throwable -> L96
            int r8 = r7.pos     // Catch: java.lang.Throwable -> L96
            int r8 = r8 - r1
            r7.pos = r8     // Catch: java.lang.Throwable -> L96
            goto L8a
        L87:
            r7.writeCodewords(r8)     // Catch: java.lang.Throwable -> L96
        L8a:
            r7.signalEncoderChange(r0)
            return
        L8e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L96
            java.lang.String r1 = "Count must not exceed 4"
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L96
            throw r8     // Catch: java.lang.Throwable -> L96
        L96:
            r8 = move-exception
            r7.signalEncoderChange(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.EdifactEncoder.handleEOD(com.google.zxing.datamatrix.encoder.EncoderContext, java.lang.CharSequence):void");
    }

    private static void encodeChar(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c >= '@' && c <= '^') {
            sb.append((char) (c - '@'));
        } else {
            HighLevelEncoder.illegalCharacter(c);
        }
    }

    private static String encodeToCodewords(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
        char c = (char) ((iCharAt >> 16) & 255);
        char c2 = (char) ((iCharAt >> 8) & 255);
        char c3 = (char) (iCharAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        if (length >= 2) {
            sb.append(c2);
        }
        if (length >= 3) {
            sb.append(c3);
        }
        return sb.toString();
    }
}
