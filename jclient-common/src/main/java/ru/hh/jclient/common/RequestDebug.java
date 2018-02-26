package ru.hh.jclient.common;

public interface RequestDebug {
  void onRequest(String url);
  void onShutdown(String name);
}
