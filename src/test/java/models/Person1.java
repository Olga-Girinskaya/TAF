package models;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor // конструктор без агрументов(пустой)
@AllArgsConstructor // конструктор со всеми конструкторами
public class Person1 {
    /**
     * Age of the person
     *
     * @param age New value for this person's age
     * @return The current value of this person's age
     */
     private int age;

    /**
     * Name of the person
     *
     * @param age New value for this person's name
     * @return The current value of this person's name
     */
    private String name;

}
