package br.com.maelton.bsc.infrastructure.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import br.com.maelton.bsc.architecture.annotation.ApplicationService;

@Configuration
@ComponentScan(
    basePackages = "br.com.maelton.bsc.application",
    includeFilters = {
        @ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = ApplicationService.class
        )
    },
    useDefaultFilters = false
)
public class SpringConfiguration {

}
