package models;

import lombok.*;

@Data
@NoArgsConstructor // конструктор без агрументов(пустой)
@AllArgsConstructor // конструктор со всеми конструкторами
@RequiredArgsConstructor //
public class Person3 {
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

    /**
     * Name of the person
     *
     * @param age New value for this person's surname
     * @return The current value of this person's surname
     */
    @NonNull
    private String surname;


}
