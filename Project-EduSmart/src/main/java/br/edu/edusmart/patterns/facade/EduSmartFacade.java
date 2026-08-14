package br.edu.edusmart.patterns.facade;
import br.edu.edusmart.service.EduSmartService;
import br.edu.edusmart.patterns.adapter.*;
public class EduSmartFacade {
 public final EduSmartService service;
 public final AcademicSystemAdapter academic;
 public final NotificationAdapter notifications;
 public EduSmartFacade(EduSmartService s,AcademicSystemAdapter a,NotificationAdapter n){
  service=s;academic=a;notifications=n;
 }
 public void closeClass(String classId){service.closeClass(classId);}
 public EduSmartService getService(){return service;}
}
