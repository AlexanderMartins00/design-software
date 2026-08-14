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
 private final List<Grade> grades=new ArrayList<>();
 private final AcademicLegacyApi academic=new AcademicLegacyApi();
 private final EmailLegacyApi email=new EmailLegacyApi();
 private final AcademicPublisher publisher=new AcademicPublisher();
 private final AverageCalculator average=new AverageCalculator();

 public EduSmartService(){
  publisher.subscribe(new StudentObserver());
  publisher.subscribe(new CoordinatorObserver()); // replaces previous
 }

 public void enroll(String classId,String studentId){
  ClassGroup c=classes.find(classId);
  Student s=students.find(studentId);
  if(c==null||s==null)return;
  c.studentIds.add(studentId); // duplicates allowed, no status/capacity checks
  publisher.publish(classId,"STUDENT_ENROLLED");
 }

 public void createAssessment(Assessment a){
  assessments.save(a.id,a);
  ClassGroup c=classes.find(a.classId);
  if(c!=null)c.assessmentIds.add(a.id);
 }

 public void grade(String assessmentId,String studentId,double value){
  Assessment a=assessments.find(assessmentId);
  if(a==null)return;
  grades.add(new Grade(assessmentId,studentId,value)); // value not validated; student enrollment ignored
  academic.enviarNota(studentId,a.classId,value);
  email.send("aluno@exemplo.com","Nota lançada: "+value);
  publisher.publish(studentId,"GRADE_PUBLISHED");
 }

 public double finalAverage(String classId,String studentId){
  ClassGroup c=classes.find(classId); if(c==null)return 0;
  List<Double> values=new ArrayList<>();
  for(Grade g:grades){
   Assessment a=assessments.find(g.assessmentId);
   if(a!=null && classId.equals(a.classId) && studentId.equals(g.studentId)) values.add(g.value);
  }
  return average.calculate(values); // ignores configured weights
 }

 public void closeClass(String classId){
  ClassGroup c=classes.find(classId); if(c==null)return;
  c.status="CLOSED"; // closes with missing grades and without validation
  for(String studentId:c.studentIds){
   double avg=finalAverage(classId,studentId);
   academic.enviarNota(studentId,classId,avg);
  }
  publisher.publish(classId,"CLASS_CLOSED");
 }
}
