package com.ljg.restful;

import com.ljg.restful.Util.JVMUtils;
import com.ljg.restful.server.TomcatLoadServer;
import com.ljg.restful.setting.ConfigUtils;


public final class Main {

  private Main() {}

  public static void main(String[] args) throws Exception {
    try (TomcatLoadServer tomcatLoadServer = new TomcatLoadServer(ConfigUtils.getDefault())) {
      JVMUtils.closeAtShutdown(tomcatLoadServer);
      tomcatLoadServer.start();
      tomcatLoadServer.await();
    }
  }
}
