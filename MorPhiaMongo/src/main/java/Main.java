import ch.qos.logback.core.net.SyslogOutputStream;
import org.mongodb.morphia.query.Query;
import org.morphiaMongo.com.MorphiaSingleton;
import org.morphiaMongo.com.bean.FakeStudents;
import org.morphiaMongo.com.bean.StudentsBean;
import org.morphiaMongo.com.conf.ConfigurationSpring;
import org.morphiaMongo.com.conf.FactoryBeans;
import org.morphiaMongo.com.conf.IPropertiesConfiguration;

/**
 * Created by cpedrero on 16/02/16.
 */
public class Main {
    public static void main(String[] arg){
            final Query<StudentsBean> clientsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(StudentsBean.class);
            MorphiaSingleton.getInstance().getDatastore().delete(clientsQuery);
            FakeStudents fakeBeans = new FakeStudents();
            IPropertiesConfiguration configdb = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(IPropertiesConfiguration.class);
            MorphiaSingleton.getInstance().getDatastore().save(fakeBeans.getFakeClientBeans(Integer.valueOf(arg[0])));
        System.out.println("Insertados: "+arg[0]+" registros");
    }
}
