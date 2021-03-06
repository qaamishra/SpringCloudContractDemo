package com.qa.contract.consumermicroservice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.qa.contract:provider-micro-service:+:stubs:8090")
//groupId:artifactId:version(+ means latest version):stubs:8090 Stub port number should be same as mentioned in provider

/*
Provider artifact , where stub is present
<groupId>com.qa.contract</groupId>
	<artifactId>provider-micro-service</artifactId>
	<version>0.0.1-SNAPSHOT</version>
 */
public class StubRunnerTest {

    @Autowired
    private MockMvc mockMvc;

  /*  @StubRunnerPort("provider-micro-service")
    int port;

    @Rule
    public StubRunnerRule rule = new StubRunnerRule()
            .downloadStub("com.qa.contract", "provider-micro-service")
            .withPort(port);

    @Autowired
    StubFinder stubFinder;*/

    @Test
    public void given_WhenPassEvenNumberInQueryParam_ThenReturnEven() throws Exception {
       /* System.out.println("==========port==========="+port+"==========port===========");
        int port = stubFinder.findStubUrl("provider-micro-service").getPort();
        System.out.println("======stubFinder======="+port+"===========stubFinder====");*/

        mockMvc.perform(MockMvcRequestBuilders.get("/check?number=2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Even number"));
    }
}
