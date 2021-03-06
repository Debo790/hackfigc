/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackersagricolitrentini;

import beans.Events;
import beans.Game;
import beans.Player;
import beans.Qualifier;
import beans.Team;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CharacterData;
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
			String stat = "Stat";
			String type = "Type";
		
		
		String Sgames = "Games";
		
		String SGame = "Game";
		
			String id = "id";
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
			//String id;
			String event_id = "event_id";
			String type_id = "type_id";
			String period_id = "period_id";
			String min = "min";
			String sec = "sec";
			String team_id = "team_id";
			String outcome = "outcome";
			String x = "x";
			String y = "y";
			String timestamp = "timestamp";
			String player_id = "player_id";
		
		
		String qualifier = "Q";
			//String id;
			String qualifier_id = "qualifier_id";
			String value = "value";
		
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
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
								uS_id = uS_id.substring(1);
							}
							
							Team team = new Team(cS, cS_id, cS_iso, rS_id, rS_name, uS_id);
							
							//aggiunta team
							teams.add(team);
							
							NodeList pla = nTeam.getChildNodes();
							
							for(int j=0; j < pla.getLength(); j++){
								
								Node work = pla.item(j);
								
								if(work.getNodeName().equals(nickName)){
									//.out.println(getCharacterDataFromElement(work));
									team.setNickname(getCharacterDataFromElement(work));
								}
								else if(work.getNodeName().equals(name)){
									//team.setNickname(work.getNodeName());
									//non so cosa farmene
								}
								else if(work.getNodeName().equals(fifarank)){
									team.setFifaRank(getCharacterDataFromElement(work));
								}
								
								else if(work.getNodeName().equals(Splayer)){
									
									NamedNodeMap plaAttr = work.getAttributes();
									
									Node p_uid = plaAttr.getNamedItem(uID);
									String pS_uid = "";
									if(u_id != null){
										pS_uid = p_uid.getNodeValue();
										pS_uid = pS_uid.substring(1);
									}
									
									Player player = new Player(pS_uid);
									
									team.addPalyer(player);
									players.add(player);
									
									NodeList plaChild = work.getChildNodes();
									
									for(int g=0; g<plaChild.getLength(); g++){
										
										if(plaChild.item(g).getNodeName().equals(name)){
											//System.out.println(getCharacterDataFromElement(plaChild.item(g)));
											player.setName(getCharacterDataFromElement(plaChild.item(g)));
											
											plaChild.item(g).getTextContent();
										}
										if(plaChild.item(g).getNodeName().equals(position)){
											player.setPosition(getCharacterDataFromElement(plaChild.item(g)));
										}
										
										if(plaChild.item(g).getNodeName().equals(stat)){
											NamedNodeMap mm = plaChild.item(g).getAttributes();
											
											
											Node in_work = mm.getNamedItem(type);
											if(in_work != null){
												
												if(in_work.getNodeValue().equals(jersey_num)){
													player.setNum(getCharacterDataFromElement(plaChild.item(g)));
												}
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
		
		System.out.println("");
		String Sfolder = "xml/";
		File folder = new File(Sfolder);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(file.getName());
				try {
					db = dbf.newDocumentBuilder();
					Document doc = (Document) db.parse(Sfolder + file.getName());

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

							Node n_id = GmapAtt.getNamedItem(id);
							String s_id = "";
							if(n_id != null){
								s_id = n_id.getNodeValue();
							}


							Node n_away_score = GmapAtt.getNamedItem(away_score);
							String s_away_score = "";
							if(n_away_score != null){
								s_away_score = n_away_score.getNodeValue();
							}

							Node n_away_team_id = GmapAtt.getNamedItem(away_team_id);
							String s_away_team_id = "";
							if(n_away_team_id != null){
								s_away_team_id = n_away_team_id.getNodeValue();
							}

							Node n_away_team_name = GmapAtt.getNamedItem(away_team_name);
							String s_away_team_name = "";
							if(n_away_team_name != null){
								s_away_team_name = n_away_team_name.getNodeValue();
							}

							Node n_competition_id = GmapAtt.getNamedItem(competition_id);
							String s_competition_id = "";
							if(n_competition_id != null){
								s_competition_id = n_competition_id.getNodeValue();
							}

							Node n_competition_name = GmapAtt.getNamedItem(competition_name);
							String s_competition_name = "";
							if(n_competition_name != null){
								s_competition_name = n_competition_name.getNodeValue();
							}

							Node n_game_date = GmapAtt.getNamedItem(game_date);
							String s_game_date = "";
							if(n_game_date != null){
								s_game_date = n_game_date.getNodeValue();
							}

							Node n_home_score = GmapAtt.getNamedItem(home_score);
							String s_home_score = "";
							if(n_home_score != null){
								s_home_score = n_home_score.getNodeValue();
							}

							Node n_home_team_id = GmapAtt.getNamedItem(home_team_id);
							String s_home_team_id = "";
							if(n_home_team_id != null){
								s_home_team_id = n_home_team_id.getNodeValue();
							}

							Node n_home_team_name = GmapAtt.getNamedItem(home_team_name);
							String s_home_team_name = "";
							if(n_home_team_name != null){
								s_home_team_name = n_home_team_name.getNodeValue();
							}

							Node n_matchday = GmapAtt.getNamedItem(matchday);
							String s_matchday = "";
							if(n_matchday != null){
								s_matchday = n_matchday.getNodeValue();
							}

							Node n_season_id = GmapAtt.getNamedItem(season_id);
							String s_season_id = "";
							if(n_season_id != null){
								s_season_id = n_season_id.getNodeValue();
							}

							Node n_season_name = GmapAtt.getNamedItem(season_name);
							String s_season_name = "";
							if(n_season_name != null){
								s_season_name = n_season_name.getNodeValue();
							}


							Game current_game = new Game(s_id, s_away_score, 
									s_away_team_id, s_away_team_name, 
									s_competition_id, s_competition_name, 
									s_game_date, s_home_score, 
									s_home_team_id, s_home_team_name, 
									s_matchday, s_season_id, s_season_name);

							games.add(current_game);

							NodeList listaEventi = gam.getChildNodes();

							for(int j=0; j<listaEventi.getLength(); j++){
								if(listaEventi.item(j).getNodeName().equals(SEvent)){

									NamedNodeMap EvAtt = listaEventi.item(j).getAttributes();

									Node n_Eid = EvAtt.getNamedItem(id);
									String s_Eid = "";
									if(n_Eid != null){
										s_Eid = n_Eid.getNodeValue();
									}

									Node n_event_id = EvAtt.getNamedItem(event_id);
									String s_event_id = "";
									if(n_event_id != null){
										s_event_id = n_event_id.getNodeValue();
									}
									Node n_type_id = EvAtt.getNamedItem(type_id);
									String s_type_id = "";
									if(n_type_id != null){
										s_type_id = n_type_id.getNodeValue();
									}
									Node n_period_id = EvAtt.getNamedItem(period_id);
									String s_period_id = "";
									if(n_period_id != null){
										s_period_id = n_period_id.getNodeValue();
									}
									Node n_min = EvAtt.getNamedItem(min);
									String s_min = "";
									if(n_min != null){
										s_min = n_min.getNodeValue();
									}
									Node n_sec = EvAtt.getNamedItem(sec);
									String s_sec = "";
									if(n_sec != null){
										s_sec = n_sec.getNodeValue();
									}

									Node n_team_id = EvAtt.getNamedItem(team_id);
									String s_team_id = "";
									if(n_team_id != null){
										s_team_id = n_team_id.getNodeValue();
									}
									Node n_outcome = EvAtt.getNamedItem(outcome);
									String s_outcome = "";
									if(n_outcome != null){
										s_outcome = n_outcome.getNodeValue();
									}
									Node n_x = EvAtt.getNamedItem(x);
									String s_x = "";
									if(n_x != null){
										s_x = n_x.getNodeValue();
									}
									Node n_y = EvAtt.getNamedItem(y);
									String s_y = "";
									if(n_y != null){
										s_y = n_y.getNodeValue();
									}
									Node n_timestamp = EvAtt.getNamedItem(timestamp);
									String s_timestamp = "";
									if(n_timestamp != null){
										s_timestamp = n_timestamp.getNodeValue();
									}
									
									Node n_player_id = EvAtt.getNamedItem(player_id);
									String s_player_id = "";
									if(n_player_id != null){
										s_player_id = n_player_id.getNodeValue();
									}

									Events evento_partita = new Events(s_Eid, s_event_id, 
											s_type_id, s_period_id, 
											s_min, s_sec, s_team_id, 
											s_outcome, s_x, s_y, 
											s_timestamp, s_player_id);

									current_game.addEvent(evento_partita);
									
									NodeList listaQuali = listaEventi.item(j).getChildNodes();

									for(int g =0; g<listaQuali.getLength(); g++){

										if(listaQuali.item(g).getNodeName().equals(qualifier)){

											NamedNodeMap QuaAtt = listaQuali.item(g).getAttributes();

											Node n_Qid = QuaAtt.getNamedItem(id);
											String s_Qid = "";
											if(n_Qid != null){
												s_Qid = n_Qid.getNodeValue();
											}

											Node n_qualifier_id = QuaAtt.getNamedItem(qualifier_id);
											String s_qualifier_id = "";
											if(n_qualifier_id != null){
												s_qualifier_id = n_qualifier_id.getNodeValue();
											}

											Node n_value = QuaAtt.getNamedItem(value);
											String s_value = "";
											if(n_value != null){
												s_value = n_value.getNodeValue();
											}


											Qualifier qual = new Qualifier(s_Qid, s_qualifier_id, s_value);

											evento_partita.addQualifier(qual);
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
				
			}
		}
		
		
		
		System.out.println("");
		
		
		//adesso analisi^^
		
		
		
		HashMap<Values, Double> mappaValoriEventi  = new HashMap<Values, Double>();
		HashMap<QValues, Double> mappaValoriQuali  = new HashMap<QValues, Double>();
		
		
		loadHashMap(mappaValoriEventi);
		loadHashMap2(mappaValoriQuali);
		
		
		//carico anche i cosi di qualifier
		
		
		for(int i=0; i<games.size(); i++){
			
			System.out.println(games.size());
			
			Game on_work = games.get(i);
			
			ArrayList<Events> event_on_work = on_work.getEventi();
			
			
			for(int j = 0; j < event_on_work.size(); j++){
				
				double partialCount = 0;
				
				Events ev_work = event_on_work.get(j);
				
				String play_id = ev_work.getPlayer_id();
				
				//addScoreToPlayer(play_id, players);
				
				
				double Ix_position = Double.parseDouble(ev_work.getX());
				double Iy_position = Double.parseDouble(ev_work.getY());
				
				int Ievent_id = Integer.parseInt(ev_work.getType_id());
				
				int Ioutcome = Integer.parseInt(ev_work.getOutcome());
				
				Values v = new Values(Ievent_id, Ioutcome, positionRemapping(Ix_position));
				Values v2 = new Values(Ievent_id, Ioutcome, 0);
				
				if(mappaValoriEventi.get(v) != null || mappaValoriEventi.get(v2) != null){
					double valll = 0.0;
					
					if(mappaValoriEventi.get(v) != null){
						valll = mappaValoriEventi.get(v);
					}
					
					if(mappaValoriEventi.get(v2) != null){
						valll = mappaValoriEventi.get(v2);
					}
					
				
					partialCount = partialCount + valll;

					
					
					ArrayList<Qualifier> ev_qual = ev_work.getQua();
					for(int g =0; g<ev_qual.size(); g++){

						Qualifier q = ev_qual.get(g);

						int qid = Integer.parseInt(q.getQualifier_id());

						QValues qv = new QValues(qid, Ioutcome);

						if(mappaValoriQuali.get(qv) != null){

							double result = mappaValoriQuali.get(qv);

							partialCount = partialCount + result;
						}
					}

					//somma effettiva del punteggio
					addPointToPlayer(play_id, partialCount, players);
				}
				
				
			}
			
			//addinc(players);
			
			//printScores(teams, on_work, players);
			
		}
		
		printResult(players);
		
	}
	
	
	public static void addPointToPlayer(String id_player, double val, ArrayList<Player> lis){
		for(int i=0; i<lis.size(); i++){
			if(lis.get(i).getuID().equals(id_player)){
				lis.get(i).addScore(val);
				lis.get(i).addEv();  
			}
		}
	}
	
	public static void addinc( ArrayList<Player> lis){
		for(int i=0; i<lis.size(); i++){
			lis.get(i).incr();
		}
		
	}
	
	public static void printScores(ArrayList<Team> teams, Game on_work,  ArrayList<Player> lis){
		for(int j=0; j<teams.size(); j++){
			if(teams.get(j).getuID().equals(on_work.getAway_team_id()) || teams.get(j).getuID().equals(on_work.getHome_team_id())){
				for(int h=0; h<teams.get(j).getPlayers().size(); h++){
					//addScoreToPlayer(teams.get(j).getPlayers().get(h).getuID(), players);
					Player pl = getPl(teams.get(j).getPlayers().get(h).getuID(), lis);
				}
			}
		}
	}
	
	public static Player getPl(String id_player, ArrayList<Player> lis){
		for(int i=0; i<lis.size(); i++){
			if(lis.get(i).getuID().equals(id_player)){
				return lis.get(i);
			}
		}
		return null;
	}
	
	public static void addScoreToPlayer(String id_player, ArrayList<Player> lis){
		for(int i=0; i<lis.size(); i++){
			if(lis.get(i).getuID().equals(id_player)){
				lis.get(i).getScores().add(0.0);
			}
		}
		
	}
	
	public static Events findeventbyID(String id_event, ArrayList<Events> list){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getId().equals(id_event)){
				return list.get(i);
			}	
		}
		return null;
		
	}
	
	public static String findValuefromQuID(String qualifierID, ArrayList<Qualifier> qua){
		for(int i=0; i<qua.size(); i++){
			if(qua.get(i).getQualifier_id().equals(qualifierID)){
				return qua.get(i).getValue();
			}
		}
		return "";
	}
	
	
	public static String getCharacterDataFromElement(Node e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
		  CharacterData cd = (CharacterData) child;
		  return cd.getData();
		}
		return "";
	 }
	
	public static int positionRemapping(double x){
		if(x <= 33){
			return 1;
		}
		else if(x >= 34 && x <=66){
			return 2;
		}
		else if(x >66){
			return 3;
		}
		return 0;
	}
	
	public static void printResult(ArrayList<Player> l){
		
		for(int i=0; i<l.size(); i++){
			System.out.println(l.get(i).getName() + ":" + l.get(i).getEv() + " score"+l.get(i).getScore());
		}
		
	}
	
	public static void loadHashMap(HashMap<Values, Double> mappaValoriEventi){
		
		if(mappaValoriEventi != null){
			
			mappaValoriEventi.put(new Values(1, 1, 1), 0.011); //pass successo difensivo
			mappaValoriEventi.put(new Values(1, 1, 2), 0.012); //pass successo difensivo
			mappaValoriEventi.put(new Values(1, 1, 3), 0.013); //pass successo difensivo
			
			
			mappaValoriEventi.put(new Values(1, 0, 1), -0.04); //pass in-successo difensivo
			mappaValoriEventi.put(new Values(1, 0, 2), -0.03); //pass in-successo difensivo
			mappaValoriEventi.put(new Values(1, 0, 3), -0.02); //pass in-successo difensivo
			
			mappaValoriEventi.put(new Values(4, 0, 1), -1.0); //fallo difensivo
			mappaValoriEventi.put(new Values(4, 0, 2), -0.5); //fallo difensivo
			mappaValoriEventi.put(new Values(4, 0, 3), -0.1); //fallo difensivo
			
			mappaValoriEventi.put(new Values(8, 1, 0), 1.0); //trakle
			mappaValoriEventi.put(new Values(8, 0, 0), 0.3); //fallo difensivo
			
			mappaValoriEventi.put(new Values(10, 1, 0), 2.0); //save correlzione di moltiplicazione
			
			mappaValoriEventi.put(new Values(12, 1, 0), 0.15); //clearance
			
			mappaValoriEventi.put(new Values(13, 1, 0), -2.5); //miss con relazione precedente
			
			mappaValoriEventi.put(new Values(14, 1, 0), 1.5); //post relazione ancgolo di tiro
			
			mappaValoriEventi.put(new Values(15, 1, 0), 1.0); //attempt saved 
			
			
			mappaValoriEventi.put(new Values(16, 1, 0), 5.0);
			
			mappaValoriEventi.put(new Values(17, 1, 0), 0.0); // cartellini. rimanda ai qualifier
			
			mappaValoriEventi.put(new Values(44, 1, 0), 0.5); //scontro aereo vinto
			mappaValoriEventi.put(new Values(44, 0, 0), -0.5); //scontro aereo perso
			
			mappaValoriEventi.put(new Values(45, 0, 0), -0.75); //dribbling subito
			
			mappaValoriEventi.put(new Values(49, 1, 0), 0.2); //palla recuperata
			
			mappaValoriEventi.put(new Values(50, 0, 0), -0.5); //perso il possesso della palla
			
			mappaValoriEventi.put(new Values(51, 0, 0), -2.0); //errore: il valore va moltiplicato per i quantifiers
			
			mappaValoriEventi.put(new Values(52, 1, 0), 0.2); //palla recuperata dal portiere
			
			mappaValoriEventi.put(new Values(53, 0, 0), -2.0); //cross sbagliato
			
			mappaValoriEventi.put(new Values(55, 1, 0), 2.0); //il difensore ha il merito di aver messo in fuorigioco l'attaccante
			
			mappaValoriEventi.put(new Values(58, 1, 0), 4.0); //gol su rigore parato
			mappaValoriEventi.put(new Values(58, 0, 0), -4.0); //gol su rigore subito
			
			mappaValoriEventi.put(new Values(60, 1, 0), 1.5); //giocatore in ottima posizione per segnare ma il passaggio diretto a lui viene sbagliato
			
			mappaValoriEventi.put(new Values(74, 1, 0), 0.4); //passaggio bloccato
			
			mappaValoriEventi.put(new Values(2, 0, 0), -0.5); //passaggio effettuato verso un giocatore in fuorigioco
			
			
		}
		else{	
			return;
		}
	}
	
	public static void loadHashMap2(HashMap<QValues, Double> mappaValoriQualifier){
		
		if(mappaValoriQualifier != null){
		
			mappaValoriQualifier.put(new QValues(1, 1), 0.3); //passaggio lungo riuscito
			mappaValoriQualifier.put(new QValues(1, 0), -0.3); // passaggio lungo non riuscito
		
			mappaValoriQualifier.put(new QValues(2, 1), 0.4); //cross riuscito
			mappaValoriQualifier.put(new QValues(2, 0), -0.4); //cross non riuscito
		
			mappaValoriQualifier.put(new QValues(4, 1), 0.5); 
			mappaValoriQualifier.put(new QValues(4, 0), -0.2);
		
			mappaValoriQualifier.put(new QValues(7, 0), -1.0); //giocatore pescato in fuorigioco
		
			mappaValoriQualifier.put(new QValues(215, 1), 1.5); //giocata individuale
		
			mappaValoriQualifier.put(new QValues(3, 1), 0.1); //punizione procurata
		
			mappaValoriQualifier.put(new QValues(196, 1), 0.1); //cambio di gioco riuscito
			mappaValoriQualifier.put(new QValues(196, 0), -0.1); //cambio di gioco non riuscito
		
			mappaValoriQualifier.put(new QValues(210, 1), 2.0); // assist
		
			mappaValoriQualifier.put(new QValues(236, 0), -0.4); //passaggio bloccato
		
			mappaValoriQualifier.put(new QValues(28, 0), -4.0); //autogol
		
			mappaValoriQualifier.put(new QValues(254, 1), 0.5); //bonus al gol (preceduto da dribbling)
		
			mappaValoriQualifier.put(new QValues(261, 1), 0.25); //bonus al gol (uno contro uno col portiere)
		
			mappaValoriQualifier.put(new QValues(328, 1), 0.25); //bonus al gol (tiro di prima)
		
			mappaValoriQualifier.put(new QValues(101, 1), 2.5); //gol salvato sulla linea
		
			mappaValoriQualifier.put(new QValues(31, 0), -0.5); //cartellino giallo
		
			mappaValoriQualifier.put(new QValues(32, 0), -1.5); //secondo cartellino giallo
		
			mappaValoriQualifier.put(new QValues(33, 0), -2.5); //cartellino rosso
		
			mappaValoriQualifier.put(new QValues(186, 1), 4.0); //gol su rigore parato
		
			mappaValoriQualifier.put(new QValues(187, 0), -4.0); //gol su rigore subito
		
			mappaValoriQualifier.put(new QValues(169, 0), -1.5); 
		
			mappaValoriQualifier.put(new QValues(170, 0), -2.5);
			
		}
		
	}
}
