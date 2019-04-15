package io.pjj.paramvalidation.antherpackage;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Worker {

    @NotNull(message = "name can not be null")
    @Length(min = 1, max = 10, message = "length should be 1-10")
    private String name;

    @Max(value = 100, message = "age should be <= 100")
    @Min(value = 0, message = "age should be >= 0")
    private int age;
}
