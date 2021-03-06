package JDBC;

import java.time.LocalDate;
import java.sql.Date;
import java.util.Optional;
import javax.persistence.AttributeConverter;

public class DataConverter implements AttributeConverter<LocalDate, Date> {


    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return Optional.ofNullable(localDate).map(Date::valueOf).orElse(null);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return Optional.ofNullable(date).map(Date::toLocalDate).orElse(null);
    }
}
