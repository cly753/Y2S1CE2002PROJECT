package Moblima;

public class Session {

    private Time time;
    private Cinema cinema;
    private Seat[][] seat;
    private int numOfEmptySeat;

    public Session(Time time, Cinema cinema) {
        this.cinema = cinema; // reference
        this.time = time; // new a time
        seat = new Seat[cinema.getRow()][cinema.getColumn()];
        for (int i = 0; i < cinema.getRow(); i++) {
            for (int j = 0; j < cinema.getColumn(); j++) {
                seat[i][j] = new Seat(i, j);
            }
        }
        numOfEmptySeat = cinema.getRow() * cinema.getColumn();
    }
    
    public Session(String s) {
    	String[] temp = s.split("##");
    	this.time = new Time(temp[0]);
    	this.cinema = new Cinema(temp[1]);
    	this.numOfEmptySeat = Integer.parseInt(temp[3]);
    	
    	String seatB = Integer.toBinaryString(Integer.parseInt(temp[2]));
    	Seat[][] seat = new Seat[cinema.getRow()][cinema.getColumn()];
    	for (int i = 0; i < cinema.getRow(); i++) {
    		for (int j = 0; j < cinema.getColumn(); j++) {
    			seat[i][j] = new Seat(i, j);
    			
    			seat[i][j].assign();
    			if ((seatB.charAt(cinema.getRow() * i + j)+"").compareTo("1") == 0)
    				seat[i][j].unAssign();
    		}
    	}
    }

    public String toString() {
    	String seatStr = "";
    	for (int i = 0; i < cinema.getRow(); i++) {
    		for (int j = 0; j < cinema.getColumn(); j++) {
    			seatStr += seat[i][j].getAssign() ? "1" : "0";
    		}
    	}
    	return time.toString() + "##" + cinema.toString() + "##" + Integer.parseInt(seatStr, 2) + "##" + numOfEmptySeat;
    }

    public Time getTime() {
        return this.time;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public void presentSeat() {
        System.out.print("  ");
        for (int j = 0; j < cinema.getRow(); j++) {
            System.out.print(" " + j);
        }
        System.out.println();
        for (int j = 0; j < cinema.getColumn(); j++) {
            System.out.print(" _");
        }
        System.out.println();
        for (int i = 0; i < cinema.getRow(); i++) {
            System.out.print("\n" + i + "|");
            for (int j = 0; j < cinema.getColumn(); j++) {
                if (seat[i][j].getAssign()) {
                    System.out.print(" O");
                } else {
                    System.out.print(" x");
                }
            }
        }
        System.out.println();
    }

    public boolean assignSeat(int row, int column) {
        if (this.seat[row][column] == null) {
            return false;
        }
        if (this.seat[row][column].getAssign()) {
            System.out.println("Seat already assgined to a customer.");
            return false;
        }
        this.seat[row][column].assign();
        numOfEmptySeat--;
        System.out.println("Seat Assigned!");
        return true;
    }

    public boolean unAssignSeat(Integer row, Integer column) {
        if (this.seat[row][column] == null) {
            return false;
        }
        seat[row][column].unAssign();
        numOfEmptySeat++;
        System.out.println("Seat Unassigned!");
        return true;
    }
}