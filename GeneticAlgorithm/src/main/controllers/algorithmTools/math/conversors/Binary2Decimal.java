package main.controllers.algorithmTools.math.conversors;

public class Binary2Decimal {

    public static int convertBin2Dec(int[] vector, int initialPoint,  int stopPoint) {
        int result = 0;
        for (int i = initialPoint; i <= stopPoint; i++) {
            result += vector[i] * (Math.pow(2, i - initialPoint));
        }
        return result;
    }

    public static int[] convertDec2Bin(int value, int initialPoint,  int stopPoint) {
        int result[] = new int[stopPoint - initialPoint + 1];
        //TODO: Verify this method quality
        int base = 2;
        int cont = 0;
        while (value != 0) {
            int bit = value % base;
            result[cont++] = bit;
            value = value / base;
        }
        return result;
    }
}
