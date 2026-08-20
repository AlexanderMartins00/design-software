package br.edu.edusmart.service;

import static org.junit.Assert.assertEquals;

import br.edu.edusmart.legacy.AcademicLegacyApi;
import br.edu.edusmart.legacy.EmailLegacyApi;
import br.edu.edusmart.model.Assessment;
import br.edu.edusmart.model.ClassGroup;
import br.edu.edusmart.model.Grade;
import br.edu.edusmart.patterns.observer.AcademicPublisher;
import br.edu.edusmart.patterns.strategy.AverageCalculator;
import br.edu.edusmart.repository.InMemoryRepository;
import java.util.ArrayList;
import org.junit.Test;

public class GradeServiceTest {
 @Test
 public void calculatesTheSameAverageAsTheLegacyService() {
  InMemoryRepository<Assessment> assessments = new InMemoryRepository<>();
  InMemoryRepository<ClassGroup> classes = new InMemoryRepository<>();
  classes.save("T1", new ClassGroup("T1", "C1", "P1"));
  GradeService grades = new GradeService(
    assessments, classes, new ArrayList<Grade>(), new AcademicLegacyApi(),
    new EmailLegacyApi(), new AcademicPublisher(), new AverageCalculator());

  grades.createAssessment(new Assessment("AV1", "T1", "EXAM", 0.6));
  grades.createAssessment(new Assessment("AV2", "T1", "PROJECT", 0.4));
  grades.grade("AV1", "A1", 8.0);
  grades.grade("AV2", "A1", 10.0);

  assertEquals(9.0, grades.finalAverage("T1", "A1"), 0.0);
 }
}
