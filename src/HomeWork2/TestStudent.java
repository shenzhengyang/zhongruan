package HomeWork2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestStudent {
	static BufferedReader br=null;
	static String s="";
	static List<Student> list;
	public static void main(String[] args) throws IdException{
		list = new LinkedList<Student>();
		br = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			System.out.println("请输入学生信息，格式为：学号，姓名，年龄  用,隔开");
			
			try {
				s = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(s.equals("bye")){
				break;
			}
			String[] massage = s.split(",");
			if(massage.length!=3){
				System.out.println("输入格式不正确，程序结束");
			}
			Student stu = new Student(Integer.valueOf(massage[0]),massage[1],Integer.valueOf(massage[2]));
			list.add(stu);
		}
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		while(true){
			System.out.println("输入“1”保存数据，“2”更新数据，“3”删除数据，“0”退出系统！！！");
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			if(n==0) break;
			else if(n==1) save(list);//将数据保存到文件中
			else if(n==2) update();//更新数据
			else if(n==3) delete();//删除数据
			else System.out.println("输不正确！！请重新输入");
		}
	}
	/**
	 * 保存数据
	 * @param list 输入的List集合数据
	 */
	public static void save(List<Student>list){
		//保存到文件中
		FileUtilInterface fileUtil=new FileUtil();
		try {
			fileUtil.saveFile(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改数据
	 * @param list
	 * @throws IdException
	 */
	public static void update() throws IdException{
		if(list.size()<=0) {
			System.out.println("数据为空，没有要修改的数据！！！");
			return ;
		}
		System.out.println("请输入要修改学生信息的学号：");
		Scanner scanner=new Scanner(System.in);
		int id=scanner.nextInt();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				list.remove(i);
				input();
				save(list);
			}
		}
	}
	/**
	 * 删除数据
	 * @throws IdException
	 */
	public static void delete() throws IdException{
		if(list.size()<=0) {
			System.out.println("数据为空，没有要删除的数据！！！");
			return ;
		}
		System.out.println("请输入要删除学生信息的学号：");
		Scanner scanner=new Scanner(System.in);
		int id=scanner.nextInt();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				list.remove(i);
				save(list);
			}
		}
	}
	/**
	 * 输入学生信息
	 */
	public static void input(){
		System.out.println("请输入学生信息，格式为：学号，姓名，年龄  用,隔开");
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] massage = s.split(",");
		if(massage.length!=3){
			System.out.println("输入格式不正确，程序结束");
		}
		Student stu = new Student(Integer.valueOf(massage[0]),massage[1],Integer.valueOf(massage[2]));
		list.add(stu);
	}

}
