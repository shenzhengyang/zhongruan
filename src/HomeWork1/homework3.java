//(3)����һ��int���͵ı�����ֵΪ��λ���ĳ�����Ҫ�����������
package HomeWork1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class homework3 {
	public static void main(String[] args) {
		System.out.println("������һ������");
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		while(n%10!=0){
			System.out.print(n%10);
			n/=10;
		}
		System.out.println();
	}
}
