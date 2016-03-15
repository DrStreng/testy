package leki;

import java.util.ArrayList;
import java.util.List;

public class LekiManager {

ArrayList<Leki> leki = new ArrayList<Leki>();
	public void add(Leki l){
		leki.add(l);
	}
	public ArrayList<Leki> getAll(){
		return leki;
	}
}

