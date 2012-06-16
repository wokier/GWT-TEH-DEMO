package teh.gwt.demo.client.rpc;

import teh.gwt.demo.shared.Demo;
import teh.gwt.shared.GWTEHObject;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("teh")
public interface TEHService extends RemoteService {

	String toString(GWTEHObject tehObject);

	boolean equals(GWTEHObject tehObject1, GWTEHObject tehObject2);

	int hashCode(GWTEHObject tehObject);

	Demo newDemo(String project, int version);

}
