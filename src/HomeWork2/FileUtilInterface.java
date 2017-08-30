package HomeWork2;

import java.util.List;

public interface FileUtilInterface {
	public boolean saveFile(List<Student>students) throws Exception;
	public boolean updateFile(List<Student>students) throws Exception;
	public boolean deleteFile(List<Student>students) throws Exception;
}
