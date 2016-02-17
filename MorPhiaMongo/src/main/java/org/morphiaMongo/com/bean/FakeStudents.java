package org.morphiaMongo.com.bean;

import java.util.ArrayList;
import java.util.List;

public class FakeStudents {

    private List<StudentsBean> students;

    public List<StudentsBean> getFakeClientBeans(int limit){
        students = new ArrayList<StudentsBean>();
        StudentsBean sb = null;
        for (int i = 0; i < limit; i++) {
            sb = new StudentsBean();
            sb.setId(i);
            sb.setCenter("Universidad_"+i);
            sb.setQualified(((i % 2)==0)?"Yes":"No");
            students.add(sb);
        }

        return students;
    }
}
