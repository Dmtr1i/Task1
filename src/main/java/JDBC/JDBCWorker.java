package JDBC;

import Contracts.Contract;
import Contracts.InternetContract;
import Contracts.MobileContract;
import Contracts.TelevisionContract;
import Repository.Repository;

import java.sql.*;

public class JDBCWorker {
    public static final String connectionUrl = "jdbc:postgresql://localhost:5432/repository";
    public static final String user = "postgres";
    public static final String password = "postgres";

    private Connection connection;

    public JDBCWorker(String tempUrl, String tempUser, String tempPass) throws SQLException {
        connection = DriverManager.getConnection(tempUrl, tempUser, tempPass);
    }

    public <T extends Contract> void writeRepo(Repository<T> repo, int repoId) throws SQLException {
        DataConverter converter = new DataConverter();
        String insertContractStatement;
        String insertPersonStatement;
        for (int i = 0; i < repo.getSize(); i++) {
            if (personExist(repo.getByIndex(i).getOwner().getName()) == null) {
                insertPersonStatement = "insert into person values\n" +
                        "(?,?,?,?,?,?,?)";
                PreparedStatement personStatement = connection.prepareStatement(insertPersonStatement);
                personStatement.setInt(1, (int)repo.getByIndex(i).getOwner().getId());
                personStatement.setString(2, repo.getByIndex(i).getOwner().getName());
                personStatement.setDate(3, converter.convertToDatabaseColumn(repo.getByIndex(i).getOwner().getBirthDate()));
                personStatement.setString(4, repo.getByIndex(i).getOwner().getGender());
                personStatement.setInt(5, repo.getByIndex(i).getOwner().getPassportSeries());
                personStatement.setInt(6, repo.getByIndex(i).getOwner().getPassportNumber());
                personStatement.setInt(7, repo.getByIndex(i).getOwner().getAge());
                personStatement.executeUpdate();
            }
            if (repo.getByIndex(i).getClass().getSimpleName().equals("InternetContract")) {
                insertContractStatement = "insert into internet_contract values\n" +
                        "(?,?,?,?,?,?,?)";
                PreparedStatement contractStatement = connection.prepareStatement(insertContractStatement);
                contractStatement.setInt(1, repo.getByIndex(i).getId());
                contractStatement.setDate(2, converter.convertToDatabaseColumn(repo.getByIndex(i).getStartContract()));
                contractStatement.setDate(3, converter.convertToDatabaseColumn(repo.getByIndex(i).getEndContract()));
                contractStatement.setInt(4, repo.getByIndex(i).getNumber());
                contractStatement.setString(5, repo.getByIndex(i).getOwner().getName());
                contractStatement.setInt(6, ((InternetContract)repo.getByIndex(i)).getConnectionSpeed());
                contractStatement.setInt(7, (int)repo.getByIndex(i).getOwner().getId());
                contractStatement.executeUpdate();
            }
            if (repo.getByIndex(i).getClass().getSimpleName().equals("MobileContract")) {
                insertContractStatement = "insert into internet_contract values\n" +
                        "(?,?,?,?,?,?,?,?,?)";
                PreparedStatement contractStatement = connection.prepareStatement(insertContractStatement);
                contractStatement.setInt(1, repo.getByIndex(i).getId());
                contractStatement.setDate(2, converter.convertToDatabaseColumn(repo.getByIndex(i).getStartContract()));
                contractStatement.setDate(3, converter.convertToDatabaseColumn(repo.getByIndex(i).getEndContract()));
                contractStatement.setInt(4, repo.getByIndex(i).getNumber());
                contractStatement.setString(5, repo.getByIndex(i).getOwner().getName());
                contractStatement.setInt(6, ((MobileContract)repo.getByIndex(i)).getMinutes());
                contractStatement.setInt(7, ((MobileContract)repo.getByIndex(i)).getMessages());
                contractStatement.setInt(8, ((MobileContract)repo.getByIndex(i)).getInternet());
                contractStatement.setInt(9, (int)repo.getByIndex(i).getOwner().getId());
                contractStatement.executeUpdate();
            }
            if (repo.getByIndex(i).getClass().getSimpleName().equals("TelevisionContract")) {
                String insertTVChannels = "insert into television_contract_channels values\n" +
                        "(?,?)";
                PreparedStatement contractChannelsStatement = connection.prepareStatement(insertTVChannels);
                for (int j = 0; j < ((TelevisionContract)repo.getByIndex(i)).getChannels().size(); j++) {
                    contractChannelsStatement.setInt(1, repo.getByIndex(i).getId());
                    contractChannelsStatement.setString(2, ((TelevisionContract)repo.getByIndex(i)).getChannels().get(j));
                    contractChannelsStatement.executeUpdate();
                }
                insertContractStatement = "insert into television_contract values\n" +
                        "(?,?,?,?,?,?)";
                PreparedStatement contractStatement = connection.prepareStatement(insertContractStatement);
                contractStatement.setInt(1, repo.getByIndex(i).getId());
                contractStatement.setDate(2, converter.convertToDatabaseColumn(repo.getByIndex(i).getStartContract()));
                contractStatement.setDate(3, converter.convertToDatabaseColumn(repo.getByIndex(i).getEndContract()));
                contractStatement.setInt(4, repo.getByIndex(i).getNumber());
                contractStatement.setString(5, repo.getByIndex(i).getOwner().getName());
                contractStatement.setInt(6, (int)repo.getByIndex(i).getOwner().getId());
                contractStatement.executeUpdate();
            }
        }
    }

    public String personExist(String person) {
        String getPerson = "select p.name from person p where p.id=" + person;
        return getPerson;
    }
}
