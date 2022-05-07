package com.example.blog;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RequiredArgsConstructor
@AutoConfigureMockMvc
@TestPropertySource("/application-dev.properties")
@Sql(value = {"/create-user-before.sql", "/create-article-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-article-after.sql", "/create-user-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ConfigTest {

    @Autowired
    public MockMvc mockMvc;

    public static String userLogin = "test";
    public static String userPassword = "test";

}
