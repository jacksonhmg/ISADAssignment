import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class ScenarioTestCases {
    @Test
    public void testConvertString(){
        assertEquals("yep","JACKSON MOWATT GOK", Scenario.stringUpper("Jackson Mowatt Gok"));
        assertEquals("yep","MOWATT GOK", Scenario.stringUpper("MOWATT GOK"));
        assertEquals("yep","INTERSTELLAR", Scenario.stringUpper("interstellar"));
        assertEquals("yep","8818", Scenario.stringUpper("8818"));
        assertEquals("yep","jackson mowatt gok", Scenario.stringLower("Jackson Mowatt Gok"));
        assertEquals("yep","mowatt gok", Scenario.stringLower("MOWATT GOK"));
        assertEquals("yep","interstellar", Scenario.stringLower("interstellar"));
        assertEquals("yep","8818", Scenario.stringLower("8818"));
    }
    @Test
    public void testNumericFilter(){
        assertEquals("yep", 0, Scenario.numericFilter("Jackson Mowatt Gok"));
        assertEquals("yep", 4, Scenario.numericFilter("Jackson Mowatt Gok 2002"));
        assertEquals("yep", 8, Scenario.numericFilter("24052022"));
    }
    @Test
    public void testNumberCheckerNoException(){
        assertEquals("yep",24052022, Scenario.numberChecker("24052022"), 0.1);
    }
    @Test(expected = NumberFormatException.class)
    public void testNumberCheckerWException(){ //TESTING NUMERIC CHECKER THROWING AN EXCEPTION
        Scenario.numberChecker("24/05/2022");
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
        assertEquals("yep",0.3281, Scenario.metersToFeet(0.1),0.001);
        assertEquals("yep",0, Scenario.metersToFeet(-0.1),0.001);
        assertEquals("yep",0.0304785, Scenario.feetToMeters(0.1),0.001);
        assertEquals("yep",0, Scenario.feetToMeters(-0.1),0.001);
    }
    @Test
    public void testCentiNInches(){
        assertEquals("yep",0.03937, Scenario.centiToInches(0.1),0.001);
        assertEquals("yep",0, Scenario.centiToInches(-0.1),0.001);
        assertEquals("yep",0.254, Scenario.inchesToCenti(0.1),0.001);
        assertEquals("yep",0, Scenario.inchesToCenti(-0.1),0.001);
    }

}
