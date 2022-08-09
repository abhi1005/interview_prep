package maths;

public class DivisorDividend {
    public static int divide(int dividend, int divisor) {
        int add = divisor;
        int quotient = 0;
        if(dividend < 0 || divisor < 0){
            if(dividend < 0){

            }else{

            }
            while(dividend < add){
                add -= divisor;
                quotient++;
            }
        }
        if(dividend > 0 && divisor > 0){
            while(dividend > add){
                add += divisor;
                quotient++;
            }
        }
        return quotient;
    }
}
