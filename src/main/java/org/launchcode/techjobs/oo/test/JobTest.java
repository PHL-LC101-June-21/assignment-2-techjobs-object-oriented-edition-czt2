package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(), testJob2.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob1.getName(), "Product tester");
        assertEquals(testJob1.getEmployer().getValue(), "ACME");
        assertEquals(testJob1.getLocation().getValue(), "Desert");
        assertEquals(testJob1.getPositionType().getValue(), "Quality control");
        assertEquals(testJob1.getCoreCompetency().getValue(), "Persistence");
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob1 instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(!(testJob1.equals(testJob2)));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//      //String testString = testJob1.toString();
        char firstChar = testJob1.toString().charAt(0);
        char lastChar = testJob1.toString().charAt(testJob1.toString().length() - 1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
        //must use single quotes
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob1.toString(), "\n" +
                                            "ID: " + testJob1.getId() + "\n" +
                                            "Name: " + testJob1.getName() + "\n" +
                                            "Employer: " + testJob1.getEmployer() + "\n" +
                                            "Location: " + testJob1.getLocation() + "\n" +
                                            "Position Type: " + testJob1.getPositionType() + "\n" +
                                            "Core Competency: " + testJob1.getCoreCompetency() + "\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob1 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob1.toString(), "\n" +
                "ID: " + testJob1.getId() + "\n" +
                "Name: " + testJob1.getName() + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: " + testJob1.getLocation() + "\n" +
                "Position Type: " + testJob1.getPositionType() + "\n" +
                "Core Competency: " + testJob1.getCoreCompetency() + "\n");
        //TODO: when I set up the abstract class I got an error for setting employer to null
    }
}
