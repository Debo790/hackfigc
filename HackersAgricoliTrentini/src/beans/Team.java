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
public class Team {
	
	String country;
	String country_id;
	String country_iso;
	String region_id;
	String region_name;
	String uID;
	String fifaRank;
	String nickname;
	
	ArrayList<Player> players;

	public Team(String country, String country_id, String country_iso, String region_id, String region_name, String uID) {
		this.country = country;
		this.country_id = country_id;
		this.country_iso = country_iso;
		this.region_id = region_id;
		this.region_name = region_name;
		this.uID = uID;
		players = new ArrayList<>();
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public void setCountry_iso(String country_iso) {
		this.country_iso = country_iso;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}
	
	
	public void addPalyer(Player pl){
		this.players.add(pl);
	}

	public void setFifaRank(String fifaRank) {
		this.fifaRank = fifaRank;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCountry() {
		return country;
	}

	public String getCountry_id() {
		return country_id;
	}

	public String getCountry_iso() {
		return country_iso;
	}

	public String getFifaRank() {
		return fifaRank;
	}

	public String getNickname() {
		return nickname;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public String getRegion_id() {
		return region_id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public String getuID() {
		return uID;
	}
	
	
	
	
	
	
	
}
