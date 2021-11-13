package io.hus;

import io.hus.entity.categoryEntity.Category;
import io.hus.service.categoryService.CategoryService;
import io.hus.service.cityService.CityService;
import io.hus.service.featureService.FeatureService;
import io.hus.service.imageService.ImageService;
import io.hus.service.productService.ProductService;
import io.hus.service.scoreService.ScoreService;
import io.hus.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;


import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegrationTest {

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
    @Order(1)
    public void CreateCategory() throws Exception {

        Category category1 = new Category(null, "Test Category title", "Test Category Description",
                "Test Category Image", "Test Category estate", new Date());



        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/category/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Jsons.asJsonString(category1)))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().is(201)).andReturn();
        Assertions.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

    @Test
    @Order(2)
    public void listCategories() throws Exception {

        Category category2 = new Category(null, "Test Category title", "Test Category Description",
                "Test Category Image", "Test Category estate", new Date());

        MvcResult response0 = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/category/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jsons.asJsonString(category2))).andReturn();

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/open/categories"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().is(200))
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
