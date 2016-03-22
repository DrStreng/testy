
import java.util.ArrayList;
import java.util.List;

public class LekiManager implements ILekiManager{

	private List<Leki> leki = new ArrayList();
	
	public void add(Leki l) {
		// TODO Auto-generated method stub
		this.leki.add(l);
		
	}

	public List<Leki> getAll() {
		// TODO Auto-generated method stub
		return this.leki;
		
	}

	public void remove(Leki l) {
		// TODO Auto-generated method stub
		this.leki.remove(l);
	}

}