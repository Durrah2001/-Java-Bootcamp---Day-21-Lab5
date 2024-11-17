package org.example.projecttracker.Controller;

import org.example.projecttracker.ApiResponse.ApiResponse;
import org.example.projecttracker.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project-tracker")
public class projectController {

    ArrayList<Project> projects = new ArrayList<>();


    @PostMapping(path = "/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Project added successfully");
    }

    @GetMapping("/display")
    public ArrayList<Project> getProjects() {
        return projects;
    }


    @PutMapping(path = "/update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project) {
        projects.set(index, project);

        return new ApiResponse("Project updated successfully");

    }

    @DeleteMapping(path = "/delete/{index}")

    public ApiResponse deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("Project deleted successfully");
    }

    //End of CRUD endpoints

//    • Change the project status as done or not done


    @PutMapping(path = "/changeStatus/{status}")
    public ApiResponse changeStatus(@PathVariable String status) {

        for (Project project : projects) {

            if (project.getStatus().equalsIgnoreCase("Not Done")) {
                project.setStatus("Done");
            }

        } //End for
        return new ApiResponse("Project status changed successfully");

    }


//• Search for a project by given title


    @PutMapping(path = "/searchByTitle/{title}")
    public ApiResponse getByTitle(@PathVariable String title) {
        for (Project project : projects) {
            if (project.getTitle().equalsIgnoreCase(title)) {
                return new ApiResponse("Project found successfully");
            }

        }
        return new ApiResponse("Project with thi title not found");
    }


//• Display All project for one company by companyName.


    @GetMapping("/displayByComp/{compName}")
    public ArrayList<Project> displayByComp(@PathVariable String compName) {

        ArrayList<Project> projectsByComp = new ArrayList<>();

        for (Project project : projects) {
            if (project.getCompanyName().equalsIgnoreCase(compName)) {
                projectsByComp.add(project);
            }
        }
        return projectsByComp;
    }


} //End Controller
