/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao.impl;

import com.dao.PatientDao;
import com.model.Admin;
import com.model.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
public class PatientDaoImpl implements PatientDao {

    private final DataSource dataSource;

    public PatientDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int create(Patient patient) {
        try (Connection conn = dataSource.getConnection()) {//установление соединения (получение соединения)
            int id;

            String sql = "insert into patients(surname,name,patronymic,address,phone,card_number,diagnosis,age) values(?,?,?,?,?,?,?,?)";//формирование запроса добавления
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {//в наш подготовленный запрос передаём строку с запросом
                preparedStatement.setString(1, patient.getSurname());
                preparedStatement.setString(2, patient.getName());
                preparedStatement.setString(3, patient.getPatronymic());
                preparedStatement.setString(4, patient.getAddress());
                preparedStatement.setString(5, patient.getPhone());
                preparedStatement.setInt(6, patient.getCardNumber());
                preparedStatement.setString(7, patient.getDiagnosis());
                preparedStatement.setInt(8, patient.getAge());
//переданный запрос меняем, указываем позицию ? и чем мы его занимаем, отсчёт с 1
                int affectedRows = preparedStatement.executeUpdate();//количество добавленных строчек

                if (affectedRows == 0) {// если строчки не добавлены выбрасывается исключение 
                    throw new SQLException("Creating user failed, no rows affected.");
                }
                sql = "SELECT * FROM patients ORDER BY id DESC LIMIT 1;";//сортируем в обратном порядке записи(от максимального до минимального) в бд и получаем первую строчку
                try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                    if (rs.next()) {//если результат имеет хотя бы 1у запись
                        id = rs.getInt("id"); //берём id свежесозданной строчки 
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public Set<Patient> read() {
        String req = "Select * from patients";
        Set<Patient> patient;
        try (Connection conn = dataSource.getConnection()) {
            try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(req)) {
                patient = new HashSet<>();
                while (resultSet.next()) {//пока есть записи 
                    int id = resultSet.getInt("id");
                    String surname = resultSet.getString("surname");
                    String name = resultSet.getString("name");
                    String patronymic = resultSet.getString("patronymic");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    int cardNumber = resultSet.getInt("card_number");
                    String diagnosis = resultSet.getString("diagnosis");
                    int age = resultSet.getInt("age");

                    patient.add(new Patient(id, surname, name, patronymic, address, phone, cardNumber, diagnosis, age));
                }
            }
            return patient;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(Patient patient) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "UPDATE patients SET surname =?,name =?,patronymic =?,address =?,phone =?,card_number =?,diagnosis =?,age =? WHERE id =?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, patient.getSurname());
                preparedStatement.setString(2, patient.getName());
                preparedStatement.setString(3, patient.getPatronymic());
                preparedStatement.setString(4, patient.getAddress());
                preparedStatement.setString(5, patient.getPhone());
                preparedStatement.setInt(6, patient.getCardNumber());
                preparedStatement.setString(7, patient.getDiagnosis());
                preparedStatement.setInt(8, patient.getAge());

                preparedStatement.setInt(9, patient.getId());
                return preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Patient patient) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "delete from patients where id = ?";
            try (PreparedStatement preparedStmt = connection.prepareStatement(query)) {
                preparedStmt.setInt(1, patient.getId());
                int result = preparedStmt.executeUpdate();
                return result;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

}
