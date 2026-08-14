package br.edu.edusmart.patterns.factory;
import br.edu.edusmart.model.Assessment;
public class AssessmentFactory {
 public static Assessment create(String type,String id,String classId){
  if("EXAM".equals(type)) return new Assessment(id,classId,type,0.6);
  if("PROJECT".equals(type)) return new Assessment(id,classId,type,0.4);
  return new Assessment(id,classId,type,1.0);
 }
}
