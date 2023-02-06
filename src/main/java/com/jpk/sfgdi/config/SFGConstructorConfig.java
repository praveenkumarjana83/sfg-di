package com.jpk.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("jpk")
public class SFGConstructorConfig {
    private String username;
    private String password;
    private String jdbcURL;

    public SFGConstructorConfig(String username, String password, String jdbcURL) {
        this.jdbcURL = jdbcURL;
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcURL() {
        return jdbcURL;
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
