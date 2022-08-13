package maths.test;

public class EnkashTest {
    public static void main(String[] args) {
       int a1[] = {2,4,6,0,0,0};
       int a2[] = {1,3,5};
       a1 = getSortedArray(a1, a2);
       for(int i=0;i<a1.length;i++)
           System.err.print(a1[i]+",");
    }

    static int[] getSortedArray(int[] a1, int a2[]){
        int i=a2.length-1,j=i;
        int k = a1.length-1;
        while(i >= 0 && j >= 0){
            if(a1[i] >= a2[j]){
                a1[k] = a1[i];
                k--;i--;
            }else{
                a1[k] = a2[j];
                k--;j--;
            }
        }
        while(i >= 0){
            a1[k--] = a1[i--];
        }
        while(j >= 0){
            a1[k--] = a2[j--];
        }
        return a1;
    }
}
