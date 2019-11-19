package org.biblio.p7.consumer.impl.RowMapper;

import org.biblio.p7.bean.SituationDemprunt;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SituationEmpruntRM implements RowMapper<SituationDemprunt> {
    @Override
    public SituationDemprunt mapRow(ResultSet rs, int rowNum) throws SQLException {
        SituationDemprunt situationDemprunt=new SituationDemprunt();
        situationDemprunt.setiD(rs.getInt("id"));
        situationDemprunt.setSituation(rs.getString("situation"));
        return situationDemprunt;
    }
}
