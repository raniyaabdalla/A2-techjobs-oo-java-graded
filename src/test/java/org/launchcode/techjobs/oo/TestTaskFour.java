package org.launchcode.techjobs.oo;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;
import org.launchcode.techjobs.oo.test.JobTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
public class TestTaskFour extends AbstractTest {

    @Tested
    JobTest jobTest;

    @Test
    public void testTestSettingJobIdExists () throws ClassNotFoundException {
        getClassByName("test.JobTest");

    }

    @Test
    public void testTestSettingJobIdCallsJobConstructorTwice (@Mocked Job job) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class jobTestClass = getClassByName("test.JobTest");
        JobTest jobTest = (JobTest) jobTestClass.getConstructor().newInstance();
        Method testSettingJobIdMethod = jobTestClass.getMethod("testSettingJobId");


        new Expectations() {{
            CoreCompetency coreCompetency = null;
            new Job(); minTimes = 2; maxTimes = 2;
        }};

        try {
            testSettingJobIdMethod.invoke(jobTest);
        } catch (InvocationTargetException e) {
            // do nothing: this is expected when using a mocked Job instance
        }
    }

    // TODO - this test isn't matching the expectation properly.

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //String s = "\n"+job1+"\n";
        String s =  job1.toString();
        assertEquals('\n',s.charAt(0));
        assertEquals('\n',s.charAt(s.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String s = "\n"+"ID: "+ job1.getId() +"\n"+
                "Name: Product tester"+ "\n" +
                "Employer: ACME"  + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n";
        assertEquals(s,job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String s = "\n"+"ID: "+ job1.getId() +"\n"+
                "Name: Data not available"+ "\n" +
                "Employer: ACME"  + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n";
        assertEquals(s,job1.toString());
    }

    @Test
    public  void testAllFieldsAreEmpty(){
        Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.",job1.toString());
    }

}
