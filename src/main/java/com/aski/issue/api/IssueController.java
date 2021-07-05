package com.aski.issue.api;




import com.aski.issue.dto.IssueDto;
import com.aski.issue.dto.ProjectDto;
import com.aski.issue.entity.Issue;
import com.aski.issue.service.impl.IssueServiceImpl;
import com.aski.issue.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/issue")
@Api(value = ApiPaths.IssueCtrl.CTRL, description = "Issue APIs")
@CrossOrigin

public class IssueController {

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

    private  final IssueServiceImpl issueServiceImpl;



    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issue = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issue);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Create Operation", response = IssueDto.class)
    public  ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue){
        return ResponseEntity.ok(issueServiceImpl.save(issue));

    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issue) {
       return ResponseEntity.ok(issueServiceImpl.update(id,issue));

    }

    @PutMapping("/del/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public  ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }


    }


