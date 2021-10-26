package io.hus;

import io.hus.entity.categoryEntity.Category;
import io.hus.service.categoryService.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.naming.NamingEnumeration;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegrationCategoryTest {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MockMvc mockMvc;


    public void loadDataSet() throws Exception {
        Category category1 = new Category(null,"Hogar1","hogar con personas1","http://urlfake1.com",
                "CREATED", new Date());
        categoryService.createCategory(category1);
        Category category2 = new Category(null,"Hogar2","hogar con personas2","http://urlfake2.com",
                "CREATED", new Date());
        categoryService.createCategory(category2);
        Category category3 = new Category(null,"Hogar3","hogar con personas3","http://urlfake3.com",
                "CREATED", new Date());
        categoryService.createCategory(category3);

    }

    @Test
    public void listCategories() throws Exception{
        this.loadDataSet();
        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/api/open/categories"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }

}
