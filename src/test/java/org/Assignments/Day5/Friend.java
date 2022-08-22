package org.Assignments.Day5;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friend {
    private String firstname;
    private String lastname;
    private Integer id;
    private Integer age;
}
