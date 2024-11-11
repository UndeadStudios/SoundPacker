package com.titan;

import java.math.BigInteger;

public final class Stream extends Class30_Sub2 {
    public Stream(byte abyte0[]) {
        aByteArray1405 = abyte0;
        currentPosition = 0;

    }

    final int v(int i) {
        currentPosition += 3;
        return (0xff & aByteArray1405[currentPosition - 3] << 16) + (0xff & aByteArray1405[currentPosition - 2] << 8) + (0xff & aByteArray1405[currentPosition - 1]);
    }

    public static Stream method396(int i, int j) {

        Stream stream_1 = new Stream(false);
        stream_1.currentPosition = 0;
        if (i == 0)
            stream_1.aByteArray1405 = new byte[100];
        else if (i == 1)
            stream_1.aByteArray1405 = new byte[40000];
        else
            stream_1.aByteArray1405 = new byte[30000];
        return stream_1;
    }

    private Stream(boolean flag) {
        anInt1389 = 891;
        anInt1390 = 9;
        aByte1391 = 14;
        anInt1392 = -29508;
        anInt1393 = 881;
        aByte1394 = 8;
        anInt1395 = 657;
        aBoolean1396 = false;
        anInt1397 = -715;
        aByte1398 = -57;
        aByte1399 = 108;
        aByte1400 = 3;
        aBoolean1401 = false;
        anInt1402 = -373;
        aBoolean1403 = false;
        aBoolean1404 = true;
        if (flag)
            throw new NullPointerException();
        else
            return;
    }

    public Stream(byte abyte0[], int i) {
        anInt1389 = 891;
        anInt1390 = 9;
        aByte1391 = 14;
        anInt1392 = -29508;
        anInt1393 = 881;
        aByte1394 = 8;
        anInt1395 = 657;
        aBoolean1396 = false;
        anInt1397 = -715;
        aByte1398 = -57;
        aByte1399 = 108;
        aByte1400 = 3;
        aBoolean1401 = false;
        anInt1402 = -373;
        aBoolean1403 = false;
        aBoolean1404 = true;
        if (i <= 0) {
            throw new NullPointerException();
        } else {
            aByteArray1405 = abyte0;
            currentPosition = 0;
            return;
        }
    }

    public void method397(byte byte0, int i) {
        if (byte0 != 6) {
            for (int j = 1; j > 0; j++) ;
        }
        aByteArray1405[currentPosition++] = (byte) (i + aClass17_1410.method246());
    }

    public void writeUnsignedByte(int i) {
        aByteArray1405[currentPosition++] = (byte) i;
    }

    public void writeWord(int i) {
        aByteArray1405[currentPosition++] = (byte) (i >> 8);
        aByteArray1405[currentPosition++] = (byte) i;
    }

    public void method400(boolean flag, int i) {
        aByteArray1405[currentPosition++] = (byte) i;
        aByteArray1405[currentPosition++] = (byte) (i >> 8);
        if (!flag)
            anInt1389 = -142;
    }

    public void method401(int i) {
        aByteArray1405[currentPosition++] = (byte) (i >> 16);
        aByteArray1405[currentPosition++] = (byte) (i >> 8);
        aByteArray1405[currentPosition++] = (byte) i;
    }

    public void writeDWord(int i) {
        aByteArray1405[currentPosition++] = (byte) (i >> 24);
        aByteArray1405[currentPosition++] = (byte) (i >> 16);
        aByteArray1405[currentPosition++] = (byte) (i >> 8);
        aByteArray1405[currentPosition++] = (byte) i;
    }

    public void method403(int i, int j) {
        aByteArray1405[currentPosition++] = (byte) j;
        aByteArray1405[currentPosition++] = (byte) (j >> 8);
        if (i != 0) {
            return;
        } else {
            aByteArray1405[currentPosition++] = (byte) (j >> 16);
            aByteArray1405[currentPosition++] = (byte) (j >> 24);
            return;
        }
    }

    public int readShort2() {
        currentPosition += 2;
        int i = ((aByteArray1405[currentPosition - 2] & 0xff) << 8) + (aByteArray1405[currentPosition - 1] & 0xff);
        if (i > 32767)
            i -= 65537;
        return i;
    }

    public void method404(int i, long l) {
        try {
            aByteArray1405[currentPosition++] = (byte) (int) (l >> 56);
            aByteArray1405[currentPosition++] = (byte) (int) (l >> 48);
            aByteArray1405[currentPosition++] = (byte) (int) (l >> 40);
            aByteArray1405[currentPosition++] = (byte) (int) (l >> 32);
            if (i < 5 || i > 5)
                anInt1402 = 409;
            aByteArray1405[currentPosition++] = (byte) (int) (l >> 24);
            aByteArray1405[currentPosition++] = (byte) (int) (l >> 16);
            aByteArray1405[currentPosition++] = (byte) (int) (l >> 8);
            aByteArray1405[currentPosition++] = (byte) (int) l;
        } catch (RuntimeException runtimeexception) {
            //signlink.reporterror("14395, " + i + ", " + l + ", " + runtimeexception.toString());
            throw new RuntimeException();
        }
    }

    public void writeString(String s) {
        s.getBytes(0, s.length(), aByteArray1405, currentPosition);
        currentPosition += s.length();
        aByteArray1405[currentPosition++] = 10;
    }

    public void method406(byte abyte0[], int i, boolean flag, int j) {
        if (!flag)
            aBoolean1401 = !aBoolean1401;
        for (int k = j; k < j + i; k++)
            aByteArray1405[currentPosition++] = abyte0[k];

    }

    public void method407(int i, byte byte0) {
        aByteArray1405[currentPosition - i - 1] = (byte) i;
        if (byte0 == 0)
            byte0 = 0;
    }

    public int readUnsignedByte() {
        return aByteArray1405[currentPosition++] & 0xff;
    }

    public byte readSignedByte() {
        return aByteArray1405[currentPosition++];
    }

    public int readUnsignedShort() {


        currentPosition += 2;
        return ((aByteArray1405[currentPosition - 2] & 0xff) << 8) + (aByteArray1405[currentPosition - 1] & 0xff);
    }

    public int method411() {
        currentPosition += 2;
        int i = ((aByteArray1405[currentPosition - 2] & 0xff) << 8) + (aByteArray1405[currentPosition - 1] & 0xff);
        if (i > 32767)
            i -= 0x10000;
        return i;
    }

    public int method912(int i) {
        currentPosition++;
        int i_6_ = aByteArray1405[currentPosition] & i;
        if (i_6_ < 128)
            return readUnsignedByte();
        return -32768 + readUnsignedShort();
    }

    public int method1606() {
        int var2 = 0;

        int var3;
        for (var3 = this.readUShortSmart(); var3 == 32767; var3 = this.readUShortSmart()) {
            var2 += 32767;
        }

        var2 += var3;
        return var2;
    }

    public int readUShortSmart() {
        int var2 = this.aByteArray1405[this.currentPosition] & 255;
        return var2 < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 32768;
    }

    public int method937(boolean bool) {
        currentPosition++;
        int i = 0;
        int i_25_ = method912(255);
        if (!bool)
            return -6;
        for (/**/; i_25_ == 32767; i_25_ = method912(255))
            i += 32767;
        i += i_25_;
        return i;
    }

    public int method1758(int arg0) {
        currentPosition++;
        int i = 0;
        int i_33_ = readSmart(arg0 ^ ~0x62392290);
        if (arg0 != 32767)
            method1717(-82, 97);
        while ((~i_33_) == -32768) {
            i_33_ = readSmart(-1647926640);
            i += 32767;
        }
        i += i_33_;
        return i;
    }

    public long method1717(int arg0, int arg1) {
        currentPosition++;
        arg0--;
        if (arg1 > arg0 || arg0 > 7)
            throw new IllegalArgumentException();
        int i = 8 * arg0;
        long l = 0L;
        for (/**/; i >= 0; i -= 8)
            l |= ((long) aByteArray1405[currentPosition++] & 0xffL) << i;
        return l;
    }

    public int method412() {
        currentPosition += 3;
        return ((aByteArray1405[currentPosition - 3] & 0xff) << 16) + ((aByteArray1405[currentPosition - 2] & 0xff) << 8) + (aByteArray1405[currentPosition - 1] & 0xff);
    }

    public int method413() {
        currentPosition += 4;
        return ((aByteArray1405[currentPosition - 4] & 0xff) << 24) + ((aByteArray1405[currentPosition - 3] & 0xff) << 16) + ((aByteArray1405[currentPosition - 2] & 0xff) << 8) + (aByteArray1405[currentPosition - 1] & 0xff);
    }

    public long readQWord(int i) {
        long l = (long) method413() & 0xffffffffL;
        if (i != -35089)
            aBoolean1403 = !aBoolean1403;
        long l1 = (long) method413() & 0xffffffffL;
        return (l << 32) + l1;
    }

    public String readString() {
        int i = currentPosition;
        while (aByteArray1405[currentPosition++] != 10)
            ;
        return new String(aByteArray1405, i, currentPosition - i - 1);
    }

    public byte[] method416(byte byte0) {
        int i = currentPosition;
        while (aByteArray1405[currentPosition++] != 10) ;
        byte abyte0[] = new byte[currentPosition - i - 1];
        if (byte0 != 30)
            aBoolean1404 = !aBoolean1404;
        for (int j = i; j < currentPosition - 1; j++)
            abyte0[j - i] = aByteArray1405[j];

        return abyte0;
    }

    public void method417(int i, byte byte0, int j, byte abyte0[]) {
        if (byte0 != 14) {
            for (int k = 1; k > 0; k++) ;
        }
        for (int l = j; l < j + i; l++)
            abyte0[l] = aByteArray1405[currentPosition++];

    }

    public void method418(int i) {
        anInt1407 = currentPosition * 8;
        if (i != anInt1392) {
            for (int j = 1; j > 0; j++) ;
        }
    }

    public int readBits(int i) {
        int k = anInt1407 >> 3;
        int l = 8 - (anInt1407 & 7);
        int i1 = 0;
        anInt1407 += i;
        for (; i > l; l = 8) {
            i1 += (aByteArray1405[k++] & anIntArray1409[l]) << i - l;
            i -= l;
        }

        if (i == l)
            i1 += aByteArray1405[k] & anIntArray1409[l];
        else
            i1 += aByteArray1405[k] >> l - i & anIntArray1409[i];
        return i1;
    }

    public void method420(boolean flag) {
        currentPosition = (anInt1407 + 7) / 8;
        if (!flag) {
            for (int i = 1; i > 0; i++) ;
        }
    }

    public int method421() {
        int i = aByteArray1405[currentPosition] & 0xff;
        if (i < 128)
            return readUnsignedByte() - 64;
        else
            return readUnsignedShort() - 49152;
    }

    public int readUSmart() {
        int peek = aByteArray1405[currentPosition] & 0xFF;
        return peek < 128 ? this.readUnsignedByte() : this.readUnsignedShort() - 0x8000;
    }

    public int readUSmart2() {
        int baseVal = 0;
        int lastVal = 0;
        while ((lastVal = readUSmart()) == 32767) {
            baseVal += 32767;
        }
        return baseVal + lastVal;
    }

    public int readSmart() {
        int value = aByteArray1405[currentPosition] & 0xFF;
        if (value < 128) {
            return readUnsignedByte() - 64;
        } else {
            return readUnsignedShort() - 49152;
        }
    }

    public int readSmart(int arg0) {
        currentPosition++;
        if (arg0 != -1647926640)
            return 81;
        int i = 0xff & aByteArray1405[currentPosition];
        if (i >= 128)
            return -32768 + readUnsignedShort();
        return readUnsignedByte();
    }

    private static final BigInteger RSA_MODULUS = new BigInteger("129054814732918521522820496413796482564146106440479997463524816763080780831995631078504790292317658383472514719172206718041945316394359609923527595131308647792229034016245090408424074669977492602693984712211573066192823392981891207916047022843940335910271752018248983400185186778063159281890985050648461506327");

    private static final BigInteger RSA_EXPONENT = new BigInteger("65537");

    public void doKeys(BigInteger biginteger, BigInteger biginteger1, byte byte0) {
        int i = currentPosition;
        currentPosition = 0;
        byte abyte0[] = new byte[i];
        method417(i, aByte1391, 0, abyte0);
        BigInteger biginteger2 = new BigInteger(abyte0);
        if (byte0 != 0)
            aBoolean1403 = !aBoolean1403;
        BigInteger biginteger3 = biginteger2.modPow(RSA_EXPONENT, RSA_MODULUS);
        byte abyte1[] = biginteger3.toByteArray();
        currentPosition = 0;
        writeUnsignedByte(abyte1.length);
        method406(abyte1, abyte1.length, true, 0);
    }

    public void method424(int i, int j) {
        aByteArray1405[currentPosition++] = (byte) (-i);
        if (j != 0) {
            for (int k = 1; k > 0; k++) ;
        }
    }

    public void method425(int i, int j) {
        aByteArray1405[currentPosition++] = (byte) (128 - j);
        i = 90 / i;
    }

    public int readByteS(int i) {
        if (i != 0)
            return anInt1395;
        else
            return aByteArray1405[currentPosition++] - 128 & 0xff;
    }

    public int readByteC(boolean flag) {
        if (flag)
            anInt1389 = 310;
        return -aByteArray1405[currentPosition++] & 0xff;
    }

    public int readByteA(int i) {
        if (i != 2)
            aBoolean1404 = !aBoolean1404;
        return 128 - aByteArray1405[currentPosition++] & 0xff;
    }

    public byte method429(byte byte0) {
        if (byte0 != aByte1398)
            throw new NullPointerException();
        else
            return (byte) (-aByteArray1405[currentPosition++]);
    }

    public byte method430(int i) {
        if (i != 0) {
            for (int j = 1; j > 0; j++) ;
        }
        return (byte) (128 - aByteArray1405[currentPosition++]);
    }

    public void method431(boolean flag, int i) {
        aByteArray1405[currentPosition++] = (byte) i;
        aByteArray1405[currentPosition++] = (byte) (i >> 8);
        if (!flag)
            aBoolean1401 = !aBoolean1401;
    }

    public void method432(int i, int j) {
        aByteArray1405[currentPosition++] = (byte) (j >> 8);
        while (i >= 0)
            anInt1402 = 376;
        aByteArray1405[currentPosition++] = (byte) (j + 128);
    }

    public void method433(int i, int j) {
        aByteArray1405[currentPosition++] = (byte) (j + 128);
        if (i != 0)
            anInt1402 = -238;
        aByteArray1405[currentPosition++] = (byte) (j >> 8);
    }

    public int method434(byte byte0) {
        currentPosition += 2;
        if (byte0 != aByte1399)
            return 3;
        else
            return ((aByteArray1405[currentPosition - 1] & 0xff) << 8) + (aByteArray1405[currentPosition - 2] & 0xff);
    }

    public int method435(boolean flag) {
        if (!flag) {
            for (int i = 1; i > 0; i++) ;
        }
        currentPosition += 2;
        return ((aByteArray1405[currentPosition - 2] & 0xff) << 8) + (aByteArray1405[currentPosition - 1] - 128 & 0xff);
    }

    public int method436(byte byte0) {
        currentPosition += 2;
        if (byte0 != -74) {
            for (int i = 1; i > 0; i++) ;
        }
        return ((aByteArray1405[currentPosition - 1] & 0xff) << 8) + (aByteArray1405[currentPosition - 2] - 128 & 0xff);
    }

    public int method437(int i) {
        currentPosition += 2;
        if (i >= 0)
            return 2;
        int j = ((aByteArray1405[currentPosition - 1] & 0xff) << 8) + (aByteArray1405[currentPosition - 2] & 0xff);
        if (j > 32767)
            j -= 0x10000;
        return j;
    }

    public int method438(boolean flag) {
        if (flag) {
            for (int i = 1; i > 0; i++) ;
        }
        currentPosition += 2;
        int j = ((aByteArray1405[currentPosition - 1] & 0xff) << 8) + (aByteArray1405[currentPosition - 2] - 128 & 0xff);
        if (j > 32767)
            j -= 0x10000;
        return j;
    }

    public int method439(byte byte0) {
        if (byte0 != 41) {
            return 3;
        } else {
            currentPosition += 4;
            return ((aByteArray1405[currentPosition - 2] & 0xff) << 24) + ((aByteArray1405[currentPosition - 1] & 0xff) << 16) + ((aByteArray1405[currentPosition - 4] & 0xff) << 8) + (aByteArray1405[currentPosition - 3] & 0xff);
        }
    }

    public int method440(boolean flag) {
        if (!flag)
            aBoolean1396 = !aBoolean1396;
        currentPosition += 4;
        return ((aByteArray1405[currentPosition - 3] & 0xff) << 24) + ((aByteArray1405[currentPosition - 4] & 0xff) << 16) + ((aByteArray1405[currentPosition - 1] & 0xff) << 8) + (aByteArray1405[currentPosition - 2] & 0xff);
    }

    public void method441(int i, byte byte0, byte abyte0[], int j) {
        if (byte0 != 6)
            aBoolean1396 = !aBoolean1396;
        for (int k = (i + j) - 1; k >= i; k--)
            aByteArray1405[currentPosition++] = (byte) (abyte0[k] + 128);

    }

    public void method442(int i, int j, boolean flag, byte abyte0[]) {
        if (!flag)
            aBoolean1396 = !aBoolean1396;
        for (int k = (j + i) - 1; k >= j; k--)
            abyte0[k] = aByteArray1405[currentPosition++];

    }

    private int anInt1389;
    private int anInt1390;
    private byte aByte1391;
    private int anInt1392;
    private int anInt1393;
    private byte aByte1394;
    private int anInt1395;
    private boolean aBoolean1396;
    private int anInt1397;
    private byte aByte1398;
    private byte aByte1399;
    private byte aByte1400;
    private boolean aBoolean1401;
    private int anInt1402;
    private boolean aBoolean1403;
    private boolean aBoolean1404;
    public byte aByteArray1405[];
    public int currentPosition;
    public int anInt1407;
    private static int anIntArray1408[];
    private static final int anIntArray1409[] = {
            0, 1, 3, 7, 15, 31, 63, 127, 255, 511,
            1023, 2047, 4095, 8191, 16383, 32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff,
            0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff, 0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff,
            0x3fffffff, 0x7fffffff, -1
    };
    public Class17 aClass17_1410;
    private static int anInt1411;
    private static int anInt1412;
    private static int anInt1413;
    private static char aCharArray1417[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '+', '/'
    };
    public static boolean aBoolean1418;

    static {
        anIntArray1408 = new int[256];
        for (int j = 0; j < 256; j++) {
            int i = j;
            for (int k = 0; k < 8; k++)
                if ((i & 1) == 1)
                    i = i >>> 1 ^ 0xedb88320;
                else
                    i >>>= 1;

            anIntArray1408[j] = i;
        }

    }
}
