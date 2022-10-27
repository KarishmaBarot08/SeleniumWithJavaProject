package TestCases;

import Functions.CommonFunctions;
import Utilities.Base;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestConvert extends Base{


    public CommonFunctions f;
    public TestConvert() throws IOException {
        super();
    }

    @Test(priority = 1)
    public void  convert() throws IOException {
        f = new CommonFunctions();
        f.convertFlow();
    }

    @Test(priority = 2)
    public void data() throws IOException, InterruptedException {
        f = new CommonFunctions();
        f.dataFlow();
    }
}
