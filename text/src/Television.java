
class Television extends Furniture implements Electric{
    private boolean on;
    private int height;
    private int width;
    public Television(int x, int y, int width, int height) {
        super(x, y);
        this.height = height;
        this.width = width;
        this.on =false;
    }

    @Override
    public void togglePowerState() {
        if(on == false) {
            on = true;
        }else {
            on = false;
        }
    }

    @Override
    public boolean getPowerState() {
        return on;
    }

    @Override
    public String display() {
        String temp;
        if(this.on){
            temp="on";
        }else {
            temp="off";
        }
        return "A "+this.width+"x"+this.height+" television in the "+temp+" state.";
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
