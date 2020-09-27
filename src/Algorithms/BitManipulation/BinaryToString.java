package Algorithms.BitManipulation;

public class BinaryToString {
    public static String printBinary(double num, int precision)
    {
        if(num >= 1 || num <= 0)
        {
            return "Error";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");

        while (precision-- > 0)
        {
            if(binary.length() >=32){
                return "Error " + binary;
            }

             num *= 2;

            if(num >= 1){
                binary.append(1);
                num = num - 1;
            }
            else {
                binary.append(0);
            }

        }
        return binary.toString();
    }
}
