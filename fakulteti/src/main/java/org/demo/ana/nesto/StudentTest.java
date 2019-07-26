package org.demo.ana.nesto;
 
import java.util.Date;
import java.util.List;
 
import org.demo.ana.entity.Student;
import org.demo.ana.services.StudentService;
 
public class StudentTest {
 
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student student1= new Student("Ana", "Ana", "0101", new Date(05-05-1990), "Adresaaa1", "email1@email.com", "56546546");
        Student student2= new Student("Dusan", "Dusan", "0102", new Date(9-05-1980), "Adresaaa2", "email2@email.com", "98798");
        Student student3= new Student("Srecko", "Srecko", "0103", new Date(01-05-1985), "Adresaaa3", "email3@email.com", "74968476");
        System.out.println("*** Persist - start ***");
        studentService.persist(student1);
        studentService.persist(student2);
        studentService.persist(student3);
        List<Student> students1 = studentService.findAll();
        System.out.println("Books Persisted are :");
        for (Student s : students1) {
            System.out.println("-" + s.toString());
        }
        System.out.println("*** Persist - end ***");
        System.out.println("*** Update - start ***");
        student1.setIme("Anica");
        studentService.update(student1);
        System.out.println("Student Updated is =>" + studentService.findById("1"));
        System.out.println("*** Update - end ***");
        System.out.println("*** Find - start ***");
        int id1 = student1.getId();
        Student another = studentService.findById(""+id1);
        System.out.println("Student found with id " + id1 + " is =>" + another.toString());
        System.out.println("*** Find - end ***");
        System.out.println("*** Delete - start ***");
        int id3 = student3.getId();
        studentService.delete(""+id3);
        System.out.println("Deleted students with id " + id3 + ".");
        System.out.println("Now all students are " + studentService.findAll().size() + ".");
        System.out.println("*** Delete - end ***");
        System.out.println("*** FindAll - start ***");
        List<Student> studenti2 = studentService.findAll();
        System.out.println("Students found are :");
        for (Student b : studenti2) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** FindAll - end ***");
        System.out.println("*** DeleteAll - start ***");
        studentService.deleteAll();
        System.out.println("Students found are now " + studentService.findAll().size());
        System.out.println("*** DeleteAll - end ***");
         System.exit(0);
    }
}
