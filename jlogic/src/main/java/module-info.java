import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.RequestDebug;

module jlogic {

  requires jclient.common;
  requires jclient.common.impl.fake;
  requires jclient.common.impl.ning;
  requires jdebug;

  uses HttpClientFactory;
  uses RequestDebug;

}
