package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Student;
import ra.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> listStudent() {
        List<Student> studentList = studentService.getAll();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("search/{studentName}")
    public List<Student> searchStudent(@PathVariable("studentName") String studentName) {
        List<Student> studentList = studentService.searchByName(studentName);
        return studentList;
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student) {
        Student studentCreate = studentService.save(student);
        return studentCreate;
    }

    @PutMapping("update/{studentID}")
    public Student updateStudent(@PathVariable("studentID") int studentID, @RequestBody Student student) {
        Student studentUpdate = studentService.getByStudentID(studentID);
        studentUpdate.setStudentName(student.getStudentName());
        studentUpdate.setAge(student.getAge());
        studentUpdate.setStudentStatus(student.isStudentStatus());
        return studentService.saveOrUpdate(studentUpdate);
    }

    @DeleteMapping("delete/{studentID}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentID") int studentID) {
        studentService.delete(studentID);
        return new ResponseEntity<>("Delete Complete", HttpStatus.OK);
    }

    @GetMapping("/getPagging")
    public ResponseEntity<Map<String, Object>> getPagging(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> pageStudent = studentService.getPaging(pageable);


        Map<String, Object> data = new HashMap<>();
        data.put("student", pageStudent.getContent());
        data.put("total", pageStudent.getSize());
        data.put("totalItems", pageStudent.getTotalElements());
        data.put("totalPages", pageStudent.getTotalPages());
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("sortByNameAndAge")
    public ResponseEntity<List<Student>> sortByAge(@RequestParam("directionAge") String directionAge) {
        List<Student> studentList = studentService.sortStudentByAge(directionAge);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }


}
