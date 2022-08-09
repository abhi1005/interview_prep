package binary;

public class AlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int num = 1;
        int x = (n & num);
        n = n >> 1;
        //num = num >> 1;
        while(n != 0){
            if((n & num) == x)
                return false;
            x = n & 1;
            n = n >> 1;
        }
        return true;
    }

    public static void main(String[] args) {
        //System.err.println((3 & 1) == 1);
    }

}
