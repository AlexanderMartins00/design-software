package br.edu.edusmart.service;

import br.edu.edusmart.legacy.AcademicLegacyApi;
import br.edu.edusmart.legacy.EmailLegacyApi;
import br.edu.edusmart.model.Assessment;
import br.edu.edusmart.model.ClassGroup;
import br.edu.edusmart.model.Grade;
import br.edu.edusmart.patterns.observer.AcademicPublisher;
import br.edu.edusmart.patterns.strategy.AverageCalculator;
import br.edu.edusmart.repository.InMemoryRepository;
import java.util.ArrayList;
import java.util.List;

public class GradeService {
 private final InMemoryRepository<Assessment> assessments;
 private final InMemoryRepository<ClassGroup> classes;
 private final List<Grade> grades;
 private final AcademicLegacyApi academic;
 private final EmailLegacyApi email;
 private final AcademicPublisher publisher;
 private final AverageCalculator average;

 public GradeService(InMemoryRepository<Assessment> assessments, InMemoryRepository<ClassGroup> classes, List<Grade> grades,
                     AcademicLegacyApi academic, EmailLegacyApi email, AcademicPublisher publisher, AverageCalculator average) {
  this.assessments = assessments;
  this.classes = classes;
  this.grades = grades;
  this.academic = academic;
  this.email = email;
  this.publisher = publisher;
  this.average = average;
 }

 public void createAssessment(Assessment assessment) {
  assessments.save(assessment.id, assessment);
  ClassGroup c = classes.find(assessment.classId);
  if (c != null) c.assessmentIds.add(assessment.id);
 }

 public void grade(String assessmentId, String studentId, double value) {
  Assessment assessment = assessments.find(assessmentId);
  if (assessment == null) return;
  grades.add(new Grade(assessmentId, studentId, value));
  academic.enviarNota(studentId, assessment.classId, value);
  email.send("aluno@exemplo.com", "Nota lançada: " + value);
  publisher.publish(studentId, "GRADE_PUBLISHED");
 }

 public double finalAverage(String classId, String studentId) {
  if (classes.find(classId) == null) return 0;
  List<Double> values = new ArrayList<>();
  for (Grade grade : grades) {
   Assessment assessment = assessments.find(grade.assessmentId);
   if (assessment != null && classId.equals(assessment.classId) && studentId.equals(grade.studentId)) values.add(grade.value);
  }
  return average.calculate(values);
 }
}
