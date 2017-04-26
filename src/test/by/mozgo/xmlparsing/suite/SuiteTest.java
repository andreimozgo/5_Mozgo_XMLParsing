package test.by.mozgo.xmlparsing.suite;

/**
 * Created by Andrei Mozgo. 2017.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.by.mozgo.xmlparsing.parser.CandiesDOMBuilderTest;
import test.by.mozgo.xmlparsing.parser.CandiesSAXBuilderTest;
import test.by.mozgo.xmlparsing.parser.CandiesStAXBuilderTest;
import test.by.mozgo.xmlparsing.validator.ValidatorSAXXSDTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CandiesDOMBuilderTest.class, CandiesSAXBuilderTest.class, CandiesStAXBuilderTest.class,
        ValidatorSAXXSDTest.class})
public class SuiteTest {
}