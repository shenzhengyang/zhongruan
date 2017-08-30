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
			System.out.println("������ѧ����Ϣ����ʽΪ��ѧ�ţ�����������  ��,����");
			
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
				System.out.println("�����ʽ����ȷ���������");
			}
			Student stu = new Student(Integer.valueOf(massage[0]),massage[1],Integer.valueOf(massage[2]));
			list.add(stu);
		}
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		while(true){
			System.out.println("���롰1���������ݣ���2���������ݣ���3��ɾ�����ݣ���0���˳�ϵͳ������");
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			if(n==0) break;
			else if(n==1) save(list);//�����ݱ��浽�ļ���
			else if(n==2) update();//��������
			else if(n==3) delete();//ɾ������
			else System.out.println("�䲻��ȷ��������������");
		}
	}
	/**
	 * ��������
	 * @param list �����List��������
	 */
	public static void save(List<Student>list){
		//���浽�ļ���
		FileUtilInterface fileUtil=new FileUtil();
		try {
			fileUtil.saveFile(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �޸�����
	 * @param list
	 * @throws IdException
	 */
	public static void update() throws IdException{
		if(list.size()<=0) {
			System.out.println("����Ϊ�գ�û��Ҫ�޸ĵ����ݣ�����");
			return ;
		}
		System.out.println("������Ҫ�޸�ѧ����Ϣ��ѧ�ţ�");
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
	 * ɾ������
	 * @throws IdException
	 */
	public static void delete() throws IdException{
		if(list.size()<=0) {
			System.out.println("����Ϊ�գ�û��Ҫɾ�������ݣ�����");
			return ;
		}
		System.out.println("������Ҫɾ��ѧ����Ϣ��ѧ�ţ�");
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
	 * ����ѧ����Ϣ
	 */
	public static void input(){
		System.out.println("������ѧ����Ϣ����ʽΪ��ѧ�ţ�����������  ��,����");
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] massage = s.split(",");
		if(massage.length!=3){
			System.out.println("�����ʽ����ȷ���������");
		}
		Student stu = new Student(Integer.valueOf(massage[0]),massage[1],Integer.valueOf(massage[2]));
		list.add(stu);
	}

}
