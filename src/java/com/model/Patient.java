package com.model;

public class Patient {

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String phone;
    private int cardNumber;
    private String diagnosis;
    private int age;

    public Patient(int id, String surname, String name, String patronymic, String address, String phone, int cardNumber, String diagnosis, int age) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.cardNumber = cardNumber;
        this.diagnosis = diagnosis;
        this.age = age;
    }
    
        public Patient(String surname, String name, String patronymic, String address, String phone, int cardNumber, String diagnosis, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.cardNumber = cardNumber;
        this.diagnosis = diagnosis;
        this.age = age;
    }
    
     public Patient(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient{"
                + "id=" + id
                + ", surname='" + surname + '\''
                + ", name='" + name + '\''
                + ", patronymic='" + patronymic + '\''
                + ", address='" + address + '\''
                + ", phone='" + phone + '\''
                + ", cardNumber=" + cardNumber
                + ", diagnosis='" + diagnosis + '\''
                + ", age='" + age + '\''
                + '}';
    }

}
