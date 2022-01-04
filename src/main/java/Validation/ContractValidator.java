package Validation;

import Contracts.*;
import Person.*;

import java.util.Arrays;

public class ContractValidator {
    String status;
    String description;
    String fields;

    public String getStatus() {return status;}

    public ContractValidator () {
        status = null;
        description = null;
        fields = null;
    }

    public void validate (Contract contract) {
        status = "OK";
        description = "";
        fields = "";
        if (contract.getStartContract().isAfter(contract.getEndContract())) {
            status = "Error";
            description = description + "Contract start date is after end date,";
            fields = fields + "startContract, endContract,";
        }
    }

    public void validate (InternetContract contract) {
        status = "OK";
        description = "";
        fields = "";
        if (contract.getStartContract().isAfter(contract.getEndContract())) {
            status = "Error";
            description = description + "Contract start date is after end date, ";
            fields = fields + "startContract, endContract, ";
        }
        if (contract.getConnectionSpeed() < 0) {
            status = "Error";
            description = description + "Too low connection speed, ";
            fields = fields + "connectionSpeed, ";
        }
    }

    public void validate (MobileContract contract) {
        status = "OK";
        description = "";
        fields = "";
        if (contract.getStartContract().isAfter(contract.getEndContract())) {
            status = "Error";
            description = description + "Contract start date is after end date, ";
            fields = fields + "startContract, endContract, ";
        }
        if (contract.getMinutes() < 0) {
            status = "Error";
            description = description + "Too low minutes, ";
            fields = fields + "minutes, ";
        }
        if (contract.getMessages() < 0) {
            status = "Error";
            description = description + "Too low messages, ";
            fields = fields + "messages, ";
        }
        if (contract.getInternet() < 0) {
            status = "Error";
            description = description + "Too low internet, ";
            fields = fields + "internet, ";
        }
    }

    public void validate(TelevisionContract contract) {
        status = "OK";
        description = "";
        fields = "";
        if (contract.getStartContract().isAfter(contract.getEndContract())) {
            status = "Error";
            description = description + "Contract start date is after end date, ";
            fields = fields + "startContract, endContract, ";
        }
        if (contract.getChannels() == null) {
            status = "Error";
            description = description + "Channels list is null, ";
            fields = fields + "channels, ";
        }
        String[] channel = {};
        if (contract.getChannels() == Arrays.stream(channel).toList()) {
            status = "Error";
            description = description + "Channels list is empty, ";
            fields = fields + "channels, ";
        }
    }

    @Override
    public String toString() {
        return "Status = " + status + "\nDescription = " + description + "\nFields = " + fields + "\n";
    }
}
