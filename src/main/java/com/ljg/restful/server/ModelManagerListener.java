package com.ljg.restful.server;

import com.ljg.restful.model.ModelManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 *  当tomcat容器启动的时候，初始化
 *  放一些类 比如model manager只需要存在一个示例  以及关闭的时候需要关闭的资源的放进这个类中
 *
 */
@WebListener
public final class ModelManagerListener implements ServletContextListener{

    private static final Logger log = LoggerFactory.getLogger(ModelManagerListener.class);

    private ModelManager modelManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...");
        ServletContext servletContext = sce.getServletContext();
        String initparam = servletContext.getInitParameter("param");
        System.out.println("initparam:"+initparam);
        modelManager = new ModelManager(initparam);
        modelManager.start();
        servletContext.setAttribute("com.ljg.restful.model.ModelManager",modelManager);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed...");
        if (modelManager != null){
            modelManager.close();
        }

    }


}
