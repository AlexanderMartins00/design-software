package br.edu.edusmart.model;
public class Assessment {
 public String id; public String classId; public String type; public double weight;
 public Assessment(String id,String classId,String type,double weight){
  this.id=id;this.classId=classId;this.type=type;this.weight=weight;
 }
}
