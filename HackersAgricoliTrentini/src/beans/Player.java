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
public class Player {
	
	String uID;
	String name;
	String position;
	String num;
	int ev=0;
	
	double score;
	
	int numS = 0;
	
	ArrayList<Double> scores;
	

	public Player(String uID) {
		this.uID = uID;
		scores = new ArrayList<>();
		scores.add(0.0);
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getuID() {
		return uID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public String getNum() {
		return num;
	}

	public String getPosition() {
		return position;
	}

	public ArrayList<Double> getScores() {
		return scores;
	}
	
	public void incr(){
		numS++;
		scores.add(0.0);
	}
	
	public void addScore(double b){
		
		score = score +b;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setEv(int ev) {
		this.ev = ev;
	}

	public int getEv() {
		return ev;
	}
	
	public void addEv(){
		ev++;
	}
	
}
