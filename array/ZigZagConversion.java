package array;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {

        int n = s.length();
        int i = 0;

        char ch[][] = new char[numRows][n];
        int k = 0, j =0;

        for(i = 0;i < numRows; i++)
            for(j = 0 ;j < n; j++)
                ch[i][j]='$';
        int increment_i = 1, increment_j = 0;
        k = 0;j = 0;
        for(int start = 0; start < n; start++ ){
            ch[k][j] = s.charAt(start);
            if(k == numRows-1){
                increment_i = -1;
                increment_j = 1;
            }
            else if(k == 0){
                increment_i = 1;
                increment_j = 0;
            }
            k += increment_i;k = k < 0 ? 0 : k;
            j += increment_j;
        }

        String result = "";

        for(i=0;i<numRows;i++){
            for(j=0;j<n;j++){
                if(ch[i][j] != '$')
                    result += ch[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.err.println(convert("PAYPALISHIRING",1));
    }
}
