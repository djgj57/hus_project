package io.hus;

import io.hus.service.categoryService.CategoryService;
import io.hus.service.cityService.CityService;
import io.hus.service.featureService.FeatureService;
import io.hus.service.imageService.ImageService;
import io.hus.service.productService.ProductService;
import io.hus.service.scoreService.ScoreService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegrationProductTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    CategoryService categoriService;
    @Autowired
    CityService cityService;
    @Autowired
    FeatureService featureService;
    @Autowired
    ImageService imageService;
    @Autowired
    ProductService productService;
    @Autowired
    ScoreService scoreService;



    @Test
    public void listCategories() throws Exception {
        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/open/categories"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void listCities() throws Exception {
        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/open/cities"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    public void listProducts() throws Exception {
        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/open/products"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

}
