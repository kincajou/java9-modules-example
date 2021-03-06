package ru.hh.jclient.common.fake;

import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.RequestDebug;

public class HttpClientFactoryImpl implements HttpClientFactory {

  @Override
  public HttpClient create(RequestDebug debug) {
    return new HttpClientImpl(debug);
  }

}
