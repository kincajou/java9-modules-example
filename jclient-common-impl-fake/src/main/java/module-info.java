import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.fake.HttpClientFactoryImpl;

module jclient.common.impl.fake {

  requires jclient.common;
  provides HttpClientFactory with HttpClientFactoryImpl;

}
