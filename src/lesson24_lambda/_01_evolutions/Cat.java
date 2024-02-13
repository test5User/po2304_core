package lesson24_lambda._01_evolutions;

import lombok.*;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Cat {
    private String name;
    private Breed breed;
    private int age;
}
