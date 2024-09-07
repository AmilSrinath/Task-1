package lk.ijse.gdse.apigateway.filter;

import lk.ijse.gdse.apigateway.util.JwtUtil;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Amil Srinath
 */
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

    @Autowired
    private JwtUtil jwtUtil;

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFilter.class);

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            // Check if the route is secured
            if (validator.isSecured.test(exchange.getRequest())) {
                // Check for Authorization header
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    logger.error("Missing Authorization Header");
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing Authorization Header");
                }

                String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    logger.error("Invalid Authorization Header Format");
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Authorization Header");
                }

                String token = authHeader.substring(7); // Extract JWT token

                try {
                    jwtUtil.validateToken(token); // Validate the token
                } catch (Exception e) {
                    logger.error("Invalid JWT Token", e);
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid JWT Token");
                }
            }
            return chain.filter(exchange);
        });
    }

    public static class Config {
        // Put the configuration properties here if needed
    }
}
