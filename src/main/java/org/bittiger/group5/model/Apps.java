package org.bittiger.group5.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bittiger.group5.model.App;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Apps {
	@JsonProperty("results") 
	private List<App> apps;

	public List<App> getApps() {
		return apps;
	}

	public void setApps(List<App> apps) {
		this.apps = apps;
	}
}
