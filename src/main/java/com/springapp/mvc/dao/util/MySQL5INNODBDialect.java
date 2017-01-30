package com.springapp.mvc.dao.util;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQL5INNODBDialect extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB";
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }
}
