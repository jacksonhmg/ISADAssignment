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
        assertEquals("yep", 0, Scenario.numericFilter("Jackson Mowatt Gok"));
        assertEquals("yep", 4, Scenario.numericFilter("Jackson Mowatt Gok 2002"));
        assertEquals("yep", 8, Scenario.numericFilter("24052022"));
    }
    @Test
    public void testNumericChecker(){
        assertEquals("yep",24052022, Scenario.numberChecker("24052022"), 0.1);
        assertEquals("yep",-1, Scenario.numberChecker("24/05/2022"), 0.1);
    }
    @Test
    public void testRemoveNConvert(){
        assertEquals("yep", "JACKSON MOWATT GOK", Scenario.removeNConvert("jackson mowatt gok", true));
        assertEquals("yep", "JACKSON MOWATT GOK ", Scenario.removeNConvert("jackson mowatt gok 19", true));
        assertEquals("yep", "", Scenario.removeNConvert("19", true));
        assertEquals("yep", "JACKSON MOWATT GOK", Scenario.removeNConvert("JACKSON MOWATT GOK", true));
        assertEquals("yep", "JACKSON MOWATT GOK ", Scenario.removeNConvert("JACKSON MOWATT GOK 19", true));
        assertEquals("yep", "JACKSON MOWATT GOK", Scenario.removeNConvert("jAcKson MoWaTt Gok", true));
        assertEquals("yep", "JACKSON MOWATT GOK ", Scenario.removeNConvert("jAcKsOn mOwaTt gOk 19", true));
        assertEquals("yep", "jackson mowatt gok", Scenario.removeNConvert("jackson mowatt gok", false));
        assertEquals("yep", "jackson mowatt gok ", Scenario.removeNConvert("jackson mowatt gok 19", false));
        assertEquals("yep", "", Scenario.removeNConvert("19", false));
        assertEquals("yep", "jackson mowatt gok", Scenario.removeNConvert("JACKSON MOWATT GOK", false));
        assertEquals("yep", "jackson mowatt gok ", Scenario.removeNConvert("JACKSON MOWATT GOK 19", false));
        assertEquals("yep", "jackson mowatt gok", Scenario.removeNConvert("jAcKson MoWaTt Gok", false));
        assertEquals("yep", "jackson mowatt gok ", Scenario.removeNConvert("jAcKsOn mOwaTt gOk 19", false));
    }
    @Test
    public void testMetersNFeet(){
        assertEquals("yep",164.05, Scenario.metersNFeet(50, true),0.001);
        assertEquals("yep",15.2392563, Scenario.metersNFeet(50, false),0.001);
    }
    @Test
    public void testCentiNInches(){
        assertEquals("yep",19.6850394, Scenario.centiNInches(50, true),0.001);
        assertEquals("yep",127, Scenario.centiNInches(50, false),0.001);
    }


}
