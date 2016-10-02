
package basics;


public class Car {
    
    private String brand;
    private String model;
    private String boardNumber;
    private int totalSeats;
    private int availableSeats;

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String toString() {
        return brand + ";" + model + ";" + boardNumber + ";" + totalSeats + ";" + availableSeats;
    }

    public Car(String brand, String model, String boardNumber, int totalSeats, int availableSeats) {
        this.brand = brand;
        this.model = model;
        this.boardNumber = boardNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }
   
}
