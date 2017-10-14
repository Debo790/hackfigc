/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackersagricolitrentini;

import beans.Game;
import beans.Player;
import beans.Team;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author greed
 */
public class HackersAgricoliTrentini {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		ArrayList<Team> teams = new ArrayList<>();
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<Game> games = new ArrayList<>();
		
		//cambiare con delle hash map
		
		
		
		
		String nodoRoot = "SoccerFeed";
			
		String nodoSocDocument = "SoccerDocument";

		String nodoTeam = "Team";

			String country = "country";
			String country_id = "country_id";
			String country_iso = "country_iso";
			String region_id = "region_id";
			String region_name = "region_name";
			String uID = "uID";

			String nickName = "Nickname";
			String name = "Name";
			String fifarank = "FifaRank";

		String Splayer = "Player";

			String position = "Position";
			String jersey_num = "jersey_num";
			String stat = "stat";
		
		
		String Sgames = "Games";
		
		String SGame = "Game";
		
			String Sid = "id";
			String away_score = "away_score";
			String away_team_id = "away_team_id";
			String away_team_name = "away_team_name";
			String competition_id = "competition_id";
			String competition_name = "competition_name";
			String game_date = "game_date";
			String home_score = "home_score";
			String home_team_id = "home_team_id";
			String home_team_name = "home_team_name";
			String matchday = "matchday";
			String period_1_start = "period_1_start";
			String period_2_start = "period_2_start";
			String period_3_start = "period_3_start";
			String period_4_start = "period_4_start";
			String season_id = "season_id";
			String season_name = "season_name";
		
		
		String SEvent = "Event";
			
		
		
		String qualifier = "Q";
		
			
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//dbf.setValidating(true); // optional – default is non-validating
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = (Document) db.parse("srml-4-2013-squads.xml");
			
			NodeList f = doc.getChildNodes();
			
			
			Node realRoot = null;
			Node teamNode = null;
			
			
			for(int i=0; i<f.getLength(); i++){
				if(f.item(i).getNodeName().equals(nodoRoot)){
					realRoot = f.item(i);
				}
			}
			if(realRoot != null){
				f = realRoot.getChildNodes();
				for(int i=0; i<f.getLength(); i++){
					if(f.item(i).getNodeName().equals(nodoSocDocument)){
						teamNode = f.item(i);
					}
				}
				
				
				if(teamNode != null){
					
					f = teamNode.getChildNodes();
					
					
					for(int i=0; i<f.getLength(); i++){
						if(f.item(i).getNodeName().equals(nodoTeam)){
							
							Node nTeam = f.item(i);
							
							NamedNodeMap map = nTeam.getAttributes();
							
							Node c = map.getNamedItem(country);
							String cS = "";
							if(c != null){
								cS = c.getNodeValue();
							}
							
							Node c_id = map.getNamedItem(country_id);
							String cS_id = "";
							if(c_id != null){
								cS_id = c_id.getNodeValue();
							}
							
							Node c_iso = map.getNamedItem(country_iso);
							String cS_iso = "";
							if(c_iso != null){
								cS_iso = c_iso.getNodeValue();
							}
							
							
							Node r_id = map.getNamedItem(region_id);
							String rS_id = "";
							if(r_id != null){
								rS_id = r_id.getNodeValue();
							}
							
							
							Node r_name = map.getNamedItem(region_name);
							String rS_name = "";
							if(r_name != null){
								rS_name = r_name.getNodeValue();
							}
							
							
							Node u_id = map.getNamedItem(uID);
							String uS_id = "";
							if(u_id != null){
								uS_id = u_id.getNodeValue();
							}
							
							Team team = new Team(cS, cS_id, cS_iso, rS_id, rS_name, uS_id);
							
							//aggiunta team
							teams.add(team);
							
							NodeList pla = nTeam.getChildNodes();
							
							for(int j=0; j < pla.getLength(); j++){
								
								Node work = pla.item(j);
								
								if(work.getNodeName().equals(nickName)){
									team.setNickname(work.getNodeName());
								}
								else if(work.getNodeName().equals(name)){
									//team.setNickname(work.getNodeName());
									//non so cosa farmene
								}
								else if(work.getNodeName().equals(fifarank)){
									team.setFifaRank(fifarank);
								}
								
								else if(work.getNodeName().equals(Splayer)){
									
									NamedNodeMap plaAttr = work.getAttributes();
									
									Node p_uid = plaAttr.getNamedItem(uID);
									String pS_uid = "";
									if(u_id != null){
										pS_uid = p_uid.getNodeValue();
									}
									
									Player player = new Player(pS_uid);
									
									team.addPalyer(player);
									players.add(player);
									
									NodeList plaChild = work.getChildNodes();
									
									for(int g=0; g<plaChild.getLength(); g++){
										
										if(plaChild.item(g).getNodeName().equals(name)){
											player.setName(plaChild.item(g).getNodeValue());
										}
										if(plaChild.item(g).getNodeName().equals(position)){
											player.setPosition(plaChild.item(g).getNodeValue());
										}
										
										if(plaChild.item(g).getNodeName().equals(stat)){
											Node in_work = plaChild.item(g).getAttributes().getNamedItem(jersey_num);
											if(in_work != null){
												player.setPosition(in_work.getNodeValue());
											}
										}
										
										
									}
									
								}
							}
						}
					}
				}
			}
			
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(HackersAgricoliTrentini.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(HackersAgricoliTrentini.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(HackersAgricoliTrentini.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		try {
			db = dbf.newDocumentBuilder();
			Document doc = (Document) db.parse("f24-4-2013-731767-eventdetails.xml");
			
			
			NodeList f = doc.getChildNodes();
			
			
			Node realRoot = null;
			Node teamNode = null;
			
			
			
			for(int i=0; i<f.getLength(); i++){
				if(f.item(i).getNodeName().equals(Sgames)){
					realRoot = f.item(i);
				}
			}
			
			
			f = realRoot.getChildNodes();
			
			
			for(int i=0; i<f.getLength(); i++){
				if(f.item(i).getNodeName().equals(SGame)){
					
					Node gam = f.item(i);
					
					NamedNodeMap GmapAtt = gam.getAttributes();
					
					//Node n_id = 
					
					
					
				}
			}
			
			
			
			
			
			
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(HackersAgricoliTrentini.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(HackersAgricoliTrentini.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(HackersAgricoliTrentini.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		
		
		
		
	}
	
}
