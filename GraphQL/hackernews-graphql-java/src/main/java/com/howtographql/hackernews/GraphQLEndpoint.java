package com.howtographql.hackernews;

import com.graphql.tools.SchemaParser;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;



@WebServlet(urlPatterns = "/graphql")

//public class GraphQLEndpoint extends GraphQLQueryResolver {
    //public class GraphQLEndpoint extends SimpleGraphQLHttpServlet {
public class GraphQLEndpoint extends HttpServlet {
    SimpleGraphQLHttpServlet servlet = SimpleGraphQLHttpServlet.newBuilder(schema)
            .build();
    public GraphQLEndpoint() {
        super();
        buildSchema();
    }

    private static GraphQLSchema buildSchema() {
        LinkRepository linkRepository = new LinkRepository();
        return Schema.newParser()
                //return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(linkRepository))
                .build()
                .makeExecutableSchema();
    }
}
