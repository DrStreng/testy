
import java.util.ArrayList;
import java.util.List;


public class LekiManager implements ILekiManager{
	
	private IMyList lekis;
	
	public LekiManager(IMyList lekis){
		super();
		this.lekis = lekis;
	}

	public void add(Leki l) {
		// TODO Auto-generated method stub
		lekis.add(l);
	}

	public IMyList getAll() {
		// TODO Auto-generated method stub
		return lekis.getAll();
	}


}