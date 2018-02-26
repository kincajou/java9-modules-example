package ru.hh.jclient.common.ning;

import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.Proper;
import ru.hh.jclient.common.RequestDebug;

@Proper
public class HttpClientFactoryImpl implements HttpClientFactory {

  @Override
  public HttpClient create(RequestDebug debug) {
    return new HttpClientImpl(debug);
  }

}
