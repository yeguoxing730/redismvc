package com.springapp.mvc;

import com.springapp.config.AppConfig;
import com.springapp.service.BookAppService;
import com.springapp.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        TestService userService = (TestService) context.getBean("testService");
        System.out.println("执行删除操作：" );
        userService.deleteById(110L);
        System.out.println("第一次执行查询：");
        System.out.println(userService.queryFullNameById(110L));
        System.out.println("-----------------------------------------------------");

        System.out.println("第二次执行查询：" );
        System.out.println(userService.queryFullNameById(110L));
        System.out.println("-----------------------------------------------------");
        System.out.println("执行删除操作：" );
        userService.deleteById(110L);
        System.out.println("-----------------------------------------------------");

        System.out.println("清除缓存后再次查询：" );
        System.out.println(userService.queryFullNameById(110L));
        System.out.println("----------------------------------");

        System.out.println("做修改操作：");
        userService.modifyFullNameById(110L, "ZhangJunBao");
        System.out.println("----------------------------------");

        System.out.println("修改数据后查询：");
        System.out.println(userService.queryFullNameById(110L));
        System.out.println("----------------------------------");


        System.out.println("修改数据后第二次执行查询：");
        System.out.println(userService.queryFullNameById(110L));
        System.out.println("----------------------------------");
    }
    @Test
    public void bookTest(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        BookAppService bookApp = ctx.getBean(BookAppService.class);
        //Calling getBook method first time.
        System.out.println(bookApp.getBook().getName());
        //Calling getBook method second time.
        //This time, method will not execute because result is cached with "mycache"
        System.out.println(bookApp.getBook().getName());
        //Calling setBook method to change cache value.
        bookApp.setBook("Ramayan");
        //Calling getBook method again. Method will no execute but cache value is changed.
        System.out.println(bookApp.getBook().getName());
        ctx.close();
    }

    @Test
    public void testEntity() throws Exception {
        mockMvc.perform(post("/user/save?name='yeguoxing33'&age=32&sex=male"));
        mockMvc.perform(get("/user/getUserById?id=4"));
        mockMvc.perform(get("/user/delete?id=3"));
        mockMvc.perform(get("/user/getUserById?id=3"));
        mockMvc.perform(get("/user/getUserById?id=4"));
        mockMvc.perform(get("/user/getUserById?id=4"));
        mockMvc.perform(get("/user/getall"));
        mockMvc.perform(get("/user/renameUser?id=3&name='yeguoxingfgg'"));
    }
    @Test
    public void testhellolog() throws Exception {

        mockMvc.perform(get("/hello/hello'"));
    }
}
