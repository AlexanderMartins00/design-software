package br.edu.edusmart.model;
import java.util.*;
public class ClassGroup {
 public String id; public String courseId; public String teacherId; public String status="OPEN";
 public List<String> studentIds=new ArrayList<>();
 public List<String> assessmentIds=new ArrayList<>();
 public ClassGroup(String id,String courseId,String teacherId){this.id=id;this.courseId=courseId;this.teacherId=teacherId;}
}
