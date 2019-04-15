package io.pjj.paramvalidation.antherpackage;

import io.pjj.paramvalidation.EnableParamValidation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableParamValidation
public class ValidationConfiguration {
}
