package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hamcrest.HamcrestTest;
import logica.ClaseParaPruebaDeMockitoTest;

@RunWith(Suite.class)
@SuiteClasses({HamcrestTest.class, ClaseParaPruebaDeMockitoTest.class, FibonacciTest.class})
public class MySuite {}
