package id.co.pcsindonesia.ea.bri.authservice.app.http.controller;

import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthCreateNewRoleRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthLoginRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthRegisterRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.request.AuthSetUserRoleRequest;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthGetAllPermissionAndGetPermissionByUserResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthGetAllRoleAndGetRoleByUserResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.AuthRegisterLoginResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.http.response.GlobalResponse;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Permission;
import id.co.pcsindonesia.ea.bri.authservice.app.model.Role;
import id.co.pcsindonesia.ea.bri.authservice.app.service.PermissionService;
import id.co.pcsindonesia.ea.bri.authservice.app.service.RoleService;
import id.co.pcsindonesia.ea.bri.authservice.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Operation(summary = "Register New user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Register Successfull",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthRegisterLoginResponse.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @PostMapping("/register")
    public GlobalResponse<AuthRegisterLoginResponse> register(@RequestBody AuthRegisterRequest authRegisterRequest){
        return userService.createNewUser(authRegisterRequest);
    }

    @Operation(summary = "Login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login Successfull",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthRegisterLoginResponse.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @PostMapping("/login")
    public void login(@Valid @RequestBody AuthLoginRequest authLoginRequest){}

    @Operation(summary = "Create new Role", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role Created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Role.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @PostMapping("/roles")
    public Role createNewRole(@Valid @RequestBody AuthCreateNewRoleRequest authCreateNewRoleRequest){
        return roleService.createNewRole(authCreateNewRoleRequest);
    }

    @Operation(summary = "Get All Role", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Role Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Role.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @GetMapping("roles")
    public List<AuthGetAllRoleAndGetRoleByUserResponse> getAllRole(){
        return roleService.getAllRole();
    }

    @Operation(summary = "Get All Permission", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Permission Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Permission.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @GetMapping("permissions")
    public List<AuthGetAllPermissionAndGetPermissionByUserResponse> getAllPermission(){
        return permissionService.getAllPermission();
    }

    @Operation(summary = "Get Role by User ID", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Role Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Role.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @GetMapping("roles/by-user/{userId}")
    public List<AuthGetAllRoleAndGetRoleByUserResponse> getRoleByUser(@PathVariable("userId") Long userId){
        return userService.getRoleById(userId);
    }

    @Operation(summary = "Get Permission by User ID", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get Permission Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Role.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @GetMapping("permissions/by-user/{userId}")
    public List<AuthGetAllPermissionAndGetPermissionByUserResponse> getPermissionByUser(@PathVariable("userId") Long userId){
        return userService.getPermissionById(userId);
    }

    @Operation(summary = "Set User Roles", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Syncronize user roles",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Role.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden",
                    content = @Content) })
    @PatchMapping("users/set-roles/{userId}")
    public GlobalResponse<String> setUserRole(@PathVariable("userId") Long userId, @RequestBody AuthSetUserRoleRequest authSetUserRoleRequest){

        return userService.setUserRole(authSetUserRoleRequest, userId);
    }
}
