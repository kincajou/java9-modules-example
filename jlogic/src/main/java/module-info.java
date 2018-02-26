import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.RequestDebug;

module jlogic {

  requires jclient.common;

  // no need to require implementations, ServiceLoader 'ioc' will find and bind them

  // requires jclient.common.impl.fake;
  // requires jclient.common.impl.ning;
  // requires jdebug;

  uses HttpClientFactory;
  uses RequestDebug;

}
