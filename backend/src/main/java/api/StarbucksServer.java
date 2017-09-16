package api ;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;
import org.restlet.service.CorsService;

import java.util.Arrays;
import java.util.HashSet;

public class StarbucksServer extends Application {

    public static void main(String[] args) throws Exception {
        Component server = new Component() ;
        server.getServers().add(Protocol.HTTP, 9090) ;

        CorsService cors=new CorsService();
        cors.setAllowedOrigins(new HashSet(Arrays.asList("*")));
        cors.setAllowedCredentials(true);


        StarbucksServer application =new StarbucksServer();
        application.getServices().add(cors);
//        server.getServices().add(cors);
        server.getDefaultHost().attach(application) ;
        server.start() ;
     //   StarbucksAPI.startOrderProcessor() ;



        //making a db connection with jongo.

//        DB db =  new MongoClient().getDB("cmpe281");
//
//        Jongo jongo = new Jongo(db);
//        MongoCollection friends = jongo.getCollection("starbucks");
//
//        MongoCursor<Order> all = friends.find().as(Order.class);
//
//
//        System.out.println("HI " + all.next().id);

//



    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext()) ;
        router.attach( "/v3/starbucks/order/{order_id}", OrderResource.class ) ;
        router.attach( "/v3/starbucks/order/{order_id}/pay", PaymentResource.class ) ;        
        router.attach( "/v3/starbucks/order", OrderResource.class ) ;        
        router.attach( "/v3/starbucks/orders", OrdersResource.class ) ;
        router.attach( "/index", index.class ) ;
        router.attach( "/v3/starbucks/cart", CartResource.class ) ;

        return router;
    }

}


/*

POST    /order
        Create a new order, and upon success, 
        receive a Location header specifying the new order’s URI.

GET     /order/{order_id}
        Request the current state of the order specified by the URI.

PUT     /order/{order_id}
        Update an order at the given URI with new information, 
        providing the full representation.

DELETE  /order/{order_id}
        Logically remove the order identified by the given URI.

POST    /order/{order_id}/pay
        Process payment for the order.

GET     /orders
        Get list of Open Orders        

*/


//      System.out.println("step 0");
//        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//
//        System.out.println("step 1");
//
//        MongoDatabase database = mongoClient.getDatabase( "test2" );
//        FindIterable<Document> find = database.getCollection("restaurants").find();
//        find.first().toJson();
//
//
//
//        System.out.println("step 2");