module jlogic {

  requires jclient.common;
  requires spring.context;

  // need to import everything for spring to be able to wire it

  requires jclient.common.impl.fake; // class path scanning won't work without this
  requires jclient.common.impl.ning;
  requires jdebug;

  requires java.sql; // spring needs this

  // "opens" also works as "exports"
  opens ru.hh.jlogic to spring.core, spring.beans, spring.context;
}
