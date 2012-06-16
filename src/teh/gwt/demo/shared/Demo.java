package teh.gwt.demo.shared;

import java.util.Date;

import teh.annotations.TEH;
import teh.annotations.ToString;
import teh.annotations.ToStringEquals;
import teh.annotations.ToStringEqualsHashCode;
import teh.fields.TEHFields;
import teh.gwt.shared.GWTEHObject;

import com.google.gwt.core.client.GWT;

@TEH
public class Demo extends GWTEHObject {

    @ToStringEqualsHashCode
    public String project;

    @ToStringEquals
    protected int version;

    @ToString
    Date creationDateTime;

    @ToString
    private String comment;

    @ToString
    @SuppressWarnings("unused")
    private String tooPrivate;

    public Demo() {
	super();
	this.creationDateTime = new Date();
	this.tooPrivate = "unused";
    }

    public Demo(String project, int version) {
	this();
	this.project = project;
	this.version = version;
    }

    public Demo(String project, int version, String comment) {
	this(project, version);
	this.comment = comment;
    }

    @Override
    protected TEHFields createTEHFields() {
	return GWT.create(Demo.class);
    }

    public void setComment(String comment) {
	this.comment = comment;
    }

    public String getComment() {
	return comment;
    }

}
