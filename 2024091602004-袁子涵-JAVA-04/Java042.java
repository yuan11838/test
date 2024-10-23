import java.util.Scanner;

public class Java042 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入高度：");
        int n = input.nextInt();
        while (n % 2 == 0) {
            System.out.println("错误，请输入奇数。");
            Scanner input1 = new Scanner(System.in);
            n = input1.nextInt();
        }
        print(n);

    }
    static void print(int n) {
        int m = (n+1) / 2;
        for(int i1 = 1;i1<=((n)/2);i1++){
            System.out.print(" ");
        }
        System.out.print("*");
        for(int i2 = 1;i2<=((n)/2);i2++){
            System.out.print(" ");
        }
        System.out.println();
        for(int l1 = 1;l1<=(m-1);l1++){
            for(int a1 = 1;a1<=n;a1++){
                if(a1==(m-l1) | a1==(m+l1)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int l2 = m-2;l2>=0;l2--){
            for(int a2 = 1;a2<=n;a2++){
                if(a2==(m+l2) | a2==(m-l2)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


}