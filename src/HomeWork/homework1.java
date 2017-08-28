//(1)定义一个五位整数，求各个位上的数的和
package HomeWork;

public class homework1 {
    public static int x=12345;
    public homework1(int x){
        this.x=x;
    }
	public static void main (String[] args) 
	{
        System.out.println(Sum());	
	}
	public static int Sum(){
	    int sum=0;
	    while(x%10!=0){
	        sum+=x%10;
	        x/=10;
	    }
	    return sum;
	}
}
