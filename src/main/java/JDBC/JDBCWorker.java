package JDBC;

import Contracts.*;
import Person.Person;
import Repository.Repository;

import java.sql.*;
import java.util.Arrays;

public class JDBCWorker {
    public static final String connectionUrl = "jdbc:postgresql://localhost:5432/netcrackerRepositoryTask1";
    public static final String user = "postgres";
    public static final String password = "postgres";

    private Connection connection;

    public JDBCWorker(String tempUrl, String tempUser, String tempPass) throws SQLException {
        connection = DriverManager.getConnection(tempUrl, tempUser, tempPass);
    }



    public <T extends Contract> void writeRepo(Repository<T> repo) throws SQLException {
        DataConverter converter = new DataConverter();
        String insertContractStatement;
        String insertPersonStatement;
        for (int i = 0; i < repo.getSize(); i++) {
            if (!personExist(repo.getByIndex(i).getOwner().getId())) {
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
                insertContractStatement = "insert into mobile_contract values\n" +
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

    public Repository readRepo(){
        String sqlPerson;
        DataConverter converter = new DataConverter();
        Repository repository = new Repository();
        try(Statement statement = connection.createStatement()) {
            sqlPerson = "select * from person";
            try (ResultSet resultSet = statement.executeQuery(sqlPerson)) {
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt(1));
                    person.setName(resultSet.getString(2));
                    person.setBirthDate(converter.convertToEntityAttribute(resultSet.getDate(3)));
                    person.setGender(resultSet.getString(4));
                    person.setPassportSeries(resultSet.getInt(5));
                    person.setPassportNumber(resultSet.getInt(6));
                    person.setAge(resultSet.getInt(7));
                    String contractRequest = "select * from mobile_contract where owner_id=" + person.getId();
                    ResultSet getContract = statement.executeQuery(contractRequest);
                    while (getContract.next()) {
                        MobileContract contract = new MobileContract();
                        contract.setId(getContract.getInt(1));
                        contract.setStartContract(converter.convertToEntityAttribute(getContract.getDate(2)));
                        contract.setEndContract(converter.convertToEntityAttribute(getContract.getDate(3)));
                        contract.setNumber(getContract.getInt(4));
                        contract.setOwner(person);
                        contract.setMinutes(getContract.getInt(6));
                        contract.setMessages(getContract.getInt(7));
                        contract.setInternet(getContract.getInt(8));
                        repository.add(contract);
                    }
                    contractRequest = "select * from internet_contract where owner_id=" + person.getId();
                    ResultSet getContract1 = statement.executeQuery(contractRequest);
                    while (getContract1.next()) {
                        InternetContract contract = new InternetContract();
                        contract.setId(getContract1.getInt(1));
                        contract.setStartContract(converter.convertToEntityAttribute(getContract1.getDate(2)));
                        contract.setEndContract(converter.convertToEntityAttribute(getContract1.getDate(3)));
                        contract.setNumber(getContract1.getInt(4));
                        contract.setOwner(person);
                        contract.setConnectionSpeed(getContract1.getInt(6));
                        repository.add(contract);
                    }
                    contractRequest = "select * from television_contract where owner_id=" + person.getId();
                    ResultSet getContract2 = statement.executeQuery(contractRequest);
                    while (getContract2.next()) {
                        TelevisionContract contract = new TelevisionContract();
                        contract.setId(getContract2.getInt(1));
                        String channelsRequest = "select * from television_contract_channels where id_contract=" + contract.getId();
                        ResultSet getChannels = statement.executeQuery(channelsRequest);
                        String[] channels = new String[0];
                        while (getChannels.next()) {
                            String[] temp = channels;
                            channels = new String[temp.length + 1];
                            for (int i = 0; i < temp.length; i++) {
                                channels[i] = temp[i];
                            }
                            channels[channels.length - 1] = getChannels.getString(2);
                        }
                        contract.setStartContract(converter.convertToEntityAttribute(getContract2.getDate(2)));
                        contract.setEndContract(converter.convertToEntityAttribute(getContract2.getDate(3)));
                        contract.setNumber(getContract2.getInt(4));
                        contract.setOwner(person);
                        contract.setChannels(Arrays.stream(channels).toList());
                        repository.add(contract);
                    }
                }
            }
            System.out.println(repository);
            return repository;
        } catch(SQLException e) {
            System.out.println("Error in reading repository: " + e);
        }
        return repository;
    }

    public boolean personExist(long id) throws SQLException {
        String getPerson = "select p.name from person p where p.id=" + id;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(getPerson);
        int i = 0;
        if (result.next()) return true;
        else return false;
    }

    public void clearRepo() throws SQLException {
        String clearSql = "delete from person";
        PreparedStatement clear = connection.prepareStatement(clearSql);
        clear.executeUpdate();
        clearSql = "delete from internet_contract";
        clear = connection.prepareStatement(clearSql);
        clear.executeUpdate();
        clearSql = "delete from mobile_contract";
        clear = connection.prepareStatement(clearSql);
        clear.executeUpdate();
        clearSql = "delete from television_contract_channels";
        clear = connection.prepareStatement(clearSql);
        clear.executeUpdate();
        clearSql = "delete from television_contract";
        clear = connection.prepareStatement(clearSql);
        clear.executeUpdate();
    }
}
