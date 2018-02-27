module jclient.common.impl.ning {

  requires jclient.common;

  // do not need "transitive" on automatic module
  requires transitive async.http.client;

  exports ru.hh.jclient.common.ning;
}
