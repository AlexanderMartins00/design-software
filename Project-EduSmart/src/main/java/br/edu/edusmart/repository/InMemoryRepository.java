package br.edu.edusmart.repository;
import java.util.*;
public class InMemoryRepository<T> {
 private final Map<String,T> data=new HashMap<>();
 public void save(String id,T value){data.put(id,value);}
 public T find(String id){return data.get(id);}
 public Collection<T> all(){return data.values();}
}
