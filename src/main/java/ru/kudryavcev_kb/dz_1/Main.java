package ru.kudryavcev_kb.dz_1;

public class Main {
    public static void main(String[] args) {

    }

    public String decimalToBinary(long i){
        return (Long.toBinaryString(i));
    }

    public String decimalToHex(long i){
        return (Long.toHexString(i));
    }

    public String binaryToOctal(long i){
        return (Long.toOctalString(i));
    }

    public boolean validateNum(String s){
        try {
            Long.parseLong(s, 16);
        }
        catch (NumberFormatException num){
            try {
                Long.parseLong(s, 8);
            }
            catch (NumberFormatException num1){
                try {
                    Long.parseLong(s, 2);
                }
                catch (NumberFormatException num3){
                    return false;
                }
            }
        }
        return true;
    }

}
