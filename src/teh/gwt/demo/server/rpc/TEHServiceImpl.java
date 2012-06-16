package teh.gwt.demo.server.rpc;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import teh.gwt.demo.client.rpc.TEHService;
import teh.gwt.demo.shared.Demo;
import teh.gwt.server.GWTEH;
import teh.gwt.shared.GWTEHObject;

import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TEHServiceImpl extends RemoteServiceServlet implements TEHService {

    private static final Logger LOGGER = Logger.getLogger(TEHServiceImpl.class.getName());

    @Override
    public void init() throws ServletException {
	super.init();
	GWTEH.initServerSide();
    }

    @Override
    protected void onBeforeRequestDeserialized(String serializedRequest) {
	super.onBeforeRequestDeserialized(serializedRequest);
    }

    @Override
    protected void onAfterRequestDeserialized(RPCRequest rpcRequest) {
	LOGGER.entering(TEHServiceImpl.class.getName(), rpcRequest.getMethod().getName(), rpcRequest.getParameters());
	super.onAfterRequestDeserialized(rpcRequest);
    }

    @Override
    public String toString(GWTEHObject tehObject) {
	return tehObject.toString();
    }

    @Override
    public boolean equals(GWTEHObject tehObject1, GWTEHObject tehObject2) {
	return tehObject1.equals(tehObject2);
    }

    @Override
    public int hashCode(GWTEHObject tehObject) {
	return tehObject.hashCode();
    }

    @Override
    public Demo newDemo(String project, int version) {
	return new Demo(project, version);
    }
}
