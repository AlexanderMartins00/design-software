package br.edu.edusmart.patterns.observer;
public class AcademicPublisher {
 private AcademicObserver observer;
 public void subscribe(AcademicObserver o){observer=o;}
 public void publish(String ref,String event){if(observer!=null)observer.update(ref,event);}
}
