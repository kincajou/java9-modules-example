package ru.hh.jlogic;

import java.util.Collection;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.Proper;

public class Jlogic {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(Config.class);
    context.scan("ru.hh");
    context.refresh();

    Collection<HttpClient> clients = context.getBeansOfType(HttpClient.class).values();

    clients.forEach(Jlogic::request);

    context.getBeansWithAnnotation(Proper.class).values().forEach(c -> ((HttpClient)c).shutdown());
  }

  private static void request(HttpClient client) {
    String page = client.getPage("http://www.google.com");
    System.out.println("[" + client.getClass() + "]: " + page);
  }
}
