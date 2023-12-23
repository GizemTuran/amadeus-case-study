package backendjava.amadeuscasestudy.request;

import java.util.Date;

public class FindDepartureTimeBetweenServiceRequest {

   private int departureAirportId;
   private int arrivalAirportId;
   private Date firstflighttime;
   private Date lastflighttime;

   public int getDepartureAirportId() {
      return departureAirportId;
   }

   public void setDepartureAirportId(int departureAirportId) {
      this.departureAirportId = departureAirportId;
   }

   public int getArrivalAirportId() {
      return arrivalAirportId;
   }

   public void setArrivalAirportId(int arrivalAirportId) {
      this.arrivalAirportId = arrivalAirportId;
   }

   public Date getFirstflighttime() {
      return firstflighttime;
   }

   public void setFirstflighttime(Date firstflighttime) {
      this.firstflighttime = firstflighttime;
   }

   public Date getLastflighttime() {
      return lastflighttime;
   }

   public void setLastflighttime(Date lastflighttime) {
      this.lastflighttime = lastflighttime;
   }
}
