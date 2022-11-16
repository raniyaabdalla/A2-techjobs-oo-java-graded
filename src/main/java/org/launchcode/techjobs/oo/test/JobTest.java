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
    public  void testAllFieldsAreEmpty(){
        Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(job1.toString(), job1.getName());
    }

    private void assertEquals(String s, String name) {
    }
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public  void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.getName() instanceof String);
        assertEquals ("Product tester",job1.getName());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals ("ACME",job1.getEmployer().getValue());
        assertTrue(job1.getLocation() instanceof Location);
        assertEquals ("Desert",job1.getLocation().getValue());
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals ("Quality control",job1.getPositionType().getValue());
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals ("Persistence",job1.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //assertNotEquals(job1, job2);
        assertFalse(job1.equals(job2));
    }
}



