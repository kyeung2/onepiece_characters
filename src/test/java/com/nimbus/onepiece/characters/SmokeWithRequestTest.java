package com.nimbus.onepiece.characters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(classes = {ServiceLayerTestConfiguration.class})
@ActiveProfiles("test")
@AutoConfigureGraphQlTester
class SmokeWithRequestTest {

    @Autowired
    GraphQlTester graphQlTester;

    @Test
    void crewQuery() {

        graphQlTester
                // given
                .document("""
                        query ExampleQuery($id: ID!) {
                          crew(id: $id) {
                        	id
                        	name
                        	members {
                        	  id
                        	  name
                        	  role
                        	}
                          }
                        }
                        """)
                .variable("id", PersistenceTestData.CREW_STRAW_HATS.id())

                // when
                .execute()

                //then
                .path("crew.id")
                .entity(String.class)
                .isEqualTo(PersistenceTestData.CREW_STRAW_HATS.id().toString())
                .path("crew.name")
                .entity(String.class)
                .isEqualTo(DomainTestData.CREW_STRAW_HATS.name())
                .path("crew.members")
                .entity(List.class)
                .matches(members -> members.size() == 10);
    }

}
