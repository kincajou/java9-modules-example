package ru.hh.jclient.common;

public interface HttpClientFactory {
  HttpClient create(RequestDebug debug);
}
