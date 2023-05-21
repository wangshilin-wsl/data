package gra;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	
	public boolean hasFood;
	public List<Vertex> neighbours;
	public boolean used;

    public Vertex(boolean hasFood) {
    	this.used=false;
    	this.hasFood = hasFood;
    	this.neighbours = new ArrayList<Vertex>();
    }

 
    public void add_edge(Vertex v) {
        // TODO implement me please!
    	if (v==null||v==this) {
    		return ;
    	}
    	for(int i=0;i<this.neighbours.size();i++){
    		if(this.neighbours.get(i)==v)
    			return;
		}
    	neighbours.add(v);
    }

    public void rm_edge(Vertex v) {
        // TODO implement me please!
    	if (v==null) {
    		return ;
    	}
    	neighbours.remove(v);
    }
}