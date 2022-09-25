package com.esiee.services;

import com.esiee.interfaces.GreetingModel;
import com.esiee.models.Greeting;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ldumay, hmaxence, zchen
 */
@Data
@RestController
public class GreetingService implements GreetingModel {

    private String info = "[GreetingService] ";
    private static List<Greeting> greetings;
    private final String greetingNotFound = "Greeting not found";

    /**
     * Constructor
     */
    public GreetingService(List<Greeting> greetings) {
        this.greetings = greetings;
        //-
        System.out.println(info + "Ready!");
    }

    /**
     * Méthode d'obtention de la liste des objets Greeting.
     * @return List<Greeting>
     *
     * -> Testé et fonctionnel
     */
    @Override
    @GetMapping("/greeting/all/")
    public List<Greeting> getAllGreetings() {
        System.out.println(info + "Get all greetings : " + greetings.size());
        return greetings;
    }

    /**
     * Méthode d'obtention d'un objet Greeting via son id.
     * @param id
     * @return Greeting
     *
     * -> Testé et fonctionnel
     */
    @Override
    @GetMapping("/greeting/getById/{id}")
    public Greeting getGreetings(@PathVariable long id) {
        Greeting greetingSelected = null;
        System.out.println(info + "Get greeting:" + id);
        greetingSelected = greetings.get((int) id-1);
        System.out.println(info + "Greeting found:" + greetingSelected);
        return greetingSelected;
    }

    /**
     * Méthode d'obtention d'un objet Greeting via son contenu.
     * @param content
     * @return Greeting
     *
     * -> Testé et fonctionnel
     */
    @GetMapping("/greeting/getByContent/{content}")
    public Greeting getGreetingsByContent(@PathVariable String content) {
        Greeting greetingSelected = null;
        System.out.println(info + "Get greeting by content:" + content);
        for (Greeting greeting : greetings) {
            if (greeting.getContent().equals(content)) {
                greetingSelected = greeting;
            }
        }
        System.out.println(info + "Greeting found:" + greetingSelected);
        return greetingSelected;
    }

    /**
     * Méthode d'obtention d'un objet Greeting via son contenu.
     * @param content
     * @return String
     *
     * -> Testé et fonctionnel
     */
    @GetMapping("/greeting/getByContentToString/{content}")
    public String getGreetingsByContentToString(@PathVariable String content) {
        String result = greetingNotFound;
        System.out.println(info + "Get greeting by content to string:" + content);
        for (Greeting greeting : greetings) {
            if (greeting.getContent().equals(content)) {
                result = greeting.toString();
            }
        }
        System.out.println(info + "Greeting found:" + result);
        return result;
    }

    /**
     * Méthode de création d'un objet Greeting.
     * @param greeting : Greeting @RequestBody
     * @return Greeting
     *
     * -> Testé et fonctionnel
     */
    // not working
//    @RequestMapping(value = "/greeting/create/", method = { RequestMethod.GET, RequestMethod.POST })
    @PostMapping("/greeting/create/")
    public String createGreetingWithObject(@RequestBody Greeting greeting) {
        boolean isExist = false;
        String result = "Error! Greeting not created.";
        try{
            for(Greeting g : greetings){
                if (g.getContent().equals(greeting.getContent())) {
                    isExist = true;
                    result = "Error! Greeting already exist.";
                    break;
                }
            }
            if(!isExist){
                int number = greetings.size()+1;
                greeting.setId(number);
                greetings.add(greeting);
                result = "Greeting " + greeting.toString() + "created.";
                System.out.println(info
                        + "Create greeting:" + number
                        + " with content:" + greeting.getContent());
            }
        } catch (Exception e) {

            System.out.println(info + "Error while creating greeting:" + e);
        }
        return result;
    }

    /**
     * Méthode de création d'un objet Greeting via son contenu.
     */
    @Override
//    @PostMapping("/greeting/create/{content}")
    @RequestMapping(value = "/greeting/create/{content}", method = { RequestMethod.GET, RequestMethod.POST })
    public void createGreeting(@PathVariable String content) {
        int number = (greetings.size()>=0) ? greetings.size()+1 : 0;
        System.out.println(info + "Create greeting:" + number + " with content:" + content);
        greetings.add(new Greeting(number, content));
    }

    /**
     * ❌❌❌
     * Méthode de mise à jour d'un objet Greeting via son id et son contenu.
     * @param id
     * @param content
     * @return Greeting
     *
     * -> Non testé et non fonctionnel
     */
    @Override
//    @PutMapping("/greeting/update/id={id}&content={content}")
    @RequestMapping(value = "/greeting/update/{id}/{content}", method = { RequestMethod.GET })
    public void updateGreeting(@PathVariable long id, @PathVariable String content) {

        long localId = (id>0)?id-1:0;
        System.out.println(info + "Update greeting:" + localId);
        greetings.set((int) localId, new Greeting(id, content));
    }

    /**
     * Méthode de suppression d'un objet Greeting via l'objet Greeting.
     * @param greeting : Greeting @RequestBody
     *
     * -> Testé et fonctionnel
     */
    @PutMapping("/greeting/update/")
    public String updateGreeting(@RequestBody Greeting greeting) {
        String result = greetingNotFound;
        try{
            System.out.println(info + "Update greeting:" + greeting.getId());
            for(Greeting g : greetings){
                if(g.getId() == greeting.getId()){
                    g.setContent(greeting.getContent());
                    result = "Greeting " + g.getId() + " updated";
                }
            }
        } catch (Exception e) {
            System.out.println(info + "Update greeting:" + greeting.getId() + " failed");
        }
        return result;
    }

    /**
     * Méthode de suppression d'un objet Greeting via son id.
     * @param id
     *
     * -> Testé et fonctionnel
     */
    @Override
    @RequestMapping(value = "/greeting/delete/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public void deleteGreeting(@PathVariable long id) {
        greetings.remove((int) id-1);
        System.out.println(info + "Remove greeting:" + id);
    }

    /**
     * Méthode de suppression d'un objet Greeting via son id.
     * @param id
     *
     * -> Testé et fonctionnel
     */
    @RequestMapping(value = "/greeting/deleteById/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public String deleteGreetingById(@PathVariable long id) {
        String result = greetingNotFound;
        try{
            greetings.remove((int) id-1);
            System.out.println(info + "Remove greeting:" + id);
            result = "Greeting " + id + " removed";
        } catch (Exception e) {
            System.out.println(info + "Remove greeting:" + id + " failed");
        }
        return result;
    }

    /**
     * Méthode de suppression d'un objet Greeting via son contenu.
     * @param content
     *
     * -> Testé et fonctionnel
     */
    @RequestMapping(value = "/greeting/deleteByContent/{content}", method = { RequestMethod.GET, RequestMethod.POST })
    public String deleteGreetingByContent(@PathVariable String content) {
        String result = greetingNotFound;
        try{
            greetings.remove(getGreetingsByContent(content));
            System.out.println(info + "Remove greeting:" + content);
            result = "Greeting " + content + " removed";
        } catch (Exception e) {
            System.out.println(info + "Remove greeting:" + content + " failed");
        }
        return result;
    }
}
