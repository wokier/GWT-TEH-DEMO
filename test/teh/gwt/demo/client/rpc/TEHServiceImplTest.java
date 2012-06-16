package teh.gwt.demo.client.rpc;

import teh.gwt.demo.client.rpc.TEHService;
import teh.gwt.demo.client.rpc.TEHServiceAsync;
import teh.gwt.demo.shared.Demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class TEHServiceImplTest extends GWTTestCase {

    TEHServiceAsync tehService;

    Demo demo;

    @Override
    public String getModuleName() {
	return "teh.gwt.demo.Gwt_teh_demo";
    }

    @Override
    protected void gwtSetUp() throws Exception {
	super.gwtSetUp();
	tehService = GWT.create(TEHService.class);
	demo = new Demo("gwt-teh", 5);
    }

    public void testToStringGWTEHObject() {
	delayTestFinish(1000);
	tehService.toString(demo, new AsyncCallback<String>() {
	    public void onSuccess(String result) {
		assertTrue(result, result.contains("Demo"));
		assertTrue(result, result.contains("gwt-teh"));
		assertTrue(result, result.contains("5"));
		finishTest();
	    }

	    public void onFailure(Throwable caught) {
		fail(caught.toString());
	    }
	});
    }

    public void testEqualsGWTEHObjectGWTEHObject() {
	delayTestFinish(1000);
	tehService.equals(demo, new Demo("gwt-teh", 5), new AsyncCallback<Boolean>() {
	    public void onSuccess(Boolean result) {
		assertTrue(result);
		finishTest();
	    }

	    public void onFailure(Throwable caught) {
		fail(caught.toString());
	    }
	});

    }

    public void testHashCodeGWTEHObject() {
	delayTestFinish(1000);
	tehService.hashCode(demo, new AsyncCallback<Integer>() {
	    public void onSuccess(Integer result) {
		finishTest();
	    }

	    public void onFailure(Throwable caught) {
		fail(caught.toString());
	    }
	});
    }

    public void testNewDemo() {
	delayTestFinish(1000);
	tehService.newDemo("gwt-teh", 5, new AsyncCallback<Demo>() {
	    public void onSuccess(Demo result) {
		assertNotNull(result);
		finishTest();
	    }

	    public void onFailure(Throwable caught) {
		fail(caught.toString());
	    }
	});
    }
}
