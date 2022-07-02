package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {  // Como será feito a diferença entre datas, o retorno será em Long, portanto já iniciar o método com long.
        long diff = checkOut.getTime() - checkIn.getTime(); // O tempo padrão do JAVA é medido em Milisegundos. Portanto a resposta será em Milisegundos.
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Usado para conversão de Milisegundos para dias.
    }

    public String updateDates(Date checkIn, Date checkOut) {

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Reservation dates for update must be in future";
        }
        if (!checkOut.after(checkIn)) {
            return "Check out date must be after check in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + " Check-In: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }

}
