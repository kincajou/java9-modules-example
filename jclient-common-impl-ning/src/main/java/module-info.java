import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.ning.HttpClientFactoryImpl;

module jclient.common.impl.ning {

  requires jclient.common;
  requires async.http.client;

  provides HttpClientFactory with HttpClientFactoryImpl;
}
