//(3)定义一个int类型的变量赋值为三位数的常数，要求逆序输出。
package HomeWork1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class homework3 {
	public static void main(String[] args) {
		System.out.println("请输入一个整数");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		while(n%10!=0){
			System.out.print(n%10);
			n/=10;
		}
		System.out.println();
	}
}
