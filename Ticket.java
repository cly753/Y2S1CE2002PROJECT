package Moblima;

class Ticket {
    //private int movieId;
    private String movieName;
    private String typeOfMovie;
    private String nameOfCinema;
    private String classOfCinema;
    private String locationOfCinema;
    private String typeOfMoviegoer;
    private Time buyTime;
    private Time bookTime;
    private Time showTime;
    private double price;
    private int seatID; // ??? row col?
    private int ticketID;
    
    public Ticket(String movieName, String typeOfMovie, String nameOfCinema, String classOfCinema, String locationOfCinema,
                  String typeOfMoviegoer, Time showTime, int seatID, int ticketID) {
        this.setMovieName(movieName);
        this.setTypeOfMovie(typeOfMovie);
        this.setNameOfCinema(nameOfCinema);
        this.setClassOfCinema(classOfCinema);
        this.setLocationOfCinema(locationOfCinema);
        this.setTypeOfMoviegoer(typeOfMoviegoer);
        this.setShowTime(showTime);
        this.setSeatID(seatID);
        this.setTicketID(ticketID);

        this.setPrice();
    }

    public static display(Ticket ti) {
        System.out.println(ti.getMovieName() + " " + ti.getTypeOfMovie());
        System.out.println(ti.getShowTime());
        System.out.println(ti.getSetSeatID() + " " + ti.getTicketID() + " " + ti.getTypeOfMoviegoer());
        System.out.println(ti.getClassOfCinema() + " " + ti.getLocationOfCinema());
    }
    
    public String getMovieName() {
        return this.movieName;
    }
    public String getTypeOfMovie() {
        return this.typeOfMovie;
    }
    public String getNameOfCinema() {
        return this.nameOfCinema;
    }
    public String getClassOfCinema() {
        return this.classOfCinema;
    }
    public String getLocationOfCinema() {
        return this.locationOfCinema;
    }
    public String getTypeOfMoviegoer() {
        return this.typeOfMoviegoer;
    }
    public Time getShowTime() {
        return this.showTime;
    }
    public double getPrice() {
        return this.price;
    }
    public int getSeatID() {
        return this.seatID;
    }
    public int getTicketID() {
        return this.ticketID;
    }
    public Time getBuyTime() {
        return buyTime;
    }
    
    public boolean setMovieName(String movieName) {
        this.movieName = movieName;
        return true;
    }
    public boolean setTypeOfMovie(String typeOfMovie) {
        this.typeOfMovie = typeOfMovie;
        return true;
    }
    public boolean setNameOfCinema(String nameOfCinema) {
        this.nameOfCinema = nameOfCinema;
        return true;
    }
    public boolean setClassOfCinema(String classOfCinema) {
        this.classOfCinema = classOfCinema;
        return true;
    }
    public boolean setLocationOfCinema(String locationOfCinema) {
        this.locationOfCinema = locationOfCinema;
        return true;
    }
    public boolean setTypeOfMoviegoer(String typeOfMoviegoer) {
        this.typeOfMoviegoer = typeOfMoviegoer;
        return true;
    }
    public boolean setShowTime(Time showTime) {
        this.showTime = showTime;
        return true;
    }
    public boolean setSeatID(int seatID) {
        this.seatID = seatID;
        return true;
    }
    public boolean setTicketID(int ticketID) {
        this.ticketID = ticketID;
        return true;
    }
    public boolean setBuyTime(Time buyTime) {
        this.buyTime = buyTime;
        return true;
    }

    public boolean setPrice() {
        if (this.typeOfMoviegoer == "Senior Citizen") {
            if (this.typeOfMovie == "Digital Movie") {
                if(this.showTime.getWeekday()) {
                    this.price = 4;
                    return true;
                }
            }
        }
        if (this.typeOfMoviegoer == "Student") {
            if (this.typeOfMovie == "Digital Movie") {
                if (this.showTime.getWeekday()) {
                    this.price = 7;
                    return true;
                }
            } else {
                this.price = 9;
                return true;
            }
        }
        if (this.showTime.getWeekday()) {
            if (this.typeOfMovie == "Digital Movie") {
                this.price = 9.5;
            } else {
                this.price = 11;
            }
            return true;
        } else {
            if (this.typeOfMovie == "Digital Movie") {
                this.price = 11;
            } else {
                this.price = 15;
            }
            return true;
        }
    }
}
