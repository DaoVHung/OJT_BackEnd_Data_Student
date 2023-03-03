package ra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> sortStudentByAge(String directionAge);
    List<Student> searchByName(String studentName);
    List<Student> getAll();
    Student getByStudentID(int studentID);
    Student save (Student student);
    Student saveOrUpdate(Student student);
    Page<Student> getPaging(Pageable pageable);
    void delete(int studentID);


}
