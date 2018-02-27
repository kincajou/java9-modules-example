package ru.hh.jlogic;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hh.jclient.common.HttpClient;
import ru.hh.jclient.common.RequestDebug;
import ru.hh.jclient.common.ning.HttpClientImpl;
import ru.hh.jdebug.RequestDebugImpl;

@Configuration
public class Config {

  @Bean
  public RequestDebug requestDebug() {
    return new RequestDebugImpl();
  }

  @Bean
  public AsyncHttpClient ning() {
    return new DefaultAsyncHttpClient();
  }

  @Bean
  public HttpClient ningClient() {
    return new HttpClientImpl(requestDebug(), ning());
  }
}
