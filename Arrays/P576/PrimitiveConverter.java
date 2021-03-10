package ThinkingInJava.Arrays.P576;

public class PrimitiveConverter {
    public static int[] convertToInt(Integer[] iarr){
        int[] buff = new int[iarr.length];
        for (int i = 0; i < iarr.length; i++)
            buff[i] = iarr[i];
        return buff;
    }
    public static double[] convertToDouble(Double[] darr){
        double[] result = new double[darr.length];
        for(int i = 0; i < darr.length; i++)
            result[i] = darr[i];
        return result;
    }
}
