package com.aski.issue.api;



import com.aski.issue.dto.ProjectDto;
import com.aski.issue.service.ProjectService;
import com.aski.issue.service.impl.ProjectServiceImpl;
import com.aski.issue.util.ApiPaths;
import com.aski.issue.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api (value =ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@CrossOrigin
@Slf4j
public class ProjectController {

    /**
     *
     *                                      HTTP METHODLARI
     *
     *  GET           (Sunucudan Data istemek için kullanılan method) (Benzetme select)
     *  POST          (Belli bir datayı sunucuda oluşturmak için kullanılan method) (Benzetme insert)
     *  PUT           (Belli bir datayı sunucuda güncellemek için kullanılan method) (Benzetme update)
     *
     *
     */

    private  final ProjectServiceImpl projectServiceImpl;

    public ProjectController (ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    @GetMapping("/paginition")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable)  {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable) ;
        return ResponseEntity.ok(data);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = ProjectDto.class)
    public  ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project){
        return ResponseEntity.ok(projectServiceImpl.save(project));

    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
       return ResponseEntity.ok(projectServiceImpl.update(id,project));

    }

    @PutMapping("/del/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public  ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }


    }


