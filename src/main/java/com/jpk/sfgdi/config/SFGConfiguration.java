package com.jpk.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("jpk")
@Configuration
public class SFGConfiguration {
    private String username;
    private String password;
    private String jdbcURL;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcURL() {
        return jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    @Override
    public String toString() {
        return "FakeDataSource{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jdbcURL='" + jdbcURL + '\'' +
                '}';
    }
}
