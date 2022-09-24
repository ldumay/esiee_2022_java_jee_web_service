package com.esiee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ldumay, hmaxence, xchen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {

    private long id;
    private String content;
}
