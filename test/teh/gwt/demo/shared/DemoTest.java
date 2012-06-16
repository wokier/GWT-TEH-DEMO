package teh.gwt.demo.shared;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import junit.runner.Version;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import teh.gwt.test.GWTEHTestWatcherRule;

public class DemoTest {

    @Rule
    public TestRule gwteh = new GWTEHTestWatcherRule();

    @Test
    public void testJUnitVersion() throws Exception {
	assertEquals("4.10", Version.id());
    }

    @Test
    public void testToString() {
	Demo demo = new Demo("gwt-teh", 5);
	assertThat(demo.toString()).contains(Demo.class.getName()).contains("project=gwt-teh").contains("version=5").doesNotMatch(".*Demo.*Demo.*");
    }

    @Test
    public void testEquals() throws Exception {
	Demo demo = new Demo("gwt-teh", 5);
	Demo differentDemo = new Demo("other project", 2);
	assertFalse(demo.equals(differentDemo));
    }

    @Test
    public void testHashCode() {
	Demo demo = new Demo("gwt-teh", 5);
	assertThat(demo.hashCode()).isNotEqualTo(0).isNotEqualTo(17);
    }

}
