package msg.role.boundary;

import msg.permission.entity.dto.PermissionDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.SecurityContext;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
@Path("/roles")
public class RoleResource {
    @EJB
    private RoleFacade roleFacade;

    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @GET
    public Response getRoleById(@PathParam("id") long id) {

        return Response.ok(roleFacade.getRoleById(id)).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllRolesAndPermissions() {
        return Response.ok(roleFacade.getAllRolesAndPermissions()).header("Cache-Control", "no-cache").build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @POST
    public Response addPermision(@Context SecurityContext securityContext ,@PathParam("id") Long id, PermissionDTO permissionDTO) {
        return Response.ok(roleFacade.addPermission(id, permissionDTO).getPermissions()).build();
    }


    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/types")
    public Response getAllRolesType(){
        return Response.ok(roleFacade.getAllRolesType()).build();
    }

}

