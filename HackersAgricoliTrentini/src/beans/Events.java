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
	String player_id;
	
	ArrayList<Qualifier> qua;

	public Events(String id, String event_id, String type_id, String period_id, String min, String sec, String team_id, String outcome, String x, String y, String timestamp, String player_id) {
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
		this.player_id = player_id;
		qua = new ArrayList<>();
	}
	
	public void addQualifier(Qualifier q){
		qua.add(q);
	}

	public String getPlayer_id() {
		return player_id;
	}

	public String getEvent_id() {
		return event_id;
	}

	public String getId() {
		return id;
	}

	public String getMin() {
		return min;
	}

	public String getOutcome() {
		return outcome;
	}

	public String getPeriod_id() {
		return period_id;
	}

	public ArrayList<Qualifier> getQua() {
		return qua;
	}

	public String getSec() {
		return sec;
	}

	public String getTeam_id() {
		return team_id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getType_id() {
		return type_id;
	}

	public String getX() {
		return x;
	}

	public String getY() {
		return y;
	}
	
	
	
	
	
	
	
	
}
