/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author greed
 */
public class Events {
	
	String id;
	String event_id;
	String type_id;
	String period_id;
	String min;
	String sec;
	String team_id;
	String outcome;
	String x;
	String y;
	String timestamp;
	
	ArrayList<Qualifier> qua;

	public Events(String id, String event_id, String type_id, String period_id, String min, String sec, String team_id, String outcome, String x, String y, String timestamp) {
		this.id = id;
		this.event_id = event_id;
		this.type_id = type_id;
		this.period_id = period_id;
		this.min = min;
		this.sec = sec;
		this.team_id = team_id;
		this.outcome = outcome;
		this.x = x;
		this.y = y;
		this.timestamp = timestamp;
		
		qua = new ArrayList<>();
	}
	
	
	
	
	
}
