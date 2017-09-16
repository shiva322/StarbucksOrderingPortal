package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import org.restlet.ext.jackson.* ;

import java.io.IOException ;
import java.util.Collection ;

public class CartResource extends ServerResource {

    @Get
    public Representation get_action (Representation rep) throws IOException {
        Order inCartOrder = StarbucksAPI.getinCartOrder() ;
        return new JacksonRepresentation<Order>(inCartOrder) ;
    }

    @Put
    public Representation put_action (Representation rep) throws IOException {

        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<Order> ( rep, Order.class ) ;
        Order updatedOrder = orderRep.getObject() ;

        Order existing_order = StarbucksAPI.updateCart(updatedOrder) ;
        api.Status api = new api.Status() ;
        api.status = "Success" ;
        api.message = "Cart Updated" ;
        return new JacksonRepresentation<api.Status>(api) ;
        }

    @Post
    public Representation post_action (Representation rep) throws IOException {

        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<Order> ( rep, Order.class ) ;
        Order updatedOrder = orderRep.getObject() ;

        Order existing_order = StarbucksAPI.updateCart(updatedOrder) ;
        api.Status api = new api.Status() ;
        api.status = "Success" ;
        api.message = "Cart Updated" ;
        return new JacksonRepresentation<api.Status>(api) ;
    }

}


