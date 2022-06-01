package models;

import lombok.*;

@Builder
@ToString//(exclude = "UUID") // Исключить это поле из вывода
@EqualsAndHashCode(exclude = "UUID") // нужно всегда при сравнении исключать айдишки
public class PersonBuilder {
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

    private int UUID;
}
