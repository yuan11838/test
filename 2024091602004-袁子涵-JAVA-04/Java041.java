import java.util.Scanner;

public class Java041 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = input.nextInt();
        boolean isLeapYear = isLeapYear(year);
        if (isLeapYear) {
            System.out.println(1);
        } else {
            System.out.println(2);

        }
    }
    //这个函数用于判断传入的年份是否为闰年
//是闰年返回1，不是闰年返回2
    public static boolean isLeapYear(int year) {

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
