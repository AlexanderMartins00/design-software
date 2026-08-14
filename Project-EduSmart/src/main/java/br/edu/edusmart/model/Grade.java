package br.edu.edusmart.model;
public class Grade {
 public String assessmentId; public String studentId; public double value;
 public Grade(String assessmentId,String studentId,double value){
  this.assessmentId=assessmentId;this.studentId=studentId;this.value=value;
 }
}
