package solid.dip;

import java.util.ArrayList;
import java.util.List;

public class ProjectMain {
    public static void main(String[] args) {
        List<Developer> developers = new ArrayList<>();
        developers.add(new FrontEndDeveloper());
        developers.add(new BackEndDeveloper());

        Project project = new Project(developers);
        project.implement();
    }
}
