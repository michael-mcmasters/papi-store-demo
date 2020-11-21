// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing the Assert Class from the org.junit package or folder
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// This is a public class called Papi
    public class PapiStoreTest {

        PapiStore papiStore;

        // This creates the object that the following test functions for.
        // It sets the object's state so that the tests will run properly.
        @Before
        public void setup(){
            papiStore = new PapiStore();
            papiStore.createActiveTab("Jamal");           // Creating tab for new person, Jamal
            papiStore.createActiveTab("Victor");          // Creating tab for new person, Victor
            papiStore.owesPapiMoney.put("Jamal", 0.0);          // Jamal owes $0
            papiStore.owesPapiMoney.put("Victor", 7.0);         // Victor owes $7.00
        }

        @Test
        public void OpenStoreTest(){
            //Given

            papiStore.openStore();      // Opens store

            //When
            Boolean expected = true;                        // This is the result we want the function to return (and actually seems to be not needed since we use assertTrue() instead).
            Boolean actual = papiStore.isStoreOpen();       // This is the result it actually returns

            //Then
            //Assert.assertEquals(expected, actual);
            Assert.assertTrue(actual);                      // This determines if the result is true.
        }

        @Test
        public void allowToUseTabTestSuccess(){
            // given
            PapiStore papiStore = new PapiStore();                    // We create a new PapiStore object even though there is one in @Before.

            // when
            Boolean expected = true;                                  // This is the result we expect. That it is true.
            Boolean actual = papiStore.allowToUseTab("Jamal");  // This is the result the function we're testing returned.

            // then
            Assert.assertEquals(expected, actual);                    // The test passes if expected and actual are the same value.
        }

        @Test
        public void allowToUseTabTestFail(){
            // given
            PapiStore papiStore = new PapiStore();                    // We create a new PapiStore object even though there is one in @Before.

            // when
            Boolean expected = false;                                 // This is the result we expect. That it is false.
            Boolean actual = papiStore.allowToUseTab("Victor"); // This is the result the function we're testing returned.

            // then
            Assert.assertEquals(expected, actual);                    // The test passes if expected and actual are the same value.
        }
}
