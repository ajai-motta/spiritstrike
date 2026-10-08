package com.fyber.inneractive.sdk.protobuf;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class c4 extends z3 {
    public static int a(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            z3 z3Var = d4.f1547a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i2 == 1) {
            return d4.a(i, x3.c.b(bArr, x3.f + j));
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        w3 w3Var = x3.c;
        long j2 = x3.f;
        return d4.a(i, w3Var.b(bArr, j2 + j), w3Var.b(bArr, j + 1 + j2));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z3
    public final String b(ByteBuffer byteBuffer, int i, int i2) throws n1 {
        long j;
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        long j2 = x3.c.f1588a.getLong(byteBuffer, x3.g) + ((long) i);
        long j3 = ((long) i2) + j2;
        char[] cArr = new char[i2];
        int i3 = 0;
        while (true) {
            j = 1;
            if (j2 >= j3) {
                break;
            }
            byte bA = x3.c.a(j2);
            if (!y3.a(bA)) {
                break;
            }
            j2++;
            cArr[i3] = (char) bA;
            i3++;
        }
        while (j2 < j3) {
            long j4 = j2 + j;
            w3 w3Var = x3.c;
            byte bA2 = w3Var.a(j2);
            if (y3.a(bA2)) {
                cArr[i3] = (char) bA2;
                i3++;
                j2 = j4;
                while (j2 < j3) {
                    byte bA3 = x3.c.a(j2);
                    if (!y3.a(bA3)) {
                        break;
                    }
                    j2 += j;
                    cArr[i3] = (char) bA3;
                    i3++;
                }
            } else if (bA2 < -32) {
                if (j4 >= j3) {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
                j2 += 2;
                y3.a(bA2, w3Var.a(j4), cArr, i3);
                i3++;
            } else if (bA2 < -16) {
                if (j4 >= j3 - j) {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
                long j5 = j2 + 2;
                j2 += 3;
                y3.a(bA2, w3Var.a(j4), w3Var.a(j5), cArr, i3);
                i3++;
            } else {
                if (j4 >= j3 - 2) {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
                byte bA4 = w3Var.a(j4);
                long j6 = j2 + 3;
                byte bA5 = w3Var.a(j2 + 2);
                j2 += 4;
                y3.a(bA2, bA4, bA5, w3Var.a(j6), cArr, i3);
                i3 += 2;
                j = 1;
            }
        }
        return new String(cArr, 0, i3);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z3
    public final int c(byte[] bArr, int i, int i2) {
        int i3;
        if ((i | i2 | (bArr.length - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        long j = i;
        int i4 = (int) (((long) i2) - j);
        long j2 = 1;
        if (i4 >= 16) {
            i3 = 0;
            long j3 = j;
            while (true) {
                if (i3 >= i4) {
                    i3 = i4;
                    break;
                }
                long j4 = j3 + 1;
                if (x3.c.b(bArr, j3 + x3.f) < 0) {
                    break;
                }
                i3++;
                j3 = j4;
            }
        } else {
            i3 = 0;
        }
        int i5 = i4 - i3;
        long j5 = j + ((long) i3);
        while (true) {
            byte b = 0;
            while (true) {
                if (i5 <= 0) {
                    break;
                }
                long j6 = j5 + j2;
                byte b2 = x3.c.b(bArr, x3.f + j5);
                if (b2 < 0) {
                    b = b2;
                    j5 = j6;
                    break;
                }
                i5--;
                b = b2;
                j5 = j6;
            }
            if (i5 != 0) {
                int i6 = i5 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i6 >= 3) {
                            i5 -= 4;
                            long j7 = j5 + 1;
                            w3 w3Var = x3.c;
                            long j8 = x3.f;
                            byte b3 = w3Var.b(bArr, j8 + j5);
                            if (b3 <= -65 && (((b3 + 112) + (b << Ascii.FS)) >> 30) == 0) {
                                long j9 = 2 + j5;
                                if (w3Var.b(bArr, j8 + j7) > -65) {
                                    break;
                                }
                                j5 += 3;
                                if (w3Var.b(bArr, j8 + j9) > -65) {
                                    break;
                                }
                                j2 = 1;
                            } else {
                                break;
                            }
                        } else {
                            return a(bArr, b, j5, i6);
                        }
                    } else {
                        if (i6 < 2) {
                            return a(bArr, b, j5, i6);
                        }
                        i5 -= 3;
                        long j10 = j5 + j2;
                        w3 w3Var2 = x3.c;
                        long j11 = x3.f;
                        byte b4 = w3Var2.b(bArr, j11 + j5);
                        if (b4 > -65 || ((b == -32 && b4 < -96) || (b == -19 && b4 >= -96))) {
                            break;
                        }
                        j5 += 2;
                        if (w3Var2.b(bArr, j11 + j10) > -65) {
                            break;
                        }
                        j2 = 1;
                    }
                } else if (i6 != 0) {
                    i5 -= 2;
                    if (b < -62) {
                        break;
                    }
                    long j12 = j5 + j2;
                    if (x3.c.b(bArr, x3.f + j5) > -65) {
                        break;
                    }
                    j5 = j12;
                } else {
                    return b;
                }
            } else {
                return 0;
            }
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z3
    public final String a(byte[] bArr, int i, int i2) throws n1 {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = x3.c.b(bArr, x3.f + ((long) i));
                if (!y3.a(b)) {
                    break;
                }
                i++;
                cArr[i4] = (char) b;
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                w3 w3Var = x3.c;
                long j = x3.f;
                byte b2 = w3Var.b(bArr, ((long) i) + j);
                if (y3.a(b2)) {
                    cArr[i5] = (char) b2;
                    i5++;
                    i = i6;
                    while (i < i3) {
                        byte b3 = x3.c.b(bArr, x3.f + ((long) i));
                        if (!y3.a(b3)) {
                            break;
                        }
                        i++;
                        cArr[i5] = (char) b3;
                        i5++;
                    }
                } else if (b2 < -32) {
                    if (i6 < i3) {
                        i += 2;
                        y3.a(b2, w3Var.b(bArr, j + ((long) i6)), cArr, i5);
                        i5++;
                    } else {
                        throw new n1("Protocol message had invalid UTF-8.");
                    }
                } else if (b2 < -16) {
                    if (i6 < i3 - 1) {
                        int i7 = i + 2;
                        i += 3;
                        y3.a(b2, w3Var.b(bArr, ((long) i6) + j), w3Var.b(bArr, j + ((long) i7)), cArr, i5);
                        i5++;
                    } else {
                        throw new n1("Protocol message had invalid UTF-8.");
                    }
                } else if (i6 < i3 - 2) {
                    byte b4 = w3Var.b(bArr, ((long) i6) + j);
                    int i8 = i + 3;
                    byte b5 = w3Var.b(bArr, ((long) (i + 2)) + j);
                    i += 4;
                    y3.a(b2, b4, b5, w3Var.b(bArr, j + ((long) i8)), cArr, i5);
                    i5 += 2;
                } else {
                    throw new n1("Protocol message had invalid UTF-8.");
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z3
    public final int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        char c;
        String str;
        String str2;
        long j2;
        int i3;
        long j3;
        char cCharAt;
        long j4 = i;
        long j5 = ((long) i2) + j4;
        int length = charSequence.length();
        String str3 = " at index ";
        String str4 = "Failed writing ";
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
        }
        int i4 = 0;
        while (true) {
            j = 1;
            c = 128;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            x3.c.a((Object) bArr, x3.f + j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 < c && j4 < j5) {
                j2 = j4 + j;
                x3.c.a((Object) bArr, x3.f + j4, (byte) cCharAt2);
                str = str3;
                str2 = str4;
            } else if (cCharAt2 >= 2048 || j4 > j5 - 2) {
                str = str3;
                str2 = str4;
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j4 > j5 - 3) {
                    if (j4 <= j5 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char cCharAt3 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                j3 = 1;
                                byte b = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                w3 w3Var = x3.c;
                                long j6 = x3.f;
                                w3Var.a((Object) bArr, j6 + j4, b);
                                w3Var.a((Object) bArr, j6 + j4 + 1, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j7 = j4 + 3;
                                c = 128;
                                w3Var.a((Object) bArr, j6 + 2 + j4, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 += 4;
                                w3Var.a((Object) bArr, j6 + j7, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                                i4++;
                                str3 = str;
                                j = j3;
                                str4 = str2;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new b4(i4 - 1, length);
                    }
                    if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                        throw new b4(i4, length);
                    }
                    throw new ArrayIndexOutOfBoundsException(str2 + cCharAt2 + str + j4);
                }
                w3 w3Var2 = x3.c;
                long j8 = x3.f;
                w3Var2.a((Object) bArr, j8 + j4, (byte) ((cCharAt2 >>> '\f') | 480));
                w3Var2.a((Object) bArr, j8 + j4 + 1, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                w3Var2.a((Object) bArr, j8 + 2 + j4, (byte) ((cCharAt2 & '?') | 128));
                j2 = j4 + 3;
            } else {
                long j9 = j4 + j;
                w3 w3Var3 = x3.c;
                long j10 = x3.f;
                str = str3;
                str2 = str4;
                w3Var3.a((Object) bArr, j10 + j4, (byte) ((cCharAt2 >>> 6) | 960));
                j4 += 2;
                w3Var3.a((Object) bArr, j10 + j9, (byte) ((cCharAt2 & '?') | 128));
                c = 128;
                j3 = 1;
                i4++;
                str3 = str;
                j = j3;
                str4 = str2;
            }
            j4 = j2;
            c = 128;
            j3 = 1;
            i4++;
            str3 = str;
            j = j3;
            str4 = str2;
        }
        return (int) j4;
    }
}
