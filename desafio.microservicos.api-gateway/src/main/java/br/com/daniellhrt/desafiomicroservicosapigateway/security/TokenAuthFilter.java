package br.com.daniellhrt.desafiomicroservicosapigateway.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TokenAuthFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(TokenAuthFilter.class);
    private static final String AUTH_TOKEN = "Bearer 12345";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        // Adicione esta linha de log para depuração
        System.out.println("DEBUG: Token recebido no cabeçalho Authorization: " + authHeader);

        logger.info("Token recebido no cabeçalho Authorization: {}", authHeader);

        if (authHeader == null || !authHeader.equals(AUTH_TOKEN)) {
            logger.warn("Requisição não autorizada. Token inválido ou ausente.");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        logger.info("Requisição autorizada. Prosseguindo na cadeia de filtros.");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}