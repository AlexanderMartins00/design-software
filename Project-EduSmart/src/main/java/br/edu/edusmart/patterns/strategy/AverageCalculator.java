package br.edu.edusmart.patterns.strategy;
import java.util.*;
public class AverageCalculator {
 private AverageStrategy strategy;
 public void setStrategy(AverageStrategy s){strategy=s;}
 public double calculate(List<Double> grades){
  if(grades.isEmpty()) return 0;
  if(grades.size()==2) return (grades.get(0)+grades.get(1))/2.0;
  double sum=0; for(double g:grades) sum+=g;
  return strategy==null?sum/grades.size():strategy.calculate(grades);
 }
}
