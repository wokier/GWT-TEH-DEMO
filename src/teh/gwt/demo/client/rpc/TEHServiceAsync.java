package teh.gwt.demo.client.rpc;

import teh.gwt.demo.shared.Demo;
import teh.gwt.shared.GWTEHObject;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface TEHServiceAsync {

	void toString(GWTEHObject tehObject, AsyncCallback<String> callback);

	void equals(GWTEHObject tehObject1, GWTEHObject tehObject2, AsyncCallback<Boolean> callback);

	void hashCode(GWTEHObject tehObject, AsyncCallback<Integer> callback);

	void newDemo(String project, int version, AsyncCallback<Demo> callback);
}
