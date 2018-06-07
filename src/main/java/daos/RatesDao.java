package daos;

import exceptions.RatesCalendarRuntimeException;
import pojos.Rate;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RatesDao {


    public void addRate(Rate rate) throws ClassNotFoundException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection connection = DriverManager.getConnection(url);
                     //DataSourceProvider.getInstance().getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO rate(rate, startdate, enddate, source, destination, currency, transfertime,vehicletype,uniqueref) VALUES(?,?,?,?,?,?,?,?,?)")) {
            statement.setDouble(1, rate.getRate());
            statement.setString(2, rate.getStartDate());
            statement.setString(3, rate.getEndDate());
            statement.setString(4, rate.getSource());
            statement.setString(5, rate.getDestination());
            statement.setString(6, rate.getCurrency());
            statement.setInt(7, rate.getTransferTime());
            statement.setString(8, rate.getVehicleType());
            statement.setString(9, rate.getUniqueRef());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RatesCalendarRuntimeException("Error while adding rate...", e);
        }
    }

    public List<Rate> listAllRates() throws ClassNotFoundException {

        List<Rate> rateList = new ArrayList<>();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection connection = DriverManager.getConnection(url);
                     //DataSourceProvider.getInstance().getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM rate")) {
            while (resultSet.next()) {
                rateList.add(
                        new Rate(
                                resultSet.getInt("idrate"),
                                resultSet.getDouble("ratevalue"),
                                resultSet.getString("uniqueref"),
                                resultSet.getString("source"),
                                resultSet.getString("destination"),
                                resultSet.getInt("transfertime"),
                                resultSet.getString("currency"),
                                resultSet.getString("vehicletype"),
                                resultSet.getString("startdate"),
                                resultSet.getString("enddate"),
                                resultSet.getString("IATA")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RatesCalendarRuntimeException("Error while listing rates", e);
        }

        return rateList;
    }

    public Rate getRateById(Integer idRate) throws ClassNotFoundException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection connection = DriverManager.getConnection(url);
                     //DataSourceProvider.getInstance().getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM rate WHERE idrate=?")) {
            statement.setInt(1, idRate);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Rate(
                            resultSet.getInt("idrate"),
                            resultSet.getDouble("ratevalue"),
                            resultSet.getString("uniqueref"),
                            resultSet.getString("source"),
                            resultSet.getString("destination"),
                            resultSet.getInt("transfertime"),
                            resultSet.getString("currency"),
                            resultSet.getString("vehicletype"),
                            resultSet.getString("startdate"),
                            resultSet.getString("enddate"),
                            resultSet.getString("IATA")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RatesCalendarRuntimeException("Error while getting specified rate", e);
        }
        return null;
    }

    public void updateRate(Rate rate, Integer idRate) throws ClassNotFoundException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection connection = DriverManager.getConnection(url);
                     //DataSourceProvider.getInstance().getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE rate SET rate=?, startdate=?, enddate=?, source=?, destination=?, currency=?, transfertime=?,vehicletype=? WHERE idrate = ?")) {
            statement.setDouble(1, rate.getRate());
            statement.setString(2, rate.getStartDate());
            statement.setString(3, rate.getEndDate());
            statement.setString(4, rate.getSource());
            statement.setString(5, rate.getDestination());
            statement.setString(6, rate.getCurrency());
            statement.setInt(7, rate.getTransferTime());
            statement.setString(8, rate.getVehicleType());
            statement.setInt(9, idRate);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RatesCalendarRuntimeException("Error while updating rate...", e);
        }
    }
}
