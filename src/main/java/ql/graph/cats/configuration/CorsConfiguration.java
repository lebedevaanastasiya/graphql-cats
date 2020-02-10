package ql.graph.cats.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfiguration {
    @Value("#{T(org.springframework.util.StringUtils).tokenizeToStringArray('${core.server.cors.allowed.origins}', ',', true, true)}")
    private List<String> corsAllowedOrigins;

    @Value("#{T(org.springframework.util.StringUtils).tokenizeToStringArray('${core.server.cors.allowed.methods}', ',', true, true)}")
    private List<String> corsAllowedMethods;

    @Value("#{T(org.springframework.util.StringUtils).tokenizeToStringArray('${core.server.cors.allowed.headers}', ',', true, true)}")
    private List<String> corsAllowedHeaders;

    @Value("#{T(org.springframework.util.StringUtils).tokenizeToStringArray('${core.server.cors.exposed.headers}', ',', true, true)}")
    private List<String> corsExposedHeaders;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        org.springframework.web.cors.CorsConfiguration configuration = new org.springframework.web.cors.CorsConfiguration();

        configuration.setAllowedOrigins(corsAllowedOrigins);
        configuration.setAllowedMethods(corsAllowedMethods);
        configuration.setAllowedHeaders(corsAllowedHeaders);
        configuration.setExposedHeaders(corsExposedHeaders);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
