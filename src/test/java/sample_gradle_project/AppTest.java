/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package sample_gradle_project;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertEquals("Hello world.", classUnderTest.getGreeting());
    }

    @Test public void testGetNameAndAge() {
        App classUnderTest = new App();
        assertEquals("My name is Sample java application and my age is young as you are", classUnderTest.getNameAndAge());
    }
}
