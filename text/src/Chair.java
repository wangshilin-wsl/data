
class Chair extends Furniture{
    private boolean occupied;
    private double comfortRating;

    public double getComfortRating() {
        return comfortRating;
    }

    public void setComfortRating(double comfortRating) {
        this.comfortRating = comfortRating;
    }

    public Chair(int x, int y, double comfort) {
        super(x,y);
        if (comfort>100) {
            this.comfortRating = 100;
        }else if(comfort<0) {
            this.comfortRating = 0;
        }else {
            this.comfortRating = comfort;
        }
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy(Ornament o) {
        if(o!=null)
        if (o.getValuation()>=100) {
            occupied = true;
        }else{
            occupied =false;
        }
    }
    @Override
    public String display() {
        //TODO
        return "A chair with comfort rating "+this.comfortRating;
    }

}