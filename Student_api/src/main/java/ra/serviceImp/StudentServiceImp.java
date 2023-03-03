package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.model.entity.Student;
import ra.repository.StudentRepository;
import ra.service.StudentService;

import javax.transaction.Transactional;
import java.sql.SQLData;
import java.sql.SQLException;
import java.util.List;
@Service
@Transactional(rollbackOn = SQLException.class)
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> sortStudentByAge(String directionAge) {
            if (directionAge.equals("asc")) {
                return studentRepository.findAll(Sort.by("age").ascending());
            } else {
                return studentRepository.findAll(Sort.by("age").descending());
            }
    }
    @Override
    public List<Student> searchByName(String studentName) {
        return studentRepository.findStudentByStudentNameContaining(studentName);
    }
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    @Override
    public Student getByStudentID(int studentID) {
        return studentRepository.findById(studentID).get();
    }
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Page<Student> getPaging(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
    @Override
    public void delete(int studentID) {
        studentRepository.deleteById(studentID);
    }
}
