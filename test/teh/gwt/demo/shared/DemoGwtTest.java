package teh.gwt.demo.shared;

import com.google.gwt.junit.client.GWTTestCase;

public class DemoGwtTest extends GWTTestCase {
    Demo demo;

    @Override
    public String getModuleName() {
	return "teh.gwt.demo.Gwt_teh_demo";
    }

    @Override
    protected void gwtSetUp() throws Exception {
	super.gwtSetUp();
    }

    public void testToString() {
	demo = new Demo("gwt-teh", 5);
	String toString = demo.toString();
	assertTrue(toString, toString.contains(Demo.class.getName()));
	assertTrue(toString, toString.contains("project=gwt-teh"));
	assertTrue(toString, toString.contains("version=5"));
	assertTrue(toString, toString.contains("creationDateTime"));
    }

    public void testToStringWithPrivateAttributeButAccessors() {
	demo = new Demo("gwt-teh", 5, "So Cool Demo");
	String toString = demo.toString();
	assertTrue(toString, toString.contains("comment=So Cool Demo"));
    }

    public void testEquals() {
	demo = new Demo("gwt-teh", 5);
	assertTrue(demo.equals(new Demo("gwt-teh", 5)));
	Demo other = new Demo("other project", 2);
	assertFalse(demo + " " + other, demo.equals(other));
    }

    public void testHashCode() {
	demo = new Demo("gwt-teh", 1);
	demo.hashCode();
    }

}
