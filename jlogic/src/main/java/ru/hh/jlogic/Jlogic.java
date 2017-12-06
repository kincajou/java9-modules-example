package ru.hh.jlogic;

import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.RequestDebug;

import java.security.Provider;
import java.util.ServiceLoader;

public class Jlogic {

  public static void main(String[] args) {
    ServiceLoader<RequestDebug> requestDebugServiceLoader = ServiceLoader.load(RequestDebug.class);
    RequestDebug requestDebug = requestDebugServiceLoader.stream().findFirst().orElseThrow(() -> new IllegalStateException("Failed to find request debug impl")).get();

    ServiceLoader.load(HttpClientFactory.class).forEach(f -> requestAndPrint(requestDebug, f));
  }

  private static void requestAndPrint(RequestDebug requestDebug, HttpClientFactory factory) {
    HttpClient client = factory.create(requestDebug);
    String page = client.getPage("http://www.google.com");
    System.out.println("[" + client.getClass() + "]: " + page);
  }
}
