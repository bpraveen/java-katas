package none.cvg.lambdas;

import org.junit.jupiter.api.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The tests in this class aim to show how functions can be invoked as lambdas
 * and method references
 *
 * @see Function
 */
@DisplayNameGeneration(LambdasKataDisplayNames.class)
@DisplayName("Lambdas and Method Reference Basics")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestKata1LambdaBasics {

    /**
     * @see IntegerPairFactory
     * @see IntegerPair
     */
    @Test
    @Tag("TODO")
    @Order(1)
    public void newObjectUsingLambdas() {
        IntegerPair classic = new IntegerPair(10, 11);

        // TODO:
        //  Replace the anonymous class with a lambda.
        //  Hint: () -> new object()
        IntegerPairFactory integerPairFactory = () -> new IntegerPair(10, 11);

        assertEquals(classic, integerPairFactory.get(),
                "Both objects should be equal");
    }

    /**
     * @see IntegerPairFactory
     * @see IntegerPair
     */
    @Test
    @Tag("TODO")
    @Order(2)
    public void newObjectUsingMethodReferences() {
        IntegerPair classic = new IntegerPair();

        // TODO:
        //  Replace the anonymous class with a method reference.
        //  Hint: Object::new
        IntegerPairFactory integerPairFactory = IntegerPair::new;

        assertEquals(classic, integerPairFactory.get(),
                "Both objects should be equal");
    }

    /**
     * @see IntegerPair
     * @see Function
     */
    @Test
    @Tag("TODO")
    @Order(3)
    public void methodCallAsLambda() {
        IntegerPair integerPair = new IntegerPair();

        // TODO:
        //  Replace the below anonymous class with a lambda call
        //  Most IDEs allow for an automatic conversion
        //  Hint: object -> object.method()
        Function<IntegerPair, Integer> getSecond = integerPair1 -> integerPair1.getSecond();

        // TODO:
        //  Fix the assertion to return the correct expectation (6)
        //  Check API: java.util.function.Function.apply(?)
        assertEquals(6, getSecond.apply(integerPair),
                "The key should have a value of \'defaultKey\'");
    }

    /**
     * @see IntegerPair
     * @see Function
     */
    @Test
    @Tag("TODO")
    @Order(4)
    public void methodCallAsMethodReference() {
        IntegerPair integerPair = new IntegerPair();

        // TODO:
        //  Replace the below anonymous class with a method reference
        //  Most IDEs allow for an automatic conversion (no parenthesis for method)
        //  Hint: object -> Object::method
        Function<IntegerPair, Integer> getSecond = IntegerPair::getSecond;

        // TODO:
        //  Fix the assertion to return the correct expectation (6)
        //  Check API: java.util.function.Function.apply(?)
        assertEquals(6, getSecond.apply(integerPair),
                "The key should have a value of \'defaultKey\'");
    }

    @Test
    @Tag("TODO")
    @Order(5)
    public void convertAnonymousClassToLambda() {

        final AtomicInteger counter = new AtomicInteger();

        // TODO:
        //  Replace the anonymous class with a lambda. Hint: () ->
        //  The addAndGet() needs to be updated to add 1 instead of 0.
        Runnable runnable = () -> counter.addAndGet(1);

        runnable.run();

        assertEquals(1, counter.get());
    }

    @Test
    @Tag("TODO")
    @Order(6)
    public void customFunctionWithLambda() {

        int integer = 10;

        String s = Integer.toBinaryString(integer);

        // TODO:
        //  Create a Function that maps any integer into a String using a lambda syntax
        //  Do not create a new method. Replace the empty String below to invoke a toBinaryString
        //  Check API: java.util.function.Function
        //  Check API: java.util.function.Function.apply(?)
        Function<Integer, String> toBinaryStringFunction = integer1 -> Integer.toBinaryString(integer1);

        assertEquals("1010",
                toBinaryStringFunction.apply(10),
                "");

        assertEquals("11110",
                toBinaryStringFunction.apply(30),
                "");

    }

    @Test
    @Tag("TODO")
    @Order(7)
    public void customFunctionWithMethodReference() {

        // TODO:
        //  Create a Function that maps any integer into a String using a method reference
        //  Do not create a new method. Replace the lambda below to invoke a toBinaryString
        //  as a method reference
        //  Check API: java.util.function.Function
        //  Check API: java.util.function.Function.apply(?)
        //  Check API: java.lang.Integer.toBinaryString(?)
        Function<Integer, String> toBinaryStringFunction = Integer::toBinaryString;

        assertEquals("1010",
                toBinaryStringFunction.apply(10),
                "");

        assertEquals("11110",
                toBinaryStringFunction.apply(30),
                "");

    }
}
