package br.edu.edusmart.patterns.abstractfactory;
import br.edu.edusmart.legacy.*;
public class LearningFamilyFactory {
 public Object academicSystem(String family){return new AcademicLegacyApi();}
 public Object notification(String family){return new EmailLegacyApi();}
 public Object secondaryNotification(String family){return new SmsLegacyApi();}
}
