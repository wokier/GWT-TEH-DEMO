package teh.gwt.demo.client;

import teh.gwt.demo.client.rpc.TEHService;
import teh.gwt.demo.client.rpc.TEHServiceAsync;
import teh.gwt.demo.shared.Demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint, ScheduledCommand, UncaughtExceptionHandler {

    private final TEHServiceAsync tehService = GWT.create(TEHService.class);

    public void onModuleLoad() {
	GWT.setUncaughtExceptionHandler(this);
	Scheduler.get().scheduleDeferred(this);
	RootPanel.get("loading").getElement().setInnerText("");
    }

    @Override
    public void execute() {
	clientObject();
	serverObject();
    }

    private void clientObject() {
	final Demo demo = new Demo("gwt-teh", 7, "ToString Equals HashCode by annotations for GWT");
	final Demo otherDemo = new Demo("gwt-teh", 7);

	RootPanel.get("toStringClientClient").getElement().setInnerText(demo.toString());
	final Element toStringClientServerElement = RootPanel.get("toStringClientServer").getElement();
	tehService.toString(demo, new AsyncCallback<String>() {
	    public void onSuccess(String result) {
		toStringClientServerElement.setInnerText(result);
	    }

	    public void onFailure(Throwable caught) {
		on(caught, toStringClientServerElement);
	    }
	});
	RootPanel.get("equalsClientClient").getElement().setInnerText(Boolean.toString(demo.equals(otherDemo)));
	final Element equalsClientServerElement = RootPanel.get("equalsClientServer").getElement();
	tehService.equals(demo, otherDemo, new AsyncCallback<Boolean>() {
	    public void onSuccess(Boolean result) {
		equalsClientServerElement.setInnerText(Boolean.toString(result));
	    }

	    public void onFailure(Throwable caught) {
		on(caught, equalsClientServerElement);
	    }
	});
	RootPanel.get("hashCodeClientClient").getElement().setInnerText(String.valueOf(demo.hashCode()));
	final Element hashCodeClientServerElement = RootPanel.get("hashCodeClientServer").getElement();
	tehService.hashCode(demo, new AsyncCallback<Integer>() {
	    public void onSuccess(Integer result) {
		hashCodeClientServerElement.setInnerText(result.toString());
	    }

	    public void onFailure(Throwable caught) {
		on(caught, hashCodeClientServerElement);
	    }
	});
    }

    private void serverObject() {
	tehService.newDemo("gwt-teh", 7, new AsyncCallback<Demo>() {
	    public void onSuccess(final Demo demo) {
		tehService.newDemo("gwt-teh", 7, new AsyncCallback<Demo>() {
		    public void onSuccess(Demo otherDemo) {
			compare(demo, otherDemo);
		    }

		    public void onFailure(Throwable caught) {
			onUncaughtException(caught);
		    }
		});
	    }

	    public void onFailure(Throwable caught) {
		onUncaughtException(caught);
	    }
	});
    }

    private void compare(Demo demo, Demo otherDemo) {

	RootPanel.get("toStringServerClient").getElement().setInnerText(demo.toString());
	final Element toStringServerServerElement = RootPanel.get("toStringServerServer").getElement();
	tehService.toString(demo, new AsyncCallback<String>() {
	    public void onSuccess(String result) {
		toStringServerServerElement.setInnerText(result);
	    }

	    public void onFailure(Throwable caught) {
		on(caught, toStringServerServerElement);
	    }
	});
	RootPanel.get("equalsServerClient").getElement().setInnerText(Boolean.toString(demo.equals(otherDemo)));
	final Element equalsServerServerElement = RootPanel.get("equalsServerServer").getElement();
	tehService.equals(demo, otherDemo, new AsyncCallback<Boolean>() {
	    public void onSuccess(Boolean result) {
		equalsServerServerElement.setInnerText(Boolean.toString(result));
	    }

	    public void onFailure(Throwable caught) {
		on(caught, equalsServerServerElement);
	    }
	});
	RootPanel.get("hashCodeServerClient").getElement().setInnerText(String.valueOf(demo.hashCode()));
	final Element hashCodeServerServerElement = RootPanel.get("hashCodeServerServer").getElement();
	tehService.hashCode(demo, new AsyncCallback<Integer>() {
	    public void onSuccess(Integer result) {
		hashCodeServerServerElement.setInnerText(result.toString());
	    }

	    public void onFailure(Throwable caught) {
		on(caught, hashCodeServerServerElement);
	    }
	});
    }

    @Override
    public void onUncaughtException(Throwable e) {
	on(e, RootPanel.get("error").getElement());
    }

    private void on(Throwable e, final Element toStringServerElement) {
	toStringServerElement.setInnerText(e.getClass().getName() + ":" + e.getMessage());
	toStringServerElement.addClassName("error");
	GWT.log(e.getMessage(), e);
	Window.alert(e.getMessage());
    }

}