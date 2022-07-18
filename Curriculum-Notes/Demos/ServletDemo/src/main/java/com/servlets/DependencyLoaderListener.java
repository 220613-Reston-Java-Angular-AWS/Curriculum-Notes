package com.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized() - this method in the DependencyLoaderListener has been run");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed() - this method in the DependencyLoaderListener has been run");
    }
}
