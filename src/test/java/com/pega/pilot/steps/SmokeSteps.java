package com.pega.pilot.steps;

import io.cucumber.java.en.Given;

public class SmokeSteps {

    @Given("irgendwas")
    public void irgendwas() {
        System.out.println("SMOKE OK");
    }
}