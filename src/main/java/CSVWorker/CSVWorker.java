package CSVWorker;
import Contracts.*;
import Person.*;
import Repository.*;
import Validation.ContractValidator;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CSVWorker <T extends Contract> {

    /*
    Class for work with CSV files
     */
    public CSVWorker() {}
    /*
    That method reads CSV files
     */
    public Repository readFile(FileReader file, Repository repo) {
        if (file == null) {
            System.out.println("No file selected");
            return null;
        }
        try {
            CSVReader reader = new CSVReader(file);
            String[] data;
            /*
            choose the type of contract, read It and add to the repository
             */
            while ((data = reader.readNext()) != null) {
                if (data[0].contains("InternetContract")) {
                    int ownerId = Integer.parseInt(data[5].replaceAll("\\s", ""));
                    String ownerName = data[6].replaceAll("^\\s", "");
                    String dateTemp = data[7].replaceAll("\\s", "");
                    String[] dateTemp2 = dateTemp.split("\\.");
                    int ownerBirthDateDay = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int ownerBirthDateMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int ownerBirthDateYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    String ownerGender = data[8].replaceAll("\\s", "");
                    int ownerPasSeries = Integer.parseInt(data[9].replaceAll("\\s", ""));
                    int ownerPasNumber = Integer.parseInt(data[10].replaceAll("\\s", ""));
                    Person owner = new Person(ownerId, ownerName, LocalDate.of(ownerBirthDateYear, ownerBirthDateMonth, ownerBirthDateDay), ownerGender, ownerPasNumber, ownerPasSeries);
                    int contractId = Integer.parseInt(data[1].replaceAll("\\s", ""));
                    dateTemp = data[2].replaceAll("\\s", "");
                    dateTemp2 = dateTemp.split("\\.");
                    int contractStartDate = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int contractStartMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int contractStartYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    dateTemp = data[3].replaceAll("\\s", "");
                    dateTemp2 = dateTemp.split("\\.");
                    int contractEndDate = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int contractEndMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int contractEndYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    int contractNumber = Integer.parseInt(data[4].replaceAll("\\s", ""));
                    int contractConnectionSpeed = Integer.parseInt(data[12].replaceAll("\\s", ""));
                    InternetContract internet = new InternetContract(contractId, LocalDate.of(contractStartYear, contractStartMonth, contractStartDate),
                            LocalDate.of(contractEndYear, contractEndMonth, contractEndDate), contractNumber, owner, contractConnectionSpeed);
                    ContractValidator vali = new ContractValidator();
                    vali.validate(internet);
                    System.out.println(vali.toString());
                    repo.add(internet);
                }
                else if (data[0].contains("MobileContract")) {
                    int ownerId = Integer.parseInt(data[5].replaceAll("\\s", ""));
                    String ownerName = data[6].replaceAll("^\\s", "");
                    String dateTemp = data[7].replaceAll("\\s", "");
                    String[] dateTemp2 = dateTemp.split("\\.");
                    int ownerBirthDateDay = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int ownerBirthDateMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int ownerBirthDateYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    String ownerGender = data[8].replaceAll("\\s", "");
                    int ownerPasSeries = Integer.parseInt(data[9].replaceAll("\\s", ""));
                    int ownerPasNumber = Integer.parseInt(data[10].replaceAll("\\s", ""));
                    Person owner = new Person(ownerId, ownerName, LocalDate.of(ownerBirthDateYear, ownerBirthDateMonth, ownerBirthDateDay), ownerGender, ownerPasNumber, ownerPasSeries);
                    int contractId = Integer.parseInt(data[1].replaceAll("\\s", ""));
                    dateTemp = data[2].replaceAll("\\s", "");
                    dateTemp2 = dateTemp.split("\\.");
                    int contractStartDate = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int contractStartMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int contractStartYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    dateTemp = data[3].replaceAll("\\s", "");
                    dateTemp2 = dateTemp.split("\\.");
                    int contractEndDate = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int contractEndMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int contractEndYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    int contractNumber = Integer.parseInt(data[4].replaceAll("\\s", ""));
                    int contractMinutes = Integer.parseInt(data[12].replaceAll("\\s", ""));
                    int contractMessages = Integer.parseInt(data[13].replaceAll("\\s", ""));
                    int contractInternet = Integer.parseInt(data[14].replaceAll("\\s", ""));
                    MobileContract mobile = new MobileContract(contractId, LocalDate.of(contractStartYear, contractStartMonth, contractStartDate),
                            LocalDate.of(contractEndYear, contractEndMonth, contractEndDate), contractNumber, owner, contractMinutes, contractMessages, contractInternet);
                    ContractValidator vali = new ContractValidator();
                    vali.validate(mobile);
                    System.out.println(vali.toString());
                    repo.add(mobile);
                }
                else if (data[0].contains("TelevisionContract")) {
                    int ownerId = Integer.parseInt(data[5].replaceAll("\\s", ""));
                    String ownerName = data[6].replaceAll("^\\s", "");
                    String dateTemp = data[7].replaceAll("\\s", "");
                    String[] dateTemp2 = dateTemp.split("\\.");
                    int ownerBirthDateDay = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int ownerBirthDateMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int ownerBirthDateYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    String ownerGender = data[8].replaceAll("\\s", "");
                    int ownerPasSeries = Integer.parseInt(data[9].replaceAll("\\s", ""));
                    int ownerPasNumber = Integer.parseInt(data[10].replaceAll("\\s", ""));
                    Person owner = new Person(ownerId, ownerName, LocalDate.of(ownerBirthDateYear, ownerBirthDateMonth, ownerBirthDateDay), ownerGender, ownerPasNumber, ownerPasSeries);
                    int contractId = Integer.parseInt(data[1].replaceAll("\\s", ""));
                    dateTemp = data[2].replaceAll("\\s", "");
                    dateTemp2 = dateTemp.split("\\.");
                    int contractStartDate = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int contractStartMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int contractStartYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    dateTemp = data[3].replaceAll("\\s", "");
                    dateTemp2 = dateTemp.split("\\.");
                    int contractEndDate = Integer.parseInt(dateTemp2[0].replaceAll("\\s", ""));
                    int contractEndMonth = Integer.parseInt(dateTemp2[1].replaceAll("\\s", ""));
                    int contractEndYear = Integer.parseInt(dateTemp2[2].replaceAll("\\s", ""));
                    int contractNumber = Integer.parseInt(data[4].replaceAll("\\s", ""));
                    String contractChannels = data[12];
                    contractChannels = contractChannels.replaceAll(" ", "");
                    contractChannels = contractChannels.replaceAll("\\[", "");
                    contractChannels = contractChannels.replaceAll("\\]", "");
                    String[] contractChannelsAr = contractChannels.split("\\.");
                    List<String> contractChannelsList = Arrays.stream(contractChannelsAr).toList();
                    TelevisionContract tv = new TelevisionContract(contractId, LocalDate.of(contractStartYear, contractStartMonth, contractStartDate),
                            LocalDate.of(contractEndYear, contractEndMonth, contractEndDate), contractNumber, owner, contractChannelsList);
                    ContractValidator vali = new ContractValidator();
                    vali.validate(tv);
                    System.out.println(vali.toString());
                    repo.add(tv);
                }

            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } catch (CsvValidationException ex) {
            System.out.println("Error: " + ex);
        }
        return repo;
    }
    /*
    That method writes CSV file
     */
    public void writeFile (FileWriter file, Repository<T> repo) {
        if (file == null) {
            System.out.println("No file selected");
            return;
        }
        try {
            CSVWriter writer = new CSVWriter(file);
            T temp;
            String[] data;
            for (int i = 0; i < repo.getSize(); i++) {
                temp = repo.getByIndex(i);
                data = temp.toString().split(",");
                String[] data2 = new String[data.length + 1];
                data2[0] = temp.getClass().getSimpleName();
                data2[1] = data[0].format("\s%s", data[0]);
                for (int j = 1; j < data.length; j++) data2[j + 1] = data[j];
                writer.writeNext(data2);
            }
            writer.close();
        } catch(IOException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
