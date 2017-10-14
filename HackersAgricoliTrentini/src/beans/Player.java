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
	
	ArrayList<Integer> scores;
	

	public Player(String uID) {
		this.uID = uID;
		scores = new ArrayList<>();
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
}
