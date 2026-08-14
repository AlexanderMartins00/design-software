package br.edu.edusmart.patterns.adapter;
import br.edu.edusmart.legacy.EmailLegacyApi;
public class NotificationAdapter {
 private final EmailLegacyApi legacy=new EmailLegacyApi();
 public void notify(String email,String message){legacy.send(email,message);}
 public EmailLegacyApi legacy(){return legacy;}
}
