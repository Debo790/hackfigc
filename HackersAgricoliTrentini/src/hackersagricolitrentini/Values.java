/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackersagricolitrentini;

/**
 *
 * @author greed
 */
public class Values {
	
	int event_id;
	int outcome;
	int value_x;
	//int value_y;

	public Values(int event_id, int outcome, int value_x) {
		this.event_id = event_id;
		this.outcome = outcome;
		this.value_x = value_x;
	}

	@Override
	public int hashCode() {
		
		return event_id*100+outcome*10+value_x*1;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		return this.hashCode() == obj.hashCode();
	}
	
	
	
	
	
}
