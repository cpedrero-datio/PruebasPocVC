package org.morphiaMongo.com;

import org.junit.Test;
import org.mongodb.morphia.query.Query;
import org.morphiaMongo.com.bean.FakeStudents;
import org.morphiaMongo.com.bean.StudentsBean;
import org.morphiaMongo.com.conf.ConfigurationSpring;
import org.morphiaMongo.com.conf.FactoryBeans;
import org.morphiaMongo.com.conf.IPropertiesConfiguration;


public class TestMorphia {
    @Test
    public void initDB() {
        final Query<StudentsBean> clientsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(StudentsBean.class);
        MorphiaSingleton.getInstance().getDatastore().delete(clientsQuery);
        FakeStudents fakeBeans = new FakeStudents();
        IPropertiesConfiguration configdb = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(IPropertiesConfiguration.class);
        MorphiaSingleton.getInstance().getDatastore().save(fakeBeans.getFakeClientBeans(Integer.valueOf(configdb.getItem(IPropertiesConfiguration.MONGO_ITEMS))));

    }
}
