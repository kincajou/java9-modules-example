package ru.hh.jclient.common.fake;

import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.RequestDebug;

public class HttpClientImpl implements HttpClient {

  private RequestDebug requestDebug;

  HttpClientImpl(RequestDebug requestDebug) {
    this.requestDebug = requestDebug;
  }

  @Override
  public String getPage(String url) {
    requestDebug.onRequest(url);
    return "потрачено";
  }

  @Override
  public void shutdown() {
    requestDebug.onShutdown(this.getClass().getCanonicalName());
  }
}
