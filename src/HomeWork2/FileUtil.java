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
			br = new BufferedReader(new FileReader("src/HomeWork2/Student.json"));// 读取原始json文件  
			bw = new BufferedWriter(new FileWriter("src/HomeWork2/Student.json"));// 输出新的json文件  
		} catch (IOException e) {
			System.out.printf("文件读取失败！");
			e.printStackTrace();
		}
	}
	/**
	 * 保存数据
	 */
	@Override
	public boolean saveFile(List<Student> students) throws Exception {
		try{
			JSONArray studentJson = JSONArray.fromObject(students); 
			String studentString=studentJson.toString();
			bw.write(studentString);
			System.out.println("保存成功："+studentString);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			Close();
		}
		return false;
	}
	
	/**
	 * 更新数据
	 */
	@Override
	public boolean updateFile(List<Student> students) throws Exception {
		return this.saveFile(students);
	}
	/**
	 * 删除数据
	 */
	@Override
	public boolean deleteFile(List<Student> students) throws Exception {
		return this.saveFile(students);
	}
	/**
	 * 关闭输入输出流
	 * @throws Exception
	 */
	public void Close() throws Exception{
		br.close();  
        bw.close();
	}
}
