package ru.hh.jlogic;

import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.Proper;
import ru.hh.jclient.common.RequestDebug;

import java.util.ServiceLoader;

public class Jlogic {

  public static void main(String[] args) {
    ServiceLoader<RequestDebug> requestDebugServiceLoader = ServiceLoader.load(RequestDebug.class);
    RequestDebug requestDebug = requestDebugServiceLoader.findFirst()
      .orElseThrow(() -> new IllegalStateException("Failed to find request debug impl"));

    ServiceLoader<HttpClientFactory> httpClientFactoryServiceLoader = ServiceLoader.load(HttpClientFactory.class);

    httpClientFactoryServiceLoader.forEach(f -> request(requestDebug, f));

    // find annotated by @Proper and call shutdown
    httpClientFactoryServiceLoader
      .stream()
      .filter(provider -> provider.type().isAnnotationPresent(Proper.class)) // inspect before instantiation
      .map(ServiceLoader.Provider::get)
      .forEach(factory -> factory.create(requestDebug).shutdown());
  }

  private static void request(RequestDebug requestDebug, HttpClientFactory factory) {
    HttpClient client = factory.create(requestDebug);
    String page = client.getPage("http://www.google.com");
    System.out.println("[" + client.getClass() + "]: " + page);
    client.shutdown();
  }
}
