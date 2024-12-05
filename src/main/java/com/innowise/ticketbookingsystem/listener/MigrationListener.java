package com.innowise.ticketbookingsystem.listener;

import com.innowise.ticketbookingsystem.utils.FlywayUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MigrationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        FlywayUtil.runMigrations();
    }
}
