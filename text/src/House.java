
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class House {


	private List<Furniture> furniture;

	public House() {
		this.furniture = new ArrayList<Furniture>();
	}

	public String listFurniture() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("This house contains:");
		if(this.furniture.size()!=0){
			stringBuilder.append("\n");
			for (int i = 0; i < this.furniture.size(); i++) {
				stringBuilder.append(furniture.get(i).display());
				if(i!=this.furniture.size()-1){
					stringBuilder.append("\n");
				}
			}
		}

		return stringBuilder.toString();
	}

	public void insert(Furniture item) {
		if(item!=null)
		furniture.add(item);
	}

	public boolean containsTelevision() {
		boolean result = false;
		for (int i = 0; i < this.furniture.size(); i++) {
			if (this.furniture.get(i) instanceof Television) {
				result = true;
			}
		}
		return result;
	}

	public int countChairs() {

		int result = 0;
		for (int i = 0; i < this.furniture.size(); i++) {

			if (this.furniture.get(i) instanceof Chair) {
				result++;
			}
			if (this.furniture.get(i) instanceof Table) {
				int num=0;
				Iterator<Chair> iterator = ((Table) this.furniture.get(i)).iterator();
				while(iterator.hasNext()){
					num++;
					iterator.next();
				}
				result += num;
			}

		}
		return result;
	}
}







