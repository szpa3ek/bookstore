package com.demoapp.booksfelf.reactive.router;

import com.demoapp.booksfelf.reactive.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class BookRouter {
    @Bean
    public RouterFunction<ServerResponse> bookRoute (BookHandler bookHandler) {
        return RouterFunctions
                .route(GET("/books")
                                .and(accept(MediaType.APPLICATION_JSON))
                        , bookHandler::getAllBooks);
    }
}
