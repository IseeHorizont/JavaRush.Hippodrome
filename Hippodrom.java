public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;
    
    public List<Horse> getHorses(){
        return horses;
    }
    
    public Hippodrome(List<Horse> horses){
        this.horses = horses; 
    }
    
    private static Horse getNewHorse(String name, int speed, int distance) {
        return new Horse(name, speed, distance);
    }
    
    public void run(){
        for(int i = 0; i < 100; i++){
            move();
            print();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                
            }
        }
    }
    public void move(){
        for(int i = 0; i < horses.size(); i++){
            horses.get(i).move();
        }
    }
    public void print(){
        for(int i = 0; i < horses.size(); i++){
            horses.get(i).print();
        }
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double winHorse = Math.max(Math.max(horses.get(0).getDistance(), horses.get(1).getDistance()), horses.get(2).getDistance());

        if (winHorse == horses.get(0).getDistance()) {
            winner = getHorses().get(0);
        } else if (winHorse == horses.get(1).getDistance()) {
            winner = getHorses().get(1);
        } else if (winHorse == horses.get(2).getDistance()) {
            winner = getHorses().get(2);
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    
    
    public static void main(String[] args){
        List<Horse> horseList = new ArrayList<>();
        horseList.add(getNewHorse("First", 3, 0));
        horseList.add(getNewHorse("Second", 3, 0));
        horseList.add(getNewHorse("Third", 3, 0));
        game = new Hippodrome(horseList);
        game.run();
        game.printWinner();
    }
}
