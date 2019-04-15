package io.pjj.paramvalidation.antherpackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ValidationConfiguration.class)
public class ValidatorTest {
    @Autowired
    private Factory factory;

    @Test(expected = IllegalArgumentException.class)
    public void whenAcceptWithMethodAnnotationAndParamAnnotation_thenShouldThrowException() {
        Worker worker = Worker.builder().name(null).age(38).build();
        factory.acceptWithMethodAnnotationAndParamAnnotation(worker);
    }

    @Test
    public void whenAcceptWithMethodAnnotationWithoutParamAnnotation_thenShouldPass() {
        Worker worker = Worker.builder().name(null).age(38).build();
        factory.acceptWithMethodAnnotationWithoutParamAnnotation(worker);
        assertTrue(true);
    }

    @Test
    public void whenAcceptWithoutMethodAnnotationWithParamAnnotation_thenShouldPass() {
        Worker worker = Worker.builder().name(null).age(38).build();
        factory.acceptWithoutMethodAnnotationWithParamAnnotation(worker);
        assertTrue(true);
    }

    @Test
    public void whenAcceptWithoutAnnotation_thenShouldPass() {
        Worker worker = Worker.builder().name(null).age(38).build();
        factory.acceptWithoutAnnotation(worker);
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAcceptWith1ValidParam1InvalidOnSingleParamAnnotation_thenShouldThrowException() {
        Worker workerInvalid = Worker.builder().name(null).age(38).build();
        Worker workerValid = Worker.builder().name("pjj").age(38).build();
        factory.acceptWithMethodAnnotationWith1ParamAnnotation(workerInvalid, workerValid);
    }

    @Test
    public void whenAcceptWith1InvalidParam1ValidOnSingleParamAnnotation_thenShouldPass() {
        Worker workerInvalid = Worker.builder().name(null).age(38).build();
        Worker workerValid = Worker.builder().name("pjj").age(38).build();
        factory.acceptWithMethodAnnotationWith1ParamAnnotation(workerValid, workerInvalid);
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAcceptWith1ValidParam1InvalidOn2ParamsAnnotation_thenShouldThrowException() {
        Worker workerInvalid = Worker.builder().name(null).age(38).build();
        Worker workerValid = Worker.builder().name("pjj").age(38).build();
        factory.acceptWithMethodAnnotationWith2ParamAnnotation(workerInvalid, workerValid);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAcceptWith1InvalidParam1ValidOn2ParamsAnnotation_thenShouldThrowException() {
        Worker workerInvalid = Worker.builder().name(null).age(38).build();
        Worker workerValid = Worker.builder().name("pjj").age(38).build();
        factory.acceptWithMethodAnnotationWith2ParamAnnotation(workerValid, workerInvalid);
    }

}

