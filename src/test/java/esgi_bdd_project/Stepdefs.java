package esgi_bdd_project;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potter.Basket;
import potter.Book;
import potter.Books;
import potter.Potter;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Stepdefs {

    private List<Integer> nbs;
    private double total;
    private static Basket basket;
    private static Books books;


    @Before
    public void init() {
        basket = new Basket();
        books = new Books();
    }

    @Given("the list of books {string}")
    public void the_list_of_books(String string) {
        books = new Books();
        nbs = explode(string);
    }
    @When("I compute the price")
    public void i_compute_the_price() {
        BigDecimal bg = new BigDecimal(basket.estimate()).setScale(2, RoundingMode.HALF_UP);
        total = bg.doubleValue();
    }

    @Then("I should pay {double}")
    public void i_should_pay(double int1) {
        assertEquals(int1, total);
    }

    static List<Integer> explode(String str) {
        if(str.isEmpty()) return new ArrayList<>();
        String[] myArray = str.split(",");
        List<Integer> myList = new ArrayList<>();
        for (String s : myArray) {
            Book book = new Book();
            book.tome = Integer.parseInt(s);
            books.add(book);
            basket.addBook(book);
            myList.add(Integer.parseInt(s));
        }
        return myList;
    }

//    @DataTableType(replaceWithEmptyString = "[blank]")
//    public String stringType(String cell) {
//        return "";
//    }


}
