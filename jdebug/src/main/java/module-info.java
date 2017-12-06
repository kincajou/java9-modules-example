import ru.hh.jclient.common.RequestDebug;
import ru.hh.jdebug.RequestDebugImpl;

module jdebug {

  requires jclient.common;
  provides RequestDebug with RequestDebugImpl;

}
