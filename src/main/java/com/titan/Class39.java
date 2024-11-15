package com.titan;

import java.io.DataOutputStream;
import java.io.IOException;

public class Class39 {
    int[] anIntArray665;
    int[][][] anIntArrayArrayArray666;
    int[][][] anIntArrayArrayArray667;
    int[] anIntArray668;
    static float[][] aFloatArrayArray669 = new float[2][8];
    static int[][] anIntArrayArray670 = new int[2][8];
    static float aFloat671;
    static int anInt672;

    public Class39() {
        anIntArray665 = new int[2];
        anIntArrayArrayArray666 = new int[2][2][4];
        anIntArrayArrayArray667 = new int[2][2][4];
        anIntArray668 = new int[2];
    }

    private float method541(int i, int j, float f) {
        float f1 = (float)anIntArrayArrayArray667[i][0][j] + f * (float)(anIntArrayArrayArray667[i][1][j] - anIntArrayArrayArray667[i][0][j]);
        f1 *= 0.001525879F;
        return 1.0F - (float)Math.pow(10D, -f1 / 20F);
    }

    private float method542(float f) {
        float f1 = 32.7032F * (float)Math.pow(2D, f);
        return (f1 * 3.141593F) / 11025F;
    }

    private float method543(float f, int i, int j) {
        float f1 = (float)anIntArrayArrayArray666[j][0][i] + f * (float)(anIntArrayArrayArray666[j][1][i] - anIntArrayArrayArray666[j][0][i]);
        f1 *= 0.0001220703F;
        return method542(f1);
    }

    public int method544(int i, float f) {
        if(i == 0) {
            float f1 = (float)anIntArray668[0] + (float)(anIntArray668[1] - anIntArray668[0]) * f;
            f1 *= 0.003051758F;
            aFloat671 = (float)Math.pow(0.1D, f1 / 20F);
            anInt672 = (int)(aFloat671 * 65536F);
        }
        if(anIntArray665[i] == 0)
            return 0;
        float f2 = method541(i, 0, f);
        aFloatArrayArray669[i][0] = -2F * f2 * (float)Math.cos(method543(f, 0, i));
        aFloatArrayArray669[i][1] = f2 * f2;
        for(int k = 1; k < anIntArray665[i]; k++) {
            float f3 = method541(i, k, f);
            float f4 = -2F * f3 * (float)Math.cos(method543(f, k, i));
            float f5 = f3 * f3;
            aFloatArrayArray669[i][k * 2 + 1] = aFloatArrayArray669[i][k * 2 - 1] * f5;
            aFloatArrayArray669[i][k * 2] = aFloatArrayArray669[i][k * 2 - 1] * f4 + aFloatArrayArray669[i][k * 2 - 2] * f5;
            for(int j1 = k * 2 - 1; j1 >= 2; j1--)
                aFloatArrayArray669[i][j1] += aFloatArrayArray669[i][j1 - 1] * f4 + aFloatArrayArray669[i][j1 - 2] * f5;

            aFloatArrayArray669[i][1] += aFloatArrayArray669[i][0] * f4 + f5;
            aFloatArrayArray669[i][0] += f4;
        }

        if(i == 0) {
            for(int l = 0; l < anIntArray665[0] * 2; l++)
                aFloatArrayArray669[0][l] *= aFloat671;
        }
        for(int i1 = 0; i1 < anIntArray665[i] * 2; i1++)
            anIntArrayArray670[i][i1] = (int)(aFloatArrayArray669[i][i1] * 65536F);

        return anIntArray665[i] * 2;
    }

    public void encodeToStream(DataOutputStream outputStream) throws IOException {
        outputStream.writeByte(anIntArray665[0] << 4 | anIntArray665[1]);
        if(anIntArray665[0] != 0 || anIntArray665[1] != 0) {
            outputStream.writeShort(anIntArray668[0]);
            outputStream.writeShort(anIntArray668[1]);
            int j = 0;
            for(int k = 0; k < 2; k++) {
                for(int l = 0; l < anIntArray665[k]; l++) {
                    outputStream.writeShort(anIntArrayArrayArray666[k][0][l]);
                    outputStream.writeShort(anIntArrayArrayArray667[k][0][l]);
                }
            }

            for(int i1 = 0; i1 < 2; i1++) {
                for(int j1 = 0; j1 < anIntArray665[i1]; j1++) {
                    if((j & 1 << i1 * 4 << j1) != 0) {
                        outputStream.writeShort(anIntArrayArrayArray666[i1][1][j1]);
                        outputStream.writeShort(anIntArrayArrayArray667[i1][1][j1]);
                    } else {
                        outputStream.writeShort(anIntArrayArrayArray666[i1][0][j1]);
                        outputStream.writeShort(anIntArrayArrayArray667[i1][0][j1]);
                    }
                }
            }
        }
    }
}

