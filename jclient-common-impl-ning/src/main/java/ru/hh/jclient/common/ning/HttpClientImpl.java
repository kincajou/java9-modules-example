package ru.hh.jclient.common.ning;

import org.asynchttpclient.DefaultAsyncHttpClient;
import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.Proper;
import ru.hh.jclient.common.RequestDebug;
import org.asynchttpclient.AsyncHttpClient;

import java.util.concurrent.ExecutionException;

@Proper
public class HttpClientImpl implements HttpClient {

  private RequestDebug requestDebug;
  private AsyncHttpClient http;

  HttpClientImpl(RequestDebug requestDebug) {
    this.requestDebug = requestDebug;
    this.http = new DefaultAsyncHttpClient();
  }

  @Override
  public String getPage(String url) {
    requestDebug.onRequest(url);
    try {
      return http.prepareGet(url).execute().get().getResponseBody();
    }
    catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }
  }
}
