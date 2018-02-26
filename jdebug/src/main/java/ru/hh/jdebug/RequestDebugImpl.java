package ru.hh.jdebug;

import ru.hh.jclient.common.RequestDebug;

public class RequestDebugImpl implements RequestDebug {

  @Override
  public void onRequest(String url) {
    System.out.println(url);
  }

  @Override
  public void onShutdown(String name) {
    System.out.println("shutting down: " + name);
  }
}
