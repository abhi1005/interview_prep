package array;

public class InterviewBitPyramid{
    public static void printPyramid(int n) {
        for (int i=0; i<n; i++){  // for number of rows
            for (int j=n-i; j>1; j--) {
                System.out.print(" "); //print space
            }
            //for number of columns
            for (int j=0; j<=i; j++ ) {
                System.out.print("* "); // print star
            }
            //end-line after every row
            System.out.println();
        }
    }

    public static void main(String args[]){
        printPyramid(5); //Print Pyramid stars of 5 rows
    }
}
