package ru.hh.jclient.common.ning;

import java.io.IOException;
import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.Proper;
import ru.hh.jclient.common.RequestDebug;
import org.asynchttpclient.AsyncHttpClient;

import java.util.concurrent.ExecutionException;

@Proper
public class HttpClientImpl implements HttpClient {

  private RequestDebug requestDebug;
  private AsyncHttpClient http;

  public HttpClientImpl(RequestDebug requestDebug, AsyncHttpClient http) {
    this.requestDebug = requestDebug;
    this.http = http;
  }

  @Override
  public String getPage(String url) {
    requestDebug.onRequest(url);
    try {
      return http.prepareGet(url).execute().get().getResponseBody();
    }
    catch (InterruptedException | ExecutionException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }

  @Override
  public void shutdown() {
    requestDebug.onShutdown(this.getClass().getCanonicalName());
    try {
      http.close();
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
