package gra;

import java.util.ArrayList;
import java.util.List;


public class QuokkaMaze {


	public List<Vertex> vertices;


	public QuokkaMaze() {
		this.vertices = new ArrayList<Vertex>();
	}

	public boolean add_vertex(Vertex v) {
		// TODO implement me, please!
		if (v==null) {
			return false;
		}
		for(int i=0;i<vertices.size();i++){
			if(vertices.get(i)==v)
				return false;
		}
		vertices.add(v);
		return true;
	}

	public boolean fix_edge(Vertex u, Vertex v) {
		// TODO implement me please.
		if(u==null||v==null) {
			return false;
		}
		if(!vertices.contains(v)||!vertices.contains(u)){
			return false;
		}
		if(u.neighbours.contains(v)&&v.neighbours.contains(u)) {
			return false;
		}else {
			u.add_edge(v);
			v.add_edge(u);
			return true;
		}
	}


	public boolean block_edge(Vertex u, Vertex v) {
		// TODO implement me, please!
		if(u==null||v==null) {
			return false;
		}
		if(u.neighbours.contains(v)&&v.neighbours.contains(u)) {
			u.rm_edge(v);
			v.rm_edge(u);
			return true;
		}else {
			return false;
		}

	}

	/**
	 * findPath returns a SIMPLE path between `s` and `t` such that from any
	 location with food along this path we reach the next location with
	 food in at most `k` steps
	 Example:
	 (* means the vertex has food)
	 *       *
	 A---B---C---D---E
	 1/ find_path(s=A, t=E, k=2) -> returns: [A, B, C, D, E]
	 2/ find_path(s=A, t=E, k=1) -> returns: null
	 (because there isn't enough food!)
	 3/ find_path(s=A, t=C, k=4) -> returns: [A, B, C]


	 * @param s The start vertex for the quokka colony
	 * @param t The destination for the quokka colony
	 * @param k The maximum number of hops between locations with food, so that the colony can survive!
	 * @return * The list of vertices to form the path from `s` to `t` satisfying the conditions.
	OR
	 * null if no simple path exists that can satisfy the conditions, or is invalid.
	 */
	public List<Vertex> find_path(Vertex s, Vertex t, int k) {
		// TODO implement me please
		return hh(s,t,k,k);
	}
	public List<Vertex> hh(Vertex s, Vertex t, int k,int tempK) {
		// TODO implement me please
		if(s==null||t==null||s.neighbours==null||t.neighbours==null||tempK<=0) {
			return null;
		}
		if(s==t){
			List<Vertex> result=new ArrayList<>();
			result.add(s);
			return result;
		}
		List<List<Vertex>> lists=new ArrayList<>();
		for(int i=0;i<s.neighbours.size();i++){
			if(s.neighbours.get(i).used)
				continue;
			s.used=true;
			if(s.neighbours.get(i).hasFood){
				List<Vertex> path = hh(s.neighbours.get(i), t, k,k);
				if(path!=null){
					path.add(0,s);
					lists.add(path);
				}
			}else {
				List<Vertex> path = hh(s.neighbours.get(i), t, k,tempK-1);
				if(path!=null){
					path.add(0,s);
					lists.add(path);
				}
			}
			s.used=false;
		}
		if(lists.size()==0){
			return null;
		}else {
			int index=-1,min=Integer.MAX_VALUE;
			for(int i=0;i<lists.size();i++){
				if(lists.get(i).size()<min){
					index=i;
					min=lists.get(i).size();
				}
			}
			return lists.get(index);
		}
	}

	/**
	 * Determines whether it is possible for the quokkas to make it from s
	 to t along a SIMPLE path where from any location with food we reach the next
	 location with food in at most k steps, by placing food at at most x
	 new locations

	 Example:
	 (* means the vertex has food)
	 *
	 A---B---C---D---E
	 1/ exists_with_extra_food(A, E, 2, 0) -> returns: False
	 (because we can't get from A to E with k=2 and 0 extra food)
	 2/ exists_with_extra_food(A, E, 2, 1) -> returns: True
	 (Yes, if we put food on `C` then we can get to E with k=2)
	 3/ exists_with_extra_food(A, E, 1, 6) -> returns: True
	 (Yes, if we put food on `B`, `C`, `D` then we reach E!)

	 * @param s The start vertex for the quokka colony
	 * @param t The destination for the quokka colony
	 * @param k The maximum number of hops between locations with food, so
	that the colony can survive!
	 * @param x The number of extra Foods to add.
	 * @return * True if with x added food we can complete the simple path
	 * False otherwise.
	 */
	public boolean exists_path_with_extra_food(Vertex s, Vertex t, int k, int x) {
		// TODO implement me please
		return hh1(s,t,k,k,x);
	}
	public boolean hh1(Vertex s, Vertex t, int k,int tempK, int x) {
		// TODO implement me please
		if(s==null||t==null||s.neighbours==null||t.neighbours==null||tempK<0||x<0||k<=0) {
			return false;
		}
		if(s==t){
			return true;
		}
		if(tempK==0&&x==0)
			return false;
		boolean result=false;
		for(int i=0;i<s.neighbours.size();i++){
			if(s.neighbours.get(i).used)
				continue;
			s.used=true;
			if(s.neighbours.get(i).hasFood){
				if(tempK==0){
					if(hh1(s.neighbours.get(i),t,k,k,x-1)){
						result=true;
					}
				}else {
					if(hh1(s.neighbours.get(i),t,k,k,x)){
						result=true;
					}
				}
			}else {
				if(tempK==0){
					if(hh1(s.neighbours.get(i),t,k,k-1,x-1)){
						result=true;
					}
				}else {
					if(hh1(s.neighbours.get(i),t,k,tempK-1,x)){
						result=true;
					}
				}
			}
			s.used=false;
		}
		return result;
	}

	public static void main(String[] args) {
		Vertex A = new Vertex(false);
		Vertex B = new Vertex(false);
		Vertex C = new Vertex(false);
		Vertex D = new Vertex(false);
		Vertex E = new Vertex(true);
		Vertex F = new Vertex(false);
		Vertex G = new Vertex(false);

		QuokkaMaze m = new QuokkaMaze();

		m.add_vertex(A);
		m.add_vertex(B);
		m.add_vertex(C);
		m.add_vertex(D);
		m.add_vertex(E);
		m.add_vertex(F);
		m.add_vertex(G);
		m.fix_edge(A, B);
		m.fix_edge(B, C);
		m.fix_edge(C, D);
		m.fix_edge(D, E);
		m.fix_edge(E, F);
		m.fix_edge(F, G);

		boolean a= m.exists_path_with_extra_food(A,G, 1,3);
		System.out.println(a);
	}
}
