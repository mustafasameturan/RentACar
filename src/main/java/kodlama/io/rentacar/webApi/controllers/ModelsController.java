package kodlama.io.rentacar.webApi.controllers;

import kodlama.io.rentacar.business.abstracts.ModelService;
import kodlama.io.rentacar.business.requests.CreateModelRequest;
import kodlama.io.rentacar.business.responses.GetAllModelsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {

    private ModelService modelService;

    @Autowired
    public ModelsController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return this.modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreateModelRequest createModelRequest) {
        modelService.add(createModelRequest);
    }
}
