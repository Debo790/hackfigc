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
public class Game {
	
	String id;
	String away_score;
	String away_team_id;
	String away_team_name;
	String competition_id;
	String competition_name;
	String game_date;
	String home_score;
	String home_team_id;
	String home_team_name;
	String matchday;
	String season_id;
	String season_name;
	
	ArrayList<Events> eventi;

	public Game(String id, String away_score, String away_team_id, String away_team_name, String competition_id, String competition_name, String game_date, String home_score, String home_team_id, String home_team_name, String matchday, String season_id, String season_name) {
		this.id = id;
		this.away_score = away_score;
		this.away_team_id = away_team_id;
		this.away_team_name = away_team_name;
		this.competition_id = competition_id;
		this.competition_name = competition_name;
		this.game_date = game_date;
		this.home_score = home_score;
		this.home_team_id = home_team_id;
		this.home_team_name = home_team_name;
		this.matchday = matchday;
		this.season_id = season_id;
		this.season_name = season_name;
		
		eventi = new ArrayList<>();
	}

	
	public void addEvent(Events ev){
		eventi.add(ev);
	}

	public ArrayList<Events> getEventi() {
		return eventi;
	}

	public String getAway_score() {
		return away_score;
	}

	public String getAway_team_id() {
		return away_team_id;
	}

	public String getAway_team_name() {
		return away_team_name;
	}

	public String getCompetition_id() {
		return competition_id;
	}

	public String getCompetition_name() {
		return competition_name;
	}

	public String getGame_date() {
		return game_date;
	}

	public String getHome_score() {
		return home_score;
	}

	public String getHome_team_id() {
		return home_team_id;
	}

	public String getHome_team_name() {
		return home_team_name;
	}

	public String getId() {
		return id;
	}

	public String getMatchday() {
		return matchday;
	}

	public String getSeason_id() {
		return season_id;
	}

	public String getSeason_name() {
		return season_name;
	}
	
	

}
