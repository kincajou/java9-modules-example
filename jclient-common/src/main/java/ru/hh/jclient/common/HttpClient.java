package ru.hh.jclient.common;

public interface HttpClient {
  String getPage(String url);
  void shutdown();
}
