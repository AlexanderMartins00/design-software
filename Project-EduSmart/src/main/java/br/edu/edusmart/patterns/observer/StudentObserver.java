package br.edu.edusmart.patterns.observer;
public class StudentObserver implements AcademicObserver {
 public void update(String ref,String event){System.out.println("STUDENT "+ref+" "+event);}
}
