package io.pjj.paramvalidation.antherpackage;

import io.pjj.paramvalidation.ParamValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Slf4j
@Component
public class Factory {
    @ParamValid
    public void acceptWithMethodAnnotationAndParamAnnotation(@Valid Worker personAnnotated) {
        log.info("acceptWithMethodAnnotationAndParamAnnotation()");
    }

    @ParamValid
    protected void acceptWithMethodAnnotationWithoutParamAnnotation(Worker personAnnotated) {
        log.info("acceptWithMethodAnnotationWithoutParamAnnotation()");
    }

    protected void acceptWithoutMethodAnnotationWithParamAnnotation(@Valid Worker personAnnotated) {
        log.info("acceptWithoutMethodAnnotationWithParamAnnotation()");
    }

    protected void acceptWithoutAnnotation(Worker personAnnotated) {
        log.info("acceptWithoutAnnotation()");
    }

    @ParamValid
    public void acceptWithMethodAnnotationWith1ParamAnnotation(@Valid Worker personAnnotated, Worker personNotAnnotated) {
        log.info("acceptWithMethodAnnotationWith1ParamAnnotation()");
    }

    @ParamValid
    public void acceptWithMethodAnnotationWith2ParamAnnotation(@Valid Worker personAnnotated, @Valid Worker personNotAnnotated) {
        log.info("acceptWithMethodAnnotationWith2ParamAnnotation()");
    }

}
