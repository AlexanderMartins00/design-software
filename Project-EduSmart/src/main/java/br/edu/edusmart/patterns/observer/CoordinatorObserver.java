package br.edu.edusmart.patterns.observer;
public class CoordinatorObserver implements AcademicObserver {
 public void update(String ref,String event){System.out.println("COORDINATOR "+ref+" "+event);}
}
