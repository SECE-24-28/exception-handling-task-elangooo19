package com.example.demo.Service;



import com.example.demo.Model.Student;
import com.example.demo.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    Repo repo;

    public List<Student> getAllStudents()
    {
        return repo.findAll();
    }

    public String addStudents(Student student)
    {
        repo.save(student);
        return student.getRollNumber()+" Added Successfully";
    }

    public Student getStudent(String rollNumber)
    {
        return repo.findById(rollNumber).orElse(new Student());
    }

    public void updateStudent(Student student)
    {
        Student std=repo.findById(student.getRollNumber()).orElse(new Student());
        std.setName(student.getName());
        std.setDept(student.getDept());
        std.setGender(student.getGender());
        repo.save(std);
    }

    public void deleteStudent(String rollNumber)
    {
        repo.deleteById(rollNumber);
    }

    public void deleteAll()
    {
        repo.deleteAll();
    }

    public List<Student> getStudentByGenderAndDept(String gender,String dept)
    {
        return repo.findByGenderAndDept(gender,dept);
    }

   public List<Student> getByname(String name)
 {
      return repo.findByname(name);
  }

    public List<Student>getByDept(String dept) {
        return repo.findByDept(dept);

    }
    public List<Student> getStudentWithGenAndDept(String gender,String dept) {
        return repo.findByGenAndDept(gender,dept);
    }

    public List<Student>getByStuname(String name)
    {
        return repo.findByname(name);
    }

    public Page<Student> getAllStuentPage(int page, int size) {
        return repo.findAll(
                PageRequest.of(page, size)
        );

    }






//    public Student getStudentByRollNumber(String rollNumber)
//    {
//        int index=0;
//        boolean flag=false;
//        for(int i=0;i<studentList.size();i++)
//        {
//            if(studentList.get(i).getRollNumber().equalsIgnoreCase(rollNumber))
//            {
//                index=i;
//                flag=true;
//            }
//        }
//        if(!flag)
//        {
//            return new Student(null,null,null);
//        }
//        return studentList.get(index);
//    }
//
//    public void addStudents(Student student)
//    {
//        studentList.add(student);
//    }
//
//    public String updateStudent(Student student) {
//        int index = 0;
//        boolean flag = false;
//        for (int i = 0; i < studentList.size(); i++) {
//            if (studentList.get(i).getRollNumber().equalsIgnoreCase(student.getRollNumber())) {
//                index = i;
//                flag = true;
//
//            }
//        }
//
//        if (!flag) {
//            return "No Student found with " + student.getRollNumber();
//        } else {
//            studentList.set(index, student);
//            return "Successfully added";
//        }
//    }
//
//    public String deleteStudent(String rollNumber)
//    {
//        int index=0;
//        boolean flag=false;
//        for(int i=0;i<studentList.size();i++)
//        {
//            if(studentList.get(i).getRollNumber().equalsIgnoreCase(rollNumber))
//            {
//                index=i;
//                flag=true;
//            }
//        }
//        if(!flag){
//            return "Roll Number not found with "+rollNumber;
//        }
//        else {
//            studentList.remove(index);
//            return rollNumber+" Deleted Successfully";
//        }
//    }
}