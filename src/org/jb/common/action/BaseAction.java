package org.jb.common.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ParameterAware,
		RequestAware, SessionAware, ApplicationAware {

	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
		
	}

	@JSON(serialize=false)
	public Map<String, Object> getApplication() {
		return application;
	}

	@JSON(serialize=false)
	public Map<String, Object> getSession() {
		return session;
	}

	@JSON(serialize=false)
	public Map<String, Object> getRequest() {
		return request;
	}

	@JSON(serialize=false)
	public Map<String, String[]> getParameters() {
		return parameters;
	}

	
	

}
