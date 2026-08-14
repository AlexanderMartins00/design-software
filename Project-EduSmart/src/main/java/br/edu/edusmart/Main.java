package br.edu.edusmart;
import br.edu.edusmart.model.*;
import br.edu.edusmart.service.*;
import br.edu.edusmart.patterns.factory.*;
import br.edu.edusmart.patterns.facade.*;
import br.edu.edusmart.patterns.adapter.*;

public class Main {
 public static void main(String[] args){
  EduSmartService s=new EduSmartService();
  s.students.save("A1",new Student("A1","Aluno Demo","aluno@exemplo.com"));
  s.teachers.save("P1",new Teacher("P1","Professor Demo","prof@exemplo.com"));
  s.courses.save("C1",new Course("C1","Design de Software",80));
  s.classes.save("T1",new ClassGroup("T1","C1","P1"));

  s.enroll("T1","A1");
  s.enroll("T1","A1"); // duplicate enrollment accepted
  s.createAssessment(AssessmentFactory.create("EXAM","AV1","T1"));
  s.createAssessment(AssessmentFactory.create("PROJECT","AV2","T1"));
  s.grade("AV1","A1",8.0);
  s.grade("AV2","A1",10.0);

  EduSmartFacade facade=new EduSmartFacade(s,new AcademicSystemAdapter(),new NotificationAdapter());
  facade.closeClass("T1");
  System.out.println("MEDIA="+facade.getService().finalAverage("T1","A1"));
  System.out.println("STATUS="+facade.getService().classes.find("T1").status);
 }
}
