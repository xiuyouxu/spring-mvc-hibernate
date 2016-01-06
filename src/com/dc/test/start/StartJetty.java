package com.dc.test.start;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartJetty {

	private static StartJetty sj = null;

	private StartJetty() {

	}

	public static StartJetty getInstance() {
		if (sj == null) {
			sj = new StartJetty();
		}
		return sj;
	}

	public void startJetty() {

		Server server = new Server();
		Connector connector = new SelectChannelConnector();
		connector.setPort(8080);
		server.setConnectors(new Connector[] { connector });
		server.setStopAtShutdown(true);

		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/springmvc");
		webapp.setResourceBase("E:/work2upload/spring-mvc/WebRoot");
		webapp.setDescriptor("E:/work2upload/spring-mvc/WebRoot/WEB-INF/web.xml");
		webapp.setParentLoaderPriority(true);
		webapp.setClassLoader(Thread.currentThread().getContextClassLoader());
		// 默认不抛出启动时异常，修改为抛出
		webapp.setThrowUnavailableOnStartupException(true);

		ServletHandler servletHandler = new ServletHandler();
		// 所有servlet没有错误时才能启动成功
		servletHandler.setStartWithUnavailable(false);
		webapp.setServletHandler(servletHandler);
		server.setHandler(webapp);

		HandlerCollection hc = new HandlerCollection();
		ContextHandlerCollection chc = new ContextHandlerCollection();
		hc.setHandlers(new Handler[] { chc });
		server.setHandler(hc);
		chc.addHandler(webapp);

		try {
			server.start();
			System.out.println("======================================");
			System.out.println("spring mvc has been started.");
			System.out.println("======================================");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("启动Jetty服务器出错！");
		}
	}
}
