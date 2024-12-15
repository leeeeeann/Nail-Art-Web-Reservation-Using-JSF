package pojo;
// Generated Sep 26, 2024 9:39:49 PM by Hibernate Tools 4.3.1

// Generated Oct 7, 2023 9:54:25 PM by Hibernate Tools 4.3.1
import DAO.ReservationDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 * Reservation generated by hbm2java
 */
@ManagedBean
public class Reservation implements java.io.Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String workshop;
    private List<Reservation> reservationList;

    public List<Reservation> getReservationList() {
        return reservationList == null ? this.getAllEmployee() : reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public List<Reservation> getAllEmployee() {
        ReservationDAO reservation = new ReservationDAO();
        return reservation.retrieveTblReservation()     ;
    }

    public List<Reservation> getAllRecords() {
        ReservationDAO list = new ReservationDAO();
        List<Reservation> listReservation = list.retrieveTblReservation();
        return listReservation;
    }

    public String getById() {
        String idReservation = id.toString();
        ReservationDAO reservation = new ReservationDAO();
        List<Reservation> listReservation = reservation.getbyID(idReservation);
        try {
            if (listReservation != null) {
                firstName = listReservation.get(0).firstName;
                lastName = listReservation.get(0).lastName;
                phone = listReservation.get(0).phone;
                email = listReservation.get(0).email;
                workshop = listReservation.get(0).workshop;
                return "reservation";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "index";
    }

    public String saveReservation() {
        ReservationDAO reservation = new ReservationDAO();
        reservation.addReservation(this);
        firstName = "";
        lastName = "";
        phone = "";
        email = "";
        workshop = "";
        return "reserved";
    }

    public String editReservation() {
        ReservationDAO reservation = new ReservationDAO();
        reservation.editUser(this);
        firstName = "";
        lastName = "";
        phone = "";
        email = "";
        workshop = "";
        return "reservation";
    }

    public String deleteReservation() {
        ReservationDAO reservation = new ReservationDAO();
        reservation.deleteUser(id);
        firstName = "";
        lastName = "";
        phone = "";
        email = "";
        workshop = "";
        return "reservation";
    }

    public Reservation() {
    }

    public Reservation(String firstName, String lastName, String phone, String email, String workshop) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.workshop = workshop;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkshop() {
        return this.workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }
    
        // Untuk mengambil id users untuk edit
    public String getById(int usersId) {
        ReservationDAO users = new ReservationDAO();
        List<Reservation> UsersList = users.ShowByID(usersId);
        try {
            id = UsersList.get(0).id;
            firstName = UsersList.get(0).firstName;
            lastName = UsersList.get(0).lastName;
            phone = UsersList.get(0).phone;
            email = UsersList.get(0).email;
            workshop = UsersList.get(0).workshop;
            return "edit";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "index";
    }

}