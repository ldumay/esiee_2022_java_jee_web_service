package com.esiee.interfaces;

import com.esiee.models.Greeting;
import com.esiee.models.Response;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author ldumay, hmaxence, xchen
 */
public interface GreetingRest {

    public List<Greeting> getAllGreetings();

    public Greeting getGreeting(
            @PathVariable(value = "id") Long id
    ) throws Exception;

    public Greeting createGreeting(
            //@RequestParam(value = "id", required=false) Long id,
            @RequestParam(value = "content") String content
    ) throws Exception;

    public Greeting updateGreeting(
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "content") String content
    ) throws Exception;

    public Response deleteGreeting(
            @PathVariable(value = "id") Long id
    ) throws Exception ;
}
