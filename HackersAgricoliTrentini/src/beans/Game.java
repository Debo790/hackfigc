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

}
