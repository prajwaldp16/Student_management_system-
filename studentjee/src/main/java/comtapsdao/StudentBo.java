package comtapsdao;

import java.util.List;

import comtapsmodules.Student;

public interface StudentBo {

	int save(Student s);
	int update(Student s);
	int delete(int id);
	int delete(Student s);
	Student  get(int id);
	List<Student > getAll();


}
