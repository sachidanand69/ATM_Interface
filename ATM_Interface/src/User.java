public class User {
    private String FirstName;
    private String LastName;
    private int Age;
    private String Address;
    private String email;
    private String Gender;
    private long accountNo;
    private int Pin;
    private double Amount;

    public User() {
        super();
    }

    public User(String firstName, String lastName, int age, String address, String email, String gender,
            long accountNo, int pin, double amount) {
        super();
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Address = address;
        this.email = email;
        Gender = gender;
        this.accountNo = accountNo;
        Pin = pin;
        Amount = amount;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public int getPin() {
        return Pin;
    }

    public void setPin(int pin) {
        Pin = pin;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }
}
