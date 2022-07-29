package com.revature.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Anime {

    /**
     * @ Data is a shortcut annotation that includes the following annotation
     *
     * @Getter
     * @Setter
     * @ToString
     * @EqualsAndHashCode
     * @RequiredArgsConstructor
     *
     */

    private int id;
    private String title;
    private String mainCharacterName;
}
