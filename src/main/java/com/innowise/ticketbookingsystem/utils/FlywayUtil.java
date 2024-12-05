package com.innowise.ticketbookingsystem.utils;

import com.innowise.ticketbookingsystem.exceptions.MigrationsException;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;

@Slf4j
public class FlywayUtil {
    public static void runMigrations() {
        log.info("Начало применения миграций");

        try {
            String url = PropertiesUtils.getProperty("db.url");
            String username = PropertiesUtils.getProperty("db.username");
            String password = PropertiesUtils.getProperty("db.password");
            String locations = PropertiesUtils.getProperty("flyway.locations");


            Flyway flyway = Flyway.configure()
                    .dataSource(url, username, password)
                    .locations(locations != null ? locations : "classpath:db/migration")
                    .load();

            flyway.migrate();

            log.info("Миграция применена успешно");
        } catch (Exception e) {
            log.error("Ошибка во время применения миграции");
            e.printStackTrace();
            throw new MigrationsException("Ошибка во время применения миграции", e);
        }
    }
}
