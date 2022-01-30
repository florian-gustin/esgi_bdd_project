package esgi_bdd_project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potter.Potter;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Stepdefs {

    private List<Integer> nbs;
    private float total;


    @Given("my basket contains {string}")
    public void my_basket_contains(String string) {
        nbs = explode(string);
    }

    @When("I compute the total price")
    public void i_compute_the_total_price() {

        total = Potter.price(nbs);
    }



    @Then("I should pay {float}")
    public void i_should_pay(float int1) {
        assertEquals(int1, total);
    }



    static List<Integer> explode(String str) {
        if(str.isEmpty()) return new ArrayList<>();
        String[] myArray = str.split(",");
        List<Integer> myList = new ArrayList<>();
        for (String s : myArray) {
            myList.add(Integer.parseInt(s));
        }
        return myList;
    }

//    @DataTableType(replaceWithEmptyString = "[blank]")
//    public String stringType(String cell) {
//        return "";
//    }


}
