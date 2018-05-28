package com.example.isvirin.cleanapp.data.entity.daoconverter;

import org.greenrobot.greendao.converter.PropertyConverter;

public class AutoTypeConverter implements PropertyConverter<AutoType, String> {

    @Override
    public AutoType convertToEntityProperty(String databaseValue) {
        return AutoType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(AutoType entityProperty) {
        return entityProperty.name();
    }
}
