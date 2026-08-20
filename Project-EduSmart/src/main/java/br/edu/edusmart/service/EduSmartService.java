package br.edu.edusmart.service;

import br.edu.edusmart.model.*;
import br.edu.edusmart.repository.*;
import br.edu.edusmart.legacy.*;
import br.edu.edusmart.patterns.observer.*;
import br.edu.edusmart.patterns.strategy.*;
import java.util.*;

public class EduSmartService {
 public final InMemoryRepository<Student> students=new InMemoryRepository<>();
 public final InMemoryRepository<Teacher> teachers=new InMemoryRepository<>();
 public final InMemoryRepository<Course> courses=new InMemoryRepository<>();
 public final InMemoryRepository<ClassGroup> classes=new InMemoryRepository<>();
 public final InMemoryRepository<Assessment> assessments=new InMemoryRepository<>();
 private final AcademicLegacyApi academic=new AcademicLegacyApi();
 private final EmailLegacyApi email=new EmailLegacyApi();
 private final AcademicPublisher publisher=new AcademicPublisher();
 private final AverageCalculator average=new AverageCalculator();
 private final EnrollmentService enrollment;
 private final GradeService grades;
 private final ClassClosingService classClosing;

 public EduSmartService(){
  publisher.subscribe(new StudentObserver());
  publisher.subscribe(new CoordinatorObserver()); // replaces previous
  enrollment=new EnrollmentService(students,classes,publisher);
  grades=new GradeService(assessments,classes,new ArrayList<>(),academic,email,publisher,average);
  classClosing=new ClassClosingService(classes,grades,academic,publisher);
 }

 public void enroll(String classId,String studentId){
  enrollment.enroll(classId,studentId);
 }

 public void createAssessment(Assessment a){
  grades.createAssessment(a);
 }

 public void grade(String assessmentId,String studentId,double value){
  grades.grade(assessmentId,studentId,value);
 }

 public double finalAverage(String classId,String studentId){
  return grades.finalAverage(classId,studentId);
 }

 public void closeClass(String classId){
  classClosing.closeClass(classId);
 }
}
