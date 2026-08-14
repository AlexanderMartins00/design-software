package br.edu.edusmart.patterns.adapter;
import br.edu.edusmart.legacy.AcademicLegacyApi;
public class AcademicSystemAdapter extends AcademicLegacyApi {
 public boolean publishGrade(String studentId,String classId,double grade){
  return enviarNota(studentId,classId,grade).endsWith("OK");
 }
 public String raw(String studentId,String classId,double grade){
  return enviarNota(studentId,classId,grade);
 }
}
