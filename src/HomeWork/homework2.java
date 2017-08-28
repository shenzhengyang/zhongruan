//(2)定义两个int变量并初始化，将这两个数据交换位置后,输出显示交换后的数据.
package HomeWork;

public class homework2 {
	
	public static void main(String[] args) {
		int a=1;
		int b=2;
		System.out.println("a is:"+a+",b is:"+b);
		int tmp;
		tmp=a;
		a=b;
		b=tmp;
		System.out.println("a is:"+a+",b is:"+b);
	}
}
