import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by laine on 19/01/2017.
 */
public class UnitTester {

    private final File unitTest = new File("UnitTestData.csv");
    private final File newOutput = new File("NewData.csv");
    private boolean UnitTestResult = false;


    public void PerformUnitTest() {
        CheckAgainstUnitTestFile();
        PrintUnitTestResult();
    }

    public void CheckAgainstUnitTestFile(){
        try {
            UnitTestResult = FileUtils.contentEquals(unitTest, newOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void PrintUnitTestResult() {
        System.out.println("File testing produces " + UnitTestResult + " result!");
    }

}
