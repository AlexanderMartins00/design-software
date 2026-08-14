package br.edu.edusmart.legacy;
public class AcademicLegacyApi {
 public String enviarNota(String studentId,String classId,double grade){
  return studentId+"|"+classId+"|"+grade+"|OK";
 }
}
