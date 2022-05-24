//package code;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class ScenarioTestCases {
    //Scenario scenario = new Scenario();
    @Test
    public void testConvertString(){
        assertEquals("yep","JACKSON MOWATT GOK", Scenario.convertString("Jackson Mowatt Gok", true));
        assertEquals("yep","MOWATT GOK", Scenario.convertString("MOWATT GOK", true));
        assertEquals("yep","INTERSTELLAR", Scenario.convertString("interstellar", true));
        assertEquals("yep","20568818", Scenario.convertString("20568818", true));
        assertEquals("yep","jackson mowatt gok", Scenario.convertString("Jackson Mowatt Gok", false));
        assertEquals("yep","mowatt gok", Scenario.convertString("MOWATT GOK", false));
        assertEquals("yep","interstellar", Scenario.convertString("interstellar", false));
        assertEquals("yep","20568818", Scenario.convertString("20568818", false));
    }
    @Test
    public void testNumericFilter(){
        assertEquals("yep",System.out.println(x);, actual);
    }
    @Test
    public void testNumericChecker(){
        
    }
    @Test
    public void testRemoveNConvert(){
        
    }
    @Test
    public void testMetersNFeet(){
        
    }
    @Test
    public void testCentiNInches(){
        
    }


}
