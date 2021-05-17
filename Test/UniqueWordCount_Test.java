import junit.framework.TestCase;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;

public class UniqueWordCount_Test {
    private A1_Unique_Word_Count testSubject;

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUp() throws Exception {
        this.testSubject = new A1_Unique_Word_Count();
    }


    @After
    public void tearDown() throws Exception {
        testSubject = null;
    }


    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testCase1() {
        final String testString = "sample.txt";
        String output = "Top 10 words\n" +
                "Count: 19 the\n" +
                "Count: 14 and\n" +
                "Count: 7 he\n" +
                "Count: 6 in\n" +
                "Count: 4 jabberwocky\n" +
                "Count: 3 my\n" +
                "Count: 3 outgrabe\n" +
                "Count: 3 thought\n" +
                "Count: 3 through\n" +
                "Count: 3 toves\n" +
                "--------------------------------------\n" +
                "Bottom 10 words\n" +
                "Count: 1 wood\n" +
                "Count: 1 whiffling\n" +
                "Count: 1 uffish\n" +
                "Count: 1 tumtum\n" +
                "Count: 1 tulgey\n" +
                "Count: 1 tree\n" +
                "Count: 1 took\n" +
                "Count: 1 time\n" +
                "Count: 1 sword\n" +
                "Count: 1 sought\n";

        provideInput(testString);

        A1_Unique_Word_Count.main(new String[0]);
        // Removes \r values to align expected and actual to same end line sign (LF vs CRLF)
        String expected = output.trim().replace("\r","");
        String actual = getOutput().trim().replace("\r","");

        assertEquals("Test Case 1",expected, actual);
    }
}