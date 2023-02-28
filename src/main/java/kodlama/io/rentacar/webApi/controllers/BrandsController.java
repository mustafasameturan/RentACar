package kodlama.io.rentacar.webApi.controllers;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.requests.CreateBrandRequest;
import kodlama.io.rentacar.business.requests.UpdateBrandRequest;
import kodlama.io.rentacar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentacar.business.responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return this.brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest) {
        brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
