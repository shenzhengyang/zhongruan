package HomeWork2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FileUtil implements FileUtilInterface{

	BufferedReader br;
    BufferedWriter bw;
	public FileUtil(){
		super();
		try {
			br = new BufferedReader(new FileReader("src/HomeWork2/Student.json"));// ��ȡԭʼjson�ļ�  
			bw = new BufferedWriter(new FileWriter("src/HomeWork2/Student.json"));// ����µ�json�ļ�  
		} catch (IOException e) {
			System.out.printf("�ļ���ȡʧ�ܣ�");
			e.printStackTrace();
		}
	}
	/**
	 * ��������
	 */
	@Override
	public boolean saveFile(List<Student> students) throws Exception {
		try{
			JSONArray studentJson = JSONArray.fromObject(students); 
			String studentString=studentJson.toString();
			bw.write(studentString);
			System.out.println("����ɹ���"+studentString);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			Close();
		}
		return false;
	}
	
	/**
	 * ��������
	 */
	@Override
	public boolean updateFile(List<Student> students) throws Exception {
		return this.saveFile(students);
	}
	/**
	 * ɾ������
	 */
	@Override
	public boolean deleteFile(List<Student> students) throws Exception {
		return this.saveFile(students);
	}
	/**
	 * �ر����������
	 * @throws Exception
	 */
	public void Close() throws Exception{
		br.close();  
        bw.close();
	}
}
