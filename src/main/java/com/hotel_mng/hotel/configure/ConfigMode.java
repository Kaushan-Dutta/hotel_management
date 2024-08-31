package com.hotel_mng.hotel.configure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotel_mng.hotel.interfaces.SwitchMode;

class DevMode implements SwitchMode {

    @Override
    public String getMode() {
        return "Switched to development mode";
    }
}

class ProdMode implements SwitchMode {

    @Override
    public String getMode() {
        return "Switched to production mode";
    }
}

@Configuration
public class ConfigMode {

    @Bean
    @ConditionalOnProperty(name = "app.mode", havingValue = "development")
    public SwitchMode devMode() {
        return new DevMode();
    }

    @Bean
    @ConditionalOnProperty(name = "app.mode", havingValue = "production")
    public SwitchMode prodMode() {
        return new ProdMode();
    }
}
