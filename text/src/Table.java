import java.util.Iterator;

class Table extends Furniture implements Iterable<Chair>{
    private Chair[] chairSet;
    private String tableclothColour;

    public Table(int x, int y, String colour, int chairs ) {
        super(x,y);
        this.tableclothColour = colour;
        if(chairs>=0) {
            this.chairSet = new Chair[chairs];
            for (int i = 0; i < chairs; i++) {
                double rating=0;
                if(colour!=null) {
                    rating=Math.abs((colour+i).hashCode()%101);
                }
                chairSet[i] = new Chair(x, y, rating);
            }
        }
    }
    int index = 0;
    @Override
    public Iterator<Chair> iterator() {
        index=0;
        return new Iterator<Chair>() {
            @Override
            public boolean hasNext() {
                return index < chairSet.length;
            }
            @Override
            public Chair next() {
                return chairSet[index++];
            }
        };
    }

    @Override
    public String display() {
        //TODO
        StringBuilder stringBuilder=new StringBuilder();
        if("".equals(this.tableclothColour)||this.tableclothColour==null){
            stringBuilder.append("A table with no tablecloth");
        }else {
            stringBuilder.append("A table with a "+this.tableclothColour+" tablecloth");
        }
        if(this.chairSet!=null&&this.chairSet.length>=0){
            stringBuilder.append("\n");
            Iterator<Chair> iterator=this.iterator();
            while(iterator.hasNext()){
                stringBuilder.append(" - "+iterator.next().display());
                if(iterator.hasNext()){
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}
