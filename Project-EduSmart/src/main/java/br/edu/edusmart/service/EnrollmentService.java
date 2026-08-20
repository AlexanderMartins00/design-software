package br.edu.edusmart.service;

import br.edu.edusmart.model.ClassGroup;
import br.edu.edusmart.model.Student;
import br.edu.edusmart.patterns.observer.AcademicPublisher;
import br.edu.edusmart.repository.InMemoryRepository;

public class EnrollmentService {
 private final InMemoryRepository<Student> students;
 private final InMemoryRepository<ClassGroup> classes;
 private final AcademicPublisher publisher;

 public EnrollmentService(InMemoryRepository<Student> students, InMemoryRepository<ClassGroup> classes, AcademicPublisher publisher) {
  this.students = students;
  this.classes = classes;
  this.publisher = publisher;
 }

 public void enroll(String classId, String studentId) {
  ClassGroup c = classes.find(classId);
  Student s = students.find(studentId);
  if (c == null || s == null) return;
  c.studentIds.add(studentId);
  publisher.publish(classId, "STUDENT_ENROLLED");
 }
}
