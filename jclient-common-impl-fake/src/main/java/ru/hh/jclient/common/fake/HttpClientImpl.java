package ru.hh.jclient.common.fake;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.RequestDebug;

@Singleton
@Named("fakeClient")
public class HttpClientImpl implements HttpClient {

  private RequestDebug requestDebug;

  @Inject
  public HttpClientImpl(RequestDebug requestDebug) {
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
