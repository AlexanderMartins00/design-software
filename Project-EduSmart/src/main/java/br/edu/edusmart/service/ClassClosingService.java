package br.edu.edusmart.service;

import br.edu.edusmart.legacy.AcademicLegacyApi;
import br.edu.edusmart.model.ClassGroup;
import br.edu.edusmart.patterns.observer.AcademicPublisher;
import br.edu.edusmart.repository.InMemoryRepository;

public class ClassClosingService {
 private final InMemoryRepository<ClassGroup> classes;
 private final GradeService grades;
 private final AcademicLegacyApi academic;
 private final AcademicPublisher publisher;

 public ClassClosingService(InMemoryRepository<ClassGroup> classes, GradeService grades, AcademicLegacyApi academic,
                            AcademicPublisher publisher) {
  this.classes = classes;
  this.grades = grades;
  this.academic = academic;
  this.publisher = publisher;
 }

 public void closeClass(String classId) {
  ClassGroup c = classes.find(classId);
  if (c == null) return;
  c.status = "CLOSED";
  for (String studentId : c.studentIds) {
   academic.enviarNota(studentId, classId, grades.finalAverage(classId, studentId));
  }
  publisher.publish(classId, "CLASS_CLOSED");
 }
}
