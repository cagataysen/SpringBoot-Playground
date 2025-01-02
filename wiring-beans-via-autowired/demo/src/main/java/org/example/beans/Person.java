package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Alex";

    /**
     *
     * FIELD INJECTION -- NOT RECOMMENDED -- Initialization without final keyword is hard and testing: mocking problem
     *
     *@Autowired
     *private Parrot parrot;
     */
/////////////////////////////////////////////////////
    /*
    * CONSTRUCTOR INJECTION
    * */

    private final Parrot parrot; /*We can now make the field final to ensure its value cannot be changed after init*/

    @Autowired          //Autowired used over the constructor
    public Person(Parrot parrot){
        this.parrot = parrot;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Parrot getParrot() {
        return parrot;
    }

    /* After defining final to Parrot parrot object.
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
    */

}
